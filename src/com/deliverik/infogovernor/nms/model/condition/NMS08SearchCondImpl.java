/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��������Ϣʵ���ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS08SearchCondImpl implements NMS08SearchCond{

	/** ��ID */
	protected Integer gid;
	
	/** ��汾 */
	protected Integer gversion;
	
	/** �û�ID */
	protected String userid;
	
	/** �豸ID */
	protected String did;
	
    /** �û�idΪ��  */
    protected boolean useridEmpty;

	/**
	 * ��IDȡ��
	 * @return gid ��ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * ��ID�趨
	 * @param gid ��ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * ��汾ȡ��
	 * @return gversion ��汾
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * ��汾�趨
	 * @param gversion ��汾
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

	/**
	 * �û�IDȡ��
	 * @return userid �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �豸IDȡ��
	 * @return did �豸ID
	 */
	public String getDid() {
		return did;
	}

	/**
	 * �豸ID�趨
	 * @param did �豸ID
	 */
	public void setDid(String did) {
		this.did = did;
	}

	/**
	 * �û�idΪ��ȡ��
	 * @return useridEmpty �û�idΪ��
	 */
	public boolean isUseridEmpty() {
		return useridEmpty;
	}

	/**
	 * �û�idΪ���趨
	 * @param useridEmpty �û�idΪ��
	 */
	public void setUseridEmpty(boolean useridEmpty) {
		this.useridEmpty = useridEmpty;
	}
}
