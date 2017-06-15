/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG007Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表格类表单信息生成标签实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TableFormGeneratedTagImpl extends FormGeneratedTagImpl{
	
	/**
	 * 公有可写标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		return generatedPublicTag(params);
	}
	
	/**
	 * 公有只读标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		return generatedPublicTag(params);
	}
	
	/**
	 * 表格类表单可写列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		return generatedPublicTag(params);
	}
	
	/**
	 * 表格类表单只读列生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		return generatedPublicTag(params);
	}

	/**
	 * 公有标签生成
	 * @param params 参数
	 * @return 生成标签字符串
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public String generatedPublicTag(Map<String, Object> params){
		//标签工厂类
		FormGeneratedTagFactory factory = (FormGeneratedTagFactory) WebApplicationSupport.getBean("formGeneratedTagFactory");
		//标签的生成信息
		StringBuffer tagString = new StringBuffer();
		//取得表格类型表单的模式（列的横向显示还是纵向显示）
		String model = (String) params.get(PARAMS_PIDDISPLAY);
		//取得表单定义ID
		String pidid = (String) params.get(PARAMS_PIDID);
		//表单名称取得
		String property = (String) params.get(PARAMS_PROPERTY);
		//表格类表单的使用模式
		String piduse = (String) params.get(PARAMS_PIDUSE);
		//行数取得
		Integer rowLength = (Integer)params.get(PARAMS_PIDROWS);
		//访问权限取得
		String pidaccess = (String) params.get(PARAMS_PIDACCESS);
		//当前行号取得
		String rownumber = params.get(PARAMS_ROWNUMBER) == null ? "0" : params.get(PARAMS_ROWNUMBER).toString();
		//取得表单列信息
		Map<String, List<IG007Info>> columnInfoMap = (Map<String, List<IG007Info>>) params.get(PARAMS_TABLE_COLUMN_INFO);
		//表格类表单列值取得
		Map<String, Map<String, Map<String, String>>> tableColumnValueMap = (Map<String, Map<String, Map<String, String>>>) params.get(PARAMS_TABLE_FORM_COLUMN_VALUE);
		//取得标题显示模式
		String titledisplay = (String) params.get(PARAMS_TITLE_DISPLAY);
		//表单名称取得
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		//标题名称显示模式取得
		String pidhide = (String) params.get(PARAMS_PIDHIDE);
		//必填标识取得
		String pidrequired = (String) params.get(PARAMS_PIDREQUIRED);
		//流程主键取得
		Integer prid = (Integer) params.get(PARAMS_PRID);
		//当前状态名称取得
		String psdname = (String) params.get(PARAMS_PSDNAME);
		//总宽度取得
		Integer containerWidth = params.get(PARAMS_PIDWIDTH) == null || "0".equals(params.get(PARAMS_PIDWIDTH)) ? null : Integer.valueOf(params.get(PARAMS_PIDWIDTH).toString());
		if(containerWidth == null){
			containerWidth = 820;
			if("T".equals(titledisplay) || "Y".equals(titledisplay)){
				containerWidth = 965;
			}
		}else{
			containerWidth -= 5;
		}
		//当前表单的列值
		Map<String, Map<String, String>> columnValueMap = null;
		if(tableColumnValueMap != null){
			columnValueMap = tableColumnValueMap.get(pidid);
		}
		if(StringUtils.isNotEmpty(rownumber) && rownumber.indexOf("_#_") >= 0){
			columnValueMap = null;
		}
		tagString.append("<input type=\"hidden\" name=\"").append(property).append("\" id=\"pidid").append(pidid).append("\" value=\"tab\" />");
		tagString.append("<input type=\"hidden\" name=\"column_table_rownumber\" value=\"").append(rownumber).append("\"/>");
		if(columnInfoMap != null){
			//取得当前表单的列信息
			List<IG007Info> columnInfoList = columnInfoMap.get(pidid);
			if(columnInfoList != null){
				//横向显示
				if("1".equals(model)){
					//取得显示行号标识
					String showrownum = (String) params.get(PARAMS_SHOWROWNUM);
					int column_length = 0;
					int sunWidth = 0;
					if("Y".equals(showrownum)){
						sunWidth += 40;
						column_length ++;
					}
					for(IG007Info column : columnInfoList){
						Integer width = column.getPidwidth() == null || column.getPidwidth() == 0 ? 150 : column.getPidwidth();
						sunWidth += width;
						column_length ++;
					}
					//div头部
					tagString.append("<div name=\"table_form_panel\" ");
					if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(pidaccess)){
						tagString.append(" style=\"display:none;\">");
					}else if(sunWidth > containerWidth){
						tagString.append(" style=\"width:").append(containerWidth).append("px;overflow-x:scroll;overflow-y:hidden;margin-left:0px;\">");
					}else{
						tagString.append(" style=\"margin-left:0px;\">");
					}
					//表格头部
					tagString.append("<table name=\"table_form\" display=\"");
					tagString.append(model);
					tagString.append("\" showrownum=\"");
					tagString.append(showrownum);
					tagString.append("\" style=\"width:").append(sunWidth).append("px;");
					if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(pidaccess)){
						tagString.append("display:none;");
					}
					if("3".equals(params.get(PARAMS_SHOWLINE))){
						tagString.append("\" class=\"table_form2\" ");
					}else if("2".equals(params.get(PARAMS_SHOWLINE))){
						tagString.append("\" class=\"table_form1\" ");
					}else{
						tagString.append("\" class=\"table_form\" ");
					}
					tagString.append(" id=\"").append(pidid).append("_tableForm\">");
					//表单名称显示头部显示
					if("T".equals(titledisplay)){
						tagString.append("<tr name=\"titlerow\"><th colspan=\"").append(column_length).append("\" >");
						tagString.append(pidlabel);
						tagString.append("</th></tr>");
					}
					boolean showTitleFlag = true;
					for(IG007Info column : columnInfoList){
						if(("8".equals(column.getPidtype()) && !"Y".equals(column.getTitledisplay())) || (!"8".equals(column.getPidtype()) && !"Y".equals(column.getPidhide()))){
							showTitleFlag = false;
							break;
						}
					}
					int index = 1;
					if(!showTitleFlag){
						//初始化标题
						tagString.append("<tr name=\"titletr\">");
						if("Y".equals(showrownum)){
							tagString.append("<th style=\"width:40px;\">序号</th>");
						}
						//初始化标题信息
						for(IG007Info column : columnInfoList){
							Integer width = column.getPidwidth() == null ? 150 : column.getPidwidth();
							String title = column.getPidname();
							if((!"8".equals(column.getPidtype()) && "Y".equals(column.getPidhide())) || ("8".equals(column.getPidtype()) && "Y".equals(column.getTitledisplay()))){
								title = "";
							}else{
								if(IGPRDCONSTANTS.PID_REQUIRED_YES.equals(column.getPidrequired())){
									title = "<span class=\"red\">*</span>" + title;
								}
							}
							tagString.append("<th style=\"width:").append(width).append("px;\"" );
							if(StringUtils.isNotEmpty(column.getPiddesc())){
								tagString.append(" onmousemove=\"tooltip.show('" )
								.append(column.getPiddesc())
								.append("');\" onmouseout=\"tooltip.hide();\"");
							}
							tagString.append(">");
							tagString.append(title);
							if(prid != null && prid > 0){
//								ProcessExamineIdeaTag.getRetHtml(prid, column.getPidid(), psdname, column.getNeedidea(),model);
							}
							tagString.append("</th>");
						}
						tagString.append("</tr>");
					}
					//可变行的处理方式
					if("1".equals(piduse)){
						if(columnValueMap == null || columnValueMap.size() == 0){
							columnValueMap = getValue(tableColumnValueMap, columnInfoMap, pidid,rownumber);
						}
						if(columnValueMap != null && columnValueMap.size() > 0){
							Set<Entry<String,Map<String,String>>> set = columnValueMap.entrySet();
							for(Iterator<Entry<String, Map<String, String>>> iter = set.iterator();iter.hasNext();){
								iter.next();
								String crownum = "";
								if("0".equals(rownumber)){
									crownum += index;
								}else{
									crownum = rownumber + "_" + index;
								}
								if(columnValueMap.get(crownum) == null){
									continue;
								}
								tagString.append("<tr ");
								if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pidaccess)){
									tagString.append("class=\"rightMenu\"");
								}
								tagString.append(">");
								if("Y".equals(showrownum)){
									tagString.append("<td align=\"center\" style=\"width:40px;\">").append(index).append("</td>");
								}
								for(IG007Info column:columnInfoList){
									Integer width = column.getPidwidth() == null ? 150 : column.getPidwidth();
									tagString.append("<td style=\"width:").append(width).append("px;text-align:").append(getAlign(column.getAlign())).append(";\">");
									Map<String, Object> columnParams = packagingParams(params,column);
									columnParams.put(PARAMS_ROWNUMBER, crownum);
									if(StringUtils.isNotEmpty(column.getPiddefault())){
										columnParams.put(PARAMS_VALUE, column.getPiddefault());
									}
									//如果存在列值，将列值加入table
									Map<String, String> valueMap = columnValueMap.get(crownum);
									if(valueMap != null){
										String value = valueMap.get(column.getPidid());
										if(StringUtils.isNotEmpty(value)){
											columnParams.put(PARAMS_VALUE, value);
										}
									}
									tagString.append(factory.generatedColumn(columnParams));
									tagString.append("</td>");
								}
								index++;
								tagString.append("</tr>");
							}
						}else{
							String crownum = "";
							if("0".equals(rownumber)){
								crownum += index;
							}else{
								crownum = rownumber + "_" + index;
							}
							tagString.append("<tr ");
							if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pidaccess)){
								tagString.append("class=\"rightMenu\"");
							}
							tagString.append(">");
							if("Y".equals(showrownum)){
								tagString.append("<td align=\"center\" style=\"width:40px;\">").append(index).append("</td>");
							}
							for(IG007Info column:columnInfoList){
								Integer width = column.getPidwidth() == null ? 150 : column.getPidwidth();
								tagString.append("<td style=\"width:").append(width).append("px;text-align:").append(getAlign(column.getAlign())).append(";\">");
								Map<String, Object> columnParams = packagingParams(params,column);
								columnParams.put(PARAMS_ROWNUMBER, crownum);
								if(StringUtils.isNotEmpty(column.getPiddefault())){
									columnParams.put(PARAMS_VALUE, column.getPiddefault());
								}
								tagString.append(factory.generatedColumn(columnParams));
								tagString.append("</td>");
							}
							tagString.append("</tr>");
						}
					//固定行的处理方式
					}else{
						for(int rownum=0;rownum<rowLength;rownum++){
							String crownum = "";
							if("0".equals(rownumber)){
								crownum += index;
							}else{
								crownum = rownumber + "_" + index;
							}
							tagString.append("<tr>");
							if("Y".equals(showrownum)){
								tagString.append("<td align=\"center\">").append(index).append("</td>");
							}
							for(IG007Info column:columnInfoList){
								Integer width = column.getPidwidth() == null ? 150 : column.getPidwidth();
								tagString.append("<td style=\"width:").append(width).append("px;text-align:").append(getAlign(column.getAlign())).append(";\">");
								Map<String, Object> columnParams = packagingParams(params,column);
								columnParams.put(PARAMS_ROWNUMBER, crownum);
								if(StringUtils.isNotEmpty(column.getPiddefault())){
									columnParams.put(PARAMS_VALUE, column.getPiddefault());
								}
								//如果存在列值，将列值加入table
								if(columnValueMap != null){
									Map<String, String> valueMap = columnValueMap.get(crownum);
									if(valueMap != null){
										String value = valueMap.get(column.getPidid());
										if(StringUtils.isNotEmpty(value)){
											columnParams.put(PARAMS_VALUE, value);
										}
									}
								}
								tagString.append(factory.generatedColumn(columnParams));
								tagString.append("</td>");
							}
							tagString.append("</tr>");
							index++;
						}
					}
					tagString.append("</table>");
					//可变行添加可变模板
					if("1".equals(piduse) && IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pidaccess) && (!rownumber.contains("_#_"))){
						tagString.append("<table style=\"display:none;\" id=\"").append(pidid).append("_tableForm_template\">");
						tagString.append("<tr>");
						for(IG007Info column:columnInfoList){
							Integer width = column.getPidwidth() == null ? 150 : column.getPidwidth();
							tagString.append("<td style=\"width:").append(width).append("px;text-align:").append(getAlign(column.getAlign())).append(";\">");
							Map<String, Object> columnParams = packagingParams(params,column);
							columnParams.put(PARAMS_ROWNUMBER, "_#_");
							if(StringUtils.isNotEmpty(column.getPiddefault())){
								columnParams.put(PARAMS_VALUE, column.getPiddefault());
							}
							tagString.append(factory.generatedColumn(columnParams));
							tagString.append("</td>");
						}
						tagString.append("</tr>");
						tagString.append("</table>");
					}
					tagString.append("</div>");
					//纵向显示
				}else{
					String pidratio = (String) params.get(PARAMS_PIDRATIO);
					//取得列宽
					int thwidth = (int)(containerWidth / 16D * 3D);
					int tdwidth = (int)(containerWidth / 16D * 5D);
					if(StringUtils.isNotEmpty(pidratio)){
						String[] ratios = pidratio.split("_");
						double thr = Double.valueOf(ratios[0]);
						double tdr = Double.valueOf(ratios[1]);
						double sumr = (thr + tdr) * 2;
						thwidth = (int) (containerWidth / sumr * thr);
						tdwidth = (int) (containerWidth / sumr * tdr);
					}
					
					//div头部
					//隐藏表单的处理方式
					tagString.append("<div name=\"table_form_panel\" ");
					if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(pidaccess)){
						tagString.append(" style=\"display:none;\" >");
					}else{
						tagString.append(" style=\"margin-left:0px;\">");
					}
					tagString.append("<table name=\"table_form\" display=\"");
					tagString.append(model);
					tagString.append("\" showrownum=\"N\" id=\"").append(pidid).append("_tableForm").append("\" ");
					if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(pidaccess)){
						tagString.append(" style=\"display:none;\"");
					}
					tagString.append(">");
					//表单名称显示头部显示
					if("T".equals(titledisplay)){
						tagString.append("<tr name=\"titlerow\">");
						tagString.append("<th style=\"border:1px solid #98c6f2;background-color:#e8f2fc;text-align:center;color:#000000; height:20px;\">");
						tagString.append(pidlabel);
						tagString.append("</th></tr>");
					}
					int index = 1;
					if("1".equals(piduse)){
						if((columnValueMap == null || columnValueMap.size() == 0) && tableColumnValueMap != null){
							for(IG007Info col:columnInfoList){
								Map<String, Map<String, String>> map = tableColumnValueMap.get(col.getPidid());
								if(map != null && map.size() > 0){
									int rows = 1;
									for(Iterator<String> iter = map.keySet().iterator();iter.hasNext();){
										String flagRowNum = iter.next();
										if(StringUtils.isNotEmpty(flagRowNum)){
											String[] split = flagRowNum.split("_");
											if(split.length > 1){
												if(Integer.valueOf(split[split.length - 2]) > rows){
													rows = Integer.valueOf(split[split.length - 2]);
												}
											}
										}
									}
									if(rows > 1){
										Map<String, Map<String, String>> tempMap = new LinkedHashMap<String, Map<String,String>>();
										for(int i=1;i<=rows;i++){
											String crownum = "";
											if("0".equals(rownumber)){
												crownum += i;
											}else{
												crownum = rownumber + "_" + i;
											}
											tempMap.put(crownum, new HashMap<String, String>());
										}
										columnValueMap = tempMap;
									}
								}
							}
						}
						if(columnValueMap != null && columnValueMap.size() > 0){
							Set<Entry<String,Map<String,String>>> set = columnValueMap.entrySet();
							for(Iterator<Entry<String, Map<String, String>>> iter = set.iterator();iter.hasNext();){
								iter.next();
								String crownum = "";
								if("0".equals(rownumber)){
									crownum += index;
								}else{
									crownum = rownumber + "_" + index;
								}
								if(columnValueMap.get(crownum) == null){
									continue;
								}
								tagString.append("<tr ");
								if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pidaccess)){
									tagString.append("class=\"rightMenu\"");
								}
								tagString.append(">");
								tagString.append("<td style=\"border:none;\">");
								if("3".equals(params.get(PARAMS_SHOWLINE))){
									tagString.append("<table class=\"table_form2\" ");
								}else if("2".equals(params.get(PARAMS_SHOWLINE))){
									tagString.append("<table class=\"table_form1\" ");
								}else{
									tagString.append("<table class=\"table_form\" ");
								}
								tagString.append(" id=\"").append(pidid).append("_tableForm\" ");
								if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(pidaccess)){
									tagString.append(" style=\"display:none;\" ");
								}
								tagString.append(">");
								//分组内容
								int col = 0;
								int colspan = 1;
								String endTag = "</tr><tr>";
								tagString.append("<tr>");
								for(IG007Info column:columnInfoList){
									if("0".equals(column.getRowwidth())){
										if(col == 1){
											endTag = "<td style=\"width:" + thwidth + "px;\"></td><td style=\"width:" + tdwidth + "px;\"></td></tr><tr>";
										}else{
											endTag = "</tr><tr>";
										}
										col = 2;
										colspan = 3;
									}else{
										if(col == 1){
											col = 0;
											endTag = "";
										}else{
											col = 1;
											endTag = "</tr><tr>";
										}
										colspan = 1;
									}
									tagString.append(endTag);
									if((!"8".equals(column.getPidtype()) && "Y".equals(column.getPidhide())) || ("8".equals(column.getPidtype()) && ("T".equals(column.getTitledisplay()) || "Y".equals(column.getTitledisplay())))){
										colspan ++;
									}else{
										tagString.append("<th style=\"width:" + thwidth + "px;\"");
										if(StringUtils.isNotEmpty(column.getPiddesc())){
											tagString.append(" onmousemove=\"tooltip.show('" )
											.append(column.getPiddesc())
											.append("');\" onmouseout=\"tooltip.hide();\"");
										}
										tagString.append(">");
										if(IGPRDCONSTANTS.PID_REQUIRED_YES.equals(column.getPidrequired())){
											tagString.append("<span class=\"red\">*</span>");
										}
										tagString.append(column.getPidname());
										tagString.append("</th>");
									}
									tagString.append("<td style=\"width:").append(styleWidth(colspan,thwidth,tdwidth)).append("px;text-align:").append(getAlign(column.getAlign())).append(";\" colspan=\"").append(colspan).append("\">");
									Map<String, Object> columnParams = packagingParams(params,column);
									columnParams.put(PARAMS_ROWNUMBER, crownum);
									columnParams.put(PARAMS_PIDWIDTH, styleWidth(colspan,thwidth,tdwidth));
									if(StringUtils.isNotEmpty(column.getPiddefault())){
										columnParams.put(PARAMS_VALUE, column.getPiddefault());
									}
									//如果存在列值，将列值加入table
									if(columnValueMap != null){
										Map<String, String> valueMap = columnValueMap.get(crownum);
										if(valueMap != null){
											String value = valueMap.get(column.getPidid());
											if(StringUtils.isNotEmpty(value)){
												columnParams.put(PARAMS_VALUE, value);
											}
										}
									}
									tagString.append(factory.generatedColumn(columnParams));
									tagString.append("</td>");
								}
								if(col == 2 || col == 0){
									tagString.append("</tr>");
								}else{
									tagString.append("<td style=\"width:").append(thwidth).append("px;\"></td><td style=\"width:").append(tdwidth).append("px;\"></td></tr><tr>");
								}
								tagString.append("</table>");
								tagString.append("</td>");
								tagString.append("</tr>");
								
								index++;
							}
						}else{
							String crownum = "";
							if("0".equals(rownumber)){
								crownum += index;
							}else{
								crownum = rownumber + "_" + index;
							}
							tagString.append("<tr ");
							if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pidaccess)){
								tagString.append("class=\"rightMenu\"");
							}
							tagString.append(">");
							tagString.append("<td style=\"border:none;\">");
							if("3".equals(params.get(PARAMS_SHOWLINE))){
								tagString.append("<table class=\"table_form2\" ");
							}else if("2".equals(params.get(PARAMS_SHOWLINE))){
								tagString.append("<table class=\"table_form1\" ");
							}else{
								tagString.append("<table class=\"table_form\" ");
							}
							tagString.append(" id=\"").append(pidid).append("_tableForm\">");
							//分组内容
							int col = 0;
							int colspan = 1;
							String endTag = "</tr><tr>";
							tagString.append("<tr>");
							for(IG007Info column:columnInfoList){
								if("0".equals(column.getRowwidth())){
									if(col == 1){
										endTag = "<td style=\"width:" + thwidth + "px;\"></td><td style=\"width:" + tdwidth + "px;\"></td></tr><tr>";
									}else{
										endTag = "</tr><tr>";
									}
									col = 2;
									colspan = 3;
								}else{
									if(col == 1){
										col = 0;
										endTag = "";
									}else{
										col = 1;
										endTag = "</tr><tr>";
									}
									colspan = 1;
								}
								tagString.append(endTag);
								if((!"8".equals(column.getPidtype()) && "Y".equals(column.getPidhide())) || ("8".equals(column.getPidtype()) && ("T".equals(column.getTitledisplay()) || "Y".equals(column.getTitledisplay())))){
									colspan ++;
								}else{
									tagString.append("<th style=\"width:").append(thwidth).append("px;\"");
									if(StringUtils.isNotEmpty(column.getPiddesc())){
										tagString.append(" onmousemove=\"tooltip.show('" )
										.append(column.getPiddesc())
										.append("');\" onmouseout=\"tooltip.hide();\"");
									}
									tagString.append(">");
									if(IGPRDCONSTANTS.PID_REQUIRED_YES.equals(column.getPidrequired())){
										tagString.append("<span class=\"red\">*</span>");
									}
									tagString.append(column.getPidname());
									tagString.append("</th>");
								}
								tagString.append("<td style=\"width:").append(styleWidth(colspan,thwidth,tdwidth)).append("px;text-align:").append(getAlign(column.getAlign())).append(";\" colspan=\"").append(colspan).append("\">");
								Map<String, Object> columnParams = packagingParams(params,column);
								columnParams.put(PARAMS_ROWNUMBER, crownum);
								if(StringUtils.isNotEmpty(column.getPiddefault())){
									columnParams.put(PARAMS_VALUE, column.getPiddefault());
								}
								//如果存在列值，将列值加入table
								if(columnValueMap != null){
									Map<String, String> valueMap = columnValueMap.get(crownum);
									if(valueMap != null){
										String value = valueMap.get(column.getPidid());
										if(StringUtils.isNotEmpty(value)){
											columnParams.put(PARAMS_VALUE, value);
										}
									}
								}
								columnParams.put(PARAMS_PIDWIDTH, styleWidth(colspan,thwidth,tdwidth));
								tagString.append(factory.generatedColumn(columnParams));
								tagString.append("</td>");
							}
							if(col == 2 || col == 0){
								tagString.append("</tr>");
							}else{
								tagString.append("<td style=\"width:").append(thwidth).append("px;\"></td><td style=\"width:").append(tdwidth).append("px;\"></td></tr><tr>");
							}
							tagString.append("</table>");
							tagString.append("</td>");
							tagString.append("</tr>");
						}
					}else{
						for(int rownum=0;rownum<rowLength;rownum++){
							String crownum = "";
							if("0".equals(rownumber)){
								crownum += index;
							}else{
								crownum = rownumber + "_" + index;
							}
							tagString.append("<tr>");
							tagString.append("<td style=\"border:none;\">");
							//表格头部
							if("3".equals(params.get(PARAMS_SHOWLINE))){
								tagString.append("<table class=\"table_form2\" ");
							}else if("2".equals(params.get(PARAMS_SHOWLINE))){
								tagString.append("<table class=\"table_form1\" ");
							}else{
								tagString.append("<table class=\"table_form\" ");
							}
							tagString.append(" id=\"").append(pidid).append("_tableForm\">");
							//分组内容
							int col = 0;
							int colspan = 1;
							String endTag = "</tr><tr>";
							tagString.append("<tr>");
							for(IG007Info column:columnInfoList){
								if("0".equals(column.getRowwidth())){
									if(col == 1){
										endTag = "<td style=\"width:" + thwidth + "px;\"></td><td style=\"width:" + tdwidth + "px;\"></td></tr><tr>";
									}else{
										endTag = "</tr><tr>";
									}
									col = 2;
									colspan = 3;
								}else{
									if(col == 1){
										col = 0;
										endTag = "";
									}else{
										col = 1;
										endTag = "</tr><tr>";
									}
									colspan = 1;
								}
								tagString.append(endTag);
								if((!"8".equals(column.getPidtype()) && "Y".equals(column.getPidhide())) || ("8".equals(column.getPidtype()) && ("T".equals(column.getTitledisplay()) || "Y".equals(column.getTitledisplay())))){
									colspan ++;
								}else{
									tagString.append("<th style=\"width:").append(thwidth).append("px;\"");
									if(StringUtils.isNotEmpty(column.getPiddesc())){
										tagString.append(" onmousemove=\"tooltip.show('" )
										.append(column.getPiddesc())
										.append("');\" onmouseout=\"tooltip.hide();\"");
									}
									tagString.append(">");
									if(IGPRDCONSTANTS.PID_REQUIRED_YES.equals(column.getPidrequired())){
										tagString.append("<span class=\"red\">*</span>");
									}
									tagString.append(column.getPidname());
									tagString.append("</th>");
								}
								tagString.append("<td style=\"width:").append(styleWidth(colspan,thwidth,tdwidth)).append("px;text-align:").append(getAlign(column.getAlign())).append(";\" colspan=\"").append(colspan).append("\">");
								Map<String, Object> columnParams = packagingParams(params,column);
								columnParams.put(PARAMS_ROWNUMBER, crownum);
								if(StringUtils.isNotEmpty(column.getPiddefault())){
									columnParams.put(PARAMS_VALUE, column.getPiddefault());
								}
								//如果存在列值，将列值加入table
								if(columnValueMap != null){
									Map<String, String> valueMap = columnValueMap.get(crownum);
									if(valueMap != null){
										String value = valueMap.get(column.getPidid());
										if(StringUtils.isNotEmpty(value)){
											columnParams.put(PARAMS_VALUE, value);
										}
									}
								}
								columnParams.put(PARAMS_PIDWIDTH, styleWidth(colspan,thwidth,tdwidth));
								tagString.append(factory.generatedColumn(columnParams));
								tagString.append("</td>");
							}
							if(col == 2 || col == 0){
								tagString.append("</tr>");
							}else{
								tagString.append("<td style=\"width:").append(thwidth).append("px;\"></td><td style=\"width:").append(tdwidth).append("px;\"></td></tr><tr>");
							}
							tagString.append("</table>");
							tagString.append("</td>");
							tagString.append("</tr>");
							index ++;
						}
					}
					tagString.append("</table>");
					
					//复制模板
					if("1".equals(piduse) && IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pidaccess) && (!rownumber.contains("_#_"))){
						//表格头部
						tagString.append("<table style=\"display:none;\" ");
						if("3".equals(params.get(PARAMS_SHOWLINE))){
							tagString.append(" class=\"table_form2\" ");
						}else if("2".equals(params.get(PARAMS_SHOWLINE))){
							tagString.append(" class=\"table_form1\" ");
						}else{
							tagString.append(" class=\"table_form\" ");
						}
						tagString.append(" id=\"").append(pidid).append("_tableForm_template\">");
						/*
						 * 列标识
						 * 0 
						 */
						int tcol = 0;
						int tcolspan = 1;
						String tendTag = "</tr><tr>";
						tagString.append("<tr>");
						for(IG007Info column:columnInfoList){
							if("0".equals(column.getRowwidth())){
								if(tcol == 1){
									tendTag = "<td style=\"width:" + thwidth + "px;\"></td><td style=\"width:" + tdwidth + "px;\"></td></tr><tr>";
								}else{
									tendTag = "</tr><tr>";
								}
								tcol = 2;
								tcolspan = 3;
							}else{
								if(tcol == 1){
									tcol = 0;
									tendTag = "";
								}else{
									tcol = 1;
									tendTag = "</tr><tr>";
								}
								tcolspan = 1;
							}
							tagString.append(tendTag);
							if((!"8".equals(column.getPidtype()) && "Y".equals(column.getPidhide())) || ("8".equals(column.getPidtype()) && ("T".equals(column.getTitledisplay()) || "Y".equals(column.getTitledisplay())))){
								tcolspan ++;
							}else{
								tagString.append("<th style=\"width:").append(thwidth).append("px;\"");
								if(StringUtils.isNotEmpty(column.getPiddesc())){
									tagString.append(" onmousemove=\"tooltip.show('" )
									.append(column.getPiddesc())
									.append("');\" onmouseout=\"tooltip.hide();\"");
								}
								tagString.append(">");
								if(IGPRDCONSTANTS.PID_REQUIRED_YES.equals(column.getPidrequired())){
									tagString.append("<span class=\"red\">*</span>");
								}
								tagString.append(column.getPidname());
								tagString.append("</th>");
							}
							tagString.append("<td style=\"width:").append(styleWidth(tcolspan,thwidth,tdwidth)).append("px;text-align:").append(getAlign(column.getAlign())).append(";\" colspan=\"").append(tcolspan).append("\">");
							Map<String, Object> columnParams = packagingParams(params,column);
							if(StringUtils.isNotEmpty(column.getPiddefault())){
								columnParams.put(PARAMS_VALUE, column.getPiddefault());
							}
							columnParams.put(PARAMS_ROWNUMBER, "_#_");
							if("8".equals(column.getPidtype())){
								columnParams.put(PARAMS_PIDWIDTH, styleWidth(tcolspan,thwidth,tdwidth));
							}
							tagString.append(factory.generatedColumn(columnParams));
							tagString.append("</td>");
						}
						if(tcol == 2 || tcol == 0){
							tagString.append("</tr>");
						}else{
							tagString.append("<td style=\"width:").append(thwidth).append("px;\"></td><td style=\"width:").append(tdwidth).append("px;\"></td></tr><tr>");
						}
						tagString.append("</table>");
					}
					
					tagString.append("</div>");
				}
			}
		}
		return tagString.toString();
	}
	
	private Map<String, Map<String, String>> getValue(Map<String, Map<String, Map<String, String>>> tableColumnValueMap,
			Map<String, List<IG007Info>> columnInfoMap,String pidid,String rownum){
		if(tableColumnValueMap == null || tableColumnValueMap.size() == 0){
			return null;
		}else{
			Map<String, Map<String, String>> map = tableColumnValueMap.get(pidid);
			Map<String, Map<String, String>> result = new LinkedHashMap<String, Map<String,String>>();
			if(map != null && map.size() > 0){
				Set<String> set = new LinkedHashSet<String>();
				for(Iterator<Entry<String, Map<String, String>>> iter = map.entrySet().iterator();iter.hasNext();){
					Entry<String, Map<String, String>> entry = iter.next();
					String key = entry.getKey();
					if(StringUtils.isNotEmpty(rownum) && !"0".equals(rownum)){
						key = key.replace(rownum + "_", "");
					}
					if(StringUtils.isNotEmpty(key)){
						int index = key.indexOf("_");
						if(index > 0){
							set.add(key.substring(0,index));
						}else{
							set.add(key);
						}
					}
				}
				int index = 0;
				for(Iterator<String> iter = set.iterator();iter.hasNext();){
					iter.next();
					index ++;
					String key = null;
					if(StringUtils.isNotEmpty(rownum) && !"0".equals(rownum)){
						key = rownum + "_" + index;
					}else{
						key = "" + index;
					}
					result.put(key, new HashMap<String, String>());
				}
				return result;
			}else{
				List<IG007Info> list = columnInfoMap.get(pidid);
				if(list == null || list.isEmpty()){
					return null;
				}else{
					for(IG007Info info:list){
						Map<String, Map<String, String>> value = getValue(tableColumnValueMap, columnInfoMap, info.getPidid(), rownum);
						if(value != null && value.size() > 0){
							return value;
						}
					}
				}
			}
		}
		return null;
	}

	public int styleWidth(int colspan,int thwidth,int tdwidth){
		int width = tdwidth;
		switch (colspan) {
		case 3:
			width = tdwidth * 2 + thwidth;
			break;
		case 4:
			width = (tdwidth + thwidth) * 2;
			break;

		default:
			break;
		}
		return width;
	}
	
	private String getAlign(String flag){
		String align = "left";
		if(StringUtils.isNotEmpty(flag)){
			if("C".equals(flag)){
				align = "center";
			}else if("R".equals(flag)){
				align = "right";
			}
		}
		return align;
	}
}
