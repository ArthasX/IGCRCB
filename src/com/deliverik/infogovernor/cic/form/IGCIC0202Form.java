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
public class IGCIC0202Form extends BaseForm {
    
    /** �ȶ���������� */
    protected Integer cpid;

    /** 
     * �ȶ���������� ȡ��
     * @return cpid �ȶ���������� 
     */
    public Integer getCpid() {
        return cpid;
    }

    /** 
     * �ȶ���������� �趨
     * @param cpid �ȶ���������� 
     */
    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }
    
    
}
