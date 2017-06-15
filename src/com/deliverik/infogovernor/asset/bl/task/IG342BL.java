/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCond;
import com.deliverik.infogovernor.asset.model.entity.IG342VW;

/**
  * ����: ҵ���߼��ӿ�
  * ��������: ҵ���߼��ӿ�
  * ������¼: 2012/08/03
  * �޸ļ�¼: 
  */
public interface IG342BL extends BaseBL {

	/**
	 * IG342VWʵ��ȡ��
	 *
	 * @return IG342VWʵ��
	 */
	public IG342VW getIG342();

//	/**
//	 * ȫ������
//	 *
//	 * @return ���������
//	 */
//	public List<EntityItemAndConfigItemVWInfo> searchEntityItemAndConfigItemVW();
//
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG342SearchCond cond);

//	/**
//	 * ������������
//	 *
//	 * @param cond ��������
//	 * @return ��������б�
//	 */
//	public List<EntityItemAndConfigItemVWInfo> searchEntityItemAndConfigItemVW(
//			EntityItemAndConfigItemVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG342Info> searchIG342(
			IG342SearchCond cond, int start,
			int count);
}