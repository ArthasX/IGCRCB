/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.framework.soc.asset.model.condition.Timer02SearchCond;
import com.deliverik.framework.soc.asset.model.entity.Timer02TB;

/**
  * ����: timer02ҵ���߼��ӿ�
  * ��������: timer02ҵ���߼��ӿ�
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public interface Timer02BL extends BaseBL {

	/**
	 * timer02ʵ��ȡ��
	 *
	 * @return timer02ʵ��
	 */
	public Timer02TB getTimer02TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Timer02Info> searchTimer02();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Timer02Info searchTimer02ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Timer02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Timer02Info> searchTimer02(
			Timer02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Timer02Info> searchTimer02(
			Timer02SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Timer02Info registTimer02(Timer02Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Timer02Info updateTimer02(Timer02Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTimer02ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTimer02(Timer02Info instance)
		throws BLException;

}