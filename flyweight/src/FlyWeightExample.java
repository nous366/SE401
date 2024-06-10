import java.util.*;

class GraphicChar {
    char c;
    String fontFace;

    public GraphicChar(char c, String fontFace) {
        this.c = c;
        this.fontFace = fontFace;
    }

    public void printAtPosition(int x, int y) {
        System.out.printf("Printing '%c' in '%s' at position %d:%d.\n", c, fontFace, x, y);
    }
}

class GraphicCharFactory {
    HashMap<String, GraphicChar> pool = new HashMap<String, GraphicChar>(); // the Flyweights

    public int getNum() {
        return pool.size();
    }

    public GraphicChar get(Character c, String fontFace) {
        GraphicChar gc;
        String key = c.toString() + fontFace;
        if ((gc = pool.get(key)) != null) {
            return gc;
        } else {
            gc = new GraphicChar(c, fontFace);
            pool.put(key, gc);
            return gc;
        }
    }
}

class FlyWeightExample {
    public static void main(String[] args) {
        GraphicCharFactory cf = new GraphicCharFactory();

        // Compose the text by storing the characters as objects.
        ArrayList<GraphicChar> text = new ArrayList<GraphicChar>();
        text.add(cf.get('H', "Arial")); // 'H' and "Arial" are called intrinsic information
        text.add(cf.get('e', "Arial")); // because it is stored in the object itself.
        text.add(cf.get('l', "Arial"));
        text.add(cf.get('l', "Arial"));
        text.add(cf.get('o', "Times"));

        // See how the Flyweight approach is beginning to save space:
        System.out.printf("CharFactory created only %d objects for %d characters.\n", cf.getNum(), text.size());

        int x = 0, y = 0;
        for (GraphicChar c : text) { // Passing position as extrinsic information to the objects,
            c.printAtPosition(x++, y); // as a top-left 'A' is not different to a top-right one.
        }
    }
}