/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ա��������ҵ����DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCHANGE01DTO extends BaseDTO implements Serializable{
	
	protected IGCHANGE0101Form igchange0101Form;
	
	protected InitiateChangLogTB initTB;
	
	
	/** �û� */
	protected User user;
	
	protected String icid;
	
	/**�����ı�ʾid*/
	protected String attkey;
	
	/**��ѯ�����ʾ1Ϊ�ɹ�0Ϊʧ��*/
	protected String result;
	
	/**����ID*/
	protected Integer prid;
	
	protected String ticketId;

	/**
	 * igchange0101Formȡ��
	 * @return igchange0101Form igchange0101Form
	 */
	public IGCHANGE0101Form getIgchange0101Form() {
		return igchange0101Form;
	}

	/**
	 * igchange0101Form�趨
	 * @param igchange0101Form igchange0101Form
	 */
	public void setIgchange0101Form(IGCHANGE0101Form igchange0101Form) {
		this.igchange0101Form = igchange0101Form;
	}

	/**
	 * �û�ȡ��
	 * @return user �û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û��趨
	 * @param user �û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * icidȡ��
	 * @return icid icid
	 */
	public String getIcid() {
		return icid;
	}

	/**
	 * icid�趨
	 * @param icid icid
	 */
	public void setIcid(String icid) {
		this.icid = icid;
	}

	/**
	 * initTBȡ��
	 * @return initTB initTB
	 */
	
	public InitiateChangLogTB getInitTB() {
		return initTB;
	}

	/**
	 * initTB�趨
	 * @param initTB initTB
	 */
	public void setInitTB(InitiateChangLogTB initTB) {
		this.initTB = initTB;
	}

	/**
	 * �����ı�ʾid��ȡ
	 * @return the attkey
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * �����ı�ʾid�趨
	 * @param attkey
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * ��ѯ�����ʾ1Ϊ�ɹ�0Ϊʧ�ܻ�ȡ
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * ��ѯ�����ʾ1Ϊ�ɹ�0Ϊʧ���趨
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ticketIdȡ��
	 * @return ticketId ticketId
	 */
	
	public String getTicketId() {
		return ticketId;
	}

	/**
	 * ticketId�趨
	 * @param ticketId ticketId
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	
	
}


