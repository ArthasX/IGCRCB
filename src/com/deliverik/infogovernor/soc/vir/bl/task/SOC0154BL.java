/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.SOC0154Info;
import com.deliverik.infogovernor.soc.vir.model.condition.SOC0154SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154PK;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154TB;

/**
  * ����: soc0154ҵ���߼��ӿ�
  * ��������: soc0154ҵ���߼��ӿ�
  * ������¼: 2013/12/29
  * �޸ļ�¼: 
  */
public interface SOC0154BL extends BaseBL {

	/**
	 * soc0154ʵ��ȡ��
	 *
	 * @return soc0154ʵ��
	 */
	public SOC0154TB getSoc0154TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0154Info> searchSoc0154();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0154Info searchSoc0154ByPK(SOC0154PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0154SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0154Info> searchSoc0154(
			SOC0154SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0154Info> searchSoc0154(
			SOC0154SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0154Info registSoc0154(SOC0154Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0154Info updateSoc0154(SOC0154Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSoc0154ByPK(SOC0154PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSoc0154(SOC0154Info instance)
		throws BLException;

}