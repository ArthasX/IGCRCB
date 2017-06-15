package com.deliverik.infogovernor.html;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeAppImpactBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeBL;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.util.CodeDefine;



/**
 * Html���������࣬ÿ��Ӧ����Ҫ��дһ����Ӧ��exportIGSVC0621����
 */
public class ExportHtml {
	private static Log log = LogFactory.getLog(ExportHtml.class);
	private static StringBuffer htmlTemp;
	public static String zipFileName;
	private static OutputStream out = null;

    private static BufferedOutputStream bos = null;

    private static ZipArchiveOutputStream zaos = null;
    
    public static void createZipOut() throws FileNotFoundException, IOException {

        File f = new File(zipFileName);

        out = new FileOutputStream(f);

        bos = new BufferedOutputStream(out);

        zaos = new ZipArchiveOutputStream(bos);

        zaos.setEncoding("UTF-8");
    }
    
    public static void closeZipOut() throws Exception {

        zaos.flush();

        zaos.close();

 

        bos.flush();

        bos.close();

 

        out.flush();

        out.close();

    }
    /**
     * ����֪ʶҳ����
     * @param sr
     * @param kn
     * @return
     * @throws Exception
     */
    
    public synchronized static String createKnowledgeDownHtml(StringBuffer sr, Knowledge kn) throws Exception {
    	if(sr==null){
    		sr = new StringBuffer("");
    	}
    	sr.append("<html>"+"\r\n");
    	//=============================================��ʽ
    	sr.append("<style type='text/css'>"+"\r\n");
    	sr.append(".table_style{"+"\r\n");
    	sr.append("width:100%;"+"\r\n");
    	sr.append("margin:0 auto;"+"\r\n");
    	sr.append("border-collapse:collapse;"+"\r\n");
    	sr.append("text-align:left;"+"\r\n");
    	sr.append("font-size: 14px;"+"\r\n");
		sr.append("}"+"\r\n");
		sr.append(".table_style th{"+"\r\n");
		sr.append("color:#000000;"+"\r\n");
		sr.append("border-bottom:1px solid #9db7d1;"+"\r\n");
		sr.append("background-color:#bdcedc;"+"\r\n");
		sr.append("height:auto;"+"\r\n");
		sr.append("text-align:right;"+"\r\n"); 
		sr.append("}"+"\r\n");
		sr.append(".table_style td{"+"\r\n");
		sr.append("word-break: break-all;"+"\r\n");
		sr.append("word-wrap:break-word;"+"\r\n");
		sr.append("border-right-width: 1px;"+"\r\n");
		sr.append("border-bottom-width: 1px;"+"\r\n");
		sr.append("border-right-style: solid;"+"\r\n");
		sr.append("border-bottom-style: solid;"+"\r\n");
		sr.append("border-right-color: #9db7d1;"+"\r\n");
		sr.append("border-bottom-color: #9db7d1;"+"\r\n");
		sr.append("background-color: #FFF;"+"\r\n");
		sr.append("}"+"\r\n");
		sr.append(".record_list {"+"\r\n");
		sr.append("width: 90%;"+"\r\n");
		sr.append("margin: 10px auto;"+"\r\n");
		sr.append("}"+"\r\n");
		sr.append("body {"+"\r\n");
		sr.append("background-color: #F6F6F6;"+"\r\n");
		sr.append("}"+"\r\n");
		sr.append("</style>"+"\r\n");
		//=============================================��ʽ
		sr.append("<title>"+kn.getKntitle()+"</title>"+"\r\n");
		sr.append("<body>"+"\r\n");
		//=============================================����
		sr.append("<div class='record_list'>"+"\r\n");
		sr.append("<table width='100%' cellspacing='2' class='table_style'>"+"\r\n");
		sr.append("<tr>"+"\r\n");
		sr.append("<td style='padding-top:20px; padding-bottom:10px; font-size:16px; border-left:none; border-right:none; background-color:F6F6F6;' colspan='4' align='center'><strong>"+kn.getKntitle()+"</strong></td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
					
		sr.append("<tr>"+"\r\n");
		sr.append("<th width=10%'>֪ʶID</th>"+"\r\n");
		
		String knid = kn.getKnserial();
		if(knid==null){
			knid = "";
		}
		
		sr.append("<td>"+knid+"</td>"+"\r\n");
		sr.append("<th width=10%'>֪ʶ�汾</th>"+"\r\n");
		Integer knversion = kn.getKnversion();
		if(knversion==null){
			knversion = 0;
		}
		
		sr.append("<td>"+knversion+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
		sr.append("<tr>"+"\r\n");
		sr.append("<th>֪ʶ����</th>"+"\r\n");

		String kndes = kn.getKndes();
		if(kndes==null){
			kndes = "";
		}
		
		sr.append("<td colspan='3'>"+kndes+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
					
		sr.append("<tr>"+"\r\n");
		sr.append("<th>����</th>"+"\r\n");
		
		String knclass = kn.getKnclass();
		if(knclass==null){
			knclass = "";
		}
		
		sr.append("<td width='38%'>"+knclass+"</td>"+"\r\n");
		sr.append("<th width='10%'>�ؼ���</th>"+"\r\n");
		
		String knkey = kn.getKnkey();
		if(knkey==null){
			knkey = "";
		}
		
		sr.append("<td width='42%'>"+knkey+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
		sr.append("<tr>"+"\r\n");
		sr.append("<th>�鵵��</th>"+"\r\n");
		
		String knapprovername = kn.getKnapprovername();
		if(knapprovername==null){
			knapprovername = "";
		}
		
		sr.append("<td>"+knapprovername+"</td>"+"\r\n");
		sr.append("<th>�鵵ʱ��</th>"+"\r\n");
		
		String knapprovetime = kn.getKnapprovetime();
		if(knapprovetime==null){
			knapprovetime = "";
		}
		
		sr.append("<td>"+knapprovetime+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
		sr.append("<tr>"+"\r\n");
		sr.append("<th>��Դ</th>"+"\r\n");
		
		String knorigin = kn.getKnorigin();
		if(knorigin==null){
			knorigin = "";
		}
		
		sr.append("<td>"+knorigin+"</td>"+"\r\n");
		sr.append("<th>֪ʶ������</th>"+"\r\n");
		
		String knproffer = kn.getKnproffername();
		if(knproffer==null){
			knproffer = "";
		}
		
		sr.append("<td>"+knproffer+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
		sr.append("<tr>"+"\r\n");
		sr.append("<th>����ʱ��</th>"+"\r\n");
		
		String knproffertime = kn.getKnproffertime();
		if(knproffertime==null){
			knproffertime = "";
		}
		
		sr.append("<td>"+knproffertime+"</td>"+"\r\n");
		sr.append("<th>����</th>"+"\r\n");
		
		String kndepartment = kn.getKndepartment();
		if(kndepartment==null){
			kndepartment = "";
		}
		
		sr.append("<td>"+kndepartment+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
		sr.append("<tr>"+"\r\n");
		sr.append("<th>��������</th>"+"\r\n");
		
		String kntelareaname = kn.getKntelareaname();
		if(kntelareaname==null){
			kntelareaname = "";
		}
		
		sr.append("<td colspan='3'>"+kntelareaname+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
		sr.append("<tr>"+"\r\n");
		sr.append("<th>ҵ������</th>"+"\r\n");
		sr.append("<td colspan='3'>"+"\r\n");
		//=============================================ҵ������
		if(StringUtils.isNotEmpty(kn.getKnattkey())){
			KnowledgeAppImpactBL knowledgeAppImpactBL = (KnowledgeAppImpactBL) WebApplicationSupport.getBean("knowledgeAppImpactBL");
			KnowledgeAppImpactSearchCondImpl cond = new KnowledgeAppImpactSearchCondImpl();
			cond.setKnid(kn.getKnid());
			cond.setKnversion(kn.getKnversion());
			List<KnowledgeAppImpact> ktList = knowledgeAppImpactBL.findKnowledgeAppImpactByCond(cond, 0, 0);
			if(ktList!=null && ktList.size()>0){
				for(KnowledgeAppImpact kt:ktList){
					CodeListUtils codeListUtils = new CodeListUtils();
					String bname = codeListUtils.getCodeValue(CodeDefine.getCodeDefine("BUSINESS_SYSTEM_CODE").getCcid(), "", "", kt.getKaicode());
					sr.append(bname+"&nbsp;&nbsp;");
				}
			}
		}
		//=============================================ҵ������
		sr.append("</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
		sr.append("<tr>"+"\r\n");
		sr.append("<th>��������</th>"+"\r\n");
		
		String knfaultcause = kn.getKnfaultcause();
		if(knfaultcause==null){
			knfaultcause = "";
		}
		
		sr.append("<td colspan='3'>"+knfaultcause+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		
		sr.append("<tr>"+"\r\n");
		sr.append("<th>����취</th>"+"\r\n");
		
		String knsolveway = kn.getKnsolveway();
		if(knsolveway==null){
			knsolveway = "";
		}
		
		sr.append("<td colspan='3'>"+knsolveway+"</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
					
		sr.append("<tr>"+"\r\n");
		sr.append("<th>������Ϣ</th>"+"\r\n");
		sr.append("<td colspan='3'>"+"\r\n");
		sr.append("\r\n");
		//=============================================��������
		if(StringUtils.isNotEmpty(kn.getKnattkey())){
			AttachmentBL attachmentBL = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
			List<Attachment> atList = attachmentBL.searchAttachmentsByAttkey(kn.getKnattkey());
			if(atList!=null){
				for(Attachment at:atList){
					String filename = at.getAttname().substring(at.getAttname().indexOf("_")+1);
					sr.append("<a href='../../kgm/"+at.getAttname()+"'>"+kn.getKnserial()+"_"+filename+"</a><br>"+"\r\n");
				}
			}
		}
		//=============================================��������
		sr.append("\r\n");
		sr.append("</td>"+"\r\n");
		sr.append("</tr>"+"\r\n");
		sr.append("</table>"+"\r\n");
		sr.append("</div>"+"\r\n");
		//=============================================����
		sr.append("</body>"+"\r\n");
		sr.append("</html>"+"\r\n");
    	return sr.toString();
    }
    
    /**
     * Indexҳ����
     * @param sr
     * @param kn
     * @return
     * @throws Exception
     */
    
    public static String createIndexHtml() throws Exception {
    	StringBuffer res = new StringBuffer("");
    	res.append("<html>"+"\r\n");
    	res.append("<title>֪ʶ��</title>"+"\r\n");
    	res.append("<frameset cols='30%,70%'>"+"\r\n");
    	res.append("<frame id src='final/final.html'/>"+"\r\n");
    	res.append("<frame src='' name='content' />"+"\r\n");
    	res.append("</frameset>"+"\r\n");
    	res.append("</html>"+"\r\n");
    	return res.toString();
    }
    
    /**
     * ���ɼ�ͷͼƬ
     * @param sr
     * @param kn
     * @return
     * @throws Exception
     */
    
    public static void createPicture(String path,String filename) throws Exception {
    	// �½��ļ����������������л��� 
    	FileInputStream input = new FileInputStream(ResourceUtility.getString("EXCEL_FILE_ROOT_PATH")+filename); 
    	BufferedInputStream inBuff=new BufferedInputStream(input); 

    	// �½��ļ���������������л��� 
    	FileOutputStream output = new FileOutputStream(path+filename); 
    	BufferedOutputStream outBuff=new BufferedOutputStream(output); 

    	// �������� 
    	byte[] b = new byte[1024 * 5]; 
    	int len; 
    	while ((len =inBuff.read(b)) != -1) { 
    	outBuff.write(b, 0, len); 
    	} 
    	// ˢ�´˻��������� 
    	outBuff.flush(); 

    	//�ر��� 
    	inBuff.close(); 
    	outBuff.close(); 
    	output.close(); 
    	input.close();
    }
    
    /**
     * ����ҳ����
     * @param sr
     * @param kn
     * @return
     * @throws Exception
     */
    
    public static String createFinalHtml(String dirpath) throws Exception {
    	StringBuffer res = new StringBuffer("");
    	res.append("<html>"+"\r\n");
    	res.append("<script type='text/javascript'>"+"\r\n");
    	res.append("function dispsub(tId)"+"\r\n");
    	res.append("{"+"\r\n");
    	res.append("var t = document.getElementById(tId);"+"\r\n");
    	res.append("var objimg = document.getElementById(tId+'Arrow');"+"\r\n");
    	res.append("if (objimg.src.match('Right'))"+"\r\n");
    	res.append("{"+"\r\n");
    	res.append("objimg.src = objimg.src.replace('Right','Down');"+"\r\n");
    	res.append("}"+"\r\n");
    	res.append("else"+"\r\n");
    	res.append("{"+"\r\n");
    	res.append("objimg.src = objimg.src.replace('Down','Right');"+"\r\n");
    	res.append("}"+"\r\n");
    	res.append("if(t.style.display=='none')"+"\r\n");
    	res.append("{"+"\r\n");
		res.append("t.style.display='';"+"\r\n");
		res.append("}"+"\r\n");
		res.append("else{"+"\r\n");
		res.append("t.style.display='none';"+"\r\n");
		res.append("}"+"\r\n");
		res.append("}"+"\r\n");
		res.append("</script>"+"\r\n");
		res.append("<style>"+"\r\n");
		res.append("body{ background-color:#ededed;}"+"\r\n");
		res.append("A:link   {"+"\r\n");
		res.append("COLOR:   #000000;"+"\r\n");
		res.append("TEXT-DECORATION:   none;"+"\r\n");
		res.append("display: table;"+"\r\n");
		res.append("margin: 3px;"+"\r\n");
		res.append("padding: 0px;"+"\r\n");
		res.append("font-size: 14px;"+"\r\n");
		res.append("};"+"\r\n");
		res.append("A:visited   {"+"\r\n");
		res.append("COLOR:   #000000;"+"\r\n");
		res.append("TEXT-DECORATION:   none;"+"\r\n");
		res.append("display: table;"+"\r\n");
		res.append("font-size: 14px;"+"\r\n");
		res.append("margin: 3px;"+"\r\n");
		res.append("};"+"\r\n");
		res.append("A:active   {"+"\r\n");
		res.append("COLOR:   #000;"+"\r\n");
		res.append("TEXT-DECORATION:   none;"+"\r\n");
		res.append("display: table;"+"\r\n");
		res.append("font-size: 14px;"+"\r\n");
		res.append("margin: 3px;"+"\r\n");
		res.append("};"+"\r\n");
		res.append("A:hover   {"+"\r\n");
		res.append("COLOR:   #000;"+"\r\n");
		res.append("TEXT-DECORATION:   none;"+"\r\n");
		res.append("background-color: #bdcedc;"+"\r\n");
		res.append("display: table;"+"\r\n");
		res.append("margin: 0px;"+"\r\n");
		res.append("padding: 3px;"+"\r\n");
		res.append("width: auto;"+"\r\n");
		res.append("font-size: 14px;"+"\r\n");
		res.append("};"+"\r\n");
		res.append("</style>"+"\r\n");
    	res.append("<body>"+"\r\n");
    	res.append("<img style='cursor: hand;'"+"\r\n");
    	res.append("onclick=\"dispsub('act1')\""+"\r\n");
    	res.append("id='act1Arrow' src='ArrowDown.gif'"+"\r\n");
    	res.append("width='16' height='16'/>"+"\r\n");
    	res.append("Index"+"\r\n");
    	res.append("<br />"+"\r\n");
    	res.append("<table width='100%' cellspacing='0' cellpadding='0'"+"\r\n");
    	res.append("border='0' id='act1' style='display: none' style='margin-left:10px;'>"+"\r\n");
    	
    	//��һ��Ŀ¼������
    	File dir1 = new File(dirpath);
        File[] files1 = dir1.listFiles();
        if (files1 != null && files1.length > 0) {
        	for (int i1 = 0; i1 < files1.length; i1++) {
                //�жϴ��ļ��Ƿ���һ���ļ���
                if (files1[i1].isDirectory() && !"final".equals(files1[i1].getName())) {
                	res.append("<tr>"+"\r\n");
                	res.append("<td>"+"\r\n");
                	res.append("<img style='cursor: hand;'"+"\r\n");
                	res.append("onclick=\"dispsub('act"+i1+"')\""+"\r\n");
                	res.append("id='act"+i1+"Arrow' src='ArrowDown.gif'"+"\r\n");
                	res.append("width='16' height='16' />"+"\r\n");
                	res.append("<span style='background-image:url(org.png); background-repeat:no-repeat; padding-left:20px; font-size:14px;'>"+files1[i1].getName()+"</span>"+"\r\n");
            		res.append("<br />"+"\r\n");
                	//�ڶ���Ŀ¼����������
                	File dir2 = new File(files1[i1].getAbsolutePath());
                    File[] files2 = dir2.listFiles();
                    if (files2 != null && files2.length > 0) {
                    	res.append("<table width='100%' cellspacing='0' cellpadding='0'"+"\r\n");
                		res.append("border='0' id='act"+i1+"' style='display: none' style='margin-left:20px;'>"+"\r\n");
                    	for (int i2 = 0; i2 < files2.length; i2++){
                    		res.append("<tr>"+"\r\n");
                        	res.append("<td>"+"\r\n");
                        	res.append("<img style='cursor: hand;'"+"\r\n");
                        	res.append("onclick=\"dispsub('act"+i1+i2+"')\""+"\r\n");
        					res.append("id='act"+i1+i2+"Arrow' src='ArrowDown.gif'"+"\r\n");
        					res.append("width='16' height='16'/>"+"\r\n");
                        	res.append("<span style='font-size:14px; background-image:url(tel.png); padding-left:18px; background-repeat:no-repeat;'>"+files2[i2].getName()+"</span>"+"\r\n");
        					res.append("<br />"+"\r\n");
                            //�жϴ��ļ��Ƿ���һ���ļ���
                            if (files2[i2].isDirectory()) {
                            	res.append("<table width='100%' cellspacing='0' cellpadding='0'"+"\r\n");
                            	res.append("border='0' id='act"+i1+i2+"' style='display: none' style='margin-left:30px;'>"+"\r\n");
                            	//��������֪ʶHTMLҳ
                            	File dir3 = new File(files2[i2].getAbsolutePath());
                                File[] files3 = dir3.listFiles();
                                if (files3 != null && files3.length > 0) {
                                	for (int i3 = 0; i3 < files3.length; i3++) {
                                		res.append("<tr>"+"\r\n");
                                    	res.append("<td>"+"\r\n");
                                    	res.append("<a href='../"+files1[i1].getName()+"/"+files2[i2].getName()+"/"+files3[i3].getName()+"'"+" target='content'>"+files3[i3].getName()+"</a><br>"+"\r\n");
                                        res.append("</td>"+"\r\n");
                                    	res.append("</tr>"+"\r\n");
                                    }
                                }
                                res.append("</table>"+"\r\n");
                            } else {
                            }
                            res.append("</td>"+"\r\n");
                        	res.append("</tr>"+"\r\n");
                        }
                    	res.append("</table>"+"\r\n");
                    }
                    res.append("</td>"+"\r\n");
                	res.append("</tr>"+"\r\n");
                } else {
                }
            }
        }
		res.append("</table>"+"\r\n");
    	res.append("</body>"+"\r\n");
	    res.append("</html>"+"\r\n");
    	return res.toString();
    }
    
	/**
	 * ֪ʶ�⵼��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void downHtmlsForKn(List<KnowLedgeInfo> knList, String id) throws Exception {
		String bzpath = ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"htmls"+File.separator+id;
		File bzpath_file = new File(bzpath);
		if(!bzpath_file.exists()) {
			bzpath_file.mkdirs();
		}
		for(KnowLedgeInfo ki:knList){
			htmlTemp = new StringBuffer("");
			KnowledgeBL knowLedgeBL = (KnowledgeBL) WebApplicationSupport.getBean("knowledgeBL");
			KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
			cond.setKnid(ki.getKnid());
			cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
			Knowledge kn = knowLedgeBL.searchKnowledgeByByKnid(cond);
			//��ѯ�鵵�˻���
			UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
			User u = userBL.searchUserByKey(kn.getKnapprover());
			
			//֪ʶ��������
			kn.getKntelareaname();
			
			//����Ŀ¼�ṹ
			boolean bFile = false;
			
			String fpath = bzpath;
			File  dirFile = new File(fpath);
			bFile = dirFile.exists();
			if( bFile == false ){
				bFile = dirFile.mkdirs();
			}
			if(StringUtils.isEmpty(kn.getKntelareaname())){
				fpath = bzpath+File.separator+u.getOrgname()+File.separator;
				dirFile = new File(fpath);
				bFile = dirFile.exists();
				if( bFile == false ){
					bFile = dirFile.mkdirs();
				}
				fpath = bzpath+File.separator+u.getOrgname()+File.separator+"����"+File.separator;
				dirFile = new File(fpath);
				bFile = dirFile.exists();
				if( bFile == false ){
					bFile = dirFile.mkdirs();
				}
			}else{
				fpath = bzpath+File.separator+u.getOrgname()+File.separator;
				dirFile = new File(fpath);
				bFile = dirFile.exists();
				if( bFile == false ){
					bFile = dirFile.mkdirs();
				}
				fpath = bzpath+File.separator+u.getOrgname()+File.separator+kn.getKntelareaname()+File.separator;
				dirFile = new File(fpath);
				bFile = dirFile.exists();
				if( bFile == false ){
					bFile = dirFile.mkdirs();
				}
			}
			
			File file = new File(fpath+kn.getKnserial()+"_"+kn.getKntitle().trim().replaceAll("[/\\:*|\"<>?]", "")+".html");
			FileOutputStream fos = new FileOutputStream(file);
			String html = createKnowledgeDownHtml(htmlTemp,kn);
			fos.write(html.getBytes());
			fos.close();
		}
		//////����INDEX�ļ�//////
		
		//����INDEX���ļ�
		String index = createIndexHtml();
		File file_I = new File(bzpath+File.separator+"Index.html");
		FileOutputStream fos_I = new FileOutputStream(file_I);
		fos_I.write(index.getBytes());
		fos_I.close();
		
		//���������ļ�
		boolean bFile = false;
		String fpath = bzpath+File.separator+"final";
		File  dirFile = new File(fpath);
		bFile = dirFile.exists();
		if( bFile == false ){
			bFile = dirFile.mkdir();
		}
		String finalFile = createFinalHtml(bzpath);
		File file_F = new File(fpath+File.separator+"final.html");
		FileOutputStream fos_F = new FileOutputStream(file_F);
		fos_F.write(finalFile.getBytes());
		fos_F.close();
		
		//����ͼƬ�ļ�
		createPicture(bzpath+File.separator+"final"+File.separator,"ArrowDown.gif");
		createPicture(bzpath+File.separator+"final"+File.separator,"ArrowRight.gif");
		createPicture(bzpath+File.separator+"final"+File.separator,"org.png");
		createPicture(bzpath+File.separator+"final"+File.separator,"tel.png");
		
		//////����INDEX�ļ�//////
		
		//��ZIP��
		ExportHtml.zipFileName = ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"allKnowledge.zip";
		ExportHtml.createZipOut();

		ExportHtml.packToolFiles(bzpath, "allKnowledge");

        ExportHtml.closeZipOut();
		log.debug("�����ɣ�");
	}
	
	
	/**

     * ��һ��Ŀ¼�����zip�ļ��е�ĳĿ¼

     * @param dirpath   Ŀ¼���Ե�ַ

     * @param pathName  zip��Ŀ¼

     */

    public static void packToolFiles(String dirpath, String pathName) throws FileNotFoundException, IOException {

        if (StringUtils.isNotEmpty(pathName)) {

            pathName = pathName + File.separator;

        }

        packToolFiles(zaos, dirpath, pathName);

    }

 

    /**

     * ��һ��Ŀ¼�����һ��ָ����zip�ļ���

     * @param dirpath           Ŀ¼���Ե�ַ

     * @param pathName       zip�ļ������ַ

     */

    public static void packToolFiles(ZipArchiveOutputStream zaos, String dirpath, String pathName) throws FileNotFoundException, IOException {
    	ByteArrayOutputStream tempbaos = new ByteArrayOutputStream();

        BufferedOutputStream tempbos = new BufferedOutputStream(tempbaos);
        File dir = new File(dirpath);

        //���ش˾���·���µ��ļ�

        File[] files = dir.listFiles();

        if (files == null || files.length < 1) {

            return;

        }

        for (int i = 0; i < files.length; i++) {

            //�жϴ��ļ��Ƿ���һ���ļ���

            if (files[i].isDirectory()) {

                packToolFiles(zaos, files[i].getAbsolutePath(), pathName + files[i].getName() + File.separator);

            } else {

                zaos.putArchiveEntry(new ZipArchiveEntry(pathName + files[i].getName()));

                IOUtils.copy(new FileInputStream(files[i].getAbsolutePath()), zaos);

                zaos.closeArchiveEntry();
            }
        }

 

        tempbaos.flush();

        tempbaos.close();

 

        tempbos.flush();

        tempbos.close();

    }
	
}
