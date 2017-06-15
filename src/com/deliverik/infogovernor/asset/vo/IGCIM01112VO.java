/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:配置源数据版本比较信息vo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM01112VO extends BaseVO{

	/** 分类 */
	protected String category;
	
	/** 关键字 */
	protected String keys;
	
	/** 采集命令 */
	protected String command;
	
	/** 被比较数据 */
	protected String compare1;
	
	/** 比较数据 */
	protected String compare2;
	
	/** 比较结果显示样式 */
	protected String compareStyle;

	/**
	 * 分类取得
	 * @return 分类
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 分类设定
	 * @param category 分类
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 关键字取得
	 * @return 关键字
	 */
	public String getKeys() {
		return keys;
	}

	/**
	 * 关键字设定
	 * @param keys 关键字
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}
	
	/**
	 * 采集命令取得
	 * @return 采集命令
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * 采集命令设定
	 * @param command 采集命令
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * 被比较数据取得
	 * @return 被比较数据
	 */
	public String getCompare1() {
		return compare1;
	}

	/**
	 * 被比较数据设定
	 * @param compare1 被比较数据
	 */
	public void setCompare1(String compare1) {
		this.compare1 = compare1;
	}

	/**
	 * 比较数据取得
	 * @return 比较数据
	 */
	public String getCompare2() {
		return compare2;
	}

	/**
	 * 比较数据设定
	 * @param compare2 比较数据
	 */
	public void setCompare2(String compare2) {
		this.compare2 = compare2;
	}

	/**
	 * 比较结果显示样式取得
	 * @return 比较结果显示样式
	 */
	public String getCompareStyle() {
		return compareStyle;
	}

	/**
	 * 比较结果显示样式设定
	 * @param compareStyle 比较结果显示样式
	 */
	public void setCompareStyle(String compareStyle) {
		this.compareStyle = compareStyle;
	}
	
	
}
