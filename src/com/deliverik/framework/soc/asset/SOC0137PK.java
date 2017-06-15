/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;

import java.io.Serializable;

import javax.persistence.Id;


import com.deliverik.framework.base.BasePK;

/**
 * ����: �豸��ϵ��Ϣ(VG-PV-Meta)
 * ��������: �豸��ϵ��ϢVO(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class SOC0137PK extends BasePK implements Serializable {
	/** �������ID */
	@Id
	protected Integer autid;
	
	/** �ʲ�ID */
	@Id
	protected Integer eiid;

	/** ��汾 */
	@Id
	protected Integer eiversion;

	/** С�汾 */
	@Id
	protected Integer eismallversion;
	
	
	/**
	 * ���캯��
	 */
	public SOC0137PK() {
		super();
	}
	
	
	/**
	 * ���캯��
	 * @param autid
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 */
	public SOC0137PK(Integer autid, Integer eiid, Integer eiversion,
			Integer eismallversion) {
		super();
		this.autid = autid;
		this.eiid = eiid;
		this.eiversion = eiversion;
		this.eismallversion = eismallversion;
	}



	/**
	 * �������IDȡ��
	 *
	 * @return �������ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * �������ID�趨
	 *
	 * @param autid �������ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��汾ȡ��
	 *
	 * @return ��汾
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * ��汾�趨
	 *
	 * @param eiversion ��汾
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * С�汾ȡ��
	 *
	 * @return С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * С�汾�趨
	 *
	 * @param eismallversion С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

}
