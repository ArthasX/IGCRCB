/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG808Info;

/**
 * <p>����:��ҳ�ϰ�����ͳ�ƹ���������ѯDAO�ӿ�</p>
 * <p>������������ȡsqlִ�в�ѯ</p>
 * <p>������¼���κ��� 2010/11/13</p>
 */

public interface IG808DAO extends BaseHibernateDAO<IG808Info> {

	/**
	 * ���ܣ���ȡ��������
	 * @return ��������б�
	 */
	public List<IG808Info> findIG808Info();

}
