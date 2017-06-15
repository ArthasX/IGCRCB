package com.deliverik.framework.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.Attachment;


/**
 * <p>
 * 附件信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Attachment")
public class AttachmentTB extends BaseEntity implements Serializable, Cloneable, Attachment {
	
	/** 附件ID */
	@Id
	@TableGenerator(
		    name="ATTACHMENT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ATTACHMENT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ATTACHMENT_TABLE_GENERATOR")
	protected Integer attid;
	
	/** 附件索引 */
	protected String attkey;
	
	/** 附件名称 */
	protected String attname;
	
	/** 附件描述名称 */
	protected String attdesc;
	
	/** 附件存放位置 */
	protected String atturl;

	
	/**
	 * 获取主键
	 * @return 主键
	 */
	public Serializable getPK() {
		return attid;
	}

	/**
	 * 比较两个对象是否相同
	 * @param obj
	 * @return 比较结果（true相同，false不同）
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof AttachmentTB))
			return false;
		Attachment target = (Attachment) obj;
		if (!(getAttid()==target.getAttid()))
			return false;

		return true;
	}

	/**
	 * 附件ID取得
	 * @return 附件ID
	 */
	public Integer getAttid() {
		return attid;
	}

	/**
	 * 附件ID设定
	 *
	 * @param attid 附件ID
	 */
	public void setAttid(Integer attid) {
		this.attid = attid;
	}

	/**
	 * 附件索引取得
	 * @return 附件索引
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * 附件索引设定
	 *
	 * @param attkey 附件索引
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * 附件名称取得
	 * @return 附件名称
	 */
	public String getAttname() {
		return attname;
	}

	/**
	 * 附件名称设定
	 *
	 * @param attname 附件名称
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}

	/**
	 * 附件描述取得
	 * @return 附件描述
	 */
	public String getAttdesc() {
		return attdesc;
	}

	/**
	 * 附件描述设定
	 *
	 * @param attdesc 附件描述
	 */
	public void setAttdesc(String attdesc) {
		this.attdesc = attdesc;
	}

	/**
	 * 附件存放位置取得
	 * @return 附件存放位置
	 */
	public String getAtturl() {
		return atturl;
	}

	/**
	 * 附件存放位置设定
	 *
	 * @param atturl 附件存放位置
	 */
	public void setAtturl(String atturl) {
		this.atturl = atturl;
	}

}
