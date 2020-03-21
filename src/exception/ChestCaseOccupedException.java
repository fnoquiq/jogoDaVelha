package exception;

public class ChestCaseOccupedException extends RuntimeException {
    private String message;

    public ChestCaseOccupedException(String message) {
        this.message = message;
    }
}
