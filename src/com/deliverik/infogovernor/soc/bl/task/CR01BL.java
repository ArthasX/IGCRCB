/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR01SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�ɼ����BL �ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface CR01BL extends BaseBL{

	/**
	 * �ɼ������ѯ
	 * @param cond ��ѯ����
	 * @param start ��ʼҳ��
	 * @param length ��ʾ����
	 * @return ��ѯ���
	 */
	public List<CR01VWInfo> searchCR01VWInfoList(CR01SearchCond cond , int start,int length);
}
