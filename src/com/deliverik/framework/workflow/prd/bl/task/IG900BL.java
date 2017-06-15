/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG900Info;
import com.deliverik.framework.workflow.prd.model.condition.IG900SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG900TB;

/**
  * ����: ���̰�ť�����ҵ���߼��ӿ�
  * ��������: ���̰�ť�����ҵ���߼��ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG900BL extends BaseBL {

	/**
	 * ���̰�ť�����ʵ��ȡ��
	 *
	 * @return ���̰�ť�����ʵ��
	 */
	public IG900TB getIG900TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG900Info> searchIG900Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG900Info searchIG900InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG900SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG900Info> searchIG900Info(
			IG900SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG900Info> searchIG900Info(
			IG900SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG900Info registIG900Info(IG900Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG900Info updateIG900Info(IG900Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG900InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG900Info(IG900Info instance)
		throws BLException;

}