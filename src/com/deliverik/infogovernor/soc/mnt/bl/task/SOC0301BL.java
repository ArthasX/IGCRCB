/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0301TB;

/**
  * ����: DMXʵʱ������ܱ�ҵ���߼��ӿ�
  * ��������: DMXʵʱ������ܱ�ҵ���߼��ӿ�
  * ������¼: 2012/05/16
  * �޸ļ�¼: 
  */
public interface SOC0301BL extends BaseBL {

	/**
	 * DMXʵʱ������ܱ�ʵ��ȡ��
	 *
	 * @return DMXʵʱ������ܱ�ʵ��
	 */
	public SOC0301TB getSoc0301Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0301Info> searchSoc0301();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0301Info searchSoc0301ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0301SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0301Info> searchSoc0301(
			SOC0301SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0301Info> searchSoc0301(
			SOC0301SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0301Info registSoc0301(SOC0301Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0301Info updateSoc0301(SOC0301Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSoc0301ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSoc0301(SOC0301Info instance)
		throws BLException;
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0301Info> searchSoc0301OrderByTimeAndName(
			SOC0301SearchCond cond);
}