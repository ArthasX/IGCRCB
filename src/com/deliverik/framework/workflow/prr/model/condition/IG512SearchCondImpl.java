/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ���̹�ϵ��ѯ����ʵ��
 */
public class IG512SearchCondImpl implements IG512SearchCond {

	/** ��������ID */
	protected Integer parprid;

	/** ��������ID */
	protected Integer cldprid;
	
	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @param parprid ��������ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getCldprid() {
		return cldprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @param cldprid ��������ID
	 */
	public void setCldprid(Integer cldprid) {
		this.cldprid = cldprid;
	}

}
