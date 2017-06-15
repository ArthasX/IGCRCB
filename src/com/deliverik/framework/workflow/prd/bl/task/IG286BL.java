/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;

/**
 * <p>����:���̼�����ҵ���߼�</p>
 * <p>����������1.������������</p>
 * <p>          2.��¼����</p>
 * <p>          3.ɾ������</p>
 * <p>          4.������������</p>
 * <p>������¼��</p>
 */
public interface IG286BL extends BaseBL{
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG286Info> searchIG286Info(IG286SearchCond cond, int start, int count);
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG286Info> searchIG286Info(IG286SearchCond cond);

	/**
	 * ���ܣ���¼����
	 * 
	 * @param IG286Info ��¼����
	 * @return IG286 ���̼�������Ϣ
	 * @throws BLException
	 */
	public IG286Info insertIG286Info(IG286Info processLinkageDef) throws BLException;
	
	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param ig286Info ���̼�������Ϣ 
	 */
	public void deleteIG286Info(IG286Info ig286Info);
	
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param plid ���̼���������
	 * @return IG286 ���̼�������Ϣ
	 */
	public IG286Info searchIG286InfoByPk(String plid);
	
	/**
	 * PLID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PLID����ֵ
	 */
	public String getPlidSequenceNextValue(String pdid);
	
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
