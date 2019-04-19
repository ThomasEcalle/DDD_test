package model.interview.exception;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 12:02
 */
public class NotInWorkingHoursException extends RuntimeException {
    public NotInWorkingHoursException() {
        super("model.interview.Creneau should be in working hours");
    }
}
