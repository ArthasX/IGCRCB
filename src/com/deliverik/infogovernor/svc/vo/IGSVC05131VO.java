/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_ͳ�Ʒ���_�����б�VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC05131VO extends BaseVO {

	/**
	 * ���̻�����Ϣ�б�
	 */
	private List<IG359Info> processCountList;
	
	/**
	 * ���̼�¼��Ϣ�б�
	 */
	private List<IG500Info> processRecordList;
	
	/**
	 * ���û���ѯ�õ������̻�����Ϣ�б�
	 */
	private List<IG160Info> userProcessCountList;
	
	/**�����Ա��Ϣ*/
	private Map<String,String> perMap;
	
	/**
	 * ���̼�¼��Ϣ
	 */
	private IG500Info process;
	
	/**
	 * ����ͳ����Ϣ�б�
	 */
	private List<IG003Info> processSummaryList;
	
	private List<IG599Info> processInfo;
	
	private List<IG677Info> processRecordInfo;
	
	private String initStatusTime;
	
	private String expectStatusTime;
	
	private String expectProcessTime;
	
	/**
	 * ���������б�
	 */
	private List<IG933Info> processGdRecordInfoList;

	public String getExpectProcessTime() {
		return expectProcessTime;
	}

	public void setExpectProcessTime(String expectProcessTime) {
		this.expectProcessTime = expectProcessTime;
	}

	public String getInitStatusTime() {
		return initStatusTime;
	}

	public void setInitStatusTime(String initStatusTime) {
		this.initStatusTime = initStatusTime;
	}

	public String getExpectStatusTime() {
		return expectStatusTime;
	}

	public void setExpectStatusTime(String expectStatusTime) {
		this.expectStatusTime = expectStatusTime;
	}

	/**���̹�ϵ��Ϣ�����б�*/
	protected List<IG512Info> processRecordRelationList;

	public List<IG677Info> getProcessRecordInfo() {
		return processRecordInfo;
	}

	public void setProcessRecordInfo(List<IG677Info> processRecordInfo) {
		this.processRecordInfo = processRecordInfo;
	}

	public List<IG599Info> getProcessInfo() {
		return processInfo;
	}

	public void setProcessInfo(List<IG599Info> processInfo) {
		this.processInfo = processInfo;
	}

	/**
	 * ��ȡ����ͳ����Ϣ�б�
	 * @return List<ProcessSummary>
	 */
	public List<IG003Info> getProcessSummaryList() {
		return processSummaryList;
	}

	/**
	 * ��������ͳ����Ϣ�б�
	 * @param processSummaryList List<ProcessSummary>
	 */
	
	public void setProcessSummaryList(List<IG003Info> processSummaryList) {
		this.processSummaryList = processSummaryList;
	}

	/**
	 * ��ȡ���û���ѯ�õ������̻�����Ϣ�б�
	 * @return  List<UserProcessCount>
	 */
	public List<IG160Info> getUserProcessCountList() {
		return userProcessCountList;
	}

	/**
	 * ���ð��û���ѯ�õ������̻�����Ϣ�б�
	 * @param userProcessCountList List<UserProcessCount>
	 */
	public void setUserProcessCountList(List<IG160Info> userProcessCountList) {
		this.userProcessCountList = userProcessCountList;
	}

	public List<IG500Info> getProcessRecordList() {
		return processRecordList;
	}

	public void setProcessRecordList(List<IG500Info> processRecordList) {
		this.processRecordList = processRecordList;
	}

	public IG500Info getProcess() {
		return process;
	}

	public void setProcess(IG500Info process) {
		this.process = process;
	}

	/**
	 * ��ȡ���̻�����Ϣ�б�
	 * @return List<ProcessCount>
	 */
	public List<IG359Info> getProcessCountList() {
		return processCountList;
	}

	/**
	 * �������̻�����Ϣ�б�
	 * @param processCountList List<ProcessCount>
	 */
	public void setProcessCountList(List<IG359Info> processCountList) {
		this.processCountList = processCountList;
	}
	
	/**
	 * ��ȡ�����Ա��Ϣ
	 * @return �����Ա��Ϣ
	 */
	public Map<String, String> getPerMap() {
		return perMap;
	}

	/**
	 * ���������Ա��Ϣ
	 * @param perMap �����Ա��Ϣ
	 */
	public void setPerMap(Map<String, String> perMap) {
		this.perMap = perMap;
	}
	
	/**
	 * �������̹�ϵ��Ϣ�����б�
	 * @param processRecordRelationList ���̹�ϵ��Ϣ�����б�
	 */
	public void setProcessRecordRelationList(
			List<IG512Info> processRecordRelationList) {
		this.processRecordRelationList = processRecordRelationList;
	}

	public List<IG933Info> getProcessGdRecordInfoList() {
		return processGdRecordInfoList;
	}

	public void setProcessGdRecordInfoList(List<IG933Info> processGdRecordInfoList) {
		this.processGdRecordInfoList = processGdRecordInfoList;
	}
	
}
