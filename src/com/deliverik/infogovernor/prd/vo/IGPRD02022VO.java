/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义简略信息显示VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD02022VO extends BaseVO{

	/** 序号 */
	protected Integer serial;
	
	/** 状态信息 */
	protected IG333Info processStatusDefinition;
	
	/** 参与人信息 */
	protected Map<Role, List<User>> participantMap;
	
	/** 前置任务序号 */
	protected String prepositionTaskSerial;
	
	/** 附件信息 */
	protected List<Attachment> attList;
	
	/** 策略时间 */
	protected String handlingTime;

	/**
	 * 序号取得
	 * @return serial 序号
	 */
	public Integer getSerial() {
		return serial;
	}

	/**
	 * 序号设定
	 * @param serial 序号
	 */
	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	/**
	 * 状态信息取得
	 * @return processStatusDefinition 状态信息
	 */
	public IG333Info getProcessStatusDefinition() {
		return processStatusDefinition;
	}

	/**
	 * 状态信息设定
	 * @param processStatusDefinition 状态信息
	 */
	public void setProcessStatusDefinition(IG333Info processStatusDefinition) {
		this.processStatusDefinition = processStatusDefinition;
	}

	/**
	 * 参与人信息取得
	 * @return participantMap 参与人信息
	 */
	public Map<Role, List<User>> getParticipantMap() {
		return participantMap;
	}

	/**
	 * 参与人信息设定
	 * @param participantMap 参与人信息
	 */
	public void setParticipantMap(Map<Role, List<User>> participantMap) {
		this.participantMap = participantMap;
	}

	/**
	 * 前置任务序号取得
	 * @return prepositionTaskSerial 前置任务序号
	 */
	public String getPrepositionTaskSerial() {
		return prepositionTaskSerial;
	}

	/**
	 * 前置任务序号设定
	 * @param prepositionTaskSerial 前置任务序号
	 */
	public void setPrepositionTaskSerial(String prepositionTaskSerial) {
		this.prepositionTaskSerial = prepositionTaskSerial;
	}

	/**
	 * 附件信息取得
	 * @return attList 附件信息
	 */
	public List<Attachment> getAttList() {
		return attList;
	}

	/**
	 * 附件信息设定
	 * @param attList 附件信息
	 */
	public void setAttList(List<Attachment> attList) {
		this.attList = attList;
	}

	/**
	 * 策略时间取得
	 * @return handlingTime 策略时间
	 */
	public String getHandlingTime() {
		return handlingTime;
	}

	/**
	 * 策略时间设定
	 * @param handlingTime 策略时间
	 */
	public void setHandlingTime(String handlingTime) {
		this.handlingTime = handlingTime;
	}
}
