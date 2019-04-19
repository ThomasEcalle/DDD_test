package model.interview;

import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 14:43
 */
class Address {
    public Address(String rue, int codePostal, String ville) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    final String rue;

    final int codePostal;

    final String ville;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return codePostal == address.codePostal &&
                Objects.equals(rue, address.rue) &&
                Objects.equals(ville, address.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rue, codePostal, ville);
    }
}
