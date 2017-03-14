/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;

/**
  * ����: timer01ҵ���߼��ӿ�
  * ��������: timer01ҵ���߼��ӿ�
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public interface Timer01BL extends BaseBL {

	/**
	 * timer01ʵ��ȡ��
	 *
	 * @return timer01ʵ��
	 */
	public Timer01TB getTimer01TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Timer01Info> searchTimer01();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Timer01Info searchTimer01ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Timer01SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Timer01Info> searchTimer01(
			Timer01SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Timer01Info> searchTimer01(
			Timer01SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Timer01Info registTimer01(Timer01Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Timer01Info updateTimer01(Timer01Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTimer01ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTimer01(Timer01Info instance)
		throws BLException;

}