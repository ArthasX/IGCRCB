/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;

/**
  * ����: ������Դ��Ŀ��Ϣ��ҵ���߼��ӿ�
  * ��������: ������Դ��Ŀ��Ϣ��ҵ���߼��ӿ�
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public interface VIM02BL extends BaseBL {

	/**
	 * ������Դ��Ŀ��Ϣ��ʵ��ȡ��
	 *
	 * @return ������Դ��Ŀ��Ϣ��ʵ��
	 */
	public VIM02TB getVIM02TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM02Info> searchVIM02();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM02Info searchVIM02ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM02Info> searchVIM02(
			VIM02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM02Info> searchVIM02(
			VIM02SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM02Info registVIM02(VIM02Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM02Info updateVIM02(VIM02Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVIM02ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVIM02(VIM02Info instance)
		throws BLException;

}