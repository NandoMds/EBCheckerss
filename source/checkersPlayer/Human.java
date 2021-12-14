package checkersPlayer;

import java.util.ResourceBundle;

import checkersGUI.CheckersGUI;
import checkersMain.CheckersBoard;
import checkersMain.CheckersPlayerInterface;
import tradutionGUi.TradutionLang;

public class Human implements CheckersPlayerInterface {
	private CheckersBoard board;
	private int moveIndex;
	private int remainingTime;
	static CheckersGUI lang;
	
	static ResourceBundle config = new TradutionLang(lang.languageSelect).getBundle(lang.languageSelect);

	@Override
	public int choosePlyIndex(CheckersPlayerEvent cpe) {
		remainingTime = cpe.remainingPlyTime;
		this.board = cpe.board;
		moveIndex = -1;
		while (moveIndex == -1) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(config.getString("HumanPlayer"));
				return -1;
			}
		}
		return moveIndex;
	}

	@Override
	public void gameEnded(CheckersPlayerEvent cpe) {
	}

	@Override
	public void gameStarted(CheckersPlayerEvent cpe) {
	}

	public CheckersBoard getCurrBoard() {
		return board;
	}

	@Override
	public String getDescription() {
		return config.getString("AHumanPlayer");
	}

	public String getName() {
		return config.getString("Humann");
	}

	public int getRemainingPlyTime() {
		return remainingTime;
	}

	@Override
	public void remainingTimeChanged(CheckersPlayerEvent cpe) {
		remainingTime = cpe.remainingPlyTime;
	}

	public void setMove(int index) {
		moveIndex = index;
	}
}
