package kh.com.petbreedding.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Board {
	
	private String bo_num;
	private String bo_title;
	private String bo_cont;
	private String  bo_img;
	private Date bo_date; 
	private int bo_view;
	
	@Override
	public String toString() {
		return "Board [bo_num=" + bo_num + ", bo_title=" + bo_title + ", bo_cont=" + bo_cont + ", bo_img=" + bo_img
				+ ", bo_date=" + bo_date + ", bo_view=" + bo_view + "]";
	}

	public String getBo_num() {
		return bo_num;
	}

	public void setBo_num(String bo_num) {
		this.bo_num = bo_num;
	}

	public String getBo_title() {
		return bo_title;
	}

	public void setBo_title(String bo_title) {
		this.bo_title = bo_title;
	}

	public String getBo_cont() {
		return bo_cont;
	}

	public void setBo_cont(String bo_cont) {
		this.bo_cont = bo_cont;
	}

	public String getBo_img() {
		return bo_img;
	}

	public void setBo_img(String bo_img) {
		this.bo_img = bo_img;
	}

	public Date getBo_date() {
		return bo_date;
	}

	public void setBo_date(Date bo_date) {
		this.bo_date = bo_date;
	}

	public int getBo_view() {
		return bo_view;
	}

	public void setBo_view(int bo_view) {
		this.bo_view = bo_view;
	}
	
	
	
}
