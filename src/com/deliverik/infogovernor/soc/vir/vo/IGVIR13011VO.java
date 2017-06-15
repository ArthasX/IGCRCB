/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机资源管理VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR13011VO extends BaseVO{

	/** 虚机信息集合 */
	protected List<VIM03Info> vim03List;

	/**
	 * 虚机信息集合取得
	 * @return vim03List 虚机信息集合
	 */
	public List<VIM03Info> getVim03List() {
		return vim03List;
	}

	/**
	 * 虚机信息集合设定
	 * @param vim03List 虚机信息集合
	 */
	public void setVim03List(List<VIM03Info> vim03List) {
		this.vim03List = vim03List;
	}
}
