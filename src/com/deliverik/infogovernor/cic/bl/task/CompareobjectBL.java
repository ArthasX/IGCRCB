/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectTB;

/**
  * ����: �Աȶ���ҵ���߼��ӿ�
  * ��������: �Աȶ���ҵ���߼��ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareobjectBL extends BaseBL {

	/**
	 * �Աȶ���ʵ��ȡ��
	 *
	 * @return �Աȶ���ʵ��
	 */
	public CompareobjectTB getCompareobjectTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareobjectInfo> searchCompareobject();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareobjectInfo searchCompareobjectByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareobjectSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareobjectInfo> searchCompareobject(
			CompareobjectSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareobjectInfo> searchCompareobject(
			CompareobjectSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareobjectInfo registCompareobject(CompareobjectInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareobjectInfo updateCompareobject(CompareobjectInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareobjectByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareobject(CompareobjectInfo instance)
		throws BLException;

	/**
	 * ���ϱ���
	 * @param instantce
	 * @throws BLException
	 */
	public void save(List<CompareobjectInfo> instantce)throws BLException;
	
	/**
	 * ת�ƶԱȶ��� ��ʷ����
	 * @param crid
	 * @return
	 */
	public boolean toHistory(Integer crid)throws BLException;
	/**
	 * ���ݹ���ɾ���Աȶ���
	 * @param crid
	 * @return
	 */
	public boolean delByCrid(Integer crid)throws BLException;
}