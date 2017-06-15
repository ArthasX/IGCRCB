/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ����״̬��Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD01041VO extends BaseVO implements Serializable{
	
	/** ����״̬��Ϣ������� */
	protected List<IG333Info> processStatusDefList;
	
	protected String imgxml;

	
	public String getImgxml() {
		return imgxml;
	}

	public void setImgxml(String imgxml) {
		this.imgxml = imgxml;
	}

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		if(processStatusDefList != null) {
			List<IG333Info> lst_IG333Info = new ArrayList<IG333Info>();
			for(IG333Info bean : processStatusDefList) {
				if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(bean.getPsdcode())) {
					lst_IG333Info.add(bean);
					break;
				}
			}
			for(IG333Info bean : processStatusDefList) {
				if(!IGPRDCONSTANTS.PROCESS_START_STATUS.equals(bean.getPsdcode())) {
					lst_IG333Info.add(bean);
				}
			}
			this.processStatusDefList = lst_IG333Info;
		} else {
			this.processStatusDefList = processStatusDefList;
		}
	}

}


