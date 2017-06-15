/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.syslog.model.Mss00006Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00006SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00006TB;

/**
  * ����: �澯��Ϣ�±�ҵ���߼��ӿ�
  * ��������: �澯��Ϣ�±�ҵ���߼��ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00006BL extends BaseBL {

	/**
	 * �澯��Ϣ�±�ʵ��ȡ��
	 *
	 * @return �澯��Ϣ�±�ʵ��
	 */
	public Mss00006TB getMss00006TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00006Info> searchMss00006();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00006Info searchMss00006ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Mss00006SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Mss00006Info> searchMss00006(
			Mss00006SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00006Info> searchMss00006(
			Mss00006SearchCond cond, int start,
			int count) throws Exception;

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Mss00006Info registMss00006(Mss00006Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Mss00006Info updateMss00006(Mss00006Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMss00006ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMss00006(Mss00006Info instance)
		throws BLException;

}