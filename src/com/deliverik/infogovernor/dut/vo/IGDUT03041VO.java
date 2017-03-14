/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;

/**
 * 日常维护登记
 */
public class IGDUT03041VO extends BaseVO implements Serializable{

    /**  */
    private static final long serialVersionUID = 1L;
    
    /** 日常维护登记列表 */
    List<OnDutyPersonRecordInfo> onDutyPersonRecordInfoList;
    
    /** 进入区域列表 */
    List<CodeDetail> codeDetailList;

    /**
	 * 进入区域列表取得
	 *
	 * @return codeDetailList 进入区域列表
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * 进入区域列表设定
	 *
	 * @param codeDetailList 进入区域列表
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/**
     * 日常维护登记列表取得
     *
     * @return onDutyPersonRecordInfoList 日常维护登记列表
     */
    public List<OnDutyPersonRecordInfo> getOnDutyPersonRecordInfoList() {
        return onDutyPersonRecordInfoList;
    }

    /**
     * 日常维护登记列表设定
     *
     * @param onDutyPersonRecordInfoList 日常维护登记列表
     */
    public void setOnDutyPersonRecordInfoList(
            List<OnDutyPersonRecordInfo> onDutyPersonRecordInfoList) {
        this.onDutyPersonRecordInfoList = onDutyPersonRecordInfoList;
    }
}
