package processors;

import com.squareup.javapoet.ClassName;
class ElementInfo {
    String tag;
    ClassName className;

    ElementInfo(String tag, ClassName className) {
        this.tag = tag;
        this.className = className;
    }
}
