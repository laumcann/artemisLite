/**
 * 
 */
package artemislitev9;
import java.util.List;

/**
 * @author MCdal
 */
public class StateOfPlay {

	private List<Player> playerList;
	
	private List<Square> board;

	public StateOfPlay(List<Player> playerList, List<Square> board) {
		this.playerList = playerList;
		this.board = board;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public List<Square> getBoard() {
		return board;
	}

	public void setBoard(List<Square> board) {
		this.board = board;
	}	
}
