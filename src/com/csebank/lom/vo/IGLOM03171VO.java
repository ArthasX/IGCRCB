/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanceDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * Ԥ֧��ϸͳ��VO
 *
 */
public class IGLOM03171VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** Ԥ֧��ϸͳ�Ʋ�ѯ����б� */
	protected List<AdvanceDetail> advanceDetailList;

	/**
	 * Ԥ֧��ϸͳ�Ʋ�ѯ����б�ȡ��
	 * @return Ԥ֧��ϸͳ�Ʋ�ѯ����б�
	 */
	public List<AdvanceDetail> getAdvanceDetailList() {
		return advanceDetailList;
	}

	/**
	 * Ԥ֧��ϸͳ�Ʋ�ѯ����б��趨
	 * @param advanceDetailList Ԥ֧��ϸͳ�Ʋ�ѯ����б�
	 */
	public void setAdvanceDetailList(
			List<AdvanceDetail> advanceDetailList) {
		this.advanceDetailList = advanceDetailList;
	}

}
