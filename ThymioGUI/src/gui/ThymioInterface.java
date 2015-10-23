package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import map.Map;
import client.ThymioConnector;
import dataanalysis.InfraRed;

public class ThymioInterface {

	private static final int CONTROLPANEL_HEIGHT = 300;
	private static final int CONTROLPANEL_WIDTH = 600;

	private static final int[] CONTROL_BUTTON_DIMENSION = { 50, 50 };

	private static final int ECKE = 0;
	private static final int FRONTAL = 1;
	private static final int SPITZE = 2;
	private static final int LINKS = 3;
	private static final int RECHTS = 4;
	private static final int FREI = 5;

	private JFrame window = new JFrame();
	private ActionListener ae;
	private JLabel classify;
	private JPanel windowPanel;
	private JPanel control;
	private JTextPane posX;
	private JTextPane posY;
	private JTextPane orientation;
	private JButton fwButton;
	private JButton bwButton;
	private JButton leftButton;
	private JButton rightButton;
	private JButton stopButton;
	private ThymioConnector myConnector;
	private MapPanel myMapDisplay;
	private InfraRed myIRData;

	public ThymioInterface(Map m, InfraRed ir) {
		myIRData = ir;
		initComponents(m);
	}

	private void initComponents(Map m) {
		//myConnector = new ThymioConnector();
		//myConnector.init(this);
		
		initWindow();
		initControlPanel();
		initInfopanel(m);
		
		/* Prolog UI-Elements */
		
		window.setVisible(true);
	}
	

	private void initInfopanel(Map m) {
		//int align = 
		//FlowLayout layout = new FlowLayout(align);
		//layout.setVgap(50);
		JPanel classifyPanel;
		
		classifyPanel = new JPanel();
		classifyPanel.setLayout(new BoxLayout(classifyPanel, BoxLayout.Y_AXIS));
		
		classify = new JLabel();
		classify.setIcon(new ImageIcon("resources/free.png"));

		posX = new JTextPane();
		posX.setSize((int)posX.getSize().getWidth(), 15);
		posY = new JTextPane();
		posY.setSize((int)posY.getSize().getWidth(), 15);
		orientation = new JTextPane();
		orientation.setSize((int)orientation.getSize().getWidth(), 15);
		
		classifyPanel.add(classify);
		classifyPanel.add(posX);
		classifyPanel.add(posY);
		classifyPanel.add(orientation);
		//classifyPanel.setPreferredSize(new Dimension((int)orientation.getSize().getWidth(), (int)orientation.getSize().getHeight()*3));
		
		//windowPanel.add(classifyPanel);
		
		myMapDisplay = new MapPanel(m, myIRData, window);
		windowPanel.add(myMapDisplay);
		window.setBounds(30, 30, CONTROLPANEL_WIDTH, CONTROLPANEL_HEIGHT);
	}

	private void initWindow() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		windowPanel = new JPanel();
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.X_AXIS));
		window.setContentPane(windowPanel);
	}

	private void setEventlisteners() {
		ae = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				performAction(e);
			}
		};

		fwButton.addActionListener(ae);
		bwButton.addActionListener(ae);
		leftButton.addActionListener(ae);
		rightButton.addActionListener(ae);
		stopButton.addActionListener(ae);
	}

	public void thymioEvent(JsonArray data) {
		String status;
		JsonArray rawValues;
		JsonArray obstacles;
		JsonArray position;
		int bestClass = FREI;
		double bestProb;

		status = data.getJsonObject(0).getString("status");
		if (status.equals("ok")) {
			rawValues = data.getJsonObject(1).getJsonArray("sensor_raw");
			
			for (int i = 0; i < rawValues.size(); i++)
				myIRData.updateValue(i, Short.parseShort(rawValues.getJsonObject(i).getString("sensor_" + i)));
			
			obstacles = data.getJsonObject(2).getJsonArray("obstacles");	

			bestProb = Double.MIN_VALUE;
			for (int i = 0; i < 6; i++) {
				double p = Double.parseDouble(obstacles.getJsonObject(i).getString("class_" + i));
				
				if (p > bestProb) {
					bestProb = p;
					bestClass = i;
				}
			}
			position = data.getJsonObject(3).getJsonArray("position");				
			
			updatePosition(Double.parseDouble(position.getJsonObject(0).getString("pos_x")),
						   Double.parseDouble(position.getJsonObject(1).getString("pos_y")),
						   Double.parseDouble(position.getJsonObject(2).getString("orientation")));			
			updateObstacle(bestClass);
			window.repaint();
		}
		else  {
			System.out.println("ERROR: " + status);
		}
	}
	
	protected void performAction(ActionEvent e) {		
		if (e.getSource() == this.fwButton) {
			System.out.println("FORWARD!");
			if (myConnector.thymioConnected()) myConnector.sendMessage("set speed 50 50");
			else this.updatePosition(myMapDisplay.getPosX()*10, (myMapDisplay.getPosY() + myMapDisplay.getEdgeLengthY())*10, myMapDisplay.getThymioOrientation());
		}
		else if (e.getSource() == this.bwButton) {
			System.out.println("BACKWARD!");
			if (myConnector.thymioConnected()) myConnector.sendMessage("set speed -50 -50");
			else this.updatePosition(myMapDisplay.getPosX()*10, (myMapDisplay.getPosY() - myMapDisplay.getEdgeLengthY())*10 , myMapDisplay.getThymioOrientation());
		}
		else if (e.getSource() == this.leftButton) {
			System.out.println("LEFT!");
			if (myConnector.thymioConnected()) myConnector.sendMessage("set speed -50 50");
			else this.updatePosition((myMapDisplay.getPosX() - myMapDisplay.getEdgeLengthX())*10, myMapDisplay.getPosY()*10, myMapDisplay.getThymioOrientation());

		}
		else if (e.getSource() == this.rightButton) {
			System.out.println("RIGHT!");
			if (myConnector.thymioConnected()) myConnector.sendMessage("set speed 50 -50");
			else this.updatePosition((myMapDisplay.getPosX() + myMapDisplay.getEdgeLengthX())*10, myMapDisplay.getPosY()*10, myMapDisplay.getThymioOrientation());
		}
		else if (e.getSource() == this.stopButton) {
			System.out.println("STOP!");
			if (myConnector.thymioConnected()) myConnector.sendMessage("set speed 0 0");
		}
		else return;
	}

	private void updatePosition(double posXmm, double posYmm, double theta) {
		posX.setText(String.format("Position X: %.2f mm", posXmm));
		posY.setText(String.format("Position Y: %.2f mm", posYmm));
		orientation.setText(String.format("Orientation: %.2f rad", theta));
		
		myMapDisplay.setPose(posXmm/10, posYmm/10, theta);
	}
	
	private void updateObstacle(int obstClass) {
		if (obstClass == FRONTAL) {
			classify.setIcon(new ImageIcon("resources/frontal.png"));
		}
		else if (obstClass == ECKE) {
			classify.setIcon(new ImageIcon("resources/ecke.png"));
		}
		else if (obstClass == SPITZE) {
			classify.setIcon(new ImageIcon("resources/kante.png"));
		}
		else if (obstClass == FREI) {
			classify.setIcon(new ImageIcon("resources/free.png"));
		}
		else if (obstClass == LINKS) {
			classify.setIcon(new ImageIcon("resources/left.png"));
		}
		else if (obstClass == RECHTS) {
			classify.setIcon(new ImageIcon("resources/right.png"));
		}
	}

	private void customizeButtons() {
		bwButton.setIcon(new ImageIcon("resources/button_bw.png"));
		fwButton.setIcon(new ImageIcon("resources/button_fw.png"));
		leftButton.setIcon(new ImageIcon("resources/button_left.png"));
		rightButton.setIcon(new ImageIcon("resources/button_right.png"));
		stopButton.setIcon(new ImageIcon("resources/button_stop.png"));
	}

	private void initControlPanel() {
		control = new JPanel();
		control.setLayout(new GridLayout(3, 1));
		int align = FlowLayout.CENTER;

		JPanel fwPanel = new JPanel(new FlowLayout(align));
		fwButton = new JButton();
		fwButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));
		fwPanel.add(fwButton);

		JPanel bwPanel = new JPanel(new FlowLayout(align));
		bwButton = new JButton();
		bwButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));
		bwPanel.add(bwButton);

		FlowLayout flow = new FlowLayout(align);
		flow.setHgap(10);
		JPanel panel = new JPanel(flow);
		leftButton = new JButton();
		stopButton = new JButton();
		rightButton = new JButton();
		leftButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));
		stopButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));
		rightButton.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0],
				CONTROL_BUTTON_DIMENSION[1]));
		panel.add(leftButton);
		panel.add(stopButton);
		panel.add(rightButton);

		control.add(fwPanel);
		control.add(panel);
		control.add(bwPanel);
		control.setPreferredSize(new Dimension(CONTROL_BUTTON_DIMENSION[0]*4, CONTROL_BUTTON_DIMENSION[0]*4));
		windowPanel.setBackground(Color.WHITE);
		windowPanel.add(control);
		customizeButtons();
		setEventlisteners();
	}
}
