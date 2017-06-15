/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.condition.AcceptuserSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.AcceptuserTB;

/**
  * ����: ���չ�����ʾ���������ݱ�ҵ���߼��ӿ�
  * ��������: ���չ�����ʾ���������ݱ�ҵ���߼��ӿ�
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public interface AcceptuserBL extends BaseBL {

	/**
	 * ���չ�����ʾ���������ݱ�ʵ��ȡ��
	 *
	 * @return ���չ�����ʾ���������ݱ�ʵ��
	 */
	public AcceptuserTB getAcceptuserTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AcceptuserInfo> searchAcceptuser();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AcceptuserInfo searchAcceptuserByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AcceptuserSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AcceptuserInfo> searchAcceptuser(
			AcceptuserSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AcceptuserInfo> searchAcceptuser(
			AcceptuserSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AcceptuserInfo registAcceptuser(AcceptuserInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AcceptuserInfo updateAcceptuser(AcceptuserInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAcceptuserByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAcceptuser(AcceptuserInfo instance)
		throws BLException;

}