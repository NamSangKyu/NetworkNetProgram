package server.controller;

import org.json.JSONObject;

import server.dao.MemberDAO;

public class DropOutController implements Controller {

	@Override
	public JSONObject execute(JSONObject content) {
		String id = content.getString("id");
		int count = MemberDAO.getInstance().deleteMemberDTO(id);
		JSONObject result = new JSONObject();
		if(count == 0) {
			result.put("responseCode", 500);
			result.put("message", "사용자 탈퇴 에러, 아이디에 해당하는 사용자가 없습니다.");
		}else {
			result.put("responseCode", 200);
			result.put("message", "사용자 탈퇴 성공");
		}
		
		return result;
	}

}
