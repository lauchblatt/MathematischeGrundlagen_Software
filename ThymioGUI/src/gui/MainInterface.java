package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainInterface {

	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 260;
	private static final Dimension WINDOW_DIMENSION = new Dimension(
			WINDOW_WIDTH, WINDOW_HEIGHT);

	private JFrame window;
	private JPanel windowPanel;
	private JButton startThymioGUI;
	private JButton startPrologGUI;
	
	private PrologInterface pInterface;

	private JTextField xAxis;
	private JTextField yAxis;

	private JLabel hint;

	private ActionListener ae;

	public MainInterface() {
		pInterface = new PrologInterface();
		
		initWindow();
		initControls();
		initActionListeners();
		window.setVisible(true);

	}

	private void initActionListeners() {
		ae = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				performAction(e);
			}
		};

		startThymioGUI.addActionListener(ae);
		startPrologGUI.addActionListener(ae);

	}

	protected void performAction(ActionEvent e) {

		if (e.getSource() == this.startThymioGUI) {
			hint.setForeground(Color.red);
			hint.setText("Not yet implemented");
		} else if (e.getSource() == this.startPrologGUI) {
			if (checkField()) {
				hint.setForeground(Color.green);
				hint.setText("Starting...");
				pInterface.start(Integer.parseInt(xAxis.getText()), Integer.parseInt(yAxis.getText()), window.getLocation());
				window.setVisible(false);
			} else {
				hint.setForeground(Color.red);
				hint.setText("Type in Numbers between 1 and 10");
			}
		}
	}

	private boolean checkField() {
		String x = xAxis.getText();
		String y = yAxis.getText();

		if (x.matches("[0-9]+") && y.matches("[0-9]+")) {
			if (x.equals("0") || y.equals("0")) {
				return false;
			} else if (Integer.parseInt(x) > 10 || Integer.parseInt(y) > 10) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	private void initControls() {
		windowPanel.add(titlePanel());
		windowPanel.add(dimensionPanel());
		windowPanel.add(selectPanel());
		windowPanel.add(infoPanel());
	}

	private JPanel infoPanel() {
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));

		hint = new JLabel("");
		hint.setForeground(Color.red);
		infoPanel.add(hint);
		infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return infoPanel;
	}

	private JPanel dimensionPanel() {
		JPanel dimensionPanel = new JPanel();
		dimensionPanel
				.setLayout(new BoxLayout(dimensionPanel, BoxLayout.X_AXIS));

		JLabel setSize = new JLabel("Field Size:");
		xAxis = new JTextField("2");
		xAxis.setMaximumSize(new Dimension(35, 25));
		JLabel sep = new JLabel("x");
		yAxis = new JTextField("2");
		yAxis.setMaximumSize(new Dimension(35, 25));

		dimensionPanel.add(setSize);
		dimensionPanel.add(xAxis);
		dimensionPanel.add(sep);
		dimensionPanel.add(yAxis);
		dimensionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
		return dimensionPanel;
	}

	private JPanel titlePanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.PAGE_AXIS));

		JLabel head = new JLabel("Thymio & Prolog");
		head.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
		head.setBorder(BorderFactory.createMatteBorder(20, 0, 20, 0,
				Color.LIGHT_GRAY));

		titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		titlePanel.add(head);
		return titlePanel;
	}

	private JPanel selectPanel() {
		JPanel selectPanel = new JPanel();
		selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.X_AXIS));
		startThymioGUI = new JButton("Start Thymio");
		startPrologGUI = new JButton("Start Prolog");
		selectPanel.add(startThymioGUI);
		selectPanel.add(startPrologGUI);
		selectPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return selectPanel;
	}

	private void initWindow() {
		window = new JFrame();
		window.setBounds(30, 30, WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setTitle("Thymio / Prolog Interface - Universität Regensburg");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowPanel = new JPanel();
		windowPanel.setMaximumSize(WINDOW_DIMENSION);
		windowPanel.setMinimumSize(WINDOW_DIMENSION);
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.PAGE_AXIS));
		window.setContentPane(windowPanel);
	}

}
