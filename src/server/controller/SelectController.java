package server.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.MemberDTO;
import server.dao.MemberDAO;

public class SelectController implements Controller {

	@Override
	public JSONObject execute(JSONObject content) {
		String name = content.getString("name");
		ArrayList<MemberDTO> list = MemberDAO.getInstance().selectMemberDTO(name);
		JSONObject result = new JSONObject();
		if(list.size() == 0) {
			result.put("responseCode", 500);
			result.put("message", "검색 결과가 없습니다. 다시 검색하세요");
		}else {
			result.put("responseCode", 200);
			result.put("message", "검색 성공");
			result.put("list",new JSONArray(list));
		}
		
		
		return result;
	}

}
