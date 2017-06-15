/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCond;

/**
  * ����: ҵ���߼��ӿ�
  * ��������: ҵ���߼��ӿ�
  * ������¼: 2012/07/13
  * �޸ļ�¼: 
  */
public interface IG344BL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG344Info> searchIG344(
			IG344SearchCond cond, int start, int count);
}