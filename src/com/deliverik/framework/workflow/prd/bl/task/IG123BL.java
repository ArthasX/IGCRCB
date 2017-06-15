/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.condition.IG123SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG123TB;

/**
  * ����: �Զ������̻�����Χ��ҵ���߼��ӿ�
  * ��������: �Զ������̻�����Χ��ҵ���߼��ӿ�
  * ������¼: 2013/03/07
  * �޸ļ�¼: 
  */
public interface IG123BL extends BaseBL {

	/**
	 * �Զ������̻�����Χ��ʵ��ȡ��
	 *
	 * @return �Զ������̻�����Χ��ʵ��
	 */
	public IG123TB getIG123TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG123Info> searchIG123();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG123Info searchIG123ByPK(String pk) throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG123SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG123Info> searchIG123(IG123SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG123Info> searchIG123(IG123SearchCond cond, int start, int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG123Info registIG123(IG123Info instance) throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG123Info updateIG123(IG123Info instance) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG123ByPK(String pk) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG123(IG123Info instance) throws BLException;
	
	/**
	 * ����ɾ������
	 * @param list
	 * @throws BLException
	 */
	public void deleteIG123List(List<IG123Info> list) throws BLException;
	
	/**
	 * �������̶���������ѯ
	 * @param pdid ���̶�������
	 * @return ������Χ����
	 * @throws BLException
	 */
	public List<IG123Info> findBypdid(String pdid);
	
	/**
	 * POTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PRTDID����ֵ
	 */
	public String getPotdidSequenceNextValue(String pdid) throws BLException;
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException;
	
	/**
	 * XML�ű����봦��
	 *
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(Element element) throws BLException;

}