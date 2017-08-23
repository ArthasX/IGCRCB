/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;
import com.deliverik.infogovernor.crc.model.dao.IGCRC0301DAO;

public class IGCRC0301BLImpl extends BaseBLImpl implements
IGCRC0301BL {

	/** igcrc1301DAO接口 */
	protected IGCRC0301DAO igcrc0301DAO;
	
	
	
	public void setIgcrc0301DAO(IGCRC0301DAO igcrc0301dao) {
		igcrc0301DAO = igcrc0301dao;
	}

	public List<IGCRC0301VWInfo> queryIG500EntityListByProcessInfo(
			IG500SearchCond cond, int start, int count) {
		return igcrc0301DAO.queryIG500EntityListByProcessInfo(cond, start, count);
	}

	public int searchProcessCount(IG500SearchCond cond) throws BLException {
		return igcrc0301DAO.queryIG500EntityCount(cond);
	}
	
}
