/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG463DAO;

/**
 * <p>����:������ҵ���߼�ʵ��</p>
 * <p>����������1.��Ȩ�������봦��</p>
 * <p>          2.�������</p>
 * <p>          3.��Ȩ������ѯ����</p>
 * <p>          4.��Ȩ������������ѯ����</p>
 * <p>������¼��</p>
 */
public class IG463BLImpl extends BaseBLImpl implements IG463BL{
	
	/** Ig463DAO DAO */
	protected IG463DAO ig463DAO;
	
	/**
	 * ���ܣ�������ҵ���߼�DAO�趨
	 * 
	 * @param IG463DAO ������ҵ���߼�DAO
	 */
	public void setIg463DAO (IG463DAO ig463DAO) {
		this.ig463DAO = ig463DAO;
	}

	/**
	 * ���ܣ��������
	 * 
	 * @param IG463Info �������
	 * @return ������
	 * @throws BLException
	 */
	public IG463Info updateIG463Info(IG463Info ig463Info) throws BLException{

		return ig463DAO.save(ig463Info);
		
	}

	/**
	 * ���ܣ���Ȩ������ѯ����
	 * 
	 * @param cond ��������ѯ����
	 * @param start ������¼��ʼ��
	 * @param count ������¼����
	 * @return List<ProcessProxyWork> ��Ȩ������ѯ���
	 * @throws BLException
	 */
	public List<IG463Info> searchIG463Info(
			IG463SearchCond cond, int start, int count)
			throws BLException {
		
		return ig463DAO.findByCond(cond, start, count);
	}

	/**
	 * ���ܣ���Ȩ������������ѯ����
	 * 
	 * @param ppwid ����ID
	 * @return ProcessProxyWork ��Ȩ������Ϣ
	 * @throws BLException
	 */
	public IG463Info findIG463InfoByPk(Integer ppwid)
			throws BLException {
		
		return ig463DAO.findByPK(ppwid);
	}

	/**
	 * ���ܣ���Ȩ�������봦��
	 * 
	 * @param IG463Info ��Ȩ������Ϣ
	 * @return ProcessProxyWork ��Ȩ������Ϣ
	 * @throws BLException
	 */
	public IG463Info insertIG463Info(
			IG463Info ig463Info) throws BLException {
		
		return ig463DAO.save(ig463Info);
	}




}
