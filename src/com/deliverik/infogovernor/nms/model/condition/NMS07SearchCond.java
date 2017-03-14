/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��·��Ϣʵ���ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS07SearchCond {
    
    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGid();

    /**
     * ��ȡ��汾
     * @return ��汾 
     */
    public Integer getGversion();

    /**
     * ��ȡ���˺�����
     * @return ���˺����� 
     */
    public boolean isFilterBlacklist();

    /**
     * ��ȡ�ϲ�������
     * @return �ϲ������� 
     */
    public boolean isMergeWhitelist();
    
    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid();
}
