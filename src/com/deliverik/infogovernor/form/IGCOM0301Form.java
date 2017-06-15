package com.deliverik.infogovernor.form;

import java.util.List;

import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 资产查询HELP画面用FORM
 * IGCOM0301Form ActionForm
 */
public class IGCOM0301Form extends BaseForm implements IG117SearchCond{

	private static final long serialVersionUID = 1L;

	/** 资产模型ID */
	protected int eid;
	
	/** 资产模型ID（文字） */
	protected String eidStr;
	
	/** 资产模型编号 */
	protected String elabel;
	
	/** 资产模型名 */
	protected String ename;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 资产模型二级子类 */
	protected String ekey2;
	
	/** 资产模型三级子类 */
	protected String ekey3;
	
	/** 资产模型分类使用标识 */
	protected String enable;
	
	protected String esyscoding_nq;
	
	/** 
	 * 资产模型层次码区间检索条件<br>
	 * （去掉资产模型层次码与该集合内的元素模糊匹配的资产模型信息） 
	 */
	protected List<String> delList_q;

    private String type;
	
	
	
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
	
	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public int getEid() {
		return eid;
	}


	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型ID（文字）取得
	 * @return 资产模型ID（文字）
	 */
	public String getEidStr() {
		return eidStr;
	}


	/**
	 * 资产模型ID（文字）设定
	 *
	 * @param eidStr 资产模型ID（文字）
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
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
	 * 资产模型三级子类取得
	 * @return 资产模型三级子类
	 */
	public String getEkey3() {
		return ekey3;
	}


	/**
	 * 资产模型三级子类设定
	 *
	 * @param ekey3 资产模型三级子类
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}


	/**
	 * 资产模型分类使用标识取得
	 * @return 资产模型分类使用标识
	 */
	public String getEnable() {
		return enable;
	}


	/**
	 * 资产模型分类使用标识设定
	 *
	 * @param enable 资产模型分类使用标识
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}


	public String getEparcoding() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getEsyscodingList() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEparcoding_q() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_q() {
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


	public String getEstatus() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEsyscoding_tree() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getDelList() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> getSelectList() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEcategory_q() {
		// TODO Auto-generated method stub
		return null;
	}


    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.IG117SearchCond#getType()
     */
    public String getType() {
        // TODO Auto-generated method stub
        return type;
    }

    /**
     * type is set.
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }
    
}
