package checkersPlayer;

import java.util.ResourceBundle;

import checkersGUI.CheckersGUI;
import checkersMain.CheckersPlayerInterface;
import tradutionGUi.TradutionLang;

/**
 * This checkers player picks one of its available moves at random.
 */
public class RandomAI implements CheckersPlayerInterface {
	
	static CheckersGUI lang;
	
	static ResourceBundle config = new TradutionLang(lang.languageSelect).getBundle(lang.languageSelect);

	@Override
	public int choosePlyIndex(CheckersPlayerEvent cpe) {
		// choose a random move to make
		return (int) (cpe.board.getNumPlies() * Math.random());
	}

	@Override
	public void gameEnded(CheckersPlayerEvent cpe) {
	}

	@Override
	public void gameStarted(CheckersPlayerEvent cpe) {
	}

	@Override
	public String getDescription() {
		return config.getString("AstupidAIthaplaysrandomly")
				+ "\n\nAuthors: Jeremy Hoffman"
				+ "\nVersion: 1.00 - 10 July 2008";
	}

	public String getName() {
		return config.getString("RandomAI");
	}

	@Override
	public void remainingTimeChanged(CheckersPlayerEvent cpe) {
	}
}
