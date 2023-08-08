
public class Main {
    public static void main(String[] args) {

        // Create instances of loggers
        Logger fileLogger = new FileLogger("log.txt");
        Logger consoleLogger = new ConsoleLogger();
        Logger databaseLogger = new DatabaseLogger();

        // Single Responsibility Principle (SRP):
        // Each logger class has a single responsibility of logging messages in a specific way (file, console, or database).

        // Create LoggerClient with different loggers
        LoggerClient loggerClient1 = new LoggerClient(fileLogger);
        LoggerClient loggerClient2 = new LoggerClient(consoleLogger);
        LoggerClient loggerClient3 = new LoggerClient(databaseLogger);

        // Open/Closed Principle (OCP):
        // The LoggerClient class is open for extension to support new loggers (e.g., DatabaseLogger) without modifying existing code.

        // Perform logging using each client
        loggerClient1.doSomeLogging();
        loggerClient2.doSomeLogging();
        loggerClient3.doSomeLogging();

        // Liskov Substitution Principle (LSP):
        // The DatabaseLogger class can be substituted for the Logger interface, ensuring it behaves correctly.

        // Interface Segregation Principle (ISP):
        // The Loggable interface segregates the logging behavior, allowing classes to use specific loggers they need.

        // Use LoggableClient to set different loggers
        LoggableClient loggableClient = new LoggableClient();
        loggableClient.setLogger(fileLogger);
        loggableClient.doSomeLogging();
        loggableClient.setLogger(databaseLogger);
        loggableClient.doSomeLogging();

        // Dependency Inversion Principle (DIP):
        // The LogManager class depends on the Logger interface, allowing flexibility and easy replacement with different loggers.

        // Create LogManager and log messages
        LogManager logManager1 = new LogManager(fileLogger);
        logManager1.logMessage("This message is logged to a file.");
        LogManager logManager2 = new LogManager(consoleLogger);
        logManager2.logMessage("This message is logged to the console.");
    }
}
