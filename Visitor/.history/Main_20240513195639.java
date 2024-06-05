// Interface for Computer Parts
interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}


class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

// Visitor Interface
interface ComputerPartVisitor {
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Mouse mouse);
}

// Concrete Visitors
class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }
}

class ComputerPartConnectVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Connecting Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Connecting Monitor.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Connecting Mouse.");
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        ComputerPart[] parts = {new Keyboard(), new Monitor(), new Mouse()};
        ComputerPartVisitor displayVisitor = new ComputerPartDisplayVisitor();
        ComputerPartVisitor connectVisitor = new ComputerPartConnectVisitor();

        for (ComputerPart part : parts) {
            part.accept(displayVisitor);
            part.accept(connectVisitor);
        }
    }
}
