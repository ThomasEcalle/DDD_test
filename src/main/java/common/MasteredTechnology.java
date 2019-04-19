package common;

import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 12:40
 */
public class MasteredTechnology {
    private Technology technology;
    private int experienceYears;

    public MasteredTechnology(Technology technology, int experienceYears) {
        this.technology = technology;
        this.experienceYears = experienceYears;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasteredTechnology that = (MasteredTechnology) o;
        return experienceYears == that.experienceYears &&
                technology == that.technology;
    }

    @Override
    public int hashCode() {
        return Objects.hash(technology, experienceYears);
    }
}
