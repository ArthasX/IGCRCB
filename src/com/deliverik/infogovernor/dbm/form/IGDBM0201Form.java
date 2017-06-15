package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;



/**
 * ȫ��IP����Form
 * IGDBM0201Form ActionForm
 */
public class IGDBM0201Form extends BaseForm implements Ip_FilterInfo {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /** IP��ַ */
	public String ip;

	/** ���ʱ�� */
    private String addtime;

    private Integer id;

    private String fingerPrint;
    
    private String[] deleteID;

    /**
     * IP��ַ is returned.
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * IP��ַ is set.
     * @param ip IP��ַ
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * ���ʱ�� is returned.
     * @return addtime
     */
    public String getAddtime() {
        return addtime;
    }

    /**
     * ���ʱ�� is set.
     * @param addtime ���ʱ��
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
	 * deleteIDȡ��
	 *
	 * @return deleteID deleteID
	 */
	public String[] getDeleteID() {
		return deleteID;
	}

	/**
	 * deleteID�趨
	 *
	 * @param deleteID deleteID
	 */
	public void setDeleteID(String[] deleteID) {
		this.deleteID = deleteID;
	}
	
}
