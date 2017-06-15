/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.bl.task.Ip_FilterBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM11DTO;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;

/**
 * @概述 全网IP地址过滤BL
 * @功能描述 1.
 * @创建记录：2012/11/07
 * @version 1.0
 */

public class IGDBM11BLImpl extends BaseBLImpl implements IGDBM11BL {
	
	static Log log = LogFactory.getLog(IGDBM11BLImpl.class);

	/** IP地址过滤BL */
	public Ip_FilterBL ip_filterBL;
	
	/**
     * IP地址过滤BL is returned.
     * @return ip_filterBL
     */
    public Ip_FilterBL getIp_filterBL() {
        return ip_filterBL;
    }

    /**
     * IP地址过滤BL is set.
     * @param ip_filterBL IP地址过滤BL
     */
    public void setIp_filterBL(Ip_FilterBL ip_filterBL) {
        this.ip_filterBL = ip_filterBL;
    }

    /** IP信息查询
     * @param dto
     */
    public IGDBM11DTO searchIp_FilterInfo(IGDBM11DTO dto) throws BLException {
        List<Ip_FilterInfo> ipFilterInfoList = ip_filterBL.searchIp_Filter();
        dto.setIpFilterInfoList(ipFilterInfoList);
        return dto;
    }

    /**
     * 新增IP过滤信息
     */
    public IGDBM11DTO addIpFilterInfo(IGDBM11DTO dto) throws BLException {
        ip_filterBL.registIp_Filter(dto.getIgdbm0201Form());
        dto.addMessage(new ActionMessage("IGDBM0201.I001"));
        return dto;
    }

    /**
     * 删除IP过滤信息
     */
    public IGDBM11DTO delIpFilterInfo(IGDBM11DTO dto) throws BLException {
        ip_filterBL.deleteIp_FilterByPK(Integer.parseInt(dto.getId()));
        dto.addMessage(new ActionMessage("IGDBM0201.I002"));
        return dto;
    }

    /**
     * 批量删除IP过滤信息
     */
	public IGDBM11DTO BatchdelIpFilterInfo(IGDBM11DTO dto) throws BLException {
		if(dto.getIgdbm0201Form()!=null){
			if(dto.getIgdbm0201Form().getDeleteID()!=null){
				for (String strID : dto.getIgdbm0201Form().getDeleteID()) {
					ip_filterBL.deleteIp_FilterByPK(Integer.parseInt(strID));
				}
				dto.addMessage(new ActionMessage("IGDBM0201.I002"));
			}
		}
		return dto;
	}
}

