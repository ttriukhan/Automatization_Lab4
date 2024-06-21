package processors;

import annotations.GenerateClass;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedAnnotationTypes("annotations.GenerateClass")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GenerateClassProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateClass.class)) {
            GenerateClass generateClass = element.getAnnotation(GenerateClass.class);
            String className = generateClass.className();
            String[] fields = generateClass.fields();

            try {
                generateClassFile(className, fields);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private void generateClassFile(String className, String[] fields) throws IOException {
        String packageName = "generated";
        String qualifiedClassName = packageName + "." + className;

        JavaFileObject file = processingEnv.getFiler().createSourceFile(qualifiedClassName);

        try (Writer writer = file.openWriter()) {
            writer.write("package " + packageName + ";\n\n");
            writer.write("public class " + className + " {\n");
            for (String field : fields) {
                writer.write("    private String " + field + ";\n");
                writer.write("    public String get" + capitalize(field) + "() { return " + field + "; }\n");
                writer.write("    public void set" + capitalize(field) + "(String " + field + ") { this." + field + " = " + field + "; }\n");
            }
            writer.write("}\n");
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
