/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.sym.form.IGSYM1402Form;
import com.deliverik.infogovernor.sym.form.IGSYM1407Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;

/**
 * ������Ϣҵ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSYM14DTO extends BaseDTO implements Serializable{
	
	/** ������Ϣ�������� */
	protected ReportFileDefinitionSearchCond reportFileDefinitionSearchCond;
	
	/** ����汾��Ϣ�������� */
	protected ReportFileVersionSearchCond reportFileVersionSearchCond;
	
	/** ������ϢForm */
	protected IGSYM1402Form igSYM1402Form;

	/** ������Ϣ��������� */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** ����汾��Ϣ��������� */
	protected List<ReportFileVersion> reportFileVersionList;
	
	/** ������Ϣ */
	protected ReportFileDefinition reportFileDefinition;
	
	/** �û���Ϣ */
	protected User user;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** �����ѯ������¼�� */
	protected int maxSearchCount;
	
	/** ����ɾ������ */
	protected String[] deleteRfdid;
	
	/** �������� */
	protected Integer rfdid;
	
	/** �汾���� */
	protected Integer rfvid;
	
	protected IGSYM1407Form	igsym1407Form;
	
	/** ����������*/
	protected List<LabelValueBean> objectNameList;
	
	protected List<LabelValueBean> prtypeList;
	
	protected List<IG333Info> prstatusList;
	
	/** ����ģ�����ݼ�*/
	protected List<LabelValueBean> rfdFileNameList;

	public List<IG333Info> getPrstatusList() {
		return prstatusList;
	}

	public void setPrstatusList(List<IG333Info> prstatusList) {
		this.prstatusList = prstatusList;
	}

	public List<LabelValueBean> getPrtypeList() {
		return prtypeList;
	}

	public void setPrtypeList(List<LabelValueBean> prtypeList) {
		this.prtypeList = prtypeList;
	}

	public List<LabelValueBean> getObjectNameList() {
		return objectNameList;
	}

	public void setObjectNameList(List<LabelValueBean> objectNameList) {
		this.objectNameList = objectNameList;
	}

	public IGSYM1407Form getIgsym1407Form() {
		return igsym1407Form;
	}

	public void setIgsym1407Form(IGSYM1407Form igsym1407Form) {
		this.igsym1407Form = igsym1407Form;
	}

	/**
	 * ������Ϣ��������ȡ��
	 * @return ������Ϣ��������
	 */
	public ReportFileDefinitionSearchCond getReportFileDefinitionSearchCond() {
		return reportFileDefinitionSearchCond;
	}

	/**
	 * ������Ϣ���������趨
	 * @param reportFileDefinitionSearchCond ������Ϣ��������
	 */
	public void setReportFileDefinitionSearchCond(
			ReportFileDefinitionSearchCond reportFileDefinitionSearchCond) {
		this.reportFileDefinitionSearchCond = reportFileDefinitionSearchCond;
	}

	/**
	 * ������ϢFormȡ��
	 * @return ������ϢForm
	 */
	public IGSYM1402Form getIgSYM1402Form() {
		return igSYM1402Form;
	}

	/**
	 * ������ϢForm�趨
	 * @param igSYM1402Form ������ϢForm
	 */
	public void setIgSYM1402Form(IGSYM1402Form igSYM1402Form) {
		this.igSYM1402Form = igSYM1402Form;
	}

	/**
	 * ������Ϣ���������ȡ��
	 * @return ������Ϣ���������
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * ������Ϣ����������趨
	 * @param reportFileDefinitionList ������Ϣ���������
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �����ѯ������¼��ȡ��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * �û���Ϣȡ��
	 * @return �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ����ɾ������ȡ��
	 * @return ����ɾ������
	 */
	public String[] getDeleteRfdid() {
		return deleteRfdid;
	}

	/**
	 * ����ɾ�������趨
	 * @param deleteRfdid ����ɾ������
	 */
	public void setDeleteRfdid(String[] deleteRfdid) {
		this.deleteRfdid = deleteRfdid;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * ���������趨
	 * @param rfdid ��������
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * ����汾��Ϣ��������ȡ��
	 * @return ����汾��Ϣ��������
	 */
	public ReportFileVersionSearchCond getReportFileVersionSearchCond() {
		return reportFileVersionSearchCond;
	}

	/**
	 * ����汾��Ϣ���������趨
	 * @param reportFileVersionSearchCond ����汾��Ϣ��������
	 */
	public void setReportFileVersionSearchCond(
			ReportFileVersionSearchCond reportFileVersionSearchCond) {
		this.reportFileVersionSearchCond = reportFileVersionSearchCond;
	}

	/**
	 * ����汾��Ϣ���������ȡ��
	 * @return ����汾��Ϣ���������
	 */
	public List<ReportFileVersion> getReportFileVersionList() {
		return reportFileVersionList;
	}

	/**
	 * ����汾��Ϣ����������趨
	 * @param reportFileVersionList ����汾��Ϣ���������
	 */
	public void setReportFileVersionList(
			List<ReportFileVersion> reportFileVersionList) {
		this.reportFileVersionList = reportFileVersionList;
	}

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public ReportFileDefinition getReportFileDefinition() {
		return reportFileDefinition;
	}

	/**
	 * ������Ϣ�趨
	 * @param reportFileDefinition ������Ϣ
	 */
	public void setReportFileDefinition(ReportFileDefinition reportFileDefinition) {
		this.reportFileDefinition = reportFileDefinition;
	}
	
	/**
	 * �汾����ȡ��
	 * @return �汾����
	 */
	public Integer getRfvid() {
		return rfvid;
	}
	
	/**
	 * �汾�����趨
	 * @param rfvid �汾����
	 */
	public void setRfvid(Integer rfvid) {
		this.rfvid = rfvid;
	}

    /**
     * @return the rfdFileNameList
     */
    public List<LabelValueBean> getRfdFileNameList() {
        return rfdFileNameList;
    }

    /**
     * @param rfdFileNameList the rfdFileNameList to set
     */
    public void setRfdFileNameList(List<LabelValueBean> rfdFileNameList) {
        this.rfdFileNameList = rfdFileNameList;
    }
	
}


