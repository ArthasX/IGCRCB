/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */


package com.csebank.lom.model;
import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 *  发票管理实体接口
 * 
 * @author piaow@deliverik.com
 * 
 */

public interface Invoice extends BaseModel {
	/**
	 * 发票管理ID取得
	 * 
	 * @return 发票管理ID
	 */
	public Integer getIid();

	/**
	 * 发票类型取得
	 * 
	 * @return 发票类型
	 */
	public String getItype();
	
	/**
	 * 开票日期取得
	 * 
	 * @return 开票日期
	 */
	public String getIdate();
	
	/**
	 * 发票号码取得
	 * 
	 * @return 发票号码
	 */
	public String getInum();
	
	/**
	 * 金额取得
	 * 
	 * @return 金额
	 */
	public BigDecimal getIamount();

	/**
	 * 用途说明描述取得
	 * 
	 * @return 用途说明描述
	 */
	public String getIcomment();

	/**
	 * 合同编号取得
	 * 
	 * @return 合同编号状态
	 */
	public String getIcontractserial();
	
	/**
	 * 合同名称取得
	 * 
	 * @return 合同名称
	 */
	public String getIcontractname();
		
	/**
	 * 收款单位名称取得
	 * 
	 * @return 收款单位名称
	 */
	public String getIcorporation();
	
	/**
	 * 开户银行取得
	 * 
	 * @return 开户银行
	 */
	public String getIbank();
	
	/**
	 * 账号取得
	 * 
	 * @return 账号
	 */
	public String getIaccount();
	
	/**
	 * 申请部门层次码取得
	 * 
	 * @return 申请部门层次码
	 */
	public String getIreqemp();
	
	/**
	 * 申请人ID取得
	 * 
	 * @return 申请人ID
	 */
	public String getIrequser();
	
	/**
	 * 申请人姓名取得
	 * 
	 * @return 申请人姓名
	 */
	public String getIrequsername();
	
	/**
	 * 状态取得
	 * 
	 * @return 状态
	 */
	public String getIstatus();

	/**
	 * 付款方式取得
	 * 
	 * @return 付款方式
	 */
	public String getIpaymenttype();
	
	/**
	 * 付款方式号码取得
	 * 
	 * @return 付款方式号码
	 */
	public String getIpaymenttypecode(); 
	
	/**
	 * 付款日期取得
	 * 
	 * @return 付款日期
	 */
	public String getIpaymentdate();
	
	
	public OrganizationTB getOrganizationTB();




}