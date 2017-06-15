/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vcd.conn;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;

/**
 * Helper class to accept the self-signed certificates.
 */
/**
 * 概述: SSL连接工具类
 * 功能描述: 不需要提供签名文件即可连接
 * 创建记录:
 * 修改记录:
 */
public class FakeSSLSocketFactory {

	private FakeSSLSocketFactory() {
	}

	public static SSLSocketFactory getInstance() throws KeyManagementException,
			UnrecoverableKeyException, NoSuchAlgorithmException,
			KeyStoreException {
		return new SSLSocketFactory(new TrustStrategy() {
			public boolean isTrusted(final X509Certificate[] chain,
					final String auth) throws CertificateException {
				return true;
			}

		}, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	}
}
