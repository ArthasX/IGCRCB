/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00012SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00012TB;

/**
  * ����: MSS00012ҵ���߼��ӿ�
  * ��������: MSS00012ҵ���߼��ӿ�
  * ������¼: 2013/04/25
  * �޸ļ�¼: 
  */
public interface Mss00012BL extends BaseBL {

	/**
	 * MSS00012ʵ��ȡ��
	 *
	 * @return MSS00012ʵ��
	 */
	public Mss00012TB getMSS00012TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00012Info> searchMSS00012();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00012Info searchMSS00012ByPK( Integer id)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00012SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00012Info> searchMSS00012(
			Mss00012SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00012Info> searchMSS00012(
			Mss00012SearchCond cond, int start,
			int count) throws Exception;

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00012Info registMSS00012(Mss00012Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00012Info updateMSS00012(Mss00012Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMSS00012ByPK( Integer id)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMSS00012(Mss00012Info instance)
		throws BLException;

}