/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.Notice;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_通知管理_查询VO
 * </p>
 * 
 * @author tangxiaona@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM14012VO extends BaseVO implements Serializable {

	/**
	 * 通知对象List
	 */
	
	protected Notice notice;

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}


}
