package com.deliverik.infogovernor.nms.event;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ����: ����ɨ�������Ϣʵʱ����
 * ��������: ����ɨ�������Ϣʵʱ����
 * ������¼: 2013/12/20
 * �޸ļ�¼:
 */
public class IGNMS0101Pushlet {
	
    static Log log = LogFactory.getLog(IGNMS0101Pushlet.class);

	/** �¼���ʶ */
	public final static String eventID = "/Push_IGNMS0101";

	/**
	 * �������ݴ��� ҳ��ͨ����ȡ���������е�key��ȡ��Ӧֵ
	 * 
	 * @param param
	 *            ��������
	 */
	public synchronized static void pushData(Map<String, String> param) {
        log.debug("=========== �¼����Ϳ�ʼ ==========");
		// �����¼�
		Event event = Event.createDataEvent(eventID);
		if (param != null) {
			// ��װ������Ϣ
			for (String key : param.keySet()) {
			    String value = param.get(key);
			    if (StringUtils.isNotEmpty(value)) {
			        event.setField(key, toISO88591(param.get(key)));
			    }
			}
		}
		// ������/Push_IGNMS0101�����¼���������
		Dispatcher.getInstance().multicast(event);
        log.debug("=========== �¼����ͽ��� ==========");
	}

	/**
	 * ����ת��
	 * @param str ����
	 * @return ת��������
	 */
	public static String toISO88591(String str) {
		try {
			str = new String(str.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			log.error("ת�����", e);
			return "transcoding error";
		}
		return str;
	}
}
