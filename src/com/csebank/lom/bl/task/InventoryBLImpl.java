/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.InventoryInfo;
import com.csebank.lom.model.condition.InventoryInfoSearchCond;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.csebank.lom.model.dao.InventoryDAO;
import com.csebank.lom.model.dao.InventoryInfoDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ÿ���̵�ҵ���߼��ӿ�ʵ��
 */
public class InventoryBLImpl extends BaseBLImpl implements InventoryBL {
	
	/** Inventory DAO */
	protected InventoryDAO inventoryDAO;
	
	public void setInventoryDAO(
			InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}
	
	/** InventoryInfo DAO */
	protected InventoryInfoDAO inventoryInfoDAO;
	
	public void setInventoryInfoDAO(
			InventoryInfoDAO inventoryInfoDAO) {
		this.inventoryInfoDAO = inventoryInfoDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(InventorySearchCond cond){
		
		return inventoryDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param lpdid 
	 * @return 
	 */
	public Inventory searchInventoryByKey(Integer inid) throws BLException{
		
		return checkExistInventory(inid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���軹����ϸ��Ϣ
	 */
	public List<Inventory> searchInventoryAll(){
		
		return inventoryDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Inventory> searchInventory(InventorySearchCond cond, int start, int count){
		
		return inventoryDAO.findByCond(cond,start,count);
	}

	/**
	 * ��Ϣ���ڼ��
	 * 
	 * @param inid 
	 * @return 
	 * @throws BLException 
	 */
	protected Inventory checkExistInventory(Integer inid) throws BLException{
		Inventory info = inventoryDAO.findByPK(inid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ÿ���̵�");
		}
		return info;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InventoryInfo> searchInventoryInfo(InventoryInfoSearchCond cond, int start, int count){
		
		return inventoryInfoDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param Inventory ��¼����
	 * @return 
	 */
	public Inventory registInventory(Inventory inventory) throws BLException{
		
		return inventoryDAO.save(inventory);
	}
}
