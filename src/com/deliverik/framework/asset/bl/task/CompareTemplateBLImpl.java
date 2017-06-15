/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.CompareTemplateInfo;
import com.deliverik.framework.asset.model.condition.CompareTemplateSearchCond;
import com.deliverik.framework.asset.model.dao.CompareTemplateDAO;
import com.deliverik.framework.asset.model.entity.CompareTemplateTB;

/**
  * ����: compareTemplateҵ���߼�ʵ��
  * ��������: compareTemplateҵ���߼�ʵ��
  * ������¼: 2011/05/23
  * �޸ļ�¼: 
  */
public class CompareTemplateBLImpl extends BaseBLImpl implements
		CompareTemplateBL {

	/** compareTemplateDAO�ӿ� */
	protected CompareTemplateDAO compareTemplateDAO;
	
	/**
	 * compareTemplateDAO�ӿ��趨
	 *
	 * @param compareTemplateDAO compareTemplateDAO�ӿ�
	 */
	public void setCompareTemplateDAO(CompareTemplateDAO compareTemplateDAO) {
		this.compareTemplateDAO = compareTemplateDAO;
	}

	/**
	 * compareTemplateʵ��ȡ��
	 *
	 * @return compareTemplateʵ��
	 */
	public CompareTemplateTB getCompareTemplateTBInstance() {
		return new CompareTemplateTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareTemplateInfo> searchCompareTemplate() {
		return compareTemplateDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareTemplateInfo searchCompareTemplateByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareTemplateSearchCond cond) {
		return compareTemplateDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareTemplateInfo> searchCompareTemplate(
			CompareTemplateSearchCond cond) {
		return compareTemplateDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return compareTemplateDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareTemplateInfo registCompareTemplate(CompareTemplateInfo instance)
		throws BLException {
		return compareTemplateDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareTemplateInfo updateCompareTemplate(CompareTemplateInfo instance)
		throws BLException {
		checkExistInstance(instance.getCtpid());
		return compareTemplateDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareTemplateByPK(Integer pk)
		throws BLException {
		compareTemplateDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareTemplate(CompareTemplateInfo instance)
		throws BLException {
		compareTemplateDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CompareTemplateInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareTemplateInfo instance = compareTemplateDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}