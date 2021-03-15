package server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private Connection conn;

	private MemberDAO() {
		// JDBC 접속
		try {
			// 1. Oracle Driver 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. DB 접속
			// 3. 커넥션 받음
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	// 로그인
	public MemberDTO login(String id, String pass) {
		MemberDTO dto = null;
		// SQL 셋팅
		String sql = "select * from nmember where id = ? and pass = ?";
		try {
			// PreparedStatement 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			// SQL 실행
			ResultSet rs = pstmt.executeQuery();
			// ResultSet 결과 조회 --> dto로 결과 리턴
			if (rs.next())
				dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	// 사용자 등록
	public int insertMemberDTO(MemberDTO dto) {
		int count = 0;
		String sql = "insert into nmember values(?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getTel());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 탈퇴
	public int deleteMemberDTO(String id) {
		int count = 0;
		String sql = "delete from nmember where id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 조회
	public ArrayList<MemberDTO> selectMemberDTO(String name) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from nmember where name like '%'||?||'%'";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 전체조회
	public ArrayList<MemberDTO> selectAllMemberDTO() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from nmember where name";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 수정
	public int updateMemberDTO(MemberDTO dto) {
		int count = 0;
		String sql = "update nmember set pass=?, name=?, tel=? where id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, dto.getId());
			pstmt.setString(1, dto.getPass());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getTel());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}



