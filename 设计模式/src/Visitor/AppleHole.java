package Visitor;

public class AppleHole implements Hole {

    private int index;

    public AppleHole (int index){
        this.index=index;
    }

    @Override
    public void accept(Farmer farmer){
        farmer.plant(this);
    }

    public int getIndex(){
        return this.index;
    }
}
