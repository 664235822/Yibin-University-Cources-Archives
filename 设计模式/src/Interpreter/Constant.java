package Interpreter;

public class Constant extends Expression {

    private int value;

    public Constant (int value){
        this.value=value;
    }

    @Override
    public int interpret(Context ctx){
        return value;
    }

    @Override
    public String toString(){
        return new Integer(value).toString();
    }
}
