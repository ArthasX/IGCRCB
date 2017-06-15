 /*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.room.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * @Description: java调用脚本工具类
 * 
 * @Author	yangyining;wangfeng;
 * @History 2013-05-29     新建 
 * @Version V1.0
 */
public class ExecScriptUtil {

    /** 成功 */
	public static final int RETURNVALUE_SUCCESS = 0;

    /** 失败 */
	public static final int RETURNVALUE_FILE = 1;

    /** 换行符 */
    private final String LINE_SEPARATOR = System.getProperty("line.separator");
    
    /** 执行后日志文件的目录 */
    private String execLogPath = "";
    
    /**
     * 执行升级所需的脚本
     * 
     * @param command	需要执行的命令
     * @return
     * @throws Exception
     */
    public int exec(String command) throws Exception {
        
        int successFlag = RETURNVALUE_SUCCESS;

        StringBuffer stringBuffer = new StringBuffer();
        
        // 缓冲字符流
        BufferedReader bufferedReader = null;
        try {
            
            appendMessage(stringBuffer, "准备执行Shell命令", command);

            // 进程信息
            Process process = null;
            // 命令
            String[] envp = {"/bin/sh", "-c", "export PATH=$PATH:/usr/local/swftools/bin/"};
            
            if ("\\".equals(File.separator)) {
            	envp = new String[]{"cmd", "/c"};
    		}
            
            // 执行Shell命令
            process = Runtime.getRuntime().exec(command, envp);
            
            // 判断进程是否存在
            if (process != null) {
                
                appendMessage(stringBuffer, "进程号：" + process.toString());
                
                // bufferedReader用于读取Shell的输出内容
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                
                // 等待子进程执行结束
                process.waitFor();
                
                appendMessage(stringBuffer, "Shell命令执行完毕\r\n执行结果为：");
                
                String line = null;
                // 读取Shell的输出内容，并添加到stringBuffer中
                while (bufferedReader != null && (line = bufferedReader.readLine()) != null) {
                    
                    appendMessage(stringBuffer, line);
                    
                    // 判断在脚本执行的过程中是否出现异常
                    if ("error".equals(line)) {
                        appendMessage(stringBuffer, "Shell脚本执行过程出现异常");
                        successFlag = RETURNVALUE_FILE;
                        break;
                    }
                }
            } else {
                appendMessage(stringBuffer, "没有pid");
                successFlag = RETURNVALUE_FILE;
            }
        } catch (Exception ioe) {
            appendMessage(stringBuffer, "执行Shell命令时发生异常：", ioe.getMessage());
            successFlag = RETURNVALUE_FILE;
        } finally {
            if (stringBuffer != null && StringUtils.isNotEmpty(execLogPath)) {
                
                OutputStreamWriter outputStreamWriter = null;
                try {
                    // 关闭缓冲流
                    if (null != bufferedReader) {
                        bufferedReader.close();
                    }
                    // 将Shell的执行情况追加到日志文件中
                    OutputStream outputStream = new FileOutputStream(execLogPath + File.separator + "exec.log", true);
                    outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    outputStreamWriter.write(stringBuffer.toString());

                } catch (Exception e) {
                    throw new Exception("输出日志文件异常", e);
                } finally {
                    if (null != outputStreamWriter) {
                        outputStreamWriter.close();
                    }
                }
            }
        }
        return successFlag;
    }
    
    /**
     * 拼写信息
     * 
     * @param stringBuffer	拼写目标
     * @param comment		拼写内容
     */
    private void appendMessage(StringBuffer stringBuffer, String... comment) {
    	
    	if (!"".equals(execLogPath)) {
    		
			stringBuffer.append(getDateTime()).append("  ");
			
			for (int i = 0; i < comment.length; i++) {
				
				if (comment[i] != null) {
					stringBuffer.append(comment[i]).append(LINE_SEPARATOR);
				}
			}
    	}
	}
    
    /**
     * 取得时间
     * 
     * @return datetime
     */
    private String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

	/**
	 * 执行后日志文件的目录取得
	 *
	 * @return execLogPath 执行后日志文件的目录
	 */
	public String getExecLogPath() {
		return execLogPath;
	}

	/**
	 * 执行后日志文件的目录设定
	 *
	 * @param execLogPath 执行后日志文件的目录
	 */
	public void setExecLogPath(String execLogPath) {
		this.execLogPath = execLogPath;
	}
}
