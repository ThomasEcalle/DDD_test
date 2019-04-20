package model.interview;

import common.MasteredTechnology;
import common.Technology;

import java.util.List;
import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 12:27
 */

class Profile {

    final List<MasteredTechnology> specialities;
    final List<Technology> knownTechnologies;

    Profile(List<MasteredTechnology> specialities, List<Technology> knownTechnologies) {
        this.specialities = specialities;
        this.knownTechnologies = knownTechnologies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(specialities, profile.specialities) &&
                Objects.equals(knownTechnologies, profile.knownTechnologies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialities, knownTechnologies);
    }
}
