/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG335PK;
import com.deliverik.framework.workflow.prd.model.entity.IG335TB;

/**
  * ����: �����Ա�ҵ���߼��ӿ�
  * ��������: �����Ա�ҵ���߼��ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG335BL extends BaseBL {

	/**
	 * �����Ա�ʵ��ȡ��
	 *
	 * @return �����Ա�ʵ��
	 */
	public IG335TB getIG335TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG335Info> searchIG335();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG335Info searchIG335ByPK(IG335PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG335SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG335Info> searchIG335(
			IG335SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG335Info> searchIG335(
			IG335SearchCond cond, int start,
			int count);

	/**
	 * ��ʱ֪ͨ���Բ�ѯ
	 * 
	 * @param pdid ���̶���ID
	 * @param psdid ״̬����ID
	 * @param pidid ������ID
	 * @return  ��ʱ֪ͨ�����б�
	 */
	public List<IG335Info> searchIG335Info(String pdid,  String psdid, String pidid, String psdconfirm);
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG335Info registIG335(IG335Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG335Info updateIG335(IG335Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG335ByPK(IG335PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG335(List<IG335Info> instanceList)
			throws BLException;
			
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG335(IG335Info instance)
		throws BLException;

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