/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����һ���Աȶ�_�Ա�ִ�������ѯ����VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02011VO extends BaseVO implements Serializable{
	
    /** �Աȼ�¼���� */
    protected List<CompareprocessInfo> compareprocessList;

    /** 
     * �Աȼ�¼���� ȡ��
     * @return compareprocessList �Աȼ�¼���� 
     */
    public List<CompareprocessInfo> getCompareprocessList() {
        return compareprocessList;
    }

    /** 
     * �Աȼ�¼���� �趨
     * @param compareprocessList �Աȼ�¼���� 
     */
    public void setCompareprocessList(List<CompareprocessInfo> compareprocessList) {
        this.compareprocessList = compareprocessList;
    }

	
}


