/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;

/**
 * 
 * ��Ȩ�����߼��ӿ�
 *
 */
public interface IG711BL extends BaseBL{
	/**
	 * ��Ȩ���봦��
	 * 
	 * @param Ig711
	 * @return Ig711
	 */
	public IG711Info insertIG711Info(IG711Info ig711Info) throws BLException;

	/**
	 * ��Ȩ��ѯ����
	 * 
	 * @param List<IG711Info>
	 * @return List<IG711Info>
	 */
	public List<IG711Info> searchIG711Info(IG711SearchCond cond, final int start, final int count) throws BLException;
	
	/**
	 * ��Ȩ��������ѯ����
	 * 
	 * @param Ig711
	 * @return Ig711
	 */
	public IG711Info findIG711InfoByPk(Integer paid) throws BLException;
}
