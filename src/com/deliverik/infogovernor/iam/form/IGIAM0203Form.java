/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
 * @author zhaomin
 *
 */
/**
 * 概述: 内审工作管理修改、删除form
 * 功能描述：内审工作管理修改、删除
 * 创建人：赵敏
 * 创建记录： 2012-7-26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGIAM0203Form extends BaseForm  implements Serializable {

	/** 主键 */
	protected Integer iajid;

	/** 计划年度 */
	protected String iajyear;

	/** 内置项目ID */
	protected Integer iajiapid;

	/** 工作名称 */
	protected String iajname;

	/** 实际工作开始日期 */
	protected String iajstarttime;

	/** 实际工作结束日期 */
	protected String iajovertime;

	/** 工作内容描述 */
	protected String iajdesc;

	/** 登记时间 */
	protected String iajinserttime;

	/** 附件 */
	protected String iajattkey;

	/** 登记人ID */
	protected String iajuserid;
	
	/** 内审项目信息实体 */
	protected  InternalauditprjTB internalauditprjTB;
	
	/** 将要删除的附件id串*/
	protected String deletekeys;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap = null;
	
	/**
	 * 获取deletekeys
	 * @return fdeletekeys deletekeys
	 */
	public String getDeletekeys() {
		return deletekeys;
	}

	/**
	 * 设置deletekeys
	 * @param deletekeys  deletekeys
	 */
	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}

	/**
	 * 获取iajid
	 * @return fiajid iajid
	 */
	public Integer getIajid() {
		return iajid;
	}

	/**
	 * 设置iajid
	 * @param iajid  iajid
	 */
	public void setIajid(Integer iajid) {
		this.iajid = iajid;
	}

	/**
	 * 获取iajyear
	 * @return fiajyear iajyear
	 */
	public String getIajyear() {
		return iajyear;
	}

	/**
	 * 设置iajyear
	 * @param iajyear  iajyear
	 */
	public void setIajyear(String iajyear) {
		this.iajyear = iajyear;
	}

	/**
	 * 获取iajiapid
	 * @return fiajiapid iajiapid
	 */
	public Integer getIajiapid() {
		return iajiapid;
	}

	/**
	 * 设置iajiapid
	 * @param iajiapid  iajiapid
	 */
	public void setIajiapid(Integer iajiapid) {
		this.iajiapid = iajiapid;
	}

	/**
	 * 获取iajname
	 * @return fiajname iajname
	 */
	public String getIajname() {
		return iajname;
	}

	/**
	 * 设置iajname
	 * @param iajname  iajname
	 */
	public void setIajname(String iajname) {
		this.iajname = iajname;
	}

	/**
	 * 获取iajstarttime
	 * @return fiajstarttime iajstarttime
	 */
	public String getIajstarttime() {
		return iajstarttime;
	}

	/**
	 * 设置iajstarttime
	 * @param iajstarttime  iajstarttime
	 */
	public void setIajstarttime(String iajstarttime) {
		this.iajstarttime = iajstarttime;
	}

	/**
	 * 获取iajovertime
	 * @return fiajovertime iajovertime
	 */
	public String getIajovertime() {
		return iajovertime;
	}

	/**
	 * 设置iajovertime
	 * @param iajovertime  iajovertime
	 */
	public void setIajovertime(String iajovertime) {
		this.iajovertime = iajovertime;
	}

	/**
	 * 获取iajdesc
	 * @return fiajdesc iajdesc
	 */
	public String getIajdesc() {
		return iajdesc;
	}

	/**
	 * 设置iajdesc
	 * @param iajdesc  iajdesc
	 */
	public void setIajdesc(String iajdesc) {
		this.iajdesc = iajdesc;
	}

	/**
	 * 获取iajinserttime
	 * @return fiajinserttime iajinserttime
	 */
	public String getIajinserttime() {
		return iajinserttime;
	}

	/**
	 * 设置iajinserttime
	 * @param iajinserttime  iajinserttime
	 */
	public void setIajinserttime(String iajinserttime) {
		this.iajinserttime = iajinserttime;
	}

	/**
	 * 获取iajattkey
	 * @return fiajattkey iajattkey
	 */
	public String getIajattkey() {
		return iajattkey;
	}

	/**
	 * 设置iajattkey
	 * @param iajattkey  iajattkey
	 */
	public void setIajattkey(String iajattkey) {
		this.iajattkey = iajattkey;
	}

	/**
	 * 获取iajuserid
	 * @return fiajuserid iajuserid
	 */
	public String getIajuserid() {
		return iajuserid;
	}

	/**
	 * 设置iajuserid
	 * @param iajuserid  iajuserid
	 */
	public void setIajuserid(String iajuserid) {
		this.iajuserid = iajuserid;
	}


	/**
	 * 获取internalauditprjTB
	 * @return finternalauditprjTB internalauditprjTB
	 */
	public InternalauditprjTB getInternalauditprjTB() {
		return internalauditprjTB;
	}

	/**
	 * 设置internalauditprjTB
	 * @param internalauditprjTB  internalauditprjTB
	 */
	public void setInternalauditprjTB(InternalauditprjTB internalauditprjTB) {
		this.internalauditprjTB = internalauditprjTB;
	}
	
	/**
	 * 获取fileMap
	 * @return ffileMap fileMap
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * 设置fileMap
	 * @param fileMap  fileMap
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.fileMap = new HashMap<Integer, FormFile>();
	}
	
	/**
	 * 获取附件
	 * @return 获取附件
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * 设置附件
	 * @param index 附件数组索引
	 * @param file 附件
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}

}
