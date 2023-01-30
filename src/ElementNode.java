import java.util.ArrayList;
import java.util.HashMap;

public class ElementNode implements Node{
    String tag;
    ArrayList<Node> contents;

    public ElementNode(String tag) {
        this.tag = tag;
        contents = new ArrayList<>();
    }

    public void append(String text) {
        contents.add(new TextNode(text));
    }

    public void append(ElementNode node) {
        contents.add(node);
    }

    @Override
    public String freeze() {
        String frozenString = String.format("<%s>", tag);

        for (Node child : contents) {
            frozenString += child.freeze();
        }

        frozenString += String.format("</%s>", tag);

        return frozenString;
    }
}
