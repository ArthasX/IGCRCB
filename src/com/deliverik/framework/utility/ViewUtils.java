package com.deliverik.framework.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.LabelValueBean;

/**
 * .<br>
 * 
 * 
 * 
 * @author
 *
 */
public class ViewUtils {
	
	/**  */
	public static final String DIFF_MARK = "*";
	
	
	/**
	 * 
	 * 
	 * @param 
	 * @return
	 */
	public static List<LabelValueBean> getLabelValueBean(List<String[]> l){
		List<LabelValueBean> ret = new ArrayList<LabelValueBean>();
		if(l == null)
			return ret;
		
		//
		ret.add(new LabelValueBean("",""));
		String buf = "";
		for (String[] i : l) {
			String code = StringUtils.defaultString(i[0]);
			String name = StringUtils.defaultString(i[1]);
			//
			buf = StringUtils.defaultString(name, "").replaceAll("�@", "  ");
			// trim
			buf = StringUtils.trim(buf);
			//
			buf = code + "�F" + buf;
			ret.add(new LabelValueBean(buf, code));
		}
		return ret;
	}
	
	/**
	 * 
	 * 
	 * @param l 
	 * @param isMakeBlankRow
	 * @param isCodeLabel
	 * @return 
	 */
	public static List<LabelValueBean> getCodeLabelValueBean(
			List<LabelValueBean> l, boolean isMakeBlankRow, boolean isCodeLabel ){
		
		if(l==null || l.size() < 1)
			return null;
		
		List<LabelValueBean> ret = l;
		
		//
		//
		if(!isMakeBlankRow || !isCodeLabel){
			ret = new ArrayList<LabelValueBean>();

			for(LabelValueBean lbv : l)
				ret.add(new LabelValueBean(lbv.getLabel(), lbv.getValue()));
		}
		
		//
		if(!isMakeBlankRow){
			//
			if(ret.get(0).getValue().equals("") && ret.get(0).getLabel().equals(""))
				ret.remove(0);
		}
		
		//
		String buf = "";
		if(!isCodeLabel){
			for(LabelValueBean lbv : ret){
				buf = StringUtils.defaultString(lbv.getLabel(),"");
				buf = buf.replaceAll("^" + lbv.getValue() + "�F", "");
				lbv.setLabel(buf);
			}
		}
		
		return ret;
	}

	/**
	 * YYYYMMDD���ڸ�ʽת����YYYY/MM/DD��ʽ
	 * @param ymd ת��ǰ����
	 * @return ת��������
	 */
	public static String getFormatedDate(String ymd){

		return StringUtils.defaultString(ymd).replaceAll("(\\d{4})(\\d{2})(\\d{2}).*", "$1/$2/$3");	
	}
	
	/**
	 * YYYYMMDDHHmmss���ڸ�ʽת����YYYY/MM/DD HH:mm:ss��ʽ
	 * @param ymdt ת��ǰ����
	 * @return ת��������
	 */
	public static String getFormatedDateTime(String ymdt){

		return StringUtils.defaultString(ymdt).replaceAll("(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2}).*", "$1/$2/$3 $4:$5:$6");
	}
	

}
