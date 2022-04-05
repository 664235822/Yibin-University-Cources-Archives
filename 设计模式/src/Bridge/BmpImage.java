package Bridge;

public class BmpImage extends Image {

    public void parseFile(String fileName) {
        Matrix m = new Matrix(fileName);
        imp.doPaint(m);
    }
}
