/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @���� ȫ��IP��ַ����BL
 * @�������� 1.
 * @������¼��2012/11/07
 * @version 1.0
 */

public class IGDBM11BLImpl extends BaseBLImpl implements IGDBM11BL {
	
	static Log log = LogFactory.getLog(IGDBM11BLImpl.class);

	/** IP��ַ����BL */
	public Ip_FilterBL ip_filterBL;
	
	/**
     * IP��ַ����BL is returned.
     * @return ip_filterBL
     */
    public Ip_FilterBL getIp_filterBL() {
        return ip_filterBL;
    }

    /**
     * IP��ַ����BL is set.
     * @param ip_filterBL IP��ַ����BL
     */
    public void setIp_filterBL(Ip_FilterBL ip_filterBL) {
        this.ip_filterBL = ip_filterBL;
    }

    /** IP��Ϣ��ѯ
     * @param dto
     */
    public IGDBM11DTO searchIp_FilterInfo(IGDBM11DTO dto) throws BLException {
        List<Ip_FilterInfo> ipFilterInfoList = ip_filterBL.searchIp_Filter();
        dto.setIpFilterInfoList(ipFilterInfoList);
        return dto;
    }

    /**
     * ����IP������Ϣ
     */
    public IGDBM11DTO addIpFilterInfo(IGDBM11DTO dto) throws BLException {
        ip_filterBL.registIp_Filter(dto.getIgdbm0201Form());
        dto.addMessage(new ActionMessage("IGDBM0201.I001"));
        return dto;
    }

    /**
     * ɾ��IP������Ϣ
     */
    public IGDBM11DTO delIpFilterInfo(IGDBM11DTO dto) throws BLException {
        ip_filterBL.deleteIp_FilterByPK(Integer.parseInt(dto.getId()));
        dto.addMessage(new ActionMessage("IGDBM0201.I002"));
        return dto;
    }

    /**
     * ����ɾ��IP������Ϣ
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

