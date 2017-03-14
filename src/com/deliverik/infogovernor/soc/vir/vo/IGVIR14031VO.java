/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����Դ����VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR14031VO extends BaseVO{

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
    protected List<String[]> vmcountList;

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
    public List<String[]> getVmcountList() {
        return vmcountList;
    }

    /**
     * ������������������б�
     * @param vmcountList ��������������б�
     */
    public void setVmcountList(List<String[]> vmcountList) {
        this.vmcountList = vmcountList;
    }
    
    
}
