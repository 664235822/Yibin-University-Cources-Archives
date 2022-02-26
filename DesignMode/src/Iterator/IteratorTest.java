package Iterator;

public class IteratorTest {

    public static void main(String[] args) {
        // write your code here

        ConcreteAggregate a=new ConcreteAggregate();

        a.add(0,"赵");
        a.add(1,"钱");
        a.add(2,"孙");
        a.add(3,"李");
        a.add(4,"周");
        a.add(5,"吴");
        a.add(6,"郑");
        a.add(7,"王");

        Iterator aIterator=new ContreteIterator(a);
        while(!aIterator.isDone()){
            System.out.println(aIterator.CurrentItem());
            aIterator.next();
        }
    }
}