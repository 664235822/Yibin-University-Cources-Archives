package Interpreter;

public class Variable extends Expression {

    private String name;

    public Variable(String name){
        this.name=name;
    }

    @Override
    public int interpret(Context ctx){
        return ctx.lookup(this);
    }

    @Override
    public String toString(){
        return name;
    }
}
