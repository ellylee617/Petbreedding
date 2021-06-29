package kh.com.petbreedding.board.model.vo;

//QNAC_NUM  NOT NULL VARCHAR2(10)   
//ADMIN_ID           VARCHAR2(50)   
//QNA_NUM            VARCHAR2(50)   
//QNAC_CONT          VARCHAR2(1000) 
//QNAC_DATE          VARCHAR2(20)

public class MyAskComment {
	private String qnacNum;
	private String adminId;
	private String qndNum;
	private String qnacCont;
	private String qnacDate;
	
	@Override
	public String toString() {
		return "MyAskComment [qnacNum=" + qnacNum + ", adminId=" + adminId + ", qndNum=" + qndNum + ", qnacCont="
				+ qnacCont + ", qnacDate=" + qnacDate + "]";
	}

	public String getQnacNum() {
		return qnacNum;
	}

	public void setQnacNum(String qnacNum) {
		this.qnacNum = qnacNum;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getQndNum() {
		return qndNum;
	}

	public void setQndNum(String qndNum) {
		this.qndNum = qndNum;
	}

	public String getQnacCont() {
		return qnacCont;
	}

	public void setQnacCont(String qnacCont) {
		this.qnacCont = qnacCont;
	}

	public String getQnacDate() {
		return qnacDate;
	}

	public void setQnacDate(String qnacDate) {
		this.qnacDate = qnacDate;
	}
	
	
}
