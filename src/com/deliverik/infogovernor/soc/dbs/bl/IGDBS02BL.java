/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_DaVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_FibreVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_RfbVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_DisksVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;

/**
 * @概述SOC EMC运维存储管理平台首页BL
 * @功能描述
 * @创建记录：
 * @version 1.0
 */

public interface IGDBS02BL extends BaseBL {

	public List<Collect_Dir_FibreVWInfo> findFrontCPUBusy(
			final Collect_BusySearchCond cond, final int start, final int count) throws BLException;

	public List<Collect_Dir_DaVWInfo> findBehindCPUBusy(
			final Collect_BusySearchCond cond, final int start, final int count) throws BLException;

	public List<Collect_DisksVWInfo> findDisksBusy(
			final Collect_BusySearchCond cond, final int start, final int count) throws BLException;

	public List<Collect_Dir_RfbVWInfo> findFrontCPUBusy2(
			final Collect_BusySearchCond cond, final int start, final int count) throws BLException;

	public String createXml(Collect_BusySearchCond cond) throws BLException;

	/**
	 * 第一次进入不查询数据库
	 * 
	 * @return
	 */
	public String initXml(Collect_BusySearchCond cond) throws BLException;

	public String initCXXml(Collect_BusySearchCond cond) throws BLException;

	public String createXml_cx(Collect_BusySearchCond cond) throws BLException;
	
	public String getSymm_version(String symm_id) throws BLException;
	
	public String getSymm_model(String symm_id) throws BLException;
	

}
