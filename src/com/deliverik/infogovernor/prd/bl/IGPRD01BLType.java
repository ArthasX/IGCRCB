/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.bl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶�����س�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD01BLType {

	/**
	 * ȡ�����̲�ѯĬ����ʾ��
	 * @return ���̲�ѯĬ����ʾ��
	 */
	public static Map<String, String> getDefaultShowColumn(){
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("pr#prserialnum#������", "������");
		map.put("pr#prtitle#����", "����");
		map.put("pr#prdesc#����", "����");
		map.put("pr#prusername#������", "������");
		map.put("pr#prstatus#״̬", "״̬");
		map.put("pr#propentime#����ʱ��", "����ʱ��");
		map.put("pr#prclosetime#�ر�ʱ��", "�ر�ʱ��");
		map.put("pp#ppusername#������", "������");
		return map;
	}
}
