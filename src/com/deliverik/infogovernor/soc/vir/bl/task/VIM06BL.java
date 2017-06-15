/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM06SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM06TB;

/**
  * ����: vim06ҵ���߼��ӿ�
  * ��������: vim06ҵ���߼��ӿ�
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
public interface VIM06BL extends BaseBL {

	/**
	 * vim06ʵ��ȡ��
	 *
	 * @return vim06ʵ��
	 */
	public VIM06TB getVim06TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM06Info> searchVim06();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM06Info searchVim06ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM06SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM06Info> searchVim06(
			VIM06SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM06Info> searchVim06(
			VIM06SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM06Info registVim06(VIM06Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM06Info updateVim06(VIM06Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVim06ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVim06(VIM06Info instance)
		throws BLException;

}