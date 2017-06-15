/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG037Info;
import com.deliverik.framework.workflow.prr.model.condition.IG037SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG037TB;

/**
  * ����: ���̵�����־��ҵ���߼��ӿ�
  * ��������: ���̵�����־��ҵ���߼��ӿ�
  * ������¼: 2014/11/14
  * �޸ļ�¼: 
  */
public interface IG037BL extends BaseBL {

	/**
	 * ���̵�����־��ʵ��ȡ��
	 *
	 * @return ���̵�����־��ʵ��
	 */
	public IG037TB getIG037TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG037Info> searchIG037();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG037Info searchIG037ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG037SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG037Info> searchIG037(
			IG037SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG037Info> searchIG037(
			IG037SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG037Info registIG037(IG037Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG037Info updateIG037(IG037Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG037ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG037(IG037Info instance)
		throws BLException;

}