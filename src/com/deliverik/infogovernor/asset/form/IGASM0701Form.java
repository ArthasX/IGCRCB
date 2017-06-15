package com.deliverik.infogovernor.asset.form;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 机房查询画面FORM
 * 
 */
public class IGASM0701Form extends BaseForm implements IG688SearchCond{

	private static final long serialVersionUID = 1L;

	/**
     * 查询标识
     */
    private String queryflag;
	/** 资产模型编号 */
	protected String elabel;
	
	/** 资产模型名 */
	protected String ename;
	
	/** 机房编号 */
	protected String eilabel;
	
	/** 机房名称 */
	protected String einame;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 资产模型二级子类 */
	protected String ekey2;
	
	/** 机房更新时间FROM */
	protected String eiupdtime_from;
	
	/** 机房更新时间TO */
	protected String eiupdtime_to;
	
	/** 删除机房对象 */
	protected String[] deleteEiid;
	
	/** 机房配置名检索条件数组 */
	protected String[] cname = new String[4];
	
	/** 机房配置值检索条件数组 */
	protected String[] civalue = new String[4];
	
	/** 机房共通配置编号检索条件数组 */
	protected String[] cclabel = new String[2];
	
	/** 机房共通配置值检索条件数组 */
	protected String[] ccivalue = new String[2];
	/** 资产项所属机构*/
	public String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	public String eiorgname;
	
	/** 资产使用机构code*/
	public String usesyscoding;
	
	/** 
	 * 资产模型的状态 
	 */
	protected String estatus;
	
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
	
	public String eistatus;

    private String eidesc_like;
	
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEistatus() {
		return eistatus;
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
	 * 机房编码取得
	 * @return 机房编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 机房编码设定
	 *
	 * @param eilabel 机房编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 机房名称取得
	 * @return 机房名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 机房名称设定
	 *
	 * @param einame 机房名称
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
	 * 机房更新时间FROM取得
	 * @return 机房更新时间FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 机房更新时间FROM设定
	 *
	 * @param eiupdtime_from 机房更新时间FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 机房更新时间TO取得
	 * @return 机房更新时间TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 机房更新时间TO设定
	 *
	 * @param eiupdtime_to 机房更新时间TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * 删除机房对象取得
	 * @return 删除机房对象
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * 删除机房对象设定
	 *
	 * @param deleteEiid 删除机房对象
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * 机房配置名检索条件数组取得
	 * @return 机房配置名检索条件数组
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * 机房配置名检索条件数组设定
	 *
	 * @param cname 机房配置名检索条件数组
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * 机房配置值检索条件数组取得
	 * @return 机房配置值检索条件数组
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * 机房配置值检索条件数组设定
	 *
	 * @param civalue 机房配置值检索条件数组
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * 机房共通配置编号检索条件数组取得
	 * @return 机房共通配置编号检索条件数组
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * 机房共通配置编号检索条件数组设定
	 *
	 * @param cclabel 机房共通配置编号检索条件数组
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * 机房共通配置值检索条件数组取得
	 * @return 机房共通配置值检索条件数组
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * 机房共通配置值检索条件数组设定
	 *
	 * @param ccivalue 机房共通配置值检索条件数组
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

	public String getEsyscoding() {
		// TODO Auto-generated method stub
		return null;
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

    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.IG688SearchCond#getEidesc_like()
     */
    public String getEidesc_like() {
        // TODO Auto-generated method stub
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
