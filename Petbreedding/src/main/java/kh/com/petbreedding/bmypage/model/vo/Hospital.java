package kh.com.petbreedding.bmypage.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Hospital {
	
	private String hosNum;	// 동물병원 번호
	private String bpId;	// 사업자 고객번호
	private String shopName;	// 동물병원 이름
	private String shopAddr;	// 동물병원 주소
	private String y; // y좌표
	private String x; // x좌표	
	private String shopTel;	// 동물병원 전화번호
	private String shopTime;	//동물병원영업시간
	private String shopMInfo;	// 동물병원 메인 소개
	private String hosConn;		// 동물병원 채팅 접속여부
	private String hosClick;	// 동물병원 잔여 클릭수
	
	


	


	@Override
	public String toString() {
		return "Hospital [hosNum=" + hosNum + ", bpId=" + bpId + ", shopName=" + shopName + ", shopAddr=" + shopAddr
				+ ", y=" + y + ", x=" + x + ", shopTel=" + shopTel + ", shopTime=" + shopTime + ", shopMInfo="
				+ shopMInfo + ", hosConn=" + hosConn + ", hosClick=" + hosClick + "]";
	}


	public String getY() {
		return y;
	}


	public void setY(String y) {
		this.y = y;
	}


	public String getX() {
		return x;
	}


	public void setX(String x) {
		this.x = x;
	}


	public String getHosNum() {
		return hosNum;
	}

	public void setHosNum(String hosNum) {
		this.hosNum = hosNum;
	}

	public String getBpId() {
		return bpId;
	}

	public void setBpId(String bpId) {
		this.bpId = bpId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getShopTel() {
		return shopTel;
	}

	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	public String getShopTime() {
		return shopTime;
	}

	public void setShopTime(String shopTime) {
		this.shopTime = shopTime;
	}

	public String getShopMInfo() {
		return shopMInfo;
	}

	public void setShopMInfo(String shopMInfo) {
		this.shopMInfo = shopMInfo;
	}

	public String getHosConn() {
		return hosConn;
	}

	public void setHosConn(String hosConn) {
		this.hosConn = hosConn;
	}

	public String getHosClick() {
		return hosClick;
	}

	public void setHosClick(String hosClick) {
		this.hosClick = hosClick;
	}
	
	
	

	
	
}


///* HOSPITAL 테이블 */
//CREATE TABLE HOSPITAL (
//    HOS_NUM VARCHAR2(20) CONSTRAINT HOSPITAL_HOS_NUM_PK PRIMARY KEY,
//    BP_ID VARCHAR2(20) CONSTRAINT HOSPITAL_BP_ID_FK REFERENCES BUSINESS_PARTNER
//    ON DELETE CASCADE NOT NULL,
//    HOS_NAME VARCHAR2(20) NOT NULL,
//    HOS_ADDR VARCHAR2(300) NOT NULL,
//    HOS_TEL VARCHAR2(20) NOT NULL,
//    OPEN_TIME VARCHAR2(20),
//    HOS_MINFO VARCHAR2(500),
//    HOS_DINFO VARCHAR2(500),
//    HOS_CONN NUMBER(1),
//    HOS_CLICK NUMBER(7) DEFAULT 0 NOT NULL
//);
