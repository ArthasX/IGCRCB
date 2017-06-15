/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VCD05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD05SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD05TB;

/**
  * ����: vCloud����ģ��ҵ���߼��ӿ�
  * ��������: vCloud����ģ��ҵ���߼��ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD05BL extends BaseBL {

	/**
	 * vCloud����ģ��ʵ��ȡ��
	 *
	 * @return vCloud����ģ��ʵ��
	 */
	public VCD05TB getVCD05TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD05Info> searchVCD05();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD05Info searchVCD05ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD05Info> searchVCD05(
			VCD05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD05Info> searchVCD05(
			VCD05SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD05Info registVCD05(VCD05Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD05Info updateVCD05(VCD05Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD05ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD05(VCD05Info instance)
		throws BLException;

}