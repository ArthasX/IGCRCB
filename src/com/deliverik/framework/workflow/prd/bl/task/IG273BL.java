/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */


package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;

/**
 * ����״̬ԾǨ����ҵ���߼�
 * 
 */

public interface IG273BL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getIG273InfoSearchCount(IG273SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param ptdid ����״̬ԾǨ����ID
	 * @return ����״̬ԾǨ������Ϣ
	 */
	
	public IG273Info searchIG273InfoByKey(String ptdid) throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	public List<IG273Info> searchIG273Info(
			IG273SearchCond cond, int start, int count);
	
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<IG273Info> searchIG273Info(IG273SearchCond cond);
	
	/**
	 * ȫ����������
	 * 
	 * @return ��������б�
	 */
	
	public List<IG273Info> searchIG273InfoAll();

	/**
	 * ��������
	 * 
	 * @param IG273Info ��������
	 * @return �ʲ���Ϣ
	 */
	
	public IG273Info registIG273Info(
			IG273Info ig273Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param ptdid ɾ������״̬ԾǨ��������
	 */
	
	public void deleteIG273InfoByKey(String ptdid) throws BLException;
	
	/**
	 * ɾ������
	 * 
	 * @param ig273Info ɾ������״̬ԾǨ������Ϣ
	 */
	
	public void deleteIG273Info(IG273Info ig273Info) throws BLException;

	/**
	 * �������
	 * 
	 * @param ig273Info �������
	 * @return ����״̬ԾǨ����
	 */
	
	public IG273Info updateIG273Info(
			IG273Info ig273Info) throws BLException;
	
	/**
	 * ��ȡ��������Ϣʵ��
	 * 
	 * @return ������
	 */
	
	public IG273TB getIG273TBInstance();
	
	/**
	 * PTDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PTDID����ֵ
	 */
	public String getPtdidSequenceNextValue(String psdid);
	
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
