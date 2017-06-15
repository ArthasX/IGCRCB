/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.cic.form.IGCIC0201Form;
import com.deliverik.infogovernor.cic.form.IGCIC0203Form;
import com.deliverik.infogovernor.cic.form.IGCIC0204Form;
import com.deliverik.infogovernor.cic.form.IGCIC0205Form;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.vo.IGCIC02022VO;
import com.deliverik.infogovernor.cic.vo.IGCIC02032VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 对比任务相关业务用DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02DTO extends BaseDTO implements Serializable{

	/** 对比执行情况查询画面FORM */
	private IGCIC0201Form igcic0201Form;

	/** 允许查询的最大记录数 */
    protected int maxSearchCount;

    /** 分页Bean */
    protected PagingDTO pagingDto;
    
    /** 对比记录集合 */
    protected List<CompareprocessInfo> compareprocessList;
    
    /** 比对结果Map */
    protected Map<String, List<IGCIC02022VO>> resultVoMap;
    
    /** 比对任务表主键 */
    protected Integer cpid;
    
    /** 匹配结果详细页面用Form */
    protected IGCIC0203Form igcic0203Form;
    protected IGCIC0205Form igcic0205Form;
    
    /** 页面显示用Map key：页面显示组名 value：显示对象Map key：模型名称 value：属性列表 */
    protected Map<String, Map<String, IGCIC02032VO>> cic0203ShowMap;
    
    /** 比对结果对象 */
    protected CompareresultInfo compareresultInfo;
    
    /** 对比结果详细画面FORM */
    protected IGCIC0204Form igcic0204Form;
    
    /**树几点的数据*/
    private Map<String,TreeNode> treeMap;
    
    private SOC0124Info soc0124Info;
    
    private Map<String,String> sourceMap;
    private Map<String,String> targetMap;
    
    /** 
     * 对比执行情况查询画面FORM 取得
     * @return igcic0201Form 对比执行情况查询画面FORM 
     */
    public IGCIC0201Form getIgcic0201Form() {
        return igcic0201Form;
    }

    /** 
     * 对比执行情况查询画面FORM 设定
     * @param igcic0201Form 对比执行情况查询画面FORM 
     */
    public void setIgcic0201Form(IGCIC0201Form igcic0201Form) {
        this.igcic0201Form = igcic0201Form;
    }

    /** 
     * 允许查询的最大记录数 取得
     * @return maxSearchCount 允许查询的最大记录数 
     */
    public int getMaxSearchCount() {
        return maxSearchCount;
    }

    /** 
     * 允许查询的最大记录数 设定
     * @param maxSearchCount 允许查询的最大记录数 
     */
    public void setMaxSearchCount(int maxSearchCount) {
        this.maxSearchCount = maxSearchCount;
    }

    /** 
     * 分页Bean 取得
     * @return pagingDto 分页Bean 
     */
    public PagingDTO getPagingDto() {
        return pagingDto;
    }

    /** 
     * 分页Bean 设定
     * @param pagingDto 分页Bean 
     */
    public void setPagingDto(PagingDTO pagingDto) {
        this.pagingDto = pagingDto;
    }

    /** 
     * 对比记录集合 取得
     * @return compareprocessList 对比记录集合 
     */
    public List<CompareprocessInfo> getCompareprocessList() {
        return compareprocessList;
    }

    /** 
     * 对比记录集合 设定
     * @param compareprocessList 对比记录集合 
     */
    public void setCompareprocessList(List<CompareprocessInfo> compareprocessList) {
        this.compareprocessList = compareprocessList;
    }

    /** 
     * 比对结果Map 取得
     * @return resultVoMap 比对结果Map 
     */
    public Map<String, List<IGCIC02022VO>> getResultVoMap() {
        return resultVoMap;
    }

    /** 
     * 比对结果Map 设定
     * @param resultVoMap 比对结果Map 
     */
    public void setResultVoMap(Map<String, List<IGCIC02022VO>> resultVoMap) {
        this.resultVoMap = resultVoMap;
    }

    /** 
     * 比对任务表主键 取得
     * @return cpid 比对任务表主键 
     */
    public Integer getCpid() {
        return cpid;
    }

    /** 
     * 比对任务表主键 设定
     * @param cpid 比对任务表主键 
     */
    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    /** 
     * 匹配结果详细页面用Form 取得
     * @return igcic0203Form 匹配结果详细页面用Form 
     */
    public IGCIC0203Form getIgcic0203Form() {
        return igcic0203Form;
    }

    /** 
     * 匹配结果详细页面用Form 设定
     * @param igcic0203Form 匹配结果详细页面用Form 
     */
    public void setIgcic0203Form(IGCIC0203Form igcic0203Form) {
        this.igcic0203Form = igcic0203Form;
    }

    /** 
     * 页面显示用Mapkey：页面显示组名value：显示对象Mapkey：模型名称value：属性列表 取得
     * @return cic0203ShowMap 页面显示用Mapkey：页面显示组名value：显示对象Mapkey：模型名称value：属性列表 
     */
    public Map<String, Map<String, IGCIC02032VO>> getCic0203ShowMap() {
        return cic0203ShowMap;
    }

    /** 
     * 页面显示用Mapkey：页面显示组名value：显示对象Mapkey：模型名称value：属性列表 设定
     * @param cic0203ShowMap 页面显示用Mapkey：页面显示组名value：显示对象Mapkey：模型名称value：属性列表 
     */
    public void setCic0203ShowMap(Map<String, Map<String, IGCIC02032VO>> cic0203ShowMap) {
        this.cic0203ShowMap = cic0203ShowMap;
    }

    /** 
     * 比对结果对象 取得
     * @return compareresultInfo 比对结果对象 
     */
    public CompareresultInfo getCompareresultInfo() {
        return compareresultInfo;
    }

    /** 
     * 比对结果对象 设定
     * @param compareresultInfo 比对结果对象 
     */
    public void setCompareresultInfo(CompareresultInfo compareresultInfo) {
        this.compareresultInfo = compareresultInfo;
    }

    /** 
     * 对比结果详细画面FORM 取得
     * @return igcic0204Form 对比结果详细画面FORM 
     */
    public IGCIC0204Form getIgcic0204Form() {
        return igcic0204Form;
    }

    /** 
     * 对比结果详细画面FORM 设定
     * @param igcic0204Form 对比结果详细画面FORM 
     */
    public void setIgcic0204Form(IGCIC0204Form igcic0204Form) {
        this.igcic0204Form = igcic0204Form;
    }

	public IGCIC0205Form getIgcic0205Form() {
		return igcic0205Form;
	}

	public void setIgcic0205Form(IGCIC0205Form igcic0205Form) {
		this.igcic0205Form = igcic0205Form;
	}

	public Map<String, TreeNode> getTreeMap() {
		return treeMap;
	}

	public void setTreeMap(Map<String, TreeNode> treeMap) {
		this.treeMap = treeMap;
	}

	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}

	public Map<String, String> getSourceMap() {
		return sourceMap;
	}

	public void setSourceMap(Map<String, String> sourceMap) {
		this.sourceMap = sourceMap;
	}

	public Map<String, String> getTargetMap() {
		return targetMap;
	}

	public void setTargetMap(Map<String, String> targetMap) {
		this.targetMap = targetMap;
	}
	
	
    
	
}


