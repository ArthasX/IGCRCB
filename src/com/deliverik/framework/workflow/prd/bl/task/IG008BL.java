/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG008PK;
import com.deliverik.framework.workflow.prd.model.entity.IG008TB;

/**
  * ����: ��Ա����ɫ�޶�ҵ���߼��ӿ�
  * ��������: ��Ա����ɫ�޶�ҵ���߼��ӿ�
  * ������¼: 2013/11/27
  * �޸ļ�¼: 
  */
public interface IG008BL extends BaseBL {

	/**
	 * ��Ա����ɫ�޶�ʵ��ȡ��
	 *
	 * @return ��Ա����ɫ�޶�ʵ��
	 */
	public IG008TB getIG008TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG008Info> searchIG008();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG008Info searchIG008ByPK(IG008PK pk) throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG008SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG008Info> searchIG008(IG008SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG008Info> searchIG008(IG008SearchCond cond, int start,int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG008Info registIG008(IG008Info instance) throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG008Info updateIG008(IG008Info instance) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG008ByPK(IG008PK pk) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG008(IG008Info instance) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param entitys ɾ��ʵ������
	 */
	public void deleteIG008(List<IG008Info> entitys) throws BLException;
	
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