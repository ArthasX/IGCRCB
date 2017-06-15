package com.deliverik.infogovernor.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.dto.IGCOM05DTO;

/**
 * portal页通知内容显示
 *
 */
public class IGCOM05BLImpl extends BaseBLImpl implements IGCOM05BL {

	static Log log = LogFactory.getLog(IGCOM05BLImpl.class);

	/**
	 * 查询通知内容
	 *
	 * @param dto IGCOM03DTO
	 * @return IGCOM03DTO
	 */
	public IGCOM05DTO getNotice(IGCOM05DTO dto) throws BLException {
		
		String filepath = ResourceUtility.getString("NOTICE_FILE_PATH")+File.separator;
		
		File notice_file = new File(filepath);
		ArrayList<String> infolist = new ArrayList<String>();
		//判断该文件夹是否存在
		if(notice_file.exists()){
			File[] files=notice_file.listFiles(); 
			for(int i=0,j=files.length;i<j;i++){ 
				infolist.add(getFileInfo(files[i]));
			} 
		
		}
		dto.setContentList(infolist);
		
		return dto;
	}
	
	/**
	 * 读取文件内容
	 * @param file
	 * @return
	 * @throws BLException
	 */
	private String getFileInfo(File file) throws BLException {
		String info = "";
		StringBuffer buf = new StringBuffer();
		try{
			FileInputStream fis = new FileInputStream(file); 
			BufferedReader in = new BufferedReader(new InputStreamReader(fis)); 
			String strLine=null;
	      
	        while((strLine=in.readLine())!=null){
	            buf.append(strLine);
	        }
	        
	        in.close();
	        info = file.getName().split("\\.")[0]+" : "+buf.toString();
	        
		}catch(IOException e){
			log.debug(e.getMessage());
		}

		return info;
	}
	
//	/**
//	 * 写文件
//	 * @param file
//	 * @return
//	 * @throws BLException
//	 */
//	private void setIPToFile(String info) throws BLException {
//
//		String filepath = "c:"+File.separator+"visitorsIP.txt";
//		String datetime = IGStringUtils.getCurrentDateTime();
//		try{
//			FileWriter fw = new FileWriter(filepath);
//			String s = info + "----访问时间----"+datetime;
//			fw.write(s,0,s.length());
//			fw.flush();
//			fw.close();
//
//		}catch(IOException e){
//			log.debug(e.getMessage());
//		}
//
//	}
	
	
//	public static void main(String[] args) {
//
//		
//		try{
//			String filepath = "f:"+File.separator+"test";
//			
//			File file = new File(filepath);
//			ArrayList infolist = new ArrayList();
//			//判断该文件夹是否存在
//			if(file.exists()){
//				File[] files=file.listFiles(); 
//				for(int i=0,j=files.length;i<j;i++){ 
//					String info = "";
//					StringBuffer buf = new StringBuffer();
//					
//					FileInputStream fis = new FileInputStream(files[i]); 
//					BufferedReader in = new BufferedReader(new InputStreamReader(fis)); 
//					String strLine=null;
//			      
//			        while((strLine=in.readLine())!=null){
//			            buf.append(strLine);
//			        }
//			        
//			        in.close();
//			        info = files[i].getName()+" : "+buf.toString();
//					
//					infolist.add(info);
//				} 
//			
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
	
}
