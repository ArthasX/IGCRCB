/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_FibreVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;


/**
 * 
 * @Description:�洢������ϢBL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Dir_FibreVWInfoBL extends BaseBL{
	
	/**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<Collect_Dir_FibreVWInfo> findByCond(final Collect_BusySearchCond cond, final int start, final int count);

}

