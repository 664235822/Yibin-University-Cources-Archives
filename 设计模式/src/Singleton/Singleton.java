package Singleton;

// 单例模式懒汉模式
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {

    }

    // 关键字 synchronized 修复多线程
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
