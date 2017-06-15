/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.dbm.form.IGDBM0201Form;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;

public class IGDBM11DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	

	/** 过滤IP地址信息 */
    private List<Ip_FilterInfo> ipFilterInfoList;

    /** IGDBM0201Form */
    private IGDBM0201Form igdbm0201Form;


    private String id;


    /**
     * 过滤IP地址信息 is returned.
     * @return ipFilterInfoList
     */
    public List<Ip_FilterInfo> getIpFilterInfoList() {
        return ipFilterInfoList;
    }


    /**
     * 过滤IP地址信息 is set.
     * @param ipFilterInfoList 过滤IP地址信息
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