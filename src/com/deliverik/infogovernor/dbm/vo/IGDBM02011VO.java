/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;

/**
 * ȫ��IP��ַ������Ϣ�������VO
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public class IGDBM02011VO extends BaseVO implements Serializable{
	
	/** ȫ��IP��ַ������Ϣ */
	protected List<Ip_FilterInfo> ipFilterInfoList;

    /**
     * ȫ��IP��ַ������Ϣ is returned.
     * @return ipFilterInfoList
     */
    public List<Ip_FilterInfo> getIpFilterInfoList() {
        return ipFilterInfoList;
    }

    /**
     * ȫ��IP��ַ������Ϣ is set.
     * @param ipFilterInfoList ȫ��IP��ַ������Ϣ
     */
    public void setIpFilterInfoList(List<Ip_FilterInfo> ipFilterInfoList) {
        this.ipFilterInfoList = ipFilterInfoList;
    }
	
}


