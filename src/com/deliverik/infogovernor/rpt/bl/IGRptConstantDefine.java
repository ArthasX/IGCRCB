/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.bl;

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * ����:������س���
 * ��������:������س���
 * ������¼: ����ȫ 
 * �޸ļ�¼:
 */
public class IGRptConstantDefine {
	static Log log = LogFactory.getLog(IGRptConstantDefine.class);
	
	/**ͼƬĬ�Ͽ��*/
	public static Float SHAPEWIDTH=200F;
	/**ͼƬĬ�ϸ߶�*/
	public static Float SHAPEHEIGHT=200F;
	/**û���ҵ�·��*/
	public static String NOT_FIND_PATH_MSG="1";
	/**ͼƬû���ҵ�*/
	public static String NOT_ANOTHER_IMG_MSG="2";
	/**�ĵ���ʶǰ׺*/
	public static String WORD_FLAG_PREFIX="[SOC_";
	/**�ĵ���ʶ��׺*/
	public static String WORD_FLAG_SUFFIX="]";
	/**ģ��ӳ���ϵ��������*/
	public static String IS_USED="1";
	/**ģ��ӳ���ϵ����δ����*/
	public static String NOT_IS_USED="0";
	/**ģ��ʱ�������±�ʶ*/
	public static String TEM_TYPE_MONTH="0";
	/**ģ��ʱ�����ͼ���ʶ*/
	public static String TEM_TYPE_QUARTER="1";
	/**ģ��ʱ���������ʶ*/
	public static String TEM_TYPE_YEAR="2";
	/**wordͼƬλ��*/
	public static Integer SHAPE_IMG_LOCATION=1;
	//----------------------------����Ϊ��������---------------------------
	/**�洢DMX ESYSCODING */
	public static String STORAGE_ESYSCODING="999001009001";
	/**ҵ��ϵͳ ESYSCODING */
	public static String BUSINESS_ESYSCODING="999003001";
	/**���� ESYSCODING */
	public static String HOST_ESYSCODING="999001001";
	/**���� ESYSCODING */
	public static String VG_ESYSCODING="999001004";
	/**�ļ�ϵͳ ESYSCODING */
	public static String FS_ESYSCODING="999001016";
	/**vg��fs��ϵ�� */
	public static String VG_FS_CODE="242";
	
	/** ��������ͳ��*/
	public static String REPORT_TEMPLATE_PROCESSNUMBER="1";
	/** �ض���ͳ��*/
	public static String REPORT_TEMPLATE_SPECIFICFORM="2";
	/** ���α�ͳ��*/
	public static String REPORT_TEMPLATE_TREEFORM="3";
	/** ��Ա������ͳ��*/
	public static String REPORT_TEMPLATE_WORKLOAD="4";
	
	/**
	 * �÷����ȡ����ֵ
	 * @param fieldName ����ֵ
	 * @return
	 */
	public static String getValue(String fieldName){
		IGRptConstantDefine iGMntConstantDefine=new IGRptConstantDefine();
		String valueStr="";
		try{
			Field value=iGMntConstantDefine.getClass().getField(fieldName);
			 valueStr=(String) value.get(iGMntConstantDefine);
		}catch (Exception e) {
			log.error("========not find==="+fieldName+"========");
		}
		return valueStr;
	}
}
