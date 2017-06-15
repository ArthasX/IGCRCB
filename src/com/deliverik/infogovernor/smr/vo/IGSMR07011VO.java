/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * 不定期报表VO
 *  
 */
@SuppressWarnings("serial")
public class IGSMR07011VO  extends BaseVO implements Serializable {
	
	/** 已启动的不定期报表列表 */
	protected List<IG380Info> ig380List;

	/**
	 *已启动的不定期报表列表取得
	 */
	public List<IG380Info> getIg380List() {
		return ig380List;
	}

	/**
	 *已启动的不定期报表列表设定
	 */
	public void setIg380List(List<IG380Info> ig380List) {
		this.ig380List = ig380List;
	}
	
	
	

}
