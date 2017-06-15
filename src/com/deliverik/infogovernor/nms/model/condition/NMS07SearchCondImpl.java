/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��·��Ϣʵ���ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS07SearchCondImpl implements NMS07SearchCond{


    /** ��ID */
    protected Integer gid;

    /** ��汾 */
    protected Integer gversion;

    /** ���˺����� */
    protected boolean filterBlacklist;
    
    /** �ϲ������� */
    protected boolean mergeWhitelist;
    
    /** �û�id */
    protected String userid;
    
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

    /**
     * ��ȡ���˺�����
     * @return ���˺����� 
     */
    public boolean isFilterBlacklist() {
        return filterBlacklist;
    }

    /**
     * ���ù��˺�����
     * @param filterBlacklist ���˺�����
     */
    public void setFilterBlacklist(boolean filterBlacklist) {
        this.filterBlacklist = filterBlacklist;
    }

    /**
     * ��ȡ�ϲ�������
     * @return �ϲ������� 
     */
    public boolean isMergeWhitelist() {
        return mergeWhitelist;
    }

    /**
     * ���úϲ�������
     * @param mergeWhitelist �ϲ�������
     */
    public void setMergeWhitelist(boolean mergeWhitelist) {
        this.mergeWhitelist = mergeWhitelist;
    }

    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * �����û�id
     * @param userid �û�id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }
    

}
