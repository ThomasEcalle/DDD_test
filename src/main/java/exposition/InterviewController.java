package exposition;

import common.Technology;
import common.response.Response;
import model.interview.Interview;
import org.joda.time.DateTime;
import use_case.CandidateReposiory;
import use_case.ConsultantRecruiterRepository;
import use_case.InterviewRepository;
import use_case.PlanInterview;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 14:15
 */
public class InterviewController {

    private CandidateReposiory candidateReposiory;
    private ConsultantRecruiterRepository consultantRecruiterRepository;
    private InterviewRepository interviewRepository;

    public InterviewController(CandidateReposiory candidateReposiory,
                               ConsultantRecruiterRepository consultantRecruiterRepository,
                               InterviewRepository interviewRepository) {
        this.candidateReposiory = candidateReposiory;
        this.consultantRecruiterRepository = consultantRecruiterRepository;
        this.interviewRepository = interviewRepository;
    }

    public void planInterview(int idCandidate, DateTime dateTime, int duration, Technology technology) {
        final PlanInterview planInterview = new PlanInterview(idCandidate, dateTime, duration, technology, candidateReposiory, consultantRecruiterRepository, interviewRepository);
        final Response<Interview> response = planInterview.planInterview();

        if (response.getError() != null) {
            // Show Error in IHM
        } else {
            // Show response.data in IHM
        }
    }
}
