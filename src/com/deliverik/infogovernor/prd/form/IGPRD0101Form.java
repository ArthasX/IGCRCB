/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;

/**
 * 流程定义查询画面Form
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGPRD0101Form extends BaseForm implements IG380SearchCond {

	/** 流程定义ID */
	protected String pdid;

	/** 流程定义名称 */
	protected String pdname;

	/** 流程定义状态 */
	protected String pdstatus;

	/** 流程模板ID */
	protected Integer ptid;
	
	/**普通流程与自定义流程模板ID集合**/
	protected Integer[] PrTypeArray;
	
	/**普通流程状态集合**/
	protected String[] pdstatuses;
	
	/** 流程日志权限 */
	protected String permission;

	/** 流程定义脚本 */
	protected FormFile xmlFile;
	
	/** 流程定义ID */
	protected String pdid_export;

	//===监管报表Begin
	/** 流程模板类型 */
	protected String pttype;
	
	/**
	 * 流程模板类型取得
	 *
	 * @return pttype 流程模板类型
	 */
	public String getPttype() {
		return pttype;
	}


	/**
	 * 流程模板类型设定
	 *
	 * @param pttype 流程模板类型
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}
	//===监管报表End

	/**
	 * 流程日志权限取得
	 * @return 流程日志权限
	 */
	public String getPermission() {
		return permission;
	}


	/**
	 * 流程日志权限设定
	  * @param permission 流程日志权限
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程定义名称取得
	 * 
	 * @return 流程定义名称
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * 流程定义名称设定
	 *
	 * @param pdname 流程定义名称
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * 流程定义状态取得
	 * 
	 * @return 流程定义状态
	 */
	public String getPdstatus() {
		return pdstatus;
	}

	/**
	 * 流程定义状态设定
	 *
	 * @param pdstatus 流程定义状态
	 */
	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}

	/**
	 * 流程模板ID取得
	 * 
	 * @return 流程模板ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程模板ID设定
	 *
	 * @param ptid 流程模板ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public Integer getNotSelfPd() {
		// TODO Auto-generated method stub
		return null;
	}


	public String[] getPdstatuses() {
		return pdstatuses;
	}

	public void setPdstatuses(String[] pdstatuses) {
		this.pdstatuses = pdstatuses;
	}

	public Integer[] getPrTypeArray() {
		return PrTypeArray;
	}

	public void setPrTypeArray(Integer[] prTypeArray) {
		PrTypeArray = prTypeArray;
	}

	public String getPdid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 流程定义脚本取得
	 * 
	 * @return 流程定义脚本
	 */
	public FormFile getXmlFile() {
		return xmlFile;
	}

	/**
	 * 流程定义脚本设定
	 * 
	 * @param xmlFile 流程定义脚本
	 */
	public void setXmlFile(FormFile xmlFile) {
		this.xmlFile = xmlFile;
	}
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid_export() {
		return pdid_export;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param pdid_export 流程定义ID
	 */
	public void setPdid_export(String pdid_export) {
		this.pdid_export = pdid_export;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.xmlFile = null;
		this.pdid_export = null;
	}


	public String[] getPrpdid_like_or() {
		// TODO Auto-generated method stub
		return null;
	}


	public String[] getPdid_in() {
		// TODO Auto-generated method stub
		return null;
	}


	public String[] getPdid_not_in() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getActname() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
