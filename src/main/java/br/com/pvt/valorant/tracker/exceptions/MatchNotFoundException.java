package br.com.pvt.valorant.tracker.exceptions;

public class MatchNotFoundException extends RuntimeException {

    // Default constructor
    public MatchNotFoundException() {
        super("Match not found.");
    }

    // Constructor to pass custom message
    public MatchNotFoundException(String message) {
        super(message);
    }

    // Constructor to pass custom message and cause
    public MatchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
