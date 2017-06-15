package com.deliverik.infogovernor.drm.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 应急资源弹出页信息检索结果FORM
 * 
 */
public class IGDRM0406Form extends BaseForm implements IG688SearchCond{

	private static final long serialVersionUID = 1L;

	/** special Plan专项预案eiid */
	protected String sp_eiid;
	/** 应急资源分类编号 */
	protected String elabel;
	
	/**
     * 查询标识
     */
    private String queryflag;
	
	/** 应急资源项编号 */
	protected String eilabel;
	
	/** 应急资源项名称 */
	protected String einame;
	
	/** 应急资源分类分类 */
	protected String ecategory;
	
	/** 应急资源分类一级子类 */
	protected String ekey1;
	
	/** 应急资源分类二级子类 */
	protected String ekey2;
	
	/** 应急资源更新时间FROM */
	protected String eiupdtime_from;
	
	/** 应急资源更新时间TO */
	protected String eiupdtime_to;
	
	/** 应急资源项所属机构*/
	public String eiorgsyscoding;
	
	/** 应急资源项所属机构名称*/
	public String eiorgname;
	
	public String eistatus;
	
	/** 应急资源分类名 */
	protected String ename;
	
	/** 模型层次码 */
	protected String esyscoding;
	
	/** 初始化层次码 */
	protected String esyscodingbegin;
	
	/** 复选框选中ID */
	protected String[] selectId;
	
	/** 应急资源使用机构code*/
	public String usesyscoding;
	
	/** 维保到期日查询开始时间 */
	public String wbdate_from;
	/** 维保到期日查询结束时间 */
	public String wbdate_to;
	
	/** 动态表单ID */
	protected String pidid;
	
	/** 
	 * 应急资源分类的状态 
	 */
	protected String estatus;
	
	private String eidesc_like;
	/**
	 * 应急资源分类类别（0：一般应急资源分类 1：配置应急资源分类）
	 */
	protected String emodeltype_eq;
	
	/** 设备类型*/
	protected String deviceType;
	
	/**应急资源变更特殊查询*/
	protected String modifyflag;
	
	/**调用标识(标注是资产表单调用还是FLEX流程设计器调用)*/
	protected String parFlag;
	

    public String getModifyflag() {
        return modifyflag;
    }

    public void setModifyflag(String modifyflag) {
        this.modifyflag = modifyflag;
    }

    /**
	 * 应急资源分类的状态取得
	 * @return 应急资源分类的状态
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * 应急资源分类的状态设定
	 *
	 * @param estatus 应急资源分类的状态
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
	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

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
	 * 应急资源分类编码取得
	 * @return 应急资源分类编码
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 应急资源分类编码设定
	 *
	 * @param elabel 应急资源分类编码
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 应急资源项编码取得
	 * @return 应急资源项编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 应急资源项编码设定
	 *
	 * @param eilabel 应急资源项编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 应急资源项名称取得
	 * @return 应急资源项名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 应急资源项名称设定
	 *
	 * @param einame 应急资源项名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 应急资源分类分类取得
	 * @return 应急资源分类分类
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * 应急资源分类分类设定
	 *
	 * @param ecategory 应急资源分类分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * 应急资源分类一级子类取得
	 * @return 应急资源分类一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * 应急资源分类一级子类设定
	 *
	 * @param ekey1 应急资源分类一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * 应急资源分类二级子类取得
	 * @return 应急资源分类二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * 应急资源分类二级子类设定
	 *
	 * @param ekey1 应急资源分类二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * 应急资源项更新时间FROM取得
	 * @return 应急资源项更新时间FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 应急资源项更新时间FROM设定
	 *
	 * @param eiupdtime_from 应急资源项更新时间FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 应急资源项更新时间TO取得
	 * @return 应急资源项更新时间TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 应急资源项更新时间TO设定
	 *
	 * @param eiupdtime_to 应急资源项更新时间TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}
	
	public String getEname() {
		return ename;
	}

	public String getEsyscoding() {
		return esyscoding;
	}
	
	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCcivalue() {
		return null;
	}

	public String[] getCclabel() {
		return null;
	}

	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEsyscodingbegin() {
		return esyscodingbegin;
	}

	public void setEsyscodingbegin(String esyscodingbegin) {
		this.esyscodingbegin = esyscodingbegin;
	}

	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 复选框选中ID取得
	 * @return 复选框选中ID
	 */
	public String[] getSelectId() {
		return selectId;
	}

	/**
	 * 复选框选中ID设定
	 *
	 * @param selectId 复选框选中ID
	 */
	public void setSelectId(String[] selectId) {
		this.selectId = selectId;
	}

	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWbdate_from() {
		return wbdate_from;
	}

	public void setWbdate_from(String wbdate_from) {
		this.wbdate_from = wbdate_from;
	}

	public String getWbdate_to() {
		return wbdate_to;
	}

	public void setWbdate_to(String wbdate_to) {
		this.wbdate_to = wbdate_to;
	}

	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	/**
	 * 应急资源分类类别取得
	 * 
	 * @return 应急资源分类类别（0：一般应急资源分类 1：配置应急资源分类）
	 */
	public String getEmodeltype_eq() {
		return emodeltype_eq;
	}

	/**
	 * 应急资源分类类别设定
	 * @param emodeltype_eq 应急资源分类类别（0：一般应急资源分类 1：配置应急资源分类）
	 */
	public void setEmodeltype_eq(String emodeltype_eq) {
		this.emodeltype_eq = emodeltype_eq;
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
    
    /**
	 * 设备类型取得
	 *
	 * @return deviceType 设备类型
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * 设备类型设定
	 *
	 * @param deviceType 设备类型
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSp_eiid() {
		return sp_eiid;
	}

	public void setSp_eiid(String sp_eiid) {
		this.sp_eiid = sp_eiid;
	}

	public String getParFlag() {
		return parFlag;
	}

	public void setParFlag(String parFlag) {
		this.parFlag = parFlag;
	}

}
