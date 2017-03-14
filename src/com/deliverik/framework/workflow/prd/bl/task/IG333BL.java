/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */


package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;

/**
 * ����״̬����ҵ���߼�
 * 
 */

public interface IG333BL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getIG333InfoSearchCount(IG333SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param psdid ����״̬����ID
	 * @return ����״̬������Ϣ
	 */
	
	public IG333Info searchIG333InfoByKey(String psdid) throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	public List<IG333Info> searchIG333Info(
			IG333SearchCond cond, int start, int count);
	
	/**
	 * ȫ����������
	 * 
	 * @return ��������б�
	 */
	
	public List<IG333Info> searchIG333InfoAll();
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<IG333Info> searchIG333Info(IG333SearchCond cond);

	/**
	 * ��¼����
	 * 
	 * @param IG333Info ��¼����
	 * @return �ʲ���Ϣ
	 */
	
	public IG333Info registIG333Info(
			IG333Info ig333Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param psdid ɾ������״̬��������
	 * @return
	 */
	
	public void deleteIG333InfoByKey(String psdid) throws BLException;

	/**
	 * �������
	 * 
	 * @param ig333Info �������
	 * @return ����״̬����
	 */
	
	public IG333Info updateIG333Info(
			IG333Info ig333Info) throws BLException;
	
	/**
	 * ����״̬������Ϣʵ��
	 * 
	 * @return ����״̬������Ϣ
	 */
	
	public IG333TB getIG333TBInstance();
	
	/**
	 * ����״̬code��ȡָ���������͵�״̬ID
	 * 
	 * @param pdid ���̶���ID
	 * @param psdcode ����״̬��ʶ
	 * @return ����״̬ID
	 * @throws BLException 
	 */
	
	public String getIG333InfoIdByStatus(String pdid, String psdcode) throws BLException;
	
	/**
	 * PSDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PSDID����ֵ
	 */
	public String getPsdidSequenceNextValue(String pdid);
	
	/**
	 * �ɱ����ɽڵ�ȡ��
	 * 
	 * @param ���ɽڵ�ID
	 * @param ���ɰ�ťID
	 * @return �ɱ����ɽڵ��б�
	 * @throws BLException 
	 */
	public List<IG333Info> searchAssignedStatusDef(String psdid, String pbdid) throws BLException;
	
	/**
	 * ָ��״̬�����Ŀɵ��������ߵ�״̬����ȡ��
	 *
	 * @param psdid ״̬ID
	 * @return ״̬����
	 */
	public List<IG333Info> searchAdjustStatus(String psdid);
	
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
