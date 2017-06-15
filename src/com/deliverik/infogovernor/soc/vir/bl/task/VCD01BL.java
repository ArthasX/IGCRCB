/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD01SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD01TB;

/**
  * ����: vCloud ServiceInstanceҵ���߼��ӿ�
  * ��������: vCloud ServiceInstanceҵ���߼��ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD01BL extends BaseBL {

	/**
	 * vCloud ServiceInstanceʵ��ȡ��
	 *
	 * @return vCloud ServiceInstanceʵ��
	 */
	public VCD01TB getVCD01TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD01Info> searchVCD01();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD01Info searchVCD01ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD01SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD01Info> searchVCD01(
			VCD01SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD01Info> searchVCD01(
			VCD01SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD01Info registVCD01(VCD01Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD01Info updateVCD01(VCD01Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD01ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD01(VCD01Info instance)
		throws BLException;

}