package use_case;

import common.MasteredTechnology;
import common.Technology;
import common.dto.CandidateDTO;
import common.dto.ConsultantRecruiterDTO;
import common.dto.ProfileDTO;
import common.response.Response;
import model.interview.Interview;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 16:31
 */
class PlanInterviewTest {
    final CandidateReposiory candidateReposiory = id -> new CandidateDTO(
            new ProfileDTO(new ArrayList<MasteredTechnology>() {{
                add(new MasteredTechnology(Technology.Android, 3));
            }}, new ArrayList<Technology>() {{
                add(Technology.Javascript);
            }}));

    final ConsultantRecruiterRepository consultantRecruiterRepository = (ConsultantRecruiterRepository) () -> new ArrayList<ConsultantRecruiterDTO>() {{
        add(new ConsultantRecruiterDTO(
                new ProfileDTO(new ArrayList<MasteredTechnology>() {{
                    add(new MasteredTechnology(Technology.Android, 8));
                }}, new ArrayList<Technology>() {{
                    add(Technology.Dotnet);
                }})));
    }};

    final InterviewRepository interviewRepository = interview -> {

    };

    @Test
    void shouldCreateInterview() {
        final DateTime dateTime = new DateTime()
                .withDayOfWeek(2)
                .withYear(2019)
                .withMonthOfYear(2)
                .withHourOfDay(10)
                .withMinuteOfHour(0);

        final int candidateId = 0;
        final int duration = 2;
        final Technology technology = Technology.Android;

        final PlanInterview planInterview = new PlanInterview(candidateId,
                dateTime,
                duration,
                technology,
                candidateReposiory,
                consultantRecruiterRepository,
                interviewRepository);

        final Response<Interview> response = planInterview.planInterview();
        assertNotNull(response.getData());
    }

    @Test
    void shouldGetError() {
        final DateTime dateTime = new DateTime()
                .withDayOfWeek(2)
                .withYear(2019)
                .withMonthOfYear(2)
                .withHourOfDay(10)
                .withMinuteOfHour(24);

        final int candidateId = 0;
        final int duration = 2;
        final Technology technology = Technology.Android;

        final PlanInterview planInterview = new PlanInterview(candidateId,
                dateTime,
                duration,
                technology,
                candidateReposiory,
                consultantRecruiterRepository,
                interviewRepository);

        final Response<Interview> response = planInterview.planInterview();
        assertNotNull(response.getError());
    }
}