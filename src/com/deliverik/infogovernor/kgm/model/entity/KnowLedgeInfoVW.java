/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;

/**
 * 概述: 知识库查询信息TB实体
 * 功能描述：知识库查询信息TB实体
 * 创建记录：wangxiaoqiang    2010/12/07
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
public class KnowLedgeInfoVW implements Serializable, Cloneable, KnowLedgeInfo {
	@Id
	/**主键*/
	protected Integer knid;

	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *主键设定
	 * 
	 * @param knid主键
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 *知识库分类
	 */
	protected String knclass;

	/**
	 *知识库分类取得
	 * 
	 * @return 知识库分类
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *知识库分类设定
	 * 
	 * @param knclass知识库分类
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	/**
	 *知识库分类名称
	 */
	protected String knclassname;

	/**
	 *知识库分类名称取得
	 * 
	 * @return 知识库分类名称
	 */
	public String getKnclassname() {
		return knclassname;
	}

	/**
	 *知识库分类名称设定
	 * 
	 * @param knclassname 知识库分类名称
	 */
	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}
	
	/**
	 *贡献人
	 */
	protected String knproffername;

	/**
	 *贡献人取得
	 * 
	 * @return 贡献人
	 */
	public String getKnproffername() {
		return knproffername;
	}

	/**
	 *贡献人设定
	 * 
	 * @param knproffername贡献人
	 */
	public void setKnproffername(String knproffername) {
		this.knproffername = knproffername;
	}

	/**
	 *知识标题
	 */
	protected String kntitle;

	/**
	 *知识标题取得
	 * 
	 * @return 知识标题
	 */
	public String getKntitle() {
		return kntitle;
	}

	/**
	 *知识标题设定
	 * 
	 * @param kntitle知识标题
	 */
	public void setKntitle(String kntitle) {
		this.kntitle = kntitle;
	}

	/**
	 *事件
	 */
	protected String knapprovetime;

	/**
	 *事件取得
	 * 
	 * @return 事件
	 */
	public String getKnapprovetime() {
		return knapprovetime;
	}

	/**
	 *事件设定
	 * 
	 * @param knapprovetime事件
	 */
	public void setKnapprovetime(String knapprovetime) {
		this.knapprovetime = knapprovetime;
	}

	/**
	 *总评分
	 */
	protected String grade;

	/**
	 *总评分取得
	 * 
	 * @return 总评分
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 *总评分设定
	 * 
	 * @param grade总评分
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/**
	 * 流程数量
	 */
	protected Integer processnum;

	/**
	 * 流程数量取得
	 * @return 流程数量
	 */
	public Integer getProcessnum() {
		return processnum;
	}

	/**
	 * 流程数量设定
	 * @param processnum 流程数量
	 */
	public void setProcessnum(Integer processnum) {
		this.processnum = processnum;
	}
	
	/**
	 * 知识版本
	 */
	protected Integer knversion;

	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * 知识版本设定
	 * @param knversion 知识版本
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	
	/**编号 */
	protected String knserial;
	
	/**
	 *编号取得
	 * 
	 * @return 编号
	 */
	public String getKnserial() {
		return knserial;
	}

	/**
	 *编号设定
	 * 
	 * @param knserial编号
	 */
	public void setKnserial(String knserial) {
		this.knserial = knserial;
	}

	
}
