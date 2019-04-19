package use_case;

import common.MasteredTechnology;
import common.Technology;
import common.dto.AddressDTO;
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
    final CandidateReposiory candidateReposiory = id -> new CandidateDTO(new AddressDTO("test", 92300, "Levallois"),
            new ProfileDTO(new ArrayList<MasteredTechnology>() {{
                add(new MasteredTechnology(Technology.Android, 3));
            }}, new ArrayList<Technology>() {{
                add(Technology.Javascript);
            }}));
    ;
    final ConsultantRecruiterRepository consultantRecruiterRepository = (ConsultantRecruiterRepository) () -> new ArrayList<ConsultantRecruiterDTO>() {{
        add(new ConsultantRecruiterDTO(new AddressDTO("test", 45300, "Paris"),
                new ProfileDTO(new ArrayList<MasteredTechnology>() {{
                    add(new MasteredTechnology(Technology.Android, 8));
                }}, new ArrayList<Technology>() {{
                    add(Technology.Dotnet);
                }})));
    }};

    @Test
    void shouldCreateInterview() {
        final DateTime dateTime = new DateTime()
                .withDayOfWeek(2)
                .withYear(2019)
                .withMonthOfYear(2)
                .withHourOfDay(10)
                .withMinuteOfHour(30);

        final int candidateId = 0;
        final int duration = 2;
        final Technology technology = Technology.Android;

        final PlanInterview planInterview = new PlanInterview(candidateId,
                dateTime,
                duration,
                technology,
                candidateReposiory,
                consultantRecruiterRepository);

        final Response<Interview> response = planInterview.planInterview();
        assertNotNull(response.getData());
    }
}