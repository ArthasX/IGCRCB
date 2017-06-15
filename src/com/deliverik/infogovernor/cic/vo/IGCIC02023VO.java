/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����һ���Աȶ�_����һ���Աȶ�_�ԱȽ���鿴����_��ʾ����VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02023VO extends BaseVO implements Serializable{
	
    /** ��������� */
    protected Integer coid;

    /** �������� */
    protected String hostname;
    
    /** �Ƿ�ͬ 0:��ͬ 1:��ͬ*/
    protected String isDifferent;

    /** 
     * ��������� ȡ��
     * @return coid ��������� 
     */
    public Integer getCoid() {
        return coid;
    }

    /** 
     * ��������� �趨
     * @param coid ��������� 
     */
    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    /** 
     * �������� ȡ��
     * @return hostname �������� 
     */
    public String getHostname() {
        return hostname;
    }

    /** 
     * �������� �趨
     * @param hostname �������� 
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /** 
     * �Ƿ�ͬ0:��ͬ1:��ͬ ȡ��
     * @return isDifferent �Ƿ�ͬ0:��ͬ1:��ͬ 
     */
    public String getIsDifferent() {
        return isDifferent;
    }

    /** 
     * �Ƿ�ͬ0:��ͬ1:��ͬ �趨
     * @param isDifferent �Ƿ�ͬ0:��ͬ1:��ͬ 
     */
    public void setIsDifferent(String isDifferent) {
        this.isDifferent = isDifferent;
    }
    
}


