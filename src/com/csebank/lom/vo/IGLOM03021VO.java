/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * Ԥ֧���ù���VO
 *
 */
public class IGLOM03021VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * Ԥ֧���ù���������
	 */
	protected List<AdvanCescost> advanCescostList;

	/**
	 * Ԥ֧���ù���������ȡ��
	 * @return Ԥ֧���ù���������
	 */
	public List<AdvanCescost> getAdvanCescostList() {
		return advanCescostList;
	}

	/**
	 * Ԥ֧���ù���������
	 * @param advanCescostList Ԥ֧���ù���������
	 */
	public void setAdvanCescostList(List<AdvanCescost> advanCescostList) {
		this.advanCescostList = advanCescostList;
	}

}
