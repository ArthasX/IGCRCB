/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskcaseVWTB;

/**
  * ����: �����¼�ҵ���߼��ӿ�
  * ��������: �����¼�ҵ���߼��ӿ�
  * ������¼: 2014/07/18
  * �޸ļ�¼: 
  */
public interface RiskcaseVWBL extends BaseBL {

	/**
	 * �����¼�ʵ��ȡ��
	 *
	 * @return �����¼�ʵ��
	 */
	public RiskcaseVWTB getRiskcaseVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskcaseVWInfo searchRiskcaseVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskcaseVWSearchCond cond);

	/**
	 * �����¼�Ӧ�Բ��Բ�ѯ
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW(
			RiskcaseVWSearchCond cond);
	
	/**
	 * �����¼��汾��ѯ
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> searchRiskcaseByVersion(
			RiskcaseVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> searchRiskcaseVW(
			RiskcaseVWSearchCond cond, int start,
			int count);

}