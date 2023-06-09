package main;

import java.util.Scanner;

import dao.AccountDao;
import file.FileProc;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		AccountDao dao = new AccountDao();
		FileProc fp = new FileProc("accountbook");
		//file read 호출
		fp.read();
		//
		// 메뉴
				while(true) {
					System.out.println("address book menu ---------------------");
					System.out.println("1.가계부추가");
					System.out.println("2.가계부삭제");
					System.out.println("3.가계부검색");
					System.out.println("4.가계부수정");
					System.out.println("5.모두출력");
					System.out.println("6.가계부저장");
					System.out.println("7.종료");
					
					System.out.print("menu number >> ");
					int menuNumber = sc.nextInt();
					
					switch(menuNumber)
					{
						case 1:
							dao.insert();
							break;
						case 2:	
							dao.delete();
							break;
						case 3:
							dao.select();
							break;
						case 4:
							dao.update();
							break;
						case 5:
							dao.allDataPrint();
							break;
						case 6:
							fp.write();
							break;
						case 7 : 
							System.out.println("프로그램을 종료하겠습니다");
							return;
					}			
				}
	}
	
}
