/*
 * 北京递蓝科软件技术有限公司。
 */
package com.deliverik.plugin.PluginMgr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.plugin.PluginMgr.dto.IGPluginDTO;

/**
 * 概述: 插件管理接口
 * 功能描述: 插件管理接口
 * 创建记录: 2012-11-5
 * 修改记录: 
 */
public interface IGPluginMgrBL extends BaseBL {
	//查询插件列表
	public IGPluginDTO getPluginList(IGPluginDTO dto)throws BLException;
	//更改插件状态
	public IGPluginDTO modifyPlugin(IGPluginDTO dto)throws BLException;
	//更新插件缓存
	public IGPluginDTO updatePluginDataXml(IGPluginDTO dto)throws BLException, Exception;
}
