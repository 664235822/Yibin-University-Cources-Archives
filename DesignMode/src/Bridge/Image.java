package Bridge;

public abstract class Image {

    protected Implementor imp;

    public void setImp(Implementor imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}
