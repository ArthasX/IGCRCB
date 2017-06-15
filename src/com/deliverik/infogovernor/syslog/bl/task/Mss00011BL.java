/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.entity.Mss00011VW;

import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00011SearchCond;

/**
  * ����: mss00011ҵ���߼��ӿ�
  * ��������: mss00011ҵ���߼��ӿ�
  * ������¼: 2013/04/16
  * �޸ļ�¼: 
  */
public interface Mss00011BL extends BaseBL {

	/**
	 * mss00011ʵ��ȡ��
	 *
	 * @return mss00011ʵ��
	 */
	public Mss00011VW getMss00011VWInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00011Info> searchMss00011();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00011Info searchMss00011ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00011SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00011Info> searchMss00011(
			Mss00011SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00011Info> searchMss00011(
			Mss00011SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00011Info registMss00011(Mss00011Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00011Info updateMss00011(Mss00011Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00011ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00011(Mss00011Info instance)
		throws BLException;

}