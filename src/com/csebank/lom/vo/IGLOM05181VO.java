/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.ItemsCodesSt;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * �Ϳ���ϢVO
 *
 */
public class IGLOM05181VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * �Ϳ���Ϣ���
	 */
	protected List<ItemsCodesSt> lunchCardList;

	/**
	 * �Ϳ���Ϣ���ȡ��
	 * @return �Ϳ���Ϣ���
	 */
	public List<ItemsCodesSt> getLunchCardList() {
		return lunchCardList;
	}

	/**
	 * �Ϳ���Ϣ���
	 * @param itemsCodes �Ϳ���Ϣ���
	 */
	public void setLunchCardList(List<ItemsCodesSt> lunchCardList) {
		this.lunchCardList = lunchCardList;
	}
	
}
