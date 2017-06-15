/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;

/**
  * ����: �����߰�ť������Ϣ����ͼҵ���߼��ӿ�
  * ��������: �����߰�ť������Ϣ����ͼҵ���߼��ӿ�
  * ������¼: 2012/04/19
  * �޸ļ�¼: 
  */
public interface IG221BL extends BaseBL {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG221Info> searchIG221Info();

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG221SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG221Info> searchIG221Info(
			IG221SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG221Info> searchIG221InfoVW(
			IG221SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG221Info> searchIG221Info(
			IG221SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG221Info registIG221Info(IG221Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG221Info updateIG221Info(IG221Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG221Info(IG221Info instance)
		throws BLException;

}