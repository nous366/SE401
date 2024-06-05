public class DeepCopyExample {

    public static void main(String[] args) {
        Person person1 = new Person("John Doe", 30);
        Address address = new Address("123 Main Street", "Anytown", "CA", 91234);
        person1.setAddress(address);

        // Deep copy
        Person person2 = new Person(person1.getName(), person1.getAge());
        person2.setAddress(new Address(person1.getAddress().getStreet(), person1.getAddress().getCity(), person1.getAddress().getState(), person1.getAddress().getZipCode()));

        // Thay đổi thuộc tính của person2
        person2.setName("Jane Doe");
        person2.getAddress().setStreet("456 Elm Street");

        // In ra thông tin của cả hai object
        System.out.println("Person 1:");
        System.out.println("  Name: " + person1.getName());
        System.out.println("  Address: " + person1.getAddress().getStreet());

        System.out.println("Person 2:");
        System.out.println("  Name: " + person2.getName());
        System.out.println("  Address: " + person2.getAddress().getStreet());

        // Giải thích:
        // - person2 là bản sao sâu của person1.
        // - Thay đổi thuộc tính của person2 không ảnh hưởng đến person1 vì chúng là hai object độc lập.
    }
}

class Person {

    private String name;
    private int age;
    private Address address;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    