/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;

/**
 * �ճ�ά����ѯ
 */
public class IGDUT03051VO extends BaseVO implements Serializable{

    /**  */
    private static final long serialVersionUID = 1L;
    
    /** �ճ�ά���Ǽ��б� */
    List<OnDutyPersonRecordInfo> onDutyPersonRecordInfoList;
    
    /** ���������б� */
    List<CodeDetail> codeDetailList;

    /**
	 * ���������б�ȡ��
	 *
	 * @return codeDetailList ���������б�
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * ���������б��趨
	 *
	 * @param codeDetailList ���������б�
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/**
     * �ճ�ά���Ǽ��б�ȡ��
     *
     * @return onDutyPersonRecordInfoList �ճ�ά���Ǽ��б�
     */
    public List<OnDutyPersonRecordInfo> getOnDutyPersonRecordInfoList() {
        return onDutyPersonRecordInfoList;
    }

    /**
     * �ճ�ά���Ǽ��б��趨
     *
     * @param onDutyPersonRecordInfoList �ճ�ά���Ǽ��б�
     */
    public void setOnDutyPersonRecordInfoList(
            List<OnDutyPersonRecordInfo> onDutyPersonRecordInfoList) {
        this.onDutyPersonRecordInfoList = onDutyPersonRecordInfoList;
    }

}
