package main;

import prolog.JPLInterface;
import dataanalysis.InfraRed;
import map.Map;
import gui.MainInterface;
import gui.ThymioInterface;

public class MainController {
	private MainInterface gui;
	//private Map map;
	//private InfraRed myIR;
	//private JPLInterface jpl;

	public MainController() {
		
		gui = new MainInterface();
		//myIR = new InfraRed();
		//map = new Map(3, 3, 17, 16.5);
		//gui = new ThymioInterface(map, myIR);
		//jpl = new JPLInterface();
	}

	public static void main(String[] args) {
		MainController mc = new MainController();
	}
	
}
