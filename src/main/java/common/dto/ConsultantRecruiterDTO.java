package common.dto;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 15:15
 */
public class ConsultantRecruiterDTO {

    public ConsultantRecruiterDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }

    private ProfileDTO profileDTO;

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }
}
