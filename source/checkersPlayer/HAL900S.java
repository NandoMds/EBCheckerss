package checkersPlayer;

import java.util.ResourceBundle;

import checkersGUI.CheckersGUI;
import checkersMain.CheckersPlayerInterface;
import tradutionGUi.TradutionLang;

/**
 * The HAL900S is an advanced Artificial Intelligence for Checkers. It uses a
 * depth-limited search and a mini-max algorithm with alpha-beta pruning. The
 * HAL900S is a reduced version of the HAL900 that moves within a few seconds.
 * 
 * @author Amos Yuen and Louis Wang
 * @version {@value #VERSION}
 */

public class HAL900S extends HAL900 implements CheckersPlayerInterface {

	public static final String VERSION = HAL900.VERSION;
	
	static CheckersGUI lang;
	
	static ResourceBundle config = new TradutionLang(lang.languageSelect).getBundle(lang.languageSelect);
	
	public HAL900S() {
		reduceTimes = new int[] { 1000 };
	}

	@Override
	protected void calcSearchDepth() {
		searchDepth = MIN_SEARCH_DEPTH;
		maxSearchDepth = searchDepth + 2;
	}

	@Override
	public String getDescription() {
		return config.getString("Asmall")
				+ " " + config.getString("constantItisan")
				+ " " + config.getString("advancedlimitedtsearch")
				+ " " + config.getString("withbetapruning")
				+ "\n\nAuthor: Amos Yuen and Louis Wang\nVersion: " + VERSION;
	}

	@Override
	public String getName() {
		return getClass().getSimpleName();
	}
}
