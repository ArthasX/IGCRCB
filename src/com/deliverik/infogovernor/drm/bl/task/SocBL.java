/**
 * 
 */
package com.deliverik.infogovernor.drm.bl.task;

import com.deliverik.framework.base.BaseBL;

/**
 * @author Administrator
 *
 */
public interface SocBL  extends BaseBL {
	/**
	 * 通过prid查询场景的定义ID
	 */
	public String searchFlowPidid(Integer prid);
}
