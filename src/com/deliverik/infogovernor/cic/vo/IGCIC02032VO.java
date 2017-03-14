/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����һ���Աȶ�_�ԱȽ����ϸ�鿴����VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02032VO extends BaseVO implements Serializable{

    public IGCIC02032VO() {
        this.crvwLst = new LinkedHashMap<String, List<CompareresultVWInfo>>();
    }
    
    /** �����б� */
    protected Map<String, List<CompareresultVWInfo>> crvwLst;
    
    /** �Ƿ�Ϊ�������� 0������ 1���� */
    protected Integer isBase;

    /** 
     * �����б� ȡ��
     * @return crvwLst �����б� 
     */
    public Map<String, List<CompareresultVWInfo>> getCrvwLst() {
        return crvwLst;
    }

    /** 
     * �����б� �趨
     * @param crvwLst �����б� 
     */
    public void setCrvwLst(Map<String, List<CompareresultVWInfo>> crvwLst) {
        this.crvwLst = crvwLst;
    }

    /** 
     * �Ƿ�Ϊ��������0������1���� ȡ��
     * @return isBase �Ƿ�Ϊ��������0������1���� 
     */
    public Integer getIsBase() {
        return isBase;
    }

    /** 
     * �Ƿ�Ϊ��������0������1���� �趨
     * @param isBase �Ƿ�Ϊ��������0������1���� 
     */
    public void setIsBase(Integer isBase) {
        this.isBase = isBase;
    }

}


