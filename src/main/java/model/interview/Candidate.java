package model.interview;

import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 14:42
 */
class Candidate {
    Candidate(Profile profile) {
        this.profile = profile;
    }

    final Profile profile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(profile, candidate.profile);

    }

    @Override
    public int hashCode() {
        return Objects.hash(profile);
    }
}
