package kh.com.petbreedding.board.model.vo;


import org.springframework.stereotype.Component;

@Component
public class B_comment {
	
	private String coNum;
	private String boNum;
	private String clNickName;
	private String coCont;
	private String coDate;
	
	@Override
	public String toString() {
		return "B_comment [coNum=" + coNum + ", boNum=" + boNum + ", clNickName=" + clNickName + ", coCont=" + coCont
				+ ", coDate=" + coDate + "]";
	}

	public String getCoNum() {
		return coNum;
	}

	public void setCoNum(String coNum) {
		this.coNum = coNum;
	}

	public String getBoNum() {
		return boNum;
	}

	public void setBoNum(String boNum) {
		this.boNum = boNum;
	}

	public String getClNickName() {
		return clNickName;
	}

	public void setClNickName(String clNickName) {
		this.clNickName = clNickName;
	}

	public String getCoCont() {
		return coCont;
	}

	public void setCoCont(String coCont) {
		this.coCont = coCont;
	}

	public String getCoDate() {
		return coDate;
	}

	public void setCoDate(String coDate) {
		this.coDate = coDate;
	}
	
	
}
