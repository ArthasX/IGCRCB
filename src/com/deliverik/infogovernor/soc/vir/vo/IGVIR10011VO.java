package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.google.gson.Gson;

/**
 * ��ҳ	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR10011VO extends BaseVO implements Serializable{
	
	private List<IG500Info> lstProcessRecord ;
	
	/**�û�������Դ���� */
	private Integer userExpireCount;
	
	/**�û���Դ������ */
	private Integer userCount;
	
	/**���ŵ�����Դ���� */
	private Integer orgExpireCount;
	
	/**������Դ������ */
	private Integer orgCount;
	
	/**��Դ�ſ���Ϣ*/
	private Map<String, Integer> resourceSurveyMap;
	
	/**��������*/
	protected List<ProcessInHandVWInfo> pihList;
	
	
	/**������Դʹ�����*/
	private List<VIM03CountByOrgVWInfo> orgResList;
	
	/**���ż���������Դ���*/
	private List<VIM03CountByOrgVWInfo> orgExpiryResList;
	
	/** ���˽����� */
	private Integer usercost;
	
	/** ���Ž����� */
	private Integer orgcost;
	
	/** �ܽ����� */
	private Integer totalcost;
	
	/**����VM�б�*/
	private List<VIM03Info> ownVMlist;

	/**ģ�弯��*/
	private List<Template> templateList;
	
	/**�·�ͳ����Ϣ*/
	private List<Object[]> monthCountData;
	
	/** �·�ͳ����ϢJson */
    protected String monthCountJson ;
    
    /** �·���ϢJson */
    protected String monthJson ;
	
	public List<IG500Info> getLstProcessRecord() {
		return lstProcessRecord;
	}

	public void setLstProcessRecord(List<IG500Info> lstProcessRecord) {
		this.lstProcessRecord = lstProcessRecord;
	}
	
	/**
	 * �û�������Դ����ȡ��
	 * @return userExpireCount �û�������Դ����
	 */
	public Integer getUserExpireCount() {
		return userExpireCount;
	}


	/**
	 * �û�������Դ�����趨
	 * @param userExpireCount �û�������Դ����
	 */
	public void setUserExpireCount(Integer userExpireCount) {
		this.userExpireCount = userExpireCount;
	}


	/**
	 * �û���Դ������ȡ��
	 * @return userCount �û���Դ������
	 */
	public Integer getUserCount() {
		return userCount;
	}


	/**
	 * �û���Դ�������趨
	 * @param userCount �û���Դ������
	 */
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}


	/**
	 * ���ŵ�����Դ����ȡ��
	 * @return orgExpireCount ���ŵ�����Դ����
	 */
	public Integer getOrgExpireCount() {
		return orgExpireCount;
	}


	/**
	 * ���ŵ�����Դ�����趨
	 * @param orgExpireCount ���ŵ�����Դ����
	 */
	public void setOrgExpireCount(Integer orgExpireCount) {
		this.orgExpireCount = orgExpireCount;
	}


	/**
	 * ������Դ������ȡ��
	 * @return orgCount ������Դ������
	 */
	public Integer getOrgCount() {
		return orgCount;
	}


	/**
	 * ������Դ�������趨
	 * @param orgCount ������Դ������
	 */
	public void setOrgCount(Integer orgCount) {
		this.orgCount = orgCount;
	}
	
	

	/**
	 * ������Դʹ�������ȡ
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getOrgResList() {
		return orgResList;
	}


	/**
	 * ������Դʹ������趨
	 * @param orgResList
	 */
	public void setOrgResList(List<VIM03CountByOrgVWInfo> orgResList) {
		this.orgResList = orgResList;
	}

	/**
	 * ���ż���������Դ�����ȡ
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getOrgExpiryResList() {
		
		Gson gson = new Gson();
		
		return orgExpiryResList;
	}

	/**
	 * ���ż���������Դ����趨
	 * @param orgExpiryResList
	 */
	public void setOrgExpiryResList(List<VIM03CountByOrgVWInfo> orgExpiryResList) {
		this.orgExpiryResList = orgExpiryResList;
	}
	

	/**
	 * ��Դ�ſ���Ϣȡ��
	 * @return resourceSurveyMap ��Դ�ſ���Ϣ
	 */
	public Map<String, Integer> getResourceSurveyMap() {
		return resourceSurveyMap;
	}

	/**
	 * ��Դ�ſ���Ϣ�趨
	 * @param resourceSurveyMap ��Դ�ſ���Ϣ
	 */
	public void setResourceSurveyMap(Map<String, Integer> resourceSurveyMap) {
		this.resourceSurveyMap = resourceSurveyMap;
	}

	public Integer getUsercost() {
		return usercost;
	}

	public void setUsercost(Integer usercost) {
		this.usercost = usercost;
	}

	public Integer getOrgcost() {
		return orgcost;
	}

	public void setOrgcost(Integer orgcost) {
		this.orgcost = orgcost;
	}

	
	public Integer getTotalcost() {
		return totalcost;
	}


	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}

	public List<ProcessInHandVWInfo> getPihList() {
		return pihList;
	}

	public void setPihList(List<ProcessInHandVWInfo> pihList) {
		this.pihList = pihList;
	}

	public List<Template> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<Template> templateList) {
		this.templateList = templateList;
	}

	public List<VIM03Info> getOwnVMlist() {
		return ownVMlist;
	}

	public void setOwnVMlist(List<VIM03Info> ownVMlist) {
		this.ownVMlist = ownVMlist;
	}

	public List<Object[]> getMonthCountData() {
		return monthCountData;
	}

	public void setMonthCountData(List<Object[]> monthCountData) {
		this.monthCountData = monthCountData;
	}

    /**
     * ��ȡ�·�ͳ����ϢJson
     * @return �·�ͳ����ϢJson 
     */
    public String getMonthCountJson() {
        return monthCountJson;
    }

    /**
     * �����·�ͳ����ϢJson
     * @param monthCountJson �·�ͳ����ϢJson
     */
    public void setMonthCountJson(String monthCountJson) {
        this.monthCountJson = monthCountJson;
    }

    /**
     * ��ȡ�·���ϢJson
     * @return �·���ϢJson 
     */
    public String getMonthJson() {
        return monthJson;
    }

    /**
     * �����·���ϢJson
     * @param monthJson �·���ϢJson
     */
    public void setMonthJson(String monthJson) {
        this.monthJson = monthJson;
    }
	
	
}


