/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.Mss00007Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00007SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00007TB;

/**
  * ����: �澯��Ϣ��ʷ��ҵ���߼��ӿ�
  * ��������: �澯��Ϣ��ʷ��ҵ���߼��ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00007BL extends BaseBL {

	/**
	 * �澯��Ϣ��ʷ��ʵ��ȡ��
	 *
	 * @return �澯��Ϣ��ʷ��ʵ��
	 */
	public Mss00007TB getMss00007TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00007Info> searchMss00007();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00007Info searchMss00007ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00007SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00007Info> searchMss00007(
			Mss00007SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00007Info> searchMss00007(
			Mss00007SearchCond cond, int start,
			int count) throws Exception;

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00007Info registMss00007(Mss00007Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00007Info updateMss00007(Mss00007Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00007ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00007(Mss00007Info instance)
		throws BLException;

}