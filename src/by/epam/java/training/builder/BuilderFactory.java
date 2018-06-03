package by.epam.java.training.builder;

import by.epam.java.training.builder.impl.NodeBuilderImpl;
import by.epam.java.training.printer.LogPrinter;
import org.apache.log4j.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuilderFactory {
    private static final Logger LOGGER = Logger.getLogger(BuilderFactory.class);

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
        } catch (Exception ex) {
            LogPrinter.printLogError(ex.getMessage(), LOGGER);
        } finally {
            lock.unlock();
        }
        return instance;
    }


}
