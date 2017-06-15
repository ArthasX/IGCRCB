package com.deliverik.infogovernor.prm.form;

import java.text.SimpleDateFormat;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG380Info;

public class IGPRM0202Form extends BaseForm implements IG380Info {

	private static final long serialVersionUID = 1L;
	private String pdid;
	private Integer ptid;
	private String pdname;
	private String pddesc;
	private String pdcrtdate;
	private String pdstatus;
	private String pdxml;
	private String pdactname;
	
	/** 工单号生成器 */
	protected String serialgenerator;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public Integer getPtid() {
		return ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public String getPdname() {
		return pdname;
	}

	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	public String getPddesc() {
		return pddesc;
	}

	public void setPddesc(String pddesc) {
		this.pddesc = pddesc;
	}

	public String getPdcrtdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		pdcrtdate = sdf.format(System.currentTimeMillis());
		return pdcrtdate;
	}

	public String getPdstatus() {
		return pdstatus;
	}

	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getPdxml() {
		return pdxml;
	}

	public void setPdxml(String pdxml) {
		this.pdxml = pdxml;
	}

	public void setPdcrtdate(String pdcrtdate) {
		this.pdcrtdate = pdcrtdate;
	}

	public String getPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 工单号生成器取得
	 * 
	 * @return 工单号生成器
	 */
	public String getSerialgenerator() {
		return serialgenerator;
	}

	/**
	 * 工单号生成器设定
	 * 
	 * @param serialgenerator 工单号生成器
	 */
	public void setSerialgenerator(String serialgenerator) {
		this.serialgenerator = serialgenerator;
	}

    /**
     * @return the pdactname
     */
    public String getPdactname() {
        return pdactname;
    }

    /**
     * @param pdactname the pdactname to set
     */
    public void setPdactname(String pdactname) {
        this.pdactname = pdactname;
    }

	public String getReportdesc() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessagegenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPdservicecatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPdserialnumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPdservicecatalogname() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
