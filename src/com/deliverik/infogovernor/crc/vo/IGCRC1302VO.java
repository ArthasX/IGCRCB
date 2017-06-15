/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1302VO extends BaseVO{

	/** 文档借阅检索结果 */
	protected List<IG500Info> ig500InfoList;

	/**
	 * 文档借阅检索结果取得
	 * @return ig500InfoList 文档借阅检索结果
	 */
	public List<IG500Info> getIg500InfoList() {
		return ig500InfoList;
	}

	/**
	 * 文档借阅检索结果设定
	 * @param ig500InfoList 文档借阅检索结果
	 */
	public void setIg500InfoList(List<IG500Info> ig500InfoList) {
		this.ig500InfoList = ig500InfoList;
	}
}
