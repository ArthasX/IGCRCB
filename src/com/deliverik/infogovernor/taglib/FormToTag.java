/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.infogovernor.prr.form.IGPRR0101Form;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01021VO;
import com.deliverik.infogovernor.taglib.util.FormGeneratedTag;
import com.deliverik.infogovernor.taglib.util.FormGeneratedTagFactory;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表单生成标签
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class FormToTag extends TagSupport{
	
	/** 大小 */
	protected String size;
	
	/** 自定义样式 */
	protected String style;
	
	/** 名称 */
	protected String name;
	
	/** 属性 */
	protected String property;
	
	/** 引用样式 */
	protected String styleClass;
	
	/** 表单备选值 */
	protected String options;
	
	/** 表单主键 */
	protected String piid;
	
	/** 流程主键 */
	protected Integer prid;
	
	/** 状态名称 */
	protected String psdname;
	
	/** 表单值 */
	protected String value;
	
	/** 用户ID */
	protected String userid;
	
	/** 机构码 */
	protected String orgid;
	
	/** 角色ID */
	protected String roleid;
	
	/** 表单类型 */
	protected String formType;
	
	/** 访问权限 */
	protected String pidaccess;
	
	/** 表单模式 */
	protected String pidmode;
	
	/** 表单定义主键 */
	protected String pidid;
	
	/** 表单默认值 */
	protected String piddefault;
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 基础数据定义ID */
	protected String ccid;
	
	/** 表单名称 */
	protected String pidlabel;
	
	/** 是否必填 */
	protected String pidrequired;
	
	/** 文本域长度 */
	protected String textAreaSize;
	
	/** 是否包含附件 */
	protected String hasattach;
	
	/** 表格类型表单模式 */
	protected String piddisplay;
	
	/** 表格类表单列宽 */
	protected String pidwidth;
	
	/** 表格类表单的使用模式 */
	protected String piduse;
	
	/** 表格类表单固定行的行数 */
	protected Integer pidrows;
	
	/** 二维表是否显示行号 */
	protected String showrownum;
	
	/** 表格列表单是否显示边线 */
	protected String showline;
	
	/** 表单单位 */
	protected String pidunit;
	
	/** 是否包含备注 */
	protected String remarks;
	
	/** 备注 */
	protected String pidcomment;
	
    /** 单选/复选显示方式 */
    protected String showstyles;
    
    /** 表单标题显示模式 */
    protected String titledisplay;
    
    /** 表单名是否隐藏 */
    protected String pidhide;
    
    /** js方法 */
    protected String jsfunction;
    
    /** 树形表单选择标识 */
    protected String selecedlast;

    /** 数字类型 */
    protected String numbertype;
    
    /** 对齐方式 */
    protected String align;
	
	/**
	 * 大小取得
	 * @return 大小
	 */
	public String getSize() {
		return size;
	}

	/**
	 * 自定义样式取得
	 * @return 自定义样式
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * 大小设定
	 * @param size 大小
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * 自定义样式设定
	 * @param style 自定义样式
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	
	/**
	 * 名称取得
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 属性取得
	 * @return 属性
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * 名称设定
	 * @param 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 属性设定
	 * @return 属性
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * 引用样式取得
	 * @return 引用样式
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * 引用样式设定
	 * @param styleClass 引用样式
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * 备选值取得
	 * @return 备选值
	 */
	public String getOptions() {
		return options;
	}

	/**
	 * 表单主键取得
	 * @return 表单主键
	 */
	public String getPiid() {
		return piid;
	}

	/**
	 * 表单值取得
	 * @return 表单值
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 机构码设定
	 * @return 机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * 备选值设定
	 * @param options 备选值
	 */
	public void setOptions(String options) {
		this.options = options;
	}

	/**
	 * 表单主键设定
	 * @param piid 表单主键
	 */
	public void setPiid(String piid) {
		this.piid = piid;
	}

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态名称取得
	 * @return psdname 状态名称
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 状态名称设定
	 * @param psdname 状态名称
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * 表单值设定
	 * @param value 表单值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 机构码取得
	 * @param orgid 机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 角色ID取得
	 * @param roleid 角色ID
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * 表单类型取得
	 * @return 表单类型
	 */
	public String getFormType() {
		return formType;
	}

	/**
	 * 表单类型设定
	 * @param formType 表单类型
	 */
	public void setFormType(String formType) {
		this.formType = formType;
	}
	
	/**
	 * 访问权限取得
	 * @return 访问权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * 访问权限设定
	 * @param pidaccess 访问权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	/**
	 * 表单模式取得
	 * @return 表单模式
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * 表单模式设定
	 * @param pidmodel 表单模式
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}
	
	/**
	 * 表单定义主键取得
	 * @return 表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义主键设定
	 * @param pidid 表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	/** 表单的权限范围 */
	protected String privatescope;

	/**
	 * 表单的权限范围取得
	 * @return 表单的权限范围
	 */
	public String getPrivatescope() {
		return privatescope;
	}

	/**
	 * 表单的权限范围设定
	 * @param privatescope 表单的权限范围
	 */
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}
	
	/**
	 * 表单默认值取得
	 * @return 表单默认值
	 */
	public String getPiddefault() {
		return piddefault;
	}

	/**
	 * 表单默认值设定
	 * @param piddefault 表单默认值
	 */
	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}
	

	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * 基础数据定义ID取得
	 * @return 基础数据定义ID
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 基础数据定义ID设定
	 * @param ccid 基础数据定义ID
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}
	
	/**
	 * 表单名称取得
	 * @return 表单名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 表单名称设定
	 * @param pidlabel 表单名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}
	
	/**
	 * 是否必填取得
	 * @return 是否必填
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 是否必填设定
	 * @param pidrequired 是否必填
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}
	
	/**
	 * 文本域长度取得
	 * @return 文本域长度
	 */
	public String getTextAreaSize() {
		return textAreaSize;
	}

	/**
	 * 文本域长度设定
	 * @param textAreaSize 文本域长度
	 */
	public void setTextAreaSize(String textAreaSize) {
		this.textAreaSize = textAreaSize;
	}
	
	/**
	 * 是否包含附件取得
	 * @return 是否包含附件
	 */
	public String getHasattach() {
		return hasattach;
	}

	/**
	 * 是否包含附件设定
	 * @param hasattach 是否包含附件
	 */
	public void setHasattach(String hasattach) {
		this.hasattach = hasattach;
	}

	/**
	 * 表格类型表单模式取得
	 * @return piddisplay 表格类型表单模式
	 */
	public String getPiddisplay() {
		return piddisplay;
	}

	/**
	 * 表格类型表单模式设定
	 * @param piddisplay 表格类型表单模式
	 */
	public void setPiddisplay(String piddisplay) {
		this.piddisplay = piddisplay;
	}

	/**
	 * 表格类表单列宽取得
	 * @return pidwidth 表格类表单列宽
	 */
	public String getPidwidth() {
		return pidwidth;
	}

	/**
	 * 表格类表单列宽设定
	 * @param pidwidth 表格类表单列宽
	 */
	public void setPidwidth(String pidwidth) {
		this.pidwidth = pidwidth;
	}

	/**
	 * 表格类表单的使用模式取得
	 * @return piduse 表格类表单的使用模式
	 */
	public String getPiduse() {
		return piduse;
	}

	/**
	 * 表格类表单的使用模式设定
	 * @param piduse 表格类表单的使用模式
	 */
	public void setPiduse(String piduse) {
		this.piduse = piduse;
	}

	/**
	 * 表格类表单固定行的行数取得
	 * @return pidrows 表格类表单固定行的行数
	 */
	public Integer getPidrows() {
		return pidrows;
	}

	/**
	 * 表格类表单固定行的行数设定
	 * @param pidrows 表格类表单固定行的行数
	 */
	public void setPidrows(Integer pidrows) {
		this.pidrows = pidrows;
	}
	
	/**
	 * 二维表是否显示行号取得
	 * @return showrownum 二维表是否显示行号
	 */
	public String getShowrownum() {
		return showrownum;
	}

	/**
	 * 二维表是否显示行号设定
	 * @param showrownum 二维表是否显示行号
	 */
	public void setShowrownum(String showrownum) {
		this.showrownum = showrownum;
	}	
	/**
	 *表单单位取得
	 */
	public String getPidunit() {
		return pidunit;
	}

	/**
	 *表单单位设置
	 */
	public void setPidunit(String pidunit) {
		this.pidunit = pidunit;
	}
	
	/**
	 *是否包含备注取得
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 *是否包含备注设置
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	/**
	 *备注取得
	 */
	public String getPidcomment() {
		return pidcomment;
	}

	/**
	 *备注设置
	 */
	public void setPidcomment(String pidcomment) {
		this.pidcomment = pidcomment;
	}

	/**
	 *单选复选显示方式取得
	 */
	public String getShowstyles() {
		return showstyles;
	}

	/**
	 *单选复选显示方式设定
	 */
	public void setShowstyles(String showstyles) {
		this.showstyles = showstyles;
	}

	/**
	 * 表格列表单是否显示边线取得
	 * @return showline 表格列表单是否显示边线
	 */
	public String getShowline() {
		return showline;
	}

	/**
	 * 表格列表单是否显示边线设定
	 * @param showline 表格列表单是否显示边线
	 */
	public void setShowline(String showline) {
		this.showline = showline;
	}

	/**
	 * 表单标题显示模式取得
	 * @return titledisplay 表单标题显示模式
	 */
	public String getTitledisplay() {
		return titledisplay;
	}

	/**
	 * 表单标题显示模式设定
	 * @param titledisplay 表单标题显示模式
	 */
	public void setTitledisplay(String titledisplay) {
		this.titledisplay = titledisplay;
	}
	
	/**
	 * 表单名是否隐藏取得
	 * @return pidhide 表单名是否隐藏
	 */
	public String getPidhide() {
		return pidhide;
	}

	/**
	 * 表单名是否隐藏设定
	 * @param pidhide 表单名是否隐藏
	 */
	public void setPidhide(String pidhide) {
		this.pidhide = pidhide;
	}

	/**
	 * js方法取得
	 * @return jsfunction js方法
	 */
	public String getJsfunction() {
		return jsfunction;
	}

	/**
	 * js方法设定
	 * @param jsfunction js方法
	 */
	public void setJsfunction(String jsfunction) {
		this.jsfunction = jsfunction;
	}

	/**
	 * 树形表单选择标识取得
	 * @return selecedlast 树形表单选择标识
	 */
	public String getSelecedlast() {
		return selecedlast;
	}

	/**
	 * 树形表单选择标识设定
	 * @param selecedlast 树形表单选择标识
	 */
	public void setSelecedlast(String selecedlast) {
		this.selecedlast = selecedlast;
	}

	/**
	 * 数字类型取得
	 * @return numbertype 数字类型
	 */
	public String getNumbertype() {
		return numbertype;
	}

	/**
	 * 数字类型设定
	 * @param numbertype 数字类型
	 */
	public void setNumbertype(String numbertype) {
		this.numbertype = numbertype;
	}

	/**
	 * 对齐方式取得
	 * @return align 对齐方式
	 */
	public String getAlign() {
		return align;
	}

	/**
	 * 对齐方式设定
	 * @param align 对齐方式
	 */
	public void setAlign(String align) {
		this.align = align;
	}

	/**
	 * 重写doStartTag方式生成标签内容
	 */
	public int doStartTag() throws JspException{
		//取得表单生成对象工厂类
		FormGeneratedTagFactory factory = (FormGeneratedTagFactory) WebApplicationSupport.getBean("formGeneratedTagFactory");
		//生成对应参数
		Map<String, Object> params = null;
		try{
			params = getParams(this);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//标签内容取得
		String tagString = factory.generatedTag(params);
		if(StringUtils.isNotEmpty(tagString)){
			TagUtils.getInstance().write(pageContext, tagString);
		}
		return SKIP_BODY;
	}
	
	/**
	 * 参数取得
	 * @return 参数map
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> getParams(Object o) throws Exception{
		//封装参数的map
		Map<String, Object> map = new HashMap<String, Object>();
		//取得当前对象的所有属性定义
		Field[] fields = o.getClass().getDeclaredFields();
		if(fields!=null){
			for(Field field:fields){
				field.setAccessible(true);
				Object value = field.get(o);
				if(FormGeneratedTag.PARAMS_VALUE.equals(field.getName())){
					//如果没有初始值，显示默认值
					if(StringUtils.isNotEmpty(piddefault)){
						if(value==null||StringUtils.isEmpty(value.toString())){
							value = piddefault;
						}
					}
					if(StringUtils.isNotEmpty(name)){
						Object obj = pageContext.getSession().getAttribute(name);
						if(obj!=null){
							String fieldName = property.indexOf("[")>-1?property.substring(0,property.indexOf("[")):property;
							Integer index = Integer.valueOf(property.substring(property.indexOf("[")+1,property.indexOf("]")));
							Field propertyField = obj.getClass().getDeclaredField(fieldName);
							Field typeField = obj.getClass().getDeclaredField("pivartype");
							propertyField.setAccessible(true);
							typeField.setAccessible(true);
							String[] strs = (String[]) propertyField.get(obj);
							String[] types = (String[]) typeField.get(obj);
							if(strs!=null&&strs.length>index && types != null && types.length > index){
								if(StringUtils.isNotEmpty(strs[index]) && !"4".equals(types[index]) && !"5".equals(types[index]) && !"P".equals(types[index])){
									value = strs[index];
								}
							}
						}
					}
					map.put(field.getName(), value);
				}else{
					map.put(field.getName(), value);
				}
			}
		}
		//封装对象
		IGPRR01021VO vo = (IGPRR01021VO) pageContext.getAttribute("IGPRR01021VO");
		if(vo==null){
			vo = (IGPRR01021VO) pageContext.getSession().getAttribute("IGPRR01021VO");
		}
		if(vo!=null){
			//取得文本域的附件集合map
			map.put(FormGeneratedTag.PARAMS_TEXTAREA_ATT_MAP, vo.getTextAreaMap());
			//取得表单信息
			map.put(FormGeneratedTag.PARAMS_PROCESSINFO_LIST, vo.getProcessInfolist());
			//取得资产信息
			map.put(FormGeneratedTag.PARAMS_PROCESSINFO_ENTITY_LIST, vo.getProcessInfoEntityList());
			//表格类表单关联资产信息
			map.put(FormGeneratedTag.PARAMS_TABLE_FORM_ENTITY_INFO, vo.getPieMap());
			//表格类表单列附件信息
			map.put(FormGeneratedTag.PARAMS_TABLE_COLUMN_ATTACH_INFO, vo.getTableAttMap());
			//流程类表单值
			map.put(FormGeneratedTag.PARAMS_PROCESSINFO_FORM_VALUE_MAP, vo.getProcessInfoFormValueMap());
			//人员类表单值
			map.put(FormGeneratedTag.PARAMS_PARTICIPANT_FORM_VALUE_MAP, vo.getParticipantFormValueMap());
		}
		//表格式表单列定义
		Map<String , List<IG007Info>> columnInfoMap = (Map<String, List<IG007Info>>) pageContext.getSession().getAttribute("AD_columnInfoMap");
		map.put(FormGeneratedTag.PARAMS_TABLE_COLUMN_INFO, columnInfoMap);
		//表格式表单值
		Map<String, Map<String, Map<String, String>>> tableColumnValueMap = (Map<String, Map<String, Map<String, String>>>) pageContext.getSession().getAttribute("AD_tableColumnValueMap");
		map.put(FormGeneratedTag.PARAMS_TABLE_FORM_COLUMN_VALUE, tableColumnValueMap);
		if(columnInfoMap != null){
			String[] column_pidid = null;
			String[] column_rownum = null;
			String[] column_value = null;
			if("IGPRR0102Form".equals(name)){
				IGPRR0102Form igprr0102form = (IGPRR0102Form) pageContext.getSession().getAttribute("IGPRR0102Form");
				if(igprr0102form != null){
					column_pidid = igprr0102form.getColumn_pidid();
					column_rownum = igprr0102form.getColumn_rownumber();
					column_value = igprr0102form.getColumn_value();
				}
			}else if("IGPRR0101Form".equals(name)){
				IGPRR0101Form igprr0101form = (IGPRR0101Form) pageContext.getSession().getAttribute("IGPRR0101Form");
				if(igprr0101form != null){
					column_pidid = igprr0101form.getColumn_pidid();
					column_rownum = igprr0101form.getColumn_rownumber();
					column_value = igprr0101form.getColumn_value();
				}
			}
			if(column_value != null && column_value.length > 0){
				Map<String, List<IG898Info>> valueMap = new HashMap<String, List<IG898Info>>();
				if(column_value != null && column_value.length > 0){
					List<IG898Info> ls_ig898Info = new ArrayList<IG898Info>();
					for(int i=0;i<column_value.length;i++){
						IG898TB ig898TB = new IG898TB();
						ig898TB.setPvrownumber(column_rownum[i]);
						ig898TB.setPvcolpidid(column_pidid[i]);
						ig898TB.setPvalue(column_value[i]);
						ls_ig898Info.add(ig898TB);
					}
					for(IG898Info ig898:ls_ig898Info){
						if(valueMap.get(ig898.getPvcolpidid()) == null){
							List<IG898Info> temp = new ArrayList<IG898Info>();
							temp.add(ig898);
							valueMap.put(ig898.getPvcolpidid(), temp);
						}else{
							valueMap.get(ig898.getPvcolpidid()).add(ig898);
						}
					}
				}
				Map<String, Map<String, Map<String, String>>> formValueMap = new HashMap<String, Map<String,Map<String,String>>>();
				Set<Entry<String, List<IG007Info>>> set = columnInfoMap.entrySet();
				for(Iterator<Entry<String, List<IG007Info>>> iter = set.iterator();iter.hasNext();){
					Entry<String, List<IG007Info>> entry = iter.next();
					String pidid = entry.getKey();
					List<IG007Info> list = entry.getValue();
					Map<String, Map<String, String>> tempValueMap = new LinkedHashMap<String, Map<String,String>>();
					for(IG007Info pid:list){
						List<IG898Info> ig898List = valueMap.get(pid.getPidid());
						if(ig898List != null){
							for(IG898Info ig898info:ig898List){
								if(tempValueMap.get(ig898info.getPvrownumber()) == null){
									Map<String, String> temp = new HashMap<String, String>();
									temp.put(ig898info.getPvcolpidid(), ig898info.getPvalue());
									tempValueMap.put(ig898info.getPvrownumber(), temp);
								}else{
									tempValueMap.get(ig898info.getPvrownumber()).put(ig898info.getPvcolpidid(), ig898info.getPvalue());
								}
							}
						}
					}
					formValueMap.put(pidid, tempValueMap);
				}
				map.put(FormGeneratedTag.PARAMS_TABLE_FORM_COLUMN_VALUE, formValueMap);
			}
		}
		/** 机构范围下拉列表 */
		List<LabelValueBean> processOrgSelectedOptions = (List<LabelValueBean>) pageContext.getAttribute("");
		if(processOrgSelectedOptions==null){
			processOrgSelectedOptions = (List<LabelValueBean>) pageContext.getSession().getAttribute("");
		}
		map.put(FormGeneratedTag.PARAMS_PROCESS_ORG_SELECTED_OPTIONS, processOrgSelectedOptions);
		//是否是最终节点 wyw 状态级私有表单增加，用于在最终节点的状态级私有表单特殊显示；table的展示
		if (vo != null && StringUtils.isNotEmpty(vo.getStatus())) {
			if ("C".equals(vo.getStatus()) || vo.getStatus().endsWith("002")) {
		        map.put("stuatsclose", "Y");
			}
		}
		//测试时候用，正式时删除
//		map.put("stuatsclose", "Y");
		//如果是最终节点将最终节点的状态级私有表单存入
		Map<String,List<IG561VWInfo>> statusclosedetails = (Map<String,List<IG561VWInfo>>) pageContext.getRequest().getAttribute("StatusCloseDetails");
		if(statusclosedetails==null||statusclosedetails.size()==0){
		    statusclosedetails=(Map<String,List<IG561VWInfo>>) pageContext.getSession().getAttribute("StatusCloseDetails");
		}
		if(statusclosedetails!=null&&statusclosedetails.size()>0){
		    map.put(FormGeneratedTag.PARAMS_STATUS_CLOSE, statusclosedetails);
		}
		return map;
	}
}
