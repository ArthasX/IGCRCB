/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.push.util;

/***
 * ״̬��
 */
public interface CodeStatus {
	public static final int SOCKET_CONNECT_SUCCESS = 0;
	public static final int SOCKET_CONNECT_ERROR = 1;
	public static final String SOCKET_CONNECT_IP = "127.0.0.1";
	public static final int SOCKET_CONNECT_TIME_OUT = 1000*15;
	public static final int PUSH_NOTICE_SUCCESS = 0;
	public static final int PUSH_NOTICE_ERROR = 1;
}
