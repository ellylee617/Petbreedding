package kh.com.petbreedding.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class B_comment {
	
	private String co_num;
	private String bo_num;
	private String cl_nickname;
	private String co_cont;
	private Date co_date;
	
	@Override
	public String toString() {
		return "B_comment [co_num=" + co_num + ", bo_num=" + bo_num + ", cl_nickname=" + cl_nickname + ", co_cont="
				+ co_cont + ", co_date=" + co_date + "]";
	}
	public String getCo_num() {
		return co_num;
	}
	public void setCo_num(String co_num) {
		this.co_num = co_num;
	}
	public String getBo_num() {
		return bo_num;
	}
	public void setBo_num(String bo_num) {
		this.bo_num = bo_num;
	}
	public String getCl_nickname() {
		return cl_nickname;
	}
	public void setCl_nickname(String cl_nickname) {
		this.cl_nickname = cl_nickname;
	}
	public String getCo_cont() {
		return co_cont;
	}
	public void setCo_cont(String co_cont) {
		this.co_cont = co_cont;
	}
	public Date getCo_date() {
		return co_date;
	}
	public void setCo_date(Date co_date) {
		this.co_date = co_date;
	}
	
	
}
