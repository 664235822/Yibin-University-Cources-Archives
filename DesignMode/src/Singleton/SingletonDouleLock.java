package Singleton;

//单例模式实现双层锁的懒汉模式
public class SingletonDouleLock {

    //关键字 volatile 不会生成本地缓存，操作共享内存
    private volatile static SingletonDouleLock instance = null;

    private SingletonDouleLock() {

    }

    public static SingletonDouleLock getInstance() {
        if(instance == null) {
            if (instance == null) {
                instance = new SingletonDouleLock();
            }
        }

        return instance;
    }
}
