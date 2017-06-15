/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.dto;

import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1401Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1403Form;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ͳ�Ʒ�������DTO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR14DTO extends BaseDTO{
    
    /** �¼����� */
    protected Integer incidentCount;
    
    /** �������� */
    protected Integer problemCount;
    
    /** ������� */
    protected Integer changeCount;
    
    /** ��Դ�������� */
    protected Integer resnewCount;
    
    /** ��Դ�������� */
    protected Integer resadjustCount;
    
    /** ��Դ�������� */
    protected Integer resrecoverCount;

    /** δ�رյ���ά�����б� */
    protected List<IG500Info> omprocessRecordList;
    
    /** δ�رյ���Դ�����б� */
    protected List<IG500Info> resprocessRecordList;
    
    /**��ҳBean*/
    protected PagingDTO pagingDto;
    
    /**�����ѯ������¼��*/
    protected int maxSearchCount;
    
    /** ��������������б� */
    protected String vmcountJson;
    
    /**  ���м���ά���Form */
    protected IGVIR1403Form igvir1403Form;
    
    /** vCenter����ID */
    protected Integer vcid;

    /** ��Դ����ͳ��Form */
    protected IGVIR1401Form igvir1401Form;
    
    /** ��Դ����ͳ��Map */
    protected Map<String, Integer[]> vmApplyStatisticsDataMap;
    
    /** �����б�ֵ�� */
    protected List<LabelValueBean> labelValueBeanList;
    
    /** Host��Ϣ���� */
    protected Map<Integer, List<Host>> hostMap;
    
    /** ����IP */
    protected String hostname;

    /**
     * ��ȡ�¼�����
     * @return �¼����� 
     */
    public Integer getIncidentCount() {
        return incidentCount;
    }

    /**
     * �����¼�����
     * @param incidentCount �¼�����
     */
    public void setIncidentCount(Integer incidentCount) {
        this.incidentCount = incidentCount;
    }

    /**
     * ��ȡ��������
     * @return �������� 
     */
    public Integer getProblemCount() {
        return problemCount;
    }

    /**
     * ������������
     * @param problemCount ��������
     */
    public void setProblemCount(Integer problemCount) {
        this.problemCount = problemCount;
    }

    /**
     * ��ȡ�������
     * @return ������� 
     */
    public Integer getChangeCount() {
        return changeCount;
    }

    /**
     * ���ñ������
     * @param changeCount �������
     */
    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    /**
     * ��ȡ��Դ��������
     * @return ��Դ�������� 
     */
    public Integer getResnewCount() {
        return resnewCount;
    }

    /**
     * ������Դ��������
     * @param resnewCount ��Դ��������
     */
    public void setResnewCount(Integer resnewCount) {
        this.resnewCount = resnewCount;
    }

    /**
     * ��ȡ��Դ��������
     * @return ��Դ�������� 
     */
    public Integer getResadjustCount() {
        return resadjustCount;
    }

    /**
     * ������Դ��������
     * @param resadjustCount ��Դ��������
     */
    public void setResadjustCount(Integer resadjustCount) {
        this.resadjustCount = resadjustCount;
    }

    /**
     * ��ȡ��Դ��������
     * @return ��Դ�������� 
     */
    public Integer getResrecoverCount() {
        return resrecoverCount;
    }

    /**
     * ������Դ��������
     * @param resrecoverCount ��Դ��������
     */
    public void setResrecoverCount(Integer resrecoverCount) {
        this.resrecoverCount = resrecoverCount;
    }

    /**
     * ��ȡδ�رյ���ά�����б�
     * @return δ�رյ���ά�����б� 
     */
    public List<IG500Info> getOmprocessRecordList() {
        return omprocessRecordList;
    }

    /**
     * ����δ�رյ���ά�����б�
     * @param omprocessRecordList δ�رյ���ά�����б�
     */
    public void setOmprocessRecordList(List<IG500Info> omprocessRecordList) {
        this.omprocessRecordList = omprocessRecordList;
    }

    /**
     * ��ȡδ�رյ���Դ�����б�
     * @return δ�رյ���Դ�����б� 
     */
    public List<IG500Info> getResprocessRecordList() {
        return resprocessRecordList;
    }

    /**
     * ����δ�رյ���Դ�����б�
     * @param resprocessRecordList δ�رյ���Դ�����б�
     */
    public void setResprocessRecordList(List<IG500Info> resprocessRecordList) {
        this.resprocessRecordList = resprocessRecordList;
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
     * ��ȡ��������������б�
     * @return ��������������б� 
     */
    public String getVmcountJson() {
        return vmcountJson;
    }

    /**
     * ������������������б�
     * @param vmcountJson ��������������б�
     */
    public void setVmcountJson(String vmcountJson) {
        this.vmcountJson = vmcountJson;
    }

    /**
     * ��ȡ���м���ά���Form
     * @return ���м���ά���Form 
     */
    public IGVIR1403Form getIgvir1403Form() {
        return igvir1403Form;
    }

    /**
     * �������м���ά���Form
     * @param igvir1403Form ���м���ά���Form
     */
    public void setIgvir1403Form(IGVIR1403Form igvir1403Form) {
        this.igvir1403Form = igvir1403Form;
    }

    /**
     * ��ȡvCenter����ID
     * @return vCenter����ID 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * ����vCenter����ID
     * @param vcid vCenter����ID
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    /**
     * ��ȡ��Դ����ͳ��Form
     * @return ��Դ����ͳ��Form 
     */
    public IGVIR1401Form getIgvir1401Form() {
        return igvir1401Form;
    }

    /**
     * ������Դ����ͳ��Form
     * @param igvir1401Form ��Դ����ͳ��Form
     */
    public void setIgvir1401Form(IGVIR1401Form igvir1401Form) {
        this.igvir1401Form = igvir1401Form;
    }

    /**
     * ��ȡ��Դ����ͳ��Map
     * @return ��Դ����ͳ��Map 
     */
    public Map<String, Integer[]> getVmApplyStatisticsDataMap() {
        return vmApplyStatisticsDataMap;
    }

    /**
     * ������Դ����ͳ��Map
     * @param vmApplyStatisticsDataMap ��Դ����ͳ��Map
     */
    public void setVmApplyStatisticsDataMap(Map<String, Integer[]> vmApplyStatisticsDataMap) {
        this.vmApplyStatisticsDataMap = vmApplyStatisticsDataMap;
    }

    /**
     * ��ȡ�����б�ֵ��
     * @return �����б�ֵ�� 
     */
    public List<LabelValueBean> getLabelValueBeanList() {
        return labelValueBeanList;
    }

    /**
     * ���������б�ֵ��
     * @param labelValueBeanList �����б�ֵ��
     */
    public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
        this.labelValueBeanList = labelValueBeanList;
    }

	/**
	 * Host��Ϣ����ȡ��
	 * @return hostMap Host��Ϣ����
	 */
	public Map<Integer, List<Host>> getHostMap() {
		return hostMap;
	}

	/**
	 * Host��Ϣ�����趨
	 * @param hostMap Host��Ϣ����
	 */
	public void setHostMap(Map<Integer, List<Host>> hostMap) {
		this.hostMap = hostMap;
	}

	/**
	 * ����IPȡ��
	 * @return hostname ����IP
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * ����IP�趨
	 * @param hostname ����IP
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
}
