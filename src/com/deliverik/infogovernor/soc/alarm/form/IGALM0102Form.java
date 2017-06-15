/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM05SearchCond;

/**
 * Server Xml上传历史查询Form
 * @author Xudong Wang
 * 2013.07.31
 */
@SuppressWarnings("serial")
public class IGALM0102Form extends BaseForm implements CRM05SearchCond {

	/** filename */
	protected String filename_like;

	/** uploadtime */
	protected String uploadtime_begin;
	protected String uploadtime_end;
	private String[] deleteId;
	
	/** 性能指标脚本 */
	protected FormFile xmlFile;

	public FormFile getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(FormFile xmlFile) {
		this.xmlFile = xmlFile;
	}
	/**
	 * filename_like取得
	 *
	 * @return filename_like filename_like
	 */
	public String getFilename_like() {
		return filename_like;
	}
	/**
	 * uploadtime_begin取得
	 *
	 * @return uploadtime_begin uploadtime_begin
	 */
	public String getUploadtime_begin() {
		return uploadtime_begin;
	}
	/**
	 * uploadtime_end取得
	 *
	 * @return uploadtime_end uploadtime_end
	 */
	public String getUploadtime_end() {
		return uploadtime_end;
	}
	/**
	 * filename_like设定
	 *
	 * @param filename_like filename_like
	 */
	public void setFilename_like(String filename_like) {
		this.filename_like = filename_like;
	}
	/**
	 * uploadtime_begin设定
	 *
	 * @param uploadtime_begin uploadtime_begin
	 */
	public void setUploadtime_begin(String uploadtime_begin) {
		this.uploadtime_begin = uploadtime_begin;
	}
	/**
	 * uploadtime_end设定
	 *
	 * @param uploadtime_end uploadtime_end
	 */
	public void setUploadtime_end(String uploadtime_end) {
		this.uploadtime_end = uploadtime_end;
	}

	public String[] getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	
}
