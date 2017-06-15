package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.UserTB;

/**
 * 流程参与用户信息
 *
 */
public interface IG337Info  extends BaseModel {

	/**
	 * 流程参与用户所属机构名称取得
	 * @return 流程参与用户所属机构名称
	 */
	public String getPporgname();

	/**
	 * 流程参与用户ID取得
	 * @return 流程参与用户ID
	 */
	public Integer getPpid();

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();
	
	/**
	 * 流程参与用户所属机构层次码取得
	 * @return 流程参与用户所属机构层次码
	 */
	public String getPporgid();

	/**
	 * 流程参与用户角色ID取得
	 * @return 流程参与用户角色ID
	 */
	public Integer getPproleid();

	/**
	 * 流程参与用户角色名称取得
	 * @return 流程参与用户角色名称
	 */
	public String getPprolename();

	/**
	 * 流程参与用户ID取得
	 * @return 流程参与用户ID
	 */
	public String getPpuserid();

	/**
	 * 流程参与用户名字取得
	 * @return 流程参与用户名字
	 */
	public String getPpusername();

	/**
	 * 流程参与用户的参与类型取得
	 * @return 流程参与用户的参与类型
	 */
	public String getPptype();

	/**
	 * 流程参与用户的信息（联系方式等）取得
	 * @return 流程参与用户的信息（联系方式等）
	 */
	public String getPpuserinfo();

	/**
	 * 流程参与用户的工作评语取得
	 * @return 流程参与用户的工作评语
	 */
	public String getPpcomment();

	/**
	 * 流程参与用户的参与状态取得
	 * @return 流程参与用户的参与状态
	 */
	public String getPpstatus();

	/**
	 * 附件索引KEY取得
	 * @return 附件索引KEY
	 */
	public String getPpattkey();

	/**
	 * 流程参与用户指定时间取得
	 * @return 流程参与用户指定时间
	 */
	public String getPpinittime();

	/**
	 * 流程参与用户处理完成时间取得
	 * @return 流程参与用户处理完成时间
	 */
	public String getPpproctime();

	/**
	 * 流程参与用户子状态取得
	 * @return 流程参与用户子状态
	 */
	public String getPpsubstatus();

	/**
	 * 流程参与用户实际解决时间取得
	 * @return 流程参与用户实际解决时间
	 */
	public Integer getPpfacttime();

	/**
	 * 流程回退指定时间取得
	 * @return 流程回退指定时间
	 */
	public String getPpbacktime();
	
	/**
	 * 流程super参与者标识取得
	 * @return 流程super参与者标识
	 */
	public String getPpsuper();
	
	/**
	 * 流程参与者角色负责人标识取得
	 * @return 流程参与者角色负责人标识
	 */
	public String getPprolemanager();
	
	/**
	 * 流程参与者值班人标识取得
	 * @return 流程参与者值班人标识
	 */
	public String getPpdutyperson();
	
	/**
	 * 流程参与代理人取得
	 * @return 流程参与代理人
	 */
	public String getPpproxyuserid();
	
	/**
	 * 流程参与代理人实体取得
	 * @return 流程参与代理人实体
	 */
	public UserTB getProxyUserTB();
	
	/**
	 * 按钮定义ID取得
	 * 
	 * @return 按钮定义ID
	 */
	public String getPbdid();

	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid();

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum();
}