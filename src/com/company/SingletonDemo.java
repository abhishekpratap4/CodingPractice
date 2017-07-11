package com.company;

/**
 * Created by pratap on 5/16/17.
 *
 * NOTE: The SingletonUtil inner static class contains the instance of SingletonDemo class.
 * When SingletonDemo is loaded, SingletonUtil class is not loaded in memory.
 * When someone calls the getInstance method of SingletonDemo, SingletonUtil gets loaded in memory
 * and creates the instance of SingletonDemo class.
 *
 * If the singleton construction does something costly then this method proves to be advantageous as instance is not created unless required
 *
 * As the class initialization phase is guaranteed by the JVM to be serial, i.e., non-concurrent,
 * so no further synchronization is required in the static getInstance() method during loading and initialization.
 *
 */
public class SingletonDemo {
    private SingletonDemo() {
    }

    private static class SingletonUtil {
        private static final SingletonDemo SINGLETON_DEMO_INSTANCE = new SingletonDemo();
    }

    public static SingletonDemo getInstance() {
        return SingletonUtil.SINGLETON_DEMO_INSTANCE;
    }
}
