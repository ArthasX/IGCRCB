package com.deliverik.infogovernor.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;

public class PrjTypeValueBean {
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(PrjTypeValueBean.class);
	
	/** ϵͳ������Ϣ */
	private static Map<String, String> ptypeValueMap = new HashMap<String, String>();

	/** ���������ļ���ʶ */
	//private static boolean init = false;

	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private PrjTypeValueBean() {

	}

	/**
	 * <p>
	 * Discription:��ʼ������map
	 * </p>
	 * 
	 * @update duchong@deliverik.com
	 */
	public static void init(String key) {

		log.debug("��������������Ŀ����ʼ����ʼ������������");
		// ȡ����λϵͳ���ò���
		
		IGPRJ01BL prjBL = (IGPRJ01BL) WebApplicationSupport.getBean("igprj01BL");
		IGPRJ01DTO dto = new IGPRJ01DTO();
		dto.setPtype(key);
		dto = prjBL.findProjectTypeAction(dto);
		
		ptypeValueMap.put(key,dto.getPtype_name());

		//init = true;
		log.debug("��������������Ŀ����ʼ������������������");

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
	public static String getConfigInfo(String key) {
		if (ptypeValueMap != null && !ptypeValueMap.isEmpty()) {
			if(ptypeValueMap.get(key)==null || "".equals(ptypeValueMap.get(key))){
				init(key);
				return (String) ptypeValueMap.get(key);
			}else{
				return (String) ptypeValueMap.get(key);
			}
		}else{
			init(key);
			return (String) ptypeValueMap.get(key);
		}

	}

}
