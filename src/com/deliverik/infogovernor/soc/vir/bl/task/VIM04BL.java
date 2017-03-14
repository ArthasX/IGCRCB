/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM04TB;

/**
  * ����: ��־��ҵ���߼��ӿ�
  * ��������: ��־��ҵ���߼��ӿ�
  * ������¼: 2014/02/19
  * �޸ļ�¼: 
  */
public interface VIM04BL extends BaseBL {

	/**
	 * ��־��ʵ��ȡ��
	 *
	 * @return ��־��ʵ��
	 */
	public VIM04TB getVIM04TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM04Info> searchVIM04();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM04Info searchVIM04ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM04SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM04Info> searchVIM04(
			VIM04SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM04Info> searchVIM04(
			VIM04SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM04Info registVIM04(VIM04Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM04Info updateVIM04(VIM04Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVIM04ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVIM04(VIM04Info instance)
		throws BLException;

}