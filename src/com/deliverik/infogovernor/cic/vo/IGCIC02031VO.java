/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

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
public class IGCIC02031VO extends BaseVO implements Serializable{

    /** ҳ����ʾ��Map key��ҳ����ʾ���� value����ʾ����Map key��ģ������ value�������б� */
    protected Map<String, Map<String, IGCIC02032VO>> cic0203ShowMap;

    /** 
     * ҳ����ʾ��Mapkey��ҳ����ʾ����value����ʾ����Mapkey��ģ������value�������б� ȡ��
     * @return cic0203ShowMap ҳ����ʾ��Mapkey��ҳ����ʾ����value����ʾ����Mapkey��ģ������value�������б� 
     */
    public Map<String, Map<String, IGCIC02032VO>> getCic0203ShowMap() {
        return cic0203ShowMap;
    }

    /** 
     * ҳ����ʾ��Mapkey��ҳ����ʾ����value����ʾ����Mapkey��ģ������value�������б� �趨
     * @param cic0203ShowMap ҳ����ʾ��Mapkey��ҳ����ʾ����value����ʾ����Mapkey��ģ������value�������б� 
     */
    public void setCic0203ShowMap(Map<String, Map<String, IGCIC02032VO>> cic0203ShowMap) {
        this.cic0203ShowMap = cic0203ShowMap;
    }
    
}


