/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����: �ճ�ά���Ǽ�ʵ��ӿ�
 * ��������: �ճ�ά���Ǽ�ʵ��ӿ�
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
public interface OnDutyPersonRecordInfo extends BaseModel{
    
    /**
     * �ճ�ά���Ǽ�����IDȡ��
     * @return �ճ�ά���Ǽ�����ID
     */
    public Integer getOdprid();
    
    /**
     * �ճ�ά���Ǽ�������Աȡ��
     * @return �ճ�ά���Ǽ�������Աȡ��
     */
    public String getOdprguest();
    
    /**
     * �ճ�ά���Ǽǵ�λȡ��
     * @return �ճ�ά���Ǽǵ�λȡ��
     */
    public String getOdprguestorg();
    
    /**
     * �ճ�ά���Ǽ��������ȡ��
     * @return �ճ�ά���Ǽ��������ȡ��
     */
    public String getOdprguestidnum();
    
    /**
     * �ճ�ά���Ǽ����ý�������ȡ��
     * @return �ճ�ά���Ǽ����ý�������ȡ��
     */
    public String getOdprarea();
    
    /**
     * �ճ�ά���Ǽ���������ʱ��ȡ��
     * @return �ճ�ά���Ǽ���������ʱ��ȡ��
     */
    public String getOdprctime();
    
    /**
     * �ճ�ά���Ǽ���������ʱ��ȡ��
     * @return �ճ�ά���Ǽ���������ʱ��ȡ��
     */
    public String getOdprltime();
    
    /**
     * �ճ�ά���Ǽǲ�����ȡ��
     * @return �ճ�ά���Ǽǲ�����ȡ��
     */
    public String getOdpropter();
    
    /**
     * �ճ�ά���Ǽ���׼��ȡ��
     * @return �ճ�ά���Ǽ���׼��ȡ��
     */
    public String getOdpracter();
    
    /**
     * �ճ�ά���ǼǼ�¼��ȡ��
     * @return �ճ�ά���ǼǼ�¼��ȡ��
     */
    public String getOdprusername();
    
    /**
     * �ճ�ά���Ǽǲ���Ŀ��ȡ��
     * @return �ճ�ά���Ǽǲ���Ŀ��ȡ��
     */
    public String getOdprtarget();
    
    /**
     * �ճ�ά���Ǽǲ�����¼ȡ��
     * @return �ճ�ά���Ǽǲ�����¼ȡ��
     */
    public String getOdprrecord();
    
    /**
     * �ճ�ά���Ǽ�¼��ʱ��ȡ��
     * @return �ճ�ά���Ǽ�¼��ʱ��ȡ��
     */
    public String getOdprinserttime();
    
    /**
     * �ճ�ά���ǼǱ༭��¼ȡ��
     * @return �ճ�ά���ǼǱ༭��¼ȡ��
     */
    public String getOdprmodtime();
}
