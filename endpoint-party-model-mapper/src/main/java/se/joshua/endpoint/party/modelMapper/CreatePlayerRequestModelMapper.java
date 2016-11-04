package se.joshua.endpoint.party.modelMapper;

import se.joshua.endpoint.party.model.CreatePlayerRequestModel;
import se.joshua.party.runner.domain.CreatePlayerRequest;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@so4it.com/>}
 */
public class CreatePlayerRequestModelMapper {


    public static CreatePlayerRequest map(CreatePlayerRequestModel createPlayerRequestModel) {
        if (createPlayerRequestModel == null) {
            return null;
        }

        return CreatePlayerRequest.builder()
                .withFirstName(createPlayerRequestModel.getFirstName())
                .withLastName(createPlayerRequestModel.getLastName())
                .withEmail(createPlayerRequestModel.getEmail())
                .withUserName(createPlayerRequestModel.getUserName())
                .withStartDate(createPlayerRequestModel.getStartDate())
                .withEndDate(createPlayerRequestModel.getEndDate())
                .build();
    }

}
