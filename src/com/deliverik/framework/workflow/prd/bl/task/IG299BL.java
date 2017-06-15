/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG299TB;

/**
  * ����: ״̬�ɷ��ɻ��������ҵ���߼��ӿ�
  * ��������: ״̬�ɷ��ɻ��������ҵ���߼��ӿ�
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public interface IG299BL extends BaseBL {

	/**
	 * ״̬�ɷ��ɻ��������ʵ��ȡ��
	 *
	 * @return ״̬�ɷ��ɻ��������ʵ��
	 */
	public IG299TB getIG299TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG299Info> searchIG299();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG299Info searchIG299ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG299SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG299Info> searchIG299(
			IG299SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG299Info> searchIG299(
			IG299SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG299Info registIG299(IG299Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG299Info updateIG299(IG299Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG299ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG299(IG299Info instance)
		throws BLException;

	/**
	 * PSODID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSODID����ֵ
	 */
	public String getPsrdidSequenceNextValue(String psdid) ;
	
	/**
	 * ָ��״̬�ɷ��ɻ�����ѯ
	 *
	 * @param psdid ����״̬ID
	 * @return �ɷ��ɻ����б�
	 * @throws BLException 
	 */
	public List<IG299Info> searchIG299Info(
			String psdid) throws BLException;
	
	/**
	 * �ɱ����ɵĻ�����������
	 * @param pdid ��������ID
	 * @param levellen �����ĵ�ǰ����
	 * @param psdid ����״̬�ڵ�ID
	 * @return �ɱ����ɵĻ����б�
	 */
	public List<Organization> searchToBeAssignOrg(String pdid, int levellen, String psdid);

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