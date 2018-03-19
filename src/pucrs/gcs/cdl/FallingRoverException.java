package pucrs.gcs.cdl;

public class FallingRoverException extends Throwable {
    public FallingRoverException() {
        this("O rover caiu!");
    }

    public FallingRoverException(String message) {
        super(message);
    }
}
