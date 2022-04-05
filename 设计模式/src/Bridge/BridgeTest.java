package Bridge;

public class BridgeTest {
    public static void main(String[] args) {
        // write your code here

        Image image=new GifImage();
        Implementor implementor=new LinuxImp();

        image.setImp(implementor);
        image.parseFile("demo.gif");
    }
}
