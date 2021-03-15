package server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private Connection conn;
	private MemberDAO() {
		//JDBC 접속
		try {
			//1. Oracle Driver 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//2. DB 접속
			//3. 커넥션 받음
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}
	//로그인
	public MemberDTO login(String id,String pass) {
		
		return null;
	}
	//사용자 등록
	//탈퇴
	//조회
	//전체조회
	//수정
	
	
}





