/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

public interface IGFIN05BL extends BaseBL {
	public String getDataXml() throws BLException;
}
