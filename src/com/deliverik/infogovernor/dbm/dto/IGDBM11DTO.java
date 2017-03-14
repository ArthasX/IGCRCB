/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.dbm.form.IGDBM0201Form;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;

public class IGDBM11DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	

	/** ����IP��ַ��Ϣ */
    private List<Ip_FilterInfo> ipFilterInfoList;

    /** IGDBM0201Form */
    private IGDBM0201Form igdbm0201Form;


    private String id;


    /**
     * ����IP��ַ��Ϣ is returned.
     * @return ipFilterInfoList
     */
    public List<Ip_FilterInfo> getIpFilterInfoList() {
        return ipFilterInfoList;
    }


    /**
     * ����IP��ַ��Ϣ is set.
     * @param ipFilterInfoList ����IP��ַ��Ϣ
     */
    public void setIpFilterInfoList(List<Ip_FilterInfo> ipFilterInfoList) {
        this.ipFilterInfoList = ipFilterInfoList;
    }


    /**
     * 
     * @param form
     */
    public void setIgdbm0201Form(IGDBM0201Form igdbm0201Form) {
        this.igdbm0201Form = igdbm0201Form;
    }


    /**
     * IGDBM0201Form is returned.
     * @return igdbm0201Form
     */
    public IGDBM0201Form getIgdbm0201Form() {
        return igdbm0201Form;
    }


    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * id is returned.
     * @return id
     */
    public String getId() {
        return id;
    }

}