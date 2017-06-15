/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM01SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM01TB;

/**
  * ����: vCenter ServiceInstanceҵ���߼��ӿ�
  * ��������: vCenter ServiceInstanceҵ���߼��ӿ�
  * ������¼: 2014/02/12
  * �޸ļ�¼: 
  */
public interface VIM01BL extends BaseBL {

	/**
	 * vCenter ServiceInstanceʵ��ȡ��
	 *
	 * @return vCenter ServiceInstanceʵ��
	 */
	public VIM01TB getVIM01TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM01Info> searchVIM01();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM01Info searchVIM01ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM01SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM01Info> searchVIM01(
			VIM01SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM01Info> searchVIM01(
			VIM01SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM01Info registVIM01(VIM01Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM01Info updateVIM01(VIM01Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVIM01ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVIM01(VIM01Info instance)
		throws BLException;

}