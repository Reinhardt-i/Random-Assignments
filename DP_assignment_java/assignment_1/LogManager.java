// Class that depends on abstractions (Logger) rather than concrete implementations
public class LogManager {
    private Logger logger;

    public LogManager(Logger logger) {
        this.logger = logger;
    }

    public void logMessage(String message) {
        logger.log(message);
    }
}