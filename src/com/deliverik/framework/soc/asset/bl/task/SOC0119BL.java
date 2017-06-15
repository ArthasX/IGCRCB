package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;

/**
 * <p>
 * �ʲ���ϵҵ���߼�
 * </p>
 */

public interface SOC0119BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ���ϵ��Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ���ϵ��Ϣ����ʵ��
	 */
	public SOC0119TB getEntityItemRelationTBInstance();

	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ����
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @return �ʲ���ϵ��Ϣ����
	 */
	public int getEntityItemRelationSearchCount(SOC0119SearchCond cond);

	/**
	 * �����ʲ���ϵ��Ϣ����ȡ���ʲ���ϵ��Ϣ
	 * 
	 * @param eid �ʲ���ϵ��Ϣ����
	 * @return �ʲ���ϵ��Ϣ
	 */
	public SOC0119Info searchEntityItemRelationByKey(Integer eirid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @return �ʲ���ϵ��Ϣ�б�
	 */
	public List<SOC0119Info> searchEntityItemRelation(SOC0119SearchCond cond);//������
	
	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���ϵ��Ϣ�б�
	 */
	public List<SOC0119Info> searchEntityItemRelation(SOC0119SearchCond cond, int start, int count);
	
	/**
	 * �����ʲ���ϵ��Ϣ����
	 * 
	 * @param entityItemRelation �ʲ���ϵ��Ϣ
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException
	 */
	public SOC0119Info registEntityItemRelation(SOC0119Info entityItemRelation) throws BLException;
	
	/**
	 * ɾ���ʲ���ϵ��Ϣ����
	 * 
	 * @param entityItemRelation �ʲ���ϵ��Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItemRelation(SOC0119Info entityItemRelation) throws BLException;
	
	/**
	 * �����ʲ���ϵ��Ϣ����ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param eid �ʲ���ϵ��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItemRelationByKey(Integer eid) throws BLException;//������


	/**
	 * ����ʲ���ϵ��Ϣ����ƽ̨������
	 * 
	 * @param entityItemRelation �ʲ���ϵ��Ϣ
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException
	 */
	public SOC0119Info updateEntityItemRelation(SOC0119Info entityItemRelation) throws BLException;
	
	/**
	 * �ʲ���ϵ��Ϣ�汾��������
	 * 
	 * @param eiid ����ʲ�ID
	 * @param eiversion ��ϵ�����ʲ����´�汾
	 * @param eismallversion �رձ����ʲ�����С�汾
	 * @param neweiversion �ʲ����´�汾
	 * @param neweismallversion �ʲ�����С�汾
	 * @throws BLException 
	 */
	public void upgradeEntityItemRelation(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException;
	
	/**
	 * �ʲ���ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0119Info> searchMaxEntityItemRelation(SOC0119SearchCond cond);
	
	public List<SOC0119Info> searchMaxEntityItemRelation(SOC0119SearchCond cond,int start,int count);
	
	/**
	 * ����eiidɾ����ϵ����
	 * @param eiid
	 */
	public void delByEiid(Integer eiid)throws BLException;
	/**
	 * ����eiidɾ����ϵ����
	 * @param eiid
	 */
	public void delByEiid(Integer eiid,String eirrelationcode)throws BLException;
	
	/**
	 * ����eiid ��ѯ������ص�eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid(SOC0119SearchCond cond) throws BLException;
	
	
	/**
	 * ���������ϵ��ѯ
	 * @param cond
	 * @return
	 */
	public List<Integer> searchCldeiidByPareiid(final SOC0119SearchCond cond)throws BLException;

	/**
	 * ��ͬ-�����ϵ����
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeEntityItemRelationOne(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion, String[] cldeiids)
			throws BLException ;

	/**
	 * ������ģʽ��ϵ
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeEntityItemRelationByJiFang(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion)
			throws BLException;
	
	/**
     * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�
     * 
     * @param cond �ʲ���ϵ��Ϣ��������
     * @return �ʲ���ϵ��Ϣ��������б�
     */
    public List<SOC0119Info> searchEntityItemRelationBySql(SOC0119SearchCond cond,int start, int count);
    
    /**
   	 * ����eiid_in ��ѯ������ص�eiid
   	 * @param eiid
   	 * @return
   	 */
   	public List<Integer> searchRelationByEiid_in(final SOC0119SearchCond cond);
}
