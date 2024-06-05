interface Expression {
    void interpret(Context context);
}


class Context {
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


class MoveExpression implements Expression {
    private int steps;

    public MoveExpression(int steps) {
        this.steps = steps;
    }

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "Move " + steps + " steps.\n");
    }
}


class TurnLeftExpression implements Expression {
    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "Turn left.\n");
    }
}


class TurnRightExpression implements Expression {
    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "Turn right.\n");
    }
}

// Lớp chính để chạy ứng dụng
public class Main {
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
