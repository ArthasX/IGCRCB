/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */


package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;

/**
 * ����״̬����ǰ����ҵ���߼�
 * 
 */

public interface IG211BL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getIG211InfoSearchCount(IG211SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param psidid ����״̬����ǰ����ID
	 * @return ����״̬����ǰ������Ϣ
	 */
	
	public IG211Info searchIG211InfoByKey(String psidid) throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	public List<IG211Info> searchIG211Info(
			IG211SearchCond cond, int start, int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<IG211Info> searchIG211Info(IG211SearchCond cond);

	/**
	 * ��������
	 * 
	 * @param IG211Info ��������
	 * @return �ʲ���Ϣ
	 */
	
	public IG211Info registIG211Info(
			IG211Info ig211Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param psidid ɾ������״̬����ǰ��������
	 * @return
	 */
	
	public void deleteIG211Info(String psidid) throws BLException;

	/**
	 * �������
	 * 
	 * @param ig211Info �������
	 * @return ����״̬����ǰ����
	 */
	
	public IG211Info updateIG211Info(
			IG211Info ig211Info) throws BLException;
	
	/**
	 * ����״̬ǰ���������Ϣʵ��
	 * 
	 * @return ����״̬ǰ�������
	 */
	
	public IG211TB getIG211TBInstance();
	
	/**
	 * PSIDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSIDID����ֵ
	 */
	public String getPsididSequenceNextValue(String psdid);
	
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
