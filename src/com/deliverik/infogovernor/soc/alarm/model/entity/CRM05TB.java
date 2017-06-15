/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: CRM05ʵ��
  * ��������: CRM05ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
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
	 * fileidȡ��
	 *
	 * @return fileid
	 */
	public Integer getFileid() {
		return fileid;
	}

	/**
	 * fileid�趨
	 *
	 * @param fileid fileid
	 */
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	/**
	 * filenameȡ��
	 *
	 * @return filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * filename�趨
	 *
	 * @param filename filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * uploadtimeȡ��
	 *
	 * @return uploadtime
	 */
	public String getUploadtime() {
		return uploadtime;
	}

	/**
	 * uploadtime�趨
	 *
	 * @param uploadtime uploadtime
	 */
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	/**
	 * filepathȡ��
	 *
	 * @return filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * filepath�趨
	 *
	 * @param filepath filepath
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return fileid;
	}

}