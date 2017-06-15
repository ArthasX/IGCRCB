/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源使用情况统计VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR14021VO extends BaseVO{

	/** Host信息集合 */
	protected Map<Integer,List<Host>> hostMap;

	/**
	 * Host信息集合取得
	 * @return hostMap Host信息集合
	 */
	public Map<Integer, List<Host>> getHostMap() {
		return hostMap;
	}

	/**
	 * Host信息集合设定
	 * @param hostMap Host信息集合
	 */
	public void setHostMap(Map<Integer, List<Host>> hostMap) {
		this.hostMap = hostMap;
	}
}
