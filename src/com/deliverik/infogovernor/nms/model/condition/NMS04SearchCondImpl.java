/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��Ϣʵ���ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS04SearchCondImpl implements NMS04SearchCond{

    /** ��ID */
    protected Integer gid;

    /** ��汾 */
    protected Integer gversion;

    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * ������ID
     * @param gid ��ID
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * ��ȡ��汾
     * @return ��汾 
     */
    public Integer getGversion() {
        return gversion;
    }

    /**
     * ������汾
     * @param gversion ��汾
     */
    public void setGversion(Integer gversion) {
        this.gversion = gversion;
    }
    
}
