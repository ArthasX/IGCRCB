/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareprocessSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareprocessTB;

/**
  * ����: �Աȼ�¼ҵ���߼��ӿ�
  * ��������: �Աȼ�¼ҵ���߼��ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareprocessBL extends BaseBL {

	/**
	 * �Աȼ�¼ʵ��ȡ��
	 *
	 * @return �Աȼ�¼ʵ��
	 */
	public CompareprocessTB getCompareprocessTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareprocessInfo> searchCompareprocess();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareprocessInfo searchCompareprocessByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareprocessSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareprocessInfo> searchCompareprocess(
			CompareprocessSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareprocessInfo> searchCompareprocess(
			CompareprocessSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareprocessInfo registCompareprocess(CompareprocessInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareprocessInfo updateCompareprocess(CompareprocessInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareprocessByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareprocess(CompareprocessInfo instance)
		throws BLException;

}