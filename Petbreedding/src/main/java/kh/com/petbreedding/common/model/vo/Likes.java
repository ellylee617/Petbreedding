package kh.com.petbreedding.common.model.vo;

public class Likes {

	private String like_num;
	private String cl_num;
	private String har_num;
	private String hos_num;
	
	@Override
	public String toString() {
		return "Likes [like_num=" + like_num + ", cl_num=" + cl_num + ", har_num=" + har_num + ", hos_num=" + hos_num
				+ "]";
	}
	public String getLike_num() {
		return like_num;
	}
	public String getCl_num() {
		return cl_num;
	}
	public String getHar_num() {
		return har_num;
	}
	public String getHos_num() {
		return hos_num;
	}
	public void setLike_num(String like_num) {
		this.like_num = like_num;
	}
	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}
	public void setHar_num(String har_num) {
		this.har_num = har_num;
	}
	public void setHos_num(String hos_num) {
		this.hos_num = hos_num;
	}
	
	
}
