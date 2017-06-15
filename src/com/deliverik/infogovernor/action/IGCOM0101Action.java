package com.deliverik.infogovernor.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.bl.IGCOM01BL;
import com.deliverik.infogovernor.broker.DashBoardJobProxy;
import com.deliverik.infogovernor.dto.IGCOM01DTO;
import com.deliverik.infogovernor.form.IGCOM0101Form;

/**
 * ��¼������Action����
 *
 */
public class IGCOM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0101Action.class);
	private boolean flag = true;

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��¼���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001", "�û����������¼ϵͳ"));
			//���ú�����Ʒÿ���̵�
//			InventoryJobProxy.getInstance().addInventoryJob();
//			DashBoardJobProxy.getInstance().addDashBoardRTJob();
			log.debug("========��¼���������ʾ�������========");
			return mapping.findForward("DISP");
		}else{
			//DTO
			log.debug("========�û���¼����ʼ========");
		
			//���ð����У��
			//*************add by tangxiaona at 2010-06-17******************
				
//			BASE64Decoder base64De = new BASE64Decoder();// ʵ����һ��������
//			// �������ļ��л�ù�������,��String ���͵����Ľ���
//			String endday =  new String (base64De.decodeBuffer(IniReader.getValue("DATE_KEY")));
//			String startday = new String (base64De.decodeBuffer(IniReader.getValue("START_DATE_KEY")));
//			String path = this.getServlet().getServletContext().getRealPath(File.separator);
//			System.out.println(path+"===path===");
//			System.out.println(File.separator+"===File.separator===");
//			
//			File file = new File(path+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+"file.txt");
//			
//			System.out.println(file+"===file===");
//			
//			
//			FileInputStream fis = new FileInputStream(file); 
//			BufferedReader in = new BufferedReader(new InputStreamReader(fis)); 
//			String lastDate="";//��ȡ�ϴε�¼��¼ʱ��
//			lastDate=in.readLine();
//			if(!"".equals(lastDate)&&lastDate!=null){
//				lastDate = new String (base64De.decodeBuffer(lastDate));
//			}
//			String today = IGStringUtils.getCurrentDate().replaceAll("/", "");  //��������
//			if(Integer.parseInt(today)<Integer.parseInt(startday)){
//				throw new BLException("IGCOM0101.E008");//��ǰʱ��С�ڿ�ʼʱ�䣬��ϵͳʱ���쳣��Ϣ
//			}
//			else if(Integer.parseInt(today)>Integer.parseInt(endday)){
//				throw new BLException("IGCOM0101.E004");//���֤�Ѿ����ڣ����쳣
//			}
//			else{//�����ָ��ʱ�䷶Χ�ڣ�Ҫ��ǰϵͳʱ������ϴμ�¼ʱ��
//				BASE64Encoder base64en = new BASE64Encoder();// ʵ����һ��������
//				if("".equals(lastDate)||lastDate==null){//�����ǰ�״ε�½����ϵͳ����д��file�ļ���
//					if (!file.exists()) {
//						file.createNewFile();
//					}
//
//					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//					bw.write(base64en.encode(today.getBytes()));
//					bw.close();
//				} else {// ��������״ε�½����ô�жϵ�ǰϵͳʱ���Ƿ�����ϴμ�¼ʱ��
//					if (Integer.parseInt(lastDate) > Integer.parseInt(today)) {
//						throw new BLException("IGCOM0101.E008");
//					} else {
//
//						BufferedWriter bw = new BufferedWriter(new FileWriter(
//								file));
//						bw.write(base64en.encode(today.getBytes()));
//						bw.close();
//
//					}
//
//				}
//			}
	
			//*************add by tangxiaona at 2010-06-17******************
			IGCOM01DTO dto = new IGCOM01DTO();
			flag = true;
			//��֤��½Ȩ��BL
			IGCOM01BL ctrlBl = (IGCOM01BL) getBean("IGCOM01BL");
			IGCOM0101Form form = (IGCOM0101Form) actionForm;
			
			//ȡ��Ļ��ǰ�ֱ���
			if(form.getPage_width()!=null && !"".equals(form.getPage_width())){
				req.setAttribute("page_width", form.getPage_width());
			}
			
			//�жϵ�½��ʽ
			String loginType = "";//��½��ʽ
			String localuser = "";//���ص�½�û���
			CodeListUtils ctlBL =  (CodeListUtils)getBean("codeListUtils");
			loginType = ctlBL.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_AUTHORIZATIONTYPE);
			localuser = ctlBL.getCodeValue(CodeDefinition.LDAP, "", "", CodeDefinition.LDAP_LOCALORIZATIONTYPE);
			
			for(int i=0,j=localuser.split(",").length;i<j;i++){//�жϵ�ǰ��½�û��Ƿ��ڱ��ص�½����
				String localUserId =  localuser.split(",")[i];
				if(null!=localUserId && form.getUserid().equals(localUserId)){
					flag = false;
				}
			}
			
			dto.setUserSearchCond(form);
			dto.setIGCOM0101Form(form);
			
			//ʹ��LDAP��ʽ��½
			if("1".equals(loginType) && flag){
				
				dto = ctrlBl.loginActionByLDAP(dto);

			}else{
				
				//��ȡAD����
				loginType = ctlBL.getCodeValue(CodeDefinition.AD, "", "", CodeDefinition.AD_AUTHORIZATIONTYPE);
				localuser = ctlBL.getCodeValue(CodeDefinition.AD, "", "", CodeDefinition.AD_LOCALORIZATIONTYPE);
				//ʹ��AD��ʽ��¼
				if("1".equals(loginType) && flag){
					dto = ctrlBl.loginActionByAD(dto);
				}else{
					//ʹ����ͨ��ʽ��½
					dto = ctrlBl.loginAction(dto);
				}
				
			}
			
			//�û���Ϣ��ʾ
			int msgCnt = dto.getMessageList().size();
			if(msgCnt > 0){
				for(ActionMessage ms : dto.getMessageList()){
					addMessage(req, ms);
				}
			}
			setSessionAttribute(req, SESSION_KEY_LOGIN_USER, dto.getUser());
			
			log.debug("========�û���¼�������========");
			return mapping.findForward("SUCCESS");
		}
	}

}
