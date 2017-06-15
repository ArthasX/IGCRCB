/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 故障类型统计实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class IncidentTypeVW implements IncidentTypeVWInfo{

	/** 主键 */
	@Id
	protected Integer id;
	
	/** OA办公 */
	protected Integer oaWork;
	
	/** 用户名或密码 */
	protected Integer userNameOrPassWord;
	
	/** 物资管理 */
	protected Integer materialsManager;
	
	/** 分诊导医 */
	protected Integer triageDaoYi;
	
	/** 网络故障 */
	protected Integer netWorkMalfunction;
	
	/** 病例丢失找回 */
	protected Integer casesOfLossBack;
	
	/** 计算机协助 */
	protected Integer computerHelp;
	
	/** 护士工作站 */
	protected Integer nurseWorkstation;
	
	/** 监控告警 */
	protected Integer prossessingErrorAlarm;

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * OA办公取得
	 * @return oaWork OA办公
	 */
	public Integer getOaWork() {
		return oaWork;
	}

	/**
	 * OA办公设定
	 * @param oaWork OA办公
	 */
	public void setOaWork(Integer oaWork) {
		this.oaWork = oaWork;
	}

	/**
	 * 用户名或密码取得
	 * @return userNameOrPassWord 用户名或密码
	 */
	public Integer getUserNameOrPassWord() {
		return userNameOrPassWord;
	}

	/**
	 * 用户名或密码设定
	 * @param userNameOrPassWord 用户名或密码
	 */
	public void setUserNameOrPassWord(Integer userNameOrPassWord) {
		this.userNameOrPassWord = userNameOrPassWord;
	}

	/**
	 * 物资管理取得
	 * @return materialsManager 物资管理
	 */
	public Integer getMaterialsManager() {
		return materialsManager;
	}

	/**
	 * 物资管理设定
	 * @param materialsManager 物资管理
	 */
	public void setMaterialsManager(Integer materialsManager) {
		this.materialsManager = materialsManager;
	}

	/**
	 * 分诊导医取得
	 * @return triageDaoYi 分诊导医
	 */
	public Integer getTriageDaoYi() {
		return triageDaoYi;
	}

	/**
	 * 分诊导医设定
	 * @param triageDaoYi 分诊导医
	 */
	public void setTriageDaoYi(Integer triageDaoYi) {
		this.triageDaoYi = triageDaoYi;
	}

	/**
	 * 网络故障取得
	 * @return netWorkMalfunction 网络故障
	 */
	public Integer getNetWorkMalfunction() {
		return netWorkMalfunction;
	}

	/**
	 * 网络故障设定
	 * @param netWorkMalfunction 网络故障
	 */
	public void setNetWorkMalfunction(Integer netWorkMalfunction) {
		this.netWorkMalfunction = netWorkMalfunction;
	}

	/**
	 * 病例丢失找回取得
	 * @return casesOfLossBack 病例丢失找回
	 */
	public Integer getCasesOfLossBack() {
		return casesOfLossBack;
	}

	/**
	 * 病例丢失找回设定
	 * @param casesOfLossBack 病例丢失找回
	 */
	public void setCasesOfLossBack(Integer casesOfLossBack) {
		this.casesOfLossBack = casesOfLossBack;
	}

	/**
	 * 计算机协助取得
	 * @return computerHelp 计算机协助
	 */
	public Integer getComputerHelp() {
		return computerHelp;
	}

	/**
	 * 计算机协助设定
	 * @param computerHelp 计算机协助
	 */
	public void setComputerHelp(Integer computerHelp) {
		this.computerHelp = computerHelp;
	}

	/**
	 * 护士工作站取得
	 * @return nurseWorkstation 护士工作站
	 */
	public Integer getNurseWorkstation() {
		return nurseWorkstation;
	}

	/**
	 * 护士工作站设定
	 * @param nurseWorkstation 护士工作站
	 */
	public void setNurseWorkstation(Integer nurseWorkstation) {
		this.nurseWorkstation = nurseWorkstation;
	}

	/**
	 * 监控告警取得
	 * @return prossessingErrorAlarm 监控告警
	 */
	public Integer getProssessingErrorAlarm() {
		return prossessingErrorAlarm;
	}

	/**
	 * 监控告警设定
	 * @param prossessingErrorAlarm 监控告警
	 */
	public void setProssessingErrorAlarm(Integer prossessingErrorAlarm) {
		this.prossessingErrorAlarm = prossessingErrorAlarm;
	}
}
