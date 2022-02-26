package Interpreter;

public class Add extends Expression {

    private Expression left, right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context ctx) {
        return (left.interpret(ctx) + right.interpret(ctx));
    }

    @Override
    public String toString() {
        return "(" + left.toString() + "+" + right.toString() + ")";
    }
}
