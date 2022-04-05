package Flyweight;

public class ConcreteFlyweight implements Flyweight {

    private Character intrinsicState = null;

    public ConcreteFlyweight(Character state) {
        this.intrinsicState = state;
    }

    @Override
    public void operation(String state) {
        System.out.println("内部状态：" + this.intrinsicState);
        System.out.println("外部场景：" + state);
    }
}
