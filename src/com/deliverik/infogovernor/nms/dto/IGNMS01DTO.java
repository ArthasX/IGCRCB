/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.nms.model.NMS01Info;
import com.deliverik.infogovernor.nms.model.NMS02Info;
import com.deliverik.infogovernor.nms.model.NMS03Info;

/**
 * 概述: 自动发现DTO
 * 功能描述: 自动发现DTO
 * 创建记录: 2013/12/20
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGNMS01DTO extends BaseDTO{
	
	/** SNMP配置信息 */
	protected NMS02Info nms02Info;
	
	/** SNMP配置列表 */
	protected List<NMS02Info> lst_NMS02Info;
	
	/** 任务配置信息 */
	protected NMS03Info nms03Info;
	
	/** 任务配置列表 */
	protected List<NMS03Info> lst_NMS03Info; 
	
	/** 组信息 */
	protected NMS01Info nms01Info;

	/** 用户id */
	protected String userid;
	
	/** 组ID */
	protected Integer groupId;
	
	/** 版本 */
	protected Integer groupVersion;
	
	/** 拓扑视图类型（1：全网拓扑 2：用户拓扑） */
	protected String topoType;
	
	/** 需要更新的设备 */
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
    protected String subNetRegion;
    
    /** 修改子网区域信息 */
    protected String updateRegionStr;
    
    /** 删除子网区域 */
    protected String delRegionStr;
    
	/** 拓扑展示用xml */
	protected String xml;
	
	/** 返回标识（0失败，1成功，-1扫描程序执行文件不存在） */
	protected int flag;
	
	/** 面板大小 */
	protected String panelSize;
	
	/** 面板大小xml */
	protected String panelSizeInfoXml;
	
	/** 拓扑设备图片路径xml */
	protected String imgUrlXml;
	
	/** 拓扑设备类型xml */
	protected String devTypeXml;
	
	/** 拓扑展现类型（1：全网拓扑图 2：网络设备拓扑图） */
    protected String showType;
    
	/**
	 * SNMP配置信息取得
	 * @return SNMP配置信息
	 */
	public NMS02Info getNms02Info() {
		return nms02Info;
	}

	/**
	 * SNMP配置信息设定
	 * @param nms02Info SNMP配置信息
	 */
	public void setNms02Info(NMS02Info nms02Info) {
		this.nms02Info = nms02Info;
	}

	/**
	 * SNMP配置列表取得
	 * @return SNMP配置列表
	 */
	public List<NMS02Info> getLst_NMS02Info() {
		return lst_NMS02Info;
	}

	/**
	 * SNMP配置列表设定
	 * @param lst_NMS02Info SNMP 配置列表
	 */
	public void setLst_NMS02Info(List<NMS02Info> lst_NMS02Info) {
		this.lst_NMS02Info = lst_NMS02Info;
	}

	/**
	 * 任务配置信息取得
	 * @return 任务配置信息
	 */
	public NMS03Info getNms03Info() {
		return nms03Info;
	}

	/**
	 * 任务配置信息设定
	 * @param nms03Info 任务配置信息
	 */
	public void setNms03Info(NMS03Info nms03Info) {
		this.nms03Info = nms03Info;
	}

	/**
	 * 任务配置列表取得
	 * @return 任务配置列表
	 */
	public List<NMS03Info> getLst_NMS03Info() {
		return lst_NMS03Info;
	}

	/**
	 * 任务配置列表设定
	 * @param lst_NMS03Info 任务配置列表
	 */
	public void setLst_NMS03Info(List<NMS03Info> lst_NMS03Info) {
		this.lst_NMS03Info = lst_NMS03Info;
	}

    /**
     * 获取组信息
     * @return 组信息 
     */
    public NMS01Info getNms01Info() {
        return nms01Info;
    }

    /**
     * 设置组信息
     * @param nms01Info 组信息
     */
    public void setNms01Info(NMS01Info nms01Info) {
        this.nms01Info = nms01Info;
    }

    /**
     * 获取用户id
     * @return 用户id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     * @param userid 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取组ID
     * @return 组ID 
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置组ID
     * @param groupId 组ID
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取版本
     * @return 版本 
     */
    public Integer getGroupVersion() {
        return groupVersion;
    }

    /**
     * 设置版本
     * @param groupVersion 版本
     */
    public void setGroupVersion(Integer groupVersion) {
        this.groupVersion = groupVersion;
    }

    /**
     * 获取拓扑视图类型（1：全网拓扑2：用户拓扑）
     * @return 拓扑视图类型（1：全网拓扑2：用户拓扑） 
     */
    public String getTopoType() {
        return topoType;
    }

    /**
     * 设置拓扑视图类型（1：全网拓扑2：用户拓扑）
     * @param topoType 拓扑视图类型（1：全网拓扑2：用户拓扑）
     */
    public void setTopoType(String topoType) {
        this.topoType = topoType;
    }

    /**
     * 获取需要更新的设备
     * @return 需要更新的设备 
     */
    public String getUpdateDevice() {
        return updateDevice;
    }

    /**
     * 设置需要更新的设备
     * @param updateDevice 需要更新的设备
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
     * subNetRegion is returned.
     * @return subNetRegion
     */
    public String getSubNetRegion() {
        return subNetRegion;
    }

    /**
     * subNetRegion is set.
     * @param subNetRegion subNetRegion
     */
    public void setSubNetRegion(String subNetRegion) {
        this.subNetRegion = subNetRegion;
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
     * 获取拓扑展示用xml
     * @return 拓扑展示用xml 
     */
    public String getXml() {
        return xml;
    }

    /**
     * 设置拓扑展示用xml
     * @param xml 拓扑展示用xml
     */
    public void setXml(String xml) {
        this.xml = xml;
    }

	/**
	 * 是否成功标识取得
	 * @return 是否成功标识
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * 是否成功标识设定
	 * @param flag 是否成功标识
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

    /**
     * 获取面板大小
     * @return 面板大小 
     */
    public String getPanelSize() {
        return panelSize;
    }

    /**
     * 设置面板大小
     * @param panelSize 面板大小
     */
    public void setPanelSize(String panelSize) {
        this.panelSize = panelSize;
    }

    /**
     * 获取面板大小xml
     * @return 面板大小xml 
     */
    public String getPanelSizeInfoXml() {
        return panelSizeInfoXml;
    }

    /**
     * 设置面板大小xml
     * @param panelSizeInfoXml 面板大小xml
     */
    public void setPanelSizeInfoXml(String panelSizeInfoXml) {
        this.panelSizeInfoXml = panelSizeInfoXml;
    }

	/**
	 * 拓扑设备图片路径xml取得
	 * @return imgUrlXml 拓扑设备图片路径xml
	 */
	public String getImgUrlXml() {
		return imgUrlXml;
	}

	/**
	 * 拓扑设备图片路径xml设定
	 * @param imgUrlXml 拓扑设备图片路径xml
	 */
	public void setImgUrlXml(String imgUrlXml) {
		this.imgUrlXml = imgUrlXml;
	}

	/**
	 * 拓扑设备类型xml取得
	 * @return devTypeXml 拓扑设备类型xml
	 */
	public String getDevTypeXml() {
		return devTypeXml;
	}

	/**
	 * 拓扑设备类型xml设定
	 * @param devTypeXml 拓扑设备类型xml
	 */
	public void setDevTypeXml(String devTypeXml) {
		this.devTypeXml = devTypeXml;
	}

    /**
     * 获取拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @return 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图） 
     */
    public String getShowType() {
        return showType;
    }

    /**
     * 设置拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     * @param showType 拓扑展现类型（1：全网拓扑图2：网络设备拓扑图）
     */
    public void setShowType(String showType) {
        this.showType = showType;
    }
	
}
