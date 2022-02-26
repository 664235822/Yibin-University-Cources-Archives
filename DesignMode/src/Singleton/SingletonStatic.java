package Singleton;

// 单例模式饿汉模式
public class SingletonStatic {

    private SingletonStatic() {

    }

    private static class SingletonHolder {

        private static SingletonStatic instance = new SingletonStatic();
    }

    public static SingletonStatic getInstance() {
        return SingletonHolder.instance;
    }
}
