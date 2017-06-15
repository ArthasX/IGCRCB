/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sya.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;

/**	
 * ����: �ƶȻ��ʵ��
 * ���������� �ƶȻ��ʵ��
 * ������¼��yukexin    2015-2-5 ����10:50:44	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
@Entity
@Table(name="Institution")
public class InstitutionTB extends BaseEntity implements Serializable,
		Cloneable, InstitutionInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="INSTITUTION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INSTITUTION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INSTITUTION_TABLE_GENERATOR")
	protected Integer inid;

	/** �ƶ�����  */	
	protected String inname;

	/** �ƶ�����  */	
	protected String indesc;

	/** ���� */
	protected String attkey;

	/** �Ǽ���id */
	protected String inuserid;

	/** �Ǽ������� */
	protected String inusername;

	/** �Ǽ��˻���id */
	protected String inorgid;

	/** �Ǽ��˻������� */
	protected String inorgname;

	/** ����ʱ�� */
	protected String createtime;
	
	/** �ƶȷ���  */	
	public String intype;
	/**
	 * ����ȡ��
	 * @return inid  ����
	 */
	public Integer getInid() {
		return inid;
	}

	/**
	 * �����趨
	 * @param inid  ����
	 */
	public void setInid(Integer inid) {
		this.inid = inid;
	}

	/**
	 * �ƶ�����ȡ��
	 * @return inname  �ƶ�����
	 */
	public String getInname() {
		return inname;
	}

	/**
	 * �ƶ������趨
	 * @param inname  �ƶ�����
	 */
	public void setInname(String inname) {
		this.inname = inname;
	}

	/**
	 * �ƶ�����ȡ��
	 * @return indesc  �ƶ�����
	 */
	public String getIndesc() {
		return indesc;
	}

	/**
	 * �ƶ������趨
	 * @param indesc  �ƶ�����
	 */
	public void setIndesc(String indesc) {
		this.indesc = indesc;
	}

	/**
	 * ����ȡ��
	 * @return attkey  ����
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * �����趨
	 * @param attkey  ����
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * �Ǽ���idȡ��
	 * @return inuserid  �Ǽ���id
	 */
	public String getInuserid() {
		return inuserid;
	}

	/**
	 * �Ǽ���id�趨
	 * @param inuserid  �Ǽ���id
	 */
	public void setInuserid(String inuserid) {
		this.inuserid = inuserid;
	}

	/**
	 * �Ǽ�������ȡ��
	 * @return inusername  �Ǽ�������
	 */
	public String getInusername() {
		return inusername;
	}

	/**
	 * �Ǽ��������趨
	 * @param inusername  �Ǽ�������
	 */
	public void setInusername(String inusername) {
		this.inusername = inusername;
	}

	/**
	 * �Ǽ��˻���idȡ��
	 * @return inorgid  �Ǽ��˻���id
	 */
	public String getInorgid() {
		return inorgid;
	}

	/**
	 * �Ǽ��˻���id�趨
	 * @param inorgid  �Ǽ��˻���id
	 */
	public void setInorgid(String inorgid) {
		this.inorgid = inorgid;
	}

	/**
	 * �Ǽ��˻�������ȡ��
	 * @return inorgname  �Ǽ��˻�������
	 */
	public String getInorgname() {
		return inorgname;
	}

	/**
	 * �Ǽ��˻��������趨
	 * @param inorgname  �Ǽ��˻�������
	 */
	public void setInorgname(String inorgname) {
		this.inorgname = inorgname;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return createtime  ����ʱ��
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * ����ʱ���趨
	 * @param createtime  ����ʱ��
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �ƶȷ���ȡ��
	 * @return intype  �ƶȷ���
	 */
	public String getIntype() {
		return intype;
	}

	/**
	 * �ƶȷ����趨
	 * @param intype  �ƶȷ���
	 */
	public void setIntype(String intype) {
		this.intype = intype;
	}

	

}