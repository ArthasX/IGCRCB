/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.condition.IG505SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG505TB;

/**
  * ����: ���̱�ֵ��ҵ���߼��ӿ�
  * ��������: ���̱�ֵ��ҵ���߼��ӿ�
  * ������¼: 2013/08/28
  * �޸ļ�¼: 
  */
public interface IG505BL extends BaseBL {

	/**
	 * ���̱�ֵ��ʵ��ȡ��
	 *
	 * @return ���̱�ֵ��ʵ��
	 */
	public IG505TB getIG505TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG505Info> searchIG505();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG505Info searchIG505ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG505SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG505Info> searchIG505(
			IG505SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG505Info> searchIG505(
			IG505SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG505Info registIG505(IG505Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG505Info updateIG505(IG505Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG505ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG505(IG505Info instance)
		throws BLException;
	
	/**
	 * ����������������
	 * @param prid ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG505Info> findByPrid(Integer prid) throws BLException;

}