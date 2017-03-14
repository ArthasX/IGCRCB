/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.drm.util.FlowDetail;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资产表单信息生成对应标签实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 * (1)增加相应获取实体判断以防止NullPointerException
 */
@SuppressWarnings("serial")
public class AssetFormGeneratedTagImpl extends FormGeneratedTagImpl{
	/**
	 * 公有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTag(Map<String, Object> params){
		
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		//相关表单信息取得 
		List<IG599Info> processInfoList = (List<IG599Info>) params.get(PARAMS_PROCESSINFO_LIST);
		//相关资产信息取得
		List<IG731Info> processInfoEntityList = (List<IG731Info>) params.get(PARAMS_PROCESSINFO_ENTITY_LIST);
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单名称取得
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		//表单名称取得
		String property = (String) params.get(PARAMS_PROPERTY);
		//是否必填
		String pidrequired = (String) params.get(PARAMS_PIDREQUIRED);
		//资产模式取得
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//模型定义取得
		String ccid = (String) params.get(PARAMS_CCID);
		String syscoding = "";
		if(StringUtils.isNotEmpty(ccid)){
			syscoding = ccid.split("_entity_")[0];
		}
		String value = "";
		String eiidary = "";
		//下标值取得
		Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
		boolean flag = true;
		if(processInfoList!=null){
			for(IG599Info pi:processInfoList){
				if(pidlabel.equals(pi.getPivarlabel())&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(pi.getPivartype())){
					if(processInfoEntityList!=null){
						//用于判断是否必填
						if(processInfoEntityList.size() > 0) {
							value = "N/A";
						}
						for(IG731Info entity:processInfoEntityList){
							if(pi.getPiid().equals(entity.getPiid())){
								//判断EntityItemTB和EntityItemVWTB是否为空//根本原因是因为IG731相关联的是IG013和IG688
								flag = false;
								String einame = "";
								if("1".equals(entity.getFingerPrint())){
									SOC0118VWPK pk = new SOC0118VWPK();
									pk.setId(Integer.parseInt(entity.getFingerPrint()));
									pk.setEiid(entity.getEiid());
									try {
										SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
										SOC0118VWInfo soc0118vwInfo = soc0118VWBL.searchEntityItemByKey(pk);
										einame = soc0118vwInfo.getEiname();
										eiidary += ","+soc0118vwInfo.getEiid();
									} catch (BLException e) {
										e.printStackTrace();
									}
									
								}else{
									if(entity.getEntityItemTB() != null){
										einame = entity.getEntityItemTB().getEiname();
										eiidary += ","+entity.getEntityItemTB().getEiid();
									}else if(entity.getEntityItemVWTB() != null){
										einame = entity.getEntityItemVWTB().getEiname();
										eiidary += ","+entity.getEntityItemVWTB().getEiid();
									}
								}
								tagString.append("<a href=\"javascript:void(0)\" asm=\"")
										 .append(pidid);
										 if("1".equals(entity.getFingerPrint())){
											 tagString.append("\" onclick=\"openSubIGCOM0303ForER('")
											 .append(entity.getFingerPrint())
											 .append("','")
											 .append(entity.getEiid())
											 .append("');\" id=\"");
										 }else{
											 tagString.append("\" onclick=\"openSubIGCOM0303('")
											 .append(entity.getEiid())
											 .append("','")
											 .append(entity.getEiversion())
											 .append("');\" id=\"");
										 }
										 tagString.append(entity.getPieid())
										 .append("\"")
										 .append(" eiid=\"")
										 .append(eiidary)
										 .append("\" >")
										 .append(einame)
//										 .append("(")
//										 .append(entity.getEiversion())
//										 .append(")")
										 .append("</a><img id=\"")
										 .append(entity.getPieid())
										 .append("ENT\" src=\"images/delate.gif\" align=\"middle\" ");
								 if(pidrows != null && pidrows > 1){
									 tagString.append(" onClick=\"delEntity('").append(entity.getPieid()).append("','").append(pidid).append("','").append(property).append("');\"");
								 }else{
									 tagString.append(" onClick=\"delSingleEntity('")
									 		  .append(entity.getPieid())
									 		  .append("','").append(pidid)
									 		  .append("','").append(property)
									 		  .append("','")
									 		  .append(pidid)
									 		  .append("','")
									 		  .append(syscoding)
									 		  .append("',")
									 		  .append(index)
									 		  .append(",");
									 if("1".equals(pidrequired)){
										 tagString.append("'1'");
									 }else{
										 tagString.append("'0'");
									 }
									 tagString.append(");\"");
								 }
								tagString.append(" border=\"0\" style=\"cursor: hand\" alt='删除'/>&nbsp;");
							}
						}
					}
				}
			}
			if(!flag){
				tagString.append("<br />");
			}
		}
		if(flag){
			String defaultValue = (String) params.get(PARAMS_VALUE);
			if(StringUtils.isNotBlank(defaultValue)){
				IG013BL ig013BL = (IG013BL) WebApplicationSupport.getBean("ig013BL");
				IG688SearchCondImpl cond = new IG688SearchCondImpl();
				List<String> eiids = new ArrayList<String>();
				for(String s:defaultValue.split("#")){
					eiids.add(s);
				}
				if(eiids.size() > 0){
					cond.setEiidList(eiids);
					List<IG688Info> list = ig013BL.searchIG688Info(cond);
					for(IG688Info info:list){
						flag = false;
						tagString.append("<a href=\"javascript:void(0)\" asm=\"")
						 .append(pidid)
						 .append("\" onclick=\"openSubIGCOM0303('")
						 .append(info.getEiid())
						 .append("','")
						 .append(info.getEiversion())
						 .append("")
						 .append("');\" id=\"")
						 .append(info.getEiid())
						 .append("EIID\">")
						 .append(info.getEiname())
						 .append("(")
						 .append(info.getEiversion())
						 .append(")")
						 .append("</a><img id=\"")
						 .append(info.getEiid())
						 .append("EIIDENT\" src=\"images/delate.gif\" align=\"middle\" ");
						if(pidrows != null && pidrows > 1){
							 tagString.append(" onClick=\"delEntity('").append(info.getEiid()).append("EIID','").append(pidid).append("','").append(property).append("');\"");
						 }else{
							 tagString.append(" onClick=\"delSingleEntity('")
							 		  .append(info.getEiid())
							 		  .append("EIID','").append(pidid)
							 		  .append("','").append(property)
							 		  .append("','")
							 		  .append(pidid)
							 		  .append("','")
							 		  .append(syscoding)
							 		  .append("',")
							 		  .append(index)
							 		  .append(",");
							 if("1".equals(pidrequired)){
								 tagString.append("'1'");
							 }else{
								 tagString.append("'0'");
							 }
							 tagString.append(");\"");
						 }
						tagString.append(" border=\"0\" style=\"cursor: hand\" alt='删除'/>&nbsp;");
					}
					if(!flag){
						tagString.append("<br />");
					}
				}
			}
		}
		if(pidrows != null && pidrows > 1){
			tagString.append("<img src=\"images/addasm.gif\" alt='查询' style=\"cursor: hand;\"/>");
			tagString.append("<a href=\"javascript:addEntity('")
			.append(pidid)
			.append("','")
			.append(syscoding)
			.append("',")
			.append(index)
			.append(",");
			if("1".equals(pidrequired)){
				tagString.append("'1'");
			}else{
				tagString.append("'0'");
			}
			tagString.append(",'").append(property);
			tagString.append("');\" id=\"aAddEntity\">添加资产</a> ");
		}else if(flag){
			String addStr = pidid + "_" + syscoding + "_" + index + "_" + ("1".equals(pidrequired) ? "1" : "0") + "_" + property;
			tagString.append("<script>assetFormArr[assetFormArr.length]='").append(addStr).append("';</script>");
		}
		tagString.append("<table id=\"tbentity")
				 .append(pidid)
				 .append("\" class=\"tableColumnEntity\"></table>");
		tagString.append("<input type=\"hidden\" id=\"pidid").append(pidid).append("\" name=\"").append(property).append("\" value=\"").append(value).append("\"/>");
		return tagString.toString();
	}
	
	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicReadableTag(Map<String, Object> params){
		
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		//相关表单信息取得 
		List<IG599Info> processInfoList = (List<IG599Info>) params.get(PARAMS_PROCESSINFO_LIST);
		//相关资产信息取得
		List<IG731Info> processInfoEntityList = (List<IG731Info>) params.get(PARAMS_PROCESSINFO_ENTITY_LIST);
		//表单名称取得
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		if(processInfoList!=null){
			for(IG599Info pi:processInfoList){
				if(pidlabel.equals(pi.getPivarlabel())&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(pi.getPivartype())){
					if(processInfoEntityList!=null){
						for(IG731Info entity:processInfoEntityList){
							String einame = "";
							  //业务系统
							if("1".equals(entity.getFingerPrint())){
								SOC0118VWPK pk = new SOC0118VWPK();
								pk.setId(Integer.parseInt(entity.getFingerPrint()));
								pk.setEiid(entity.getEiid());
								try {
									SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
									SOC0118VWInfo soc0118vwInfo = soc0118VWBL.searchEntityItemByKey(pk);
									einame = soc0118vwInfo.getEiname();
								} catch (BLException e) {
									e.printStackTrace();
								}
							}else{
								if(entity.getEntityItemVWTB()!=null){
									einame = entity.getEntityItemVWTB().getEiname();
								}
							}
							if(pi.getPiid().equals(entity.getPiid())){
								if("1".equals(entity.getFingerPrint())){
									tagString.append("<a href=\"javascript:void(0)\" onclick=\"openSubIGCOM0303ForER('")
											.append(entity.getFingerPrint())
			                                .append("','")
			                                .append(entity.getEiid())
			                                .append("');\" id=\"");
								}else{
									tagString.append("<a href=\"javascript:void(0)\" onclick=\"openSubIGCOM0303('")
										.append(entity.getEiid())
				                        .append("','")
				                        .append(entity.getEiversion())
				                        .append("');\" id=\"");
								}
									tagString.append(entity.getPieid())
										 .append("\">")
										 .append(einame)
//										 .append("(")
//										 .append(entity.getEiversion())
//										 .append(")")
										 .append("</a>")
										 .append("<br />");
										 ;
							}
						}
					}
				}
			}
		}
		String value = (String) params.get(PARAMS_VALUE);
		if(StringUtils.isNotEmpty(value) && !"N/A".equals(value)){

			IG013BL ig013BL = (IG013BL) WebApplicationSupport.getBean("ig013BL");
			IG688SearchCondImpl cond = new IG688SearchCondImpl();
			List<String> eiids = new ArrayList<String>();
			for(String s:value.split("#")){
				eiids.add(s);
			}
			if(eiids.size() > 0){
				cond.setEiidList(eiids);
				if(eiids.get(0).indexOf("_")>0){
					SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
					for(String eiid : eiids){
						try {
							SOC0118VWInfo info = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt(eiid.split("_")[0]),Integer.parseInt(eiid.split("_")[1])));
							tagString.append("<a href=\"javascript:void(0)\" asm=\"")
							.append("\" onclick=\"openSubIGCOM0303ForER('")
							.append(eiid.split("_")[0])
							.append("','")
							.append(eiid.split("_")[1])
							.append("")
							.append("');\" id=\"")
							.append(eiid)
							.append("EIID\">")
							.append(info.getEiname())
//							.append("(")
//							.append(info.getEiversion())
//							.append(")")
							.append("</a>")
							.append("<br />");
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (BLException e) {
							e.printStackTrace();
						}
					}
				}else{
					List<IG688Info> list = ig013BL.searchIG688Info(cond);
					for(IG688Info info:list){
						tagString.append("<a href=\"javascript:void(0)\" asm=\"")
						.append("\" onclick=\"openSubIGCOM0303('")
						.append(info.getEiid())
						.append("','")
						.append(info.getEiversion())
						.append("")
						.append("');\" id=\"")
						.append(info.getEiid())
						.append("EIID\">")
						.append(info.getEiname())
//						.append("(")
//						.append(info.getEiversion())
//						.append(")")
						.append("</a>")
						.append("<br />");
					}
				}
			}
		}
		return tagString.toString();
	}
	
	/**
	 * 表格类表单可写列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		//标签生成信息
		StringBuffer tagString = new StringBuffer();
		//资产模式取得
		Integer pidrows = (Integer) params.get(PARAMS_PIDROWS);
		//表单定义主键取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//表格类表单关联资产信息取得
		Map<String, IG731Info> pieMap = (Map<String, IG731Info>) params.get(PARAMS_TABLE_FORM_ENTITY_INFO);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//ccid取得
		String ccid = (String) params.get(PARAMS_CCID);
		String syscoding = "";
		if(StringUtils.isNotEmpty(ccid)){
			syscoding = ccid.split("_entity_")[0];
		}
		boolean flag = true;
		
		if(pieMap != null && StringUtils.isNotEmpty(value)){
			if(value.split("_entityValue_") != null && value.split("_entityValue_").length > 0){
				String str0 = value.split("_entityValue_")[0];
				if(StringUtils.isNotEmpty(str0)){
					String[] split = str0.split(",");
					if(split != null && split.length > 0){
						for(String pieid:split){
							IG731Info pieInfo = pieMap.get(pieid);
							if(pieInfo != null){
								flag = false;
								tagString.append("<a href=\"javascript:void(0)\" asm=\"")
								.append(pidid)
								.append("\" onclick=\"openSubIGCOM0303('")
								.append(pieInfo.getEiid())
								.append("','")
								.append(pieInfo.getEiversion())
								.append("');\" id=\"")
								.append(pieInfo.getPieid())
								.append("\">")
								.append(pieInfo.getEntityItemTB().getEiname())
//								.append("(")
//								.append(pieInfo.getEiversion())
//								.append(")")
								.append("</a>")
								.append("<img style=\"cursor: hand;\" src=\"images/delate.gif\" align=\"middle\" ");
								if(pidrows != null && pidrows > 1){
									tagString.append("onclick=\"delTableColumnEntity(this,'").append(pieInfo.getPieid()).append("');\" ");
								}else{
									tagString.append("onclick=\"delSingleTableColumnEntity(this,'").append(pieInfo.getPieid()).append("','").append(pidid).append("','").append(syscoding).append("');\" ");
								}
								tagString.append(" />");
							}
						}
						if(!flag){
							tagString.append("<br />");
						}
					}
				}
			}
		}
		
		if(StringUtils.isNotEmpty(value) && flag){
			String[] split = value.split("#");
			IG013BL ig013BL = (IG013BL) WebApplicationSupport.getBean("ig013BL");
			IG688SearchCondImpl cond = new IG688SearchCondImpl();
			List<String> eiids = new ArrayList<String>();
			for(String eiid:split){
				eiids.add(eiid);
			}
			cond.setEiidList(eiids);
			List<IG688Info> list = ig013BL.searchIG688Info(cond);
			for(IG688Info info:list){
				tagString.append("<a href=\"javascript:void(0)\" asm=\"")
				.append(pidid)
				.append("\" onclick=\"openSubIGCOM0303('")
				.append(info.getEiid())
				.append("','")
				.append(info.getEiversion())
				.append("');\" id=\"")
				.append(info.getEiid())
				.append("EIID\">")
				.append(info.getEiname())
//				.append("(")
//				.append(info.getEiversion())
//				.append(")")
				.append("</a>")
				.append("<img style=\"cursor: hand;\" src=\"images/delate.gif\" align=\"middle\" ");
				if(pidrows != null && pidrows > 1){
					tagString.append("onclick=\"delTableColumnEntity(this,'").append(info.getEiid()).append("EIID');\" ");
				}else{
					tagString.append("onclick=\"delSingleTableColumnEntity(this,'").append(info.getEiid()).append("EIID','").append(pidid).append("','").append(syscoding).append("');\" ");
				}
				tagString.append(" />");
				flag = false;
			}
			if(!flag){
				value = "DEFAULT_entityValue_";
				tagString.append("<br />");
			}
		}
		
		if(pidrows != null && pidrows > 1){
			tagString.append("<img src=\"images/addasm.gif\" alt='查询' style=\"cursor: hand;\"/>");
			tagString.append("<a href=\"javascript:void(0);\" onclick=\"javascript:addTableColumnEntity(this,'");
			tagString.append(pidid);
			tagString.append("','");
			tagString.append(syscoding);
			tagString.append("');\">添加资产</a>");
			tagString.append("<table name=\"column_entity\" class=\"tableColumnEntity\"></table>");
		}else{
			if(flag){
				tagString.append("<table name=\"column_entity\" class=\"tableColumnEntity\" ><tr id=\"0\"><td>");
				tagString.append("<input type=\"text\" name=\"show_value\" size=\"18\" readonly=\"true\" />");
				tagString.append("<img src=\"images/seek.gif\" border=\"0\" width=\"16\" height=\"16\" alt=\"查询\" style=\"cursor: hand;\" onclick=\"columnSelectEntity(this,'").append(pidid).append("','").append(syscoding).append("');\" />");
				tagString.append("</td></tr></table>");
			}else{
				tagString.append("<table name=\"column_entity\" class=\"tableColumnEntity\"></table>");
			}
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
	
	/**
	 * 表格类表单只读列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings("unchecked")
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		//表单定义ID取得
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单值取得
		String value = (String) params.get(PARAMS_VALUE);
		//表格类表单关联资产信息取得
		Map<String, IG731Info> pieMap = (Map<String, IG731Info>) params.get(PARAMS_TABLE_FORM_ENTITY_INFO);
		//取得行号
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		if(value == null || "null".equals(value)){
			value = "";
		}
		//声明标签生成字符串
		StringBuffer tagString = new StringBuffer();
		boolean flag = true;
		if(pieMap != null && StringUtils.isNotEmpty(value)){
			String str0 = value.split("_entityValue_")[0];
			if(StringUtils.isNotEmpty(str0)){
				String[] split = str0.split(",");
				if(split != null && split.length > 0){
					for(String pieid:split){
						IG731Info pieInfo = pieMap.get(pieid);
						if(pieInfo != null){
							flag = false;
							tagString.append("<a href=\"javascript:void(0)\" onclick=\"openSubIGCOM0303('")
									 .append(pieInfo.getEiid())
									 .append("','")
									 .append(pieInfo.getEiversion())
									 .append("');\" id=\"")
									 .append(pieInfo.getPieid())
									 .append("\">")
									 .append(pieInfo.getEntityItemTB().getEiname())
//									 .append("(")
//									 .append(pieInfo.getEiversion())
//									 .append(")")
									 .append("</a>");
						}
					}
				}
			}
		}
		if(StringUtils.isNotEmpty(value) && flag){
			String[] split = value.split("#");
			IG013BL ig013BL = (IG013BL) WebApplicationSupport.getBean("ig013BL");
			IG688SearchCondImpl cond = new IG688SearchCondImpl();
			List<String> eiids = new ArrayList<String>();
			for(String eiid:split){
				eiids.add(eiid);
			}
			cond.setEiidList(eiids);
			List<IG688Info> list = ig013BL.searchIG688Info(cond);
			for(IG688Info info:list){
				tagString.append("<a href=\"javascript:void(0)\" asm=\"")
				.append(pidid)
				.append("\" onclick=\"openSubIGCOM0303('")
				.append(info.getEiid())
				.append("','")
				.append(info.getEiversion())
				.append("');\" id=\"")
				.append(info.getEiid())
				.append("EIID\">")
				.append(info.getEiname())
//				.append("(")
//				.append(info.getEiversion())
//				.append(")")
				.append("</a>");
				flag = false;
			}
			if(!flag){
				value = "DEFAULT_entityValue_";
				tagString.append("<br />");
			}
		}
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value=\"").append(value).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
	
   /**
    *流程关闭状态状态级表单显示
    * @param params 参数
    * @return 流程关闭状态状态级表单显示
    */
   @Override
   public String generatedStatusCloseTag(Map<String, Object> params){
       //取得piid
       String pidid = (String) params.get(PARAMS_PIDID);
       //表单名称取得
       String property = (String) params.get(PARAMS_PROPERTY);
       //表单值取得
//       String value = (String) params.get(PARAMS_VALUE);
       
       //关闭之后的状态级私有表单列表
       @SuppressWarnings("unchecked")
       Map<String,List<IG561VWInfo>> statusclosedetails = (Map<String,List<IG561VWInfo>>) params.get(FormGeneratedTag.PARAMS_STATUS_CLOSE);
       //相关资产信息取得
       @SuppressWarnings("unchecked")
       List<IG731Info> processInfoEntityList = (List<IG731Info>) params.get(PARAMS_PROCESSINFO_ENTITY_LIST);
       
       StringBuffer tagString = new StringBuffer();
       if(statusclosedetails!=null){
           tagString.append("<table class=\"table_form\" style=\"width:100%;\"> " );
           List<IG561VWInfo> list= statusclosedetails.get(pidid);
           for(IG561VWInfo info:list){
               tagString.append("<tr>")
                   .append("<td style=\"width:30%;\">").append(info.getPsdname())
                   .append("</td>")
               
                   .append("<td style=\"width:70%;\">");
               //在此增加特殊处理逻辑 start
               boolean flag=false;
               //业务系统
               for(IG731Info entity:processInfoEntityList){
            	   String einame = "";
            	   if("1".equals(entity.getFingerPrint())){
						SOC0118VWPK pk = new SOC0118VWPK();
						pk.setId(Integer.parseInt(entity.getFingerPrint()));
						pk.setEiid(entity.getEiid());
						try {
							SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
							SOC0118VWInfo soc0118vwInfo = soc0118VWBL.searchEntityItemByKey(pk);
							einame = soc0118vwInfo.getEiname();
						} catch (BLException e) {
							e.printStackTrace();
						}
						
					}else{
						if(entity.getEntityItemTB() != null){
							einame = entity.getEntityItemTB().getEiname();
						}
					}
            	   
                   if(StringUtils.isNotEmpty(info.getPivarvalue())&&info.getPivarvalue().equals(entity.getPieid().toString())){
                	   if("1".equals(entity.getFingerPrint())){
							tagString.append("<a href=\"javascript:void(0)\" onclick=\"openSubIGCOM0303ForER('")
									.append(entity.getFingerPrint())
	                                .append("','")
	                                .append(entity.getEiid())
	                                .append("');\" id=\"");
						}else{
							tagString.append("<a href=\"javascript:void(0)\" onclick=\"openSubIGCOM0303('")
								.append(entity.getEiid())
		                        .append("','")
		                        .append(entity.getEiversion())
		                        .append("');\" id=\"");
						}
                	   tagString.append(entity.getPieid())
                                .append("\">")
                                .append(einame)
                                .append("</a>")
                                .append("<br />");
                                ;
                       flag=true;
                   }
               }
               //如果没有而且有默认值，则显示默认值
               //判断是否为应急资源应急资源
               if(info.getPivarname().equals("应急资源")){
            	   IG560BL ig560BL = (IG560BL) WebApplicationSupport.getBean("ig560BL");
            	   IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
            	   ig560Cond.setPsdid(info.getPsdid());
            	   List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
            	   SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
            		SOC0118VWSearchCondImpl soc0118Cond = new SOC0118VWSearchCondImpl();
            		FlowDetail flowDetail = new FlowDetail();
    				//遍历应急资源，并且组建类别Map;
    				if(ig560List != null && ig560List.size()>0){
    					if(flowDetail.getSoc0118Map()==null){
    						flowDetail.setSoc0118Map(new HashMap<String, List<SOC0118VWInfo>>());
    					}
    					for(IG560Info ig560Info : ig560List){
    						if(ig560Info.getDfvalue()!=null &&!ig560Info.getDfvalue().isEmpty()){
    							String type = ig560Info.getDfvalue().split("_SOC_")[1];
    							soc0118Cond.setEiid(ig560Info.getDfvalue().split("_")[1]);
    							soc0118Cond.setId(Integer.parseInt(ig560Info.getDfvalue().split("_")[0]));
    							SOC0118VWInfo soc0118VWInfo = soc0118VWBL.searchEntityItem(soc0118Cond).get(0);
    							if(flowDetail.getSoc0118Map().get(type)!=null){
    								List<SOC0118VWInfo> soc0118VWInfoList = flowDetail.getSoc0118Map().get(type);
    								soc0118VWInfoList.add(soc0118VWInfo);
    								flowDetail.getSoc0118Map().put(type, soc0118VWInfoList);
    							}else{
    								flowDetail.getSoc0118Map().put(type, new ArrayList<SOC0118VWInfo>());
    								List<SOC0118VWInfo> soc0118VWInfoList = flowDetail.getSoc0118Map().get(type);
    								soc0118VWInfoList.add(soc0118VWInfo);
    								flowDetail.getSoc0118Map().put(type, soc0118VWInfoList);
    							}
    						}
    						
    					}
    				}
    				if (flowDetail.getSoc0118Map() != null && flowDetail.getSoc0118Map().size() > 0) {
    					for(String key:flowDetail.getSoc0118Map().keySet()){
    						//计算空格的数量
    						String spaceStr = "";
    						for(int spaceIndex = 0;spaceIndex<key.length()*2;spaceIndex++){
    							spaceStr += "&nbsp;";
    							
    						}
    						List<SOC0118VWInfo> soc0118List = flowDetail.getSoc0118Map().get(key);
    						for (int index = 0; index < soc0118List.size(); index++) {
    							SOC0118VWInfo soc0118 = soc0118List.get(index);
	                         	if(index == 0){
	            					tagString.append(key.split("_")[1]+"：");
	            				}else {
	            					tagString.append(spaceStr);
	            				}
    							tagString.append("<a href=\"javascript:void(0)\" asm=\"")
        					    .append("\" onclick=\"openSubIGCOM0303('")
        					    .append(soc0118.getEiid())
        					    .append("','")
        					    .append(soc0118.getEiversion())
        					    .append("")
	                         	.append("');\" id=\"")
	                         	.append(soc0118.getEiid())
	                         	.append("EIID\">").append(soc0118.getEiname())
//	                         	.append("(")
//	                         	.append(soc0118.getEiversion())
//	                         	.append(")")
	                         	.append("</a>")
	                         	.append("<br />");
    						}
    						
    					}
    				}
               }else{
            	   if(!flag&&StringUtils.isNotEmpty(info.getPivarvalue())&&info.getPivarvalue().contains("def_")){
                       IG013BL ig013BL = (IG013BL) WebApplicationSupport.getBean("ig013BL");
                       IG688SearchCondImpl cond = new IG688SearchCondImpl();
                       List<String> eiids = new ArrayList<String>();
                       String value=info.getPivarvalue().substring(4);
                       for(String s:value.split("#")){
                           eiids.add(s);
                       }
                       if(eiids.size() > 0){
                           cond.setEiidList(eiids);
                           List<IG688Info> list_688 = ig013BL.searchIG688Info(cond);
                           for(IG688Info ig688Info:list_688){
                               tagString.append("<a href=\"javascript:void(0)\" asm=\"")
                                .append("\" onclick=\"openSubIGCOM0303('")
                                .append(ig688Info.getEiid())
                                .append("','")
                                .append(ig688Info.getEiversion())
                                .append("")
                                .append("');\" id=\"")
                                .append(ig688Info.getEiid())
                                .append("EIID\">")
                                .append(ig688Info.getEiname())
                                .append("(")
    							.append(ig688Info.getEiversion())
    							.append(")")
                                .append("</a>")
                                .append("<br />");
                           }
                       }
                   } 
            	   
               }
               
               //在此增加特殊处理逻辑 end
               tagString.append("</td>");
               tagString.append("</tr>");
           }
           tagString.append("</table>");
       }
       tagString.append("<input type=\"hidden\" id=\"pidid")
                .append(pidid)
                .append("\" name=\"")
                .append(property)
                .append("\" value=\"")
                .append("")
                .append("\"/>");
       return tagString.toString();
   }
	
}
