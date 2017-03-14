/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 数据VO
 * </p>
 * 2014-6-19
 * @author zhangq@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK07012VO extends BaseVO{

	/** 风险提示对象 */
	protected RiskmanagerwaringInfo risk;
	
	/** 下发人员集合 */
	protected List<AcceptuserInfo> acceptuserList;

	/**
	 * 风险提示对象取得
	 * @return risk 风险提示对象
	 */
	public RiskmanagerwaringInfo getRisk() {
		return risk;
	}

	/**
	 * 风险提示对象设定
	 * @param risk 风险提示对象
	 */
	public void setRisk(RiskmanagerwaringInfo risk) {
		this.risk = risk;
	}

	/**
	 * 下发人员集合取得
	 * @return acceptuserList 下发人员集合
	 */
	public List<AcceptuserInfo> getAcceptuserList() {
		return acceptuserList;
	}

	/**
	 * 下发人员集合设定
	 * @param acceptuserList 下发人员集合
	 */
	public void setAcceptuserList(List<AcceptuserInfo> acceptuserList) {
		this.acceptuserList = acceptuserList;
	}
}
