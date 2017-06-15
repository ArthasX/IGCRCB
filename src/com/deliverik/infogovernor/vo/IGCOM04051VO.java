/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;

/**
 * ҵ����Ա��ҳ��VO
 *
 */
@SuppressWarnings("serial")
public class IGCOM04051VO extends BaseVO implements Serializable{

	/** �ҵĹ����б� */
	private List<IG677Info> processRecordInfoForMeList;
	
	/** �ҷ���Ĺ����б� */
	private List<IG677Info> processRecordInitForMeList;
	
	/** ��ʷ�����б� */
	private List<IG500Info> processRecordInitForHistoryList;
	
	/**��ع����б�*/
	private Map<String,List<IG677Info>> retForRelateMap;
	
	/**��ع�������*/
	private List<IG677Info> retForRelateList;
	
	/** ���̲鿴ҳ���� */
	private Map<String,String> urlMap;
	
	/** �ҵĹ������� */
	private Map<String,List<IG677Info>> processRecordMap;
	
	/** �ҷ���Ĺ������� */
	private Map<String,List<IG677Info>> processRecordInitForMeMap;
	
	/** ��ʷ�������� */
	private Map<String,List<IG500Info>> processRecordInitForHistoryMap;
	
	/** �ҷ���ķ���̨������¼ */
	private List<IG933Info> serviceFormList;
	
	/** ��ѯ���������Ƿ���ñ�ʶ */
	private boolean service_process_6;
	
	/** Ͷ�齨�������Ƿ���ñ�ʶ */
	private boolean service_process_7;
	
	/** �ҵĹ������� */
	protected List<ProcessInHandVWInfo> myWorkList;
	
	/** ��ع������� */
	protected List<ProcessInHandVWInfo> relevanceWorkList;
	
	/**
	 * �ҵĹ����б�ȡ��
	 * 
	 * @return �ҵĹ����б�
	 */
	public List<IG677Info> getProcessRecordInfoForMeList() {
		return processRecordInfoForMeList;
	}

	/**
	 * �ҵĹ����б��趨
	 * 
	 * @param processRecordInfoForMeList �ҵĹ����б�
	 */
	public void setProcessRecordInfoForMeList(
			List<IG677Info> processRecordInfoForMeList) {
		this.processRecordInfoForMeList = processRecordInfoForMeList;
	}

	/**
	 * �ҷ���Ĺ����б�ȡ��
	 * 
	 * @return �ҷ���Ĺ����б�
	 */
	public List<IG677Info> getProcessRecordInitForMeList() {
		return processRecordInitForMeList;
	}

	/**
	 * �ҷ���Ĺ����б��趨
	 * 
	 * @param processRecordInitForMeList �ҷ���Ĺ����б�
	 */
	public void setProcessRecordInitForMeList(
			List<IG677Info> processRecordInitForMeList) {
		this.processRecordInitForMeList = processRecordInitForMeList;
	}

	/**
	 * ���̲鿴ҳ����ȡ��
	 * 
	 * @return ���̲鿴ҳ����
	 */
	public Map<String, String> getUrlMap() {
		return urlMap;
	}

	/**
	 * ���̲鿴ҳ�����趨
	 * 
	 * @param urlMap ���̲鿴ҳ����
	 */
	public void setUrlMap(Map<String, String> urlMap) {
		this.urlMap = urlMap;
	}

	/**
	 * �ҵĹ�������ȡ��
	 * 
	 * @return �ҵĹ�������ȡ��
	 */
	public Map<String, List<IG677Info>> getProcessRecordMap() {
		return processRecordMap;
	}

	/**
	 * �ҵĹ��������趨
	 * 
	 * @param processRecordMap �ҵĹ�������
	 */
	public void setProcessRecordMap(
			Map<String, List<IG677Info>> processRecordMap) {
		this.processRecordMap = processRecordMap;
	}
	
	/**
	 * �ҷ���Ĺ�������ȡ��
	 * 
	 * @return �ҷ���Ĺ�������
	 */
	public Map<String, List<IG677Info>> getProcessRecordInitForMeMap() {
		return processRecordInitForMeMap;
	}
	
	/**
	 * �ҷ���Ĺ��������趨
	 * 
	 * @param processRecordInitForMeMap �ҷ���Ĺ�������
	 */
	public void setProcessRecordInitForMeMap(
			Map<String, List<IG677Info>> processRecordInitForMeMap) {
		this.processRecordInitForMeMap = processRecordInitForMeMap;
	}

	/**
	 * ��ѯ���������Ƿ���ñ�ʶȡ��
	 * 
	 * @return ��ѯ���������Ƿ���ñ�ʶ
	 */
	public boolean isService_process_6() {
		return service_process_6;
	}

	/**
	 * ��ѯ���������Ƿ���ñ�ʶ�趨
	 * 
	 * @param service_process_6 ��ѯ���������Ƿ���ñ�ʶ
	 */
	public void setService_process_6(boolean service_process_6) {
		this.service_process_6 = service_process_6;
	}

	/**
	 * Ͷ�߽��������Ƿ���ñ�ʶȡ��
	 * 
	 * @return Ͷ�߽��������Ƿ���ñ�ʶ
	 */
	public boolean isService_process_7() {
		return service_process_7;
	}

	/**
	 * Ͷ�߽��������Ƿ���ñ�ʶ�趨
	 * 
	 * @param service_process_7 Ͷ�߽��������Ƿ���ñ�ʶ
	 */
	public void setService_process_7(boolean service_process_7) {
		this.service_process_7 = service_process_7;
	}

	/**
	 * �ҷ���ķ���̨������¼ȡ��
	 * 
	 * @return �ҷ���ķ���̨������¼
	 */
	public List<IG933Info> getServiceFormList() {
		return serviceFormList;
	}

	/**
	 * �ҷ���ķ���̨������¼�趨
	 * 
	 * @param serviceFormList �ҷ���ķ���̨������¼
	 */
	public void setServiceFormList(List<IG933Info> serviceFormList) {
		this.serviceFormList = serviceFormList;
	}
	
	/**
	 *��ȡ��ʷ�����б�
	 * @return the processRecordInitForHistoryList��ʷ�����б�
	 */
	public List<IG500Info> getProcessRecordInitForHistoryList() {
		return processRecordInitForHistoryList;
	}

	/**
	 *������ʷ�����б�
	 * @param processRecordInitForHistoryList ��ʷ�����б�
	 */
	public void setProcessRecordInitForHistoryList(
			List<IG500Info> processRecordInitForHistoryList) {
		this.processRecordInitForHistoryList = processRecordInitForHistoryList;
	}
	
	/**
	 *��ȡ��ʷ��������
	 * @return the processRecordInitForHistoryMap��ʷ��������
	 */
	public Map<String, List<IG500Info>> getProcessRecordInitForHistoryMap() {
		return processRecordInitForHistoryMap;
	}

	/**
	 *������ʷ��������
	 * @param processRecordInitForHistoryMap ��ʷ��������
	 */
	public void setProcessRecordInitForHistoryMap(
			Map<String, List<IG500Info>> processRecordInitForHistoryMap) {
		this.processRecordInitForHistoryMap = processRecordInitForHistoryMap;
	}


	/**
	 * ��ع�������ȡ��
	 * @return retForRelateList ��ع�������
	 */
	public List<IG677Info> getRetForRelateList() {
		return retForRelateList;
	}

	/**
	 * ��ع��������趨
	 * @param retForRelateList ��ع�������
	 */
	public void setRetForRelateList(List<IG677Info> retForRelateList) {
		this.retForRelateList = retForRelateList;
	}

	/**
	 * ��ع����б�ȡ��
	 * @return retForRelateMap ��ع����б�
	 */
	public Map<String, List<IG677Info>> getRetForRelateMap() {
		return retForRelateMap;
	}

	/**
	 * ��ع����б��趨
	 * @param retForRelateMap ��ع����б�
	 */
	public void setRetForRelateMap(Map<String, List<IG677Info>> retForRelateMap) {
		this.retForRelateMap = retForRelateMap;
	}

	/**
	 * �ҵĹ�������ȡ��
	 * @return myWorkList �ҵĹ�������
	 */
	public List<ProcessInHandVWInfo> getMyWorkList() {
		return myWorkList;
	}

	/**
	 * �ҵĹ��������趨
	 * @param myWorkList �ҵĹ�������
	 */
	public void setMyWorkList(List<ProcessInHandVWInfo> myWorkList) {
		this.myWorkList = myWorkList;
	}

	/**
	 * ��ع�������ȡ��
	 * @return relevanceWorkList ��ع�������
	 */
	public List<ProcessInHandVWInfo> getRelevanceWorkList() {
		return relevanceWorkList;
	}

	/**
	 * ��ع��������趨
	 * @param relevanceWorkList ��ع�������
	 */
	public void setRelevanceWorkList(List<ProcessInHandVWInfo> relevanceWorkList) {
		this.relevanceWorkList = relevanceWorkList;
	}
	
}
