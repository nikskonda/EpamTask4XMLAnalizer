package by.epam.java.training.servise.impl.builder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuilderFactory {

    private static BuilderFactory instance = new BuilderFactory();
    private static Lock lock = new ReentrantLock();

    private final NodeBuilder nodeBuilder = new NodeBuilderImpl();

    private BuilderFactory() {}

    public NodeBuilder getNodeBuilder() {
        return nodeBuilder;
    }

    public static BuilderFactory getInstance() {
        try {
            lock.lock();
            if (instance == null){
                instance = new BuilderFactory();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
        return instance;
    }


}
