/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������Ϣ���ɱ�ǩʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TableFormGeneratedTagImpl extends FormGeneratedTagImpl{
	
	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params){
		return generatedPublicTag(params);
	}
	
	/**
	 * ����ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTag(Map<String, Object> params){
		return generatedPublicTag(params);
	}
	
	/**
	 * ��������д������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		return generatedPublicTag(params);
	}
	
	/**
	 * ������ֻ��������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		return generatedPublicTag(params);
	}

	/**
	 * ���б�ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public String generatedPublicTag(Map<String, Object> params){
		//��ǩ������
		FormGeneratedTagFactory factory = (FormGeneratedTagFactory) WebApplicationSupport.getBean("formGeneratedTagFactory");
		//��ǩ��������Ϣ
		StringBuffer tagString = new StringBuffer();
		//ȡ�ñ�����ͱ���ģʽ���еĺ�����ʾ����������ʾ��
		String model = (String) params.get(PARAMS_PIDDISPLAY);
		//ȡ�ñ�����ID
		String pidid = (String) params.get(PARAMS_PIDID);
		//������ȡ��
		String property = (String) params.get(PARAMS_PROPERTY);
		//��������ʹ��ģʽ
		String piduse = (String) params.get(PARAMS_PIDUSE);
		//����ȡ��
		Integer rowLength = (Integer)params.get(PARAMS_PIDROWS);
		//����Ȩ��ȡ��
		String pidaccess = (String) params.get(PARAMS_PIDACCESS);
		//��ǰ�к�ȡ��
		String rownumber = params.get(PARAMS_ROWNUMBER) == null ? "0" : params.get(PARAMS_ROWNUMBER).toString();
		//ȡ�ñ�����Ϣ
		Map<String, List<IG007Info>> columnInfoMap = (Map<String, List<IG007Info>>) params.get(PARAMS_TABLE_COLUMN_INFO);
		//��������ֵȡ��
		Map<String, Map<String, Map<String, String>>> tableColumnValueMap = (Map<String, Map<String, Map<String, String>>>) params.get(PARAMS_TABLE_FORM_COLUMN_VALUE);
		//ȡ�ñ�����ʾģʽ
		String titledisplay = (String) params.get(PARAMS_TITLE_DISPLAY);
		//������ȡ��
		String pidlabel = (String) params.get(PARAMS_PIDLABEL);
		//����������ʾģʽȡ��
		String pidhide = (String) params.get(PARAMS_PIDHIDE);
		//�����ʶȡ��
		String pidrequired = (String) params.get(PARAMS_PIDREQUIRED);
		//��������ȡ��
		Integer prid = (Integer) params.get(PARAMS_PRID);
		//��ǰ״̬����ȡ��
		String psdname = (String) params.get(PARAMS_PSDNAME);
		//�ܿ��ȡ��
		Integer containerWidth = params.get(PARAMS_PIDWIDTH) == null || "0".equals(params.get(PARAMS_PIDWIDTH)) ? null : Integer.valueOf(params.get(PARAMS_PIDWIDTH).toString());
		if(containerWidth == null){
			containerWidth = 820;
			if("T".equals(titledisplay) || "Y".equals(titledisplay)){
				containerWidth = 965;
			}
		}else{
			containerWidth -= 5;
		}
		//��ǰ������ֵ
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
			//ȡ�õ�ǰ��������Ϣ
			List<IG007Info> columnInfoList = columnInfoMap.get(pidid);
			if(columnInfoList != null){
				//������ʾ
				if("1".equals(model)){
					//ȡ����ʾ�кű�ʶ
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
					//divͷ��
					tagString.append("<div name=\"table_form_panel\" ");
					if(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE.equals(pidaccess)){
						tagString.append(" style=\"display:none;\">");
					}else if(sunWidth > containerWidth){
						tagString.append(" style=\"width:").append(containerWidth).append("px;overflow-x:scroll;overflow-y:hidden;margin-left:0px;\">");
					}else{
						tagString.append(" style=\"margin-left:0px;\">");
					}
					//���ͷ��
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
					//��������ʾͷ����ʾ
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
						//��ʼ������
						tagString.append("<tr name=\"titletr\">");
						if("Y".equals(showrownum)){
							tagString.append("<th style=\"width:40px;\">���</th>");
						}
						//��ʼ��������Ϣ
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
					//�ɱ��еĴ���ʽ
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
									//���������ֵ������ֵ����table
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
					//�̶��еĴ���ʽ
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
								//���������ֵ������ֵ����table
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
					//�ɱ�����ӿɱ�ģ��
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
					//������ʾ
				}else{
					String pidratio = (String) params.get(PARAMS_PIDRATIO);
					//ȡ���п�
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
					
					//divͷ��
					//���ر��Ĵ���ʽ
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
					//��������ʾͷ����ʾ
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
								//��������
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
									//���������ֵ������ֵ����table
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
							//��������
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
								//���������ֵ������ֵ����table
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
							//���ͷ��
							if("3".equals(params.get(PARAMS_SHOWLINE))){
								tagString.append("<table class=\"table_form2\" ");
							}else if("2".equals(params.get(PARAMS_SHOWLINE))){
								tagString.append("<table class=\"table_form1\" ");
							}else{
								tagString.append("<table class=\"table_form\" ");
							}
							tagString.append(" id=\"").append(pidid).append("_tableForm\">");
							//��������
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
								//���������ֵ������ֵ����table
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
					
					//����ģ��
					if("1".equals(piduse) && IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pidaccess) && (!rownumber.contains("_#_"))){
						//���ͷ��
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
						 * �б�ʶ
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
