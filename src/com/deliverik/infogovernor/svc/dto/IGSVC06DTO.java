package com.deliverik.infogovernor.svc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.svc.form.IGSVC0601Form;
import com.deliverik.infogovernor.svc.form.IGSVC0602Form;
import com.deliverik.infogovernor.svc.form.IGSVC0635Form;
import com.deliverik.infogovernor.svc.form.IGSVC0636Form;
import com.deliverik.infogovernor.svc.form.IGSVC0639Form;
import com.deliverik.infogovernor.svc.form.IGSVC0637Form;
import com.deliverik.infogovernor.svc.form.IGSVC0638Form;
import com.deliverik.infogovernor.svc.form.IGSVC0640Form;
import com.deliverik.infogovernor.svc.form.IGSVC0642Form;
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;
import com.deliverik.infogovernor.svc.vo.IGSVC06421VO;

public class IGSVC06DTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private IGSVC0601Form igsvc0601Form;

	private IG500Info processRecord;
	
	private IG500SearchCond processRecordSearchCond;
	
	private IGSVC0602Form igsvc0602Form;
	
	/**��Ա������ͳ��form*/
	private IGSVC0639Form igsvc0639Form;
	
	/** ��������ͳ��form */
	private IGSVC0635Form igsvc0635Form;
	
	/** ���ŷ���ͳ��form */
	protected IGSVC0636Form igsvc0636Form;
	
	/** ���ŷ���top5ͳ�� */
	protected IGSVC0637Form igsvc0637Form;
	
	/** ��������ƽ�����ʱ��ͳ��form */
	protected IGSVC0638Form igsvc0638Form;
	
	/** ��������ͳ��Form */
	protected IGSVC0642Form igsvc0642Form;
	
	private String prassetcategory;
	
	/** ��������ͳ����Ϣ */
	private IncidentTypeVWInfo incidentType;
	
	/**��Ա������ͳ����Ϣ*/
	private List<IG160Info> summartyCountList;
	
	/**
	 * ���̻�����Ϣ�б�
	 */
	private List<IG359Info> processCountList;
	
	/** ���ŷ���ͳ�����ݼ��� */
	private List<OrganizationServiceVWInfo> organizationServiceList;
	
	/** �¼����� */
	private Integer icount;
	
	/** ������������ */
	private Integer scount;
	
	/** ������ */
	private Integer gcount;
	
	/** ���� */
	private Integer totalCount;
	
	/** ���ŷ���top5ͳ������ */
	protected List<ServiceTopFiveVWInfo> serviceTopFiveList;
	
	/** ʱ��ƽ�����ʱ��ͳ������ */
	protected List<IncidentAveSolveTimeVWInfo> incidentAveSolveTimeDate;

	/**��Ա�������Ǹ�ͳ��Json��ʽ  ��Ա��Ϣ */
	private String presonsJson;
	/**��Ա������ͳ�� Json ��ʽͳ������*/
	private String acountJson;
	
	/** ��ȹ�������ͳ��Form */
	private IGSVC0640Form igsvc0640Form;
	
	/** ��������ͳ��VO */
	protected IGSVC06421VO igsvc06421VO;
	
	/** �¼�ͳ������ */
	private String incidentnum;
	/** ����ͳ������ */
	private String problemnum;
	/** ���ͳ������ */
	private String changenum;
	/** ��������ͳ������ */
	private String servicenum;
	/** ���񹤵�ͳ������ */
	private String sfnum;

	public IG500SearchCond getProcessRecordSearchCond() {
		return processRecordSearchCond;
	}

	public void setProcessRecordSearchCond(
			IG500SearchCond processRecordSearchCond) {
		this.processRecordSearchCond = processRecordSearchCond;
	}

	public String getPrassetcategory() {
		return prassetcategory;
	}

	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	protected IG359SearchCond processcountsearchcond;
	
	public IG359SearchCond getProcesscountsearchcond() {
		return processcountsearchcond;
	}

	public void setProcesscountsearchcond(
			IG359SearchCond processcountsearchcond) {
		this.processcountsearchcond = processcountsearchcond;
	}

	
	public IGSVC0602Form getIgsvc0602Form() {
		return igsvc0602Form;
	}

	public void setIgsvc0602Form(IGSVC0602Form igsvc0602Form) {
		this.igsvc0602Form = igsvc0602Form;
	}

	public IGSVC0601Form getIgsvc0601Form() {
		return igsvc0601Form;
	}

	public void setIgsvc0601Form(IGSVC0601Form igsvc0601Form) {
		this.igsvc0601Form = igsvc0601Form;
	}

	public IG500Info getProcessRecord() {
		return processRecord;
	}

	public void setProcessRecord(IG500Info processRecord) {
		this.processRecord = processRecord;
	}

	public List<IG359Info> getProcessCountList() {
		return processCountList;
	}

	public void setProcessCountList(List<IG359Info> processCountList) {
		this.processCountList = processCountList;
	}

	/**
	 * ��������ͳ��formȡ��
	 * @return igsvc0635Form ��������ͳ��form
	 */
	public IGSVC0635Form getIgsvc0635Form() {
		return igsvc0635Form;
	}

	/**
	 * ��������ͳ��form�趨
	 * @param igsvc0635Form ��������ͳ��form
	 */
	public void setIgsvc0635Form(IGSVC0635Form igsvc0635Form) {
		this.igsvc0635Form = igsvc0635Form;
	}

	/**
	 * ���ŷ���ͳ��formȡ��
	 * @return igsvc0636Form ���ŷ���ͳ��form
	 */
	public IGSVC0636Form getIgsvc0636Form() {
		return igsvc0636Form;
	}

	/**
	 * ���ŷ���ͳ��form�趨
	 * @param igsvc0636Form ���ŷ���ͳ��form
	 */
	public void setIgsvc0636Form(IGSVC0636Form igsvc0636Form) {
		this.igsvc0636Form = igsvc0636Form;
	}

	/**
	 * ���ŷ���top5ͳ��ȡ��
	 * @return igsvc0637Form ���ŷ���top5ͳ��
	 */
	public IGSVC0637Form getIgsvc0637Form() {
		return igsvc0637Form;
	}

	/**
	 * ���ŷ���top5ͳ���趨
	 * @param igsvc0637Form ���ŷ���top5ͳ��
	 */
	public void setIgsvc0637Form(IGSVC0637Form igsvc0637Form) {
		this.igsvc0637Form = igsvc0637Form;
	}

	/**
	 * ��������ƽ�����ʱ��ͳ��formȡ��
	 * @return igsvc0638Form ��������ƽ�����ʱ��ͳ��form
	 */
	public IGSVC0638Form getIgsvc0638Form() {
		return igsvc0638Form;
	}

	/**
	 * ��������ƽ�����ʱ��ͳ��form�趨
	 * @param igsvc0638Form ��������ƽ�����ʱ��ͳ��form
	 */
	public void setIgsvc0638Form(IGSVC0638Form igsvc0638Form) {
		this.igsvc0638Form = igsvc0638Form;
	}

	/**
	 * ��������ͳ��Formȡ��
	 * @return igsvc0642Form ��������ͳ��Form
	 */
	public IGSVC0642Form getIgsvc0642Form() {
		return igsvc0642Form;
	}

	/**
	 * ��������ͳ��Form�趨
	 * @param igsvc0642Form ��������ͳ��Form
	 */
	public void setIgsvc0642Form(IGSVC0642Form igsvc0642Form) {
		this.igsvc0642Form = igsvc0642Form;
	}

	/**
	 * ��������ͳ����Ϣȡ��
	 * @return incidentType ��������ͳ����Ϣ
	 */
	public IncidentTypeVWInfo getIncidentType() {
		return incidentType;
	}

	/**
	 * ��������ͳ����Ϣ�趨
	 * @param incidentType ��������ͳ����Ϣ
	 */
	public void setIncidentType(IncidentTypeVWInfo incidentType) {
		this.incidentType = incidentType;
	}

	/**
	 * ���ŷ���ͳ�����ݼ���ȡ��
	 * @return organizationServiceList ���ŷ���ͳ�����ݼ���
	 */
	public List<OrganizationServiceVWInfo> getOrganizationServiceList() {
		return organizationServiceList;
	}

	/**
	 * ���ŷ���ͳ�����ݼ����趨
	 * @param organizationServiceList ���ŷ���ͳ�����ݼ���
	 */
	public void setOrganizationServiceList(
			List<OrganizationServiceVWInfo> organizationServiceList) {
		this.organizationServiceList = organizationServiceList;
	}

	/**
	 * �¼�����ȡ��
	 * @return icount �¼�����
	 */
	public Integer getIcount() {
		return icount;
	}

	/**
	 * �¼������趨
	 * @param icount �¼�����
	 */
	public void setIcount(Integer icount) {
		this.icount = icount;
	}

	/**
	 * ������������ȡ��
	 * @return scount ������������
	 */
	public Integer getScount() {
		return scount;
	}

	/**
	 * �������������趨
	 * @param scount ������������
	 */
	public void setScount(Integer scount) {
		this.scount = scount;
	}

	/**
	 * ����ȡ��
	 * @return totalCount ����
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * �����趨
	 * @param totalCount ����
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public IGSVC0639Form getIgsvc0639Form() {
		return igsvc0639Form;
	}

	public void setIgsvc0639Form(IGSVC0639Form igsvc0639Form) {
		this.igsvc0639Form = igsvc0639Form;
	}

	public List<IG160Info> getSummartyCountList() {
		return summartyCountList;
	}

	public void setSummartyCountList(List<IG160Info> summartyCountList) {
		this.summartyCountList = summartyCountList;
	}

	public String getPresonsJson() {
		return presonsJson;
	}

	public void setPresonsJson(String presonsJson) {
		this.presonsJson = presonsJson;
	}

	public String getAcountJson() {
		return acountJson;
	}

	public void setAcountJson(String acountJson) {
		this.acountJson = acountJson;
	}

	
	/**
	 * ���ŷ���top5ͳ������ȡ��
	 * @return serviceTopFiveList ���ŷ���top5ͳ������
	 */
	public List<ServiceTopFiveVWInfo> getServiceTopFiveList() {
		return serviceTopFiveList;
	}

	/**
	 * ���ŷ���top5ͳ�������趨
	 * @param serviceTopFiveList ���ŷ���top5ͳ������
	 */
	public void setServiceTopFiveList(List<ServiceTopFiveVWInfo> serviceTopFiveList) {
		this.serviceTopFiveList = serviceTopFiveList;
	}

	/**
	 * ʱ��ƽ�����ʱ��ͳ������ȡ��
	 * @return incidentAveSolveTimeDate ʱ��ƽ�����ʱ��ͳ������
	 */
	public List<IncidentAveSolveTimeVWInfo> getIncidentAveSolveTimeDate() {
		return incidentAveSolveTimeDate;
	}

	/**
	 * ʱ��ƽ�����ʱ��ͳ�������趨
	 * @param incidentAveSolveTimeDate ʱ��ƽ�����ʱ��ͳ������
	 */
	public void setIncidentAveSolveTimeDate(
			List<IncidentAveSolveTimeVWInfo> incidentAveSolveTimeDate) {
		this.incidentAveSolveTimeDate = incidentAveSolveTimeDate;
	}
	public Integer getGcount() {
		return gcount;
	}

	public void setGcount(Integer gcount) {
		this.gcount = gcount;
	}

	/**
	 * ��ȹ�������ͳ��Formȡ��
	 * @return igsvc0640Form ��ȹ�������ͳ��Form
	 */
	public IGSVC0640Form getIgsvc0640Form() {
		return igsvc0640Form;
	}

	/**
	 * ��ȹ�������ͳ��Form�趨
	 * @param igsvc0640Form ��ȹ�������ͳ��Form
	 */
	public void setIgsvc0640Form(IGSVC0640Form igsvc0640Form) {
		this.igsvc0640Form = igsvc0640Form;
	}
	/**
	 * ��������ͳ��VOȡ��
	 * @return igsvc06421VO ��������ͳ��VO
	 */
	public IGSVC06421VO getIgsvc06421VO() {
		return igsvc06421VO;
	}

	/**
	 * ��������ͳ��VO�趨
	 * @param igsvc06421VO ��������ͳ��VO
	 */
	public void setIgsvc06421VO(IGSVC06421VO igsvc06421vo) {
		igsvc06421VO = igsvc06421vo;
	}

	/**
	 * �¼�ͳ������ȡ��
	 * @return incidentnum �¼�ͳ������
	 */
	public String getIncidentnum() {
		return incidentnum;
	}
	
	/**
	 * �¼�ͳ�������趨
	 * @param incidentnum �¼�ͳ������
	 */
	public void setIncidentnum(String incidentnum) {
		this.incidentnum = incidentnum;
	}

	/**
	 * ����ͳ������ȡ��
	 * @return problemnum ����ͳ������
	 */
	public String getProblemnum() {
		return problemnum;
	}

	/**
	 * ����ͳ�������趨
	 * @param problemnum ����ͳ������
	 */
	public void setProblemnum(String problemnum) {
		this.problemnum = problemnum;
	}

	/**
	 * ���ͳ������ȡ��
	 * @return changenum ���ͳ������
	 */
	public String getChangenum() {
		return changenum;
	}

	/**
	 * ���ͳ�������趨
	 * @param changenum ���ͳ������
	 */
	public void setChangenum(String changenum) {
		this.changenum = changenum;
	}

	/**
	 * ��������ͳ������ȡ��
	 * @return servicenum ��������ͳ������
	 */
	public String getServicenum() {
		return servicenum;
	}
	
	/**
	 * ��������ͳ�������趨
	 * @param servicenum ��������ͳ������
	 */
	public void setServicenum(String servicenum) {
		this.servicenum = servicenum;
	}

	/**
	 * ���񹤵�ͳ������ȡ��
	 * @return sfnum ���񹤵�ͳ������
	 */
	public String getSfnum() {
		return sfnum;
	}
	
	/**
	 * ���񹤵�ͳ�������趨
	 * @param sfnum ���񹤵�ͳ������
	 */
	public void setSfnum(String sfnum) {
		this.sfnum = sfnum;
	}
	
}
