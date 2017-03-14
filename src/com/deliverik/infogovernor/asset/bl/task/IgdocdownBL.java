/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.IgdocdownInfo;
import com.deliverik.infogovernor.asset.model.condition.IgdocdownSearchCond;
import com.deliverik.infogovernor.asset.model.entity.IgdocdownTB;

/**
  * ����: ���ؼ�¼��ҵ���߼��ӿ�
  * ��������: ���ؼ�¼��ҵ���߼��ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface IgdocdownBL extends BaseBL {

	/**
	 * ���ؼ�¼��ʵ��ȡ��
	 *
	 * @return ���ؼ�¼��ʵ��
	 */
	public IgdocdownTB getIgdocdownTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IgdocdownInfo> searchIgdocdown();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IgdocdownInfo searchIgdocdownByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IgdocdownSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IgdocdownInfo> searchIgdocdown(
			IgdocdownSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgdocdownInfo> searchIgdocdown(
			IgdocdownSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IgdocdownInfo registIgdocdown(IgdocdownInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IgdocdownInfo updateIgdocdown(IgdocdownInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIgdocdownByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIgdocdown(IgdocdownInfo instance)
		throws BLException;

	public void insertDate(IgdocdownSearchCond cond)
			throws BLException;
	
}