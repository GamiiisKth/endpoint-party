package se.joshua.endpoint.party.service;

import com.so4it.common.util.object.Required;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import se.joshua.endpoint.party.model.CreatePlayerRequestModel;
import se.joshua.endpoint.party.modelMapper.CreatePlayerRequestModelMapper;
import se.joshua.party.client.PlayerClient;

import javax.validation.Valid;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@so4it.com/>}
 */

@RestController
@RequestMapping("/")
public class PlayerRestService {


    private PlayerClient playerClient;




    public PlayerRestService(PlayerClient playerClient) {
        this.playerClient = Required.notNull(playerClient, "playerService");
    }

    @ApiOperation(value = "Create Player" , httpMethod = "POST")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public void post(@Valid @RequestBody CreatePlayerRequestModel createPlayerRequestModel) {
        playerClient.createPlayer(CreatePlayerRequestModelMapper.map(createPlayerRequestModel));

    }

}
