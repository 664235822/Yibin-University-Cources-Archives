package Visitor;

public class TreeFarmer extends Farmer {

    @Override
    public void plant(AppleHole hole){
        System.out.println("树农向"+hole.getIndex()+"号坑种下一颗苹果树");
    }

    @Override
    public void plant(OrangeHole hole){
        System.out.println("树农向"+hole.getIndex()+"号坑种下一颗橘子树");
    }
}
