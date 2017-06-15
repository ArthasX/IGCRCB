/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.infogovernor.drm.model.condition.SpecialPlanSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ר��Ԥ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface SpecialPlanBL extends BaseBL{

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SpecialPlanSearchCond cond);
	
	/**
	 * ��������
	 * @param cond ��������
	 * @param start ��ʼ����
	 * @param count ��ʾ����
	 * @return �������
	 */
	public List<SOC0118VWInfo> search(SpecialPlanSearchCond cond,int start,int count);
}
