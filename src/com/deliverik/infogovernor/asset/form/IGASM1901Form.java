package com.deliverik.infogovernor.asset.form;



import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * 人员查询画面FORM
 * 
 */
public class IGASM1901Form extends BaseForm implements SOC0124SearchCond{

	private static final long serialVersionUID = 1L;

	/**
     * 查询标识
     */
    private String queryflag;
	/** 资产模型编号 */
	protected String elabel;
	
	/** 资产模型名 */
	protected String ename;
	
	/** 人员编号 */
	protected String eilabel;
	
	/** 人员名称 */
	protected String einame;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 资产模型二级子类 */
	protected String ekey2;
	
	/** 人员更新时间FROM */
	protected String eiupdtime_from;
	
	/** 人员更新时间TO */
	protected String eiupdtime_to;
	
	/** 删除人员对象 */
	protected String[] deleteEiid;
	
	/** 人员配置名检索条件数组 */
	protected String[] cname = new String[4];
	
	/** 人员配置值检索条件数组 */
	protected String[] civalue = new String[4];
	
	/** 人员共通配置编号检索条件数组 */
	protected String[] cclabel = new String[2];
	
	/** 人员共通配置值检索条件数组 */
	protected String[] ccivalue = new String[2];
	/** 资产项所属机构*/
	public String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	public String eiorgname;
	/** 资产项所属模型*/
	public String esyscoding;
	
	/** 资产项的状态 */
	protected String eistatus;//下发存N|R  上缴存U  报废存N|R  
	
	/** 资产使用机构code*/
	public String usesyscoding;
	
	private String eidesc_like;
	/** 
	 * 资产模型的状态 
	 */
	protected String estatus;

	private String flagFWS;
	
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
	
	public String getUsesyscoding() {
		return usesyscoding;
	}

	public void setUsesyscoding(String usesyscoding) {
		this.usesyscoding = usesyscoding;
	}
	
	public String getEistatus() {
		return eistatus;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * 资产模型编码取得
	 * @return 资产模型编码
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编码设定
	 *
	 * @param elabel 资产模型编码
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
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
	 *
	 * @param ename 资产模型名
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 人员编码取得
	 * @return 人员编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 人员编码设定
	 *
	 * @param eilabel 人员编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 人员名称取得
	 * @return 人员名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 人员名称设定
	 *
	 * @param einame 人员名称
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
	 * @param ekey1 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * 人员更新时间FROM取得
	 * @return 人员更新时间FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 人员更新时间FROM设定
	 *
	 * @param eiupdtime_from 人员更新时间FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 人员更新时间TO取得
	 * @return 人员更新时间TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 人员更新时间TO设定
	 *
	 * @param eiupdtime_to 人员更新时间TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * 删除人员对象取得
	 * @return 删除人员对象
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * 删除人员对象设定
	 *
	 * @param deleteEiid 删除人员对象
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * 人员配置名检索条件数组取得
	 * @return 人员配置名检索条件数组
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * 人员配置名检索条件数组设定
	 *
	 * @param cname 人员配置名检索条件数组
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * 人员配置值检索条件数组取得
	 * @return 人员配置值检索条件数组
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * 人员配置值检索条件数组设定
	 *
	 * @param civalue 人员配置值检索条件数组
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * 人员共通配置编号检索条件数组取得
	 * @return 人员共通配置编号检索条件数组
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * 人员共通配置编号检索条件数组设定
	 *
	 * @param cclabel 人员共通配置编号检索条件数组
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * 人员共通配置值检索条件数组取得
	 * @return 人员共通配置值检索条件数组
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * 人员共通配置值检索条件数组设定
	 *
	 * @param ccivalue 人员共通配置值检索条件数组
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}

	/**
	 * 初始化处理
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteEiid = null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getEiidList() {
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

    public String getBjdesc_like() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getBjserialnum() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getBjstatus() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getEilabel_like() {
        // TODO Auto-generated method stub
        return null;
    }

	public String getFlagFWS() {
		// TODO Auto-generated method stub
		return flagFWS;
	}

	/**
	 * flagFWS设定
	 * @param flagFWS flagFWS
	 */
	public void setFlagFWS(String flagFWS) {
		this.flagFWS = flagFWS;
	}

	public String getEiorgsyscoding_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getEiversion_gys() {
		// TODO Auto-generated method stub
		return null;
	}

    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.IG688SearchCond#getConfigMap()
     */
    public HashMap<String, String> getConfigMap() {
        // TODO Auto-generated method stub
        return null;
    }

	public Integer getEirootmark_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiupdtime_from2() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiupdtime_to2() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTopCiFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getDeviceType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLifeCycle() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getIpAddress()
	 */
	public String getIpAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getAssetNumber()
	 */
	public String getAssetNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getAote()
	 */
	public String getAote() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getEiidNotInList() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getPayee()
	 */
	public String getPayee() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getAmount()
	 */
	public String getAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUpgrade() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getEiinsdate_gt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiinsdate_lt() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiusername()
	 */
	public String getEiusername() {
		// TODO Auto-generated method stub
		return null;
	}
    
	
}
