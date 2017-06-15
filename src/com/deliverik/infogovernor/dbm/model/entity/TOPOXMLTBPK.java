package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;
import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * TOPOXMLʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class TOPOXMLTBPK extends BasePK implements Serializable {

	private String myid;
	private String isellipsis;

	public TOPOXMLTBPK(){}
	
	public TOPOXMLTBPK(String myid,String isellipsis){
		this.myid = myid;
		this.isellipsis = isellipsis;
	}

	/**
	 * myidȡ��
	 *
	 * @return myid myid
	 */
	public String getMyid() {
		return myid;
	}

	/**
	 * isellipsisȡ��
	 *
	 * @return isellipsis isellipsis
	 */
	public String getIsellipsis() {
		return isellipsis;
	}

	/**
	 * myid�趨
	 *
	 * @param myid myid
	 */
	public void setMyid(String myid) {
		this.myid = myid;
	}

	/**
	 * isellipsis�趨
	 *
	 * @param isellipsis isellipsis
	 */
	public void setIsellipsis(String isellipsis) {
		this.isellipsis = isellipsis;
	}


}
