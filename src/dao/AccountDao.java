package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AccountDto;
import singleton.Singleton;

public class AccountDao {
	//데이터 편집
	//날짜 용도 수입/지출/ 금액 /내용

	private Scanner sc = new Scanner(System.in);
	
	public AccountDao() {
		
	}
	
	public void insert() {
		System.out.println("데이터를 추가합니다");
		System.out.print("날짜를 입력해주세요 생년월일 ex(220608) :  ");
		int date = sc.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		System.out.print("용도는 무엇입니까? : ");
		String perpose = null;
		try {
			perpose = br.readLine();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.print("수입입니까?(수입/지출): ");
		String incomeOrNot;
		while(true) {
			 incomeOrNot = sc.next();
			if(incomeOrNot.equals("수입")||incomeOrNot.equals("지출")) {
				break;
			}else {
				System.out.print("수입과 지출중에서 입력해주세요: ");
			}
		}
		System.out.print("금액은 얼마입니까? : ");
		int price = sc.nextInt();
		
		System.out.print("내용은 무엇입니까? : ");
		String details = null;
		try {
			details = br.readLine();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		Singleton s = Singleton.getInstance();
		s.accountList.add(new AccountDto(date, perpose, incomeOrNot, price, details));
		
		}
		
		//삭제
		public void delete() {
			String type = "삭제";
			List<Integer> deleteIndexes = search(type);
			Singleton s = Singleton.getInstance();
			if(deleteIndexes.isEmpty()) {
				System.out.println("해당 정보는 존재하지 않습니다.");
			}else {
				//삭제 대상 확인
				for (int i = 0; i < deleteIndexes.size(); i++) {
					System.out.println("대상 내용들은 아래와 같습니다.");
					System.out.println((i+1)+"번째 :" + s.accountList.get(deleteIndexes.get(i)).toString());
				}
				while(true) {
					System.out.print("삭제하고 싶은 번호를 입력해주세요(종료는 0을 입력 ): ");
					int deleteTarget = sc.nextInt();
					if(deleteTarget ==0) {
						break;
					}
					if(deleteTarget>0|| deleteTarget<deleteIndexes.size()) {						
						s.accountList.remove(deleteTarget);
						System.out.println("삭제하였습니다.");
					}else {
						System.out.print("존재하지 않는 번호입니다");
					}
				}
				
			}
		}
		//업데이트 
		public void update() {
			String type = "수정";
			List<Integer> updateIndexes = search(type);
			Singleton s = Singleton.getInstance();
			if(updateIndexes.isEmpty()) {
				System.out.println("해당 정보는 존재하지 않습니다.");
			}else {
				//삭제 대상 확인
				for (int i = 0; i < updateIndexes.size(); i++) {
					System.out.println("대상 내용들은 아래와 같습니다.");
					System.out.println((i+1)+"번째 :" + s.accountList.get(updateIndexes.get(i)).toString());
				}
				while(true) {
					System.out.print("수정하고 싶은 번호를 입력해주세요(종료는 0을 입력 ): ");
					int updateTarget = sc.nextInt();
					if(updateTarget ==0) {
						break;
					}
					if(updateTarget>0|| updateTarget<updateIndexes.size()) {						
						BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

						System.out.print("용도는 무엇입니까? : ");
						String perpose = null;
						try {
							perpose = br.readLine();
						} catch (IOException e) {			
							e.printStackTrace();
						}
						
						System.out.print("수입입니까?(수입/지출): ");
						String incomeOrNot;
						while(true) {
							 incomeOrNot = sc.next();
							if(incomeOrNot.equals("수입")||incomeOrNot.equals("지출")) {
								break;
							}else {
								System.out.print("수입과 지출중에서 입력해주세요: ");
							}
						}
						System.out.print("금액은 얼마입니까? : ");
						int price = sc.nextInt();
						
						System.out.print("내용은 무엇입니까? : ");
						String details = null;
						try {
							details = br.readLine();
						} catch (IOException e) {			
							e.printStackTrace();
						}
						AccountDto dto = s.accountList.get(updateTarget);
						dto.setPerpose(perpose);
						dto.setIncomeOrNot(incomeOrNot);
						dto.setPrice(price);
						dto.setDetails(details);
						System.out.println("수정이 완료 되었습니다.");
						
					}else {
						System.out.print("존재하지 않는 번호입니다");
					}
				}
				
			}
		}
		//선택 확인
		public void select() {
			String type = "확인";
			List<Integer> selectIndexes = search(type);
			Singleton s = Singleton.getInstance();
			if(selectIndexes.isEmpty()) {
				System.out.println("해당 정보는 존재하지 않습니다.");
			}else {
				//삭제 대상 확인
				for (int i = 0; i < selectIndexes.size(); i++) {
					System.out.println("대상 내용들은 아래와 같습니다.");
					System.out.println((i+1)+"번째 :" + s.accountList.get(selectIndexes.get(i)).toString());
				}
				while(true) {
					System.out.print("합계 =1, 종료 =0 을 입력해주세요 : ");
					int selectTarget = sc.nextInt();
					int sum=0;
					if(selectTarget ==0) {
						break;
					}else if(selectTarget==1) {				
						for(int i=0; i<selectIndexes.size();i++) {
							if(s.accountList.get(selectIndexes.get(i)).getIncomeOrNot().equals("수입")) {
								sum+=s.accountList.get(selectIndexes.get(i)).getPrice();
							}else {
								sum-=s.accountList.get(selectIndexes.get(i)).getPrice();
							}
						}
						String incomeOrNot;
						if(sum>=0) {
							incomeOrNot ="수입";
						}else {incomeOrNot ="지출";
							
						}
						System.out.println("해당 "+ incomeOrNot+"은 "+sum+"원입니다.");
					}else {
						System.out.print("잘못 입력하셨습니다.");
					}
				}
				
			}
		}
		//검색
		public List<Integer> search(String type ) {
			
			System.out.print(type+"할 방법(용도 : 1, 기간 : 2)");
			//입력 타입
			int searchType;
			while(true) {
				searchType= sc.nextInt();
				if(searchType==1||searchType==2) {
					break;
				}else {
					System.out.print("1(용도)와 2(기간)중에서 입력해주세요 : ");
				}
			}
			//입력 내용
			String searchThings;
			if(searchType==1) {
				System.out.print("용도를 입력해주세요 : ");
				searchThings=sc.next();
			}else {
				System.out.print("시작날짜를 입력해주세요(000000) : ");
				while(true) {
					searchThings = sc.next();
					// 길이가 6이 아니면 다시 반복문의 처음으로 돌아감
					 if (searchThings.length() != 6) {
			                System.out.println("6글자 짜리 정수를 입력해주세요 : ");
			                continue; 
			            }
					 
		            try {
		            	// 정상적으로 int로 변환되면 반복문 종료
		                Integer.parseInt(searchThings);
		                break;
		            } catch (NumberFormatException e) {
		                // 변환에 실패한 경우 다시 입력 받기
		                System.out.print("입력한 값이 유효한 정수가 아닙니다. 다시 입력해주세요.");
		            }
					
				}
				System.out.print("종료날짜를 입력해주세요(000000) : ");
				while(true) {
					String endDate= sc.next();
					// 길이가 6이 아니면 다시 반복문의 처음으로 돌아감
					 if (endDate.length() != 6) {
			                System.out.println("6글자 짜리 정수를 입력해주세요 : ");
			                continue; 
			            }
					
		            try {
		            	// 정상적으로 int로 변환되면 반복문 종료
		            	int numberIntDate =Integer.parseInt(endDate);
		                if(numberIntDate>=Integer.parseInt(searchThings)) {
		                	searchThings += "~"+endDate;
		                	break;
		                }else {
		                	System.out.print("종료일이 시작일보다 작습니다. 다시 입력해주세요 :");
		                	continue;
		                }
		            } catch (NumberFormatException e) {
		                // 변환에 실패한 경우 다시 입력 받기
		                System.out.print("입력한 값이 유효한 정수가 아닙니다. 다시 입력해주세요.");
		            }
					
				}
			}
		    Singleton s = Singleton.getInstance();
		    List<Integer> indexes = new ArrayList<>();

		    if (searchType == 1) { // 용도로 검색
		        for (int i = 0; i < s.accountList.size(); i++) {
		            AccountDto dto = s.accountList.get(i);
		            if (dto.getPerpose().contains(searchThings)) {
		            	indexes.add(i);
		            }
		        }
		    }else {
		    	 for (int i = 0; i < s.accountList.size(); i++) {
			            AccountDto dto = s.accountList.get(i);
			            String[] dates = searchThings.split("~");
			            int startDate = Integer.parseInt(dates[0]);
			            int endDate = Integer.parseInt(dates[1]);

			            if (dto.getDate()>=startDate || dto.getDate()<=endDate) {
			            	indexes.add(i);
			            }
			        }
		    }

		    return indexes;
		}
		
		
		// 확인
		public void allDataPrint() {
			
			
			Singleton s = Singleton.getInstance();
			
			if(s.accountList.isEmpty()) {	// addressList.size() == 0
				System.out.println("데이터 없습니다");
				return;
			}
			
			for (int i = 0; i < s.accountList.size(); i++) {
				System.out.println(s.accountList.get(i).toString());
			}
			
		}
}
