package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG413Info;

/**
 * �����¼�������Ϣʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "IG413")
public class IG413TB extends BaseEntity implements Serializable,
		Cloneable, IG413Info {
	/**
	 * �����¼�����ID
	 */
	@Id
	protected String pedid;

	/** ���̶���ID */
	protected String pdid;

	/** ״̬ID */
	protected String psdid;

	/** ����ID */
	protected String pedactionid;

	/** �¼����� */
	protected String pedtype;

	/** �Զ���BL���� */
	protected String pedblid;

	/** �¼�ִ��˳�� */
	protected Integer pedorder;
	
	/** �������� */
	protected String pedec;

	public String getPedec() {
		return pedec;
	}

	public void setPedec(String pedec) {
		this.pedec = pedec;
	}

	/**
	 * �����¼�����IDȡ��
	 * 
	 * @return �����¼�����ID
	 */
	public String getPedid() {
		return pedid;
	}

	/**
	 * �����¼�����ID�趨
	 * 
	 * @param pedid�����¼�����ID
	 */
	public void setPedid(String pedid) {
		this.pedid = pedid;
	}

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ״̬IDȡ��
	 * 
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 * 
	 * @param psdid״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public String getPedactionid() {
		return pedactionid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param pedactionid����ID
	 */
	public void setPedactionid(String pedactionid) {
		this.pedactionid = pedactionid;
	}

	/**
	 * �¼�����ȡ��
	 * 
	 * @return �¼�����
	 */
	public String getPedtype() {
		return pedtype;
	}

	/**
	 * �¼������趨
	 * 
	 * @param pedtype�¼�����
	 */
	public void setPedtype(String pedtype) {
		this.pedtype = pedtype;
	}

	/**
	 * �Զ���BL����ȡ��
	 * 
	 * @return �Զ���BL����
	 */
	public String getPedblid() {
		return pedblid;
	}

	/**
	 * �Զ���BL�����趨
	 * 
	 * @param pedblid�Զ���BL����
	 */
	public void setPedblid(String pedblid) {
		this.pedblid = pedblid;
	}

	/**
	 * �¼�ִ��˳��ȡ��
	 * 
	 * @return �¼�ִ��˳��
	 */
	public Integer getPedorder() {
		return pedorder;
	}

	/**
	 * �¼�ִ��˳���趨
	 * 
	 * @param pedorder�¼�ִ��˳��
	 */
	public void setPedorder(Integer pedorder) {
		this.pedorder = pedorder;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Serializable getPK() {
		return pedid;
	}

	/**
	 * �ȽϷ���
	 * 
	 * @param obj�����¼�������Ϣ
	 * @return �ȽϽ��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof IG413TB))
			return false;
		IG413Info target = (IG413Info) obj;
		if (!(getPedid() == target.getPedid()))
			return false;
		return true;
	}

}
