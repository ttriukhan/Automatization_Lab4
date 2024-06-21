package processors;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class FactoryBuilder {
    private Filer filer;
    private Map<ClassName, List<ElementInfo>> input;

    FactoryBuilder(Filer filer, Map<ClassName, List<ElementInfo>> input) {
        this.filer = filer;
        this.input = input;
    }

    void generate() throws IOException {
        for (ClassName key : input.keySet()) {
            String simpleName = key.simpleName().substring(1);
            MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("create" + simpleName)
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .addParameter(String.class, "type")
                    .beginControlFlow("switch(type)");
            for (ElementInfo elementInfo : input.get(key)) {
                methodBuilder
                        .addStatement("case $S: return new $T()", elementInfo.tag, elementInfo.className);
            }

            methodBuilder
                    .endControlFlow()
                    .addStatement("throw new RuntimeException(\"not support type\")")
                    .returns(key);
            MethodSpec methodSpec = methodBuilder.build();
            TypeSpec helloWorld = TypeSpec.classBuilder(simpleName + "Factory")
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addMethod(methodSpec)
                    .build();
            JavaFile javaFile = JavaFile.builder(key.packageName(), helloWorld)
                    .build();

            javaFile.writeTo(filer);
        }
    }
}
