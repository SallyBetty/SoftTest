package nl.tudelft.jpacman.npc.ghost;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.google.common.collect.Lists;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClydeTest {

	@Test
	@DisplayName("Clyde距离player小于8个方块")
	@Order(1)
	void departMoreThanEight() {
		//Arrange
		PacManSprites sprites = new PacManSprites();
		LevelFactory levelFactory = new LevelFactory(
				sprites,
				new GhostFactory(sprites),
				mock(PointCalculator.class));
		BoardFactory boardFactory = new BoardFactory(sprites);
		GhostFactory ghostFactory = new GhostFactory(sprites);
		
		MapParser mapParser = new GhostMapParser(levelFactory,boardFactory,ghostFactory);
		List<String> text = Lists.newArrayList(
				"##############",
				"#.#....C.....P",
				"##############");
		Level level = mapParser.parseMap(text);
		
		Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
		assertThat(clyde).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		
		//创建player
		Player player = new PlayerFactory(new PacManSprites()).createPacMan();
		player.setDirection(Direction.valueOf("WEST"));
		level.registerPlayer(player);
		Player p = Navigation.findUnitInBoard(Player.class, level.getBoard());
		assertThat(p).isNotNull();
		assertThat(p.getDirection()).isEqualTo(Direction.valueOf("WEST"));
		
		//act
		Optional<Direction> opt = clyde.nextAiMove();
		
		//assert:
		assertThat(opt.get()).isEqualTo(Direction.valueOf("WEST"));
	}
	
	@Test
	@DisplayName("Clyde距离player大于8个方块")
	@Order(2)
	void departMoreThanEight2() {
		//Arrange
		PacManSprites sprites = new PacManSprites();
		LevelFactory levelFactory = new LevelFactory(
				sprites,
				new GhostFactory(sprites),
				mock(PointCalculator.class));
		BoardFactory boardFactory = new BoardFactory(sprites);
		GhostFactory ghostFactory = new GhostFactory(sprites);
		
		MapParser mapParser = new GhostMapParser(levelFactory,boardFactory,ghostFactory);
		List<String> text = Lists.newArrayList(
				"##############",
				"#.C..........P",
				"##############");
		Level level = mapParser.parseMap(text);
		
		Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
		assertThat(clyde).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		
		//创建player
		Player player = new PlayerFactory(new PacManSprites()).createPacMan();
		player.setDirection(Direction.valueOf("WEST"));
		level.registerPlayer(player);
		/*Player p = Navigation.findUnitInBoard(Player.class, level.getBoard());
		assertThat(p).isNotNull();
		assertThat(p.getDirection()).isEqualTo(Direction.valueOf("WEST")); */
		
		//act
		Optional<Direction> opt = clyde.nextAiMove();
		
		//assert:
		assertThat(opt.get()).isEqualTo(Direction.valueOf("EAST"));
	}
	
	@Test
	@DisplayName("Clyde没有player")
	@Order(3)
	void departWithoPlayer() {
		//Arrange
		PacManSprites sprites = new PacManSprites();
		LevelFactory levelFactory = new LevelFactory(
				sprites,
				new GhostFactory(sprites),
				mock(PointCalculator.class));
		BoardFactory boardFactory = new BoardFactory(sprites);
		GhostFactory ghostFactory = new GhostFactory(sprites);
		
		MapParser mapParser = new GhostMapParser(levelFactory,boardFactory,ghostFactory);
		List<String> text = Lists.newArrayList(
				"##############",
				"#.C...........",
				"##############");
		Level level = mapParser.parseMap(text);
		
		Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
		assertThat(clyde).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		
		assertThat(level.isAnyPlayerAlive()).isFalse();
		
		//act
		Optional<Direction> opt = clyde.nextAiMove();
		
		//assert:
		assertThat(opt.isPresent()).isFalse();
	}
	
	@Test
	@DisplayName("Clyde与player没有路径到达")
	@Order(4)
	void withoutPathToPlayer() {
		//Arrange
		PacManSprites sprites = new PacManSprites();
		LevelFactory levelFactory = new LevelFactory(
				sprites,
				new GhostFactory(sprites),
				mock(PointCalculator.class));
		BoardFactory boardFactory = new BoardFactory(sprites);
		GhostFactory ghostFactory = new GhostFactory(sprites);
		
		MapParser mapParser = new GhostMapParser(levelFactory,boardFactory,ghostFactory);
		List<String> text = Lists.newArrayList(
				"#############P",
				"#...C........#",
				"##############");
		Level level = mapParser.parseMap(text);
		
		Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
		assertThat(clyde).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		
		assertThat(level.isAnyPlayerAlive()).isFalse();
		
		//act
		Optional<Direction> opt = clyde.nextAiMove();
		
		//assert:
		assertThat(opt.isPresent()).isFalse();
	}
		
}
