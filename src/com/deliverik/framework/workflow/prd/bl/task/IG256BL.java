/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;

/**
  * ����: ���̲�������ҵ���߼��ӿ�
  * ��������: ���̲�������ҵ���߼��ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG256BL extends BaseBL {

	/**
	 * ���̲�������ʵ��ȡ��
	 *
	 * @return ���̲�������ʵ��
	 */
	public IG256TB getIG256TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG256Info> searchIG256();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG256Info searchIG256ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG256SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG256Info> searchIG256(
			IG256SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG256Info> searchIG256(
			IG256SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG256Info registIG256(IG256Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG256Info updateIG256(IG256Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG256ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG256(IG256Info instance)
		throws BLException;

}