package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0301Form;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;

/**
 * ���⻯��Դ����ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR03DTO extends BaseDTO implements Serializable{
    
    /** ��Ŀ�б� */
    protected List<VIM02Info> vim02List;
    
    /** ���⻯��ĿID */
    protected String pid;
    
    /** �����Ϣ */
    protected String vmInfo_json;

    /** �û���Ϣ */
    protected User user;
    
    /** ��Դ��������FORM */
    protected IGVIR0301Form igvir0301Form;
    
    /**
     * ��ȡ��Ŀ�б�
     * @return ��Ŀ�б� 
     */
    public List<VIM02Info> getVim02List() {
        return vim02List;
    }

    /**
     * ������Ŀ�б�
     * @param vim02List ��Ŀ�б�
     */
    public void setVim02List(List<VIM02Info> vim02List) {
        this.vim02List = vim02List;
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
     * ��ȡ��Դ��������FORM
     * @return ��Դ��������FORM 
     */
    public IGVIR0301Form getIgvir0301Form() {
        return igvir0301Form;
    }

    /**
     * ������Դ��������FORM
     * @param igvir0301Form ��Դ��������FORM
     */
    public void setIgvir0301Form(IGVIR0301Form igvir0301Form) {
        this.igvir0301Form = igvir0301Form;
    }
    
    
}
