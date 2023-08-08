// FileLogger class responsible for logging messages to a file
public class FileLogger implements Logger {
    private String fileName;

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        // Logic to log the message to a file
        // Implementation details omitted for simplicity
    }
}
