/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.dao;

import java.util.ArrayList;

import com.deliverik.framework.asset.VgPvMetaInfo;
import com.deliverik.framework.asset.model.condition.VgPvMetaSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ����: �豸��ϵ��ϢDAO�ӿ�(VG-PV-Meta)
 * ��������: �豸��ϵ��ϢDAO�ӿ�(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface VgPvMetaDao extends BaseHibernateDAO<VgPvMetaInfo> {

	public ArrayList<VgPvMetaInfo> searchVgPvMeta(VgPvMetaSearchCond cond);

}
