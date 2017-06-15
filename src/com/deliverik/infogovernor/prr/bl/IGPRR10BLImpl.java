/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG037BL;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG037TB;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.infogovernor.prr.bl.IGPRR10BLType.Sign;
import com.deliverik.infogovernor.prr.dto.IGPRR10DTO;
import com.deliverik.infogovernor.prr.form.IGPRR1001Form;
import com.deliverik.infogovernor.prr.form.IGPRR1002Form;
import com.deliverik.infogovernor.prr.util.ExcelUtils;
import com.deliverik.infogovernor.prr.util.ExcelUtils.Type;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̵���BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR10BLImpl extends BaseBLImpl implements IGPRR10BL{

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGPRR10BLImpl.class);

	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ���̴���LB */
	protected WorkFlowOperationBL workFlowOperationBL;
	
//	/** ȡ�����ö��� */
//	protected ImportProcessUtils util = ImportProcessUtils.getInstance();
	
	/** excel������ȡ�� */
	protected ExcelUtils eUtils = ExcelUtils.getInstance();
	
	/** �ϴ�����BL */
	protected FileUploadBL fileUploadBL;
	
	/** ��������ϢBL */
	protected IG500BL ig500BL;
	
	/** �û�BL */
	protected UserBL userBL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** ������BL */
	protected IG337BL ig337BL;
	
	/** ����״̬��־BL */
	protected IG224BL ig224BL;
	
	/** ���ʽ��BL */
	protected IG898BL ig898BL;
	
	/** ���̵�����־BL */
	protected IG037BL ig037BL;
	
	/** �ʲ���Ϣ����BL */
	protected SOC0118BL soc0118BL;
	
	/** �������ݴ���BL */
	protected CodeDetailBL codeDetailBL;
	
	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ���̴���LB�趨
	 * @param workFlowOperationBL ���̴���LB
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * �ϴ�����BL�趨
	 * @param fileUploadBL �ϴ�����BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * ��������ϢBL�趨
	 * @param ig500BL ��������ϢBL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * �û�BL�趨
	 * @param userBL �û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * �û���ɫBL�趨
	 * @param userRoleBL �û���ɫBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ������BL�趨
	 * @param ig337BL ������BL
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	/**
	 * ����״̬��־BL�趨
	 * @param ig224bl ����״̬��־BL
	 */
	public void setIg224BL(IG224BL ig224bl) {
		ig224BL = ig224bl;
	}

	/**
	 * ���ʽ��BL�趨
	 * @param ig898bl ���ʽ��BL
	 */
	public void setIg898BL(IG898BL ig898bl) {
		ig898BL = ig898bl;
	}

	/**
	 * ���̵�����־BL�趨
	 * @param ig037bl ���̵�����־BL
	 */
	public void setIg037BL(IG037BL ig037bl) {
		ig037BL = ig037bl;
	}

	/**
	 * �ʲ���Ϣ����BL�趨
	 * @param soc0118bl �ʲ���Ϣ����BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * �������ݴ���BL�趨
	 * @param codeDetailBL �������ݴ���BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ���̶����ѯ������ʼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO searchProcessDefinitionsAction(IGPRR10DTO dto) throws BLException {
		log.debug("=============���̶����ѯ������ʼ==============");
		//ʵ������ѯ����
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		//��ѯͨ��ģ���µ�����
		Integer[] ptids = new Integer[]{IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID};
		cond.setPrTypeArray(ptids);
		//��ѯ����״̬Ϊ����
		cond.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
		//����BL��ѯ�������°汾����
		//�������ͷ�Χ
		CodeDetailSearchCondImpl cond_code = new CodeDetailSearchCondImpl();
		cond_code.setCcid(CodeDefine.getCodeDefine("PDID_IMPORT_CCID").getCcid());//�ɵ������̵Ļ�����Ϣ
		cond_code.setCdstatus("1");
		List<CodeDetail> lst_codedetail = this.codeDetailBL.searchCodeDetail(cond_code, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		
//		String[] prpdid_like_or = IGPRR10BLType.PROCESS_PDIDS;
		String[] prpdid_like_or = null;
		if(lst_codedetail != null && lst_codedetail.size() > 0){
			prpdid_like_or = new String[lst_codedetail.size()];//��¼�ɵ������̵Ķ���ID
			for (int i = 0; i < lst_codedetail.size(); i++) {
				CodeDetail codeDetail = lst_codedetail.get(i);
				prpdid_like_or[i] = codeDetail.getCvalue();
			}
		}else{
			prpdid_like_or = new String[]{"00000"};
		}
		
		cond.setPrpdid_like_or(prpdid_like_or);
		List<IG380Info> processDefinitionList = workFlowDefinitionBL.searchLastProcessDefinition(cond, 0, 0);
		//���÷��ؽ��
		dto.setProcessDefinitionList(processDefinitionList);
		log.debug("=============���̶����ѯ��������==============");
		return dto;
	}
	
	/**
	 * ��װ����ģ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO initProcessExportTemplateAction(IGPRR10DTO dto) throws BLException {
		log.debug("================��װ����ģ�������ʼ==================");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRR1001Form){
			//ҳ������ȡ��
			IGPRR1001Form form = (IGPRR1001Form) dto.getForm();
			if(form.getPdids() != null && form.getPdids().length > 0){
				//���ɵ���ģ��
				String timestamp = generatedTemplate(form.getPdids());
				//�ļ����
				String fileName = packToolFiles(timestamp);
				//�����ļ�
				downloadFile(fileName,dto.getResponse());
				//ɾ�������ļ�
				eUtils.flush();
			}
		}
		log.debug("================��װ����ģ���������==================");
		return dto;
	}
	
	/**
	 * �ļ�����
	 * @param fileName �ļ�����
	 * @param response ��Ӧ����
	 */
	private void downloadFile(String fileName, HttpServletResponse response) throws BLException {
		// �����
    	OutputStream output = null;
    	// ������
    	FileInputStream input = null;
    	try{
	        File file = new File(fileName);
	    	//�ļ����ش���
	        response.reset();
	        response.setContentType("binary/octet-stream");
	        response.setHeader("Content-Disposition", "attachment;filename=" +  new String(file.getName().getBytes("gb2312"),"iso-8859-1"));
	    	// �����ȡ��
			output = response.getOutputStream();
			// ������ȡ��
			input = new FileInputStream(file);
			int actual = 0;
			byte[] b = new byte[1024];
			
			while ((actual = input.read(b)) > 0) {
				output.write(b,0,actual);
			}
			output.flush();
    	}catch (Exception e) {
    		log.error("DownloadAction Exception", e);
    		throw new BLException("IGCO10000.E009");
		}finally {
			try {
				// �ر�������
				if(input != null){
					input.close();
					input = null;
				}
				// �ر������
				if(output != null){
					output.close();
					output = null;
				}
			} catch (Exception e) {
				log.error("DownloadAction Exception", e);
			}
		}
	}

	/**
	 * ���
	 * @param timestamp ʱ���
	 * @return ѹ���ļ���
	 */
	private String packToolFiles(String timestamp) throws BLException{
		//����Ŀ¼��·��
//		String rootPath = util.get("TEMPLATE_TEMP_PATH").toString();
		String rootPath = ResourceUtility.getString("TEMPLATE_TEMP_PATH");
		//ѹ�����ļ���
		String zipFileName = rootPath + timestamp + "_templates.zip";
		//ѹ���ļ��������
		ZipOutputStream out = null;
		try{
			//ʵ����ѹ���ļ��������
			out = new ZipOutputStream(new FileOutputStream(zipFileName));
			out.setEncoding("GBK");
			//��ѹ��Ŀ¼file����
			File file = new File(rootPath + timestamp);
			if(file.exists()){
				toZip(out, file, file.getName(), zipFileName);
			}else{
				throw new BLException("IGCO10000.E141","�ļ����ʧ�ܣ�");
			}
		}catch (Exception e) {
			log.debug("�ļ����ʧ��",e);
			throw new BLException("IGCO10000.E141","�ļ����ʧ�ܣ�");
		}finally{
			if(out != null){
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					log.debug("",e);
				}
			}
		}
		return zipFileName;
	}
	
	/**
     * ���ļ�����ѹ��.
     * 
     * @param outputStream
     * @param file Ҫѹ�����ļ����ļ�Ŀ¼.
     * @param base �ļ�������Ŀ¼����.
     * @param zipFileName ѹ�����ZIP�ļ���.
     * @return ѹ������ļ�.
     * @throws Exception һЩ�����IO�쳣��Ϣ.
     */
    private void toZip(ZipOutputStream outputStream, File file, String base, String zipFileName) throws Exception {
        if (file.isDirectory()) {
            File[] fl = file.listFiles();
            outputStream.putNextEntry(new ZipEntry(base + "/"));

            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < fl.length; i++) {
                if(fl[i].getName().equals(new File(zipFileName).getName())) {
                    continue;
                }
                toZip(outputStream, fl[i], base + fl[i].getName(), zipFileName);
            }
        } else {
            outputStream.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(file);
            int b;
            while ((b = in.read()) != -1) {
                outputStream.write(b);
            }
            in.close();
        }
    }

	/**
	 * ����ģ��
	 * @param pdids ���̶���ID����
	 * @return ģ������ʱ���
	 */
	private String generatedTemplate(String[] pdids) throws BLException{
		//ʱ���
//		String timestamp = util.getTimestamp();
		String timestamp = IGStringUtils.getAttKey();
		//ȡ�û���Ŀ¼��·��
//		String tempRootPath = util.get("TEMPLATE_TEMP_PATH").toString() + timestamp + File.separator;
		String tempRootPath = ResourceUtility.getString("TEMPLATE_TEMP_PATH") + timestamp + File.separator;
		//��дģ��
		WritableWorkbook book = null;
		//��дsheetҳ
		WritableSheet sheet = null;
		//ѭ������excelģ��
		for(int i=0;i<pdids.length;i++){
			//���̶�������
			String pdid = pdids[i];
			//��ѯ���̶�����Ϣ
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			//��ѯ������
			IG007SearchCondImpl pidCond = new IG007SearchCondImpl();
			pidCond.setPdid(pdid);
			List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(pidCond);
			//����������б��ʽ���еĲ㼶��ϵ
			Map<String, List<IG007Info>> map = new LinkedHashMap<String, List<IG007Info>>();
			map.put(IGPRR10BLType.PROCESS_BASIS_FORM_KEY, new ArrayList<IG007Info>());
			if(pidList != null && pidList.size() > 0){
				for(IG007Info pid:pidList){
					String key = pid.getPpidid();
					if(StringUtils.isNotEmpty(pid.getPpidid())){
						if(map.get(pid.getPpidid()) == null){
							map.put(pid.getPpidid(), new ArrayList<IG007Info>());
						}
					}else{
						key = IGPRR10BLType.PROCESS_BASIS_FORM_KEY;
					}
					map.get(key).add(pid);
				}
			}
			//д���к�
			int index = 0;
			//������
			int sumColumn = getSumColumnCount(map);
			
			//-------------����excelģ��------------
			checkPath(tempRootPath);
			try{
				//����������
				book = Workbook.createWorkbook(new File(tempRootPath + pd.getPdname() + ".xls"));
				//����sheetҳ
				sheet = book.createSheet("sheet1", 0);
				sheet.addCell(new Label(0,index,Sign.PDID.toString(),eUtils.format(Type.SIGN)));
				sheet.addCell(new Label(1,index,pd.getPdid(),eUtils.format(Type.CONTENT)));
				sheet.setRowView(index,0); 
				//д�����
				index ++;
				sheet.addCell(new Label(0, index, pd.getPdname(),eUtils.format(Type.MAIN_TITLE)));
				//�ϲ���Ԫ��
				sheet.mergeCells(0, index, sumColumn - 1, index);
				//д�������Ϣ���
				index = writeBasisInfo(sheet, pdid, index, sumColumn);
				//д�����Ϣ
				index = writeProcessInfo(sheet, pdid, index, sumColumn,map);
				//д���������Ϣ
				index = writeParticipantInfo(sheet, pdid, index, sumColumn);
				//�����п�
				for(int colNum=0;colNum<sumColumn;colNum++){
					sheet.setColumnView(colNum, 20);
				}
				book.write();
			}catch (Exception e) {
				log.debug("����\"" + pd.getPdname() + "\"ģ��ʧ��",e);
				throw new BLException("IGCO10000.E141","����\"" + pd.getPdname() + "\"ģ��ʧ�ܣ�");
			}finally{
				try {
					book.close();
				} catch (Exception e) {
					log.error("",e);
				}
			}
		}
		return timestamp;
	}

	/**
	 * ����������
	 * @param map ��������Ϣ
	 * @return ������
	 */
	private int getSumColumnCount(Map<String, List<IG007Info>> map) {
		int sumCount = 4;
		List<IG007Info> pidList = map.get(IGPRR10BLType.PROCESS_BASIS_FORM_KEY);
		if(pidList != null){
			for(IG007Info pid:pidList){
				int count = getCount(pid.getPidid(),map);
				
				if(count > sumCount){
					sumCount = count;
				}
			}
		}
		return sumCount + 1;
	}

	/**
	 * ȡ�ñ��������
	 * @param pidid ���������
	 * @param map ������㼶��ϵmap
	 * @return ������
	 */
	private int getCount(String pidid, Map<String, List<IG007Info>> map) {
		int count = 0;
		List<IG007Info> list = map.get(pidid);
		if(list != null && list.size() > 0){
			for(IG007Info pid:list){
				count += getCount(pid.getPidid(), map);
			}
		}else{
			count = 1;
		}
		return count;
	}

	/**
	 * ��excelд�����̱���
	 * @param sheet excel sheetҳ
	 * @param pdid ���̶���ID
	 * @param index ������
	 * @param sumColumn ������
	 * @return ��ǰд����
	 * @throws Exception
	 */
	private int writeParticipantInfo(WritableSheet sheet,String pdid, int index,int sumColumn) throws Exception{
		//��ѯ״̬������Ϣ
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(cond);
		if(psdList != null && psdList.size() > 1){
			//д������˱��
			index ++;
			sheet.addCell(new Label(0,index,Sign.PARTICIPANT.toString(),eUtils.format(Type.SIGN)));
			sheet.setRowView(index,0); 
			//���ñ���
			index ++;
			sheet.addCell(new Label(0,index,"״̬����",eUtils.format(Type.TITLE)));
			sheet.addCell(new Label(1,index,"������ID",eUtils.format(Type.TITLE)));
			sheet.addCell(new Label(2,index,"����ʱ��",eUtils.format(Type.TITLE)));
			sheet.addCell(new Label(3,index,"������",eUtils.format(Type.TITLE)));
			sheet.addCell(new Label(4,index,"�������",eUtils.format(Type.TITLE)));
			if(sumColumn > 5){
				sheet.addCell(new Label(5,index,"",eUtils.format(Type.CONTENT)));
				if(sumColumn > 6){
					//�ϲ���Ԫ��
					sheet.mergeCells(5, index, sumColumn - 1, index);
				}
			}
			for(IG333Info psd:psdList){
				//����״̬�����ò�����
				if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode())){
					index ++;
					sheet.addCell(new Label(0,index,psd.getPsdname(),eUtils.format(Type.CONTENT)));
					sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
					sheet.addCell(new Label(2,index,"",eUtils.format(Type.CONTENT)));
					sheet.addCell(new Label(3,index,"",eUtils.format(Type.CONTENT)));
					sheet.addCell(new Label(4,index,"",eUtils.format(Type.CONTENT)));
					if(sumColumn > 5){
						sheet.addCell(new Label(5,index,"",eUtils.format(Type.CONTENT)));
						if(sumColumn > 6){
							//�ϲ���Ԫ��
							sheet.mergeCells(5, index, sumColumn - 1, index);
						}
					}
				}
			}
		}
		return index;
	}
	/**
	 * ��excelд�����̱���
	 * @param sheet excel sheetҳ
	 * @param pdid ���̶���ID
	 * @param index ������
	 * @param sumColumn ������
	 * @return ��ǰд����
	 * @throws Exception
	 */
	private int writeProcessInfo(WritableSheet sheet,String pdid, int index,int sumColumn,Map<String, List<IG007Info>> pidMap) throws Exception{
		//ȡ�û�����
		List<IG007Info> pidList = pidMap.get(IGPRR10BLType.PROCESS_BASIS_FORM_KEY);
		if(pidList != null && pidList.size() > 0){
			index ++;
			//д����
			sheet.addCell(new Label(0,index,Sign.PROCESS_INFO.toString(),eUtils.format(Type.SIGN)));
			sheet.setRowView(index,0); 
			for(IG007Info pid:pidList){
				//д��ʱ���������ʽ���ж���
				if(StringUtils.isEmpty(pid.getPpidid())){
					//���Ը�����
					if("F".equals(pid.getPidtype())){
						continue;
					}
					index ++;
					sheet.addCell(new Label(0,index,pid.getPidname(),eUtils.format(Type.TITLE)));
					//���ʽ������
					if("8".equals(pid.getPidtype())){
						int startColumn = 1;
						List<IG007Info> list = pidMap.get(pid.getPidid());
						if(list != null && list.size() > 0){
							for(IG007Info column:list){
								int count = getCount(column.getPidid(), pidMap);
								sheet.addCell(new Label(startColumn,index,column.getPidname(),eUtils.format(Type.TITLE)));
								if(count > 1){
									//�ϲ���Ԫ��
									sheet.mergeCells(startColumn, index, startColumn + count - 1, index);
								}else{
									sheet.addCell(new Label(startColumn,index + 1,"",eUtils.format(Type.CONTENT)));
								}
								startColumn += count;
							}
						}
						if(startColumn < sumColumn){
							sheet.addCell(new Label(startColumn,index,"",eUtils.format(Type.CONTENT)));
							sheet.addCell(new Label(startColumn,index + 1,"",eUtils.format(Type.CONTENT)));
							if(sumColumn - startColumn > 1){
								//�ϲ���Ԫ��
								sheet.mergeCells(startColumn, index, sumColumn - 1, index);
								sheet.mergeCells(startColumn, index + 1, sumColumn - 1, index + 1);
							}
						}
						//�ϲ���Ԫ��
						sheet.mergeCells(0, index, 0, index + 1);
						index ++;
						
					}else{
						sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
						//�ϲ���Ԫ��
						sheet.mergeCells(1, index, sumColumn - 1, index);
					}
				}
			}
		}
		return index;
	}
	
	/**
	 * ��excelд�����̻�����Ϣ
	 * @param sheet excel sheetҳ
	 * @param pdid ���̶���ID
	 * @param index ������
	 * @param sumColumn ������
	 * @return ��ǰд����
	 * @throws Exception
	 */
	private int writeBasisInfo(WritableSheet sheet,String pdid, int index,int sumColumn) throws Exception{
		//��ѯ����������Ϣ
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPdid(pdid);
		List<IG243Info> lstProcessTitleDef = this.workFlowDefinitionBL.searchProcessTitleDef(cond);
		index ++;
		sheet.addCell(new Label(0,index,Sign.BASIS.toString(),eUtils.format(Type.SIGN)));
		sheet.setRowView(index,0); 
		//---------------������Ϣstart--------------
		if(lstProcessTitleDef != null && lstProcessTitleDef.size() == 1){
			//���̱���
			if(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT.equals(lstProcessTitleDef.get(0).getPtitleaccess())){
				index ++;
				sheet.addCell(new Label(0,index,lstProcessTitleDef.get(0).getPtitlename(),eUtils.format(Type.TITLE)));
				sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
				//�ϲ���Ԫ��
				sheet.mergeCells(1, index, sumColumn - 1, index);
			}
			//��������
			if(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT.equals(lstProcessTitleDef.get(0).getPdescaccess())){
				index ++;
				sheet.addCell(new Label(0,index,lstProcessTitleDef.get(0).getPdescname(),eUtils.format(Type.TITLE)));
				sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
				//�ϲ���Ԫ��
				sheet.mergeCells(1, index, sumColumn - 1, index);
			}
		}
		//���̷���ʱ��
		index ++;
		sheet.addCell(new Label(0,index,IGPRR10BLType.PROCESS_BASIS_OPENTIME,eUtils.format(Type.TITLE)));
		sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
		//�ϲ���Ԫ��
		sheet.mergeCells(1, index, sumColumn - 1, index);
		//���̽���ʱ��
		index ++;
		sheet.addCell(new Label(0,index,IGPRR10BLType.PROCESS_BASIS_CLOSETIME,eUtils.format(Type.TITLE)));
		sheet.addCell(new Label(1,index,"",eUtils.format(Type.CONTENT)));
		//�ϲ���Ԫ��
		sheet.mergeCells(1, index, sumColumn - 1, index);
		return index;
	}
	
	/***
	 * �ļ�Ŀ¼���
	 * @param path �ļ�Ŀ¼
	 */
	private void checkPath(String path) throws BLException {
		File objFile = new File(path);
		if (objFile.exists() != true && objFile.isDirectory() != true) {
			// �ļ�·��������ʱ������Ŀ¼
			boolean ret = objFile.mkdirs();
			if (!ret) {
				throw new BLException("IGCO10000.E008",path);
			}
		}
	}
	
	/**
	 * ���̵������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO importProcessRecordsAction(IGPRR10DTO dto) throws BLException {
		log.debug("================���̵��������ʼ=================");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRR1002Form){
			IGPRR1002Form form = (IGPRR1002Form) dto.getForm();
			FormFile file = form.getExportFile();
			//�ϴ��ļ�
			FileInfo info = uploadFile(file);
			importProcess(info);
		}
		log.debug("================���̵����������=================");
		return dto;
	}
	
	private void importProcess(FileInfo info) throws BLException{
		log.debug("============�����ļ���ʼ==============");
		//�ļ�����
		File file = info.getFile();
		Workbook wb = null;
		try{
			//ȡ�ù�����
			wb = Workbook.getWorkbook(file);
			if(wb != null){
				Sheet[] sheets = wb.getSheets();
				if(sheets != null && sheets.length > 0){
					for(Sheet sheet:sheets){
						createProcess(sheet);
					}
				}else{
					throw new BLException("IGCO10000.E141","�������ݲ����ڡ�");
				}
			}else{
				throw new BLException("IGCO10000.E141","�ļ���ȡʧ�ܡ�");
			}
		} catch (BLException e) {
			log.error("���̵���ʧ��",e);
//			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			log.error(e);
			throw new BLException("IGCO10000.E141","�ļ�����ʧ�ܡ�");
		}
		log.debug("============�����ļ�����==============");
	}
	
	@SuppressWarnings("unchecked")
	private void createProcess(Sheet sheet) throws BLException{
		//��ʼ��
		int row = 0;
		//ȡ������
		int rows = sheet.getRows();
		//ȡ�����̶���
		Info<IG380Info> pdInfo = getProcessDefinition(sheet,row,rows);
		row = pdInfo.row;
		IG380Info pd = pdInfo.obj;
		//��ѯ״̬������Ϣ
		Map<String, IG333Info> statusMap = getProcessStatusDefinition(pd.getPdid());
		//��ѯ��������Ϣ
		Map<String, IG007Info> processInfoDefMap = getProcessInfoDefinition(pd.getPdid());
		//�����˶���Map
		Map<String, List<IG222Info>> participantDefMap = getProcessRoleDefinition(pd.getPdid());
		//��ѯ����������Ϣ
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPdid(pd.getPdid());
		List<IG243Info> lstProcessTitleDef = this.workFlowDefinitionBL.searchProcessTitleDef(cond);
		Info<Map<String,String>> basisInfo = getBasisInfo(sheet, row, rows);
		Map<String, String> basisMap = basisInfo.obj;
		row = basisInfo.row;
		//ȡ�ñ���Ϣ
		Info<Map<String, Object>> formInfo = getProcessInfo(sheet,row,rows,processInfoDefMap);
		Map<String, Object> processInfoMap = formInfo.obj;
		row = formInfo.row;
		//ȡ�ò�������Ϣ
		Info<Map<String, Map<String, String>>> ppInfo = getParticipantInfo(sheet, row, rows);
		Map<String, Map<String, String>> ppMap = ppInfo.obj;
		row = ppInfo.row;
		IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(pd.getPtid());
		IG500TB prTB = new IG500TB();
		prTB.setPrpdid(pd.getPdid());
		prTB.setPrpdname(pd.getPdname());
		prTB.setPrtype(pt.getPttype());
		if(lstProcessTitleDef != null && lstProcessTitleDef.size() == 1){
			//���̱���
			if(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT.equals(lstProcessTitleDef.get(0).getPtitleaccess())){
				prTB.setPrtitle(basisMap.get(lstProcessTitleDef.get(0).getPtitlename()));
			}else{
				prTB.setPrtitle(pd.getPdname());
			}
			//��������
			if(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT.equals(lstProcessTitleDef.get(0).getPdescaccess())){
				prTB.setPrdesc(basisMap.get(lstProcessTitleDef.get(0).getPdescname()));
			}else{
				prTB.setPrdesc(pd.getPdactname());
			}
		}
		//ȡ�÷���״̬��Ϣ
		IG333Info psd = statusMap.get("������");
		Map<String, String> pp = ppMap.get("������");
		String pruserid = pp.get("������ID");
		User user = userBL.searchUserByKey(pruserid);
		if(user == null){
			throw new BLException("IGCO10000.E141","��������Ϣ������");
		}
		//ȡ�÷����˽�ɫ
		List<IG222Info> ppdList = participantDefMap.get(psd.getPsdid());
		List<Integer> roleIds = new ArrayList<Integer>();
		for(IG222Info info:ppdList){
			roleIds.add(info.getRoleid());
		}
		UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
		urcond.setRoleid_in(roleIds);
		urcond.setUserid(user.getUserid());
		List<UserRoleInfo> urList = userRoleBL.searchUserRoleVW(urcond);
		if(urList == null || urList.size() == 0){
			throw new BLException("IGCO10000.E141","�����˽�ɫ��Ϣ������");
		}
		prTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		prTB.setPropentime(basisMap.get(IGPRR10BLType.PROCESS_BASIS_OPENTIME));
		prTB.setPrclosetime(basisMap.get(IGPRR10BLType.PROCESS_BASIS_CLOSETIME));
		prTB.setPruserid(user.getUserid());
		prTB.setPrusername(user.getUsername());
		prTB.setProrgid(user.getOrgid());
		prTB.setProrgname(user.getOrgname());
		prTB.setPrroleid(urList.get(0).getRoleid());
		prTB.setPrrolename(urList.get(0).getRolename());
		IG500Info pr = ig500BL.registIG500Info(prTB);
		//�������̹ر�״̬��־
		//��ѯ���̹ر�״̬��ʶ
		String statusNow = workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), IGPRDCONSTANTS.PROCESS_END_STATUS);
		//��ȡʱ��
		Date dateTime = new Date();
		IG224TB currentRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		currentRecordStatusLogTB.setPrid(pr.getPrid());//����ID
		currentRecordStatusLogTB.setPrtype(pr.getPrtype());//��������
		currentRecordStatusLogTB.setRslOpenTime(dateTime);//��ʼʱ��
		currentRecordStatusLogTB.setRslCloseTime(dateTime);
		currentRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);//��ǰ����״̬
		currentRecordStatusLogTB.setPrpdid(pr.getPrpdid());//�Զ�����������ID
		currentRecordStatusLogTB.setVirtualstatus("0");//������״̬
		currentRecordStatusLogTB.setPsdid(statusNow);//������״̬
		this.ig224BL.registIG224Info(currentRecordStatusLogTB);
				
		for(Iterator<Entry<String, Map<String, String>>> iter = ppMap.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, String>> entry = iter.next();
			String key = entry.getKey();
			Map<String, String> value = entry.getValue();
			psd = statusMap.get(key);
			IG337TB ppTB = new IG337TB();
			ppTB.setPrid(pr.getPrid());
			ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
			ppTB.setPpstatus(psd.getPsdcode());
			ppTB.setPsdid(psd.getPsdid());
			ppTB.setPpinittime(pr.getPropentime());
			ppTB.setPpproctime(value.get("����ʱ��"));
			User u = userBL.searchUserByKey(value.get("������ID"));
			if(u == null){
				throw new BLException("IGCO10000.E141",key + "�ڵ㴦������Ϣ������");
			}
			ppTB.setPpuserid(u.getUserid());
			ppTB.setPpusername(u.getUsername());
			ppTB.setPpuserinfo(u.getUsermobile());
			ppTB.setPporgid(u.getOrgid());
			ppTB.setPporgname(u.getOrgname());
			List<IG222Info> list = participantDefMap.get(psd.getPsdid());
			urcond = new UserRoleVWSearchCondImpl();
			urcond.setUserid(u.getUserid());
			if(list != null && list.size() > 0){
				List<Integer> roleidList = new ArrayList<Integer>();
				for(IG222Info info:list){
					roleidList.add(info.getRoleid());
				}
				urcond.setRoleid_in(roleidList);
			}
			List<UserRoleInfo> ur = userRoleBL.searchUserRoleVW(urcond);
			if(ur.size() > 0){
				ppTB.setPproleid(ur.get(0).getRoleid());
				ppTB.setPprolename(ur.get(0).getRolename());
			}
			ig337BL.registIG337Info(ppTB);
		}
		
		//��ֵ����
		IG599TB instance = null;
		for(Iterator<Entry<String, Object>> iterator = processInfoMap.entrySet().iterator();iterator.hasNext();){
			//��ȡ����ı���Ϣ
			Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			instance = this.workFlowOperationBL.getProcessInfoTBInstance();//ʵ�������̱�ʵ��
			//�������ʽ��ʵ��
			IG898TB instance_table = null;
			if(processInfoDefMap.get(key) != null){
				//��ȡ��������Ϣ
				IG007Info ig007Info = processInfoDefMap.get(key);
				instance.setPrid(pr.getPrid());//��������
				instance.setPivarname(ig007Info.getPidname());//���̱�����
				instance.setPivarlabel(ig007Info.getPidlabel());//���̱���ʾ����
				instance.setPivartype(ig007Info.getPidtype());//���̱�����
				instance.setPidid(ig007Info.getPidid());//���̱�����
				instance.setPidmode(ig007Info.getPidmode());//���̱�ģʽ
				
				if("8".equals(ig007Info.getPidtype())){
					instance.setPivarvalue("tab");//���̱�ֵ
					List<Map<String, Object>> lst_processinfo_tab = (List<Map<String, Object>>)value;
					
					//��ѯ���ʽ������
					int num = 0;
					for (Map<String, Object> linkedHashMap : lst_processinfo_tab) {
						
						num ++;//��ȡ�к�
						instance_table = this.ig898BL.getIG898TBInstance();//ʵ�������ʽ��ʵ��
						instance_table.setPrid(pr.getPrid());
						instance_table.setPidid(ig007Info.getPidid());//���̱�����
						instance_table.setPidname(ig007Info.getPidname());//���̱�����
						instance_table.setPvrownumber(java.lang.String.valueOf(num));//�к�
						
						//��ȡmap����
						Set<String> keySet = linkedHashMap.keySet();
						for (String pvcolname : keySet) {
							//��ȡ��������Ϣ
							IG007Info ig007Info_table = processInfoDefMap.get(pvcolname);
							
							instance_table.setPvcolpidid(ig007Info_table.getPidid());//���̱��ʽ����ID
							instance_table.setPvcolname(ig007Info_table.getPidname());//���̱��ʽ��������
							
							//��ȡ��ֵ��Ϣ
							String tab_value = (String)linkedHashMap.get(pvcolname);
							
							//��ֵУ��
							//��ȡ��������Ϣ
							tab_value = grtProcessInfoValue(tab_value, ig007Info_table);
							
							instance_table.setPvalue(tab_value);//���ʽ����ֵ
							//�������ʽ��ֵ
							this.ig898BL.registIG898(instance_table);
						}
					}
				}else{
					//���ʽ����������
					if(StringUtils.isNotBlank(ig007Info.getPpidid())){
						continue;
					}
					
					//��ͨ��
					//��ȡ���̱�ֵ
					String pivarvalue = "";
					if(value != null){
						pivarvalue = grtProcessInfoValue((String)value, ig007Info);
					}
					instance.setPivarvalue(StringUtils.isEmpty(pivarvalue) ? ig007Info.getPiddefault() : pivarvalue);//���̱�ֵ
				}
				
				//��������Ϣ
				this.workFlowOperationBL.saveProcessInfo(instance);
//				IG599Info saveProcessInfo = this.workFlowOperationBL.saveProcessInfo(instance);
				
//				//�����������й�����Ϣ�Ĺ�ϵ��¼
//				saveProcessInfoValue(saveProcessInfo, (String)value, ig007Info);
			}
		}
		
		//��ӵ�����־
		insertImportLogByProcess(pr.getPrid(), user, "���̵�����־", "������Ϣ����ɹ���");
		
	}
	
	/**
	 * ��ͨ��ֵ����
	 * 
	 * @param pivalue �����ֵ
	 * @param ig007Info ��������Ϣ
	 * @return
	 */
	private String grtProcessInfoValue(String pivalue, IG007Info ig007Info)  throws BLException{
		String value = pivalue;
		String pidtype = ig007Info.getPidtype();
		if("2".equals(pidtype)){
			//�����б�
			
		}else if ("3".equals(pidtype)){
			//����
			
		}else if ("4".equals(pidtype)){
			//�ʲ�
		}else if ("5".equals(pidtype)){
			//����
			
		}else if ("6".equals(pidtype)){
			//��Ŀ
			
		}else if ("7".equals(pidtype)){
			//���ֿؼ�
			
		}else if ("9".equals(pidtype)){
			//�ı���
			
		}else if ("A".equals(pidtype)){
			//ʱ��
			
		}else if ("B".equals(pidtype)){
			//��ѡ
			
		}else if ("C".equals(pidtype)){
			//��ѡ
			
		}else if ("E".equals(pidtype)){
			//��ѡ����
			
		}else if ("F".equals(pidtype)){
			//����
			
		}else if ("G".equals(pidtype)){
			//������
			value = "_OrgTree_" + value;
			
		}else if ("O".equals(pidtype)){
			//����
			
		}else if ("P".equals(pidtype)){
			//��Ա
			
		}else if ("R".equals(pidtype)){
			//��ɫ
			
		}else if ("S".equals(pidtype)){
			//��ѡ��������
			
		}else if ("T".equals(pidtype)){
			//��
			value = "_tree_" + value;
		}
		return value;
	}
	
	
	/**
	 * ���̱�������Ϣ��ѯ
	 * @param pdid
	 * @return
	 * @throws BLException
	 */
	private Map<String, IG007Info> getProcessInfoDefinition(String pdid) throws BLException{
		Map<String, IG007Info> map = new HashMap<String, IG007Info>();
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pdid);
		List<IG007Info> list = workFlowDefinitionBL.searchProcessInfoDef(cond);
		for(IG007Info info:list){
			map.put(info.getPidname(), info);
		}
		return map;
	}
	
	/**
	 * ���̵�����־��Ϣ����
	 * @param pdid
	 * @return
	 * @throws BLException
	 */
	private void insertImportLogByProcess(Integer prid, User user, String desc, String comment) throws BLException{
		log.debug("================���̵�����־������ʼ================");
		
		IG037TB instance = this.ig037BL.getIG037TBInstance();
		instance.setPrid(prid);//��������
		instance.setIrtime(IGStringUtils.getCurrentDateTime());//����ʱ��
		instance.setIruserid(user.getUserid());//�����û�ID
		instance.setIrusername(user.getUsername());//�����û�����
		instance.setIrorgid(user.getOrgid());//���벿��ID
		instance.setIrorgname(user.getOrgname());//���벿������
		instance.setIrdesc(desc);//������־����
		instance.setIrcomment(comment);//������־����
		
		//������־
		this.ig037BL.registIG037(instance);
		
		log.debug("================���̵�����־��������================");
	}
	
	/**
	 * ��ȡ����Excel�еı���Ϣ
	 * @param sheet Exccel��sheet����
	 * @param row ����Ϣ��ʼ�к�
	 * @param rows ������Ϣ������
	 * @param processInfoDefMap ��������Ϣ
	 * @return
	 * @throws BLException
	 */
	private Info<Map<String, Object>> getProcessInfo(Sheet sheet, int row, int rows,Map<String, IG007Info> processInfoDefMap) throws BLException{
		Info<Map<String, Object>> info = null;
		
		for(int i=row;i<rows;i++){
			//ȡ�õ�ǰ�еĵ�Ԫ��
			Cell[] cells = sheet.getRow(i);
			Type type = eUtils.getType(cells[0].getCellFormat());
			if(Type.SIGN.equals(type)){
				String contents = cells[0].getContents();
				if(Sign.PROCESS_INFO.toString().equals(contents)){
					info = new Info<Map<String,Object>>();
					Map<String, Object> map = new HashMap<String, Object>();
					for(int index=i+1;index<rows;index++){
						cells = sheet.getRow(index);
						type = eUtils.getType(cells[0].getCellFormat());
						if(Type.SIGN.equals(type)){
							info.row = index;
							break;
						}
						
						//��ȡ��������Ϣ
						IG007Info ig007Info = processInfoDefMap.get(cells[0].getContents());
						if(ig007Info != null){
							if("8".equals(ig007Info.getPidtype())){
								
								List<Map<String, Object>> tableList = new ArrayList<Map<String,Object>>();
								Map<String, Object> mapTable = null;
								//��ȡ���ʽ��Excel����ռ����(Ĭ��ռ1��)
								int rows_contents = getRows(sheet, index, 1);
								//�������ʽ��������
								for (int rcs = 1; rcs < rows_contents; rcs++) {
									//��ȡ�����еĵ�Ԫ����Ϣ����
									Cell[] contents_cell = sheet.getRow(index + rcs);
									
									//��װ���ʽ������Ϣ
									mapTable = new HashMap<String, Object>();
									//������ǰ�����е�Ԫ��
									for (int j = 1; j < cells.length; j++) {
										if(StringUtils.isBlank(cells[j].getContents())){
											break;
										}
										mapTable.put(cells[j].getContents(), contents_cell[j].getContents());
									}
									//�����ʽ����Ϣ��¼��������
									tableList.add(mapTable);
									
								}
							
								//����Ǳ��ʽ����Խ��������
								index += (rows_contents - 1);
								//��װ���ʽ����Ϣ
								map.put(cells[0].getContents(), tableList);
							}else{
								map.put(cells[0].getContents(), cells[1].getContents());
							}
						}
					}
					//��װ����Ϣ������ѭ��
					info.obj = map;
					break;
				}
			}
		}
		//û�л�ȡ������Ϣʱ����ʾ�û�
		if(info == null){
			throw new BLException("IGCO10000.E141","���̱���Ϣ�����ڡ�");
		}
		return info;
	}

	private Map<String, IG333Info> getProcessStatusDefinition(String pdid) throws BLException{
		Map<String, IG333Info> map = new HashMap<String, IG333Info>();
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		List<IG333Info> list = workFlowDefinitionBL.searchProcessStatusDef(cond);
		for(IG333Info info:list){
			map.put(info.getPsdname(), info);
		}
		return map;
	}
	
	/**
	 * ������ʽ��Excel����ռ����
	 * @param sheet Excel����������
	 * @param row ����ʼ����
	 * @param rows ����ռ����
	 * @return
	 */
	private int getRows(Sheet sheet, int row, int rows){
		//ȡ����һ�еĵ�Ԫ��
		row++;
		Cell[] cells = sheet.getRow(row);
		
		if(!StringUtils.isBlank(cells[0].getContents())){
			
			return rows;
		}
		rows++;
		return getRows(sheet, row, rows);
	}
	/**
	 * �����˶���map
	 * @param pdid
	 * @return
	 * @throws BLException
	 */
	private Map<String, List<IG222Info>> getProcessRoleDefinition(String pdid) throws BLException{
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPdid(pdid);
		List<IG222Info> list = workFlowDefinitionBL.searchParticipantDef(cond);
		Map<String, List<IG222Info>> map = new HashMap<String, List<IG222Info>>();
		for(IG222Info info : list){
			if(map.get(info.getPsdid()) == null){
				map.put(info.getPsdid(), new ArrayList<IG222Info>());
			}
			map.get(info.getPsdid()).add(info);
		}
		return map;
	}
	
	private Info<Map<String, Map<String, String>>> getParticipantInfo(Sheet sheet,int row, int rows) throws BLException{
		Info<Map<String, Map<String, String>>> info = null;
		for(int i=row;i<rows;i++){
			//ȡ�õ�ǰ�еĵ�Ԫ��
			Cell[] cells = sheet.getRow(i);
			Type type = eUtils.getType(cells[0].getCellFormat());
			if(Type.SIGN.equals(type)){
				String contents = cells[0].getContents();
				if(Sign.PARTICIPANT.toString().equals(contents)){
					Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();
					for(int index=i+2;index<rows;index++){
						cells = sheet.getRow(index);
						String psdname = cells[0].getContents();
						String userid = cells[1].getContents();
						String date = cells[2].getContents();
						String action = cells[3].getContents();
						String comment = cells[4].getContents();
						Map<String, String> temp = new HashMap<String, String>();
						temp.put("������ID", userid);
						temp.put("����ʱ��", date);
						temp.put("������", action);
						temp.put("�������", comment);
						map.put(psdname, temp);
					}
					info = new Info<Map<String,Map<String,String>>>();
					info.obj = map;
					info.row = i + 1;
				}
			}
		}
		return info;
	}

	private Info<Map<String, String>> getBasisInfo(Sheet sheet, int row, int rows) throws BLException {
		Info<Map<String,String>> info = null;
		for(int i=row;i<rows;i++){
			//ȡ�õ�ǰ�еĵ�Ԫ��
			Cell[] cells = sheet.getRow(i);
			Type type = eUtils.getType(cells[0].getCellFormat());
			if(Type.SIGN.equals(type)){
				String contents = cells[0].getContents();
				if(Sign.BASIS.toString().equals(contents)){
					info = new Info<Map<String,String>>();
					Map<String, String> map = new HashMap<String, String>();
					for(int index=i+1;index<rows;index++){
						//ȡ�õ�ǰ�еĵ�Ԫ��
						cells = sheet.getRow(index);
						type = eUtils.getType(cells[0].getCellFormat());
						if(Type.SIGN.equals(type)){
							info.row = index;
							break;
						}
						map.put(cells[0].getContents(), cells[1].getContents());
					}
					info.obj = map;
					break;
				}
			}
		}
		if(info == null){
			throw new BLException("IGCO10000.E141","���̻�����Ϣ������");
		}
		return info;
	}

	private Info<IG380Info> getProcessDefinition(Sheet sheet, int row, int rows) throws BLException {
		Info<IG380Info> info = null;
		for(int i=row;i<rows;i++){
			//ȡ�õ�ǰ�еĵ�Ԫ��
			Cell[] cells = sheet.getRow(i);
			Type type = eUtils.getType(cells[0].getCellFormat());
			if(Type.SIGN.equals(type)){
				String contents = cells[0].getContents();
				if(Sign.PDID.toString().equals(contents)){
					String pdid = cells[1].getContents();
					info = new Info<IG380Info>();
					info.obj = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid); 
					info.row = i + 1;
					if(!(i + 1 < rows && sheet.getRow(i + 1)[0].getContents().equals(info.obj.getPdname()))){
						throw new BLException("IGCO10000.E141","���̶�����Ϣ����ȷ");
					}
					break;
				}
			}
		}
		if(info == null){
			throw new BLException("IGCO10000.E141","���̶�����Ϣ������");
		}
		return info;
	}

	private FileInfo uploadFile(FormFile file) throws BLException{
		log.debug("===========�ϴ��ļ�������ʼ============");
		FileInfo info = new FileInfo();
		if(file != null && file.getFileSize() > 0){
			//ʱ���
//			String timestamp = util.getTimestamp();
			String timestamp = IGStringUtils.getAttKey();
			//ȡ�õ�ǰ��
			String year = timestamp.substring(0,4);
			//ȡ�õ�ǰ��
			String month = timestamp.substring(4,6);
			//ȡ�õ�ǰ��
			String day = timestamp.substring(6,8);
			//ȡ�ø�Ŀ¼
//			String rootPath = (String) util.get("TEMPLATE_IMPORT_FILE_PATH");
			String rootPath = ResourceUtility.getString("TEMPLATE_IMPORT_FILE_PATH");
			StringBuffer path = new StringBuffer();
			path.append(rootPath);
			path.append(year);
			path.append(File.separator);
			path.append(month);
			path.append(File.separator);
			path.append(day);
			path.append(File.separator);
			try {
				fileUploadBL.saveFile(file, path.toString(), timestamp + "_" + file.getFileName());
				info.filename = timestamp + "_" + file.getFileName();
				info.success = true;
				info.day = day;
				info.month = month;
				info.day = day;
				info.path = path.toString();
			} catch (BLException e) {
				throw e;
			} catch (Exception e) {
				throw new BLException("IGCO10000.E141","�ϴ��ļ�ʧ��");
			}
		}else{
			throw new BLException("IGCO10000.E141","�ļ����ݲ�����");
		}
		log.debug("===========�ϴ��ļ���������============");
		return info;
	}
	
	class Info<T>{
		
		/** ���ض��� */
		public T obj;
		
		/** ��ȡ�� */
		public int row;
	}
	
	class FileInfo{
		
		/** �ļ��ϴ��Ƿ�ɹ� */
		public boolean success = false;
		
		/** �ϴ�·�� */
		public String path = null;
		
		/** �ļ��� */
		public String filename = null;
		
		/** �� */
		public String year = null;
		
		/** �� */
		public String month = null;
		
		/** �� */
		public String day = null;
		
		/**
		 * ȡ���ļ�����
		 * @return �ļ�����
		 */
		public File getFile(){
			return new File(path + filename);
		}
	}
}
