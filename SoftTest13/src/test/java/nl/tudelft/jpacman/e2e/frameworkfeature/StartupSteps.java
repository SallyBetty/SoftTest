package nl.tudelft.jpacman.e2e.frameworkfeature;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;

public class StartupSteps {
	private Launcher lancher;

	private Game getGame() {
		return lancher.getGame();
	}

	@Given("The user has lanched the game")
	public void the_user_has_lanched_the_game() {
		lancher = new Launcher();
		lancher.launch();
	}

	@When("The user presses the {string} button")
	public void the_user_presses_the_button(String string) {
		getGame().start();
	}

	@Then("The game is running")
	public void the_game_is_running() {
		assertThat(getGame().isInProgress()).isTrue();
	}

	@After("@framework")
	void teardownUI() {
		lancher.dispose();
	}
}
