/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.EworkingLunch;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ʳ�ù����͹���VO
 *
 */
public class IGLOM05031VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * ʳ�ù����͹���������
	 */
	protected List<EworkingLunch> eworkingLunchList;

	/**
	 * ʳ�ù����͹���������ȡ��
	 * @return ʳ�ù����͹���������
	 */
	public List<EworkingLunch> getEworkingLunchList() {
		return eworkingLunchList;
	}

	/**
	 * ʳ�ù����͹���������
	 * @param eateryList ʳ�ù����͹���������
	 */
	public void setEworkingLunchList(List<EworkingLunch> eworkingLunchList) {
		this.eworkingLunchList = eworkingLunchList;
	}

}
