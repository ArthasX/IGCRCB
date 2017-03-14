/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM07SearchCond;

/**
  * ����: ���������Ϣ��ҵ���߼��ӿ�
  * ��������: ���������Ϣ��ҵ���߼��ӿ�
  * ������¼: 2014/03/24
  * �޸ļ�¼: 
  */
public interface VIM07BL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM07Info searchVim07ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM07SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM07Info> searchVim07(VIM07SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM07Info> searchVim07(VIM07SearchCond cond, int start, int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM07Info registVim07(VIM07Info instance) throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM07Info updateVim07(VIM07Info instance) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVim07ByPK(Integer pk) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVim07(VIM07Info instance) throws BLException;

}