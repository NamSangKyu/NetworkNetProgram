package client.controller;

import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;

import client.DataWrapper;

public class LoginController implements Controller {

	@Override
	public JSONObject execute() {
		Scanner sc = DataWrapper.getSc();
		System.out.println("로그인하시겠습니다......");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("암호 : ");
		String pass = sc.nextLine();
		JSONObject json = new JSONObject();
		json.put("code", "login");
		JSONObject content = new JSONObject();
		content.put("id", id);
		content.put("pass", pass);
		json.put("content",content);
		try {
			//서버 전송
			DataWrapper.getPw().println(json.toString());
			DataWrapper.getPw().flush();
			//결과 받고 처리
			String msg = DataWrapper.getBr().readLine();
			JSONObject result = new JSONObject(msg);
			if(result.getInt("responseCode")==200) {
				DataWrapper.setLogin(true);
			}
			System.out.println(result.getString("message"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

}
