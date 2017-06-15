/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.util;

import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �̶��ı�����ǩ������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LabelFormGeneratedTagImpl extends FormGeneratedTagImpl{
	
	/**
	 * ������������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params){
		return generatedPublicTableColumn(params);
	}
	
	/**
	 * ������ֻ��������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params){
		return generatedPublicTableColumn(params);
	}

	/**
	 * ������������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicTableColumn(Map<String, Object> params){
		//����������ȡ��
		String pidid = (String) params.get(PARAMS_PIDID);
		//�к�ȡ��
		String rownum = (String) params.get(PARAMS_ROWNUMBER);
		//��ѡֵȡ��
		String[] options = null;
		if(params.get(PARAMS_OPTIONS)!=null){
			options = params.get(PARAMS_OPTIONS).toString().split("#");
		}
		//ֵȡ��
		String value = "";
		if(rownum != null){
			if(!"_#_".equals(rownum)){
				
				int index =0;
				if(rownum.indexOf("_")> -1){
					index = Integer.parseInt(rownum.substring(rownum.lastIndexOf("_") + 1));
				}else{
					index = Integer.parseInt(rownum);
				}
				if(options != null){
					if(options.length >= index){
						value = options[index-1];
					}
				}
			}
		}
		//�����ɱ�ǩ�ַ���
		StringBuffer tagString = new StringBuffer(value);
		tagString.append("<input type=\"hidden\" id=\"").append(pidid).append("_").append(rownum).append("\" rownumber=\"").append(rownum).append("\" name=\"column_value\" value='").append(value).append("'/>");
		tagString.append("<input type=\"hidden\" name=\"column_pidid\" value=\"").append(pidid).append("\" />");
		tagString.append("<input type=\"hidden\" name=\"column_rownumber\" value=\"").append(rownum).append("\" />");
		return tagString.toString();
	}
}
