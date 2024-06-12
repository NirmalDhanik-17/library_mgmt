package library_project;

import java.math.BigDecimal;

public class Fine
{
	private int fine_id;
    private int user_id;
    private BigDecimal amount;
    private String reason;
    private boolean paid;
    
	public Fine() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fine(int fine_id, int user_id, BigDecimal amount, String reason, boolean paid) {
		super();
		this.fine_id = fine_id;
		this.user_id = user_id;
		this.amount = amount;
		this.reason = reason;
		this.paid = paid;
	}
	public int getFine_id() {
		return fine_id;
	}
	public void setFine_id(int fine_id) {
		this.fine_id = fine_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}  
}
