package common.dto;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 11:59
 */
public class CandidateDTO {

    public CandidateDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }

    private ProfileDTO profileDTO;

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setProfileDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }
}
