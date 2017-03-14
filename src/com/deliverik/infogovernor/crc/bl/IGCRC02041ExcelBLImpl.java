/*	
 * ��������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;

/**
 * ���ܣ��澯�¼���ѯ����
 * 
 * ���ڣ�2016/10/14
 * 
 * gongyunpeng
 *
 */
public class IGCRC02041ExcelBLImpl extends BaseBLImpl implements IGCRC02041ExcelBL  {
	/** ������Ϣbl */
	private IG599BL ig599BL;
	
	/** ������bl */
	private IG898BL ig898BL;
	
	/**
	 * ������Ϣbl����
	 * @param ig599bl
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	/**
	 * ������bl����
	 * @param ig599bl
	 */
	public void setIg898BL(IG898BL ig898BL) {
		this.ig898BL = ig898BL;
	}

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC02041ExcelBLImpl.class);
	
	/**
	 * ����excel
	 * @param dto
	 * @return
	 * @throws BLException
	 */
    public String generatedFile(IGCRC02ExcelDTO dto)throws BLException{
        log.debug("========Ԥ��ģ�����ɿ�ʼ========");
  		
        String timestamp = IGStringUtils.getAttKey();
  		// ��ȡģ���ļ�
  		StringBuffer fileName = new StringBuffer();
  		fileName.append(ResourceUtility.getString("EXCEL_FILE_ROOT_PATH"));
  		fileName.append("temp");
  		fileName.append(File.separator);
  		fileName.append("giveAlarm");
  		fileName.append(File.separator);
  		fileName.append(timestamp);
  		fileName.append(File.separator);
  		//·�����
		checkPath(fileName.toString());
  		fileName.append("�¼������.xls");
  		// ������ʵд��� Excel ����������  
  		WritableWorkbook book = null;
  		//��дsheetҳ
		WritableSheet sheet = null;
  		try {
  			book = Workbook.createWorkbook(new File(fileName.toString()));
		} catch (Exception e) {
			log.debug("========�����ɱ༭ģ��ʧ�ܣ��޷���̬�������������sheetҳ========",e);
		}  
  		// �����ɱ༭Excelʧ��
  		if(book==null){
  			throw new BLException("IGCUS0101.E001", "����������ʧ�ܣ�����³��ԣ�");
  		}
  		if(book.getSheet("�¼�����")==null){
  			sheet=book.createSheet("�¼�����", 1);
  		}
		
  		//�����п� 
		sheet.setColumnView(0, 15);
		sheet.setColumnView(1, 25);
		sheet.setColumnView(2, 50);
		sheet.setColumnView(3, 15);
		sheet.setColumnView(4, 50);
		sheet.setColumnView(5, 30);
		sheet.setColumnView(6, 25);
		sheet.setColumnView(7, 15);
		sheet.setColumnView(8, 15);
		sheet.setColumnView(9, 25);
		sheet.setColumnView(10, 25);
		sheet.setColumnView(11, 25);
		sheet.setColumnView(12, 25);
		sheet.setColumnView(13, 25);
		sheet.setColumnView(14, 15);
		sheet.setColumnView(15, 25);
		sheet.setColumnView(16, 25);
		sheet.setColumnView(17, 15);


		
		
		// ����������Ϣ
		List<IGCRC0208VWInfo> processList = dto.getProcessList();
		// ���б���Ϣ
		List<IG599Info> processInfoList = dto.getProcessInfoList();
		// ���в�������Ϣ
		List<IG337Info> processParticipantList = dto.getProcessParticipantList();
		// ����״̬��Ϣ
		List<IG333Info> processStatusDefList = dto.getProcessStatusDefList();
		/* 
		 * �����ݼ�
		 * ���map: Key(prid:���̱��) Value(Map:��Ӧ���̱�����)
		 * �ڲ�Map: String(pivarname:������) value(��Ӧ������)
		 */
		Map<Integer, Map<String, IG599Info>> piMap = new HashMap<Integer, Map<String, IG599Info>>();
		/* 
		 * ���������ݼ�
		 * ���Map��Key(prid:���̱��) Value(Map:��Ӧ״̬�Ĳ����˼���)
		 * �ڲ�Map��Key(psdid:������״̬) Value(List:���ж�Ӧ״̬�Ĳ�����)
		 */
		Map<Integer, Map<String, List<IG337Info>>> ppMap = new HashMap<Integer, Map<String, List<IG337Info>>>();
		/* 
		 * ״̬���ݼ�
		 * Key��(psdcode������״̬��ʾ)
		 * Value��(��Ӧ״̬����)
		 */
		Map<String, IG333Info> psdMap = new HashMap<String, IG333Info>();

		// ���еı�
		for (IG599Info info599 : processInfoList) {
			// �ж��Ƿ��и����̶�Ӧ����Ϣ,����������Ը����̱����ΪKey������һ��mapʵ�������ڴ洢���ж�Ӧ��
			if (piMap.get(info599.getPrid()) == null) {
				piMap.put(info599.getPrid(), new HashMap<String, IG599Info>());
			}
			// �������̶�Ӧ�����б���Ϣ
			piMap.get(info599.getPrid()).put(info599.getPivarname(), info599);
		}

		// ���е�״̬
		for (IG333Info psd : processStatusDefList) {
			//������״̬��ʾ��ΪKey�������������״̬��Ϣ
			psdMap.put(psd.getPsdcode() + "-" + psd.getPdid(), psd);
		}

		// ���в�����
		for (IG337Info pp : processParticipantList) {
			// �жϸ������Ƿ���ڣ�����������Ը����̱����ΪKey������һ��map����ʵ����������װ��Ӧ���в�����
			if (ppMap.get(pp.getPrid()) == null) {
				ppMap.put(pp.getPrid(), new HashMap<String, List<IG337Info>>());
			}
			// �жϲ�����״̬�Ƿ���ڣ�����������Բ�����״̬��ΪKey������һ��List����ʵ����������װ��Ӧ���̶�Ӧ״̬�Ĳ�����
			if (ppMap.get(pp.getPrid()).get(pp.getPsdid()) == null) {
				ppMap.get(pp.getPrid()).put(pp.getPsdid(),
						new ArrayList<IG337Info>());
			}
			// ��������
			ppMap.get(pp.getPrid()).get(pp.getPsdid()).add(pp);
		}
		
		
		//�¼�����
		Map<Integer,String>  eventLevel = searchEventLevelAction();
		
		//����ԭ��Map<prid,����ԭ��>
		Map<Integer,String>  causeFailure = searchCauseFailureAction();

		
		//��������(����ϵͳ����)
		Map<Integer,String>  hostName = searchHostNameAction();
		
		
		
		//д������
		try {
		 // �����ʽ ���� �»��� б�� ���� ��ɫ
			WritableFont font = new WritableFont
			(WritableFont.ARIAL, 15,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.AUTOMATIC);
			//���õ�Ԫ���ʽ
			WritableCellFormat contentFormat = new WritableCellFormat(font);
			//�����������
			contentFormat.setAlignment(Alignment.CENTRE);
			//���������Զ�����
			contentFormat.setWrap(true);
			//���ñ���
			sheet.mergeCells(0, 0, 17, 1);
			
			sheet.addCell(new Label(0,0,"�¼�����",contentFormat));
			
	    	//����Excel����
	    	String [] title = {"������","�¼�����","��������","�¼�����","����ϵͳ����","����ԭ��"
	    					  ,"�¼�������","������","����ʱ��","�¼�����","�¼���Դ","���س̶�"
	    					  ,"�����̶�","������","����ʱ��","��ǰ������","״̬","�ر�ʱ��"};
			if(title!=null && title.length != 0){
				for(int i = 0 ; i < title.length; i++){
					sheet.addCell(new Label(i,2,title[i],contentFormat));
				}
			}
			
			
			// д�������Ԫ��
			if (processList != null && processList.size() > 0) {
				for (int i = 0; i < processList.size(); i++) {
					// ��ȡ���̶���
					IGCRC0208VWInfo info = processList.get(i);
					
					// ��乤����
					sheet.addCell(new Label(0,i+3, info.getPrserialnum()));
					// ����¼�����
					sheet.addCell(new Label(1,i+3, info.getPrtitle()));
					//��ȡ�¼�������Ϣ
					String prdesc = piMap.get(info.getPrid()).get("�¼�����").getPivarvalue();
					if(StringUtils.isNotEmpty(prdesc)){
						prdesc = prdesc.replaceAll("&nbsp;", " ");
						prdesc = prdesc.replaceAll("<br>", "");
					}
					
					// ���������� 
					sheet.addCell(new Label(2,i+3, prdesc));
					
					// ����¼��ȼ�
					sheet.addCell(new Label(3,i+3,eventLevel.get(info.getPrid())));
					
					//����ϵͳ����
					sheet.addCell(new Label(4,i+3,hostName.get(info.getPrid())));
					//ԭ�����
					sheet.addCell(new Label(5,i+3,causeFailure.get(info.getPrid())));
					
					//�¼�������
					int n = 0;
					int m = 0;
					StringBuffer strPeople = new StringBuffer();
					for (IG337Info bean : processParticipantList) {
						if(info.getPrid().equals(bean.getPrid())){
							String psdid = bean.getPsdid();
							if("01080".equals(psdid.substring(0,5)) && "005".equals(psdid.substring(7,10))){	
								// ƴ�����̴�����
								if (m > 0) {
									strPeople.append(",");
								}
								strPeople.append(processParticipantList.get(n).getPpusername());
								m++;
							}
						}
						n++;
					}
					sheet.addCell(new Label(6,i+3, strPeople.toString()));
					
					
					//������
					sheet.addCell(new Label(7,i+3, info.getHandlingMethod()));
					//����ʱ��
					sheet.addCell(new Label(8,i+3, info.getHappenTime()));
					
					
					// ����Ƿ���Ҫ����
					String[] strs = piMap.get(info.getPrid()).get("�¼�����").getPivarvalue().split("_");
					String[] strs2 = strs[strs.length-1].split("-");
					sheet.addCell(new Label(9,i+3, strs2[strs2.length-1]));
					
					// ����¼���Դ
					sheet.addCell(new Label(10, i+3, piMap.get(info.getPrid()).get("�¼���Դ").getPivarvalue()));
					
					//���Ӱ��̶�
					sheet.addCell(new Label(11,i+3, piMap.get(info.getPrid()).get("���س̶�").getPivarvalue()));
					
					//���������
					IG599Info info599 = piMap.get(info.getPrid()).get("�����̶�");
					sheet.addCell(new Label(12,i+3, info599.getPivarvalue()));
					
					// ��䷢����	
					sheet.addCell(new Label(13,i+3, info.getPrusername()));

					StringBuffer str = new StringBuffer();
					// ��ȡ��Ӧ���̴�����
					if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
						str.append("");
					}else{					
						List<IG337Info> list = ppMap.get(info.getPrid()).get(
								psdMap.get(info.getPrstatus() + "-" + info.getPrpdid()).getPsdid());
						// ƴ�����̴�����
						if (list != null) {
							for (int j = 0; j < list.size(); j++) {
								if (j > 0) {
									str.append(",");
								}
								str.append(list.get(j).getPpusername());
							}
						}
					}
					
					//��䷢��ʱ��
					sheet.addCell(new Label(14, i+3, info.getPropentime()));
					// ��䴦����
					sheet.addCell(new Label(15, i+3, str.toString()));
					// ��乤��״̬
					if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
						sheet.addCell(new Label(16, i+3, "��ֹ"));
					}else{
						sheet.addCell(new Label(16, i+3, psdMap.get(info.getPrstatus() + "-" + info.getPrpdid()).getPsdname()));
					}
					// ���ر�ʱ��
					sheet.addCell(new Label(17, i+3, info.getPrclosetime()));
			
				}	
			}		
			
			book.write();
			book.close();
		} catch (Exception e) {
			log.debug("����ʧ�ܣ�",e);
			throw new BLException("IGCO10000.E141","����ʧ�ܣ�");
		}
        log.debug("========Ԥ��ģ�嵼������========");
        return fileName.toString();
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
	 * �ļ�����
	 * @param fileName �ļ�����
	 * @param response ��Ӧ����
	 */
	public void downloadFile(String fileName, HttpServletResponse response) throws BLException {
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
	 * ��ѯ�¼�����
	 * 
	 * <prid,�¼�����>
	 */
	private Map<Integer,String> searchEventLevelAction(){
		//�¼�����
		Map<Integer,String>  eventLevel = new HashMap<Integer,String>();
		
		//����prid ȥ��ѯig599���¼��ȼ�
		IG599SearchCondImpl ig599cond = new IG599SearchCondImpl();
		ig599cond.setPdid("01080");
		ig599cond.setPivarname("�¼�����");
		List<IG599Info> ig599Listinfo = ig599BL.searchIG599InfosByCond(ig599cond);
		//һ���Խ��������ݲ��,����map�� map��key��ig599���е�prid value��pivarnameΪ�¼������privarvalue
		if(ig599Listinfo != null && !ig599Listinfo.isEmpty()){
			for(int i = 0;i<ig599Listinfo.size();i++){
				if(eventLevel.get(ig599Listinfo.get(i).getPrid()) == null){
					eventLevel.put(ig599Listinfo.get(i).getPrid(), ig599Listinfo.get(i).getPivarvalue());
				}
			}
		}
		return eventLevel;
	}
	
	/**
	 * ��ѯ����ԭ��
	 * 
	 * @return <prid,����ԭ��>
	 */
	private Map<Integer,String> searchCauseFailureAction(){
		
		//����ԭ��Map<prid,����ԭ��>
		Map<Integer,String>  causeFailure = new HashMap<Integer,String>();
		
		//����prid ȥ��ѯig599�Ĺ���ԭ��
		IG599SearchCondImpl ig599FailureCond = new IG599SearchCondImpl();
		ig599FailureCond.setPdid("01080");
		ig599FailureCond.setPivarname("����ԭ��");
		List<IG599Info> ig599FailureListinfo = ig599BL.searchIG599InfosByCond(ig599FailureCond);
		//һ���Խ��������ݲ��,����map�� map��key��ig599���е�prid value��pivarnameΪ����ԭ���privarvalue
		if(ig599FailureListinfo != null && !ig599FailureListinfo.isEmpty()){
			for(int i = 0 ;i<ig599FailureListinfo.size();i++){
				if(causeFailure.get(ig599FailureListinfo.get(i).getPrid()) == null){
					causeFailure.put(ig599FailureListinfo.get(i).getPrid(),ig599FailureListinfo.get(i).getPivarvalue());
				}
			}
		}
		return causeFailure;
	}
	
	/**
	 * ��ѯ��������(����ϵͳ����)
	 * 
	 * @return Map<prid,ƴ��������ֵ> ȡֵʱֱ�Ӹ���pridȡ��
	 */
	private Map<Integer,String> searchHostNameAction(){
		
		//��������(����ϵͳ����)
		Map<Integer,String>  hostName = new HashMap<Integer,String>(); 
		//����prid ��ѯig898����������(����ϵͳ����Ϊ������������ƴ����һ��)
		IG898SearchCondImpl ig898cond = new IG898SearchCondImpl();
		ig898cond.setPvcolname("��������");
		List<IG898Info> ig898ListInfo = ig898BL.searchIG898(ig898cond);
		//һ���Խ��������ݲ��,����map�� map��key��ig898���е�prid value��pvcolnameΪ�������Ƶ�pvalue prid��ͬ���pvalueƴ����һ��
		//����Map<prid,ƴ��������ֵ> ȡֵʱֱ�Ӹ���pridȡ��
		if(ig898ListInfo != null && !ig898ListInfo.isEmpty() ){
			for(int i = 0;i<ig898ListInfo.size();i++){
				if(hostName.get(ig898ListInfo.get(i).getPrid()) == null){
					hostName.put(ig898ListInfo.get(i).getPrid(),ig898ListInfo.get(i).getPvalue());
				}else{
					hostName.put(ig898ListInfo.get(i).getPrid(), 
							hostName.get(ig898ListInfo.get(i).getPrid())+","+ig898ListInfo.get(i).getPvalue());
					
				}
			}
		}
		return hostName;
	}
	
	
	
}
