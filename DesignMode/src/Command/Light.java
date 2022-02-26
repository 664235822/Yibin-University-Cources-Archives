package Command;

public class Light {

    private String name;

    public Light() {
    }

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + "：灯开了");
    }

    public void off() {
        System.out.println(name + "：灯关了");
    }
}
