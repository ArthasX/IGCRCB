package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;

/**
 * IGMNT01071VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGMNT01071VO extends BaseVO implements Serializable{
	
	/** �������List */
	protected List<SOC0304Info> soc0304List =new ArrayList<SOC0304Info>();
	
	/** ���󼯺�List */
	protected List<Object_ListInfo> olInfoList=new ArrayList<Object_ListInfo>();
	/**ʱ��Ĭ��*/
	protected String interValDefault;
	/**
	 * �������к�
	 */
	protected String mtSsn;
	/**
	 * ѡ������
	 */
	protected String checkedCount;
	
	/**��������ID*/
	protected String tmpMtId;
	/**��ǰ�û�ID*/
	protected String userId;


	/**
	 * ���󼯺�Listȡ��
	 *
	 * @return olInfoList ���󼯺�List
	 */
	public List<Object_ListInfo> getOlInfoList() {
		return olInfoList;
	}

	/**
	 * ���󼯺�List�趨
	 *
	 * @param olInfoList ���󼯺�List
	 */
	public void setOlInfoList(List<Object_ListInfo> olInfoList) {
		this.olInfoList = olInfoList;
	}

	/**
	 * �������к�ȡ��
	 *
	 * @return mtSsn �������к�
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * �������к��趨
	 *
	 * @param mtSsn �������к�
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}

	/**
	 * ѡ������ȡ��
	 *
	 * @return checkedCount ѡ������
	 */
	public String getCheckedCount() {
		return checkedCount;
	}

	/**
	 * ѡ�������趨
	 *
	 * @param checkedCount ѡ������
	 */
	public void setCheckedCount(String checkedCount) {
		this.checkedCount = checkedCount;
	}

	/**
	 * ʱ��Ĭ��ȡ��
	 *
	 * @return interValDefault ʱ��Ĭ��
	 */
	public String getInterValDefault() {
		return interValDefault;
	}

	/**
	 * ʱ��Ĭ���趨
	 *
	 * @param interValDefault ʱ��Ĭ��
	 */
	public void setInterValDefault(String interValDefault) {
		this.interValDefault = interValDefault;
	}

	/**
	 * ��������IDȡ��
	 *
	 * @return tmpMtId ��������ID
	 */
	public String getTmpMtId() {
		return tmpMtId;
	}

	/**
	 * ��������ID�趨
	 *
	 * @param tmpMtId ��������ID
	 */
	public void setTmpMtId(String tmpMtId) {
		this.tmpMtId = tmpMtId;
	}

	/**
	 * ��ǰ�û�IDȡ��
	 *
	 * @return userId ��ǰ�û�ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ��ǰ�û�ID�趨
	 *
	 * @param userId ��ǰ�û�ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * �������Listȡ��
	 *
	 * @return soc0304List �������List
	 */
	public List<SOC0304Info> getSoc0304List() {
		return soc0304List;
	}

	/**
	 * �������List�趨
	 *
	 * @param soc0304List �������List
	 */
	public void setSoc0304List(List<SOC0304Info> soc0304List) {
		this.soc0304List = soc0304List;
	}


	
}


