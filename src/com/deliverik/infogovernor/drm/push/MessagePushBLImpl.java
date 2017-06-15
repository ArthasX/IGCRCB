/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.push;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.deliverik.framework.base.BLException;


/**
 * SCOKET 服务端消息句柄
 */
public class MessagePushBLImpl extends IoHandlerAdapter implements MessagePushBL {
	private final Log log = LogFactory.getLog(IoHandlerAdapter.class);  //日志文件
	
	/** flex安全策略文件取得 */
	private String getFlexXML(){
//		String ip = MINAServer.ip;
	    return "<?xml version='1.0'?> <cross-domain-policy> "
	            + "<site-control permitted-cross-domain-policies='all'/>"
	            + "<allow-access-from domain='*' to-ports='*'/>"
	            + "</cross-domain-policy>";
	}
	
	/***
	 * 消息管理器
	 */
	Map<String, IoSession> sessionMap = new HashMap<String, IoSession>();

	/**
	 * 监听创建连接
	 */
	@Override
    public void sessionOpened(IoSession session) {
		InetSocketAddress remoteAddress = (InetSocketAddress)session.getRemoteAddress();
		String clientIp = remoteAddress.getAddress().getHostAddress();
		log.info("SESSION ID ="+String.valueOf(session.getId()) +"  IP ="+clientIp);
//		session.write(getFlexXML() + "\0");
	}

	/**
	 * 接收来至客户端的消息
	 */
	@Override
	public void messageReceived(IoSession session, Object receiveMsg){
		if("#QUIT".equals(receiveMsg.toString())){
			
			delSession(session);
			return;
		}else if(receiveMsg.toString().startsWith("#FLEX_")){
			InetSocketAddress remoteAddress = (InetSocketAddress)session.getRemoteAddress();
			String clientIp = remoteAddress.getAddress().getHostAddress();
			String prid = receiveMsg.toString().split("_")[1];
			sessionMap.put(clientIp+"_"+session.getId()+"_"+prid, session);
			return;
		}else if(receiveMsg.toString().contains("<policy-file-request/>")){
			session.write(getFlexXML() + "\0");
			return;
		}else {
//		    //该种方法已经废弃
//		    Iterator<String> ite = sessionMap.keySet().iterator();
//			String target = JSONUtils.getValueForJSON(receiveMsg.toString(), "target"); //取得接收消息目标源
//			String sessionKey = "";
//			while(ite.hasNext()){
//				sessionKey = ite.next();
//				userSession = sessionMap.get(sessionKey);
//				if(sessionKey.startsWith(target+"_")){
//					userSession.write(receiveMsg.toString());
//				}
//			}
		}
	}

	private void delSession(IoSession session) {
		Iterator<String> ite = sessionMap.keySet().iterator();
		
		InetSocketAddress remoteAddress = (InetSocketAddress)session.getRemoteAddress();
		String clientIp = remoteAddress.getAddress().getHostAddress();
		String sessionKey = "";
		while(ite.hasNext()){
		    sessionKey = ite.next();
		    if(sessionKey.startsWith(clientIp+"_"+session.getId())){
		    	sessionMap.remove(sessionKey);
		    }
		}
		if(!session.isClosing())
		session.close(true);
		session = null;
	}

	/**
	 *异常出现时执行 
	 */
	@Override
    public void exceptionCaught(IoSession session, Throwable cause) {
		if(session!=null){
			delSession(session);
		}
		log.error("socket",cause);
    }
	
	/**
	 *连接关闭时执行 
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		delSession(session);
		super.sessionClosed(session);
	}

    /* 
     * <p>Title: pushMessage</p> 
     * <p>Description: </p> 
     * @param prid
     * @param message
     * @return
     * @throws BLException 
     * @see com.deliverik.plugin.message.server.MessagePushBL#pushMessage(java.lang.String, java.lang.String) 
     */
    public synchronized boolean pushMessage(String prid, String message) throws BLException {
    	message = message.replaceAll("\r\n", "<br/>").replaceAll("\n", "");
        log.debug("=prid=Message=============:"+prid+"----"+message);
        Iterator<String> ite = sessionMap.keySet().iterator();
        String sessionKey = "";
        IoSession userSession = null;
        boolean flag=false;
        while(ite.hasNext()){
            sessionKey = ite.next();
            userSession = sessionMap.get(sessionKey);
            if(sessionKey.endsWith("_"+prid)){
            	log.debug("推送消息>>>>>>>>>>>"+message);
                userSession.write(message+ "\0");
            }
            
            flag=true;
        }
        return flag;
    }
	
}
