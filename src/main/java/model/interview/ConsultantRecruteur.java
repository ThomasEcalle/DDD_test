package model.interview;

import common.MasteredTechnology;
import common.Technology;

import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 14:39
 */
class ConsultantRecruteur {
    ConsultantRecruteur(Profile profile) {
        this.profile = profile;
    }

    final Profile profile;

    public boolean canTest(Candidate candidate, Technology technology) {
        int candidateExperience = 0;
        for (MasteredTechnology speciality : candidate.profile.specialities) {
            if (speciality.getTechnology().equals(technology)) {
                candidateExperience = speciality.getExperienceYears();
            }
        }
        int recruiterExperience = 0;
        for (MasteredTechnology speciality : this.profile.specialities) {
            if (speciality.getTechnology().equals(technology)) {
                recruiterExperience = speciality.getExperienceYears();
            }
        }

        return recruiterExperience > candidateExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultantRecruteur that = (ConsultantRecruteur) o;
        return Objects.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile);
    }
}
