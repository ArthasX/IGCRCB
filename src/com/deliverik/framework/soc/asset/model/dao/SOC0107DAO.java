package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;



/**
 * �ʲ���������ϢDAO�ӿ�
 * 
 */
public interface SOC0107DAO extends BaseHibernateDAO<SOC0107Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SOC0107Info> findAll();

	/**
	 * ������������
	 * @param ciid ����
	 * @return �������
	 */
	public SOC0107Info findByPK(Serializable ciid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0107SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond, final int start, final int count);
	
	/**
	 * ���ݴ�汾��ȡ�ʲ����С�汾
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ���汾��
	 * @return ���С�汾
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);

	public String getHostEiid(SOC0107SearchCondImpl cond);
	
	/**
	 * �����ʲ�ģ��ID��ȡ������Ϣ
	 * @param eiid �ʲ�ID
	 * @return List<SOC0107Info>
	 */
	public List<SOC0107Info> getConfigItemByEid(final SOC0107SearchCondImpl cond);
	
	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException;
	

	/**
	 * �����ʲ�id��config id ��ѯ�����������̽ڵ���ڵ��������Ϣ
	 * @param cid config id
	 * @param eiid �ʲ�id
	 * @return
	 * @throws BLException
	 */
	public List<Map<String,Object>> searchProcessDefineUserByEiidInfo(String cid,Integer eiid)throws BLException;
}
