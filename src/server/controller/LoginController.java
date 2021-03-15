package server.controller;

import org.json.JSONObject;

public class LoginController implements Controller {

	@Override
	public JSONObject execute(JSONObject content) {
		//아이디 패스워드 뽑음
		//DAO로 보내서 DB에서 로그인 정보 확인
		//그에 따른 결과를 json으로 넘겨줌
		return null;
	}

}
