package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0801Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0802Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0803Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0804Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0805Form;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * 虚拟化管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR08DTO extends BaseDTO implements Serializable{
	
	protected IGVIR0801Form igVIR0801Form;
	protected IGVIR0802Form igVIR0802Form;
	protected IGVIR0803Form igVIR0803Form;
	protected IGVIR0804Form igVIR0804Form;
	protected IGVIR0805Form igVIR0805Form;
	
	/**
	 * 分页Bean
	 */
	protected PagingDTO pagingDto;
	
	/**
	 * 允许查询的最大记录数
	 */
	protected int maxSearchCount;
	
	/**
	 * 虚拟资源统计结果（按用户）
	 */
	protected List<VIM03CountByUserVWInfo> vim03uList;
	
	/**
	 * 虚拟资源统计结果（按机构）
	 */
	protected List<VIM03CountByOrgVWInfo> vim03oList;
	
	/**
	 * 虚拟资源统计结果（按项目）
	 */
	protected List<VIM03CountByProjVWInfo> vim03pList;
	
	/**
	 * 虚拟资源统计结果（某一用户）
	 */
	protected List<VIM03Info> oneVim03uList;
	
	/**
	 * 虚拟资源统计结果（某一机构）
	 */
	protected List<VIM03Info> oneVim03oList;
	
	/**
	 * 虚拟资源统计结果
	 */
	protected List<VIM03Info> oneVim03List;
	
	/**
	 * 用户信息
	 */
	protected User user;
	
	/**
	 * 机构信息
	 */
	protected Organization orgbean;

	/**
	 * 登陆用户
	 * */
	protected User loginUser;
	
	/**
	 * igVIR0801Form取得
	 * @return igVIR0801Form igVIR0801Form
	 */
	public IGVIR0801Form getIgVIR0801Form() {
		return igVIR0801Form;
	}

	/**
	 * igVIR0801Form设定
	 * @param igVIR0801Form igVIR0801Form
	 */
	public void setIgVIR0801Form(IGVIR0801Form igVIR0801Form) {
		this.igVIR0801Form = igVIR0801Form;
	}

	/**
	 * igVIR0802Form取得
	 * @return igVIR0802Form igVIR0802Form
	 */
	public IGVIR0802Form getIgVIR0802Form() {
		return igVIR0802Form;
	}

	/**
	 * igVIR0802Form设定
	 * @param igVIR0802Form igVIR0802Form
	 */
	public void setIgVIR0802Form(IGVIR0802Form igVIR0802Form) {
		this.igVIR0802Form = igVIR0802Form;
	}

	/**
	 * igVIR0803Form取得
	 * @return igVIR0803Form igVIR0803Form
	 */
	public IGVIR0803Form getIgVIR0803Form() {
		return igVIR0803Form;
	}

	/**
	 * igVIR0803Form设定
	 * @param igVIR0803Form igVIR0803Form
	 */
	public void setIgVIR0803Form(IGVIR0803Form igVIR0803Form) {
		this.igVIR0803Form = igVIR0803Form;
	}

	/**
	 * igVIR0804Form取得
	 * @return igVIR0804Form igVIR0804Form
	 */
	public IGVIR0804Form getIgVIR0804Form() {
		return igVIR0804Form;
	}

	/**
	 * igVIR0804Form设定
	 * @param igVIR0804Form igVIR0804Form
	 */
	public void setIgVIR0804Form(IGVIR0804Form igVIR0804Form) {
		this.igVIR0804Form = igVIR0804Form;
	}

	/**
	 * igVIR0805Form取得
	 * @return igVIR0805Form igVIR0805Form
	 */
	public IGVIR0805Form getIgVIR0805Form() {
		return igVIR0805Form;
	}

	/**
	 * igVIR0805Form设定
	 * @param igVIR0805Form igVIR0805Form
	 */
	public void setIgVIR0805Form(IGVIR0805Form igVIR0805Form) {
		this.igVIR0805Form = igVIR0805Form;
	}

	/**
	 * 分页Bean取得
	 * @return pagingDto 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 允许查询的最大记录数取得
	 * @return maxSearchCount 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 虚拟资源统计结果（按用户）取得
	 * @return vim03uList 虚拟资源统计结果（按用户）
	 */
	public List<VIM03CountByUserVWInfo> getVim03uList() {
		return vim03uList;
	}

	/**
	 * 虚拟资源统计结果（按用户）设定
	 * @param vim03uList 虚拟资源统计结果（按用户）
	 */
	public void setVim03uList(List<VIM03CountByUserVWInfo> vim03uList) {
		this.vim03uList = vim03uList;
	}

	/**
	 * 虚拟资源统计结果（按机构）取得
	 * @return vim03oList 虚拟资源统计结果（按机构）
	 */
	public List<VIM03CountByOrgVWInfo> getVim03oList() {
		return vim03oList;
	}

	/**
	 * 虚拟资源统计结果（按机构）设定
	 * @param vim03oList 虚拟资源统计结果（按机构）
	 */
	public void setVim03oList(List<VIM03CountByOrgVWInfo> vim03oList) {
		this.vim03oList = vim03oList;
	}

	/**
	 * 虚拟资源统计结果（按项目）取得
	 * @return vim03pList 虚拟资源统计结果（按项目）
	 */
	public List<VIM03CountByProjVWInfo> getVim03pList() {
		return vim03pList;
	}

	/**
	 * 虚拟资源统计结果（按项目）设定
	 * @param vim03pList 虚拟资源统计结果（按项目）
	 */
	public void setVim03pList(List<VIM03CountByProjVWInfo> vim03pList) {
		this.vim03pList = vim03pList;
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
	 * 虚拟资源统计结果（某一机构）取得
	 * @return oneVim03oList 虚拟资源统计结果（某一机构）
	 */
	public List<VIM03Info> getOneVim03oList() {
		return oneVim03oList;
	}

	/**
	 * 虚拟资源统计结果（某一机构）设定
	 * @param oneVim03oList 虚拟资源统计结果（某一机构）
	 */
	public void setOneVim03oList(List<VIM03Info> oneVim03oList) {
		this.oneVim03oList = oneVim03oList;
	}

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

	/**
	 * 机构信息取得
	 * @return orgbean 机构信息
	 */
	public Organization getOrgbean() {
		return orgbean;
	}

	/**
	 * 机构信息设定
	 * @param orgbean 机构信息
	 */
	public void setOrgbean(Organization orgbean) {
		this.orgbean = orgbean;
	}

	/**
	 * 登陆用户取得
	 * @return loginUser 登陆用户
	 */
	public User getLoginUser() {
		return loginUser;
	}

	/**
	 * 登陆用户设定
	 * @param loginUser 登陆用户
	 */
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	
}


