public class ShallowCopy {

    public static void main(String[] args) {
        Person person1 = new Person("John Doe", 30);
        Address address = new Address("123 Main Street", "Anytown", "CA", 91234);
        person1.setAddress(address);

        // Shallow copy
        Person person2 = person1;

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
        // - person2 chỉ là bản sao nông của person1.
        // - Khi thay đổi thuộc tính của person2, nó cũng ảnh hưởng đến person1 vì cả hai đều trỏ đến cùng một object "address".
    }
}

class Person {

    private String name;
    private Address address;

    public Person(String name, int age) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {

    private String street;
    private String city;
    private String state;
    private int zipCode;

    public Address(String street, String city, String state, int zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // ... getters and setters for other fields
}