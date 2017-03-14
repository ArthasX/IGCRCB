/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * @Description: 机柜编辑画面FORM
 * @Author  
 * @History 2009-8-17     新建
 * @Version V2.0
 */
public class IGASM1112Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;
	
	/** 容器类型 */
	protected String eimark;
	/** 机柜ID */
	protected Integer eiid;
	
	/** 机柜ID（文字） */
	protected String eiidStr;

	/** 资产类型ID */
	protected String eid;
	
	/** 资产类型ID（文字） */
	protected String eidStr;
	
	/** 机柜名称 */
	protected String einame;
	
	/** 机架名称 */
	protected String jiname;
	
	/** 机柜编码 */
	protected String eilabel;
	
	/** 机架编码 */
	protected String jilabel;
	
	/** 机柜说明 */
	protected String eidesc;
	
	/** 机架说明 */
	protected String jidesc;
	/** 机柜版本号 */
	protected Integer eiversion;
	
	/** 是否已设置标志位 */
	protected String graphstatus;

	/** 机柜变更时间 */
	protected String eiupdtime;
	
	/** 机柜登记日 */
	protected String eiinsdate;
	
	/** 机柜位置（X） */
	protected String x_value;
	
	/** 机柜位置（Y） */
	protected String y_value;
	
	/** 机架在机柜中位置（U） */
	protected String wz_value;
	
	/** 机柜高度（U） */
	protected String u_total;
	
	/** 机架高度（J） */
	protected String j_total;
	
	/** 机架宽度（W） */
	protected String w_total;
	
	/** 机柜横向宽 */
	protected String x_width;

	/** 机柜纵向宽 */
	protected String y_width;

	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	/** 资产项所属机构*/
	protected String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	protected String eiorgname;
	
	/** 资产管理人*/
	protected String eiuserid;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** 机柜规格*/
	protected String standard;
	
	/** 机柜重量*/
	protected String weight;
	
	/** 额定电压*/
	protected String voltage;

	/** 最大负载*/
	protected String maxload;
	
	/** 最大电力*/
	protected String maxpower;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	/** 机架横向U数 */
	protected String width;
	
	/** 平台保留字段 */
	protected String ptemp;
	
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	
	/**
	 * 资产删除标记
	 */
	protected String deleteflag;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/** 资产项所属类型层次码*/
	public String esyscoding;
	
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
	 * 容器类型标识取得
	 * @return 容器类型标识取得
	 */
	public String getEimark() {
		return eimark;
	}
	/**
	 * 容器类型标识设定
	 * @return 容器类型标识设定
	 */
	public void setEimark(String eimark) {
		this.eimark = eimark;
	}
	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}
	
	/**
	 * 是否已上架标志位取得
	 * @return 是否已上架标志位
	 */
	public String getGraphstatus() {
		return graphstatus;
	}
	
	/**
	 * 是否已上架标志位设定
	 *
	 * @param eismallversion 是否已上架标志位
	 */
	public void setGraphstatus(String graphstatus) {
		this.graphstatus = graphstatus;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param eiid 机柜ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * 机柜ID（文字）取得
	 * @return 机柜ID（文字）
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * 机柜ID（文字）设定
	 *
	 * @param eiidStr 机柜ID（文字）
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * 资产类型ID取得
	 * @return 资产类型ID
	 */
	public String getEid() {
		if( (this.eidStr == null) || (this.eidStr.equals(""))){
			return null;
		} else {
			return this.eidStr;
		}
	}

	/**
	 * 资产类型ID设定
	 *
	 * @param eid 资产类型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产类型ID（文字）取得
	 * @return 资产类型ID（文字）
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * 资产类型ID（文字）设定
	 *
	 * @param eidStr 资产类型ID（文字）
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * 机柜名称取得
	 * @return 机柜名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 机柜名称设定
	 *
	 * @param einame 机柜名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 机柜编码取得
	 * @return 机柜编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 机柜编码设定
	 *
	 * @param eilabel 机柜编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 机柜说明取得
	 * @return 机柜说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 机柜说明设定
	 *
	 * @param eidesc 机柜说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 机柜版本号取得
	 * @return 机柜版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 机柜版本号设定
	 *
	 * @param eiversion 机柜版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 机柜更新时间取得
	 * @return 机柜更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 机柜更新时间设定
	 *
	 * @param eiupdtime 机柜更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 机柜登记日取得
	 * @return 机柜登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 机柜登记日设定
	 *
	 * @param eiinsdate 机柜登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 机柜位置（X）取得
	 * @return 机柜位置（X）
	 */
	public String getX_value() {
		return x_value;
	}

	/**
	 * 机柜位置（X）设定
	 *
	 * @param x_value 机柜位置（X）
	 */
	public void setX_value(String x_value) {
		this.x_value = x_value;
	}

	/**
	 * 机柜位置（Y）取得
	 * @return 机柜位置（Y）
	 */
	public String getY_value() {
		return y_value;
	}

	/**
	 * 机柜位置（Y）设定
	 *
	 * @param y_value 机柜位置（Y）
	 */
	public void setY_value(String y_value) {
		this.y_value = y_value;
	}

	/**
	 * 机柜高度（U）取得
	 * @return 机柜高度（U）
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * 机柜高度（U）设定
	 *
	 * @param u_total 机柜高度（U）
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}


	/**
	 * 机架宽度（W）取得
	 * @return 机柜高度（W）
	 */
	public String getW_total() {
		return w_total;
	}

	/**
	 * 机架宽度（W）设定
	 * @return 机架高度（W）
	 */
	public void setW_total(String w_total) {
		this.w_total = w_total;
	}
	/**
	 * 机柜横向宽取得
	 * @return 机柜横向宽
	 */
	public String getX_width() {
		return x_width;
	}

	/**
	 * 机柜横向宽设定
	 *
	 * @param x_width 机柜横向宽
	 */
	public void setX_width(String x_width) {
		this.x_width = x_width;
	}

	/**
	 * 机柜纵向宽取得
	 * @return 机柜纵向宽
	 */
	public String getY_width() {
		return y_width;
	}

	/**
	 * 机柜纵向宽设定
	 *
	 * @param y_width 机柜纵向宽
	 */
	public void setY_width(String y_width) {
		this.y_width = y_width;
	}

	/**
	 * 编辑模式取得
	 * @return 编辑模式
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * 编辑模式设定
	 *
	 * @param mode 编辑模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 资产项所属类型层次码取得
	 * @return 资产项所属类型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产项所属类型层次码设定
	 *
	 * @param mode 资产项所属类型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEistatus() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 资产管理人取得
	 * @return 资产管理人
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * 资产管理人设定
	 *
	 * @param eiuserid 资产管理人
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * 资产管理人姓名取得
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * 资产管理人姓名设定
	 *
	 * @param eiusername 资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getJiname() {
		return jiname;
	}
	public void setJiname(String jiname) {
		this.jiname = jiname;
	}
	public String getJilabel() {
		return jilabel;
	}
	public void setJilabel(String jilabel) {
		this.jilabel = jilabel;
	}
	public String getJidesc() {
		return jidesc;
	}
	public void setJidesc(String jidesc) {
		this.jidesc = jidesc;
	}
	public String getJ_total() {
		return j_total;
	}
	public void setJ_total(String j_total) {
		this.j_total = j_total;
	}

	public String getWz_value() {
		return wz_value;
	}

	public void setWz_value(String wz_value) {
		this.wz_value = wz_value;
	}

	public String getPtemp() {
		return ptemp;
	}

	public void setPtemp(String ptemp) {
		this.ptemp = ptemp;
	}

	public Integer getEirootmark() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * 最大负载取得
     *
     * @return maxload 最大负载
     */
    public String getMaxload() {
        return maxload;
    }

    /**
     * 最大电力取得
     *
     * @return maxpower 最大电力
     */
    public String getMaxpower() {
        return maxpower;
    }

    /**
     * 最大负载设定
     *
     * @param maxload 最大负载
     */
    public void setMaxload(String maxload) {
        this.maxload = maxload;
    }

    /**
     * 最大电力设定
     *
     * @param maxpower 最大电力
     */
    public void setMaxpower(String maxpower) {
        this.maxpower = maxpower;
    }

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
