package infrastructure;

import common.MasteredTechnology;
import common.Technology;
import common.dto.AddressDTO;
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
        AddressDTO addressDTO;
        ProfileDTO profileDTO;
        String otherDataWeDontWant;


        public FakeRecruiterReturnedFromDB(AddressDTO addressDTO, ProfileDTO profileDTO, String otherDataWeDontWant) {
            this.addressDTO = addressDTO;
            this.profileDTO = profileDTO;
            this.otherDataWeDontWant = otherDataWeDontWant;
        }

    }

    private List<FakeRecruiterReturnedFromDB> fakeRedcruiters;

    public ConsultantRecruiterRepsitoryImpl() {
        fakeRedcruiters = new ArrayList<>();
        fakeRedcruiters.add(new FakeRecruiterReturnedFromDB(
                new AddressDTO("74 rue chaptal", 92300, "Levallois"),
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
            recruiters.add(new ConsultantRecruiterDTO(fakeRecruiterReturnedFromDB.addressDTO, fakeRecruiterReturnedFromDB.profileDTO));
        }

        return recruiters;
    }
}
