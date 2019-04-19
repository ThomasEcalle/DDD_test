package common.dto;

import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 14:35
 */
public class AddressDTO {

    public AddressDTO(String rue, int codePostal, String ville) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    private String rue;

    private int codePostal;

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    private String ville;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO that = (AddressDTO) o;
        return codePostal == that.codePostal &&
                Objects.equals(rue, that.rue) &&
                Objects.equals(ville, that.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rue, codePostal, ville);
    }
}
