/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0130SearchCond;

/**
 * ����: �豸��ϵ��Ϣҵ���߼���FS-LV-VG��
 * ��������: �豸��ϵ��Ϣҵ���߼���FS-LV-VG��
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface SOC0130BL extends BaseBL{
	
	public ArrayList<SOC0130Info> searchFsLvVg(SOC0130SearchCond cond) throws BLException;

}
