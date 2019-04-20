package model.interview;

import common.MasteredTechnology;
import common.Technology;
import common.dto.CandidateDTO;
import common.dto.ConsultantRecruiterDTO;
import common.dto.ProfileDTO;
import model.interview.exception.NeitherHalfOrPlainHourStartException;
import model.interview.exception.NoRecruiterAvailableException;
import model.interview.exception.NotInWorkingHoursException;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 21:18
 */
class InterviewTest {

    final DateTime dateTime = new DateTime()
            .withDayOfWeek(2)
            .withYear(2019)
            .withMonthOfYear(2)
            .withHourOfDay(10)
            .withMinuteOfHour(0);

    final CandidateDTO candidateDTO = new CandidateDTO(
            new ProfileDTO(new ArrayList<MasteredTechnology>() {{
                add(new MasteredTechnology(Technology.Android, 3));
            }}, new ArrayList<Technology>() {{
                add(Technology.Javascript);
            }}));

    final List<ConsultantRecruiterDTO> recruiters = new ArrayList<ConsultantRecruiterDTO>() {{
        add(new ConsultantRecruiterDTO(
                new ProfileDTO(new ArrayList<MasteredTechnology>() {{
                    add(new MasteredTechnology(Technology.Android, 8));
                }}, new ArrayList<Technology>() {{
                    add(Technology.Dotnet);
                }})));
    }};


    @Test
    void shouldTwoInterviewsNotBeEquals() {
        final Interview interview1 = new Interview(dateTime,
                2,
                Technology.Android,
                candidateDTO,
                recruiters);

        final Interview interview2 = new Interview(dateTime,
                2,
                Technology.Android,
                candidateDTO,
                recruiters);
        assertNotEquals(interview1, interview2);
    }

    @Test
    void shouldThrowExceptionWhenNotGoodStartingHour() {
        final DateTime dateTime = new DateTime()
                .withDayOfWeek(2)
                .withYear(2019)
                .withMonthOfYear(2)
                .withHourOfDay(10)
                .withMinuteOfHour(22);

        Assertions.assertThrows(NeitherHalfOrPlainHourStartException.class, () -> {
            new Interview(dateTime,
                    2,
                    Technology.Android,
                    candidateDTO,
                    recruiters);
        });
    }

    @Test
    void shouldThrowExceptionWhenNotInWorkingHours() {
        final DateTime dateTime = new DateTime()
                .withDayOfWeek(2)
                .withYear(2019)
                .withMonthOfYear(2)
                .withHourOfDay(22)
                .withMinuteOfHour(0);

        Assertions.assertThrows(NotInWorkingHoursException.class, () -> {
            new Interview(dateTime,
                    2,
                    Technology.Android,
                    candidateDTO,
                    recruiters);
        });
    }

    @Test
    void shouldThrowExceptionWhenNoRecruiterAvailable() {

        Assertions.assertThrows(NoRecruiterAvailableException.class, () -> {
            new Interview(dateTime,
                    2,
                    Technology.Android,
                    candidateDTO,
                    new ArrayList<>());
        });
    }

}