package com.deliverik.infogovernor.sta.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sta.form.IGSTA0102Form;
import com.deliverik.infogovernor.sta.form.IGSTA0103Form;
import com.deliverik.infogovernor.sta.form.IGSTA0105Form;
import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;

/**
 * �����ලDTO
 * 
 */
@SuppressWarnings("serial")
public class IGSTA01DTO extends BaseDTO implements Serializable{

	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/**  ��ҳBean  */
	protected PagingDTO pagingDto;
	
	/**  ��ͬģ��  */
	protected List<LabelValueBean> contractType;
	
	/** �������ļලForm */
	protected IGSTA0102Form igsta0102Form;

	/** ����������Ϣȡ�� */
	List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList;
			
	protected IGSTA0103Form igsta0103Form;
	
	protected IGSTA0105Form igsta0105Form;

	/**��Ŀͳ����Ϣ*/
	protected List<ProjectStatistic> projectInfo;
	
	/**��ͬͳ����Ϣ*/
	protected List<Contract> contracts;
	
	/** ��ͬ��Ϣ������� */
    protected List<IG499Info> entityItemCompactVWInfoList;
	/**
	 * �����ѯ������¼��ȡ��
	 * @return maxSearchCount �����ѯ������¼��
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
	 * ��ҳBeanȡ��
	 * @return pagingDto ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �������ļලFormȡ��
	 * @return igsta0102Form �������ļලForm
	 */
	public IGSTA0102Form getIgsta0102Form() {
		return igsta0102Form;
	}

	/**
	 * �������ļලForm�趨
	 * @param igsta0102Form �������ļලForm
	 */
	public void setIgsta0102Form(IGSTA0102Form igsta0102Form) {
		this.igsta0102Form = igsta0102Form;
	}

	/**
	 * ����������Ϣȡ��ȡ��
	 * @return riskCheckProblemSuperviseVWList ����������Ϣȡ��
	 */
	public List<RiskCheckProblemSuperviseVWInfo> getRiskCheckProblemSuperviseVWList() {
		return riskCheckProblemSuperviseVWList;
	}

	/**
	 * ����������Ϣȡ���趨
	 * @param riskCheckProblemSuperviseVWList ����������Ϣȡ��
	 */
	public void setRiskCheckProblemSuperviseVWList(
			List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList) {
		this.riskCheckProblemSuperviseVWList = riskCheckProblemSuperviseVWList;
	}

    /**
     * igsta0103Formȡ��
     *
     * @return igsta0103Form igsta0103Form
     */
    public IGSTA0103Form getIgsta0103Form() {
        return igsta0103Form;
    }

    /**
     * ��ͬͳ����Ϣȡ��
     *
     * @return contracts ��ͬͳ����Ϣ
     */
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * igsta0103Form�趨
     *
     * @param igsta0103Form igsta0103Form
     */
    public void setIgsta0103Form(IGSTA0103Form igsta0103Form) {
        this.igsta0103Form = igsta0103Form;
    }

    /**
     * ��ͬͳ����Ϣ�趨
     *
     * @param contracts ��ͬͳ����Ϣ
     */
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * ��ͬģ��ȡ��
     *
     * @return contractType ��ͬģ��
     */
    public List<LabelValueBean> getContractType() {
        return contractType;
    }

    /**
     * ��ͬģ���趨
     *
     * @param contractType ��ͬģ��
     */
    public void setContractType(List<LabelValueBean> contractType) {
        this.contractType = contractType;
    }

    /**
     * ��ͬ��Ϣ�������ȡ��
     *
     * @return entityItemCompactVWInfoList ��ͬ��Ϣ�������
     */
    public List<IG499Info> getEntityItemCompactVWInfoList() {
        return entityItemCompactVWInfoList;
    }

    /**
     * ��ͬ��Ϣ��������趨
     *
     * @param entityItemCompactVWInfoList ��ͬ��Ϣ�������
     */
    public void setEntityItemCompactVWInfoList(List<IG499Info> entityItemCompactVWInfoList) {
        this.entityItemCompactVWInfoList = entityItemCompactVWInfoList;
    }

    /**
     * igsta0105Formȡ��
     *
     * @return igsta0105Form igsta0105Form
     */
    public IGSTA0105Form getIgsta0105Form() {
        return igsta0105Form;
    }

    /**
     * ��Ŀͳ����Ϣȡ��
     *
     * @return projectInfo ��Ŀͳ����Ϣ
     */
    public List<ProjectStatistic> getProjectInfo() {
        return projectInfo;
    }

    /**
     * igsta0105Form�趨
     *
     * @param igsta0105Form igsta0105Form
     */
    public void setIgsta0105Form(IGSTA0105Form igsta0105Form) {
        this.igsta0105Form = igsta0105Form;
    }

    /**
     * ��Ŀͳ����Ϣ�趨
     *
     * @param projectInfo ��Ŀͳ����Ϣ
     */
    public void setProjectInfo(List<ProjectStatistic> projectInfo) {
        this.projectInfo = projectInfo;
    }
	
}


