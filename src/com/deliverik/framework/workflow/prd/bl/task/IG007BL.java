/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;
import java.util.Map;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * <p>
 * ���̱�������ҵ���߼�
 * </p>
 */

public interface IG007BL extends BaseBL {

	/**
	 * ��ȡ���̱�������ʵ��
	 * 
	 * @return ProcessInfoDefTB
	 * @throws BLException
	 */
	
	public IG007TB getIG007TBInstance();
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG007InfoSearchCount(IG007SearchCond cond);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG007Info> searchIG007Info(IG007SearchCond cond);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG007Info> searchIG007Info(IG007SearchCond cond, int start, int count);
	
	/**
	 * ���洦��
	 * 
	 * @param ig007Info ���̱�����������
	 * @return ���̱���������Ϣ
	 */
	public IG007Info registIG007Info(IG007Info ig007Info) throws BLException;
	
	/**
	 * ���´���
	 * 
	 * @param ig007Info ��������
	 * @return ȫ�ֱ���
	 */
	public IG007Info updateIG007Info(IG007Info ig007Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pipdid ���̱�����������
	 * @return
	 */
	public void deleteIG007InfoByKey(String pidid) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param ig007Info ���̱�������
	 * @return
	 */
	public void deleteIG007Info(IG007Info ig007Info) throws BLException;
	
	/**
	 * ���̱���������Ϣ��������
	 * 
	 * @param pidid ���̱���ID
	 * @return ���̱���������Ϣ
	 * @throws BLException 
	 */
	public IG007Info searchIG007InfoByKey(String pidid) throws BLException;
	
	/**
	 * ��ȡ���̱�������
	 * @param pdid ���̶���ID
	 * @return  ���̱�������
	 */
	
	public List<IG007Info> searchIG007InfoByPdid(String pdid);
	
	/**
	 * ��ȡ���̱���ȱʡ������
	 * @param pdid ���̶���ID
	 * @return  ���̱���ȱʡ�����˼���
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid);
	
	/**
	 * ��ȡ���̱������ϣ�������ȱʡ����
	 * @param pdid ���̶���ID
	 * @return  ���̱�������
	 */
	
	public List<IG007Info> searchIG007InfoNoDefault(String pdid);
	
	/**
	 * ��ȡ���̱���ȱʡ���������˼���
	 * @param pdid ���̶���ID
	 * @return  ���̱���ȱʡ���������˼���
	 */
	
	public List<IG337Info> searchDefaultApprovorDispatcherByPdid(String pdid);
	
	/**
	 * PIDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PIDID����ֵ
	 */
	public String getPididSequenceNextValue(String pdid);
	
	/**
	 * ���ݱ�����ѯ��������Ϣ
	 * 
	 * @param pdid ���̶���ID
	 * @param name ����
	 * @return ��������Ϣ
	 * @throws BLException
	 */
	public IG007Info searchIG007Info(String pdid, String name) throws BLException;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG007Info> searchIG007InfoRun(IG007SearchCond cond);
	
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
