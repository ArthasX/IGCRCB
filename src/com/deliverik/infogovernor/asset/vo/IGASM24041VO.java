package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 发票详细信息VO
 * 
 * @author
 * 修改记录: 2012/11/27 LuJiayuan 增加标识判断是否显示图像按钮
 */
@SuppressWarnings("serial")
public class IGASM24041VO extends BaseVO implements Serializable{
	
	/** 发票信息 */
	protected IG688Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** 图像扫描XML */
    protected String picuXml;
    
    /** 图像查看XML */
    protected String picsXml;
    
    /** 图像显示标识 */
	protected Boolean image_flag;

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM24041VO(IG688Info entityItemData,Map<String,List<IG002Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** 发票所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * 发票信息取得
	 * @return 发票信息
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

    /**
     * 图像扫描XML is returned.
     * @return picuXml
     */
    public String getPicuXml() {
        return picuXml;
    }

    /**
     * 图像扫描XML is set.
     * @param picuXml 图像扫描XML
     */
    public void setPicuXml(String picuXml) {
        this.picuXml = picuXml;
    }

    /**
     * 图像查看XML is returned.
     * @return picsXml
     */
    public String getPicsXml() {
        return picsXml;
    }

    /**
     * 图像查看XML is set.
     * @param picsXml 图像查看XML
     */
    public void setPicsXml(String picsXml) {
        this.picsXml = picsXml;
    }
	
    /**
	 * 图像显示标识取得
	 *
	 * @return image_flag 图像显示标识
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	/**
	 * 图像显示标识设定
	 *
	 * @param image_flag 图像显示标识
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
}