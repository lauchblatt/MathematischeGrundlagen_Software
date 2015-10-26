package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
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

	private String type = "T";

	private JTextField input;
	private JButton addRule;

	private int xAxis;
	private int yAxis;

	private JTree ruleTree;
	private DefaultMutableTreeNode tree;
	private DefaultTreeModel model;

	private ArrayList<JButton> buttons = new ArrayList<JButton>();

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
		windowPanel.setMaximumSize(WINDOW_DIMENSION);
		windowPanel.setMinimumSize(WINDOW_DIMENSION);
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.X_AXIS));
		window.setContentPane(windowPanel);
		window.setVisible(false);
	}

	public void start(int xAxis, int yAxis, Point loc) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;

		window.setLocation(loc);
		initComponents();
		initEventListeners();
		initTreeListener();
		window.setVisible(true);

	}

	private void initTreeListener() {

		removeRule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath path = ruleTree.getSelectionPath();
				if (path!=null)
				{

				MutableTreeNode node =(MutableTreeNode) path.getLastPathComponent();

				System.out.println("Trying to remove : "+node.toString());

				MutableTreeNode parent=(MutableTreeNode)node.getParent();
				int index=parent.getIndex(node);
				parent.remove(node);

				DefaultTreeModel model=(DefaultTreeModel)ruleTree.getModel();
				model.nodesWereRemoved(parent,new int[]{index},null);

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
		JPanel ruleInfoPanel = new JPanel();
		ruleInfoPanel.setLayout(new BoxLayout(ruleInfoPanel, BoxLayout.Y_AXIS));
		ruleInfoPanel.setSize(550, 600);


		tree = new DefaultMutableTreeNode(
				"Defined Rules:");
		
		tree.setAllowsChildren(true);
		ruleTree = new JTree(tree);
		ruleTree.setMinimumSize(new Dimension(500, 400));
		ruleInfoPanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		ruleInfoPanel.add(ruleTree);
		ruleTree.setVisible(false);
		model = (DefaultTreeModel) ruleTree.getModel();
		
		removeRule = new JButton("Remove selected Rule");
		removeRule.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeRule.setVisible(false);
		ruleInfoPanel.add(removeRule);
		return ruleInfoPanel;
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
					ruleTree.setVisible(true);
					removeRule.setVisible(true);
					if (!input.getText().equals("")) {
						DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
						model.insertNodeInto(new DefaultMutableTreeNode(input.getText()), root, root.getChildCount());
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
					for (int i = 0; i < buttons.size(); i++) {
						buttons.get(i).setText("");
					}
				}
			}
		});

		controlPanel.add(clearButton);
		controlPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return controlPanel;
	}

	private JPanel map() {

		mapPanel = new JPanel(new GridLayout(yAxis, xAxis));

		for (int i = 0; i < yAxis; i++) {
			for (int k = 0; k < xAxis; k++) {
				int row = i;
				int col = k;

				if (i > 0) {
					col = k + xAxis * i - i;
				}
				JButton field = createGridButton(row, col);
				buttons.add(field);
				mapPanel.add(field);
			}
		}

		mapPanel.setMaximumSize(new Dimension(xAxis * 50 + 50, yAxis * 50 + 50));
		mapPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		return mapPanel;
	}

	private JButton createGridButton(final int row, final int col) {
		final JButton b = new JButton();

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton gb = PrologInterface.this.getGridButton(row, col);

				if (gb.getText().equals(type)) {
					gb.setText("");
				} else {
					if (gb.getText().equals("")) {
						gb.setText(type);
					}
				}
			}
		});
		return b;
	}

	protected JButton getGridButton(int row, int col) {
		int index = row + col;
		return buttons.get(index);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		type = e.getActionCommand();

	}
}
