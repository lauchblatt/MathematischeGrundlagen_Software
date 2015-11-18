package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import org.jpl7.Term;

import parser.ClauseProcessor;
import prolog.GuiModel;
import prolog.JPLInterface;

public class PrologInterface implements ActionListener {

	private static final int WINDOW_WIDTH = 1248;
	private static final int WINDOW_HEIGHT = 800;
	private static final int[] CONTROL_BUTTON_DIMENSION = { 75, 75 };

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
	private int obstacleCounter = 1;

	private String positionsString;
	private String fieldsString;
	private String freeString;
	private String blockedString;
	private String thymioString = "";
	private String goalString = "";
	private String obstacleString = "";

	private JButton fwButton;
	private JButton bwButton;
	private JButton leftButton;
	private JButton rightButton;

	private JTextField requestField;
	private JButton requestButton;
	private JTextPane requestAnswer;
	private JTextPane arrowAnswer;

	private ActionListener ae;

	private JButton removeRule;
	
	private JPLInterface jpl;
	private ClauseProcessor cp;
	private GuiModel guiModel;

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
		
		jpl = new JPLInterface();
		cp = new ClauseProcessor();
		
	}

	public void start(int xAxis, int yAxis, Point loc) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		
		guiModel = new GuiModel(xAxis, yAxis);

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

	private JPanel controlPanel() {
		JPanel control = new JPanel();
		control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));

		JPanel fwPanel = new JPanel();
		fwPanel.setLayout(new BoxLayout(fwPanel, BoxLayout.X_AXIS));
		fwButton = new JButton();
		fwButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));
		fwPanel.add(fwButton);

		JPanel bwPanel = new JPanel();
		bwPanel.setLayout(new BoxLayout(bwPanel, BoxLayout.X_AXIS));
		bwButton = new JButton();
		bwButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));
		bwPanel.add(bwButton);

		JPanel lrPanel = new JPanel();
		lrPanel.setLayout(new BoxLayout(lrPanel, BoxLayout.X_AXIS));
		leftButton = new JButton();
		rightButton = new JButton();
		JLabel sep = new JLabel("      ");
		leftButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));
		rightButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));

		customizeButtons();

		lrPanel.add(leftButton);
		lrPanel.add(sep);
		lrPanel.add(rightButton);

		fwPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		bwPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		lrPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		JPanel requestPanel = new JPanel();
		requestPanel.setLayout(new BoxLayout(requestPanel, BoxLayout.Y_AXIS));

		JLabel requestHint = new JLabel("Type in Requests:");
		requestHint.setAlignmentX(Component.CENTER_ALIGNMENT);
		requestField = new JTextField();
		requestField.setMaximumSize(new Dimension(400, 35));
		requestField.setAlignmentX(Component.CENTER_ALIGNMENT);
		requestButton = new JButton("Send Request");
		requestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		requestAnswer = new JTextPane();
		requestAnswer.setMaximumSize(new Dimension(400, 200));
		requestAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
		requestAnswer.setBackground(new Color(0xeeeeee));
		
		setListenerForRequest();

		requestPanel.add(requestHint);
		requestPanel.add(requestField);
		requestPanel.add(requestButton);
		requestPanel.add(requestAnswer);
		requestPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(fwPanel);
		buttonPanel.add(lrPanel);
		buttonPanel.add(bwPanel);
		buttonPanel.setSize(550, 600);

		
		JPanel requestAnswerPanel = new JPanel();
		requestAnswerPanel.setLayout(new BoxLayout(requestAnswerPanel, BoxLayout.X_AXIS));
		JLabel requestAnswerHint = new JLabel("Status: ");
		requestAnswerHint.setAlignmentX(Component.CENTER_ALIGNMENT);
		arrowAnswer = new JTextPane();
		arrowAnswer.setMaximumSize(new Dimension(400, 35));
		arrowAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
		arrowAnswer.setBackground(new Color(0xeeeeee));
		requestAnswerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		requestAnswerPanel.add(requestAnswerHint);
		requestAnswerPanel.add(arrowAnswer);
		
		control.add(requestPanel);
		control.add(buttonPanel);
		control.add(requestAnswerPanel);
		
		
		return control;
	}

	private void setListenerForRequest() {
		requestButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(requestField.getText().equals("")){
					requestAnswer.setText("Type in Request...");
				} else{
					// Send Requests to Prolog
					// Falschangaben abfangen?
					// Ask if Solution exists...
					boolean hasSolution = jpl.queryClause(requestField.getText());
					if(hasSolution){
						
						String answer = "TRUE";
						
						Color green = new Color(0, 255, 0);
						requestAnswer.setForeground(green);
						
						// ... if yes ask for all solutions
						Map<String, Term>[] solutions = jpl.request(requestField.getText());
						
						for(int i = 0; i < solutions.length; i++){
							Iterator it = solutions[i].entrySet().iterator();
							answer = answer + "\n " + (i+1) + ". L�sung: ";
							while(it.hasNext()){
								Map.Entry pair = (Map.Entry)it.next();
								answer = answer + pair.getKey() + " = " + pair.getValue() + " ";
						        it.remove();			}
						}
						
						requestAnswer.setText(answer);
						
					}else{
						Color red = new Color(255, 0, 0);
						requestAnswer.setForeground(red);
						requestAnswer.setText("FALSE -->" + jpl.getCurrentRequestError());
					}
					
				}
			}
		});
	}

	private void customizeButtons() {
		bwButton.setIcon(new ImageIcon("resources/button_bw.png"));
		fwButton.setIcon(new ImageIcon("resources/button_fw.png"));
		leftButton.setIcon(new ImageIcon("resources/button_left.png"));
		rightButton.setIcon(new ImageIcon("resources/button_right.png"));
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
				positionsString += "pos(f" + count + ",(" + i + "," + k
						+ ")).\n";
				
				freeMap[i][k] = count;
				count++;
			}
		}
		
		updateFacts();
	}

	private void updateFacts() {
		
		guiModel.resetBlocked();
		
		freeString = "";
		//blockedString = "";

		int count = 1;
		for (int i = 0; i < xAxis; i++) {
			for (int k = 0; k < yAxis; k++) {
				if (freeMap[i][k] == count) {
					freeString += "free(f" + count + ").\n";
				} else if (freeMap[i][k] == count * -1) {
					//blockedString += "blocked(f" + count + ").\n";
					
					//Set Model blocked
					int[] blocked = new int[]{i, k};
					guiModel.addToBlocked(blocked);
					
				}
				count++;
			}
		}

		facts.setText(fieldsString + positionsString + freeString
				//+ blockedString 
				+ thymioString + goalString + obstacleString);
		jpl.updateFacts(facts.getText());
		jpl.test();
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
					
					//remove Rule in Prolog
					jpl.removeRuleByIndex(index);
					jpl.test();

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
		window.add(controlPanel());
	}

	private JPanel rulePanel() {
		JPanel rulePanel = new JPanel();
		rulePanel.setLayout(new BoxLayout(rulePanel, BoxLayout.Y_AXIS));
		rulePanel.add(ruleInput());
		rulePanel.add(ruleInfo());
		rulePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));
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
						
						//Rules added here
						//Parser Problems
						//System.out.println(cp.process(input.getText()));
						
						//Lets assume everything is prolog
						jpl.addRule(input.getText());
						jpl.test();
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
		for (int i = 0; i < freeMap.length; i++) {
			for (int k = 0; k < freeMap[i].length; k++) {
				if (freeMap[i][k] < 0) {
					freeMap[i][k] *= -1;
				}
			}
		}
		obstacleCounter = 1;
		obstacleString = "";
		thymioString = "";
		goalString = "";
		updateFacts();
	}

	private JPanel map() {

		mapPanel = new JPanel(new GridLayout(xAxis, yAxis));
		for (int i = 0; i < xAxis; i++) {
			for (int k = 0; k < yAxis; k++) {
				int row = i;
				int col = k;

				JButton field = createGridButton(row, col);
				field.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
						Color.BLACK));
				field.setMaximumSize(new Dimension(35,35));
				field.setMinimumSize(new Dimension(35,35));
				
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
						generateGoalFact(1, row, col);
						updateFacts();
					} else if (type.equals("resources/obstacle.png")) {
						freeMap[row][col] *= -1;
						generateObstacleString(1, row, col);
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
						generateGoalFact(0, row, col);
						updateFacts();
					} else if (type.equals("resources/obstacle.png")) {
						freeMap[row][col] *= -1;
						generateObstacleString(0, row, col);
						updateFacts();
						gb.setIcon(null);
					}
				}
			}

		});
		return b;
	}

	protected void generateObstacleString(int i, int row, int col) {
		if (i == 1) {
			obstacleString += "obstacle(o" + obstacleCounter + ")." + "\n"
					+ "pos(o" + obstacleCounter + ",(" + row + "," + col
					+ ")).\n";
			obstacleCounter++;
		} else {
			String known = ",(" + row + "," + col + ")).";
			String[] obstArray = obstacleString.split("\n");
			for (int k = 0; k < obstArray.length; k++) {
				if (obstArray[k].contains(known)) {
					obstArray[k] = "";
					obstArray[k - 1] = "";
				}
			}
			obstacleString = "";

			for (int k = 0; k < obstArray.length; k++) {
				if (obstArray[k] != "") {
					obstacleString += obstArray[k] + "\n";
				}
			}
		}
	}

	protected void generateGoalFact(int i, int row, int col) {
		if (i == 1) {
			goalString = "goal(z)." + "\n" + "pos(z,(" + row + "," + col
					+ ")).\n";
		} else {
			goalString = "";
		}
	}

	protected void generateThymioFact(int i, int row, int col) {
		if (i == 1) {
			thymioString = "thymio(t)." + "\n" + "pos(t,(" + row + "," + col
					+ ")).\n";
		} else {
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
