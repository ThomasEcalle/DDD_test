package model.interview;

import common.InterviewStatus;
import common.Technology;
import common.dto.CandidateDTO;
import common.dto.ConsultantRecruiterDTO;
import model.interview.exception.NoRecruiterAvailableException;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Objects;

/**
 * User: thomasecalle
 * Date: 18/04/2019
 * Time: 14:17
 */
public class Interview {
    public Interview(
            DateTime date,
            int duration,
            Technology technology,
            CandidateDTO candidateDTO,
            List<ConsultantRecruiterDTO> recruiters) {

        this.creneau = new Creneau(date, duration);

        final Profile profile = new Profile(candidateDTO.getProfileDTO().getSpecialities(),
                candidateDTO.getProfileDTO().getKnownTechnologies());
        final Address address = new Address(candidateDTO.getAddressDTO().getRue(),
                candidateDTO.getAddressDTO().getCodePostal(),
                candidateDTO.getAddressDTO().getVille());

        this.candidate = new Candidate(profile, address);
        this.interviewId = InterviewId.generateInterviewId();

        for (ConsultantRecruiterDTO consultantRecruiterDTO : recruiters) {

            final Profile recruiterProfile = new Profile(consultantRecruiterDTO.getProfileDTO().getSpecialities(),
                    consultantRecruiterDTO.getProfileDTO().getKnownTechnologies());
            final Address recruiterAddress = new Address(consultantRecruiterDTO.getAddressDTO().getRue(),
                    consultantRecruiterDTO.getAddressDTO().getCodePostal(),
                    consultantRecruiterDTO.getAddressDTO().getVille());
            final ConsultantRecruteur consultantRecruteur = new ConsultantRecruteur(recruiterProfile, recruiterAddress);

            if (consultantRecruteur.canTest(candidate, technology)) {
                this.consultantRecruteur = consultantRecruteur;
                break;
            }
        }

        if (this.consultantRecruteur == null) {
            throw new NoRecruiterAvailableException();
        }
    }

    public final InterviewId interviewId;

    public InterviewStatus status;

    public Creneau creneau;

    public final Candidate candidate;

    public ConsultantRecruteur getConsultantRecruteur() {
        return consultantRecruteur;
    }

    public void setConsultantRecruteur(ConsultantRecruteur consultantRecruteur) {
        this.consultantRecruteur = consultantRecruteur;
    }

    public ConsultantRecruteur consultantRecruteur;

    public InterviewStatus getStatus() {
        return status;
    }

    public void setStatus(InterviewStatus status) {
        this.status = status;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(interviewId, interview.interviewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interviewId);
    }
}
