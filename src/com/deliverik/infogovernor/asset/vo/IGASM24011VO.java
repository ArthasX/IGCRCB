package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * ��Ʊ��Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM24011VO extends BaseVO implements Serializable{
    
    /** ��Ʊ��Ϣ������� */
    protected List<IG688Info> entityDataList;

    /**
     * ���캯��
     * @param entityData����Ʊ��Ϣ�������
     */
    public IGASM24011VO(List<IG688Info> entityDataList) {
        this.entityDataList = entityDataList;
    }
    
    /**
     * ��Ʊ��Ϣ�������ȡ��
     * @return �ʲ�����Ϣ�������
     */
    public List<IG688Info> getEntityDataList() {
        return entityDataList;
    }

}


