/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VCD04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD04TB;

/**
  * ����: vCloud������־ҵ���߼��ӿ�
  * ��������: vCloud������־ҵ���߼��ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD04BL extends BaseBL {

	/**
	 * vCloud������־ʵ��ȡ��
	 *
	 * @return vCloud������־ʵ��
	 */
	public VCD04TB getVCD04TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD04Info> searchVCD04();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD04Info searchVCD04ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD04SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD04Info> searchVCD04(
			VCD04SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD04Info> searchVCD04(
			VCD04SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD04Info registVCD04(VCD04Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD04Info updateVCD04(VCD04Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD04ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD04(VCD04Info instance)
		throws BLException;

}