/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCond;
import com.deliverik.framework.soc.asset.model.dao.PlatformManagerDAO;

/**
  * ����: ҵ��ϵͳ����Աȱʧҵ���߼�ʵ��
  * ��������: ҵ��ϵͳ����Աȱʧҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class PlatformManagerBLImpl extends BaseBLImpl implements
		PlatformManagerBL {

	/** ����ʲ����Ա�DAO�ӿ� */
	protected PlatformManagerDAO platformManagerDAO;
	
	

	public void setPlatformManagerDAO(PlatformManagerDAO platformManagerDAO) {
		this.platformManagerDAO = platformManagerDAO;
	}

	
	public Integer getCount(PlatformManagerVWSearchCond cond)throws BLException{
		return platformManagerDAO.getSearchCount(cond);
	}

	public List<PlatformManagerInfo> findByCond(PlatformManagerVWSearchCond cond,int start,int count)throws BLException{
		return platformManagerDAO.findByCond(cond, start, count);
	}
}