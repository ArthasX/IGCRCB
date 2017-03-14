package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG778Info;
import com.deliverik.framework.asset.model.condition.IG778SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ������Ϣҵ���߼�
 * 
 */
public interface IG778BL extends BaseBL{

	/**
	 * ���ݻ�����Ϣ����ȡ�û�����Ϣ
	 * 
	 * @param eiid ����ID
	 * @return ������Ϣ
	 */
	public IG778Info searchIG778InfoByKey(Integer eiid);

	/**
	 * ���ݼ�������ȡ�û�����Ϣ����
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ����
	 */
	public int getIG778InfoSearchCount(IG778SearchCond cond);


	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ�б�
	 */
	public List<IG778Info> searchIG778Info(IG778SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ�б�
	 */
	public List<IG778Info> searchIG778Info(IG778SearchCond cond, int start, int count);
	
	/**
	 * �½�������Ϣ����
	 * 
	 * @param ig778Info ������Ϣ
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer registIG778Info(IG778Info ig778Info) throws BLException;

	/**
	 * ɾ��������Ϣ����
	 * 
	 * @param ig778Info ɾ���Ļ�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG778Info(IG778Info ig778Info) throws BLException;

	/**
	 * ���ݻ�������ɾ��������Ϣ����
	 * 
	 * @param eiid ɾ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteIG778InfoByKey(Integer eiid) throws BLException;

	/**
	 * ���������Ϣ����
	 * 
	 * @param ig778Info ���ǰ�Ļ�����Ϣ
	 * @throws BLException
	 */
	public void updateIG778Info(IG778Info ig778Info) throws BLException;

	/**
	 * �����������������յ���UPS
	 * 
	 * @param cond
	 * @return
	 */
	public List<IG778Info> searchUpsAndAirIG778Info(IG778SearchCond cond);
}
