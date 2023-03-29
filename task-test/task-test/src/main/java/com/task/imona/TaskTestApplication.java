package com.task.imona;

import com.task.imona.entity.Action;
import com.task.imona.entity.Game;
import com.task.imona.entity.Player;
import com.task.imona.entity.PlayerAction;
import com.task.imona.repository.ActionRepository;
import com.task.imona.repository.PlayerActionRepository;
import com.task.imona.service.GameService;
import com.task.imona.service.PlayerService;
import com.task.imona.service.RelationshipService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TaskTestApplication implements CommandLineRunner {

	public TaskTestApplication(PlayerService playerService, GameService gameService, RelationshipService relationService, ActionRepository actionRepository, PlayerActionRepository playerActionRepository) {
		this.playerService = playerService;
		this.gameService = gameService;
		this.relationService = relationService;
		this.actionRepository = actionRepository;
		this.playerActionRepository = playerActionRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskTestApplication.class, args);
	}

	private final PlayerService playerService;

	private final GameService gameService;

	private final  RelationshipService relationService;

	private final ActionRepository actionRepository;

	private final PlayerActionRepository playerActionRepository;


	@Override
	public void run(String... args) throws Exception {

		Game game= new Game("Drinks","win as you drink");
		gameService.saveGame(game);

		Player py1= new Player("Ercan","can","Male", new Date(2000,2,20),"istanbul",Boolean.TRUE);
		Player py2= new Player("Tyler","can","Male", new Date(2000,2,20),"istanbul",Boolean.TRUE);
        playerService.savePlayer(py1);
		playerService.savePlayer(py2);

		Action ac1= new Action("drink coffee","coffee is a good drink",10);
		Action ac2= new Action("drink tea","tea is a good drink",7);
		Action ac3= new Action("drink milk","milk is a good drink",5);
		actionRepository.save(ac1);
		actionRepository.save(ac2);
		actionRepository.save(ac3);

		//relationService.addActionToPlayer(py1.getId(),ac1.getId());
		//relationService.addActionToPlayer(py2.getId(),ac1.getId());
	//	relationService.addActionToPlayer(py1.getId(),ac2.getId());
		PlayerAction myobj=new PlayerAction(py1.getId(),ac1.getId());
		PlayerAction objobj=new PlayerAction(py1.getId(),ac2.getId());
		playerActionRepository.save(myobj);
		playerActionRepository.save(objobj);




	}
}
