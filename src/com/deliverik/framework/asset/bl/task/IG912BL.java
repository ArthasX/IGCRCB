package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG912Info;
import com.deliverik.framework.asset.model.IG790Info;
import com.deliverik.framework.asset.model.condition.IG912SearchCond;
import com.deliverik.framework.asset.model.condition.IG790SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * �豸��Ϣҵ���߼�
 * 
 */
public interface IG912BL extends BaseBL{

	/**
	 * �����豸��Ϣ����ȡ���豸��Ϣ
	 * 
	 * @param eiid �豸ID
	 * @return �豸��Ϣ
	 */
	public IG912Info searchIG912InfoByKey(String eiid);

	/**
	 * ���ݼ�������ȡ���豸��Ϣ�������
	 * 
	 * @param cond �豸��Ϣ��������
	 * @return �豸��Ϣ�������
	 */
	public int getIG912InfoSearchCount(IG912SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���豸��Ϣ�б�
	 * 
	 * @param cond �豸��Ϣ��������
	 * @return �豸��Ϣ��������б�
	 */
	public List<IG912Info> searchIG912Info(IG912SearchCond cond);


	/**
	 * ���ݼ�������ȡ���豸��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �豸��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �豸��Ϣ��������б�
	 */
	public List<IG912Info> searchIG912Info(IG912SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�б�
	 * 
	 * @param cond ��������ͳ�Ʒ�����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �����豸��Ϣ��������б�
	 */
	public List<IG790Info> searchIG790Info(IG790SearchCond cond,int start,int count) throws BLException;
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�������
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @return �����豸��Ϣ�������
	 */
	public int getIG790InfoSearchCount(IG790SearchCond cond) throws BLException;

}
