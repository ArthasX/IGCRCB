/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.ProjectPlan;

public class ProjectPlanForm extends BaseForm implements ProjectPlan , ProjectLog {
	private static final long serialVersionUID = 1L;
	private Integer plid;
	private Integer pid;
	private Integer pplid;
	private String popentime;
	private String pclosetime;
	private String ppltitle;
	private String pplclosetime;
	private String pplopentime;
	protected String pplshuttime;
	private String[] projectPlanTitle;
	private String[] projectPlanTime;
	private String[] projectPlanDesc;
	private String[] confirmDesc;
	private String[] confirmTime;
	
	private String pplstatus;
	private Integer pplversion;
	private String pplinfo;
	private String ppldesc;
	private String[] pplInfoStatus;
	
	private String siattkey;
	private String pltype;
	private String plinfo;
	
	/**
	 * 附件
	 * @return
	 */
	protected String pplriskatt;
	
	/**附件LIST */
	protected List<Attachment> attachmentList;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	public String[] getProjectPlanDesc() {
		return projectPlanDesc;
	}

	public void setProjectPlanDesc(String[] projectPlanDesc) {
		this.projectPlanDesc = projectPlanDesc;
	}

	public String[] getConfirmDesc() {
		return confirmDesc;
	}

	public void setConfirmDesc(String[] confirmDesc) {
		this.confirmDesc = confirmDesc;
	}

	public String[] getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(String[] confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String[] getPplInfoStatus() {
		return pplInfoStatus;
	}

	public void setPplInfoStatus(String[] pplInfoStatus) {
		this.pplInfoStatus = pplInfoStatus;
	}
	
	public void setPlinfo(String plinfo) {
		this.plinfo = plinfo;
	}

	public void setPltype(String pltype) {
		this.pltype = pltype;
	}

	public void setPpldesc(String ppldesc) {
		this.ppldesc = ppldesc;
	}	
	
	public String getPplinfo() {
		return pplinfo;
	}

	public void setPplinfo(String pplinfo) {
		this.pplinfo = pplinfo;
	}

	public void setPplversion(Integer pplversion) {
		this.pplversion = pplversion;
	}

	public void setPplstatus(String pplstatus) {
		this.pplstatus = pplstatus;
	}

	public Integer getPlid() {
		return plid;
	}

	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPopentime() {
		return popentime;
	}

	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}

	public String getPclosetime() {
		return pclosetime;
	}

	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}

	public String[] getProjectPlanTitle() {
		return projectPlanTitle;
	}

	public void setProjectPlanTitle(String[] projectPlanTitle) {
		this.projectPlanTitle = projectPlanTitle;
	}

	public String[] getProjectPlanTime() {
		return projectPlanTime;
	}

	public void setProjectPlanTime(String[] projectPlanTime) {
		this.projectPlanTime = projectPlanTime;
	}

	public void setPplid(Integer pplid) {
		this.pplid = pplid;
	}
	
	public String getPpldate() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis() + "";
	}

	public String getPpldesc() {
		// TODO Auto-generated method stub
		return ppldesc;
	}

	public Integer getPplid() {
		// TODO Auto-generated method stub
		return pplid;
	}


	public String getPplstatus() {
		// TODO Auto-generated method stub
		return pplstatus;
	}

	public Integer getPplversion() {
		// TODO Auto-generated method stub
		return pplversion;
	}

	public String getPlattkey() {
		// TODO Auto-generated method stub
		return siattkey;
	}

	public String getPlinfo() {
		// TODO Auto-generated method stub
		return plinfo;
	}

	public Integer getPlroleid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPlrolename() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPltime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPltype() {
		// TODO Auto-generated method stub
		return pltype;
	}

	public String getPluserid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPlusername() {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getPpltitle() {
		return ppltitle;
	}

	public void setPpltitle(String ppltitle) {
		this.ppltitle = ppltitle;
	}

	public String getPplclosetime() {
		return pplclosetime;
	}

	public void setPplclosetime(String pplclosetime) {
		this.pplclosetime = pplclosetime;
	}
	
	public String getPplopentime() {
		return pplopentime;
	}

	public void setPplopentime(String pplopentime) {
		this.pplopentime = pplopentime;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
	public String getPplriskatt() {
		return pplriskatt;
	}

	public void setPplriskatt(String pplriskatt) {
		this.pplriskatt = pplriskatt;
	}

	/**
	 * 附件数据取得
	 * @return 附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}
	
	/**
	 * 设置附件数据
	 *
	 * @param index 附件数组索引
	 * @param file 附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}

	/**
	 * 获取附件Map
	 * @return 附件Map
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}
	
	/**
	 * 附件取得
	 * 
	 * @return 附件
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	public String getPplshuttime() {
		return pplshuttime;
	}

	public void setPplshuttime(String pplshuttime) {
		this.pplshuttime = pplshuttime;
	}
	
	
}
