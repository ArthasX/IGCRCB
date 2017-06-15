/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;

/** 
 * ����ȱʡ�����߱���Ȩ��ҵ���߼�
 *
 */
public interface IG699BL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG699InfoSearchCount(IG699SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pipdid ����ȱʡ�����߱���Ȩ��ID
	 * @return ����ȱʡ�����߱���Ȩ��
	 */
	public IG699Info searchIG699InfoByKey(String pipdid) throws BLException;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG699Info> searchIG699Info(IG699SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG699Info> searchIG699Info(IG699SearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param IG881 ��¼����
	 * @return ����ȱʡ�����߱���Ȩ��
	 */
	public IG699Info registIG699Info(IG699Info ig699Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pipdid ɾ����������ȱʡ����������
	 * @return
	 */
	public void deleteIG699InfoByKey(String pdvid) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pdvid ɾ����������ȱʡ����������
	 * @return
	 */
	public void deleteIG699Info(IG699Info ig699Info) throws BLException;
	
	/**
	 * �������
	 * 
	 * @param ig699Info �������
	 * @return ����ȱʡ�����߱���Ȩ��
	 */
	public IG699Info updateIG699Info(IG699Info ig699Info) throws BLException;
	
	/**
	 * ����ȱʡ����Ȩ����ͼ��ѯ
	 * 
	 * @param cond ��ѯ����
	 * @return ����ȱʡ����Ȩ��
	 * @throws BLException 
	 */
	public List<IG909Info> searchIG909Info(IG909SearchCond cond);
	
	/**
	 * PDVID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PDVID����ֵ
	 */
	public String getPdvidSequenceNextValue(String psdid);
	
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
