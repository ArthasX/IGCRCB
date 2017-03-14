/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.InventoryInfo;
import com.csebank.lom.model.condition.InventoryInfoSearchCond;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ÿ���̵�ҵ���߼��ӿ�
 */
public interface InventoryBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(InventorySearchCond cond);

	/**
	 * ������������
	 * 
	 * @param lpdid 
	 * @return 
	 */
	public Inventory searchInventoryByKey(Integer inid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return 
	 */
	public List<Inventory> searchInventoryAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Inventory> searchInventory(InventorySearchCond cond, int start, int count);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InventoryInfo> searchInventoryInfo(InventoryInfoSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param Inventory ��¼����
	 * @return 
	 */
	public Inventory registInventory(Inventory inventory) throws BLException;
}
