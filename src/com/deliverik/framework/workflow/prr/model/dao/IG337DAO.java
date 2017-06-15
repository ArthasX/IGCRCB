/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;

/**
 * <p>����:���̲����û���ϢDAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.���������������ȡ��</p>
 * <p>          5.ָ���û���������̴����ɫ��������</p>
 * <p>������¼��</p>
 */
public interface IG337DAO extends BaseHibernateDAO<IG337Info> {

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG337Info> findAll();

	/**
	 * ���ܣ�������������
	 * @param pdaid ����
	 * @return �������
	 */
	public IG337Info findByPK(Serializable ppid);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �������
	 */
	public List<IG337Info> findByCond(final IG337SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getCountByCond(final IG337SearchCond cond);
	
	/**
	 * ���ܣ�ָ���û���������̴����ɫ��������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG337Info> queryRolemanager(final String userid , final Integer prid);
	
	/**
	 * ����ִ���˼�������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return ��������б�
	 */
	public List<IG602Info> searchIG602Info(final String userid, final Integer prid);
	
	/**
	 * ���̿ɷ����˼�������
	 * @param prid ����ID
	 * @param roleid ��ɫID
	 * @return ��������б�
	 */
	public List<IG602Info> searchSuperAssignExecutors(final Integer prid, final Integer roleid);

	public List<IG337Info> findByCondRun(final IG337SearchCond cond);
}
