/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 风险检查实体接口
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskCheck  extends BaseModel {
	/**
	 * 风险检查ID取得
	 * @return 风险检查ID
	 */
	public Integer getRcid(); 
	
	/**
	 * 风险检查名称取得
	 * @return 风险检查名称
	 */
	public String getRcname();

	/**
	 * 风险检查描述取得
	 * @return 风险检查描述
	 */
	public String getRcdesc();

	/**
	 * 重要度取得
	 * @return 重要度
	 */
	public String getRctype();

	/**
	 * 风险检查状态取得
	 * @return 风险检查状态
	 */
	public String getRcstatus(); 

	/**
	 * 风险检查起始时间取得
	 * @return 风险检查起始时间
	 */
	public String getRcstartdate();

	/**
	 * 风险检查结束时间取得
	 * @return 风险检查结束时间
	 */
	public String getRcenddate();

	/**
	 * 风险检查频率取得
	 * @return 风险检查频率
	 */
	public String getRcfrequency();
	
	/**
	 * 风险检查频率内容取得
	 * @return 风险检查频率内容
	 */
	public String getRcfrequencydesc();

	/**
	 * 风险检查责任人ID取得
	 * @return 风险检查责任人ID
	 */
	public String getRcuserid();

	/**
	 * 风险检查责任人姓名取得
	 * @return 风险检查责任人姓名
	 */
	public String getRcusername();

	/**
	 * 风险检查责任组角色ID取得
	 * @return 风险检查责任组角色ID
	 */
	public Integer getRcroleid();

	/**
	 * 风险检查责任组角色名取得
	 * @return 风险检查责任组角色名
	 */
	public String getRcrolename();

	/**
	 * 风险检查相关资产ID取得
	 * @return 风险检查相关资产ID
	 */
	public Integer getRcasset();

	/**
	 * 风险检查附件ID取得
	 * @return 风险检查附件ID
	 */
	public String getRcattch();

	/**
	 * 风险检查选项取得
	 * @return 风险检查选项
	 */
	public String getRcoption();
	
	/**
	 * 风险检查策略执行表达式取得
	 * @return 风险检查策略执行表达式
	 */
	public String getRccron();
	
	/**
	 * 风险检查相关资产名称
	 * @return 风险检查相关资产名称
	 */
	public String getRcassetname();
	
	/**
	 * 风险检查项类别取得
	 * @return 风险检查项类别
	 */
	public String getRccategory();
	
	/**
	 * 风险检查项类别名称取得
	 * @return 风险检查项类别名称
	 */
	public String getRccategoryname();
	
	/**
	 * 风险检查登记时间取得
	 * @return 风险检查登记时间
	 */
	public String getRccreatetime();
	
	/**
	 * 风险检查审批时间取得
	 * @return 风险检查审批时间
	 */
	public String getRcapprovetime();
	
	/**
	 * 风险检查审批人取得
	 * @return 风险检查审批人
	 */
	public String getRcapprover();
	
	/**
	 * 风险检查频率(每月最后一天)取得
	 * @return 风险检查频率(每月最后一天)
	 */
	public String getRcfrequencymonthlastday();
	
	/**
	 * 处理时间取得
	 * @return 处理时间
	 */
	public String getRcupdatetime();
	
	/**
	 * 类型取得
	 * @return 类型时间
	 */
	public String getRcclass();

	/**
	 * 检查方法取得
	 * @return 检查方法
	 */
	public String getRccommon();
	/**
	 * 合作执行组取得
	 * @return 合作执行组
	 */
	public String getCog();
	/**
	 * 合作执行人取得
	 * @return 合作执行人
	 */
	public String getCiiop();
	/**
	 * 工作执行期限取得
	 * @return 工作执行期限
	 */
	public Integer getWtip();
	/**
	 * 合作执行组ID取得
	 * @return 合作执行组ID
	 */
	public String getCogid();
	/**
	 * 合作执行人ID取得
	 * @return 合作执行人ID
	 */
	public String getCiiopid();
	public String getRcrtestmode();
	
	/**
	 * 风险检查相关资产版本号取得
	 * @return the rcassetversion
	 */
	public Integer getRcassetversion();
}