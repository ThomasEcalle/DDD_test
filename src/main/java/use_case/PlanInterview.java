package use_case;

import common.Technology;
import common.dto.CandidateDTO;
import common.dto.ConsultantRecruiterDTO;
import common.response.Response;
import model.interview.Interview;
import org.joda.time.DateTime;

import java.util.List;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 15:08
 */
public class PlanInterview {

    private int candidateId;
    private DateTime date;
    private int duration;
    private Technology technology;
    private CandidateReposiory candidateReposiory;
    private ConsultantRecruiterRepository consultantRecruiterRepository;
    private InterviewRepository interviewRepository;


    public PlanInterview(int candidateId,
                         DateTime date,
                         int duration,
                         Technology technology,
                         CandidateReposiory candidateReposiory,
                         ConsultantRecruiterRepository consultantRecruiterRepository,
                         InterviewRepository interviewRepository
    ) {
        this.candidateId = candidateId;
        this.date = date;
        this.duration = duration;
        this.technology = technology;
        this.candidateReposiory = candidateReposiory;
        this.consultantRecruiterRepository = consultantRecruiterRepository;
        this.interviewRepository = interviewRepository;
    }

    public Response<Interview> planInterview() {
        final CandidateDTO candidateDTO = candidateReposiory.getCandidateById(candidateId);
        final List<ConsultantRecruiterDTO> recruiters = consultantRecruiterRepository.getAllConsultantsRecruiter();
        final Response<Interview> response = new Response<>();

        Interview interview = new Interview(date, duration, technology, candidateDTO, recruiters);
        interviewRepository.saveInterview(interview);
        response.setData(interview);

        return response;
    }


}
