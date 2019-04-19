package model.interview;

import model.interview.exception.NeitherHalfOrPlainHourStartException;
import model.interview.exception.NotInWorkingHoursException;
import org.joda.time.DateTime;

import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 11:31
 */
class Creneau {
    final DateTime date;
    final int startHour;
    final int endHour;

    Creneau(DateTime date, int durationInHours) {
        this.date = date;
        this.startHour = date.getHourOfDay();
        this.endHour = date.getHourOfDay() + durationInHours;

        if (date.getMinuteOfHour() != 30 && date.getMinuteOfHour() != 0) {
            throw new NeitherHalfOrPlainHourStartException();
        }

        if (startHour <= 8 || endHour >= 17) {
            throw new NotInWorkingHoursException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creneau creneau = (Creneau) o;
        return startHour == creneau.startHour &&
                endHour == creneau.endHour &&
                Objects.equals(date, creneau.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, startHour, endHour);
    }
}
