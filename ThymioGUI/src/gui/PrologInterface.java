package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class PrologInterface implements ActionListener {

	private static final int WINDOW_WIDTH = 960;
	private static final int WINDOW_HEIGHT = 800;
	private static final Dimension WINDOW_DIMENSION = new Dimension(
			WINDOW_WIDTH, WINDOW_HEIGHT);

	private JFrame window;
	private JPanel windowPanel;
	private JPanel mapPanel;

	private ButtonGroup radioButtons;
	private JRadioButton thymioRadio;
	private JRadioButton obstacleRadio;
	private JRadioButton finishRadio;
	private JButton clearButton;

	private String type = "resources/thymio.png";

	private JTextField input;
	private JButton addRule;

	private JTextPane facts;

	private int xAxis;
	private int yAxis;

	private boolean thymioOnField = false;
	private boolean goalOnField = false;

	private JTree ruleTree;
	private DefaultMutableTreeNode tree;
	private DefaultTreeModel model;

	private JButton[][] buttons;
	private int[][] freeMap;


	private String positionsString;
	private String fieldsString;
	private String freeString;
	private String blockedString;
	private String thymioString = "";
	
	private ActionListener ae;

	private JButton removeRule;

	public PrologInterface() {
		initWindow();
	}

	private void initWindow() {
		window = new JFrame();
		window.setBounds(30, 30, WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setTitle("Thymio / Prolog Interface - Universität Regensburg");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowPanel = new JPanel();
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.X_AXIS));
		window.setVisible(false);
	}

	public void start(int xAxis, int yAxis, Point loc) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;

		buttons = new JButton[xAxis][yAxis];
		freeMap = new int[xAxis][yAxis];
		
		Dimension d = getDimension();
		windowPanel.setMinimumSize(d);
		window.setMinimumSize(d);
		windowPanel.setMaximumSize(d);
		window.setMaximumSize(d);
		window.setContentPane(windowPanel);
		window.setLocation(loc);
		initComponents();
		initFacts();
		initEventListeners();
		initTreeListener();
		window.setVisible(true);

	}

	private void initFacts() {
		fieldsString = "";
		positionsString = "";
		for (int i = 0; i < xAxis * yAxis; i++) {
			fieldsString += "field(f" + (i + 1) + ").\n";
		}

		int count = 1;
		for (int i = 0; i < xAxis; i++) {
			for (int k = 0; k < yAxis; k++) {
				positionsString += "pos(f" + count + ",(" + i + "," + k + ").\n";
				freeMap[i][k] = count;
				count++;
			}
		}
		
		updateFacts();
	}

	private void updateFacts() {
		freeString = "";
		blockedString = "";
		
		int count = 1;
		for(int i = 0; i < xAxis; i++){
			for(int k = 0; k < yAxis; k++){
				if(freeMap[i][k] == count){
					freeString += "free(f" + count + ").\n";
				}else if(freeMap[i][k] == count*-1){
					blockedString += "blocked(f" + count + ").\n";
				}
				count++;
			}
		}
		
		
		facts.setText(fieldsString + positionsString + freeString + blockedString + thymioString);
	}

	private Dimension getDimension() {
		int height = 100;
		switch (xAxis) {
		case 1:
			height = 300;
			break;
		case 2:
			height = 350;
			break;
		case 3:
			height = 400;
			break;
		case 4:
			height = 450;
			break;
		case 5:
			height = 500;
			break;
		case 6:
			height = 550;
			break;
		case 7:
			height = 600;
			break;
		case 8:
			height = 650;
			break;
		case 9:
			height = 700;
			break;
		case 10:
			height = 750;
			break;
		}
		return new Dimension(WINDOW_WIDTH, height);
	}

	private void initTreeListener() {

		removeRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath path = ruleTree.getSelectionPath();
				if (path != null) {

					MutableTreeNode node = (MutableTreeNode) path
							.getLastPathComponent();

					System.out.println("Trying to remove : " + node.toString());

					MutableTreeNode parent = (MutableTreeNode) node.getParent();
					int index = parent.getIndex(node);
					parent.remove(node);

					DefaultTreeModel model = (DefaultTreeModel) ruleTree
							.getModel();
					model.nodesWereRemoved(parent, new int[] { index }, null);

				}
			}
		});
	}

	private void initEventListeners() {
		ae = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				performAction(e);
			}
		};

	}

	protected void performAction(ActionEvent e) {
		JButton field = (JButton) e.getSource();
		field.setBackground(Color.red);
	}

	private void initComponents() {
		window.add(mapPanel());
		window.add(rulePanel());

	}

	private JPanel rulePanel() {
		JPanel rulePanel = new JPanel();
		rulePanel.setLayout(new BoxLayout(rulePanel, BoxLayout.Y_AXIS));
		rulePanel.add(ruleInput());
		rulePanel.add(ruleInfo());
		return rulePanel;
	}

	private JPanel ruleInfo() {
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		infoPanel.setSize(550, 600);

		facts = new JTextPane();
		facts.setMaximumSize(new Dimension(100, 100));
		facts.setEditable(false);
		facts.setText("Test");

		JScrollPane factsScroll = new JScrollPane(facts);
		factsScroll.setMaximumSize(new Dimension(250, 150));
		factsScroll.setBounds(0, 0, 50, 100);
		factsScroll.setVisible(true);
		factsScroll.setBorder(BorderFactory.createTitledBorder("Facts"));

		JPanel ruleInfoPanel = new JPanel();
		ruleInfoPanel.setLayout(new BoxLayout(ruleInfoPanel, BoxLayout.Y_AXIS));
		ruleInfoPanel.setSize(50, 100);

		tree = new DefaultMutableTreeNode("Defined Rules:");
		tree.setAllowsChildren(true);
		ruleTree = new JTree(tree);
		ruleTree.setMinimumSize(new Dimension(50, 100));
		ruleTree.setMaximumSize(new Dimension(50, 100));
		ruleTree.setScrollsOnExpand(true);
		ruleInfoPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		ruleInfoPanel.add(ruleTree);
		model = (DefaultTreeModel) ruleTree.getModel();

		JScrollPane strukturpane = new JScrollPane(ruleTree);
		strukturpane.setMaximumSize(new Dimension(250, 150));
		strukturpane.setBounds(0, 0, 50, 100);
		strukturpane.setVisible(true);
		ruleInfoPanel.add(strukturpane);
		strukturpane.setBorder(BorderFactory.createTitledBorder("Rules"));

		removeRule = new JButton("Remove selected Rule");
		removeRule.setAlignmentX(Component.CENTER_ALIGNMENT);
		ruleInfoPanel.add(removeRule);

		infoPanel.add(factsScroll);
		infoPanel.add(ruleInfoPanel);
		return infoPanel;
	}

	private JPanel ruleInput() {
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

		JLabel inputHint = new JLabel("Type in Rules:");
		inputHint.setAlignmentX(Component.CENTER_ALIGNMENT);

		input = new JTextField();
		input.setMaximumSize(new Dimension(500, 35));
		input.setAlignmentX(Component.CENTER_ALIGNMENT);

		addRule = new JButton("Add Rule");
		addRule.setAlignmentX(Component.CENTER_ALIGNMENT);

		addRule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == addRule) {
					if (!input.getText().equals("")) {
						DefaultMutableTreeNode root = (DefaultMutableTreeNode) model
								.getRoot();
						model.insertNodeInto(
								new DefaultMutableTreeNode(input.getText()),
								root, root.getChildCount());
						model.reload(root);
						input.setText("");
					}
				}
			}
		});

		inputPanel.add(inputHint);
		inputPanel.add(input);
		inputPanel.add(addRule);
		inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return inputPanel;
	}

	private JPanel mapPanel() {
		JPanel mapPanel = new JPanel();
		mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.Y_AXIS));
		mapPanel.add(map());
		mapPanel.add(controls());

		mapPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		return mapPanel;
	}

	private JPanel controls() {
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

		thymioRadio = new JRadioButton("Thymio", true);
		thymioRadio.setActionCommand("T");
		obstacleRadio = new JRadioButton("Obstacles", false);
		obstacleRadio.setActionCommand("O");
		finishRadio = new JRadioButton("Goal", false);
		finishRadio.setActionCommand("Z");

		radioButtons = new ButtonGroup();

		radioButtons.add(thymioRadio);
		radioButtons.add(obstacleRadio);
		radioButtons.add(finishRadio);

		controlPanel.add(thymioRadio);
		controlPanel.add(obstacleRadio);
		controlPanel.add(finishRadio);

		thymioRadio.addActionListener(this);
		obstacleRadio.addActionListener(this);
		finishRadio.addActionListener(this);

		thymioRadio.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));
		obstacleRadio.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		finishRadio.setBorder(BorderFactory.createEmptyBorder(0, 5, 20, 5));

		clearButton = new JButton("Clear");

		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == clearButton) {
					for (int i = 0; i < buttons.length; i++) {
						for (int k = 0; k < buttons[i].length; k++) {
							buttons[i][k].setIcon(null);
							buttons[i][k].setToolTipText("");
							clearFreeMap();
						}
					}
					thymioOnField = false;
					goalOnField = false;
				}
			}

		});

		controlPanel.add(clearButton);
		controlPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return controlPanel;
	}

	protected void clearFreeMap() {
		for(int i = 0; i < freeMap.length; i++){
			for(int k = 0; k < freeMap[i].length; k++){
				if(freeMap[i][k] < 0){
					freeMap[i][k]*=-1;
				}
			}
		}
		updateFacts();
	}

	private JPanel map() {

		mapPanel = new JPanel(new GridLayout(xAxis, yAxis));
		for (int i = 0; i < xAxis; i++) {
			for (int k = 0; k < yAxis; k++) {
				int row = i;
				int col = k;

				// if (i > 0) {
				// col = k + xAxis * i - i;
				// }
				JButton field = createGridButton(row, col);
				field.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
						Color.BLACK));
				
				buttons[i][k] = (field);
				mapPanel.add(field);
			}
		}

		mapPanel.setMaximumSize(new Dimension(yAxis * 50 + 52, xAxis * 50 + 52));
		mapPanel.setMinimumSize(new Dimension(yAxis * 50 + 52, xAxis * 50 + 52));

		mapPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		return mapPanel;
	}

	private JButton createGridButton(final int row, final int col) {
		final JButton b = new JButton();
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton gb = PrologInterface.this.getGridButton(row, col);

				if (gb.getIcon() == null) {
					if (!thymioOnField && type.equals("resources/thymio.png")) {
						thymioOnField = true;
						gb.setToolTipText(type);
						gb.setIcon(new ImageIcon(type));
						generateThymioFact(1, row, col);
						freeMap[row][col] *= -1;
						updateFacts();
					} else if (!goalOnField
							&& type.equals("resources/finish.png")) {
						goalOnField = true;
						gb.setToolTipText(type);
						gb.setIcon(new ImageIcon(type));
					} else if (type.equals("resources/obstacle.png")) {
						freeMap[row][col] *= -1;
						updateFacts();
						gb.setToolTipText(type);
						gb.setIcon(new ImageIcon(type));
					}
				} else if (gb.getToolTipText().equals(type)) {
					if (type.equals("resources/thymio.png")) {
						gb.setIcon(null);
						freeMap[row][col] *= -1;
						generateThymioFact(0, row, col);
						updateFacts();
						thymioOnField = false;
					} else if (type.equals("resources/finish.png")) {
						gb.setIcon(null);
						goalOnField = false;
					} else if (type.equals("resources/obstacle.png")) {
						freeMap[row][col] *= -1;
						updateFacts();
						gb.setIcon(null);
					}
				}
			}

		});
		return b;
	}

	protected void generateThymioFact(int i, int row, int col) {
		if(i == 1){
			thymioString = "Thymio(t)." + "\n" + "pos(t,(" + row + "," + col +")).\n";
		}else{
			thymioString = "";
		}
	}

	protected JButton getGridButton(int row, int col) {
		return buttons[row][col];

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "T":
			type = "resources/thymio.png";
			break;
		case "O":
			type = "resources/obstacle.png";
			break;
		case "Z":
			type = "resources/finish.png";
			break;
		}

	}
}
