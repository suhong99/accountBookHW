package dto;

public class AccountDto {
	//가계부 한 개 데이터
	//날짜 용도 수입/지출/ 금액 /내용
	private int date; //날짜
	private String purpose; // 용도
	private String incomeOrNot;//수입 지출
	private int price;//가격
	private String details; //내용
	
	public AccountDto() {
		
	}
	

	public AccountDto(int date, String perpose, String incomeOrNot, int price, String details) {
		super();
		this.date = date;
		this.purpose = perpose;
		this.incomeOrNot = incomeOrNot;
		this.price = price;
		this.details = details;
	}


	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getPerpose() {
		return purpose;
	}

	public void setPerpose(String perpose) {
		this.purpose = perpose;
	}

	public String getIncomeOrNot() {
		return incomeOrNot;
	}

	public void setIncomeOrNot(String incomeOrNot) {
		this.incomeOrNot = incomeOrNot;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "AccountDto [날짜=" + date + ", 용도=" + purpose + ", 수입/지출=" + incomeOrNot + ", 금액=" + price
				+ ", 내용=" + details + "]";
	}
	
	public String print() {
		return date + "-" + purpose + "-" + incomeOrNot + "-" + price + "-" + details;
	}
	
	
}
