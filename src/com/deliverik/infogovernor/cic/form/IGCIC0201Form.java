/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.form;

import com.deliverik.framework.base.BaseForm;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����һ���Աȶ�_�Ա�ִ�������ѯ����FORM
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC0201Form extends BaseForm {
	
    /** ��ʼʱ��Form */
    protected String cpstarttime_form;
    
    /** ��ʼʱ��To */
    protected String cpstarttime_to;

    /** 
     * ��ʼʱ��Form ȡ��
     * @return cpstarttime_form ��ʼʱ��Form 
     */
    public String getCpstarttime_form() {
        return cpstarttime_form;
    }

    /** 
     * ��ʼʱ��Form �趨
     * @param cpstarttime_form ��ʼʱ��Form 
     */
    public void setCpstarttime_form(String cpstarttime_form) {
        this.cpstarttime_form = cpstarttime_form;
    }

    /** 
     * ��ʼʱ��To ȡ��
     * @return cpstarttime_to ��ʼʱ��To 
     */
    public String getCpstarttime_to() {
        return cpstarttime_to;
    }

    /** 
     * ��ʼʱ��To �趨
     * @param cpstarttime_to ��ʼʱ��To 
     */
    public void setCpstarttime_to(String cpstarttime_to) {
        this.cpstarttime_to = cpstarttime_to;
    }
    
}
