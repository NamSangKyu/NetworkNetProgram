package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//클라이언트 프로그램에 필요한 모든 데이터를 해당클래스에서 관리 
public class DataWrapper {
	private static boolean login = false;
	private static BufferedReader br = null;
	private static PrintWriter pw = null;
	private static Scanner sc = null;
	
	public static void init(Socket server) {
		sc = new Scanner(System.in);
		try {
			br = new BufferedReader(new InputStreamReader(server.getInputStream()));
			pw = new PrintWriter(server.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isLogin() {
		return login;
	}

	public static void setLogin(boolean login) {
		DataWrapper.login = login;
	}

	public static BufferedReader getBr() {
		return br;
	}


	public static PrintWriter getPw() {
		return pw;
	}

	public static Scanner getSc() {
		return sc;
	}
	
}
