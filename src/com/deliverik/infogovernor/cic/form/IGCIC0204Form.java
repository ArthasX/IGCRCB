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
 * Description: ����һ���Աȶ�_�ԱȽ����ϸ����FORM
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC0204Form extends BaseForm {

    /** �ȶԽ�������� */
    protected Integer crid;

    /** 
     * �ȶԽ�������� ȡ��
     * @return crid �ȶԽ�������� 
     */
    public Integer getCrid() {
        return crid;
    }

    /** 
     * �ȶԽ�������� �趨
     * @param crid �ȶԽ�������� 
     */
    public void setCrid(Integer crid) {
        this.crid = crid;
    }
    
    
}
