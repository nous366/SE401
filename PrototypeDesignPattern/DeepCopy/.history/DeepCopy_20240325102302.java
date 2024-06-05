public class DeepCopy {

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

public class Person {

    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
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

    public Person deepCopy() {
        Person copy = new Person(this.name, this.address.deepCopy());
        return copy;
    }
}

public class Address {

    private String street;
    private City city;

    public Address(String street, City city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Address deepCopy() {
        return new Address(this.street, this.city.deepCopy());
    }
}

public class City {

    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City deepCopy() {
        return new City(this.name);
    }
}
