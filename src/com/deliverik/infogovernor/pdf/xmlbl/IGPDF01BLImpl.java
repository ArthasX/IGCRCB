package com.deliverik.infogovernor.pdf.xmlbl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.pdf.bl.task.PdfConfigrationBL;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfConfigrationSearchCondImpl;
import com.deliverik.infogovernor.pdf.xmlbl.task.PdfTaskBL;
import com.deliverik.infogovernor.util.Zip;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.XfaForm;

/**
 * 概述: 导出PDF的控制BL
 * 功能描述：导出PDF的控制BL
 * 创建人：deliverik
 * 创建记录：2013-7-29
 * 修改记录：
 */
public class IGPDF01BLImpl extends BaseBLImpl implements IGPDF01BL {

    /** 报表对应BL及模板名称配置表业务逻辑接口视图BL*/ 
    protected PdfConfigrationBL pdfConfigrationBL;
    
    /** 报表数据获取BL类*/ 
    protected PdfTaskBL pdfTaskBL;
    
    /** 报表模板存放路径*/ 
    private final String PDF_TEMPLATE_PATH = 
        ResourceUtility.getString("PDF_TEMPLATE_PATH"); 
    
    /** 报表结果输出路径*/ 
    private final String PDF_EXPORT_PATH = 
        ResourceUtility.getString("PDF_EXPORT_PATH"); 
    
    /** 报表压缩文件名称*/ 
    private final String PDF_ZIP_NAME = 
        ResourceUtility.getString("PDF_ZIP_NAME"); 
    
    /** 附件路径名称*/ 
    private final String UPLOAD_FILE_ROOT_PATH = 
    		ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH"); 
	/** 处理日志*/ 
	static Log log = LogFactory.getLog(IGPDF01BLImpl.class);

    /**
     * @param 报表对应BL及模板名称配置表业务逻辑接口视图BL the pdfConfigrationBL to set
     */
    public void setPdfConfigrationBL(PdfConfigrationBL pdfConfigrationBL) {
        this.pdfConfigrationBL = pdfConfigrationBL;
    }
    
    /**
     * @param 报表数据获取BL类 the pdfTaskBL to set
     */
    public void setPdfTaskBL(PdfTaskBL pdfTaskBL) {
        this.pdfTaskBL = pdfTaskBL;
    }
    
	/**
     * 读取流程数据填充XML并导出到PDF中
     *
     * @param pdid 流程定义id
     * @param prid 流程id
     * @return String PDF报表路径和文件名
     */
	public String createPdf(String pdid, Integer prid) throws BLException  {
	    log.debug("========PDF导出处理开始========");
	    // 取得报表配置信息
	    PdfConfigrationSearchCondImpl cond = new PdfConfigrationSearchCondImpl();
	    cond.setPdid(pdid);
	    List<PdfConfigrationInfo>  pdfConfigrationInfolist = 
	        pdfConfigrationBL.searchPdfConfigration(cond);
	    String templatePath,exportPath;
	    if (pdfConfigrationInfolist.size() > 0) {
	    	String xmlData = null;
	        PdfConfigrationInfo info = pdfConfigrationInfolist.get(0);
	        //T-Q-3此流程原逻辑不好使，单独处理 2015年11月17日19:42:47
	    	if(pdid.startsWith("21000")){
	    		xmlData = pdfTaskBL.getXmlFilledDataForTQ3(prid, pdid, info.getXmlname());
	    		xmlData = xmlData.replaceAll("null null:null:00", "");
        	}else{
        		xmlData = pdfTaskBL.getXmlFilledData(prid, pdid, info.getXmlname());
        		xmlData = xmlData.replaceAll("null null:null:00", "");
        	}
	        // 导出到PDF
	        templatePath = PDF_TEMPLATE_PATH +info.getTemplatename();
	        exportPath = PDF_EXPORT_PATH +  info.getExportname();
        	exportPdf(templatePath, exportPath, xmlData,pdid,prid);
	    } else {
	        throw new BLException("IGPDF0101.E001", pdid);
	    }
		log.debug("========PDF导出处理结束========");
		return exportPath;
	}
    
    /** 
     * 打包并下载PDF报表文件
     * 
     * @param fileNames PDF报表文件全路径
     * @param response response
     * @return void
     * @throws BLException
     */
    public void toZipAndDownload(List<String> fileNames ,
    		HttpServletResponse res) throws BLException{
    	// 输出流
    	OutputStream output = null;
    	// 输入流
    	FileInputStream input = null;
    	try{
	    	Zip.toZip(PDF_EXPORT_PATH+PDF_ZIP_NAME, fileNames);
	        File file = new File(PDF_EXPORT_PATH+PDF_ZIP_NAME);
	    	//文件下载处理
			res.reset();
			res.setContentType("binary/octet-stream");
	    	res.setHeader("Content-Disposition", "attachment;filename=" +  new String(file.getName().getBytes("gb2312"),"iso-8859-1"));
	    	// 输出流取得
			output = res.getOutputStream();
			// 输入流取得
			input = new FileInputStream(file);
			int actual = 0;
			byte[] b = new byte[1024];
			
			while ((actual = input.read(b)) > 0) {
				output.write(b,0,actual);
			}
			output.flush();
    	}catch (Exception e) {
    		throw new BLException("IGPDF0101.E005");
		}finally {
			try {
				// 关闭输入流
				if(input != null){
					input.close();
					input = null;
				}
				// 关闭输出流
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
    * 批量压缩指定文件或目录
    * @param fileNames 将要打包的文件名集合
    * @return void
    * @throws 
    */
    public void toZip(List<String> fileNames) throws BLException{
        try {
            Zip.toZip(PDF_EXPORT_PATH+PDF_ZIP_NAME, fileNames);
        } catch (Exception e) {
            throw new BLException("IGPDF0101.E005");
        }
    }
    
	/** 
	* PDF文件导出处理
	* 
	* @param tempPath 模板读取目录
	* @param exportPath 报表导出目录
	* @param doc 填充数据后的xml对象
	* @return void
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	private void exportPdf(String tempPath, String exportPath, String xmlData,String pdid, Integer prid) throws BLException {
	    try {
            PdfReader reader = new PdfReader(tempPath);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(exportPath),'\0',true);
            AcroFields form = stamper.getAcroFields();
            XfaForm xfa = form.getXfa();
            xfa.fillXfaForm(new ByteArrayInputStream(xmlData.getBytes("UTF-8")));
            //新增附件处理逻辑 2015年11月23日15:30:22 R-R-1 附件表单上传附件
            if(pdid.startsWith("11040")){
            	AttachmentBL attachmentBL  = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
            	IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
            	IG898SearchCondImpl cond = new IG898SearchCondImpl(); 
            	cond.setPidid(pdid+"444");
            	cond.setPrid(prid);
            	cond.setPidname("信息科技管理年度报告");
				List<IG898Info> ig898List = ig898BL.searchIG898(cond);
				if(ig898List!=null&&ig898List.size()>0){
					for(IG898Info info : ig898List){
						if("附件".equals(info.getPvcolname())){
							List<Attachment> searchAttachmentsByAttkey = attachmentBL.searchAttachmentsByAttkey(info.getAttkey());
							if(searchAttachmentsByAttkey!=null&searchAttachmentsByAttkey.size()>0){
								Attachment att = searchAttachmentsByAttkey.get(0);
								String name = att.getAttname();
								if(name.split("_").length==2){
									name=name.split("_")[1];
								}else if(name.split("_").length>2){
									name=name.substring(name.indexOf("_")+1, name.length());
								}
								PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(stamper.getWriter(), UPLOAD_FILE_ROOT_PATH + att.getAtturl() + File.separator + att.getAttname(), name, null);
								fs.setUnicodeFileName(name, true);
								stamper.addFileAttachment("", fs);
//								stamper.addFileAttachment("", null, UPLOAD_FILE_ROOT_PATH+"svc"+File.separator+att.getAttname(), name);
							}									
								
						}
					}
				}
            }
            //T-B-13 解决研发咨询类服务类型其他选项因表单没有绑定数据源而导入不进值问题
            else if(pdid.startsWith("11085")){
            	StringBuffer js = new StringBuffer();
            	List<Map<String, String>> list = new ArrayList<Map<String,String>>();
            	try {
					Document document = DocumentHelper.parseText(xmlData);
					Element root = document.getRootElement();
					List<Element> elements = root.elements("TB13001");
					if(elements != null){
						for(int i=0;i<elements.size();i++){
							Map<String, String> map = new HashMap<String, String>();
							map.put("COL22", elements.get(i).elementText("COL22"));
							map.put("COL23", elements.get(i).elementText("COL23"));
							map.put("COL24", elements.get(i).elementText("COL24"));
							map.put("COL25", elements.get(i).elementText("COL25"));
							list.add(map);
						}
					}
				} catch (org.dom4j.DocumentException e) {
					e.printStackTrace();
				}
        		js.append("var bskb_val = xfa.resolveNode('T_B_13.页面1.子表单1.isempty').rawValue;");//报送空表
        		js.append("if(bskb_val == \"报送空表\"){");
        		js.append("xfa.resolveNode('T_B_13.页面1.submitForm1.ND').rawValue = 1;");
        		js.append("}");
        		js.append("var index = -1;");
        		js.append("var tables1 = xfa.resolveNode('T_B_13.页面1.子表单1').nodes;");//14
        		js.append("for(var i=0;i<tables1.length;i++){");//报送空表 START
        		js.append("var TBITEM = tables1.item(i);");//start if
        			js.append("if(TBITEM.name == 'TB1'){");//start if
        				js.append("index++;");
        				//获取执行情况值，更改计算是否是本年度新增隐藏域值
        				js.append("var is_insert = TBITEM.DR1.子表单2.TB2.DR2.子表单8.YN_01.Radio1.rawValue;");
        				js.append("if(is_insert == '是'){");
        				js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单8.num05.rawValue = 1;");
        				js.append("}");
        				
        				//获取执行中还是已完成，对应更改隐藏域
        				js.append("var is_ing = TBITEM.DR1.子表单2.TB2.DR2.子表单8.YN_02.Radio1.rawValue;");
        				
        				js.append("if(is_ing == '执行中'){");
        				js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单8.num06.rawValue = 1;");
        				js.append("}");
        				js.append("var is_non = TBITEM.DR1.子表单2.TB2.DR2.子表单8.YN_02.Radio2.rawValue;");
        				js.append("if(is_non == '完成'){");
        				js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单8.num07.rawValue = 1;");
        				js.append("}");
        				
        				//是否关联外包
        				js.append("var is_wb1 = TBITEM.DR1.子表单2.TB2.DR4.子表单6.YN_01.Radio1.rawValue;");
        				js.append("var is_wb2 = TBITEM.DR1.子表单2.TB2.DR4.子表单6.YN_01.Radio2.rawValue;");
        				js.append("if(is_wb1 == '母公司或子公司' || is_wb2 == '关联公司或附属机构'){");
        				js.append("TBITEM.DR1.子表单2.TB2.DR4.子表单6.num09.rawValue = 1;");
        				js.append("}");
        				
        				//异常退出外包
        				js.append("var is_e = TBITEM.DR1.子表单2.TB2.DR4.子表单3.YN_01.Radio1.rawValue;");
        				js.append("if(is_e == '是'){");
        				js.append("TBITEM.DR1.子表单2.TB2.DR4.子表单3.num08.rawValue = 1;");
        				js.append("}");
        				
        				//是否跨境外包
        				js.append("var is_kj = TBITEM.DR1.子表单2.TB2.DR4.子表单7.YN_01.Radio1.rawValue;");
        				js.append("if(is_kj == '跨境外包'){");
        				js.append("TBITEM.DR1.子表单2.TB2.DR4.子表单7.num10.rawValue = 1;");
        				js.append("}");
        				
        				//是否非驻场外包
        				js.append("var is_zc = TBITEM.DR1.子表单2.TB2.DR2.子表单4.YN_01.Radio2.rawValue;");
        				js.append("if(is_zc == '非驻场外包'){");
        				js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单4.num11.rawValue = 1;");
        				js.append("}");
        			
        				js.append("var yfzx_val = TBITEM.DR1.子表单2.TB2.DR2.子表单2.item1001.rawValue;");//研发咨询类
        				js.append("var strArr = yfzx_val.split(',');");
        					js.append("for(var j=0;j<strArr.length;j++){");//for start
        						js.append("if(strArr[j] == '科技管理及科技治理等咨询设计'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框1.rawValue = 1;");//DR1.子表单2.TB2.DR2.子表单2.复选框1
        						js.append("}");
        						js.append("if(strArr[j] == '系统开发'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框2.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr[j] == '测试'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框3.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr[j] == '其他'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框4.rawValue = 1;");
        						js.append("var temp_obj = TBITEM.DR1.子表单2.TB2.DR2.子表单2.hidden01;");
        						js.append("temp_obj.presence = 'visible';");
        						js.append("if(temp_obj.rawValue == null || temp_obj.rawValue == ''){");
        						for(int i=0;i<list.size();i++){
                					js.append("if(index == " + i +  "){");
                					js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.hidden01.rawValue = '" + list.get(i).get("COL22") + "';");
                					js.append("}");
                				}
        						js.append("}");
        						js.append("}");
        					js.append("}");//for strArr
        					
        					js.append("var xtyxwh_val = TBITEM.DR1.子表单2.TB2.DR2.子表单2.item1002.rawValue;");//系统运行维护类
        					js.append("var strArr1 = xtyxwh_val.split(',');");
        					js.append("for(var w=0;w<strArr1.length;w++){");
        						js.append("if(strArr1[w] == '数据中心整体运维'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框5.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '机房配套设施运维'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框6.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '网络建设及运维'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框7.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '系统及应用运维'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框8.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '自助设备运维'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框9.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr1[w] == '其他'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框10.rawValue = 1;");
        						js.append("var temp_obj2 = TBITEM.DR1.子表单2.TB2.DR2.子表单2.hidden02;");
        						js.append("temp_obj2.presence = 'visible';");
        						js.append("if(temp_obj2.rawValue == null || temp_obj2.rawValue == ''){");
        						for(int i=0;i<list.size();i++){
                					js.append("if(index == " + i +  "){");
                					js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.hidden02.rawValue = '" + list.get(i).get("COL23") + "';");
                					js.append("}");
                				}
        						js.append("}");
        						js.append("}");
        					js.append("}");
        					
        					js.append("var ywwb_val = TBITEM.DR1.子表单2.TB2.DR2.子表单2.item1003.rawValue;");//业务外包中的信息科技活动：
        					js.append("var strArr2 = ywwb_val.split(',');");
        					js.append("for(var q=0;q<strArr2.length;q++){");
        						js.append("if(strArr2[q] == '系统开发'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框11.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr2[q] == '运行维护'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框12.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr2[q] == '数据处理'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框13.rawValue = 1;");
        						js.append("}");
        						js.append("if(strArr2[q] == '其他'){");
        						js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.复选框14.rawValue = 1;");
        						js.append("var temp_obj4 = TBITEM.DR1.子表单2.TB2.DR2.子表单2.hidden03;");
        						js.append("temp_obj4.presence = 'visible';");
        						js.append("if(temp_obj4.rawValue == null || temp_obj4.rawValue == ''){");
        						for(int i=0;i<list.size();i++){
                					js.append("if(index == " + i +  "){");
                					js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单2.hidden03.rawValue = '" + list.get(i).get("COL25") + "';");
                					js.append("}");
                				}
        						js.append("}");
        					js.append("}");
        					js.append("}");
        					
        					js.append("var ht_yxywlx_val = TBITEM.DR1.子表单2.TB2.DR2.子表单5.item1004.rawValue;");//合同-影响业务类型
        					js.append("var strArr3 = ht_yxywlx_val.split(',');");
        					js.append("for(var p=0;p<strArr3.length;p++){");
        					js.append("		if(strArr3[p] == '渠道管理类'){");
        					js.append("			TBITEM.DR1.子表单2.TB2.DR2.子表单5.复选框1.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '客户管理类'){");
        					js.append("			TBITEM.DR1.子表单2.TB2.DR2.子表单5.复选框2.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '产品管理类'){");
        					js.append("			TBITEM.DR1.子表单2.TB2.DR2.子表单5.复选框3.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '财务管理类'){");
        					js.append("			TBITEM.DR1.子表单2.TB2.DR2.子表单5.复选框4.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '决策支持类'){");
        					js.append("			TBITEM.DR1.子表单2.TB2.DR2.子表单5.复选框5.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '共享支持类'){");
        					js.append("			TBITEM.DR1.子表单2.TB2.DR2.子表单5.复选框6.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '基础设施类'){");
        					js.append("			TBITEM.DR1.子表单2.TB2.DR2.子表单5.复选框7.rawValue = 1;");
        					js.append("		}");
        					js.append("		if(strArr3[p] == '其他'){");
        					js.append("			TBITEM.DR1.子表单2.TB2.DR2.子表单5.复选框8.rawValue = 1;");
        					js.append("var temp_obj3 = TBITEM.DR1.子表单2.TB2.DR2.子表单5.hidden04;");
        					js.append("			temp_obj3.presence = 'visible';");
        					js.append("if(temp_obj3.rawValue == null || temp_obj3.rawValue == ''){");
        					for(int i=0;i<list.size();i++){
            					js.append("if(index == " + i +  "){");
            					js.append("TBITEM.DR1.子表单2.TB2.DR2.子表单5.hidden04.rawValue = '" + list.get(i).get("COL24") + "';");
            					js.append("}");
            				}
        					js.append("		}");
        					js.append("}");
        					js.append("}");
        					
        				js.append("}");//if table.name end
        			js.append("}");//for tables1 end
        			
        			stamper.addJavaScript(js.toString());
            }
            //解决T-Q-2因未绑定数据源而导致带不上值的问题
            else if(pdid.startsWith("21040")){
            	List<Map<String, String>> list = new ArrayList<Map<String,String>>();
            	try {
					Document document = DocumentHelper.parseText(xmlData);
					Element root = document.getRootElement();
					List<Element> elements = root.elements("TQ2001");
					if(elements != null){
						for(int i=0;i<elements.size();i++){
							Map<String, String> map = new HashMap<String, String>();
							map.put("COL14", elements.get(i).elementText("COL14"));
							map.put("COL15", elements.get(i).elementText("COL15"));
							map.put("COL16", elements.get(i).elementText("COL16"));
							map.put("COL17", elements.get(i).elementText("COL17"));
							map.put("COL18", elements.get(i).elementText("COL18"));
							map.put("COL19", elements.get(i).elementText("COL19"));
							map.put("COL20", elements.get(i).elementText("COL20"));
							list.add(map);
						}
					}
				} catch (org.dom4j.DocumentException e) {
					e.printStackTrace();
				}
            	StringBuffer js = new StringBuffer();
        		//填充报送空表选择框
        		js.append("var isempty = xfa.resolveNode('T_Q_2.isempty').rawValue;");
        		js.append("if(isempty == '报送空表'){");
        		js.append("xfa.resolveNode('T_Q_2.page1.Subform1.ND').rawValue = 1;");
        		js.append("}");
        		//获取主题内容表格
        		js.append("var tables = xfa.resolveNode('T_Q_2.page1').nodes;");
        		js.append("var index = -1;");
        		js.append("for(var i=0;i<tables.length;i++){");
        		js.append("var table = tables.item(i);");
        		js.append("if(table.name == 'DR1'){");
        		js.append("index++;");
        		
        		//填充季度实施情况选择框
        		js.append("var quarter_info = table.Table8.Row1.subform10.item6.rawValue;");
        		js.append("if(quarter_info){");
        		js.append("var quarter_values = quarter_info.split(',');");
        		js.append("for(var n=0;n<quarter_values.length;n++){");
        		js.append("if(quarter_values[n] == '新增'){");
        		js.append("table.Table8.Row1.subform10.CB_SYS_TYPE00.rawValue = 1;");
        		js.append("}");
        		js.append("if(quarter_values[n] == '执行中'){");
        		js.append("table.Table8.Row1.subform10.CB_SYS_TYPE01.rawValue = 1;");
        		js.append("}");
        		js.append("if(quarter_values[n] == '已完成'){");
        		js.append("table.Table8.Row1.subform10.CB_SYS_TYPE02.rawValue = 1;");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		//填充系统类别选择框
        		js.append("var system_type_info = table.Table8.Row1.subform20.Table11.Row1.Cell1.item6.rawValue;");
        		js.append("if(system_type_info){");
        		js.append("var system_type_values = system_type_info.split(',');");
        		js.append("for(var n=0;n<system_type_values.length;n++){");
        		js.append("if(system_type_values[n] == '渠道管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//填充渠道管理子类别
        		js.append("var channel_chile_type_info = table.Table8.Row1.subform20.Table11.Row1.Cell2.cell.rawValue;");
        		js.append("if(channel_chile_type_info){");
        		js.append("var channel_chile_type_values = channel_chile_type_info.split(',');");
        		js.append("for(var n1=0;n1<channel_chile_type_values.length;n1++){");
        		js.append("if(channel_chile_type_values[n1] == '前置类'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '柜员类'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == 'ATM'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == 'POS'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox4.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '银行卡'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox5.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '自助终端'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox6.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '网上银行'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox7.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '电话银行'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox8.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '手机银行'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox9.rawValue = 1;");
        		js.append("}");
        		js.append("if(channel_chile_type_values[n1] == '其他'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row1.Cell2.CheckBox10.rawValue = 1;");
        		js.append("var temp_obj1 = table.Table8.Row1.subform20.Table11.Row1.Cell2.O_item7;");
        		js.append("temp_obj1.presence = 'visible';");
        		js.append("if(temp_obj1.rawValue == null || temp_obj1.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj1.rawValue = '" + list.get(i).get("COL14") + "';");
					js.append("}");
        		}
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '客户管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//填充客户管理子类别
        		js.append("var customer_manager_child_type_info = table.Table8.Row1.subform20.Table11.Row2.Cell2.cell.rawValue;");
        		js.append("if(customer_manager_child_type_info){");
        		js.append("var customer_manager_child_type_values = customer_manager_child_type_info.split(',');");
        		js.append("for(var n2=0;n2<customer_manager_child_type_values.length;n2++){");
        		js.append("if(customer_manager_child_type_values[n2] == '对私客户关系管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(customer_manager_child_type_values[n2] == '对公客户关系管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(customer_manager_child_type_values[n2] == '客户信息管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(customer_manager_child_type_values[n2] == '其他'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row2.Cell2.CheckBox4.rawValue = 1;");
        		js.append("var temp_obj2 = table.Table8.Row1.subform20.Table11.Row2.Cell2.O_item9;");
        		js.append("temp_obj2.presence = 'visible';");
        		js.append("if(temp_obj2.rawValue == null || temp_obj2.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj2.rawValue = '" + list.get(i).get("COL15") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '产品管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//填充产品管理子类别选择框
        		js.append("var product_child_type_info = table.Table8.Row1.subform20.Table11.Row3.Cell2.cell.rawValue;");
        		js.append("if(product_child_type_info){");
        		js.append("var product_child_type_values = product_child_type_info.split(',');");
        		js.append("for(var n3=0;n3<product_child_type_values.length;n3++){");
        		js.append("if(product_child_type_values[n3] == '核心业务系统'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '对公贷款'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '对公存款'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '对公存款'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '对私贷款'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox4.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '对私存款'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox5.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '支付结算'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox6.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '投资银行'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox7.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '贸易融资'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox8.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '衍生产品'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox9.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '国际结算'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox10.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '基金产品'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox11.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '外汇理财产品'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox12.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '代理业务'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox13.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '信用卡'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox14.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '总账'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox15.rawValue = 1;");
        		js.append("}");
        		js.append("if(product_child_type_values[n3] == '其他'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row3.Cell2.CheckBox16.rawValue = 1;");
        		
        		js.append("var temp_obj3 = table.Table8.Row1.subform20.Table11.Row3.Cell2.O_item11;");
        		js.append("temp_obj3.presence = 'visible';");
        		js.append("if(temp_obj3.rawValue == null || temp_obj3.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj3.rawValue = '" + list.get(i).get("COL16") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '财务管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//填充财务管理子类选择框
        		js.append("var finance_child_type_info = table.Table8.Row1.subform20.Table11.Row4.Cell2.cell.rawValue;");
        		js.append("if(finance_child_type_info){");
        		js.append("var finance_child_type_values = finance_child_type_info.split(',');");
        		js.append("for(var n4=0;n4<finance_child_type_values.length;n4++){");
        		js.append("if(finance_child_type_values[n4] == '预算控制'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(finance_child_type_values[n4] == '固定资产'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(finance_child_type_values[n4] == '应收应付'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(finance_child_type_values[n4] == '资金交易'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox4.rawValue = 1;");
        		js.append("}");
        		js.append("if(finance_child_type_values[n4] == '其他'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row4.Cell2.CheckBox5.rawValue = 1;");
        		
        		js.append("var temp_obj4 = table.Table8.Row1.subform20.Table11.Row4.Cell2.O_item13;");
        		js.append("temp_obj4.presence = 'visible';");
        		js.append("if(temp_obj4.rawValue == null || temp_obj4.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj4.rawValue = '" + list.get(i).get("COL17") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '决策支持'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//填充决策支持选择框
        		js.append("var decision_support_child_type_info = table.Table8.Row1.subform20.Table11.Row5.Cell2.cell.rawValue;");
        		js.append("if(decision_support_child_type_info){");
        		js.append("var decision_support_child_type_values = decision_support_child_type_info.split(',');");
        		js.append("for(var n5=0;n5<decision_support_child_type_values.length;n5++){");
        		js.append("if(decision_support_child_type_values[n5] == '数据仓库'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(decision_support_child_type_values[n5] == '绩效考核'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(decision_support_child_type_values[n5] == '风险管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(decision_support_child_type_values[n5] == '资产负债管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox4.rawValue = 1;");
        		js.append("}");
        		js.append("if(decision_support_child_type_values[n5] == '其他'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row5.Cell2.CheckBox5.rawValue = 1;");
        		
        		js.append("var temp_obj5 = table.Table8.Row1.subform20.Table11.Row5.Cell2.O_item15;");
        		js.append("temp_obj5.presence = 'visible';");
        		js.append("if(temp_obj5.rawValue == null || temp_obj5.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj5.rawValue = '" + list.get(i).get("COL18") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '共享支持'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//填充共享支持选择框
        		js.append("var share_child_type_info = table.Table8.Row1.subform20.Table11.Row6.Cell2.cell.rawValue;");
        		js.append("if(share_child_type_info){");
        		js.append("var share_child_type_values = share_child_type_info.split(',');");
        		js.append("for(var n6=0;n6<share_child_type_values.length;n6++){");
        		js.append("if(share_child_type_values[n6] == '抵押品/质押品管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(share_child_type_values[n6] == '数据管理'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(share_child_type_values[n6] == '技术支撑'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(share_child_type_values[n6] == '其他'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row6.Cell2.CheckBox4.rawValue = 1;");
        		
        		js.append("var temp_obj6 = table.Table8.Row1.subform20.Table11.Row6.Cell2.O_item17;");
        		js.append("temp_obj6.presence = 'visible';");
        		js.append("if(temp_obj6.rawValue == null || temp_obj6.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj6.rawValue = '" + list.get(i).get("COL19") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '基础设施'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell1.CB_SYS_TYPE1.rawValue = 1;");
        		//填充基础设施子类选择框
        		js.append("var basis_child_type_info = table.Table8.Row1.subform20.Table11.Row7.Cell2.cell.rawValue;");
        		js.append("if(basis_child_type_info){");
        		js.append("var basis_child_type_values = basis_child_type_info.split(',');");
        		js.append("for(var n7=0;n7<basis_child_type_values.length;n7++){");
        		js.append("if(basis_child_type_values[n7] == '网络建设类'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell2.CheckBox1.rawValue = 1;");
        		js.append("}");
        		js.append("if(basis_child_type_values[n7] == '主机 /存储建设类'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell2.CheckBox2.rawValue = 1;");
        		js.append("}");
        		js.append("if(basis_child_type_values[n7] == '数据中心/机房建设类'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell2.CheckBox3.rawValue = 1;");
        		js.append("}");
        		js.append("if(basis_child_type_values[n7] == '其他'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row7.Cell2.CheckBox4.rawValue = 1;");
        		
        		js.append("var temp_obj7 = table.Table8.Row1.subform20.Table11.Row7.Cell2.O_item88;");
        		js.append("temp_obj7.presence = 'visible';");
        		js.append("if(temp_obj7.rawValue == null || temp_obj7.rawValue == ''){");
        		for(int i=0;i<list.size();i++){
        			js.append("if(index == " + i +  "){");
					js.append("temp_obj7.rawValue = '" + list.get(i).get("COL20") + "';");
					js.append("}");
        		}
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		js.append("if(system_type_values[n] == '其他'){");
        		js.append("table.Table8.Row1.subform20.Table11.Row8.Cell1.CB_SYS_TYPE_O.rawValue = 1;");
        		js.append("table.Table8.Row1.subform20.Table11.Row8.CB_SYS_TYPE_O_Item.access = 'open';");
        		js.append("}");
        		js.append("}");
        		js.append("}");
        		
        		js.append("}");
        		js.append("}");
        		
        		
        		stamper.addJavaScript(js.toString());
            }
        	WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
        	Map<IG036Info, List<Attachment>> map = workFlowOperationBL.searchRecordLog(prid);
        	for(Iterator<Entry<IG036Info, List<Attachment>>> iter = map.entrySet().iterator();iter.hasNext();){
        		Entry<IG036Info, List<Attachment>> entry = iter.next();
        		List<Attachment> list = entry.getValue();
        		for(int i=0;i<list.size();i++){
        			Attachment att = list.get(i);
					String name = att.getAttname().substring(att.getAttname().toString().indexOf("_") + 1);
					PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(stamper.getWriter(), UPLOAD_FILE_ROOT_PATH + att.getAtturl() + File.separator + att.getAttname(), name, null);
					fs.setUnicodeFileName(name, true);
					stamper.addFileAttachment("", fs);
        		}
        		
        	}
            stamper.close();
            reader.close();
	    } catch (DocumentException e) {
            throw new BLException("IGPDF0101.E004");
        } catch (IOException e) {
            throw new BLException("IGPDF0101.E002", tempPath);
        }
    }

	
}
