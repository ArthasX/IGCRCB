/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM05SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM05TB;

/**
  * ����: vim05ҵ���߼��ӿ�
  * ��������: vim05ҵ���߼��ӿ�
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
public interface VIM05BL extends BaseBL {

	/**
	 * vim05ʵ��ȡ��
	 *
	 * @return vim05ʵ��
	 */
	public VIM05TB getVim05TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM05Info> searchVim05();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM05Info searchVim05ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM05Info> searchVim05(
			VIM05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM05Info> searchVim05(
			VIM05SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM05Info registVim05(VIM05Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM05Info updateVim05(VIM05Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVim05ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVim05(VIM05Info instance)
		throws BLException;

}