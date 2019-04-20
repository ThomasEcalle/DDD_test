package model.interview;

import model.interview.exception.InterviewIdBadFormatException;

import java.util.Objects;
import java.util.UUID;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 14:18
 */
class InterviewId {
    private final String value;

    InterviewId(String value) {
        if (value == null) {
            throw new InterviewIdBadFormatException();
        }
        this.value = value;
    }

    static InterviewId generateInterviewId() {
        return new InterviewId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewId that = (InterviewId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}

