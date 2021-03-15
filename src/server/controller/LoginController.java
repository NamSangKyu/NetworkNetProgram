package server.controller;

import org.json.JSONObject;

import dto.MemberDTO;
import server.dao.MemberDAO;

public class LoginController implements Controller {

	@Override
	public JSONObject execute(JSONObject content) {
		//아이디 패스워드 뽑음
		String id = content.getString("id");
		String pass = content.getString("pass");
		//DAO로 보내서 DB에서 로그인 정보 확인
		MemberDTO dto = MemberDAO.getInstance().login(id, pass);
		//그에 따른 결과를 json으로 넘겨줌
		//responseCode, message
		JSONObject result = new JSONObject();
		if(dto == null) {
			result.put("responseCode", 500);
			result.put("message", "로그인 에러, 아이디 비밀번호 확인하세요");
		}else {
			result.put("responseCode", 200);
			result.put("message", "로그인 성공");
		}
		return result;
	}

}






