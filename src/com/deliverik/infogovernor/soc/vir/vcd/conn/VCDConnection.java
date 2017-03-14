/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 概述: vCloud连接工具类
 * 功能描述: vCloud连接工具类
 * 创建记录:
 * 修改记录:
 */
public class VCDConnection {

    private static final Log log = LogFactory.getLog(VCDConnection.class);

    /** 最大连接数 */
    private static final int MAX_CONS = 1;

    /** 超时分钟*/
    private static final int SESSION_TIMEOUT = 30;

    /** 实例连接开始时间 */
    private static Map<String, Date> map_lastLoggedIn = new HashMap<String, Date>();

    /** 实例集合 key为URL */
    private static Map<String, VcloudClient> map_client = new HashMap<String, VcloudClient>();

    /**
     * 根据配置信息连接到指定的vCloud
     * 将连接实例保存至以URl为key的集合中
     * 超时连接自动关闭
     * @param vcd01Info 配置信息
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
            map_client.put(url, client);//保存实例
            map_lastLoggedIn.put(url, new Date());//保存实例连接开始时间
            log.debug("Logged IN against VCD instance:  " + username + " @ " + url);
        } catch (Exception e) {
            log.error(vcd01Info.getVcurl() + " connect error ", e);
        }
    }

    /**
     * 获取指定vCloud连接
     * @param vcd01Info 配置信息
     * @return 连接实例
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
     * 校验超时
     * @param url key
     * @return 是否超时
     */
    private static boolean sessionExpired(String url) {
        Calendar now = Calendar.getInstance();
        return now.compareTo(getTimeout(url)) >= 0;
    }

    /**
     * 获取连接时长
     * @param url key
     * @return 连接时长
     */
    private static Calendar getTimeout(String url) {
        Calendar timeout = Calendar.getInstance();
        timeout.setTime(map_lastLoggedIn.get(url));
        timeout.add(GregorianCalendar.MINUTE, SESSION_TIMEOUT);
        return timeout;
    }
}
