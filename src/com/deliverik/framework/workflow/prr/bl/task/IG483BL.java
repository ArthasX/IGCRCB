/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;

/**
  * ����: ������ʵ����ҵ���߼��ӿ�
  * ��������: ������ʵ����ҵ���߼��ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG483BL extends BaseBL {

	/**
	 * ������ʵ����ʵ��ȡ��
	 *
	 * @return ������ʵ����ʵ��
	 */
	public IG483TB getIG483TBInstance();
	
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG483Info> searchIG483();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG483Info searchIG483ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG483SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG483Info> searchIG483(
			IG483SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG483Info> searchIG483(
			IG483SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG483Info registIG483(IG483Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG483Info updateIG483(IG483Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG483ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG483(IG483Info instance)
		throws BLException;
	
	/**
	 * ��ѯ�������Ա�б�
	 * @param pgrid ������ID
	 * @return �������Ա�б�
	 */
	public List<IG500Info> searchProcess(Integer pgrid);

	/**
	 * ��ѯ�������ⷢ�������prid
	 * @param pgrid ��������-������ʵ��ID
	 */
	public List<Map<String,Object>> searchProcessInfoByCond(final int pgrid);
	
}