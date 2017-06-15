package com.deliverik.infogovernor.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * 配置项配置详细画面FORM
 * 
 */
public class IGCOM0328Form extends BaseForm implements SOC0107SearchCond{

	private static final long serialVersionUID = 1L;

	/** 配置项ID */
	protected String eiid;
	
	/** 配置项配置版本 */
	protected String civersion;
	/** 设备配置附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	
	
	/** 资产属性小版本号*/
	protected String cismallversion;
	/**
	 * 取值范围下拉数据取得
	 * @return 取值范围下拉数据
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return (List<LabelValueBean>) selectedListMap.get( new Integer( index ) );
	}

	/**
	 * 取值范围下拉数据设定
	 *
	 * @param selectedList 取值范围下拉数据
	 */
	public void setSelectedListMap(int index,List<LabelValueBean> selectedList) {
		selectedListMap.put(new Integer(index), selectedList);
	}

	/**
	 * 取值范围下拉数据取得
	 * @return 取值范围下拉数据
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}


	/**
	 * 配置项ID取得
	 * @return 配置项ID
	 */
	public String getEiid() {
		return eiid;
	}


	/**
	 * 配置项ID设定
	 *
	 * @param eiid 配置项ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 配置项配置版本取得
	 * @return 配置项配置版本
	 */
	public String getCiversion() {
		return civersion;
	}


	/**
	 * 配置项配置版本设定
	 *
	 * @param civersion 配置项配置版本
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}

	public String getCid() {
		return null;
	}

	public String getEid() {
		return null;
	}

	public String getCivalue() {
		return null;
	}
	/**
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public String getCismallversion() {
		return cismallversion;
	}
	/**
	 * 资产属性小版本号设定
	 *
	 * @param cismallversion 资产属性小版本号
	 */
	public void setCismallversion(String cismallversion) {
		this.cismallversion = cismallversion;
	}

	public String[] getCivalues() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getCids() {
		// TODO Auto-generated method stub
		return null;
	}
}
