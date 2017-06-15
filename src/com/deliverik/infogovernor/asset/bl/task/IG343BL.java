/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.condition.IG343SearchCond;

/**
  * ����: ҵ���߼��ӿ�
  * ��������: ҵ���߼��ӿ�
  * ������¼: 2012/07/12
  * �޸ļ�¼: 
  */
public interface IG343BL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG343Info> searchIG343(
			IG343SearchCond cond, int start, int count);

}