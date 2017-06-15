/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareresultTB;

/**
  * ����: �ȶԽ��ҵ���߼��ӿ�
  * ��������: �ȶԽ��ҵ���߼��ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareresultBL extends BaseBL {

	/**
	 * �ȶԽ��ʵ��ȡ��
	 *
	 * @return �ȶԽ��ʵ��
	 */
	public CompareresultTB getCompareresultTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareresultInfo> searchCompareresult();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareresultInfo searchCompareresultByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareresultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareresultInfo> searchCompareresult(
			CompareresultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareresultInfo> searchCompareresult(
			CompareresultSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareresultInfo registCompareresult(CompareresultInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareresultInfo updateCompareresult(CompareresultInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareresultByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareresult(CompareresultInfo instance)
		throws BLException;

	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<CompareresultVWInfo> searchCompareresultVW(CompareresultSearchCond cond) throws BLException ;
    
    /**
     * ���ݶ���ȶԽ������List
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<Object[]> getEnameList(final CompareresultSearchCond cond) throws BLException;
}