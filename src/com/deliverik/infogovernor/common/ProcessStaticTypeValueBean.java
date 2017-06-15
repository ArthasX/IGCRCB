package com.deliverik.infogovernor.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;

public class ProcessStaticTypeValueBean {
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(ProcessDefineTypeValueBean.class);
	
	/** ϵͳ������Ϣ ���ڱ�������״̬ */
	private static Map<String, String> prtypeValueMap = new HashMap<String, String>();


	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private ProcessStaticTypeValueBean() {

	}

	/**
	 * <p>
	 * Discription:��ʼ������map
	 * </p>
	 * 
	 * @update duchong@deliverik.com
	 */
	public static void init(String pdid,String psdcode) {

		log.debug("�������������Զ�������״̬��ȡ�ÿ�ʼ������������");
		// ȡ����λϵͳ���ò���
		
		IGPRD01BL prdBL = (IGPRD01BL) WebApplicationSupport.getBean("igPRD01BL");
		String type_name = prdBL.getPsNameByPdidAndPsdidAction(pdid,psdcode);
		String key = String.valueOf(pdid)+"_"+psdcode;
		prtypeValueMap.put(key,type_name);

		log.debug("�������������Զ�������״̬��ȡ�ý���������������");

	}

	/**
	 * <p>
	 * Description: ��ȡ������Ϣ
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update duchong@deliverik.com
	 */
	public static String getConfigInfo(String pdid,String psdcode) {
		String key = String.valueOf(pdid)+"_"+psdcode;
		if (prtypeValueMap != null && !prtypeValueMap.isEmpty()) {
			if(prtypeValueMap.get(key)==null || "".equals(prtypeValueMap.get(key))){
				init(pdid,psdcode);
				return (String) prtypeValueMap.get(key);
			}else{
				return (String) prtypeValueMap.get(key);
			}
		}else{
			init(pdid,psdcode);
			return (String) prtypeValueMap.get(key);
		}

	}
	
}
