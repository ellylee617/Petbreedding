package kh.com.petbreedding.bmypage.model.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HairSalon {

	private String harNum; // 미용실 번호
	private String bpId; // 사업자 고객번호
	private String shopName; // 미용실 이름
	private String shopAddr; // 미용실 주소
	private String y; // y좌표
	private String x; // x좌표
	private String shopTel; // 미용실 전화번호
	private String shopTime; // 미용실 영업시간
	private String shopMInfo; // 미용실 메인 소개

	private Style style;

	private List<HairSalonImg> shopImgList; // 미용실 대표사진들. 미용실 하나가 여러 개의 사진을 가짐.
	private List<String> shopDayOffList; // 미용실 주휴일

	
	
	@Override
	public String toString() {
		return "HairSalon [harNum=" + harNum + ", bpId=" + bpId + ", shopName=" + shopName + ", shopAddr=" + shopAddr
				+ ", y=" + y + ", x=" + x + ", shopTel=" + shopTel + ", shopTime=" + shopTime + ", shopMInfo="
				+ shopMInfo + ", style=" + style + ", shopImgList=" + shopImgList + ", shopDayOffList=" + shopDayOffList
				+ "]";
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



	public String getHarNum() {
		return harNum;
	}

	public void setHarNum(String harNum) {
		this.harNum = harNum;
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

	public List<HairSalonImg> getShopImgList() {
		return shopImgList;
	}

	public void setShopImgList(List<HairSalonImg> shopImgList) {
		this.shopImgList = shopImgList;
	}

	public List<String> getShopDayOffList() {
		return shopDayOffList;
	}

	public void setShopDayOffList(List<String> shopDayOffList) {
		this.shopDayOffList = shopDayOffList;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

}

//
///* HAIR_SALON 테이블 */
//CREATE TABLE HAIR_SALON (
//    HAR_NUM VARCHAR2(20) CONSTRAINT HAIR_SALON_HAR_NUM_PK PRIMARY KEY,
//    BP_ID VARCHAR2(20) CONSTRAINT HAIR_SALON_BP_ID_FK REFERENCES BUSINESS_PARTNER ON DELETE CASCADE NOT NULL,
//    HAR_NAME VARCHAR2(20) NOT NULL,
//    HAR_ADDR VARCHAR2(300) NOT NULL,
//    HAR_TEL VARCHAR2(20) NOT NULL,
//    HOPEN_TIME VARCHAR2(100),
//    HAR_MINFO VARCHAR2(500),
//    HAR_DINFO VARCHAR2(500),
//    HAR_CLICK NUMBER(7) NOT NULL
//);
