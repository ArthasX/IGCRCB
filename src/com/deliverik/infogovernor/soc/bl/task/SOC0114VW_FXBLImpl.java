/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0107DAO;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCondImpl;
import com.deliverik.infogovernor.dbm.model.dao.TOPOXMLDAO;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM06BL;
import com.deliverik.infogovernor.soc.model.SOC0114VWInfo;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCond;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCondImpl;
import com.deliverik.infogovernor.soc.model.condition.UserRegionSearchCondImpl;
import com.deliverik.infogovernor.soc.model.dao.SOC0114VW_FXDAO;
import com.deliverik.infogovernor.soc.model.dao.UserRegionDAO;

/**
 * SOC0114VW_FX业务逻辑接口实现
 */
public class SOC0114VW_FXBLImpl extends BaseBLImpl implements SOC0114VW_FXBL{
	
	/** DAO */
	protected SOC0114VW_FXDAO soc0114VW_FXDAO;
	protected SOC0107DAO soc0107DAO;
	protected TOPOXMLDAO topoxmldao;
	protected CRM06BL crm06BL;
	protected UserRegionDAO userRegionDAO;
	
	public void setUserRegionDAO(UserRegionDAO userRegionDAO) {
		this.userRegionDAO = userRegionDAO;
	}
	
	public void setSoc0114VW_FXDAO(SOC0114VW_FXDAO soc0114VW_FXDAO) {
		this.soc0114VW_FXDAO = soc0114VW_FXDAO;
	}

	public void setSoc0107DAO(SOC0107DAO soc0107DAO) {
		this.soc0107DAO = soc0107DAO;
	}


	public void setTopoxmldao(TOPOXMLDAO topoxmldao) {
		this.topoxmldao = topoxmldao;
	}

	public void setCrm06BL(CRM06BL crm06BL) {
		this.crm06BL = crm06BL;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public String searchSOC0114VW_FXByCond(SOC0114VW_FXSearchCond cond){
		String xmlData = "";
		String legendData = "";
		Integer colorArrIndex =0;
    	String temp_x="";
    	String temp_y="";
    	List<String>  nodeEiidList=new ArrayList<String>();
    	TOPOXMLSearchCondImpl tcond=new TOPOXMLSearchCondImpl();
    	tcond.setIsellipsis("b");
    	List<TOPOXMLInfo> list_axis=topoxmldao.findByCond(tcond, 0, 0);
		List<SOC0114VWInfo> list_0114_FX=soc0114VW_FXDAO.findByCond(cond);
		Map<String, String> colorMap=new HashMap<String, String>();
		if(list_0114_FX.size()>0){
			xmlData="<?xml version='1.0' encoding='utf-8'?><root>";
			legendData = "<?xml version='1.0' encoding='utf-8'?><root>";
//			SOC0107SearchCondImpl cond0107 = new SOC0107SearchCondImpl();
			String name="";
			for (int i=0;i<list_0114_FX.size();i++) {
//    			String datatips ="";
    			if(colorMap!=null&&colorMap.size()>0){
    				if(colorMap.get(list_0114_FX.get(i).getHostIP())!=null){
    					colorArrIndex=Integer.parseInt(colorMap.get(list_0114_FX.get(i).getHostIP()).split("_")[3]);
    				}else{
    					colorArrIndex++;
    					colorMap.put(list_0114_FX.get(i).getHostIP(), list_0114_FX.get(i).getHostEiid()+"_"+list_0114_FX.get(i).getHostVersion()+"_"+list_0114_FX.get(i).getHostSmallVersion()+"_"+colorArrIndex);
    				}
    			}else{
    				if(StringUtils.isNotEmpty(list_0114_FX.get(i).getHostIP())){
    					colorMap.put(list_0114_FX.get(i).getHostIP(), list_0114_FX.get(i).getHostEiid()+"_"+list_0114_FX.get(i).getHostVersion()+"_"+list_0114_FX.get(i).getHostSmallVersion()+"_"+colorArrIndex);
    				}
    			}
    	   		for (TOPOXMLInfo xmlinfo : list_axis) {
        			if(xmlinfo.getMyid().equals(list_0114_FX.get(i).getEiid().toString())){
        				temp_x=xmlinfo.getAixs().split("\\,")[0];
        				temp_y=xmlinfo.getAixs().split("\\,")[1];
        				break;
        			}
        		}
//    	   		cond0107.setEiid(list_0114_FX.get(i).getEiid().toString());
//    	   		cond0107.setCiversion(list_0114_FX.get(i).getEiversion().toString());
//    	   		cond0107.setCismallversion(list_0114_FX.get(i).getEismallversion().toString());
//    	   		List<SOC0107Info> info0107_list=soc0107DAO.findByCond(cond0107, 0, 0);//datatips
//    	   		for (SOC0107Info soc0107Info : info0107_list) {
//					datatips+=soc0107Info.getConfiguration().getCname()+": "+soc0107Info.getCivalue()+"\\n ";
//				}
    	   		if(list_0114_FX.get(i).getEiname().length()>14){
    	   			name=list_0114_FX.get(i).getEiname().substring(0, 13)+"...";
    	   		}else{
    	   			name=list_0114_FX.get(i).getEiname();
    	   		}
    	   		if(nodeEiidList!=null&&nodeEiidList.size()>0){
    	   			if(!nodeEiidList.contains(list_0114_FX.get(i).getEiid().toString())){
    	   				xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
    	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
    	   				"alert='false' name='"+name+"' " +
						"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='"+colorArrIndex+"' smalltype='"+list_0114_FX.get(i).getLinkorder()+"' />";
    	   			}
    	   		}else{
    	   			xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
    	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
    	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
					"alert='false' name='"+name+"' " +
					"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='"+colorArrIndex+"' smalltype='"+list_0114_FX.get(i).getLinkorder()+"' />";
    	   		}
    	   		nodeEiidList.add(list_0114_FX.get(i).getEiid().toString());
				if(i< list_0114_FX.size()-1){
					if(list_0114_FX.get(i).getLinkid().intValue() == list_0114_FX.get(i+1).getLinkid().intValue()){
						xmlData+="<LINE id='"+Math.random()+"' " +
								"fromNode='"+list_0114_FX.get(i).getEiid().toString()+"' " +
								"toNode='"+list_0114_FX.get(i+1).getEiid().toString()+"' />";
					}
				}
			}
			if(colorMap!=null&&colorMap.size()>0){
				Set<Map.Entry<String,String>> set= colorMap.entrySet();
				for(Iterator<Map.Entry<String,String>> iter = set.iterator();iter.hasNext();){
					Map.Entry<String,String> entry = iter.next();
					String value=entry.getValue();
					String eiid=value.split("_")[0];
					String version=value.split("_")[1];
					String smallversion=value.split("_")[2];
					String color=value.split("_")[3];
					legendData+= "<LEGEND_NODE id='"+eiid+"' parentnode='"+color+"' textvalue=\'"+entry.getKey()+"' eirootmark='"+eiid+"' version='"+version+"' smallversion='"+smallversion+"' />" ;
				}
			}
			xmlData+="</root>";
			legendData+="</root>";
		}
		return xmlData+"@"+legendData;
	}
	
	/**
	 * 应用维护拓扑查询
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public String searchSOC0114VW_FXAPPByCond(SOC0114VW_FXSearchCond cond,String FLEXID){
		StringBuffer xmlData = new StringBuffer();
		//查询保存坐标的
		TOPOXMLSearchCondImpl tcond=new TOPOXMLSearchCondImpl();
    	tcond.setIsellipsis("c");
    	List<TOPOXMLInfo> list_axis=topoxmldao.findByCond(tcond, 0, 0);
    	HashMap<String, String> topoXYMap = null;
    	if(list_axis != null){
    		if(list_axis.size() >0){
	    		topoXYMap = new HashMap<String, String>();
				for (TOPOXMLInfo xmlinfo : list_axis) {
					topoXYMap.put(xmlinfo.getMyid(), xmlinfo.getAixs());
				}
    		}
    	}
    	//查询链路
    	String temp_x="";
    	String temp_y="";
		List<SOC0114VWInfo> list_0114_FX=soc0114VW_FXDAO.findByCond(cond);
		if(list_0114_FX.size()==0){
			return xmlData.toString();
		}
		Map<String,SOC0114VWInfo> intMap = null;
		Map<Integer,List<SOC0114VWInfo>> linkMap = new LinkedHashMap<Integer,List<SOC0114VWInfo>>();
		//把链路Map便于拼接LINK
		Integer linkid = list_0114_FX.get(0).getLinkid();
		List<SOC0114VWInfo> linkList = new ArrayList<SOC0114VWInfo>();
		int num=0;
		//以Map保存多链路
		for(SOC0114VWInfo soc0114 : list_0114_FX){
			num++;
			if(linkid.equals(soc0114.getLinkid())){
				linkList.add(soc0114);
				if(num==list_0114_FX.size()){
					linkMap.put(linkid, linkList);
				}
			}else{
				linkMap.put(linkid, linkList);
				linkid = soc0114.getLinkid();
				linkList = new ArrayList<SOC0114VWInfo>();
				linkList.add(soc0114);
			}
		}
		
		Map<Integer,Boolean> ibMap = new HashMap<Integer,Boolean>();//判断节点是否已经拼接过XML
		Map<String,Integer> iiMap = new HashMap<String,Integer>();//判断链路关系是否拼接过XML
		xmlData.append("<?xml version='1.0' encoding='utf-8'?><root>");
		Set<Map.Entry<Integer,List<SOC0114VWInfo>>> set= linkMap.entrySet();//循环多链路
			for(Iterator<Map.Entry<Integer,List<SOC0114VWInfo>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<SOC0114VWInfo>> entry = iter.next();
				intMap = new LinkedHashMap<String,SOC0114VWInfo>();//保存单条链路便于取得下一个节点数据
				List<SOC0114VWInfo> soc0114List = entry.getValue();
				for(SOC0114VWInfo soc0114info:soc0114List){
					intMap.put(soc0114info.getLinkorder(), soc0114info);
				}
				//查询已经保存的坐标
	   			String formeiid = "";
				for(int i=0;i<soc0114List.size();i++){
					SOC0114VWInfo soc0114vwInfo = soc0114List.get(i);
					String eitype=null;
					
					if(soc0114vwInfo.getHostEiid()!=null){
						eitype=soc0114VW_FXDAO.getEitype(soc0114vwInfo.getHostEiid().toString());
					}
	    	   		
	    	   		//判断是业务系统，应用模块还是中间件及数据库
	    	   		if((soc0114vwInfo.getHostEiid()==null || "".equals(soc0114vwInfo.getHostEiid()))){
	    	   			if(ibMap.get(soc0114vwInfo.getEiid())==null){
	    	   				//拼接链路关系
		        	   		if(!"".equals(formeiid)){
		        	   			xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+soc0114vwInfo.getEiid()+"' />");
		        	   			iiMap.put(formeiid, soc0114vwInfo.getEiid());
		        	   		}
		        	   		if (topoXYMap != null) {
		            			if(StringUtils.isNotEmpty(topoXYMap.get(soc0114vwInfo.getEiid().toString()) )){
		            				temp_x=topoXYMap.get(soc0114vwInfo.getEiid().toString()).split("\\,")[0];
		            				temp_y=topoXYMap.get(soc0114vwInfo.getEiid().toString()).split("\\,")[1];
		            			}
		            		}
		        	   		//拼接XML节点
		       				xmlData.append("<NODE id='"+soc0114vwInfo.getEiid()+"' eiid2='' eiid3='' ");
		    	   			xmlData.append("eirootmark='' eiversion1='"+soc0114vwInfo.getEiversion()+"' eismallversion1='"+soc0114vwInfo.getEismallversion()+"' ");
		    	   			xmlData.append("eiversion2='' eismallversion2='' eiversion3='' eismallversion3='' ");
		    	   			xmlData.append("alert='false' name='"+soc0114vwInfo.getEiname()+"' iptext='' apptext='' eitype='"+eitype+"'");
		    	   			xmlData.append("x='"+temp_x+"' y='"+temp_y+"' datatips='"+soc0114vwInfo.getEiname()+"' smalltype1='"+getSmalltype(soc0114vwInfo.getEsyscoding())+"' smalltype2='0' />");
		    	   			formeiid = String.valueOf(soc0114vwInfo.getEiid());
		    	   			ibMap.put(soc0114vwInfo.getEiid(), true);//该节点不在重复添加
	    	   			}else{
	    	   				//如果该节点已经添加过则不需要拼接节点，只需拼接链路关系。
	    	   				if(iiMap.get(formeiid)!=null && !iiMap.get(formeiid).equals(String.valueOf(soc0114vwInfo.getEiid()))){
		        	   			xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+soc0114vwInfo.getEiid()+"' />");
	    	   				}
	    	   				//把当前节点作为链路关系父节点
	    	   				formeiid = String.valueOf(soc0114vwInfo.getEiid());
	    	   			}
	    	   		}else{
	    	   			//当不是业务系统或应用模块时，需判断两层之间，具体的前后关系。
	    	   			SOC0114VWInfo vwinfoChild = intMap.get(String.valueOf(Integer.parseInt(soc0114vwInfo.getLinkorder())+1));
	    	   			if(vwinfoChild!=null){//判断时候有下一级链路节点
	    	   				String esyscoding = soc0114vwInfo.getEsyscoding();
	    	   				//通过Esyscoding判断下一级节点与本节点之间谁是父节点。
	        	   			if(soc0114vwInfo.getEsyscoding().length()<=vwinfoChild.getEsyscoding().length()){
	        	   				if(vwinfoChild.getEsyscoding().substring(0,vwinfoChild.getEsyscoding().length()-3).equals(esyscoding)){
	        	   					//如果该节点已经拼接过XML则不重复拼接
	        	   					if(ibMap.get(vwinfoChild.getEiid())==null){
	        	   						if(!"".equals(formeiid)){
			        	       				xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+vwinfoChild.getEiid()+"' />");
	        	   							iiMap.put(formeiid, vwinfoChild.getEiid());
	        	   						}
	        		        	   		if (topoXYMap != null) {
	        		            			if(StringUtils.isNotEmpty(  topoXYMap.get(vwinfoChild.getEiid().toString()) )){
	        		            				temp_x=topoXYMap.get(vwinfoChild.getEiid().toString()).split("\\,")[0];
	        		            				temp_y=topoXYMap.get(vwinfoChild.getEiid().toString()).split("\\,")[1];
	        		            			}
	        		            		}
		        	   					xmlData.append("<NODE id='"+vwinfoChild.getEiid()+"' eiid2='"+soc0114vwInfo.getHostEiid()+"' eiid3='"+soc0114vwInfo.getEiid()+"' ");
		        	    	   			xmlData.append("eirootmark='"+soc0114vwInfo.getHostEiid()+"' eiversion1='"+vwinfoChild.getEiversion()+"' eismallversion1='"+vwinfoChild.getEismallversion()+"' ");
		        	    	   			xmlData.append("eiversion2='"+soc0114vwInfo.getHostVersion()+"' eismallversion2='"+soc0114vwInfo.getHostSmallVersion()+"' eiversion3='"+soc0114vwInfo.getEiversion()+"' eismallversion3='"+soc0114vwInfo.getEismallversion()+"' ");
		        	    	   			xmlData.append("alert='false' name='"+vwinfoChild.getEiname()+"' iptext='"+soc0114vwInfo.getHostIP()+"' apptext='"+soc0114vwInfo.getEiname()+"' eitype='"+eitype+"'");
		        	    	   			xmlData.append("x='"+temp_x+"' y='"+temp_y+"' datatips='"+vwinfoChild.getEiname()+"' smalltype1='"+getSmalltype(soc0114vwInfo.getEsyscoding())+"' smalltype2='"+getSmalltype(soc0114vwInfo.getHostEsyscoding())+"' />");
		        	    	   			formeiid = String.valueOf(vwinfoChild.getEiid());
		        	    	   			ibMap.put(vwinfoChild.getEiid(), true);
	        	   					}else{
        		        	   			xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+vwinfoChild.getEiid()+"' />");
	        	    	   				formeiid = String.valueOf(vwinfoChild.getEiid());
	        	    	   			}
	        	   				}else{
	                	   			xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+soc0114vwInfo.getEiid()+"' />");
	                	   			if(ibMap.get(soc0114vwInfo.getEiid())==null){
		                	   			if (topoXYMap != null) {
					            			if(StringUtils.isNotEmpty(  topoXYMap.get(soc0114vwInfo.getEiid().toString()) )){
					            				temp_x=topoXYMap.get(soc0114vwInfo.getEiid().toString()).split("\\,")[0];
					            				temp_y=topoXYMap.get(soc0114vwInfo.getEiid().toString()).split("\\,")[1];
					            			}
					            		}
			        	   			   	xmlData.append("<NODE id='"+soc0114vwInfo.getEiid()+"' eiid2='"+soc0114vwInfo.getHostEiid()+"' eiid3='' ");
		        	    	   			xmlData.append("eirootmark='"+soc0114vwInfo.getHostEiid()+"' eiversion1='"+soc0114vwInfo.getEiversion()+"' eismallversion1='"+soc0114vwInfo.getEismallversion()+"' ");
		        	    	   			xmlData.append("eiversion2='"+soc0114vwInfo.getHostVersion()+"' eismallversion2='"+soc0114vwInfo.getHostSmallVersion()+"' eiversion3='' eismallversion3='' ");
		        	    	   			xmlData.append("alert='false' name='"+soc0114vwInfo.getEiname()+"' iptext='"+soc0114vwInfo.getHostIP()+"' apptext='' eitype='"+eitype+"'");
		        	    	   			xmlData.append("x='"+temp_x+"' y='"+temp_y+"' datatips='"+soc0114vwInfo.getEiname()+"' smalltype1='"+getSmalltype(soc0114vwInfo.getEsyscoding())+"' smalltype2='"+getSmalltype(soc0114vwInfo.getHostEsyscoding())+"' />");
		       
	                	   			}
	                	   			formeiid = String.valueOf(soc0114vwInfo.getEiid());
	        	    	   			ibMap.put(soc0114vwInfo.getEiid(), true);
	        	   				}
	        	   			}else {
	        	   				//通过Esyscoding判断下一级节点与本节点之间谁是父节点。
	        	   				if(vwinfoChild.getEsyscoding().equals(esyscoding.substring(0,esyscoding.length()-3))){
	        	   					if(ibMap.get(soc0114vwInfo.getEiid())==null){
		        	   			   		if(!"".equals(formeiid)){
			        	       				xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+soc0114vwInfo.getEiid()+"' />");
	        	   							iiMap.put(formeiid, soc0114vwInfo.getEiid());
		        	   			   		}
		    		        	   		if (topoXYMap != null) {
		    		            			if(StringUtils.isNotEmpty(  topoXYMap.get(soc0114vwInfo.getEiid().toString()) )){
		    		            				temp_x=topoXYMap.get(soc0114vwInfo.getEiid().toString()).split("\\,")[0];
		    		            				temp_y=topoXYMap.get(soc0114vwInfo.getEiid().toString()).split("\\,")[1];
		    		            			}
		    		            		}
		        	   					xmlData.append("<NODE id='"+soc0114vwInfo.getEiid()+"' eiid2='"+soc0114vwInfo.getHostEiid()+"' eiid3='"+vwinfoChild.getEiid()+"' ");
		        	    	   			xmlData.append("eirootmark='"+soc0114vwInfo.getHostEiid()+"' eiversion1='"+soc0114vwInfo.getEiversion()+"' eismallversion1='"+soc0114vwInfo.getEismallversion()+"' ");
		        	    	   			xmlData.append("eiversion2='"+soc0114vwInfo.getHostVersion()+"' eismallversion2='"+soc0114vwInfo.getHostSmallVersion()+"' eiversion3='"+vwinfoChild.getEiversion()+"' eismallversion3='"+vwinfoChild.getEismallversion()+"' ");
		        	    	   			xmlData.append("alert='false' name='"+soc0114vwInfo.getEiname()+"' iptext='"+soc0114vwInfo.getHostIP()+"' apptext='"+vwinfoChild.getEiname()+"' eitype='"+eitype+"'");
		        	    	   			xmlData.append("x='"+temp_x+"' y='"+temp_y+"' datatips='"+soc0114vwInfo.getEiname()+"' smalltype1='"+getSmalltype(vwinfoChild.getEsyscoding())+"' smalltype2='"+getSmalltype(soc0114vwInfo.getHostEsyscoding())+"' />");
		        	    	   			formeiid = String.valueOf(soc0114vwInfo.getEiid());
		        	    	   			ibMap.put(soc0114vwInfo.getEiid(), true);
	        	   					}else{
        		        	   			xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+soc0114vwInfo.getEiid()+"' />");
	        	    	   				formeiid = String.valueOf(soc0114vwInfo.getEiid());
	        	    	   			}
	        	   				}
	        	   			}
	    	   			}else{//当遇见最后一个单子节点时，直接拼接
	    	   				boolean flag =false;
		    	   			SOC0114VWInfo vwinfoParent = intMap.get(String.valueOf(Integer.parseInt(soc0114vwInfo.getLinkorder())-1));
		    	   			if(soc0114vwInfo.getEsyscoding().length()>vwinfoParent.getEsyscoding().length()){
		    	   				if(!soc0114vwInfo.getEsyscoding().substring(0, soc0114vwInfo.getEsyscoding().length()-3).equals(vwinfoParent.getEsyscoding())){
		    	   					flag = true;
		    	   				}
		    	   			}else if(soc0114vwInfo.getEsyscoding().length()<vwinfoParent.getEsyscoding().length()){
		    	   				if(!vwinfoParent.getEsyscoding().substring(0, vwinfoParent.getEsyscoding().length()-3).equals(soc0114vwInfo.getEsyscoding())){
		    	   					flag = true;
		    	   				}
		    	   			}else{
		    	   				flag = true;
		    	   			}
		    	   			if(flag&&ibMap.get(soc0114vwInfo.getEiid())==null){
		        	   			xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+soc0114vwInfo.getEiid()+"' />");
			        	   		if (topoXYMap != null) {
			            			if(StringUtils.isNotEmpty(  topoXYMap.get(soc0114vwInfo.getEiid().toString()) )){
			            				temp_x=topoXYMap.get(soc0114vwInfo.getEiid().toString()).split("\\,")[0];
			            				temp_y=topoXYMap.get(soc0114vwInfo.getEiid().toString()).split("\\,")[1];
			            			}
			            		}
	        	   			   	xmlData.append("<NODE id='"+soc0114vwInfo.getEiid()+"' eiid2='"+soc0114vwInfo.getHostEiid()+"' eiid3='' ");
        	    	   			xmlData.append("eirootmark='"+soc0114vwInfo.getHostEiid()+"' eiversion1='"+soc0114vwInfo.getEiversion()+"' eismallversion1='"+soc0114vwInfo.getEismallversion()+"' ");
        	    	   			xmlData.append("eiversion2='"+soc0114vwInfo.getHostVersion()+"' eismallversion2='"+soc0114vwInfo.getHostSmallVersion()+"' eiversion3='' eismallversion3='' ");
        	    	   			xmlData.append("alert='false' name='"+soc0114vwInfo.getEiname()+"' iptext='"+soc0114vwInfo.getHostIP()+"' apptext='' eitype='"+eitype+"'");
        	    	   			xmlData.append("x='"+temp_x+"' y='"+temp_y+"' datatips='"+soc0114vwInfo.getEiname()+"' smalltype1='"+getSmalltype(soc0114vwInfo.getEsyscoding())+"' smalltype2='"+getSmalltype(soc0114vwInfo.getHostEsyscoding())+"' />");
        	    	   			formeiid = String.valueOf(soc0114vwInfo.getEiid());
        	    	   			ibMap.put(soc0114vwInfo.getEiid(), true);
		    	   			}else if(flag&&ibMap.get(soc0114vwInfo.getEiid())!=null){
		        	   			xmlData.append("<LINE id='"+Math.random()+"' fromNode='"+formeiid+"' toNode='"+soc0114vwInfo.getEiid()+"' />");
		    	   			}
	    	   			}
	    	   		}
			}
		}
		UserRegionSearchCondImpl cond_ur = new UserRegionSearchCondImpl();
		cond_ur.setFLEXID(FLEXID);
		cond_ur.setUSERID(cond.getEiid().toString());
		List<UserRegionInfo> list_ur = userRegionDAO.findByCond(cond_ur, 0, 0);
		for (UserRegionInfo urInfo : list_ur) {
			xmlData.append("<REGION id='"+urInfo.getID()+"' x='"+urInfo.getX()+"' y='"+urInfo.getY()+"' width='"+urInfo.getWidth()+"' height='"+urInfo.getHeight()+"' title='"+urInfo.getTitle()+"' />");
		}
		xmlData.append("</root>");
		return xmlData.toString().replace("iptext='null'", "iptext=''");
	}
/*	public String searchSOC0114VW_FXAPPByCond(SOC0114VW_FXSearchCond cond){
		String xmlData = "";
		String legendData = "";
		Integer colorArrIndex =0;
		String colorArrIndex1 ="";
    	String temp_x="";
    	String temp_y="";
    	List<String>  nodeEiidList=new ArrayList<String>();
    	TOPOXMLSearchCondImpl tcond=new TOPOXMLSearchCondImpl();
    	tcond.setIsellipsis("c");
    	List<TOPOXMLInfo> list_axis=topoxmldao.findByCond(tcond, 0, 0);
		List<SOC0114VWInfo> list_0114_FX=soc0114VW_FXDAO.findByCond(cond);
		Map<String, String> colorMap=new HashMap<String, String>();
		if(list_0114_FX.size()>0){
			xmlData="<?xml version='1.0' encoding='utf-8'?><root>";
			legendData = "<?xml version='1.0' encoding='utf-8'?><root>";
//			SOC0107SearchCondImpl cond0107 = new SOC0107SearchCondImpl();
			String name="";
			String smalltype="";
			for (int i=0;i<list_0114_FX.size();i++) {
//    			String datatips ="";
    			if(colorMap!=null&&colorMap.size()>0){
    				if(StringUtils.isNotEmpty(list_0114_FX.get(i).getHostIP())){
	    				if(colorMap.get(list_0114_FX.get(i).getHostIP())!=null){
	    					colorArrIndex1=colorMap.get(list_0114_FX.get(i).getHostIP()).split("_")[3];
	    				}else{
	    					colorArrIndex++;
	    					colorMap.put(list_0114_FX.get(i).getHostIP(), list_0114_FX.get(i).getHostEiid()+"_"+list_0114_FX.get(i).getHostVersion()+"_"+list_0114_FX.get(i).getHostSmallVersion()+"_"+colorArrIndex);
	    				}
    				}
    			}else{
    				if(StringUtils.isNotEmpty(list_0114_FX.get(i).getHostIP())){
    					colorMap.put(list_0114_FX.get(i).getHostIP(), list_0114_FX.get(i).getHostEiid()+"_"+list_0114_FX.get(i).getHostVersion()+"_"+list_0114_FX.get(i).getHostSmallVersion()+"_"+colorArrIndex);
    				}
    			}
    	   		for (TOPOXMLInfo xmlinfo : list_axis) {
        			if(xmlinfo.getMyid().equals(list_0114_FX.get(i).getEiid().toString())){
        				temp_x=xmlinfo.getAixs().split("\\,")[0];
        				temp_y=xmlinfo.getAixs().split("\\,")[1];
        				break;
        			}
        		}
//    	   		cond0107.setEiid(list_0114_FX.get(i).getEiid().toString());
//    	   		cond0107.setCiversion(list_0114_FX.get(i).getEiversion().toString());
//    	   		cond0107.setCismallversion(list_0114_FX.get(i).getEismallversion().toString());
//    	   		List<SOC0107Info> info0107_list=soc0107DAO.findByCond(cond0107, 0, 0);//datatips
//    	   		for (SOC0107Info soc0107Info : info0107_list) {
//					datatips+=soc0107Info.getConfiguration().getCname()+": "+soc0107Info.getCivalue()+"\\n ";
//				}
    	   		if(list_0114_FX.get(i).getEiname().length()>14){
    	   			name=list_0114_FX.get(i).getEiname().substring(0, 13)+"...";
    	   		}else{
    	   			name=list_0114_FX.get(i).getEiname();
    	   		}
    	   		smalltype =getSmalltype(list_0114_FX.get(i).getEsyscoding());
    	   		if(nodeEiidList!=null&&nodeEiidList.size()>0){
    	   			if(!nodeEiidList.contains(list_0114_FX.get(i).getEiid().toString())){
    	   				if("999003001".equals(list_0114_FX.get(i).getEsyscoding())){
		   					xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
	    	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
	        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
	    	   				"alert='false' name='"+name+"' " +
							"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='-1' smalltype='"+smalltype+"' />";
    	   				}else{
    	   					xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
        	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
            	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
        	   				"alert='false' name='"+name+"' " +
    						"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"'"; 
    	   					if(StringUtils.isNotEmpty(colorArrIndex1)){
    	   						xmlData+=" parentnode='"+colorArrIndex1+"' smalltype='"+smalltype+"' />";
    	   					}else{
    	   						xmlData+=" parentnode='"+colorArrIndex+"' smalltype='"+smalltype+"' />";
    	   					}
    	   				}
    	   			}
    	   		}else{
    	   			if("999003001".equals(list_0114_FX.get(i).getEsyscoding())){
		   				xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
	    	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
	    	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
						"alert='false' name='"+name+"' " +
						"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='-1' smalltype='"+smalltype+"' />";
    	   			}else{
    	   				xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
        	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
    					"alert='false' name='"+name+"' " +
    					"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"'"; 
	   					if(StringUtils.isNotEmpty(colorArrIndex1)){
	   						xmlData+=" parentnode='"+colorArrIndex1+"' smalltype='"+smalltype+"' />";
	   					}else{
	   						xmlData+=" parentnode='"+colorArrIndex+"' smalltype='"+smalltype+"' />";
	   					}
    	   			}
    	   		}
    	   		nodeEiidList.add(list_0114_FX.get(i).getEiid().toString());
				if(i< list_0114_FX.size()-1){
					if(list_0114_FX.get(i).getLinkid().intValue() == list_0114_FX.get(i+1).getLinkid().intValue()){
						xmlData+="<LINE id='"+Math.random()+"' " +
								"fromNode='"+list_0114_FX.get(i).getEiid().toString()+"' " +
								"toNode='"+list_0114_FX.get(i+1).getEiid().toString()+"' />";
					}
				}
				colorArrIndex1="";
			}
			if(colorMap!=null&&colorMap.size()>0){
				Set<Map.Entry<String,String>> set= colorMap.entrySet();
				for(Iterator<Map.Entry<String,String>> iter = set.iterator();iter.hasNext();){
					Map.Entry<String,String> entry = iter.next();
					String value=entry.getValue();
					String eiid=value.split("_")[0];
					String version=value.split("_")[1];
					String smallversion=value.split("_")[2];
					String color=value.split("_")[3];
					legendData+= "<LEGEND_NODE id='"+eiid+"' parentnode='"+color+"' textvalue=\'"+entry.getKey()+"' eirootmark='"+eiid+"' version='"+version+"' smallversion='"+smallversion+"' />" ;
				}
			}
			xmlData+="</root>";
			legendData+="</root>";
		}
		return xmlData+"@"+legendData;
	}*/
	
	/**
	 * 获取Smalltype
	 * @param esyscoding
	 * @return
	 */
	public String getSmalltype(String esyscoding){
		String smalltype="";
		if(EntityItemKeyWords.AIX_ESYSCODING.equals(esyscoding)){
   			smalltype="0";
   		}else if(EntityItemKeyWords.APACHE_ESYSCODING.equals(esyscoding)){
   			smalltype="1";
   		}else if(EntityItemKeyWords.DB2_ESYSCODING.equals(esyscoding)){
   			smalltype="2";
   		}else if(EntityItemKeyWords.HPUX_ESYSCODING.equals(esyscoding)){
   			smalltype="3";
   		}else if(EntityItemKeyWords.INFORMIX_ESYSCODING.equals(esyscoding)){
   			smalltype="4";
   		}else if(EntityItemKeyWords.JBOSSSERVER_ESYSCODING.equals(esyscoding)){
   			smalltype="5";
   		}else if(EntityItemKeyWords.LINUX_ESYSCODING.equals(esyscoding)){
   			smalltype="6";
   		}else if(EntityItemKeyWords.ORACLE_ESYSCODING.equals(esyscoding)){
   			smalltype="8";
   		}else if(EntityItemKeyWords.SCOUNIX_ESYSCODING.equals(esyscoding)){
   			smalltype="10";
   		}else if(EntityItemKeyWords.SOLARIS_ESYSCODING.equals(esyscoding)){
   			smalltype="11";
   		}else if(EntityItemKeyWords.SQLSERVER_ESYSCODING.equals(esyscoding)){
   			smalltype="12";
   		}else if(EntityItemKeyWords.SYBASE_ESYSCODING.equals(esyscoding)){
   			smalltype="13";
   		}else if(EntityItemKeyWords.TOMCAT_ESYSCODING.equals(esyscoding)){
   			smalltype="14";
   		}else if(EntityItemKeyWords.TUXEDO_ESYSCODING.equals(esyscoding)){
   			smalltype="15";
   		}else if(EntityItemKeyWords.WEBLOGIC_ESYSCODING.equals(esyscoding)){
   			smalltype="16";
   		}else if(EntityItemKeyWords.WEBSPHERE_ESYSCODING.equals(esyscoding)){
   			smalltype="17";
   		}else if(EntityItemKeyWords.WINDOWS_ESYSCODING.equals(esyscoding)){
   			smalltype="18";
   		}else if(EntityItemKeyWords.BUSS_ESYSCODING.equals(esyscoding)){
   			smalltype="99";
   		}else if(EntityItemKeyWords.APP_ESYSCODING.equals(esyscoding)){
   			smalltype="100";
   		}
		return smalltype;
		
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public String searchSOC0114VW_BJByCond(SOC0114VW_FXSearchCond cond) {
		String xmlData = "";
		String legendData = "";
		Integer colorArrIndex =0;
		String colorArrIndex1 ="";
    	String temp_x="";
    	String temp_y="";
    	List<String>  nodeEiidList=new ArrayList<String>();
    	TOPOXMLSearchCondImpl tcond=new TOPOXMLSearchCondImpl();
    	tcond.setIsellipsis("c");
    	List<TOPOXMLInfo> list_axis=topoxmldao.findByCond(tcond, 0, 0);
		List<SOC0114VWInfo> list_0114_FX=soc0114VW_FXDAO.findByCondForBJ(cond);
		Map<String, String> colorMap=new HashMap<String, String>();
		if(list_0114_FX.size()>0){
			xmlData="<?xml version='1.0' encoding='utf-8'?><root>";
			legendData = "<?xml version='1.0' encoding='utf-8'?><root>";
			SOC0107SearchCondImpl cond0107 = new SOC0107SearchCondImpl();
			String name="";
			String smalltype="";
			List<Integer> resourceid=new ArrayList<Integer>();
	    	if(list_0114_FX!=null&&list_0114_FX.size()>0){
	    		for(SOC0114VWInfo  soc0114vwinfo:list_0114_FX){
	    			if(StringUtils.isNotEmpty(soc0114vwinfo.getResourceid())){
	    				if(!resourceid.contains(soc0114vwinfo.getResourceid())){
		    				resourceid.add(Integer.parseInt(soc0114vwinfo.getResourceid()));
		    			}
	    			}
	    		}
	    	}
			for (int i=0;i<list_0114_FX.size();i++) {
				String resid="";
//    			String datatips ="";
    			if(colorMap!=null&&colorMap.size()>0){
    				if(StringUtils.isNotEmpty(list_0114_FX.get(i).getHostIP())){
    					if(StringUtils.isNotEmpty(list_0114_FX.get(i).getHostIP())){
    						if(colorMap.get(list_0114_FX.get(i).getHostIP())!=null){
    							colorArrIndex1=colorMap.get(list_0114_FX.get(i).getHostIP()).split("_")[3];
    	    				}else{
    	    					colorArrIndex++;
    	    					colorMap.put(list_0114_FX.get(i).getHostIP(), list_0114_FX.get(i).getHostEiid()+"_"+list_0114_FX.get(i).getHostVersion()+"_"+list_0114_FX.get(i).getHostSmallVersion()+"_"+colorArrIndex);
    	    				}
    					}
    				}
    			}else{
    				if(StringUtils.isNotEmpty(list_0114_FX.get(i).getHostIP())){
    					colorMap.put(list_0114_FX.get(i).getHostIP(), list_0114_FX.get(i).getHostEiid()+"_"+list_0114_FX.get(i).getHostVersion()+"_"+list_0114_FX.get(i).getHostSmallVersion()+"_"+colorArrIndex);
    				}
    			}
    	   		for (TOPOXMLInfo xmlinfo : list_axis) {
        			if(xmlinfo.getMyid().equals(list_0114_FX.get(i).getEiid().toString())){
        				temp_x=xmlinfo.getAixs().split("\\,")[0];
        				temp_y=xmlinfo.getAixs().split("\\,")[1];
        				break;
        			}
        		}
//    	   		cond0107.setEiid(list_0114_FX.get(i).getEiid().toString());
//    	   		cond0107.setCiversion(list_0114_FX.get(i).getEiversion().toString());
//    	   		cond0107.setCismallversion(list_0114_FX.get(i).getEismallversion().toString());
//    	   		List<SOC0107Info> info0107_list=soc0107DAO.findByCond(cond0107, 0, 0);//datatips
//    	   		for (SOC0107Info soc0107Info : info0107_list) {
//					datatips+=soc0107Info.getConfiguration().getCname()+": "+soc0107Info.getCivalue()+"\\n ";
//				}
    	   		if(list_0114_FX.get(i).getEiname().length()>14){
    	   			name=list_0114_FX.get(i).getEiname().substring(0, 13)+"...";
    	   		}else{
    	   			name=list_0114_FX.get(i).getEiname();
    	   		}
    	   		smalltype =getSmalltype(list_0114_FX.get(i).getEsyscoding());
    	   		if(StringUtils.isNotEmpty(list_0114_FX.get(i).getResourceid())&&!"null".equals(list_0114_FX.get(i).getResourceid())){
    	   			resid=list_0114_FX.get(i).getResourceid();
    	   		}
    	   		if(nodeEiidList!=null&&nodeEiidList.size()>0){
    	   			if(!nodeEiidList.contains(list_0114_FX.get(i).getEiid().toString())){
    	   				if(StringUtils.isNotEmpty(list_0114_FX.get(i).getResourceid())){
    	   					if(!resourceid.contains(list_0114_FX.get(i).getResourceid())){
    	   						if("999003001".equals(list_0114_FX.get(i).getEsyscoding())){
	    	    	   				xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
	    	    	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
	    	        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
	    	        	   			"resid='"+resid+"' " +
	    	        	   			"alert='false' name='"+name+"' " +
	    	        	   			"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='-1' smalltype='"+smalltype+"' />";
    	   						}else{
    	   							xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
        	    	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
        	        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
        	        	   			"resid='"+resid+"' " +
        	        	   			"alert='false' name='"+name+"' " +
        	        	   			"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"'";
    	   							if(StringUtils.isNotEmpty(colorArrIndex1)){
    	   								xmlData+=" parentnode='"+colorArrIndex1+"' smalltype='"+smalltype+"' />";
    	   							}else{
    	   								xmlData+=" parentnode='"+colorArrIndex+"' smalltype='"+smalltype+"' />";
    	   							}
    	   							
    	   						}
    	   					}else{
    	   						if("999003001".equals(list_0114_FX.get(i).getEsyscoding())){
	    	    	   				xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
	    	    	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
	    	        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
	    	        	   			"resid='"+resid+"' " +
	    	        	   			"alert='true' name='"+name+"' " +
	    	        	   			"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='-1' smalltype='"+smalltype+"' />";
    	   						}else{
    	   							xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
	    	    	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
	    	        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
	    	        	   			"resid='"+resid+"' " +
	    	        	   			"alert='true' name='"+name+"' " +
	    	        	   			"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"'";
    	   							if(StringUtils.isNotEmpty(colorArrIndex1)){
    	   								xmlData+=" parentnode='"+colorArrIndex1+"' smalltype='"+smalltype+"' />";
    	   							}else{
    	   								xmlData+=" parentnode='"+colorArrIndex+"' smalltype='"+smalltype+"' />";
    	   							}
    	   						}
            	   			}
    	   				}else{
    	   					if("999003001".equals(list_0114_FX.get(i).getEsyscoding())){
	    	   					xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
		    	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
		        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
		        	   			"resid='"+resid+"' " +
		        	   			"alert='false' name='"+name+"' " +
		        	   			"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='-1' smalltype='"+smalltype+"' />";
    	   					}else{
    	   						xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
		    	   				"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
		        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
		        	   			"resid='"+resid+"' " +
		        	   			"alert='false' name='"+name+"' " +
		        	   			"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"'";
	   							if(StringUtils.isNotEmpty(colorArrIndex1)){
	   								xmlData+=" parentnode='"+colorArrIndex1+"' smalltype='"+smalltype+"' />";
	   							}else{
	   								xmlData+=" parentnode='"+colorArrIndex+"' smalltype='"+smalltype+"' />";
	   							}
    	   					}
    	   				}
    	   			}
    	   		}else{
    	   			if(StringUtils.isNotEmpty(list_0114_FX.get(i).getResourceid())){
	    	   			if(StringUtils.isNotEmpty(list_0114_FX.get(i).getResourceid())&&!resourceid.contains(list_0114_FX.get(i).getResourceid())){
	    	   				if("999003001".equals(list_0114_FX.get(i).getEsyscoding())){
		    	   				xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
			    	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
			    	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
			    	   			"resid='"+resid+"' " +
								"alert='false' name='"+name+"' " +
								"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='-1' smalltype='"+smalltype+"' />";
	    	   				}else{
	    	   					xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
			    	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
			    	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
			    	   			"resid='"+resid+"' " +
								"alert='false' name='"+name+"' " +
								"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"'";
	   							if(StringUtils.isNotEmpty(colorArrIndex1)){
	   								xmlData+=" parentnode='"+colorArrIndex1+"' smalltype='"+smalltype+"' />";
	   							}else{
	   								xmlData+=" parentnode='"+colorArrIndex+"' smalltype='"+smalltype+"' />";
	   							}
	    	   				}
	    	   			}else{
	    	   				if("999003001".equals(list_0114_FX.get(i).getEsyscoding())){
	    	   					xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
		        	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
		        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
		        	   			"resid='"+resid+"' " +
		    					"alert='true' name='"+name+"' " +
		    					"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='-1' smalltype='"+smalltype+"' />";
	    	   				}else{
	    	   					xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
		        	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
		        	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
		        	   			"resid='"+resid+"' " +
		    					"alert='true' name='"+name+"' " +
		    					"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"'";
	   							if(StringUtils.isNotEmpty(colorArrIndex1)){
	   								xmlData+=" parentnode='"+colorArrIndex1+"' smalltype='"+smalltype+"' />";
	   							}else{
	   								xmlData+=" parentnode='"+colorArrIndex+"' smalltype='"+smalltype+"' />";
	   							}
	    	   				}
	    	   				
	    	   			}
    	   			}else{
    	   				if("999003001".equals(list_0114_FX.get(i).getEsyscoding())){
	    	   				xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
		    	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
		    	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
		    	   			"resid='"+resid+"' " +
							"alert='false' name='"+name+"' " +
							"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"' parentnode='-1' smalltype='"+smalltype+"' />";
    	   				}else{
    	   					xmlData+="<NODE id='"+list_0114_FX.get(i).getEiid()+"' " +
		    	   			"eirootmark='"+list_0114_FX.get(i).getHostEiid()+"' version='"+list_0114_FX.get(i).getEiversion()+"' " +
		    	   			"smallversion='"+list_0114_FX.get(i).getEismallversion()+"' " +
		    	   			"resid='"+resid+"' " +
							"alert='false' name='"+name+"' " +
							"x='"+temp_x+"' y='"+temp_y+"' datatips='"+list_0114_FX.get(i).getEiname()+"'";
   							if(StringUtils.isNotEmpty(colorArrIndex1)){
   								xmlData+=" parentnode='"+colorArrIndex1+"' smalltype='"+smalltype+"' />";
   							}else{
   								xmlData+=" parentnode='"+colorArrIndex+"' smalltype='"+smalltype+"' />";
   							}
    	   				}
    	   			}
    	   		}
    	   		nodeEiidList.add(list_0114_FX.get(i).getEiid().toString());
				if(i< list_0114_FX.size()-1){
					if(list_0114_FX.get(i).getLinkid().intValue() == list_0114_FX.get(i+1).getLinkid().intValue()){
						xmlData+="<LINE id='"+Math.random()+"' " +
								"fromNode='"+list_0114_FX.get(i).getEiid().toString()+"' " +
								"toNode='"+list_0114_FX.get(i+1).getEiid().toString()+"' />";
					}
				}
				colorArrIndex1="";
			}
			if(colorMap!=null&&colorMap.size()>0){
				Set<Map.Entry<String,String>> set= colorMap.entrySet();
				for(Iterator<Map.Entry<String,String>> iter = set.iterator();iter.hasNext();){
					Map.Entry<String,String> entry = iter.next();
					String value=entry.getValue();
					String eiid=value.split("_")[0];
					String version=value.split("_")[1];
					String smallversion=value.split("_")[2];
					String color=value.split("_")[3];
					cond0107.setEiid(eiid);
					cond0107.setCiversion(version);
					cond0107.setCismallversion(smallversion);
					cond0107.setCid("CI010100010025");
					List<SOC0107Info> info0107_list=soc0107DAO.findByCond(cond0107, 0, 0);//resourceid
					if(info0107_list!=null&&info0107_list.size()>0){
						legendData+= "<LEGEND_NODE id='"+eiid+"' parentnode='"+color+"' textvalue=\'"+entry.getKey()+"' eirootmark='"+eiid+"' version='"+version+"' smallversion='"+smallversion+"' resid='"+info0107_list.get(0).getCivalue()+"'/>" ;
					}else{
						legendData+= "<LEGEND_NODE id='"+eiid+"' parentnode='"+color+"' textvalue=\'"+entry.getKey()+"' eirootmark='"+eiid+"' version='"+version+"' smallversion='"+smallversion+"' resid=''/>" ;
					}
				}
			}
			xmlData+="</root>";
			legendData+="</root>";
		}
		return xmlData+"@"+legendData;
	}

	public List<SOC0114VWInfo> findByCondForBJ(
			SOC0114VW_FXSearchCondImpl soc0114Cond) {
		return soc0114VW_FXDAO.findByCondForBJ(soc0114Cond);
	}

}
