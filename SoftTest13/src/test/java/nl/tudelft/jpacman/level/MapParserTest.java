package nl.tudelft.jpacman.level;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MapParserTest {

	private MapParser mapParser;
	private final LevelFactory levelFactory = mock(LevelFactory.class);
	private final BoardFactory boardFactory = mock(BoardFactory.class);
	
	@BeforeEach
	void setup() {
		mapParser = new MapParser(levelFactory, boardFactory);
		
		when(boardFactory.createGround()).thenReturn(mock(Square.class));
		when(boardFactory.createWall()).thenReturn(mock(Square.class));
		
		when(levelFactory.createGhost()).thenReturn(mock(Ghost.class));
		when(levelFactory.createPellet()).thenReturn(mock(Pellet.class));
	}
	
	@Test
	@Order(1)
	@DisplayName("null文件名")
	void nullFile() {
		assertThatThrownBy(()->{
			mapParser.parseMap((String)null);
		}).isInstanceOf(NullPointerException.class);
	}
	
	@Test
	@Order(2)
	@DisplayName("读取不存在的文件")
	void notExistFile() {
		String file = "/notexistmap.txt";
		assertThatThrownBy(()->{
			mapParser.parseMap(file);
		}).isInstanceOf(PacmanConfigurationException.class)
		.hasMessage("Could not get resource for: "+file);
	}
	
	@Test
	@Order(3)
	@DisplayName("存在的文件")
	void exitsFile() throws IOException{
		String file = "/simplemap.txt";
		mapParser.parseMap(file);
		
		verify(boardFactory,times(4)).createGround();
		verify(boardFactory,times(2)).createWall();
		verify(levelFactory).createGhost();
	}
	
	@Test
	@Order(4)
	@DisplayName("包含非法字符的文件")
	void unrecognizeMap() {
		String file = "/unrecognizedMap.txt";
		assertThatThrownBy(()->{
			mapParser.parseMap(file);
		}).isInstanceOf(PacmanConfigurationException.class)
		.hasMessage("Invalid character at 0,0: B");
	}
}
