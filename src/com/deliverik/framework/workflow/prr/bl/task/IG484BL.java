/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG484PK;
import com.deliverik.framework.workflow.prr.model.entity.IG484TB;

/**
  * ����: �������Աʵ��ҵ���߼��ӿ�
  * ��������: �������Աʵ��ҵ���߼��ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG484BL extends BaseBL {

	/**
	 * �������Աʵ��ʵ��ȡ��
	 *
	 * @return �������Աʵ��ʵ��
	 */
	public IG484TB getIG484TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG484Info> searchIG484();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG484Info searchIG484ByPK(IG484PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG484SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG484Info> searchIG484(
			IG484SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG484Info> searchIG484(
			IG484SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG484Info registIG484(IG484Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG484Info updateIG484(IG484Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG484ByPK(IG484PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG484(IG484Info instance)
		throws BLException;
	
	/**
	 * ͨ����һ���̲�ѯ�������ʵ��pgrid
	 *
	 * @param prid ����id
	 * @return �������pgrid ������ؿ���ǰ���̲���������������
	 */
	public Integer searchIG484PgridByPrid(Integer prid);

}