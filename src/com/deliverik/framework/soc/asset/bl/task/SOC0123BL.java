/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0123SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;

/**
  * ����: �ʲ�ģ����ͼҵ���߼��ӿ�
  * ��������: �ʲ�ģ����ͼҵ���߼��ӿ�
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public interface SOC0123BL extends BaseBL {

	/**
	 * �ʲ�ģ����ͼʵ��ȡ��
	 *
	 * @return �ʲ�ģ����ͼʵ��
	 */
	public SOC0123VW getEntityItemEntityVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0123Info> searchEntityItemEntityVW();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0123Info searchEntityItemEntityVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0123SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0123Info> searchEntityItemEntityVW(
			SOC0123SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0123Info> searchEntityItemEntityVW(
			SOC0123SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0123Info registEntityItemEntityVW(SOC0123Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0123Info updateEntityItemEntityVW(SOC0123Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEntityItemEntityVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEntityItemEntityVW(SOC0123Info instance)
		throws BLException;

}