/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG711DAO;

/**
 * <p>����:��Ȩ����ҵ���߼�ʵ��</p>
 * <p>����������1.��Ȩ��¼����</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>������¼��</p>
 */
public class IG711BLImpl extends BaseBLImpl implements IG711BL{
	
	/** Ig711 DAO */
	protected IG711DAO ig711DAO;
	
	/**
	 * ���ܣ�������ȨDAO
	 * 
	 * @param ig711DAO ������ȨDAO
	 */
	public void setIg711DAO(IG711DAO ig711DAO) {
		this.ig711DAO = ig711DAO;
	}

	/**
	 * ���ܣ���Ȩ��¼����
	 * @param IG711Info ������Ȩ
	 * @return Ig711 ������Ȩ
	 * @throws BLException
	 */
	public IG711Info insertIG711Info(IG711Info ig711Info) throws BLException{
		return ig711DAO.save(ig711Info);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<IG711Info> searchIG711Info(
			IG711SearchCond cond, int start, int count)
			throws BLException {
		
		return ig711DAO.findByCond(cond, start, count);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param paid ������ȨID
	 * @return ������Ȩ
	 * @throws BLException
	 */
	public IG711Info findIG711InfoByPk(Integer paid)
			throws BLException {
		
		return ig711DAO.findByPK(paid);
	}
	
	
}
