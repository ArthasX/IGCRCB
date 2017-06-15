/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;

/**
 * <p>
 * ��־��Ϣҵ���߼�
 * </p>
 */
public interface IG036BL extends BaseBL{
	
	/**
	 * <p>
	 * �����־��Ϣ
	 * </p>
	 * 
	 * @param ig036Info ��־��Ϣ
	 * @return ��־��Ϣ
	 * @throws BLException
	 */
	
	public IG036Info registIG036Info(IG036Info ig036Info) throws BLException;

	/**
	 * <p>
	 * �޸���־��Ϣ
	 * </p>
	 * 
	 * @param ig036Info ��־��Ϣ
	 * @return ��־��Ϣ
	 * @throws BLException
	 */
	
	public IG036Info updateG036Info(IG036Info ig036Info) throws BLException;
	
	/**
	 * <p>
	 * ��ȡָ�����̼�¼��������־��Ϣ
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @return ��־��Ϣ����
	 * @throws BLException
	 */
	
	public List<IG036Info> searchIG036InfoByPrid(Integer processId);
	
	/**
	 * ����������ѯ��־��Ϣ
	 * 
	 * @param pk ����ֵ
	 * @return ��־��Ϣ
	 * @throws BLException
	 */
	
	public IG036Info searchIG036InfoByPK(Integer pk) throws BLException;
	
	/**
	 * ��ȡ��־��Ϣʵ��
	 * 
	 * @return ��־��Ϣʵ��
	 * @throws BLException
	 */
	
	public IG036TB getIG036TBInstance();
	
	/**
	 * ���ݲ�ѯ������ȡ��־��Ϣ����
	 * @param ��־����ֵ��Ϣ����
	 * @throws BLException
	 */
	public List<IG036Info> searchIG036InfoByCond(IG036SearchCond cond);
}
