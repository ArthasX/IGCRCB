/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG334TB;

/**
  * ����: ֪ͨ���Ի�����Ϣҵ���߼��ӿ�
  * ��������: ֪ͨ���Ի�����Ϣҵ���߼��ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG334BL extends BaseBL {

	/**
	 * ֪ͨ���Ի�����Ϣʵ��ȡ��
	 *
	 * @return ֪ͨ���Ի�����Ϣʵ��
	 */
	public IG334TB getIG334TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG334Info> searchIG334();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG334Info searchIG334ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG334SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG334Info> searchIG334(
			IG334SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG334Info> searchIG334(
			IG334SearchCond cond, int start,
			int count);

	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG334VWInfo> findByCondTactics(final IG334SearchCond cond);
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG334Info registIG334(IG334Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG334Info updateIG334(IG334Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG334ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG334(IG334Info instance)
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