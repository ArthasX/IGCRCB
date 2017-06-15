package com.deliverik.infogovernor.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.common.OrgValueBean;
import com.csebank.common.SysConfigManager;
import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.form.ITEMS0171Form;
import com.csebank.items.model.InStock;
import com.csebank.items.model.ItemsPay;
import com.csebank.items.model.OutStock;
import com.csebank.items.model.OutStockDetail;
import com.csebank.items.model.Stock;
import com.csebank.items.util.CSEHelper;
import com.csebank.items.util.DefineUtils;
import com.csebank.items.vo.ITEMS01691VO;
import com.csebank.items.vo.ITEMS01692VO;
import com.csebank.items.vo.ITEMS01711VO;
import com.csebank.items.vo.ITEMS01712VO;
import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.IG019Info;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.vo.IGRIS01171VO;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.syslog.model.Mss00006Info;
import com.deliverik.infogovernor.syslog.model.Mss00007Info;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;
import com.deliverik.infogovernor.syslog.model.Mss00009Info;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * Excel���������࣬ÿ��������Ҫ��дһ����Ӧ��exportIGSVC0621����
 */
public class ExportExcel {
	private static Log log = LogFactory.getLog(ExportExcel.class);

	/**
	 * һ���ʲ�ģ��EXCELģ�嵼��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportExcel(OutputStream os,
			List<IG117Info> list, List<Organization> orglist, List<Map<String,List<IG225Info>>> configurationMapList,List<IG545Info> ccdList,List<User> userList) throws Exception {

		IG117Info entity = list.get(0);
		String modelpath = ResourceUtility.getString("EXCEL_FILE_ROOT_PATH");//ģ��·��
		String filepath = ResourceUtility.getString("EXPORT_EXCEL_PATH");//�ļ���·��
		
		//��ȡģ��cell�ĵ�Ԫ���ʽ
		Workbook modeltemplate = ExportExcel.getTemplate("model.xls");
		Sheet wsheetTemplate = modeltemplate.getSheet(0);
		Cell cell0 = wsheetTemplate.getCell(0, 1);
		//CellFormat wcfF = cell0.getCellFormat();
		CellFormat f = cell0.getCellFormat();
		WritableCellFormat wcfF = new WritableCellFormat(f);
		wcfF.setShrinkToFit(true);
		//cells.EntireColumn.AutoFit
		//Cells.EntireColumn.ColumnWidth = Cells.EntireColumn.ColumnWidth + 2
		
		//����ģ�崴��Excel�ļ�
		File modelfile = new File(modelpath+"model.xls");
		File filedir = new File(filepath);
		
		if(!filedir.exists()){
			if(!filedir.mkdirs()){
				throw new BLException("IGASM0112.E001");
			}
		}
		File file = new File(filedir.getPath()+File.separator+entity.getEname()+".xls");
		
		FileInputStream input = new FileInputStream(modelfile);
		FileOutputStream output = new FileOutputStream(file);
		byte[] b = new byte[1024];
		while(input.read(b)!=-1){
			output.write(b);
		}
		input.close();
		output.flush();
		output.close();
		
		//����Workbook����
		Workbook template = Workbook.getWorkbook(new FileInputStream(filepath+entity.getEname()+".xls"));
		WritableWorkbook wwb = Workbook.createWorkbook(os,template);
		
		int sheetNum = 1;
		
		//1.����Excel�ʲ�������Ϣ������
	    WritableSheet ws = wwb.getSheet(0);
	    ws.setName(entity.getEname());
	    ws.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    //���EID
	    Label eidlabel = new Label(0, 1, String.valueOf(entity.getEid()), wcfF);
		ws.addCell(eidlabel);
		//���ģ��esyscoding
	    Label ecodelabel = new Label(1, 1, String.valueOf(entity.getEsyscoding()), wcfF);
		ws.addCell(ecodelabel);
		//���ģ��ename
	    Label enmaelabel = new Label(2, 1, String.valueOf(entity.getEname()), wcfF);
		ws.addCell(enmaelabel);
		
		int num = 0;//��3����ʹ�õ������ļ�����
		
		//���einame
		Label einamelabel = new Label(0, 2, "einame", wcfF);
		ws.addCell(einamelabel);
		Label einamelabeldesc = new Label(0, 4, "�ʲ�����", wcfF);
		ws.addCell(einamelabeldesc);
		
		//ÿʹ�ù�1�оͽ���������1
		num++;
		//���eiorgsyscoding
		for(int i=0;i<6;i++){
			Label eiorgsyscodinglabel = new Label(1+i, 2, (i+1)+"-"+"eiorgsyscoding", wcfF);
			ws.addCell(eiorgsyscodinglabel);
			Label eiorgsyscodinglabeldesc = new Label(1+i, 4, (i+1)+"����������", wcfF);
			ws.addCell(eiorgsyscodinglabeldesc);
			num++;
		}

		//���esyscoding
//		for(int i=0;i<5;i++){
//			Label esyscodinglabel = new Label(7+i, 2, (i+2)+"-"+"esyscoding", wcfF);
//			ws.addCell(esyscodinglabel);
//			Label esyscodinglabeldesc = new Label(7+i, 4, (i+2)+"��ģ������", wcfF);
//			ws.addCell(esyscodinglabeldesc);
//			num++;
//		}

		//���eiidate
		Label eiidatelabel = new Label(num, 2, "eiinsdate", wcfF);
		ws.addCell(eiidatelabel);
		Label eiidatelabeldesc = new Label(num, 4, "�Ǽ���(��ʽΪyyyy/mm/dd)", wcfF);
		ws.addCell(eiidatelabeldesc);
		num++;
		
		//���eiuserid
		Label eiuseridlabel = new Label(num, 2, "eiuserid", wcfF);
		ws.addCell(eiuseridlabel);
		Label eiuseridlabeldesc = new Label(num, 4, "�Ǽ���ID", wcfF);
		ws.addCell(eiuseridlabeldesc);
		num++;
		
		//���eiusername
		Label eiusernamelabel = new Label(num, 2, "eiusername", wcfF);
		ws.addCell(eiusernamelabel);
		Label eiusernamelabeldesc = new Label(num, 4, "�Ǽ�������", wcfF);
		ws.addCell(eiusernamelabeldesc);
		num++;
		
		//����ʲ����������Ϣ
		List<String> ccdcategoryList = new ArrayList<String>();//�õ���ȡֵ��Χ��ccdcategory�ļ���
		
		Map<String,List<IG225Info>> cmap = configurationMapList.get(0);
		Set<Map.Entry<String,List<IG225Info>>> cset = cmap.entrySet();
		for(Iterator<Map.Entry<String,List<IG225Info>>> iter = cset.iterator();iter.hasNext();){
			Map.Entry<String,List<IG225Info>> entry = iter.next();
			//String esys = entry.getKey();
			List<IG225Info> clist = entry.getValue();
			
			for(int i=0,j=clist.size();i<j;i++){
				IG225Info config = clist.get(i);
				//���cid
				Label cidlabel = new Label(num+i, 2, String.valueOf(config.getCid()), wcfF);
				ws.addCell(cidlabel);
				
				//������Ϊ����ʱ�������Ӧ��ȡֵ��Χ,������cid��ӵ�����У����ձ���
				if("2".equals(config.getCattach())){
					Label coptionlabel = new Label(num+i, 3, String.valueOf(config.getCoption()), wcfF);
					ws.addCell(coptionlabel);
					
					//ȡ��ccdcategory������
					ccdcategoryList.add(config.getCoption());
				}
				
				//���cname
				Label cnamelabel = new Label(num+i, 4, String.valueOf(config.getCname()), wcfF);
				ws.addCell(cnamelabel);
			}
			
			num = num + clist.size();
		}
		
		
		//2.����Excel�ʲ�ģ����Ϣ������
//		WritableSheet ws1 = wwb.createSheet("�ʲ�ģ��", sheetNum);
//		sheetNum++;
//		for(int i=0,j=entitylist.size();i<j;i++){
//			Entity e = entitylist.get(i);
//			//����ʲ�����
//			Label elabel = new Label(0, i, String.valueOf(e.getEname()), wcfF);
//			ws1.addCell(elabel);
//			
//			//���esyscoding
//			Label esyslabel = new Label(1, i, String.valueOf(e.getEsyscoding()), wcfF);
//			ws1.addCell(esyslabel);
//			
//			//���eid
//			Label idlabel = new Label(2, i, String.valueOf(e.getEid()), wcfF);
//			ws1.addCell(idlabel);
//		}
		
		
		//3.����Excel������Ϣ������
		WritableSheet ws2 = wwb.createSheet("����", sheetNum);
		sheetNum++;
		for(int i=0,j=orglist.size();i<j;i++){
			Organization org = orglist.get(i);
			//��ӻ�������
			Label orgnamelabel = new Label(0, i, String.valueOf(org.getOrgname()), wcfF);
			ws2.addCell(orgnamelabel);
			
			//��ӻ�������
			Label orgsyslabel = new Label(1, i, String.valueOf(org.getOrgsyscoding()), wcfF);
			ws2.addCell(orgsyslabel);
		}
		
		
		//4.����Excel�ʲ�ģ����Ϣ������
		WritableSheet ws4 = wwb.createSheet("�û�", sheetNum);
		sheetNum++;
		for(int i=0,j=userList.size();i<j;i++){
			User user = userList.get(i);
			//����û�ID
			Label elabel = new Label(0, i, String.valueOf(user.getUserid()), wcfF);
			ws4.addCell(elabel);
			
			//����û�����
			Label esyslabel = new Label(1, i, String.valueOf(user.getUsername()), wcfF);
			ws4.addCell(esyslabel);
			
		}
		
		
		
		
		Map<String,List<IG545Info>> map = new LinkedHashMap<String, List<IG545Info>>();
		
		//����ͬ��ȡֵ��Χ���鱣�浽map��
		for(int i=0,j=ccdcategoryList.size();i<j;i++){
			String ccdcategory = ccdcategoryList.get(i);
			List<IG545Info> scalelist = new ArrayList<IG545Info>();
			for(IG545Info ccd : ccdList){
				if(ccdcategory.equals(ccd.getCcdcategory())){
					scalelist.add(ccd);
				}	
			}
			if(scalelist.size()>0){
				map.put(ccdcategory, scalelist);
			}
		}
		//���ݲ�ͬ��ȡֵ��Χ���ɸ��Ե�sheetҳ
		Set<Map.Entry<String,List<IG545Info>>> set = map.entrySet();
		for(Iterator<Map.Entry<String,List<IG545Info>>> iter = set.iterator();iter.hasNext();){
			Map.Entry<String,List<IG545Info>> entry = iter.next();
			
			//����sheet
			WritableSheet scalews = wwb.createSheet((entry.getValue().get(0).getCcdlabel()+(entry.getKey())), sheetNum);
			sheetNum++;	
			
			//�����ݵ��뵽��sheet��
			for(int i=0,j=entry.getValue().size();i<j;i++){
				IG545Info ccd = entry.getValue().get(i);
				//���ccdcategory
				Label ccdcategorylabel = new Label(0, i, String.valueOf(ccd.getCcdcategory()), wcfF);
				scalews.addCell(ccdcategorylabel);
				
				//���ccdlabel
				Label ccdlabel = new Label(1, i, String.valueOf(ccd.getCcdlabel()), wcfF);
				scalews.addCell(ccdlabel);
				
				//���ccdvalue
				Label ccdvaluelabel = new Label(2, i, String.valueOf(ccd.getCcdvalue()), wcfF);
				scalews.addCell(ccdvaluelabel);
			}
		}

	    //д��Excel
	    wwb.write();
	    //�ر�Excel����������
	    wwb.close();
		//�ر������
		os.close();
	}
	
	/**
	 * SOCһ���ʲ�ģ��EXCELģ�嵼��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportExcel_SOC(OutputStream os,
			List<SOC0117Info> list, List<Organization> orglist, List<Map<String,List<SOC0109Info>>> configurationMapList,List<SOC0151Info> ccdList,List<User> userList) throws Exception {

		SOC0117Info entity = list.get(0);
		String modelpath = ResourceUtility.getString("EXCEL_FILE_ROOT_PATH");//ģ��·��
		String filepath = ResourceUtility.getString("EXPORT_EXCEL_PATH");//�ļ���·��
		
		//��ȡģ��cell�ĵ�Ԫ���ʽ
		Workbook modeltemplate = ExportExcel.getTemplate("model.xls");
		Sheet wsheetTemplate = modeltemplate.getSheet(0);
		Cell cell0 = wsheetTemplate.getCell(0, 1);
		//CellFormat wcfF = cell0.getCellFormat();
		CellFormat f = cell0.getCellFormat();
		WritableCellFormat wcfF = new WritableCellFormat(f);
		wcfF.setShrinkToFit(true);
		//cells.EntireColumn.AutoFit
		//Cells.EntireColumn.ColumnWidth = Cells.EntireColumn.ColumnWidth + 2
		
		//����ģ�崴��Excel�ļ�
		File modelfile = new File(modelpath+"model.xls");
		File filedir = new File(filepath);
		
		if(!filedir.exists()){
			if(!filedir.mkdirs()){
				throw new BLException("IGASM0112.E001");
			}
		}
		File file = new File(filedir.getPath()+File.separator+entity.getEname()+".xls");
		
		FileInputStream input = new FileInputStream(modelfile);
		FileOutputStream output = new FileOutputStream(file);
		byte[] b = new byte[1024];
		while(input.read(b)!=-1){
			output.write(b);
		}
		input.close();
		output.flush();
		output.close();
		
		//����Workbook����
		Workbook template = Workbook.getWorkbook(new FileInputStream(filepath+entity.getEname()+".xls"));
		WritableWorkbook wwb = Workbook.createWorkbook(os,template);
		
		int sheetNum = 1;
		
		//1.����Excel�ʲ�������Ϣ������
	    WritableSheet ws = wwb.getSheet(0);
	    ws.setName(entity.getEname());
	    ws.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    //���EID
	    Label eidlabel = new Label(0, 1, String.valueOf(entity.getEid()), wcfF);
		ws.addCell(eidlabel);
		//���ģ��esyscoding
	    Label ecodelabel = new Label(1, 1, String.valueOf(entity.getEsyscoding()), wcfF);
		ws.addCell(ecodelabel);
		//���ģ��ename
	    Label enmaelabel = new Label(2, 1, String.valueOf(entity.getEname()), wcfF);
		ws.addCell(enmaelabel);
		
		int num = 0;//��3����ʹ�õ������ļ�����
		
		//���einame
		Label einamelabel = new Label(0, 2, "einame", wcfF);
		ws.addCell(einamelabel);
		Label einamelabeldesc = new Label(0, 4, "�ʲ�����", wcfF);
		ws.addCell(einamelabeldesc);
		
		//ÿʹ�ù�1�оͽ���������1
		num++;
		//���eiorgsyscoding
		for(int i=0;i<6;i++){
			Label eiorgsyscodinglabel = new Label(1+i, 2, (i+1)+"-"+"eiorgsyscoding", wcfF);
			ws.addCell(eiorgsyscodinglabel);
			Label eiorgsyscodinglabeldesc = new Label(1+i, 4, (i+1)+"����������", wcfF);
			ws.addCell(eiorgsyscodinglabeldesc);
			num++;
		}

		//���esyscoding
//		for(int i=0;i<5;i++){
//			Label esyscodinglabel = new Label(7+i, 2, (i+2)+"-"+"esyscoding", wcfF);
//			ws.addCell(esyscodinglabel);
//			Label esyscodinglabeldesc = new Label(7+i, 4, (i+2)+"��ģ������", wcfF);
//			ws.addCell(esyscodinglabeldesc);
//			num++;
//		}

		//���eiidate
		Label eiidatelabel = new Label(num, 2, "eiinsdate", wcfF);
		ws.addCell(eiidatelabel);
		Label eiidatelabeldesc = new Label(num, 4, "�Ǽ���(��ʽΪyyyy/mm/dd)", wcfF);
		ws.addCell(eiidatelabeldesc);
		num++;
		
		//���eiuserid
		Label eiuseridlabel = new Label(num, 2, "eiuserid", wcfF);
		ws.addCell(eiuseridlabel);
		Label eiuseridlabeldesc = new Label(num, 4, "�Ǽ���ID", wcfF);
		ws.addCell(eiuseridlabeldesc);
		num++;
		
		//���eiusername
		Label eiusernamelabel = new Label(num, 2, "eiusername", wcfF);
		ws.addCell(eiusernamelabel);
		Label eiusernamelabeldesc = new Label(num, 4, "�Ǽ�������", wcfF);
		ws.addCell(eiusernamelabeldesc);
		num++;
		
		//����ʲ����������Ϣ
		List<String> ccdcategoryList = new ArrayList<String>();//�õ���ȡֵ��Χ��ccdcategory�ļ���
		
		Map<String,List<SOC0109Info>> cmap = configurationMapList.get(0);
		Set<Map.Entry<String,List<SOC0109Info>>> cset = cmap.entrySet();
		for(Iterator<Map.Entry<String,List<SOC0109Info>>> iter = cset.iterator();iter.hasNext();){
			Map.Entry<String,List<SOC0109Info>> entry = iter.next();
			//String esys = entry.getKey();
			List<SOC0109Info> clist = entry.getValue();
			
			for(int i=0,j=clist.size();i<j;i++){
				SOC0109Info config = clist.get(i);
				//���cid
				Label cidlabel = new Label(num+i, 2, String.valueOf(config.getCid()), wcfF);
				ws.addCell(cidlabel);
				
				//������Ϊ����ʱ�������Ӧ��ȡֵ��Χ,������cid��ӵ�����У����ձ���
				if("2".equals(config.getCattach())){
					Label coptionlabel = new Label(num+i, 3, String.valueOf(config.getCoption()), wcfF);
					ws.addCell(coptionlabel);
					
					//ȡ��ccdcategory������
					ccdcategoryList.add(config.getCoption());
				}
				
				//���cname
				Label cnamelabel = new Label(num+i, 4, String.valueOf(config.getCname()), wcfF);
				ws.addCell(cnamelabel);
			}
			
			num = num + clist.size();
		}
		
		
		//2.����Excel�ʲ�ģ����Ϣ������
//		WritableSheet ws1 = wwb.createSheet("�ʲ�ģ��", sheetNum);
//		sheetNum++;
//		for(int i=0,j=entitylist.size();i<j;i++){
//			Entity e = entitylist.get(i);
//			//����ʲ�����
//			Label elabel = new Label(0, i, String.valueOf(e.getEname()), wcfF);
//			ws1.addCell(elabel);
//			
//			//���esyscoding
//			Label esyslabel = new Label(1, i, String.valueOf(e.getEsyscoding()), wcfF);
//			ws1.addCell(esyslabel);
//			
//			//���eid
//			Label idlabel = new Label(2, i, String.valueOf(e.getEid()), wcfF);
//			ws1.addCell(idlabel);
//		}
		
		
		//3.����Excel������Ϣ������
		WritableSheet ws2 = wwb.createSheet("����", sheetNum);
		sheetNum++;
		for(int i=0,j=orglist.size();i<j;i++){
			Organization org = orglist.get(i);
			//��ӻ�������
			Label orgnamelabel = new Label(0, i, String.valueOf(org.getOrgname()), wcfF);
			ws2.addCell(orgnamelabel);
			
			//��ӻ�������
			Label orgsyslabel = new Label(1, i, String.valueOf(org.getOrgsyscoding()), wcfF);
			ws2.addCell(orgsyslabel);
		}
		
		
		//4.����Excel�ʲ�ģ����Ϣ������
		WritableSheet ws4 = wwb.createSheet("�û�", sheetNum);
		sheetNum++;
		for(int i=0,j=userList.size();i<j;i++){
			User user = userList.get(i);
			//����û�ID
			Label elabel = new Label(0, i, String.valueOf(user.getUserid()), wcfF);
			ws4.addCell(elabel);
			
			//����û�����
			Label esyslabel = new Label(1, i, String.valueOf(user.getUsername()), wcfF);
			ws4.addCell(esyslabel);
			
		}
		
		
		
		
		Map<String,List<SOC0151Info>> map = new LinkedHashMap<String, List<SOC0151Info>>();
		
		//����ͬ��ȡֵ��Χ���鱣�浽map��
		for(int i=0,j=ccdcategoryList.size();i<j;i++){
			String ccdcategory = ccdcategoryList.get(i);
			List<SOC0151Info> scalelist = new ArrayList<SOC0151Info>();
			for(SOC0151Info ccd : ccdList){
				if(ccdcategory != null &&ccdcategory.equals(ccd.getCcdcategory())){
					scalelist.add(ccd);
				}	
			}
			if(scalelist.size()>0){
				map.put(ccdcategory, scalelist);
			}
		}
		//���ݲ�ͬ��ȡֵ��Χ���ɸ��Ե�sheetҳ
		Set<Map.Entry<String,List<SOC0151Info>>> set = map.entrySet();
		for(Iterator<Map.Entry<String,List<SOC0151Info>>> iter = set.iterator();iter.hasNext();){
			Map.Entry<String,List<SOC0151Info>> entry = iter.next();
			
			//����sheet
			WritableSheet scalews = wwb.createSheet((entry.getValue().get(0).getCcdlabel()+(entry.getKey())), sheetNum);
			sheetNum++;	
			
			//�����ݵ��뵽��sheet��
			for(int i=0,j=entry.getValue().size();i<j;i++){
				SOC0151Info ccd = entry.getValue().get(i);
				//���ccdcategory
				Label ccdcategorylabel = new Label(0, i, String.valueOf(ccd.getCcdcategory()), wcfF);
				scalews.addCell(ccdcategorylabel);
				
				//���ccdlabel
				Label ccdlabel = new Label(1, i, String.valueOf(ccd.getCcdlabel()), wcfF);
				scalews.addCell(ccdlabel);
				
				//���ccdvalue
				Label ccdvaluelabel = new Label(2, i, String.valueOf(ccd.getCcdvalue()), wcfF);
				scalews.addCell(ccdvaluelabel);
			}
		}

	    //д��Excel
	    wwb.write();
	    //�ر�Excel����������
	    wwb.close();
		//�ر������
		os.close();
	}
	
	
	
	/**
	 * ҵ�����б��浼��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGSVC0621(OutputStream os,
			List<IG359Info> dataList, String opentime_from, String opentime_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGSVC0621.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "ҵ�����б���");	
		if(StringUtils.isEmpty(opentime_from) && StringUtils.isEmpty(opentime_to)){
			setCellByContents(wsheet, "date", "��ѯʱ�䣺");
		}else{
			setCellByContents(wsheet, "date","��ѯʱ�䣺" +(null!=opentime_from ?opentime_from:"") + "��" + (null!=opentime_to?opentime_to:""));
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			Cell cell6 = wsheetTemplate.getCell(6, startrow);
//			CellFormat format6 = cell6.getCellFormat();
			
			int incident = 0;
			int problem = 0;
			int change = 0;
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			int deployment = 0;
			int work = 0;
			int summary = 0;
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				IG359Info data = (IG359Info) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getPrassetname(),
						format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getIncident()
						 + "", format1);
				wsheet.addCell(label1);
				
				incident += data.getIncident();

				Label label2 = new Label(2, j + startrow,
						data.getProblem() + "", format2);
				wsheet.addCell(label2);
				
				problem += data.getProblem();

				Label label3 = new Label(3, j + startrow, data.getChange() + "",
						format3);
				wsheet.addCell(label3);
				
				change += data.getChange();
				
				/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//				Label label4 = new Label(4, j + startrow, data.getDeployment()
//						 + "", format4);
//				wsheet.addCell(label4);
//				
//				deployment += data.getDeployment();

				Label label4 = new Label(4, j + startrow, data.getWork() + "",
						format4);
				wsheet.addCell(label4);
				
				work += data.getWork();

				int count = data.getIncident() + data.getProblem()
						+ data.getChange() + data.getDeployment()
						+ data.getWork();

				Label label5 = new Label(5, j + startrow, String.valueOf(count),
						format5);
				wsheet.addCell(label5);
				
				summary += count;

			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "ͳ��",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(incident), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow,String.valueOf(problem), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow, String.valueOf(change),
					format3);
			wsheet.addCell(label3);
			
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			Label label4 = new Label(4, size + startrow, String.valueOf(deployment), format4);
//			wsheet.addCell(label4);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(work),
					format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, size + startrow, String.valueOf(summary),
					format5);
			wsheet.addCell(label5);
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * �豸���б��浼��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	
	public synchronized static void exportIGSVC0622(OutputStream os,
			List<IG359Info> dataList, String opentime_from, String opentime_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGSVC0622.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�豸���б���");
	
		setCellByContents(wsheet, "date",(null!=opentime_from ?opentime_from:"")  + "~" + (null!=opentime_to ?opentime_to:"") );
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			Cell cell6 = wsheetTemplate.getCell(6, startrow);
//			CellFormat format6 = cell6.getCellFormat();
			
			int incident = 0;
			int problem = 0;
			int change = 0;
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			int deployment = 0;
			int work = 0;
			int summary = 0;
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				IG359Info data = (IG359Info) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getPrassetname(),
						format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getIncident()
						 + "", format1);
				wsheet.addCell(label1);
				
				incident += data.getIncident();

				Label label2 = new Label(2, j + startrow,
						data.getProblem() + "", format2);
				wsheet.addCell(label2);
				
				problem += data.getProblem();

				Label label3 = new Label(3, j + startrow, data.getChange() + "",
						format3);
				wsheet.addCell(label3);
				
				change += data.getChange();

				/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//				Label label4 = new Label(4, j + startrow, data.getDeployment()
//						 + "", format4);
//				wsheet.addCell(label4);
//				
//				deployment += data.getDeployment();

				Label label4 = new Label(4, j + startrow, data.getWork() + "",
						format4);
				wsheet.addCell(label4);
				
				work += data.getWork();

				int count = data.getIncident() + data.getProblem()
						+ data.getChange() + data.getDeployment()
						+ data.getWork();

				Label label5 = new Label(5, j + startrow, String.valueOf(count),
						format5);
				wsheet.addCell(label5);
				
				summary += count;

			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "ͳ��",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(incident), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow,String.valueOf(problem), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow, String.valueOf(change),
					format3);
			wsheet.addCell(label3);
			
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			Label label4 = new Label(4, size + startrow, String.valueOf(deployment), format4);
//			wsheet.addCell(label4);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(work),
					format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, size + startrow, String.valueOf(summary),
					format5);
			wsheet.addCell(label5);
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ��Ա��������
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGSVC0623(OutputStream os,
			List<IG160Info> dataList, String opentime_from, String opentime_to ,String orgName) throws Exception  {
		Workbook template = ExportExcel.getTemplate("IGSVC0623.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��Ա��������");
		//
		setCellByContents(wsheet, "date", "��ѯ���ڣ�"+(null!=opentime_from ?opentime_from:"") + "~" +(null!=opentime_to ?opentime_to:""));
		setCellByContents(wsheet, "date1", "����������"+(null!=orgName ?orgName:""));
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			Cell cell8 = wsheetTemplate.getCell(8, startrow);
//			CellFormat format8 = cell8.getCellFormat();
			int incident = 0;
			int problem = 0;
			int change = 0;
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			int deployment = 0;
			int work = 0;
			int ask=0;
			int summary = 0;
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				IG160Info data = (IG160Info) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getPpusername(),format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getOrgname(),format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow, data.getIncident() + "", format2);
				wsheet.addCell(label2);
				
				incident += data.getIncident();
				
				Label label3 = new Label(3, j + startrow,data.getProblem() + "", format3);
				wsheet.addCell(label3);
				
				problem += data.getProblem();

				Label label4 = new Label(4, j + startrow, data.getChange() + "",format4);
				wsheet.addCell(label4);
				
				change += data.getChange();

				/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//				Label label5 = new Label(5, j + startrow, data.getDeployment() + "", format5);
//				wsheet.addCell(label5);
//				
//				deployment += data.getDeployment();

				Label label5 = new Label(5, j + startrow, data.getWork() + "",format5);
				wsheet.addCell(label5);
				
				work += data.getWork();
				
				Label label6 = new Label(6, j + startrow, data.getAsk() + "",format6);
				wsheet.addCell(label6);
				
				ask += data.getAsk();
				
				int count = data.getIncident() + data.getProblem()
						+ data.getChange() + data.getDeployment()
						+ data.getWork()+data.getAsk();

				Label label7 = new Label(7, j + startrow, String.valueOf(count),format7);
				wsheet.addCell(label7);
				
				summary += count;

			}
			   /*WritableCellFormat wc = new WritableCellFormat();    
	            // ���þ���    
	            wc.setAlignment(Alignment.CENTRE);    
	            // ���ñ߿���    
	            wc.setBorder(Border.ALL, BorderLineStyle.THIN); 
	            wc.setFont(f);*/

			//����ͳ����
			int size = dataList.size();
			
			
			Label label0 = new Label(0, size + startrow, "ͳ��",format0);
			wsheet.addCell(label0);	
			Label label1 = new Label(1, size + startrow, null,format0);
			wsheet.addCell(label1);	
			
			wsheet.mergeCells(0, size + startrow, 1, size + startrow);
			

			Label label2 = new Label(2, size + startrow, String.valueOf(incident), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,String.valueOf(problem), format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(change),format4);
			wsheet.addCell(label4);
			
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			Label label5 = new Label(5, size + startrow, String.valueOf(deployment), format5);
//			wsheet.addCell(label5);
			
			Label label5 = new Label(5, size + startrow, String.valueOf(work),format5);
			wsheet.addCell(label5);
			
			Label label6 = new Label(6, size + startrow, String.valueOf(ask),format6);
			wsheet.addCell(label6);
			
			Label label7 = new Label(7, size + startrow, String.valueOf(summary),format7);
			wsheet.addCell(label7);
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}

	
	/**
	 * �����ϱ�ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	
	
	public synchronized static void exportIGSVC0903(OutputStream os,
			List<IG019Info> dataList, String year, String orgname) throws Exception  {
		Workbook template = ExportExcel.getTemplate("IGSVC0903.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�����ϱ�ͳ��");
		if(StringUtils.isEmpty(orgname)) {
			setCellByContents(wsheet, "date", "���:" + year);
		} else {
			setCellByContents(wsheet, "date", "���:" + year + "    ��������:" + orgname);
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
		
			int work = 0;			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				IG019Info data = (IG019Info) dataList.get(j);
				
				int index=j+1;
				
				Label label0 = new Label(0, j + startrow, String.valueOf(index),format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getOrgname() + "",format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow, data.getIncident() + "", format2);
				wsheet.addCell(label2);
				
								
				Label label3 = new Label(3, j + startrow,data.getServiceRequest() + "", format3);
				wsheet.addCell(label3);
						
				work = data.getIncident()+data.getServiceRequest();

				Label label4 = new Label(4, j + startrow, String.valueOf(work) , format4);
				wsheet.addCell(label4);
								
			}			  						
					
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	
	
	
	/**
	 * ������ȱ���
	 * 
	 * @param ws sheetҳ
	 * @param value ����ֵ
	 * @param newValue	�滻ֵ
	 * @return
	 */
	
	
	public synchronized static void exportIGSVC0624(OutputStream os,
			List<IG003Info> dataList, String currentyear) throws Exception  {
		Workbook template = ExportExcel.getTemplate("IGSVC0624.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "������ȱ���");
		setCellByContents(wsheet, "date",  currentyear+"��");
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();		
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();
			Cell cell10 = wsheetTemplate.getCell(10, startrow);
			CellFormat format10 = cell10.getCellFormat();
			Cell cell11 = wsheetTemplate.getCell(11, startrow);
			CellFormat format11 = cell11.getCellFormat();
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			Cell cell12 = wsheetTemplate.getCell(12, startrow);
//			CellFormat format12 = cell12.getCellFormat();
//			Cell cell13 = wsheetTemplate.getCell(13, startrow);
//			CellFormat format13 = cell13.getCellFormat();
			
			int totalCurrentIncident = 0;
			int totalPrecedingIncident = 0;
			
			int totalCurrentProblem = 0;
			int totalPrecedingProblem = 0;
			
			int totalCurrentChange = 0;
			int totalPrecedingChange = 0;
			
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			int totalCurrentDeployment = 0;
//			int totalPrecedingDeployment = 0;
			
			int totalCurrentWork = 0;
			int totalPrecedingWork = 0;
			
			int totalCurrent = 0;
			int totalPreceding = 0;
			
			int totalMonthCurrent = 0;
			int totalMonthPreceding = 0;
			//���õ�Ԫ��
			
		
			for (int j = 0; j < dataList.size(); j++) {
				IG003Info data = (IG003Info) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getMonth(),format0);
				wsheet.addCell(label0);
				
				//currentIncident
				Label label1 = new Label(1, j + startrow, data.getCurrentIncident() + "",format1);
				wsheet.addCell(label1);
				totalCurrentIncident+=data.getCurrentIncident();
				
                //precedingIncident
				Label label2 = new Label(2, j + startrow, data.getPrecedingIncident() + "", format2);
				wsheet.addCell(label2);
				totalPrecedingIncident+=data.getPrecedingIncident();
				
				//currentProblem
				Label label3 = new Label(3, j + startrow,data.getCurrentProblem() + "", format3);
				wsheet.addCell(label3);		
				totalCurrentProblem +=data.getCurrentProblem();
				
				//precedingProblem
				Label label4 = new Label(4, j + startrow, data.getPrecedingProblem() + "",format4);
				wsheet.addCell(label4);
				totalPrecedingProblem += data.getPrecedingProblem();
				
				//currentChange
				Label label5 = new Label(5, j + startrow, data.getCurrentChange() + "", format5);
				wsheet.addCell(label5);
			    totalCurrentChange += data.getCurrentChange();
				
				//precedingChange
				Label label6 = new Label(6, j + startrow, data.getPrecedingChange() + "",format6);
				wsheet.addCell(label6);
				totalPrecedingChange += data.getPrecedingChange();
				
				/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
				//currentDeployment
//				Label label7 = new Label(7, j + startrow, data.getCurrentDeployment() + "",format7);
//				wsheet.addCell(label7);
//				totalCurrentDeployment += data.getCurrentDeployment();
				
				//precedingDeployment
//				Label label8 = new Label(8, j + startrow, data.getPrecedingDeployment() + "",format8);
//				wsheet.addCell(label8);
//				totalPrecedingDeployment += data.getPrecedingDeployment();
				
				//currentWork
				Label label7 = new Label(7, j + startrow, data.getCurrentWork() + "",format7);
				wsheet.addCell(label7);
				totalCurrentWork += data.getCurrentWork();
				
				//precedingWork
				Label label8 = new Label(8, j + startrow, data.getPrecedingWork() + "",format8);
				wsheet.addCell(label8);
				totalPrecedingWork += data.getPrecedingWork();
				
				//totalCurrent
				
				totalCurrent=data.getCurrentIncident()+data.getCurrentProblem()+data.getCurrentChange()+data.getCurrentDeployment()+data.getCurrentWork();			
				Label label9 = new Label(9, j + startrow, String.valueOf(totalCurrent),format9);
				wsheet.addCell(label9);
				
				//totalPreceding
				totalPreceding=data.getPrecedingIncident()+data.getPrecedingProblem()+data.getPrecedingChange()+data.getPrecedingDeployment()+data.getPrecedingWork();
				Label label10 = new Label(10, j + startrow, String.valueOf(totalPreceding),format10);
				wsheet.addCell(label10);
				
				totalMonthCurrent += totalCurrent;
				totalMonthPreceding+=totalPreceding;
				
				double totalRange = 0;
            	String result = "0";
        		if(totalCurrent != 0 && totalPreceding != 0){
        			double dTotalCurrent = Double.valueOf(totalCurrent);
        			double dTotalPreceding = Double.valueOf(totalPreceding);
        			totalRange = (dTotalCurrent - dTotalPreceding)/dTotalPreceding*100;
        			DecimalFormat df1 = new DecimalFormat("##.##");//##.00%   �ٷֱȸ�ʽ�����治��2λ����0����    
     			    result = df1.format(totalRange);
     			   
        		}
				
				Label label11 = new Label(11, j + startrow, result+"%",format11);
				wsheet.addCell(label11);
											

			}
			  

			//����ͳ����
			int size = dataList.size();
					
			Label label0 = new Label(0, size + startrow, "��ݻ���",format0);
			wsheet.addCell(label0);	
			
			Label label1 = new Label(1, size + startrow, String.valueOf(totalCurrentIncident), format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow, String.valueOf(totalPrecedingIncident), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,String.valueOf(totalCurrentProblem), format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(totalPrecedingProblem),format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, size + startrow, String.valueOf(totalCurrentChange), format5);
			wsheet.addCell(label5);
			
			Label label6 = new Label(6, size + startrow, String.valueOf(totalPrecedingChange),format6);
			wsheet.addCell(label6);
			
			/** 2012.06.29 wanglei ����mantis�ϱ��0005657�޸�BUG�������ļ������ط��� */
//			Label label7 = new Label(7, size + startrow, String.valueOf(totalCurrentDeployment),format7);
//			wsheet.addCell(label7);
//			
//			Label label8 = new Label(8, size + startrow, String.valueOf(totalPrecedingDeployment),format8);
//			wsheet.addCell(label8);
			
			Label label7 = new Label(7, size + startrow, String.valueOf(totalCurrentWork),format7);
			wsheet.addCell(label7);
			
			Label label8 = new Label(8, size + startrow, String.valueOf(totalPrecedingWork),format8);
			wsheet.addCell(label8);
			
			Label label9 = new Label(9, size + startrow, String.valueOf(totalMonthCurrent),format9);
			wsheet.addCell(label9);
			
			Label label10 = new Label(10, size + startrow, String.valueOf(totalMonthPreceding),format10);
			wsheet.addCell(label10);
			
			
			double totalRange = 0;
        	String result = "0";
    		if(totalMonthCurrent != 0 && totalMonthPreceding != 0){
    			double dTotalCurrent = Double.valueOf(totalMonthCurrent);
    			double dTotalPreceding = Double.valueOf(totalMonthPreceding);
    			totalRange = (dTotalCurrent - dTotalPreceding)/dTotalPreceding*100;
    			DecimalFormat df1 = new DecimalFormat("##.##");//##.00%   �ٷֱȸ�ʽ�����治��2λ����0����    
 			    result = df1.format(totalRange);
 			  
    		}
			
    		Label label11 = new Label(11, size + startrow, result+"%",format11);
			wsheet.addCell(label11);
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ��Ʊ���
	 * 
	 * @param ws sheetҳ
	 * @param value ����ֵ
	 * @param newValue	�滻ֵ
	 * @return
	 */
	
	
	public synchronized static void exportIGRIS0120(OutputStream os,
			IGRIS01171VO vo) throws Exception  {
		List<RiskAuditDefResultVWInfo> dataList = vo.getRiskAuditDefResultVWInfoList();
		
		//���ճ̶�
		List<CodeDetail> radrisklevel = vo.getRadrisklevelList();
		int radrisklevelSize = vo.getRadrisklevelSizeColspan();
		
		//����Ƶ��
		List<CodeDetail> radfrequency=vo.getRadfrequencyList();
		int radfrequencySize= vo.getRadfrequencySizeColspan();
		
		//�����ֶ�
		List<CodeDetail> radModeList =vo.getRadmodeList();
		int radmodeSize =vo.getRadmodeSizeColspan();
		
		//��������
		List<CodeDetail> radtype=vo.getRadtypeList();
		int radtypeSize =vo.getRadtypeSizeColspan();
		
		//�ƶȽ�����Ч�� 
		List<CodeDetail> rarplanscore=vo.getRarplanscoreList();
		int rarplanscoreSize=vo.getRarplanscoreSizeColspan();
		
		//�ƶ�ִ����Ч��	
		
		List<CodeDetail> rarExecscoreList=vo.getRarexecscoreList();
		int rarExecscoreSize=vo.getRarexecscoreSizeColspan();
		
		//����
		List<CodeDetail>  raroverallscoreList=vo.getRaroverallscoreList();
		int raroverallscoreSize=vo.getRaroverallscoreSizeColspan();
		
		
		Workbook template = ExportExcel.getTemplate("IGRIS0120.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		setCellByContents(wsheet, "date", "��Ʊ�ţ�" + vo.getRiskAuditIns().getRaicode() + "  ���ڣ�" + IGStringUtils.getCurrentDate());
		Map<String,Integer> countMap = new HashMap<String,Integer>();
		
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��Ʊ���");
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			//���
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			//�����Ŀ
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			//����
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			//���ճ̶�
			Cell cellRis = wsheetTemplate.getCell(3, startrow);
			CellFormat formatRis = cellRis.getCellFormat();
			//�����˲���
			int  pos_risklevel = 3 + radrisklevelSize;
			
			Cell cellOrg = wsheetTemplate.getCell(pos_risklevel, startrow);
			CellFormat formatOrg = cellOrg.getCellFormat();	
			//����������
			int pos_orgname = pos_risklevel + 1;
			
			Cell cellOrgName = wsheetTemplate.getCell(pos_orgname, startrow);
			CellFormat formatOrgName = cellOrgName.getCellFormat();	
			//����Ƶ��
			int pos_frequency = pos_orgname + 1;
			
			Cell cellFrequency = wsheetTemplate.getCell(pos_frequency, startrow);
			CellFormat formatFrequency = cellFrequency.getCellFormat();
			//�����ֶ�
			int pos_mode = pos_frequency + radfrequencySize;
			
			Cell cellRadmode = wsheetTemplate.getCell(pos_mode, startrow);
			CellFormat formatRadmode = cellRadmode.getCellFormat();
			//��������
			int pos_type = pos_mode + radmodeSize;
			
			Cell cellType = wsheetTemplate.getCell(pos_type, startrow);
			CellFormat formatType = cellType.getCellFormat();
			//������			
			int pos_rarusername = pos_type + radtypeSize;
			
			Cell cellRarusername = wsheetTemplate.getCell(pos_rarusername, startrow);
			CellFormat formatRarusername = cellRarusername.getCellFormat();
			//�ƶȽ�����Ч��
			int pos_rarplanScore = pos_rarusername + 1;
			
			Cell cellRarplanScore = wsheetTemplate.getCell(pos_rarplanScore, startrow);
			CellFormat formatRarplanScore = cellRarplanScore.getCellFormat();
			//�ƶȽ�����Ч������
			int pos_rarplandesc= pos_rarplanScore + rarplanscoreSize;
			
			Cell cellRarplandesc = wsheetTemplate.getCell(pos_rarplandesc , startrow);
			CellFormat formatRarplandesc = cellRarplandesc.getCellFormat();
			//�ƶ�ִ����Ч��
			int pos_rarexeScore = pos_rarplandesc + 1;
			
			Cell cellRarexeScore = wsheetTemplate.getCell(pos_rarexeScore, startrow);
			CellFormat formatRarexeScore = cellRarexeScore.getCellFormat();
			//�ƶ�ִ����Ч������
			int pos_rarexedesc= pos_rarexeScore + rarExecscoreSize;
			
			Cell cellRarexedesc = wsheetTemplate.getCell(pos_rarexedesc , startrow);
			CellFormat formatRarexedesc = cellRarexedesc.getCellFormat();
			//��������
			int pos_rarallScore = pos_rarexedesc + 1;
			
			Cell cellRarallScore = wsheetTemplate.getCell(pos_rarallScore, startrow);
			CellFormat formatRarallScore = cellRarallScore.getCellFormat();
			//��������
			int pos_raralldesc= pos_rarallScore + raroverallscoreSize;
			
			Cell cellRaralldesc = wsheetTemplate.getCell(pos_raralldesc , startrow);
			CellFormat formatRaralldesc = cellRaralldesc.getCellFormat();
			
			
			
		
			for (int j = 0; j < dataList.size(); j++) {
				RiskAuditDefResultVWInfo data = (RiskAuditDefResultVWInfo) dataList.get(j);

				//����Ѹ����ڵ�ĸ��ڵ�����ƴ�Ӷ���
				String radparcode = data.getRadparcode();
				if(countMap.containsKey(radparcode)) {
					countMap.put(radparcode,countMap.get(radparcode) + 1);
				} else {
					countMap.put(radparcode,1);
				} 
				String levelCode = countMap.get(radparcode) + "";
				int level = Integer.parseInt(data.getRadlevel());
				for(int i = level - 1; i > 0; i--) {
					String parcode = radparcode.substring(0 , radparcode.length() -3);
					radparcode = radparcode.substring(0 , radparcode.length() -3);
					levelCode = countMap.get(parcode) + "." +levelCode;
				}
				
				Label label0 = new Label(0, j + startrow, String.valueOf(levelCode),format0);
				wsheet.addCell(label0);
				
				String radname = data.getRadname();
				int radLevel= Integer.parseInt(data.getRadlevel());
				for(int i = 1; i < radLevel; i++) {
					radname = "      " + radname;
				}
				
				Label label1 = new Label(1, j + startrow,radname,format1);
				wsheet.addCell(label1);
						
				Label label2 = new Label(2, j + startrow, data.getRaddesc(),format2);
				wsheet.addCell(label2);
				
				//���ճ̶�
				String radRisklevel=data.getRadrisklevel();
										
				for(int i = 0; i < radrisklevelSize; i++) {
					Label label = new Label(3 + i, j + startrow, (null!=radRisklevel && radRisklevel.equals(radrisklevel.get(i).getCid()))?"��":"",formatRis);
					wsheet.addCell(label);
				}
		
							
				Label labelOrg = new Label(pos_risklevel, j + startrow, data.getRadorg(),formatOrg);
				wsheet.addCell(labelOrg);
				
				Label labelOrgName = new Label(pos_orgname, j + startrow,data.getRadusername(),formatOrgName);
				wsheet.addCell(labelOrgName);
				

				//����Ƶ��
				
				String radFrequency=data.getRadfrequency();
			
				for(int i=0;i<radfrequencySize;i++){
					
					Label labe = new Label(pos_frequency + i, j + startrow, (null!=radFrequency && radFrequency.equals(radfrequency.get(i).getCid()))?"��":"",formatFrequency);
					wsheet.addCell(labe);
				}
						
				
				//�����ֶ�
				String radMode=data.getRadmode();
				
				
				for(int i=0;i<radmodeSize;i++){
					
					Label label = new Label(pos_mode + i, j + startrow, (null!=radMode && radMode.equals(radModeList.get(i).getCid()))?"��":"",formatRadmode);
					wsheet.addCell(label);

				}
				//��������
			
				String radType=data.getRadtype();
				
				for(int i=0;i<radtypeSize;i++){
					Label label = new Label(pos_type + i, j + startrow, (null!=radType && radType.equals(radtype.get(i).getCid()))?"��":"",formatType);
					wsheet.addCell(label);
				}
				

				//������
				Label label = new Label(pos_rarusername, j + startrow,data.getRarusername(),formatRarusername);
				wsheet.addCell(label);
				
				
				//�ƶȽ�����Ч�� 
				String rarplanScore=data.getRarplanscore();
				for(int i=0;i<rarplanscoreSize;i++){			
					Label labelRarplanScore = new Label(pos_rarplanScore + i, j + startrow,(null!=rarplanScore && rarplanScore.equals(rarplanscore.get(i).getCid()))?"��":"",formatRarplanScore);
					wsheet.addCell(labelRarplanScore);
				}

				//�ƶȽ�������
				Label labeRarplandesc = new Label(pos_rarplandesc, j + startrow,data.getRarplandesc(),formatRarplandesc);
				wsheet.addCell(labeRarplandesc);
				
				
				//�ƶ�ִ����Ч��			
				String rarexecscore=data.getRarexecscore();
				for(int i=0;i<rarExecscoreSize;i++){
					Label labelRarExecscoreSize = new Label(pos_rarexeScore + i, j + startrow,(null!=rarexecscore && rarexecscore.equals(rarExecscoreList.get(i).getCid()))?"��":"",formatRarexeScore);
					wsheet.addCell(labelRarExecscoreSize);
				}
				//�ƶ�ִ������ 
				Label labelrarExecscore = new Label(pos_rarexedesc, j + startrow,data.getRarexecdesc(),formatRarexedesc);
				wsheet.addCell(labelrarExecscore);

				//��������				
				String raroverallscore=data.getRaroverallscore();
				
				for(int i=0;i<raroverallscoreSize;i++){
					Label labelRaroverallscore = new Label(pos_rarallScore + i, j + startrow,(null!=raroverallscore && raroverallscore.equals(raroverallscoreList.get(i).getCid()))?"��":"",formatRarallScore);
					wsheet.addCell(labelRaroverallscore);
				}
				//��������
				Label labelRaroverallscore = new Label(pos_raralldesc, j + startrow,data.getRaroveralldesc(),formatRaralldesc);
				wsheet.addCell(labelRaroverallscore);
			}		  	
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * �豸����ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGASM1304(OutputStream os,
			List<IG011Info> dataList, String eiorgsyscoding_qname, String orgType) throws Exception  {
		Workbook template = ExportExcel.getTemplate("IGASM1304.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�豸����ͳ��");
		if(StringUtils.isEmpty(eiorgsyscoding_qname)) {
			eiorgsyscoding_qname = "";
		}
		if("0".equals(orgType)){
			setCellByContents(wsheet, "date", "����������"+ eiorgsyscoding_qname );		
		}else if("1".equals(orgType)){
			setCellByContents(wsheet, "date", "ʹ�û�����"+ eiorgsyscoding_qname );
		}
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			
	        
			int totalAll=0;
		
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				IG011Info data = (IG011Info) dataList.get(j);
				
				int index=j+1;

				Label label0 = new Label(0, j + startrow, String.valueOf(index),format0);
				wsheet.addCell(label0);
				//cvalue
				Label label1 = new Label(1, j + startrow, data.getCvalue() + "",format1);
				wsheet.addCell(label1);
              
				Label label2 = new Label(2, j + startrow, data.getTotal() + "", format2);
				wsheet.addCell(label2);				
				totalAll+=data.getTotal();
				Label label3 = new Label(3, j + startrow,data.getProportion() + "", format3);
				wsheet.addCell(label3);
								

			}
			

			//����ͳ����
			int size = dataList.size();
			
			
			Label label0 = new Label(0, size + startrow, "�ϼ�",format0);
			
			wsheet.addCell(label0);	
			
			Label label1 = new Label(1, size + startrow, "", format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow, String.valueOf(totalAll), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,"", format3);
			wsheet.addCell(label3);
			
			
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * �豸�ֲ�ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGASM1309(OutputStream os,
			 List<IG445Info> dataList) throws Exception  {
		Workbook template = ExportExcel.getTemplate("IGASM1309.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 2;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�豸�ֲ�ͳ��");
		
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����3��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			
	        
			int totalAll=0;
		
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				IG445Info data = (IG445Info) dataList.get(j);
				
				int index=j+1;

				Label label0 = new Label(0, j + startrow, String.valueOf(index),format0);
				wsheet.addCell(label0);
			
				Label label1 = new Label(1, j + startrow, data.getOrgname() + "",format1);
				wsheet.addCell(label1);
           
				Label label2 = new Label(2, j + startrow, data.getCount() + "", format2);
				wsheet.addCell(label2);				
				totalAll+=data.getCount();
				
				Label label3 = new Label(3, j + startrow,data.getProportion() + "", format3);
				wsheet.addCell(label3);
								

			}
			

			//����ͳ����
			int size = dataList.size();
			
			
			Label label0 = new Label(0, size + startrow, "�ϼ�",format0);
			
			wsheet.addCell(label0);	
			
			Label label1 = new Label(1, size + startrow, "", format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow, String.valueOf(totalAll), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,"", format3);
			wsheet.addCell(label3);
			
			
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * �½��豸ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGASM1305(OutputStream os,
			List<IG011Info> dataList, String eiorgsyscoding_qname,String ciupdtime_from,String ciupdtime_to) throws Exception  {
		Workbook template = ExportExcel.getTemplate("IGASM1311.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�½��豸ͳ��");
		if(StringUtils.isEmpty(eiorgsyscoding_qname)) {
			eiorgsyscoding_qname = "";
		}
		setCellByContents(wsheet, "date", "����������"+ eiorgsyscoding_qname);
		if(StringUtils.isEmpty(ciupdtime_from) && StringUtils.isEmpty(ciupdtime_to)){
			setCellByContents(wsheet, "date1", "��ѯʱ�䣺");
		}else{
			if(StringUtils.isEmpty(ciupdtime_from)){
				setCellByContents(wsheet, "date1", "��ѯʱ�䣺��ֹ��" + (null!=ciupdtime_to?ciupdtime_to:"") + "Ϊֹ");
			}else if(StringUtils.isEmpty(ciupdtime_to)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				setCellByContents(wsheet, "date1", "��ѯʱ�䣺"+ (null!=ciupdtime_from ?ciupdtime_from:"") + "��" + sdf.format(new Date()));
			}else {
				setCellByContents(wsheet, "date1", "��ѯʱ�䣺"+ (null!=ciupdtime_from ?ciupdtime_from:"") + "��" + (null!=ciupdtime_to?ciupdtime_to:""));
			}
		}
	
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			
	        
			int totalAll=0;
		
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				IG011Info data = (IG011Info) dataList.get(j);
				
				int index=j+1;

				Label label0 = new Label(0, j + startrow, String.valueOf(index),format0);
				wsheet.addCell(label0);
				//cvalue
				Label label1 = new Label(1, j + startrow, data.getCvalue() + "",format1);
				wsheet.addCell(label1);
              
				Label label2 = new Label(2, j + startrow, data.getTotal() + "", format2);
				wsheet.addCell(label2);				
				totalAll+=data.getTotal();
				Label label3 = new Label(3, j + startrow,data.getProportion() + "", format3);
				wsheet.addCell(label3);
								

			}
			

			//����ͳ����
			int size = dataList.size();
			
			
			Label label0 = new Label(0, size + startrow, "�ϼ�",format0);
			
			wsheet.addCell(label0);	
			
			Label label1 = new Label(1, size + startrow, "", format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow, String.valueOf(totalAll), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,"", format3);
			wsheet.addCell(label3);
			
			
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	
	/**
	 * �½��豸�ֲ�ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGASM1310(OutputStream os,
			 List<IG445Info> dataList, String eiorgsyscoding_qname,String ciupdtime_from,String ciupdtime_to) throws Exception  {
		Workbook template = ExportExcel.getTemplate("IGASM1310.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�½��豸�ֲ�ͳ��");
		
		setCellByContents(wsheet, "date", "����������"+ eiorgsyscoding_qname);
		
		if(StringUtils.isEmpty(ciupdtime_from) && StringUtils.isEmpty(ciupdtime_to)){
			setCellByContents(wsheet, "date1", "��ѯʱ�䣺");
		}else{
			setCellByContents(wsheet, "date1", "��ѯʱ�䣺"+ (null!=ciupdtime_from ?ciupdtime_from:"") + "��" + (null!=ciupdtime_to?ciupdtime_to:""));
		}
		
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			
	        
			int totalAll=0;
		
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				IG445Info data = (IG445Info) dataList.get(j);
				
				int index=j+1;

				Label label0 = new Label(0, j + startrow, String.valueOf(index),format0);
				wsheet.addCell(label0);
			
				Label label1 = new Label(1, j + startrow, data.getOrgname() + "",format1);
				wsheet.addCell(label1);
           
				Label label2 = new Label(2, j + startrow, data.getCount() + "", format2);
				wsheet.addCell(label2);				
				totalAll+=data.getCount();
				
				Label label3 = new Label(3, j + startrow,data.getProportion() + "", format3);
				wsheet.addCell(label3);
								

			}
			

			//����ͳ����
			int size = dataList.size();
			
			
			Label label0 = new Label(0, size + startrow, "�ϼ�",format0);
			
			wsheet.addCell(label0);	
			
			Label label1 = new Label(1, size + startrow, "", format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow, String.valueOf(totalAll), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,"", format3);
			wsheet.addCell(label3);
			
			
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}

	/**
	 * ���ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0131(OutputStream os,
			List<InStock> dataList, String ciupdtime_from,String ciupdtime_to,String eiorgsyscoding_qname,
			String seqcode_q, String itemsname_q) throws Exception  {
		Workbook template = ExportExcel.getTemplate("ITEMS0131.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "���ͳ��");
		if(StringUtils.isEmpty(eiorgsyscoding_qname)) {
			eiorgsyscoding_qname = "ȫ��";
		}
		//
		setCellByContents(wsheet, "date", "����������"+ eiorgsyscoding_qname );
		
		if(StringUtils.isEmpty(ciupdtime_from) && StringUtils.isEmpty(ciupdtime_to)){
			setCellByContents(wsheet, "date1", "��ѯʱ�䣺");
		}else{
			setCellByContents(wsheet, "date1","��ѯʱ�䣺" +(null!=ciupdtime_from ?ciupdtime_from:"") + "��" + (null!=ciupdtime_to?ciupdtime_to:""));	
		}
		
		if(StringUtils.isEmpty(seqcode_q)){
			setCellByContents(wsheet, "date2", "��Ʒ��ţ�");
		}else{
			setCellByContents(wsheet, "date2","��Ʒ��ţ�" + seqcode_q);	
		}
		
		if(StringUtils.isEmpty(itemsname_q)){
			setCellByContents(wsheet, "date3", "��Ʒ���ƣ�");
		}else{
			setCellByContents(wsheet, "date3","��Ʒ���ƣ�" + itemsname_q);	
		}
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();
//			int totalAll=0;
		    String codeValue=null;
		    
		    int innum = 0;
		    Double inamount = 0d;
		    int outnum = 0;
		    int lossnum = 0;
		    int havocnum = 0;
		    
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				InStock data = (InStock) dataList.get(j);
	
				Label label0 = new Label(0, j + startrow,data.getSeqcode(),format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow,data.getItemsname(),format1);
				wsheet.addCell(label1);
				
				codeValue=data.getType();
				String out = SysConfigManager.getConfigInfo("2_" + codeValue);
				Label label2 = new Label(2, j + startrow,out , format2);
				wsheet.addCell(label2);				
			
				Label label3 = new Label(3, j + startrow,data.getIntime(), format3);
				wsheet.addCell(label3);
					
				Label label4 = new Label(4, j + startrow,data.getInnum().toString(), format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow, data.getInprice() + "",format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, j + startrow, data.getInamount() + "",format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,data.getOutnum().toString(), format7);
				wsheet.addCell(label7);
			
				Label label8 = new Label(8, j + startrow,data.getLossnum().toString(), format8);
				wsheet.addCell(label8);
				
				Label label9 = new Label(9, j + startrow,data.getHavocnum().toString(), format9);
				wsheet.addCell(label9);
				
				innum+=data.getInnum();
				outnum+=data.getOutnum();
				lossnum+=data.getLossnum();
				havocnum+=data.getHavocnum();
				inamount = CSEHelper.getAdd(String.valueOf(inamount), String.valueOf(data.getInamount())).doubleValue();
			}		
			
			//���Ӻϼ���
			
			Label label0 = new Label(0, dataList.size() + startrow,"�ϼ�",format0);
			wsheet.addCell(label0);
			
			Label label1 = new Label(1, dataList.size() + startrow,"",format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, dataList.size() + startrow,"", format2);
			wsheet.addCell(label2);				
		
			Label label3 = new Label(3, dataList.size() + startrow,"", format3);
			wsheet.addCell(label3);
				
			Label label4 = new Label(4, dataList.size() + startrow,String.valueOf(innum), format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, dataList.size() + startrow, "",format5);
			wsheet.addCell(label5);
			
			Label label6 = new Label(6, dataList.size() + startrow, String.valueOf(inamount),format6);
			wsheet.addCell(label6);
			
			Label label7 = new Label(7, dataList.size() + startrow,String.valueOf(outnum), format7);
			wsheet.addCell(label7);
		
			Label label8 = new Label(8, dataList.size() + startrow,String.valueOf(lossnum), format8);
			wsheet.addCell(label8);
			
			Label label9 = new Label(9, dataList.size() + startrow,String.valueOf(havocnum), format9);
			wsheet.addCell(label9);
		}
		
		
		wwb.write();
		wwb.close();
		os.close();
	}

	/**
	 * ����ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0132(OutputStream os,
			List<OutStock> dataList, String ciupdtime_from,String ciupdtime_to,String eiorgsyscoding_qname,String typecode,
			String accountstatus_q,String reqstatus,String seqcode_q, String itemsname_q) throws Exception  {
		
		ITEMS01BL items01BL = (ITEMS01BL)WebApplicationSupport.getBean("items01BL");
		Workbook template = ExportExcel.getTemplate("ITEMS0132.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 6;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "����ͳ��");
		if(StringUtils.isEmpty(eiorgsyscoding_qname)) {
			eiorgsyscoding_qname = "ȫ��";
		}
		String typeName = items01BL.getOutTypeName(DefineUtils.ITEMSCODES_OUTSTOCK_OUTTYPE,typecode);
		setCellByContents(wsheet, "date", "����������"+ eiorgsyscoding_qname);
		setCellByContents(wsheet, "date1", "��������:" + typeName);
		if(StringUtils.isEmpty(ciupdtime_from) && StringUtils.isEmpty(ciupdtime_to)){
			setCellByContents(wsheet, "date2", "��ѯʱ�䣺");
		}else{
			setCellByContents(wsheet, "date2", "��ѯʱ�䣺"+ (null!=ciupdtime_from ?ciupdtime_from:"") + "��" + (null!=ciupdtime_to?ciupdtime_to:""));
		}
		
		if(accountstatus_q.equals(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_WJZ)){
			setCellByContents(wsheet, "date3", "����״̬: δ����");
		}else if(accountstatus_q.equals(DefineUtils.ITEMSCODES_ACCOUNTSTATUS_YJZ)){
			setCellByContents(wsheet, "date3", "����״̬: �ѽ���");
		}else{
			setCellByContents(wsheet, "date3", "����״̬:");
		}
		
		if(reqstatus.equals(DefineUtils.ITEMSCODES_REQSTATUS_DJS)){
			setCellByContents(wsheet, "date4", "����״̬: ������");
		}else if(reqstatus.equals(DefineUtils.ITEMSCODES_REQSTATUS_CKWC)){
			setCellByContents(wsheet, "date4", "����״̬: �������");
		}else{
			setCellByContents(wsheet, "date4", "����״̬:");
		}

		if(StringUtils.isEmpty(seqcode_q)){
			setCellByContents(wsheet, "date5", "��Ʒ��ţ�");
		}else{
			setCellByContents(wsheet, "date5","��Ʒ��ţ�" + seqcode_q);	
		}
		
		if(StringUtils.isEmpty(itemsname_q)){
			setCellByContents(wsheet, "date6", "��Ʒ���ƣ�");
		}else{
			setCellByContents(wsheet, "date6","��Ʒ���ƣ�" + itemsname_q);	
		}
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����5��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();

			Double outamount = 0d;
			int outnum = 0;
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				OutStock data = (OutStock) dataList.get(j);
		
				
				Label label0 = new Label(0, j + startrow,data.getSeqcode(),format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow,data.getItemsname() , format1);
				wsheet.addCell(label1);				

				Label label2 = new Label(2, j + startrow,data.getTypecode(), format2);
				wsheet.addCell(label2);
					
				String out = OrgValueBean.getConfigInfo(data.getReqorg());
				Label label3 = new Label(3, j + startrow,out, format3);
				wsheet.addCell(label3);
				
				
				String temp = SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS + "_" + data.getAccountstatus());
				Label label4 = new Label(4, j + startrow,temp, format4);
				wsheet.addCell(label4);
				
				String temp1 = SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_OUTSTOCK_REQSTATUS + "_" + data.getReqstatus());
				Label label5 = new Label(5, j + startrow,temp1, format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, j + startrow,data.getOutnum().toString(), format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,data.getOuttime().toString(), format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, j + startrow,data.getOutprice().toString(), format8);
				wsheet.addCell(label8);
				String outCount = data.getOutamount().toString();
				if("4".equals(data.getOuttype())||"5".equals(data.getOuttype())){
					outCount="0";
				}
				Label label9 = new Label(9, j + startrow,outCount, format9);
				wsheet.addCell(label9);

				outnum+=data.getOutnum();
				outamount = CSEHelper.getAdd(String.valueOf(outamount), outCount).doubleValue();
			}		
			
			//���Ӻϼ���
			
			Label label0 = new Label(0, dataList.size() + startrow,"�ϼ�",format0);
			wsheet.addCell(label0);
			
			Label label1 = new Label(1, dataList.size() + startrow,"" , format1);
			wsheet.addCell(label1);				

			Label label2 = new Label(2, dataList.size() + startrow,"", format2);
			wsheet.addCell(label2);

			Label label3 = new Label(3, dataList.size() + startrow,"", format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, dataList.size() + startrow,"", format4);
			wsheet.addCell(label4);
		
			Label label5 = new Label(5, dataList.size() + startrow,"", format5);
			wsheet.addCell(label5);
			
			Label label6 = new Label(6, dataList.size() + startrow,String.valueOf(outnum), format6);
			wsheet.addCell(label6);
		
			Label label7 = new Label(7, dataList.size() + startrow,"", format7);
			wsheet.addCell(label7);
			
			Label label8 = new Label(8, dataList.size() + startrow,"", format8);
			wsheet.addCell(label8);
			
			Label label9 = new Label(9, dataList.size() + startrow,String.valueOf(outamount), format9);
			wsheet.addCell(label9);
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}

	/**
	 * ���ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0133(OutputStream os,
			List<Stock> dataList, List<Integer> chknumList ,String stockorg_qname,String category,
			String seqcode_q, String itemsname_q) throws Exception  {
		
		ITEMS01BL items01BL = (ITEMS01BL)WebApplicationSupport.getBean("items01BL");
		Workbook template = ExportExcel.getTemplate("ITEMS0133.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "���ͳ��");
		if(StringUtils.isEmpty(stockorg_qname)) {
			stockorg_qname = "ȫ��";
		}
		String typeName = items01BL.getOutTypeName(DefineUtils.ITEMSCODES_STOCK_CATEGORY,category);
		setCellByContents(wsheet, "date", "����������"+ stockorg_qname);
		setCellByContents(wsheet, "date1", "��Ʒ����:" + typeName);

		if(StringUtils.isEmpty(seqcode_q)){
			setCellByContents(wsheet, "date2", "��Ʒ��ţ�");
		}else{
			setCellByContents(wsheet, "date2","��Ʒ��ţ�" + seqcode_q);	
		}
		
		if(StringUtils.isEmpty(itemsname_q)){
			setCellByContents(wsheet, "date3", "��Ʒ���ƣ�");
		}else{
			setCellByContents(wsheet, "date3","��Ʒ���ƣ�" + itemsname_q);	
		}
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();		
			
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();	
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();	

			int stocknum = 0;
		    int lostnum = 0;
		    int chknum = 0;
		    Double amount = 0d;
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Stock data = (Stock) dataList.get(j);
		
				String codeValue=data.getCategory();
				String categoryName = SysConfigManager.getConfigInfo("1_" + codeValue);
				
				Label label0 = new Label(0, j + startrow,categoryName,format0);
				wsheet.addCell(label0);
			
				Label label1 = new Label(1, j + startrow, data.getSeqcode(),format1);
				wsheet.addCell(label1);
                			
				Label label2 = new Label(2, j + startrow,data.getTypecode() , format2);
				wsheet.addCell(label2);				

				Label label3 = new Label(3, j + startrow,data.getItemsname(), format3);
				wsheet.addCell(label3);
					
				String typeValue=data.getType();
				String typeValueName = SysConfigManager.getConfigInfo("2_" + typeValue);
				
				Label label4 = new Label(4, j + startrow,typeValueName, format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow,String.valueOf(data.getStocknum()), format5);
				wsheet.addCell(label5);

				Label label6 = new Label(6, j + startrow,String.valueOf(data.getLostnum()), format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,String.valueOf(chknumList.get(0)), format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, j + startrow,String.valueOf(data.getPrice()), format8);
				wsheet.addCell(label8);
				
				Label label9 = new Label(9, j + startrow,String.valueOf(data.getAmount()), format9);
				wsheet.addCell(label9);
				
				stocknum+=data.getStocknum();
				lostnum+=data.getLostnum();
				chknum+=chknumList.get(0);
				amount = CSEHelper.getAdd(String.valueOf(amount), String.valueOf(data.getAmount())).doubleValue();
			}		
			//���Ӻϼ���

			Label label0 = new Label(0, dataList.size() + startrow,"�ϼ�",format0);
			wsheet.addCell(label0);
		
			Label label1 = new Label(1, dataList.size() + startrow,"" ,format1);
			wsheet.addCell(label1);
            			
			Label label2 = new Label(2, dataList.size() + startrow,"" , format2);
			wsheet.addCell(label2);				

			Label label3 = new Label(3, dataList.size() + startrow,"" , format3);
			wsheet.addCell(label3);

			Label label4 = new Label(4, dataList.size() + startrow,"" , format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, dataList.size() + startrow,String.valueOf(stocknum), format5);
			wsheet.addCell(label5);

			Label label6 = new Label(6, dataList.size() + startrow,String.valueOf(lostnum), format6);
			wsheet.addCell(label6);
			
			Label label7 = new Label(7, dataList.size() + startrow,String.valueOf(chknum), format7);
			wsheet.addCell(label7);
			
			Label label8 = new Label(8, dataList.size() + startrow,"" , format8);
			wsheet.addCell(label8);
			
			Label label9 = new Label(9, dataList.size() + startrow,String.valueOf(amount), format9);
			wsheet.addCell(label9);
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ����ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0134(OutputStream os,
			List<OutStock> dataList, String ciupdtime_from,String ciupdtime_to,String eiorgsyscoding_qname) throws Exception  {
		try{
//		ITEMS01BL items01BL = (ITEMS01BL)WebApplicationSupport.getBean("items01BL");
		Workbook template = ExportExcel.getTemplate("ITEMS0134.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "����ͳ��");
		if(StringUtils.isEmpty(eiorgsyscoding_qname)) {
			eiorgsyscoding_qname = "ȫ��";
		}
		setCellByContents(wsheet, "date", "����������"+ eiorgsyscoding_qname);
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();		
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();
			Cell cell10 = wsheetTemplate.getCell(10, startrow);
			CellFormat format10 = cell10.getCellFormat();
			String outtype;
			String accountstatus;
			String reqorg;
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				OutStock data = (OutStock) dataList.get(j);
				
				reqorg = OrgValueBean.getConfigInfo(data.getReqorg());
				
				Label label0 = new Label(0, j + startrow, reqorg,format0);
				wsheet.addCell(label0);
				//cvalue
				Label label1 = new Label(1, j + startrow, data.getSeqcode(),format1);
				wsheet.addCell(label1);
                			
				Label label2 = new Label(2, j + startrow,data.getItemsname() , format2);
				wsheet.addCell(label2);				

				Label label3 = new Label(3, j + startrow,data.getTypecode(), format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow,String.valueOf(data.getOutnum()), format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow,String.valueOf(data.getOutprice()), format5);
				wsheet.addCell(label5);
			
				Label label6 = new Label(6, j + startrow,String.valueOf(data.getOutamount()), format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,data.getOuttime(), format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, j + startrow,data.getRcvtime(), format8);
				wsheet.addCell(label8);
				
				outtype = SysConfigManager.getConfigInfo("5" + "_" + data.getOuttype());
				
				Label label9 = new Label(9, j + startrow,outtype, format9);
				wsheet.addCell(label9);
				
				accountstatus = SysConfigManager.getConfigInfo("7" + "_" + data.getAccountstatus());
				
				Label label10 = new Label(10, j + startrow,accountstatus, format10);
				wsheet.addCell(label10);
			}		
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * �����嵥
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0167(OutputStream os,
			Map<String,Map<String,String>> outmap, String ciupdtime_from,String ciupdtime_to) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("ITEMS0167.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "���Ͱ��Ż����嵥");
		
		if(StringUtils.isEmpty(ciupdtime_from) && StringUtils.isEmpty(ciupdtime_to)){
			setCellByContents(wsheet, "date", "��ѯʱ�䣺");
		}else{
			setCellByContents(wsheet, "date", "��ѯʱ�䣺"+ (null!=ciupdtime_from ?ciupdtime_from:"") + "��" + (null!=ciupdtime_to?ciupdtime_to:""));
		}
		
		if (outmap != null && outmap.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����3��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			
			

			//���õ�Ԫ��
			Set<Map.Entry<String,Map<String,String>>> set = outmap.entrySet();
			int j = 0;
			for(Iterator<Map.Entry<String,Map<String,String>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<String,Map<String,String>> entry = iter.next();
				
				Map<String,String> packmap = entry.getValue();
				Set<Map.Entry<String,String>> set1 = packmap.entrySet();
				
				String reqorg;
				for(Iterator<Map.Entry<String,String>> iter1 = set1.iterator();iter1.hasNext();){
					Map.Entry<String,String> entry1 = iter1.next();
					reqorg = OrgValueBean.getConfigInfo(entry1.getKey());//����
					
					Label label0 = new Label(0, j + startrow, entry.getKey(),format0);//����ʱ��
					wsheet.addCell(label0);
			
					Label label1 = new Label(1, j + startrow, reqorg,format1);//����
					wsheet.addCell(label1);
	                			
					Label label2 = new Label(2, j + startrow,entry1.getValue(),format2);//������
					wsheet.addCell(label2);				

					Label label3 = new Label(3, j + startrow,"", format3);//������ǩ��
					wsheet.addCell(label3);
					j++;
				}

			}
		
			
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �����嵥��ϸ
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0168(OutputStream os,
			List<OutStock> dataList, String ciupdtime_from,String ciupdtime_to) throws Exception  {
		try{
			Workbook template = ExportExcel.getTemplate("ITEMS0168.xls");
			Sheet wsheetTemplate = template.getSheet(0);
			WritableWorkbook wwb = Workbook.createWorkbook(os, template);
			WritableSheet wsheet = wwb.getSheet(0);
			wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
			int startrow = 3;
			//�滻ָ����Ԫ��
			setCellByContents(wsheet, "title", "������Ʒ�嵥��ϸ");
			if(StringUtils.isEmpty(ciupdtime_from) && StringUtils.isEmpty(ciupdtime_to)){
				setCellByContents(wsheet, "date", "��ѯʱ�䣺");
			}else{
				setCellByContents(wsheet, "date", "��ѯʱ�䣺"+ (null!=ciupdtime_from ?ciupdtime_from:"") + "��" + (null!=ciupdtime_to?ciupdtime_to:""));
			}
			
			if (dataList != null && dataList.size() > 0) {
				// ��ȡָ����Ԫ���ʽ����4��
				Cell cell0 = wsheetTemplate.getCell(0, startrow);
				CellFormat format0 = cell0.getCellFormat();
				Cell cell1 = wsheetTemplate.getCell(1, startrow);
				CellFormat format1 = cell1.getCellFormat();
				Cell cell2 = wsheetTemplate.getCell(2, startrow);
				CellFormat format2 = cell2.getCellFormat();
				Cell cell3 = wsheetTemplate.getCell(3, startrow);
				CellFormat format3 = cell3.getCellFormat();		
				Cell cell4 = wsheetTemplate.getCell(4, startrow);
				CellFormat format4 = cell4.getCellFormat();
				Cell cell5 = wsheetTemplate.getCell(5, startrow);
				CellFormat format5 = cell5.getCellFormat();
				Cell cell6 = wsheetTemplate.getCell(6, startrow);
				CellFormat format6 = cell6.getCellFormat();
				Cell cell7 = wsheetTemplate.getCell(7, startrow);
				CellFormat format7 = cell7.getCellFormat();		
				
				String reqorg;
				String category;
				//���õ�Ԫ��
				for (int j = 0; j < dataList.size(); j++) {
					OutStock data = (OutStock) dataList.get(j);
					
					reqorg = OrgValueBean.getConfigInfo(data.getReqorg());
					category =  SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_STOCK_CATEGORY + "_" + data.getCategory());
					
					Label label0 = new Label(0, j + startrow, reqorg,format0);
					wsheet.addCell(label0);
					
					Label label1 = new Label(1, j + startrow, data.getPackno(),format1);
					wsheet.addCell(label1);
					
					Label label2 = new Label(2, j + startrow,data.getOuttime() , format2);
					wsheet.addCell(label2);				
					
					Label label3 = new Label(3, j + startrow,data.getSeqcode(), format3);
					wsheet.addCell(label3);
					
					Label label4 = new Label(4, j + startrow,data.getItemsname(), format4);
					wsheet.addCell(label4);
					
					Label label5 = new Label(5, j + startrow,data.getTypecode(), format5);
					wsheet.addCell(label5);
					
					Label label6 = new Label(6, j + startrow,category, format6);
					wsheet.addCell(label6);
					
					Label label7 = new Label(7, j + startrow,String.valueOf(data.getOutnum()), format7);
					wsheet.addCell(label7);
					
					
				}		
			}
			wwb.write();
			wwb.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �ֿ��������
	 * 
	 * @param os
	 * @param vo
	 * @param reqtime_f
	 * @param reqtime_t
	 * @throws Exception
	 */
	public static void exportITEMS0169(OutputStream os,
			ITEMS01691VO vo , String reqtime_f,String reqtime_t) throws Exception  {
		try{
			Workbook template = ExportExcel.getTemplate("ITEMS0169.xls");
			Sheet wsheetTemplate = template.getSheet(0);
			WritableWorkbook wwb = Workbook.createWorkbook(os, template);
			WritableSheet wsheet = wwb.getSheet(0);
			wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
			int startrow = 3;
			//�滻ָ����Ԫ��
			setCellByContents(wsheet, "title", "�ֿ��������");
			if(StringUtils.isEmpty(reqtime_f) && StringUtils.isEmpty(reqtime_t)){
				setCellByContents(wsheet, "date", "��ѯʱ�䣺");
			}else{
				setCellByContents(wsheet, "date", "��ѯʱ�䣺"+ (null!=reqtime_f ?reqtime_f:"") + "��" + (null!=reqtime_t?reqtime_t:""));
			}
			
			List<ITEMS01692VO> dataList = vo.getItems01692VOList();
			
			if (dataList != null && dataList.size() > 0) {
				// ��ȡָ����Ԫ���ʽ����4��
				Cell cell0 = wsheetTemplate.getCell(0, startrow);
				CellFormat format0 = cell0.getCellFormat();
				Cell cell1 = wsheetTemplate.getCell(1, startrow);
				CellFormat format1 = cell1.getCellFormat();
				Cell cell2 = wsheetTemplate.getCell(2, startrow);
				CellFormat format2 = cell2.getCellFormat();
				Cell cell3 = wsheetTemplate.getCell(3, startrow);
				CellFormat format3 = cell3.getCellFormat();		
				Cell cell4 = wsheetTemplate.getCell(4, startrow);
				CellFormat format4 = cell4.getCellFormat();
				Cell cell5 = wsheetTemplate.getCell(5, startrow);
				CellFormat format5 = cell5.getCellFormat();
				Cell cell6 = wsheetTemplate.getCell(6, startrow);
				CellFormat format6 = cell6.getCellFormat();
				Cell cell7 = wsheetTemplate.getCell(7, startrow);
				CellFormat format7 = cell7.getCellFormat();		
				Cell cell8 = wsheetTemplate.getCell(8, startrow);
				CellFormat format8 = cell8.getCellFormat();		
				Cell cell9 = wsheetTemplate.getCell(9, startrow);
				CellFormat format9 = cell9.getCellFormat();		
				Cell cell10 = wsheetTemplate.getCell(10, startrow);
				CellFormat format10 = cell10.getCellFormat();		
				Cell cell11 = wsheetTemplate.getCell(11, startrow);
				CellFormat format11 = cell11.getCellFormat();			
				Cell cell12 = wsheetTemplate.getCell(12, startrow);
				CellFormat format12 = cell12.getCellFormat();	
				
				String reqorg_name;
				String category_name;
				String outtype_name;
				BigDecimal inamount;
				
				Integer num = 0;
				BigDecimal inprice = new BigDecimal("0");
				BigDecimal incost = new BigDecimal("0");
				BigDecimal outprice = new BigDecimal("0");
				BigDecimal outcost = new BigDecimal("0");
				BigDecimal synum = new BigDecimal("0");
				//���õ�Ԫ��
				for (int j = 0; j < dataList.size(); j++) {
					OutStock data = (OutStock) dataList.get(j).getOutStock();
					
					reqorg_name = OrgValueBean.getConfigInfo(data.getReqorg());
					category_name =  SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_STOCK_CATEGORY + "_" + data.getCategory());
					outtype_name =  SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_OUTSTOCK_OUTTYPE + "_" + data.getOuttype());
					inamount = CSEHelper.getMultiply(String.valueOf(dataList.get(j).getInPrice()),String.valueOf(dataList.get(j).getCount()));
					
					Label label0 = new Label(0, j + startrow, reqorg_name,format0);
					wsheet.addCell(label0);
					
					Label label1 = new Label(1, j + startrow, outtype_name,format1);
					wsheet.addCell(label1);
					
					Label label2 = new Label(2, j + startrow,data.getReqtime() , format2);
					wsheet.addCell(label2);				
					
					Label label3 = new Label(3, j + startrow,data.getSeqcode(), format3);
					wsheet.addCell(label3);
					
					Label label4 = new Label(4, j + startrow,data.getItemsname(), format4);
					wsheet.addCell(label4);
					
					Label label5 = new Label(5, j + startrow,data.getTypecode(), format5);
					wsheet.addCell(label5);
					
					Label label6 = new Label(6, j + startrow,category_name, format6);
					wsheet.addCell(label6);
					/////////////////////////////////////////////////////////////////////////////////
					Label label7 = new Label(7, j + startrow,dataList.get(j).getCount(), format7);
					wsheet.addCell(label7);
					
					Label label8 = new Label(8, j + startrow,dataList.get(j).getInPrice(), format8);
					wsheet.addCell(label8);
					
					Label label9 = new Label(9, j + startrow,inamount.toString(), format9);
					wsheet.addCell(label9);
					
					Label label10 = new Label(10, j + startrow,dataList.get(j).getOutPrice(), format10);
					wsheet.addCell(label10);
					
					Label label11 = new Label(11, j + startrow,dataList.get(j).getCountPrice(), format11);
					wsheet.addCell(label11);
					
					Label label12 = new Label(12, j + startrow,dataList.get(j).getIncome(), format12);
					wsheet.addCell(label12);
					
					num = num+Integer.parseInt(dataList.get(j).getCount());
					inprice = inprice.add(new BigDecimal(dataList.get(j).getInPrice()));
					incost = incost.add(new BigDecimal(inamount.toString()));
					if(!"/".equals(dataList.get(j).getOutPrice())){
						outprice = outprice.add(new BigDecimal(dataList.get(j).getOutPrice()));
					}
					if(!"/".equals(dataList.get(j).getCountPrice())){
						outcost = outcost.add(new BigDecimal(dataList.get(j).getCountPrice()));
					}
					if(!"/".equals(dataList.get(j).getIncome())){
						synum = synum.add(new BigDecimal(dataList.get(j).getIncome()));
					}
					
					
				}		
				Label label0 = new Label(0, dataList.size() + startrow, "�ϼ�",format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, dataList.size() + startrow, "",format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, dataList.size() + startrow,"" , format2);
				wsheet.addCell(label2);				
				
				Label label3 = new Label(3, dataList.size() + startrow,"", format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, dataList.size() + startrow,"", format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, dataList.size() + startrow,"", format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, dataList.size() + startrow,"", format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, dataList.size() + startrow,String.valueOf(num), format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, dataList.size() + startrow,inprice.toString(), format8);
				wsheet.addCell(label8);
				
				Label label9 = new Label(9, dataList.size() + startrow,incost.toString(), format9);
				wsheet.addCell(label9);
				
				Label label10 = new Label(10, dataList.size() + startrow,outprice.toString(), format10);
				wsheet.addCell(label10);
				
				Label label11 = new Label(11, dataList.size() + startrow,outcost.toString(), format11);
				wsheet.addCell(label11);
				
				Label label12 = new Label(12, dataList.size() + startrow,synum.toString(), format12);
				wsheet.addCell(label12);
			}
			wwb.write();
			wwb.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * ��һ��Ʒ������ϸ
	 * 
	 * @param os
	 * @param vo
	 * @param form
	 * @throws Exception
	 */
	public static void exportITEMS0171(OutputStream os,
			ITEMS01711VO vo , ITEMS0171Form form) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("ITEMS0171.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��һ��Ʒ������ϸ");
		if(StringUtils.isEmpty(form.getOuttime_f()) && StringUtils.isEmpty(form.getOuttime_t())){
			setCellByContents(wsheet, "date", "��ѯʱ�䣺");
		}else{
			setCellByContents(wsheet, "date", "��ѯʱ�䣺"+ (null!=form.getOuttime_f() ?form.getOuttime_f():"") + "��" + (null!=form.getOuttime_t()?form.getOuttime_t():""));
		}
		//��Ʒ���
		setCellByContents(wsheet, "seqcode", form.getSeqcode());
		//��Ʒ����
		setCellByContents(wsheet, "itemsname", form.getItemsname());
		//��Ʒ�ͺ�
		setCellByContents(wsheet, "typecode", form.getTypecode());
		//��Ʒ���
		String category_name =  SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_STOCK_CATEGORY + "_" + form.getCategory());
		setCellByContents(wsheet, "category", category_name);
		
		List<ITEMS01712VO> dataList = vo.getItems01712VOList();
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();		
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();		
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();		
			Cell cell10 = wsheetTemplate.getCell(10, startrow);
			CellFormat format10 = cell10.getCellFormat();		
			
			String reqorg_name;
			String outtype_name;
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				OutStockDetail data = (OutStockDetail) dataList.get(j).getOutStockDetail();
				
				reqorg_name = OrgValueBean.getConfigInfo(data.getReqorg());
				outtype_name =  SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_OUTSTOCK_OUTTYPE + "_" + data.getOuttype());
				
				Label label0 = new Label(0, j + startrow, dataList.get(j).getDate(),format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, outtype_name,format1);
				wsheet.addCell(label1);
                			
				Label label2 = new Label(2, j + startrow,reqorg_name , format2);
				wsheet.addCell(label2);				

				Label label3 = new Label(3, j + startrow,dataList.get(j).getInNum(), format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow,dataList.get(j).getInPrice(), format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow,dataList.get(j).getInCountPrice(), format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, j + startrow,dataList.get(j).getOutNum(), format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,dataList.get(j).getOutPrice(), format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, j + startrow,dataList.get(j).getOutCountPrice(), format8);
				wsheet.addCell(label8);
				
				Label label9 = new Label(9, j + startrow,dataList.get(j).getIncome(), format9);
				wsheet.addCell(label9);
				
				Label label10 = new Label(10, j + startrow,dataList.get(j).getStockNum() + "", format10);
				wsheet.addCell(label10);
				
			}		
			int length = dataList.size();
			Label label0 = new Label(0, length + startrow, "�ϼ�",format0);
			wsheet.addCell(label0);
			
			Label label1 = new Label(1, length + startrow, null,format1);
			wsheet.addCell(label1);
            			
			Label label2 = new Label(2, length + startrow,null , format2);
			wsheet.addCell(label2);				

			Label label3 = new Label(3, length + startrow,null, format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, length + startrow,null, format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, length + startrow,null, format5);
			wsheet.addCell(label5);
			
			Label label6 = new Label(6, length + startrow,null, format6);
			wsheet.addCell(label6);
			
			Label label7 = new Label(7, length + startrow,null, format7);
			wsheet.addCell(label7);
			
			Label label8 = new Label(8, length + startrow,null, format8);
			wsheet.addCell(label8);
			
			Label label9 = new Label(9, length + startrow,vo.getTotal(), format9);
			wsheet.addCell(label9);
			
			Label label10 = new Label(10, length + startrow,null, format10);
			wsheet.addCell(label10);
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �����嵥
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0135(OutputStream os,
			List<ItemsPay> paymentList, String starttime,String endtime) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("ITEMS0135.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "���ܽ��");
		if(StringUtils.isEmpty(starttime) && StringUtils.isEmpty(endtime)){
			setCellByContents(wsheet, "date", "ʱ��Σ�");
		}else{
			setCellByContents(wsheet, "date", "ʱ��Σ�" + starttime + "��" + endtime);
		}
		
		if (paymentList != null && paymentList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			
			String reqorg;
			Double notpayment = 0d;
			Double payment = 0d;
			Double amount = 0d;
			
			//���õ�Ԫ��
			for (int j = 0; j < paymentList.size(); j++) {
				ItemsPay data = paymentList.get(j);
				
				reqorg = OrgValueBean.getConfigInfo(data.getReqorg());
				Label label0 = new Label(0, j + startrow, reqorg,format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, CSEHelper.round(String.valueOf(data.getNotpayment()),2) + "",format1);
				wsheet.addCell(label1);
                			
				Label label2 = new Label(2, j + startrow,CSEHelper.round(String.valueOf(data.getPayment()),2) + "" , format2);
				wsheet.addCell(label2);				

				Label label3 = new Label(3, j + startrow,CSEHelper.round(String.valueOf((data.getNotpayment() + data.getPayment())),2) + "" , format3);
				wsheet.addCell(label3);
				
				notpayment = CSEHelper.getAdd(String.valueOf(notpayment), String.valueOf(data.getNotpayment())).doubleValue();
				notpayment = CSEHelper.round(String.valueOf(notpayment), 2);
				payment = CSEHelper.getAdd(String.valueOf(payment), String.valueOf(data.getPayment())).doubleValue();
				payment = CSEHelper.round(String.valueOf(payment), 2);
				amount = CSEHelper.getAdd(String.valueOf(amount), String.valueOf(data.getNotpayment() + data.getPayment())).doubleValue();
				amount = CSEHelper.round(String.valueOf(amount), 2);
			}		
			//����ͳ����
			int size = paymentList.size();
			
			
			Label label0 = new Label(0, size + startrow, "�ϼ�",format0);
			
			wsheet.addCell(label0);	
			
			Label label1 = new Label(1, size + startrow, String.valueOf(notpayment), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow, String.valueOf(payment), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,String.valueOf(amount), format3);
			wsheet.addCell(label3);
		}
		
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ֧�н����嵥��ϸ
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0138(OutputStream os,
			List<OutStock> dataList, String outtime_f,String outtime_t,String reqorg) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("ITEMS0138.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		reqorg = OrgValueBean.getConfigInfo(reqorg);
		setCellByContents(wsheet, "title", "֧�н����嵥��ϸ");
		setCellByContents(wsheet, "orgname", reqorg);
		setCellByContents(wsheet, "date", (null!=outtime_f ?outtime_f:"") + "��" + (null!=outtime_t?outtime_t:""));
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();		
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();	
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();	
			
			Double amount = 0d;
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				OutStock data = dataList.get(j);
				
				Label label0 = new Label(0, j + startrow, data.getOuttime() ,format0);
				wsheet.addCell(label0);
				
				String outtype = SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_OUTSTOCK_OUTTYPE + "_" + data.getOuttype());
				Label label1 = new Label(1, j + startrow, outtype,format1);
				wsheet.addCell(label1);
                			
				Label label2 = new Label(2, j + startrow,data.getSeqcode() , format2);
				wsheet.addCell(label2);				

				Label label3 = new Label(3, j + startrow,data.getItemsname(), format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow,data.getTypecode(), format4);
				wsheet.addCell(label4);
				
				String category =  SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_STOCK_CATEGORY + "_" + data.getCategory());
				Label label5 = new Label(5, j + startrow,category, format5);
				wsheet.addCell(label5);
			
				String accountstatus = SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS + "_" + data.getAccountstatus());
				Label label6 = new Label(6, j + startrow,accountstatus, format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,data.getOutprice() + "", format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, j + startrow,data.getOutnum() + "", format8);
				wsheet.addCell(label8);
				
				Label label9 = new Label(9, j + startrow,data.getOutamount() + "", format9);
				wsheet.addCell(label9);

				amount = CSEHelper.getAdd(String.valueOf(amount), String.valueOf(data.getOutamount())).doubleValue();
				amount = CSEHelper.round(String.valueOf(amount), 2);
			}	
			//����ͳ����
			int size = dataList.size();
			
			
			Label label0 = new Label(0, size + startrow, "�ϼ�",format0);
			wsheet.addCell(label0);	

			Label label1 = new Label(1, size + startrow, "",format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow, "",format2);
			wsheet.addCell(label2);

			Label label3 = new Label(3, size + startrow, "",format3);
			wsheet.addCell(label3);

			Label label4 = new Label(4, size + startrow, "",format4);
			wsheet.addCell(label4);

			Label label5 = new Label(5, size + startrow, "",format5);
			wsheet.addCell(label5);

			Label label6 = new Label(6, size + startrow, "",format6);
			wsheet.addCell(label6);

			Label label7 = new Label(7, size + startrow, "",format7);
			wsheet.addCell(label7);

			Label label8 = new Label(8, size + startrow, "",format8);
			wsheet.addCell(label8);
			
			Label label9 = new Label(9, size + startrow,String.valueOf(amount), format9);
			wsheet.addCell(label9);		
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �����嵥ȫ��ϸ
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportITEMS0139(OutputStream os,
			List<OutStock> dataList, String outtime_f,String outtime_t) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("ITEMS0139.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�����嵥ȫ��ϸ");
		setCellByContents(wsheet, "date", "ʱ��Σ�" + (null!=outtime_f ?outtime_f:"") + "��" + (null!=outtime_t?outtime_t:""));
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();		
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();	
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();	
			Cell cell10 = wsheetTemplate.getCell(10, startrow);
			CellFormat format10 = cell10.getCellFormat();	
			
			Double amount = 0d;
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				OutStock data = dataList.get(j);
				String reqorg = OrgValueBean.getConfigInfo(data.getReqorg());
				
				Label label0 = new Label(0, j + startrow, reqorg ,format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getOuttime() ,format1);
				wsheet.addCell(label1);
				
				String outtype = SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_OUTSTOCK_OUTTYPE + "_" + data.getOuttype());
				Label label2 = new Label(2, j + startrow, outtype,format2);
				wsheet.addCell(label2);
                			
				Label label3 = new Label(3, j + startrow,data.getSeqcode() , format3);
				wsheet.addCell(label3);				

				Label label4 = new Label(4, j + startrow,data.getItemsname(), format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow,data.getTypecode(), format5);
				wsheet.addCell(label5);
				
				String category =  SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_STOCK_CATEGORY + "_" + data.getCategory());
				Label label6 = new Label(6, j + startrow,category, format6);
				wsheet.addCell(label6);
			
				String accountstatus = SysConfigManager.getConfigInfo(DefineUtils.ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS + "_" + data.getAccountstatus());
				Label label7 = new Label(7, j + startrow,accountstatus, format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, j + startrow,data.getOutprice() + "", format8);
				wsheet.addCell(label8);
				
				Label label9 = new Label(9, j + startrow,data.getOutnum() + "", format9);
				wsheet.addCell(label9);
				
				Label label10 = new Label(10, j + startrow,data.getOutamount() + "", format10);
				wsheet.addCell(label10);
				

				amount = CSEHelper.getAdd(String.valueOf(amount), String.valueOf(data.getOutamount())).doubleValue();
				amount = CSEHelper.round(String.valueOf(amount), 2);
			}	
			//����ͳ����
			int size = dataList.size();
			
			
			Label label0 = new Label(0, size + startrow, "�ϼ�",format0);
			wsheet.addCell(label0);	

			Label label1 = new Label(1, size + startrow, "",format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow, "",format2);
			wsheet.addCell(label2);

			Label label3 = new Label(3, size + startrow, "",format3);
			wsheet.addCell(label3);

			Label label4 = new Label(4, size + startrow, "",format4);
			wsheet.addCell(label4);

			Label label5 = new Label(5, size + startrow, "",format5);
			wsheet.addCell(label5);

			Label label6 = new Label(6, size + startrow, "",format6);
			wsheet.addCell(label6);

			Label label7 = new Label(7, size + startrow, "",format7);
			wsheet.addCell(label7);

			Label label8 = new Label(8, size + startrow, "",format8);
			wsheet.addCell(label8);

			Label label9 = new Label(9, size + startrow, "",format9);
			wsheet.addCell(label9);
			
			Label label10 = new Label(10, size + startrow,String.valueOf(amount), format10);
			wsheet.addCell(label10);	
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ������־����
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static void exportIGPRR0115(OutputStream os,
			List<IG036Info> recordLogs, IG500Info pr, String dealtime,
			Map<String, IG007Info> processInfoDef) throws Exception {
		try {
			Workbook template = ExportExcel.getTemplate("IGPRR0115.xls");
			Sheet wsheetTemplate = template.getSheet(0);
			WritableWorkbook wwb = Workbook.createWorkbook(os, template);
			WritableSheet wsheet = wwb.getSheet(0);
			wsheet.getSettings().setScaleFactor(
					wsheetTemplate.getSettings().getScaleFactor());
			// ģ��ھ��У�������8���и�
			int row8 = wsheet.getRowHeight(8);
			
			int startrow = 19;
			int start = 8;
			int pf = 0;
			
			// ����ʱ�����ݽ��������е�����
			int pi = 7;
			
			Cell cell00 = wsheetTemplate.getCell(0, start);
			CellFormat format00 = cell00.getCellFormat();
//			Cell cell01 = wsheetTemplate.getCell(1, start);
//			CellFormat format01 = cell01.getCellFormat();
			WritableCellFormat format01 = new WritableCellFormat();
			format01.setBorder(Border.ALL, BorderLineStyle.THIN);
			Cell cell02 = wsheetTemplate.getCell(1, start);
			CellFormat format02 = cell02.getCellFormat();

			// �滻ָ����Ԫ��
			String attnamedesc = "";
			for (int j = 0; j < recordLogs.size(); j++) {
				IG036Info recordLog = recordLogs.get(j);
				List<Attachment> attacList = recordLog.getAttachmentList();
				if (attacList != null) {
					for (Attachment attachment : attacList) {
						if ("".equals(attnamedesc)) {
							attnamedesc = attachment.getAttname().toString()
									.split("_")[1]
									+ "\n";
						} else {
							attnamedesc += attachment.getAttname().toString()
									.split("_")[1]
									+ "\n";
						}
					}
				}
			}
			setCellByContents(wsheet, "title", "��־��Ϣ");
			setCellByContents(wsheet, "prusername", pr.getPrusername());
			setCellByContents(wsheet, "prrolename", pr.getPrrolename());
			setCellByContents(wsheet, "prinfo", pr.getPrinfo());
			setCellByContents(wsheet, "prorgname", pr.getProrgname());
			setCellByContents(wsheet, "prserialnum", pr.getPrserialnum());
			setCellByContents(wsheet, "prtitle", pr.getPrtitle());
			setCellByContents(wsheet, "prdesc", pr.getPrdesc() + "\n"
					+ attnamedesc);
			setCellByContents(wsheet, "prpdname", pr.getPrpdname());
			setCellByContents(wsheet, "propentime", pr.getPropentime());
			setCellByContents(wsheet, "dealtime", dealtime);
			if(processInfoDef != null){
				for (String num : processInfoDef.keySet()) {
					if (StringUtils.isNotEmpty(processInfoDef.get(num)
							.getPidvalue())) {
						Label label00 = new Label(0, pf + start, processInfoDef
								.get(num).getPidlabel(), format00);
						wsheet.addCell(label00);
						
						if (StringUtils.isNotEmpty(processInfoDef.get(num)
								.getPidvalue())
								&& processInfoDef.get(num).getPidvalue().contains(
										"_role_")) {
							Label label01 = new Label(1, pf + start, processInfoDef
									.get(num).getPidvalue().split("_role_")[1],
									format01);
							wsheet.addCell(label01);
							Label label02 = new Label(2, pf + start, "", format02);
							wsheet.addCell(label02);
						} else if (StringUtils.isNotEmpty(processInfoDef.get(num)
								.getPidvalue())
								&& processInfoDef.get(num).getPidvalue().contains(
										"_asset_")) {
							Label label01 = new Label(1, pf + start, processInfoDef
									.get(num).getPidvalue().split("_asset_")[1],
									format01);
							wsheet.addCell(label01);
							Label label02 = new Label(2, pf + start, "", format02);
							wsheet.addCell(label02);
						} else if (StringUtils.isNotEmpty(processInfoDef.get(num)
								.getPidvalue())
								&& processInfoDef.get(num).getPidvalue().contains(
										"_svc_")) {
							Label label01 = new Label(1, pf + start, processInfoDef
									.get(num).getPidvalue().split("_svc_")[1],
									format01);
							wsheet.addCell(label01);
							Label label02 = new Label(2, pf + start, "", format02);
							wsheet.addCell(label02);
						} else if (StringUtils.isNotEmpty(processInfoDef.get(num)
								.getPidvalue())
								&& processInfoDef.get(num).getPidvalue().contains(
										"_prj_")) {
							Label label01 = new Label(1, pf + start, processInfoDef
									.get(num).getPidvalue().split("_prj_")[1],
									format01);
							wsheet.addCell(label01);
							Label label02 = new Label(2, pf + start, "", format02);
							wsheet.addCell(label02);
						} else {
							if(processInfoDef.get(num).getPidname().contains("_collect")){
//								processInfoDef.get(num).getPidvalue().replace(";", "\012");
//								String replaceAll = processInfoDef.get(num).getPidvalue().replaceAll(";", "\012");
								int length = processInfoDef.get(num).getPidvalue().split(";").length;
								
								wsheet.setRowView(pf + start, row8*length); // �����и�
								Label label01 = new Label(1, pf + start, processInfoDef.get(num).getPidvalue(), format01);
								wsheet.addCell(label01);
								Label label02 = new Label(2, pf + start, "", format02);
								wsheet.addCell(label02);
							}else{
								Label label01 = new Label(1, pf + start, processInfoDef
										.get(num).getPidvalue(), format01);
								wsheet.addCell(label01);
								Label label02 = new Label(2, pf + start, "", format02);
								wsheet.addCell(label02);
							}
						}
						
						// ����ʱ�����������еĵ�Ԫ��ϲ�(�ӵ�2�п�ʼ��)
						wsheet.mergeCells(1, pf + start, pi, pf + start);
						pf = pf + 1;
					}

				} 
			}
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();

			// ���õ�Ԫ��
			for (int j = 0; j < recordLogs.size(); j++) {
				IG036Info recordLog = recordLogs.get(j);
				List<Attachment> attacList = recordLog.getAttachmentList();
				String attname = "";
				if (attacList != null) {
					for (Attachment attachment : attacList) {
						if ("".equals(attname)) {
							attname = attachment.getAttname().toString().split(
									"_")[1]
									+ "\n";
						} else {
							attname += attachment.getAttname().toString()
									.split("_")[1]
									+ "\n";
						}
					}
				}

				Label label0 = new Label(0, j + startrow,
						recordLog.getPsname(), format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, recordLog
						.getRlrolename(), format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow,
						recordLog.getRltime(), format2);
				wsheet.addCell(label2);

				Label label3 = new Label(3, j + startrow, recordLog
						.getRlusername(), format3);
				wsheet.addCell(label3);

				Label label4 = new Label(4, j + startrow, recordLog
						.getRlorgname(), format4);
				wsheet.addCell(label4);

				Label label5 = new Label(5, j + startrow, recordLog
						.getRlcomment(), format5);
				wsheet.addCell(label5);

				Label label6 = new Label(6, j + startrow,
						recordLog.getRldesc(), format6);
				wsheet.addCell(label6);

				Label label7 = new Label(7, j + startrow, attname, format7);
				wsheet.addCell(label7);

			}

			wwb.write();
			wwb.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���񹤵���Աͳ��  
	 * @param os
	 * @param dataList
	 * @throws Exception
	 * ���� by ���� 2010/10/28
	 */
	public synchronized static void exportIGSVC1301(OutputStream os,List<List<String>> dataList, String opentime_from, String opentime_to,String title,String sftypename) throws Exception {
		
		Workbook template = ExportExcel.getTemplate("IGSVC1301.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		wsheet.getSettings().setPrintTitlesRow(0, 2);
		
		int startrow = 1;
        String date="";                                                   //���ò�ѯʱ��
        String typeName ="��ѯ��λ�� ";                                       //���ø�λ��Ϣ
			
		WritableFont font1  =  new   WritableFont(WritableFont.createFont("����"),  20  ,WritableFont.BOLD);
		WritableCellFormat format1  =  new   WritableCellFormat(font1);   //��һ�еĸ�ʽ
		format1.setAlignment(jxl.format.Alignment.CENTRE);                //��һ�о�����ʾ
		format1.setBorder(Border.ALL, BorderLineStyle.THIN);              //���ñ߿��ʽ
		
		WritableFont font2  =  new   WritableFont(WritableFont.createFont("����"),  12  ,WritableFont.BOLD);
		WritableCellFormat format2  =  new   WritableCellFormat(font2);   //�ڶ��еĸ�ʽ
		format2.setAlignment(jxl.format.Alignment.LEFT);                  //�ڶ��о�����ʾ
		format2.setBorder(Border.ALL, BorderLineStyle.THIN);              //���ñ߿��ʽ
		
		WritableFont font3  =  new   WritableFont(WritableFont.createFont("����"),  12  ,WritableFont.BOLD);
		WritableCellFormat format3  =  new   WritableCellFormat(font3);   //�����еĸ�ʽ
		format3.setAlignment(jxl.format.Alignment.CENTRE);                  //�����о�����ʾ
		format3.setBorder(Border.ALL, BorderLineStyle.THIN);              //���ñ߿��ʽ
		format3.setWrap(true);
		//���ɱ�����
		int column = dataList.get(0).size();		 
		wsheet.mergeCells(0  ,  0  ,  column-1 ,  0 );                     //�ϲ���Ԫ�� ��һ��
		wsheet.mergeCells(0  ,  1  ,  column-1 ,  1 );                     //�ϲ���Ԫ�� �ڶ���
		wsheet.mergeCells(0  ,  2  ,  column-1 ,  2 );                     //�ϲ���Ԫ�� ������
		
		Label label0 = new Label(0, 0, title,format1);	
		wsheet.addCell(label0);	
		
		if (StringUtils.isEmpty(opentime_from)&& StringUtils.isEmpty(opentime_to)) {
			date="��ѯʱ�䣺";
		} else {
			date="��ѯʱ�䣺"
					+ (null != opentime_from ? opentime_from : "") + "��"
					+ (null != opentime_to ? opentime_to : "");
		}
			
		if (dataList != null && dataList.size() > 0) {
					
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			
			//���ò�ѯʱ��
			label0 = new Label(0,1,date,format2);
			wsheet.addCell(label0);	
			
			//���ø�λ��Ϣ
			label0 = new Label(0,2,typeName+sftypename,format2);
			wsheet.addCell(label0);	
							
			//���õ�Ԫ��		
			for (int j = 0; j < dataList.size(); j++) {
				List<String> data = (List<String>) dataList.get(j);
				
				for (int i = 0; i < data.size(); i++) {
					if(j==0){					
						//��һ�мӴ�
						label0 = new Label(i, j + startrow+2, data.get(i),format3);
						wsheet.addCell(label0);	
					}else{
					label0 = new Label(i, j + startrow+2, data.get(i),format0);
					wsheet.addCell(label0);	
					}	
				}
			}	
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ֪ʶ��������
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGKGM0228(OutputStream os,
			List<Knowledge> dataList) throws Exception {
		
		//��ȡģ��
		Workbook template = ExportExcel.getTemplate("IGKGM0228.xls");
		//��ȡģ����sheetҳ
		Sheet wsheetTemplate = template.getSheet(0);
		//�½�excel
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		
		List<CodeDetail> cd = null;
		
		if (dataList != null && dataList.size() > 0) {
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Knowledge data = (Knowledge) dataList.get(j);
				
				WritableSheet wsheet;
				if(j == 0){
					//��һ��������excel�еĵ�һ��sheetҳ
					wsheet = wwb.getSheet(0);
					wsheet.setName(j + 1 + "." + data.getKnserial());
				}else{
					//����һ�����������½�sheetҳ
					wsheet = wwb.importSheet(j + 1 + "." + data.getKnserial(), j, wsheetTemplate);
				}
				
				//��ģ����sheetҳ��ӡ���ø���������excel��sheetҳ��
				wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
				
				//�滻ָ����Ԫ��
				setCellByContents(wsheet, "title", "֪ʶ��Ϣ");	
				
				//��ȡָ����Ԫ���ʽ
				//����
				Cell cell0 = wsheetTemplate.getCell(1, 1);
				CellFormat format0 = cell0.getCellFormat();
				Label label0 = new Label(1, 1, data.getKntitle(), format0);
				wsheet.addCell(label0);
				
				//����
				Cell cell1 = wsheetTemplate.getCell(1, 2);
				CellFormat format1 = cell1.getCellFormat();
				Label label1 = new Label(1, 2, data.getKnclassname(), format1);
				wsheet.addCell(label1);
				
				//�ؼ���
				Cell cell2 = wsheetTemplate.getCell(3, 2);
				CellFormat format2 = cell2.getCellFormat();
				Label label2 = new Label(3, 2, data.getKnkey(), format2);
				wsheet.addCell(label2);
				
				//�鵵��
				Cell cell3 = wsheetTemplate.getCell(1, 3);
				CellFormat format3 = cell3.getCellFormat();
				Label label3 = new Label(1, 3, data.getKnapprovername(), format3);
				wsheet.addCell(label3);
				
				//�鵵ʱ��
				Cell cell4 = wsheetTemplate.getCell(3, 3);
				CellFormat format4 = cell4.getCellFormat();
				Label label4 = new Label(3, 3, data.getKnapprovetime(), format4);
				wsheet.addCell(label4);
				
				//��Դ
				
				if(StringUtils.isNotEmpty(data.getKnorigin())) {
					Cell cell5 = wsheetTemplate.getCell(1, 4);
					CellFormat format5 = cell5.getCellFormat();
					CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
					condimpl.setSyscoding_q(data.getKnorigin());
					cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
					if(cd.size() > 0) {
						Label label5 = new Label(1, 4, cd.get(0).getCvalue(), format5);
						wsheet.addCell(label5);
					} else {
						Label label5 = new Label(1, 4, "", format5);
						wsheet.addCell(label5);
					}
				}
				
				//֪ʶ������
				Cell cell6 = wsheetTemplate.getCell(3, 4);
				CellFormat format6 = cell6.getCellFormat();
				Label label6 = new Label(3, 4, data.getKnproffername(), format6);
				wsheet.addCell(label6);
				
				//����ʱ��
				Cell cell7 = wsheetTemplate.getCell(1, 5);
				CellFormat format7 = cell7.getCellFormat();
				Label label7 = new Label(1, 5, data.getKnproffertime(), format7);
				wsheet.addCell(label7);
				
				//����
				Cell cell8 = wsheetTemplate.getCell(3, 5);
				CellFormat format8 = cell8.getCellFormat();
				Label label8 = new Label(3, 5, data.getKndepartment(), format8);
				wsheet.addCell(label8);
				
				//��������
				Cell cell9 = wsheetTemplate.getCell(1, 6);
				CellFormat format9 = cell9.getCellFormat();
				Label label9 = new Label(1, 6, data.getKntelareaname(), format9);
				wsheet.addCell(label9);
				
				//ҵ��ϵͳ
				IGKGM02BL igkgm02BL = (IGKGM02BL)WebApplicationSupport.getBean("igkgm02BL");
				String knareaname = igkgm02BL.searchKnowLedgeAppImpactAction(data.getKnid(), data.getKnversion());
				Cell cell10 = wsheetTemplate.getCell(1, 7);
				CellFormat format10 = cell10.getCellFormat();
				Label label10 = new Label(1, 7, knareaname, format10);
				wsheet.addCell(label10);
				
				//��������
				Cell cell11 = wsheetTemplate.getCell(1, 8);
				CellFormat format11 = cell11.getCellFormat();
				Label label11 = new Label(1, 8, data.getKnfaultcause(), format11);
				wsheet.addCell(label11);
				
				//����취
				Cell cell12 = wsheetTemplate.getCell(1, 9);
				CellFormat format12 = cell12.getCellFormat();
				Label label12 = new Label(1, 9, data.getKnsolveway(), format12);
				wsheet.addCell(label12);
				
				//֪ʶ����
				Cell cell13 = wsheetTemplate.getCell(1, 10);
				CellFormat format13 = cell13.getCellFormat();
				Label label13 = new Label(1, 10, data.getKndes(), format13);
				wsheet.addCell(label13);
				
			}
		}
			
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ����ָ���ı��滻��Ԫ������
	 * 
	 * @param ws sheetҳ
	 * @param value ����ֵ
	 * @param newValue	�滻ֵ
	 * @return
	 */
	private static boolean setCellByContents(WritableSheet ws, String value,
			String newValue) {
		try {
			ArrayList<Cell> cellList = getCellByValue(ws, value);
			Cell cell = null;
			Iterator<Cell> cellIt = cellList.iterator();
			while (cellIt.hasNext()) {
				cell = (Cell) cellIt.next();
				if (cell != null) {
					CellFormat format = cell.getCellFormat();
					//WritableCellFormat wcf = new WritableCellFormat(format);
					int col = cell.getColumn();
					int row = cell.getRow();
					Label label = new Label(col, row, newValue, format);
					ws.addCell(label);
				}
			}
			return true;
		} catch (RowsExceededException e) {
			log.debug(e);
			return false;
		} catch (WriteException e) {
			log.debug(e);
			return false;
		}
	}

	/**
	 * ����ָ�����ݻ�ȡ��Ԫ��
	 * 
	 * @param ws sheetҳ
	 * @param value ����ֵ
	 * @return
	 */
	private static ArrayList<Cell> getCellByValue(WritableSheet ws, String value) {
		ArrayList<Cell> cellList = new ArrayList<Cell>();
		if (StringUtils.isNotEmpty(value)) {
			int numCol = ws.getColumns();
			int numRows = ws.getRows();
			for (int i = 0; i < numCol; i++) {
				for (int j = 0; j < numRows; j++) {
					Cell cell = ws.getCell(i, j);
					String content = cell.getContents();
					if (value.equals(content)) {
						cellList.add(cell);
					}
				}
			}
		}
		return cellList;
	}

	/**
	 * ��ȡģ��
	 * 
	 * @param filename
	 * @return
	 */
	private static Workbook getTemplate(String filename) {
		//String path = ExportExcel.class.getResource("/").getPath();
		String rootPath = ResourceUtility.getString("EXCEL_FILE_ROOT_PATH");
//		log.debug("----------------"+path);
//		if (path != null && path.indexOf("WEB-INF") != -1) {
//			path = path.substring(1, path.indexOf("WEB-INF"));
//		} 
		String templatePath = rootPath + filename;
		Workbook template = null;
		
		//log.debug("----------------"+templatePath);

		try {
			template = Workbook.getWorkbook(new FileInputStream(templatePath));
		} catch (BiffException e) {
			log.debug(e);
		} catch (FileNotFoundException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}
		return template;

	}
	/**
	 * ��ƶԱȽ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportIGCIM0302Action(OutputStream os,
			List<SOC0137Info> dataList, String autime_from, String autime_to, String autdesc) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("IGCIM0313.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		int startrow = 4;
		//�滻ָ����Ԫ��
		//setCellByContents(wsheet, "title", "��ƶԱȽ��");
		setCellByContents(wsheet, "date", (null!=autime_from ?autime_from:"") + "��" + (null!=autime_to?autime_to:""));
		setCellByContents(wsheet, "autdesc", autdesc);
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				SOC0137Info data = dataList.get(j);
				
				Label label0 = new Label(0, j + startrow, data.getEiname(), format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getAutime(), format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getEntityTB().getEname(), format2);
				wsheet.addCell(label2);
				
				CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
				String aucmptype = codeListUtils.getCodeValue(CodeDefine.getCodeDefine("AUDITRESULT_AUCMPTYPE").getCcid(), "", "", data.getAucmptype());
				Label label3 = new Label(3, j + startrow, aucmptype, format3);
				wsheet.addCell(label3);
                			
				String auflag =  codeListUtils.getCodeValue(CodeDefine.getCodeDefine("AUDITRESULT_AUFLAG").getCcid(), "", "", data.getAuflag());
				Label label4 = new Label(4, j + startrow, auflag, format4);
				wsheet.addCell(label4);
			
			}	
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ƶԱȽ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportIGCIM0302(OutputStream os,
			List<SOC0103Info> dataList, String autime_from, String autime_to, String autdesc, String ename) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("IGCIM0302.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��ƶԱȽ��");
		setCellByContents(wsheet, "date", (null!=autime_from ?autime_from:"") + "��" + (null!=autime_to?autime_to:""));
		setCellByContents(wsheet, "ename", ename);
		setCellByContents(wsheet, "autdesc", autdesc);
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����5��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();		
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				SOC0103Info data = dataList.get(j);
				
				Label label0 = new Label(0, j + startrow, data.getEiname(), format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getAutime(), format1);
				wsheet.addCell(label1);
				
				CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
				String aucmptype = codeListUtils.getCodeValue(CodeDefine.getCodeDefine("AUDITRESULT_AUCMPTYPE").getCcid(), "", "", data.getAucmptype());
				Label label2 = new Label(2, j + startrow, aucmptype, format2);
				wsheet.addCell(label2);
                			
				Label label3 = new Label(3, j + startrow, data.getCname(), format3);
				wsheet.addCell(label3);				

				Label label4 = new Label(4, j + startrow, data.getCivalue(), format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow, data.getAuvalue(), format5);
				wsheet.addCell(label5);
				
				String auflag =  codeListUtils.getCodeValue(CodeDefine.getCodeDefine("AUDITRESULT_AUFLAG").getCcid(), "", "", data.getAuflag());
				Label label6 = new Label(6, j + startrow, auflag, format6);
				wsheet.addCell(label6);
			
				Label label7 = new Label(7, j + startrow, data.getAuresultdesc(), format7);
				wsheet.addCell(label7);
				
			}	
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * CI���¶ԱȽ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportIGASM2202(OutputStream os,
			List<CIResultInfo> dataList, String citime_from, String citime_to, String citdesc, String ename) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("IGASM2202.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "CI���¶ԱȽ��");
		setCellByContents(wsheet, "date", (null!=citime_from ?citime_from:"") + "��" + (null!=citime_to?citime_to:""));
		setCellByContents(wsheet, "ename", ename);
		setCellByContents(wsheet, "citdesc", citdesc);
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����5��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();		
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				CIResultInfo data = dataList.get(j);
				
				Label label0 = new Label(0, j + startrow, data.getEiname(), format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getCitime(), format1);
				wsheet.addCell(label1);
				
				CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
				String cicmptype = codeListUtils.getCodeValue(CodeDefine.getCodeDefine("CIRESULT_CICMPTYPE").getCcid(), "", "", data.getCicmptype());
				Label label2 = new Label(2, j + startrow, cicmptype, format2);
				wsheet.addCell(label2);
                			
				Label label3 = new Label(3, j + startrow, data.getCname(), format3);
				wsheet.addCell(label3);				

				Label label4 = new Label(4, j + startrow, data.getCivalue(), format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow, data.getAuvalue(), format5);
				wsheet.addCell(label5);
				
				String ciflag =  codeListUtils.getCodeValue(CodeDefine.getCodeDefine("CIRESULT_CIFLAG").getCcid(), "", "", data.getCiflag());
				Label label6 = new Label(6, j + startrow, ciflag, format6);
				wsheet.addCell(label6);
			
				Label label7 = new Label(7, j + startrow, data.getCiresultdesc(), format7);
				wsheet.addCell(label7);
				
			}	
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void exportIGMNT0108(OutputStream os,
			Map<String, List<SOC0301Info>> dataMap) throws Exception  {
		try{
			Workbook template = ExportExcel.getTemplate("IGMNT0108.xls");
			Sheet wsheetTemplate = template.getSheet(0);
			WritableWorkbook wwb = Workbook.createWorkbook(os, template);
			WritableSheet wsheet = wwb.getSheet(0);
			int startRow = 2;
			int startColumn=2;
			
			if (dataMap != null && dataMap.size() > 0) {
				// ��ȡָ����Ԫ���ʽ
				Cell timeCell = wsheetTemplate.getCell(2, 1);
				CellFormat timeFormat = timeCell.getCellFormat();
				Cell valueCell = wsheetTemplate.getCell(2, 2);
				CellFormat valueFormat = valueCell.getCellFormat();
				Cell objCell = wsheetTemplate.getCell(1, 2);
				CellFormat objFormat = objCell.getCellFormat();
				
				Object[] objNames = dataMap.keySet().toArray();
				//���õ�Ԫ��
				for (int i = 0; i < objNames.length; i++) {
					
					Label objName = new Label(startColumn+i, 1, String.valueOf(objNames[i]), objFormat);
					wsheet.addCell(objName);
					
					List<SOC0301Info> drtList = dataMap.get(objNames[i]);
					for (int j = 0; j < drtList.size(); j++) {
						SOC0301Info drt = drtList.get(j);
						Label time = new Label(1, startRow + j, drt
								.getTimeStamp(), timeFormat);
						wsheet.addCell(time);
						Number value = new Number(startColumn + i,startRow + j, drt.getKpiValue(), valueFormat);
						wsheet.addCell(value);
					}
				}	
			}
			wwb.write();
			wwb.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �豸��־�澯����
	 * @param os
	 * @param dataList
	 * @param title
	 * @throws Exception
	 */
	public static void exportIGLOG0003(OutputStream os,List dataList,String title) throws Exception{
		Workbook template = ExportExcel.getTemplate("IGLOG0003.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 2;
		if(StringUtils.isEmpty(title)) title = "�豸��־�澯�б�";
		setCellByContents(wsheet, "title", title.trim());
		CellFormat[] formats = new CellFormat[6];
		Label[] labels = new Label[6];
		
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String[] alarmlevels = new String[cds.size()];
        for (int i = 0; i < cds.size(); i++) {
        	alarmlevels[i] = cds.get(i).getCvalue();
		}
        
		String[] alarmstates = {"δ����","�Ѵ���"};
		String time, level, ip, msg, state="";
		if(dataList != null && dataList.size() > 0){
			
			for (int i = 0; i <dataList.size(); i++) {
				Object obj = dataList.get(i);
				if(Mss00006Info.class.isInstance(obj)){
					Mss00006Info info = (Mss00006Info) obj;
					time = info.getSyslogtime()==null?"":info.getSyslogtime();
					if(info.getRulelevel()==null) level = "";
					else level = alarmlevels[Integer.parseInt(info.getRulelevel().trim())];
					ip = info.getDeviceip()==null?"":info.getDeviceip();
					msg = info.getSyslogmsg()==null?"":info.getSyslogmsg();
					state = alarmstates[info.getAlarmstate()];
				}else {
					Mss00007Info info = (Mss00007Info) obj;
					time = info.getSyslogtime()==null?"":info.getSyslogtime();
					if(info.getRulelevel()==null) level = "";
					else level = alarmlevels[Integer.parseInt(info.getRulelevel().trim())];
					ip = info.getDeviceip()==null?"":info.getDeviceip();
					msg = info.getSyslogmsg()==null?"":info.getSyslogmsg();
					state = alarmstates[info.getAlarmstate()];
				}
				
				for(int j=0; j<labels.length; j++){
					// ��ȡָ����Ԫ���ʽ
					Cell cell = wsheetTemplate.getCell(j, startrow);
					formats[j] = cell.getCellFormat(); 
					
					String index = String.valueOf(i+1);
					String[] values = {index, time, state, level, ip, msg};
					labels[j] = new Label(j, i + startrow, values[j], formats[j]);
					wsheet.addCell(labels[j]);
				}
			}
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	
	/**
	 * �豸��־����
	 * @param os
	 * @param dataList
	 * @param title
	 * @throws Exception
	 */
	public static void exportIGLOG0105(OutputStream os,List dataList,String title) throws Exception{
		Workbook template = ExportExcel.getTemplate("IGLOG0104.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 2;
		if(StringUtils.isEmpty(title)) title = "��ʷ�豸��־�б�";
		setCellByContents(wsheet, "title", title.trim());
		CellFormat[] formats = new CellFormat[8];
		Label[] labels = new Label[8];
		
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String[] alarmlevels = new String[cds.size()];
        for (int i = 0; i < cds.size(); i++) {
        	alarmlevels[i] = cds.get(i).getCvalue();
		}
        
		String time, level, ip, msg ="";
		String satrttime="";
		String endtime="";
		String state=""; 
		if(dataList != null && dataList.size() > 0){
			for (int i = 0; i <dataList.size(); i++) {
				Object obj = dataList.get(i);
				if(Mss00009Info.class.isInstance(obj)){
					Mss00009Info info = (Mss00009Info)obj;
					time = info.getCreatetime()==null?"":info.getCreatetime();
					if(info.getRulelevel()==null) level = "";
					else level = alarmlevels[Integer.parseInt(info.getRulelevel().trim())];
			        ip = info.getDeviceip()==null?"":info.getDeviceip();
					msg = info.getAlarmmsg()==null?"":info.getAlarmmsg();
					satrttime=info.getStarttime()==null?"":info.getStarttime();
					endtime=info.getEndtime()==null?"":info.getEndtime();
					if(info.getState() == null) state = "";
					else if(info.getState().equals(0) || info.getState().equals(1)) 
						state="���޸�";
					else if(info.getState().equals(2))
						state="������";
					
				}else{
					Mss00012Info info = (Mss00012Info)obj;
					time = info.getCreatetime()==null?"":info.getCreatetime();
					
					if(info.getRulelevel()==null) level = "";
					else level = alarmlevels[Integer.parseInt(info.getRulelevel().trim())];
					ip = info.getDeviceip()==null?"":info.getDeviceip();
					satrttime=info.getStarttime()==null?"":info.getStarttime();
					endtime=info.getEndtime()==null?"":info.getEndtime();
					msg = info.getAlarmmsg()==null?"":info.getAlarmmsg();
					if(info.getState() == null) state = "";
					else if(info.getState().equals(0) || info.getState().equals(1)) 
						state="���޸�";
					else if(info.getState().equals(2))
						state="������";
				}
				for(int j=0; j<labels.length; j++){
					// ��ȡָ����Ԫ���ʽ
					Cell cell = wsheetTemplate.getCell(j, startrow);
					formats[j] = cell.getCellFormat(); 
					
					String index = String.valueOf(i+1);
					String[] values = {index,level , state, time , satrttime,endtime,ip, msg};
					labels[j] = new Label(j, i + startrow, values[j], formats[j]);
					wsheet.addCell(labels[j]);
				}
			}
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	
	public static void exportIGLOG0104(OutputStream os,List dataList,String title) throws Exception{
		Workbook template = ExportExcel.getTemplate("IGLOG0103.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 2;
		if(StringUtils.isEmpty(title)) title = "�豸��־�б�";
		setCellByContents(wsheet, "title", title.trim());
		CellFormat[] formats = new CellFormat[5];
		Label[] labels = new Label[5];
		
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String[] alarmlevels = new String[cds.size()];
        for (int i = 0; i < cds.size(); i++) {
        	alarmlevels[i] = cds.get(i).getCvalue();
		}
        
		String time, level, ip, msg ="";
		if(dataList != null && dataList.size() > 0){
			
			for (int i = 0; i <dataList.size(); i++) {
				Object obj = dataList.get(i);
				if(Mss00009Info.class.isInstance(obj)){
					Mss00009Info info = (Mss00009Info)obj;
					time = info.getCreatetime()==null?"":info.getCreatetime();
					if(info.getRulelevel()==null) level = "";
					else level = alarmlevels[Integer.parseInt(info.getRulelevel().trim())];
					ip = info.getDeviceip()==null?"":info.getDeviceip();
					msg = info.getAlarmmsg()==null?"":info.getAlarmmsg();
				}else{
					Mss00012Info info = (Mss00012Info)obj;
					time = info.getCreatetime()==null?"":info.getCreatetime();
					if(info.getRulelevel()==null) level = "";
					else level = alarmlevels[Integer.parseInt(info.getRulelevel().trim())];
					ip = info.getDeviceip()==null?"":info.getDeviceip();
					msg = info.getAlarmmsg()==null?"":info.getAlarmmsg();
				}
				for(int j=0; j<labels.length; j++){
					// ��ȡָ����Ԫ���ʽ
					Cell cell = wsheetTemplate.getCell(j, startrow);
					formats[j] = cell.getCellFormat(); 
					
					String index = String.valueOf(i+1);
					String[] values = {index, time, level, ip, msg};
					labels[j] = new Label(j, i + startrow, values[j], formats[j]);
					wsheet.addCell(labels[j]);
				}
			}
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * �豸��־����
	 * @param os
	 * @param dataList
	 * @param title
	 * @throws Exception
	 */
	public static void exportIGLOG0103(OutputStream os,List dataList,String title) throws Exception{
		Workbook template = ExportExcel.getTemplate("IGLOG0103.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 2;
		if(StringUtils.isEmpty(title)) title = "�豸��־�б�";
		setCellByContents(wsheet, "title", title.trim());
		CellFormat[] formats = new CellFormat[6];
		Label[] labels = new Label[6];
		
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String[] alarmlevels = new String[cds.size()];
        for (int i = 0; i < cds.size(); i++) {
        	alarmlevels[i] = cds.get(i).getCvalue();
		}
        
		String time, level, ip, msg , isalarm="";
		if(dataList != null && dataList.size() > 0){
			
			for (int i = 0; i <dataList.size(); i++) {
				Object obj = dataList.get(i);
				Mss00008Info info = (Mss00008Info)obj;
				time = info.getCreatetime()==null?"":info.getCreatetime();
				if(info.getRulelevel()==null) level = "";
				else level = alarmlevels[Integer.parseInt(info.getRulelevel().trim())];
				ip = info.getDeviceip()==null?"":info.getDeviceip();
				msg = info.getAlarmmsg()==null?"":info.getAlarmmsg();
				if(info.getIsalarm() == null) isalarm = "";
				else if(info.getIsalarm().equals(0)) isalarm = "��";
				else if(info.getIsalarm().equals(1)) isalarm = "��";
				
				for(int j=0; j<labels.length; j++){
					// ��ȡָ����Ԫ���ʽ
					Cell cell = wsheetTemplate.getCell(j, startrow);
					formats[j] = cell.getCellFormat(); 
					
					String index = String.valueOf(i+1);
					String[] values = {index, isalarm , level ,time, ip, msg};
					labels[j] = new Label(j, i + startrow, values[j], formats[j]);
					wsheet.addCell(labels[j]);
				}
			}
		}
		wwb.write();
		wwb.close();
		os.close();
	}
}
