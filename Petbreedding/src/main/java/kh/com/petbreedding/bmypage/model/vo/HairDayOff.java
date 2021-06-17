package kh.com.petbreedding.bmypage.model.vo;

public class HairDayOff {

	private String harNum; // 미용실번호
	private String harDayOff; // 미용실주휴일
	
	@Override
	public String toString() {
		return "hairDayOff [harNum=" + harNum + ", harDayOff=" + harDayOff + "]";
	}

	public String getHarNum() {
		return harNum;
	}

	public void setHarNum(String harNum) {
		this.harNum = harNum;
	}

	public String getHarDayOff() {
		return harDayOff;
	}

	public void setHarDayOff(String harDayOff) {
		this.harDayOff = harDayOff;
	}

	
	
}
