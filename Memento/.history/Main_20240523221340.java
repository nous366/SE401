import java.util.ArrayList;
import java.util.List;

// Lớp Memento lưu trữ trạng thái của TextEditor
class TextMemento {
    private String content;

    public TextMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}


class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
        System.out.println("Content set to: " + content);
    }

    public String getContent() {
        return content;
    }

    public TextMemento saveContentToMemento() {
        return new TextMemento(content);
    }

    public void restoreContentFromMemento(TextMemento memento) {
        content = memento.getContent();
    }
}


class TextEditorHistory {
    private List<TextMemento> mementoList = new ArrayList<>();

    public void addMemento(TextMemento memento) {
        mementoList.add(memento);
    }

    public TextMemento getMemento(int index) {
        return mementoList.get(index);
    }
}


public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        textEditor.setContent("Version 1");
        history.addMemento(textEditor.saveContentToMemento());

        textEditor.setContent("Version 2");
        history.addMemento(textEditor.saveContentToMemento());

        textEditor.setContent("Version 3");
        System.out.println("Current Content: " + textEditor.getContent());

        textEditor.restoreContentFromMemento(history.getMemento(0));
        System.out.println("Restored to: " + textEditor.getContent());

        textEditor.restoreContentFromMemento(history.getMemento(1));
        System.out.println("Restored to: " + textEditor.getContent());
    }
}
