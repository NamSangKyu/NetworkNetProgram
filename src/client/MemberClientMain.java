package client;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.JSONObject;

import menu.MenuList;

/**
 * 파일명 : MemberClientMain
 * 작성일 : 2021-03-15
 * 작성자 : 남상규
 *@version 0.0.1
 * 개요 : 클라이언트 프로그램
 */
public class MemberClientMain {

	public static void main(String[] args) {
		Socket server = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);
		boolean login = false;//현재 로그인 상태 ---> 문자열로 세션ID 생성 관리
		try {
			//1. 서버 접속
			server = new Socket("127.0.0.1",1234);
			
			while(true) {
				JSONObject json = new JSONObject();
				if(login) {
					
				}else {
					System.out.println(MenuList.LOGIN_MENU);
					System.out.println("원하시는 메뉴를 입력하세요>");
					int no = sc.nextInt();
					if(no==1) {
						System.out.println("로그인하시겠습니다......");
						System.out.print("아이디 : ");
						String id = sc.nextLine();
						System.out.print("암호 : ");
						String pass = sc.nextLine();
						json.put("code", "login");
						json.put("id", id);
						json.put("pass", pass);
					}else {
						System.out.println("사용자 등록하시겠습니다......");
						System.out.print("아이디 : ");
						String id = sc.nextLine();
						System.out.print("암호 : ");
						String pass = sc.nextLine();
						System.out.print("이름 : ");
						String name = sc.nextLine();
						System.out.print("연락처 : ");
						String tel = sc.nextLine();
						json.put("code", "register");
						json.put("id", id);
						json.put("pass", pass);
						json.put("name", name);
						json.put("tel", tel);
						
					}
				}
				//전송
			}
			//2. 메뉴 출력
			//3. 내용 입력
			//4. 서버로 전송
			//5. 결과를 받아서 처리
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}












