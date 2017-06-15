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
	
	/** 监控任务List */
	protected List<SOC0304Info> soc0304List =new ArrayList<SOC0304Info>();
	
	/** 对象集合List */
	protected List<Object_ListInfo> olInfoList=new ArrayList<Object_ListInfo>();
	/**时间默认*/
	protected String interValDefault;
	/**
	 * 磁盘序列号
	 */
	protected String mtSsn;
	/**
	 * 选择限制
	 */
	protected String checkedCount;
	
	/**新增任务ID*/
	protected String tmpMtId;
	/**当前用户ID*/
	protected String userId;


	/**
	 * 对象集合List取得
	 *
	 * @return olInfoList 对象集合List
	 */
	public List<Object_ListInfo> getOlInfoList() {
		return olInfoList;
	}

	/**
	 * 对象集合List设定
	 *
	 * @param olInfoList 对象集合List
	 */
	public void setOlInfoList(List<Object_ListInfo> olInfoList) {
		this.olInfoList = olInfoList;
	}

	/**
	 * 磁盘序列号取得
	 *
	 * @return mtSsn 磁盘序列号
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * 磁盘序列号设定
	 *
	 * @param mtSsn 磁盘序列号
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}

	/**
	 * 选择限制取得
	 *
	 * @return checkedCount 选择限制
	 */
	public String getCheckedCount() {
		return checkedCount;
	}

	/**
	 * 选择限制设定
	 *
	 * @param checkedCount 选择限制
	 */
	public void setCheckedCount(String checkedCount) {
		this.checkedCount = checkedCount;
	}

	/**
	 * 时间默认取得
	 *
	 * @return interValDefault 时间默认
	 */
	public String getInterValDefault() {
		return interValDefault;
	}

	/**
	 * 时间默认设定
	 *
	 * @param interValDefault 时间默认
	 */
	public void setInterValDefault(String interValDefault) {
		this.interValDefault = interValDefault;
	}

	/**
	 * 新增任务ID取得
	 *
	 * @return tmpMtId 新增任务ID
	 */
	public String getTmpMtId() {
		return tmpMtId;
	}

	/**
	 * 新增任务ID设定
	 *
	 * @param tmpMtId 新增任务ID
	 */
	public void setTmpMtId(String tmpMtId) {
		this.tmpMtId = tmpMtId;
	}

	/**
	 * 当前用户ID取得
	 *
	 * @return userId 当前用户ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 当前用户ID设定
	 *
	 * @param userId 当前用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 监控任务List取得
	 *
	 * @return soc0304List 监控任务List
	 */
	public List<SOC0304Info> getSoc0304List() {
		return soc0304List;
	}

	/**
	 * 监控任务List设定
	 *
	 * @param soc0304List 监控任务List
	 */
	public void setSoc0304List(List<SOC0304Info> soc0304List) {
		this.soc0304List = soc0304List;
	}


	
}


