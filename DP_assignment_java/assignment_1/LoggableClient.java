// Class that implements the Loggable interface to utilize different loggers
class LoggableClient implements Loggable {
    private Logger logger;

    @Override
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    // ... Other methods of the class that utilize the logger
}