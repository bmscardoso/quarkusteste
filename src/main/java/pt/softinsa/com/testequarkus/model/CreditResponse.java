package pt.softinsa.com.testequarkus.model;

public class CreditResponse{

	private int creditDuration;
	private String clientName;
	private double monthlyPayment;
	private int amountBorrowed;
	private boolean isCreditAproved;

	public CreditResponse() {
	}

	public int getCreditDuration() {
		return creditDuration;
	}

	public void setCreditDuration(int creditDuration) {
		this.creditDuration = creditDuration;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public int getAmountBorrowed() {
		return amountBorrowed;
	}

	public void setAmountBorrowed(int amountBorrowed) {
		this.amountBorrowed = amountBorrowed;
	}

	public boolean isCreditAproved() {
		return isCreditAproved;
	}

	public void setCreditAproved(boolean creditAproved) {
		isCreditAproved = creditAproved;
	}
}