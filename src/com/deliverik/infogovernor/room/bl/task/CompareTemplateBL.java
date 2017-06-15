/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.room.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.room.model.CompareTemplateInfo;
import com.deliverik.infogovernor.room.model.condition.CompareTemplateSearchCond;
import com.deliverik.infogovernor.room.model.entity.CompareTemplateTB;


/**
  * ����: compareTemplateҵ���߼��ӿ�
  * ��������: compareTemplateҵ���߼��ӿ�
  * ������¼: 2011/05/23
  * �޸ļ�¼: 
  */
public interface CompareTemplateBL extends BaseBL {

	/**
	 * compareTemplateʵ��ȡ��
	 *
	 * @return compareTemplateʵ��
	 */
	public CompareTemplateTB getCompareTemplateTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareTemplateInfo> searchCompareTemplate();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareTemplateInfo searchCompareTemplateByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareTemplateSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareTemplateInfo> searchCompareTemplate(
			CompareTemplateSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareTemplateInfo> searchCompareTemplate(
			CompareTemplateSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareTemplateInfo registCompareTemplate(CompareTemplateInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareTemplateInfo updateCompareTemplate(CompareTemplateInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareTemplateByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareTemplate(CompareTemplateInfo instance)
		throws BLException;

}