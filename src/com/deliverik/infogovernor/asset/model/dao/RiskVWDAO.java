/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.dao;

import java.util.List;

import com.deliverik.infogovernor.asset.model.RiskVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskVWCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ�ƽӿ�
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface RiskVWDAO {
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskVWInfo> findByCond(final RiskVWCond cond);
	
}
