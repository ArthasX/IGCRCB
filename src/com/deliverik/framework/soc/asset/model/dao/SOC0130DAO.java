/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.ArrayList;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0130SearchCond;

/**
 * ����: �豸��ϵ��Ϣ��FS-LV-VG��DAO�ӿ�
 * ��������: �豸��ϵ��Ϣ��FS-LV-VG��DAO�ӿ�
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface SOC0130DAO extends BaseHibernateDAO<SOC0130Info> {

	public ArrayList<SOC0130Info> searchFsLvVg(SOC0130SearchCond cond);
	
}
