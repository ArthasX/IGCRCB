/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_CXVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
/**
 * 
 * @Description:�洢������ϢDAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_CXVWDAO extends BaseHibernateDAO<Collect_CXVWInfo> {

	public List<Collect_CXVWInfo> CX_findProtDeviceName(
			final Collect_BusySearchCond cond, final int start,
			final int count);

	public List<Collect_CXVWInfo> findProtByCond_CX(
			final Collect_BusySearchCond cond,final int start,final int count);

	public List<Collect_CXVWInfo> findSPByCond_CX(
			final	Collect_BusySearchCond cond, final int start, final int count);

}
