package model.interview;

import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 14:42
 */
class Candidate {
    public Candidate(Profile profile, Address address) {
        this.profile = profile;
        this.address = address;
    }

    final Profile profile;
    final Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(profile, candidate.profile) &&
                Objects.equals(address, candidate.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile, address);
    }
}
