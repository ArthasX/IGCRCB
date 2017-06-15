/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;

/**
 * <p>����:������ҵ���߼��ӿ�</p>
 * <p>����������1.��Ȩ�������봦��</p>
 * <p>          2.�������</p>
 * <p>          3.��Ȩ������ѯ����</p>
 * <p>          4.��Ȩ������������ѯ����</p>
 * <p>������¼��</p>
 */
public interface IG463BL extends BaseBL{
	
	/**
	 * ���ܣ���Ȩ�������봦��
	 * 
	 * @param IG463Info
	 * @return ProcessProxyWork
	 * @throws BLException
	 */
	public IG463Info insertIG463Info(IG463Info ig463Info) throws BLException;
	
	/**
	 * ���ܣ��������
	 * 
	 * @param IG463Info �������
	 * @return ������
	 * @throws BLException
	 */
	public IG463Info updateIG463Info(IG463Info ig463Info) throws BLException;
	
	/**
	 * ���ܣ���Ȩ������ѯ����
	 * 
	 * @param cond ��������ѯ����
	 * @param start ������¼��ʼ��
	 * @param count ������¼����
	 * @return List<ProcessProxyWork> ��Ȩ�����б�
	 * @throws BLException
	 */
	public List<IG463Info> searchIG463Info(IG463SearchCond cond, final int start, final int count) throws BLException;
	
	/**
	 * ���ܣ���Ȩ������������ѯ����
	 * 
	 * @param ppwid ����
	 * @return ProcessProxyWork ��Ȩ������Ϣ
	 * @throws BLException
	 */
	public IG463Info findIG463InfoByPk(Integer ppwid) throws BLException;
}
