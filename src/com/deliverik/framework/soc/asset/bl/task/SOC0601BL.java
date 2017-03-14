/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCond;

/**
 * ������Ϣҵ���߼�
 * 
 */
public interface SOC0601BL extends BaseBL{

	/**
	 * ���ݻ�����Ϣ����ȡ�û�����Ϣ
	 * 
	 * @param eiid ������Ϣ����
	 * @return ������Ϣ
	 */
	public SOC0601Info searchSOC0601InfoByKey(String eiid);

	/**
	 * ���ݼ�������ȡ�û�����Ϣ�������
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ�������
	 */
	public int getSOC0601InfoSearchCount(SOC0601SearchCond cond);

	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ��������б�
	 */
	public List<SOC0601Info> searchSOC0601Info(SOC0601SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	public List<SOC0601Info> searchSOC0601Info(SOC0601SearchCond cond, int start, int count);
	
	/**
	 * �½�������Ϣ����
	 * 
	 * @param SOC0601Info ������Ϣ
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer registSOC0601Info(SOC0601Info SOC0601Info) throws BLException;

	/**
	 * ɾ��������Ϣ����
	 * 
	 * @param SOC0601Info ɾ���Ļ�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0601Info(SOC0601Info SOC0601Info) throws BLException;

	/**
	 * ���ݻ�������ɾ��������Ϣ����
	 * 
	 * @param eiid ɾ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0601InfoByKey(Integer eiid) throws BLException;

	/**
	 * ���������Ϣ����
	 * 
	 * @param SOC0601Info ���ǰ�Ļ�����Ϣ
	 * @throws BLException
	 */
	public void updateSOC0601Info(SOC0601Info SOC0601Info) throws BLException;


}
