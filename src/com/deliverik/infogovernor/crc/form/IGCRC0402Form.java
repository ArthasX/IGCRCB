/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:变更批量处理Form 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC0402Form extends BaseForm{
	
	/** 流程ID集合 */
	protected Integer[] prid;
	
	/** 处理意见 */
	protected String rlcomment;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 流程状态码 */
	protected String prstatus;
	
	/** 表单名称 */
	protected String[] pivarnames;
	
	/** 表单值 */
	protected String[] pivarvalues;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 跳转标识 */
	protected String forward = "DISP";
	
	/** 按钮名称 */
	protected String buttonName;
	
	/** 按钮标识 */
	protected String buttonCode;
	
	/** 状态标示符*/
	protected String statusCode;

	/**
	 * 流程ID集合取得
	 * @return prid 流程ID集合
	 */
	public Integer[] getPrid() {
		return prid;
	}

	/**
	 * 流程ID集合设定
	 * @param prid 流程ID集合
	 */
	public void setPrid(Integer[] prid) {
		this.prid = prid;
	}

	/**
	 * 处理意见取得
	 * @return rlcomment 处理意见
	 */
	public String getRlcomment() {
		return rlcomment;
	}

	/**
	 * 处理意见设定
	 * @param rlcomment 处理意见
	 */
	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态码取得
	 * @return prstatus 流程状态码
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态码设定
	 * @param prstatus 流程状态码
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
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

	/**
	 * 附件取得
	 * @return fileMap 附件
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * 附件设定
	 * @param fileMap 附件
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	/**
	 * 表单名称取得
	 * @return pivarnames 表单名称
	 */
	public String[] getPivarnames() {
		return pivarnames;
	}

	/**
	 * 表单名称设定
	 * @param pivarnames 表单名称
	 */
	public void setPivarnames(String[] pivarnames) {
		this.pivarnames = pivarnames;
	}

	/**
	 * 表单值取得
	 * @return pivarvalues 表单值
	 */
	public String[] getPivarvalues() {
		return pivarvalues;
	}

	/**
	 * 表单值设定
	 * @param pivarvalues 表单值
	 */
	public void setPivarvalues(String[] pivarvalues) {
		this.pivarvalues = pivarvalues;
	}

	/**
	 * 跳转标识取得
	 * @return forward 跳转标识
	 */
	public String getForward() {
		return forward;
	}

	/**
	 * 跳转标识设定
	 * @param forward 跳转标识
	 */
	public void setForward(String forward) {
		this.forward = forward;
	}

	/**
	 * 按钮名称取得
	 * @return buttonName 按钮名称
	 */
	public String getButtonName() {
		return buttonName;
	}

	/**
	 * 按钮名称设定
	 * @param buttonName 按钮名称
	 */
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	/**
	 * 按钮标识取得
	 * @return buttonCode 按钮标识
	 */
	public String getButtonCode() {
		return buttonCode;
	}

	/**
	 * 按钮标识设定
	 * @param buttonCode 按钮标识
	 */
	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}

	/**
	 * 状态标示符获取
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * 状态标示符设定
	 * @param statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
