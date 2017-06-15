package com.deliverik.infogovernor.xls.prj.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.html.ExportHtml;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.vo.IGPRJ01HistoryVO;
import com.deliverik.infogovernor.xls.prj.dto.IGPRJ0108ExcelDTO;

public class IGPRJ0108ExcelBLImpl extends ExcelBaseBLImpl implements IGPRJ0108ExcelBL  {


	public ExcelDTO initHeader(ExcelDTO excelDto) throws BLException {
		return excelDto;
	}


	public ExcelDTO initBody(ExcelDTO excelDto) throws BLException {
		//项目日志统计
		IGPRJ0108ExcelDTO dto = (IGPRJ0108ExcelDTO)excelDto;
		dto.setStartRow(2);
		IGPRJ01HistoryVO[] historyVOs = (IGPRJ01HistoryVO[])dto.getHistoryVOs();
		
		if (null != historyVOs) {
			int k = 0;
			for (int i = 0; i < historyVOs.length; i++) {
				String fileName = null;
				String fname = null;
				int j = 1;
				IGPRJ01HistoryVO historyVO = historyVOs[i];
				ProjectLog projectLog = historyVO.getProjectLog();
				List<Attachment> attachmentList = historyVO.getAttachmentList();
				List<CodeDetail> codeDetailList = dto.getCodeDetailList();
				if(StringUtils.isNotEmpty(projectLog.getPluserid())&&StringUtils.isNotEmpty(projectLog.getPlusername())){
					//时间
					addCell(j, k, projectLog.getPltime());
					j++;
					//操作人
					addCell(j, k, projectLog.getPlusername());
					j++;
					//日志类别
					if(StringUtils.isNotEmpty(projectLog.getPltype())){						
						for (CodeDetail cd : codeDetailList) {
							if(projectLog.getPltype().equals(cd.getCid())){
								addCell(j, k, cd.getCvalue());
								j++;
								break;
							}
						}
					}else{
						addCell(j, k, "");
						j++;
					}
					//内容
					if(StringUtils.isNotEmpty(projectLog.getPlinfo())){					
						addCell(j, k, projectLog.getPlinfo());
						j++;
					}
					//附件
					if (null != attachmentList) {
						for (Attachment attachment : attachmentList) {
							fname = attachment.getAttname().substring(attachment.getAttname().indexOf("_")+1);
							if(attachmentList.size()>1){
								if(fileName == null){
									fileName = fname;
								}else{								
									fileName = fileName + "," + fname;
								}
							}else{
								fileName = fname;
							}
						}
						addCell(j, k, fileName);
						j++;
					}else{
						addCell(j, k, "");
						j++;
					}
					k++;
				}
			}
		}
		dto.setHistoryVOs(historyVOs);
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO excelDto) throws BLException {
		return excelDto;
	}

	/**
	 * 初始化Excel内容并打入Zip包内
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcelToDownZip(IGPRJ0108ExcelDTO dto) throws BLException {
		
		//删除文件夹内的已存在文件
		this.clearDirect(ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"projectLog\\file");
		
		setExcelDTO(dto);
		
		//定义可写模版
		WritableWorkbook writableWorkbook = null;
		try {
			//获取模版
			Workbook template = getTemplate(dto);
			
			//设定模版Sheet页
			dto.setTemplateSheet(template.getSheet(0));
			
			File file_I = new File(ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"projectLog\\projectLog.xls");
    		FileOutputStream fos_I = new FileOutputStream(file_I);
    		dto.setFos_I(fos_I);
			//创建可写模版
			writableWorkbook = Workbook.createWorkbook(dto.getFos_I(), template);
			
			//设定可写Sheet页
			dto.setWritableSheet(writableWorkbook.getSheet(0));
			
			// 设定可写模板
			dto.setWritableWorkbook(writableWorkbook);
			
			//初始化Excel表头
			initHeader(dto);
			
			//初始化Excel表主体
			initBody(dto);
			
			//初始化Excel表底部
			initFooter(dto);
			

			//获得附件
    		IGPRJ01HistoryVO[] historyVOs = (IGPRJ01HistoryVO[])dto.getHistoryVOs();    		
    		if (null != historyVOs) {
    			for (int i = 0; i < historyVOs.length; i++) {
    				IGPRJ01HistoryVO historyVO = historyVOs[i];
    				List<Attachment> attachmentList = historyVO.getAttachmentList();
    				//附件
    				if (null != attachmentList) {
    					for (Attachment attachment : attachmentList) {

    						String fileName = attachment.getAttname().substring(attachment.getAttname().indexOf("_")+1);
    						File file = new File(ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"attach\\prj\\"+attachment.getAttname());
    						FileInputStream fis_I = new FileInputStream(file);
    						byte[] b = new byte[(int)file.length()];
    						fis_I.read(b);
    						
    						File file_II = new File(ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"projectLog\\file\\"+attachment.getAttid()+"_"+fileName);
    						FileOutputStream fos_II = new FileOutputStream(file_II);
    						fos_II.write(b);

    						if(fis_I!=null){
    							fis_I.close();
	    		    		}
    						if(fos_II!=null){
    							fos_II.close();
	    		    		}
    					}
    				}
    			}
    		}
    		
		} catch (Exception e) {
			//IGRPT0000.E003=（{0}）生成Excel时发生错误。
			throw new BLException("IGRPT0000.E003", dto.getFileid());
		} finally { 
			try {
				if(writableWorkbook != null) {
					writableWorkbook.write();
					writableWorkbook.close();
				}
//				if(dto.getResponse().getOutputStream() != null) {
//					dto.getResponse().getOutputStream().close();
//				}

				if(dto.getFos_I()!=null){
					dto.getFos_I().close();
	    		}
				//打ZIP包
    			ExportHtml.zipFileName = ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"projectLog.zip";
    			ExportHtml.createZipOut();
    			
    			ExportHtml.packToolFiles(ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"projectLog", "projectLog");
    			
    			ExportHtml.closeZipOut();
    			
    			//删除文件夹内的已存在文件
        		this.clearDirect(ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"projectLog\\file");
				
			} catch (Exception e) {
				//IGRPT0000.E003=（{0}）生成Excel时发生错误。
				throw new BLException("IGRPT0000.E003", dto.getFileid());
			}
		}
		return dto;
	}
	
	
	
	/***
	 * 删除指定文件夹下所有文件
	 * @param filePath
	 */
	private void clearDirect(String filePath){
		//生成指定文件夹对象
		File file = new File(filePath);
		//如果该路径是个目录
		if(file.isDirectory()){
			//列出目录下所有文件
			File files[] = file.listFiles();
			for(File delFile:files){
				//如果文件存在
				if(delFile.exists()){
					//删除文件
					delFile.delete();
				}
			}
		}
	}

}
