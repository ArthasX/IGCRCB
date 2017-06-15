/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG237PK;
import com.deliverik.framework.workflow.prd.model.entity.IG237TB;

/**
  * ����: ���̲���֪ͨ��ҵ���߼��ӿ�
  * ��������: ���̲���֪ͨ��ҵ���߼��ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG237BL extends BaseBL {

	/**
	 * ���̲���֪ͨ��ʵ��ȡ��
	 *
	 * @return ���̲���֪ͨ��ʵ��
	 */
	public IG237TB getIG237TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG237Info> searchIG237Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG237Info searchIG237InfoByPK(IG237PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG237SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG237Info> searchIG237Info(
			IG237SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG237Info> searchIG237Info(
			IG237SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG237Info registIG237Info(IG237Info instance)
		throws BLException;

	/**
	 * ��������
	 *
	 * @param ig237tblist_temp ����ʵ��
	 * @return ����ʵ��
	 */
	public void registAllIG237Info(List<IG237Info> ig237tblist_temp)
			throws BLException;
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG237Info updateIG237Info(IG237Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG237InfoByPK(IG237PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG237Info(IG237Info instance)
		throws BLException;
	
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