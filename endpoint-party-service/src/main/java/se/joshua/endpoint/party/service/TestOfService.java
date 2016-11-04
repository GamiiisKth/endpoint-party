package se.joshua.endpoint.party.service;


import com.j_spaces.core.IJSpace;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.openspaces.remoting.ExecutorRemotingProxyConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.joshua.party.runner.domain.CreatePlayerRequest;
import se.joshua.party.service.PlayerService;

import java.time.LocalDate;


/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class TestOfService {


    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("endpoint-reducers.xml");

        context.getBean("objectListResultReducer");


        IJSpace space = new UrlSpaceConfigurer("jini://*/*/party?locators=127.0.0.1").space();

        GigaSpace gigaSpace = new GigaSpaceConfigurer(space).gigaSpace();

        PlayerService playerService = new ExecutorRemotingProxyConfigurer<>(gigaSpace, PlayerService.class)
                .proxy();


        playerService.createPlayer(CreatePlayerRequest.builder()
                .withEmail("dennis@joshua.com")
                .withFirstName("edw")
                .withLastName("we")
                .withUserName("hej")
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now())
                .build());

    }


}
