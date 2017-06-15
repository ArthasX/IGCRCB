package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1001Form;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.deliverik.infogovernor.soc.vir.vim.model.VMachine;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10051VO;

/**
 * ��ҳҵ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR10DTO extends BaseDTO implements Serializable{
	
	/**form*/
	private IGVIR1001Form igvir1001Form;
	
	/**������Ϣ*/
	private List<IG500Info> lstProcessRecord;

	/**�û���Ϣ*/
	private User user;
	
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
	/**������Դʹ�����*/
	private List<VIM03CountByOrgVWInfo> orgResList;
	
	/**���ż���������Դ���*/
	private List<VIM03CountByOrgVWInfo> orgExpiryResList;
	
	/**��������*/
	protected List<ProcessInHandVWInfo> pihList;
	
	/** ���˽����� */
	private Integer usercost;
	
	/** ���Ž����� */
	private Integer orgcost;
	
	/** �ܽ����� */
	private Integer totalcost;
	
	/**ģ�弯��*/
	private List<Template> templateList;
	
	/**����VM�б�*/
	private List<VIM03Info> ownVMList ;
	
	/**�·�ͳ����Ϣ*/
	private List<Object[]> monthCountData;
	
	/** �·�ͳ����ϢJson */
	protected String monthCountJson ;
	
	/** �·���ϢJson */
	protected String monthJson ;
	
	/** ���⻯������ҳVO */
	protected IGVIR10051VO igvir10051VO;
	
	/** �ҷ����������Ϣ */
	protected List<IG677Info> myOpenProcessList;
	
	/** �����Ϣ */
	protected List<VMachine> vmList;
	
	/** ������� */
	protected String vmname;
	
	/** ���״̬ */
	protected String powerState;
	
	/** Host��Ϣ���� */
	protected Map<Integer, List<Host>> hostMap;
	
	/** ��������ͳ��Map */
	protected Map<String, Integer> vmReportMap;
	
	/** ��ά��������Map */
	protected Map<String, Map<String, Integer>> prRecportMap;
	
    /** vcenter���� */
    protected Integer vcid;
    
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public IGVIR1001Form getIgvir1001Form() {
		return igvir1001Form;
	}

	
	public void setIgvir1001Form(IGVIR1001Form igvir1001Form) {
		this.igvir1001Form = igvir1001Form;
	}

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
		return orgExpiryResList;
	}

	/**
	 * ���ż���������Դ����趨
	 * @param orgExpiryResList
	 */
	public void setOrgExpiryResList(List<VIM03CountByOrgVWInfo> orgExpiryResList) {
		this.orgExpiryResList = orgExpiryResList;
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


	public List<VIM03Info> getOwnVMList() {
		return ownVMList;
	}


	public void setOwnVMList(List<VIM03Info> ownVMList) {
		this.ownVMList = ownVMList;
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


	/**
	 * ���⻯������ҳVOȡ��
	 * @return igvir10051VO ���⻯������ҳVO
	 */
	public IGVIR10051VO getIgvir10051VO() {
		return igvir10051VO;
	}


	/**
	 * ���⻯������ҳVO�趨
	 * @param igvir10051VO ���⻯������ҳVO
	 */
	public void setIgvir10051VO(IGVIR10051VO igvir10051vo) {
		igvir10051VO = igvir10051vo;
	}


	/**
	 * �ҷ����������Ϣȡ��
	 * @return myOpenProcessList �ҷ����������Ϣ
	 */
	public List<IG677Info> getMyOpenProcessList() {
		return myOpenProcessList;
	}


	/**
	 * �ҷ����������Ϣ�趨
	 * @param myOpenProcessList �ҷ����������Ϣ
	 */
	public void setMyOpenProcessList(List<IG677Info> myOpenProcessList) {
		this.myOpenProcessList = myOpenProcessList;
	}


	/**
	 * �����Ϣȡ��
	 * @return vmList �����Ϣ
	 */
	public List<VMachine> getVmList() {
		return vmList;
	}


	/**
	 * �����Ϣ�趨
	 * @param vmList �����Ϣ
	 */
	public void setVmList(List<VMachine> vmList) {
		this.vmList = vmList;
	}


	/**
	 * �������ȡ��
	 * @return vmname �������
	 */
	public String getVmname() {
		return vmname;
	}


	/**
	 * ��������趨
	 * @param vmname �������
	 */
	public void setVmname(String vmname) {
		this.vmname = vmname;
	}


	/**
	 * ���״̬ȡ��
	 * @return powerState ���״̬
	 */
	public String getPowerState() {
		return powerState;
	}


	/**
	 * ���״̬�趨
	 * @param powerState ���״̬
	 */
	public void setPowerState(String powerState) {
		this.powerState = powerState;
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
	 * ��������ͳ��Mapȡ��
	 * @return vmReportMap ��������ͳ��Map
	 */
	public Map<String, Integer> getVmReportMap() {
		return vmReportMap;
	}


	/**
	 * ��������ͳ��Map�趨
	 * @param vmReportMap ��������ͳ��Map
	 */
	public void setVmReportMap(Map<String, Integer> vmReportMap) {
		this.vmReportMap = vmReportMap;
	}


	/**
	 * ��ά��������Mapȡ��
	 * @return prRecportMap ��ά��������Map
	 */
	public Map<String, Map<String, Integer>> getPrRecportMap() {
		return prRecportMap;
	}


	/**
	 * ��ά��������Map�趨
	 * @param prRecportMap ��ά��������Map
	 */
	public void setPrRecportMap(Map<String, Map<String, Integer>> prRecportMap) {
		this.prRecportMap = prRecportMap;
	}


    /**
     * ��ȡvcenter����
     * @return vcenter���� 
     */
    public Integer getVcid() {
        return vcid;
    }


    /**
     * ����vcenter����
     * @param vcid vcenter����
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }
}


