/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0111PK;

/**
  * 概述: 拓扑图业务逻辑实现
  * 功能描述: 拓扑图业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SocDomainGraphBLImpl extends BaseBLImpl implements
	SocDomainGraphBL {

	/** 拓扑图链路信息BL */
	protected SOC0114BL soc0114BL;
	
	/** 域定义信息BL */
	protected SOC0111BL soc0111BL;
	
	/** 快照BL */
	protected SOC0121BL soc0121BL;
	
	
	public void setSoc0114BL(SOC0114BL soc0114BL) {
		this.soc0114BL = soc0114BL;
	}

	public void setSoc0111BL(SOC0111BL soc0111BL) {
		this.soc0111BL = soc0111BL;
	}

	public void setSoc0121BL(SOC0121BL soc0121BL) {
		this.soc0121BL = soc0121BL;
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
	 * 构造节点
	 * 
	 * @param nodeXmlStr 节点XML
	 * @param eiLinkMap 链路上的资产
	 * @param selEiid 高亮的资产ID
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 快照生成时间
	 */
	private void drawNodeOne(StringBuffer nodeXmlStr,Integer linkSize,Integer linkNum, SOC0114Info eiLinkInfo, 
			Integer domainid, Integer domainversion) throws BLException {
		nodeXmlStr.append("<NODE ");
		nodeXmlStr.append("id=\"");
		nodeXmlStr.append(eiLinkInfo.getEiid());//节点ID
		nodeXmlStr.append("\" eiid=\"");
		nodeXmlStr.append(eiLinkInfo.getEiid());//资产ID
		nodeXmlStr.append("\" name=\"");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkInfo.getEiname()));//资产名称
		nodeXmlStr.append("\" alert=\"flase\"");
		nodeXmlStr.append(" x=\"\"");
		nodeXmlStr.append(" y=\"\"");
		nodeXmlStr.append(" esyscoding=\"");
		nodeXmlStr.append(eiLinkInfo.getEsyscoding());//资产模型层次码
		nodeXmlStr.append("\" domainversion=\"");//域版本
		nodeXmlStr.append(domainversion.toString());
		nodeXmlStr.append("\" imgUrl=\"../monitor/");
		nodeXmlStr.append(eiLinkInfo.getEsyscoding());//资产模型层次码
		nodeXmlStr.append(".png\"/>");
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
	private void drawNodeTwo(StringBuffer nodeXmlStr,Integer linkSize,Integer linkNum, SOC0114Info eiLinkInfo, 
			Integer domainid, Integer domainversion) throws BLException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension scrnsize = toolkit.getScreenSize();
		nodeXmlStr.append("<NODE ");
		nodeXmlStr.append("id=\"");
		nodeXmlStr.append(eiLinkInfo.getEiid());//节点ID
		nodeXmlStr.append("\" eiid=\""); 
		nodeXmlStr.append(eiLinkInfo.getEiid());//资产ID
		nodeXmlStr.append("\" name=\"");
		nodeXmlStr.append(TopologyGraph.filterStr(eiLinkInfo.getEiname()));//资产名称
		nodeXmlStr.append("\" alert=\"flase\"");
		nodeXmlStr.append(" esyscoding=\"");
		nodeXmlStr.append(eiLinkInfo.getEsyscoding()).append("\"");//资产模型层次码
		nodeXmlStr.append(" domainversion=\"");//域版本
		nodeXmlStr.append(domainversion.toString()).append("\"");
		//设置链路节点坐标
		if(eiLinkInfo.getEsyscoding().startsWith("999001001")){
			nodeXmlStr.append(" x=\"100\"");
			nodeXmlStr.append(" y=\"");
			nodeXmlStr.append(scrnsize.height/linkSize*(linkSize/2));
		}
//		else if(eiLinkInfo.getEsyscoding().startsWith("999001010")
//				||eiLinkInfo.getEsyscoding().startsWith("999001009")){
//			nodeXmlStr.append(" x=\""+eiLinkInfo.getLinkorder()*130).append("\"");
//			nodeXmlStr.append(" y=\"");
//			nodeXmlStr.append(scrnsize.height/(linkSize+1)*linkNum);
//		}
		else if(eiLinkInfo.getEsyscoding().startsWith("999001011")){
			nodeXmlStr.append(" x=\""+eiLinkInfo.getLinkorder()*100).append("\"");
			nodeXmlStr.append(" y=\"");
			nodeXmlStr.append(scrnsize.height/(linkSize+1)*linkNum);
		}else{
			nodeXmlStr.append(" x=\""+eiLinkInfo.getLinkorder()*120).append("\"");
			nodeXmlStr.append(" y=\"");
			nodeXmlStr.append(scrnsize.height/(linkSize+1)*linkNum);
		}
		nodeXmlStr.append("\" imgUrl=\"../monitor/");
		nodeXmlStr.append(eiLinkInfo.getEsyscoding());//资产模型层次码
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
		actionXmlStr.append("<Edge ");
		actionXmlStr.append("fromID='");
		actionXmlStr.append(fromId);
		actionXmlStr.append("' toID='");
		actionXmlStr.append(to_id);
		actionXmlStr.append("'");
		actionXmlStr.append("/>");
	}
	
	/**
	 * 连线
	 * 
	 * @param actionXmlStr 连线XML
	 * @param fromId 起始节点ID
	 * @param to_id 结束节点ID
	 */
	private void drawLineOne(StringBuffer actionXmlStr, Integer fromId, Integer to_id) {
		actionXmlStr.append("<LINE ");
		actionXmlStr.append("fromNode=\"");
		actionXmlStr.append(fromId);
		actionXmlStr.append("\" toNode=\"");
		actionXmlStr.append(to_id);
		actionXmlStr.append("\"");
		actionXmlStr.append("/>");
	}
	
	/**
	 * 拓扑图显示初始化处理(默认检索default域)
	 * 
	 * @param ei 选中资产信息
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 创建时间
	 * @return 显示用XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(SOC0118Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		SOC0111Info domain = null;
		Map<Integer, List<SOC0114Info>> linkMap=new HashMap<Integer, List<SOC0114Info>>();
		//取默认域ID
		if(domainid == null || domainid.intValue() == 0) {
			domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		}
		//取最大域版本
		if(domainversion == null || domainversion.intValue() == 0) {
			domain = this.soc0111BL.searchDomainMaxVersion(domainid);
			domainversion = domain.getVersion();
			if(StringUtils.isEmpty(createtime)) {
				createtime = domain.getUpdatetime();
			}
		}
		//取拓扑图链路创建时间
		if(StringUtils.isEmpty(createtime)) {
			domain = this.soc0111BL.searchEiDomainDefByPK(new SOC0111PK (domainid, domainversion));
			createtime = domain.getUpdatetime();
		}
		
		List<SOC0114Info> linkList = this.searchLinkMap(ei, domainid, domainversion, createtime);
		//组装新链路集合
		Iterator<SOC0114Info> linkIt=linkList.iterator();
		while(linkIt.hasNext()){
			SOC0114Info linkInfo=linkIt.next();
			if(linkMap.get(linkInfo.getLinkid())!=null){
				List<SOC0114Info> newLinkList=linkMap.get(linkInfo.getLinkid());
				newLinkList.add(linkInfo);
				linkMap.put(linkInfo.getLinkid(), newLinkList);
			}else{
				List<SOC0114Info> newLinkList=new ArrayList<SOC0114Info>();
				newLinkList.add(linkInfo);
				linkMap.put(linkInfo.getLinkid(), newLinkList);
			}
		}
		return this.createXmlOne(ei, linkMap, domainid, domainversion);
	}
	
	/**
	 * 影响CI为硬盘时拓扑图显示
	 * @param ei
	 * @param domainid
	 * @param domainversion
	 * @param updatetime
	 * @param diskei
	 * @return
	 * @throws BLException
	 */
	public String initGraph(SOC0118Info ei, Integer domainid,
			Integer domainversion, String updatetime, SOC0118Info diskei)
			throws BLException {
		//应用eiid集合
		List<Integer>  appeiids=new ArrayList<Integer>();
		//链路id
		List<Integer>  linkids=new ArrayList<Integer>();
		//与该硬盘相关的应用的链路集合
		List<SOC0114Info> newLinkMap=new ArrayList<SOC0114Info>();
		//总的链路集合
		List<SOC0114Info> linkMap = this.searchLinkMap(ei, domainid, domainversion, updatetime);
		SOC0121SearchCondImpl snapshotRelationSearchCond=new SOC0121SearchCondImpl();
		snapshotRelationSearchCond.setSrcldeiid_eq(Integer.toString(diskei.getEiid()));
		snapshotRelationSearchCond.setSrcldversion_eq(Integer.toString(diskei.getEiversion()));
		snapshotRelationSearchCond.setSrcldsmallversion_eq(Integer.toString(diskei.getEismallversion()));
		snapshotRelationSearchCond.setSrdomainid_eq(Integer.toString(domainid));
		snapshotRelationSearchCond.setSrdomainversion_eq(Integer.toString(domainversion));
		snapshotRelationSearchCond.setSrassetrelation_eq("235");
		snapshotRelationSearchCond.setDeleteflag_eq("0");
		//检索出与该硬盘相关的FS
		List<SOC0121Info>  snapshotRelationInfoList=this.soc0121BL.searchSnapshotRelation(snapshotRelationSearchCond);
		
		SOC0121SearchCondImpl snapshotRelationSearch=new SOC0121SearchCondImpl();
		snapshotRelationSearch.setSrpareiid_eq(Integer.toString(ei.getEiid()));
		snapshotRelationSearch.setSrparversion_eq(Integer.toString(ei.getEiversion()));
		snapshotRelationSearch.setSrparsmallversion_eq(Integer.toString(ei.getEismallversion()));
		snapshotRelationSearch.setSrdomainid_eq(Integer.toString(domainid));
		snapshotRelationSearch.setSrdomainversion_eq(Integer.toString(domainversion));
		snapshotRelationSearch.setSrassetrelation_eq("213");
		snapshotRelationSearch.setDeleteflag_eq("0");
		//检索出与该主机相关的FS
		List<SOC0121Info>  host_FSRelationInfoList=this.soc0121BL.searchSnapshotRelation(snapshotRelationSearch);
		//与主机、硬盘都有关的FS
		Map<Integer,SOC0121Info> map=new HashMap<Integer, SOC0121Info>();
		if(snapshotRelationInfoList!=null&&snapshotRelationInfoList.size()>0){
			if(host_FSRelationInfoList!=null&&host_FSRelationInfoList.size()>0){
				for(SOC0121Info host_FSInfo:host_FSRelationInfoList){
					for(SOC0121Info disk_FSInfo:snapshotRelationInfoList){
						if(host_FSInfo.getSrcldeiid().equals(disk_FSInfo.getSrpareiid())){
							map.put(host_FSInfo.getSrid(), host_FSInfo);
						}
					}
				}
			}
		}
		//检索出与FS相关的应用
		if(map!=null&&map.size()>0){
			Set<Map.Entry<Integer,SOC0121Info>> cset = map.entrySet();
			for(Iterator<Map.Entry<Integer,SOC0121Info>> iter = cset.iterator();iter.hasNext();){
				Map.Entry<Integer,SOC0121Info> entry = iter.next();
				SOC0121SearchCondImpl cond=new SOC0121SearchCondImpl();
				cond.setSrcldeiid_eq(Integer.toString(entry.getValue().getSrcldeiid()));
				cond.setSrcldversion_eq(Integer.toString(entry.getValue().getSrcldversion()));
				cond.setSrcldsmallversion_eq(Integer.toString(entry.getValue().getSrcldsmallversion()));
				cond.setSrdomainid_eq(Integer.toString(domainid));
				cond.setSrdomainversion_eq(Integer.toString(domainversion));
				cond.setSrassetrelation_eq("4");
				cond.setDeleteflag_eq("0");
				//检索出与FS相关的应用
				List<SOC0121Info>  snapshotRelationList=this.soc0121BL.searchSnapshotRelation(cond);
				if(snapshotRelationList!=null&&snapshotRelationList.size()>0){
					for(SOC0121Info snapshotRelation:snapshotRelationList){
						appeiids.add(snapshotRelation.getSrpareiid());
					}
				}
			}
		}
		if(appeiids!=null&&appeiids.size()>0){
			if(linkMap!=null&&linkMap.size()>0){
				//通过应用ID和总的链路集合过滤出链路ID
				for(Integer appeiid:appeiids){
					for(SOC0114Info eiLinkMapInfo:linkMap){
						if(appeiid.equals(eiLinkMapInfo.getEiid())){
							linkids.add(eiLinkMapInfo.getLinkid());
						}
					}
				}
				//通过链路ID和总的链路集合过滤出与该硬盘相关应用的链路集合
				if(linkids!=null&&linkids.size()>0){
					for(Integer linkid:linkids){
						for(SOC0114Info eiLinkMapInfo:linkMap){
							if(linkid.equals(eiLinkMapInfo.getLinkid())){
								newLinkMap.add(eiLinkMapInfo);
							}
						}
						
					}
				}
			}
			
			return this.createXml(ei, newLinkMap, domainid, domainversion, updatetime);
		}else{
			return this.createXml(ei, linkMap, domainid, domainversion, updatetime);
		}
	}
	
	/**
	 * 拓扑图链路检索
	 * 
	 * @param ei 资产信息
	 * @param domainid 域ID
	 * @param domainversion 域版本
	 * @param createtime 创建时间
	 * @return 显示用XML
	 * @throws BLException 
	 * 
	 */
	private List<SOC0114Info> searchLinkMap(SOC0118Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException {
		
		if(ei!=null){
			String  esyscoding = ei.getEsyscoding();
			Integer temp_eiid = ei.getEiid();
			//判断资产类型，如果为DA或者DISK则需要先找到其所属存储（顶级CI）的EIID，再按照该EIID进行影响分析
			if("999001012".equals(esyscoding) || "999001013".equals(esyscoding)){
				temp_eiid = ei.getEirootmark();
			}
			
			
			SOC0114SearchCondImpl cond = new SOC0114SearchCondImpl();
			cond.setDomainid_eq(domainid);//域ID
			cond.setDomainversion_eq(domainversion);//域版本
			cond.setEiid_eq(temp_eiid);//资产ID
//			cond.setCreatetime_eq(createtime);//最新域快照时间
			cond.setLinkflag_eq("1");//绘图标记
			return this.soc0114BL.queryEiLinkMapList(cond);
		}else{
			return null;
		}
		
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
	protected String createXml(SOC0118Info ei, List<SOC0114Info> linkMap, 
			Integer domainid, Integer domainversion, String createtime) throws BLException {
		StringBuffer nodeXmlStr = new StringBuffer("<?xml version='1.0' encoding='utf-8'?>");
		nodeXmlStr.append("<TopologyGraph>");
		this.drawRoot(nodeXmlStr);
		this.drawGraph(linkMap, ei.getEiid(), nodeXmlStr, domainid, domainversion, createtime);
		nodeXmlStr.append("</TopologyGraph>");
		return nodeXmlStr.toString();
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
	protected String createXmlOne(SOC0118Info ei,Map<Integer, List<SOC0114Info>>  linkMap, 
			Integer domainid, Integer domainversion) throws BLException {
		//链路条数
		Integer linkSize=linkMap.size();
		//过滤重复的资产
		Set<Integer> eiidSet = new HashSet<Integer>();
		//过滤重复的线
		Set<String> lineSet = new HashSet<String>();
		StringBuffer nodeXmlStr = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		nodeXmlStr.append("<root>");
		Integer linkNum=1;
		if(ei.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)||
				ei.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)){
			this.drawRootSwitch(nodeXmlStr,ei,domainversion);
			eiidSet.add(ei.getEiid());
		}
		//循环添加链路
		for(Map.Entry<Integer, List<SOC0114Info>> entry: linkMap.entrySet()) {
			this.drawGraphOne(entry.getValue(),ei,linkSize,linkNum, nodeXmlStr, domainid, domainversion,eiidSet,lineSet);
			linkNum++;
		} 
		nodeXmlStr.append("</root>");
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
	 * 构造根节点
	 * 
	 * @param actionXmlStr 节点XML
	 */
	private void drawRootSwitch(StringBuffer nodeXmlStr,SOC0118Info ei,Integer domainversion) throws BLException {
		if(ei.getEsyscoding().startsWith(EiRelationKeyWords.HOST)){
			Toolkit toolkit = Toolkit.getDefaultToolkit();
	        Dimension scrnsize = toolkit.getScreenSize();
			nodeXmlStr.append("<NODE ");
			nodeXmlStr.append("id=\"");
			nodeXmlStr.append(ei.getEiid());//节点ID
			nodeXmlStr.append("\" eiid=\""); 
			nodeXmlStr.append(ei.getEiid());//资产ID
			nodeXmlStr.append("\" name=\"");
			nodeXmlStr.append(TopologyGraph.filterStr(ei.getEiname()));//资产名称
			nodeXmlStr.append("\" alert=\"flase\"");
			nodeXmlStr.append(" esyscoding=\"");
			nodeXmlStr.append(ei.getEsyscoding()).append("\"");//资产模型层次码
			nodeXmlStr.append(" domainversion=\"");//域版本
			nodeXmlStr.append(domainversion.toString()).append("\"");
			//设置链路节点坐标
			nodeXmlStr.append(" x=\"100\"");
			nodeXmlStr.append(" y=\"");
			nodeXmlStr.append(scrnsize.height/2);
			nodeXmlStr.append("\" imgUrl=\"../monitor/");
			nodeXmlStr.append(ei.getEsyscoding());//资产模型层次码
			nodeXmlStr.append(".png\"/>");
		}else{
			nodeXmlStr.append("<NODE ");
			nodeXmlStr.append("id=\"");
			nodeXmlStr.append(ei.getEiid());
			nodeXmlStr.append("\" eiid=\"");
			nodeXmlStr.append(ei.getEiid());
			nodeXmlStr.append("\" name=\"");
			nodeXmlStr.append(ei.getEiname());
			nodeXmlStr.append("\" alert=\"false\"");
			nodeXmlStr.append(" x=\"\"");
			nodeXmlStr.append(" y=\"\"");
			nodeXmlStr.append(" domainversion=\"");//域版本
			nodeXmlStr.append(domainversion.toString()).append("\"");
			nodeXmlStr.append(" esyscoding=\"");
			nodeXmlStr.append(ei.getEsyscoding());//资产模型层次码
			nodeXmlStr.append("\" imgUrl=\"../monitor/");
			nodeXmlStr.append(ei.getEsyscoding());//资产模型层次码
			nodeXmlStr.append(".png\"/>");
		}
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
			//不显示DA和DISK
			if(eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.DA)
					|| eiLinkMap.getEsyscoding().startsWith(EiRelationKeyWords.DISK)) {
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
			if(!lineSet.contains(fromId.toString() + "-" + eiLinkMap.getEiid().toString())) {
				//构造ActionXML
				this.drawLine(actionXmlStr, fromId, eiLinkMap.getEiid());
				lineSet.add(fromId.toString() + "-" + eiLinkMap.getEiid().toString());
			}
			fromId = eiLinkMap.getEiid();
		}
		nodeXmlStr.append(actionXmlStr);
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
	private void drawGraphOne(List<SOC0114Info> linkList,SOC0118Info ei,Integer linkSize,Integer linkNum,StringBuffer nodeXmlStr, 
			Integer domainid, Integer domainversion,Set<Integer> eiidSet,Set<String> lineSet) throws BLException {
		StringBuffer actionXmlStr = new StringBuffer();
		//链路fromId
		Integer fromId = 1;
		for(SOC0114Info eiLinkInfo : linkList) {
			if(ei.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
					||ei.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)){
				//不显示HBA、HBAPORT、SANPORT、FRONTPORT、FA
				if(eiLinkInfo.getEsyscoding().startsWith(EiRelationKeyWords.HBA)
						|| eiLinkInfo.getEsyscoding().startsWith(EiRelationKeyWords.HBAPORT)
							||eiLinkInfo.getEsyscoding().startsWith(EiRelationKeyWords.FRONTPORT)
							||eiLinkInfo.getEsyscoding().startsWith(EiRelationKeyWords.SANPORT)
							||eiLinkInfo.getEsyscoding().startsWith(EiRelationKeyWords.FA)) {
					continue;
				}
			}
			if(!eiidSet.contains(eiLinkInfo.getEiid())) {
				//构造节点XML
				if(ei.getEsyscoding().startsWith(EiRelationKeyWords.HOST)||ei.getEsyscoding().startsWith(EiRelationKeyWords.APP)){
					this.drawNodeTwo(nodeXmlStr,linkSize,linkNum, eiLinkInfo, domainid, domainversion);
				}else{
					this.drawNodeOne(nodeXmlStr,linkSize,linkNum, eiLinkInfo, domainid, domainversion);
				}
				eiidSet.add(eiLinkInfo.getEiid());
			}
//			if(ei.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)){
//				if(!lineSet.contains(ei.getEiid() + "-" + eiLinkInfo.getEiid().toString())) {
//					//构造ActionXML
//					this.drawLineOne(actionXmlStr, ei.getEiid(), eiLinkInfo.getEiid());
//					lineSet.add(ei.getEiid() + "-" + eiLinkInfo.getEiid().toString());
//				}
//				//设置链路fromId
//				fromId = eiLinkInfo.getEiid();
//			}else{
				if(!lineSet.contains(fromId.toString() + "-" + eiLinkInfo.getEiid().toString())&&
						eiLinkInfo.getLinkorder().intValue()!=1) {
					//构造ActionXML
					this.drawLineOne(actionXmlStr, fromId, eiLinkInfo.getEiid());
					lineSet.add(fromId.toString() + "-" + eiLinkInfo.getEiid().toString());
				}
				//设置链路fromId
				fromId = eiLinkInfo.getEiid();
//			}
		}
		nodeXmlStr.append(actionXmlStr);
	}


}