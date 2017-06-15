/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;

/**
 * <p>
 * ����ҳ�涨��ҵ���߼�
 * </p>
 */

public interface IG126BL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG126SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pedid ����ҳ�涨��ID
	 * @return ����ҳ�涨����Ϣ
	 */
	public IG126Info searchIG126InfoByKey(String pedid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ������ҳ�涨����Ϣ
	 */
	public List<IG126Info> searchIG126InfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG126Info> searchIG126Info(IG126SearchCond cond, int start, int count);
	
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG126Info> searchIG126Info(IG126SearchCond cond);

	/**
	 * ��¼����
	 * 
	 * @param IG126 ��¼����
	 * @return ����ҳ�涨����Ϣ
	 */
	public IG126Info registIG126Info(IG126Info ig126Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pedid ����ҳ�涨��ID
	 */
	public void deleteIG126Info(String pedid) throws BLException;

	/**
	 * �������
	 * 
	 * @param IG126 �������
	 * @return ����ҳ�涨����Ϣ
	 */
	public IG126Info updateIG126Info(IG126Info ig126Info) throws BLException;
	
	/**
	 * PJDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PJDID����ֵ
	 */
	public String getPjdidSequenceNextValue(String pdid);

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
