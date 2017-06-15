package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;

/**
 * @Description: 资产模型树
 * @Author  
 * @History 2009-8-18     新建 
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGCIM1202Form extends BaseForm implements SOC0117SearchCond {

	private static final long serialVersionUID = 1L;
	

	
	/** 查询指定结点的下级树 */
	protected String syscoding_q;
	
	/** entity syscoding */
	protected String esyscoding;
	
	/** entity parsyscoding */
	protected String eparcoding;
	
	protected String eparcoding_q;
	
	/** 资产类型ID */
	protected String eidStr;

	/** 资产类型编号 */
	protected String elabel;
	
	/** 资产类型名 */
	protected String ename;
	
	/** 资产类型分类 */
	protected String ecategory;
	
	/** 资产类型一级子类 */
	protected String ekey1;
	
	/** 资产类型二级子类 */
	protected String ekey2;
	
	/** 资产类型三级子类 */
	protected String ekey3;
	
	protected String esyscoding_q;
	
	protected String estatus;
	
	/** 资产模型syscoding,igsym1201action使用 */
	protected String esyscoding_tree;
	
	protected List<String> selectList;//entity树显示时需要查询的1级结点（供取值范围使用）
	
	protected List<String> delList;//entity树显示时需要去掉的1级结点（供取值范围使用）
	
	/** 资产模型树中是否显示机房标识 0不显示*/
	protected String type;
	
	protected String esyscoding_nq;
	
	/**
	 * 资产模型类别（0：一般资产模型 1：配置资产模型）
	 */
	protected String emodeltype_eq;
	
	/** 
	 * 资产模型层次码区间检索条件<br>
	 * （去掉资产模型层次码与该集合内的元素模糊匹配的资产模型信息） 
	 */
	protected List<String> delList_q;
	
	
	
	public List<String> getDelList_q() {
		return delList_q;
	}


	public void setDelList_q(List<String> delList_q) {
		this.delList_q = delList_q;
	}
	
	public String getEsyscoding_nq() {
		return esyscoding_nq;
	}


	public void setEsyscoding_nq(String esyscoding_nq) {
		this.esyscoding_nq = esyscoding_nq;
	}
	
	public List<String> getSelectList() {
		return selectList;
	}

	public List<String> getDelList() {
		return delList;
	}

	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	public String getEsyscoding_tree() {
		return esyscoding_tree;
	}

	public void setEsyscoding_tree(String esyscoding_tree) {
		this.esyscoding_tree = esyscoding_tree;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getEparcoding_q() {
		return eparcoding_q;
	}

	public void setEparcoding_q(String eparcoding_q) {
		this.eparcoding_q = eparcoding_q;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	public String getSyscoding_q() {
		return syscoding_q;
	}

	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	

	public String getEparcoding() {
		return eparcoding;
	}

	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	public String getEidStr() {
		return eidStr;
	}

	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	public String getElabel() {
		return elabel;
	}

	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEcategory() {
		return ecategory;
	}

	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	public String getEkey1() {
		return ekey1;
	}

	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	public String getEkey2() {
		return ekey2;
	}

	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	public String getEkey3() {
		return ekey3;
	}

	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}

	public List<String> getEsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEparcoding_status() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEparcoding_status_start() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEcategory_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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


	public String getEidStr_like() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEname_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEparcoding_neq() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
