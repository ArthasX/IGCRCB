/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.svc.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.svc.form.IGSVC0100Form;


@SuppressWarnings("serial")
public class IGSVC01DTO extends BaseDTO implements Serializable {
    
	/**�û�id*/
	private String userid;
	
	protected String userid_q;
	
	/**�û�����*/
	private String username;
	
	/**����map*/
	private Map<String, List<IG500Info>> processRecordMap;
	
	/**�¼���ѯ�ӿ�*/
	protected IG500SearchCond prSearchCond;
	
	/**�������������ͼmap*/
	private Map<String, List<IG677Info>> processRecordInfoMap;
	
	/**����ģ������*/
	private String[] templateNames;
	
	/**����ģ��鿴ҳURL*/
	private Map<String,String> detailPgMap;
	
	/**����ģ��鿴ҳURL*/
	private String[] detailPgs;
	
	/**���̶���List*/
	protected List<IG500Info> processList;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	protected IGSVC0100Form igsvc0100form;

	protected IG677SearchCondImpl processInfoSearchCond;
	
	/** �������ͼ��� */
	protected List<LabelValueBean> prtypeList;
	
	/** ������Ϣ���� */
	protected List<ProcessInHandVWInfo> workList;
	
	public IGSVC0100Form getIgsvc0100form() {
		return igsvc0100form;
	}

	public void setIgsvc0100form(IGSVC0100Form igsvc0100form) {
		this.igsvc0100form = igsvc0100form;
	}

	/**
	 * ��ȡ�û�id
	 * @return �û�id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �����û�id
	 * @param userid �û�id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ�û�����
	 * @return �û�����
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �����û�����
	 * @param username �û�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ��ȡ����map
	 * @return ����map
	 */
	public Map<String, List<IG500Info>> getProcessRecordMap() {
		return processRecordMap;
	}

	/**
	 * ��������map
	 * @param processRecordMap ����map
	 */
	public void setProcessRecordMap(
			Map<String, List<IG500Info>> processRecordMap) {
		this.processRecordMap = processRecordMap;
	}

	/**
	 * ��ȡ����ģ������
	 * @return ����ģ������
	 */
	public String[] getTemplateNames() {
		return templateNames;
	}

	/**
	 * ��������ģ������
	 * @param templateNames ����ģ������
	 */
	public void setTemplateNames(String[] templateNames) {
		this.templateNames = templateNames;
	}

	/**
	 * ��ȡ����ģ��鿴ҳURL
	 * @return ����ģ��鿴ҳURL
	 */
	public Map<String,String> getDetailPgMap() {
		return detailPgMap;
	}

	/**
	 * ��������ģ��鿴ҳURL
	 * @param detailPgMap ����ģ��鿴ҳURL
	 */
	public void setDetailPgMap(Map<String,String> detailPgMap) {
		this.detailPgMap = detailPgMap;
	}
	
	/**
	 * ��ȡ����ģ��鿴ҳURL
	 * @return ����ģ��鿴ҳURL
	 */
	public String[] getDetailPgs() {
		return detailPgs;
	}

	/**
	 * ��������ģ��鿴ҳURL
	 * @param detailPgs ����ģ��鿴ҳURL
	 */
	public void setDetailPgs(String[] detailPgs) {
		this.detailPgs = detailPgs;
	}

	/**
	 * ��ȡ�������������ͼmap
	 * @return �������������ͼmap
	 */
	public Map<String, List<IG677Info>> getProcessRecordInfoMap() {
		return processRecordInfoMap;
	}

	/**
	 * �����������������ͼmap
	 * @param processRecordInfoMap �������������ͼmap
	 */
	public void setProcessRecordInfoMap(
			Map<String, List<IG677Info>> processRecordInfoMap) {
		this.processRecordInfoMap = processRecordInfoMap;
	}
	

	/**
	 * ��ȡ�¼���ѯ�ӿ�
	 * @return �¼���ѯ�ӿ�
	 */
	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}

	/**
	 * �����¼���ѯ�ӿ�
	 * @param prSearchCond �¼���ѯ�ӿ�
	 */
	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}

	/**
	 * ��ȡ���̶���List
	 * @return ���̶���List
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}


	/**
	 * �������̶���List
	 * @param processList ���̶���List
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}
	
	/**
	 * ��ȡ�����ѯ������¼��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ȡ��ҳBean
	 * @return ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public IG677SearchCondImpl getProcessInfoSearchCond() {
		return processInfoSearchCond;
	}

	public void setProcessInfoSearchCond(
			IG677SearchCondImpl processInfoSearchCond) {
		this.processInfoSearchCond = processInfoSearchCond;
	}

	/**
	 * ��ȡuserid_q
	 * @return fuserid_q userid_q
	 */
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * ����userid_q
	 * @param userid_q  userid_q
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	/**
	 * prtypeListȡ��
	 * @return prtypeList prtypeList
	 */
	public List<LabelValueBean> getPrtypeList() {
		return prtypeList;
	}

	/**
	 * prtypeList�趨
	 * @param prtypeList prtypeList
	 */
	public void setPrtypeList(List<LabelValueBean> prtypeList) {
		this.prtypeList = prtypeList;
	}

	/**
	 * ������Ϣ����ȡ��
	 * @return workList ������Ϣ����
	 */
	public List<ProcessInHandVWInfo> getWorkList() {
		return workList;
	}

	/**
	 * ������Ϣ�����趨
	 * @param workList ������Ϣ����
	 */
	public void setWorkList(List<ProcessInHandVWInfo> workList) {
		this.workList = workList;
	}
	
	
}