/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BasePK;

/**
 * ����: ���̲����趨��Ϣʵ��֪ʶID
 * �������������̲����趨��Ϣʵ��֪ʶID
 * ������¼������ 2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class KnowledgeTBPK extends BasePK implements Serializable{
	@Id
	/**֪ʶID */
	protected Integer knid;
	
	@Id
	/**֪ʶ�汾 */
	protected Integer knversion;
	/**
	 * ֪ʶ��Ϣʵ���������캯��
	 * 
	 */
	public KnowledgeTBPK() {
	}

	/**
	 * ֪ʶ��Ϣʵ���������캯��
	 * 
	 * @param knid ֪ʶID
	 * @param knversion ֪ʶ�汾
	 */
	public KnowledgeTBPK(Integer knid, Integer knversion) {
		super();
		this.knid = knid;
		this.knversion = knversion;
	}
	
	/**
	 *֪ʶ�汾ȡ��
	 * 
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion() {
		return knversion;
	}
	/**
	 * ֪ʶ�汾
	 * @param knversion ֪ʶ�汾
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	
	/**
	 *֪ʶIDȡ��
	 * 
	 * @return ֪ʶID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *֪ʶID�趨
	 * 
	 * @param knid ֪ʶID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}
	
}
