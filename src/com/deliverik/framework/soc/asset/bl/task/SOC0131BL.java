/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0131SearchCond;

/**
 * ����: �豸��ϵ��Ϣҵ���߼�(VG-PV-Meta)
 * ��������: �豸��ϵ��Ϣҵ���߼�(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface SOC0131BL extends  BaseBL{
	
	public ArrayList<SOC0131Info> searchVgPvMeta(SOC0131SearchCond cond) throws BLException;
}
