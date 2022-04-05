package Visitor;

import java.util.Iterator;

public class VisitorTest {

    public static void main(String[] args) {
        // write your code here

        Orchard orchard=new Orchard();

        Hole h1=new AppleHole(1);
        Hole h2=new AppleHole(2);
        Hole h3=new AppleHole(3);
        Hole h4=new OrangeHole(4);
        Hole h5=new OrangeHole(5);

        orchard.add(h1);
        orchard.add(h2);
        orchard.add(h3);
        orchard.add(h4);
        orchard.add(h5);

        Farmer farmer=new TreeFarmer();

        Iterator<Hole> iterator=orchard.getIterator();
        while(iterator.hasNext()){
            iterator.next().accept(farmer);
        }
    }
}