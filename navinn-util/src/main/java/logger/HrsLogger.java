package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

public class HrsLogger extends ExtendedLoggerWrapper {

    private final ExtendedLoggerWrapper logger=this;
    public HrsLogger(ExtendedLogger logger, String name, MessageFactory messageFactory) {
        super(logger, name, messageFactory);
    }

    private HrsLogger(Logger logger){
        super((AbstractLogger)logger,logger.getName(),((AbstractLogger) logger).getMessageFactory());
    }

    public static HrsLogger create(){
        Logger wrapped= LogManager.getLogger();
        return new HrsLogger(wrapped);
    }

    public static HrsLogger create(Class<?> loggerName){
        Logger wrapped= LogManager.getLogger(loggerName);
        return new HrsLogger(wrapped);
    }

    public static HrsLogger create(String name){
        Logger wrapped= LogManager.getLogger(name);
        return new HrsLogger(wrapped);
    }
}
