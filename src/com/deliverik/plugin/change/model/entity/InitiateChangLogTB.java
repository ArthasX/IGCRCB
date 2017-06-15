/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.change.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;

/**
  * ����: ������������־ʵ��
  * ��������: ������������־ʵ��
  * ������¼: 2015/07/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="initiateChang_Log")
public class InitiateChangLogTB extends BaseEntity implements Serializable,
		Cloneable, InitiateChangLogInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="INITIATECHANGLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INITIATECHANGLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INITIATECHANGLOG_TABLE_GENERATOR")
	protected Integer icid;

	/** ����ʱ�� */
	protected String sendTime;

	/** ����ʱ�� */
	protected String publishTime;

	/** ����id */
	protected Integer prid;

	/** ����״̬ */
	protected String publishStatus;

	/** ��ע */
	protected String remark;

	/** ������id */
	protected String pruserId;

	/** �����˽�ɫid */
	protected String prroleId;

	/** ������� */
	protected String changeName;

	/** ������� */
	protected String changeDescription;

	/** �ƻ�ִ�п�ʼʱ�� */
	protected String beginTime;

	/** �ƻ�ִ�н���ʱ�� */
	protected String endTime;

	/** ������� */
	protected String changeType;

	/** ������ */
	protected String changeCategory;

	/** ��ѡ������� */
	protected String selectedChangeType;

	/** ������� */
	protected String changeClassify;

	/** ����ƽ̨ */
	protected String updatePlatform;

	/** ���ԭ����� */
	protected String changeReasonClassify;

	/** ���ԭ�� */
	protected String changeReason;

	/** ������� */
	protected String changeContent;

	/** �����Ŀ��� */
	protected String prjid;

	/** �����Ŀ���� */
	protected String prjtitle;

	/** �Ƿ�Ӱ��ҵ�� */
	protected String isBusiness;

	/** ��ҵ��Ӱ�췶Χ */
	protected String businessScope;

	/** �ƻ�Ӱ��ҵ��ʱ��(����) */
	protected String businessTime;

	/** ִ�мƻ� */
	protected String deliveryProgram;

	/** ���˼ƻ� */
	protected String rollbackProgram;

	/** ��֤�ƻ� */
	protected String verificationProgram;

	/** ��س��򿪷����� */
	protected String relatedPrid;
	
	/** ����key*/
	protected String attkey;
	
	/**PMS ϵͳ����ID*/
	protected String ticketid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getIcid() {
		return icid;
	}

	/**
	 * �����趨
	 *
	 * @param icid ����
	 */
	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param sendTime ����ʱ��
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getPublishTime() {
		return publishTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param publishTime ����ʱ��
	 */
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPublishStatus() {
		return publishStatus;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param publishStatus ����״̬
	 */
	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ��ע�趨
	 *
	 * @param remark ��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPruserId() {
		return pruserId;
	}

	/**
	 * ������id�趨
	 *
	 * @param pruserId ������id
	 */
	public void setPruserId(String pruserId) {
		this.pruserId = pruserId;
	}

	/**
	 * �����˽�ɫidȡ��
	 *
	 * @return �����˽�ɫid
	 */
	public String getPrroleId() {
		return prroleId;
	}

	/**
	 * �����˽�ɫid�趨
	 *
	 * @param prroleId �����˽�ɫid
	 */
	public void setPrroleId(String prroleId) {
		this.prroleId = prroleId;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeName() {
		return changeName;
	}

	/**
	 * ��������趨
	 *
	 * @param changeName �������
	 */
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeDescription() {
		return changeDescription;
	}

	/**
	 * ��������趨
	 *
	 * @param changeDescription �������
	 */
	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	/**
	 * �ƻ�ִ�п�ʼʱ��ȡ��
	 *
	 * @return �ƻ�ִ�п�ʼʱ��
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * �ƻ�ִ�п�ʼʱ���趨
	 *
	 * @param beginTime �ƻ�ִ�п�ʼʱ��
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * �ƻ�ִ�н���ʱ��ȡ��
	 *
	 * @return �ƻ�ִ�н���ʱ��
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * �ƻ�ִ�н���ʱ���趨
	 *
	 * @param endTime �ƻ�ִ�н���ʱ��
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * ��������趨
	 *
	 * @param changeType �������
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getChangeCategory() {
		return changeCategory;
	}

	/**
	 * �������趨
	 *
	 * @param changeCategory ������
	 */
	public void setChangeCategory(String changeCategory) {
		this.changeCategory = changeCategory;
	}

	/**
	 * ��ѡ�������ȡ��
	 *
	 * @return ��ѡ�������
	 */
	public String getSelectedChangeType() {
		return selectedChangeType;
	}

	/**
	 * ��ѡ��������趨
	 *
	 * @param selectedChangeType ��ѡ�������
	 */
	public void setSelectedChangeType(String selectedChangeType) {
		this.selectedChangeType = selectedChangeType;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeClassify() {
		return changeClassify;
	}

	/**
	 * ��������趨
	 *
	 * @param changeClassify �������
	 */
	public void setChangeClassify(String changeClassify) {
		this.changeClassify = changeClassify;
	}

	/**
	 * ����ƽ̨ȡ��
	 *
	 * @return ����ƽ̨
	 */
	public String getUpdatePlatform() {
		return updatePlatform;
	}

	/**
	 * ����ƽ̨�趨
	 *
	 * @param updatePlatform ����ƽ̨
	 */
	public void setUpdatePlatform(String updatePlatform) {
		this.updatePlatform = updatePlatform;
	}

	/**
	 * ���ԭ�����ȡ��
	 *
	 * @return ���ԭ�����
	 */
	public String getChangeReasonClassify() {
		return changeReasonClassify;
	}

	/**
	 * ���ԭ������趨
	 *
	 * @param changeReasonClassify ���ԭ�����
	 */
	public void setChangeReasonClassify(String changeReasonClassify) {
		this.changeReasonClassify = changeReasonClassify;
	}

	/**
	 * ���ԭ��ȡ��
	 *
	 * @return ���ԭ��
	 */
	public String getChangeReason() {
		return changeReason;
	}

	/**
	 * ���ԭ���趨
	 *
	 * @param changeReason ���ԭ��
	 */
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeContent() {
		return changeContent;
	}

	/**
	 * ��������趨
	 *
	 * @param changeContent �������
	 */
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}

	/**
	 * �����Ŀ���ȡ��
	 *
	 * @return �����Ŀ���
	 */
	public String getPrjid() {
		return prjid;
	}

	/**
	 * �����Ŀ����趨
	 *
	 * @param prjid �����Ŀ���
	 */
	public void setPrjid(String prjid) {
		this.prjid = prjid;
	}

	/**
	 * �����Ŀ����ȡ��
	 *
	 * @return �����Ŀ����
	 */
	public String getPrjtitle() {
		return prjtitle;
	}

	/**
	 * �����Ŀ�����趨
	 *
	 * @param prjtitle �����Ŀ����
	 */
	public void setPrjtitle(String prjtitle) {
		this.prjtitle = prjtitle;
	}

	/**
	 * �Ƿ�Ӱ��ҵ��ȡ��
	 *
	 * @return �Ƿ�Ӱ��ҵ��
	 */
	public String getIsBusiness() {
		return isBusiness;
	}

	/**
	 * �Ƿ�Ӱ��ҵ���趨
	 *
	 * @param isBusiness �Ƿ�Ӱ��ҵ��
	 */
	public void setIsBusiness(String isBusiness) {
		this.isBusiness = isBusiness;
	}

	/**
	 * ��ҵ��Ӱ�췶Χȡ��
	 *
	 * @return ��ҵ��Ӱ�췶Χ
	 */
	public String getBusinessScope() {
		return businessScope;
	}

	/**
	 * ��ҵ��Ӱ�췶Χ�趨
	 *
	 * @param businessScope ��ҵ��Ӱ�췶Χ
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	/**
	 * �ƻ�Ӱ��ҵ��ʱ��(����)ȡ��
	 *
	 * @return �ƻ�Ӱ��ҵ��ʱ��(����)
	 */
	public String getBusinessTime() {
		return businessTime;
	}

	/**
	 * �ƻ�Ӱ��ҵ��ʱ��(����)�趨
	 *
	 * @param businessTime �ƻ�Ӱ��ҵ��ʱ��(����)
	 */
	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	/**
	 * ִ�мƻ�ȡ��
	 *
	 * @return ִ�мƻ�
	 */
	public String getDeliveryProgram() {
		return deliveryProgram;
	}

	/**
	 * ִ�мƻ��趨
	 *
	 * @param deliveryProgram ִ�мƻ�
	 */
	public void setDeliveryProgram(String deliveryProgram) {
		this.deliveryProgram = deliveryProgram;
	}

	/**
	 * ���˼ƻ�ȡ��
	 *
	 * @return ���˼ƻ�
	 */
	public String getRollbackProgram() {
		return rollbackProgram;
	}

	/**
	 * ���˼ƻ��趨
	 *
	 * @param rollbackProgram ���˼ƻ�
	 */
	public void setRollbackProgram(String rollbackProgram) {
		this.rollbackProgram = rollbackProgram;
	}

	/**
	 * ��֤�ƻ�ȡ��
	 *
	 * @return ��֤�ƻ�
	 */
	public String getVerificationProgram() {
		return verificationProgram;
	}

	/**
	 * ��֤�ƻ��趨
	 *
	 * @param verificationProgram ��֤�ƻ�
	 */
	public void setVerificationProgram(String verificationProgram) {
		this.verificationProgram = verificationProgram;
	}

	/**
	 * ��س��򿪷�����ȡ��
	 *
	 * @return ��س��򿪷�����
	 */
	public String getRelatedPrid() {
		return relatedPrid;
	}

	/**
	 * ��س��򿪷������趨
	 *
	 * @param relatedPrid ��س��򿪷�����
	 */
	public void setRelatedPrid(String relatedPrid) {
		this.relatedPrid = relatedPrid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return icid;
	}

	/**
	 * ����key��ȡ
	 * @return the attkey
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * ����key�趨
	 * @param attkey
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * PMSϵͳ����IDȡ��
	 * @return ticketid PMSϵͳ����ID
	 */
	
	public String getTicketid() {
		return ticketid;
	}

	/**
	 * PMSϵͳ����ID�趨
	 * @param ticketid PMSϵͳ����ID
	 */
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}
}