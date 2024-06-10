package implement;

import interfaces.devicefactory;
import interfaces.laptop;
import interfaces.mobile;

public class appleFactory implements devicefactory {
    public laptop createLaptop() {
        return new appleLaptop();
    }

    public mobile createMobile() {
        return new appleMobile();
    }
}
