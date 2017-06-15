/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;

/**
  * ����: ������ֵ��ҵ���߼��ӿ�
  * ��������: ������ֵ��ҵ���߼��ӿ�
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
public interface IG898BL extends BaseBL {

	/**
	 * ������ֵ��ʵ��ȡ��
	 *
	 * @return ������ֵ��ʵ��
	 */
	public IG898TB getIG898TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG898Info> searchIG898();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG898Info searchIG898ByPK(IG898PK pk) throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG898SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG898Info> searchIG898(IG898SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG898Info> searchIG898(IG898SearchCond cond, int start,int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG898Info registIG898(IG898Info instance) throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG898Info updateIG898(IG898Info instance) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG898ByPK(IG898PK pk) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG898(IG898Info instance) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG898(List<IG898Info> list) throws BLException;
	
	/**
     * ȡ�ñ�����ͱ�������
     *
     * @param cond ��������
     * @return ��������
     */
    public int getTableRowCount(IG898SearchCond cond) throws BLException ;

}