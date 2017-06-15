/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG212PK;
import com.deliverik.framework.workflow.prd.model.entity.IG212TB;

/**
  * ����: ����֪ͨ����ҵ���߼��ӿ�
  * ��������: ����֪ͨ����ҵ���߼��ӿ�
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
public interface IG212BL extends BaseBL {

	/**
	 * ����֪ͨ����ʵ��ȡ��
	 *
	 * @return ����֪ͨ����ʵ��
	 */
	public IG212TB getIG212TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG212Info> searchIG212Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG212Info searchIG212InfoByPK(IG212PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG212SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG212Info> searchIG212Info(
			IG212SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG212Info> searchIG212Info(
			IG212SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG212Info registIG212Info(IG212Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG212Info updateIG212Info(IG212Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG212InfoByPK(IG212PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG212Info(IG212Info instance)
		throws BLException;
	
	/**
	 * ����֪ͨ���Բ�ѯ
	 * 
	 * @param pdid ���̶���ID
	 * @return ����֪ͨ�����б�
	 */
	public List<IG238Info> searchIG238Info(String pdid);
	
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