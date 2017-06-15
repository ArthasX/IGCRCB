/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.push.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import nl.justobjects.pushlet.util.Log;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.drm.push.MessagePushBL;

public class MINAServer {
    private final org.apache.commons.logging.Log log = LogFactory.getLog(MINAServer.class);  //日志文件
	protected boolean serverStatus = false; //服务器状态 false = 未启动; true = 已启动;非sprint托管
	protected IoAcceptor ioAcceptor = null; //Socket管理
	public static String port;
	protected MessagePushBL messagePushBL; //接收器
	protected CodeListUtils codeListUtils;
	

    public void setCodeListUtils(CodeListUtils codeListUtils) {
        this.codeListUtils = codeListUtils;
    }

    public boolean isServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(boolean serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
    	MINAServer.port = port;
    }


    public IoAcceptor getIoAcceptor() {
        return ioAcceptor;
    }

    public void setIoAcceptor(IoAcceptor ioAcceptor) {
        this.ioAcceptor = ioAcceptor;
    }

    



    public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}

	/***
     * 初始化方法，spring自动调用
	 * 创建SOCKET 服务
	 * @return 0 = 创建成功,1 = 创建失败
	 */
	public void createSession(){
	    log.info("=========mina启动开始===========");
	    String portcc = codeListUtils.getCodeValue("174",null, null, "1");
	    
	    if(StringUtils.isNotBlank(portcc)){
	        port=portcc;
	    }
		ioAcceptor = new NioSocketAcceptor();
		ioAcceptor.getFilterChain().addLast("logger", new LoggingFilter() );
		TextLineCodecFactory lineCodec = new TextLineCodecFactory(Charset.forName("UTF-8"),LineDelimiter.NUL,LineDelimiter.NUL);
		lineCodec.setDecoderMaxLineLength(1024*1024);
		lineCodec.setEncoderMaxLineLength(1024*1024);
		ioAcceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(lineCodec));
		ioAcceptor.setHandler(messagePushBL); //设置数据流句柄
		ioAcceptor.getSessionConfig().setReadBufferSize(4096);
		try {
			ioAcceptor.bind(new InetSocketAddress(Integer.valueOf(port)));  //绑定端口
			serverStatus = true;
		} catch (IOException e) {
			serverStatus = false;
			Log.error("创建SOCKET失败, 端口号="+port,e);
		}
		log.info("=========mina启动完成 是否成功："+serverStatus+"===========");
	}
	
	
	/***
	 * 销毁方法
	 */
	public void destroy() {
		serverStatus = false;
		//销毁连接
		if(ioAcceptor!=null){
			ioAcceptor.unbind();
			ioAcceptor.dispose();
		}
	}
}
