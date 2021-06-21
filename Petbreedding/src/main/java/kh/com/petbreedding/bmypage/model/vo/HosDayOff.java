package kh.com.petbreedding.bmypage.model.vo;

public class HosDayOff {

	private String hosNumDayOff; // 동물병원번호
	private String shopDayOff; // 동물병원주휴일
	
	
	@Override
	public String toString() {
		return "HosDayOff [hosNumDayOff=" + hosNumDayOff + ", shopDayOff=" + shopDayOff + "]";
	}
	public String getHosNumDayOff() {
		return hosNumDayOff;
	}
	public void setHosNumDayOff(String hosNumDayOff) {
		this.hosNumDayOff = hosNumDayOff;
	}
	public String getShopDayOff() {
		return shopDayOff;
	}
	public void setShopDayOff(String shopDayOff) {
		this.shopDayOff = shopDayOff;
	}
	
	
}
