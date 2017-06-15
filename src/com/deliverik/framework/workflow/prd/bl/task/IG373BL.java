/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG373TB;

/**
  * ����: ���̱���ʼ���¼������ҵ���߼��ӿ�
  * ��������: ���̱���ʼ���¼������ҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 
  */
public interface IG373BL extends BaseBL {

	/**
	 * ���̱���ʼ���¼������ʵ��ȡ��
	 *
	 * @return ���̱���ʼ���¼������ʵ��
	 */
	public IG373TB getIG373TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG373Info> searchIG373Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG373Info searchIG373InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG373SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG373Info> searchIG373Info(
			IG373SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG373Info> searchIG373Info(
			IG373SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG373Info registIG373Info(IG373Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG373Info updateIG373Info(IG373Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG373InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG373Info(IG373Info instance)
		throws BLException;
	
	/**
	 * PIIDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PIIDID����ֵ
	 */
	public String getPiididSequenceNextValue(String psdid);
	
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