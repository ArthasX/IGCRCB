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
public class IGCIC0203Form extends BaseForm {

    /** ��������������� */
    protected Integer coid;
    
    /** �ȶ���������� */
    protected Integer cpid;

    /** 
     * ��������������� ȡ��
     * @return coid ��������������� 
     */
    public Integer getCoid() {
        return coid;
    }

    /** 
     * ��������������� �趨
     * @param coid ��������������� 
     */
    public void setCoid(Integer coid) {
        this.coid = coid;
    }

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
