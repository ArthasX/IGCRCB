/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * ��ƹ���Form
 *
 * @author 
 */
@SuppressWarnings("serial")
public class IGIAM0503Form extends BaseForm implements Serializable {
    
    protected String bkmode;

    protected String prcorid;
    

    /**
     * prcoridȡ��
     *
     * @return prcorid prcorid
     */
    public String getPrcorid() {
        return prcorid;
    }

    /**
     * prcorid�趨
     *
     * @param prcorid prcorid
     */
    public void setPrcorid(String prcorid) {
        this.prcorid = prcorid;
    }

    /**
     * bkmodeȡ��
     *
     * @return bkmode bkmode
     */
    public String getBkmode() {
        return bkmode;
    }

    /**
     * bkmode�趨
     *
     * @param bkmode bkmode
     */
    public void setBkmode(String bkmode) {
        this.bkmode = bkmode;
    }
    
    
    
}
