/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;

/**
 * �豸��Ϣҵ���߼�
 * 
 */
public interface SOC0602BL extends BaseBL{

	/**
	 * �����豸��Ϣ����ȡ���豸��Ϣ
	 * 
	 * @param eiid �豸ID
	 * @return �豸��Ϣ
	 */
	public SOC0602Info searchSOC0602InfoByKey(String eiid);

	/**
	 * ���ݼ�������ȡ���豸��Ϣ�������
	 * 
	 * @param cond �豸��Ϣ��������
	 * @return �豸��Ϣ�������
	 */
	public int getSOC0602InfoSearchCount(SOC0602SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���豸��Ϣ�б�
	 * 
	 * @param cond �豸��Ϣ��������
	 * @return �豸��Ϣ��������б�
	 */
	public List<SOC0602Info> searchSOC0602Info(SOC0602SearchCond cond);


	/**
	 * ���ݼ�������ȡ���豸��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �豸��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �豸��Ϣ��������б�
	 */
	public List<SOC0602Info> searchSOC0602Info(SOC0602SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�б�
	 * 
	 * @param cond ��������ͳ�Ʒ�����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �����豸��Ϣ��������б�
	 */
	public List<SOC0604Info> searchSOC0604Info(SOC0604SearchCond cond,int start,int count) throws BLException;
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�������
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @return �����豸��Ϣ�������
	 */
	public int getSOC0604InfoSearchCount(SOC0604SearchCond cond) throws BLException;
	
	/**
     * ������������ģ����ѯ�豸���������豸���ڻ��񣬻���
     * 
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<Object[]> findZhiJiLocation(SOC0602SearchCond cond);

}
