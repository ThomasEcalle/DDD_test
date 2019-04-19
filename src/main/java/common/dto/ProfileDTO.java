package common.dto;

import common.MasteredTechnology;
import common.Technology;

import java.util.List;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 14:39
 */
public class ProfileDTO {

    public ProfileDTO(List<MasteredTechnology> specialities, List<Technology> knownTechnologies) {
        this.specialities = specialities;
        this.knownTechnologies = knownTechnologies;
    }

    private List<MasteredTechnology> specialities;
    private List<Technology> knownTechnologies;

    public List<Technology> getKnownTechnologies() {
        return knownTechnologies;
    }

    public void setKnownTechnologies(List<Technology> knownTechnologies) {
        this.knownTechnologies = knownTechnologies;
    }

    public List<MasteredTechnology> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<MasteredTechnology> specialities) {
        this.specialities = specialities;
    }
}
