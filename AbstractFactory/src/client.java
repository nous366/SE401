import implement.DellFactory;
import implement.appleFactory;
import interfaces.devicefactory;
import interfaces.laptop;
import interfaces.mobile;

public class client {
    public static void main(String[] args) {

        devicefactory appleFactory = new appleFactory();
        laptop appleLaptop = appleFactory.createLaptop();
        mobile appleMobile = appleFactory.createMobile();

        appleLaptop.create();
        appleMobile.create();

        devicefactory dellFactory = new DellFactory();
        laptop dellLaptop = dellFactory.createLaptop();
        mobile samsungMobile = dellFactory.createMobile();

        dellLaptop.create();
        samsungMobile.create();
    }
}
