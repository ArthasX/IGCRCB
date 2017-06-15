/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG298TB;

/**
  * ����: ����״̬�ɷ��ɽ�ɫ������Ϣҵ���߼��ӿ�
  * ��������: ����״̬�ɷ��ɽ�ɫ������Ϣҵ���߼��ӿ�
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public interface IG298BL extends BaseBL {

	/**
	 * ����״̬�ɷ��ɽ�ɫ������Ϣʵ��ȡ��
	 *
	 * @return ����״̬�ɷ��ɽ�ɫ������Ϣʵ��
	 */
	public IG298TB getIG298TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG298Info> searchIG298Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG298Info searchIG298InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG298SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG298Info> searchIG298Info(
			IG298SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG298Info> searchIG298Info(
			IG298SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG298Info registIG298Info(IG298Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG298Info updateIG298Info(IG298Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG298InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG298Info(IG298Info instance)
		throws BLException;
	
	/**
	 * PSRDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSRDID����ֵ
	 */
	public String getPsrdidSequenceNextValue(String psdid);
	
	/**
	 * ָ��״̬�ɷ��ɽ�ɫ��ѯ
	 *
	 * @param psdid ����״̬ID
	 * @return �ɷ��ɽ�ɫ�б�
	 * @throws BLException 
	 */
	public List<IG298Info> searchIG298Info(
			String psdid) throws BLException;
	
	/**
	 * �ɱ����ɵĽ�ɫ��������
	 * @param pdid ���̶���ID
	 * @param psdid ����״̬ID
	 * @return �ɱ����ɵĽ�ɫ�б�
	 */
	public List<Role> searchToBeAssignRole(String pdid, String psdid);
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ʵ��
	 */
	public IG298Info checkIG298Info(String psdid, Integer roleid)
		throws BLException;
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 * @throws BLException
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