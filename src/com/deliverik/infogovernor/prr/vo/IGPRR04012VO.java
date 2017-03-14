/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR04012VO extends BaseVO {

	/** 显示标题 */
	protected String title;
	
	/** 是否显示标题(1：显示 0：不显示) */
	protected String isShowTitle = "1";
	
	/** 显示内容 */
	protected List<IG380Info> content;

	/**
	 * 显示标题取得
	 * @return title 显示标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 显示标题设定
	 * @param title 显示标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 是否显示标题取得
	 * @return isShowTitle 是否显示标题
	 */
	public String getIsShowTitle() {
		return isShowTitle;
	}

	/**
	 * 是否显示标题设定
	 * @param isShowTitle 是否显示标题
	 */
	public void setIsShowTitle(String isShowTitle) {
		this.isShowTitle = isShowTitle;
	}

	/**
	 * 显示内容取得
	 * @return content 显示内容
	 */
	public List<IG380Info> getContent() {
		return content;
	}

	/**
	 * 显示内容设定
	 * @param content 显示内容
	 */
	public void setContent(List<IG380Info> content) {
		this.content = content;
	}
}
