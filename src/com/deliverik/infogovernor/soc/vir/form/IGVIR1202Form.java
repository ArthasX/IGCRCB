/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机使用情况展示Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1202Form extends BaseForm{

	/** vCenter连接ID */
	protected Integer vcid;

	/**
	 * vCenter连接ID取得
	 * @return vcid vCenter连接ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter连接ID设定
	 * @param vcid vCenter连接ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}
}
