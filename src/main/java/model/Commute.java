package model;

import java.util.Date;

public class Commute {
	private String stf_id;
	private Date cmt_srt_tm;//출근시간
	private Date cmt_end_tm;//퇴근시간
	
	public String getStf_id() {
		return stf_id;
	}
	public void setStf_id(String stf_id) {
		this.stf_id = stf_id;
	}
	public Date getCmt_srt_tm() {
		return cmt_srt_tm;
	}
	public void setCmt_srt_tm(Date cmt_srt_tm) {
		this.cmt_srt_tm = cmt_srt_tm;
	}
	public Date getCmt_end_tm() {
		return cmt_end_tm;
	}
	public void setCmt_end_tm(Date cmt_end_tm) {
		this.cmt_end_tm = cmt_end_tm;
	}
	@Override
	public String toString() {
		return "commute [stf_id=" + stf_id + ", cmt_srt_tm=" + cmt_srt_tm + ", cmt_end_tm=" + cmt_end_tm + "]";
	}
}
