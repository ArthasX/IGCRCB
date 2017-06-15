/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;

/**
 * 
 * ���񹤵���������ҵ���߼��ӿ�
 *
 */
public interface IG715BL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG715SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param raid ���񹤵���������ID
	 * @return ���񹤵���������
	 */
	public IG715Info searchIG715InfoByKey(Integer raid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��������񹤵���������
	 */
	public List<IG715Info> searchIG715InfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG715Info> searchIG715Info(IG715SearchCond cond, int start, int count);

	/**
	 * ���洦��
	 * 
	 * @param IG715Info ��������
	 * @return ���񹤵���������
	 */
	public IG715Info registIG715Info(IG715Info ig715Info) throws BLException;

	/**
	 * �������
	 * 
	 * @param IG715Info �������
	 * @return ���񹤵���������
	 */
	public IG715Info updateIG715Info(IG715Info ig715Info) throws BLException;

	/**
	 * ��ȡʵ�����
	 * @return ʵ�����
	 */
	public IG715TB getIG715TBInstance();
}
