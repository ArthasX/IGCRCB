/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vcd.conn;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.vmware.vcloud.sdk.VcloudClient;
import com.vmware.vcloud.sdk.constants.Version;

/**
 * ����: vCloud���ӹ�����
 * ��������: vCloud���ӹ�����
 * ������¼:
 * �޸ļ�¼:
 */
public class VCDConnection {

    private static final Log log = LogFactory.getLog(VCDConnection.class);

    /** ��������� */
    private static final int MAX_CONS = 1;

    /** ��ʱ����*/
    private static final int SESSION_TIMEOUT = 30;

    /** ʵ�����ӿ�ʼʱ�� */
    private static Map<String, Date> map_lastLoggedIn = new HashMap<String, Date>();

    /** ʵ������ keyΪURL */
    private static Map<String, VcloudClient> map_client = new HashMap<String, VcloudClient>();

    /**
     * ����������Ϣ���ӵ�ָ����vCloud
     * ������ʵ����������URlΪkey�ļ�����
     * ��ʱ�����Զ��ر�
     * @param vcd01Info ������Ϣ
     * @throws Exception
     */
    private static void init(VCD01Info vcd01Info) throws Exception {
        final String url = vcd01Info.getVcurl();
        final String username = vcd01Info.getVcusername();
        final String password = vcd01Info.getVcpassword();
        VcloudClient.setLogLevel(Level.OFF);
        VcloudClient client = new VcloudClient(url, Version.V5_5);
        try {
            client.registerScheme("https", 443, FakeSSLSocketFactory.getInstance());
            client.login(username + "@system", password);
            client.setMaxConnections(MAX_CONS);
            client.setConnectionTimeout(SESSION_TIMEOUT * 60);
            map_client.put(url, client);//����ʵ��
            map_lastLoggedIn.put(url, new Date());//����ʵ�����ӿ�ʼʱ��
            log.debug("Logged IN against VCD instance:  " + username + " @ " + url);
        } catch (Exception e) {
            log.error(vcd01Info.getVcurl() + " connect error ", e);
        }
    }

    /**
     * ��ȡָ��vCloud����
     * @param vcd01Info ������Ϣ
     * @return ����ʵ��
     * @throws Exception
     */
    public synchronized static VcloudClient getClient(VCD01Info vcd01Info) throws Exception {
        if (map_lastLoggedIn.get(vcd01Info.getVcurl()) == null || sessionExpired(vcd01Info.getVcurl())) {
            // XXX use extendSession() here when possible.
            init(vcd01Info);
        }
        return map_client.get(vcd01Info.getVcurl());
    }

    /**
     * У�鳬ʱ
     * @param url key
     * @return �Ƿ�ʱ
     */
    private static boolean sessionExpired(String url) {
        Calendar now = Calendar.getInstance();
        return now.compareTo(getTimeout(url)) >= 0;
    }

    /**
     * ��ȡ����ʱ��
     * @param url key
     * @return ����ʱ��
     */
    private static Calendar getTimeout(String url) {
        Calendar timeout = Calendar.getInstance();
        timeout.setTime(map_lastLoggedIn.get(url));
        timeout.add(GregorianCalendar.MINUTE, SESSION_TIMEOUT);
        return timeout;
    }
}
