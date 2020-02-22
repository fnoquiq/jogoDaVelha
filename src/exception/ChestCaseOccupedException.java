package exception;

public class ChestCaseOccupedException extends Exception {
    private String message;

    public ChestCaseOccupedException(String message) {
        this.message = message;
    }
}
