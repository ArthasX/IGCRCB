/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG064Info;
import com.deliverik.framework.workflow.prr.model.condition.IG064SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG064VW;

/**
  * ����: ���̼�¼�ڵ�������ͼҵ���߼��ӿ�
  * ��������: ���̼�¼�ڵ�������ͼҵ���߼��ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG064BL extends BaseBL {

	/**
	 * ���̼�¼�ڵ�������ͼʵ��ȡ��
	 *
	 * @return ���̼�¼�ڵ�������ͼʵ��
	 */
	public IG064VW getIG064VWInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG064Info> searchIG064Info();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG064SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG064Info> searchIG064Info(
			IG064SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG064Info> searchIG064Info(
			IG064SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param ig064Info ����ʵ��
	 * @return ����ʵ��
	 */
	public IG064Info registIG064Info(IG064Info ig064Info)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param ig064Info �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG064Info updateIG064Info(IG064Info ig064Info)
		throws BLException;


	/**
	 * ɾ������
	 *
	 * @param ig064Info ɾ��ʵ��
	 */
	public void deleteIG064Info(IG064Info ig064Info)
		throws BLException;

}