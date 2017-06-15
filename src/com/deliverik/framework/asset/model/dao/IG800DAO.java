package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * �ʲ���������ϢDAO�ӿ�
 * 
 */
public interface IG800DAO extends BaseHibernateDAO<IG800Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG800Info> findAll();

	/**
	 * ������������
	 * @param ciid ����
	 * @return �������
	 */
	public IG800Info findByPK(Serializable ciid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG800SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG800Info> findByCond(final IG800SearchCond cond, final int start, final int count);
	
	/**
	 * ���ݴ�汾��ȡ�ʲ����С�汾
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ���汾��
	 * @return ���С�汾
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);
	
	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException;
}
