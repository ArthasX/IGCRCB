/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.asset.VgPvMetaInfo;
import com.deliverik.framework.asset.model.condition.VgPvMetaSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ����: �豸��ϵ��Ϣҵ���߼�(VG-PV-Meta)
 * ��������: �豸��ϵ��Ϣҵ���߼�(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface VgPvMetaBL extends  BaseBL{
	
	public ArrayList<VgPvMetaInfo> searchVgPvMeta(VgPvMetaSearchCond cond) throws BLException;
}
