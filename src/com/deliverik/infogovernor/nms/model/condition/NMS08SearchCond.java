/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��������Ϣʵ���ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS08SearchCond {

	/**
	 * ��IDȡ��
	 * @return gid ��ID
	 */
	public Integer getGid();

	/**
	 * ��汾ȡ��
	 * @return gversion ��汾
	 */
	public Integer getGversion() ;
	
	/**
	 * �û�IDȡ��
	 * @return userid �û�ID
	 */
	public String getUserid();
	
	/**
	 * �豸IDȡ��
	 * @return did �豸ID
	 */
	public String getDid();
	
	/**
	 * �û�idΪ��ȡ��
	 * @return useridEmpty �û�idΪ��
	 */
	public boolean isUseridEmpty();
}
