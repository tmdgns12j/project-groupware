package model;

import java.util.Date;

public class Letter {
	private int EML_SQ;//편지번호
	private String EML_CNT;
	private String EML_PL_NM;
	private String EML_PL_CRS;
	private String STF_SND_ID;
	private Date RCV_DT;
	private String STF_RCV_ID;
	private Date SND_DT;
	private String hidden;
	private String hidden1;
	
	private int EML_READ;//eml_read
	private int ref;
	private int reflevel;
	private int refstep;
	public int getEML_SQ() {
		return EML_SQ;
	}
	public void setEML_SQ(int eML_SQ) {
		EML_SQ = eML_SQ;
	}
	public String getEML_CNT() {
		return EML_CNT;
	}
	public void setEML_CNT(String eML_CNT) {
		EML_CNT = eML_CNT;
	}
	public String getEML_PL_NM() {
		return EML_PL_NM;
	}
	public void setEML_PL_NM(String eML_PL_NM) {
		EML_PL_NM = eML_PL_NM;
	}
	public String getEML_PL_CRS() {
		return EML_PL_CRS;
	}
	public void setEML_PL_CRS(String eML_PL_CRS) {
		EML_PL_CRS = eML_PL_CRS;
	}
	public String getSTF_SND_ID() {
		return STF_SND_ID;
	}
	public void setSTF_SND_ID(String sTF_SND_SQ) {
		STF_SND_ID = sTF_SND_SQ;
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
	public void setSTF_RCV_ID(String sTF_RCV_SQ) {
		STF_RCV_ID = sTF_RCV_SQ;
	}
	public Date getSND_DT() {
		return SND_DT;
	}
	public void setSND_DT(Date sND_DT) {
		SND_DT = sND_DT;
	}
	public int getEML_READ() {
		return EML_READ;
	}
	public void setEML_READ(int eML_READ) {
		EML_READ = eML_READ;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getReflevel() {
		return reflevel;
	}
	public void setReflevel(int reflevel) {
		this.reflevel = reflevel;
	}
	public int getRefstep() {
		return refstep;
	}
	public void setRefstep(int refstep) {
		this.refstep = refstep;
	}
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
	@Override
	public String toString() {
		return "Letter [EML_SQ=" + EML_SQ + ", EML_CNT=" + EML_CNT + ", EML_PL_NM=" + EML_PL_NM + ", EML_PL_CRS="
				+ EML_PL_CRS + ", STF_SND_ID=" + STF_SND_ID + ", RCV_DT=" + RCV_DT + ", STF_RCV_ID=" + STF_RCV_ID
				+ ", SND_DT=" + SND_DT + ", hidden=" + hidden + ", hidden1=" + hidden1 + ", EML_READ=" + EML_READ
				+ ", ref=" + ref + ", reflevel=" + reflevel + ", refstep=" + refstep + "]";
	}
		
}
