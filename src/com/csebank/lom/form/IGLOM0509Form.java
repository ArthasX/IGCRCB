/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_部门接待统计FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0509Form extends BaseForm implements DeptEentertainmentSearchCond {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询条件
	 */
	public String ewhere;
	
	public Integer rid;
	
	/**
	 * 食堂招待费用统计开始时间查询
	 */
	public String etime_from;
	
	/**
	 * 食堂招待费用统计结束时间查询
	 */
	public String etime_to;

	/**
	 * 食堂成本信息时间查询取得
	 * @return 食堂成本信息开始时间查询
	 */
	public String getEtime_from() {
		return etime_from;
	}

	/**
	 * 食堂招待费用统计开始时间查询设定
	 * @param etime_from 食堂招待费用统计开始时间查询
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * 食堂招待费用统计结束时间查询取得
	 * @return 食堂招待费用统计结束时间查询
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * 食堂招待费用统计结束时间查询设定
	 * @param etime_to 食堂招待费用统计结束时间查询
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * 查询条件
	 * @return 查询条件
	 */
	public String getEwhere() {
		return ewhere;
	}
	
	/**
	 * 查询条件
	 * @param ewhere 查询条件
	 */
	public void setEwhere(String ewhere) {
		this.ewhere = ewhere;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}
}
