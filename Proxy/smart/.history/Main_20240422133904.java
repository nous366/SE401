interface Image {
    void display();
}
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class SmartReferenceProxy implements Image {
    private Image image;
    private int accessCount = 0;

    public SmartReferenceProxy(Image image) {
        this.image = image;
    }

    @Override
    public void display() {
        accessCount++;
        System.out.println("Image display count: " + accessCount);
        image.display();
    }
}
public class Main {
    public static void main(String[] args) {
        Image image = new SmartReferenceProxy(new RealImage("test_image.jpg"));
        image.display();
        image.display();
        image.display();
    }
}
