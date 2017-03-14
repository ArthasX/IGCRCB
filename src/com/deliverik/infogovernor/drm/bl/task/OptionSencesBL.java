/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCond;
import com.deliverik.infogovernor.drm.model.entity.OptionSencesTB;

/**
  * ����: ��ѡ����ҵ���߼��ӿ�
  * ��������: ��ѡ����ҵ���߼��ӿ�
  * ������¼: 2016/10/09
  * �޸ļ�¼: 
  */
public interface OptionSencesBL extends BaseBL {

	/**
	 * ��ѡ����ʵ��ȡ��
	 *
	 * @return ��ѡ����ʵ��
	 */
	public OptionSencesTB getOptionSencesTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OptionSencesInfo> searchOptionSences();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public OptionSencesInfo searchOptionSencesByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(OptionSencesSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<OptionSencesInfo> searchOptionSences(
			OptionSencesSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<OptionSencesInfo> searchOptionSences(
			OptionSencesSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public OptionSencesInfo registOptionSences(OptionSencesInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public OptionSencesInfo updateOptionSences(OptionSencesInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteOptionSencesByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteOptionSences(OptionSencesInfo instance)
		throws BLException;

}