/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.plugin.change.dto;

import java.io.Serializable;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.plugin.change.form.IGCHANGE0101Form;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 对比任务相关业务用DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCHANGE01DTO extends BaseDTO implements Serializable{
	
	protected IGCHANGE0101Form igchange0101Form;
	
	protected InitiateChangLogTB initTB;
	
	
	/** 用户 */
	protected User user;
	
	protected String icid;
	
	/**附件的标示id*/
	protected String attkey;
	
	/**查询结果标示1为成功0为失败*/
	protected String result;
	
	/**流程ID*/
	protected Integer prid;
	
	protected String ticketId;

	/**
	 * igchange0101Form取得
	 * @return igchange0101Form igchange0101Form
	 */
	public IGCHANGE0101Form getIgchange0101Form() {
		return igchange0101Form;
	}

	/**
	 * igchange0101Form设定
	 * @param igchange0101Form igchange0101Form
	 */
	public void setIgchange0101Form(IGCHANGE0101Form igchange0101Form) {
		this.igchange0101Form = igchange0101Form;
	}

	/**
	 * 用户取得
	 * @return user 用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户设定
	 * @param user 用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * icid取得
	 * @return icid icid
	 */
	public String getIcid() {
		return icid;
	}

	/**
	 * icid设定
	 * @param icid icid
	 */
	public void setIcid(String icid) {
		this.icid = icid;
	}

	/**
	 * initTB取得
	 * @return initTB initTB
	 */
	
	public InitiateChangLogTB getInitTB() {
		return initTB;
	}

	/**
	 * initTB设定
	 * @param initTB initTB
	 */
	public void setInitTB(InitiateChangLogTB initTB) {
		this.initTB = initTB;
	}

	/**
	 * 附件的标示id获取
	 * @return the attkey
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * 附件的标示id设定
	 * @param attkey
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * 查询结果标示1为成功0为失败获取
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 查询结果标示1为成功0为失败设定
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
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
	 * ticketId取得
	 * @return ticketId ticketId
	 */
	
	public String getTicketId() {
		return ticketId;
	}

	/**
	 * ticketId设定
	 * @param ticketId ticketId
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	
	
}


