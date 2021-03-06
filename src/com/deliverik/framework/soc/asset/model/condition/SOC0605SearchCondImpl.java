/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * 资产信息检索条件实现
 * 
 */
public class SOC0605SearchCondImpl implements SOC0605SearchCond {

	/** 资产模型编号 */
	protected String elabel;
	
	/** 资产模型名称（平台保留） */
	protected String ename;
	
	/** 资产编号 */
	protected String eilabel;
	
	/** 资产名称 */
	protected String einame;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类（平台保留） */
	protected String ekey1;
	
	/** 资产模型二级子类（平台保留） */
	protected String ekey2;
	
	/** 资产更新开始时间 */
	protected String eiupdtime_from;
	
	/** 资产更新截止时间 */
	protected String eiupdtime_to;
	
	/** 资产属性名检索条件数组（平台保留） */
	protected String[] cname;
	
	/** 资产属性值检索条件数组（平台保留） */
	protected String[] civalue;
	
	/** 资产共通属性编号检索条件数组（平台保留） */
	protected String[] cclabel;
	
	/** 资产共通属性值检索条件数组（平台保留） */
	protected String[] ccivalue;
	
	/** 资产所属机构层次码*/
	public String eiorgcode;
	
	/** 资产所属机构层次码（平台保留）*/
	public String eiorgsyscoding;
	
	/** 资产所属机构层次码（平台保留）*/
	public String eiorgsyscoding_q;

	/** 资产状态（平台保留） */
	protected String eistatus;

	/** 资产模型层次码 */
	protected String esyscoding;
	
	/** 资产状态（平台保留）*/
	protected String eistatus_q;
	
	/** 资产ID集合（平台保留）*/
	protected List<String> eiidList;
	
	/** 资产使用机构code */
	protected String usesyscoding;
	
	/** 维保开始日期 */
	protected String wbdate_from;
	
	/** 维保结束日期 */
	protected String wbdate_to;
	
	/** 资产模糊查询 */
	protected String eidesc_like;
	
	/** 
	 * 资产模型的状态 
	 */
	protected String estatus;
	
	/**
	 * 资产模型类别（0：一般资产模型 1：配置资产模型）
	 */
	protected String emodeltype_eq;

	/**
	 * 查询标识
	 */
    private String queryflag;
	
    /**
     * 备件状态条件
     */
    protected String bjstatus;
    
    /**
     * 备件序列号
     */
    protected String bjserialnum;
    
    /**
     * 备件描述条件
     */
    protected String bjdesc_like;
    
    /** 资产编号Like */
	protected String eilabel_like;

	/** 服务商 资产标识 */
	private String flagFWS;
	
	    /** 查询机构码（过滤条件） */
    protected String eiorgsyscoding_in;
    
    protected Integer eiversion_gys;
    

	/**
     * @return the 备件状态条件
     */
    public String getBjstatus() {
        return bjstatus;
    }

    /**
     * @param 备件状态条件 the bjstatus to set
     */
    public void setBjstatus(String bjstatus) {
        this.bjstatus = bjstatus;
    }

    /**
     * @return the 备件序列号
     */
    public String getBjserialnum() {
        return bjserialnum;
    }

    /**
     * @param 备件序列号 the bjserialnum to set
     */
    public void setBjserialnum(String bjserialnum) {
        this.bjserialnum = bjserialnum;
    }

    /**
     * @return the 备件描述条件
     */
    public String getBjdesc_like() {
        return bjdesc_like;
    }

    /**
     * @param 备件描述条件 the bjdesc_like to set
     */
    public void setBjdesc_like(String bjdesc_like) {
        this.bjdesc_like = bjdesc_like;
    }

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
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgcode() {
		return eiorgcode;
	}

	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgcode 资产所属机构层次码
	 */
	public void setEiorgcode(String eiorgcode) {
		this.eiorgcode = eiorgcode;
	}
	
	
	/**
	 * 资产状态取得
	 * @return 资产状态
	 */
	public String getEistatus_q() {
		return eistatus_q;
	}

	/**
	 * 资产状态设定
	 *
	 * @param eistatus_q 资产状态
	 */
	public void setEistatus_q(String eistatus_q) {
		this.eistatus_q = eistatus_q;
	}

	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding_q() {
		return eiorgsyscoding_q;
	}

	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgsyscoding_q 资产所属机构层次码
	 */
	public void setEiorgsyscoding_q(String eiorgsyscoding_q) {
		this.eiorgsyscoding_q = eiorgsyscoding_q;
	}

	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param esyscoding 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产状态取得
	 * @return 资产状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 资产状态设定
	 *
	 * @param eistatus 资产状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgsyscoding 资产所属机构层次码
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编号设定
	 *
	 * @param elabel 资产模型编号
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 资产编号取得
	 * @return 资产编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产编号设定
	 *
	 * @param eilabel 资产编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资产名称设定
	 *
	 * @param einame 资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
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

	/**
	 * 资产模型一级子类取得
	 * @return 资产模型一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * 资产模型一级子类设定
	 *
	 * @param ekey1 资产模型一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * 资产模型二级子类取得
	 * @return 资产模型二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * 资产模型二级子类设定
	 *
	 * @param ekey2 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * 资产更新开始时间取得
	 * @return 资产更新开始时间
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 资产更新开始时间设定
	 *
	 * @param eiupdtime_from 资产更新开始时间
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 资产更新截止时间取得
	 * @return 资产更新截止时间
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 资产更新截止时间设定
	 *
	 * @param eiupdtime_to 资产更新截止时间
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	/**
	 * 资产属性名检索条件数组取得
	 * @return 资产属性名检索条件数组
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * 资产属性名称检索条件数组设定
	 *
	 * @param cname 资产属性名称检索条件数组
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * 资产属性值检索条件数组取得
	 * @return 资产属性值检索条件数组
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * 资产属性值检索条件数组设定
	 *
	 * @param civalue 资产属性值检索条件数组
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * 资产共通属性编号检索条件数组取得
	 * @return 资产共通属性编号检索条件数组
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * 资产共通属性编号检索条件数组设定
	 *
	 * @param cclabel 资产共通属性编号检索条件数组
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * 资产共通属性值检索条件数组取得
	 * @return 资产共通属性值检索条件数组
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * 资产共通属性值检索条件数组设定
	 *
	 * @param ccivalue 资产共通属性值检索条件数组
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}

	/**
	 * 资产ID集合取得
	 * @return 资产ID集合
	 */
	public List<String> getEiidList() {
		return eiidList;
	}

	/**
	 * 资产ID集合设定
	 *
	 * @param eiidList 资产ID集合
	 */
	public void setEiidList(List<String> eiidList) {
		this.eiidList = eiidList;
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
	 *
	 * @param usesyscoding 资产使用机构code
	 */
	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}

	/**
	 * 维保开始日期取得
	 * @return 维保开始日期
	 */
	public String getWbdate_from() {
		return wbdate_from;
	}

	/**
	 * 维保开始日期设定
	 *
	 * @param wbdate_from 维保开始日期
	 */
	public void setWbdate_from(String wbdate_from) {
		this.wbdate_from = wbdate_from;
	}

	/**
	 * 维保结束日期取得
	 * @return 维保结束日期
	 */
	public String getWbdate_to() {
		return wbdate_to;
	}

	/**
	 * 维保结束日期设定
	 *
	 * @param wbdate_to 维保结束日期
	 */
	public void setWbdate_to(String wbdate_to) {
		this.wbdate_to = wbdate_to;
	}
	
	/**
	 * 资产模型类别取得
	 * 
	 * @return 资产模型类别（0：一般资产模型 1：配置资产模型）
	 */
	public String getEmodeltype_eq() {
		return emodeltype_eq;
	}

	/**
	 * 资产模型类别设定
	 * @param emodeltype_eq 资产模型类别（0：一般资产模型 1：配置资产模型）
	 */
	public void setEmodeltype_eq(String emodeltype_eq) {
		this.emodeltype_eq = emodeltype_eq;
	}

    /**
     * 资产模糊查询 is returned.
     * @return eidesc_like
     */
    public String getEidesc_like() {
        return eidesc_like;
    }

    /**
     * 资产模糊查询 is set.
     * @param eidesc_like 资产模糊查询
     */
    public void setEidesc_like(String eidesc_like) {
        this.eidesc_like = eidesc_like;
    }

    /**
     * 查询标志
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
    
    /** 
     * 资产编号Like 取得
     * @return eilabel_like 资产编号Like 
     */
    public String getEilabel_like() {
        return eilabel_like;
    }

    /** 
     * 资产编号Like 设定
     * @param eilabel_like 资产编号Like 
     */
    public void setEilabel_like(String eilabel_like) {
        this.eilabel_like = eilabel_like;
    }

	/**
	 * 服务商资产标识取得
	 * @return flagFWS 服务商资产标识
	 */
	public String getFlagFWS() {
		return flagFWS;
	}

	/**
	 * 服务商资产标识设定
	 * @param flagFWS 服务商资产标识
	 */
	public void setFlagFWS(String flagFWS) {
		this.flagFWS = flagFWS;
	}
	
	 /**
     * 查询机构码（过滤条件）获取
     * @return eiorgsyscoding_in
     */
	public String getEiorgsyscoding_in() {
		return eiorgsyscoding_in;
	}

	/**
	 * 查询机构码（过滤条件）设定
	 * @param eiorgsyscoding_in
	 */
	public void setEiorgsyscoding_in(String eiorgsyscoding_in) {
		this.eiorgsyscoding_in = eiorgsyscoding_in;
	}

	/**
	 * eiversion_gys取得
	 *
	 * @return eiversion_gys eiversion_gys
	 */
	public Integer getEiversion_gys() {
		return eiversion_gys;
	}

	/**
	 * eiversion_gys设定
	 *
	 * @param eiversion_gys eiversion_gys
	 */
	public void setEiversion_gys(Integer eiversion_gys) {
		this.eiversion_gys = eiversion_gys;
	}
}
