package use_case;

import common.dto.ConsultantRecruiterDTO;

import java.util.List;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 15:14
 */
public interface ConsultantRecruiterRepository {
    List<ConsultantRecruiterDTO> getAllConsultantsRecruiter();
}
