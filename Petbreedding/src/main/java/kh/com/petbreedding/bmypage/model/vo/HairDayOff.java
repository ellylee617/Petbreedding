package kh.com.petbreedding.bmypage.model.vo;

public class HairDayOff {

	private String harNumDayOff; // 미용실번호
	private String shopDayOff; // 미용실주휴일
	@Override
	public String toString() {
		return "HairDayOff [harNumDayOff=" + harNumDayOff + ", shopDayOff=" + shopDayOff + "]";
	}
	public String getHarNumDayOff() {
		return harNumDayOff;
	}
	public void setHarNumDayOff(String harNumDayOff) {
		this.harNumDayOff = harNumDayOff;
	}
	public String getShopDayOff() {
		return shopDayOff;
	}
	public void setShopDayOff(String shopDayOff) {
		this.shopDayOff = shopDayOff;
	}
	
	
	
}
