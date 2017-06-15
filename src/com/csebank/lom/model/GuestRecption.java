/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */


package com.csebank.lom.model;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 *  接待客人查询实体
 * 
 * @author songhaiyang@deliverik.com
 * 
 */
public interface GuestRecption {
	/**
	 * 接待客人ID取得
	 * 
	 * @return 接待RID
	 */
	public Integer getRgid();
	
	/**
	 * 接待工作ID取得
	 * 
	 * @return 接待工作ID
	 */
	public Integer getRid();
	
	/**
	 * 接待工作名称取得
	 * 
	 * @return 接待工作名称
	 */
	public String getRname();
	
	/**
	 * 主要申请部门取得
	 * 
	 * @return 主要申请部门
	 */
	public String getRapporgid();
	
	/**
	 * 接待开始日期取得
	 * 
	 * @return 接待开始日期
	 */
	public String getRstime();
	
	/**
	 * 接待结束日期取得
	 * 
	 * @return 接待结束日期
	 */
	public String getRetime();

	/**
	 *  接待客人单位取得
	 * 
	 * @return 接待客人单位
	 */
	public String getRgunit();

	/**
	 * 接待客人姓名取得
	 * 
	 * @return 接客人姓名
	 */
	public String getRgname();
	
	/** 状态（1进行中，2结束）取得
	 * 
	 *  @return 状态（
	 */
	public String getRstatus();
	
	/** 机构信息实体取得
	 * 
	 * @return 机构信息实体
	 */
	public OrganizationTB getOrganizationTB();

}