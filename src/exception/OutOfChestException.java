package exception;

public class OutOfChestException extends RuntimeException {
    private String message;

    public OutOfChestException(String message) {
        this.message = message;
    }
}
