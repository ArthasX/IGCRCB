/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.dev.qlb.igflow.generator.serialnum;

import java.util.HashMap;
import java.util.Map;

/**
 * ���̹����ŶԱȳ��� 
 *
 */
public final class IGPUBGENERATORType {

	/** ���̹�����ǰ׺��Ӧ���� */
	@SuppressWarnings("serial")
	public static final Map<String, String> SERIALNUM_MAP = new HashMap<String, String>(){
		{
			put("01100", "SF");//���񹤵�SF
			put("01183", "I");//�¼�ΪI
			put("01184", "P");//����ΪP
			put("01185", "C");//���ΪC
			put("01190", "WB");//���˹���ΪWB
			put("01200", "WA");//ָ�ɹ���ΪWA
			put("01260", "ME");//�����Ṥ��ME
			put("01380", "WS");//����֧��ΪWS
			put("01402", "WP");//��������ΪWP
			
		}
	};
}
