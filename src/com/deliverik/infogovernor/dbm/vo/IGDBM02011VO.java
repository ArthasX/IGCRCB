/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;

/**
 * 全网IP地址过滤信息检索结果VO
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public class IGDBM02011VO extends BaseVO implements Serializable{
	
	/** 全网IP地址过滤信息 */
	protected List<Ip_FilterInfo> ipFilterInfoList;

    /**
     * 全网IP地址过滤信息 is returned.
     * @return ipFilterInfoList
     */
    public List<Ip_FilterInfo> getIpFilterInfoList() {
        return ipFilterInfoList;
    }

    /**
     * 全网IP地址过滤信息 is set.
     * @param ipFilterInfoList 全网IP地址过滤信息
     */
    public void setIpFilterInfoList(List<Ip_FilterInfo> ipFilterInfoList) {
        this.ipFilterInfoList = ipFilterInfoList;
    }
	
}


