package implement;

import interfaces.devicefactory;
import interfaces.laptop;
import interfaces.mobile;

public class DellFactory implements devicefactory {
    public laptop createLaptop() {
        return new dellLaptop();
    }

    public mobile createMobile() {
        return new samsungMobile();
    }
}
