/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

import com.deliverik.framework.asset.model.IG887Info;


/**
 * �ʲ�������ʷ�汾����ʱ��ʵ��
 *
 */
@SuppressWarnings("serial")
@Entity
@IdClass(IG887PK.class)
public class IG887VW implements Serializable, Cloneable, IG887Info {
	
	/** �ʲ����Դ�汾�� */
	@Id
	protected Integer civersion;
	
	/** �ʲ����Ը���ʱ�� */
    protected String ciupdtime;
    
    /** �Ƿ���������ļ������������ڵ��ڰ汾�Ƚ�ʱ����ʾ */
    @Transient
    protected String isshow;
    
    /** �ʲ�����С�汾�� */
    @Id
	protected Integer cismallversion;
    
    /**
	 * �Ƿ���������ļ������������ڵ��ڰ汾�Ƚ�ʱ����ʾ 0����ʾ 1��ʾ
	 * @return ��ʾ��ʶ
	 */
    public String getIsshow() {
		return isshow;
	}

    /**
	 * �Ƿ���������ļ������������ڵ��ڰ汾�Ƚ�ʱ����ʾ 0����ʾ 1��ʾ
	 *
	 * @param isshow 
	 */
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

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
	 * �ʲ����Ը���ʱ��ȡ��
	 * @return �ʲ����Ը���ʱ��
	 */
	public String getCiupdtime() {
		return ciupdtime;
	}

	/**
	 * �ʲ����Ը���ʱ���趨
	 *
	 * @param ciupdtime �ʲ����Ը���ʱ��
	 */
	public void setCiupdtime(String ciupdtime) {
		this.ciupdtime = ciupdtime;
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

}
