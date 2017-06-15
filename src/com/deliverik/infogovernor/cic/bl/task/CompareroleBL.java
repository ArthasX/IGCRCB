/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareroleTB;

/**
  * ����: �Աȹ���ҵ���߼��ӿ�
  * ��������: �Աȹ���ҵ���߼��ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareroleBL extends BaseBL {

	/**
	 * �Աȹ���ʵ��ȡ��
	 *
	 * @return �Աȹ���ʵ��
	 */
	public CompareroleTB getCompareroleTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareroleInfo> searchComparerole();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareroleInfo searchCompareroleByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareroleSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareroleInfo> searchComparerole(
			CompareroleSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareroleInfo> searchComparerole(
			CompareroleSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareroleInfo registComparerole(CompareroleInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareroleInfo updateComparerole(CompareroleInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareroleByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteComparerole(CompareroleInfo instance)
		throws BLException;

	/**
	 * ����
	 * @param instantce
	 * @return
	 */
	public CompareroleInfo save(CompareroleInfo instantce)throws BLException;
	/**
     * ���ݹ�ϵ���ѯ���򼰶���
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<CompareroleInfo> searchCompareroleByRelation(CompareroleSearchCond cond) throws BLException;
}