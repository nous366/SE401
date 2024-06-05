// Interface Expression định nghĩa phương thức interpret
public interface Expression {
    void interpret(Context context);
}

// Lớp Context chứa thông tin về lệnh đầu vào và chuỗi đầu ra sau khi giải thích
public class Context {
    private String input;
    private String output;

    public Context(String input) {
        this.input = input;
        this.output = "";
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}

// Lớp MoveExpression cho phép di chuyển
public class MoveExpression implements Expression {
    private int steps;

    public MoveExpression(int steps) {
        this.steps = steps;
    }

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "Move " + steps + " steps.\n");
    }
}

// Lớp TurnLeftExpression cho phép quay trái
public class TurnLeftExpression implements Expression {
    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "Turn left.\n");
    }
}

// Lớp TurnRightExpression cho phép quay phải
public class TurnRightExpression implements Expression {
    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "Turn right.\n");
    }
}

// Lớp chính để chạy ứng dụng
public class RobotControlInterpreter {
    public static void main(String[] args) {
        String instructions = "MOVE 3\nTURN LEFT\nMOVE 1\nTURN RIGHT";
        Context context = new Context(instructions);

        String[] commands = context.getInput().split("\n");
        for (String command : commands) {
            Expression expr = null;
            if (command.startsWith("MOVE")) {
                int steps = Integer.parseInt(command.split(" ")[1]);
                expr = new MoveExpression(steps);
            } else if (command.equals("TURN LEFT")) {
                expr = new TurnLeftExpression();
            } else if (command.equals("TURN RIGHT")) {
                expr = new TurnRightExpression();
            }

            if (expr != null) {
                expr.interpret(context);
            }
        }

        System.out.println(context.getOutput());
    }
}
