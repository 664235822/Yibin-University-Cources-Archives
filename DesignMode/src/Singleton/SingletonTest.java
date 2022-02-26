package Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        // write your code here

        // 单例模式懒汉模式
        System.out.println("单例模式懒汉模式");
        Singleton s1 = Singleton.getInstance();
        System.out.println(s1.hashCode());
        Singleton s2 = Singleton.getInstance();
        System.out.println(s2.hashCode());

        // 单例模式双层锁懒汉模式
        System.out.println("单例模式双层锁懒汉模式");
        SingletonDouleLock sd1 = SingletonDouleLock.getInstance();
        System.out.println(sd1.hashCode());
        SingletonDouleLock sd2 = SingletonDouleLock.getInstance();
        System.out.println(sd2.hashCode());

        // 单例模式饿汉模式
        System.out.println("单例模式饿汉模式");
        SingletonStatic ss1 = SingletonStatic.getInstance();
        System.out.println(ss1.hashCode());
        SingletonStatic ss2 = SingletonStatic.getInstance();
        System.out.println(ss2.hashCode());
    }
}
