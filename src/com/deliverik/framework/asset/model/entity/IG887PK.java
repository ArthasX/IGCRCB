/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.entity;
import java.io.Serializable;

import com.deliverik.framework.base.BasePK;


/**
 * �ʲ�������ʷ�汾����ʱ������ʵ��
 *
 */
@SuppressWarnings("serial")
public class IG887PK extends BasePK implements Serializable {
	
	/** �ʲ����Դ�汾�� */
	protected Integer civersion;
	
    /** �ʲ�����С�汾�� */
	protected Integer cismallversion;
    
	/**
	 * �ʲ����Դ�汾��ȡ��
	 * @return �ʲ����Դ�汾��
	 */
	public Integer getCiversion() {
		return civersion;
	}

	/**
	 * �ʲ����Դ�汾���趨
	 *
	 * @param civersion �ʲ����Դ�汾��
	 */
	public void setCiversion(Integer civersion) {
		this.civersion = civersion;
	}

	/**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public Integer getCismallversion() {
		return cismallversion;
	}

	/**
	 * �ʲ�����С�汾���趨
	 *
	 * @param cismallversion �ʲ�����С�汾��
	 */
	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
	}
	
	/**
	 * ���캯��
	 * 
	 */
	public IG887PK(){}
	
	/**
	 * ���캯��
	 * 
	 */
	public IG887PK(Integer civersion, Integer cismallversion) {
		super();
		this.civersion = civersion;
		this.cismallversion = cismallversion;
	}

}
