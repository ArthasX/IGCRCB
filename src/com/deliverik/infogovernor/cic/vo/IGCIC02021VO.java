/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����һ���Աȶ�_�ԱȽ���鿴����VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02021VO extends BaseVO implements Serializable{
    /** �ȶԽ��Map */
    protected Map<String, List<IGCIC02022VO>> resultVoMap;

    /** 
     * �ȶԽ��Map ȡ��
     * @return resultVoMap �ȶԽ��Map 
     */
    public Map<String, List<IGCIC02022VO>> getResultVoMap() {
        return resultVoMap;
    }

    /** 
     * �ȶԽ��Map �趨
     * @param resultVoMap �ȶԽ��Map 
     */
    public void setResultVoMap(Map<String, List<IGCIC02022VO>> resultVoMap) {
        this.resultVoMap = resultVoMap;
    }
}


