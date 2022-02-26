package Visitor;

public class OrangeHole implements Hole {

    private int index;

    public OrangeHole (int index){
        this.index=index;
    }

    @Override
    public void accept(Farmer farmer){
        farmer.plant(this);
    }

    public int getIndex() {
        return this.index;
    }
}
