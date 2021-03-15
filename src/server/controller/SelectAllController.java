package server.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.MemberDTO;
import server.dao.MemberDAO;

public class SelectAllController implements Controller {

	@Override
	public JSONObject execute(JSONObject content) {
		ArrayList<MemberDTO> list = MemberDAO.getInstance().selectAllMemberDTO();
		JSONObject result = new JSONObject();
		if(list.size() == 0) {
			result.put("responseCode", 500);
			result.put("message", "데이터가 하나도 없습니다.");
		}else {
			result.put("responseCode", 200);
			result.put("message", "전체 조회 성공");
			result.put("list",new JSONArray(list));
		}
		
		
		return result;
	}

}
