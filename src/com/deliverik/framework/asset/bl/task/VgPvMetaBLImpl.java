/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.asset.VgPvMetaInfo;
import com.deliverik.framework.asset.model.condition.VgPvMetaSearchCond;
import com.deliverik.framework.asset.model.dao.VgPvMetaDao;
import com.deliverik.framework.base.BLException;

/**
 * ����: �豸��ϵ��Ϣҵ��ʵ��(VG-PV-Meta)
 * ��������: �豸��ϵ��Ϣҵ��ʵ��(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class VgPvMetaBLImpl implements VgPvMetaBL{
	
	protected  VgPvMetaDao vgPvMetaDao;
	
	
	
	
	public void setVgPvMetaDao(VgPvMetaDao vgPvMetaDao) {
		this.vgPvMetaDao = vgPvMetaDao;
	}




	public ArrayList<VgPvMetaInfo> searchVgPvMeta(VgPvMetaSearchCond cond) throws BLException{
		return vgPvMetaDao.searchVgPvMeta(cond);
	}

}
