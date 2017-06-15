/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00001TB;

/**
  * ����: �豸��Ϣ��ҵ���߼��ӿ�
  * ��������: �豸��Ϣ��ҵ���߼��ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00001BL extends BaseBL {

	/**
	 * �豸��Ϣ��ʵ��ȡ��
	 *
	 * @return �豸��Ϣ��ʵ��
	 */
	public Mss00001TB getMss00001TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00001Info> searchMss00001();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00001Info searchMss00001ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00001SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00001Info> searchMss00001(
			Mss00001SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00001Info> searchMss00001(
			Mss00001SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00001Info registMss00001(Mss00001Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00001Info updateMss00001(Mss00001Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00001ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00001(Mss00001Info instance)
		throws BLException;

}