/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG132TB;

/**
  * ����: �����߰�ť������Ϣ��ҵ���߼��ӿ�
  * ��������: �����߰�ť������Ϣ��ҵ���߼��ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG132BL extends BaseBL {

	/**
	 * �����߰�ť������Ϣ��ʵ��ȡ��
	 *
	 * @return �����߰�ť������Ϣ��ʵ��
	 */
	public IG132TB getIG132TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG132Info> searchIG132Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG132Info searchIG132InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG132SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG132Info> searchIG132Info(
			IG132SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG132Info> searchIG132Info(
			IG132SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG132Info registIG132Info(IG132Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG132Info updateIG132Info(IG132Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG132InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG132Info(IG132Info instance)
		throws BLException;

	/**
	 * PPBDID����ֵȡ��
	 * 
	 * @param ppdid
	 * @return 
	 */
	public String getPpbdidSequenceNextValue(String ppdid);
	
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