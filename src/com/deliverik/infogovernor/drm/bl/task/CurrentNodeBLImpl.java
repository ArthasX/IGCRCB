/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.dao.CurrentNodeDAO;

/**
 * ��������ȡ�����ָ����̵�ǰ�ڵ�BL
 * ����������
 * ������¼��2014/05/19
 * �޸ļ�¼��
 */
public class CurrentNodeBLImpl extends BaseBLImpl implements CurrentNodeBL {
	private CurrentNodeDAO currentNodeDao;
	
	

	public void setCurrentNodeDao(CurrentNodeDAO currentNodeDao) {
		this.currentNodeDao = currentNodeDao;
	}



	/**
	 * ͨ������id��ȡ��ǰ�ڵ���Ϣ
	 */
	public List<Map<String,Object>> getCurrentNodes(Integer prid) throws BLException {
		
		return currentNodeDao.searchCurrentNodes(prid);
	}

	/**
	 * ��������id ��ѯ���нڵ���Ϣ
	 */
	public List<Map<String,Object>> searchAllNodes(Integer prid,String psdid) throws BLException{
		return currentNodeDao.searchAllNodes(prid,psdid);
	}
	
}