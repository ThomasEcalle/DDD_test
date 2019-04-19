package model.interview.exception;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 12:02
 */
public class NeitherHalfOrPlainHourStartException extends RuntimeException {
    public NeitherHalfOrPlainHourStartException() {
        super("model.interview.Creneau should start int half or plain hour");
    }
}
