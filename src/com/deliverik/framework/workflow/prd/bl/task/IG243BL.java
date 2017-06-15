/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;

/**
  * ����: ���̱��ⶨ���ҵ���߼��ӿ�
  * ��������: ���̱��ⶨ���ҵ���߼��ӿ�
  * ������¼: 2012/03/30
  * �޸ļ�¼: 
  */
public interface IG243BL extends BaseBL {

	/**
	 * ���̱��ⶨ���ʵ��ȡ��
	 *
	 * @return ���̱��ⶨ���ʵ��
	 */
	public IG243TB getIG243TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG243Info> searchIG243Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG243Info searchIG243InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG243SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG243Info> searchIG243Info(
			IG243SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG243Info> searchIG243Info(
			IG243SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG243Info registIG243Info(IG243Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG243Info updateIG243Info(IG243Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG243InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG243Info(IG243Info instance)
		throws BLException;
	
	/**
	 * PTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PTDID����ֵ
	 */
	public String getPtdidSequenceNextValue(String pdid);
	
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