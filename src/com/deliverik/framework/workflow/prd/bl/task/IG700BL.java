/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG700PK;
import com.deliverik.framework.workflow.prd.model.entity.IG700TB;
 
/**
  * ����: ���̲鿴��ɫ���ñ�ҵ���߼��ӿ�
  * ��������: ���̲鿴��ɫ���ñ�ҵ���߼��ӿ�
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public interface IG700BL extends BaseBL {

	/**
	 * ���̲鿴��ɫ���ñ�ʵ��ȡ��
	 *
	 * @return ���̲鿴��ɫ���ñ�ʵ��
	 */
	public IG700TB getIg700TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG700Info> searchIg700();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG700Info searchIg700ByPK(IG700PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG700SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG700Info> searchIg700(
			IG700SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG700Info> searchIg700(
			IG700SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG700Info registIg700(IG700Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG700Info updateIg700(IG700Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIg700ByPK(IG700PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIg700(IG700Info instance)
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