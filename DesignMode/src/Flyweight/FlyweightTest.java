package Flyweight;

import java.util.ArrayList;
import java.util.List;

public class FlyweightTest {

    public static void main(String[] args) {
        // write your code here

        FlyweightFactory factory=new FlyweightFactory();
        Character state='a';

        Flyweight shareFly1=factory.getFlyweight(state);
        Flyweight shareFly2=factory.getFlyweight(state);
        System.out.println(shareFly1.hashCode());
        System.out.println(shareFly2.hashCode());
        System.out.println(("内部状态是共享的"));

        List<Character> stateList=new ArrayList<Character>();
        stateList.add('a');
        stateList.add('b');
        stateList.add('c');
        stateList.add('c');
        Flyweight fly1=factory.getFlyweight(stateList);
        Flyweight fly2=factory.getFlyweight(stateList);
        fly1.operation("外部场景");
        System.out.println(fly1.hashCode());
        System.out.println(fly2.hashCode());
    }
}
