/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCond;
import com.deliverik.infogovernor.soc.model.entity.CR03PK;
import com.deliverik.infogovernor.soc.model.entity.CR03TB;

/**
  * ����: ����ԭ������������ϵ��ҵ���߼��ӿ�
  * ��������: ����ԭ������������ϵ��ҵ���߼��ӿ�
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
public interface CR03BL extends BaseBL {

	/**
	 * ����ԭ������������ϵ��ʵ��ȡ��
	 *
	 * @return ����ԭ������������ϵ��ʵ��
	 */
	public CR03TB getCR03TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CR03Info> searchCR03();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CR03Info searchCR03ByPK(CR03PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CR03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CR03Info> searchCR03(
			CR03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CR03Info> searchCR03(
			CR03SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CR03Info registCR03(CR03Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CR03Info updateCR03(CR03Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCR03ByPK(CR03PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCR03(CR03Info instance)
		throws BLException;
	/**
	 * ��ѯ��¼
	 *
	 * @param instance ��ѯʵ��
	 */
	public List<CR03Info> findByCondMax(
			final CR03SearchCond cond, final int start, 
			final int count);
	/**
	 * ������������[������ڵĵ����type]
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CR03VWInfo> findByCondMaxAndEsyscoding(final CR03SearchCond cond, final int start, final int count);
	
	/**
	 * ���������������ȡ��[������ڵĵ����type]
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCountByCondMaxAndEsyscoding(final CR03SearchCond cond);
	
	/**
	 * ��ȡ���òɼ��İ汾��Ϣ
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CR03VWInfo> getRciVersions(final CR03SearchCond cond, final int start, final int count);

}