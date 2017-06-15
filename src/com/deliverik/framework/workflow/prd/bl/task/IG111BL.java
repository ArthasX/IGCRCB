/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯ��������ʵ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG111BL extends BaseBL{

	/**
	 * ��������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG111Info> searchIG111(IG111SearchCond cond) throws BLException;

	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG111(IG111Info instance) throws BLException;
	
	/**
	 * ȡ����һ��ID
	 * @param pdid ���̶���ID
	 * @return ʵ��ID
	 * @throws BLException
	 */
	public String getNextId(String pdid) throws BLException;

	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG111Info registIG111(IG111Info instance) throws BLException;
	
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

	/**
	 * �������̶���idɾ�� �Զ����ѯ����
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid) throws BLException;

}
