/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG213TB;

/**
 * <p>
 * ���̽�ɫ���ʹ���ҵ���߼� 
 * </p>
 */

public interface IG213BL extends BaseBL {
	
	/**
	 * �����̽�ɫ����ʵ��
	 * 
	 * @return ProcessRoleTypeDefTB
	 * @throws BLException
	 */
	
	public IG213TB getIG213TBInstance();
	
	/**
	 * �����������̽�ɫ������Ϣ
	 * @param cond ���̽�ɫ������Ϣ��������
	 * @return ���̽�ɫ������Ϣ����б�
	 * @throws BLException
	 */
	public List<IG213Info> searchIG213Info(IG213SearchCond cond);
	
	/**
	 * �����������̽�ɫ������Ϣ
	 * @param cond ���̽�ɫ������Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ���̽�ɫ������Ϣ����б�
	 * @throws BLException
	 */
	public List<IG213Info> searchIG213Info(IG213SearchCond cond, int start, int count);
	
	/**
	 * ��������ID��ȡ���̽�ɫ����
	 * @param pdid ����ID
	 * @return ���̽�ɫ����
	 * @throws BLException
	 */
	public IG213Info searchIG213InfoByKey(String prtdid) throws BLException;
	
	/**
	 * �������̽�ɫ���Ͷ��崦��
	 * 
	 * @param ig213Info ��������
	 * @return ���̽�ɫ���Ͷ���
	 */
	
	public IG213Info registIG213Info(
			IG213Info ig213Info) throws BLException;
	
	/**
	 * ɾ������
	 * 
	 * @param pdid ���̽�ɫ���Ͷ���
	 * @return
	 */
	
	public void deleteIG213InfoByKey(String prtdid) throws BLException;
	
	/**
	 * �������
	 * 
	 * @param ig213Info �������
	 * @return ���̽�ɫ���Ͷ���
	 */
	
	public IG213Info updateIG213Info(
			IG213Info ig213Info) throws BLException;
	
	/**
	 * PRTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PRTDID����ֵ
	 */
	public String getPrtdidSequenceNextValue(String pdid);
	
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
