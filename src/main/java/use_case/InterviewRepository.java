package use_case;

import model.interview.Interview;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 14:15
 */
public interface InterviewRepository {
    void saveInterview(Interview interview);
}
