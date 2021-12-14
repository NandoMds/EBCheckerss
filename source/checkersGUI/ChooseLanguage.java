package checkersGUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import checkersMain.CheckersPlayerInterface;
import checkersMain.CheckersPlayerLoader;
import tradutionGUi.TradutionInterface;
import tradutionGUi.TradutionInterface.CheckersLanguage;
import tradutionGUi.TradutionLang;

/**
 * This class is a GUI dialog that allows the user to change different settings
 * in the GameCheckerager and CheckersGUI.
 * 
 * @author Amos Yuen
 * @version 1.20 - 30 July 2008
 */

@SuppressWarnings("serial")
public class ChooseLanguage extends JDialog implements ActionListener,
		KeyListener, ItemListener {

	public static final Font FONT = new Font("Arial", Font.BOLD, 20);

	private boolean accepted;
	private SimpleComboBox comboBox1;
	private JComponent component1;
	private JTextArea description1;
	private JButton ok, cancel;
	private JPanel panel;
	private JScrollPane scrollPane1;
	public String textSelect;

	public String[] selectLang = new String[] {"PT", "EN"};
	
	static CheckersGUI lang;
	
	static ResourceBundle config = new TradutionLang(lang.languageSelect).getBundle(lang.languageSelect);

	public ChooseLanguage(JFrame parent) {
		super(parent, config.getString("Tools"), true);

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(CheckersGUI.NEUTRAL_BG_COLOR);

		ListCellRenderer cellRenderer = new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				JComponent c = (JComponent) super.getListCellRendererComponent(
						list, value, index, isSelected, false);

				if (isSelected) {
					c.setForeground(CheckersGUI.NEUTRAL_BG_COLOR);
					c.setBackground(list.getForeground());
				}

				return c;
			}
		};

		component1 = new JComponent() {
		};
		component1.setLayout(new GridBagLayout());
		TitledBorder border = BorderFactory.createTitledBorder(
				CheckersGUI.BORDER, config.getString("ChooseLanguage"));
		border.setTitleFont(FONT);
		border.setTitleColor(CheckersGUI.PLAYER1_COLOR);
		component1.setBorder(border);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;

		comboBox1 = new SimpleComboBox(selectLang);
		comboBox1.addItemListener(this);
		comboBox1.setForeground(CheckersGUI.PLAYER1_COLOR);
		comboBox1.setBackground(CheckersGUI.NEUTRAL_BG_COLOR);
		comboBox1.setFocusForeground(CheckersGUI.NEUTRAL_BG_COLOR);
		comboBox1.setFocusBackground(CheckersGUI.PLAYER1_COLOR);
		comboBox1.getList().setCellRenderer(cellRenderer);
		comboBox1.getPopup().setBorder(CheckersGUI.BORDER);
		component1.add(comboBox1, c);

		c.gridy++;
		c.weighty = 7;
		description1 = new JTextArea();
		description1.setEditable(false);
		description1.setLineWrap(true);
		description1.setWrapStyleWord(true);
		description1.setBackground(CheckersGUI.NEUTRAL_BG_COLOR);
		description1.setForeground(CheckersGUI.PLAYER1_COLOR);
		scrollPane1 = new JScrollPane(description1);
		scrollPane1.setOpaque(false);
		border = BorderFactory.createTitledBorder(CheckersGUI.BORDER,
				config.getString("Languageselect"));
		border.setTitleFont(FONT);
		border.setTitleColor(CheckersGUI.PLAYER1_COLOR);
		scrollPane1.setBorder(border);
		component1.add(scrollPane1, c);

		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 1;
		c.weighty = 5;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(component1, c);

		c.gridwidth = 1;
		c.weighty = 1;
		c.gridy++;
		ok = new JButton("OK");
		ok.addActionListener(this);
		panel.add(ok, c);

		c.gridx--;
		cancel = new JButton(config.getString("Cancel"));
		cancel.addActionListener(this);
		panel.add(cancel, c);

		add(panel);
		setFocusCycleRoot(true);
		description1.setFocusable(false);

		comboBox1.addKeyListener(this);
		scrollPane1.addKeyListener(this);
		cancel.addKeyListener(this);
		ok.addKeyListener(this);
		addKeyListener(this);

		setMinimumSize(new Dimension(400, 300));
		setSize(600, 400);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			accepted = true;
		}
		
		setVisible(false);
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

	@Override
	public void itemStateChanged(ItemEvent e) {		
		System.out.println("Item");
		System.out.println(e.getItem());
		
		textSelect = e.getItem().toString();
		
		System.out.println("textSelect");
		System.out.println(textSelect);
	}
}