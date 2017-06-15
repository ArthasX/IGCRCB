/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;

/**
  * ����: ȱʡ�����߰�ť�����ҵ���߼��ӿ�
  * ��������: ȱʡ�����߰�ť�����ҵ���߼��ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG725BL extends BaseBL {

	/**
	 * ȱʡ�����߰�ť�����ʵ��ȡ��
	 *
	 * @return ȱʡ�����߰�ť�����ʵ��
	 */
	public IG725TB getIG725TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG725Info> searchIG725Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG725Info searchIG725InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG725SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG725Info> searchIG725Info(
			IG725SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG725Info> searchIG725Info(
			IG725SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG725Info registIG725Info(IG725Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG725Info updateIG725Info(IG725Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG725InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG725Info(IG725Info instance)
		throws BLException;
	/**
	 * PDBDID����ֵȡ��
	 * 
	 * @param psdid
	 * @return 
	 */
	public String getPdbdidSequenceNextValue(String psdid);
	
	/**
	 * ����ȷ�ϰ�ť����
	 *
	 * @param psdid ����״̬ID
	 */
	public void registConfirmButton(String psdid) throws BLException;
	
	/**
	 * ɾ��ȷ�ϰ�ť����
	 *
	 * @param psdid ����״̬ID
	 */
	public void deleteConfirmButton(String psdid) throws BLException;
	
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