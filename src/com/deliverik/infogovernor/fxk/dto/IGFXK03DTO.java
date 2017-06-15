package com.deliverik.infogovernor.fxk.dto;



import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0302Form;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 参数传递DTO
 * </p>
 * 2014-7-24
 * 
 * @author fenghuan@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK03DTO extends BaseDTO {
	
	   /** 允许查询的最大记录数 */
	private int maxSearchCount;
	
    /**获得的信息map*/
    private Map<RiskprojectvwInfo,Map<String,Map<String,String>>> infomap;

    /** 分页Bean */
    private PagingDTO pagingDto;
    
    /** 用户首页列表 */
    private List<LabelValueBean> lst_LabelValueBean;
    
    private IGFXK0302Form form0302;
    
    /** 用户负责人列表*/
    private List<LabelValueBean> Peo_LabelValueBean;

	/**
	 * 允许查询的最大记录数取得
	 * @return maxSearchCount 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 获得的信息map取得
	 * @return infomap 获得的信息map
	 */
	public Map<RiskprojectvwInfo, Map<String, Map<String, String>>> getInfomap() {
		return infomap;
	}

	/**
	 * 获得的信息map设定
	 * @param infomap 获得的信息map
	 */
	public void setInfomap(
			Map<RiskprojectvwInfo, Map<String, Map<String, String>>> infomap) {
		this.infomap = infomap;
	}

	/**
	 * 分页Bean取得
	 * @return pagingDto 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 用户首页列表取得
	 * @return lst_LabelValueBean 用户首页列表
	 */
	public List<LabelValueBean> getLst_LabelValueBean() {
		return lst_LabelValueBean;
	}

	/**
	 * 用户首页列表设定
	 * @param lst_LabelValueBean 用户首页列表
	 */
	public void setLst_LabelValueBean(List<LabelValueBean> lst_LabelValueBean) {
		this.lst_LabelValueBean = lst_LabelValueBean;
	}

	/**
	 * form0302取得
	 * @return form0302 form0302
	 */
	public IGFXK0302Form getForm0302() {
		return form0302;
	}

	/**
	 * form0302设定
	 * @param form0302 form0302
	 */
	public void setForm0302(IGFXK0302Form form0302) {
		this.form0302 = form0302;
	}

	/**
	 * peo_LabelValueBean取得
	 * @return peo_LabelValueBean peo_LabelValueBean
	 */
	public List<LabelValueBean> getPeo_LabelValueBean() {
		return Peo_LabelValueBean;
	}

	/**
	 * peo_LabelValueBean设定
	 * @param peo_LabelValueBean peo_LabelValueBean
	 */
	public void setPeo_LabelValueBean(List<LabelValueBean> peo_LabelValueBean) {
		Peo_LabelValueBean = peo_LabelValueBean;
	}

}
