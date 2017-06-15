package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCond;



/**
 * �ʲ����ϵ��ϢDAO�ӿ�
 * 
 */
public interface SOC0119DAO extends BaseHibernateDAO<SOC0119Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SOC0119Info> findAll();

	/**
	 * ������������
	 * @param eirid ����
	 * @return �������
	 */
	public SOC0119Info findByPK(Serializable eirid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0119SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0119Info> findByCond(final SOC0119SearchCond cond, final int start, final int count);
	
	public List<SOC0119Info> searchMaxEntityItemRelation(final SOC0119SearchCond cond,final int start, final int count);
	/**
	 * �ʲ���ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0119Info> searchMaxEntityItemRelation(final SOC0119SearchCond cond);
	
	/**
	 * ����eiidɾ����ϵ����
	 * @param eiid
	 */
	public void delByEiid(Integer eiid);
	
	/**
	 * ����eiid ��ѯ������ص�eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid(final SOC0119SearchCond cond);
	
	/**
	 * ���������ϵ��ѯ
	 * @param cond
	 * @return
	 */
	public List<Integer> searchCldeiidByPareiid(final SOC0119SearchCond cond);
	
	/**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<SOC0119Info> findByCondBySql(final SOC0119SearchCond cond, final int start, final int count);
	
    /**
	 * ����eiid_in ��ѯ������ص�eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid_in(final SOC0119SearchCond cond);
	
	/**
	 * ����eiidɾ����ϵ����
	 * @param eiid
	 */
	public void delByEiid(Integer eiid,String eirrelationcode);
}
