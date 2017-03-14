/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.EiDomainKeyWords;
import com.deliverik.framework.asset.EiRelationKeyWords;
import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.entity.EiDomainDefPK;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: 影响分析图业务逻辑实现
  * 功能描述: 影响分析图业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SocImpactGraphBLImpl extends BaseBLImpl implements
	SocImpactGraphBL {

	/** 影响分析图链路信息BL */
	protected EiLinkMapBL eiLinkMapBL;
	
	/** 域定义信息BL */
	protected EiDomainDefBL eiDomainDefBL;
	
	/**
	 * 影响分析图链路信息BL设定
	 *
	 * @param eiLinkMapBL 影响分析图链路信息BL
	 */
	public void setEiLinkMapBL(EiLinkMapBL eiLinkMapBL) {
		this.eiLinkMapBL = eiLinkMapBL;
	}
	
	/**
	 * 域定义信息BL设定
	 *
	 * @param eiDomainDefBL 域定义信息BL
	 */
	public void setEiDomainDefBL(EiDomainDefBL eiDomainDefBL) {
		this.eiDomainDefBL = eiDomainDefBL;
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
	private void drawNode(StringBuffer nodeXmlStr, EiLinkMapInfo eiLinkMap, Integer selEiid, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		nodeXmlStr.append("<Node ");
		nodeXmlStr.append("id='");
		nodeXmlStr.append(eiLinkMap.getEiid());//节点ID
		nodeXmlStr.append("' eiid='");
		nodeXmlStr.append(eiLinkMap.getEiid());//资产ID
		nodeXmlStr.append("' name='");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkMap.getEiname()));//资产名称
		nodeXmlStr.append("' desc='");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkMap.getEiname()));//资产名称
		//高亮
		if(eiLinkMap.getEiid().equals(selEiid)){
			nodeXmlStr.append("' nodeColor='0x00FF00' bright='true'");
		} else {
			nodeXmlStr.append("'");
		}
		nodeXmlStr.append(" eiversion='").append(eiLinkMap.getEiversion()).append("'");
		nodeXmlStr.append(" eismallversion='").append(eiLinkMap.getEismallversion()).append("'");
		
		//主机，交换机，存储可以查看关系
		if(eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
				|| eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
				|| eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)) {
			nodeXmlStr.append(" showRelation='true'");
			nodeXmlStr.append(" domainid='").append(domainid).append("'");
			nodeXmlStr.append(" domainversion='").append(domainversion).append("'");
			nodeXmlStr.append(" createtime='").append(createtime).append("'");
		}
		nodeXmlStr.append(" nodeClass='leaf'");
		nodeXmlStr.append(" nodeIcon='");
		nodeXmlStr.append(eiLinkMap.getEsyscoding());//资产模型层次码
		nodeXmlStr.append("'/>");
	}
	
	/**
	 * 连线
	 * 
	 * @param actionXmlStr 连线XML
	 * @param fromId 起始节点ID
	 * @param to_id 结束节点ID
	 */
	private void drawLine(StringBuffer actionXmlStr, Integer fromId, Integer to_id) {
		actionXmlStr.append("<Edge ");
		actionXmlStr.append("fromID='");
		actionXmlStr.append(fromId);
		actionXmlStr.append("' toID='");
		actionXmlStr.append(to_id);
		actionXmlStr.append("'");
		actionXmlStr.append("/>");
	}
	
	/**
	 * 影响分析图显示初始化处理(默认检索default域)
	 * 
	 * @param ei 选中资产信息
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 创建时间
	 * @return 显示用XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(IG688Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		EiDomainDefInfo domain = null;
		//取默认域ID
		if(domainid == null || domainid.intValue() == 0) {
			domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		}
		//取最大域版本
		if(domainversion == null || domainversion.intValue() == 0) {
			domain = this.eiDomainDefBL.searchDomainMaxVersion(domainid);
			domainversion = domain.getVersion();
			if(StringUtils.isEmpty(createtime)) {
				createtime = domain.getUpdatetime();
			}
		}
		//取影响分析图链路创建时间
		if(StringUtils.isEmpty(createtime)) {
			domain = this.eiDomainDefBL.searchEiDomainDefByPK(new EiDomainDefPK (domainid, domainversion));
			createtime = domain.getUpdatetime();
		}
		List<EiLinkMapInfo> linkMap = this.searchLinkMap(ei, domainid, domainversion, createtime);
		return this.createXml(ei, linkMap, domainid, domainversion, createtime);
	}
	
	/**
	 * 影响分析图链路检索
	 * 
	 * @param ei 资产信息
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 创建时间
	 * @return 显示用XML
	 * @throws BLException 
	 * 
	 */
	private List<EiLinkMapInfo> searchLinkMap(IG688Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		EiLinkMapSearchCondImpl cond = new EiLinkMapSearchCondImpl();
		cond.setDomainid_eq(domainid);//域ID
		cond.setDomainversion_eq(domainversion);//域版本
		cond.setEiid_eq(ei.getEiid());//资产ID
		cond.setCreatetime_eq(createtime);//最新域快照时间
		cond.setLinkflag_eq("1");//绘图标记
		return this.eiLinkMapBL.queryEiLinkMapList(cond);
	}
	
	/**
	 * 构造显示XML
	 * 
	 * @param ei 选择资产
	 * @param linkMap 链路集合
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 快照生成时间
	 * @throws BLException 
	 */
	protected String createXml(IG688Info ei, List<EiLinkMapInfo> linkMap, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer nodeXmlStr = new StringBuffer("<?xml version='1.0' encoding='utf-8'?>");
		nodeXmlStr.append("<TopologyGraph>");
		this.drawRoot(nodeXmlStr);
		this.drawGraph(linkMap, ei.getEiid(), nodeXmlStr, domainid, domainversion, createtime);
		nodeXmlStr.append("</TopologyGraph>");
		return nodeXmlStr.toString();
	}
	
	/**
	 * 构造根节点
	 * 
	 * @param actionXmlStr 节点XML
	 */
	private void drawRoot(StringBuffer nodeXmlStr) throws BLException {
		nodeXmlStr.append("<Node ");
		nodeXmlStr.append("id='1' ");
		nodeXmlStr.append("name='");
		nodeXmlStr.append("Start");
		nodeXmlStr.append("' desc='");
		nodeXmlStr.append("Start");
		nodeXmlStr.append("' showRelation='false'");
		nodeXmlStr.append(" nodeClass='earth'");
		nodeXmlStr.append(" nodeIcon='");
		nodeXmlStr.append("0");
		nodeXmlStr.append("'/>");
	}
	
	/**
	 * 画影响分析图
	 * 
	 * @param linkMap 链路集合
	 * @param selEiid 选中的资产ID
	 * @param nodeXmlStr 节点XML
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 快照生成时间
	 * @throws BLException
	 */
	private void drawGraph(List<EiLinkMapInfo> linkMap, Integer selEiid, StringBuffer nodeXmlStr, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer actionXmlStr = new StringBuffer();
		//过滤重复的资产
		Set<Integer> eiidSet = new HashSet<Integer>();
		//过滤重复的线
		Set<String> lineSet = new HashSet<String>();
		Integer fromId = 1;
		//判断链路是否已画到选中资产，到了则不往下画
		boolean flag = false;
		for(EiLinkMapInfo eiLinkMap : linkMap) {
			if(flag && eiLinkMap.getLinkorder().intValue() != 1) {
				continue;
			}
			if(eiLinkMap.getLinkorder().intValue() == 1) {
				fromId = 1;
				flag = false;//重置标志
			}
			if(!eiidSet.contains(eiLinkMap.getEiid())) {
				//构造节点XML
				this.drawNode(nodeXmlStr, eiLinkMap, selEiid, domainid, domainversion, createtime);
				eiidSet.add(eiLinkMap.getEiid());
			}
			if(!lineSet.contains(fromId.toString() + "-" + eiLinkMap.getEiid().toString())) {
				//构造ActionXML
				this.drawLine(actionXmlStr, fromId, eiLinkMap.getEiid());
				lineSet.add(fromId.toString() + "-" + eiLinkMap.getEiid().toString());
			}
			fromId = eiLinkMap.getEiid();
			//是否已画到选中资产
			if(fromId.equals(selEiid)) {
				flag = true;
				fromId = 1;
			}
		}
		nodeXmlStr.append(actionXmlStr);
	}

	/**
	 * 影响CI检索处理(默认检索default域)
	 * 
	 * @param eiid 选择的资产ID
	 * @param domainid 域ID
	 * @param syscoding 影响CI模型层次码
	 * @return 影响CI资产ID集合
	 * @throws BLException
	 */
	public List<Integer> searchImpactCI(Integer eiid, Integer domainid, String syscoding) throws BLException {
		EiLinkMapSearchCondImpl cond = new EiLinkMapSearchCondImpl();
		if(domainid == null) {
			cond.setDomainid_eq(EiDomainKeyWords.DOOMAIN_ID_DEFAULT);
		}
		cond.setDomainid_eq(1);
		cond.setEiid_eq(eiid);
		cond.setEsyscoding_eq(syscoding);
		return this.eiLinkMapBL.queryImpactCI(cond);
	}
	
}