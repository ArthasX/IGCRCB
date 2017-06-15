package com.deliverik.infogovernor.dbm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;

public interface BussinessAvailvalVWDAO extends BaseHibernateDAO<BussinessAvailval> {

	public List<BussinessAvailval> getAllBusinessAvailvalList();

}
