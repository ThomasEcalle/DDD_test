package infrastructure;

import model.interview.Interview;
import use_case.InterviewRepository;

/**
 * User: thomasecalle
 * Date: 21/04/2019
 * Time: 00:16
 */
public class InterviewRepositoryImpl implements InterviewRepository {
    @Override
    public void saveInterview(Interview interview) {
        // Some Logic to save interview like in DB or FileSystem, etc..
    }
}
