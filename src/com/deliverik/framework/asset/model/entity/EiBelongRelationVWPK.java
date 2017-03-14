/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BasePK;

/**
 * ����: ����������ϵ��ͼ��������
 * ��������: ����������ϵ��ͼ��������
 * ������¼: 2011/04/20
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class EiBelongRelationVWPK extends BasePK implements Serializable{

	/** Դ�ʲ�ID */
	@Id
	protected Integer brpareiid;

	/** Ŀ���ʲ�ID */
	@Id
	protected Integer brcldeiid;
	
	/**
	 * ���캯��
	 * 
	 */
	public EiBelongRelationVWPK(){}
	
	/**
	 * ���캯��
	 * 
	 */
	public EiBelongRelationVWPK(Integer brpareiid, Integer brcldeiid) {
		super();
		this.brpareiid = brpareiid;
		this.brcldeiid = brcldeiid;
	}

	/**
	 * Դ�ʲ�IDȡ��
	 *
	 * @return Դ�ʲ�ID
	 */
	public Integer getBrpareiid() {
		return brpareiid;
	}

	/**
	 * Դ�ʲ�ID�趨
	 *
	 * @param brpareiidԴ�ʲ�ID
	 */
	public void setBrpareiid(Integer brpareiid) {
		this.brpareiid = brpareiid;
	}

	/**
	 * Ŀ���ʲ�IDȡ��
	 *
	 * @return Ŀ���ʲ�ID
	 */
	public Integer getBrcldeiid() {
		return brcldeiid;
	}

	/**
	 * Ŀ���ʲ�ID�趨
	 *
	 * @param brcldeiidĿ���ʲ�ID
	 */
	public void setBrcldeiid(Integer brcldeiid) {
		this.brcldeiid = brcldeiid;
	}

}
