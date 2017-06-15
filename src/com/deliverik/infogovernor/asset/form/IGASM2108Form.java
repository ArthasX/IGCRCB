/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 设备查询画面Form
 * 功能描述: 设备查询画面Form
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2108Form extends BaseForm implements IG688SearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 资产项所属机构名称*/
	public String eiorgname;
	
	/**
     * 查询标识
     */
    private String queryflag;
	/** 资产使用机构名称*/
	public String useorgname;
	
	/** 资产模型名 */
	protected String ename;
	
	/** 设备名称 */
	protected String einame;
	
	/** 开始时间 */
	protected String eiupdtime_from;
	
	/** 结束时间 */
	protected String eiupdtime_to;
	
	/** 资产项所属机构*/
	public String eiorgsyscoding;
	
	/** 资产项所属模型*/
	public String esyscoding;
	
	/** 资产使用机构code*/
	public String usesyscoding;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 设备ID */
	protected String eiid;
	
	/** 权限标识ID */
	protected boolean flag;
	
	/** 
	 * 资产模型的状态 
	 */
	protected String estatus;
	
	private String eidesc_like;
	
	/**
	 * 资产模型的状态取得
	 * @return 资产模型的状态
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * 资产模型的状态设定
	 *
	 * @param estatus 资产模型的状态
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
	/**
	 * 权限标识取得
	 * @return 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 *
	 * @param flag 权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * 设备ID取得
	 * @return 设备ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 设备ID设定
	 * @param eiid设备ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产项所属机构名称取得
	 * @return 资产项所属机构名称
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * 资产项所属机构名称设定
	 * @param eiorgname资产项所属机构名称
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * 资产使用机构名称取得
	 * @return 资产使用机构名称
	 */
	public String getUseorgname() {
		return useorgname;
	}

	/**
	 * 资产使用机构名称设定
	 * @param useorgname资产使用机构名称
	 */
	public void setUseorgname(String useorgname) {
		this.useorgname = useorgname;
	}

	/**
	 * 资产模型名取得
	 * @return 资产模型名
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名设定
	 * @param ename资产模型名
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 设备名称取得
	 * @return 设备名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设备名称设定
	 * @param einame设备名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 开始时间取得
	 * @return 开始时间
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 开始时间设定
	 * @param eiupdtime_from开始时间
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 结束时间取得
	 * @return 结束时间
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 结束时间设定
	 * @param eiupdtime_to结束时间
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	/**
	 * 资产项所属机构取得
	 * @return 资产项所属机构
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * 资产项所属机构设定
	 * @param eiorgsyscoding资产项所属机构
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 资产项所属模型取得
	 * @return 资产项所属模型
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产项所属模型设定
	 * @param esyscoding资产项所属模型
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产使用机构code取得
	 * @return 资产使用机构code
	 */
	public String getUsesyscoding() {
		return usesyscoding;
	}

	/**
	 * 资产使用机构code设定
	 * @param usesyscoding资产使用机构code
	 */
	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}
	
	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory 资产模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	public String[] getCcivalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCclabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEilabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEistatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEkey1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getElabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWbdate_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWbdate_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmodeltype_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCondudetime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCondudetime_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFacilitator() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * eidesc_like is returned.
     * @return eidesc_like
     */
    public String getEidesc_like() {
        return eidesc_like;
    }

    /**
     * eidesc_like is set.
     * @param eidesc_like eidesc_like
     */
    public void setEidesc_like(String eidesc_like) {
        this.eidesc_like = eidesc_like;
    }

    /**
     * 查询标识 is returned.
     * @return queryflag
     */
    public String getQueryflag() {
        return queryflag;
    }

    /**
     * 查询标识 is set.
     * @param queryflag 查询标识
     */
    public void setQueryflag(String queryflag) {
        this.queryflag = queryflag;
    }
	
}
