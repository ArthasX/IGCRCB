/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.ram.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * 风险评估类型查询结果ＶＯ
 * 
 * @author tangzhen@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRAM01011VO extends BaseVO implements Serializable{
	
	/** 风险评估类型查询结果 */
	protected List<IG380Info> ig380List;

	/**
	 * ig380List取得
	 */
	public List<IG380Info> getIg380List() {
		return ig380List;
	}

	/**
	 * ig380List设定
	 */
	public void setIg380List(List<IG380Info> ig380List) {
		this.ig380List = ig380List;
	}



}


