/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.vo;

import java.util.List;

import com.csebank.lom.model.Inventory;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ÿ���̵�VO
 *
 */
public class IGLOM02201VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	/** ÿ���̵��ѯ����� */
	private List<Inventory> inventoryList;

	/**
	 * ÿ���̵��ѯ�����ȡ��
	 * @return ÿ���̵��ѯ�����
	 */
	public List<Inventory> getInventoryList() {
		return inventoryList;
	}

	/**
	 * ÿ���̵��ѯ������趨
	 * @param inventoryList ÿ���̵��ѯ�����
	 */
	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	
}
