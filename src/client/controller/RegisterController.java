package client.controller;

import java.util.Scanner;

import org.json.JSONObject;

import client.DataWrapper;

public class RegisterController implements Controller {

	@Override
	public JSONObject execute() {
		Scanner sc = DataWrapper.getSc();
		System.out.println("사용자 등록하시겠습니다......");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("암호 : ");
		String pass = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("연락처 : ");
		String tel = sc.nextLine();
		JSONObject content = new JSONObject();
		json.put("code", "register");
		content.put("id", id);
		content.put("pass", pass);
		content.put("name", name);
		content.put("tel", tel);
		json.put("content",content);
		return null;
	}


}
