/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.condition.IG110SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��ʾ�ж���ʵ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG110BL extends BaseBL{

	/**
	 * ��������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG110Info> searchIG110(IG110SearchCond cond) throws BLException;

	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG110(IG110Info instance) throws BLException;

	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG110Info registIG110(IG110Info instance) throws BLException;

	/**
	 * ȡ����һ��ID
	 * @param pdid ���̶���ID
	 * @return ʵ��ID
	 * @throws BLException
	 */
	public String getNextId(String pdid) throws BLException;

	/**
	 * �޸Ĵ���
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG110Info updateIG110(IG110Info instance) throws BLException;
	
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
	 * �������̶���idɾ����ʾ��
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid) throws BLException;

}
