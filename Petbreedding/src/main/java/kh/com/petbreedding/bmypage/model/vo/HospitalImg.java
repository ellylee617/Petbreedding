package kh.com.petbreedding.bmypage.model.vo;

public class HospitalImg {
	
	private String imgNum; // 이미지 번호 
	private String hosNumImg;	// 동물병원 번호
	private String shopImg;	// 미용실 매장 이미지 (파일명)
	
	
	@Override
	public String toString() {
		return "HospitalImg [imgNum=" + imgNum + ", hosNumImg=" + hosNumImg + ", shopImg=" + shopImg + "]";
	}
	
	public String getImgNum() {
		return imgNum;
	}
	public void setImgNum(String imgNum) {
		this.imgNum = imgNum;
	}
	public String getHosNumImg() {
		return hosNumImg;
	}
	public void setHosNumImg(String hosNumImg) {
		this.hosNumImg = hosNumImg;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	
	
	
}
