/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.condition.IG108SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG108TB;

/**
  * ����: �Զ������̱���ѯ���������ҵ���߼��ӿ�
  * ��������: �Զ������̱���ѯ���������ҵ���߼��ӿ�
  * ������¼: 2013/03/13
  * �޸ļ�¼: 
  */
public interface IG108BL extends BaseBL {

	/**
	 * �Զ������̱���ѯ���������ʵ��ȡ��
	 *
	 * @return �Զ������̱���ѯ���������ʵ��
	 */
	public IG108TB getIG108TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG108Info> searchIG108();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG108Info searchIG108ByPK(Integer pk) throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG108SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG108Info> searchIG108(IG108SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG108Info> searchIG108(IG108SearchCond cond, int start,int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG108Info registIG108(IG108Info instance) throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG108Info updateIG108(IG108Info instance) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG108ByPK(Integer pk) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG108(IG108Info instance) throws BLException;
	/**
	 * ��������������������
	 * @param pdid
	 * @return
	 */
	public List<IG108Info> findBypdid(String pdid);
	
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