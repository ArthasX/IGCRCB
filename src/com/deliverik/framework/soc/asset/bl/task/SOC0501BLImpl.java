/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0501Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0501SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0501DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0501TB;

/**
  * ����: SOC0305ҵ���߼�ʵ��
  * ��������: SOC0305ҵ���߼�ʵ��
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public class SOC0501BLImpl extends BaseBLImpl implements
		SOC0501BL {
	
	private SOC0501DAO soc0501DAO;

	public SOC0501TB getSoc0501Instance() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SOC0501Info> searchSoc0501() {
		// TODO Auto-generated method stub
		return null;
	}

	public SOC0501Info searchSoc0501ByPK(Integer id) throws BLException {
		
		return soc0501DAO.findByPK(id);
	}

	
	public int getSearchCount(SOC0501SearchCond cond) {
		return soc0501DAO.getSearchCount(cond);
	}

	public List<SOC0501Info> searchSoc0501(SOC0501SearchCond cond) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����������ѯ
	 */
	public List<SOC0501Info> searchSoc0501(SOC0501SearchCond cond, int start,
			int count) {
		return soc0501DAO.findByCond(cond, start, count);
	}

	/**
	 * ����������Ϣ
	 */
	public SOC0501Info registSoc0501(SOC0501Info instance) throws BLException {
		return 		soc0501DAO.save(instance);
	}

	public SOC0501Info updateSoc0501(SOC0501Info instance) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteSoc0501ByPK(Integer id) throws BLException {
		// TODO Auto-generated method stub
		
	}

	public void deleteSoc0501(SOC0501Info instance) throws BLException {
		// TODO Auto-generated method stub
		
	}

	public int getVWSearchCount(SOC0501SearchCond storageEventSearchCond)
			throws BLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.bl.task.SOC0501BL#searchSOC0501(com.deliverik.framework.soc.asset.model.condition.SOC0501SearchCond, int, int)
	 */
	public List<SOC0501Info> searchSOC0501(
			SOC0501SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSoc0501DAO(SOC0501DAO soc0501dao) {
		soc0501DAO = soc0501dao;
	}

	


}