/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG113Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表单日志显示VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR01231VO extends BaseVO{

	/** 表单日志集合*/
	protected List<IG113Info> varLogList;

	/**
	 * 表单日志集合取得
	 * @return varLogList 表单日志集合
	 */
	public List<IG113Info> getVarLogList() {
		return varLogList;
	}

	/**
	 * 表单日志集合设定
	 * @param varLogList 表单日志集合
	 */
	public void setVarLogList(List<IG113Info> varLogList) {
		this.varLogList = varLogList;
	}
}
