/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.DeptEentertainment;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 接待统计VO
 *
 */
public class IGLOM05091VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 接待统计结果
	 */
	protected List<DeptEentertainment> deptEentertainment;

	/**
	 * 接待统计结果取得
	 * @return 接待统计结果
	 */
	public List<DeptEentertainment> getDeptEentertainmentList() {
		return deptEentertainment;
	}

	/**
	 * 接待统计结果
	 * @param deptEentertainment 接待统计结果
	 */
	public void setDeptEentertainmentList(List<DeptEentertainment> deptEentertainment) {
		this.deptEentertainment = deptEentertainment;
	}

}
