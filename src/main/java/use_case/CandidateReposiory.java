package use_case;

import common.dto.CandidateDTO;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 14:19
 */
public interface CandidateReposiory {
    CandidateDTO getCandidateById(int id);
}
