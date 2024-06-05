import java.util.ArrayList;
import java.util.List;

// Lớp Memento lưu trữ trạng thái của giao diện
class ColorMemento {
    private String color;

    public ColorMemento(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

// Lớp Originator có trạng thái cần được lưu trữ và khôi phục
class Interface {
    private String color;

    public void setColor(String color) {
        this.color = color;
        System.out.println("Interface color set to: " + color);
    }

    public String getColor() {
        return color;
    }

    public ColorMemento saveColorToMemento() {
        return new ColorMemento(color);
    }

    public void restoreColorFromMemento(ColorMemento memento) {
        color = memento.getColor();
    }
}

// Lớp Caretaker quản lý các đối tượng Memento
class InterfaceHistory {
    private List<ColorMemento> mementoList = new ArrayList<>();
    private int currentIndex = -1;

    public void addMemento(ColorMemento memento) {
        if (currentIndex != mementoList.size() - 1) {
            mementoList = mementoList.subList(0, currentIndex + 1);
        }
        mementoList.add(memento);
        currentIndex++;
    }

    public ColorMemento undo() {
        if (currentIndex > 0) {
            currentIndex--;
            return mementoList.get(currentIndex);
        }
        return null;
    }

    public ColorMemento redo() {
        if (currentIndex < mementoList.size() - 1) {
            currentIndex++;
            return mementoList.get(currentIndex);
        }
        return null;
    }
}

// Lớp chính để kiểm tra ứng dụng quản lý đổi màu giao diện
public class main {
    public static void main(String[] args) {
        Interface userInterface = new Interface();
        InterfaceHistory history = new InterfaceHistory();

        userInterface.setColor("Red");
        history.addMemento(userInterface.saveColorToMemento());

        userInterface.setColor("Blue");
        history.addMemento(userInterface.saveColorToMemento());

        userInterface.setColor("Green");
        history.addMemento(userInterface.saveColorToMemento());

        System.out.println("Current Color: " + userInterface.getColor());

        userInterface.restoreColorFromMemento(history.undo());
        System.out.println("Undo to: " + userInterface.getColor());

        userInterface.restoreColorFromMemento(history.undo());
        System.out.println("Undo to: " + userInterface.getColor());

        userInterface.restoreColorFromMemento(history.redo());
        System.out.println("Redo to: " + userInterface.getColor());
    }
}
