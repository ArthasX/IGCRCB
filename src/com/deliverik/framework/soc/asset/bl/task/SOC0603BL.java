/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;

/**
 * ������Ϣҵ���߼�
 * 
 */
public interface SOC0603BL extends BaseBL{

	/**
	 * ���ݻ�����Ϣ����ȡ�û�����Ϣ
	 * 
	 * @param eiid ����ID
	 * @return ������Ϣ
	 */
	public SOC0603Info searchSOC0603InfoByKey(String eiid);

	/**
	 * ���ݼ�������ȡ�û�����Ϣ����
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */
	public int getSOC0603InfoSearchCount(SOC0603SearchCond cond);


	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ�б�
	 */
	public List<SOC0603Info> searchSOC0603Info(SOC0603SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ�б�
	 */
	public List<SOC0603Info> searchSOC0603Info(SOC0603SearchCond cond, int start, int count);
	
	/**
	 * �½�������Ϣ����
	 * 
	 * @param SOC0603Info ������Ϣ
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer registSOC0603Info(SOC0603Info SOC0603Info) throws BLException;

	/**
	 * ɾ��������Ϣ����
	 * 
	 * @param SOC0603Info ɾ���Ļ�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0603Info(SOC0603Info SOC0603Info) throws BLException;

	/**
	 * ���ݻ�������ɾ��������Ϣ����
	 * 
	 * @param eiid ɾ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0603InfoByKey(Integer eiid) throws BLException;

	/**
	 * ���������Ϣ����
	 * 
	 * @param SOC0603Info ���ǰ�Ļ�����Ϣ
	 * @throws BLException
	 */
	public void updateSOC0603Info(SOC0603Info SOC0603Info) throws BLException;

	/**
	 * �����������������յ���UPS
	 * 
	 * @param cond
	 * @return
	 */
	public List<SOC0603Info> searchUpsAndAirSOC0603Info(SOC0603SearchCond cond);
}
