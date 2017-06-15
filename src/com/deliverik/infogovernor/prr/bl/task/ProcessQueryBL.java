/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.model.condition.ProcessSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯBL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessQueryBL extends BaseBL{

	/**
	 * ��������ȡ��
	 * @param cond ��ѯ����
	 * @return �涨����
	 * @throws BLException
	 */
	public int getProcessCount(ProcessSearchCond cond) throws BLException;

	/**
	 * ��ѯ������Ϣ
	 * @param cond ��ѯ����
	 * @param start ��ʼҳ��
	 * @param count ��ʾ����
	 * @return ������Ϣ����
	 */
	public List<Map<String, Object>> searchProcess(ProcessSearchCond cond, int start, int count);

}
