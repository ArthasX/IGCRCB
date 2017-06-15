/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * 审计管理Form
 *
 * @author 
 */
@SuppressWarnings("serial")
public class IGIAM0503Form extends BaseForm implements Serializable {
    
    protected String bkmode;

    protected String prcorid;
    

    /**
     * prcorid取得
     *
     * @return prcorid prcorid
     */
    public String getPrcorid() {
        return prcorid;
    }

    /**
     * prcorid设定
     *
     * @param prcorid prcorid
     */
    public void setPrcorid(String prcorid) {
        this.prcorid = prcorid;
    }

    /**
     * bkmode取得
     *
     * @return bkmode bkmode
     */
    public String getBkmode() {
        return bkmode;
    }

    /**
     * bkmode设定
     *
     * @param bkmode bkmode
     */
    public void setBkmode(String bkmode) {
        this.bkmode = bkmode;
    }
    
    
    
}
