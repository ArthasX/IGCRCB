/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG001TB;

/**
  * ����: OA��ɫ���ñ�ҵ���߼��ӿ�
  * ��������: OA��ɫ���ñ�ҵ���߼��ӿ�
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public interface IG001BL extends BaseBL {

	/**
	 * OA��ɫ���ñ�ʵ��ȡ��
	 *
	 * @return OA��ɫ���ñ�ʵ��
	 */
	public IG001TB getIG001TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG001Info> searchIG001();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG001Info searchIG001ByPK(Integer pk) throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG001SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG001Info> searchIG001(IG001SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG001Info> searchIG001(IG001SearchCond cond, int start, int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG001Info registIG001(IG001Info instance) throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG001Info updateIG001(IG001Info instance) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG001ByPK(Integer pk) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG001(IG001Info instance) throws BLException;
	/**
	 * ɾ������
	 * @param infoList
	 */
	public void deleteIG001(List<IG001Info> infoList) throws BLException;
}