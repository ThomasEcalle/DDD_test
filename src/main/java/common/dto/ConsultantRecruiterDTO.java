package common.dto;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 15:15
 */
public class ConsultantRecruiterDTO {

    public ConsultantRecruiterDTO(AddressDTO addressDTO, ProfileDTO profileDTO) {
        this.addressDTO = addressDTO;
        this.profileDTO = profileDTO;
    }

    private AddressDTO addressDTO;
    private ProfileDTO profileDTO;

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setProfileDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }
}
