/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0153SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0153DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0153TB;

/**
  * ����: SOC0153ҵ���߼�ʵ��
  * ��������: SOC0153ҵ���߼�ʵ��
  * ������¼: 2013/12/05
  * �޸ļ�¼: 
  */
public class SOC0153BLImpl extends BaseBLImpl implements
		SOC0153BL {
	
	private SOC0153DAO soc0153DAO;

	public SOC0153TB getSoc0153Instance() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SOC0153Info> searchSoc0153() {
		// TODO Auto-generated method stub
		return null;
	}

	public SOC0153Info searchSoc0153ByPK(Integer id) throws BLException {
		
		return soc0153DAO.findByPK(id);
	}

	
	public int getSearchCount(SOC0153SearchCond cond) {
		return soc0153DAO.getSearchCount(cond);
	}

	public List<SOC0153Info> searchSoc0153(SOC0153SearchCond cond) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����������ѯ
	 */
	public List<SOC0153Info> searchSoc0153(SOC0153SearchCond cond, int start,
			int count) {
		return soc0153DAO.findByCond(cond, start, count);
	}

	/**
	 * ����������Ϣ
	 */
	public SOC0153Info registSoc0153(SOC0153Info instance) throws BLException {
		return 		soc0153DAO.save(instance);
	}

	public SOC0153Info updateSoc0153(SOC0153Info instance) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteSoc0153ByPK(Integer id) throws BLException {
		// TODO Auto-generated method stub
		
	}

	public void deleteSoc0153(SOC0153Info instance) throws BLException {
		// TODO Auto-generated method stub
		
	}

	public int getVWSearchCount(SOC0153SearchCond storageEventSearchCond)
			throws BLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<SOC0153Info> searchSOC0153(
			SOC0153SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSoc0153DAO(SOC0153DAO soc0153dao) {
		soc0153DAO = soc0153dao;
	}

	


}