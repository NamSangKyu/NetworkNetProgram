package server.controller;

import org.json.JSONObject;

public interface Controller {
	public JSONObject execute(JSONObject content);
}
