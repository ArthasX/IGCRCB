package com.deliverik.framework.workflow.prr.model;

import java.util.Date;

/**
 * 流程记录与参与用户信息
 *
 */
public interface IG677Info{
	/**
	 * 流程记录类型取得
	 * @return 流程记录类型
	 */
	public String getPrtype();

	/**
	 * 流程记录子类型取得
	 * @return 流程记录子类型
	 */
	public String getPrsubtype();

	/**
	 * 流程记录状态取得
	 * @return 流程记录状态
	 */
	public String getPrstatus();

	/**
	 * 流程记录状态子状态取得
	 * @return 流程记录状态子状态
	 */
	public String getPrsubstatus();

	/**
	 * 流程记录题目取得
	 * @return 流程记录题目
	 */
	public String getPrtitle();

	/**
	 * 流程记录描述取得
	 * @return 流程记录描述
	 */
	public String getPrdesc();

	/**
	 * 流程记录建立时间取得
	 * @return 流程记录建立时间
	 */
	public String getPropentime();

	/**
	 * 流程记录关闭时间取得
	 * @return 流程记录关闭时间
	 */
	public String getPrclosetime();

	/**
	 * 流程记录计划执行时间取得
	 * @return 流程记录计划执行时间
	 */
	public String getPrplantime();

	/**
	 * 流程记录计划执行周期取得
	 * @return 流程记录计划执行周期
	 */
	public String getPrduration();

	/**
	 * 流程记录紧急程度取得
	 * @return 流程记录紧急程度
	 */
	public String getPrurgency();

	/**
	 * 流程记录影响程度取得
	 * @return 流程记录影响程度
	 */
	public String getPrimpact();

	/**
	 * 流程记录相关资产ID取得
	 * @return 流程记录相关资产ID
	 */
	public Integer getPrassetid();

	/**
	 * 流程记录相关资产名称取得
	 * @return 流程记录相关资产名称
	 */
	public String getPrassetname();

	/**
	 * 流程记录的相关业务取得
	 * @return 流程记录的相关业务
	 */
	public String getPrbusiness();

	/**
	 * 流程记录执行计划取得
	 * @return 流程记录执行计划
	 */
	public String getPrimplplan();

	/**
	 * 流程记录恢复计划取得
	 * @return 流程记录恢复计划
	 */
	public String getPrbackplan();

	/**
	 * 流程记录验证计划取得
	 * @return 流程记录验证计划
	 */
	public String getPrvfyplan();
	
	/**
	 * 流程记录相关项目ID取得
	 * @return 流程记录相关项目ID
	 */
	public Integer getPid();

	/**
	 * 流程记录相关项目编号取得
	 * @return 流程记录相关项目编号
	 */
	public String getPcode();

	/**
	 * 流程记录相关项目名称取得
	 * @return 流程记录相关项目名称
	 */
	public String getPname();
	
	/**
	 * 流程记录发起者联系方式取得
	 * @return 流程记录发起者联系方式
	 */
	public String getPrinfo();

	/**
	 * 流程记录相关流程ID取得
	 * @return 流程记录相关流程ID
	 */
	public Integer getPrcorid();

	/**
	 * 流程记录相关流程类型取得
	 * @return 流程记录相关流程类型
	 */
	public String getPrcortype();

	/**
	 * 流程记录相关流程名称取得
	 * @return 流程记录相关流程名称
	 */
	public String getPrcortitle();

	/**
	 * 流程记录相关资产类型取得
	 * @return 流程记录相关资产类型
	 */
	public String getPrassetcategory();

	/**
	 * 流程记录发起者用户姓名取得
	 * @return 流程记录发起者用户姓名
	 */
	public String getPrusername();

	/**
	 * 流程记录发起者角色名称取得
	 * @return 流程记录发起者角色名称
	 */
	public String getPrrolename();

	/**
	 * 流程记录发起者用户ID取得
	 * @return 流程记录发起者用户ID
	 */
	public String getPruserid();

	/**
	 * 流程记录发起者角色ID取得
	 * @return 流程记录发起者角色ID
	 */
	public Integer getPrroleid();

	/**
	 * 流程记录流程类型ID取得
	 * @return 流程记录流程类型ID
	 */
	public String getPrpdid();

	/**
	 * 流程记录流程类型名称取得
	 * @return 流程记录流程类型名称
	 */
	public String getPrpdname();

	/**
	 * 流程记录发起者所属机构层次码取得
	 * @return 流程记录发起者所属机构层次码
	 */
	public String getProrgid();

	/**
	 * 流程记录发起者所属机构名称取得
	 * @return 流程记录发起者所属机构名称
	 */
	public String getProrgname();

	/**
	 * 流程记录工单号取得
	 * @return 流程记录工单号
	 */
	public String getPrserialnum();

	/**
	 * 流程记录实际解决时间（从开始到结束）取得
	 * @return 流程记录实际解决时间
	 */
	public String getPrfacttime();
	
	
	
	/**
	 * 流程参与用户所属机构名称取得
	 * @return 流程参与用户所属机构名称
	 */
	public String getPporgname();

	

	/**
	 * 流程参与用户信息ID取得
	 * @return 流程参与用户信息ID
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
	 * 流程策略版本取得
	 * @return 流程策略版本
	 */
	public Integer getPrStrategyVersion();
	
	/**
	 * 流程状态处理完成时间取得
	 * @return 流程状态处理完成时间
	 */
	public Date getRslclosetime();

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();

	/**
	 * 流程动态分支编号取得
	 * @return 流程动态分支编号
	 */
	public Integer getPsdnum();
	
}