/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.emo.model.EmInfo;
import com.deliverik.infogovernor.emo.model.condition.EmSearchCond;
import com.deliverik.infogovernor.emo.model.entity.EmTB;

/**
  * ����: oracle���ܲɼ�ҵ���߼��ӿ�
  * ��������: oracle���ܲɼ�ҵ���߼��ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface EmBL extends BaseBL {

	/**
	 * oracle���ܲɼ�ʵ��ȡ��
	 *
	 * @return oracle���ܲɼ�ʵ��
	 */
	public EmTB getEmTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmInfo> searchEm();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmInfo searchEmByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EmSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EmInfo> searchEm(
			EmSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmInfo> searchEm(
			EmSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EmInfo registEm(EmInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EmInfo updateEm(EmInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEmByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEm(EmInfo instance)
		throws BLException;

}