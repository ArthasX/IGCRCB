/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCond;

/** 
 * ���̲����߱���Ȩ��ҵ���߼�
 *
 */
public interface IG881BL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG881InfoSearchCount(IG881SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pipdid ���̲����߱���Ȩ��ID
	 * @return ���̲����߱���Ȩ��
	 */
	public IG881Info searchIG881InfoByKey(String pipdid) throws BLException;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG881Info> searchIG881Info(IG881SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG881Info> searchIG881Info(IG881SearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param IG881 ��¼����
	 * @return ���̲����߱���Ȩ��
	 */
	public IG881Info registIG881Info(IG881Info ig881Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pipdid ɾ���������̲���������
	 * @return
	 */
	public void deleteIG881InfoByKey(String pipdid) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pipdid ɾ���������̲���������
	 * @return
	 */
	public void deleteIG881Info(IG881Info ig881Info) throws BLException;
	
	/**
	 * �������
	 * 
	 * @param IG881 �������
	 * @return ���̲����߱���Ȩ��
	 */
	public IG881Info updateIG881Info(IG881Info ig881Info) throws BLException;
	
	/**
	 * ���̲����߱���Ȩ����ͼ��ѯ
	 * 
	 * @param cond ��ѯ����
	 * @return ���̲����߱���Ȩ��
	 * @throws BLException 
	 */
	public List<IG100Info> searchIG100Info(IG100SearchCond cond) throws BLException;
	
	/**
	 * PIPDID����ֵȡ��
	 * 
	 * @param ����״̬�����߶���ID
	 * @return PIPDID����ֵ
	 */
	public String getPipdidSequenceNextValue(String ppdid);
	
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
