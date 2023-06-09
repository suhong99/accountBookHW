package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dto.AccountDto;
import singleton.Singleton;

public class FileProc {

	private File file = null;
	
	public FileProc(String filename) {
		file = new File("c:\\testtmp\\" + filename + ".txt");
		
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("파일 생성 실패~");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	
	public void write() {
		
		Singleton s = Singleton.getInstance();
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < s.accountList.size(); i++) {
				AccountDto dto = s.accountList.get(i); 
				pw.println(dto.print());
			}
			
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}	
		
		System.out.println("파일에 저장되었습니다");
	}
	
	public void read() {
		
		Singleton s = Singleton.getInstance();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String str = "";
			while((str = br.readLine()) != null) {				
				
				String split[] = str.split("-");
			
				AccountDto dto = new AccountDto( Integer.parseInt(split[0]), split[1], split[2], Integer.parseInt(split[3]), split[4]);
					
				s.accountList.add(dto);
			}			
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}			
		System.out.println("데이터를 모두 읽어들였습니다");
	}
	
}




