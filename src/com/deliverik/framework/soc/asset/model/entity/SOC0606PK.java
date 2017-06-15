package com.deliverik.framework.soc.asset.model.entity;
import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * </p>
 * �ʲ�������Ϣ��ͼ��������
 *</p>
 */
@SuppressWarnings("serial")
public class SOC0606PK extends BasePK implements Serializable{

	/** �ʲ�ID */
	protected String eiid ;
	
	/** �ʲ�ģ������ID */
	protected String cid;
	

	/**
	 * ���캯��
	 * 
	 */
	public SOC0606PK(){}
	
	/**
	 * ���캯��
	 * 
	 */
	public SOC0606PK(String eiid, String cid) {
		super();
		this.eiid = eiid;
		this.cid = cid;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ������ID�趨
	 *
	 * @param cid �ʲ�ģ������ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

}
