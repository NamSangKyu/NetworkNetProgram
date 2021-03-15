package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		Scanner sc = null;
		boolean login = false;//현재 로그인 상태 ---> 문자열로 세션ID 생성 관리
		try {
			//1. 서버 접속
			server = new Socket("127.0.0.1",1234);
			DataWrapper.init(server);
			sc = DataWrapper.getSc();
			int no;
			while(true) {
				JSONObject json = new JSONObject();
				//2. 메뉴 출력
				//3. 메뉴 입력
				//4. 컨트롤러 생성 -> 실행
				if(login) {
					System.out.println(MenuList.MAIN_MENU);
					System.out.println("원하시는 메뉴를 입력하세요>");
					no = sc.nextInt();
					sc.nextLine();
				}else {
					System.out.println(MenuList.LOGIN_MENU);
					System.out.println("원하시는 메뉴를 입력하세요>");
					no = sc.nextInt();
					sc.nextLine();
					if(no==1) {
						
					}else {
						
					}
					
				}
				//컨트롤러 실행부분

			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}












