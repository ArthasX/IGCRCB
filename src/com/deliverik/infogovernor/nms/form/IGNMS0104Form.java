/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���������ֶ�ɨ������form
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGNMS0104Form extends BaseForm {

	/** �ر��������� */
	protected String doClose;
	
	/** ��汾 */
	protected String gversion;
	
	/** ��������xml */
	protected String pushXML;

    /**
     * ��ȡ�ر���������
     * @return �ر��������� 
     */
    public String getDoClose() {
        return doClose;
    }

    /**
     * ���ùر���������
     * @param doClose �ر���������
     */
    public void setDoClose(String doClose) {
        this.doClose = doClose;
    }

    /**
     * ��ȡ��汾
     * @return ��汾 
     */
    public String getGversion() {
        return gversion;
    }

    /**
     * ������汾
     * @param gversion ��汾
     */
    public void setGversion(String gversion) {
        this.gversion = gversion;
    }

    /**
     * ��ȡ��������xml
     * @return ��������xml 
     */
    public String getPushXML() {
        return pushXML;
    }

    /**
     * ������������xml
     * @param pushXML ��������xml
     */
    public void setPushXML(String pushXML) {
        this.pushXML = pushXML;
    }
}
