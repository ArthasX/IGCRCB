/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EEOrgVWSearchCond;
import com.csebank.lom.model.condition.EESearchCond;
import com.csebank.lom.model.dao.EEDetailDAO;
import com.csebank.lom.model.dao.EEOrgVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂招待部门汇总业务逻辑接口实现
 * 作者：唐晓娜
 */
public class EEOrgVWBLImpl extends BaseBLImpl implements EEOrgVWBL {
	
	/** RecptionOrgVW DAO */
	protected EEOrgVWDAO eeOrgVWDAO;
	protected EEDetailDAO eeDetailDAO;
	

	public List<EEOrg> searchEEOrgVW(EEOrgVWSearchCond cond,
			int start, int count) {
		
		return eeOrgVWDAO.findByCond(cond, start, count);
	}
	public List<Eentertainment> searchEEOrgVWDetail(EESearchCond cond, int start, int count){
		return eeDetailDAO.findByCond(cond, start, count);
	}


	public EEOrgVWDAO getEeOrgVWDAO() {
		return eeOrgVWDAO;
	}



	public void setEeOrgVWDAO(EEOrgVWDAO eeOrgVWDAO) {
		this.eeOrgVWDAO = eeOrgVWDAO;
	}
	public EEDetailDAO getEeDetailDAO() {
		return eeDetailDAO;
	}
	public void setEeDetailDAO(EEDetailDAO eeDetailDAO) {
		this.eeDetailDAO = eeDetailDAO;
	}
	

	
}
