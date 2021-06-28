package kh.com.petbreedding.Shop.model.vo;

public class HospitalReservation {
	private String hos_rnum; 	//동물병원 예약번호
	private String pet_num;		//펫번호
	private String msg_num;		//알림번호
	private String cl_num;		//고객번호
	private String med_num;		//예약메뉴번호
	private String hos_num;		//동물병원 번호
	private String hos_date;	//예약날짜
	private String hos_date2;	//예약 검색날짜
	private int hos_status; 	//예약 상태
	private String hos_time; 	//예약 시간
	
	@Override
	public String toString() {
		return "HospitalReservation [hos_rnum=" + hos_rnum + ", pet_num=" + pet_num + ", msg_num=" + msg_num
				+ ", cl_num=" + cl_num + ", med_num=" + med_num + ", hos_num=" + hos_num + ", hos_date=" + hos_date
				+ ", hos_date2=" + hos_date2 + ", hos_status=" + hos_status + ", hos_time=" + hos_time + "]";
	}
	public String getHos_rnum() {
		return hos_rnum;
	}
	public void setHos_rnum(String hos_rnum) {
		this.hos_rnum = hos_rnum;
	}
	public String getPet_num() {
		return pet_num;
	}
	public void setPet_num(String pet_num) {
		this.pet_num = pet_num;
	}
	public String getMsg_num() {
		return msg_num;
	}
	public void setMsg_num(String msg_num) {
		this.msg_num = msg_num;
	}
	public String getCl_num() {
		return cl_num;
	}
	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}
	public String getMed_num() {
		return med_num;
	}
	public void setMed_num(String med_num) {
		this.med_num = med_num;
	}
	public String getHos_num() {
		return hos_num;
	}
	public void setHos_num(String hos_num) {
		this.hos_num = hos_num;
	}
	public String getHos_date() {
		return hos_date;
	}
	public void setHos_date(String hos_date) {
		this.hos_date = hos_date;
	}
	public String getHos_date2() {
		return hos_date2;
	}
	public void setHos_date2(String hos_date2) {
		this.hos_date2 = hos_date2;
	}
	public int getHos_status() {
		return hos_status;
	}
	public void setHos_status(int hos_status) {
		this.hos_status = hos_status;
	}
	public String getHos_time() {
		return hos_time;
	}
	public void setHos_time(String hos_time) {
		this.hos_time = hos_time;
	}
	
	
	
}
