package Interpreter;

public class InterpreterTest {

    public static void main(String[] args) {
        // write your code here

        //(a-b)*(c+5)
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Constant constant = new Constant(5);

        Expression left = new Sub(a, b);
        Expression right = new Add(c, constant);
        Expression expression = new Muti(left, right);

        System.out.println(expression.toString());

        Context context = new Context();
        context.assign(a, 23);
        context.assign(b, 12);
        context.assign(c, 5);

        System.out.println("a=" + a.interpret(context));
        System.out.println("b=" + b.interpret(context));
        System.out.println("c=" + c.interpret(context));
        System.out.println(expression.interpret(context));
    }
}
