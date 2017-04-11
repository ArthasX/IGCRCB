/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.nms.bl.task.NMS01BL;
import com.deliverik.infogovernor.nms.bl.task.NMS02BL;
import com.deliverik.infogovernor.nms.bl.task.NMS03BL;
import com.deliverik.infogovernor.nms.bl.task.NMS04BL;
import com.deliverik.infogovernor.nms.bl.task.NMS05BL;
import com.deliverik.infogovernor.nms.bl.task.NMS06BL;
import com.deliverik.infogovernor.nms.bl.task.NMS07BL;
import com.deliverik.infogovernor.nms.bl.task.NMS08BL;
import com.deliverik.infogovernor.nms.bl.task.NMS09BL;
import com.deliverik.infogovernor.nms.bl.task.NMS10BL;
import com.deliverik.infogovernor.nms.bl.task.NMS11BL;
import com.deliverik.infogovernor.nms.bl.task.NMS12BL;
import com.deliverik.infogovernor.nms.bl.task.NMS13BL;
import com.deliverik.infogovernor.nms.bl.task.NMS16BL;
import com.deliverik.infogovernor.nms.bl.task.NMS17BL;
import com.deliverik.infogovernor.nms.bl.task.NMSBaseBLImpl;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;
import com.deliverik.infogovernor.nms.form.IGNMS0102Form;
import com.deliverik.infogovernor.nms.form.IGNMS0103Form;
import com.deliverik.infogovernor.nms.model.NMS01Info;
import com.deliverik.infogovernor.nms.model.NMS04Info;
import com.deliverik.infogovernor.nms.model.NMS04VWInfo;
import com.deliverik.infogovernor.nms.model.NMS07Info;
import com.deliverik.infogovernor.nms.model.NMS08Info;
import com.deliverik.infogovernor.nms.model.NMS09Info;
import com.deliverik.infogovernor.nms.model.NMS12Info;
import com.deliverik.infogovernor.nms.model.NMS13Info;
import com.deliverik.infogovernor.nms.model.NMS16Info;
import com.deliverik.infogovernor.nms.model.NMS17Info;
import com.deliverik.infogovernor.nms.model.condition.NMS02SearchCondImpl;
import com.deliverik.infogovernor.nms.model.condition.NMS03SearchCondImpl;
import com.deliverik.infogovernor.nms.model.condition.NMS04VWSearchCondImpl;
import com.deliverik.infogovernor.nms.model.condition.NMS07SearchCondImpl;
import com.deliverik.infogovernor.nms.model.condition.NMS08SearchCondImpl;
import com.deliverik.infogovernor.nms.model.condition.NMS09SearchCondImpl;
import com.deliverik.infogovernor.nms.model.condition.NMS12SearchCondImpl;
import com.deliverik.infogovernor.nms.model.condition.NMS16SearchCondImpl;
import com.deliverik.infogovernor.nms.model.condition.NMS17SearchCondImpl;
import com.deliverik.infogovernor.nms.model.entity.NMS04TB;
import com.deliverik.infogovernor.nms.model.entity.NMS05TB;
import com.deliverik.infogovernor.nms.model.entity.NMS08TB;
import com.deliverik.infogovernor.nms.model.entity.NMS09TB;
import com.deliverik.infogovernor.nms.model.entity.NMS10TB;
import com.deliverik.infogovernor.nms.model.entity.NMS12TB;
import com.deliverik.infogovernor.nms.model.entity.NMS13TB;
import com.deliverik.infogovernor.nms.model.entity.NMS16TB;
import com.deliverik.infogovernor.nms.model.entity.NMS17TB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 概述: 自动发现BL实现
 * 功能描述: 自动发现BL实现
 * 创建记录: 2013/12/20
 * 修改记录: 
 */
public class IGNMS01BLImpl extends NMSBaseBLImpl implements IGNMS01BL{
    
    static Log log = LogFactory.getLog(IGNMS01BLImpl.class);
    
	/** 组信息实体BL */
	protected NMS01BL nms01BL;
	
	/** SNMP参数信息实体BL */
	protected NMS02BL nms02BL;
	
	/** 发现任务信息实体BL */
	protected NMS03BL nms03BL;
	
	/** 设备信息实体BL */
	protected NMS04BL nms04BL;
	
	/** 设备组关系信息实体BL */
	protected NMS05BL nms05BL;
	
	/** 设备MAC/IP信息实体BL */
	protected NMS06BL nms06BL;
	
	/** 链路信息实体BL */
	protected NMS07BL nms07BL;
	
	/** 设备黑名单信息实体BL */
	protected NMS08BL nms08BL;
	
	/** 用户拓扑视图信息实体BL */
	protected NMS09BL nms09BL;
	
	/** 链路黑名单信息实体BL */
	protected NMS10BL nms10BL;
	
	/** 任务日志实体BL */
	protected NMS11BL nms11BL;
	
	/** 设备白名单信息BL */
	protected NMS12BL nms12BL;
	
	/** 链路白名单信息BL */
	protected NMS13BL nms13BL;
	
	/** 组设备坐标实体BL */
	protected NMS16BL nms16BL;
	
	/** 子网区域实体BL */
	protected NMS17BL nms17BL;
	
	/** 基础数据BL */
	protected CodeListUtils codeListUtils;
	
	/** 基础数据BL */
	protected CodeDetailBL codeDetailBL;

	/**
	 * 组信息实体BL设定
	 * @param nms01BL 组信息实体BL
	 */
	public void setNms01BL(NMS01BL nms01bl) {
		nms01BL = nms01bl;
	}
	
	/**
	 * SNMP参数信息实体BL设定
	 * @param nms02BL SNMP参数信息实体BL
	 */
	public void setNms02BL(NMS02BL nms02bl) {
		nms02BL = nms02bl;
	}

	/**
	 * 发现任务信息实体BL设定
	 * @param nms03BL 发现任务信息实体BL
	 */
	public void setNms03BL(NMS03BL nms03bl) {
		nms03BL = nms03bl;
	}

	/**
	 * 设备信息实体BL设定
	 * @param nms04BL 设备信息实体BL
	 */
	public void setNms04BL(NMS04BL nms04bl) {
		nms04BL = nms04bl;
	}

	/**
	 * 设备组关系信息实体BL设定
	 * @param nms05BL 设备组关系信息实体BL
	 */
	public void setNms05BL(NMS05BL nms05bl) {
		nms05BL = nms05bl;
	}

	/**
	 * 设备MACIP信息实体BL设定
	 * @param nms06BL 设备MACIP信息实体BL
	 */
	public void setNms06BL(NMS06BL nms06bl) {
		nms06BL = nms06bl;
	}

	/**
	 * 链路信息实体BL设定
	 * @param nms07BL 链路信息实体BL
	 */
	public void setNms07BL(NMS07BL nms07bl) {
		nms07BL = nms07bl;
	}

	/**
	 * 设备黑名单信息实体BL设定
	 * @param nms08BL 设备黑名单信息实体BL
	 */
	public void setNms08BL(NMS08BL nms08bl) {
		nms08BL = nms08bl;
	}

	/**
	 * 用户拓扑视图信息实体BL设定
	 * @param nms09BL 用户拓扑视图信息实体BL
	 */
	public void setNms09BL(NMS09BL nms09bl) {
		nms09BL = nms09bl;
	}

	/**
	 * 链路黑名单信息实体BL设定
	 * @param nms10BL 链路黑名单信息实体BL
	 */
	public void setNms10BL(NMS10BL nms10bl) {
		nms10BL = nms10bl;
	}

	/**
	 * 任务日志实体BL设定
	 * @param nms11BL 任务日志实体BL
	 */
	public void setNms11BL(NMS11BL nms11bl) {
		nms11BL = nms11bl;
	}
	
	/**
     * 设置设备白名单信息BL
     * @param nms12BL 设备白名单信息BL
     */
    public void setNms12BL(NMS12BL nms12bl) {
        nms12BL = nms12bl;
    }

    /**
     * 设置链路白名单信息BL
     * @param nms13BL 链路白名单信息BL
     */
    public void setNms13BL(NMS13BL nms13bl) {
        nms13BL = nms13bl;
    }

    /**
     * 设置组设备坐标实体BL
     * @param nms16BL 组设备坐标实体BL
     */
    public void setNms16BL(NMS16BL nms16bl) {
        nms16BL = nms16bl;
    }
	
	/**
     * nms17BL is set.
     * @param nms17bl nms17BL
     */
    public void setNms17BL(NMS17BL nms17bl) {
        nms17BL = nms17bl;
    }

    /**
	 * 基础数据BL设定
	 * @param codeDetailBL 基础数据BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 获取组版本
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO searchGroupVersionAction(IGNMS01DTO dto) throws BLException {
		log.debug("========获取组版本处理开始========");
		dto.setGroupVersion(nms01BL.searchByPK(dto.getGroupId()).getVersion());
		log.debug("========获取组版本处理结束========");
		return dto;
	}
    
    /**
     * 设置基础数据BL
     * @param codeListUtils 基础数据BL
     */
    public void setCodeListUtils(CodeListUtils codeListUtils) {
        this.codeListUtils = codeListUtils;
    }

    /**
     * 查询拓扑xml
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGNMS01DTO searchTopoXML(IGNMS01DTO dto) throws BLException {
        log.debug("=============== 查询拓扑xml处理开始 ===============");
        
        String userid = dto.getUserid(); // 用户id
        Integer groupId = dto.getGroupId(); // 组id
        String topoType = dto.getTopoType(); // 拓扑视图类型
        // 当组信息为空时查询默认组
        groupId = groupId != null ? groupId : GROUPID_DEFAULT;
        String topoShowType = StringUtils.isNotEmpty(dto.getShowType()) ? dto.getShowType() : IGNMS01BLType.TOPOSHOWTYPE_ALL;
        
        // 查询组信息
        NMS01Info nms01Info = nms01BL.searchByPK(groupId);
        Integer gversion = dto.getGroupVersion(); // 组版本
        gversion = gversion != null ? gversion : nms01Info.getVersion(); // 当版本为空时显示最新版
        
        // 实例化并设置查询条件
        NMS09SearchCondImpl nms09cond = new NMS09SearchCondImpl();
        nms09cond.setGid_eq(groupId);
        nms09cond.setGversion_eq(gversion);
        boolean isAll = false; // 是否是全网拓扑标识
        // 全网拓扑
        if (StringUtils.isEmpty(topoType) || IGNMS01BLType.TOPOTYPE_ALL.equals(topoType)) {
            nms09cond.setUseridEmpty(true);
            isAll = true;
        } 
        // 用户拓扑
        else if (IGNMS01BLType.TOPOTYPE_USER.equals(topoType)) {
            nms09cond.setUserid_eq(userid);
        } 
        
        nms09cond.setShowtype(topoShowType);
        // 查询用户拓扑
        List<NMS09Info> nms09InfoList = nms09BL.search(nms09cond);
        NMS09TB nms09TB = null;
        String xml = "";
        if (nms09InfoList.size() > 0) {
            nms09TB = (NMS09TB) SerializationUtils.clone(nms09InfoList.get(0));
            xml = nms09TB.getXml();
        } else {
            if(!isAll){
                nms09cond.setUseridEmpty(true);
                nms09cond.setUserid_eq(null);
                nms09InfoList = nms09BL.search(nms09cond);
                if (nms09InfoList.size() > 0) {
                    nms09TB = (NMS09TB) SerializationUtils.clone(nms09InfoList.get(0));
                    xml = nms09TB.getXml();
                }else{
	            	 Document document = DocumentHelper.createDocument();
	                 document.addElement("root");
	                 xml = document.asXML();
	                 if(IGNMS01BLType.TOPOSHOWTYPE_NEWWORK.equals(topoShowType)){
	                     xml = createNetWorkTopoXML(nms01Info, isAll, userid);
	                 }
                }
            } else {
                Document document = DocumentHelper.createDocument();
                document.addElement("root");
                xml = document.asXML();
                if(IGNMS01BLType.TOPOSHOWTYPE_NEWWORK.equals(topoShowType)){
                    xml = createNetWorkTopoXML(nms01Info, isAll, userid);
                }
            }
        }
        
        dto.setXml(xml);
        log.debug("=============== 查询拓扑xml处理结束 ===============");
        return dto;
    }

    /**
	 *  生成拓扑显示用xml
	 *  
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
    public IGNMS01DTO saveTopoXML(IGNMS01DTO dto) throws BLException {
	    log.debug("=============== 生成拓扑xml处理开始 ================");
	    
	    
	    String userid = dto.getUserid(); // 用户id
	    Integer groupId = dto.getGroupId(); // 组id
	    String topoType = dto.getTopoType(); // 拓扑视图类型
	    // 当组信息为空时查询默认组
	    groupId = groupId != null ? groupId : GROUPID_DEFAULT;
	    
	    String topoShowType = StringUtils.isNotEmpty(dto.getShowType()) ? dto.getShowType() : IGNMS01BLType.TOPOSHOWTYPE_ALL;
	    // 查询组信息
	    NMS01Info nms01Info = nms01BL.searchByPK(groupId);
	    Integer gversion = nms01Info.getVersion(); // 当前组最新版本
	    
	    nms16BL.setVersion(gversion);
	    if(!nms16BL.checkTableExits()){
	        nms16BL.upateVersion();
	    }
//	    nms07BL.setVersion(gversion);
//	    nms07BL.upateVersion();
	    
        
	    // 实例化并设置查询条件
        NMS09SearchCondImpl nms09cond = new NMS09SearchCondImpl();
        nms09cond.setGid_eq(groupId);
        nms09cond.setGversion_eq(gversion);
        boolean isAll = false;
        // 全网拓扑
        if (StringUtils.isEmpty(topoType) || IGNMS01BLType.TOPOTYPE_ALL.equals(topoType)) {
            nms09cond.setUseridEmpty(true);
            isAll = true;
        } 
        // 用户拓扑
        else if (IGNMS01BLType.TOPOTYPE_USER.equals(topoType)) {
            nms09cond.setUserid_eq(userid);
        } 
        
        // 生成拓扑展示XML
        String topoXML = "";
        if(IGNMS01BLType.TOPOSHOWTYPE_ALL.equals(topoShowType)){
            topoXML = createTopoXML(nms01Info, isAll, userid);
        } else {
            topoXML = createNetWorkTopoXML(nms01Info, isAll, userid);
        }
        
        nms09cond.setShowtype(topoShowType);
        // 查询用户拓扑
        List<NMS09Info> nms09InfoList = nms09BL.search(nms09cond);
        NMS09TB nms09TB = null;
        if (nms09InfoList.size() > 0) {
            nms09TB = (NMS09TB) SerializationUtils.clone(nms09InfoList.get(0));
        } else {
            nms09TB = new NMS09TB();
            nms09TB.setGid(groupId);
            nms09TB.setGversion(gversion);
            // 用户拓扑保存用户id
            if (!isAll) {
                nms09TB.setUserid(userid);
            }
        }
        nms09TB.setShowtype(topoShowType);
        nms09TB.setXml(topoXML);
        nms09BL.regist(nms09TB);
	    log.debug("=============== 生成拓扑xml处理结束 ================");
	    return dto;
	}
	
	/**
	 * 创建XML
	 * 
	 * @param nms01Info 组信息
	 * @throws BLException 
	 */
	private String createTopoXML(NMS01Info nms01Info,boolean isAll, String userid) throws BLException{
	    log.debug("============ 创建XML处理开始 ==================");
	    Integer version = nms01Info.getVersion();
	    Integer gid = nms01Info.getId();
	    Integer gversion = nms01Info.getVersion();
	    
	    // 创建XML Document对象
	    Document document = DocumentHelper.createDocument();
	    Element rootElement = document.addElement("root");
	    
	    // 查询设备信息
	    NMS04VWSearchCondImpl nms04cond = new NMS04VWSearchCondImpl();
	    nms04cond.setGid(gid);
	    nms04cond.setGversion(gversion);
	    if(!isAll){
	        nms04cond.setUserid(userid);
        }
	    nms04cond.setShowType(IGNMS01BLType.TOPOSHOWTYPE_ALL);
	    List<NMS04VWInfo> nms04InfoList = nms04BL.searchDeviceByGroup(nms04cond, version);
	    
        // 设备信息
	    for (NMS04VWInfo nms04Info : nms04InfoList) {
	        Element nodeElement = rootElement.addElement("NODE");
	        nodeElement.addAttribute("id", nms04Info.getId());                                 // 设备ID  
	        nodeElement.addAttribute("devid", "");                                             // 预留
	        nodeElement.addAttribute("alert", "false");                                        //
            nodeElement.addAttribute("name", StringUtils.isNotEmpty(nms04Info.getDispname()) ? nms04Info.getDispname()
                    : nms04Info.getIp() + "_" + nms04Info.getName());                          // 显示名称（设备IP+设备名称）
	        
	        nodeElement.addAttribute("x", nms04Info.getX());                                   // TOPO X坐标
	        nodeElement.addAttribute("y", nms04Info.getY());                                   // TOPO Y坐标
	        // 根据设备类型获取显示图片
            String imgurl = codeListUtils.getCodeValue(CodeDefine.getCodeDefine("TOPO_DEVICE_TYPE").getCcid(), "", "",
                    nms04Info.getType());
	        nodeElement.addAttribute("imgUrl", imgurl);                                        // 显示图片
	        nodeElement.addAttribute("frontPanel", "1");                                       // 前面板
	        nodeElement.addAttribute("backPanel", "2");                                        // 后面板
	        Integer eiid = nms04Info.getEiid();
	        String eiid_str = null != eiid ? eiid +"" : "";
	        nodeElement.addAttribute("eiid", eiid_str);                                        // 对应资产ID
	        nodeElement.addAttribute("resid", "");     											// 性能
	        //byf start
	        nodeElement.addAttribute("eirootmark", eiid_str);
	        Integer eiversion = nms04Info.getEiversion();
	        String eiversion_str=null!=eiversion?eiversion+"":"";
	        nodeElement.addAttribute("eiversion", eiversion_str);
	        Integer eismallversion = nms04Info.getEismallVersion();
	        String eismallversion_str=null!=eismallversion?eismallversion+"":"";
	        nodeElement.addAttribute("eismallversion", eismallversion_str);
	        //byf end
        }
	    
	    // 查询链路信息
	    NMS07SearchCondImpl nms07cond = new NMS07SearchCondImpl();
	    nms07cond.setGid(gid);
	    nms07cond.setGversion(gversion);
	    nms07BL.setVersion(version);
	    nms07cond.setFilterBlacklist(true);
	    nms07cond.setMergeWhitelist(true);
	    if(!isAll){
	        nms07cond.setUserid(userid);
	    }
	    List<NMS07Info> nms07InfoList = nms07BL.search(nms07cond);
	    //<LINE colorType='1' id='xx' frDesc='流量: 10MB\/s' portFromId='88' portToId='99' prDesc='端口关系: FA0/0 - FA0/2' fromNode='1150' toNode='1151'/>
	    // 链路信息
	    for (NMS07Info nms07Info : nms07InfoList) {
	        Element nodeElement = rootElement.addElement("LINE");
            nodeElement.addAttribute("id", nms07Info.getId());                                  // 链路id   
            nodeElement.addAttribute("colorType", "");                           // 线的颜色  
            nodeElement.addAttribute("fromNode", nms07Info.getFromdid() + "");                  // 源设备
            nodeElement.addAttribute("portFromId", nms07Info.getFromPhysicalPort() + "");       // 源端口
            nodeElement.addAttribute("toNode", nms07Info.getTodid() + "");                      // 目标设备
            nodeElement.addAttribute("portToId", nms07Info.getTopHysicalPort() + "");          // 目标端口
            String fromNode = StringUtils.isNotEmpty(nms07Info.getFromNodeIfName()) ? nms07Info.getFromNodeIfName() : nms07Info.getFromPhysicalPort() + "";
            String toNode = StringUtils.isNotEmpty(nms07Info.getToNodeIfName()) ? nms07Info.getToNodeIfName() : nms07Info.getTopHysicalPort() + "";
            String prdesc = fromNode + " - " + toNode;
            nodeElement.addAttribute("prDesc", prdesc);                         // 链路描述
            nodeElement.addAttribute("frDesc", "");                                           // 流量描述
        }
	    
	    // 查询子网区域信息
	    NMS17SearchCondImpl nms17cond = new NMS17SearchCondImpl();
	    nms17cond.setGid(gid);
	    nms17cond.setGversion(gversion);
	    if(!isAll){
	        nms17cond.setUserid(userid);
	    }
	    List<NMS17Info> searchNMS17 = nms17BL.searchNMS17(nms17cond);
	    for (NMS17Info nms17Info : searchNMS17) {
	        Element regionElement = rootElement.addElement("REGION");
	        regionElement.addAttribute("id", nms17Info.getId());   
	        regionElement.addAttribute("x", nms17Info.getX());   
	        regionElement.addAttribute("y", nms17Info.getY());   
	        regionElement.addAttribute("width", nms17Info.getWidth());   
	        regionElement.addAttribute("height", nms17Info.getHeight());   
	        regionElement.addAttribute("title", nms17Info.getTitle());   
	        regionElement.addAttribute("rotation", nms17Info.getRotation());   
        }
	    log.debug("============ 创建XML处理结束 ==================");	    
	    return document.asXML();
	}
	
	/**
	 * 创建XML
	 * 
	 * @param nms01Info 组信息
	 * @throws BLException 
	 */
	private String createNetWorkTopoXML(NMS01Info nms01Info,boolean isAll, String userid) throws BLException{
	    log.debug("============ 创建XML处理开始 ==================");
	    Integer version = nms01Info.getVersion();
	    Integer gid = nms01Info.getId();
	    Integer gversion = nms01Info.getVersion();
	    
	    // 创建XML Document对象
	    Document document = DocumentHelper.createDocument();
	    Element rootElement = document.addElement("root");
	    
	    // 查询设备信息
	    NMS04VWSearchCondImpl nms04cond = new NMS04VWSearchCondImpl();
	    nms04cond.setGid(gid);
	    nms04cond.setGversion(gversion);
	    if(!isAll){
	        nms04cond.setUserid(userid);
	    }
	    nms04cond.setShowType(IGNMS01BLType.TOPOSHOWTYPE_NEWWORK);
	    List<NMS04VWInfo> nms04InfoList = nms04BL.searchDeviceByGroup(nms04cond, version);
	    if(nms04InfoList.size() == 0){
	        nms04cond.setShowType(IGNMS01BLType.TOPOSHOWTYPE_ALL);
	        nms04InfoList = nms04BL.searchDeviceByGroup(nms04cond, version);
	    }
	    // 储存网络设备Map
	    Map<String, String> networkDeviceMap = new HashMap<String, String>();
	    // 设备信息
	    for (NMS04VWInfo nms04Info : nms04InfoList) {
	        
            if (IGNMS01BLType.DEVICETYPE_AIX.equals(nms04Info.getType())
                    || IGNMS01BLType.DEVICETYPE_LINUX.equals(nms04Info.getType())
                    || IGNMS01BLType.DEVICETYPE_WIN.equals(nms04Info.getType())
                    || IGNMS01BLType.DEVICETYPE_COMPUTER.equals(nms04Info.getType())
                    || StringUtils.isEmpty(nms04Info.getType().trim())) {
	            continue;
	        }
            networkDeviceMap.put(nms04Info.getId(), nms04Info.getId());
	        Element nodeElement = rootElement.addElement("NODE");
	        nodeElement.addAttribute("id", nms04Info.getId());                                 // 设备ID  
	        nodeElement.addAttribute("devid", "");                                             // 预留
	        nodeElement.addAttribute("alert", "false");                                        //
	        nodeElement.addAttribute("name", StringUtils.isNotEmpty(nms04Info.getDispname()) ? nms04Info.getDispname()
	                : nms04Info.getIp() + "_" + nms04Info.getName());                          // 显示名称（设备IP+设备名称）
	        
	        nodeElement.addAttribute("x", nms04Info.getX());                                   // TOPO X坐标
	        nodeElement.addAttribute("y", nms04Info.getY());                                   // TOPO Y坐标
	        if(StringUtils.isEmpty(nms04Info.getX())||StringUtils.isEmpty(nms04Info.getY())){
	        	nms16BL.setVersion(gversion);
	        	NMS16SearchCondImpl cond16 = new NMS16SearchCondImpl();
	            cond16.setDid(nms04Info.getId());
	            cond16.setGid(gid);
	            cond16.setGversion(gversion);
	            if(!isAll){
	            	cond16.setUserid(userid);
	            }else{
	            	cond16.setUseridEmpty(true);
	            }
	            List<NMS16Info> list16 = nms16BL.search(cond16);
	            
	            if(list16 != null && list16.size() > 0){
	            	nodeElement.addAttribute("x", list16.get(0).getX());                                   // TOPO X坐标
	            	nodeElement.addAttribute("y", list16.get(0).getY());                                   // TOPO Y坐标
	            }else{
	            	if(!isAll){
	            		cond16.setUseridEmpty(true);
	            		cond16.setUserid(null);
	            		List<NMS16Info> list_16 = nms16BL.search(cond16);
	            		 if(list16 != null && list_16.size() > 0){
	     	            	nodeElement.addAttribute("x", list_16.get(0).getX());                                   // TOPO X坐标
	     	            	nodeElement.addAttribute("y", list_16.get(0).getY());                                   // TOPO Y坐标
	     	            }
	            	}
	            }
	        }
	        // 根据设备类型获取显示图片
	        String imgurl = codeListUtils.getCodeValue(CodeDefine.getCodeDefine("TOPO_DEVICE_TYPE").getCcid(), "", "",
	                nms04Info.getType());
	        nodeElement.addAttribute("imgUrl", imgurl);                                        // 显示图片
	        nodeElement.addAttribute("frontPanel", "1");                                       // 前面板
	        nodeElement.addAttribute("backPanel", "2");                                        // 后面板
	        Integer eiid = nms04Info.getEiid();
	        String eiid_str = null != eiid ? eiid +"" : "";
	        nodeElement.addAttribute("eiid", eiid_str);                                        // 对应资产ID
	        nodeElement.addAttribute("resid", "");     											// 性能
	        //byf start
	        nodeElement.addAttribute("eirootmark", eiid_str);
	        Integer eiversion = nms04Info.getEiversion();
	        String eiversion_str=null!=eiversion?eiversion+"":"";
	        nodeElement.addAttribute("eiversion", eiversion_str);
	        Integer eismallversion = nms04Info.getEismallVersion();
	        String eismallversion_str=null!=eismallversion?eismallversion+"":"";
	        nodeElement.addAttribute("eismallversion", eismallversion_str);
	        //byf end
	    }
	    
	    // 查询链路信息
	    NMS07SearchCondImpl nms07cond = new NMS07SearchCondImpl();
	    nms07cond.setGid(gid);
	    nms07cond.setGversion(gversion);
	    nms07BL.setVersion(version);
	    nms07cond.setFilterBlacklist(true);
	    nms07cond.setMergeWhitelist(true);
	    if(!isAll){
	        nms07cond.setUserid(userid);
	    }
	    List<NMS07Info> nms07InfoList = nms07BL.search(nms07cond);
	    //<LINE colorType='1' id='xx' frDesc='流量: 10MB\/s' portFromId='88' portToId='99' prDesc='端口关系: FA0/0 - FA0/2' fromNode='1150' toNode='1151'/>
	    // 链路信息
	    for (NMS07Info nms07Info : nms07InfoList) {
	        if(networkDeviceMap.get(nms07Info.getFromdid()) == null || networkDeviceMap.get(nms07Info.getTodid()) == null){
	            continue;
	        }
	        Element nodeElement = rootElement.addElement("LINE");
	        nodeElement.addAttribute("id", nms07Info.getId());                                  // 链路id   
	        nodeElement.addAttribute("colorType", "");                           // 线的颜色  
	        nodeElement.addAttribute("fromNode", nms07Info.getFromdid());                  // 源设备
	        nodeElement.addAttribute("portFromId", nms07Info.getFromPhysicalPort() + "");       // 源端口
	        nodeElement.addAttribute("toNode", nms07Info.getTodid());                      // 目标设备
	        nodeElement.addAttribute("portToId", nms07Info.getTopHysicalPort() + "");          // 目标端口
	        String fromNode = StringUtils.isNotEmpty(nms07Info.getFromNodeIfName()) ? nms07Info.getFromNodeIfName() : nms07Info.getFromPhysicalPort() + "";
	        String toNode = StringUtils.isNotEmpty(nms07Info.getToNodeIfName()) ? nms07Info.getToNodeIfName() : nms07Info.getTopHysicalPort() + "";
	        String prdesc = fromNode + " - " + toNode;
	        nodeElement.addAttribute("prDesc", prdesc);                         // 链路描述
	        nodeElement.addAttribute("frDesc", "");                                           // 流量描述
	    }
	    
	    // 查询子网区域信息
	    NMS17SearchCondImpl nms17cond = new NMS17SearchCondImpl();
	    nms17cond.setGid(gid);
	    nms17cond.setGversion(gversion);
	    if(!isAll){
	        nms17cond.setUserid(userid);
	    }
	    nms17cond.setType(IGNMS01BLType.TOPOSHOWTYPE_NEWWORK);
	    List<NMS17Info> searchNMS17 = nms17BL.searchNMS17(nms17cond);
	    if(searchNMS17.size() == 0){
	        nms17cond.setType(IGNMS01BLType.TOPOSHOWTYPE_ALL);
	        searchNMS17 = nms17BL.searchNMS17(nms17cond);
	    }
	    for (NMS17Info nms17Info : searchNMS17) {
	        Element regionElement = rootElement.addElement("REGION");
	        regionElement.addAttribute("id", nms17Info.getId());   
	        regionElement.addAttribute("x", nms17Info.getX());   
	        regionElement.addAttribute("y", nms17Info.getY());   
	        regionElement.addAttribute("width", nms17Info.getWidth());   
	        regionElement.addAttribute("height", nms17Info.getHeight());   
	        regionElement.addAttribute("title", nms17Info.getTitle());   
	        regionElement.addAttribute("rotation", nms17Info.getRotation());   
	    }
	    log.debug("============ 创建XML处理结束 ==================");	    
	    return document.asXML();
	}
	
	/**
	 * 更新拓扑坐标
	 * 
	 * 需要传出参数： userid（必须） groupID（可选） topoType（可选，默认为全网） showtype（）
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGNMS01DTO saveTopoInfo(IGNMS01DTO dto) throws BLException {
	    String userid = dto.getUserid(); // 用户id
	    Integer groupId = dto.getGroupId(); // 组id
	    String topoType = dto.getTopoType(); // 拓扑视图类型
	    String topoShowType = StringUtils.isNotEmpty(dto.getShowType()) ? dto.getShowType() : IGNMS01BLType.TOPOSHOWTYPE_ALL;
        // 当组信息为空时查询默认组
        groupId = groupId != null ? groupId : GROUPID_DEFAULT;
        
        // 查询组信息
        NMS01Info nms01Info = nms01BL.searchByPK(groupId);
        Integer gversion = nms01Info.getVersion(); // 当前组最新版本
        // 格式： 192.168.1.1@11,11|192.168.1.2@12,12
        String updateDevice = dto.getUpdateDevice();
        String addDevice = dto.getAddDevice();
        String addRela = dto.getAddRela();
        String delDevice = dto.getDelDevice();
        String delRela = dto.getDelRela();
        String renameDeivce = dto.getRenameDevice();
        String subNetRegion = dto.getSubNetRegion();
        String updateRegionStr = dto.getUpdateRegionStr();
        String delRegionStr = dto.getDelRegionStr();
        
        // 删除设备
        if (StringUtils.isNotEmpty(delDevice)) {
            delDeviceInfo(groupId, gversion, topoType, userid, delDevice);
        }
        
        // 添加设备
        if (StringUtils.isNotEmpty(addDevice)) {
            addDeviceInfo(groupId, gversion, topoType, userid, addDevice);
        }
        
        // 添加链路
        if (StringUtils.isNotEmpty(addRela)) {
            addDeviceLinkInfo(groupId, gversion, addRela);
        }
        
        // 删除链路
        if(StringUtils.isNotEmpty(delRela)){
            delDeviceLinkInfo(groupId, gversion, topoType, userid, delRela);
        }
        
        // 更新设备坐标
        if(StringUtils.isNotEmpty(updateDevice)){
            updateDeviceCoordinate(userid, groupId, topoType, topoShowType, gversion, updateDevice);
        }
        
        // 更新设备名称
        if (StringUtils.isNotEmpty(renameDeivce)) {
            renameDeviceName(renameDeivce);
        }
        
        // 添加区域
        if(StringUtils.isNotEmpty(subNetRegion)){
            addSubNetRegion(userid, groupId, topoType, gversion, subNetRegion);
        }
        
        // 更新区域信息
        if(StringUtils.isNotEmpty(updateRegionStr)){
            updateSubNetRegion(updateRegionStr);
        }
        
        // 删除区域信息
        if (StringUtils.isNotEmpty(delRegionStr)) {
            deleteSubNetRegion(delRegionStr);
        }
        dto = saveTopoXML(dto);
	    return dto;
	}
	
	/**
	 * 保存设备
	 * 
	 * @param userid 用户id
	 * @param groupId 组id
	 * @param topoType 保存拓扑类型
	 * @param gversion 组版本
	 * @param topoType 类型
	 * @param userid 用户id
	 * @param device 设备信息
	 * @throws BLException 
	 */
	private void addDeviceInfo(Integer groupId, Integer gversion,String topoType, String userid, String device) throws BLException{
	    log.debug("========== 添加设备处理开始 ========");
	    nms16BL.setVersion(gversion);
	    // 将字符串拆分成多个设备信息
	    String devices[] = device.split("\\|");
	    for (String dev : devices) {
	        // 拆分设备属性
	        String devinfo[] = dev.split("@");
	        String devid = devinfo[0];	// 设备id
            String devtype = devinfo[1];    // 设备类型
            String devX = devinfo[2];	//x坐标
            String devY = devinfo[3];	//y坐标
	        
	        String[] devStr = devid.split("_", 3);
            String devname = devStr[0];    // 设备名称  
            String ip = devStr[1];         // 设备IP
            String mac = devStr[2];        // 设备MAC
            
            // 保存设备信息
            NMS04TB nms04tb = new NMS04TB();
            nms04tb.setId(devid);
            nms04tb.setName(devname);
            nms04tb.setIp(ip);
            nms04tb.setMac(mac);
            nms04tb.setType(devtype);
            nms04BL.regist(nms04tb);

            // 全网拓扑
            boolean isAll = false;
            if (StringUtils.isEmpty(topoType) || IGNMS01BLType.TOPOTYPE_ALL.equals(topoType)) {
                isAll = true;
            }
            
            //从设备黑名单中移除
            NMS08SearchCondImpl cond08 = new NMS08SearchCondImpl();
            cond08.setDid(devid);
            cond08.setGid(groupId);
            cond08.setGversion(gversion);
            if(!isAll){
            	cond08.setUserid(userid);
            }else{
            	cond08.setUseridEmpty(true);
            }
            List<NMS08Info> list08 = nms08BL.search(cond08);
            for(NMS08Info nms08info:list08){
            	nms08BL.delete(nms08info.getId());
            }
            
            // 保存设备白名单
            NMS12SearchCondImpl cond12 = new NMS12SearchCondImpl();
            cond12.setDid(devid);
            cond12.setGid(groupId);
            cond12.setGversion(gversion);
            if(!isAll){
            	cond12.setUserid(userid);
            }else{
            	cond12.setUseridEmpty(true);
            }
            List<NMS12Info> list12 = nms12BL.search(cond12);
            if(list12 == null || list12.size() == 0){
                NMS12TB nms12tb = new NMS12TB();
                nms12tb.setDid(devid);
                nms12tb.setGid(groupId);
                nms12tb.setGversion(gversion);
                if(!isAll){
                    nms12tb.setUserid(null);
                }
                // 用户拓扑
                else if (IGNMS01BLType.TOPOTYPE_USER.equals(topoType)) {
                    nms12tb.setUserid(userid);
                }
                nms12BL.regist(nms12tb);
            }
            
            // 保存组设备信息
            nms05BL.setVersion(gversion);
            NMS05TB nms05tb = new NMS05TB();
            nms05tb.setDid(devid);
            nms05tb.setGid(groupId);
            nms05tb.setGversion(gversion);
            nms05tb.setIp(ip);
            nms05tb.setMac(mac);
            nms05BL.regist(nms05tb);
            
            // 保存设备坐标信息
            nms16BL.setVersion(gversion);
            NMS16TB nms16tb = new NMS16TB();
            
            NMS16SearchCondImpl cond16 = new NMS16SearchCondImpl();
            cond16.setDid(devid);
            cond16.setGid(groupId);
            cond16.setGversion(gversion);
            cond16.setType(IGNMS01BLType.TOPOSHOWTYPE_ALL);
            if(!isAll){
            	cond16.setUserid(userid);
            }else{
            	cond16.setUseridEmpty(true);
            }
            List<NMS16Info> list16 = nms16BL.search(cond16);
            
            if(list16 != null && list16.size() > 0){
            	BeanUtils.copyProperties(list16.get(0),nms16tb);
            }else{
            	nms16tb.setId(nms16BL.getUUID());
	            nms16tb.setDid(devid);
	            nms16tb.setGid(groupId);
	            nms16tb.setGversion(gversion);
                // 当用户添加设备保存用户id
                if(!isAll){
                    nms16tb.setUserid(userid);
                }
            }
            // 保存设备坐标信息
            nms16tb.setX(devX + "");
            nms16tb.setY(devY + "");
            
            nms16BL.regist(nms16tb);
        }
	    log.debug("========== 添加设备处理结束 ========");
	}

	/**
     * 保存链路
     * 
     * @param groupId 组id
     * @param gversion 组版本
     * @param links_str 链路信息
     * @throws BLException 
     */
    private void addDeviceLinkInfo(Integer groupId, Integer gversion, String links_str) throws BLException{
        log.debug(" ============ 保存设备链路信息处理开始 =========== ");
        String links[] = links_str.split("\\|");
        for (String link : links) {
            String link_arr[] = link.split("@");
            String fromdid = link_arr[0];       // 源设备id
            String todid = link_arr[1];         // 目标设备id
            String fromdport = link_arr[2];     // 源设备端口
            Integer fromport_int = StringUtils.isNotEmpty(fromdport) ? Integer.parseInt(fromdport) : -1;
            String toport = link_arr[3];        // 目标设备端口
            Integer toport_int = StringUtils.isNotEmpty(toport) ? Integer.parseInt(toport) : -1;
            
            NMS13TB nms13tb = new NMS13TB(); 
            nms13tb.setId(nms13BL.getUUID());
            nms13tb.setGid(groupId);
            nms13tb.setGversion(gversion);
            nms13tb.setFromdid(fromdid);
            nms13tb.setTodid(todid);
            nms13tb.setFromPhysicalPort(fromport_int);
            nms13tb.setFromNodeIfIndex(fromport_int);
            nms13tb.setFromNodeIfName(fromdport);
            nms13tb.setTopHysicalPort(toport_int);
            nms13tb.setToNodeIfIndex(toport_int);
            nms13tb.setToNodeIfName(toport);
            nms13BL.regist(nms13tb);
        }
        
        log.debug(" ============ 保存设备链路信息处理结束 =========== ");
    }
    
    /**
     * 删除链路
     * 
     * @param groupId 组id
     * @param gversion 组版本
     * @param topotype 拓扑类型
     * @param dellinks_str 链路信息
     * @throws BLException 
     */
    private void delDeviceLinkInfo(Integer groupId, Integer gversion,String topoType, String userid, String dellinks_str) 
            throws BLException{
        log.debug("=================== 删除设备链路信息处理开始 ================");
        
        boolean isAll = false; // 是否是全网拓扑
        // 全网拓扑
        if (StringUtils.isEmpty(topoType) || IGNMS01BLType.TOPOTYPE_ALL.equals(topoType)) {
            isAll = true;
        } 
        
        // 需要删除的链路集合
        String dellinks[] = dellinks_str.split("\\|");
        for (String delink : dellinks) {
            // 实例化链路黑名单
            NMS10TB nms10tb = new NMS10TB();
            nms07BL.setVersion(gversion);
            
            // 查询链路信息
            NMS07Info nms07info = nms07BL.searchByPK(delink);
            // 当链路表中没查询时查询链路白名单
            if(nms07info != null){
                BeanUtils.copyProperties(nms07info, nms10tb);
                nms10tb.setId(nms10BL.getUUID());
                // 全网拓扑时删除链路信息
                if(!isAll){
                    nms10tb.setUserid(userid);
                }
                nms10BL.regist(nms10tb);
            } 
            // 链路白名单
            else {
                NMS13Info nsm13info = nms13BL.searchByPK(delink);
                if (nsm13info == null) {
                    continue;
                }
                nms13BL.delete(nsm13info);
            }
        }
        
        log.debug("=================== 删除设备链路信息处理删除 ================");
    }
    
    /**
     * 删除设备
     * 
     * @param groupId 组id
     * @param gversion 组版本
     * @param topotype 拓扑类型
     * @param dellinks_str 链路信息
     * @throws BLException 
     */
    private void delDeviceInfo(Integer groupId, Integer gversion,String topoType, String userid, String deldevs_str) 
            throws BLException{
        log.debug("=================== 删除设备信息开始 ================");
        boolean isAll = false;
        // 全网拓扑
        if (StringUtils.isEmpty(topoType) || IGNMS01BLType.TOPOTYPE_ALL.equals(topoType)) {
            isAll = true;
        } 
        String[] deldevs = deldevs_str.split("\\|");
        for (String deldev : deldevs) {
        	
        	NMS08SearchCondImpl cond08 = new NMS08SearchCondImpl();
            cond08.setDid(deldev);
            cond08.setGid(groupId);
            cond08.setGversion(gversion);
            if(!isAll){
            	cond08.setUserid(userid);
            }else{
            	cond08.setUseridEmpty(true);
            }
            List<NMS08Info> list08 = nms08BL.search(cond08);
        	if(list08 ==null || list08.size() == 0){
                // 实例化设备黑名单
                NMS08TB nms08tb = new NMS08TB();
                nms08tb.setDid(deldev);
                nms08tb.setGid(groupId);
                nms08tb.setGversion(gversion);
                if(!isAll){
                    nms08tb.setUserid(userid);
                }
                nms08BL.regist(nms08tb);
        	}
        }
        
        log.debug("=================== 删除设备信息删除 ================");
    }
    
	/**
	 * 更新设备坐标
	 * 
	 * @param userid
	 * @param groupId
	 * @param topoType
	 * @param gversion
	 * @param updateDevice
	 * @throws BLException
	 */
    private void updateDeviceCoordinate(String userid, Integer groupId, String topoType, String topoShowType, Integer gversion, 
            String updateDevice) throws BLException {
        log.debug("------------------- 更新设备坐标处理开始 ------------------");
        nms16BL.setVersion(gversion);
        NMS16SearchCondImpl nms16cond = new NMS16SearchCondImpl();
        nms16cond.setGid(groupId);
        nms16cond.setGversion(gversion);
        boolean isAll = false;
        // 全网拓扑
        if (StringUtils.isEmpty(topoType) || IGNMS01BLType.TOPOTYPE_ALL.equals(topoType)) {
            nms16cond.setUseridEmpty(true);
            isAll = true;
        } 
        // 用户拓扑
        else if (IGNMS01BLType.TOPOTYPE_USER.equals(topoType)) {
            nms16cond.setUserid(userid);
        } 
        nms16cond.setType(topoShowType);
        List<NMS16Info> nms16InfoList = nms16BL.search(nms16cond);
        // 存在已存在的设备坐标信息
        Map<String, NMS16Info> nms16InfoMap = new HashMap<String, NMS16Info>();
        for (NMS16Info nms16Info : nms16InfoList) {
            String key = nms16Info.getDid() + "_" + nms16Info.getGid() + "_" + nms16Info.getGversion();
            nms16InfoMap.put(key, nms16Info);
        }
        
        // 需要更新的坐标的设备
        if (StringUtils.isNotEmpty(updateDevice)) {
            String devices[] = updateDevice.split("\\|");
            // 遍历更新设备坐标
            for (String device : devices) {
                String did = device.split("@")[0]; // 设备id
                String deviceX = device.split("@")[1].split(",")[0]; // x坐标
                String deviceY = device.split("@")[1].split(",")[1]; // y坐标
                String key = did + "_" + groupId + "_" + gversion;
                NMS16Info nms16Info = nms16InfoMap.get(key);
                NMS16TB nsm16tb = null;
                // 更新设备坐标
                if(nms16Info != null){
                    nsm16tb = (NMS16TB) SerializationUtils.clone(nms16Info);
                } else {
                    nsm16tb = new NMS16TB();
                    nsm16tb.setId(nms16BL.getUUID());
                    nsm16tb.setDid(did);
                    nsm16tb.setGid(groupId);
                    nsm16tb.setGversion(gversion);
                }
                nsm16tb.setX(deviceX);
                nsm16tb.setY(deviceY);
                if (!isAll) {
                    nsm16tb.setUserid(userid);
                }
                
                nsm16tb.setShowtype(topoShowType);
                nms16BL.regist(nsm16tb);
            }
        }
        log.debug("------------------- 更新设备坐标处理结束 ------------------");
    }
	
    /**
     * 更新设备名称
     * 
     * @param deviceInfos
     */
    private void renameDeviceName(String deviceInfos){
        log.debug("------------------- 更新设备名称处理开始 ------------------");
        String device_arr[] = deviceInfos.split("\\|");
        for (String device : device_arr) {
            String devinfos[] = device.split("@");
            try {
                NMS04Info nms04info = nms04BL.searchByPK(devinfos[0]);
                NMS04TB nms04tb = (NMS04TB) SerializationUtils.clone(nms04info);
                nms04tb.setDispname(devinfos[1]);
                nms04BL.update(nms04tb);
            } catch (BLException e) {
                log.debug("设备信息不存在");
                log.error("设备信息不存在", e);
            }
        }
        log.debug("------------------- 更新设备名称处理结束 ------------------");
    }
    
    /**
     * 添加子网区域
     * 
     * @param userid
     * @param groupId
     * @param topoType
     * @param gversion
     * @param allSubNet_Str
     * @throws BLException 
     */
    private void addSubNetRegion(String userid, Integer groupId, String topoType, Integer gversion, String allSubNet_Str) throws BLException{
        log.debug("------------------- 增加区域信息处理开始 ------------------");
        String allSubNet_Arr[] = allSubNet_Str.split("\\|");
        
        List<NMS17Info> nms17list = new ArrayList<NMS17Info>();
        for (String str : allSubNet_Arr) {
            NMS17TB nms17tb = nms17BL.getNMS17TBInstance();
            String region_arr[] = str.split("@");
            String x = region_arr[0];
            String y = region_arr[1];
            String width = region_arr[2];
            String height = region_arr[3];
            String title = region_arr[4];
            String rotation = region_arr[5];
            nms17tb.setId(nms17BL.getUUID());
            nms17tb.setGid(groupId);
            nms17tb.setGversion(gversion);
            nms17tb.setX(x);
            nms17tb.setY(y);
            nms17tb.setWidth(width);
            nms17tb.setHeight(height);
            nms17tb.setTitle(title);
            nms17tb.setRotation(rotation);
            nms17list.add(nms17tb);
        }
        nms17BL.registNMS17All(nms17list);
        log.debug("------------------- 增加区域信息处理结束 ------------------");
    }
    
    /**
     * 更新区域信息
     * 
     * @param updateRegionStr
     */
    private void updateSubNetRegion( String updateRegionStr){
        String updateRegion_arr[] = updateRegionStr.split("\\|");
        for (String rag : updateRegion_arr) {
            String[] ragAtt = rag.split("@");
            String id =ragAtt[0]; 
            String x =ragAtt[1]; 
            String y =ragAtt[2]; 
            String width =ragAtt[3]; 
            String height =ragAtt[4]; 
            String title =ragAtt[5]; 
            String rotation = ragAtt[6];
            
            try {
                NMS17Info nms17info = nms17BL.searchNMS17ByPK(id);
                NMS17TB nms17tb = (NMS17TB) SerializationUtils.clone(nms17info);
                nms17tb.setX(x);
                nms17tb.setY(y);
                nms17tb.setWidth(width);
                nms17tb.setHeight(height);
                nms17tb.setTitle(title);
                nms17tb.setRotation(rotation);
                nms17BL.updateNMS17(nms17tb);
            } catch (BLException e) {
                log.debug("区域信息不存在");
                log.error("区域信息不存在", e);
            }
        }
        log.debug("------------------- 更新区域信息处理结束 ------------------");
    }
    
    /**
     * 删除区域信息
     * 
     * @param updateRegionStr
     */
    private void deleteSubNetRegion(String deleteRegionStr) {
        log.debug("------------------- 删除区域信息处理开始 ------------------");
        String deleteRegion_arr[] = deleteRegionStr.split("\\|");
        for (String rag : deleteRegion_arr) {
            
            try {
                nms17BL.deleteNMS17ByPK(rag);
            } catch (BLException e) {
                log.debug("区域信息不存在");
                log.error("区域信息不存在", e);
            }
        }
        log.debug("------------------- 删除区域信息处理结束 ------------------");
    }
    
    /**
     * 获取面板大小
     * 
     * @param dto
     * @return
     */
    public IGNMS01DTO getPanelSize(IGNMS01DTO dto) throws BLException {
        log.debug("========== 获取面板大小处理开始 ==========");

        Integer groupId = dto.getGroupId();
        Integer gversion = dto.getGroupVersion();
        String userid = dto.getUserid();
        String topoType = dto.getTopoType();
        groupId = groupId != null ? groupId : GROUPID_DEFAULT;

        // 实例化并设置查询条件
        NMS09SearchCondImpl nms09cond = new NMS09SearchCondImpl();
        nms09cond.setGid_eq(groupId);
        nms09cond.setGversion_eq(gversion);
        // 全网拓扑
        if (StringUtils.isEmpty(topoType) || IGNMS01BLType.TOPOTYPE_ALL.equals(topoType)) {
            nms09cond.setUseridEmpty(true);
        }
        // 用户拓扑
        else if (IGNMS01BLType.TOPOTYPE_USER.equals(topoType)) {
            nms09cond.setUserid_eq(userid);
        }
        // 创建XML Document对象
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("root");
        Element panelElement = rootElement.addElement("PANEL");
        
        // 查询用户拓扑
        List<NMS09Info> nms09InfoList = nms09BL.search(nms09cond);
        if(nms09InfoList.size() > 0){
            NMS09Info nms09info = (NMS09Info)SerializationUtils.clone(nms09InfoList.get(0));
            panelElement.addAttribute("width", nms09info.getWidth());
            panelElement.addAttribute("height", nms09info.getHeight());
        } else {
            panelElement.addAttribute("width", "");
            panelElement.addAttribute("height", "");
        }
        
        dto.setPanelSizeInfoXml(document.asXML());
        log.debug("========== 获取面板大小处理结束 ==========");
        return dto;
    }
    
    /**
     * 更新面板大小
     * 
     * @param dto
     * @return
     * @throws BLException 
     */
    public IGNMS01DTO updatePanelSize(IGNMS01DTO dto) throws BLException {
        log.debug("=========== 更新面板大小处理开始 ==========");
        Integer groupId = dto.getGroupId();
        Integer gversion = dto.getGroupVersion();
        String userid = dto.getUserid();
        String topoType = dto.getTopoType();
        groupId = groupId != null ? groupId : GROUPID_DEFAULT;
        
        String updateSize = dto.getPanelSize();
        if(StringUtils.isNotEmpty(updateSize)){
            String width = updateSize.split("@")[0];
            String height = updateSize.split("@")[1];
         // 实例化并设置查询条件
            NMS09SearchCondImpl nms09cond = new NMS09SearchCondImpl();
            nms09cond.setGid_eq(groupId);
            nms09cond.setGversion_eq(gversion);
            boolean isAll = false;
            // 全网拓扑
            if (StringUtils.isEmpty(topoType) || IGNMS01BLType.TOPOTYPE_ALL.equals(topoType)) {
                nms09cond.setUseridEmpty(true);
                isAll = true;
            } 
            // 用户拓扑
            else if (IGNMS01BLType.TOPOTYPE_USER.equals(topoType)) {
                nms09cond.setUserid_eq(userid);
            } 
            
            // 查询用户拓扑
            List<NMS09Info> nms09InfoList = nms09BL.search(nms09cond);
            NMS09TB nms09TB = null;
            if (nms09InfoList.size() > 0) {
                nms09TB = (NMS09TB) SerializationUtils.clone(nms09InfoList.get(0));
                
            } else {
                nms09TB = new NMS09TB();
                nms09TB.setGid(groupId);
                nms09TB.setGversion(gversion);
                // 用户拓扑保存用户id
                if (!isAll) {
                    nms09TB.setUserid(userid);
                }
            }
            nms09TB.setWidth(width);
            nms09TB.setHeight(height);
            nms09BL.regist(nms09TB);
        }
        
        
        log.debug("=========== 更新面板大小处理结束 ==========");
        return dto;
    }
    
	public IGNMS01DTO test(IGNMS01DTO dto) throws BLException {
		nms03BL.setVersion(1);
		nms03BL.search(new NMS03SearchCondImpl());
		return dto;
	}

	/**
	 * 查看SNMP配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO initNMS02Action(IGNMS01DTO dto) throws BLException {
		log.debug("========SNMP配置显示处理开始========");
		NMS02SearchCondImpl cond = new NMS02SearchCondImpl();
		cond.setDeleteflag("0");
		dto.setLst_NMS02Info(nms02BL.search(cond));
		log.debug("========SNMP配置显示处理结束========");
		return dto;
	}
	
	/**
	 * 登记SNMP配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO insertNMS02Action(IGNMS01DTO dto) throws BLException {
		log.debug("========SNMP配置新增处理开始========");
		IGNMS0102Form instance = (IGNMS0102Form)dto.getNms02Info();
		instance.setId(getSNMPID(instance));
		instance.setInstime(IGStringUtils.getCurrentDateTime());
		if(StringUtils.isEmpty(instance.getSnmpPrivacyPassPhrase())) {
			if(StringUtils.isEmpty(instance.getSnmpPassword())) {
//				instance.setSnmpSecurityLevel(SecurityLevel.NOAUTH_NOPRIV + "");
			} else {
//				instance.setSnmpSecurityLevel(SecurityLevel.AUTH_NOPRIV + "");
			}
		} else {
//			instance.setSnmpSecurityLevel(SecurityLevel.AUTH_PRIV + "");
		}
		nms02BL.regist(instance);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "配置信息") );
		log.debug("========SNMP配置新增处理结束========");
		return dto;
	}
	
	/**
	 * 删除SNMP配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO deleteNMS02Action(IGNMS01DTO dto) throws BLException {
		log.debug("========SNMP配置删除处理开始========");
		nms02BL.delete(dto.getNms02Info().getId());
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "配置信息") );
		log.debug("========SNMP配置删除处理结束========");
		return dto;
	}

	/**
	 * 查看任务配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO initNMS03Action(IGNMS01DTO dto) throws BLException {
		log.debug("========任务配置显示处理开始========");
		NMS03SearchCondImpl cond = new NMS03SearchCondImpl();
//		cond.setGid(dto.getNms03Info().getGid());
//		cond.setGversion(nms03BL.getMaxGversion(dto.getNms03Info().getGid()));
		cond.setDeleteflag("0");
		dto.setLst_NMS03Info(nms03BL.search(cond));
		log.debug("========任务配置显示处理结束========");
		return dto;
	}
	
	/**
	 * 登记任务配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO insertNMS03Action(IGNMS01DTO dto) throws BLException {
		log.debug("========任务配置新增处理开始========");
		IGNMS0103Form instance = (IGNMS0103Form)dto.getNms03Info();
		instance.setInstime(IGStringUtils.getCurrentDateTime());
		instance.setVersion(0);
		nms03BL.regist(instance);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "配置信息") );
		log.debug("========任务配置新增处理结束========");
		return dto;
	}
	
	/**
	 * 删除任务配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO deleteNMS03Action(IGNMS01DTO dto) throws BLException {
		log.debug("========任务配置删除处理开始========");
		nms03BL.delete(dto.getNms03Info().getId());
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "配置信息") );
		log.debug("========任务配置删除处理结束========");
		return dto;
	}
	
	/**
	 * 启动扫描程序
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO execCommandAction(IGNMS01DTO dto) throws BLException {
		String path = this.codeListUtils.getCodeValue(CodeDefine.getCodeDefine("NMS_EXECUTABLE_FILE_PATH").getCcid(),
				"", "", "1");
		File file = new File(path);
		if(!file.exists() || !file.isFile()) {
			log.error("=========== 扫描程序执行文件（" +  path + "）不存在 ==========");
			dto.setFlag(-1);
			return dto;
		}
    	String line;
    	if("/".equals(File.pathSeparator)) {
    		//line = "./IG/test.sh";
    		line = "sh " + path + " " + "Y" + " " + dto.getGroupId();
    	} else {
    		line = "cmd.exe /C start /b " + path + " " + "Y" + " " + dto.getGroupId();
    	}
    	try {
			Runtime.getRuntime().exec(line);
		} catch (Exception e) {
			log.error("=========== 扫描程序启动失败 ==========");
			dto.setFlag(0);
			return dto;
		}
    	log.info("=========== 扫描程序启动成功 ==========");
    	dto.setFlag(1);
    	return dto;
    }
	
    public static void main(String[] args) {
//        Document document = DocumentHelper.createDocument();
//        Element catalogElement = document.addElement("catalog");
//        catalogElement.addComment("An XML Catalog");
//        catalogElement.addProcessingInstruction("target", "text");
//        Element journalElement = catalogElement.addElement("journal");
//        journalElement.addAttribute("title", "XML Zone");
//        journalElement.addAttribute("publisher", "IBM developerWorks");
//        Element articleElement = journalElement.addElement("article");
//        articleElement.addAttribute("level", "Intermediate");
//        articleElement.addAttribute("date", "December-2001");
//        Element titleElement = articleElement.addElement("title");
//        titleElement.setText("Java configuration with XML Schema");
//        Element authorElement = articleElement.addElement("author");
//        Element firstNameElement = authorElement.addElement("firstname");
//        firstNameElement.setText("Marcello");
//        Element lastNameElement = authorElement.addElement("lastname");
//        lastNameElement.setText("Vitaletti");
////        document.addDocType("catalog", null, "file://c:/Dtds/catalog.dtd");
//        
//        String xml = document.asXML();
//        System.out.println(xml);
        
        
        
//        try {
//            XMLWriter output = new XMLWriter(new FileWriter(new File("c:/catalog.xml")));
//            output.write(document);
//            output.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        
        
//        
//        Document document;
//        try {
//            document = DocumentHelper
//                    .parseText("<root>"
//                            + "<NODE id='192.168.1.1' devid='' alert='false' name='255.255.255.253_这是个测试啊1' x='468' y='271' imgUrl='resource/image/monitor/route.png' frontPanel='1' backPanel='2' eiid='888' resid='998' />"
//                            + "<NODE id='1151' alert='false' name='255.255.255.254_这是个测试啊2' x='450' y='271' imgUrl='resource/image/monitor/route.png' frontPanel='2' backPanel='2' eiid='999' resid='997' />"
//                            + "<LINE colorType='1' id='xx' frDesc='流量: 10MB/s' portFromId='88' portToId='99' prDesc='端口关系: FA0/0 - FA0/2' fromNode='1150' toNode='1151'/>"
//                            + "</root>");
//            Element root = document.getRootElement();
//            List<Element> nodes = root.elements("NODE");
//            for (Iterator it = nodes.iterator(); it.hasNext();) {
//                Element elm = (Element) it.next();
//                System.out.println(elm.getName());
//            }
//            System.out.println(root);
//        } catch (DocumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        
//        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
//        System.out.println(System.getProperty("os.name"));
        int i = 1000000;
        System.out.println(i*i);
        i = 2000000;
        System.out.println(i*i);
    }
    
    /**
	 * 取得拓扑设备图片路径
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO getImgUrl(IGNMS01DTO dto) throws BLException {
		List<LabelValueBean> imgUrlList = codeListUtils.getCodeList(CodeDefine.getCodeDefine("TOPO_DEVICE_TYPE").getCcid(), null, null, false, false);
		Document document = DocumentHelper.createDocument();
	    Element rootElement = document.addElement("root");
		for(LabelValueBean lvbean:imgUrlList){
			if(StringUtils.isNotEmpty(lvbean.getLabel())){
			    Element imgElement = rootElement.addElement("IMG");
			    imgElement.addAttribute("type", lvbean.getValue());
			    imgElement.addAttribute("url", lvbean.getLabel());
			}
		}
		dto.setImgUrlXml(document.asXML());
		return dto;
	}
	
    /**
	 * 取得拓扑设备类型
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO getDevType(IGNMS01DTO dto) throws BLException {
		CodeDetailSearchCondImpl codedetailcond = new CodeDetailSearchCondImpl();
        codedetailcond.setCcid(CodeDefine.getCodeDefine("TOPO_DEVICE_TYPE").getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(codedetailcond,
                CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        
        Document document = DocumentHelper.createDocument();
	    Element rootElement = document.addElement("root");
        for(CodeDetail cd:cds){
        	if(StringUtils.isNotEmpty(cd.getCdinfo())){
        		Element dateElement = rootElement.addElement("date");
        		dateElement.addAttribute("type", cd.getCid());
        		dateElement.addAttribute("name", cd.getCdinfo());
        	}
        }
        
		dto.setDevTypeXml(document.asXML());
		return dto;
	}
}
