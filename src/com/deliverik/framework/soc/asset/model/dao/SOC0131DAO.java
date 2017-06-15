/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.ArrayList;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0131SearchCond;

/**
 * ����: �豸��ϵ��ϢDAO�ӿ�(VG-PV-Meta)
 * ��������: �豸��ϵ��ϢDAO�ӿ�(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼:  
 */
public interface SOC0131DAO extends BaseHibernateDAO<SOC0131Info> {

	public ArrayList<SOC0131Info> searchVgPvMeta(SOC0131SearchCond cond);

}
