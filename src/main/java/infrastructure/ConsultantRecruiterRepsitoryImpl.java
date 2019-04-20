package infrastructure;

import common.MasteredTechnology;
import common.Technology;
import common.dto.ConsultantRecruiterDTO;
import common.dto.ProfileDTO;
import use_case.ConsultantRecruiterRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 15:18
 */
public class ConsultantRecruiterRepsitoryImpl implements ConsultantRecruiterRepository {

    private class FakeRecruiterReturnedFromDB {
        ProfileDTO profileDTO;
        String otherDataWeDontWant;


        FakeRecruiterReturnedFromDB(ProfileDTO profileDTO, String otherDataWeDontWant) {
            this.profileDTO = profileDTO;
            this.otherDataWeDontWant = otherDataWeDontWant;
        }

    }

    private List<FakeRecruiterReturnedFromDB> fakeRedcruiters;

    public ConsultantRecruiterRepsitoryImpl() {
        fakeRedcruiters = new ArrayList<>();
        fakeRedcruiters.add(new FakeRecruiterReturnedFromDB(
                new ProfileDTO(new ArrayList<MasteredTechnology>() {{
                    add(new MasteredTechnology(Technology.Android, 3));
                }}, new ArrayList<Technology>() {{
                    add(Technology.Javascript);
                }}),
                "Useless Information"));
    }

    @Override
    public List<ConsultantRecruiterDTO> getAllConsultantsRecruiter() {
        final List<FakeRecruiterReturnedFromDB> recruitersFromDB = fakeRedcruiters;
        final List<ConsultantRecruiterDTO> recruiters = new ArrayList<ConsultantRecruiterDTO>();
        for (FakeRecruiterReturnedFromDB fakeRecruiterReturnedFromDB : recruitersFromDB) {
            recruiters.add(new ConsultantRecruiterDTO(fakeRecruiterReturnedFromDB.profileDTO));
        }

        return recruiters;
    }
}
