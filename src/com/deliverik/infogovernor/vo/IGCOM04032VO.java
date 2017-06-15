package com.deliverik.infogovernor.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.Knowledge;

/**
 * IGCOM04032VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM04032VO extends BaseVO implements Serializable{
	
	/** 知识对象 */
	protected Knowledge knowledge;

	/** 知识标题 */
	protected String title;
	
	/** 知识关键字 */
	protected String keys;
	
	/** 知识归档日期 */
	protected String time;
	
	/** 知识问题描述 */
	protected String knfaultcause;

	/** 知识标题全称 */
	protected String titleall;
	
	/** 知识ID */
	protected Integer knid;
	
	/** 知识版本号 */
	protected Integer knversion;
	/**编号 */
	protected String  knserial;
	/**分类*/
	protected String knclass;
	/**知识贡献人姓名*/
	protected String knproffername;
	/**分类名称*/
	protected String knclassname;
	
	
	public String getKnclassname() {
		return knclassname;
	}

	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}

	public String getKnclass() {
		return knclass;
	}

	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	public String getKnproffername() {
		return knproffername;
	}

	public void setKnproffername(String knproffername) {
		this.knproffername = knproffername;
	}

	public String getKnserial() {
		return knserial;
	}

	public void setKnserial(String knserial) {
		this.knserial = knserial;
	}

	public Integer getKnid() {
		return knid;
	}

	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	public Integer getKnversion() {
		return knversion;
	}

	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	public String getTitleall() {
		return titleall;
	}

	public void setTitleall(String titleall) {
		this.titleall = titleall;
	}

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKnfaultcause() {
		return knfaultcause;
	}

	public void setKnfaultcause(String knfaultcause) {
		this.knfaultcause = knfaultcause;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}


