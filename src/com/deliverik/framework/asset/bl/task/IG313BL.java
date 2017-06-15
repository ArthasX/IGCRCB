package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.condition.IG313SearchCond;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * �ʲ���ϵҵ���߼�
 * </p>
 */

public interface IG313BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ���ϵ��Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ���ϵ��Ϣ����ʵ��
	 */
	public IG313TB getIG313TBInstance();

	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ����
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @return �ʲ���ϵ��Ϣ����
	 */
	public int getIG313InfoSearchCount(IG313SearchCond cond);

	/**
	 * �����ʲ���ϵ��Ϣ����ȡ���ʲ���ϵ��Ϣ
	 * 
	 * @param eid �ʲ���ϵ��Ϣ����
	 * @return �ʲ���ϵ��Ϣ
	 */
	public IG313Info searchIG313InfoByKey(Integer eirid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @return �ʲ���ϵ��Ϣ�б�
	 */
	public List<IG313Info> searchIG313Info(IG313SearchCond cond);//������
	
	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���ϵ��Ϣ�б�
	 */
	public List<IG313Info> searchIG313Info(IG313SearchCond cond, int start, int count);
	
	/**
	 * �����ʲ���ϵ��Ϣ����
	 * 
	 * @param ig313Info �ʲ���ϵ��Ϣ
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException
	 */
	public IG313Info registIG313Info(IG313Info ig313Info) throws BLException;
	
	/**
	 * ɾ���ʲ���ϵ��Ϣ����
	 * 
	 * @param ig313Info �ʲ���ϵ��Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG313Info(IG313Info ig313Info) throws BLException;
	
	/**
	 * �����ʲ���ϵ��Ϣ����ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param eid �ʲ���ϵ��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteIG313InfoByKey(Integer eid) throws BLException;//������


	/**
	 * ����ʲ���ϵ��Ϣ����ƽ̨������
	 * 
	 * @param ig313Info �ʲ���ϵ��Ϣ
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException
	 */
	public IG313Info updateIG313Info(IG313Info ig313Info) throws BLException;
	
	/**
	 * �ʲ���ϵ��Ϣ�汾��������
	 * 
	 * @param eiid ����ʲ�ID
	 * @param eiversion ��ϵ�����ʲ����´�汾
	 * @param eismallversion ��ϵ�����ʲ�����С�汾
	 * @param neweiversion �ʲ����´�汾
	 * @param neweismallversion �ʲ�����С�汾
	 * @throws BLException 
	 */
	public void upgradeIG313Info(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException;
	
	/**
	 * �ʲ���ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG313Info> searchMaxIG313Info(IG313SearchCond cond);

	/**
	 * ��ͬ-�����ϵ����
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeIG313InfoOne(Integer eiid, Integer eiversion,
			Integer eismallversion, int version, int i, String[] cldeiids) throws BLException;
	
	/**
	 * ������ģʽ��ϵ
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeIG313InfoByJiFang(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion)
			throws BLException;
	
}
