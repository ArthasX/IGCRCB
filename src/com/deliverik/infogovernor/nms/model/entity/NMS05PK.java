/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���豸��ϵ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class NMS05PK extends BasePK {

	/** ��ID */
	protected Integer gid;
	
	/** �豸ID */
	protected String did;
	
	/** ��汾 */
	protected Integer gversion;
	
	/**
	 * ���췽��
	 */
	public NMS05PK(){
		super();
	}
	
	/**
	 * ���췽��
	 */
	public NMS05PK(Integer gid,String did,Integer gversion){
		super();
		this.gid = gid;
		this.did = did;
		this.gversion = gversion;
	}

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
	
}
