/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.asset.FsLvVgInfo;
import com.deliverik.framework.asset.model.condition.FsLvVgSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ����: �豸��ϵ��Ϣҵ���߼���FS-LV-VG��
 * ��������: �豸��ϵ��Ϣҵ���߼���FS-LV-VG��
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface FsLvVgBL extends BaseBL{
	
	public ArrayList<FsLvVgInfo> searchFsLvVg(FsLvVgSearchCond cond) throws BLException;

}
