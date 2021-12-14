package checkersGUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import checkersGUI.CheckersGUI;
import tradutionGUi.TradutionLang;
/**
 * This class searches for classes that implements the interface CheckersPlayer
 * in the Player folder. It then allows the user to choose a player for player1
 * and player2.
 * 
 * @author Amos Yuen
 * @version 1.20 - 27 July 2008
 */

@SuppressWarnings("serial")
public class GameOptionsDialog extends JDialog implements ActionListener,
		KeyListener {
	private boolean accepted;
	private JCheckBox autoSwitch, showMoves;
	private JButton ok, cancel;
	private JPanel panel;
	private TextSlider turnTime, maxMoves, waitTime, tileSize;
	static CheckersGUI lang;
	
	static ResourceBundle config = new TradutionLang(lang.languageSelect).getBundle(lang.languageSelect);
	
	public GameOptionsDialog(JFrame parent, int turnTimeAmount,
			int maxMovesAmount, int waitTimeAmount, int tileSizeAmount,
			boolean autoSwitchB, boolean showMovesB) {
		super(parent, config.getString("GameOptionss"), true);
		
		System.out.println(config);
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(CheckersGUI.NEUTRAL_BG_COLOR);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 0, 5);
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		turnTime = new TextSlider(10, 120, turnTimeAmount);
		turnTime.setMajorTickSpacing(10);
		turnTime.setMinorTickSpacing(2);
		turnTime.setToolTipText(config.getString("Theamountoftimeinseconds") + " "
				+ config.getString("thataplayerhastodecideonhisturnn"));
		turnTime.getSlider().setForeground(CheckersGUI.NEUTRAL_FG_COLOR);
		TitledBorder border = BorderFactory.createTitledBorder(
				CheckersGUI.BORDER, config.getString("TurnTimee"));
		border.setTitleColor(CheckersGUI.NEUTRAL_FG_COLOR);
		turnTime.setBorder(border);
		panel.add(turnTime, c);

		c.insets = new Insets(0, 5, 0, 5);
		c.gridy++;
		maxMoves = new TextSlider(20, 150, maxMovesAmount);
		maxMoves.setMajorTickSpacing(10);
		maxMoves.setMinorTickSpacing(2);
		maxMoves.setToolTipText(config.getString("Themaximumnumberofmoves") + " "
				+ config.getString("inagamebeforeitiscaleldaDraw"));
		maxMoves.getSlider().setForeground(CheckersGUI.NEUTRAL_FG_COLOR);
		border = BorderFactory.createTitledBorder(CheckersGUI.BORDER,
				config.getString("MaxMoves"));
		border.setTitleColor(CheckersGUI.NEUTRAL_FG_COLOR);
		maxMoves.setBorder(border);
		panel.add(maxMoves, c);

		c.gridy++;
		waitTime = new TextSlider(0, 1000, waitTimeAmount);
		waitTime.setMajorTickSpacing(100);
		waitTime.setMinorTickSpacing(10);
		waitTime.setToolTipText(config.getString("Theamountoftimeinmilliseconds") + " "
				+ config.getString("thatthegamewillwait/pauseaftereachturn"));
		waitTime.getSlider().setForeground(CheckersGUI.NEUTRAL_FG_COLOR);
		border = BorderFactory.createTitledBorder(CheckersGUI.BORDER,
				config.getString("TurnWaitTime"));
		border.setTitleColor(CheckersGUI.NEUTRAL_FG_COLOR);
		waitTime.setBorder(border);
		panel.add(waitTime, c);

		c.gridy++;
		tileSize = new TextSlider(10, 100, tileSizeAmount);
		tileSize.setMinorTickSpacing(2);
		tileSize.setMajorTickSpacing(10);
		tileSize.setToolTipText(config.getString("Thesizeinpixelsofeach")
				+ " " + config.getString("squareonthecheckersboard"));
		tileSize.getSlider().setForeground(CheckersGUI.NEUTRAL_FG_COLOR);
		border = BorderFactory.createTitledBorder(CheckersGUI.BORDER,
				config.getString("TileSize"));
		border.setTitleColor(CheckersGUI.NEUTRAL_FG_COLOR);
		tileSize.setBorder(border);
		panel.add(tileSize, c);

		c.insets = new Insets(5, 5, 5, 5);
		c.gridwidth = 1;
		c.weighty = 1;
		c.gridy++;
		autoSwitch = new JCheckBox("Auto-Switch Players", autoSwitchB);
		autoSwitch
				.setToolTipText(config.getString("Automaticallyswitchplayersidesoftheboardeverynewgame"));
		autoSwitch.setOpaque(false);
		autoSwitch.setForeground(CheckersGUI.NEUTRAL_FG_COLOR);
		panel.add(autoSwitch, c);

		c.gridx++;
		showMoves = new JCheckBox(config.getString("ShowMovess"), showMovesB);
		showMoves
				.setToolTipText(config.getString("Highlighttilestoshowthecurrentplayerspossiblemoves"));
		showMoves.setOpaque(false);
		showMoves.setForeground(CheckersGUI.NEUTRAL_FG_COLOR);
		panel.add(showMoves, c);

		c.gridx--;
		c.gridy++;
		cancel = new JButton(config.getString("Cancel"));
		cancel.addActionListener(this);
		panel.add(cancel, c);

		c.gridx++;
		ok = new JButton("OK");
		ok.addActionListener(this);
		panel.add(ok, c);

		add(panel);
		setFocusCycleRoot(true);

		turnTime.addKeyListener(this);
		maxMoves.addKeyListener(this);
		waitTime.addKeyListener(this);
		autoSwitch.addKeyListener(this);
		showMoves.addKeyListener(this);
		cancel.addKeyListener(this);
		ok.addKeyListener(this);
		addKeyListener(this);

		setSize(500, 450);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok)
			accepted = true;
		setVisible(false);
	}

	public int getMaxMoves() {
		return maxMoves.getValue();
	}

	public int getTileSize() {
		return tileSize.getValue();
	}

	public int getTurnTime() {
		return turnTime.getValue();
	}

	public int getWaitTime() {
		return waitTime.getValue();
	}

	public boolean isAccepted() {
		return accepted;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			cancel.doClick();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public boolean showMoves() {
		return showMoves.isSelected();
	}

	public boolean useAutoSwitch() {
		return autoSwitch.isSelected();
	}
}