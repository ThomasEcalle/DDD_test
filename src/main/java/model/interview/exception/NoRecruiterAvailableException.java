package model.interview.exception;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 12:02
 */
public class NoRecruiterAvailableException extends RuntimeException {
    public NoRecruiterAvailableException() {
        super("No recruiter available");
    }
}
