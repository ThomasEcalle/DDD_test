package model.interview.exception;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 12:02
 */
public class InterviewIdBadFormatException extends RuntimeException {
    public InterviewIdBadFormatException() {
        super("Interview Id incorrect");
    }
}
