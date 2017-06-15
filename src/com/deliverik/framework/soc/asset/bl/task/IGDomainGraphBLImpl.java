/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCondImpl;

/**
  * 概述: 拓扑图业务逻辑实现
  * 功能描述: 拓扑图业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class IGDomainGraphBLImpl extends BaseBLImpl implements
	IGDomainGraphBL {

	/** 拓扑图链路信息BL */
	protected SOC0114BL soc0114BL;
	
	/**
	 * 拓扑图链路信息BL设定
	 *
	 * @param soc0114BL 拓扑图链路信息BL
	 */
	public void setSoc0114BL(SOC0114BL soc0114BL) {
		this.soc0114BL = soc0114BL;
	}
	
	/**
	 * 构造节点
	 * 
	 * @param nodeXmlStr 节点XML
	 * @param eiLinkMap 链路上的资产
	 * @param selEiid 高亮的资产ID
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 快照生成时间
	 */
	private void drawNode(StringBuffer nodeXmlStr, SOC0114Info eiLinkMap, Integer selEiid, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		nodeXmlStr.append("<NODE ");
		nodeXmlStr.append("id=\"");
		nodeXmlStr.append(eiLinkMap.getEiid());//节点ID
		nodeXmlStr.append("\" eiid=\"");
		nodeXmlStr.append(eiLinkMap.getEiid());//资产ID
		nodeXmlStr.append("\" name=\"");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkMap.getEiname()));//资产名称
		nodeXmlStr.append("\" desc=\"");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkMap.getEiname()));//资产名称
		nodeXmlStr.append("\" alert=\"flase\"");
		nodeXmlStr.append(" esyscoding=\"");
		nodeXmlStr.append(eiLinkMap.getEsyscoding());//资产模型层次码
		nodeXmlStr.append("\" imgUrl=\"../monitor/");
		nodeXmlStr.append(eiLinkMap.getEsyscoding());//资产模型层次码
		nodeXmlStr.append(".png\"/>");
	}
	
	/**
	 * 连线
	 * 
	 * @param actionXmlStr 连线XML
	 * @param fromId 起始节点ID
	 * @param to_id 结束节点ID
	 */
	private void drawLine(StringBuffer actionXmlStr, Integer fromId, Integer to_id) {
		actionXmlStr.append("<LINE ");
		actionXmlStr.append("fromNode=\"");
		actionXmlStr.append(fromId);
		actionXmlStr.append("\" toNode=\"");
		actionXmlStr.append(to_id);
		actionXmlStr.append("\"");
		actionXmlStr.append("/>");
	}
	
	/**
	 * 拓扑图显示初始化处理
	 * 
	 * @param eiid 选中资产ID
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 创建时间
	 * @return 显示用XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(Integer eiid, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		List<SOC0114Info> linkMap = this.searchLinkMap(eiid, domainid, domainversion, createtime);
		return this.createXml(eiid, linkMap, domainid, domainversion, createtime);
	}
	
	/**
	 * 拓扑图链路检索
	 * 
	 * @param eiid 选中资产ID
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 创建时间
	 * @return 显示用XML
	 * @throws BLException 
	 * 
	 */
	private List<SOC0114Info> searchLinkMap(Integer eiid, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		SOC0114SearchCondImpl cond = new SOC0114SearchCondImpl();
		cond.setDomainid_eq(domainid);//域ID
		cond.setDomainversion_eq(domainversion);//域版本
//		cond.setCreatetime_eq(createtime);//最新域快照时间
		cond.setLinkflag_eq("1");//有效链路
		return this.soc0114BL.searchEiLinkMap(cond);
	}
	
	/**
	 * 构造显示XML
	 * 
	 * @param eiid 选中资产ID
	 * @param linkMap 链路集合
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 快照生成时间
	 * @throws BLException 
	 */
	protected String createXml(Integer eiid, List<SOC0114Info> linkMap, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer nodeXmlStr = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		nodeXmlStr.append("<root>");
		nodeXmlStr.append("<NODEONE id=\"0\" esyscoding=\"999999999999\"/>");
		this.drawGraph(linkMap, eiid, nodeXmlStr, domainid, domainversion, createtime);
		nodeXmlStr.append("</root>");
		return nodeXmlStr.toString();
	}
	
	
	/**
	 * 画拓扑图
	 * 
	 * @param linkMap 链路集合
	 * @param selEiid 选中的资产ID
	 * @param nodeXmlStr 节点XML
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 快照生成时间
	 * @throws BLException
	 */
	private void drawGraph(List<SOC0114Info> linkMap, Integer selEiid, StringBuffer nodeXmlStr, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer actionXmlStr = new StringBuffer();
		//过滤重复的资产
		Set<Integer> eiidSet = new HashSet<Integer>();
		//过滤重复的线
		Set<String> lineSet = new HashSet<String>();
		Integer fromId = 1;
		for(SOC0114Info eiLinkMap : linkMap) {
			//过滤无效路径
//			if("0".equals(eiLinkMap.getLinkflag())) {
//				continue;
//			}
			//不显示DA和DISK
			if(eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.HBA)
					|| eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.HBAPORT)
						||eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.FRONTPORT)
						||eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.SANPORT)
						||eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.FA)) {
				continue;
			}
			//不显示无任何连接的交换机端口
			if(eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.SANPORT)
					&& "1".equals(eiLinkMap.getEndflag())) {
				continue;
			}
			if(eiLinkMap.getLinkorder().intValue() == 1) {
				fromId = 1;
			}
			if(!eiidSet.contains(eiLinkMap.getEiid())) {
				//构造节点XML
				this.drawNode(nodeXmlStr, eiLinkMap, selEiid, domainid, domainversion, createtime);
				eiidSet.add(eiLinkMap.getEiid());
			}
			if(!lineSet.contains(fromId.toString() + "-" + eiLinkMap.getEiid().toString())&&
					eiLinkMap.getLinkorder().intValue()!=1&&fromId!=eiLinkMap.getEiid()) {
				//构造ActionXML
				this.drawLine(actionXmlStr, fromId, eiLinkMap.getEiid());
				lineSet.add(fromId.toString() + "-" + eiLinkMap.getEiid().toString());
			}
			fromId = eiLinkMap.getEiid();
		}
		
		nodeXmlStr.append(actionXmlStr);
	}
	
}