/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG555Info;
import com.deliverik.framework.workflow.prr.model.condition.IG555SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG555TB;

/**
  * ����: ���̴���ҳ����������Ϣҵ���߼��ӿ�
  * ��������: ���̴���ҳ����������Ϣҵ���߼��ӿ�
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
public interface IG555BL extends BaseBL {

	/**
	 * ���̴���ҳ����������Ϣʵ��ȡ��
	 *
	 * @return ���̴���ҳ����������Ϣʵ��
	 */
	public IG555TB getIG555TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG555Info> searchIG555Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG555Info searchIG555InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG555SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG555Info> searchIG555Info(
			IG555SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG555Info> searchIG555Info(
			IG555SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG555Info registIG555Info(IG555Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG555Info updateIG555Info(IG555Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG555InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG555Info(IG555Info instance)
		throws BLException;

}