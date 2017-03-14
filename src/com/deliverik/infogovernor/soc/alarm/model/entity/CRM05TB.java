/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;

/**
  * 概述: CRM05实体
  * 功能描述: CRM05实体
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM05")
public class CRM05TB extends BaseEntity implements Serializable,
		Cloneable, CRM05Info {

	/** fileid */
	@Id
	@GeneratedValue(generator = "fileid")
	@GenericGenerator(name = "fileid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "crm05_seq") })
	protected Integer fileid;

	/** filename */
	protected String filename;

	/** uploadtime */
	protected String uploadtime;

	/** filepath */
	protected String filepath;

	/**
	 * fileid取得
	 *
	 * @return fileid
	 */
	public Integer getFileid() {
		return fileid;
	}

	/**
	 * fileid设定
	 *
	 * @param fileid fileid
	 */
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	/**
	 * filename取得
	 *
	 * @return filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * filename设定
	 *
	 * @param filename filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * uploadtime取得
	 *
	 * @return uploadtime
	 */
	public String getUploadtime() {
		return uploadtime;
	}

	/**
	 * uploadtime设定
	 *
	 * @param uploadtime uploadtime
	 */
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	/**
	 * filepath取得
	 *
	 * @return filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * filepath设定
	 *
	 * @param filepath filepath
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return fileid;
	}

}