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
			controller = new LoginController();
			break;
		case "dropout":
			controller = new DropOutController();
			break;
		case "update":
			controller = new UpdateController();
			break;
		case "select" : 
			controller = new SelectController();
			break;
		case "all":
			controller = new SelectAllController();
			break;
		}
		return controller;
	}
	
	
}
