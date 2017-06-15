package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;



/**
 * 全网IP过滤Form
 * IGDBM0201Form ActionForm
 */
public class IGDBM0201Form extends BaseForm implements Ip_FilterInfo {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /** IP地址 */
	public String ip;

	/** 添加时间 */
    private String addtime;

    private Integer id;

    private String fingerPrint;
    
    private String[] deleteID;

    /**
     * IP地址 is returned.
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * IP地址 is set.
     * @param ip IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 添加时间 is returned.
     * @return addtime
     */
    public String getAddtime() {
        return addtime;
    }

    /**
     * 添加时间 is set.
     * @param addtime 添加时间
     */
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Integer getId() {
        return id;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    /**
     * id is set.
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * fingerPrint is set.
     * @param fingerPrint fingerPrint
     */
    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

	/**
	 * deleteID取得
	 *
	 * @return deleteID deleteID
	 */
	public String[] getDeleteID() {
		return deleteID;
	}

	/**
	 * deleteID设定
	 *
	 * @param deleteID deleteID
	 */
	public void setDeleteID(String[] deleteID) {
		this.deleteID = deleteID;
	}
	
}
