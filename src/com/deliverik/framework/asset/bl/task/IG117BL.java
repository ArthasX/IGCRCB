package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.asset.model.entity.IG117TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * �ʲ�ģ��ҵ���߼�
 * </p>
 */
public interface IG117BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�ģ����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�ģ����Ϣ����ʵ��
	 */

	public IG117TB getIG117TBInstance();

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ����
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ����
	 */
	public int getIG117InfoSearchCount(IG117SearchCond cond);

	/**
	 * �����ʲ�ģ����Ϣ����ȡ���ʲ�ģ����Ϣ
	 * 
	 * @param eid �ʲ�ģ����Ϣ����
	 * @return �ʲ�ģ����Ϣ
	 */
	public IG117Info searchIG117InfoByKey(Integer eid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ�б�
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�ģ����Ϣ�б�
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond, int start, int count);

	/**
	 * �����ʲ�ģ����Ϣ����
	 * 
	 * @param ig117Info �ʲ�ģ����Ϣ
	 * @param pareid �ϼ��ʲ�ģ��ID��"0":�����ϼ��ʲ�ģ��Ϊ����㣩
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException
	 */
	public IG117Info registIG117Info(IG117Info ig117Info,int pareid) throws BLException;

	/**
	 * ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param ig117Info �ʲ�ģ����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG117Info(IG117Info ig117Info) throws BLException;

	/**
	 * �����ʲ�ģ����Ϣ����ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param eid ɾ���ʲ�ģ����Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteIG117InfoByKey(Integer eid) throws BLException;

	/**
	 * ����ʲ�ģ����Ϣ����
	 * 
	 * @param ig117Info �ʲ�ģ����Ϣ
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException
	 */
	public IG117Info updateIG117Info(IG117Info ig117Info) throws BLException;
	
	/**
	 * �����ʲ�ģ��ID��ȡ��ȫ�����ϼ��ʲ�ģ����Ϣ
	 * 
	 * @param eid �ʲ�ģ��ID
	 * @return �ϼ��ʲ�ģ����Ϣ�б�
	 * @throws BLException
	 */
	public List<IG117Info> getParentNodes(Integer eid) throws BLException;
	
	/**
	 * �����ʲ�ģ����Ϣ������ȡ��ȫ�����ϼ��ʲ�ģ����Ϣ��ƽ̨������
	 * 
	 * @param esyscoding �ʲ�ģ����Ϣ�����
	 * @return �ϼ��ʲ�ģ����Ϣ�б�
	 */
	public List<IG117Info> getParentNodes(String esyscoding);

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�
	 *  (�����ʲ���Ϣ���������)
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @param orderType ��������б�����ʽ
	 * 		  "assetdomain" : �����ʲ���Ϣ�������������
	 * 
	 * @return �ʲ���Ϣ�б�
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond, String orderType);
}
