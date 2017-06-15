package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0301Form;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;

/**
 * 虚拟化资源调整业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR03DTO extends BaseDTO implements Serializable{
    
    /** 项目列表 */
    protected List<VIM02Info> vim02List;
    
    /** 虚拟化项目ID */
    protected String pid;
    
    /** 虚机信息 */
    protected String vmInfo_json;

    /** 用户信息 */
    protected User user;
    
    /** 资源调整画面FORM */
    protected IGVIR0301Form igvir0301Form;
    
    /**
     * 获取项目列表
     * @return 项目列表 
     */
    public List<VIM02Info> getVim02List() {
        return vim02List;
    }

    /**
     * 设置项目列表
     * @param vim02List 项目列表
     */
    public void setVim02List(List<VIM02Info> vim02List) {
        this.vim02List = vim02List;
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
     * 获取资源调整画面FORM
     * @return 资源调整画面FORM 
     */
    public IGVIR0301Form getIgvir0301Form() {
        return igvir0301Form;
    }

    /**
     * 设置资源调整画面FORM
     * @param igvir0301Form 资源调整画面FORM
     */
    public void setIgvir0301Form(IGVIR0301Form igvir0301Form) {
        this.igvir0301Form = igvir0301Form;
    }
    
    
}
