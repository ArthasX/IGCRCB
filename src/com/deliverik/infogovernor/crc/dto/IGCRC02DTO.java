/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.form.IGCRC0203Form;
import com.deliverik.infogovernor.crc.form.IGCRC0204Form;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/***
 * ���ɸ澯���ҵ����DTO
 * @time 2014/06/20
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */

@SuppressWarnings("serial")
public class IGCRC02DTO extends BaseDTO implements Serializable{

	/** ���ɸ澯��ӿ� */
	private IgalarmInfo igalarmInfo;
	
	protected IGWKM0101Form igwkm0101form;
	
	/** ��ѯ���� */
	private List<IgalarmInfo> IgalarmInfos;
	
	/** ����ѯҳ�� */
	private int maxSearchCount;
	
	/** ҳ���� ���ݴ������ */
	private PagingDTO pagingDTO;
	
	/** �澯��Ϣ��ѯForm */
	private IGCRC0203Form form;
	
	/** �澯����Form */
	private IGCRC0204Form igcrc0204Form;
	
	/** socket��Ϣ */
	private String msg;
	
	//�澯�¼��� begin
	protected String prtype;
	
	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	protected Map<String,String> nameURLMap;
	
	protected List<IG380Info> processDefinitionList;
	
	protected List<IG259Info> processTemplateList;
	
	/**�����ѯ�ӿ�*/
	protected IG500SearchCond prSearchCond;
	/** ��ѯ����*/
	protected String type;
	//�澯�¼��� end
	/** ������Ϣ���� */
	protected List<IGCRC0208VWInfo> processList;
	
	
	/** ������������״̬�� */
	private String appnamestatus;
	
	/** ip��ַ����״̬�� */
	private String ipaddrstatus;
	
	/** ����ʱ������״̬�� */
	private String lasttimestatus;
	
	
	public List<IGCRC0208VWInfo> getProcessList() {
		return processList;
	}

	public void setProcessList(List<IGCRC0208VWInfo> processList) {
		this.processList = processList;
	}

	public List<IG599Info> getProcessInfoList() {
		return processInfoList;
	}

	public void setProcessInfoList(List<IG599Info> processInfoList) {
		this.processInfoList = processInfoList;
	}
	
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}
	

	/**
	 * @return the igwkm0101form
	 */
	public IGWKM0101Form getIgwkm0101form() {
		return igwkm0101form;
	}

	/**
	 * @param igwkm0101form the igwkm0101form to set
	 */
	public void setIgwkm0101form(IGWKM0101Form igwkm0101form) {
		this.igwkm0101form = igwkm0101form;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}

	/** �û���Ϣ */
	protected User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfo() {
		return assignInfo;
	}

	public void setAssignInfo(Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo) {
		this.assignInfo = assignInfo;
	}

	public Map<String, IG007Info> getProcessInfoQueryMap() {
		return processInfoQueryMap;
	}

	public void setProcessInfoQueryMap(Map<String, IG007Info> processInfoQueryMap) {
		this.processInfoQueryMap = processInfoQueryMap;
	}

	/** ������Ϣ */
	protected Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo;
	/** ��ֵ*/
	protected List<IG599Info> processInfoList;
	/** �������ѯ����map */
	protected Map<String, IG007Info> processInfoQueryMap;
	/** ������*/
	protected List<IG337Info> processParticipantList;
	/** ״̬����*/
	protected List<IG333Info> processStatusDefList;
	/**
	 * ���ɸ澯��ӿڻ�ȡ
	 * @return ���ɸ澯��ӿ�
	 */
	public IgalarmInfo getIgalarmInfo() {
		return igalarmInfo;
	}

	/**
	 * ���ɸ澯��ӿ�����
	 * @param igalarmInfo ���ɸ澯��ӿ�
	 */
	public void setIgalarmInfo(IgalarmInfo igalarmInfo) {
		this.igalarmInfo = igalarmInfo;
	}

	/**
	 * ҳ���ѯ���ݻ�ȡ
	 * @return ҳ���ѯ����
	 */
	public List<IgalarmInfo> getIgalarmInfos() {
		return IgalarmInfos;
	}
	
	/**
	 * ҳ���ѯ��������
	 * @param igalarmInfos ҳ���ѯ����
	 */
	public void setIgalarmInfos(List<IgalarmInfo> igalarmInfos) {
		IgalarmInfos = igalarmInfos;
	}

	/**
	 * ����ѯ����ȡ
	 * @return ����ѯ��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ����ѯ������
	 * @param maxSearchCount ����ѯ��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��ѯ������ȡ
	 * @return ��ҳ��ѯ����
	 */
	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	/**
	 * ��ҳ��ѯ����
	 * @param pagingDTO ����
	 */
	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}
	
	/**
	 * �澯��Ϣ��ѯForm
	 * @return �澯��Ϣ��ѯForm
	 */
	public IGCRC0203Form getForm() {
		return form;
	}
	
	/**
	 * �澯��Ϣ��ѯForm����
	 * @param form �澯��Ϣ��ѯForm
	 */
	public void setForm(IGCRC0203Form form) {
		this.form = form;
	}
	
	/**
	 * socket��Ϣ
	 * @return socket��Ϣ
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * socket��Ϣ����
	 * @param msg socket��Ϣ
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * �澯����Formȡ��
	 * @return igcrc0204Form  �澯����Form
	 */
	public IGCRC0204Form getIgcrc0204Form() {
		return igcrc0204Form;
	}

	/**
	 * �澯����Form�趨
	 * @param igcrc0204Form  �澯����Form
	 */
	public void setIgcrc0204Form(IGCRC0204Form igcrc0204Form) {
		this.igcrc0204Form = igcrc0204Form;
	}

	/**
	 * prtypeȡ��
	 * @return prtype  prtype
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * prtype�趨
	 * @param prtype  prtype
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ��ҳBeanȡ��
	 * @return pagingDto  ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param pagingDto  ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * nameURLMapȡ��
	 * @return nameURLMap  nameURLMap
	 */
	public Map<String, String> getNameURLMap() {
		return nameURLMap;
	}

	/**
	 * nameURLMap�趨
	 * @param nameURLMap  nameURLMap
	 */
	public void setNameURLMap(Map<String, String> nameURLMap) {
		this.nameURLMap = nameURLMap;
	}

	/**
	 * processDefinitionListȡ��
	 * @return processDefinitionList  processDefinitionList
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * processDefinitionList�趨
	 * @param processDefinitionList  processDefinitionList
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * processTemplateListȡ��
	 * @return processTemplateList  processTemplateList
	 */
	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	/**
	 * processTemplateList�趨
	 * @param processTemplateList  processTemplateList
	 */
	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}

	/**
	 * �����ѯ�ӿ�ȡ��
	 * @return prSearchCond  �����ѯ�ӿ�
	 */
	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}

	/**
	 * �����ѯ�ӿ��趨
	 * @param prSearchCond  �����ѯ�ӿ�
	 */
	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}

	/**
	 * ��ѯ����ȡ��
	 * @return type  ��ѯ����
	 */
	public String getType() {
		return type;
	}

	/**
	 * ��ѯ�����趨
	 * @param type  ��ѯ����
	 */
	public void setType(String type) {
		this.type = type;
	}
	

	/**
	 * ������������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ������������״̬��
	 */
	public String getAppnamestatus() {
		return appnamestatus;
	}

	/**
	 * ������������״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param ������������״̬��
	 */
	public void setAppnamestatus(String appnamestatus) {
		this.appnamestatus = appnamestatus;
	}

	/**
	 * ip��ַ����״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ip��ַ����״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getIpaddrstatus() {
		return ipaddrstatus;
	}

	/**
	 * ip��ַ����״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param  ip��ַ����״̬��(1Ϊ���� 2Ϊ����)
	 */
	public void setIpaddrstatus(String ipaddrstatus) {
		this.ipaddrstatus = ipaddrstatus;
	}

	/**
	 * ����ʱ������״̬��(1Ϊ���� 2Ϊ����)ȡ��
	 * 
	 * @return ����ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public String getLasttimestatus() {
		return lasttimestatus;
	}

	/**
	 * ����ʱ������״̬��(1Ϊ���� 2Ϊ����)����
	 * 
	 * @param ����ʱ������״̬��(1Ϊ���� 2Ϊ����)
	 */
	public void setLasttimestatus(String lasttimestatus) {
		this.lasttimestatus = lasttimestatus;
	}

}
