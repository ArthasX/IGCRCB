/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00013TB;

/**
  * ����: mss00013ҵ���߼��ӿ�
  * ��������: mss00013ҵ���߼��ӿ�
  * ������¼: 2013/08/15
  * �޸ļ�¼: 
  */
public interface Mss00013BL extends BaseBL {

	/**
	 * mss00013ʵ��ȡ��
	 *
	 * @return mss00013ʵ��
	 */
	public Mss00013TB getMss00013TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00013Info> searchMss00013();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00013Info searchMss00013ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00013SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00013Info> searchMss00013(
			Mss00013SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00013Info> searchMss00013(
			Mss00013SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00013Info registMss00013(Mss00013Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00013Info updateMss00013(Mss00013Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00013ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00013(Mss00013Info instance)
		throws BLException;

}