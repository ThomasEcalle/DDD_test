package common.dto;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 11:59
 */
public class CandidateDTO {

    public CandidateDTO(AddressDTO addressDTO, ProfileDTO profileDTO) {
        this.addressDTO = addressDTO;
        this.profileDTO = profileDTO;
    }

    private AddressDTO addressDTO;
    private ProfileDTO profileDTO;

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setProfileDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
