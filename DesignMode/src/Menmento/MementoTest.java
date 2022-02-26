package Menmento;

public class MementoTest {

    public static void main(String[] args) {
        // write your code here

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker(originator);

        originator.setState("状态0");
        caretaker.createMemento();
        originator.toString();

        originator.setState("状态1");
        caretaker.createMemento();
        originator.toString();

        originator.setState("状态2");
        caretaker.createMemento();
        originator.toString();

        System.out.println("--------------恢复--------------");
        caretaker.restoreMemeto(1);
        originator.toString();
    }
}
