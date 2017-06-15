/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;

/**
 * <p>
 * �����¼�����ҵ���߼�
 * </p>
 */

public interface IG413BL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG413SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pedid �����¼�����ID
	 * @return �����¼�������Ϣ
	 */
	public IG413Info searchIG413InfoByKey(String pedid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�������¼�������Ϣ
	 */
	public List<IG413Info> searchIG413InfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG413Info> searchIG413Info(IG413SearchCond cond, int start, int count);

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG413Info> searchIG413Info(IG413SearchCond cond);

	/**
	 * ��¼����
	 * 
	 * @param ig413Info ��¼����
	 * @return �����¼�������Ϣ
	 */
	public IG413Info registIG413Info(IG413Info ig413Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pedid �����¼�����ID
	 */
	public void deleteIG413Info(String pedid) throws BLException;

	/**
	 * �������
	 * 
	 * @param ig413Info �������
	 * @return �����¼�������Ϣ
	 */
	public IG413Info updateIG413Info(IG413Info ig413Info) throws BLException;
	
	/**
	 * PEDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getPedidSequenceNextValue(String psdid);
	
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
