package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.json.JSONObject;

import server.controller.Controller;
import server.controller.HandlerMapping;

/**
 * 파일명 : MemberServerMain
 * 작성자 : 남상규
 * 작성일 : 2021-03-01
 * 개요 : 서버프로그램 및 서버 스레드
 * @version 0.0.1
 */
public class MemberServerMain {
	private static ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();
	public static void main(String[] args) {
		ServerSocket server = null;
//		  1. 서버 오픈
		try {
			server = new ServerSocket(1234);
			System.out.println("서버 오픈 완료");
			while(true) {
//		  2. 클라이언트 접속 - 사용자 접속 정보 출력은 스레드에서 처리
				Socket client = server.accept();
				System.out.println(client.getInetAddress() + "에서 접속함....");
//		  3. ServerWorker 생성 후 Thread실행
				ServerWorker worker = new ServerWorker(client);
				worker.start();
				System.out.println(list.size()+"명 접속 중입니다.");
//		  4. ServerWorker 리스트에 추가
				list.add(worker);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	/**
	 * 클래스 : ServerWorker
	 * 개요 : Client와 직접 통신을 하는 스레드
	 */
	public static class ServerWorker extends Thread{
		private Socket client;
		private BufferedReader br;
		private PrintWriter pw;

		public ServerWorker(Socket client) {
			this.client = client;
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = new PrintWriter(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			//클라이언트가 서버 접속 후
			String msg = null;
			try {
				while(true) {
					//사용자가 요청한 메뉴코드와 정보를 받아서 실행
					msg = br.readLine();
					//코드와 정보를 분리
					JSONObject json = new JSONObject(msg);
					String code = json.getString("code");
					String content = json.getString("content");
					Controller controller = HandlerMapping.getInstance().createController(code);
					//작업 수행 후 결과 Json으로 결과를 받음
					JSONObject result = null;
					if(controller != null)
						//Controller에서 작업결과를 json으로 셋팅
						result = controller.execute(content);
					else {
						result = new JSONObject();
						result.put("code", "error");
						result.put("message", "잘못된 명령을 보냈습니다.");
					}
					//결과를 사용자에게 전송
					pw.println(result.toString());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}





