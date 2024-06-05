public class Main {

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Car");
        Vehicle vehicle2 = vehicle1.clone(); 

        vehicle2.setType("Motorcycle"); 

        System.out.println(vehicle1); // In ra: Vehicle [Type=Car]
        System.out.println(vehicle2); // In ra: Vehicle [Type=Motorcycle]
    }

    public interface Prototype {
        Prototype clone();
    }

    public static class Vehicle implements Prototype {
        private String type;

        public Vehicle(String type) {
            this.type = type;
        }

        // Getter và Setter cho type
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public Vehicle clone() {
            return new Vehicle(this.type);
        }

        @Override
        public String toString() {
            return "Vehicle [Type=" + type + "]";
        }
    }
}
