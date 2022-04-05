package Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Orchard {

    private List<Hole> holes=new ArrayList<>();

    public void add(Hole hole){
        holes.add(hole);
    }

    public Iterator<Hole> getIterator(){
        return holes.iterator();
    }
}
