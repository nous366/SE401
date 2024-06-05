
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
