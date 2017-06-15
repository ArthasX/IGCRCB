/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;

/**
 * <p>
 *  ����־��Ϣҵ���߼�
 * </p>
 */

public interface IG113BL extends BaseBL {


	/**
	 * �������־
	 * @param ����־����
	 * @throws BLException
	 */
	public IG113Info registIG113Info(IG113Info ig113Info) throws BLException;
	
	/**
	 * �������־
	 * @param ����־����
	 * @throws BLException
	 */
	public void UpdateIG113Info(List<IG113Info> ig113InfoList) throws BLException;

	/**
	 * �������̼�¼ID��ȡ����־��Ϣ����
	 * @param ����־��Ϣ����
	 * @throws BLException
	 */
	public List<IG113Info> searchIG113InfoByIG036Info(Integer rlid);
	
	/**
	 * �������̱���ID��ȡ����־��Ϣ����
	 * @param piid ���̱���ID
	 * @throws BLException 
	 */
	public IG113Info searchIG113InfoByRlvid(Integer rlvid) throws BLException;
	
	/**
	 * ��ȡ����־ʵ��
	 * 
	 * @return RecordLogVarInfoTB
	 * @throws BLException
	 */
	
	public IG113TB getIG113TBInstance();
	
	/**
	 * �������־
	 * @param ����־����
	 * @throws BLException
	 */
	public void saveOrUpdIG113Info(List<IG113Info> ig113InfoList) throws BLException;
	
	/**
	 * ���ݲ�ѯ������ȡ����־��Ϣ����
	 * @param ����־��Ϣ����
	 * @throws BLException
	 */
	public List<IG113Info> searchIG113InfoByCond(IG113SearchCond cond);
}
