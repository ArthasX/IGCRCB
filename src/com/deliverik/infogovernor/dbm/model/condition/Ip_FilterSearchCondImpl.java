/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.condition;

/**
  * ����: ȫ��IP���˼�������ʵ��
  * ��������: ȫ��IP���˼�������ʵ��
  * ������¼: 2012/11/07
  * �޸ļ�¼: 
  */
public class Ip_FilterSearchCondImpl implements
		Ip_FilterSearchCond {

    /**IP��ַ��ѯ����*/
    private String ip;

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * IP��ַ��ѯ���� is returned.
     * @return ip
     */
    public String getIp() {
        return ip;
    }

}