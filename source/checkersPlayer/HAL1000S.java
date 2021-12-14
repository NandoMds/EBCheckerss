package checkersPlayer;

import java.util.ResourceBundle;

import checkersGUI.CheckersGUI;
import tradutionGUi.TradutionLang;

/**
 * The HAL1000S is an advanced learning Artificial Intelligence for Checkers. It
 * uses a depth-limited search and a mini-max algorithm with alpha-beta pruning.
 * It uses a neural network to evaluate the board. The HAL1000S is a reduced
 * version of the HAL1000 that moves within a few seconds.
 * 
 * @author Amos Yuen and Louis Wang
 * @version {@value #VERSION}
 */

public class HAL1000S extends HAL1000 {

	public static final String VERSION = HAL1000.VERSION;
	
	static CheckersGUI lang;
	
	static ResourceBundle config = new TradutionLang(lang.languageSelect).getBundle(lang.languageSelect);

	public HAL1000S() {
		reduceTimes = new int[] { 1000 };
	}

	@Override
	protected void calcSearchDepth() {
		searchDepth = MIN_SEARCH_DEPTH;
		maxSearchDepth = searchDepth + 2;
	}

	@Override
	public String getDescription() {
		return config.getString("ASpeedversionotheHAL1000thatsearchesmallconstant")
				+ " " + config.getString("depthforfastperformanceItisadvancedlearning")
				+ " " + config.getString("Checkerssearchwithamini-ma")
				+ " " + config.getString("algorithmandalpha-betapruningunique")
				+ " " +config.getString("heuristicin")
				+ "\n\nAuthor: Amos Yuen and Louis Wang\nVersion: " + VERSION;
	}
}
