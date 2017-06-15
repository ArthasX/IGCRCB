/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGCIM0204Form extends BaseForm implements SOC0112SearchCond{
	
	/**资产域ID**/
	private Integer eiddid;
	
	/**资产域版本**/
	private Integer eiddversion;
	
	/**
	 * 已添加导入资产
	 */
	protected String[] owneiddids;
	
	/**
	 * 未添加导入资产
	 */
	protected String[] eiddids;
	
	/**
	 * 处理方式1-删除，0-添加
	 */
	protected String mode;
	
	/** 逻辑删除标识 */
	private String deleteflag;
	
	
	
	/**获取资产域ID**/
	public Integer getEiddid() {
		return eiddid;
	}
	
	/**
	 * 资产域ID设定
	 * @param eiddid资产域ID
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	/**获取资产域版本**/
	public Integer getEiddversion() {
		return eiddversion;
	}
	/**
	 * 资产域版本设定
	 * @param eiddversion资产域版本
	 */
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}
	
	
		
	/**
	 * 重置Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.owneiddids = null;
		this.eiddids = null;
	}
	
	/**
	 * 获取处理方式1-删除，0-添加
	 * @return String[]
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * 设置处理方式1-删除，0-添加
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 已添加导入资产取得
	 * @return 已添加导入资产
	 */
	public String[] getOwneiddids() {
		return owneiddids;
	}
	/**
	 * 已添加导入资产设定
	 * @param owneiddids已添加导入资产
	 */
	public void setOwneiddids(String[] owneiddids) {
		this.owneiddids = owneiddids;
	}
	/**
	 * 未添加导入资产取得
	 * @return 未添加导入资产
	 */
	public String[] getEiddids() {
		return eiddids;
	}
	/**
	 * 未添加导入资产设定
	 * @param eiddids未添加导入资产
	 */
	public void setEiddids(String[] eiddids) {
		this.eiddids = eiddids;
	}
	/**
	 * 逻辑删除标识取得
	 */
	public String getDeleteflag() {
		return deleteflag;
	}
	/**
	 * 逻辑删除标识设定
	 * @param deleteflag逻辑删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
}
