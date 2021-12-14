package tradutionGUi;

import javax.swing.JTextArea;

import checkersMain.CheckersBoard;

public interface TradutionInterface {
	
	public static final class CheckersLanguage {
		/**
		 * The current {@link CheckersBoard} such that this
		 * {@link CheckersPlayerInterface} is Player1.
		 */
		public final CheckersBoard board;
		
		public final String lang;

		public final boolean isSelect;

		public CheckersLanguage(CheckersBoard board, String lang,
				boolean isSelect) {
			this.board = board;
			this.lang = lang;
			this.isSelect = isSelect;
		}
	}

	/**
	 * Returns a description of this {@link CheckersPlayerInterface}. The text
	 * should be displayed in a {@link JTextArea} using line wrap.
	 * 
	 * @return a description of this {@link CheckersPlayerInterface}
	 */
	public String getLanguageDesc();

	/**
	 * Returns the display name of this {@link CheckersPlayerInterface}.
	 * 
	 * @return the display name of this {@link CheckersPlayerInterface}
	 */
	public String getNameLang();
}
