package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;

public interface CRM01DAO extends BaseHibernateDAO<CRMVW01Info>{
	public List<CRMVW01Info> searchCRM01VWInfoList(final CRM10SearchCond cond,int start,int length);
	public int getSearchCount(final CRM10SearchCond cond);
	public IGALM07DTO getRefreshRate(IGALM07DTO dto) throws BLException;
	public String searchTable(final CRM10SearchCond cond);
}
