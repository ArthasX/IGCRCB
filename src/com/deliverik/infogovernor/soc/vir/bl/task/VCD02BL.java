/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD02TB;

/**
  * ����: ������Դ��Ŀ��Ϣҵ���߼��ӿ�
  * ��������: ������Դ��Ŀ��Ϣҵ���߼��ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD02BL extends BaseBL {

	/**
	 * ������Դ��Ŀ��Ϣʵ��ȡ��
	 *
	 * @return ������Դ��Ŀ��Ϣʵ��
	 */
	public VCD02TB getVCD02TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD02Info> searchVCD02();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD02Info searchVCD02ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD02Info> searchVCD02(
			VCD02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD02Info> searchVCD02(
			VCD02SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD02Info registVCD02(VCD02Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD02Info updateVCD02(VCD02Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD02ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD02(VCD02Info instance)
		throws BLException;

}