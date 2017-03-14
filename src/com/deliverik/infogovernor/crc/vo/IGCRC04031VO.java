/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.risk.form.IGRIS0203Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更批量分派VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC04031VO extends BaseVO{

	/** 分派信息 */
	protected Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo;

	protected IGRIS0203Form form;
	
	protected Integer[] prids;
	/**
	 * 分派信息取得
	 * @return assignInfo 分派信息
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfo() {
		return assignInfo;
	}

	/**
	 * 分派信息设定
	 * @param assignInfo 分派信息
	 */
	public void setAssignInfo(Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo) {
		this.assignInfo = assignInfo;
	}

	/**
	 * @return the form
	 */
	public IGRIS0203Form getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(IGRIS0203Form form) {
		this.form = form;
	}

	/**
	 * @return the prids
	 */
	public Integer[] getPrids() {
		return prids;
	}

	/**
	 * @param prids the prids to set
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}
	
	
	
}
