/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM05检索条件实现
  * 功能描述: CRM05检索条件实现
  * 创建记录: 2013/07/30
  * 修改记录: 2013/07/31 xudong wang
  */
public class CRM05SearchCondImpl implements
		CRM05SearchCond {

	/** filename */
	protected String filename_like;

	/** uploadtime */
	protected String uploadtime_begin;
	protected String uploadtime_end;
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
}