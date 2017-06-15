/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;

/**
 * 概述: 知识库统计实体
 * 功能描述：知识库统计
 * 创建记录：wanglei 2014/3/13
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
public class KnowledgeStatisticsVW implements Serializable, Cloneable, KnowledgeStatisticsInfo{
	@Id
	/**主键 */
	protected Integer klsid;
	
	/**统计数量 */
	protected Integer klscount;
	
	/**知识贡献人id */
	protected String knproffer;
	
	/**知识贡献人姓名*/
	protected String knproffername;

	/**知识分类 */
	protected String knclass;
	
	/**知识分类名称 */
	protected String knclassname;
	
	/**
	 *知识贡献人姓名取得
	 * 
	 * @return 知识贡献人姓名
	 */
	public String getKnproffername() {
		return knproffername;
	}

	/**
	 * 知识贡献人姓名设定
	 * @param knproffername 知识贡献人姓名
	 */
	public void setKnproffername(String knproffername) {
		this.knproffername = knproffername;
	}

	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKlsid() {
		return klsid;
	}
	
	/**
	 *主键设定
	 * 
	 * @param knid主键
	 */
	public void setKlsid(Integer klsid) {
		this.klsid = klsid;
	}
	
	/**
	 *统计数量取得
	 * 
	 * @return 统计数量
	 */
	public Integer getKlscount() {
		return klscount;
	}

	/**
	 *统计数量设定
	 * 
	 * @param klscount统计数量
	 */
	public void setKlscount(Integer klscount) {
		this.klscount = klscount;
	}

	/**
	 *分类取得
	 * 
	 * @return 分类
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *分类设定
	 * 
	 * @param knclass分类
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	/**
	 *知识贡献人取得
	 * 
	 * @return 知识贡献人
	 */
	public String getKnproffer() {
		return knproffer;
	}

	/**
	 *知识贡献人设定
	 * 
	 * @param knproffer知识贡献人
	 */
	public void setKnproffer(String knproffer) {
		this.knproffer = knproffer;
	}

	/**
	 *类别名称取得
	 * 
	 * @return 类别名称
	 */
	public String getKnclassname() {
		return knclassname;
	}
	
	/**
	 *类别名称设定
	 * 
	 * @param knclassname 类别名称
	 */
	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}

}
