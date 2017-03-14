/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.condition.IG506SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;

/**
  * ����: ��Ա���ֵ��ҵ���߼��ӿ�
  * ��������: ��Ա���ֵ��ҵ���߼��ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG506BL extends BaseBL {

	/**
	 * ��Ա���ֵ��ʵ��ȡ��
	 *
	 * @return ��Ա���ֵ��ʵ��
	 */
	public IG506TB getIG506TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG506Info> searchIG506();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG506Info searchIG506ByPK(Integer pk) throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG506SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG506Info> searchIG506(IG506SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG506Info> searchIG506(IG506SearchCond cond, int start,int count);
	
	/**
	 * ����������������
	 * @param prid ��������
	 * @return
	 * @throws BLException
	 */
	public List<IG506Info> findByPrid(Integer prid) throws BLException;

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG506Info registIG506(IG506Info instance) throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG506Info updateIG506(IG506Info instance) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG506ByPK(Integer pk) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG506(IG506Info instance) throws BLException;

}