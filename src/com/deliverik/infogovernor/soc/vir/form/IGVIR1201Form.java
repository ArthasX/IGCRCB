/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դ�������Form
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1201Form extends BaseForm{

    /** �������� */
	protected String hostname;

    /**
     * ��ȡ��������
     * @return �������� 
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * ������������
     * @param hostname ��������
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
	
}
