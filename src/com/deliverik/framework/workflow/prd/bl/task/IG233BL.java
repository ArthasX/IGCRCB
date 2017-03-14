/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG233PK;
import com.deliverik.framework.workflow.prd.model.entity.IG233TB;

/**
  * ����: �Զ������̷��ɶ����ҵ���߼��ӿ�
  * ��������: �Զ������̷��ɶ����ҵ���߼��ӿ�
  * ������¼: 2013/03/12
  * �޸ļ�¼: 
  */
public interface IG233BL extends BaseBL {

	/**
	 * �Զ������̷��ɶ����ʵ��ȡ��
	 *
	 * @return �Զ������̷��ɶ����ʵ��
	 */
	public IG233TB getIG233TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG233Info> searchIG233();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG233Info searchIG233ByPK(IG233PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG233SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG233Info> searchIG233(IG233SearchCond cond);
	
	/**
	 * ����״̬id��ѯ
	 * @param psdid
	 * @return
	 */
	public List<IG233Info> searchByPsdid(String psdid);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG233Info> searchIG233(IG233SearchCond cond, int start,int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG233Info registIG233(IG233Info instance)throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG233Info updateIG233(IG233Info instance)throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG233ByPK(IG233PK pk)throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG233(IG233Info instance)throws BLException;
	
	/**
	 * ����ɾ��
	 * @param list
	 */
	public void deleteIG233(List<IG233Info> list);
	
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