package server.controller;

import org.json.JSONObject;

import dto.MemberDTO;
import server.dao.MemberDAO;

public class UpdateController implements Controller {

	@Override
	public JSONObject execute(JSONObject content) {
		String id = content.getString("id");
		String pass = content.getString("pass");
		String name = content.getString("name");
		String tel = content.getString("tel");
		
		int count = MemberDAO.getInstance().updateMemberDTO(new MemberDTO(id, pass, name, tel));
		JSONObject result = new JSONObject();
		if(count == 0) {
			result.put("responseCode", 500);
			result.put("message", "사용자 정보 수정 에러, 수정할려는 사용자 정보가 없습니다.");
		}else {
			result.put("responseCode", 200);
			result.put("message", "사용자 정보 수정 성공");
		}
		
		return result;
	}

}
