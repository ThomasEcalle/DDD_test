package infrastructure;

import common.MasteredTechnology;
import common.Technology;
import common.dto.AddressDTO;
import common.dto.CandidateDTO;
import common.dto.ProfileDTO;
import use_case.CandidateReposiory;

import java.util.ArrayList;
import java.util.List;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 14:24
 */


public class CandidateRepositoryDefaultImpl implements CandidateReposiory {

    private class FakeCandidateReturnedFromDB {
        AddressDTO addressDTO;
        ProfileDTO profileDTO;
        String otherDataWeDontWant;


        public FakeCandidateReturnedFromDB(AddressDTO addressDTO, ProfileDTO profileDTO, String otherDataWeDontWant) {
            this.addressDTO = addressDTO;
            this.profileDTO = profileDTO;
            this.otherDataWeDontWant = otherDataWeDontWant;
        }

    }

    private List<FakeCandidateReturnedFromDB> fakeCandidates;

    public CandidateRepositoryDefaultImpl() {
        fakeCandidates = new ArrayList<>();
        fakeCandidates.add(new FakeCandidateReturnedFromDB(
                new AddressDTO("74 rue chaptal", 92300, "Levallois"),
                new ProfileDTO(new ArrayList<MasteredTechnology>() {{
                    add(new MasteredTechnology(Technology.Android, 3));
                }}, new ArrayList<Technology>() {{
                    add(Technology.Javascript);
                }}),
                "Useless Information"));
    }

    @Override
    public CandidateDTO getCandidateById(int id) {
        if (id >= 0 && id < fakeCandidates.size()) {
            FakeCandidateReturnedFromDB fromDatabase = fakeCandidates.get(id);
            CandidateDTO candidateDTO = new CandidateDTO(fromDatabase.addressDTO, fromDatabase.profileDTO);

            return candidateDTO;
        }
        return null;
    }
}
