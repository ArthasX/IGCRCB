/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG941Info;
import com.deliverik.framework.workflow.prr.model.condition.IG941SearchCond;

/**
 * 
 * ���񹤵���־ҵ���߼��ӿ�
 *
 */
public interface IG941BL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG941SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param sflid ���񹤵���־ID
	 * @return ���񹤵���־
	 */
	public IG941Info searchIG941InfoByKey(Integer sflid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����񹤵���־��Ϣ
	 */
	public List<IG941Info> searchIG941InfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG941Info> searchIG941Info(IG941SearchCond cond, int start, int count);

	/**
	 * �ǼǴ���
	 * 
	 * @param IG941Info �Ǽ�����
	 * @return ���񹤵���־
	 */
	public IG941Info registIG941Info(IG941Info ig941Info) throws BLException;

	/**
	 * �������
	 * 
	 * @param IG941Info �������
	 * @return ���񹤵���־��־
	 */
	public IG941Info updateIG941Info(IG941Info ig941Info) throws BLException;
	
}
