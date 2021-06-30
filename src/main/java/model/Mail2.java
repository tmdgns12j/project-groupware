package model;

import java.util.Date;

public class Mail2 {
 
	private int MAIL_NUM;
	private String MAIL_CONTENT;
	private String MAIL_PL_NM;
	private String MAIL_PL_CRS;
	private String STF_SND_ID;
	private Date RCV_DT;
	private String STF_RCV_ID;
	private Date SND_DT;
	private int MAIL_READ;
	private String hidden;
	private String hidden1;
	
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String getHidden1() {
		return hidden1;
	}
	public void setHidden1(String hidden1) {
		this.hidden1 = hidden1;
	}
	public int getMAIL_NUM() {
		return MAIL_NUM;
	}
	public void setMAIL_NUM(int mAIL_NUM) {
		MAIL_NUM = mAIL_NUM;
	} 
	public String getMAIL_CONTENT() {
		return MAIL_CONTENT;
	}
	public void setMAIL_CONTENT(String mAIL_CONTENT) {
		MAIL_CONTENT = mAIL_CONTENT;
	}
	public String getMAIL_PL_NM() {
		return MAIL_PL_NM;
	}
	public void setMAIL_PL_NM(String mAIL_PL_NM) {
		MAIL_PL_NM = mAIL_PL_NM;
	}
	public String getMAIL_PL_CRS() {
		return MAIL_PL_CRS;
	}
	public void setMAIL_PL_CRS(String mAIL_PL_CRS) {
		MAIL_PL_CRS = mAIL_PL_CRS;
	}
	public String getSTF_SND_ID() {
		return STF_SND_ID;
	}
	public void setSTF_SND_ID(String sTF_SND_ID) {
		STF_SND_ID = sTF_SND_ID;
	}
	public Date getRCV_DT() {
		return RCV_DT;
	}
	public void setRCV_DT(Date rCV_DT) {
		RCV_DT = rCV_DT;
	}
	public String getSTF_RCV_ID() {
		return STF_RCV_ID;
	}
	public void setSTF_RCV_ID(String sTF_RCV_ID) {
		STF_RCV_ID = sTF_RCV_ID;
	}
	public Date getSND_DT() {
		return SND_DT;
	}
	public void setSND_DT(Date sND_DT) {
		SND_DT = sND_DT;
	}
	public int getMAIL_READ() {
		return MAIL_READ;
	}
	public void setMAIL_READ(int mAIL_READ) {
		MAIL_READ = mAIL_READ;
	}
	@Override
	public String toString() {
		return "Mail [MAIL_NUM=" + MAIL_NUM + ", MAIL_CONTENT=" + MAIL_CONTENT + ", MAIL_PL_NM=" + MAIL_PL_NM
				+ ", MAIL_PL_CRS=" + MAIL_PL_CRS + ", STF_SND_ID=" + STF_SND_ID + ", RCV_DT=" + RCV_DT + ", STF_RCV_ID="
				+ STF_RCV_ID + ", SND_DT=" + SND_DT + ", MAIL_READ=" + MAIL_READ + ", hidden=" + hidden + ", hidden1="
				+ hidden1 + "]";
	}
	


}