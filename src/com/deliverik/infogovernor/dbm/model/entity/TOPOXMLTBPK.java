package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;
import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * TOPOXML实体主键
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
	 * myid取得
	 *
	 * @return myid myid
	 */
	public String getMyid() {
		return myid;
	}

	/**
	 * isellipsis取得
	 *
	 * @return isellipsis isellipsis
	 */
	public String getIsellipsis() {
		return isellipsis;
	}

	/**
	 * myid设定
	 *
	 * @param myid myid
	 */
	public void setMyid(String myid) {
		this.myid = myid;
	}

	/**
	 * isellipsis设定
	 *
	 * @param isellipsis isellipsis
	 */
	public void setIsellipsis(String isellipsis) {
		this.isellipsis = isellipsis;
	}


}
