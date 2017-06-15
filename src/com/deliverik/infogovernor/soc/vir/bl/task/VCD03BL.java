/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD03TB;

/**
  * ����: ��Դ���������Ϣҵ���߼��ӿ�
  * ��������: ��Դ���������Ϣҵ���߼��ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD03BL extends BaseBL {

	/**
	 * ��Դ���������Ϣʵ��ȡ��
	 *
	 * @return ��Դ���������Ϣʵ��
	 */
	public VCD03TB getVCD03TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD03Info> searchVCD03();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD03Info searchVCD03ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD03Info> searchVCD03(
			VCD03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD03Info> searchVCD03(
			VCD03SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD03Info registVCD03(VCD03Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD03Info updateVCD03(VCD03Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD03ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD03(VCD03Info instance)
		throws BLException;

}