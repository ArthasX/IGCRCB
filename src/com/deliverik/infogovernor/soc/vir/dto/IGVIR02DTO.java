package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0201Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0202Form;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * ���⻯��Դ����ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR02DTO extends BaseDTO implements Serializable{
    
    /** vCenter���ӵ�ַ */
    protected String vCenterUrl;
    
    /** vCenter�û��� */
    protected String vCenterUsername;
    
    /** vCenter���� */
    protected String vCenterPassword;

    /** ģ����ϢJson�� */
    protected String templateJson;
    
    /** ��Դ���뻭��FORM */
    protected IGVIR0201Form igvir0201Form;
    
    /** ��Դ������������FORM */
    protected IGVIR0202Form igvir0202Form;
    
    /** ���⻯��Ŀ��Ϣ */
    protected VIM02Info vim02info;
    
    /** ���⻯��ĿID */
    protected String pid;
    
    /** �����Ϣ */
    protected String vmInfo_json;
    
    /** vCenter���� */
    protected Integer vcid;
    
    /** Host�б�json���� */
    protected String hostlist_json;
    
    /** ����IP */
    protected String hostip;
    
    /** ����json���� */
    protected String netLabel_json;
    
    /** �����Ϣ */
    protected List<VIM03Info> vim03List;
    
    /** ��������json */
    protected String datacenter_json;
    
    /** ��Դ��json */
    protected String resourcePool_json;
    
    /** �û���Ϣ */
    protected User user;
    
    /** ������־json */
    protected String deployLog_json;
    
    /** ���id�ַ��� */
    protected String vmids;
    
    /** ������������ */
    protected Integer prid;
    
    /** ������������ */
    protected String dcname;
    
    /**
     * ��ȡvCenter���ӵ�ַ
     * @return vCenter���ӵ�ַ 
     */
    public String getvCenterUrl() {
        return vCenterUrl;
    }

    /**
     * ����vCenter���ӵ�ַ
     * @param vCenterUrl vCenter���ӵ�ַ
     */
    public void setvCenterUrl(String vCenterUrl) {
        this.vCenterUrl = vCenterUrl;
    }

    /**
     * ��ȡvCenter�û���
     * @return vCenter�û��� 
     */
    public String getvCenterUsername() {
        return vCenterUsername;
    }

    /**
     * ����vCenter�û���
     * @param vCenterUsername vCenter�û���
     */
    public void setvCenterUsername(String vCenterUsername) {
        this.vCenterUsername = vCenterUsername;
    }

    /**
     * ��ȡvCenter����
     * @return vCenter���� 
     */
    public String getvCenterPassword() {
        return vCenterPassword;
    }

    /**
     * ����vCenter����
     * @param vCenterPassword vCenter����
     */
    public void setvCenterPassword(String vCenterPassword) {
        this.vCenterPassword = vCenterPassword;
    }

    /**
     * ��ȡģ����ϢJson��
     * @return ģ����ϢJson�� 
     */
    public String getTemplateJson() {
        return templateJson;
    }

    /**
     * ����ģ����ϢJson��
     * @param templateJson ģ����ϢJson��
     */
    public void setTemplateJson(String templateJson) {
        this.templateJson = templateJson;
    }

    /**
     * ��ȡ��Դ���뻭��FORM
     * @return ��Դ���뻭��FORM 
     */
    public IGVIR0201Form getIgvir0201Form() {
        return igvir0201Form;
    }

    /**
     * ������Դ���뻭��FORM
     * @param igvir0201Form ��Դ���뻭��FORM
     */
    public void setIgvir0201Form(IGVIR0201Form igvir0201Form) {
        this.igvir0201Form = igvir0201Form;
    }

    /**
     * ��ȡ��Դ������������FORM
     * @return ��Դ������������FORM 
     */
    public IGVIR0202Form getIgvir0202Form() {
        return igvir0202Form;
    }

    /**
     * ������Դ������������FORM
     * @param igvir0202Form ��Դ������������FORM
     */
    public void setIgvir0202Form(IGVIR0202Form igvir0202Form) {
        this.igvir0202Form = igvir0202Form;
    }

    /**
     * ��ȡ���⻯��Ŀ��Ϣ
     * @return ���⻯��Ŀ��Ϣ 
     */
    public VIM02Info getVim02info() {
        return vim02info;
    }

    /**
     * �������⻯��Ŀ��Ϣ
     * @param vim02info ���⻯��Ŀ��Ϣ
     */
    public void setVim02info(VIM02Info vim02info) {
        this.vim02info = vim02info;
    }

    /**
     * ��ȡ���⻯��ĿID
     * @return ���⻯��ĿID 
     */
    public String getPid() {
        return pid;
    }

    /**
     * �������⻯��ĿID
     * @param pid ���⻯��ĿID
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * ��ȡ�����Ϣ
     * @return �����Ϣ 
     */
    public String getVmInfo_json() {
        return vmInfo_json;
    }

    /**
     * ���������Ϣ
     * @param vmInfo_json �����Ϣ
     */
    public void setVmInfo_json(String vmInfo_json) {
        this.vmInfo_json = vmInfo_json;
    }

    /**
     * ��ȡvCenter����
     * @return vCenter���� 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * ����vCenter����
     * @param vcid vCenter����
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    /**
     * ��ȡHost�б�json����
     * @return Host�б�json���� 
     */
    public String getHostlist_json() {
        return hostlist_json;
    }

    /**
     * ����Host�б�json����
     * @param hostlist_json Host�б�json����
     */
    public void setHostlist_json(String hostlist_json) {
        this.hostlist_json = hostlist_json;
    }

    /**
     * ��ȡ����IP
     * @return ����IP 
     */
    public String getHostip() {
        return hostip;
    }

    /**
     * ��������IP
     * @param hostip ����IP
     */
    public void setHostip(String hostip) {
        this.hostip = hostip;
    }

    /**
     * ��ȡ����json����
     * @return ����json���� 
     */
    public String getNetLabel_json() {
        return netLabel_json;
    }

    /**
     * ��������json����
     * @param netLabel_json ����json����
     */
    public void setNetLabel_json(String netLabel_json) {
        this.netLabel_json = netLabel_json;
    }
    
    /**
     * �����Ϣȡ��
     * @return vim03List �����Ϣ
     */
    public List<VIM03Info> getVim03List() {
        return vim03List;
    }

    /**
     * �����Ϣ�趨
     * @param vim03List �����Ϣ
     */
    public void setVim03List(List<VIM03Info> vim03List) {
        this.vim03List = vim03List;
    }

    /**
     * ��ȡ��������json
     * @return ��������json 
     */
    public String getDatacenter_json() {
        return datacenter_json;
    }

    /**
     * ������������json
     * @param datacenter_json ��������json
     */
    public void setDatacenter_json(String datacenter_json) {
        this.datacenter_json = datacenter_json;
    }

    /**
     * ��ȡ��Դ��json
     * @return ��Դ��json 
     */
    public String getResourcePool_json() {
        return resourcePool_json;
    }

    /**
     * ������Դ��json
     * @param resourcePool_json ��Դ��json
     */
    public void setResourcePool_json(String resourcePool_json) {
        this.resourcePool_json = resourcePool_json;
    }

    /**
     * ��ȡ�û���Ϣ
     * @return �û���Ϣ 
     */
    public User getUser() {
        return user;
    }

    /**
     * �����û���Ϣ
     * @param user �û���Ϣ
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * ��ȡ������־json
     * @return ������־json 
     */
    public String getDeployLog_json() {
        return deployLog_json;
    }

    /**
     * ���ò�����־json
     * @param deployLog_json ������־json
     */
    public void setDeployLog_json(String deployLog_json) {
        this.deployLog_json = deployLog_json;
    }

    /**
     * ��ȡ���id�ַ���
     * @return ���id�ַ��� 
     */
    public String getVmids() {
        return vmids;
    }

    /**
     * �������id�ַ���
     * @param vmids ���id�ַ���
     */
    public void setVmids(String vmids) {
        this.vmids = vmids;
    }

    /**
     * ��ȡ������������
     * @return ������������ 
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * ����������������
     * @param prid ������������
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * ��ȡ������������
     * @return ������������ 
     */
    public String getDcname() {
        return dcname;
    }

    /**
     * ����������������
     * @param dcname ������������
     */
    public void setDcname(String dcname) {
        this.dcname = dcname;
    }
    
}
