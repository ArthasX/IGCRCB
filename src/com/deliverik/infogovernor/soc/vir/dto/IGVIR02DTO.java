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
 * 虚拟化资源管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR02DTO extends BaseDTO implements Serializable{
    
    /** vCenter连接地址 */
    protected String vCenterUrl;
    
    /** vCenter用户名 */
    protected String vCenterUsername;
    
    /** vCenter密码 */
    protected String vCenterPassword;

    /** 模板信息Json串 */
    protected String templateJson;
    
    /** 资源申请画面FORM */
    protected IGVIR0201Form igvir0201Form;
    
    /** 资源申请审批画面FORM */
    protected IGVIR0202Form igvir0202Form;
    
    /** 虚拟化项目信息 */
    protected VIM02Info vim02info;
    
    /** 虚拟化项目ID */
    protected String pid;
    
    /** 虚机信息 */
    protected String vmInfo_json;
    
    /** vCenter主键 */
    protected Integer vcid;
    
    /** Host列表json对象 */
    protected String hostlist_json;
    
    /** 主机IP */
    protected String hostip;
    
    /** 网络json对象 */
    protected String netLabel_json;
    
    /** 虚机信息 */
    protected List<VIM03Info> vim03List;
    
    /** 数据中心json */
    protected String datacenter_json;
    
    /** 资源池json */
    protected String resourcePool_json;
    
    /** 用户信息 */
    protected User user;
    
    /** 部署日志json */
    protected String deployLog_json;
    
    /** 虚机id字符串 */
    protected String vmids;
    
    /** 所属流程主键 */
    protected Integer prid;
    
    /** 数据中心名称 */
    protected String dcname;
    
    /**
     * 获取vCenter连接地址
     * @return vCenter连接地址 
     */
    public String getvCenterUrl() {
        return vCenterUrl;
    }

    /**
     * 设置vCenter连接地址
     * @param vCenterUrl vCenter连接地址
     */
    public void setvCenterUrl(String vCenterUrl) {
        this.vCenterUrl = vCenterUrl;
    }

    /**
     * 获取vCenter用户名
     * @return vCenter用户名 
     */
    public String getvCenterUsername() {
        return vCenterUsername;
    }

    /**
     * 设置vCenter用户名
     * @param vCenterUsername vCenter用户名
     */
    public void setvCenterUsername(String vCenterUsername) {
        this.vCenterUsername = vCenterUsername;
    }

    /**
     * 获取vCenter密码
     * @return vCenter密码 
     */
    public String getvCenterPassword() {
        return vCenterPassword;
    }

    /**
     * 设置vCenter密码
     * @param vCenterPassword vCenter密码
     */
    public void setvCenterPassword(String vCenterPassword) {
        this.vCenterPassword = vCenterPassword;
    }

    /**
     * 获取模板信息Json串
     * @return 模板信息Json串 
     */
    public String getTemplateJson() {
        return templateJson;
    }

    /**
     * 设置模板信息Json串
     * @param templateJson 模板信息Json串
     */
    public void setTemplateJson(String templateJson) {
        this.templateJson = templateJson;
    }

    /**
     * 获取资源申请画面FORM
     * @return 资源申请画面FORM 
     */
    public IGVIR0201Form getIgvir0201Form() {
        return igvir0201Form;
    }

    /**
     * 设置资源申请画面FORM
     * @param igvir0201Form 资源申请画面FORM
     */
    public void setIgvir0201Form(IGVIR0201Form igvir0201Form) {
        this.igvir0201Form = igvir0201Form;
    }

    /**
     * 获取资源申请审批画面FORM
     * @return 资源申请审批画面FORM 
     */
    public IGVIR0202Form getIgvir0202Form() {
        return igvir0202Form;
    }

    /**
     * 设置资源申请审批画面FORM
     * @param igvir0202Form 资源申请审批画面FORM
     */
    public void setIgvir0202Form(IGVIR0202Form igvir0202Form) {
        this.igvir0202Form = igvir0202Form;
    }

    /**
     * 获取虚拟化项目信息
     * @return 虚拟化项目信息 
     */
    public VIM02Info getVim02info() {
        return vim02info;
    }

    /**
     * 设置虚拟化项目信息
     * @param vim02info 虚拟化项目信息
     */
    public void setVim02info(VIM02Info vim02info) {
        this.vim02info = vim02info;
    }

    /**
     * 获取虚拟化项目ID
     * @return 虚拟化项目ID 
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置虚拟化项目ID
     * @param pid 虚拟化项目ID
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 获取虚机信息
     * @return 虚机信息 
     */
    public String getVmInfo_json() {
        return vmInfo_json;
    }

    /**
     * 设置虚机信息
     * @param vmInfo_json 虚机信息
     */
    public void setVmInfo_json(String vmInfo_json) {
        this.vmInfo_json = vmInfo_json;
    }

    /**
     * 获取vCenter主键
     * @return vCenter主键 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * 设置vCenter主键
     * @param vcid vCenter主键
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    /**
     * 获取Host列表json对象
     * @return Host列表json对象 
     */
    public String getHostlist_json() {
        return hostlist_json;
    }

    /**
     * 设置Host列表json对象
     * @param hostlist_json Host列表json对象
     */
    public void setHostlist_json(String hostlist_json) {
        this.hostlist_json = hostlist_json;
    }

    /**
     * 获取主机IP
     * @return 主机IP 
     */
    public String getHostip() {
        return hostip;
    }

    /**
     * 设置主机IP
     * @param hostip 主机IP
     */
    public void setHostip(String hostip) {
        this.hostip = hostip;
    }

    /**
     * 获取网络json对象
     * @return 网络json对象 
     */
    public String getNetLabel_json() {
        return netLabel_json;
    }

    /**
     * 设置网络json对象
     * @param netLabel_json 网络json对象
     */
    public void setNetLabel_json(String netLabel_json) {
        this.netLabel_json = netLabel_json;
    }
    
    /**
     * 虚机信息取得
     * @return vim03List 虚机信息
     */
    public List<VIM03Info> getVim03List() {
        return vim03List;
    }

    /**
     * 虚机信息设定
     * @param vim03List 虚机信息
     */
    public void setVim03List(List<VIM03Info> vim03List) {
        this.vim03List = vim03List;
    }

    /**
     * 获取数据中心json
     * @return 数据中心json 
     */
    public String getDatacenter_json() {
        return datacenter_json;
    }

    /**
     * 设置数据中心json
     * @param datacenter_json 数据中心json
     */
    public void setDatacenter_json(String datacenter_json) {
        this.datacenter_json = datacenter_json;
    }

    /**
     * 获取资源池json
     * @return 资源池json 
     */
    public String getResourcePool_json() {
        return resourcePool_json;
    }

    /**
     * 设置资源池json
     * @param resourcePool_json 资源池json
     */
    public void setResourcePool_json(String resourcePool_json) {
        this.resourcePool_json = resourcePool_json;
    }

    /**
     * 获取用户信息
     * @return 用户信息 
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置用户信息
     * @param user 用户信息
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取部署日志json
     * @return 部署日志json 
     */
    public String getDeployLog_json() {
        return deployLog_json;
    }

    /**
     * 设置部署日志json
     * @param deployLog_json 部署日志json
     */
    public void setDeployLog_json(String deployLog_json) {
        this.deployLog_json = deployLog_json;
    }

    /**
     * 获取虚机id字符串
     * @return 虚机id字符串 
     */
    public String getVmids() {
        return vmids;
    }

    /**
     * 设置虚机id字符串
     * @param vmids 虚机id字符串
     */
    public void setVmids(String vmids) {
        this.vmids = vmids;
    }

    /**
     * 获取所属流程主键
     * @return 所属流程主键 
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * 设置所属流程主键
     * @param prid 所属流程主键
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * 获取数据中心名称
     * @return 数据中心名称 
     */
    public String getDcname() {
        return dcname;
    }

    /**
     * 设置数据中心名称
     * @param dcname 数据中心名称
     */
    public void setDcname(String dcname) {
        this.dcname = dcname;
    }
    
}
