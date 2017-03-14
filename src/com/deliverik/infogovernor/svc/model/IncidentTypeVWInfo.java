/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 故障类型统计实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentTypeVWInfo {

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();

	/**
	 * OA办公取得
	 * @return oaWork OA办公
	 */
	public Integer getOaWork();

	/**
	 * 用户名或密码取得
	 * @return userNameOrPassWord 用户名或密码
	 */
	public Integer getUserNameOrPassWord();

	/**
	 * 物资管理取得
	 * @return materialsManager 物资管理
	 */
	public Integer getMaterialsManager();

	/**
	 * 分诊导医取得
	 * @return triageDaoYi 分诊导医
	 */
	public Integer getTriageDaoYi();

	/**
	 * 网络故障取得
	 * @return netWorkMalfunction 网络故障
	 */
	public Integer getNetWorkMalfunction();

	/**
	 * 病例丢失找回取得
	 * @return casesOfLossBack 病例丢失找回
	 */
	public Integer getCasesOfLossBack();

	/**
	 * 计算机协助取得
	 * @return computerHelp 计算机协助
	 */
	public Integer getComputerHelp();

	/**
	 * 护士工作站取得
	 * @return nurseWorkstation 护士工作站
	 */
	public Integer getNurseWorkstation();
	
	/**
	 * 监控告警取得
	 * @return prossessingErrorAlarm 监控告警
	 */
	public Integer getProssessingErrorAlarm();
}
