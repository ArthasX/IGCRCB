/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Eatery;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ʳ�óɱ�����VO
 *
 */
public class IGLOM05011VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * ʳ�óɱ�����������
	 */
	protected List<Eatery> eateryList;

	/**
	 * ʳ�óɱ�����������ȡ��
	 * @return ʳ�óɱ�����������
	 */
	public List<Eatery> getEateryList() {
		return eateryList;
	}

	/**
	 * ʳ�óɱ�����������
	 * @param eateryList ʳ�óɱ�����������
	 */
	public void setEateryList(List<Eatery> eateryList) {
		this.eateryList = eateryList;
	}

}
