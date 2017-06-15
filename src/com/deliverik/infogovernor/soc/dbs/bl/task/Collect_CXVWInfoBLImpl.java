/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_CXVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_CXVWDAO;

public class Collect_CXVWInfoBLImpl extends BaseBLImpl implements
		Collect_CXVWInfoBL {

	private Collect_CXVWDAO collect_CXVWDAO;



	public Collect_CXVWDAO getCollect_CXVWDAO() {
		return collect_CXVWDAO;
	}

	public void setCollect_CXVWDAO(Collect_CXVWDAO collect_CXVWDAO) {
		this.collect_CXVWDAO = collect_CXVWDAO;
	}

	public List<Collect_CXVWInfo> CX_findProtDeviceName(Collect_BusySearchCond cond, int start, int count) {
		return collect_CXVWDAO.CX_findProtDeviceName(cond, start, count);
	}

	public List<Collect_CXVWInfo> findProtByCond_CX(
			Collect_BusySearchCond cond, int start, int count) {
		return collect_CXVWDAO.findProtByCond_CX(cond, start, count);
	}

	public List<Collect_CXVWInfo> findSPByCond_CX(
			Collect_BusySearchCond cond, int start, int count) {
		return collect_CXVWDAO.findSPByCond_CX(cond, start, count);
	}





}
