package com.deliverik.infogovernor.drm.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 应急工作台FORM
 * 
 */
@SuppressWarnings("serial")
public class IGDRM1010Form extends BaseForm{
	
	/** 流程ID */
	protected Integer prid;
	
	/** 处理用户ID */
	protected String userid;
	
	/** 节点信息 */
	protected String status;
	
	/** 状态表单主机 */
	protected Integer pvlid;

	/** 状态id */
	protected String psdid;

	/** 装填表单值（处置说明） */
	protected String psdValue;

	/** 处理角色ID */
	protected Integer roleid;
	
	/** 处理动作 */
	protected String btnid;
	
	/** 处理结果 */
	protected String result;
	
	/** 处理记录 */
	protected String rlcomment;

	/** 消息内容 */
	protected String msg;

	/** 短信接收人id */
	protected String userids;
	/** 公告(通知)发送人id */
	protected String sendUserid;
	/** 公告(通知)发送人id */
	protected String sendUserName;

	protected FormFile file;

	/** 场景eiid */
	protected String senceEiid;
	/** 场景版本 */
	protected String senceEiversion;

	public String getSenceEiid() {
		return senceEiid;
	}

	public void setSenceEiid(String senceEiid) {
		this.senceEiid = senceEiid;
	}

	public String getSenceEiversion() {
		return senceEiversion;
	}

	public void setSenceEiversion(String senceEiversion) {
		this.senceEiversion = senceEiversion;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getSendUserid() {
		return sendUserid;
	}

	public void setSendUserid(String sendUserid) {
		this.sendUserid = sendUserid;
	}

	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserids() {
		return userids;
	}

	public void setUserids(String userids) {
		this.userids = userids;
	}

	/**
	 * 流程ID取得
	 * @return prid 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 处理用户ID取得
	 * @return userid 处理用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 处理用户ID设定
	 * @param userid 处理用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 节点信息取得
	 * @return status 节点信息
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 节点信息设定
	 * @param status 节点信息
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 处理角色ID取得
	 * @return roleid 处理角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 处理角色ID设定
	 * @param roleid 处理角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 处理动作取得
	 * @return btnid 处理动作
	 */
	public String getBtnid() {
		return btnid;
	}

	/**
	 * 处理动作设定
	 * @param btnid 处理动作
	 */
	public void setBtnid(String btnid) {
		this.btnid = btnid;
	}

	/**
	 * 处理结果取得
	 * @return result 处理结果
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 处理结果设定
	 * @param result 处理结果
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 处理记录取得
	 * @return rlcomment 处理记录
	 */
	public String getRlcomment() {
		return rlcomment;
	}

	/**
	 * 处理记录设定
	 * @param rlcomment 处理记录
	 */
	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

	public String getPsdValue() {
		return psdValue;
	}

	public void setPsdValue(String psdValue) {
		this.psdValue = psdValue;
	}

	public Integer getPvlid() {
		return pvlid;
	}

	public void setPvlid(Integer pvlid) {
		this.pvlid = pvlid;
	}
}
