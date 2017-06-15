/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.asset.FsLvVgInfo;
import com.deliverik.framework.asset.model.condition.FsLvVgSearchCond;
import com.deliverik.framework.asset.model.dao.FsLvVgDao;
import com.deliverik.framework.base.BLException;

/**
 * ����: �豸��ϵ��Ϣҵ��ʵ�֣�FS-LV-VG��
 * ��������: �豸��ϵ��Ϣҵ��ʵ�֣�FS-LV-VG��
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class FsLvVgBLImpl implements FsLvVgBL{
	
	protected FsLvVgDao fsLvVgDao;
	
	

	public void setFsLvVgDao(FsLvVgDao fsLvVgDao) {
		this.fsLvVgDao = fsLvVgDao;
	}



	public ArrayList<FsLvVgInfo> searchFsLvVg(FsLvVgSearchCond cond) throws BLException{
		return fsLvVgDao.searchFsLvVg(cond);
	}

}
