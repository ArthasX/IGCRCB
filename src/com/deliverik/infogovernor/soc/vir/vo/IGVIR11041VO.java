package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * 虚拟资源统计结果	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR11041VO extends BaseVO implements Serializable{
	
	/**
	 * 虚拟资源统计结果
	 */
	protected List<VIM03Info> oneVim03List;
	/**
	 * 虚拟资源统计结果（某一用户）
	 */
	protected List<VIM03Info> oneVim03uList;
	/**
	 * 用户信息
	 */
	protected User user;

	/**
	 * 虚拟资源统计结果取得
	 * @return oneVim03List 虚拟资源统计结果
	 */
	public List<VIM03Info> getOneVim03List() {
		return oneVim03List;
	}

	/**
	 * 虚拟资源统计结果设定
	 * @param oneVim03List 虚拟资源统计结果
	 */
	public void setOneVim03List(List<VIM03Info> oneVim03List) {
		this.oneVim03List = oneVim03List;
	}

	/**
	 * 虚拟资源统计结果（某一用户）取得
	 * @return oneVim03uList 虚拟资源统计结果（某一用户）
	 */
	public List<VIM03Info> getOneVim03uList() {
		return oneVim03uList;
	}

	/**
	 * 虚拟资源统计结果（某一用户）设定
	 * @param oneVim03uList 虚拟资源统计结果（某一用户）
	 */
	public void setOneVim03uList(List<VIM03Info> oneVim03uList) {
		this.oneVim03uList = oneVim03uList;
	}

	/**
	 * 用户信息取得
	 * @return user 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

}


