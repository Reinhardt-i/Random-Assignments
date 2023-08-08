
// LoggerClient class responsible for using different loggers based on the configuration
public class LoggerClient {
    private final Logger logger;

    public LoggerClient(Logger logger) {
        this.logger = logger;
    }

    public void doSomeLogging() {
        // Perform some logging operation
        String message = "Logging message...";
        logger.log(message);
    }
}