/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3001Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3002Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3003Form;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:虚拟化Vcloud管理DTO 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR30DTO extends BaseDTO{
	
	/** 项目ID */
	protected Integer pid;

	/** 用户信息 */
	protected User user;
	
	/** json结果 */
	protected String jsonResult;

	/** vCloud虚拟化申请发起Form */
	protected IGVIR3001Form igvir3001Form;
	
	/** vCloud虚拟化申请处理Form */
	protected IGVIR3002Form igvir3002Form;
	
	/** 自动部署进度显示Form */
	protected IGVIR3003Form igvir3003Form;
	
	/** 项目信息 */
	protected VCD02Info vcd02;
	
	/** vmids */
	protected String vmids;
	
	/** vm信息集合 */
	protected List<VCD03Info> vcd03List;
	
	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目ID设定
	 * @param pid 项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
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
	 * json结果取得
	 * @return jsonResult json结果
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * json结果设定
	 * @param jsonResult json结果
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * vCloud虚拟化申请发起Form取得
	 * @return igvir3001Form vCloud虚拟化申请发起Form
	 */
	public IGVIR3001Form getIgvir3001Form() {
		return igvir3001Form;
	}

	/**
	 * vCloud虚拟化申请发起Form设定
	 * @param igvir3001Form vCloud虚拟化申请发起Form
	 */
	public void setIgvir3001Form(IGVIR3001Form igvir3001Form) {
		this.igvir3001Form = igvir3001Form;
	}

	/**
	 * vCloud虚拟化申请处理Form取得
	 * @return igvir3002Form vCloud虚拟化申请处理Form
	 */
	public IGVIR3002Form getIgvir3002Form() {
		return igvir3002Form;
	}

	/**
	 * vCloud虚拟化申请处理Form设定
	 * @param igvir3002Form vCloud虚拟化申请处理Form
	 */
	public void setIgvir3002Form(IGVIR3002Form igvir3002Form) {
		this.igvir3002Form = igvir3002Form;
	}

	/**
	 * 自动部署进度显示Form取得
	 * @return igvir3003Form 自动部署进度显示Form
	 */
	public IGVIR3003Form getIgvir3003Form() {
		return igvir3003Form;
	}

	/**
	 * 自动部署进度显示Form设定
	 * @param igvir3003Form 自动部署进度显示Form
	 */
	public void setIgvir3003Form(IGVIR3003Form igvir3003Form) {
		this.igvir3003Form = igvir3003Form;
	}

	/**
	 * 项目信息取得
	 * @return vcd02 项目信息
	 */
	public VCD02Info getVcd02() {
		return vcd02;
	}

	/**
	 * vmids取得
	 * @return vmids vmids
	 */
	public String getVmids() {
		return vmids;
	}

	/**
	 * 项目信息设定
	 * @param vcd02 项目信息
	 */
	public void setVcd02(VCD02Info vcd02) {
		this.vcd02 = vcd02;
	}

	/**
	 * vmids设定
	 * @param vmids vmids
	 */
	public void setVmids(String vmids) {
		this.vmids = vmids;
	}

	/**
	 * vm信息集合取得
	 * @return vcd03List vm信息集合
	 */
	public List<VCD03Info> getVcd03List() {
		return vcd03List;
	}

	/**
	 * vm信息集合设定
	 * @param vcd03List vm信息集合
	 */
	public void setVcd03List(List<VCD03Info> vcd03List) {
		this.vcd03List = vcd03List;
	}
}
