package server.controller;

import org.json.JSONObject;

import dto.MemberDTO;
import server.dao.MemberDAO;

public class RegisterController implements Controller {

	@Override
	public JSONObject execute(JSONObject content) {
		String id = content.getString("id");
		String pass = content.getString("pass");
		String name = content.getString("name");
		String tel = content.getString("tel");
		
		int count = MemberDAO.getInstance().insertMemberDTO(new MemberDTO(id, pass, name, tel));
		JSONObject result = new JSONObject();
		if(count == 0) {
			result.put("responseCode", 500);
			result.put("message", "사용자 등록 에러, 아이디가 중복됩니다. 다른 아이디를 입력하세요");
		}else {
			result.put("responseCode", 200);
			result.put("message", "사용자 등록 성공");
		}
		
		return result;
	}

}
