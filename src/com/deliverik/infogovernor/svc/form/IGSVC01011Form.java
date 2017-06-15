/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_事件管理_事件查看历史记录FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC01011Form extends BaseForm implements IG036SearchCond {

	/**流程编号*/
	protected Integer prid;

	/**操作用户ID*/
	protected String rluserid;

	/**操作用户名称*/
	protected String rlusername;

	/**
	 * 获取流程编号
	 * @return 流程编号
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 设置流程编号
	 * @param prid 流程编号
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 获取操作用户ID
	 * @return 操作用户ID
	 */
	public String getRluserid() {
		return rluserid;
	}

	/**
	 * 设置操作用户ID
	 * @param rluserid 操作用户ID
	 */
	public void setRluserid(String rluserid) {
		this.rluserid = rluserid;
	}

	/**
	 * 获取操作用户名称
	 * @return 操作用户名称
	 */
	public String getRlusername() {
		return rlusername;
	}

	/**
	 * 设置操作用户名称
	 * @param rlusername 操作用户名称
	 */
	public void setRlusername(String rlusername) {
		this.rlusername = rlusername;
	}

	public String getNotEqualrlType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPsdcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRlType() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getRoleid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRolemanger() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoleorder_type() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isRoleorder() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPsdid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPsdnum() {
		// TODO Auto-generated method stub
		return null;
	}

}
