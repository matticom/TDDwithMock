package fit_ness;

import Euro.Euro;

public class Movie {

	private String title;
	private IPrice price;
	private int number;
	
	

	public Movie() {
	}
	
	public Movie(int number, String title, IPrice price) {
		this.number = number;
		this.title = title;
		this.price = price;
	}

	public void setPrice(IPrice price) {
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getTitle() {
		return title;
	}

	public Euro getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}
}