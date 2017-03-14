/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * 概述: 拓扑图业务逻辑接口
  * 功能描述: 拓扑图业务逻辑接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SocDomainGraphBL extends BaseBL {

	/**
	 * 拓扑图显示初始化处理(默认检索default域)
	 * 
	 * @param ei 选中资产信息
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 创建时间
	 * @return 显示用XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(IG688Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException;

}