/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����Ԥ��Form
 *
 */
@SuppressWarnings("serial")
public class PreviewPdfForm extends BaseForm {
    /** ����ID */
    protected Integer prid;
    
    /** ���̶���ID */
    protected String pdid;

    /**
     * @return the ����ID
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * @param ����ID the prid to set
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * @return the ���̶���ID
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param ���̶���ID the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }
	
}