
public class Main {

    
    public interface Strategy {
        int doOperation(int num1, int num2);
    }

    
    public static class OperationAdd implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 + num2;
        }
    }

    
    public static class OperationSubtract implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 - num2;
        }
    }

  
    public static class Context {
        private Strategy strategy;
        
        public Context(Strategy strategy){
            this.strategy = strategy;
        }

        // Execute the strategy
        public int executeStrategy(int num1, int num2){
            return strategy.doOperation(num1, num2);
        }
    }

    // Main method to run the demo
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());  
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());  
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
    }
}
