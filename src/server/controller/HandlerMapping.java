package server.controller;

public class HandlerMapping {
	//Singletone Pattern
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}
	//Factory Pattern
	public Controller createController(String code) {
		Controller controller = null;
		switch(code) {
		case "login":
			controller = null;
			break;
		}
		return controller;
	}
	
	
}
