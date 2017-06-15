/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 概述：应急人员就位表业务逻辑接口
 * 功能描述：应急人员就位表业务逻辑接口
 * 创建记录：2014/05/19
 * 修改记录：
 */
public interface ParentNodeBL extends BaseBL {
	
	public List<Map<String,Object>> getParentNodes(String psdid) throws BLException;
}