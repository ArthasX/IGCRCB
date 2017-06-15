/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_DisksVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;


/**
 * 
 * @Description:存储基本信息BL接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_DisksVWInfoBL extends BaseBL{
	
	/**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<Collect_DisksVWInfo> findByCond(final Collect_BusySearchCond cond, final int start, final int count);

    /**
     * 获取全部磁盘名称
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<Collect_DisksVWInfo> findDisksDeviceName(final Collect_BusySearchCond cond, final int start, final int count);

	
    public List<Collect_DisksVWInfo> CX_findDisksDeviceName(final Collect_BusySearchCond cond, final int i, final int j);

	public List<Collect_DisksVWInfo> findDisksByCond_CX(
			final	Collect_BusySearchCond cond, final int i, final int j);

}

