/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 网络拓扑自动发现form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGNMS0101Form extends BaseForm {

	/** 组ID */
	protected Integer gid;
	
	/** 组版本 */
	protected Integer gversion;
	
	/**  拓扑类型*/
	protected String topotype;
	
	/** 更新设备 */
	protected String updateDevice;
	
	/** 添加设备 */
	protected String addDevice;
	
	/** 添加链路 */
	protected String addRela;
	
	/** 删除设备 */
	protected String delDevice;
	
	/** 删除链路 */
	protected String delRela;

	/** 修改设备名称 */
	protected String renameDevice;
	
	/** 子网区域 */
	protected String regionStr;
	
	/** 修改子网区域信息 */
	protected String updateRegionStr;
	
	/** 删除子网区域 */
	protected String delRegionStr;
	
	/** 修改面板大小 */
	protected String panelSize;
	
	/** 编辑模式类型 */
	protected String editModeType;
	
	/** 拓扑展现类型（1：全网拓扑图 2：网络设备拓扑图） */
    protected String showtype;
	
	/**
	 * 组ID取得
	 * @return 组ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * 组ID设定
	 * @param gid 组ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * 组版本取得
	 * @return 组版本
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * 组版本设定
	 * @param gversion 组版本
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

    /**
     * 获取拓扑类型
     * @return 拓扑类型 
     */
    public String getTopotype() {
        return topotype;
    }

    /**
     * 设置拓扑类型
     * @param topotype 拓扑类型
     */
    public void setTopotype(String topotype) {
        this.topotype = topotype;
    }

    /**
     * 获取更新设备
     * @return 更新设备 
     */
    public String getUpdateDevice() {
        return updateDevice;
    }

    /**
     * 设置更新设备
     * @param updateDevice 更新设备
     */
    public void setUpdateDevice(String updateDevice) {
        this.updateDevice = updateDevice;
    }

    /**
     * 获取添加设备
     * @return 添加设备 
     */
    public String getAddDevice() {
        return addDevice;
    }

    /**
     * 设置添加设备
     * @param addDevice 添加设备
     */
    public void setAddDevice(String addDevice) {
        this.addDevice = addDevice;
    }

    /**
     * 获取添加链路
     * @return 添加链路 
     */
    public String getAddRela() {
        return addRela;
    }

    /**
     * 设置添加链路
     * @param addRela 添加链路
     */
    public void setAddRela(String addRela) {
        this.addRela = addRela;
    }

    /**
     * 获取删除设备
     * @return 删除设备 
     */
    public String getDelDevice() {
        return delDevice;
    }

    /**
     * 设置删除设备
     * @param delDevice 删除设备
     */
    public void setDelDevice(String delDevice) {
        this.delDevice = delDevice;
    }

    /**
     * 获取删除链路
     * @return 删除链路 
     */
    public String getDelRela() {
        return delRela;
    }

    /**
     * 设置删除链路
     * @param delRela 删除链路
     */
    public void setDelRela(String delRela) {
        this.delRela = delRela;
    }

    /**
     * 获取修改设备名称
     * @return 修改设备名称 
     */
    public String getRenameDevice() {
        return renameDevice;
    }

    /**
     * 设置修改设备名称
     * @param renameDevice 修改设备名称
     */
    public void setRenameDevice(String renameDevice) {
        this.renameDevice = renameDevice;
    }

    /**
     * regionStr is returned.
     * @return regionStr
     */
    public String getRegionStr() {
        return regionStr;
    }

    /**
     * regionStr is set.
     * @param regionStr regionStr
     */
    public void setRegionStr(String regionStr) {
        this.regionStr = regionStr;
    }

    /**
     * updateRegionStr is returned.
     * @return updateRegionStr
     */
    public String getUpdateRegionStr() {
        return updateRegionStr;
    }

    /**
     * updateRegionStr is set.
     * @param updateRegionStr updateRegionStr
     */
    public void setUpdateRegionStr(String updateRegionStr) {
        this.updateRegionStr = updateRegionStr;
    }

    /**
     * 获取删除子网区域
     * @return 删除子网区域 
     */
    public String getDelRegionStr() {
        return delRegionStr;
    }

    /**
     * 设置删除子网区域
     * @param delRegionStr 删除子网区域
     */
    public void setDelRegionStr(String delRegionStr) {
        this.delRegionStr = delRegionStr;
    }

    /**
     * 获取修改面板大小
     * @return 修改面板大小 
     */
    public String getPanelSize() {
        return panelSize;
    }

    /**
     * 设置修改面板大小
     * @param panelSize 修改面板大小
     */
    public void setPanelSize(String panelSize) {
        this.panelSize = panelSize;
    }

    /**
     * 获取编辑模式类型
     * @return 编辑模式类型 
     */
    public String getEditModeType() {
        return editModeType;
    }

    /**
     * 设置编辑模式类型
     * @param editModeType 编辑模式类型
     */
    public void setEditModeType(String editModeType) {
        this.editModeType = editModeType;
    }

    /**
     * 获取拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @return 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图） 
     */
    public String getShowtype() {
        return showtype;
    }

    /**
     * 设置拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @param showtype 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     */
    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }
	
}
