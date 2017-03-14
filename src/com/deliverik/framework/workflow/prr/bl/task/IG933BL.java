/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCond;

/**
 * 
 * ���񹤵�ҵ���߼��ӿ�
 *
 */
public interface IG933BL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG933SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param raid ���񹤵�ID
	 * @return ���񹤵�
	 */
	public IG933Info searchIG933InfoByKey(Integer raid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����񹤵���Ϣ
	 */
	public List<IG933Info> searchIG933InfoAll();
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����񹤵���Ϣʱ������
	 */
	public List<IG933Info> searchIG933InfoAllAsc();
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG933Info> searchIG933Info(IG933SearchCond cond, int start, int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�ʱ������
	 */
	public List<IG933Info> searchIG933InfoAsc(IG933SearchCond cond, int start, int count);
	
	/**
	 * �ǼǴ���
	 * 
	 * @param IG933Info �Ǽ�����
	 * @return ���񹤵�
	 */
	public IG933Info registIG933Info(IG933Info ig933Info) throws BLException;

	/**
	 * �������
	 * 
	 * @param IG933Info �������
	 * @return ���񹤵�
	 */
	public IG933Info updateIG933Info(IG933Info ig933Info) throws BLException;
	
	 /**
	 * ��ȡ���񹤵�������ֵ
	 * 
	 * @return ���񹤵�������ֵ
	 */
	public String searchMaxID(String code) throws BLException;
}
