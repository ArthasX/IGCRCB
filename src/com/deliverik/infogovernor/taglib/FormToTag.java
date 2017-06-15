/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ɱ�ǩ
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class FormToTag extends TagSupport{
	
	/** ��С */
	protected String size;
	
	/** �Զ�����ʽ */
	protected String style;
	
	/** ���� */
	protected String name;
	
	/** ���� */
	protected String property;
	
	/** ������ʽ */
	protected String styleClass;
	
	/** ����ѡֵ */
	protected String options;
	
	/** ������ */
	protected String piid;
	
	/** �������� */
	protected Integer prid;
	
	/** ״̬���� */
	protected String psdname;
	
	/** ��ֵ */
	protected String value;
	
	/** �û�ID */
	protected String userid;
	
	/** ������ */
	protected String orgid;
	
	/** ��ɫID */
	protected String roleid;
	
	/** ������ */
	protected String formType;
	
	/** ����Ȩ�� */
	protected String pidaccess;
	
	/** ��ģʽ */
	protected String pidmode;
	
	/** ���������� */
	protected String pidid;
	
	/** ��Ĭ��ֵ */
	protected String piddefault;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** �������ݶ���ID */
	protected String ccid;
	
	/** ������ */
	protected String pidlabel;
	
	/** �Ƿ���� */
	protected String pidrequired;
	
	/** �ı��򳤶� */
	protected String textAreaSize;
	
	/** �Ƿ�������� */
	protected String hasattach;
	
	/** ������ͱ�ģʽ */
	protected String piddisplay;
	
	/** �������п� */
	protected String pidwidth;
	
	/** ��������ʹ��ģʽ */
	protected String piduse;
	
	/** �������̶��е����� */
	protected Integer pidrows;
	
	/** ��ά���Ƿ���ʾ�к� */
	protected String showrownum;
	
	/** ����б��Ƿ���ʾ���� */
	protected String showline;
	
	/** ����λ */
	protected String pidunit;
	
	/** �Ƿ������ע */
	protected String remarks;
	
	/** ��ע */
	protected String pidcomment;
	
    /** ��ѡ/��ѡ��ʾ��ʽ */
    protected String showstyles;
    
    /** ��������ʾģʽ */
    protected String titledisplay;
    
    /** �����Ƿ����� */
    protected String pidhide;
    
    /** js���� */
    protected String jsfunction;
    
    /** ���α�ѡ���ʶ */
    protected String selecedlast;

    /** �������� */
    protected String numbertype;
    
    /** ���뷽ʽ */
    protected String align;
	
	/**
	 * ��Сȡ��
	 * @return ��С
	 */
	public String getSize() {
		return size;
	}

	/**
	 * �Զ�����ʽȡ��
	 * @return �Զ�����ʽ
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * ��С�趨
	 * @param size ��С
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * �Զ�����ʽ�趨
	 * @param style �Զ�����ʽ
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * �����趨
	 * @param ����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �����趨
	 * @return ����
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * ������ʽȡ��
	 * @return ������ʽ
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * ������ʽ�趨
	 * @param styleClass ������ʽ
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * ��ѡֵȡ��
	 * @return ��ѡֵ
	 */
	public String getOptions() {
		return options;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getPiid() {
		return piid;
	}

	/**
	 * ��ֵȡ��
	 * @return ��ֵ
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �������趨
	 * @return ������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * ��ѡֵ�趨
	 * @param options ��ѡֵ
	 */
	public void setOptions(String options) {
		this.options = options;
	}

	/**
	 * �������趨
	 * @param piid ������
	 */
	public void setPiid(String piid) {
		this.piid = piid;
	}

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬����ȡ��
	 * @return psdname ״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ״̬�����趨
	 * @param psdname ״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * ��ֵ�趨
	 * @param value ��ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * ������ȡ��
	 * @param orgid ������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ��ɫIDȡ��
	 * @param roleid ��ɫID
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getFormType() {
		return formType;
	}

	/**
	 * �������趨
	 * @param formType ������
	 */
	public void setFormType(String formType) {
		this.formType = formType;
	}
	
	/**
	 * ����Ȩ��ȡ��
	 * @return ����Ȩ��
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * ����Ȩ���趨
	 * @param pidaccess ����Ȩ��
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	/**
	 * ��ģʽȡ��
	 * @return ��ģʽ
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * ��ģʽ�趨
	 * @param pidmodel ��ģʽ
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * �����������趨
	 * @param pidid ����������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	/** ����Ȩ�޷�Χ */
	protected String privatescope;

	/**
	 * ����Ȩ�޷�Χȡ��
	 * @return ����Ȩ�޷�Χ
	 */
	public String getPrivatescope() {
		return privatescope;
	}

	/**
	 * ����Ȩ�޷�Χ�趨
	 * @param privatescope ����Ȩ�޷�Χ
	 */
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}
	
	/**
	 * ��Ĭ��ֵȡ��
	 * @return ��Ĭ��ֵ
	 */
	public String getPiddefault() {
		return piddefault;
	}

	/**
	 * ��Ĭ��ֵ�趨
	 * @param piddefault ��Ĭ��ֵ
	 */
	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}
	

	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * �������ݶ���IDȡ��
	 * @return �������ݶ���ID
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * �������ݶ���ID�趨
	 * @param ccid �������ݶ���ID
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * �������趨
	 * @param pidlabel ������
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}
	
	/**
	 * �Ƿ����ȡ��
	 * @return �Ƿ����
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * �Ƿ�����趨
	 * @param pidrequired �Ƿ����
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}
	
	/**
	 * �ı��򳤶�ȡ��
	 * @return �ı��򳤶�
	 */
	public String getTextAreaSize() {
		return textAreaSize;
	}

	/**
	 * �ı��򳤶��趨
	 * @param textAreaSize �ı��򳤶�
	 */
	public void setTextAreaSize(String textAreaSize) {
		this.textAreaSize = textAreaSize;
	}
	
	/**
	 * �Ƿ��������ȡ��
	 * @return �Ƿ��������
	 */
	public String getHasattach() {
		return hasattach;
	}

	/**
	 * �Ƿ���������趨
	 * @param hasattach �Ƿ��������
	 */
	public void setHasattach(String hasattach) {
		this.hasattach = hasattach;
	}

	/**
	 * ������ͱ�ģʽȡ��
	 * @return piddisplay ������ͱ�ģʽ
	 */
	public String getPiddisplay() {
		return piddisplay;
	}

	/**
	 * ������ͱ�ģʽ�趨
	 * @param piddisplay ������ͱ�ģʽ
	 */
	public void setPiddisplay(String piddisplay) {
		this.piddisplay = piddisplay;
	}

	/**
	 * �������п�ȡ��
	 * @return pidwidth �������п�
	 */
	public String getPidwidth() {
		return pidwidth;
	}

	/**
	 * �������п��趨
	 * @param pidwidth �������п�
	 */
	public void setPidwidth(String pidwidth) {
		this.pidwidth = pidwidth;
	}

	/**
	 * ��������ʹ��ģʽȡ��
	 * @return piduse ��������ʹ��ģʽ
	 */
	public String getPiduse() {
		return piduse;
	}

	/**
	 * ��������ʹ��ģʽ�趨
	 * @param piduse ��������ʹ��ģʽ
	 */
	public void setPiduse(String piduse) {
		this.piduse = piduse;
	}

	/**
	 * �������̶��е�����ȡ��
	 * @return pidrows �������̶��е�����
	 */
	public Integer getPidrows() {
		return pidrows;
	}

	/**
	 * �������̶��е������趨
	 * @param pidrows �������̶��е�����
	 */
	public void setPidrows(Integer pidrows) {
		this.pidrows = pidrows;
	}
	
	/**
	 * ��ά���Ƿ���ʾ�к�ȡ��
	 * @return showrownum ��ά���Ƿ���ʾ�к�
	 */
	public String getShowrownum() {
		return showrownum;
	}

	/**
	 * ��ά���Ƿ���ʾ�к��趨
	 * @param showrownum ��ά���Ƿ���ʾ�к�
	 */
	public void setShowrownum(String showrownum) {
		this.showrownum = showrownum;
	}	
	/**
	 *����λȡ��
	 */
	public String getPidunit() {
		return pidunit;
	}

	/**
	 *����λ����
	 */
	public void setPidunit(String pidunit) {
		this.pidunit = pidunit;
	}
	
	/**
	 *�Ƿ������עȡ��
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 *�Ƿ������ע����
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	/**
	 *��עȡ��
	 */
	public String getPidcomment() {
		return pidcomment;
	}

	/**
	 *��ע����
	 */
	public void setPidcomment(String pidcomment) {
		this.pidcomment = pidcomment;
	}

	/**
	 *��ѡ��ѡ��ʾ��ʽȡ��
	 */
	public String getShowstyles() {
		return showstyles;
	}

	/**
	 *��ѡ��ѡ��ʾ��ʽ�趨
	 */
	public void setShowstyles(String showstyles) {
		this.showstyles = showstyles;
	}

	/**
	 * ����б��Ƿ���ʾ����ȡ��
	 * @return showline ����б��Ƿ���ʾ����
	 */
	public String getShowline() {
		return showline;
	}

	/**
	 * ����б��Ƿ���ʾ�����趨
	 * @param showline ����б��Ƿ���ʾ����
	 */
	public void setShowline(String showline) {
		this.showline = showline;
	}

	/**
	 * ��������ʾģʽȡ��
	 * @return titledisplay ��������ʾģʽ
	 */
	public String getTitledisplay() {
		return titledisplay;
	}

	/**
	 * ��������ʾģʽ�趨
	 * @param titledisplay ��������ʾģʽ
	 */
	public void setTitledisplay(String titledisplay) {
		this.titledisplay = titledisplay;
	}
	
	/**
	 * �����Ƿ�����ȡ��
	 * @return pidhide �����Ƿ�����
	 */
	public String getPidhide() {
		return pidhide;
	}

	/**
	 * �����Ƿ������趨
	 * @param pidhide �����Ƿ�����
	 */
	public void setPidhide(String pidhide) {
		this.pidhide = pidhide;
	}

	/**
	 * js����ȡ��
	 * @return jsfunction js����
	 */
	public String getJsfunction() {
		return jsfunction;
	}

	/**
	 * js�����趨
	 * @param jsfunction js����
	 */
	public void setJsfunction(String jsfunction) {
		this.jsfunction = jsfunction;
	}

	/**
	 * ���α�ѡ���ʶȡ��
	 * @return selecedlast ���α�ѡ���ʶ
	 */
	public String getSelecedlast() {
		return selecedlast;
	}

	/**
	 * ���α�ѡ���ʶ�趨
	 * @param selecedlast ���α�ѡ���ʶ
	 */
	public void setSelecedlast(String selecedlast) {
		this.selecedlast = selecedlast;
	}

	/**
	 * ��������ȡ��
	 * @return numbertype ��������
	 */
	public String getNumbertype() {
		return numbertype;
	}

	/**
	 * ���������趨
	 * @param numbertype ��������
	 */
	public void setNumbertype(String numbertype) {
		this.numbertype = numbertype;
	}

	/**
	 * ���뷽ʽȡ��
	 * @return align ���뷽ʽ
	 */
	public String getAlign() {
		return align;
	}

	/**
	 * ���뷽ʽ�趨
	 * @param align ���뷽ʽ
	 */
	public void setAlign(String align) {
		this.align = align;
	}

	/**
	 * ��дdoStartTag��ʽ���ɱ�ǩ����
	 */
	public int doStartTag() throws JspException{
		//ȡ�ñ����ɶ��󹤳���
		FormGeneratedTagFactory factory = (FormGeneratedTagFactory) WebApplicationSupport.getBean("formGeneratedTagFactory");
		//���ɶ�Ӧ����
		Map<String, Object> params = null;
		try{
			params = getParams(this);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//��ǩ����ȡ��
		String tagString = factory.generatedTag(params);
		if(StringUtils.isNotEmpty(tagString)){
			TagUtils.getInstance().write(pageContext, tagString);
		}
		return SKIP_BODY;
	}
	
	/**
	 * ����ȡ��
	 * @return ����map
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> getParams(Object o) throws Exception{
		//��װ������map
		Map<String, Object> map = new HashMap<String, Object>();
		//ȡ�õ�ǰ������������Զ���
		Field[] fields = o.getClass().getDeclaredFields();
		if(fields!=null){
			for(Field field:fields){
				field.setAccessible(true);
				Object value = field.get(o);
				if(FormGeneratedTag.PARAMS_VALUE.equals(field.getName())){
					//���û�г�ʼֵ����ʾĬ��ֵ
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
		//��װ����
		IGPRR01021VO vo = (IGPRR01021VO) pageContext.getAttribute("IGPRR01021VO");
		if(vo==null){
			vo = (IGPRR01021VO) pageContext.getSession().getAttribute("IGPRR01021VO");
		}
		if(vo!=null){
			//ȡ���ı���ĸ�������map
			map.put(FormGeneratedTag.PARAMS_TEXTAREA_ATT_MAP, vo.getTextAreaMap());
			//ȡ�ñ���Ϣ
			map.put(FormGeneratedTag.PARAMS_PROCESSINFO_LIST, vo.getProcessInfolist());
			//ȡ���ʲ���Ϣ
			map.put(FormGeneratedTag.PARAMS_PROCESSINFO_ENTITY_LIST, vo.getProcessInfoEntityList());
			//�����������ʲ���Ϣ
			map.put(FormGeneratedTag.PARAMS_TABLE_FORM_ENTITY_INFO, vo.getPieMap());
			//�������и�����Ϣ
			map.put(FormGeneratedTag.PARAMS_TABLE_COLUMN_ATTACH_INFO, vo.getTableAttMap());
			//�������ֵ
			map.put(FormGeneratedTag.PARAMS_PROCESSINFO_FORM_VALUE_MAP, vo.getProcessInfoFormValueMap());
			//��Ա���ֵ
			map.put(FormGeneratedTag.PARAMS_PARTICIPANT_FORM_VALUE_MAP, vo.getParticipantFormValueMap());
		}
		//���ʽ���ж���
		Map<String , List<IG007Info>> columnInfoMap = (Map<String, List<IG007Info>>) pageContext.getSession().getAttribute("AD_columnInfoMap");
		map.put(FormGeneratedTag.PARAMS_TABLE_COLUMN_INFO, columnInfoMap);
		//���ʽ��ֵ
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
		/** ������Χ�����б� */
		List<LabelValueBean> processOrgSelectedOptions = (List<LabelValueBean>) pageContext.getAttribute("");
		if(processOrgSelectedOptions==null){
			processOrgSelectedOptions = (List<LabelValueBean>) pageContext.getSession().getAttribute("");
		}
		map.put(FormGeneratedTag.PARAMS_PROCESS_ORG_SELECTED_OPTIONS, processOrgSelectedOptions);
		//�Ƿ������սڵ� wyw ״̬��˽�б����ӣ����������սڵ��״̬��˽�б�������ʾ��table��չʾ
		if (vo != null && StringUtils.isNotEmpty(vo.getStatus())) {
			if ("C".equals(vo.getStatus()) || vo.getStatus().endsWith("002")) {
		        map.put("stuatsclose", "Y");
			}
		}
		//����ʱ���ã���ʽʱɾ��
//		map.put("stuatsclose", "Y");
		//��������սڵ㽫���սڵ��״̬��˽�б�����
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
