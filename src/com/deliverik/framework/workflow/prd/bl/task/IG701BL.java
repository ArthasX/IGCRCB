/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;
 
import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701TB;

/**
  * ����: ���̲鿴��ɫ��Ȩ����ҵ���߼��ӿ�
  * ��������: ���̲鿴��ɫ��Ȩ����ҵ���߼��ӿ�
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public interface IG701BL extends BaseBL {

	/**
	 * ���̲鿴��ɫ��Ȩ����ʵ��ȡ��
	 *
	 * @return ���̲鿴��ɫ��Ȩ����ʵ��
	 */
	public IG701TB getIg701TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG701Info> searchIg701();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG701Info searchIg701ByPK(IG701PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG701SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG701Info> searchIg701(
			IG701SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG701Info> searchIg701(
			IG701SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG701Info registIg701(IG701Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG701Info updateIg701(IG701Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIg701ByPK(IG701PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIg701(IG701Info instance)
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