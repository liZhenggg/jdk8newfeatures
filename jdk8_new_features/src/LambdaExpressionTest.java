/**
 * Lambda表达式用法
 */
public class LambdaExpressionTest {

    static String salutation = "你好，";

    public static void main(String[] args) {
        LambdaExpressionTest lambdaTest = new LambdaExpressionTest();

        //类声明
        MathOperation addition = (int a, int b) -> a + b;

        //不用类声明
        MathOperation subtraction = (a, b) -> a - b;

        //大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        //没有大括号及返回语句
        MathOperation division = (a, b) -> a / b;


        System.out.println("10 + 5 = " + lambdaTest.operator(10, 5, addition));
        System.out.println("10 - 5 = " + lambdaTest.operator(10, 5, subtraction));
        System.out.println("10 * 5 = " + lambdaTest.operator(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambdaTest.operator(10, 5, division));

        //不用括号
        GreetingService greetingService1 = message -> System.out.println("Hello " + message);
        //用括号
        GreetingService greetingService2 = (message) -> System.out.println("Hi " + message);

        greetingService1.sayMessage("Jack");
        greetingService2.sayMessage("Mose");

        GreetingService greetingService3 = (message) -> {
            System.out.println(salutation + message);
        };
        greetingService3.sayMessage("Mary");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operator(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


}
