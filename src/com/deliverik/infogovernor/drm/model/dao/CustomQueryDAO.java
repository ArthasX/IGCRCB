/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * �������Զ����ѯͨ��DAO �����������Զ����ѯͨ��DAO ������¼��2016/8/10
 */
public interface CustomQueryDAO extends BaseHibernateDAO {


	public List<Map<String, Object>> queryBySql(String sql, Map<String, Type> resultField);
}