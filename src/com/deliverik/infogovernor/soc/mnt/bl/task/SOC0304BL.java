/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0304SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0304TB;

/**
  * ����: �����������ҵ���߼��ӿ�
  * ��������: �����������ҵ���߼��ӿ�
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public interface SOC0304BL extends BaseBL {

	/**
	 * �����������ʵ��ȡ��
	 *
	 * @return �����������ʵ��
	 */
	public SOC0304TB getSoc0304Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0304Info> searchSoc0304();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0304Info searchSoc0304ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0304SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0304Info> searchSoc0304(
			SOC0304SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0304Info> searchSoc0304(
			SOC0304SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0304Info registSoc0304(SOC0304Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0304Info updateSoc0304(SOC0304Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSoc0304ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSoc0304(SOC0304Info instance)
		throws BLException;

}