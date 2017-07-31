package com.deliverik.infogovernor.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.MessageResources;
import org.dom4j.DocumentHelper;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.model.condition.InStockSearchCondImpl;
import com.csebank.items.util.DefineUtils;
import com.csebank.lom.bl.IGLOM02BL;
import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.bl.IGASMBLType;
import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.bl.task.IG601BL;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG013SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG601SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.bl.task.EntityItemUntreatedVWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0110BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0114BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0121BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0125BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0152BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0305BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0601BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0602BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0603BL;
import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0125Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.RelationTreeTB;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0607VW;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG286BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG725BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowLinkageHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG132TB;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.asset.bl.IGASM10BL;
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1102Form;
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.cic.bl.IGCIC01BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM01BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM02BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM03BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM04BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM05BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM06BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM07BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM08BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM09BL;
import com.deliverik.infogovernor.dbm.bl.IGDBM10BL;
import com.deliverik.infogovernor.dbm.bl.task.BussinessAvailvalVWBL;
import com.deliverik.infogovernor.dbm.bl.task.Ip_FilterBL;
import com.deliverik.infogovernor.dbm.bl.task.TOPOXMLBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM01DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM02DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM03DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM04DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM05DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM06DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM07DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM08DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM09DTO;
import com.deliverik.infogovernor.dbm.dto.IGDBM10DTO;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCondImpl;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCondImpl;
import com.deliverik.infogovernor.dbm.model.entity.TOPOXMLTB;
import com.deliverik.infogovernor.fxk.bl.IGFXK03BLType;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0104Form;
import com.deliverik.infogovernor.risk.bl.task.CheckWorkResultBL;
import com.deliverik.infogovernor.risk.bl.task.CheckworkInfoResultBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCondImpl;
import com.deliverik.infogovernor.room.bl.task.CompareTemplateBL;
import com.deliverik.infogovernor.room.model.CompareTemplateInfo;
import com.deliverik.infogovernor.room.model.condition.CompareTemplateSearchCondImpl;
import com.deliverik.infogovernor.room.model.entity.CompareTemplateTB;
import com.deliverik.infogovernor.room.utils.DrawFloorUtil;
import com.deliverik.infogovernor.room.utils.DrawResBean;
import com.deliverik.infogovernor.rpt.bl.task.SOC0204BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0207BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0405BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0409BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0410BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0411BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0415BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0419BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0428BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0429BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0434BL;
import com.deliverik.infogovernor.rpt.job.CustomBirtReportImport;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.SOC0405Info;
import com.deliverik.infogovernor.rpt.model.SOC0409Info;
import com.deliverik.infogovernor.rpt.model.SOC0410Info;
import com.deliverik.infogovernor.rpt.model.SOC0411Info;
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.rpt.model.SOC0419Info;
import com.deliverik.infogovernor.rpt.model.SOC0428Info;
import com.deliverik.infogovernor.rpt.model.SOC0429Info;
import com.deliverik.infogovernor.rpt.model.SOC0434Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0405SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0409SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0410SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0411SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0415SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0419SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0428SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0429SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0434SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.entity.SOC0204TB;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM04BL;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM04SearchCondImpl;
import com.deliverik.infogovernor.soc.bl.task.SOC0114VW_FXBL;
import com.deliverik.infogovernor.soc.bl.task.UserRegionBL;
import com.deliverik.infogovernor.soc.cim.bl.IGCIMConstants;
import com.deliverik.infogovernor.soc.cim.bl.task.PortRelationBL;
import com.deliverik.infogovernor.soc.dbs.bl.IGDBS01BL;
import com.deliverik.infogovernor.soc.dbs.bl.IGDBS02BL;
import com.deliverik.infogovernor.soc.dbs.dto.IGDBS01DTO;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.bl.IGMntConstantDefine;
import com.deliverik.infogovernor.soc.mnt.bl.task.MonitorTypeDefBL;
import com.deliverik.infogovernor.soc.mnt.bl.task.Object_ListBL;
import com.deliverik.infogovernor.soc.mnt.bl.task.SOC0301BL;
import com.deliverik.infogovernor.soc.mnt.bl.task.SOC0304BL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeDefSearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0304TB;
import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;
import com.deliverik.infogovernor.soc.model.condition.PortRelationSearchCondImpl;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCondImpl;
import com.deliverik.infogovernor.soc.model.condition.UserRegionSearchCondImpl;
import com.deliverik.infogovernor.soc.model.entity.UserRegionTB;
import com.deliverik.infogovernor.soc.vir.bl.task.SOC0154BL;
import com.deliverik.infogovernor.soc.vir.model.SOC0154Info;
import com.deliverik.infogovernor.soc.vir.model.condition.SOC0154SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154TB;
import com.deliverik.infogovernor.sym.bl.IGSYM11BL;
import com.deliverik.infogovernor.sym.bl.IGSYM11BLType;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.syslog.bl.task.Mss00001BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00002BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00004BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00008BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00014BL;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;
import com.deliverik.infogovernor.syslog.model.Mss00014Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00002SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00008SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.dao.Mss00008DAO;
import com.deliverik.infogovernor.syslog.vo.IGLOG0003VO;
import com.deliverik.infogovernor.util.CodeDefine;
import com.deliverik.infogovernor.util.SVCHelper;
import com.deliverik.plugin.mail.MAILThread;
import com.deliverik.plugin.sms.SMSThread;
import com.google.gson.Gson;

/**
 * Ajax����Action����
 *	��ֲFROM soc4.3
 * @author none
 */
public class AjaxAction extends BaseAction {

	/** Ajax����LOG */
	static Log log = LogFactory.getLog(AjaxAction.class);

	// ���ο���log  
    static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
	private static final String ajaxParam_Type  = "type";
	private static final String ajaxType_ename = "ename";
	private static final String ajaxType_ccname = "ccname";
	private static final String ajaxType_cvalue = "cvalue";
	private static final String ajaxType_ccdvalue = "ccdvalue";
	private static final String ajaxType_eilable = "eilable";//��ǰ�ʲ������
	private static final String ajaxType_servertime = "servertime";//��ǰ������ʱ��ȡ��
	private static final String ajaxType_seqcode = "searchOldStock";//��ǰ��Ʒ��������Ϣ
	private static final String ajaxType_seqGoodsCode = "searchGoodsCode";//��ǰ��Ʒ������������Ʒ��Ϣ
	private static final String ajaxType_selectEntityItem = "selectEntityItem";//IGCOM0306�����¼�ʲ�ѡ�д���
	private static final String ajaxType_confirmEntityItem = "confirmEntityItem";//IGCOM0306�����¼�ʲ�ѡ��ȷ��
	private static final String ajaxType_confirmEntityItemfull = "confirmEntityItemfull";//IGCOM0311�豸Ԥ����
	private static final String ajaxType_removeSlectedEntityItem = "removeSlectedEntityItem";//IGCOM0306�����¼�ʲ�ɾ��
	private static final String ajaxType_getSlectedEntityItemNum = "getSlectedEntityItemNum";//IGCOM0306�����¼��ȡѡ�����
	private static final String ajaxType_searchprocessJC = "searchprocessJC";//��ҳ���̽�ɫ��ʾ
	private static final String ajaxType_searchprocessOP = "searchprocessOP";//��ҳ���̴�������ʾ
	private static final String ajaxType_searchprocessStatus = "searchprocessStatus";//���̲�ѯ����,�����������Ͳ�ѯ״̬�ڵ�
	private static final String ajaxType_deleteAttid = "deleteAttid";//֪ͨ����ɾ������
	private static final String ajaxType_process_Priority = "processPriority"; //�������ȼ�ȡ��
	
	private static final String ajaxType_DashBoard_BankMaster = "BankMaster";//�г���ҳflex����
	private static final String ajaxType_DashBoard_DepartmentMaster = "DepartmentMaster";//������ҳflex����
	private static final String ajaxType_DashBoard_ProcessTopics = "ProcessTopics";//������ʩ��ҳflex����
	private static final String ajaxType_DashBoard_BasicEquipment = "BasicEquipment";//������ʩ��ҳflex����
	private static final String ajaxType_DashBoard_processProblem = "processProblem"; //�����ۺϷ�������
	private static final String ajaxType_DashBoard_processIncident = "processIncident"; //�¼��ۺϷ�������
	private static final String ajaxType_DashBoard_processChange = "processChange"; //����ۺϷ�������
	private static final String ajaxType_DashBoard_processWork = "processWork"; //�����ۺϷ�������
	private static final String ajaxType_DashBoard_systemUse = "systemUse"; //ϵͳ�����ʷ�������
	private static final String ajaxType_DashBoard_channelBusiness = "channelBusiness"; //����ҵ��ʵʱ���
	//20121017 add start zjg
	private static final String ajaxType_DashBoard_WarningInfo = "WarningInfo"; //HQ,Ħ��,�����澯��Ϣ��ѯ
	private static final String ajaxType_DashBoard_PlatformAvailable = "PlatformAvailable"; //HQ,ƽ̨������
	private static final String ajaxType_DashBoard_PlatformCount = "PlatformCount"; //HQ,ƽ̨���� 
	private static final String ajaxType_DashBoard_PlatformMeasurementCount = "PlatformMeasurementCount"; //hq���ƽָ̨��
	private static final String ajaxType_DashBoard_HangZhangPieAll = "HangZhangPieAll"; //�г�6��Բ
	private static final String ajaxType_TopoMap_saveTopoMapXML= "saveTopoMapXML"; //topomap xml
	private static final String ajaxType_getBussTopoMapXML= "getBussTopoMapXML"; //topomap xml
	private static final String ajaxType_saveBussTopoMapXML= "saveBussTopoMapXML"; //Busstopomap axis
	private static final String ajaxType_getBusinessTopoXML = "getBusinessTopoXML";//ҵ��ϵͳ���˲�ѯ
	private static final String ajaxType_getVWTopoXML = "getVWTopoXML";
	private static final String ajaxType_getHostEiidByVW = "getHostEiidByVW";
	private static final String ajaxType_saveVWTopoMapXML= "saveVWTopoMapXML";
	private static final String ajaxType_getBusinessTopoXMLForBJ = "getBusinessTopoXMLForBJ";
	private static final String ajaxType_SMS_setStatus= "setSMSstatus"; //SMS status
	private static final String ajaxType_EveryDayWorkSMS_setStatus= "setEveryDayWorkSMSstatus"; //SMS status
	private static final String ajaxType_WorkItemSMS_setStatus= "setWorkItemSMSstatus"; //������������ѿ��� SMS status
	private static final String ajaxType_MAIL_setStatus= "setMAILstatus"; //MAIL status
	//20121017 add end zjg
	private static final String ajaxType_SelectUserItem = "selectUserItem"; //ѡ����Ա����
	private static final String ajaxType_searchButtonList = "searchButtonList";//����״̬ID��ѯ�趨�İ�ť����
	
	//add by song for linkage start
	private static final String ajaxType_searchValue = "searchValue";//������(�������仯���±�����ֵ�仯)
	private static final String ajaxType_searchObjectForCheck = "searchObjectForCheck";//ȡ����Ҫ��У��ı���Ϣ
	private static final String ajaxType_checkLinkage = "checkLinkage";//�ύʱ��У��
	//add by song for linkage end
	
	/** �жϻ��������Ƿ���� */
	private static final String ajaxType_checkEntityItemByKey = "checkEntityItemByKey";

	/** ɾ���������� */
	private static final String ajaxType_DELETE_PART = "deletePart";
	
	/** ����������� */
	private static final String ajaxType_SAVE_JIFANG = "saveJifangData";
	
	/** ����������� */
	private static final String ajaxType_SAVE_GEDUAN = "saveGeDuanData";
	
	/** ������Ͼ������� */
	private static final String ajaxType_SAVE_PARTABSOLUTE = "savePartAbsolute";
	
	/** ��ȡ�������� */
	private static final String ajaxType_GET_PART = "getPartInfo";
	
	/** ��ȡ�������� */
	private static final String ajaxType_GET_PARTXY = "getPartXY";
	
	/** ����������� */
	private static final String ajaxType_GETZHUJIDATE = "getZhuJiData";
	
	/** �����豸�ϼ���Ϣ */
	private static final String ajaxType_SAVE_ZHUJIRELATION = "saveZhuJiRelation";
	
	/** ȡ�����ϼܵ��豸��Ϣ */
	private static final String ajaxType_GETJIGUIDETAIL = "getJiguiDetal";
	
	private static final String ajaxType_TRACEZHUJILOCATION = "traceZhuJiLocation";

	/** ��ѯ������Ϣ������ʣ��Uλ������ */
	private static final String ajaxType_GETJIGUILASTDETAIL = "getJiGuiLastDetail";

	/** ��ѯ���������Ļ���*/
	private static final String ajaxType_TRACEJIGUILOCATION = "traceJiGuiLocation";
	
	/** ȡ���豸��ϸ��Ϣ */
	private static final String ajaxType_GETZHUJIDETAIL = "getZhujiDetal";
	
	/** ȡ�û��������Ϣ */
	private static final String ajaxType_GETJIGUIDATA = "getJiguiData";
	
	/** ȡ�û���ƽ��ͼ��ѯ���������˵� */
	private static final String ajaxType_GETSEARCHVALUE = "getSearchValue";
	
//	private static final String ajaxType_SMS_Connection = "testConnection";
	
	//�洢��ϵͼ
	private static final String ajaxType_SOCStorage_App = "SOCStorage_App";
	
	//�洢��ϵͼ
	private static final String ajaxType_SOCStorage_Meta = "SOCStorage_Meta";

	//�洢��ϵͼ
	private static final String ajaxType_SOCStorage_XML = "SOCStorage_XML";
	
	//�洢��ϵͼ
	private static final String ajaxType_SOCStorage_Disk = "SOCStorage_Disk";
	/**soc4.3 ����*/
	//dashboard��ά����ҳ(�� host iops etc.)
	private static final String ajaxType_SOCEMC = "SOCEMC";	
	//dashboard��ά����ҳ(�� host iops etc.)
	private static final String ajaxType_SOCEMC_A = "SOCEMC_A";
	//��ض���ֵ
	private static final String ajaxType_KPI="KPI";
	//�澯��Ϣ
	private static final String ajaxType_EVENT="EVENT";
	// ��ѯ�豸��־�б�
	private static final String ajaxType_searchAlm0401List = "searchAlm0401List";
	//ʵʱ���ܼ��(DMXRealTime)
	private static final String ajaxType_DMXRealTime="DMXRealTime";
	//���ü���ӳ�ʱ��
	private static final String ajaxType_setMtPstoptime="setMtPstoptime";
	//�������
	private static final String ajaxType_KPIVAL="KPIVAL";
	//dashboard����
	//�����ͼ
	private static final String ajaxType_getPieSingle="getPieSingle";
	//��ѯ�����б�
	private static final String ajaxType_showHostList="showHostList";
	//��ѯ������vg
	private static final String ajaxType_showHostVG="showHostVG";
	//��ѯlunid
	private static final String ajaxType_showHostLUNID="showHostLUNID";
	//��ѯvg��ts
	private static final String ajaxType_showVGTS="showVGTS";
	//��ѯvg��fs
	private static final String ajaxType_showVGFS="showVGFS";
	//��ѯLV warning
	private static final String ajaxType_showLVWarning="showLVWarning";
	//��ѯVIO ʣ��LUNID
	private static final String ajaxType_showVIOLUNID="showVIOLUNID";
	//�澯״̬	0:δ���� 1���Ѵ���
	private static final String ajaxType_SES="StorageEventStatus";
	
	//�����Զ����ĵ�
	private static final String ajaxType_generateCustomDoc="generateCustomDoc";
	//��ȡģ����������
	private static final String ajaxType_getTemDateType="getTemDateType";
	//����ɾ���Զ��屨������
	private static final String ajaxType_delMyChoiceRCL="delMyChoiceRCL";
	//�����Զ��屨������
	private static final String ajaxType_addReportCustomLink="addReportCustomLink";
	
	//����ͼ��Ϣ
	private static final String ajaxType_SHOWDATAIO="showDataIO";
	
	//����ͼ��Ϣ
	private static final String ajaxType_SHOWSTORAGEIO="showStorageIO";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYFS="changeColorByFs";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYLV="changeColorByLv";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYVG="changeColorByVg";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYPV="changeColorByPv";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYPORT="changeColorByPort";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYZONGING="changeColorByZonging";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYFAPORT="changeColorByFaPort";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYFA="changeColorByFa";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYMETA="changeColorByMeta";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYHYPER="changeColorByHyper";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYDA="changeColorByDa";
	
	//����ͼIO��ɫ��Ϣ
	private static final String ajaxType_CHANGECOLORBYDISK="changeColorByDisk";
	
	//��֤������IP��ַ�Ƿ��Ѿ�����
	private static final String ajaxType_ISREPEATIP="isRepeatIP";
	
	// �ж���ʾ����
	private static final String ajaxType_CHECKIO = "checkIo";
	
	// ����Ӱ�����XML
	private static final String ajaxType_createImageXml = "createImageXml";
	
	//ҵ����Դ��ػ�ȡ�����ڵ�
	private static final String ajaxType_getServerList="getServerList";
	//����service���ͻ�ȡ����
	private static final String ajaxType_getDataByServicetypename="getDataByServicetypename";
	
	//����service��ȡ����
	private static final String ajaxType_getDataByService="getDataByService";
	//��ȡƽ̨��Ч����
	private static final String ajaxType_getPlatformAvailData="getPlatformAvailData";
	
	//��ȡƽ̨�µ�server��ȡsevice�Ƿ���Ч
	private static final String ajaxType_getServerOrServiceAvail="getServerOrServiceAvail";
	//ָ�����߻�ȡ����
	private static final String ajaxType_getMeasurememtCurve="getMeasurememtCurve";
	
	//���������û���¼��־
	private static final String ajaxType_setLoginTime="setLoginTime";

	
	//�����������Ͳ�ѯ����״̬
	private static final String ajaxType_LCZT="LCZT";
	
	//�����������Ͳ�ѯ���̱� ��������ѡ����ѡ
	private static final String ajaxType_LCBD="LCBD";
	//�����������Ͳ�ѯ���̱� ����
	private static final String ajaxType_LCBDT="LCBDT";
	//�����Ϣɾ����ˢ��
	private static final String ajaxType_getSystemDataRefresh="getSystemDataRefresh";
	private static final String ajaxType_DashBoard_PlatformAvailableForWidth = "PlatformAvailableForWidth"; //HQ,ƽ̨�����ԣ�չʾ22ϵͳ
	
	//��ѯʣ��Hyper
	private static final String ajaxType_remainHyperByAjax="remainHyperByAjax";
	
	//ҵ��ϵͳ�ؼ��ֲ�ѯ
	private static final String ajaxType_bussSearchByAjax="bussSearchByAjax";
	
	//����&HBA�ؼ��ֲ�ѯ
	private static final String ajaxType_hostHbaSearchByAjax="hostHbaSearchByAjax";
	
	//�������ؼ��ֲ�ѯ
	private static final String ajaxType_switchPortSearchByAjax="switchPortSearchByAjax";

	//Fa
	private static final String ajaxType_faPortSearchByAjax="faPortSearchByAjax";
	
	//Mate��gateKeeper
	private static final String ajaxType_hyperPortSearchByAjax="hyperPortSearchByAjax";
	
	private static final String ajaxType_searchRelationByAjax="searchRelationByAjax";
	
	private static final String ajaxType_SOCPerformance_V2 = "SOCPerformance_V2";
	
	private static final String ajaxType_checkEntityID = "checkEntityID";
	
	private static final String ajaxType_checkCID = "checkCID";
	/**��������ȡ���*/
	private static final String ajaxType_getContainTreeNode ="getContainTreeNode";
	
	/**�������ˣ���ϵ����ȡ���*/
	private static final String ajaxType_getBusinessTreeNode ="getBusinessTreeNode";
	
	private static final String ajaxType_searchig380 ="searchig380";
	
	/**�����������ѯ*/
	private static final String ajaxType_searchCategorysByType = "searchCategorysByType";
	/** ����VM CI��ѯ */
	private static final String ajaxType_getCIInfoVM = "getCIInfoVM";
	
	/** ����ID��ѯ�澯 */
	private static final String ajaxType_getAlarmByID = "getAlarmByID";
	/** ����ID��ѯָ������ */
	private static final String ajaxType_getTrendByID = "getTrendByID";
	/**����ָ���id��ѯָ���������_����ʹ��*/
	private static final String ajaxType_gatMaterChartData = "gatMaterChartData";
	
	/**����begin*/
	// �����豸�ϼ���Ϣ 
	private static final String ajaxType_SAVE_HOSTRELATION = "saveHostRelation";
	// �����豸�ϼ���Ϣ 
	private static final String ajaxType_REMOVE_HOSTRELATION = "removeHostRelation";
	// ȡ��δ�ϼܵĻ����б���װ��XML
	private static final String ajaxType_GET_TOOLSDATA = "getToolsData";
	// ��������ϵ
	private static final String ajaxType_REALTIMESAVE = "realTimeSave";
	// ɾ�������ϵ
	private static final String ajaxType_DELETE_CABINET = "deleteCabinet";
	// ���»���λ��
	private static final String ajaxType_REALTIMEUPDATE = "realTimeUpdate";
	// ����ͼ��λ��
	private static final String ajaxType_SAVE_LEGEND = "saveLegend";
	// ɾ��ͼ��λ��
	private static final String ajaxType_DELETE_LEGEND = "deleteLegend";
	// ����ͼ��λ��
	private static final String ajaxType_SAVE_ZONE = "saveZone";
	// ��û�����Ϣ
	private static final String ajaxType_GET_ROOMINFO = "getRoomInfo";
	// ��û�����Ϣ
	private static final String ajaxType_GET_ZONEINFO ="getZoneInfo";
	// ��û�����Ϣ
	private static final String ajaxType_DELETE_ZONEANDCABINET = "deleteZoneAndCabinet";
	// ��������
	private static final String ajaxType_CHANGE_ANGLE ="changeAngle";
	// ��������
	private static final String ajaxType_GET_MAP4VEC ="getMap4Vec";
	// ���ƻ���
	private static final String ajaxType_CHANGE_INDEX ="changeIndex";
	// �����Ч�ذ�
	private static final String ajaxType_ADD_NAF ="addNaF";
	// �����Ч�ذ�
	private static final String ajaxType_DELETE_NAF ="deleteNaF";
	// ��ѯ��Ч�ذ�
	private static final String ajaxType_IS_NAF ="isNAF";
	private static final String ajaxType_SearchCompareSourchHostList ="searchCompareSourchHostList";
	
	private static final String ajaxType_getRiskCheckName = "getRiskCheckName";//��ȡ���������
	
	private static final String ajaxType_getCheckResultUsername = "getCheckResultUsername";
	
	private static final String ajaxType_getAreaOptionname = "getAreaOptionname";
	/**����end*/
	
	/** syslog��ؿ�ʼ */
	// ��ѯ�豸��־�б�
	private static final String ajaxType_searchsyslogList = "searchsyslogList";
	//��ѯ�豸��־��������
	private static final String ajaxType_getAlarmTotalCount = "getAlarmTotalCount";
	// �����豸���Ͳ�ѯ�����豸��ģ��
	private static final String ajaxType_searchDevicesAndTemps = "searchDevicesAndTemps";
	// �����豸��ѯ����ģ��
	private static final String ajaxType_searchTempsByDevice = "searchTempsByDevice";
	// ��ѯҪ��ӵ��豸IP�Ƿ��Ѿ�����
	private static final String ajaxType_checkIP = "checkIP";
	// �޸Ĺ���ģ��״̬
	private static final String ajaxType_checkExist = "checkExist";
	//��ȡ�澯�籩��¼
	private static final String ajaxType_getStormRecord = "getStormRecord";
	//��ȡ���չ������Ա
	private static final String ajaxType_getUserRisk = "getUserRisk";
	//��ȡ���ռƻ�������
	private static final String ajaxType_getUserManager = "getUserManager";

	private static final String ajaxType_crateArea ="crateArea";
	
	private static final String ajaxType_getSyslogAlarmByID = "getSyslogAlarmByID";
	
	private static final String ajaxType_getFindData = "getFindData";
	
	private static final String ajaxType_saveBack = "saveBack";
	
	//һ���¼����� ��ȡ���̲�������״̬
	private static final String ajaxType_getPpsubstatus = "getPpsubstatus";
	//һ���¼����� ��ȡ���̲�������״̬ȷ��
	private static final String ajaxType_confirmPpsubstatus = "confirmPpsubstatus";
	//һ���¼����� �¼���������
	private static final String ajaxType_upgrade = "upgrade";
	
	/** syslog��ؽ��� */
	
	
	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @update 0000105
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) {

		//
		String prmType = req.getParameter(ajaxParam_Type);

		PrintWriter out = null;
		try {
			out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
			
			if(ajaxType_ename.equals(prmType)){
				//
				assistEname(req, out, req.getParameter("value"));
				
			} 
			/** syslog��� */
			else if (ajaxType_searchsyslogList.equals(prmType)) {
				searchsyslogList(req, out,req.getParameter("checkedStr"));
			} else if(ajaxType_getAlarmTotalCount.equals(prmType)){
				getAlarmTotalCount(req, out);
			} else if (ajaxType_getStormRecord.equals(prmType)) {
				getStormRecord(req, out);
			} 
			else if (ajaxType_getUserRisk.equals(prmType)) {
				//��ȡ���չ������Ա
				getUserRisk(req, out);
			} 
			else if (ajaxType_getUserManager.equals(prmType)) {
				//��ȡ���ռƻ���������Ϣ
				if(StringUtils.isNotEmpty(req.getParameter("prid"))){
					int prid = Integer.valueOf(req.getParameter("prid"));
					getUserManager(req, out, prid);
				}else{
					getUserManager(req, out, null);
				}
				
			}else if(ajaxType_getSyslogAlarmByID.equals(prmType)){
				getSyslogAlarmByID(req, out, req.getParameter("alarmid"));
			}else if(ajaxType_getFindData.equals(prmType)){
				getFindData(req,out);
			}else if (ajaxType_searchDevicesAndTemps.equals(prmType)) {
				searchDevicesAndTemps(req, out, req.getParameter("typeid"),
						req.getParameter("deviceid"));
			} else if (ajaxType_searchTempsByDevice.equals(prmType)) {
				searchTempsByDevice(req, out, req.getParameter("deviceid"),
						req.getParameter("typeid"),
						req.getParameter("pagedeviceid"));
			} else if (ajaxType_checkIP.equals(prmType)) {
				checkIP(req, out, req.getParameter("deviceip"));
			} else if (ajaxType_checkExist.equals(prmType)) {
				checkExist(req, out, req.getParameter("ruletempid"));
			} else if(ajaxType_ccname.equals(prmType)) {
				assistCcname(req, out, req.getParameter("ccid"));
			} else if(ajaxType_cvalue.equals(prmType)) {
				assistCvalue(req, out, req.getParameter("ccid"), req.getParameter("cid"));
			} else if(ajaxType_ccdvalue.equals(prmType)) {
				getCcdvalueByCoption(req, out, req.getParameter("coption"));
			} else if(ajaxType_eilable.equals(prmType)) {
				searchMaxEntityItemLable(req, out, req.getParameter("ecategorykey"));
			} else if(ajaxType_servertime.equals(prmType)) {
				searchServerTime(req, out);
			} else if(ajaxType_seqcode.equals(prmType)){
				searchOldStock(req, out, req.getParameter("seqcode"), req.getParameter("category"));
			} else if(ajaxType_selectEntityItem.equals(prmType)) {
				selectEntityItem(req, out, req.getParameter("eiid"),req.getParameter("clicktype"));
			} else if(ajaxType_confirmEntityItem.equals(prmType)) {
				confirmEntityItem(req, out);
			} else if(ajaxType_confirmEntityItemfull.equals(prmType)) {
				confirmEntityItemfull(req, out);
			} else if(ajaxType_removeSlectedEntityItem.equals(prmType)) {
				removeSlectedEntityItem(req, out, req.getParameter("eiid"));
			} else if(ajaxType_deleteAttid.equals(prmType)) {
				deleteAttid(req, out, req.getParameter("attid"));
			} else if(ajaxType_getSlectedEntityItemNum.equals(prmType)) {
				getSlectedEntityItemNum(req, out);
			} else if(ajaxType_seqGoodsCode.equals(prmType)) {
				searchGoodsCode(req, out, req.getParameter("gcategory"));
			} else if(ajaxType_searchprocessJC.equals(prmType)) {
				searchprocessJC(req, out, req.getParameter("prid"));
			} else if(ajaxType_searchprocessOP.equals(prmType)) {
				searchprocessOP(req, out, req.getParameter("prid"));
			} else if(ajaxType_searchprocessStatus.equals(prmType)) {
				searchprocessStatus(req, out, req.getParameter("pdid"), req.getParameter("property"),
						req.getParameter("ccid"),req.getParameter("propertyValue"));
			}else if(ajaxType_DashBoard_BankMaster.equals(prmType)) {
				getRequestModeForBankMaster(req, out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_DepartmentMaster.equals(prmType)) {// ȡ�ô�����ҳ����
				getRequestModeForDepartmentMaster(req, out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_BasicEquipment.equals(prmType)) {// ȡ�û�����ʩ��ҳ����
				getRequestModeForBasicEquipment(req, out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_ProcessTopics.equals(prmType)) {// ȡ������������ҳ����
				getRequestModeForProcessTopics(req, out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_processProblem.equals(prmType)){ //ȡ�������ۺϷ�����ҳ����
				getRequestModeForProcessProblem(req,out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_processIncident.equals(prmType)){ //ȡ���¼��ۺϷ�����ҳ����
				getRequestModeForProcessIncident(req,out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_processChange.equals(prmType)){ //ȡ�ñ���ۺϷ�����ҳ����
				getRequestModeForProcessChange(req,out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_processWork.equals(prmType)){ //ȡ�ù����ۺϷ�����ҳ����
				getRequestModeForProcessWork(req,out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_systemUse.equals(prmType)){ //ȡ��ϵͳ�����ʷ�������
				getRequestModeForSystemUse(req,out,req.getParameter("requestMode"));
			}else if(ajaxType_DashBoard_channelBusiness.equals(prmType)){ //ȡ������ҵ��ʵʱ���
				getRequestModeForChannelBusiness(req,out,req.getParameter("requestMode"));
			}else if(ajaxType_process_Priority.equals(prmType)){
				getPriority(req, out); //ȡ���������ȼ�
			}else if(ajaxType_DashBoard_WarningInfo.equals(prmType)){
				getDSWarningInfo(req, out); //ȡ��DS�澯��Ϣ
			}else if(ajaxType_DashBoard_PlatformAvailable.equals(prmType)){
				getDSPlatformAvailable(req, out); //hqƽ̨������

			}else if(ajaxType_DashBoard_PlatformAvailableForWidth.equals(prmType)){
				getDSPlatformAvailableForWidth(req, out); //hqƽ̨�����ԣ�չʾ22ϵͳ
			}else if(ajaxType_DashBoard_PlatformCount.equals(prmType)){
				getDSPlatformCount(req, out); //hqƽ̨count
			}else if(ajaxType_DashBoard_HangZhangPieAll.equals(prmType)){
				getDSHangZhangPieAll(req, out); //hzPIE
			}else if(ajaxType_DashBoard_PlatformMeasurementCount.equals(prmType)){
				getDSPlatformMeasurementCount(req, out); //Measurement
			}else if(ajaxType_TopoMap_saveTopoMapXML.equals(prmType)){
				saveTopoXML(req,out);
			}else if(ajaxType_getBussTopoMapXML.equals(prmType)){
				getBussTopoMapXml(req,out);
			}else if(ajaxType_getBusinessTopoXML.equals(prmType)){
				getBusinessTopoXML(req,out);
			}else if(ajaxType_getVWTopoXML.equals(prmType)){
				getVWTopoXML(req,out);
			}else if(ajaxType_getHostEiidByVW.equals(prmType)){
				getHostEiidByVW(req,out);
			}else if(ajaxType_getBusinessTopoXMLForBJ.equals(prmType)){
				getBusinessTopoXMLForBJ(req,out);
			}else if(ajaxType_saveBussTopoMapXML.equals(prmType)){
				saveBussTopoXML(req,out);
			}else if(ajaxType_saveVWTopoMapXML.equals(prmType)){
				saveVWTopoXML(req,out);
			}else if(ajaxType_SMS_setStatus.equals(prmType)){
				setSMSstatus(req,out);
			}else if(ajaxType_EveryDayWorkSMS_setStatus.equals(prmType)){
				setEveryDayWorkSMSstatus(req,out);
			}else if(ajaxType_WorkItemSMS_setStatus.equals(prmType)){
				setWorkItemSMSstatus(req,out);
			}else if(ajaxType_MAIL_setStatus.equals(prmType)){
				setMAILstatus(req,out);
			}else if (ajaxType_checkEntityItemByKey.equals(prmType)) {
				checkEntityItemByKey(req, out);// �жϷ����Ƿ����
            }else if(ajaxType_DELETE_PART.equals(prmType)){
				deletePart(req,out);//ɾ������
			}else if(ajaxType_searchValue.equals(prmType)) {
				searchValue(req, out);
			}else if(ajaxType_searchObjectForCheck.equals(prmType)) {
				searchObjectForCheck(req, out);
			}else if(ajaxType_checkLinkage.equals(prmType)) {
				checkLinkage(req, out);
			}else if(ajaxType_SAVE_JIFANG.equals(prmType)){
				saveJiFangXML(req,out);
			}else if(ajaxType_SAVE_GEDUAN.equals(prmType)){
				saveGeDuanXML(req,out);
			} else if (ajaxType_searchAlm0401List.equals(prmType)) {
				searchAlm0401List(req, out);
			}else if(ajaxType_SAVE_PARTABSOLUTE.equals(prmType)){
				savePartAbsolute(req,out);
			}else if(ajaxType_GET_PART.equals(prmType)){
				getPartXML(req,out);
			}else if(ajaxType_GET_PARTXY.equals(prmType)){
				getPartXYXML(req,out);
			}else if(ajaxType_GETZHUJIDATE.equals(prmType)){
				getZhuJiData(req,out);
			}else if(ajaxType_SAVE_ZHUJIRELATION.equals(prmType)){
				saveZhuJiRelation(req,out);
			}else if(ajaxType_GETJIGUIDETAIL.equals(prmType)){
				getJiguiDetal(req,out,req.getParameter("jitype"));
			}else if (ajaxType_TRACEZHUJILOCATION.equals(prmType)) {
			    traceZhuJiLocation(req, out, 
			            req.getParameter("zhuJiName"),
			            req.getParameter("zhuJiNum"),
			            req.getParameter("jiFangId")
			            );
			} else if (ajaxType_GETJIGUILASTDETAIL.equals(prmType)) {
			    getJiGuiLastDetail(req, out, 
			            req.getParameter("jiGuiName"),
			            req.getParameter("jiGuiNum"),
			            req.getParameter("jiFangId")
			            );
			} else if (ajaxType_TRACEJIGUILOCATION.equals(prmType)) {
			    traceJiGuiLocation(req, out,
			            req.getParameter("jiFangId"),
			            req.getParameter("U_High"),
			            req.getParameter("power"),
			            req.getParameter("load")
			     );
			}else if(ajaxType_GETZHUJIDETAIL.equals(prmType)){
				getZhujiDetail(req,out);
			}else if(ajaxType_GETJIGUIDATA.equals(prmType)){
				getJiguiData(req,out);
			}else if(ajaxType_gatMaterChartData.equals(prmType)){
				gatMaterChartData(req,out);
			}else if (ajaxType_REMOVE_HOSTRELATION.equals(prmType)) {
				removeHostRelation(req);
			}else if (ajaxType_SAVE_HOSTRELATION.equals(prmType)) {
				saveHostRelation(req);
			}else if (ajaxType_GET_TOOLSDATA.equals(prmType)) {
				getToolsData(req,out);
			} else if (ajaxType_REALTIMESAVE.equals(prmType)) {
				realTimeSave(req,out);
			} else if (ajaxType_DELETE_CABINET.equals(prmType)) {
				deleteCabinet(req,out);
			} else if (ajaxType_REALTIMEUPDATE.equals(prmType)) {
				realTimeUpdate(req,out);
			} else if (ajaxType_SAVE_LEGEND.equals(prmType)) {
				saveLegend(req,out);
			} else if (ajaxType_DELETE_LEGEND.equals(prmType)) {
				deleteLegend(req,out);
			} else if (ajaxType_SAVE_ZONE.equals(prmType)) {
				saveZone(req,out);
			} else if (ajaxType_GET_ROOMINFO.equals(prmType)) {
				getRoomInfo(req,out);
			} else if (ajaxType_GET_ZONEINFO.equals(prmType)) {
				getZoneInfo(req,out);
			} else if (ajaxType_DELETE_ZONEANDCABINET.equals(prmType)) {
				deleteZoneAndCabinet(req,out);
			} else if (ajaxType_CHANGE_ANGLE.equals(prmType)) {
				changeAngle(req,out);
			} else if (ajaxType_GET_MAP4VEC.equals(prmType)) {
				getMap4Vec(req,out);
			} else if (ajaxType_CHANGE_INDEX.equals(prmType)) {
				changeIndex(req,out);
			} else if (ajaxType_ADD_NAF.equals(prmType)) {
				addNaF(req,out);
			} else if(ajaxType_crateArea.equals(prmType)){ 
				crateArea(req,out);
			} else if (ajaxType_DELETE_NAF.equals(prmType)) {
				deleteLegend(req,out);
			} else if (ajaxType_IS_NAF.equals(prmType)) {
				isNAF(req,out);
			}else if(ajaxType_GETSEARCHVALUE.equals(prmType)){
				getSearchValue(req,out,req.getParameter("jitype"));
			}else if(ajaxType_SOCStorage_App.equals(prmType)){ //emc��ά�洢����
				getAppXMLForSOCStorage(req,out,req.getParameter("eiid"),req.getParameter("version"),req.getParameter("smallversion"));
			}else if(ajaxType_SOCStorage_Meta.equals(prmType)){ //emc��ά�洢����
				getMetaXMLForSOCStorage(req,out,req.getParameter("eiid"),req.getParameter("version"),req.getParameter("smallversion"));
			}else if(ajaxType_SOCStorage_XML.equals(prmType)){ //emc��ά�洢����
				getSOCStorage_XMLForSOCStorage(req,out,req.getParameter("metaeiid"),req.getParameter("metaversion"),req.getParameter("metasmallversion")
						                              ,req.getParameter("hosteiid"),req.getParameter("hostversion"),req.getParameter("hostsmallversion"));
			}else if(ajaxType_SOCStorage_Disk.equals(prmType)){ //emc��ά�洢����
				getSOCStorage_DiskForSOCStorage(req,out,req.getParameter("eiid"),req.getParameter("version"),req.getParameter("smallversion"));
            }else if(ajaxType_SelectUserItem.equals(prmType)){ //emc��ά�洢����
            	selectUserItem(req,out,req.getParameter("urids"),req.getParameter("clicktype"));
            }else if(ajaxType_searchButtonList.equals(prmType)){
				searchButtonList(req, out, req.getParameter("psdid"));
            }else if(ajaxType_SOCEMC.equals(prmType)){ //���� add from soc4.3========================
				getRequestModeForSOCEMC(req,out,req.getParameter("requestMode"));
			}else if(ajaxType_SOCEMC_A.equals(prmType)){ 
				getRequestModeForSOCEMCA(req,out,req.getParameter("requestMode"));
			}else if(ajaxType_KPI.equals(prmType)){//��ȡKPI
				getKPI(req,out,req.getParameter("mtId"));
			}else if(ajaxType_EVENT.equals(prmType)){//��ȡKPI
				getEventInfo(req,out,req.getParameter("id"));
			}else if(ajaxType_DMXRealTime.equals(prmType)){//��ȡʵʱ���ܼ��DMXRealTime����
				getRequestModeForDMXRealTime(req,res,out,req.getParameter("requestMode"));
			}else if(ajaxType_KPIVAL.equals(prmType)){//��ȡKPI
				getMonitorMsg(req,out,req.getParameter("cid"),req.getParameter("mtSsn"));
			}else if(ajaxType_setMtPstoptime.equals(prmType)){//�����ӳ�ʱ��
				getSetMtPstoptime(req,out,req.getParameter("MtId"));
			}else if(ajaxType_getPieSingle.equals(prmType)){//20120716 add
				getPieSingle(req,out);
			}else if(ajaxType_showHostList.equals(prmType)){
				showHostList(req,out);
			}else if(ajaxType_showHostVG.equals(prmType)){
				showHostVG(req,out);
			}else if(ajaxType_showHostLUNID.equals(prmType)){
				showHostLUNID(req,out);
			}else if(ajaxType_showVGTS.equals(prmType)){
				showVGTS(req,out);
			}else if(ajaxType_showVGFS.equals(prmType)){
				showVGFS(req,out);
			}else if(ajaxType_showLVWarning.equals(prmType)){
				showLVWarning(req,out);
			}else if(ajaxType_showVIOLUNID.equals(prmType)){
				showVIOLUNID(req,out);
			}else if(ajaxType_SES.equals(prmType)){
				updateStorageEventStatus(req,out,req.getParameter("id"));
			}else if(ajaxType_generateCustomDoc.equals(prmType)){
				generateCustomDoc(req,out);
			}else if(ajaxType_getTemDateType.equals(prmType)){
				ajaxType_getTemDateType(req,out);
			}else if(ajaxType_delMyChoiceRCL.equals(prmType)){
				delMyChoiceRCL(req,out);
			}else if(ajaxType_addReportCustomLink.equals(prmType)){
				addReportCustomLink(req,out);
			}else if(ajaxType_SHOWDATAIO.equals(prmType)){
				getShowDataIO(req,out,req.getParameter("eirootmark"));
			}else if(ajaxType_SHOWSTORAGEIO.equals(prmType)){
				getShowStorageIO(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYFS.equals(prmType)){
				changeColorByFs(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYLV.equals(prmType)){
				changeColorByLv(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYVG.equals(prmType)){
				changeColorByVg(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYPV.equals(prmType)){
				changeColorByPv(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYPORT.equals(prmType)){
				changeColorByPort(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYZONGING.equals(prmType)){
				changeColorByZonging(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYFAPORT.equals(prmType)){
				changeColorByFaPort(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYFA.equals(prmType)){
				changeColorByFa(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYMETA.equals(prmType)){
				changeColorByMeta(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYHYPER.equals(prmType)){
				changeColorByHyper(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYDA.equals(prmType)){
				changeColorByDa(req,out,req.getParameter("eiid"));
			}else if(ajaxType_CHANGECOLORBYDISK.equals(prmType)){
			    changeColorByDisk(req,out,req.getParameter("eiid"));
			}else if(ajaxType_ISREPEATIP.equals(prmType)){
			    isRepeatIP(req,out,req.getParameter("ip"));
			}else if (ajaxType_CHECKIO.equals(prmType)) {
					checkIo(req, out);
			}else if(ajaxType_createImageXml.equals(prmType)){//�鿴Ӱ��
				createImageXml(req, out);
			}else if(ajaxType_getServerList.equals(prmType)){
				getServerList(req,out);//ҵ����Դ��ػ�ȡ�����ڵ�
			}else if(ajaxType_getDataByServicetypename.equals(prmType)){
				getDataByServicetypename(req,out);//����serviceTypename��ȡָ��ֵ
			}else if(ajaxType_getDataByService.equals(prmType)){
				getDataByService(req,out);//����service��ȡ����
			}else if(ajaxType_getPlatformAvailData.equals(prmType)){
				getPlatformAvailData(req,out);//��ȡƽ̨��Ч����
			}else if(ajaxType_getServerOrServiceAvail.equals(prmType)){
				getServerOrServiceAvail(req,out);//��ȡƽ̨�µ�server��ȡsevice�Ƿ���Ч
			}else if(ajaxType_LCZT.equals(prmType)){
				searchPrStatusByPdid(req,out,req.getParameter("pdid"));
			}else if(ajaxType_LCBD.equals(prmType)){
				searchPrInfoByPdid(req,out,req.getParameter("pdid"));
			}else if(ajaxType_LCBDT.equals(prmType)){
				searchPrInfoByPdid_T(req,out,req.getParameter("pdid"));
			}else if(ajaxType_setLoginTime.equals(prmType)){
			    setLoginTime(req,out,req.getParameter("flag"));
			}else if(ajaxType_getMeasurememtCurve.equals(prmType)){//ָ�����߻�ȡ����
				getMeasurememtCurve(req,out);
			}else if(ajaxType_getSystemDataRefresh.equals(prmType)){//�����Ϣɾ����ˢ��
                getSystemDataRefresh(req,out,req.getParameter("sysid"));
			}else if(ajaxType_remainHyperByAjax.equals(prmType)){
				remainHyperByAjax(req,out);
			}else if(ajaxType_bussSearchByAjax.equals(prmType)){
				bussSearchByAjax(req,out);	
			}else if(ajaxType_hostHbaSearchByAjax.equals(prmType)){
				hostHbaSearchByAjax(req,out);	
			}else if(ajaxType_switchPortSearchByAjax.equals(prmType)){
				switchPortSearchByAjax(req,out);
			}else if(ajaxType_faPortSearchByAjax.equals(prmType)){
				faPortSearchByAjax(req,out);
			}else if(ajaxType_hyperPortSearchByAjax.equals(prmType)){
				hyperPortSearchByAjax(req,out);
			}else if(ajaxType_searchRelationByAjax.equals(prmType)){
				searchRelationByAjax(req,out);
			}else if(ajaxType_SOCPerformance_V2.equals(prmType)){ //emc��ά�洢����
				getBusyForSOCPerformance_V2(req,out,req.getParameter("dataid"),req.getParameter("date_from"),req.getParameter("date_to"),req.getParameter("flag"));
			}else if(ajaxType_checkEntityID.equals(prmType)){
				checkEntityID(req,out,req.getParameter("eid"));
			}else if(ajaxType_checkCID.equals(prmType)){
				checkCID(req,out,req.getParameter("cid"));
			}else if(ajaxType_getContainTreeNode.equals(prmType)){ //��������ȡ���
				getContainTreeNode(req,out);
			}else if(ajaxType_getBusinessTreeNode.equals(prmType)){ //�������ˣ���ϵ����ȡ���
				getBusinessTreeNode(req,out);
			}else if(ajaxType_searchig380.equals(prmType)) {// 
                searchig380(req, out);
            }else if(ajaxType_searchCategorysByType.equals(prmType)){
				searchCategorysByType(req,out,req.getParameter("typeid"));
			}else if(ajaxType_getCIInfoVM.equals(prmType)){
				getCIInfoVM(req,out);
			}else if(ajaxType_getAlarmByID.equals(prmType)){
				getAlarmByID(req,out,req.getParameter("alarmid"));
			}else if(ajaxType_getTrendByID.equals(prmType)){
				getTrendByID(req,out);
			}else if(ajaxType_SearchCompareSourchHostList.equals(prmType)){
				searchCompareSourchHostList(req,out);
			}else if(ajaxType_getRiskCheckName.equals(prmType)) {// 
				getRiskCheckName(req, out, req.getParameter("rcrid"));
			}else if(ajaxType_getCheckResultUsername.equals(prmType)){
				getCheckResultUsername(req, out, req.getParameter("rcrid"));
			}else if(ajaxType_getAreaOptionname.equals(prmType)){
				getAreaOptionname(req, out);
			}else if(ajaxType_saveBack.equals(prmType)){
				saveBack(req,out);
			}else if(ajaxType_getPpsubstatus.equals(prmType)){
				getPpsubstatus(req, out);
			}else if(ajaxType_confirmPpsubstatus.equals(prmType)){
				confirmPpsubstatus(req, out);
			}else if(ajaxType_upgrade.equals(prmType)){
				upgrade(req, out);
			}else {
				out.print("");
			}
		} catch (Exception e) {
			out.print("");
			log.error("AjaxAction Exception", e);
		}finally{
			if(out != null)
				out.close();
		}

		return null;
	}
	
	

	private void getFindData(HttpServletRequest req, PrintWriter out) {
		// TODO Auto-generated method stub
		String flag = req.getParameter("flag");
		if(flag!=null && flag.equals("1")){			
			String rcclass = req.getParameter("rcclass");
			String rcrplandate_from = req.getParameter("rcrplandate_from");
			String rcrplandate_to = req.getParameter("rcrplandate_to");
			String rcusername = req.getParameter("rcusername");
			req.getSession().setAttribute("rcclass", rcclass);
			req.getSession().setAttribute("rcrplandate_from", rcrplandate_from);
			req.getSession().setAttribute("rcrplandate_to", rcrplandate_to);
			req.getSession().setAttribute("rcusername", rcusername);
		}
		else if(flag.equals("0")){	
			String rcclass = (String) req.getSession().getAttribute("rcclass");
			String rcrplandate_from = (String) req.getSession().getAttribute("rcrplandate_from");
			String rcrplandate_to = (String) req.getSession().getAttribute("rcrplandate_to");
			String rcusername = (String) req.getSession().getAttribute("rcusername");
			
			req.getSession().removeAttribute("rcclass");
			req.getSession().removeAttribute("rcrplandate_from");
			req.getSession().removeAttribute("rcrplandate_to");
			req.getSession().removeAttribute("rcusername");
			if(rcclass!=null || rcrplandate_from!=null || rcrplandate_to!=null || rcusername!=null){
				out.print(rcclass + "#" +rcrplandate_from+ "#" +rcrplandate_to+ "#" +rcusername);
			}
		}
	}

	/**
	 * ��ȡ�澯�籩��¼
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void getStormRecord(HttpServletRequest req, PrintWriter out) throws Exception {
		Mss00014BL mss00014BL = (Mss00014BL) getBean("mss00014BL");
		List<Mss00014Info> records = mss00014BL.searchMss00014();
		if(records == null || records.size() == 0){
			out.print("none");
		}else{
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < records.size(); i++){
				Mss00014Info record = records.get(i);
				builder.append(record.getAlarmip()+"#"+record.getHappentime()+"#"+record.getCount());
				if(i < records.size()-1) builder.append("&");
			}
			out.print(builder.toString());
		}
	}
	/**
	 * ��ȡ���չ������Ա
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void getUserRisk(HttpServletRequest req, PrintWriter out) throws Exception {
		//��ȡ�û���ɫ��ȨBL
		UserRoleBL userRoleBL = (UserRoleBL) getBean("userRoleBL");
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		//��װ��ѯ��ɫ��Χ�ļ���
		List<Integer> roleid_in = new ArrayList<Integer>();
		Integer[] riskManagerPerson = IGFXK03BLType.RISK_MANAGER_PERSON;
		for (int i = 0; i < riskManagerPerson.length; i++) {
			roleid_in.add(riskManagerPerson[i]);//���չ����
		}
		
		cond.setRoleid_in(roleid_in);
		List<UserRoleInfo> lst_UserRoleVW = userRoleBL.searchUserRoleVW(cond);
		
		//������ѯ����������Ա
		StringBuffer out_user = new StringBuffer();
		if(lst_UserRoleVW != null &&lst_UserRoleVW.size() > 0){
			for (UserRoleInfo userRoleInfo : lst_UserRoleVW) {
				out_user.append("#").append(userRoleInfo.getUserid())
					.append("_user_").append(userRoleInfo.getUsername())
					.append("_user_").append(userRoleInfo.getRoleid());
			}
			out.print(out_user.toString());
		}else{
			out.print("");
		}
		
	}
	
	/**
	 * ��ȡ���չ�����������Ϣ
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void getUserManager(HttpServletRequest req, PrintWriter out, Integer prid) throws Exception {
		//�ж�����ID�Ƿ����
		if(prid != null){
			//��ȡ���ʽ����ѯBL
			IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
			IG898SearchCondImpl cond = new IG898SearchCondImpl();
			cond.setPrid(prid);
			//��ѯ����������Ϣ
			cond.setPidname("�����б�");
			List<IG898Info> lst_ig898_job = ig898BL.searchIG898(cond);
			
			//������ѯ�������и�������Ϣ
			StringBuffer out_user = new StringBuffer();
			if(lst_ig898_job != null && lst_ig898_job.size() > 0){
				//����������Ϣ��װ����ҳ����
				for (IG898Info ig898Info : lst_ig898_job) {
					if("������".equals(ig898Info.getPvcolname())){
						out_user.append("#").append(ig898Info.getPvrownumber()).append("_manager_").append(ig898Info.getPvalue());
					}
				}
				out.print(out_user);
			}else{
				out.print("");
			}
		}else{
			out.print("");
		}
	}

	/**
	 * ���澯�����Ƿ��豸ʹ��
	 * 
	 * @param req
	 * @param out
	 * @param ruletempid
	 * @throws Exception
	 */
	private void checkExist(HttpServletRequest req, PrintWriter out,
			String ruletempid) throws Exception {
		Mss00002BL mss00002BL = (Mss00002BL) getBean("mss00002BL");
		Mss00002SearchCondImpl searchCond = new Mss00002SearchCondImpl();
		searchCond.setRuletempid(Integer.valueOf(ruletempid));
		List<Mss00002Info> minfoList = mss00002BL.searchMss00002(searchCond);
		if (minfoList != null && minfoList.size() != 0)
			out.print("yes");
		else
			out.print("no");
	}

	/**
	 * ��ѯҪ��ӵ��豸IP�Ƿ��Ѿ�����
	 * 
	 * @param req
	 * @param out
	 * @param deviceip
	 * @throws Exception
	 */
	private void checkIP(HttpServletRequest req, PrintWriter out,
			String deviceip) throws Exception {
		boolean isNewIP = true;
		Mss00001BL mss00001BL = (Mss00001BL) getBean("mss00001BL");
		Mss00001SearchCondImpl cond = new Mss00001SearchCondImpl();
		cond.setDeviceip(deviceip);
		List<Mss00001Info> devices = mss00001BL.searchMss00001(cond);
		if (devices != null && devices.size() != 0)
			isNewIP = false;
		// ����IP��Ҫ���
		cond.setDeviceip(null);
		cond.setDeviceip2(deviceip);
		List<Mss00001Info> devices1 = mss00001BL.searchMss00001(cond);
		if (devices.size() != 0 || devices1.size() != 0)
			isNewIP = false;

		if (isNewIP) {
			out.print("no");
		} else {
			if (devices.size() != 0)
				out.print(devices.get(0).getDevicename());
			else if (devices1.size() != 0)
				out.print(devices1.get(0).getDevicename());
		}
	}

	/**
	 * �����豸��ѯ���еĹ����б�
	 * 
	 * @param req
	 * @param out
	 * @param deviceid
	 * @throws Exception
	 * @author ��ʡ
	 */
	private void searchTempsByDevice(HttpServletRequest req, PrintWriter out,
			String deviceid, String typeid, String pagedeviceid)
			throws Exception {
		Mss00002BL mss00002BL = (Mss00002BL) getBean("mss00002BL");
		Mss00004BL mss00004BL = (Mss00004BL) getBean("mss00004BL");
		List<Mss00004Info> ruleTemps = new ArrayList<Mss00004Info>();
		Mss00002SearchCondImpl ms00002cond = new Mss00002SearchCondImpl();
		ms00002cond.setDeviceid(deviceid);
		List<Mss00002Info> relations = mss00002BL.searchMss00002(ms00002cond);
		for (Mss00002Info info : relations) {
			Integer tempid = info.getRuletempid();
			// ͨ���豸���ҹ���
			Mss00004Info ruletemp = mss00004BL.searchMss00004ByPK(tempid);
			if (ruletemp.getTempstate() == 1)
				ruleTemps.add(ruletemp);
		}
		StringBuilder builder = new StringBuilder();
		// ����豸Ϊ�գ�����Ҹ��豸�������й���
		if (StringUtils.isEmpty(deviceid)) {
			Mss00004SearchCondImpl tempCond = new Mss00004SearchCondImpl();
			tempCond.setTypeid(typeid);
			tempCond.setTempstates(1);
			ruleTemps = mss00004BL.searchMss00004(tempCond);
		}

		// ��ǰҳ���޸ĵ��豸ID�������ĵĹ����б����Ҳ���еĹ����б�
		List<Mss00004Info> ruleTempsFromPageDevice = new ArrayList<Mss00004Info>();
		if (StringUtils.isNotEmpty(pagedeviceid)) {
			ms00002cond = new Mss00002SearchCondImpl();
			ms00002cond.setDeviceid(pagedeviceid);
			List<Mss00002Info> pagerelations = mss00002BL
					.searchMss00002(ms00002cond);
			for (Mss00002Info info : pagerelations) {
				Integer tempid = info.getRuletempid();
				Mss00004Info ruletemp = mss00004BL.searchMss00004ByPK(tempid);
				ruleTempsFromPageDevice.add(ruletemp);
			}
		}
		index: for (int i = 0; i < ruleTemps.size(); i++) {
			Mss00004Info info = ruleTemps.get(i);
			for (int j = 0; j < ruleTempsFromPageDevice.size(); j++) {
				if (info.getRuletempid().intValue() == ruleTempsFromPageDevice
						.get(j).getRuletempid().intValue())
					continue index;
			}
			builder.append(info.getRuletempid() + "&" + info.getRuletempname()
					+ ",");
		}
		out.flush();
		out.print(builder);
	}

	/**
	 * �����豸���Ͳ�ѯ�������豸�б�͹����б�
	 * 
	 * @param req
	 * @param out
	 * @param typeid
	 * @throws Exception
	 * @author ��ʡ
	 */
	private void searchDevicesAndTemps(HttpServletRequest req, PrintWriter out,
			String typeid, String deviceid) throws Exception {

		Mss00001BL mss00001BL = (Mss00001BL) getBean("mss00001BL");
		Mss00002BL mss00002BL = (Mss00002BL) getBean("mss00002BL");
		Mss00004BL mss00004BL = (Mss00004BL) getBean("mss00004BL");
		Mss00001SearchCondImpl cond = new Mss00001SearchCondImpl();
		cond.setTypeid(typeid);
		List<Mss00001Info> devices = mss00001BL.searchMss00001(cond);
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(typeid) && devices.size() != 0) {// �������ID�ǿյĻ���ʲô������ʾ
			for (int i = 0; i < devices.size(); i++) {
				Mss00001Info info = devices.get(i);
				if (!String.valueOf(info.getDeviceid()).equals(deviceid))// �豸�����б��в���ʾ��ǰ�豸
					builder.append(info.getDeviceid() + "&"
							+ info.getDevicename() + "&" + info.getDeviceip()
							+ ",");
			}
		}
		builder.append("@@@");
		List<Mss00004Info> ruleTempsFromDevice = new ArrayList<Mss00004Info>();
		if (StringUtils.isNotEmpty(deviceid)) {
			Mss00002SearchCondImpl ms00002cond = new Mss00002SearchCondImpl();
			ms00002cond.setDeviceid(deviceid);
			List<Mss00002Info> relations = mss00002BL
					.searchMss00002(ms00002cond);
			for (Mss00002Info info : relations) {
				Integer tempid = info.getRuletempid();
				Mss00004Info ruletemp = mss00004BL.searchMss00004ByPK(tempid);
				ruleTempsFromDevice.add(ruletemp);
			}
		}

		Mss00004SearchCondImpl tempCond = new Mss00004SearchCondImpl();
		tempCond.setTypeid(typeid);
		tempCond.setTempstates(1);
		List<Mss00004Info> buff = mss00004BL.searchMss00004(tempCond);
		List<Mss00004Info> ruleTemps = new ArrayList<Mss00004Info>();

		// ��������б��е�ĳ�������Ѿ������ڸ��豸�У�������ʾ�������͹����б��У������ظ�
		index: for (int i = 0; i < buff.size(); i++) {
			Mss00004Info info = buff.get(i);
			for (int j = 0; j < ruleTempsFromDevice.size(); j++) {
				if (info.getRuletempid().equals(
						ruleTempsFromDevice.get(j).getRuletempid()))
					continue index;
			}
			ruleTemps.add(info);
		}

		if (StringUtils.isNotEmpty(typeid) && ruleTemps.size() != 0) {
			for (int i = 0; i < ruleTemps.size(); i++) {
				Mss00004Info temp = ruleTemps.get(i);
				builder.append(temp.getRuletempid() + "&"
						+ temp.getRuletempname() + ",");
			}
		}
		out.flush();
		out.print(builder);
	}

	/**
	 * ҳ���Զ�ˢ���豸��־
	 * 
	 * @param req
	 * @param out
	 * @author ��ʡ
	 */
	private void searchsyslogList(HttpServletRequest req,
			 PrintWriter out ,String checkedStr)
			throws Exception {
		
		List<IGLOG0003VO> list_vo = new ArrayList<IGLOG0003VO>();
		
		String[] checkedIds = new String[0];
		if(StringUtils.isNotEmpty(checkedStr)){
			checkedIds = checkedStr.split("_");
		}
		
		Mss00008BL mss00008BL = (Mss00008BL)getBean("mss00008BL");
		String maxcount = ResourceUtility.getString("SYSLOG_NUM");
		if(StringUtils.isEmpty(maxcount)) maxcount = "500";
		int maxCnt = Integer.parseInt(maxcount);
		Mss00008SearchCondImpl cond = new Mss00008SearchCondImpl();
		List<Mss00008Info> sysLogAlarmList = mss00008BL.searchMss00008(cond,0,maxCnt);
		
		IG599BL ig599BL = (IG599BL)getBean("ig599BL");
		IG599SearchCondImpl cond1 = new IG599SearchCondImpl();
		cond1.setPivarname("�豸�澯id");
		List<IG599Info> list_ig599 = ig599BL.searchIG599InfosByCond(cond1);
		if(sysLogAlarmList!=null && sysLogAlarmList.size() != 0){
			for( Mss00008Info info:sysLogAlarmList){
				IGLOG0003VO vo = new IGLOG0003VO();
				vo.setId(info.getID());
				vo.setAlarmmsg(info.getAlarmmsg());
				vo.setCreatetime(info.getCreatetime());
				vo.setDevceid(info.getDeviceid());
				vo.setDeviceip(info.getDeviceip());
				vo.setDevicename(vo.getDevicename());
				vo.setIsalarm(info.getIsalarm());
				vo.setRulelevel(info.getRulelevel());
		        for(IG599Info ig599:list_ig599){
		        	if(String.valueOf(info.getID()).equals(ig599.getPivarvalue())){		        				        		
		        		vo.setPrid(ig599.getPrid());
		        		break;
		        	}
		        }
		        if(vo.getPrid()==null){
		        	vo.setPrid(0);
		        }
		        list_vo.add(vo);
			}
		}
		
		Map<String,String> levelmap = new HashMap<String,String>();
		CodeDetailBL bl = (CodeDetailBL) getBean("codeDetailBL");
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
		List<CodeDetail> cds = bl.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		for(CodeDetail cd:cds){
			levelmap.put(cd.getCid(), cd.getCvalue());
		}
		
		StringBuilder builder = new StringBuilder();
		//����#ID#
		for(int i=0;i<list_vo.size();i++){
			
			IGLOG0003VO info = list_vo.get(i);
			StringBuilder buff = new StringBuilder();
			buff.append(info.getRulelevel()).append("#_#");//����
			buff.append(info.getId()).append("#_#");//ID
			String buf="";
			for(int j=0; j < checkedIds.length; j++){
				if(StringUtils.isEmpty(checkedIds[j])) continue;
				if(checkedIds[j].equals(String.valueOf(info.getId()))){
					buf = "checked";
					break;
				}
			}
			buff.append(buf).append("#_#");//��ѡ��
			buff.append(info.getPrid()).append("#_#");//����ID�������ж��߼���
			buff.append(levelmap.get(info.getRulelevel())).append("#_#");//����Ӣ�ı�ʶ
			buff.append((info.getCreatetime()==null?"":info.getCreatetime()).trim()).append("#_#");//����ʱ��
			buff.append((info.getDeviceip()==null?"":info.getDeviceip()).trim()).append("#_#");//IP
			buff.append((info.getAlarmmsg()==null?"":info.getAlarmmsg()).trim()).append("#_#");//�澯��Ϣ
			buff.append(info.getIsalarm());
			builder.append(buff.toString()).append("@_@");
		}
		
		if(StringUtils.isNotEmpty(builder.toString())){
			out.print(builder.substring(0, builder.length()-3).toString());
		}else out.print("");
		//FileUtils.writeStringToFile(new File("C:\\"+System.currentTimeMillis()+".html"), (builder.substring(0, builder.length()-3)+"</root>").toString(), "utf-8");
	}
	
	/**
	 * ��ѯ�豸��־�澯����
	 * 
	 * @param req
	 * @param out
	 * @author ��ʡ
	 * @throws Exception 
	 */
	private void getAlarmTotalCount(HttpServletRequest req, PrintWriter out) throws Exception {
		Mss00008BL mss00008BL = (Mss00008BL) getBean("mss00008BL");
		Mss00008SearchCondImpl cond = new Mss00008SearchCondImpl();
		cond.setIsalarm("1");
		int count = mss00008BL.getSearchCount(cond);
		out.print(count);
	}

	/**
	 * ���ݸ澯ID��ѯHQ�澯
	 * @param req
	 * @param out
	 * @param parameter
	 */
	private void getAlarmByID(HttpServletRequest req, PrintWriter out,
			String alarmid) {
	}
	
	/**
	 * ���ݸ澯ID��ѯSyslog�澯
	 * @param req
	 * @param out
	 * @param parameter
	 */
	private void getSyslogAlarmByID(HttpServletRequest req, PrintWriter out,
			String alarmid) {
		Mss00008DAO dao = (Mss00008DAO) getBean("mss00008DAO");
		if(StringUtils.isEmpty(alarmid)) return;
		Mss00008Info alarm = dao.findByPK(Integer.parseInt(alarmid));
		if(alarm == null) return;
		StringBuilder builder = new StringBuilder();
		
	   CodeDetailBL bl = (CodeDetailBL) getBean("codeDetailBL");
	   CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
	   condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
	   List<CodeDetail> cds = bl.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
	   Map<String,String> levelMap = new HashMap<String,String>();
	   for(CodeDetail cd:cds){
		   levelMap.put(cd.getCid(), cd.getCvalue());
	   }
		   
		builder.append(alarm.getRulelevel()==null?"��":levelMap.get(alarm.getRulelevel().trim())).append("#")
		.append(alarm.getCreatetime()==null?"��":alarm.getCreatetime()).append("#")
		.append(alarm.getDeviceip()==null?"��":alarm.getDeviceip()).append("#")
		.append(alarm.getDevicename()==null?"��":alarm.getDevicename()).append("#")
		.append(alarm.getAlarmmsg()==null?"��":alarm.getAlarmmsg()).append("#");
		out.print(builder.toString());
	}

	/**
     * ��ȡ������������pdid
     * @param req 
     * @param out PrintWriter
     * @param eiid
     */
    protected void searchig380(HttpServletRequest req, PrintWriter out) throws BLException {
        String pdid = req.getParameter("pdid");
        if(StringUtils.isEmpty(pdid)){
            out.print(StringUtils.EMPTY);
            return;
        }
        StringBuffer bf=new StringBuffer();
        IG380BL ig380BL=(IG380BL)getBean("ig380BL");
        IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
        condImpl.setPdid_like(pdid);
        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
        List<IG380Info> ig380infoList = ig380BL.searchIG380Info(condImpl);
        //��ѯ�����̶����µ���������״̬
        IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
        if(ig380infoList.size()>0){
            ig333Cond.setPdid(ig380infoList.get(0).getPdid());  
        }
        IG333BL ig333BL=(IG333BL)getBean("ig333BL");
        List<IG333Info> ig333Infos = ig333BL.searchIG333Info(ig333Cond);
            if (ig333Infos.size() > 0) {
               for(IG333Info info: ig333Infos ){
                   bf.append("#"+info.getPsdcode()+"&"+info.getPsdname());
               }
            }
            out.print(bf.toString().substring(1));
        
    }
	private void searchCategorysByType(HttpServletRequest req, PrintWriter out,
			String typeid) {
	   CodeDetailBL bl = (CodeDetailBL) getBean("codeDetailBL");
	   CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
	   condimpl.setCcid(CodeDefine.PERF_MONITOR_CATEGORY.getCcid());
	   condimpl.setPcid(typeid);
	   List<CodeDetail> cd = bl.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
	   StringBuilder sb = new StringBuilder();
	   for(CodeDetail bean:cd){
		   sb.append(bean.getCcid()+"#").append(bean.getCid()+"_").
		   	append(bean.getCvalue()).append(",");
	   } 
	   out.print(sb.toString());
	}

	private void checkCID(HttpServletRequest req, PrintWriter out,String cid) {
		SOC0109BL bl = (SOC0109BL) getBean("soc0109BL");
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setCid(cid);
		List<SOC0109Info> list = bl.searchConfiguration(cond);
		if(list != null && list.size() != 0){
			out.print("yes");
		}
	}

	/**
	 * ���Ҫ¼����ʲ�ģ��ID�Ƿ����
	 * @param req
	 * @param out
	 * @param eid
	 * @throws BLException
	 */
	private void checkEntityID(HttpServletRequest req, PrintWriter out,String eid) throws BLException{
		SOC0117BL bl = (SOC0117BL) getBean("soc0117BL");
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEidStr(eid);
		List<SOC0117Info> list = bl.searchEntity(cond);
		if(list != null && list.size() != 0){
			out.print("yes");
		}
	}

	/**
     * ҵ��ϵͳ��������ɾ����ˢ��
     * @param req
     * @param out
     * @param parameter
     * @param parameter2
     */
    private void getSystemDataRefresh(HttpServletRequest req, PrintWriter out,String sysid) throws BLException{
    }
    
    

    /**
     * @param req
     * @param out
     */
    private void setLoginTime(HttpServletRequest req, PrintWriter out,String flag)throws BLException {
        CodeDetailBL bl = (CodeDetailBL) getBean("codeDetailBL");
        CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.LOGIN_TIME_FLAG.getCcid());
        List<CodeDetail> cd = bl.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        for (int i = 0; i < cd.size(); i++) {
            if(!"1".equals(flag)){//ҳ������ִ�ж�ʱ���񣬸���ʱ��
                if("1".equals(cd.get(i).getCid())){//���ʱ���
                    CodeDetailTB cdTB = (CodeDetailTB) SerializationUtils.clone(cd.get(i));
                    cdTB.setCvalue(IGStringUtils.getCurrentDateTime());
                    bl.updateCodeDetail(cdTB);
                }
            }else{//���ڹر��¼�����ʶ����Ϊfalse
                if("2".equals(cd.get(i).getCid())){
                    CodeDetailTB cdTB = (CodeDetailTB) SerializationUtils.clone(cd.get(i));
                    cdTB.setCvalue("false");
                    bl.updateCodeDetail(cdTB);
                }
            }
        }
        out.print("1");
    }

    /**
	 * �����ʲ�����������ȡ����ȡֵ��Χ�������б��ϣ�igasm1001.jspʹ�ã�
	 * @param req 
	 * @param out PrintWriter
	 * @param coption
	 * @author   
	 */
	protected void getCcdvalueByCoption(HttpServletRequest req, PrintWriter out, String coption) throws BLException{

		//
		IGASM10BL bl = (IGASM10BL) getBean("igasm10BL");
		
		//List<LabelValueBean> newlist = new ArrayList<LabelValueBean>();
		//newlist.add(new LabelValueBean("", ""));
		List<LabelValueBean> list = bl.searchCcdvalueByCoption(coption);
		StringBuffer ret = new StringBuffer();
		for(LabelValueBean lvb:list){
			if(!"".equals(lvb.getValue())){
				ret.append(";");
				ret.append(lvb.getValue()+"_"+lvb.getLabel());
			}
			
			
		}
//		for(int i=0,j=list.size();i<j;i++){
//			newlist.add(list.get(i));
//		}
		
		//req.setAttribute("cvalueList", newlist);
		out.print(ret.toString());
	}
	
	/**
	 * �ʲ�������ȡ��
	 * @param req 
	 * @param out PrintWriter
	 * @param elabel
	 */
	protected void assistEname(HttpServletRequest req, PrintWriter out, String elabel){

		//
		IG117BL bl = (IG117BL) getBean("ig117BL");
		
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		
		cond.setElabel(elabel);
		
		List<IG117Info> entityList = bl.searchIG117Info(cond, 0, 0);
		
		String ret = "";
		
		if ( entityList != null && entityList.size() > 0){
			ret = entityList.get(0).getEname();
		}
		log.debug("�ʲ����ͣ�" + elabel + " >> �ʲ���������" + ret);

		out.print(ret);
	}

	/**
	 * ���ݷ�����ȡ��
	 * @param req 
	 * @param out PrintWriter
	 * @param elabel
	 */
	protected void assistCcname(HttpServletRequest req, PrintWriter out, String ccid){

		//
		CodeCategoryBL bl = (CodeCategoryBL) getBean("codeCategoryBL");
		
		CodeCategoryInfo info = bl.searchCodeCategoryByPK(ccid);
		
		String ret = "";
		
		if ( info != null){
			ret = info.getCcname();
		}
		log.debug("���ݷ��ࣺ" + ccid + " >> ���ݷ�������" + ret);

		out.print(ret);
	}

	/**
	 * ������ȡ��
	 * @param req 
	 * @param out PrintWriter
	 * @param elabel
	 */
	protected void assistCvalue(HttpServletRequest req, PrintWriter out, String ccid, String cid){

		//
		CodeDetailBL bl = (CodeDetailBL) getBean("codeDetailBL");
		
		CodeDetailTBPK pk = new CodeDetailTBPK();
		
		pk.setCcid(ccid);
		pk.setCid(cid);
		
		CodeDetail info = bl.searchCodeDetailByPK(pk);
		
		String ret = "";
		
		if ( info != null){
			ret = info.getCvalue();
		}
		log.debug("���ݷ��ࣺ" + ccid + ",����:" + cid + " >> ���ݷ�������" + ret);

		out.print(ret);
	}
	
	/**
	 * �ʲ����ȡ��
	 * @param req 
	 * @param out PrintWriter
	 * @param ecategorykey
	 * @update 0000331
	 * @update 2014/05/05 ��Ҫ��ԭIG013���SOC0118
	 * (1)��ѯ�ʲ���������ʲ������һ�����Ե��µ����ȡ�ʲ���ų��ִ���
	 */
	protected void searchMaxEntityItemLable(HttpServletRequest req, PrintWriter out, String ecategorykey) throws BLException {
		
		// ԭ�ʲ���
//		IG013BL bl = (IG013BL) getBean("ig013BL");
//		IG013SearchCondImpl cond = new IG013SearchCondImpl();
		// ���ʲ���
		SOC0118BL bl = (SOC0118BL) getBean("soc0118BL");
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		// ����cond��������
		cond.setEilabel(ecategorykey + IGStringUtils.getCurrentYear().substring(2));
		// ԭ��ȡ�ʲ�����ŷ���
//		String ret = bl.searchNextIG013InfoLable(cond);
		// �ֻ�ȡ�ʲ�����ŷ���
		String ret = bl.searchNextEntityItemLable(cond);
		
		if(StringUtils.isEmpty(ret)) {
			ret = "";
		}
		
		log.debug("�ʲ����ࣺ" + ecategorykey + ",��ǰ���ñ��:" + ret);
//		System.out.println("�ʲ����ࣺ" + ecategorykey + ",��ǰ���ñ��:" + ret);
		
		out.print(ret);
	}
	
	/**
	 * ��ǰ������ʱ��ȡ��
	 * @param req 
	 * @param out PrintWriter
	 */
	protected void searchServerTime(HttpServletRequest req, PrintWriter out) throws BLException {
		
		String ret = IGStringUtils.getCurrentDateTime();
		
		log.debug("��ǰ������ʱ�䣺" + ret);

		out.print(ret);
	}
	
	
	/**
	 * ��ȡѡȡ��Ʒ��������Ϣ
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	protected void searchOldStock(HttpServletRequest req, PrintWriter out, String seqcode, String category) throws BLException {
		
		ITEMS01BL bl = (ITEMS01BL)getBean("items01BL");
		InStockSearchCondImpl cond = new InStockSearchCondImpl();
		cond.setCategory(category);
		cond.setSeqcode(seqcode);
		cond.setInstockorg(DefineUtils.DEFAULT_ORGNO);
		cond.setInstock_sort(DefineUtils.INSTOCK_SORT_BYINTIME_DESC);
		String ret = bl.searchOldStockAction(cond);
		
		if(StringUtils.isEmpty(ret)) {
			ret = "";
		}
		
		out.print(ret);
	}
	
	/**
	 * ��ȡѡȡ��Ʒ�������µ���Ʒ����¼
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	protected void searchGoodsCode(HttpServletRequest req, PrintWriter out, String gcategory) throws BLException {
		
		IGLOM02BL bl = (IGLOM02BL)getBean("iglom02BL");
		String ret = bl.searchGoodsCodeAction(gcategory);
		
		if(StringUtils.isEmpty(ret)) {
			ret = "";
		}
		
		out.print(ret);
	}
	
	
	/**
	 * IGCOM0306�����¼�ʲ�ѡ�д���
	 * @param req 
	 * @param out PrintWriter
	 * @param eiid
	 */
	@SuppressWarnings("unchecked")
	protected void selectEntityItem(HttpServletRequest req, PrintWriter out, String eiid, String clicktype) throws BLException {
		
		//�ʲ�ID����
		Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
		
		if(set == null) {
			set = new LinkedHashSet<String>();
			req.getSession().setAttribute("ADSelectEntity",set);
		}
		
		if(clicktype != null && "del".equals(clicktype)) {//���ѡ�� 
			set.remove(eiid);
			log.debug("�ʲ�ID��" + eiid + "�����");
		} else if(clicktype != null && "add".equals(clicktype)){//ѡ��
			set.add(eiid);
			log.debug("�ʲ�ID��" + eiid + "��ѡ��");
		} else {
			log.error("��Ч����");
		}
		req.getSession().setAttribute("ADSelectEntity",set);
		out.print("1");
	}
	
	/**
	 * IGCOM0306�����¼�ʲ�ѡ��ȷ��
	 * @param req 
	 * @param out PrintWriter
	 * @param eiid
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void confirmEntityItem(HttpServletRequest req, PrintWriter out) {
		
		//IG013BL bl = (IG013BL) getBean("ig013BL");
		SOC0118BL bl = (SOC0118BL) getBean("soc0118BL");
		
		Set<String> selectSet = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
		
		Set<String> selectedSet = (Set<String>)req.getSession().getAttribute("ADSelectedEntity");
		
		if(selectSet != null) {
			
			//����һ�����ϣ�ȷ��ѡ���൱��׷���ʲ�
			if(selectedSet == null) {
				selectedSet = new LinkedHashSet<String>(selectSet);
				req.getSession().setAttribute("ADSelectedEntity", selectedSet);
			} else {
				selectedSet.addAll(selectSet);
			}
			
			StringBuffer sbf = new StringBuffer();
			
			int i = 0;
			if(selectedSet.size() > 0) {
				//IG688SearchCondImpl cond = new IG688SearchCondImpl();
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				cond.setEiidList(new ArrayList(selectedSet));
				List<SOC0124Info> eiList = bl.searchEntityItemVW(cond);
				for(SOC0124Info ei : eiList) {
					//ƴ������
					sbf.append(ei.getEid()).append("###").append(ei.getEiid());
					sbf.append("###").append(ei.getEiname()).append("###").append(ei.getEcategory()).append("###").append(ei.getEilabel());
					if((++i) != eiList.size()) {
						sbf.append("###");
					}
					log.debug("�ʲ�ID��" + ei.getEiid() + "��ʾ��");
				}
				out.print(sbf.toString());
			} else {
				log.error("û��ѡ���ʲ���");
			}
		} else {
			log.error("û��ѡ���ʲ���");
		}
		
	}
	
	/**
	 * IGCOM0311�豸Ԥ����
	 * @param req 
	 * @param out PrintWriter
	 * @param eiid
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void confirmEntityItemfull(HttpServletRequest req, PrintWriter out) {
		
		IG013BL bl = (IG013BL) getBean("ig013BL");
		
		Set<String> selectSet = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
		
		Set<String> selectedSet = (Set<String>)req.getSession().getAttribute("ADSelectedEntity");
		
		if(selectSet != null) {
			
			//����һ�����ϣ�ȷ��ѡ���൱��׷���ʲ�
			if(selectedSet == null) {
				selectedSet = new LinkedHashSet<String>(selectSet);
				req.getSession().setAttribute("ADSelectedEntity", selectedSet);
			} else {
				selectedSet.addAll(selectSet);
			}
			
			StringBuffer sbf = new StringBuffer();
			
			int i = 0;
			if(selectedSet.size() > 0) {
				IG688SearchCondImpl cond = new IG688SearchCondImpl();
				cond.setEiidList(new ArrayList(selectedSet));
				List<IG688Info> eiList = bl.searchIG688Info(cond);
				for(IG688Info ei : eiList) {
					//ƴ������
					sbf.append(ei.getEid()).append("###").append(ei.getEiid());
					sbf.append("###").append(ei.getEiname()).append("###").append(ei.getEcategory()).append("###").append(ei.getEilabel());
					if((++i) != eiList.size()) {
						sbf.append("###");
					}
					log.debug("�ʲ�ID��" + ei.getEiid() + "��ʾ��");
				}
				out.print(sbf.toString());
			} else {
				log.error("û��ѡ���ʲ���");
			}
		} else {
			log.error("û��ѡ���ʲ���");
		}
		
	}
	
	/**
	 * IGCOM0306�����¼�ʲ�ɾ��
	 * @param req 
	 * @param out PrintWriter
	 * @param eiid
	 */
	@SuppressWarnings("unchecked")
	protected void removeSlectedEntityItem(HttpServletRequest req, PrintWriter out, String eiid) throws BLException {
		
		//�ʲ�ID����
		Set<String> selectedEntity = (Set<String>)req.getSession().getAttribute("ADSelectedEntity");
		
		Set<String> selectEntity = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
		
		if(selectEntity != null) {
			if(StringUtils.isNotEmpty(eiid)) {
				selectEntity.remove(eiid);
				log.debug("�ʲ�ID��" + eiid + "��ɾ��");
			} else {
				log.error("��Ч����");
			}
		} else {
			log.error("��Ч����");
		}
		if(selectedEntity != null) {
			if(StringUtils.isNotEmpty(eiid)) {
				selectedEntity.remove(eiid);
				log.debug("�ʲ�ID��" + eiid + "��ɾ��");
			} else {
				log.error("��Ч����");
			}
		} else {
			log.error("��Ч����");
		}
		out.print("1");
	}
	
	/**
	 * IGCOM0306�����¼��ȡѡ�����
	 * @param req 
	 * @param out PrintWriter
	 */
	@SuppressWarnings("unchecked")
	protected void getSlectedEntityItemNum(HttpServletRequest req, PrintWriter out) throws BLException {
		
		//�ʲ�ID����
		Set<String> selectEntity = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
		
		if(selectEntity != null) {
			out.print(selectEntity.size());
			log.debug(selectEntity.size());
		} else {
			log.error("��Ч����");
			out.print("0");
		}
		req.getSession().setAttribute("ADSelectEntity",selectEntity);
	}
	
	/**
	 * 
	 * @param req 
	 * @param out PrintWriter
	 */
	protected void searchprocessJC(HttpServletRequest req, PrintWriter out, String prid) throws BLException {
		
		WorkFlowOperationBL bl = (WorkFlowOperationBL) getBean("workFlowOperationBL");
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(Integer.parseInt(prid));
		String temp;
		List<String> codelist = new ArrayList<String>();
		List<IG337Info> list = bl.searchProcessParticipants(cond);
		for(IG337Info role:list){
			boolean flag = true;
			
			for(String code:codelist){
				if(StringUtils.isNotEmpty(role.getPprolename())){
					temp=role.getPprolename();
					if(temp.equals(code)){
						flag = false;
						break;
					}
				}else{
					break;
				}
				
			}
			if(flag){
				if(!"null".equals(String.valueOf(role.getPprolename()))){
					codelist.add(role.getPprolename());
				}
				
			}
		}
		StringBuffer bf = new StringBuffer("");
		for(int i=0; i<codelist.size(); i++){
			if(i==(codelist.size()-1)){
				bf.append(codelist.get(i));
			}else{
				bf.append(codelist.get(i)+",");
			}
		}
		out.print(bf.toString());
	}
	
	/**
	 * 
	 * @param req 
	 * @param out PrintWriter
	 */
	protected void searchprocessOP(HttpServletRequest req, PrintWriter out, String prid) throws BLException {
		
		WorkFlowOperationBL bl = (WorkFlowOperationBL) getBean("workFlowOperationBL");
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(Integer.parseInt(prid));
		String temp;
		List<String> codelist = new ArrayList<String>();
		List<IG337Info> list = bl.searchProcessParticipants(cond);
		for(IG337Info user:list){
			boolean flag = true;
			
			for(String code:codelist){
				if(StringUtils.isNotEmpty(user.getPpusername())){
					temp=user.getPpusername();
					if(temp.equals(code)){
						flag = false;
						break;
					}
				}else{
					break;
				}
				
			}
			if(flag){
				if(!"null".equals(String.valueOf(user.getPpusername()))){
					codelist.add(user.getPpusername());
				}
				
			}
		}
		StringBuffer bf = new StringBuffer("");
		for(int i=0; i<codelist.size(); i++){
			if(i==(codelist.size()-1)){
				bf.append(codelist.get(i));
			}else{
				bf.append(codelist.get(i)+",");
			}
		}
		out.print(bf.toString());
	}

	/**
	 * ��������״̬
	 * @param req 
	 * @param out PrintWriter
	 * @param pdid 
	 * @param property select�����˵�name��
	 * @param ccid ����״̬��Ӧ��������
	 */
	protected void searchprocessStatus(HttpServletRequest req, PrintWriter out, String pdid, String property, String ccid,String propertyValue) throws BLException {
		
		StringBuffer bf = new StringBuffer("");
		bf.append("<SELECT name=\""+property+"\" style=\"width: 80px;\" >");
		bf.append("<option></option>");
		
		//���pdidΪ��,��Ϊ��ѯҳ��������������ѡ���˿�
		if(StringUtils.isEmpty(pdid)){
			bf.append("</SELECT>");
			out.print(bf.toString());
			return;
		}
		
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		IGPRD01DTO dto = new IGPRD01DTO();
		IGPRD0104Form form = new IGPRD0104Form();
		
		form.setPdid(pdid);
		dto.setIgPRD0104Form(form);
		//��ѯ�Զ�������״̬
		dto = ctlBL.searchProcessStatusDefAction(dto);


		List<IG333Info> list = dto.getProcessStatusDefList();
		int i = 0;
		
		if(!list.isEmpty()){
			//���Զ�������,��ѡ�Զ���ڵ�״̬
			for(IG333Info psd: list){
				psd = (IG333Info) SerializationUtils.clone(list.get(i++));
				if(StringUtils.isEmpty(propertyValue)){
					bf.append("<option value=\""+psd.getPsdcode()+"\">"+psd.getPsdname()+"</option>");
				}else{
					if(propertyValue.equals(psd.getPsdcode())){
						bf.append("<option value=\""+psd.getPsdcode()+"\" selected=\"selected\" >"+psd.getPsdname()+"</option>");
					}else{
						bf.append("<option value=\""+psd.getPsdcode()+"\">"+psd.getPsdname()+"</option>");
					}
				}
				
			}
			
		}else{
			//��������,��ѯ����������״̬
			CodeDetailBL codeDetailBL = (CodeDetailBL)getBean("codeDetailBL");
			CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
			cond.setCcid(ccid);
			List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cond,0);
			
			for(CodeDetail cd : codeDetailList){
				cd = (CodeDetail) SerializationUtils.clone(codeDetailList.get(i++));
				if(StringUtils.isEmpty(propertyValue)){
					bf.append("<option value=\""+cd.getCid()+"\">"+cd.getCvalue()+"</option>");
				}else{
					if(propertyValue.equals(cd.getCid())){
						bf.append("<option value=\""+cd.getCid()+"\" selected=\"selected\" >"+cd.getCvalue()+"</option>");
					}else{
						bf.append("<option value=\""+cd.getCid()+"\">"+cd.getCvalue()+"</option>");
					}
				}
				
			}
		}
		bf.append("</SELECT>");
		out.print(bf.toString());
	}
	
	/**
	 * ɾ������
	 * @param req 
	 * @param out PrintWriter
	 * @param attid
	 */
	protected void deleteAttid(HttpServletRequest req, PrintWriter out, String attId) throws BLException {
		
		AttachmentBL bl = (AttachmentBL) getBean("attachmentBL");
		Attachment attachment = bl.searchAttachmentByKey(Integer.parseInt(attId));
		bl.deleteAttachment(attachment);
		out.print(attId);
	}
	
	
/**
 * ���ܣ�ȡ���г���ҳҳ������
 * @param req
 * @param out
 * @param requestMode 
 * @throws Exception 
 */	
protected void getRequestModeForBankMaster(HttpServletRequest req, PrintWriter out,String requestMode) throws BLException {
		
		IGDBM01BL ctlBL = (IGDBM01BL) getBean("igDBM01BL");
		IGDBM01DTO dto = new IGDBM01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if ("PLine".equals(requestMode)) {
			String resxml = ctlBL.getPLine(dto).getResultXML();
			out.print(resxml);
		}
		
		if ("pillar2".equals(requestMode)) {
			String currentWorks = ctlBL.getCurrentWorkPiller(dto).getCurrentWork();
			out.print(currentWorks);
		}
		
		if ("calendar".equals(requestMode)) {
			
			String thedate = req.getParameter("thedate");
			String year = thedate.substring(0,thedate.indexOf("��"));
			String month = thedate.substring(thedate.indexOf("��")+1,thedate.indexOf("��"));
			dto.setYear(Integer.valueOf(year));
			dto.setMonth(Integer.valueOf(month));
			String resxml = ctlBL.setCalendar(dto).getResultXML();
			out.print(resxml);
		}
		
		if("map".equals(requestMode)){
			String mapname = req.getParameter("mapname");
			dto.setMapname(mapname);
			String var = ctlBL.getMap(dto).getMaps();
			out.print(var);
		}
		
		if("Study".equals(requestMode)){
			
			int var = ctlBL.getStudy(dto).getMeter();
			out.print(var);
		}
		
		if("monitor".equals(requestMode)){
			String monitor = ctlBL.getMonitor(dto).getMonitor();
			out.print(monitor);
		}
		
		
		if("failstat".equals(requestMode)){
			//���ɱ��¸��¼����Ͳ�ͬ����������xml
			dto = ctlBL.setAllTypeEventCount(dto);
			out.print(dto.getResultXML());
		}
		
		
	}
	/**
	 * ���ܣ�ȡ�ô�����ҳ����
	 * @param req
	 * @param out
	 * @param flash 
	 * @throws Exception 
	 */

    protected void getRequestModeForDepartmentMaster(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {

		IGDBM02BL ctlBL = (IGDBM02BL) getBean("igDBM02BL");
		IGDBM02DTO dto = new IGDBM02DTO();
		
		if ("PLine".equals(requestMode)) {
			String resxml = ctlBL.getPLine(dto).getResultXML();
			out.print(resxml);
		}
		
		if("Study".equals(requestMode)){
			
			int var = ctlBL.getStudy(dto).getMeter();
			out.print(var);
		}
		
		if("monitor".equals(requestMode)){
			String monitor = ctlBL.getMonitor(dto).getMonitor();
			out.print(monitor);
		}

		if ("processCount".equals(requestMode)) {

			dto = ctlBL.getProcessCount(dto);
			out.print(dto.getProcessCount());
		}
		
		
		if ("changeplan".equals(requestMode)) {
			dto.setValueOfDate(req.getParameter("date"));
			dto = ctlBL.setChangePlan(dto);
			out.print(dto.getChangePlanCalender());
			
		}


	}
    
    /**
	 * ���ܣ�ȡ������������ҳ����
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */

    protected void getRequestModeForProcessTopics(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {

		IGDBM03BL ctlBL = (IGDBM03BL) getBean("igDBM03BL");
		IGDBM03DTO dto = new IGDBM03DTO();

		if("failstat".equals(requestMode)){
			//���ɱ��¸��¼����Ͳ�ͬ����������xml
			dto = ctlBL.setAllTypeEventCount(dto);
			out.print(dto.getResultXML());
		}
		
		if ("processCount".equals(requestMode)) {

			dto = ctlBL.getProcessCount(dto);
			out.print(dto.getProcessCount());
		}
		
		if ("changeplan".equals(requestMode)) {
			dto.setValueOfDate(req.getParameter("date"));
			dto = ctlBL.setChangePlan(dto);
			out.print(dto.getChangePlanCalender());
			
		}
		
	}
    
    /**
	 * ���ܣ�ȡ�û�����ʩ��ҳ����
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */

    protected void getRequestModeForBasicEquipment(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {

		IGDBM04BL ctlBL = (IGDBM04BL) getBean("igDBM04BL");
		IGDBM04DTO dto = new IGDBM04DTO();

		if ("equipment".equals(requestMode)) {
			String resxml = ctlBL.setEquipment(dto).getResultXML();
			out.print(resxml);
		}
		if ("systempiller".equals(requestMode)) {
			dto.setSystemPillarType(String.valueOf(req.getParameter("SystemPillarType")));
			String resxml = ctlBL.getSystemPiller(dto).getResultXML();
			out.print(resxml);
		}
		if ("LineForHourKernel".equals(requestMode)) {
			String resxml = ctlBL.setKernelUseAvg(dto).getResultXML();
			out.print(resxml);
		}
		if ("LineForHourPrefix".equals(requestMode)) {
			String resxml = ctlBL.setPrefixUseAvg(dto).getResultXML();
			out.print(resxml);
		}
		if ("LineForHourMiddleOperation".equals(requestMode)) {
			String resxml = ctlBL.setMiddleOperationUseAvg(dto).getResultXML();
			out.print(resxml);
		}
		if ("LineForHourNetbank".equals(requestMode)) {
			String resxml = ctlBL.setNetbankUseAvg(dto).getResultXML();
			out.print(resxml);
		}
		if ("SomeThingsQuestions".equals(requestMode)) {
			//����¼��������������
			dto = ctlBL.getSomeThingsQuestions(dto);
			out.print(dto.getSomethings()+"|"+dto.getSomequestion());
		}
	}
    
    /**
	 * ���ܣ�ȡ�������ۺϷ���ҳ������
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */
    protected void getRequestModeForProcessProblem(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {
		IGDBM05BL ct5BL = (IGDBM05BL) getBean("igDBM05BL");
    	if("allMode".equals(requestMode)){  //ȡ�������ۺϷ���ҳ����������ֵ
    		String typeValue = req.getParameter("typeValue"); //��ѯ����
    		String yearValue = req.getParameter("yearValue"); //��ѯʱ��
    		String pn1Value = req.getParameter("pn1Value"); //������ռ�ȵ�������ֵ(��ѯ�·�)
    		String pn2Value = req.getParameter("pn2Value"); //ƽ�����ʱ�䵼������ֵ(��������)
    		String pn3Value = req.getParameter("pn3Value"); //�������Ƶ�������ֵ(��������)
    		String pn4Value = req.getParameter("pn4Value"); //��ʱ����ʵ�������ֵ(��������)
    		IGDBM05DTO dto = new IGDBM05DTO();
    		dto.setPn1Value(pn1Value);
    		dto.setPn2Value(pn2Value);
    		dto.setPn3Value(pn3Value);
    		dto.setPn4Value(pn4Value);
    		dto.setTypeValue(typeValue);
    		dto.setYearValue(yearValue);
    		ct5BL.getProcessProblemAllMode(dto); //ȡ�������ۺϷ���ҳ������
    		String outStr = dto.getPieValue()+"#"+dto.getProblemLineForAvg()+
    						"#"+dto.getProblemLineForCount()+"#"+dto.getProblemLineForSolve();
    		out.print(outStr);
    	}else if("navigateValue".equals(requestMode)){//���ݵ��������ͼ���ֵȡ����Ӧ����
    		String typeValue = req.getParameter("typeValue"); //��ѯ����
    		String yearValue = req.getParameter("yearValue"); //��ѯʱ��
    		String navigateValue = req.getParameter("navigateValue"); //������ֵ
    		String navigateType = req.getParameter("navigateType"); //���������� pn1 ~ pn4
    		if("pn1".equals(navigateType)){
    			
    			//ȡ������������������ռ��ֵ
    			IGDBM05DTO dto = new IGDBM05DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn1Value(navigateValue);
        		dto = ct5BL.getPieValue(dto);
        		out.print(dto.getPieValue());
        		return;
    		}
    		if("pn2".equals(navigateType)){
    			//����ƽ�����ʱ��
    			IGDBM05DTO dto = new IGDBM05DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn2Value(navigateValue);
        		dto = ct5BL.getProcessProblemLineForAvg(dto);
        		out.print(dto.getProblemLineForAvg());
        		return;
    		}
    		if("pn3".equals(navigateType)){
    			//��������
    			IGDBM05DTO dto = new IGDBM05DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn3Value(navigateValue);
        		dto = ct5BL.getProcessProblemLineForCount(dto);
        		out.print(dto.getProblemLineForCount());
        		return;
    		}
    		if("pn4".equals(navigateType)){
    			//���⼰ʱ�����
    			IGDBM05DTO dto = new IGDBM05DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn4Value(navigateValue);
        		dto = ct5BL.getProcessProblemLineForSolve(dto);
        		out.print(dto.getProblemLineForSolve());
        		return;
    		}
    	}
    	
    }
    
    /**
	 * ���ܣ�ȡ���¼��ۺϷ���ҳ������
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */
    protected void getRequestModeForProcessIncident(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {
		IGDBM06BL ct6BL = (IGDBM06BL) getBean("igDBM06BL");
    	if("allMode".equals(requestMode)){  //ȡ�������ۺϷ���ҳ����������ֵ
    		String typeValue = req.getParameter("typeValue"); //��ѯ����
    		String yearValue = req.getParameter("yearValue"); //��ѯʱ��
    		String pn1Value = req.getParameter("pn1Value"); //������ռ�ȵ�������ֵ(��ѯ�·�)
    		String pn2Value = req.getParameter("pn2Value"); //ƽ�����ʱ�䵼������ֵ(��������)
    		String pn3Value = req.getParameter("pn3Value"); //�������Ƶ�������ֵ(��������)
    		String pn4Value = req.getParameter("pn4Value"); //��ʱ����ʵ�������ֵ(��������)
    		IGDBM06DTO dto = new IGDBM06DTO();
    		dto.setPn1Value(pn1Value);
    		dto.setPn2Value(pn2Value);
    		dto.setPn3Value(pn3Value);
    		dto.setPn4Value(pn4Value);
    		dto.setTypeValue(typeValue);
    		dto.setYearValue(yearValue);
    		ct6BL.getProcessIncidentAllMode(dto); //ȡ�������ۺϷ���ҳ������
    		String outStr = dto.getPieValue()+"#"+dto.getIncidentLineForAvg()+
    						"#"+dto.getIncidentLineForCount()+"#"+dto.getIncidentLineForSolve();
    		out.print(outStr);
    	}else if("navigateValue".equals(requestMode)){//���ݵ��������ͼ���ֵȡ����Ӧ����
    		String typeValue = req.getParameter("typeValue"); //��ѯ����
    		String yearValue = req.getParameter("yearValue"); //��ѯʱ��
    		String navigateValue = req.getParameter("navigateValue"); //������ֵ
    		String navigateType = req.getParameter("navigateType"); //���������� pn1 ~ pn4
    		if("pn1".equals(navigateType)){
    			
    			//ȡ�����¼�����������ռ��ֵ
    			IGDBM06DTO dto = new IGDBM06DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn1Value(navigateValue);
        		dto = ct6BL.getPieValue(dto);
        		out.print(dto.getPieValue());
        		return;
    		}
    		if("pn2".equals(navigateType)){
    			//�¼�ƽ�����ʱ��
    			IGDBM06DTO dto = new IGDBM06DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn2Value(navigateValue);
        		dto = ct6BL.getProcessIncidentLineForAvg(dto);
        		out.print(dto.getIncidentLineForAvg());
        		return;
    		}
    		if("pn3".equals(navigateType)){
    			//��������
    			IGDBM06DTO dto = new IGDBM06DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn3Value(navigateValue);
        		dto = ct6BL.getProcessIncidentLineForCount(dto);
        		out.print(dto.getIncidentLineForCount());
        		return;
    		}
    		if("pn4".equals(navigateType)){
    			//�¼���ʱ�����
    			IGDBM06DTO dto = new IGDBM06DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn4Value(navigateValue);
        		dto = ct6BL.getProcessIncidentLineForSolve(dto);
        		out.print(dto.getIncidentLineForSolve());
        		return;
    		}
    	}
    	
    }
    
    /**
	 * ���ܣ�ȡ�ñ���ۺϷ���ҳ������
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */
    protected void getRequestModeForProcessChange(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {
		IGDBM07BL ct7BL = (IGDBM07BL) getBean("igDBM07BL");
    	if("allMode".equals(requestMode)){  //ȡ�ñ���ۺϷ���ҳ����������ֵ
    		String typeValue = req.getParameter("typeValue"); //��ѯ����
    		String yearValue = req.getParameter("yearValue"); //��ѯʱ��
    		String pn1Value = req.getParameter("pn1Value"); //������ռ�ȵ�������ֵ(��ѯ�·�)
    		String pn2Value = req.getParameter("pn2Value"); //ƽ�����ʱ�䵼������ֵ(�������)
    		String pn3Value = req.getParameter("pn3Value"); //�������Ƶ�������ֵ(�������)
    		String pn4Value = req.getParameter("pn4Value"); //��ʱ����ʵ�������ֵ(�������)
    		IGDBM07DTO dto = new IGDBM07DTO();
    		dto.setPn1Value(pn1Value);
    		dto.setPn2Value(pn2Value);
    		dto.setPn3Value(pn3Value);
    		dto.setPn4Value(pn4Value);
    		dto.setTypeValue(typeValue);
    		dto.setYearValue(yearValue);
    		ct7BL.getProcessChangeAllMode(dto); //ȡ�ñ���ۺϷ���ҳ������
    		String outStr = dto.getPieValue()+"#"+dto.getChangeLineForAvg()+
    						"#"+dto.getChangeLineForCount()+"#"+dto.getChangeLineForSolve();
    		out.print(outStr);
    	}else if("navigateValue".equals(requestMode)){//���ݵ��������ͼ���ֵȡ����Ӧ����
    		String typeValue = req.getParameter("typeValue"); //��ѯ����
    		String yearValue = req.getParameter("yearValue"); //��ѯʱ��
    		String navigateValue = req.getParameter("navigateValue"); //������ֵ
    		String navigateType = req.getParameter("navigateType"); //���������� pn1 ~ pn4
    		if("pn1".equals(navigateType)){
    			
    			//ȡ���±������������ռ��ֵ
    			IGDBM07DTO dto = new IGDBM07DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn1Value(navigateValue);
        		dto = ct7BL.getPieValue(dto);
        		out.print(dto.getPieValue());
        		return;
    		}
    		if("pn2".equals(navigateType)){
    			//���ƽ�����ʱ��
    			IGDBM07DTO dto = new IGDBM07DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn2Value(navigateValue);
        		dto = ct7BL.getProcessChangeLineForAvg(dto);
        		out.print(dto.getChangeLineForAvg());
        		return;
    		}
    		if("pn3".equals(navigateType)){
    			//��������
    			IGDBM07DTO dto = new IGDBM07DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn3Value(navigateValue);
        		dto = ct7BL.getProcessChangeLineForCount(dto);
        		out.print(dto.getChangeLineForCount());
        		return;
    		}
    		if("pn4".equals(navigateType)){
    			//�����ʱ�����
    			IGDBM07DTO dto = new IGDBM07DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn4Value(navigateValue);
        		dto = ct7BL.getProcessChangeLineForSolve(dto);
        		out.print(dto.getChangeLineForSolve());
        		return;
    		}
    	}
    	
    }
    
    /**
	 * ���ܣ�ȡ�ù����ۺϷ���ҳ������
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */
    protected void getRequestModeForProcessWork(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {
		IGDBM08BL ct8BL = (IGDBM08BL) getBean("igDBM08BL");
    	if("allMode".equals(requestMode)){  //ȡ�ù����ۺϷ���ҳ����������ֵ
    		String typeValue = req.getParameter("typeValue"); //��ѯ����
    		String yearValue = req.getParameter("yearValue"); //��ѯʱ��
    		String pn1Value = req.getParameter("pn1Value"); //������ռ�ȵ�������ֵ(��ѯ�·�)
    		String pn2Value = req.getParameter("pn2Value"); //ƽ�����ʱ�䵼������ֵ(��������)
    		String pn3Value = req.getParameter("pn3Value"); //�������Ƶ�������ֵ(��������)
    		String pn4Value = req.getParameter("pn4Value"); //��ʱ����ʵ�������ֵ(��������)
    		IGDBM08DTO dto = new IGDBM08DTO();
    		dto.setPn1Value(pn1Value);
    		dto.setPn2Value(pn2Value);
    		dto.setPn3Value(pn3Value);
    		dto.setPn4Value(pn4Value);
    		dto.setTypeValue(typeValue);
    		dto.setYearValue(yearValue);
    		ct8BL.getProcessWorkAllMode(dto); //ȡ�ù����ۺϷ���ҳ������
    		String outStr = dto.getPieValue()+"#"+dto.getWorkLineForAvg()+
    						"#"+dto.getWorkLineForCount()+"#"+dto.getWorkLineForSolve();
    		out.print(outStr);
    	}else if("navigateValue".equals(requestMode)){//���ݵ��������ͼ���ֵȡ����Ӧ����
    		String typeValue = req.getParameter("typeValue"); //��ѯ����
    		String yearValue = req.getParameter("yearValue"); //��ѯʱ��
    		String navigateValue = req.getParameter("navigateValue"); //������ֵ
    		String navigateType = req.getParameter("navigateType"); //���������� pn1 ~ pn4
    		if("pn1".equals(navigateType)){
    			
    			//ȡ���¹�������������ռ��ֵ
    			IGDBM08DTO dto = new IGDBM08DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn1Value(navigateValue);
        		dto = ct8BL.getPieValue(dto);
        		out.print(dto.getPieValue());
        		return;
    		}
    		if("pn2".equals(navigateType)){
    			//����ƽ�����ʱ��
    			IGDBM08DTO dto = new IGDBM08DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn2Value(navigateValue);
        		dto = ct8BL.getProcessWorkLineForAvg(dto);
        		out.print(dto.getWorkLineForAvg());
        		return;
    		}
    		if("pn3".equals(navigateType)){
    			//��������
    			IGDBM08DTO dto = new IGDBM08DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn3Value(navigateValue);
        		dto = ct8BL.getProcessWorkLineForCount(dto);
        		out.print(dto.getWorkLineForCount());
        		return;
    		}
    		if("pn4".equals(navigateType)){
    			//������ʱ�����
    			IGDBM08DTO dto = new IGDBM08DTO();
        		dto.setTypeValue(typeValue);
        		dto.setYearValue(yearValue);
        		dto.setPn4Value(navigateValue);
        		dto = ct8BL.getProcessWorkLineForSolve(dto);
        		out.print(dto.getWorkLineForSolve());
        		return;
    		}
    	}
    	
    }
    
    /**
	 * ���ܣ�ȡ��ϵͳ�����ʷ�������
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */

    protected void getRequestModeForSystemUse(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {

		IGDBM09BL ctlBL = (IGDBM09BL) getBean("igDBM09BL");
		IGDBM09DTO dto = new IGDBM09DTO();
		
		if ("selectValue".equals(requestMode)) {
			dto.setSelectSystemId(req.getParameter("systemid"));
			String resxml = "";
			resxml = resxml+ctlBL.getCurrentActualAvailability(dto).getCurrentActualAvailability()+"#";
			resxml = resxml+ctlBL.getYearActualAvailability(dto).getYearActualAvailability()+"#";
			resxml = resxml+ctlBL.getAvailabilityYearTrends(dto).getAvailabilityYearTrends();
			out.print(resxml);
		}
	}
    
    /**
     * ���ܣ�zjg����DashBoard �澯��Ϣ��ѯ
     * @param req
     * @param out
     * @throws Exception 
     */
    protected void getDSWarningInfo(HttpServletRequest req,PrintWriter out)throws BLException{
    }
    /**
     * ���ܣ�zjg����DashBoard �澯��Ϣ��ͼ��ѯ
     * @param req
     * @param out
     * @throws Exception 
     */
    protected void getDSWarningPie(HttpServletRequest req,PrintWriter out)throws BLException{
    }
    /**
     * ���ܣ�zjg����DashBoard ƽ̨Count
     * @param req
     * @param out
     * @throws Exception 
     */
    protected void getDSPlatformCount(HttpServletRequest req,PrintWriter out)throws BLException{
    }
    /**
     * ���ܣ�zjg����DashBoard ƽָ̨��Count
     * @param req
     * @param out
     * @throws Exception 
     */
    protected void getDSPlatformMeasurementCount(HttpServletRequest req,PrintWriter out)throws BLException{
    }
    /**
     * ���ܣ�HangZhangPieAll
     * @param req
     * @param out
     * @throws Exception 
     */
    protected void getDSHangZhangPieAll(HttpServletRequest req,PrintWriter out)throws BLException{
    }
    /**
     * ���ܣ�zjg����DashBoard ƽ̨������
     * @param req
     * @param out
     * @throws Exception 
     */
    protected void getDSPlatformAvailable(HttpServletRequest req,PrintWriter out)throws BLException{
    	StringBuffer xmlStr=new StringBuffer("");
    	BussinessAvailvalVWBL bussinessAvailvalVWBL=(BussinessAvailvalVWBL)getBean("bussinessAvailvalVWBL");
    	List<BussinessAvailval> list=bussinessAvailvalVWBL.searchBussinessAvailvalVW();
    	if(list.size()>0){
    		for (int i = 0; i < list.size(); i++) {
    			if(i%10==0 && i!=0){
    				xmlStr.append("@");
    			}
    			xmlStr.append(list.get(i).getAvailval()+":"+list.get(i).getGname()+"|");
			}
    	}
    	out.print(xmlStr);
    }

    /**
     * ���ܣ�zjg����DashBoard ƽ̨������
     * @param req
     * @param out
     * @throws Exception 
     */
    protected void getDSPlatformAvailableForWidth(HttpServletRequest req,PrintWriter out)throws BLException{
    	StringBuffer xmlStr=new StringBuffer("");
    	BussinessAvailvalVWBL bussinessAvailvalVWBL=(BussinessAvailvalVWBL)getBean("bussinessAvailvalVWBL");
    	List<BussinessAvailval> list=bussinessAvailvalVWBL.searchBussinessAvailvalVW();
    	if(list.size()>0){
    		for (int i = 0; i < list.size(); i++) {
    			if(i%22==0 && i!=0){
    				xmlStr.append("@");
    			}
    			xmlStr.append(list.get(i).getAvailval()+":"+list.get(i).getGname()+"|");
			}
    	}
    	out.print(xmlStr);
    }
    //����������ʼList<String>
	public String GetSubNet(String IP,String NetMask){
		StringBuffer netsStr=null;
		//List<String> nets=null;
		String[] ipArgs=IP.split("\\.");
		String[] nmArgs=NetMask.split("\\.");
		
		if(ipArgs!=null && nmArgs!=null){
			//nets=new ArrayList<String>();
			netsStr=new StringBuffer("");
			for (int i = 0; i < nmArgs.length; i++) {
				if(nmArgs[i].equals("255")){//ֱ��ʹ�ö�Ӧip
					netsStr.append("."+ipArgs[i]);
				}else if(nmArgs[i].equals("0")){//��Ӧip���ó�0
					netsStr.append(".0");
				}else{//��255 or 0 ��ʼ����
					int ip=Integer.parseInt(ipArgs[i]);
					int mask=Integer.parseInt(nmArgs[i]);
					String ipStr=String.format("%8s", Integer.toBinaryString(ip));
					String maskStr=String.format("%8s", Integer.toBinaryString(mask));
					StringBuffer res=new StringBuffer("");
					for (int j = 0; j < maskStr.length(); j++) {
						res.append( AND(ipStr.substring(j, j+1),maskStr.substring(j, j+1)) );
					}
					int r=Integer.parseInt(res.toString(), 2);
					netsStr.append("."+r);
				}
			}
			//nets.add(netsStr.substring(1));
		}
		//return nets;
		return netsStr.substring(1);
	}
	private String AND(String num1,String num2){
		if(num1.equals(num2)){//��ͬ
			if(num1.equals("1")){//ͬΪ1
				return "1";
			}else{//ͬΪ0
				return "0";
			}
		}else{//��ͬ
			return "0";
		}
	}
	//������������
	protected void saveTopoXML(HttpServletRequest req,PrintWriter out)throws BLException{
		//dataxml
		String xmlstr=req.getParameter("xmlstr");
		if(StringUtils.isNotEmpty(xmlstr)){
			String[] bigEL=xmlstr.split("\\|");
			TOPOXMLBL tOPOXMLBL=(TOPOXMLBL)getBean("tOPOXMLBL");
			for (int i = 0; i < bigEL.length; i++) {
				String[] smallEL=bigEL[i].split("@");//192.168.1.0@x,y
				String address=smallEL[0];//192.168.1.0
				String aixs=smallEL[1];
				TOPOXMLTB topoxml=new TOPOXMLTB();
				topoxml.setMyid(address);//primary key
				topoxml.setAixs(aixs);
				tOPOXMLBL.registTOPOXML(topoxml);
			}
			out.print("����ɹ�");
			return;
		}
		out.print("����ʧ��");
	}
    /**
	 * ���ܣ�ȡ���������ȼ�
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */
    protected void getPriority(HttpServletRequest req,PrintWriter out)throws BLException{
    	String pprtype = req.getParameter("prtype");
    	String ivalue = req.getParameter("primpactValue");
    	String uvalue = req.getParameter("prurgencyValue");
    	IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
    	IGSYM11DTO dto = new IGSYM11DTO();
    	dto.setIvalue(ivalue);
    	dto.setPprtype(pprtype);
    	dto.setUvalue(uvalue);
    	dto=ctlBL.findByPriorityCond(dto);
    	List<Priority> prioritieList = dto.getPrioritieList();
    	if(prioritieList == null || prioritieList.size()<1){
    		out.print("");
    	}
    	for(Priority priority:prioritieList){
    			out.print(priority.getPvalue());
    	}
    }
    

    
    /**
	 * ���ܣ�ȡ��ȡ������ҵ��ʵʱ���
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */

    protected void getRequestModeForChannelBusiness(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {

		IGDBM10BL ctlBL = (IGDBM10BL) getBean("igDBM10BL");
		IGDBM10DTO dto = new IGDBM10DTO();
		
		if ("SystemMap".equals(requestMode)) {
			String resxml = "";
			resxml = resxml+ctlBL.getChannelsBusinessRealtime(dto).getChannelsBusinessRealtime();
			out.print(resxml);
		}
		if ("SystemPillar".equals(requestMode)) {
			
			String resxml = "";
			resxml = resxml+ctlBL.getDB2Information(dto).getDb2Information();
			out.print(resxml);
		}
		if ("HostMode".equals(requestMode)) {
			String hostid = req.getParameter("id");
			String resxml = "";
			dto.setHostid(hostid);
			resxml = resxml+ctlBL.getBackupAndHCAMPType(dto).getBackupAndHCAMPType();
			out.print(resxml);
		}
		if ("WarningText".equals(requestMode)) {
			String resxml = "";
			resxml = resxml+ctlBL.getOmnibusEventWarning(dto).getOmnibusEventWarning();
			out.print(resxml);
		}
		if ("Pillar6Mode".equals(requestMode)) {
			String resxml = "";
			resxml = resxml+ctlBL.getCPUOccupancyrateTOP5(dto).getCpuOccupancyrateTOP5();
			out.print(resxml);
		}
	}
    
    /**
	 * ���ܣ���ά�洢����ƽ̨
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */

    protected void getAppXMLForSOCStorage(HttpServletRequest req,
			PrintWriter out, String requestMode,String requestMode1,String requestMode2) throws Exception {
    	//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");	
		SOC0121SearchCondImpl  cond = new SOC0121SearchCondImpl();
		String srdomainid_eq = (String)req.getSession().getAttribute("soc_srdomainid_eq");
		String srdomainversion_eq = (String)req.getSession().getAttribute("soc_srdomainversion_eq");
		String srcreatetime_eq = (String)req.getSession().getAttribute("soc_srcreatetime_eq");

		cond.setDeleteflag_eq("0");
		cond.setSrarithmetictype_eq("1");   //����Ϊ1 �ǹ�ϵͼ��
		cond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_200);  // 200ΪӦ�ú�������ϵ
		cond.setSrcldeiid_eq(requestMode);
		cond.setSrcldversion_eq(requestMode1);
		cond.setSrcldsmallversion_eq(requestMode2);
		cond.setSrdomainid_eq(srdomainid_eq);
		cond.setSrdomainversion_eq(srdomainversion_eq);
		cond.setSrcreatetime_eq(srcreatetime_eq);  
		String resxml = ctlBL.createAppXml(cond);
		out.print(resxml);	
	}
    
    /**
	 * ���ܣ���ά�洢����ƽ̨
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */

    protected void getMetaXMLForSOCStorage(HttpServletRequest req,
			PrintWriter out, String requestMode,String requestMode1,String requestMode2) throws Exception {
    	//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");	
		SOC0121SearchCondImpl  cond = new SOC0121SearchCondImpl();
		String srdomainid_eq = (String)req.getSession().getAttribute("soc_srdomainid_eq");
		String srdomainversion_eq = (String)req.getSession().getAttribute("soc_srdomainversion_eq");
		String srcreatetime_eq = (String)req.getSession().getAttribute("soc_srcreatetime_eq");
        String soc_storage_eq = (String)req.getSession().getAttribute("soc_storage_eq");
		cond.setDeleteflag_eq("0");
		cond.setSrarithmetictype_eq("4");   //����Ϊ4�Ǵ洢��ϵͼ��
		cond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_228);  // 228Ϊ������Meta��ϵ
		cond.setSrpareiid_eq(requestMode);
		cond.setSrparversion_eq(requestMode1);
		cond.setSrparsmallversion_eq(requestMode2);
		cond.setSrdomainid_eq(srdomainid_eq);
		cond.setSrdomainversion_eq(srdomainversion_eq);
		cond.setSrcreatetime_eq(srcreatetime_eq);  
		String resxml = ctlBL.createMetaXml(cond,soc_storage_eq);
		out.print(resxml);	
	} 
    
    /**
	 * ���ܣ���ά�洢����ƽ̨
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */
    protected void getSOCStorage_XMLForSOCStorage(HttpServletRequest req,
			PrintWriter out, String metaeiid,String metaversion,String metasmallversion,
			String hosteiid,String hostversion,String hostsmallversion) throws Exception {
    	//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");	
		
		String srdomainid_eq = (String)req.getSession().getAttribute("soc_srdomainid_eq");
		String srdomainversion_eq = (String)req.getSession().getAttribute("soc_srdomainversion_eq");
		String srcreatetime_eq = (String)req.getSession().getAttribute("soc_srcreatetime_eq");
		String storageeiid = req.getSession().getAttribute("soc_storageeiid").toString();
		String storageversion = req.getSession().getAttribute("soc_storageversion").toString();
		String storagesmallversion = req.getSession().getAttribute("soc_storagesmallversion").toString();
		String soc_storage_eq = (String)req.getSession().getAttribute("soc_storage_eq");
		
		SOC0121SearchCondImpl  meta_diskcond = new SOC0121SearchCondImpl();
		meta_diskcond.setDeleteflag_eq("0");
		meta_diskcond.setSrarithmetictype_eq("4");   //����Ϊ4�Ǵ洢��ϵͼ��
		meta_diskcond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_229);  // 229ΪMeta��Disk��ϵ
		meta_diskcond.setSrpareiid_eq(metaeiid);
		meta_diskcond.setSrparversion_eq(metaversion);
		meta_diskcond.setSrparsmallversion_eq(metasmallversion);
		meta_diskcond.setSrdomainid_eq(srdomainid_eq);
		meta_diskcond.setSrdomainversion_eq(srdomainversion_eq);
		meta_diskcond.setSrcreatetime_eq(srcreatetime_eq);  
		
		SOC0121SearchCondImpl  storage_Dacond = new SOC0121SearchCondImpl();
		storage_Dacond.setDeleteflag_eq("0");
		storage_Dacond.setSrarithmetictype_eq("1");   //����Ϊ4�Ǵ洢��ϵͼ��
		storage_Dacond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_211);  // 211ΪStorage��Da��ϵ
		storage_Dacond.setSrpareiid_eq(storageeiid);
		storage_Dacond.setSrparversion_eq(storageversion);
		storage_Dacond.setSrparsmallversion_eq(storagesmallversion);
		storage_Dacond.setSrdomainid_eq(srdomainid_eq);
		storage_Dacond.setSrdomainversion_eq(srdomainversion_eq);
		storage_Dacond.setSrcreatetime_eq(srcreatetime_eq);  
		
		SOC0121SearchCondImpl  host_facond = new SOC0121SearchCondImpl();
		host_facond.setDeleteflag_eq("0");
		host_facond.setSrarithmetictype_eq("4");   //����Ϊ4�Ǵ洢��ϵͼ��
		host_facond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_231);  // 211ΪStorage��Da��ϵ
		host_facond.setSrpareiid_eq(hosteiid);
		host_facond.setSrparversion_eq(hostversion);
		host_facond.setSrparsmallversion_eq(hostsmallversion);
		host_facond.setSrdomainid_eq(srdomainid_eq);
		host_facond.setSrdomainversion_eq(srdomainversion_eq);
		host_facond.setSrcreatetime_eq(srcreatetime_eq);  
		
		String resxml = ctlBL.createXml(meta_diskcond,storage_Dacond,host_facond,soc_storage_eq);
		out.print(resxml);	
	}
    /**
	 * ���ܣ���ά�洢����ƽ̨
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */
    protected void getSOCStorage_DiskForSOCStorage(HttpServletRequest req,
			PrintWriter out, String eiid,String version,String smallversion) throws Exception {
    	//BLȡ��
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");	
		
		String srdomainid_eq = (String)req.getSession().getAttribute("soc_srdomainid_eq");
		String srdomainversion_eq = (String)req.getSession().getAttribute("soc_srdomainversion_eq");
		String srcreatetime_eq = (String)req.getSession().getAttribute("soc_srcreatetime_eq");
		SOC0121SearchCondImpl  meta_diskcond = new SOC0121SearchCondImpl();
		meta_diskcond.setDeleteflag_eq("0");
		meta_diskcond.setSrarithmetictype_eq("4");   //����Ϊ4�Ǵ洢��ϵͼ��
		meta_diskcond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_229);  // 229ΪMeta��Disk��ϵ
		meta_diskcond.setSrcldeiid_eq(eiid);
		meta_diskcond.setSrcldversion_eq(version);
		meta_diskcond.setSrcldsmallversion_eq(smallversion);
		meta_diskcond.setSrdomainid_eq(srdomainid_eq);
		meta_diskcond.setSrdomainversion_eq(srdomainversion_eq);
		meta_diskcond.setSrcreatetime_eq(srcreatetime_eq);  
		
		SOC0121SearchCondImpl  host_diskcond = new SOC0121SearchCondImpl();
		host_diskcond.setDeleteflag_eq("0");
		host_diskcond.setSrarithmetictype_eq("1");   //����Ϊ4�Ǵ洢��ϵͼ��
		host_diskcond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_230);  // 230Ϊhost��Disk��ϵ
		host_diskcond.setSrcldeiid_eq(eiid);
		host_diskcond.setSrcldversion_eq(version);
		host_diskcond.setSrcldsmallversion_eq(smallversion);
		host_diskcond.setSrdomainid_eq(srdomainid_eq);
		host_diskcond.setSrdomainversion_eq(srdomainversion_eq);
		host_diskcond.setSrcreatetime_eq(srcreatetime_eq);  
		
		SOC0121SearchCondImpl  app_hostcond = new SOC0121SearchCondImpl();
		app_hostcond.setDeleteflag_eq("0");
		app_hostcond.setSrarithmetictype_eq("1");   //����Ϊ4�Ǵ洢��ϵͼ��
		app_hostcond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_200);  // 200ΪӦ�ú�������ϵ
		app_hostcond.setSrdomainid_eq(srdomainid_eq);
		app_hostcond.setSrdomainversion_eq(srdomainversion_eq);
		app_hostcond.setSrcreatetime_eq(srcreatetime_eq);  
		
		String resxml = ctlBL.createDiskXml(meta_diskcond,host_diskcond,app_hostcond);
		out.print(resxml);	
	}
    
    /* �������� */
    /**
	 * 
	 * ��ʼ���ذ�
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void getMap4Vec(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		//��ȡ����id
		String roomID = req.getParameter("roomID");
		
		SOC0601BL computerRoomBL = (SOC0601BL) getBean("soc0601BL");
		
		//��ȡ������Ϣ
		SOC0601Info ctbean = computerRoomBL.searchSOC0601InfoByKey(roomID);
		int x_total = Integer.parseInt(ctbean.getX_total());
		int y_total = Integer.parseInt(ctbean.getY_total());
		
		//���㶥������
		DrawFloorUtil df = new DrawFloorUtil();
		DrawResBean dr = df.getDrawResBean(x_total, y_total);
		
		StringBuffer str = new StringBuffer(ctbean.getX_total()+"#"+ctbean.getY_total()+"#");
		str.append((dr.getOx1()>0?dr.getOx1():0)+"#")
		.append((dr.getOy1()>0?dr.getOy1():0)+"#")
		.append((dr.getOx2()>0?dr.getOx2():0)+"#")
		.append((dr.getOy2()>0?dr.getOy2():0)+"#")
		.append((dr.getOx3()>0?dr.getOx3():0)+"#")
		.append((dr.getOy3()>0?dr.getOy3():0)+"#")
		.append((dr.getOx4()>0?dr.getOx4():0)+"#")
		.append((dr.getOy4()>0?dr.getOy4():0)+"#")
		//.append("assets/roomBg/"+"jifang"+roomID+".swf");
		.append("IGASM1104_Initapp.do?roomID="+roomID);
		out.print(str.toString());
	}
	
	//���ظ澯ָʾ����˸���
	private String getIndicatorLights(String eiid) throws BLException{
		return "";
	} 
    
	/**
	 * 
	 * ȡ��δ�ϼܵĻ����б�
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void getToolsData(HttpServletRequest req, PrintWriter out)
			throws BLException  {

		//�������ù���BLȡ��
		EntityItemUntreatedVWBL entityItemUntreatedVWBL = (EntityItemUntreatedVWBL) getBean("entityItemUntreatedVWBL");
		//ȡ��δ�ϼܵĻ����б�
		List<EntityItemUntreatedVWInfo> entityItemUntreatedVWList = entityItemUntreatedVWBL.getToolsData();
		//ƴװxml
		StringBuffer toolsXml =  new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		toolsXml.append("<ROOT>");
		toolsXml.append("<TOOLS>");
		String type = "t1";
		if(entityItemUntreatedVWList!=null){
			for(EntityItemUntreatedVWInfo bean:entityItemUntreatedVWList){
				if(bean.getEsyscoding().startsWith(EntityItemKeyWords.CONTAINER)&&EntityItemKeyWords.VALUE_PULLDOWN.equals(bean.getContainertype())){
					type = "shelf14";
				}else if(bean.getEsyscoding().startsWith("999001035002")){
					if(StringUtils.isNotEmpty(bean.getEitype()) && bean.getEitype().equals("��ʽ")){
						type = "a1";
					}else{
						type = "a3";
					}
				}else if(bean.getEsyscoding().startsWith("999001035001")){
					type = "UPS";
				}

				String eilabel = bean.getEilabel().startsWith("SBZC") ? bean.getEilabel().substring(4) : bean.getEilabel();
				toolsXml.append("<img x=\"0\" y=\"0\" ontools=\"y\"")
						.append(" id=\"" + bean.getEiid() + "\"  ")				//����ID
						.append(" type=\""+type+"\"  ")							//��������		
						.append(" title=\""+bean.getEiname()+"\"  ")  		//��������
						.append(" eilabel=\""+ eilabel +"\"  ")					//������
						.append(" gaodu=\""+bean.getU_total()+"(U)\" />"); 	//����߶�
			}
		}
		toolsXml.append("</TOOLS>");
		toolsXml.append("</ROOT>");
		
		out.print(toolsXml.toString());
	}
	
    /**
     * ���ܣ��������ƽ��ͼ����
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    protected void saveJiFangXML(HttpServletRequest req,PrintWriter out) throws BLException {
    	try {
			String jiguiXML = URLDecoder.decode(req.getParameter("jiguiXML"),
					"utf-8");
			String toolsXML = URLDecoder.decode(req.getParameter("toolsXML"),
					"utf-8");
			String wuxiaoXML = URLDecoder.decode(req.getParameter("wuxiaoXML"),
					"utf-8");
			String legendXML = URLDecoder.decode(req.getParameter("legendXML"),
					"utf-8");
			String roomID = req.getParameter("roomID");
			saveJiguiMsg(jiguiXML, roomID); // �������ϼܻ���
			saveToolsMsg(toolsXML); // ����δ�ϼܻ���
			saveLegendMsg(legendXML, roomID); // ����ͼ����Ϣ
			saveWuXiaoMsg(wuxiaoXML, roomID); // ������Ч��Ϣ
			out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("error");
		}
    }
    
    /**
     * ���ܣ�����ͼ����Ϣ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
	private String saveLegendMsg(String legendXML,String roomId) throws Exception{
    	CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		// ��ɾ��������
		if (StringUtils.isNotEmpty(roomId)) {
			String[] legend = { "d1", "d2", "d3", "d4", "w1", "w2", "f1", "c1",
					"c2" };
			CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
			ctcond.setCategory(roomId);
			ctcond.setLegendArray(legend);
			List<CompareTemplateInfo> ctList = compareTemplateBL
					.searchCompareTemplate(ctcond, 0, 0);
			if (ctList != null) {
				for (CompareTemplateInfo ctbean : ctList) {
					compareTemplateBL.deleteCompareTemplateByPK(ctbean
							.getCtpid());
				}
			}
		}

		CompareTemplateTB ctTB = new CompareTemplateTB();
		ctTB.setCtcategory(roomId);
		SAXBuilder builder = new SAXBuilder();
		StringReader read = new StringReader(legendXML);
		InputSource source = new InputSource(read);
		Document doc = builder.build(source);
		Element root = doc.getRootElement();
		List<Element> eList = root.getChildren();
		// ��ȡͼ��ID ���� ����
		String imgid = null;
		String imgx = null;
		String imgy = null;
		String imgtype = null;
		for (Element el : eList) {
			List<Element> subList = el.getChildren();
			if (subList != null) {
				for (Element subEL : subList) {
					imgid = subEL.getAttributeValue("id");
					imgx = subEL.getAttributeValue("x");
					imgy = subEL.getAttributeValue("y");
					imgtype = subEL.getAttributeValue("type");
					// ����
					ctTB.setCttype(imgid);
					// ���Ժ�����
					ctTB.setCtx(imgx);
					// ����������
					ctTB.setCty(imgy);
					// ��������
					ctTB.setCttype(imgtype);
					// ͼ��insert
					compareTemplateBL.registCompareTemplate(ctTB);
				}
			}
		}

		return "ok";
    }
    
    /**
     * ���ܣ����������Ч������Ϣ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    @SuppressWarnings("unchecked")
	private String saveWuXiaoMsg(String wuxiaoXML,String roomId) throws Exception{
    	CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		// ��ɾ��������
		if (StringUtils.isNotEmpty(roomId)) {
			CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
			ctcond.setCategory(roomId);
			ctcond.setType("wuxiao");
			List<CompareTemplateInfo> ctList = compareTemplateBL
					.searchCompareTemplate(ctcond, 0, 0);
			if (ctList != null) {
				for (CompareTemplateInfo ctbean : ctList) {
					compareTemplateBL.deleteCompareTemplateByPK(ctbean
							.getCtpid());
				}
			}
		}

		CompareTemplateTB ctTB = new CompareTemplateTB();
		ctTB.setCttype("wuxiao");
		ctTB.setCtcategory(roomId);
		SAXBuilder builder = new SAXBuilder();
		StringReader read = new StringReader(wuxiaoXML);
		InputSource source = new InputSource(read);
		Document doc = builder.build(source);
		Element root = doc.getRootElement();
		List<Element> eList = root.getChildren();
		String value;

		for (Element el : eList) {
			List<Element> subList = el.getChildren();
			for (Element subEL : subList) {
				value = subEL.getAttributeValue("id");
				if (value != null) {
					ctTB.setCttype(value);
					compareTemplateBL.registCompareTemplate(ctTB);
				}
			}

		}

		return "ok";
    }
    
    /**
     * ���ܣ��������ƽ��ͼ��δ�ϼܻ�����Ϣ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    @SuppressWarnings("unchecked")
	private String saveToolsMsg(String toolsXML) throws Exception{
    	SOC0603BL computerContainerBL = (SOC0603BL) getBean("soc0603BL");
		SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");
		SAXBuilder builder = new SAXBuilder();
		StringReader read = new StringReader(toolsXML);
		InputSource source = new InputSource(read);
		Document doc = builder.build(source);
		Element root = doc.getRootElement();
		List<Element> eList = root.getChildren();
		String imgId = null;
		for (Element el : eList) {
			List<Element> subList = el.getChildren();
			for (Element subEL : subList) {
				imgId = subEL.getAttributeValue("id")
						.replaceAll("jiguiImg", "");
				imgId = imgId.replaceAll("AIR", "");
				imgId = imgId.replaceAll("UPS", "");
				// ��ʾ�û�����Ϣȡ��
				SOC0603Info computerContainerVWInfo = computerContainerBL
						.searchSOC0603InfoByKey(imgId);

				if (computerContainerVWInfo == null) {
					SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
					cond.setEiid(Integer.parseInt(imgId));
					computerContainerVWInfo = computerContainerBL
							.searchUpsAndAirSOC0603Info(cond).get(0);
				}

				// ��ǰ������Ϣȡ��
				SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
				ciCond.setEiid(imgId);
				ciCond.setCiversion(String.valueOf(computerContainerVWInfo.getEiversion()));
				List<SOC0107Info> configItemList = configItemBL.searchSOC0107(
						ciCond, 0, 0);

				// ���񱣴����λ����Ϣ
				if (configItemList != null && configItemList.size() > 0) {
					for (SOC0107Info item : configItemList) {
						String clabel = item.getConfiguration().getClabel();
						SOC0107TB configItemTB = (SOC0107TB) SerializationUtils
								.clone(item);
						if (EntityItemKeyWords.CLABEL_GRAPHSTATUS
								.equals(clabel)) {
							configItemTB
									.setCivalue(EntityItemKeyWords.graphstatusN);
							configItemBL.updateSOC0107(configItemTB);
							break;
						}
					}
				}

				// ɾ��ĳ�豸�ڻ����е�λ����Ϣ

				// ��ȡCompareTemplateBL
				CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
				// ��ɾ��������
				if (StringUtils.isNotEmpty(imgId)) {
					CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
					ctcond.setCabtype("jigui" + imgId);
					List<CompareTemplateInfo> ctList = compareTemplateBL
							.searchCompareTemplate(ctcond, 0, 0);
					if (ctList != null && !ctList.isEmpty()) {
						for (CompareTemplateInfo ctbean : ctList) {
							compareTemplateBL.deleteCompareTemplateByPK(ctbean.getCtpid());
						}
					}
				}

				// ɾ����ϵ
				delComputerContainer(imgId);
			}

		}
    	return "ok";
    }
    
    /**
     * ���ܣ��������ƽ��ͼ�����ϼܻ�����Ϣ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
	private String saveJiguiMsg(String jiguiXML,String roomID) throws Exception{
		// �������
		SOC0603BL computerContainerBL = (SOC0603BL) getBean("soc0603BL");
		SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");
		SAXBuilder builder = new SAXBuilder();
		StringReader read = new StringReader(jiguiXML);
		InputSource source = new InputSource(read);
		Document doc = builder.build(source);
		Element root = doc.getRootElement();
		List<Element> eList = root.getChildren();
		String imgId = null;
		String imgX = null;
		String imgY = null;
		String imgIndex = null;
		String imgType = null;
		String floorx = null;
		String floory = null;
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		
		// ��ɾ��������
		if (StringUtils.isNotEmpty(roomID)) {
			CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
			// ctcond.setCategory(roomID);
			ctcond.setCabtype("jigui" + imgId);
			List<CompareTemplateInfo> ctList = compareTemplateBL
					.searchCompareTemplate(ctcond, 0, 0);
			if (ctList != null) {
				for (CompareTemplateInfo ctbean : ctList) {
					compareTemplateBL.deleteCompareTemplateByPK(ctbean
							.getCtpid());
				}
			}
		}
		for (Element el : eList) {
			List<Element> subList = el.getChildren();
			for (Element subEL : subList) {
				imgId = subEL.getAttributeValue("id")
						.replaceAll("jiguiImg", "");
				imgId = imgId.replaceAll("AIR", "");
				imgId = imgId.replaceAll("UPS", "");
				imgX = subEL.getAttributeValue("x");
				imgY = subEL.getAttributeValue("y");
				imgIndex = subEL.getAttributeValue("index");
				// ��������
				imgType = subEL.getAttributeValue("type");
				// �����ذ�����
				floorx = subEL.getAttributeValue("floorx");
				// �����ݵذ�����
				floory = subEL.getAttributeValue("floory");
				// ��ʾ�û�����Ϣȡ��
				SOC0603Info computerContainerVWInfo = computerContainerBL
						.searchSOC0603InfoByKey(imgId);

				if (computerContainerVWInfo == null) {
					SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
					cond.setEiid(Integer.parseInt(imgId));
					computerContainerVWInfo = computerContainerBL
							.searchUpsAndAirSOC0603Info(cond).get(0);
				}

				// ��ǰ������Ϣȡ��
				SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
				ciCond.setEiid(imgId);
				ciCond.setCiversion(String.valueOf(computerContainerVWInfo.getEiversion()));
				List<SOC0107Info> configItemList = configItemBL.searchSOC0107(
						ciCond, 0, 0);

				// �������λ����Ϣ
				if (configItemList != null && configItemList.size() > 0) {
					for (SOC0107Info item : configItemList) {
						String clabel = item.getConfiguration().getClabel();

						if (EntityItemKeyWords.CLABEL_X_VALUE.equals(clabel)) {
							if (StringUtils.isEmpty(item.getCivalue())
									|| !imgX.equals(item.getCivalue())) {
								SOC0107TB configItemTB = (SOC0107TB) SerializationUtils
										.clone(item);
								configItemTB.setCivalue(imgX);
								configItemBL.updateSOC0107(configItemTB);
							}
						} else if (EntityItemKeyWords.CLABEL_Y_VALUE
								.equals(clabel)) {
							if (StringUtils.isEmpty(item.getCivalue())
									|| !imgY.equals(item.getCivalue())) {
								SOC0107TB configItemTB = (SOC0107TB) SerializationUtils
										.clone(item);
								configItemTB.setCivalue(imgY);
								configItemBL.updateSOC0107(configItemTB);
							}
						} else if (EntityItemKeyWords.CLABEL_GRAPHSTATUS
								.equals(clabel)) {
							if (StringUtils.isEmpty(item.getCivalue())
									|| !"1".equals(item.getCivalue())) {
								SOC0107TB configItemTB = (SOC0107TB) SerializationUtils
										.clone(item);
								configItemTB
										.setCivalue(EntityItemKeyWords.graphstatusY);
								configItemBL.updateSOC0107(configItemTB);
							}
						} else if (EntityItemKeyWords.CLABEL_GRAPHINDEX
								.equals(clabel)) {
							if (StringUtils.isEmpty(item.getCivalue())
									|| !item.getCivalue().equals(imgIndex)) {
								SOC0107TB configItemTB = (SOC0107TB) SerializationUtils
										.clone(item);
								configItemTB.setCivalue(imgIndex);
								configItemBL.updateSOC0107(configItemTB);
							}
						}
					}

					// �����ʷ����
					CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
					ctcond.setType("jigui" + imgId);
					List<CompareTemplateInfo> ctList = compareTemplateBL
							.searchCompareTemplate(ctcond, 0, 0);
					if (ctList != null) {
						for (CompareTemplateInfo ctbean : ctList) {
							compareTemplateBL.deleteCompareTemplateByPK(ctbean
									.getCtpid());
						}
					}

					// ������ռ�ذ���Ϣ�����CompareTemplate����
					CompareTemplateTB ctTB = new CompareTemplateTB();
					ctTB.setCtcategory(roomID);
					ctTB.setCttype("jigui" + imgId);
					ctTB.setCtx(floorx);
					ctTB.setCty(floory);
					ctTB.setCttype(imgType);
					compareTemplateBL.registCompareTemplate(ctTB);
				}

				// 6.���й�ϵɾ��
				SOC0119BL entityItemRelationBL = (SOC0119BL) getBean("soc0119BL");
				SOC0119SearchCondImpl cd = new SOC0119SearchCondImpl();
				cd.setDeleteflag("0");
				cd.setCldeiid(Integer.parseInt(imgId));
				List<SOC0119Info> entityItemRelationList = entityItemRelationBL
						.searchEntityItemRelation(cd, 0, 0);
				if (entityItemRelationList != null
						&& entityItemRelationList.size() > 0) {
					for (SOC0119Info res : entityItemRelationList) {
						entityItemRelationBL.deleteEntityItemRelation(res);
					}
				}

				// ���������������ϵ��������Ϣȡ��
				IG601SearchCondImpl cond = new IG601SearchCondImpl();
				cond.setRelateroom(roomID);

				// �����ͷ���BLȡ��
				IG601BL computerRoomBL = (IG601BL) getBean("ig601BL");

				// ��ǰ�������з���ȡ��
				List<IG601Info> computerRoomVWInfoList = computerRoomBL
						.searchIG601Info(cond, 0, 0);
				String xMin = "000";
				String xMax = "000";
				String yMin = "000";
				String yMax = "000";
				if (computerRoomVWInfoList != null
						&& computerRoomVWInfoList.size() > 0) {
					for (IG601Info crVW : computerRoomVWInfoList) {
						// ��ȡ�����ذ������
						xMin = crVW.getRelatex().split(":")[0];
						xMax = crVW.getRelatex().split(":")[1];
						yMin = crVW.getRelatey().split(":")[0];
						yMax = crVW.getRelatey().split(":")[1];
						// �жϻ����Ƿ��ڷ���֮��
						if (Float.parseFloat(floorx) >= Float.parseFloat(xMin)
								&& Float.parseFloat(floorx) <= Float
										.parseFloat(xMax)
								&& Float.parseFloat(floory) >= Float
										.parseFloat(yMin)
								&& Float.parseFloat(floory) <= Float
										.parseFloat(yMax)) {
							// ���������������ϵ
							addPartContainer(imgId, String.valueOf(crVW.getEiid()));
						}
					}
				}

				// ���������������ϵ
				addComputerContainer(imgId, roomID);
			}
		}
    	return "ok";
    }
   
    /**
     * ���ܣ������������
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    @SuppressWarnings("unchecked")
	protected void saveGeDuanXML(HttpServletRequest req,PrintWriter out) throws BLException {
		try {
			// ��ȡ�û���Ϣ
			User user = (User) req.getSession().getAttribute(
					SESSION_KEY_LOGIN_USER);

			// ��ȡ�Ǽ�BL
			IGASM11BL bl = (IGASM11BL) getBean("igasm11BL");

			// FORMȡ��
			IGASM1102Form form = new IGASM1102Form();

			// DTO����
			IGASM11DTO dto = new IGASM11DTO();

			// �������
			String relateRoomXML = URLDecoder.decode(
					req.getParameter("relateRoomXML"), "utf-8");
			String baseMessageXML = URLDecoder.decode(
					req.getParameter("baseMessageXML"), "utf-8");
			String roomID = req.getParameter("roomID");
			String xMargin = "";
			String yMargin = "";
			String einame = "";
			String eidesc = "";
			String eilabel = "";

			// ����relateRoomXML
			SAXBuilder builderR = new SAXBuilder();
			StringReader readR = new StringReader(relateRoomXML);
			InputSource sourceR = new InputSource(readR);
			Document docR = builderR.build(sourceR);
			Element rootR = docR.getRootElement();
			List<Element> ListR = rootR.getChildren();
			List<Element> relateRoomList = ListR.get(0).getChildren();
			// ������������xmin->xmax,ymin->ymax
			if (relateRoomList != null && relateRoomList.size() > 0) {
				for (int i = 0; i < relateRoomList.size(); i++) {
					if ("x".equals(relateRoomList.get(i)
							.getAttributeValue("id"))) {
						xMargin = relateRoomList.get(i).getText();
					}
					if ("y".equals(relateRoomList.get(i)
							.getAttributeValue("id"))) {
						yMargin = relateRoomList.get(i).getText();
					}
				}
			}

			// ����baseMessageXML
			SAXBuilder builderB = new SAXBuilder();
			StringReader readB = new StringReader(baseMessageXML);
			InputSource sourceB = new InputSource(readB);
			Document docB = builderB.build(sourceB);
			Element rootB = docB.getRootElement();
			List<Element> ListB = rootB.getChildren();
			List<Element> baseMessageList = ListB.get(0).getChildren();
			// ����������Ϣ
			if (baseMessageList != null && baseMessageList.size() > 0) {
				for (int j = 0; j < baseMessageList.size(); j++) {
					if ("jfid".equals(baseMessageList.get(j).getAttributeValue(
							"id"))) {
						eilabel = baseMessageList.get(j).getText();
					}
					if ("jfname".equals(baseMessageList.get(j)
							.getAttributeValue("id"))) {
						einame = baseMessageList.get(j).getText();
					}
					if ("jfinfo".equals(baseMessageList.get(j)
							.getAttributeValue("id"))) {
						eidesc = baseMessageList.get(j).getText();
					}
				}
			}

			String[] cid = { IGASMBLType.RELATEROOM, IGASMBLType.RELATEX,
					IGASMBLType.RELATEY };
			// ������������
			String[] civalue = { roomID, xMargin, yMargin };
			// �жϸ�����Ϣ
			String[] ciattach = { "0", "0", "0" };

			// �ʲ�����
			form.setEilabel(eilabel);
			form.setEidesc(eidesc);
			form.setEiname(einame);
			form.setEiinsdate(IGStringUtils.getCurrentDate());
			form.setEsyscoding(EntityItemKeyWords.COMPUTER_ROOM_ESYSCODING);
			form.setCid(cid);
			form.setCivalue(civalue);
			form.setCiattach(ciattach);
			dto.setIgasm1102Form(form);
			dto.setUser(user);
			// ������Ϣ����
			dto = bl.insertComputerRoomInfoAction(dto);

			// ��������������ϵ��ʼ
			// ��ȡ�����ذ������
			String xMin = xMargin.split(":")[0];
			String xMax = xMargin.split(":")[1];
			String yMin = yMargin.split(":")[0];
			String yMax = yMargin.split(":")[1];

			// ��ȡCompareTemplateBL
			CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
			CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
			ctcond.setCategory(roomID);
			ctcond.setCabtype("jigui");
			List<CompareTemplateInfo> ctList = compareTemplateBL
					.searchCompareTemplate(ctcond, 0, 0);
			if (ctList != null) {
				for (CompareTemplateInfo ctVW : ctList) {
					// �жϻ����Ƿ��ڷ���֮��  //2013wxd
					if (Float.parseFloat(ctVW.getCtx()) >= Float
							.parseFloat(xMin)
							&& Float.parseFloat(ctVW.getCtx()) <= Float
									.parseFloat(xMax)
							&& Float.parseFloat(ctVW.getCty()) >= Float
									.parseFloat(yMin)
							&& Float.parseFloat(ctVW.getCty()) <= Float
									.parseFloat(yMax)) {
						String cttype = ctVW.getCttype()
								.replaceAll("jigui", "");
						cttype = cttype.replaceAll("UPS", "");
						cttype = cttype.replaceAll("AIR", "");
						// ���������������ϵ
						addPartContainer(cttype, String.valueOf(dto.getEiid()));
					}
				}
			}
			// ��������������ϵ����

			// ���������������ϵ
			addComputerRoomRelation(dto.getIgasm1102Form().getEid(),
					dto.getEiid(), roomID);
			out.print(dto.getEiid());
		}catch (Exception e) {
			e.printStackTrace();
			out.print("error");
		}
    }
    
    /**
     * ���ܣ����������������
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    protected void savePartAbsolute(HttpServletRequest req,PrintWriter out) throws BLException {
    	try {
			//�ʲ�BL���
			SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");
			
			//�������
			String partID = req.getParameter("partID");
			String absoluteX = req.getParameter("absoluteX");
			String absoluteY = req.getParameter("absoluteY");
			String[] cid = {IGASMBLType.X_TOTAL,IGASMBLType.Y_TOTAL};
            String[] civalue = {absoluteX,absoluteY};
            
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
			
			for( int i=0 ; i < 2; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//����ID
				configItem.setEiid(Integer.parseInt(partID));
				//�ʲ�����ID
				configItem.setCid(cid[i]);
				//����ID
				configItem.setEid("CM10000000");
				//���Ͳ����
				configItem.setEsyscoding("999007");
				//����
				configItem.setCivalue(civalue[i]);
				//����ʱ��
				configItem.setCiupdtime(datetime);
				//�汾Ϊ1
				configItem.setCiversion(1);
				
				configItem = (SOC0107TB) configItemBL.registSOC0107(configItem);
				
				log.debug("�ʲ������[�ʲ�����ID:" + cid[i] + "]�ǼǴ���ɹ���");
			}
	    	out.print("ok");
		}catch (Exception e) {
			e.printStackTrace();
			out.print("error");
		}
    }
    
    /**
     * ���ܣ����������������ϵ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void addComputerRoomRelation(String partEID,Integer partitionEIID,String roomID) throws BLException{
    	
    	
    	SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");
    	SOC0118BL entityItemBL = (SOC0118BL)getBean("soc0118BL");
    	
    	//�����趨��Ϣ����
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setCldeiid(partitionEIID);
		cond.setDeleteflag("0");
		//����ͷ�����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.ROOM_PART_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = entityItemRelationBL.searchEntityItemRelation(cond, 0, 0);
		
		//���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
					entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
		
		//3.1.������Ϣȡ��
		SOC0118Info roomEntity = entityItemBL.searchEntityItemByKey(Integer.parseInt(roomID));
		
		//4.��������������ϵ����
		SOC0119TB entityItemRelation = new SOC0119TB();
		entityItemRelation.setPareiid(roomEntity.getEiid());
		entityItemRelation.setPareid(roomEntity.getEid().toString());
		entityItemRelation.setCldeiid(partitionEIID);
		entityItemRelation.setCldeid(partEID.toString());
		entityItemRelation.setEirrelation(CommonDefineUtils.ROOM_PART_ASSIGN_RELATION);
		entityItemRelation.setEirrelationcode(CommonDefineUtils.PART_DEVICE_ASSIGN_RELATION_CODE);
		entityItemRelation.setEirupdtime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));
		
		entityItemRelationBL.registEntityItemRelation(entityItemRelation);
    }
    
    /**
     * ���ܣ���ø����б�
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    private void getPartXML(HttpServletRequest req,PrintWriter out) throws BLException{
    	//��ȡ����ID
    	String roomID = req.getParameter("roomID");
    	
    	//�ʲ���Ϣȡ��
    	SOC0118SearchCondImpl eicond = new SOC0118SearchCondImpl();
    	
    	//������Ϣȡ�� 
		SOC0601SearchCondImpl cond = new SOC0601SearchCondImpl();
		cond.setRelateroom(roomID);
		
		//�������ȡ��
		SOC0601SearchCondImpl condSup = new SOC0601SearchCondImpl();
		if(StringUtils.isNotEmpty(roomID));
		{condSup.setEiid(roomID);}
		SOC0601BL computerRoomBL = (SOC0601BL)getBean("soc0601BL");
		SOC0107BL configItemBL = (SOC0107BL)getBean("soc0107BL");
		SOC0107SearchCondImpl cicond = new SOC0107SearchCondImpl();
		if(roomID!=null){
		cicond.setEiid(roomID);}

		//��ǰ������Ϣȡ��
		List<SOC0601Info> ComputerRoomVWInfoList = computerRoomBL.searchSOC0601Info(cond, 0, 0);
		
		//���������Ϣȡ��
		List<SOC0601Info> ComputerRoomVWInfoListSup = computerRoomBL.searchSOC0601Info(condSup, 0, 0);
		List<SOC0107Info> configItem = configItemBL.searchSOC0107(cicond, 0, 0);
		//��ȡbaseMessageXML
		StringBuffer bmXML = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bmXML.append("<ROOT>");
		if(ComputerRoomVWInfoListSup!=null && ComputerRoomVWInfoListSup.size()==1){
			bmXML.append("<MESSAGE id=\"-1\">");
			bmXML.append("<INFO id=\"jfid\" title=\"�������\">"+ComputerRoomVWInfoListSup.get(0).getEilabel()+"</INFO>");
			bmXML.append("<INFO id=\"jfname\" title=\"��������\">"+ComputerRoomVWInfoListSup.get(0).getEiname()+"</INFO>");
			if(StringUtils.isNotEmpty(ComputerRoomVWInfoListSup.get(0).getEidesc())){
				bmXML.append("<INFO id=\"jfinfo\" title=\"����˵��\">"+ComputerRoomVWInfoListSup.get(0).getEidesc()+"</INFO>");
			}
			if(configItem != null && configItem.size() != 0){
				for(SOC0107Info cfitem:configItem){
					if(cfitem.getCid().toString().equals(IGASMBLType.JFHEADER)){
					    bmXML.append("<INFO id=\"jfheader\" title=\"������\">"+cfitem.getCivalue()+"</INFO>");
					}
					if(cfitem.getCid().toString().equals(IGASMBLType.JFTEL)){
					    bmXML.append("<INFO id=\"jftel\" title=\"��ϵ�绰\">"+cfitem.getCivalue()+"</INFO>");
					}
				}
			}
			bmXML.append("</MESSAGE>");
		}
		if(ComputerRoomVWInfoList!=null && ComputerRoomVWInfoList.size()!=0){
			for(SOC0601Info crVW : ComputerRoomVWInfoList){
				eicond.setEiid(crVW.getEiid().toString());
//				List<IG013> eiList = entityItemBL.searchEntityItem(eicond, 0, 0);
				bmXML.append("<MESSAGE id=\""+crVW.getEiid()+"\">");
				bmXML.append("<INFO id=\"jfid\" title=\"�������\">"+crVW.getEilabel()+"</INFO>");
				bmXML.append("<INFO id=\"jfname\" title=\"��������\">"+crVW.getEiname()+"</INFO>");
				bmXML.append("<INFO id=\"jfinfo\" title=\"����˵��\">"+crVW.getEidesc()+"</INFO>");
				bmXML.append("<INFO id=\"width\" title=\"���򳤶�\">" + (Integer.parseInt(crVW.getRelatex().split(":")[1]) - Integer.parseInt(crVW.getRelatex().split(":")[0])) + "</INFO>");
				bmXML.append("<INFO id=\"height\" title=\"���򳤶�\">" + (Integer.parseInt(crVW.getRelatey().split(":")[1]) - Integer.parseInt(crVW.getRelatey().split(":")[0])) + "</INFO>");
				bmXML.append("</MESSAGE>");
			}
		}
		bmXML.append("</ROOT>");
		out.print(bmXML.toString());
    }
    
    /**D
     * ���ܣ���ø�������
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    private void getPartXYXML(HttpServletRequest req,PrintWriter out) throws BLException{
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		
		// ��ȡ����ID
		String roomID = req.getParameter("roomID");

		//��ѯ�������꣬������Ϣ
		CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
		ctcond.setCategory(roomID);
		ctcond.setType("zone");
		
		// ��ȡzoneXML
		StringBuffer zoneXML = new StringBuffer(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		zoneXML.append("<ROOT>");
		
		List<CompareTemplateInfo> zoneList = compareTemplateBL.searchCompareTemplate(ctcond, 0, 0);
		if(zoneList!=null&& !zoneList.isEmpty()){
			for(CompareTemplateInfo zone:zoneList){
				zoneXML.append("<ZONE ")
				.append("TITLE=\""+zone.getCteiid()+"\" ")
				.append("STARTX=\""+zone.getCtx()+"\" ")
				.append("STARTY=\""+zone.getCty()+"\" ")
				.append("ENDX=\""+zone.getCtfloorx()+"\" ")
				.append("ENDY=\""+zone.getCtfloory()+"\" ")
				.append("/>");
			}
		}
		
		zoneXML.append("</ROOT>");
		
		out.print(zoneXML.toString());
    }
    
    /**
     * ���ܣ�ɾ������
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    private void deletePart(HttpServletRequest req,PrintWriter out) throws BLException{
    	//��ȡ����ID
    	String partID = req.getParameter("partID");
    	
    	//ɾ���ʲ�����Ϣ
    	SOC0118BL entityItemBL = (SOC0118BL)getBean("soc0118BL");
    	SOC0118Info ei = entityItemBL.searchEntityItemByKey(Integer.valueOf(partID));
    	SOC0118TB EntityTB = (SOC0118TB) SerializationUtils.clone(ei);
    	entityItemBL.deleteEntityItem(EntityTB);
    	
    	//ɾ����ϵ����Ϣ
    	SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");

    	SOC0119SearchCondImpl eicond = new SOC0119SearchCondImpl();
    	eicond.setDeleteflag("0");
		//���������
    	if(partID!=null){
		eicond.setCldeiid(Integer.parseInt(partID));}
		//�����������������ϵ�趨
		eicond.setEirrelation(CommonDefineUtils.ROOM_PART_ASSIGN_RELATION);
		//��ѯ�����������ϵ
		List<SOC0119Info> entityItemRelationList1 = entityItemRelationBL.searchEntityItemRelation(eicond, 0, 0);
		
		eicond = new SOC0119SearchCondImpl();
		eicond.setDeleteflag("0");
		//���������
		if(partID!=null){
		eicond.setPareiid(Integer.parseInt(partID));}
		//����ͷ�����������ϵ�趨
		eicond.setEirrelation(CommonDefineUtils.PART_CONTAINER_ASSIGN_RELATION);
		//��ѯ����������ϵ
		List<SOC0119Info> entityItemRelationList2 = entityItemRelationBL.searchEntityItemRelation(eicond, 0, 0);
		
		//���л����������ϵɾ��
		if (entityItemRelationList1 != null && entityItemRelationList1.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList1) {
				entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
		//���з���������ϵɾ��
		if (entityItemRelationList2 != null && entityItemRelationList2.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList2) {
				entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
		
		out.print("ok");
    }
    /**
     * ���ܣ�ɾ�������� �����ϵ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void delComputerContainer(String jiguiID) throws BLException{
    	
    	
    	SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");
    	///////////�����������ϵɾ��
		//1.�����趨��Ϣ����
    	SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		if(jiguiID!=null){
			cond.setCldeiid(Integer.parseInt(jiguiID));
		}
		cond.setDeleteflag("0");
		//����ͻ�����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = entityItemRelationBL.searchEntityItemRelation(cond, 0, 0);
		
		//2.���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
					entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
		///////////////////////////
		
		///////////�����������ϵɾ��
		//����ͷ�����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.PART_CONTAINER_ASSIGN_RELATION);
		
		entityItemRelationList = entityItemRelationBL.searchEntityItemRelation(cond, 0, 0);
		
		//2.���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
					entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
		///////////////////////////
		
    }

    /**
     * ���ܣ����������� �����ϵ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void addComputerContainer(String jiguiID,String roomID) throws BLException{
    	
    	SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");
    	SOC0118BL entityItemBL = (SOC0118BL)getBean("soc0118BL");

		//1.�����趨��Ϣ����
    	SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setDeleteflag("0");
		if(jiguiID!=null){
			cond.setCldeiid(Integer.parseInt(jiguiID));
		}
		if(roomID!=null){
			cond.setPareiid(Integer.parseInt(roomID));
		}
		//����ͻ�����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = entityItemRelationBL.searchEntityItemRelation(cond, 0, 0);
		
		//2.���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
					entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
		
		//3.������Ϣȡ��
		SOC0605Info jiguiEntity = entityItemBL.searchSOC0605InfoByKey(Integer.parseInt(jiguiID));
		
		//3.1.������Ϣȡ��
		SOC0605Info roomEntity = entityItemBL.searchSOC0605InfoByKey(Integer.parseInt(roomID));
		
		//4.��������������ϵ����
		SOC0119TB entityItemRelation = new SOC0119TB();
		entityItemRelation.setPareiid(roomEntity.getEiid());
		entityItemRelation.setPareid(roomEntity.getEid().toString());
		entityItemRelation.setCldeiid(jiguiEntity.getEiid());
		entityItemRelation.setCldeid(jiguiEntity.getEid().toString());
		entityItemRelation.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		entityItemRelation.setDeleteflag("0");
		
		if (CommonDefineUtils.ENTIY_CATEGORY_DEVICE.equals(jiguiEntity.getEcategory())) {
			entityItemRelation.setEirrelationcode(CommonDefineUtils.ROOM_EQUIPMENT_RELATION_CODE);
		}else{
			entityItemRelation.setEirrelationcode(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION_CODE);
		}
		entityItemRelation.setEirupdtime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));

		entityItemRelationBL.registEntityItemRelation(entityItemRelation);
    }
    
    /**
     * ���ܣ���������������ϵ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void addPartContainer(String jiguiID,String partID) throws BLException{
    	
    	SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");
    	SOC0118BL entityItemBL = (SOC0118BL)getBean("soc0119BL");

		//�����趨��Ϣ����
    	SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		if(jiguiID!=null){			
			cond.setCldeiid(Integer.parseInt(jiguiID));
		}
		cond.setDeleteflag("0");
		//����ͷ�����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.PART_CONTAINER_ASSIGN_RELATION);
		
		List<SOC0119Info> entityItemRelationList = entityItemRelationBL.searchEntityItemRelation(cond, 0, 0);
		
		//���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
					entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
		
		//������Ϣȡ��
		SOC0605Info jiguiEntity = entityItemBL.searchSOC0605InfoByKey(Integer.parseInt(jiguiID));
		//������Ϣȡ��
		SOC0605Info roomEntity = entityItemBL.searchSOC0605InfoByKey(Integer.parseInt(partID));
		
		//��������������ϵ����
		SOC0119TB entityItemRelation = new SOC0119TB();
		entityItemRelation.setPareiid(roomEntity.getEiid());
		entityItemRelation.setPareid(roomEntity.getEid().toString());
		entityItemRelation.setCldeiid(jiguiEntity.getEiid());
		entityItemRelation.setCldeid(jiguiEntity.getEid().toString());
		entityItemRelation.setEirrelation(CommonDefineUtils.PART_CONTAINER_ASSIGN_RELATION);
		
		if (CommonDefineUtils.ENTIY_CATEGORY_DEVICE.equals(jiguiEntity.getEcategory())) {
			entityItemRelation.setEirrelationcode(CommonDefineUtils.ROOM_EQUIPMENT_RELATION_CODE);
		}else{
			entityItemRelation.setEirrelationcode(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION_CODE);
		}
		entityItemRelation.setEirupdtime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));

		entityItemRelationBL.registEntityItemRelation(entityItemRelation);
    }
    
    /**
     * ���ܣ����δ�ϼܵ������б�
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void getZhuJiData(HttpServletRequest req,PrintWriter out) throws BLException{
    	String esyscoding = req.getParameter("esyscoding");
    	String einame = req.getParameter("einame");
    	String serialNum = req.getParameter("serialnum");
    	String cabinet = req.getParameter("cabinet");
    	String eiid = req.getParameter("eiid");
    	SOC0118BL entityItemBL = (SOC0118BL) getBean("soc0118BL");
    	SOC0118Info entityItem = entityItemBL.searchEntityItemByKey(Integer.parseInt(eiid));
    	
//    	User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
    	
    	if(EntityItemKeyWords.CONTAINER.equals(esyscoding)){//���ܲ�ѯ
    		SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
    		if(einame!=null&&!"".equals(einame)){
        		cond.setEiname(einame);
        	}
    		cond.setContainertype(EntityItemKeyWords.VALUE_PULLDOWN);
    		SOC0603BL computerContainerBL = (SOC0603BL)getBean("soc0603BL");
    		List<SOC0603Info> list = computerContainerBL.searchSOC0603Info(cond);
    		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    		sb.append("<ROOT>");
    		sb.append("<ZHUJI>");
    		if(list!=null && list.size()>0){
    			//���˵���ϵ���������������������ϵ�Ļ���
    			SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
        		eircond.setDeleteflag("0");
        		SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");
        		for(Iterator<SOC0603Info> it = list.iterator(); it.hasNext();){
        			SOC0603Info ccvw = it.next();
        			if((ccvw.getEiid())!=null){
        				eircond.setCldeiid(ccvw.getEiid());
        			}
    				//����Eiid��ѯ���й�ϵ
    				List<SOC0119Info> entityItemRelationList = entityItemRelationBL.searchEntityItemRelation(eircond, 0, 0);
    				if(entityItemRelationList!=null && entityItemRelationList.size()>0){
    					it.remove();
    				}else{
    					String cdType = "j7u";
    					if(StringUtils.isNotEmpty(ccvw.getU_total())){
        					if("7".equals(ccvw.getU_total())){
        						cdType = "j7u";
        					}else if("8".equals(ccvw.getU_total())){
        						cdType = "j8u";
        					}else if("9".equals(ccvw.getU_total())){
        						cdType = "j9u";
        					}else if("12".equals(ccvw.getU_total())){
        						cdType = "j12u";
        					}else{
        						cdType = ccvw.getU_total();
        					}
        				}
    					sb.append("<img x=\"0\" y=\"0\" id=\"zhuji"+ccvw.getEiid()+"\" type=\""+cdType+"\" title=\""+ccvw.getEiname()+"\" ontools=\"y\" />");
    				}
                }
    		}
    		sb.append("</ZHUJI>");
    		sb.append("</ROOT>");
    		out.print(sb.toString());
    	}else{//�豸��ѯ
    		SOC0602SearchCondImpl cond = new SOC0602SearchCondImpl();
    		cond.setEsyscoding(esyscoding);//��ֵʱ��ѯȫ��
    		/*if(StringUtils.isNotEmpty(esyscoding)){
        		cond.setEsyscoding(esyscoding);
        	}else{
        		cond.setEsyscoding("999001001");
        	}*/
        	if(einame!=null&&!"".equals(einame)){
        		cond.setEiname(einame);
//        		cond.setEsyscoding(null);
        	}
        	cond.setEiStatuses(new String[]{CommonDefineUtils.ENTITYITEM_STARUS_RENEW,CommonDefineUtils.ENTITYITEM_STARUS_NEW});
        	cond.setInJiguiFlg("N");
        	cond.setInroomFlg("��");
        	if(cabinet != null){
        		if("1".equals(cabinet)){
        			cabinet = entityItem.getEiname();
        		}
        	}
        	cond.setCabinet(cabinet);
    		//��ǰҳ�豸��Ϣȡ��
        	SOC0602BL computerDeviceBL = (SOC0602BL)getBean("soc0602BL");
    		List<SOC0602Info> computerDeviceVWInfoList = computerDeviceBL.searchSOC0602Info(cond,0,0);
    		String cdType = "b1u";
    		
    		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    		sb.append("<ROOT>");
    		sb.append("<ZHUJI>");
    		if(computerDeviceVWInfoList!=null){
    			for(SOC0602Info cdBean:computerDeviceVWInfoList){
    				if(StringUtils.isNotEmpty(cdBean.getU_width())){
    					if("1".equals(cdBean.getU_width())){
    						cdType = "b1u";
    					}else if("2".equals(cdBean.getU_width())){
    						cdType = "b2u";
    					}else if("3".equals(cdBean.getU_width())){
    						cdType = "b3u";
    					}else if("4".equals(cdBean.getU_width())){
    						cdType = "b4u";
    					}else if("5".equals(cdBean.getU_width())){
    						cdType = "b5u";
    					}else{
    						cdType = cdBean.getU_width();
    					}
    				}
    				if(StringUtils.isNotEmpty(serialNum)){
						if( getSN(cdBean.getEiid().toString()).indexOf(serialNum) != -1 ){
							sb.append("<img x=\"0\" y=\"0\" id=\""
									+ cdBean.getEiid() + "\" type=\"" + cdType
									+ "\" title=\"" + cdBean.getEiname()
									+ "\" eilabel=\"" + getSN(cdBean.getEiid().toString())
									+ "\" ontools=\"y\" />");
						}
					}else{
						sb.append("<img x=\"0\" y=\"0\" id=\""
								+ cdBean.getEiid() + "\" type=\"" + cdType
								+ "\" title=\"" + cdBean.getEiname()
								+ "\" eilabel=\"" + getSN(cdBean.getEiid().toString())
								+ "\" ontools=\"y\" />");
					}
//    				sb.append("<img x=\"0\" y=\"0\" id=\"zhuji"+cdBean.getEiid()+"\" type=\""+cdType+"\" title=\""+cdBean.getEiname()+"\" ontools=\"y\" />");
    			}
    		}
    		sb.append("</ZHUJI>");
    		sb.append("</ROOT>");
    		out.print(sb.toString());
    	}
    }
    
	//�����������к�
	private String getSN(String eiid) throws BLException{
		SOC0118BL entityItemBL = (SOC0118BL) getBean("soc0118BL");
		SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");

		SOC0118Info zhujiEntity = entityItemBL.searchEntityItemByKey(Integer.parseInt(eiid));
		// ��ǰ������Ϣȡ��
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		ciCond.setEiid(eiid);
		ciCond.setCiversion(String.valueOf(zhujiEntity.getEiversion()));
		List<SOC0107Info> configItemList = configItemBL.searchSOC0107(ciCond,
				0, 0);
		String serial="";
		for (SOC0107Info item : configItemList) {
			String clabel = item.getConfiguration().getClabel();
			if (EntityItemKeyWords.ENTITY_DEFAULT_SERIAL_NUMBER
					.equals(clabel)) {
				serial=item.getCivalue() == null ? "" : item
						.getCivalue();
				break;
			}
		}
		return serial;
		
	}
    
    /**
     * ���ܣ��������������Ĺ�ϵ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void saveZhuJiRelation(HttpServletRequest req, PrintWriter out) throws BLException {
    	try {
			String jiguiDetalXML = URLDecoder.decode(req.getParameter("jiguiDetalXML"), "utf-8"); // �Ѿ��ϼܵ��豸
			String shebeiXML = URLDecoder.decode(req.getParameter("shebeiXML"), "utf-8"); // δ�ϼܵ���
			String jiguiID = req.getParameter("jiguiID");
			if (jiguiID != null) {
				jiguiID = jiguiID.replaceAll("jiguiImg", "");
			}
			saveSheBeiMsg(jiguiDetalXML, jiguiID); // �������ϼܵ��豸
			savejgListMsg(shebeiXML); // ����δ�ϼܵ��豸
			out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("error");
		}
	}
    
    /**
     * ���ܣ�����δ�ϼ��豸
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    @SuppressWarnings("unchecked")
	private void savejgListMsg(String jiguiXML) throws Exception{
		SAXBuilder builder = new SAXBuilder();
		StringReader read = new StringReader(jiguiXML);
	    InputSource source = new InputSource(read);
	    Document doc = builder.build(source);
	    Element root = doc.getRootElement();
		List<Element> eList = root.getChildren();
		String imgId = null;
		for(Element el:eList){
			List<Element> subList = el.getChildren();
			for(Element subEL:subList){
				imgId = subEL.getAttributeValue("id").replaceAll("zhuji","");
				delZhuJiDetal(imgId);
			}
		}
    }
    
    
    /**
     * ���ܣ������ϼ��豸
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
	private void saveSheBeiMsg(String shebeiXML,String jiguiID) throws Exception{
		SAXBuilder builder = new SAXBuilder();
		StringReader read = new StringReader(shebeiXML);
	    InputSource source = new InputSource(read);
	    Document doc = builder.build(source);
	    Element root = doc.getRootElement();
		List<Element> eList = root.getChildren();
		String imgId = null;
		String address = null;
		for(Element el:eList){
			List<Element> subList = el.getChildren();
			for(Element subEL:subList){
				imgId = subEL.getAttributeValue("id").replaceAll("zhuji","");
				address = subEL.getAttributeValue("address");
				addZhuJiRelation(imgId,jiguiID,address);
			}
		}
    }
    
    
    
    /**
     * ���ܣ��������������Ĺ�ϵ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    private void addZhuJiRelation(String zhujiID,String jiguiID,String address) throws BLException{
    	log.debug("==========�������������Ĺ�ϵ��" + zhujiID + "����ʼ==========");
    	
    	zhujiID = zhujiID.replaceAll("zhuji", "");
    	String sysTime = IGStringUtils.getCurrentDateTime();
		//1.�豸��Ϣȡ��
    	SOC0118BL entityItemBL = (SOC0118BL)getBean("soc0118BL");
    	SOC0118Info zhujiEntity = entityItemBL.searchEntityItemByKey(Integer.parseInt(zhujiID));
		
    	SOC0107BL configItemBL = (SOC0107BL)getBean("soc0107BL");
		//��ǰ������Ϣȡ��
    	SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		ciCond.setEiid(zhujiID);
		ciCond.setCiversion(String.valueOf(zhujiEntity.getEiversion()));
//		ciCond.setCismallversion(String.valueOf(zhujiEntity.getEismallversion()));
		List<SOC0107Info> configItemList = configItemBL.searchSOC0107(ciCond, 0, 0);
		
		//2.�ж������Ƿ����ı�
		boolean flag = false;
		if(zhujiEntity.getEid().equals(8)){
			flag = false;//����
		}else{
			flag = true;//�豸
		}
		
		if(flag){//�豸
			boolean isUpdateFlg = isUpdateConfigFlg(configItemList,EntityItemKeyWords.CLABEL_U_VALUE,address);
			//���δ�����ı������κζ���
			if(isUpdateFlg){
				return;
			}
		}else{//����
			boolean isUpdateFlg = isUpdateConfigFlg(configItemList,EntityItemKeyWords.CLABEL_WZ_VALUE,address);
			//���δ�����ı������κζ���
			if(isUpdateFlg){
				return;
			}
		}
		//3. ����entityItem �汾��Ϣ��ʼ
		SOC0118TB zhujiEntityTB = (SOC0118TB) SerializationUtils.clone(zhujiEntity);
		SOC0117BL soc0117BL = (SOC0117BL) getBean("soc0117BL");
		SOC0117Info entity = soc0117BL.searchEntityByKey(zhujiEntityTB.getEid());
		zhujiEntityTB.setEiversion(zhujiEntity.getEiversion() + 1);
		zhujiEntityTB.setEiupdtime(sysTime);
		SOC0118Info newZhuJiEntityItem =  entityItemBL.updateEntityItem(zhujiEntityTB);
		//����entityItem �汾��Ϣ����
		
		
		
		//4.�ʲ���ϵ��Ϣ�汾��������
		SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");
    	//5.���й�ϵɾ��
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setCldeiid(Integer.parseInt(zhujiID));
		cond.setDeleteflag("0");
		if(flag){//�豸
			cond.setEirrelation(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION);
		}else{//����
			cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		}
		List<SOC0119Info> entityItemRelationList = entityItemRelationBL.searchEntityItemRelation(cond, 0, 0);
		if (entityItemRelationList != null && entityItemRelationList.size()>0 ) {
			for (SOC0119Info res:entityItemRelationList) {
				entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
    	
		SOC0118Info jiguiEntity = entityItemBL.searchEntityItemByKey(Integer.parseInt(jiguiID));
		SOC0119TB entityItemRelation = new SOC0119TB();
		entityItemRelation.setPareiid(jiguiEntity.getEiid());
		entityItemRelation.setPareid(jiguiEntity.getEid());
		
		entityItemRelation.setCldeiid(newZhuJiEntityItem.getEiid());
		entityItemRelation.setCldeid(newZhuJiEntityItem.getEid());
		if(flag){//�豸
			entityItemRelation.setEirrelation(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION);
		}else{//����
			entityItemRelation.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		}
		
		entityItemRelation.setEirrelationcode(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION_CODE);
		
		entityItemRelation.setEirupdtime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));
		
		entityItemRelation.setParversion(jiguiEntity.getEiversion());
		entityItemRelation.setParsmallversion(jiguiEntity.getEismallversion());
		
		entityItemRelation.setCldversion(newZhuJiEntityItem.getEiversion());
		entityItemRelation.setCldsmallversion(newZhuJiEntityItem.getEismallversion());
		
		entityItemRelationBL.registEntityItemRelation(entityItemRelation);
		
		if(flag){//�豸
			updateJFConfig(configItemList,EntityItemKeyWords.CLABEL_U_VALUE,address, entity,sysTime);
		}else{//����
			updateJFConfig(configItemList,EntityItemKeyWords.CLABEL_WZ_VALUE,address, entity,sysTime);
			
			ciCond = new SOC0107SearchCondImpl();
			ciCond.setEiid(zhujiID);
			ciCond.setCid(String.valueOf(EntityItemKeyWords.GRAPHSTATUS_ID));
			ciCond.setCiversion(String.valueOf(newZhuJiEntityItem.getEiversion()));
			List<SOC0107Info> ciList = configItemBL.searchSOC0107(ciCond, 0, 0);
			if(ciList!=null && ciList.size()>0){
				SOC0107TB ci = (SOC0107TB) SerializationUtils.clone(ciList.get(0));
				ci.setCivalue(EntityItemKeyWords.graphstatusY);
				configItemBL.registSOC0107(ci);
			}
		}
    }
    
    /**
	 * ���ܣ������¼ܵ��豸
	 * 
	 * @param imgId
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	private void removeHostRelation(HttpServletRequest req) throws Exception {
		String shebeiId = req.getParameter("shebeiId");
		delZhuJiDetal(shebeiId);
	}
	
	/**
	 * ���ܣ��������������Ĺ�ϵ
	 * 
	 * @param req
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */

	private void saveHostRelation(HttpServletRequest req)
			throws Exception {
		String shebeiId = req.getParameter("shebeiId");
		String jiguiID = req.getParameter("jiguiID");
		String address = req.getParameter("address");
		addZhuJiRelation(shebeiId, jiguiID, address);
	}
    
    /**
     * ���ܣ�ɾ���ϼܵ������б�
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void delZhuJiDetal(String zhujiID) throws BLException{
    	
    	zhujiID = zhujiID.replaceAll("zhuji", "");
    	String sysTime = IGStringUtils.getCurrentDateTime();
		// 1.�豸��Ϣȡ��
		SOC0118BL entityItemBL = (SOC0118BL) getBean("soc0118BL");
		SOC0118Info zhujiEntity = entityItemBL.searchEntityItemByKey(Integer
				.parseInt(zhujiID));

		SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");
		// ��ǰ������Ϣȡ��
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		ciCond.setEiid(zhujiID);
		ciCond.setCiversion(String.valueOf(zhujiEntity.getEiversion()));
		List<SOC0107Info> configItemList = configItemBL.searchSOC0107(ciCond,
				0, 0);

		// 2.�ж������Ƿ����ı�
		boolean flag = false;
		if (zhujiEntity.getEid().equals(8)) {
			flag = false;// ����
		} else {
			flag = true;// �豸
		}

		if (flag) {// �豸
			boolean isUpdateFlg = isUpdateConfigFlg(configItemList,
					EntityItemKeyWords.CLABEL_U_VALUE, null);
			// ���δ�����ı������κζ���
			if (isUpdateFlg) {
				return;
			}
		} else {// ����
			boolean isUpdateFlg = isUpdateConfigFlg(configItemList,
					EntityItemKeyWords.CLABEL_WZ_VALUE, null);
			// ���δ�����ı������κζ���
			if (isUpdateFlg) {
				return;
			}
		}

		// 3. ����entityItem �汾��Ϣ��ʼ
		SOC0118TB zhujiEntityTB = (SOC0118TB) SerializationUtils
				.clone(zhujiEntity);
		SOC0117BL SOC0117BL = (SOC0117BL) getBean("soc0117BL");
		SOC0117Info entity = SOC0117BL.searchEntityByKey(zhujiEntityTB.getEid());
		zhujiEntityTB.setEiversion(zhujiEntity.getEiversion() + 1);
		zhujiEntityTB.setEiupdtime(sysTime);
		SOC0118Info ei = entityItemBL.updateEntityItem(zhujiEntityTB);
		// ����entityItem �汾��Ϣ����

		// 4.�ʲ���ϵ��Ϣ�汾��������
		SOC0119BL entityItemRelationBL = (SOC0119BL) getBean("soc0119BL");

		// 5.���й�ϵɾ��
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setCldeiid(Integer.parseInt(zhujiID));
		cond.setDeleteflag("0");
		if (flag) {// �豸
			cond.setEirrelation(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION);
		} else {// ����
			cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);
		}
		List<SOC0119Info> entityItemRelationList = entityItemRelationBL
				.searchEntityItemRelation(cond, 0, 0);
		if (entityItemRelationList != null && entityItemRelationList.size() > 0) {
			for (SOC0119Info res : entityItemRelationList) {
				entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
		if (flag) {// �豸
			updateZJConfig(configItemList, EntityItemKeyWords.CLABEL_U_VALUE,
					null, entity, sysTime);
		} else {// ����
			updateJFConfig(configItemList, EntityItemKeyWords.CLABEL_WZ_VALUE,
					null, entity, sysTime);

			ciCond = new SOC0107SearchCondImpl();
			ciCond.setEiid(zhujiID);
			ciCond.setCid(String.valueOf(EntityItemKeyWords.GRAPHSTATUS_ID));
			ciCond.setCiversion(String.valueOf(ei.getEiversion()));
			List<SOC0107Info> ciList = configItemBL.searchSOC0107(ciCond, 0, 0);
			if (ciList != null && ciList.size() > 0) {
				SOC0107TB ci = (SOC0107TB) SerializationUtils
						.clone(ciList.get(0));
				ci.setCivalue(EntityItemKeyWords.graphstatusN);
				configItemBL.registSOC0107(ci);
			}
		}
    }
    
    private void updateZJConfig(List<SOC0107Info> configItemList, String ciLabel,
			String ciValue, SOC0117Info entity, String ciupdtime)
			throws BLException {
		SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");
		SOC0118BL entityItemBL = (SOC0118BL) getBean("soc0118BL");
		SOC0119BL entityItemRelationBL = (SOC0119BL) getBean("soc0119BL");
		Integer u_eiid = 0;
		Integer u_eiversion = 0;
		Integer u_smallversion = 0;
		// ���񱣴����λ����Ϣ
		if (configItemList != null && configItemList.size() > 0) {
			for (SOC0107Info item : configItemList) {
				String clabel = item.getConfiguration().getClabel();
				SOC0107TB configItemTB = (SOC0107TB) SerializationUtils
						.clone(item);
				configItemTB.setCiid(null);
				configItemTB.setCiversion(item.getCiversion() + 1);
				if (ciLabel.equals(clabel)) {
					configItemTB.setCivalue(ciValue);
					configItemTB.setCicurver("1");
				}else{
					configItemTB.setCicurver("0");
				}
				configItemTB.setCiupdtime(ciupdtime);
				SOC0107Info configItem = configItemBL
						.registSOC0107(configItemTB);
				u_eiid = configItem.getEiid();
				u_eiversion = item.getCiversion();
				u_smallversion = item.getCismallversion();

				// �������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
				if ("4".equals(configItem.getConfiguration().getCattach())
						&& StringUtils.isNotEmpty(configItem.getCivalue())) {

					String str = configItem.getCivalue();
					SOC0118Info ei = new SOC0118TB();
					Integer eiid = Integer.parseInt(str.substring(
							str.lastIndexOf("(") + 1, str.length() - 1));
					try {
						ei = entityItemBL.searchEntityItemByKey(eiid);
						// У���ϵ�Ƿ����
						SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
						eirCond.setEirinfo(configItem.getEiid() + "_"
								+ item.getCiid() + "_" + ei.getEiid());
						eirCond.setEirstatus("C");
						eirCond.setDeleteflag("0");
						eirCond.setParversion(item.getCiversion());// �ʲ���汾
						eirCond.setParsmallversion(item.getCismallversion());// �ʲ�С�汾

						List<SOC0119Info> eirlist = entityItemRelationBL
								.searchMaxEntityItemRelation(eirCond);
						if (eirlist.size() != 1) {
							throw new BLException(
									BLErrorType.ENTITY_NOT_EXISTS_ERROR,
									"IGCO10000.E017");
						} else {
						    SOC0607VW eirTB = (SOC0607VW) SerializationUtils
									.clone(eirlist.get(0));
							eirTB.setEirid(null);
							eirTB.setEirupdtime(IGStringUtils
									.getCurrentDateTime());
							eirTB.setEirinfo(eirTB.getEirinfo().replaceAll(
									"_" + item.getCiid() + "_",
									"_" + configItem.getCiid() + "_"));
							eirTB.setParversion(configItem.getCiversion());
							eirTB.setParsmallversion(configItem
									.getCismallversion());
							entityItemRelationBL.registEntityItemRelation(eirTB);
						}
					} catch (Exception ex) {
						log.warn("��ģʽ��ϵ��Ϣ�д��ڵ��ʲ�eiid���ʲ����в����ڡ�eiid:" + eiid);
					}
				}
			}

			// �ʲ���ϵ��Ϣ�汾��������
			entityItemRelationBL.upgradeEntityItemRelationByJiFang(u_eiid, u_eiversion,
					u_smallversion, u_eiversion + 1, 0);
		}
	}
    
	/**
	 * 
	 * �����ϼܵĻ����б�
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void realTimeSave(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		String roomID = req.getParameter("roomID");
		String imgId = req.getParameter("id");
		String imgX = req.getParameter("x");
		String imgY = req.getParameter("y");
		String imgIndex = req.getParameter("index");
		String imgType = req.getParameter("cttype");
		String floorx = req.getParameter("floorx");
		String floory = req.getParameter("floory");
		String zoneid = req.getParameter("zoneid");
		

		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		CompareTemplateSearchCondImpl ctCond = new CompareTemplateSearchCondImpl();
		ctCond.setCteiid(imgId);
		//��ѯ��ǰ�����Ƿ�����
		List<CompareTemplateInfo> ctlist = compareTemplateBL.searchCompareTemplate(ctCond);
		//�������������
		if(ctlist!=null&&ctlist.size()>0){
			
			//����λ��
			int compareTemplateId = ctlist.get(0).getCtpid();
			
			CompareTemplateInfo ctbean = compareTemplateBL.searchCompareTemplateByPK(compareTemplateId);
			CompareTemplateTB configItemTB = (CompareTemplateTB) SerializationUtils
					.clone(ctbean);
			configItemTB.setCtx(imgX);
			configItemTB.setCty(imgY);
			configItemTB.setCtfloorx(floorx);
			configItemTB.setCtfloory(floory);
			configItemTB.setCtindex(imgIndex);
			configItemTB.setCtZoneId("null".equals(zoneid)?null:zoneid);
			configItemTB.setCtcategory(roomID);
			compareTemplateBL.updateCompareTemplate(configItemTB);
			
			//���¹�ϵ
			addComputerContainer(imgId, roomID);
			
			out.print(compareTemplateId);
			
		}else{
			
			// �������
			SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");
			SOC0118BL SOC0118BL = (SOC0118BL) getBean("soc0118BL");
						
			SOC0118Info bean013 = SOC0118BL.searchEntityItemByKey(Integer.parseInt(imgId));
	
			// ��ǰ������Ϣȡ��
			SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
			ciCond.setEiid(imgId); 
			ciCond.setCiversion(bean013.getEiversion().toString());
			List<SOC0107Info> configItemList = configItemBL.searchSOC0107(
					ciCond, 0, 0);
	
			String ctid = "";
			
			// ���û���'������'
			if (configItemList != null && configItemList.size() > 0) {
				for (SOC0107Info item : configItemList) {
					String clabel = item.getConfiguration().getClabel();
	
					if (EntityItemKeyWords.CLABEL_GRAPHSTATUS
							.equals(clabel)) {
						if (StringUtils.isEmpty(item.getCivalue())
								|| !"1".equals(item.getCivalue())) {
							SOC0107TB configItemTB = (SOC0107TB) SerializationUtils
									.clone(item);
							configItemTB
									.setCivalue(EntityItemKeyWords.graphstatusY);
							configItemBL.updateSOC0107(configItemTB);
						}
					} 
				}
	
				// ������ռ�ذ���Ϣ�����CompareTemplate����
				CompareTemplateTB ctTB = new CompareTemplateTB();
				ctTB.setCtcategory(roomID);
				ctTB.setCteiid(imgId);
				ctTB.setCtx(imgX);
				ctTB.setCty(imgY);
				ctTB.setCtfloorx(floorx);
				ctTB.setCtfloory(floory);
				ctTB.setCttype(imgType);
				ctTB.setCtindex(imgIndex);
				ctTB.setCtZoneId("null".equals(zoneid)?null:zoneid);
				CompareTemplateInfo ctinfo = compareTemplateBL.registCompareTemplate(ctTB);
				ctid = ctinfo.getCtpid().toString();
			}
	
			// ���������������ϵ
			addComputerContainer(imgId, roomID);
			out.print(ctid);
		}
	}
	
	/**
	 * 
	 * ����δ�ϼܵĻ���
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void deleteCabinet(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		String imgId = req.getParameter("id");

		deleteCabinetById(imgId);
		out.print("ok");
	}
	
	/**
	 * 
	 * ɾ���ϼܵĻ���
	 * 
	 * @param imgId
	 * @throws BLException
	 */
	private void deleteCabinetById(String imgId)
			throws BLException  {

		SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");
		SOC0118BL SOC0118BL = (SOC0118BL) getBean("soc0118BL");
		
		SOC0118Info bean013 = SOC0118BL.searchEntityItemByKey(Integer.parseInt(imgId));

		// ��ǰ������Ϣȡ��
		SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		ciCond.setEiid(imgId);
		ciCond.setCiversion(bean013.getEiversion().toString());
		List<SOC0107Info> configItemList = configItemBL.searchSOC0107(
				ciCond, 0, 0);

		// ��������Ϊ  'δ����'
		if (configItemList != null && configItemList.size() > 0) {
			for (SOC0107Info item : configItemList) {
				String clabel = item.getConfiguration().getClabel();
				SOC0107TB configItemTB = (SOC0107TB) SerializationUtils
						.clone(item);
				if (EntityItemKeyWords.CLABEL_GRAPHSTATUS
						.equals(clabel)) {
					configItemTB
							.setCivalue(EntityItemKeyWords.graphstatusN);
					configItemBL.updateSOC0107(configItemTB);
					break;
				}
			}
		}



		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		// ɾ��ĳ�豸�ڻ����е�λ����Ϣ
		if (StringUtils.isNotEmpty(imgId)) {
			CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
			ctcond.setCteiid(imgId);
			List<CompareTemplateInfo> ctList = compareTemplateBL
					.searchCompareTemplate(ctcond, 0, 0);
			if (ctList != null && !ctList.isEmpty()) {
				for (CompareTemplateInfo ctbean : ctList) {
					compareTemplateBL.deleteCompareTemplateByPK(ctbean
							.getCtpid());
				}
			}
		}

		// ɾ����ϵ
		//delComputerContainer(imgId);
		
		String jiguiID = imgId;
		
		SOC0119BL entityItemRelationBL = (SOC0119BL) getBean("soc0119BL");
		// /////////�����������ϵɾ��
		// 1.�����趨��Ϣ����
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setCldeiid(Integer.parseInt(jiguiID));
		cond.setDeleteflag("0");
		// ����ͻ�����������ϵ�趨
		cond.setEirrelation(CommonDefineUtils.ROOM_CONTAINER_ASSIGN_RELATION);

		List<SOC0119Info> entityItemRelationList = entityItemRelationBL.searchEntityItemRelationBySql(cond, 0, 0);

		// 2.���й�ϵɾ��
		if (entityItemRelationList != null && entityItemRelationList.size() > 0) {
			for (SOC0119Info res : entityItemRelationList) {
				entityItemRelationBL.deleteEntityItemRelation(res);
			}
		}
	}
	
	/**
	 * 
	 * ���»���λ����Ϣ
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void realTimeUpdate(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		
		String id = req.getParameter("id");
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		String index = req.getParameter("index");
		String floorx = req.getParameter("floorx");
		String floory = req.getParameter("floory");
		String zoneid = req.getParameter("zoneid");
		String cttype = req.getParameter("cttype");
		
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		// �޸�ĳ�豸�ڻ����е�λ����Ϣ
		if (StringUtils.isNotEmpty(id)) {
			Integer ctid = Integer.parseInt(id);
			CompareTemplateInfo ctbean = compareTemplateBL.searchCompareTemplateByPK(ctid);
			CompareTemplateTB configItemTB = (CompareTemplateTB) SerializationUtils
					.clone(ctbean);
			configItemTB.setCtx(x);
			configItemTB.setCty(y);
			configItemTB.setCtfloorx(floorx);
			configItemTB.setCtfloory(floory);
			configItemTB.setCtindex(index);
			if(!"legend".equals(cttype)){
				configItemTB.setCtZoneId("null".equals(zoneid)?null:zoneid);
			}
			compareTemplateBL.updateCompareTemplate(configItemTB);
		}
	}
	
	/**
	 * 
	 * ����ͼ��λ��
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void saveLegend(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		
		//ȡ��ͼ����Ϣ
		String roomID = req.getParameter("roomID");
		//String imgId = req.getParameter("id");
		String imgX = req.getParameter("x");
		String imgY = req.getParameter("y");
		String imgIndex = req.getParameter("index");
		String imgType = req.getParameter("cttype");
		String floorx = req.getParameter("floorx");
		String floory = req.getParameter("floory");
		
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		
		//����ͼ����Ϣ
		CompareTemplateTB ctTB = new CompareTemplateTB();
		ctTB.setCtcategory(roomID);
		//ctTB.setCteiid(imgId);
		ctTB.setCtx(imgX);
		ctTB.setCty(imgY);
		ctTB.setCtindex(imgIndex);
		ctTB.setCttype(imgType);
		ctTB.setCtfloorx(floorx);
		ctTB.setCtfloory(floory);
		
		CompareTemplateInfo ctinfo = compareTemplateBL.registCompareTemplate(ctTB);
		out.print(ctinfo.getCtpid().toString());
	}
	
	/**
	 * 
	 * ɾ��ͼ��λ��
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void deleteLegend(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		
		String id = req.getParameter("id");
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		// ɾ��ͼ��λ����Ϣ
		if (StringUtils.isNotEmpty(id)) {
			Integer ctid = Integer.parseInt(id);
			compareTemplateBL.deleteCompareTemplateByPK(ctid);
		}
		out.print("ok");
	}
	
	/**
	 * 
	 * ��ѯ��Ч�ذ�
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void isNAF(HttpServletRequest req, PrintWriter out)
			throws BLException  {
			//��ȡ�������
			String roomID = req.getParameter("roomID");
			String x = req.getParameter("x");
			String y = req.getParameter("y");
			
			// ��ȡCompareTemplateBL
			CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
			
			CompareTemplateSearchCondImpl cond = new CompareTemplateSearchCondImpl();
			cond.setCategory(roomID);
			cond.setCtfloorx(x);
			cond.setCtfloory(y);
			cond.setType("naf");
			
			List<CompareTemplateInfo> ctlist = compareTemplateBL.searchCompareTemplate(cond);
			
			String flag = "no";
			
			if(ctlist != null&&ctlist.size()>0){
				flag = "yes";
			}
			
			out.print(flag);
	}
	
	/**
	 * 
	 * ���ƻ���
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void changeIndex(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		
		String pkid = req.getParameter("pkid");
		String ctindex = req.getParameter("ctindex");
		
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		// ��������
		if (StringUtils.isNotEmpty(pkid)) {
			Integer id = Integer.parseInt(pkid);
			CompareTemplateInfo ctbean = compareTemplateBL.searchCompareTemplateByPK(id);
			CompareTemplateTB configItemTB = (CompareTemplateTB) SerializationUtils
					.clone(ctbean);
			configItemTB.setCtindex(ctindex);
			compareTemplateBL.updateCompareTemplate(configItemTB);
		}
		out.print("ok");
	}
	
	/**
	 * 
	 * �����Ч�ذ�
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void addNaF(HttpServletRequest req, PrintWriter out)
			throws BLException  {
			//��ȡ��Ч�ذ��������
			String roomID = req.getParameter("roomID");
			String ctx = req.getParameter("ctx");
			String cty = req.getParameter("cty");
			String floorx = req.getParameter("floorx");
			String floory = req.getParameter("floory");
			
			// ��ȡCompareTemplateBL
			CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
			
			//������Ч�ذ��������
			CompareTemplateTB ctTB = new CompareTemplateTB();
			ctTB.setCtcategory(roomID);
			ctTB.setCtx(ctx);
			ctTB.setCty(cty);
			ctTB.setCtfloorx(floorx);
			ctTB.setCtfloory(floory);
			ctTB.setCttype("naf");
			
			//����
			CompareTemplateInfo ctbean = compareTemplateBL.registCompareTemplate(ctTB);
			
			out.print(ctbean.getCtpid());
	}
	
	/**
	 * 
	 * ���������Ϣ
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void saveZone(HttpServletRequest req, PrintWriter out){
		
		try {
			//��ȡ������Ϣ
			String roomID = req.getParameter("roomID");
			String zid = URLDecoder.decode(req.getParameter("zid"),
					"utf-8");
			String zname = URLDecoder.decode(req.getParameter("zname"),
					"utf-8");
			String zinfo = URLDecoder.decode(req.getParameter("zinfo"),
					"utf-8");

			String zsx = req.getParameter("zsx");
			String zsy = req.getParameter("zsy");
			String zenx = req.getParameter("zenx");
			String zeny = req.getParameter("zeny");
			
			// ��ȡCompareTemplateBL
			CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
			
			//���÷�����Ϣ
			CompareTemplateTB ctTB = new CompareTemplateTB();
			ctTB.setCtcategory(roomID);
			ctTB.setCteiid(zid);
			ctTB.setCtName(zname);
			ctTB.setCtInfo(zinfo);
			ctTB.setCtx(zsx);
			ctTB.setCty(zsy);
			ctTB.setCtfloorx(zenx);
			ctTB.setCtfloory(zeny);
			ctTB.setCttype("zone");
			
			//����
			compareTemplateBL.registCompareTemplate(ctTB);
			
			out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("error");
		}
	}
    
	/**
	 * 
	 * ��û�����Ϣ
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void getRoomInfo(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		
		// ��ȡ����ID
		String roomID = req.getParameter("roomID");

		// �������ȡ��
		SOC0601SearchCondImpl condSup = new SOC0601SearchCondImpl();
		condSup.setEiid(roomID);
		SOC0601BL computerRoomBL = (SOC0601BL) getBean("soc0601BL");
		SOC0107BL configItemBL = (SOC0107BL) getBean("soc0107BL");
		SOC0107SearchCondImpl cicond = new SOC0107SearchCondImpl();
		cicond.setEiid(roomID);

		// ���������Ϣȡ��
		List<SOC0601Info> ComputerRoomVWInfoListSup = computerRoomBL
				.searchSOC0601Info(condSup, 0, 0);
		List<SOC0107Info> configItem = configItemBL.searchSOC0107(cicond, 0, 0);
		// ��ȡbaseMessageXML
		StringBuffer bmXML = new StringBuffer(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bmXML.append("<ROOT>");
		if (ComputerRoomVWInfoListSup != null
				&& ComputerRoomVWInfoListSup.size() == 1) {
			bmXML.append("<MESSAGE id=\"-1\">");
			bmXML.append("<INFO id=\"jfid\" title=\"�������\">"
					+ ComputerRoomVWInfoListSup.get(0).getEilabel() + "</INFO>");
			bmXML.append("<INFO id=\"jfname\" title=\"��������\">"
					+ ComputerRoomVWInfoListSup.get(0).getEiname() + "</INFO>");
			if (StringUtils.isNotEmpty(ComputerRoomVWInfoListSup.get(0)
					.getEidesc())) {
				bmXML.append("<INFO id=\"jfinfo\" title=\"����˵��\">"
						+ ComputerRoomVWInfoListSup.get(0).getEidesc()
						+ "</INFO>");
			}
			if (configItem != null && configItem.size() != 0) {
				for (SOC0107Info cfitem : configItem) {
					if (cfitem.getCid().toString().equals(IGASMBLType.JFHEADER)) {
						bmXML.append("<INFO id=\"jfheader\" title=\"������\">"
								+ cfitem.getCivalue() + "</INFO>");
					}
					if (cfitem.getCid().toString().equals(IGASMBLType.JFTEL)) {
						bmXML.append("<INFO id=\"jftel\" title=\"��ϵ�绰\">"
								+ cfitem.getCivalue() + "</INFO>");
					}
				}
			}
			bmXML.append("</MESSAGE>");
		}

		bmXML.append("</ROOT>");
		out.print(bmXML.toString());
	}
	
	/**
	 * 
	 * ��÷�����Ϣ
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void getZoneInfo(HttpServletRequest req, PrintWriter out)
			throws Exception  {
		
		// ��ȡ����ID
		String zoneid = URLDecoder.decode(req.getParameter("zoneid"),
				"utf-8");

		
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		
		// ��ȡbaseMessageXML
		StringBuffer bmXML = new StringBuffer(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bmXML.append("<ROOT>");
		
		// ��ȡ����
		if (StringUtils.isNotEmpty(zoneid)) {
			CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
			ctcond.setCteiid(zoneid);
			List<CompareTemplateInfo> ctList = compareTemplateBL
					.searchCompareTemplate(ctcond, 0, 0);
			if (ctList != null && !ctList.isEmpty()) {
				for (CompareTemplateInfo ctbean : ctList) {
					bmXML.append("<MESSAGE id=\"" + ctbean.getCtpid().toString() + "\">");
					bmXML.append("<INFO id=\"jfid\" title=\"�������\">"
							+ ctbean.getCteiid() + "</INFO>");
					bmXML.append("<INFO id=\"jfname\" title=\"��������\">"
							+ ctbean.getCtName() + "</INFO>");
					bmXML.append("<INFO id=\"jfinfo\" title=\"����˵��\">"
							+ ctbean.getCtInfo() + "</INFO>");
					bmXML.append("</MESSAGE>");
				}
			}
		}

		bmXML.append("</ROOT>");
		out.print(bmXML.toString());
	}
	
	/**
	 * 
	 * ɾ������
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 */
	private void deleteZoneAndCabinet(HttpServletRequest req, PrintWriter out)
			throws Exception  {
		
		// ��ȡ����ID
		String zoneid = URLDecoder.decode(req.getParameter("zoneid"),
				"utf-8");
		//String jiguistr = req.getParameter("jiguistr");
		String flag = req.getParameter("flag");
		
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");

		if (StringUtils.isNotEmpty(zoneid)) {
			//��ȡ������ػ���ͼ��
			CompareTemplateSearchCondImpl jgcond = new CompareTemplateSearchCondImpl();
			jgcond.setCtZoneId(zoneid);
			List<CompareTemplateInfo> ctList = compareTemplateBL
					.searchCompareTemplate(jgcond, 0, 0);
			//ɾ������ʱ
			if("Y".equals(flag)){
				for(CompareTemplateInfo ctbean : ctList){
					if(ctbean.getCteiid()!=null){
						deleteCabinetById(ctbean.getCteiid());
					}
				}
			}else{//��ɾ������ʱ
				for(CompareTemplateInfo ctbean : ctList){
					CompareTemplateTB configItemTB = (CompareTemplateTB) SerializationUtils
							.clone(ctbean);
					configItemTB.setCtZoneId(null);
					compareTemplateBL.updateCompareTemplate(configItemTB);
				}
			}
			//ɾ������
			CompareTemplateSearchCondImpl ctcond = new CompareTemplateSearchCondImpl();
			ctcond.setCteiid(zoneid);
			List<CompareTemplateInfo> fqList = compareTemplateBL
					.searchCompareTemplate(ctcond, 0, 0);
			for(CompareTemplateInfo fqbean : fqList){
				compareTemplateBL.deleteCompareTemplateByPK(fqbean.getCtpid());
			}
		}
		
		out.print("ok");
	}
	
	/**
	 * 
	 * ��������
	 * 
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void changeAngle(HttpServletRequest req, PrintWriter out)
			throws BLException  {
		
		String ctid = req.getParameter("ctid");
		String cttype = req.getParameter("cttype");
		
		// ��ȡCompareTemplateBL
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");
		// ��������
		if (StringUtils.isNotEmpty(ctid)) {
			Integer id = Integer.parseInt(ctid);
			CompareTemplateInfo ctbean = compareTemplateBL.searchCompareTemplateByPK(id);
			CompareTemplateTB configItemTB = (CompareTemplateTB) SerializationUtils
					.clone(ctbean);
			configItemTB.setCttype(cttype);
			compareTemplateBL.updateCompareTemplate(configItemTB);
		}
		out.print("ok");
	}
    
    /**
     * ���ܣ�������ϼܵ������б�
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void getJiguiDetal(HttpServletRequest req,PrintWriter out,String jitype) throws BLException{
    	String  jiguiID = req.getParameter("jiguiID");
		if(jiguiID!=null){
			jiguiID = jiguiID.replaceAll("jiguiImg","");
		}
    	SOC0602SearchCondImpl cond = new SOC0602SearchCondImpl();
    	cond.setInJiguiFlg("Y");
    	if(jiguiID!=null){
    		cond.setContainer_eiid(Integer.parseInt(jiguiID));
    	}
		//��ǰҳ�豸��Ϣȡ��
    	SOC0602BL computerDeviceBL = (SOC0602BL)getBean("soc0602BL");
		List<SOC0602Info> computerDeviceVWInfoList = computerDeviceBL.searchSOC0602Info(cond,0,0);
		String cdType = "b1u";
		
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<ROOT>");
		sb.append("<ZHUJILIST>");
		if(computerDeviceVWInfoList!=null){
			for(SOC0602Info cdBean:computerDeviceVWInfoList){
				if(StringUtils.isNotEmpty(cdBean.getU_width())){
					if("1".equals(cdBean.getU_width())){
						cdType = "b1u";
					}else if("2".equals(cdBean.getU_width())){
						cdType = "b2u";
					}else if("3".equals(cdBean.getU_width())){
						cdType = "b3u";
					}else if("4".equals(cdBean.getU_width())){
						cdType = "b4u";
					}else if("5".equals(cdBean.getU_width())){
						cdType = "b5u";
					}else{
						cdType = cdBean.getU_width();
					}
				}
				sb.append("<img id=\"zhuji"+cdBean.getEiid()+"\" " +
						"type=\""+cdType+"\" " +
						"title=\""+cdBean.getEiname()+"\" " +
						"lightstype=\"" + getIndicatorLights(String.valueOf(cdBean.getEiid()))+"\" " + 
						"eilabel=\"" + getSN(cdBean.getEiid().toString())+"\" " + 
						" address=\""+cdBean.getU_value()+"\" />");
			}
		}
		if("0".equals(jitype)){
			//׷�ӻ�����Ϣ
			SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
			if(jiguiID!=null){
	    		eircond.setPareiid(Integer.parseInt(jiguiID));
	    	}
			eircond.setPareid(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER_EID);
			eircond.setCldeid(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER_EID);
			eircond.setDeleteflag("0");
			//����Eiid��ѯ���й�ϵ
			SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");
			List<SOC0119Info> entityItemRelationList = entityItemRelationBL.searchEntityItemRelation(eircond, 0, 0);
			if(entityItemRelationList!=null && entityItemRelationList.size()>0){
				for(SOC0119Info cdBean:entityItemRelationList){
					SOC0603BL computerContainerBL = (SOC0603BL)getBean("soc0603BL");
					SOC0603Info ccvw = computerContainerBL.searchSOC0603InfoByKey(cdBean.getCldeiid().toString());
					if(ccvw!=null && StringUtils.isNotEmpty(ccvw.getU_total())){
						if("7".equals(ccvw.getU_total())){
							cdType = "j7u";
						}else if("8".equals(ccvw.getU_total())){
							cdType = "j8u";
						}else if("9".equals(ccvw.getU_total())){
							cdType = "j9u";
						}else if("12".equals(ccvw.getU_total())){
							cdType = "j12u";
						}else{
							cdType = ccvw.getU_total();
						}
						sb.append("<img id=\"zhuji"+ccvw.getEiid()+"\" type=\""+cdType+"\" " +
								"title=\""+ccvw.getEiname()+"\" " +
								"lightstype=\"" + getIndicatorLights(String.valueOf(ccvw.getEiid()))+"\" " +
								"eilabel=\"" + getSN(ccvw.getEiid().toString())+"\" " + 
								"address=\""+ccvw.getU_value()+"\" />");
					}
				}
			}
		}
		
		sb.append("</ZHUJILIST>");
		sb.append("</ROOT>");
		out.print(sb.toString());
    }
    
	/**
	 * ���ܣ���λ�������ڻ���
	 * 
	 * @param req
	 * @param out
	 * @param requestMode
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	private void traceZhuJiLocation(HttpServletRequest req, PrintWriter out,
	        String zhuJiName,String zhuJiNum,String jiFangId) throws BLException {
	    try {
            zhuJiName = URLDecoder.decode(zhuJiName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("============�������============",e);
            out.print(StringUtils.EMPTY);
            return;
        }
	    
        SOC0602SearchCondImpl cond = new SOC0602SearchCondImpl();
        cond.setEiname(zhuJiName);
        cond.setEilabel(zhuJiNum);
        cond.setRoom_eiid(Integer.parseInt(jiFangId));
        // ��ǰҳ�豸��Ϣȡ��
        SOC0602BL computerDeviceBL = (SOC0602BL) getBean("soc0602BL");
        List<Object[]> computerDeviceVWInfoList = computerDeviceBL.findZhiJiLocation(cond);
        org.dom4j.Document document = DocumentHelper.createDocument();
        org.dom4j.Element root = document.addElement("ROOT");
        if (!computerDeviceVWInfoList.isEmpty()) {
            for (Object[] objects : computerDeviceVWInfoList) {
                org.dom4j.Element data = root.addElement("DATA");
                data.addElement("HOSTTITLE").addText(objects[0].toString());
                data.addElement("HOSTLABEL").addText(objects[1].toString());
                data.addElement("CABINETID").addText(objects[2].toString());
                data.addElement("CABINETTITLE").addText(objects[3].toString());
                data.addElement("CABINETLABEL").addText(objects[4].toString());
            }
            out.print(document.asXML());
        } else {
            out.print(StringUtils.EMPTY);
        }
	}
	
	/**
	 * ���ܣ���ѯ����U�ߣ����������ش��ڲ�ѯ�����Ļ�����Ϣ
	 * 
	 * @param req
	 * @param out
	 * @param requestMode
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	
	private void traceJiGuiLocation(HttpServletRequest req, PrintWriter out,
	        String jiFangId ,String U_High ,String power ,String load ) throws BLException {
       //����������
       String regex = "^[0-9]*[1-9][0-9]*$";
       
       //������벻�������������ؿ�
       if(!U_High.matches(regex)&&!(StringUtils.isEmpty(U_High))){
           out.print(StringUtils.EMPTY);
           return;
       }
       
       //������벻�������������ؿ�
       if(!power.matches(regex)&&!StringUtils.isEmpty(power)){
           out.print(StringUtils.EMPTY);
           return;
       }
       
       //������벻�������������ؿ�
       if(!load.matches(regex)&&!StringUtils.isEmpty(load)){
           out.print(StringUtils.EMPTY);
           return;
       }
	    
	    
	    SOC0603BL computerContainerBL = (SOC0603BL) getBean("soc0603BL");

	    SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
        cond.setRoom_eiid(Integer.parseInt(jiFangId));
        cond.setU_last(U_High);
        cond.setPower_last(power);
        cond.setLoad_last(load);
        List<SOC0603Info> soc0603Infos = computerContainerBL.searchSOC0603Info(cond);
	    
        org.dom4j.Document document = DocumentHelper.createDocument();
        org.dom4j.Element root = document.addElement("ROOT");
        if(!soc0603Infos.isEmpty()){
            for (SOC0603Info objects : soc0603Infos) {
                org.dom4j.Element data = root.addElement("DATA");
                data.addElement("CABINETTITLE").addText(objects.getEiname());
                data.addElement("CABINETLABEL").addText(objects.getEilabel());
                data.addElement("HEIGHTU").addText(objects.getU_last().toString());
                data.addElement("ELECTRICITY").addText(objects.getPower_last().toString());
                data.addElement("BEARING").addText(objects.getLoad_last().toString());
                data.addElement("CABINETID").addText(String.valueOf(objects.getEiid()));
            }
            out.print(document.asXML());
        } else {
            out.print(StringUtils.EMPTY);
        }
	}
	
	/**
	 * ���ܣ���ѯ�������ϸ��Ϣ������ʣ��Uλ������
	 * 
	 * @param req
	 * @param out
	 * @param requestMode
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	
	private void getJiGuiLastDetail(HttpServletRequest req, PrintWriter out,
	        String jiGuiName,String jiGuiNum,String jiFangId) throws BLException {
	 
	    try {
	        jiGuiName = URLDecoder.decode(jiGuiName, "utf-8");
	        jiGuiNum = URLDecoder.decode(jiGuiNum, "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("============�������============",e);
            out.print(StringUtils.EMPTY);
            return;
        }
	    
        SOC0603BL computerContainerBL = (SOC0603BL) getBean("soc0603BL");
        SOC0603SearchCondImpl cond = new SOC0603SearchCondImpl();
        cond.setEiname(jiGuiName);
        cond.setEilabel_like(jiGuiNum);
        cond.setRoom_eiid(Integer.parseInt(jiFangId));
        List<SOC0603Info> soc0603Infos = computerContainerBL.searchSOC0603Info(cond);
	    
        org.dom4j.Document document = DocumentHelper.createDocument();
        org.dom4j.Element root = document.addElement("ROOT");
        if(!soc0603Infos.isEmpty()){
            for (SOC0603Info objects : soc0603Infos) {
                org.dom4j.Element data = root.addElement("DATA");
                data.addElement("CABINETTITLE").addText(objects.getEiname());
                data.addElement("CABINETLABEL").addText(objects.getEilabel());
                data.addElement("HEIGHTU").addText(objects.getU_last().toString());
                data.addElement("ELECTRICITY").addText(objects.getPower_last().toString());
                data.addElement("BEARING").addText(objects.getLoad_last().toString());
                data.addElement("CABINETID").addText(String.valueOf(objects.getEiid()));
            }
            out.print(document.asXML());
        }else {
            out.print(StringUtils.EMPTY);
        }
	}
    
    /**
     * ���ܣ����������ϸ��Ϣ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void getZhujiDetail(HttpServletRequest req,PrintWriter out) throws BLException{
    	SOC0118BL entityItemBL = (SOC0118BL)getBean("soc0118BL");
    	SOC0107BL configItemBL = (SOC0107BL)getBean("soc0107BL");
    	String zhujiID = req.getParameter("zhujiID");
    	if(zhujiID!=null){
    		zhujiID = req.getParameter("zhujiID").replaceAll("zhuji","");
    	}

    	SOC0118Info zhujiEntity = entityItemBL.searchEntityItemByKey(Integer.parseInt(zhujiID));
		//��ǰ������Ϣȡ��
    	SOC0107SearchCondImpl ciCond = new SOC0107SearchCondImpl();
		if(StringUtils.isNotEmpty(zhujiID)){
			ciCond.setEiid(zhujiID);
		}
		ciCond.setCiversion(String.valueOf(zhujiEntity.getEiversion()));
		List<SOC0107Info> configItemList = configItemBL.searchSOC0107(ciCond, 0, 0);
		String zhujiSerial = ""; //�������к�
		String buyDate = "";  //��������
		String maintainDate = ""; //ά������
		
		StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		//���񱣴����λ����Ϣ
		if (configItemList!=null && configItemList.size()>0) {
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				if(EntityItemKeyWords.ENTITY_DEFAULT_SERIAL_NUMBER.equals(clabel)){
					zhujiSerial = item.getCivalue() == null ? "" : item.getCivalue();
				}else if(EntityItemKeyWords.ENTITY_DEFAULT_MAINTAIN_DATE.equals(clabel)){
					maintainDate = item.getCivalue() == null ? "" : item.getCivalue();
				}else if(EntityItemKeyWords.ENTITY_DEFAULT_PURCHASE_DATE.equals(clabel)){
					buyDate = item.getCivalue() == null ? "" : item.getCivalue();
				}
				
			}
		}
		sb.append("<ROOT>");
		if(EntityItemKeyWords.CONTAINER.equals(zhujiEntity.getEsyscoding())){
			sb.append("<ZHUJIDETAIL type='jijia'>");
		}else{
			sb.append("<ZHUJIDETAIL type='shebie'>");
		}
		String manager = zhujiEntity.getEiusername() == null ? "" : zhujiEntity.getEiusername();
		
		sb.append("<text title=\"�豸����:\"   value=\""+zhujiEntity.getEiname()+"\" />");
		sb.append("<text title=\"�豸���:\"   value=\""+zhujiEntity.getEilabel()+"\" />");
		sb.append("<text title=\"�Ǽ�����:\"   value=\""+zhujiEntity.getEiinsdate()+"\" />");
		sb.append("<text title=\"������Ա:\"   value=\""+manager+"\" />");
		sb.append("<text title=\"�� �� ��:\"    value=\""+zhujiSerial+"\" />");
		sb.append("<text title=\"��������:\"   value=\""+buyDate+"\" />");
		sb.append("<text title=\"ά������:\"   value=\""+maintainDate+"\" />");
		sb.append("</ZHUJIDETAIL>");
		sb.append("</ROOT>");
		out.println(sb.toString());
    }
    
    /**
     * ���ܣ�ȡ�û��������Ϣ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void getJiguiData(HttpServletRequest req,PrintWriter out) throws BLException{
    	String jiguiID = req.getParameter("jiguiID");
    	if(StringUtils.isNotEmpty(jiguiID)){
    		jiguiID = req.getParameter("jiguiID").replaceAll("jiguiImg","");
    	
    		SOC0603BL computerContainerBL = (SOC0603BL)getBean("soc0603BL");
    		SOC0603Info ccBean=computerContainerBL.searchSOC0603InfoByKey(jiguiID);
			StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			String voltage = ccBean.getVoltage()==null?"":ccBean.getVoltage();
			String weight = ccBean.getWeight()==null?"":ccBean.getWeight();
			String standard = ccBean.getStandard()==null?"":ccBean.getStandard();
			String type = "����";
			
			if ("1".equals(ccBean.getContainertype())) {
				type = "����";
			}
			
			sb.append("<ROOT>");
			sb.append("<JIGUIDETAIL>");
			sb.append("<text title=\""+ type +"����:\"   value=\""+ccBean.getEiname()==null?"":ccBean.getEiname()+"\" />");
			sb.append("<text title=\""+ type +"���:\"   value=\""+ccBean.getEilabel()==null?"":ccBean.getEilabel()+"\" />");
			sb.append("<text title=\""+ type +"�߶�:\"   value=\""+ccBean.getU_total()==null?"":ccBean.getU_total()+"\" />");
			sb.append("<text title=\""+ type +"˵��:\"   value=\""+ccBean.getEidesc()==null?"":ccBean.getEidesc()+"\" />");
			sb.append("<text title=\"���ѹ:\"   value=\""+voltage+"\" />");
			sb.append("<text title=\""+ type +"����:\"    value=\""+weight+"\" />");
			sb.append("<text title=\""+ type +"���:\"   value=\""+standard+"\" />");
			sb.append("</JIGUIDETAIL>");
			sb.append("</ROOT>");
			
			out.println(sb.toString());
    	}else{
    		out.println("");
    	}
    }
    /**
     * ���ܣ�ȡ�û���ƽ��ͼ��ѯ���������˵�
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void getSearchValue(HttpServletRequest req,PrintWriter out, String jitype) throws BLException{
		CodeDetailBL codeDetailBL = (CodeDetailBL)getBean("codeDetailBL");
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(IGSYM11BLType.ITEMS_TYPE_INFO);
		cond.setCdstatus("1");
		String returnValue="";
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cond,0);
		if(codeDetailList!=null){
			for(CodeDetail cdbean:codeDetailList){
				if("0".equals(jitype)){
					returnValue=returnValue+cdbean.getPsyscoding()+":"+cdbean.getCvalue()+"|";
				}else{
					if(!EntityItemKeyWords.CONTAINER.equals(cdbean.getPsyscoding())){
						returnValue=returnValue+cdbean.getPsyscoding()+":"+cdbean.getCvalue()+"|";
					}
				}
			}
		}
		returnValue =  returnValue.substring(0, returnValue.length()-1);
		out.println(returnValue);
    }

    /**
     * ���ܣ��ж������Ƿ�ı�
     * @param eiid
     * @param ciVersion
     * @param ciLabel
     * @param ciValue
     * @param entity
     * @throws BLException
     */
    private boolean isUpdateConfigFlg(List<SOC0107Info> configItemList,String ciLabel,String ciValue) throws BLException{
    	boolean isUpdateFlg = false;
		if (configItemList!=null && configItemList.size()>0) {
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				if(ciLabel.equals(clabel)){
					String olCivalue = item.getCivalue();
					if(ciValue==null){
						ciValue = "";
					}
					if(olCivalue==null){
						olCivalue= "";
					}
					if(olCivalue.equals(ciValue)){
						isUpdateFlg = true;
						break;
					}
				}
			}
		}else{
			return true;
		}
		return isUpdateFlg;
    }

    /**
     * ���ܣ������ø�����������Ϣ
     * @param req
     * @param out
     * @param requestMode 
     * @throws UnsupportedEncodingException 
     * @throws Exception 
     */
    
    private void updateJFConfig(List<SOC0107Info> configItemList,String ciLabel,String ciValue,SOC0117Info entity,String ciupdtime) throws BLException{
    	SOC0107BL configItemBL = (SOC0107BL)getBean("soc0107BL");
    	SOC0118BL entityItemBL = (SOC0118BL)getBean("soc0118BL");
    	SOC0119BL entityItemRelationBL = (SOC0119BL)getBean("soc0119BL");
    	Integer u_eiid = 0;
    	Integer u_eiversion = 0;
    	Integer u_smallversion = 0;
		//���񱣴����λ����Ϣ
    	if(configItemList!=null&&configItemList.size()>0){
			for (SOC0107Info item:configItemList) {
				String clabel = item.getConfiguration().getClabel();
				SOC0107TB configItemTB = (SOC0107TB) SerializationUtils.clone(item);
				configItemTB.setCiid(null);
				configItemTB.setCiversion(item.getCiversion() + 1);
				if(ciLabel.equals(clabel)){
					configItemTB.setCivalue(ciValue);
				}
				configItemTB.setCiupdtime(ciupdtime);
				SOC0107Info configItem = configItemBL.registSOC0107(configItemTB);
				u_eiid = configItem.getEiid();
				u_eiversion = item.getCiversion();
				u_smallversion = item.getCismallversion();
				
				//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
				if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){

					String str = configItem.getCivalue();	
					SOC0118Info ei = new SOC0118TB(); 
					Integer eiid = Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)); 
					try{
						ei = entityItemBL.searchEntityItemByKey(eiid);
						//У���ϵ�Ƿ����
						SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
						eirCond.setEirinfo(configItem.getEiid()+"_"+item.getCiid()+"_"+ei.getEiid());
						eirCond.setEirstatus("C");
						eirCond.setDeleteflag("0");
						eirCond.setParversion(item.getCiversion());//�ʲ���汾
						eirCond.setParsmallversion(item.getCismallversion());//�ʲ�С�汾
						
						List<SOC0119Info> eirlist = entityItemRelationBL.searchMaxEntityItemRelation(eirCond);
						if(eirlist.size() != 1) {
							throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
						} else {
							SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
							eirTB.setEirid(null);
							eirTB.setEirupdtime(IGStringUtils.getCurrentDateTime());
							eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + item.getCiid() + "_", "_" + configItem.getCiid() + "_"));
							eirTB.setParversion(configItem.getCiversion());
							eirTB.setParsmallversion(configItem.getCismallversion());
							entityItemRelationBL.registEntityItemRelation(eirTB);
						}
					}catch(Exception ex){
						log.warn("��ģʽ��ϵ��Ϣ�д��ڵ��ʲ�eiid���ʲ����в����ڡ�eiid:"+eiid);
					}
				}
			}
			
			//�ʲ���ϵ��Ϣ�汾��������
	    	entityItemRelationBL.upgradeEntityItemRelationByJiFang(u_eiid, u_eiversion,u_smallversion,u_eiversion+1, 0);
    	}
    }

    /**
     * �жϷ�������Ƿ����
     * @param req
     * @param out
     * @param requestMode
     */
    protected void checkEntityItemByKey(HttpServletRequest req, PrintWriter out) {
		IG013BL entityItemBL = (IG013BL)getBean("ig013BL");
		String roomID = req.getParameter("roomID");
		
		//������Ϣȡ�� 
		IG013SearchCondImpl cond = new IG013SearchCondImpl();
		cond.setEilabel(roomID);
		
		//��ǰ������Ϣȡ��
		List<IG013Info> entityItemList = entityItemBL.searchIG013Info(cond);
		if (entityItemList != null && !entityItemList.isEmpty()) {
			out.print("nook");
	    	}else {
	    		out.print("ok");
	    	}
	    }
    /**
	 * IGSYM0419��Աѡ�д���
	 * @param req 
	 * @param out PrintWriter
	 * @param eiid
	 */
	@SuppressWarnings("unchecked")
	protected void selectUserItem(HttpServletRequest req, PrintWriter out, String urids, String clicktype) throws BLException {
		
		//�ʲ�ID����
		Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectUser");
		
		if(set == null) {
			set = new LinkedHashSet<String>();
			req.getSession().setAttribute("ADSelectUser",set);
		}
		
		if(clicktype != null && "del".equals(clicktype)) {//���ѡ�� 
			set.remove(urids);
			log.debug("��ԱID��" + urids + "�����");
		} else if(clicktype != null && "add".equals(clicktype)){//ѡ��
			set.add(urids);
			log.debug("��ԱID����" + urids + "��ѡ��");
		} else {
			log.error("��Ч����");
		}
		
		out.print("1");
	}
	
	/**
	 * ����״̬��ѯ���ж���İ�ť
	 * @param req
	 * @param out
	 * @param pauid
	 * @throws BLException
	 */
	protected void searchButtonList(HttpServletRequest req,
			PrintWriter out,String psdid) throws BLException {
		//���� ��ťID����ťԭʼ����
		Map<String, String> map = new HashMap<String, String>();
		//���� ��ťID
		List<String> idList = new ArrayList<String>();
		
		//����״̬ID��ѯ���в����ߵ������Ѷ���İ�ť
		IG222BL processParticipantDefBL = (IG222BL) getBean("ig222BL");
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPsdid(psdid);
		List<IG222Info> lstPpdef = processParticipantDefBL.searchIG222Info(cond);
		for(IG222Info def : lstPpdef){
			List<IG132TB> buttonDefTB = def.getProcessParticipantButtonDefList();
			for(IG132TB buttonTB : buttonDefTB){
				//���˵��Ѿ����ڵİ�ť
				if(!map.containsKey(buttonTB.getPbdid())){
					map.put(buttonTB.getPbdid(), buttonTB.getPpbdname());
					idList.add(buttonTB.getPbdid());
				}
			}
		}
		//����״̬ID��ѯȱʡ�¶���İ�ť
		IG725BL participantDefaultButtonDefBL = (IG725BL)getBean("ig725BL");
		IG725SearchCondImpl condImpl = new IG725SearchCondImpl();
		condImpl.setPsdid(psdid);
		List<IG725Info> lstdefaultDef = participantDefaultButtonDefBL.searchIG725Info(condImpl);
		for(IG725Info info : lstdefaultDef){
			//���˵��Ѿ����ڵİ�ť
			if(!map.containsKey(info.getPbdid())){
				map.put(info.getPbdid(), info.getPdbdname());
				idList.add(info.getPbdid());
			}
		}
		
		//����ťID
		Collections.sort(idList);
		StringBuffer buf = new StringBuffer("");
		if(idList.size() > 0){
			for(String id : idList){
				buf.append(id).append("#").append(map.get(id)).append(";");
			}
		}
		out.print(buf.toString().length() == 0 ? "" : buf.toString().substring(0, buf.toString().length()-1));
	}
	
	/**
     * ������(�������仯���±�����ֵ�仯)
     * @param req 
     * @param out PrintWriter
     * 
     */
    protected void searchValue(HttpServletRequest req, PrintWriter out) throws BLException {
        
        String ret ="";//�����ķ���ֵ
        
        String objvalue = req.getParameter("objvalue");//ȡ����������ֵ
        
        String initiativepidid = req.getParameter("initiativepidid");//ȡ��������ID
        
        // ͨ������id���ڱ��������У�ȡ�ñ���ID�͵��õ�bl����
        IG286BL processLinkageBL = (IG286BL) getBean("ig286BL");
        IG286SearchCondImpl cond = new IG286SearchCondImpl();
        cond.setInitiativepidid(initiativepidid);
        List<IG286Info> processLinkageDefList  = processLinkageBL.searchIG286Info(cond,0,0);
        
        //����bl��ȡ�ñ�������ֵ
        if(processLinkageDefList != null && processLinkageDefList.size()>0){
            for(int i=0; i<processLinkageDefList.size(); i++){
                IG286Info linkapage = processLinkageDefList.get(i);
                String passivitypidid = "pidid" + linkapage.getPassivitypidid();//ƴ��ǰ̨�����ϱ�������id
                String blname = linkapage.getPlblname();//ȡ�õ���bl������
                String returnValue = "";
                if(blname != null && !"".equals(blname)){
                    WorkFlowLinkageHandlerBL workFlowLinkageHandlerBL = (WorkFlowLinkageHandlerBL)getBean(blname);
                    igflowlog.debug("========================�������¼���ʼ========================");
                    igflowlog.debug("���������ƣ�" + linkapage.getInitiativepidname());
                    igflowlog.debug("���������ƣ�" + linkapage.getPassivitypidname());
                    igflowlog.debug("������ֵ��" + objvalue);
                    igflowlog.debug("����BL��" + blname);
                    String passivitypididvalue = workFlowLinkageHandlerBL.linkageExecute(objvalue);
                    //ƴ�ӷ���ֵ ���򣺱�����A |������A��ֵ # ������B |������B��ֵ
                    returnValue =passivitypidid + "|" + passivitypididvalue;
                    igflowlog.debug("������ֵ��" + returnValue);
                    igflowlog.debug("========================�������¼�����========================");                    
                }
                
                if(i>0){
                    ret = ret + "#" + returnValue; 
                }else{
                    ret = returnValue;
                }
            }
        }
        
        out.print(ret);
    }
	
	/**
	 * �����Զ�������id�Ͱ�ťid��ȡ������id
	 * @param req 
	 * @param out PrintWriter
	 * 
	 */
	protected void searchObjectForCheck(HttpServletRequest req, PrintWriter out) throws BLException {
        
		String ret ="";//�����ķ���ֵ
		
		String pdid = req.getParameter("pdid");//ȡ�����Զ�������id
		String btnid = req.getParameter("btnid");//ȡ�ð�ťid

		
		// ͨ�����Զ�������id�Ͱ�ťid��ȡ������id
		IG286BL ig286BL = (IG286BL) getBean("ig286BL");
		IG286SearchCondImpl cond = new IG286SearchCondImpl();
		cond.setPldactionid(btnid);
		cond.setPldpdid(pdid);
		List<IG286Info> processLinkageDefList  = ig286BL.searchIG286Info(cond,0,0);
		
		//����bl��ȡ�ñ�������ֵ
		if(processLinkageDefList != null && processLinkageDefList.size()>0){
			for(int i=0; i<processLinkageDefList.size(); i++){
				IG286Info linkapage = processLinkageDefList.get(i);
				String passivitypidid = "pidid" + linkapage.getPassivitypidid();//ƴ��ǰ̨�����ϱ�������id
				String initiativepidid = "pidid" + linkapage.getInitiativepidid();//ƴ��ǰ̨�����ϱ�������id
				String blname =linkapage.getPlblname();//У��ʹ�õ�bl����
				//ƴ�ӷ���ֵ ����bl���� |������ID |������ID # bl���� |������ID |������ID
			    String returnValue =blname + "|" + initiativepidid + "|" + passivitypidid ;
			    if(i>0){
			    	ret = ret + "#" + returnValue; 
			    }else{
			    	ret = returnValue;
			    }
			}
		}
		
		out.print(ret);
	}
	
	/**
     * ���ݴ����ֵ�����չ̶�����У��
     * @param req 
     * @param out PrintWriter
     * 
     */
    protected void checkLinkage(HttpServletRequest req, PrintWriter out) throws BLException {
        
        String ret ="";//�����ķ���ֵ
        
        String blname = req.getParameter("blname");//ȡ��bl����
        String initiativeValue = req.getParameter("initiativeValue");//ȡ��������ֵ
        String passivityValue = req.getParameter("passivityValue");//ȡ�ôӱ���ֵ
        
        if(blname != null && !"".equals(blname)){
            WorkFlowLinkageHandlerBL workFlowLinkageHandlerBL = (WorkFlowLinkageHandlerBL)getBean(blname);
            igflowlog.debug("========================������У�鴦�������ʼ========================");
            igflowlog.debug("������ֵ��" + initiativeValue);
            igflowlog.debug("�ӱ���ֵ��" + passivityValue);
            igflowlog.debug("����BL��" + blname);
            //���У��ʧ�ܷ���ʧ�ܵ���Ϣcode�����򷵻�ֵΪ�մ�
            ret = workFlowLinkageHandlerBL.checkLinkageExecute(initiativeValue, passivityValue);
            igflowlog.debug("========================������У�鴦���������========================");
        }
        if(ret != null && !"".equals(ret)){
            MessageResources message=getResources(req);
            ret=message.getMessage(ret);
        }
         
        
        out.print(ret);
    }
	/**
	 * ���ܣ���ά�洢����ƽ̨
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */

    protected void getRequestModeForSOCEMC(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {
     	//����BL
		IGDBS01BL ctlBL = (IGDBS01BL) getBean("igDBS01BL");
		IGDBS01DTO dto = new IGDBS01DTO();
		
		//20120704���� �澯��ʾ
		if("WarningType".equals(requestMode)){
			SOC0305BL storageEventBL =(SOC0305BL) getBean("soc0305BL");
			String resxml = "";
			List<SOC0305Info> list=storageEventBL.searchSoc0305(new SOC0305SearchCondImpl(), 0, 30);
			if(list.size()>0){
				for (int i = 0; i < list.size(); i++) {
					resxml+="<DG>";
					resxml+="<STORAGE>"+list.get(i).getEirootmark()+"</STORAGE>";//�洢id
					resxml+="<TYPE>"+(list.get(i).getAlarmType().equals("1")?"Event":"Performance")+"</TYPE>";//�澯����
					String detectiontime="";
					detectiontime=list.get(i).getDetectiontime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					
						try {
							detectiontime=sdf.format(sdf.parse(detectiontime));
						} catch (ParseException e) {
							e.printStackTrace();
						}
					
					resxml+="<WETIME>"+detectiontime+"</WETIME>";//�澯ʱ��
					resxml+="<WELV>"+list.get(i).getSeverity()+"</WELV>";//�澯�ȼ�
					resxml+="</DG>";
				}
			}
			out.print(resxml);
		}

		//ҵ���������
		if ("BusinessRus".equals(requestMode)) {
			String resxml = "";
			resxml = ctlBL.getBusinessRus(dto).getBusinessRus();
			out.print(resxml);
		}
		
		//iops������
		if ("iops".equals(requestMode)) {
			String resxml = "";
			dto.setSymmid(req.getParameter("id"));
			dto.setHostchoose(req.getParameter("choose"));
			resxml = ctlBL.getIOPSandThroughput1(dto).getIopsThroughput();
			out.print(resxml);
		}
		
		//��д������
		if ("readwrite".equals(requestMode)) {
			String resxml = "";
			dto.setSymmid(req.getParameter("id"));
			dto.setHostchoose(req.getParameter("choose"));
			String symm_type=ctlBL.getIOPSandThroughput1(dto).getSymm_type();
			if(StringUtils.isNotEmpty(symm_type)){
				if("CX".equalsIgnoreCase(symm_type)){
				resxml = ctlBL.getIOPSandThroughputCX(dto).getReadperWriteperHitper();
				}else{
				resxml = ctlBL.getReadperWriteperHitper1(dto).getReadperWriteperHitper();
				}
			}else{
				resxml = ctlBL.getReadperWriteperHitper1(dto).getReadperWriteperHitper();
			}
			out.print(resxml);
		}
		
		//������Ϣ
		if ("hostinfo".equals(requestMode)) {
			String resxml = "";
			dto.setSymmid(req.getParameter("id"));
			dto.setHostchoose(req.getParameter("choose"));
			String host = req.getParameter("host");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);	
			if("host1".equals(host)){					
				req.getSession().setAttribute(user.getUserid()+"host1", req.getParameter("id"));
				req.getSession().setAttribute(user.getUserid()+"type1", req.getParameter("choose"));	

		
			}else if("host2".equals(host)){
				req.getSession().setAttribute(user.getUserid()+"host2", req.getParameter("id"));
				req.getSession().setAttribute(user.getUserid()+"type2", req.getParameter("choose"));	
			}
            
			resxml = ctlBL.getHostInfo1(dto).getHostInfo();
			out.print(resxml);
		}

		//����KPI
		if ("ProcessKPI".equals(requestMode)) {
			String resxml = "";
			//resxml = ctlBL.getProcessKPI(dto).getProcessKPI();
			out.print(resxml);
		}
	}
    /**
	 * ���ܣ���ά�洢����ƽ̨
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @author baiyanfu_20120301_��ҳDashBoard����
	 * @throws Exception 
	 */
    protected void getRequestModeForSOCEMCA(HttpServletRequest req,
			PrintWriter out, String requestMode) throws BLException {
    	//����BL
		IGDBS01BL ctlBL = (IGDBS01BL) getBean("igDBS01BL");
		IGDBS01DTO dto = new IGDBS01DTO();

		//ҵ���������
		if ("BusinessRus".equals(requestMode)) {
			String resxml = "";
			resxml = ctlBL.getBusinessRus(dto).getBusinessRus();
			out.print(resxml);
		}
		
		//iops������
		if ("iops".equals(requestMode)) {
			String resxml = "";
			dto.setSymmid(req.getParameter("id"));
			dto.setHostchoose(req.getParameter("choose"));
			resxml = ctlBL.getIOPSandThroughput2(dto).getIopsThroughput();
			out.print(resxml);
		}
		
		//��д������
		if ("readwrite".equals(requestMode)) {
			String resxml = "";
			dto.setSymmid(req.getParameter("id"));
			dto.setHostchoose(req.getParameter("choose"));
			String symm_type=ctlBL.getIOPSandThroughput2(dto).getSymm_type();
			if(StringUtils.isNotEmpty(symm_type)){
				if("CX".equalsIgnoreCase(symm_type)){
				resxml = ctlBL.getIOPSandThroughputCX(dto).getReadperWriteperHitper();
				}else{
				resxml = ctlBL.getReadperWriteperHitper2(dto).getReadperWriteperHitper();
				}
			}else{
				resxml = ctlBL.getReadperWriteperHitper2(dto).getReadperWriteperHitper();
			}
			out.print(resxml);
		}
		
		//������Ϣ
		if ("hostinfo".equals(requestMode)) {
			String resxml = "";
			dto.setSymmid(req.getParameter("id"));
			dto.setHostchoose(req.getParameter("choose"));
			String host = req.getParameter("host");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);	
			if("host1".equals(host)){					
				req.getSession().setAttribute(user.getUserid()+"host1", req.getParameter("id"));
				req.getSession().setAttribute(user.getUserid()+"type1", req.getParameter("choose"));	

		
			}else if("host2".equals(host)){
				req.getSession().setAttribute(user.getUserid()+"host2", req.getParameter("id"));
				req.getSession().setAttribute(user.getUserid()+"type2", req.getParameter("choose"));	
			}
            
			resxml = ctlBL.getHostInfo2(dto).getHostInfo();
			out.print(resxml);
		}

		//����KPI
		if ("ProcessKPI".equals(requestMode)) {
			String resxml = "";
			//resxml = ctlBL.getProcessKPI(dto).getProcessKPI();
			out.print(resxml);
		}
	}
    //������� 
    //Բ��(�����洢)��ʾ
    protected void getPieSingle(HttpServletRequest req,PrintWriter out) throws BLException {
		//20120704
    		SOC0411BL storageCapacityRealTimeBL=(SOC0411BL)getBean("soc0411BL");
    		SOC0428BL businessCapacityRealTimeVWBL =(SOC0428BL)getBean("soc0428BL");
    		SOC0429BL hostCapacityRealTimeVWBL=(SOC0429BL)getBean("soc0429BL");
			String ssid="";
			double remain=0.0;//ʣ��ٷֱ�
			double remian_value=0.0;//ʣ��ֵ
			SOC0411SearchCondImpl cond_s=new SOC0411SearchCondImpl();
			SOC0428SearchCondImpl cond_b=new SOC0428SearchCondImpl();
			if(req.getParameter("SSID")!=null){
				ssid=req.getParameter("SSID");
			}
			cond_s.setSName(ssid);
			cond_b.setSName(ssid);
			List<SOC0411Info> list_s=storageCapacityRealTimeBL.searchSOC0411(cond_s);
			List<SOC0428Info> list_b=businessCapacityRealTimeVWBL.searchSOC0428(cond_b);
			String pieXmlStr="";

			if(list_s.size()>0 && list_b.size()>0){
				double sigStorage=list_s.get(0).getEffectiveCapacity();
				pieXmlStr+="<?xml version='1.0' encoding='utf-8'?>";
				pieXmlStr+="<ROOT>";
				pieXmlStr+="<DATA value='pie@eff:#"+mBToTB(sigStorage,2)+" (TB)#pie@disknum:#      "+list_s.get(0).getDiskCount()+"' >";
				for(int i = 0; i < list_b.size(); i++){
					pieXmlStr+="<STORAGE name='"+list_b.get(i).getBcid()+"' "+
					"label='"+list_b.get(i).getBcName()+"' "+
					"text='pie@bcname:"+list_b.get(i).getBcName()+"#pie@alloc: "+mBToTB(list_b.get(i).getAllottedCapacity(),2)+" TB#"+"' "+
					"pietext='"+SVCHelper.round(SVCHelper.getDivide(list_b.get(i).getAllottedCapacity(), sigStorage)*100, 2) +"%'>";
					remian_value+=list_b.get(i).getAllottedCapacity();
					remain+=SVCHelper.round(SVCHelper.getDivide(list_b.get(i).getAllottedCapacity(), sigStorage)*100, 2);
					SOC0429SearchCondImpl cond_h=new SOC0429SearchCondImpl();
					cond_h.setSName_eq(list_b.get(i).getSName());
					cond_h.setBcName_eq(list_b.get(i).getBcName());
					cond_h.setBcId_eq(list_b.get(i).getBcid());
					List<SOC0429Info> list_h=hostCapacityRealTimeVWBL.searchSOC0429(cond_h);
						for (int j = 0; j < list_h.size(); j++) {
							if(list_b.get(i).getBcName().equals(list_h.get(j).getBcName())){
								pieXmlStr+="<VOLUME category='HostName' value='"+Double.valueOf(mBToTB(list_b.get(i).getAllottedCapacity(),2))/list_h.size()+"' text='host.hostname:"+list_h.get(j).getHostName()+"#pie@alloc:"+mBToTB(list_h.get(j).getAllottedCapacity(),2)+"(TB)"+"#pie@free:"+mBToTB(list_h.get(j).getFreeCapacity(),2)+"(TB)"+"' />";
							}
						}
						pieXmlStr+="</STORAGE>";
				}
				if(remain < 100.0){//����ʣ��
					pieXmlStr+="<STORAGE name='-1' "+
					"label='"+"pie@bsr"+"' "+
					"text='    pie@seer    ' "+
					"pietext='"+SVCHelper.round((100-remain),2)+"%'>";
					pieXmlStr+="<VOLUME category='FreeCap' value='"+mBToTB((sigStorage-remian_value),2)+"' text='pie@free:"+mBToTB((sigStorage-remian_value),2)+"(TB)' />";
					pieXmlStr+="</STORAGE>";
				}
				pieXmlStr+="</DATA>";
				pieXmlStr+="</ROOT>";
			}
			out.print(pieXmlStr);
    }
    //��ѯҵ��ϵͳ��host list
    protected void showHostList(HttpServletRequest req,PrintWriter out) throws BLException {
		//20120705 ���������б���ʾ
    		SOC0429BL hostCapacityRealTimeVWBL=(SOC0429BL)getBean("soc0429BL");
			List<SOC0429Info> list_h=null;
			int bcid=0;
			String ssid="";
			String bcName_eq="";
			String hostXml="";
			if(req.getParameter("bcid")!=null && req.getParameter("SSID")!=null && req.getParameter("bcName")!=null){//����ҵ��ϵͳ id name ssn
				bcid=Integer.parseInt(req.getParameter("bcid"));
				ssid=req.getParameter("SSID");
				bcName_eq=req.getParameter("bcName");
			}
			if(bcid!=0 && !"".equals(ssid) &&!"".equals(bcName_eq)){
				SOC0429SearchCondImpl cond=new SOC0429SearchCondImpl();
				cond.setBcId_eq(bcid);
				cond.setBcName_eq(bcName_eq);
				cond.setSName_eq(ssid);
				list_h=hostCapacityRealTimeVWBL.searchSOC0429(cond);
				for (int i = 0; i < list_h.size(); i++) {
					hostXml+="<DG>";
					hostXml+="<HOST>"+list_h.get(i).getHostName()+"</HOST>";
					hostXml+="<SIZE>"+mBToGB(list_h.get(i).getAllottedCapacity(),2)+"</SIZE>";
					hostXml+="</DG>";
				}
			}
			out.print(hostXml);
    }
    //��ʾlunid xml
    protected void showHostLUNID(HttpServletRequest req,PrintWriter out) throws BLException {
		//20120710 Host��LUNID��ʾ
			SOC0409BL pvHostRealTimeBL=(SOC0409BL)getBean("soc0409BL");
			String hostName="";
			String sName="";
			String lunIDXml="";
			SOC0409SearchCondImpl cond=null;
			int temInterval=0;
			int lastlunNum=9999;
			int location=1;
			String startLun="";
			String endLun="";
			int prevLunSize=0;//��һ��lunSize
			int lunTypeCount=0;
			if(req.getParameter("hostName")!=null && req.getParameter("sName")!=null){
				hostName=req.getParameter("hostName");
				sName=req.getParameter("sName");
			}
			if(!"".equals(req.getParameter("hostName")) && !"".equals(req.getParameter("SSID")) && !"-1".equals(req.getParameter("hostName"))){
				cond=new SOC0409SearchCondImpl();
				cond.setHostName_eq(hostName);
				cond.setSName_eq(sName);
				
				List<SOC0409Info> list_pv=pvHostRealTimeBL.searchSOC0409(cond);
				if(list_pv.size()>0){
					lunIDXml+="<DG>";
					lunIDXml+="<LUNID>Total Count:"+list_pv.size()+"</LUNID>";
					lunIDXml+="</DG>";
					for (int i = 0; i < list_pv.size(); i++) {
						SOC0409Info obj=list_pv.get(i);
 						String lunid=obj.getLunid();//lunid
						int lunNum=Integer.valueOf(lunid,16) ;//����lunidתΪ10����
						int val=lunNum-lastlunNum;  //���μ�ȥ�ϴΣ����Ĳ�
						int lunSize=obj.getPvSize();//����lunSize
						//����Ϊ����Ĭ��
						if(lastlunNum==0){
							//lastlunNum=lunNum;
						}
						if("".equals(startLun)){
							startLun=lunid;
						}
						if("".equals(endLun)){
							endLun=lunid;
						}
						if(i==list_pv.size()-1){//���һ����
							if(location>1){//�Ƿ����ָ��
								if(temInterval==val&&prevLunSize==lunSize){//�������ж��Ƿ���ڼ��
									endLun=lunid;
									lunTypeCount++;
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
								}else{//�����ڴ�ӡ2��
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
									startLun=lunid;
									endLun=lunid;
									lunTypeCount=1;
									prevLunSize=lunSize;
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
								}
							}else{
								if((val==1||val==2||val==4||val==6||val==8)&&lunSize==prevLunSize){
									
									lunTypeCount++;
									temInterval=val;
									endLun=lunid;
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
									
								}else{
									if(i>0){
										lunIDXml+="<DG>";
										lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
										lunIDXml+="</DG>";
									}
									prevLunSize=lunSize;
									startLun=lunid;
									endLun=lunid;
									lunTypeCount=1;
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
								}
							}
						}else if(temInterval==val&&prevLunSize==lunSize){
							
						}else {
							if(location>2){
								lunIDXml+="<DG>";
								lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
								lunIDXml+="</DG>";
								startLun=lunid;
								location=0;
								lunTypeCount=0;
							}else {
								if(val!=1&&val!=2&&val!=4&&val!=6&&val!=8){
									if(lastlunNum!=lunNum){
										if(i>0){
										if(temInterval==1||temInterval==2||temInterval==4||temInterval==6||temInterval==8){
											if(startLun.equals(endLun)){
												temInterval=0;
											}
											lunIDXml+="<DG>";
											lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
											lunIDXml+="</DG>";
											
										}else{
											lunIDXml+="<DG>";
											lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
											lunIDXml+="</DG>";
										}
										startLun=lunid;
										location=0;
										lunTypeCount=0;
										}
									}
								}else{
									if(prevLunSize!=lunSize){
										if(temInterval==1||temInterval==2||temInterval==4||temInterval==6||temInterval==8){
											if(startLun.equals(endLun)){
												temInterval=0;
											}
											lunIDXml+="<DG>";
											lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
											lunIDXml+="</DG>";
											
										}else{
											lunIDXml+="<DG>";
											lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
											lunIDXml+="</DG>";
										}
										startLun=lunid;
										location=0;
										lunTypeCount=0;
									}
								}
							}
						}
						prevLunSize=lunSize;
						temInterval=val;
						lastlunNum=lunNum;
						endLun=lunid;
						location++;
						lunTypeCount++;
					}//for end
				}//if list.size end
			}// if req.p==null
			if("-1".equals(req.getParameter("hostName")) && req.getParameter("sName")!=null){//����δʹ�õ�LUNID
				List<SOC0410Info> list_pvs=null;
				SOC0410BL pvStorageRealTimeBL =(SOC0410BL)getBean("soc0410BL");
				lunIDXml="";
				SOC0410SearchCondImpl cond_pvs=new SOC0410SearchCondImpl();
				cond_pvs.setSName_eq(req.getParameter("sName"));
				cond_pvs.setIsUsed_eq("0");
				list_pvs=pvStorageRealTimeBL.searchSOC0410(cond_pvs);
				if(list_pvs.size()>0){
					lunIDXml+="<DG>";
					lunIDXml+="<LUNID>Total Count:"+list_pvs.size()+"</LUNID>";
					lunIDXml+="</DG>";
					for (int i = 0; i < list_pvs.size(); i++) {
						SOC0410Info obj=list_pvs.get(i);
						String lunid=obj.getLunid();//lunid
						int lunNum=Integer.valueOf(lunid,16) ;//����lunidתΪ10����
						int val=lunNum-lastlunNum;  //���μ�ȥ�ϴΣ����Ĳ�
						int lunSize=obj.getPvSize();//����lunSize
						//����Ϊ����Ĭ��
						if(lastlunNum==0){
							//lastlunNum=lunNum;
						}
						if("".equals(startLun)){
							startLun=lunid;
						}
						if("".equals(endLun)){
							endLun=lunid;
						}
						if(i==list_pvs.size()-1){//���һ����
							if(location>1){//�Ƿ����ָ��
								if(temInterval==val&&prevLunSize==lunSize){//�������ж��Ƿ���ڼ��
									endLun=lunid;
									lunTypeCount++;
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
								}else{//�����ڴ�ӡ2��
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
									startLun=lunid;
									endLun=lunid;
									lunTypeCount=1;
									prevLunSize=lunSize;
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
								}
							}else{
								if((val==1||val==2||val==4||val==6||val==8)&&lunSize==prevLunSize){
									lunTypeCount++;
									temInterval=val;
									endLun=lunid;
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
									
								}else{
									if(i>0){
										lunIDXml+="<DG>";
										lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
										lunIDXml+="</DG>";
									}
									prevLunSize=lunSize;
									startLun=lunid;
									endLun=lunid;
									lunTypeCount=1;
									lunIDXml+="<DG>";
									lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									lunIDXml+="</DG>";
								}
							}
						}else if(temInterval==val&&prevLunSize==lunSize){
							
						}else {
							if(location>2){
								lunIDXml+="<DG>";
								lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
								lunIDXml+="</DG>";
								startLun=lunid;
								location=0;
								lunTypeCount=0;
							}else {
								if(val!=1&&val!=2&&val!=4&&val!=6&&val!=8){
									if(lastlunNum!=lunNum){
										if(i>0){
										if(temInterval==1||temInterval==2||temInterval==4||temInterval==6||temInterval==8){
											if(startLun.equals(endLun)){
												temInterval=0;
											}
											lunIDXml+="<DG>";
											lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
											lunIDXml+="</DG>";
											
										}else{
											lunIDXml+="<DG>";
											lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
											lunIDXml+="</DG>";
										}
										startLun=lunid;
										location=0;
										lunTypeCount=0;
										}
									}
								}else{
									if(prevLunSize!=lunSize){
										if(temInterval==1||temInterval==2||temInterval==4||temInterval==6||temInterval==8){
											if(startLun.equals(endLun)){
												temInterval=0;
											}
											lunIDXml+="<DG>";
											lunIDXml+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
											lunIDXml+="</DG>";
											
										}else{
											lunIDXml+="<DG>";
											lunIDXml+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
											lunIDXml+="</DG>";
										}
										startLun=lunid;
										location=0;
										lunTypeCount=0;
									}
								}
							}
						}
						prevLunSize=lunSize;
						temInterval=val;
						lastlunNum=lunNum;
						endLun=lunid;
						location++;
						lunTypeCount++;
					}//for end
				}//if list.size end
			}
			out.print(lunIDXml);
    }
    //��ʾhost�� vg xml
    protected void showHostVG(HttpServletRequest req,PrintWriter out) throws BLException {
		//20120706 Host��VG��ʾ
    		SOC0419BL vgCapacityRealTimeBL=(SOC0419BL)getBean("soc0419BL");
			String hostName="";
			String vgXml="";
			SOC0419SearchCondImpl cond=null;
			if(req.getParameter("hostName")!=null){
				hostName=req.getParameter("hostName");
			}
			if(!"".equals(hostName)){
				cond=new SOC0419SearchCondImpl();
				cond.setHostName_eq(hostName);
				List<SOC0419Info> list_vg=vgCapacityRealTimeBL.searchSOC0419(cond);
				if(list_vg.size()>0){
					vgXml+="<?xml version='1.0' encoding='utf-8'?>";
					vgXml+="<ROOT>";
					vgXml+="<DATA name='"+list_vg.get(0).getHostName()+"'>";
					SOC0405BL lvCapacityRealTimeBL=(SOC0405BL)getBean("soc0405BL");
					SOC0405SearchCondImpl condlv=new SOC0405SearchCondImpl();
					condlv.setHostName_eq(hostName);
					condlv.setFsName_neq("");
					condlv.setLvType_ne("raw");
					List<SOC0405Info> list_fs=null;
					for (int j = 0; j < list_vg.size(); j++) {
						vgXml+="<SERVER name='"+list_vg.get(j).getVgName()+"'>";
						vgXml+="<ALLOCATION name='AllocCap' value='"+mBToGB(list_vg.get(j).getAllottedCapacity(),2)+"'/>";
						vgXml+="<USE name='UsedCap' value='"+mBToGB(list_vg.get(j).getUsedCapacity(),2)+"' usedpercent ='"+SVCHelper.round(SVCHelper.getDivide(list_vg.get(j).getUsedCapacity(), list_vg.get(j).getAllottedCapacity())*100 , 1)+"' />";
						condlv.setVgName_eq(list_vg.get(j).getVgName());
						list_fs=lvCapacityRealTimeBL.searchSOC0405(condlv);
						if(list_fs.size()==0){
							vgXml+="<CLICKENABLE clickenable='no' />";//�Ƿ��ܵ��
						}else{
							vgXml+="<CLICKENABLE clickenable='ok' />";
						}
						vgXml+="</SERVER>";
					}
					vgXml+="</DATA>";
					vgXml+="</ROOT>";
				}
			}
			out.print(vgXml);
    }
    //��ʾvg�� ts xml mod 2012-08-20 mon
    protected void showVGTS(HttpServletRequest req,PrintWriter out) throws BLException {
		//20120706 VG��TS��ʾ
			SOC0415BL tsCapacityRealTimeBL=(SOC0415BL)getBean("soc0415BL");
			String tsXml="";
			String tsTitleXml="";
			String hostName="";
			List<String> dbNameArr=new ArrayList<String>();
			double totalAlloc=0.0;
			double totalUsed=0.0;
			SOC0415SearchCondImpl cond=null;
			if(req.getParameter("hostName")!=null){
				hostName=req.getParameter("hostName");
			}
			if(!hostName.equals("")){
				cond=new SOC0415SearchCondImpl();
				cond.setHostName_eq(hostName);
				List<SOC0415Info> list_ts=tsCapacityRealTimeBL.searchSOC0415(cond);//ȫ�� ȡ��dbnames
				for (int i = 0; i < list_ts.size(); i++) {
					if(i==0){dbNameArr.add(list_ts.get(i).getDbName());}
					if(i+1==list_ts.size()){break;}
					if(!list_ts.get(i).getDbName().equals(list_ts.get(i+1).getDbName())){//x
						dbNameArr.add(list_ts.get(i+1).getDbName());
					};
				}
				if(dbNameArr.size()>0){
					//tt
					for (int j = 0; j < dbNameArr.size(); j++) {
						tsTitleXml+="<TT>";
						tsTitleXml+="<DBTS>"+dbNameArr.get(j)+"</DBTS>";
						for (int i = 0; i < list_ts.size(); i++) {
							if(dbNameArr.get(j).equals(list_ts.get(i).getDbName())){
								totalAlloc=SVCHelper.getAdd(totalAlloc, list_ts.get(i).getAllottedCapacity());
								totalUsed=SVCHelper.getAdd(totalUsed, list_ts.get(i).getUsedCapacity());
								tsXml+="<TS>";
								tsXml+="<DBTS>"+list_ts.get(i).getTsName()+"</DBTS>";
								tsXml+="<SIZE>"+mBToGB(list_ts.get(i).getAllottedCapacity(),2)+"</SIZE>";
								tsXml+="<USE>"+mBToGB(list_ts.get(i).getUsedCapacity(),2)+"</USE>";
								tsXml+="<Percent>"+SVCHelper.round((SVCHelper.getDivide(list_ts.get(i).getUsedCapacity(), list_ts.get(i).getAllottedCapacity())*100), 2)+"</Percent>";
								tsXml+="</TS>";
							}
						}
						tsXml+="@";//@�ָ�ÿ��ts
						tsTitleXml+="<SIZE>"+mBToGB(totalAlloc,2)+"</SIZE>";
						tsTitleXml+="<USE>"+mBToGB(totalUsed,2)+"</USE>";
						tsTitleXml+="<Percent>"+SVCHelper.round((SVCHelper.getDivide(totalUsed, totalAlloc)*100), 2)+"</Percent>";
						tsTitleXml+="</TT>";
						tsTitleXml+="@";//@�ָ�ÿ������
					}
				}
			}
			out.print(tsTitleXml+"$"+tsXml);//$�ָ� title��ts
    }
    //��ʾvg�� fs xml
    protected void showVGFS(HttpServletRequest req,PrintWriter out) throws BLException {
		//20120706 VG��FS��ʾ
    		SOC0405BL lvCapacityRealTimeBL=(SOC0405BL)getBean("soc0405BL");
			String fsXml="";
			String hostName="";
			String vgName="";
			SOC0405SearchCondImpl cond=null;
			if(req.getParameter("hostName")!=null && req.getParameter("vgName")!=null){
				hostName=req.getParameter("hostName");
				vgName=req.getParameter("vgName");
			}
			if(!"".equals(hostName) && !"".equals(vgName)){
				cond=new SOC0405SearchCondImpl();
				cond.setHostName_eq(hostName);
				cond.setFsName_neq("");//���˷�fs
				cond.setVgName_eq(vgName);
				cond.setLvType_ne("raw");//��raw����fs
				List<SOC0405Info> list_fs=lvCapacityRealTimeBL.searchSOC0405(cond);
				if(list_fs.size()>0){
					fsXml+="<?xml version='1.0' encoding='utf-8'?>";
					fsXml+="<ROOT>";
					fsXml+="<DATA name='"+list_fs.get(0).getVgName()+"'>";
					for (int i = 0; i < list_fs.size(); i++){
						fsXml+="<SERVER name='"+list_fs.get(i).getFsName()+"'>";
						fsXml+="<ALLOCATION name='AllocCap' value='"+mBToGB(list_fs.get(i).getAllottedCapacity(),2)+"'/>";
						fsXml+="<USE name='UsedCap' value='"+mBToGB(list_fs.get(i).getUsedCapacity(),2)+"' usedpercent ='"+SVCHelper.round(SVCHelper.getDivide(list_fs.get(i).getUsedCapacity(), list_fs.get(i).getAllottedCapacity())*100,2)+"' />";
						fsXml+="<CLICKENABLE clickenable='no' />";
						fsXml+="</SERVER>";
					}
					fsXml+="</DATA>";
					fsXml+="</ROOT>";
				}
			}
			out.print(fsXml);
    }
    //lv�澯
    private void showLVWarning(HttpServletRequest req,PrintWriter out){
    	SOC0405BL lvCapacityRealTimeBL=(SOC0405BL)getBean("soc0405BL");
    	SOC0405SearchCondImpl cond=new SOC0405SearchCondImpl();
    	String LVDataXml="";
    	String hasAlert="0$";
    	cond.setHostName_eq(req.getParameter("hostName"));
    	cond.setLvType_eq("raw");
    	cond.setLvState_eq("C");
    	List<SOC0405Info> list_closed=lvCapacityRealTimeBL.searchSOC0405(cond);
    	cond.setLvState_eq(null);
    	List<SOC0405Info> list_all=lvCapacityRealTimeBL.searchSOC0405(cond);
    	double tmp_all=0.0;
    	double tmp_closed=0.0;
    	if(list_all.size()>0 && list_closed.size()>0){
    		for (int i = 0; i < list_all.size(); i++) {
    			tmp_all=SVCHelper.getAdd(tmp_all, list_all.get(i).getLvSize());
    		}
    	}
    	if(list_closed.size()>0){
    		for (int i = 0; i < list_closed.size(); i++) {
    			tmp_closed+=list_closed.get(i).getLvSize();
    			LVDataXml+="<DG>";
    			LVDataXml+="<LVNAME>"+list_closed.get(i).getLvName()+"</LVNAME>";
    			LVDataXml+="<LVSIZE>"+list_closed.get(i).getLvSize()+"</LVSIZE>";
    			LVDataXml+="<ALOCCAP>"+list_closed.get(i).getAllottedCapacity()+"</ALOCCAP>";
    			LVDataXml+="<FREECAP>"+list_closed.get(i).getFreeCapacity()+"</FREECAP>";
    			LVDataXml+="<USEDCAP>"+list_closed.get(i).getUsedCapacity()+"</USEDCAP>";
    			LVDataXml+="<VGNAME>"+list_closed.get(i).getVgName()+"</VGNAME>";
    			LVDataXml+="<FSNAME>"+list_closed.get(i).getFsName()+"</FSNAME>";
    			LVDataXml+="</DG>";
    		}
    		double res=SVCHelper.getDivide(tmp_closed, tmp_all);
    		if(0.10>res){//closed֮��/lvsize total С�ڰٷ�֮10 LV�澯
    			hasAlert="1$";
    		}
    	}
    	out.print(hasAlert+LVDataXml);
    }
    //vio remain lunid
    private void showVIOLUNID(HttpServletRequest req,PrintWriter out){
    	SOC0434BL pvVIOBL=(SOC0434BL)getBean("soc0434BL");
    	String vioXmlStr="";
    	String sname=req.getParameter("sName");
    	String vioName=req.getParameter("vioName");
    	SOC0434SearchCondImpl cond=new SOC0434SearchCondImpl();
    	cond.setIsUsed("0");//unused
    	cond.setSName(sname);
    	cond.setSN(vioName);

		int temInterval=0;
		int lastlunNum=9999;
		int location=1;
		String startLun="";
		String endLun="";
		int prevLunSize=0;//��һ��lunSize
		int lunTypeCount=0;
    	List<SOC0434Info> list_vio=pvVIOBL.searchPVVIO(cond);
    	if(list_vio.size()>0){
			String lunid="";
			vioXmlStr+="<DG>";
			vioXmlStr+="<LUNID>TotalCount:"+list_vio.size()+"</LUNID>";
			vioXmlStr+="</DG>";
			for (int i = 0; i < list_vio.size(); i++) {
				SOC0434Info obj=list_vio.get(i);
				lunid=obj.getLUNID();//lunid
				int lunNum=Integer.valueOf(lunid,16) ;//����lunidתΪ10����
				int val=lunNum-lastlunNum;  //���μ�ȥ�ϴΣ����Ĳ�
				int lunSize=obj.getPVSIZE();//����lunSize
				//����Ϊ����Ĭ��
				if(lastlunNum==0){
					//lastlunNum=lunNum;
				}
				if("".equals(startLun)){
					startLun=lunid;
				}
				if("".equals(endLun)){
					endLun=lunid;
				}
				if(i==list_vio.size()-1){//���һ����
					if(location>1){//�Ƿ����ָ��
						if(temInterval==val&&prevLunSize==lunSize){//�������ж��Ƿ���ڼ��
							endLun=lunid;
							lunTypeCount++;
							vioXmlStr+="<DG>";
							vioXmlStr+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
							vioXmlStr+="</DG>";
						}else{//�����ڴ�ӡ2��
							vioXmlStr+="<DG>";
							vioXmlStr+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
							vioXmlStr+="</DG>";
							startLun=lunid;
							endLun=lunid;
							lunTypeCount=1;
							prevLunSize=lunSize;
							vioXmlStr+="<DG>";
							vioXmlStr+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
							vioXmlStr+="</DG>";
						}
					}else{
						if((val==1||val==2||val==4||val==6||val==8)&&lunSize==prevLunSize){
							
							lunTypeCount++;
							temInterval=val;
							endLun=lunid;
							vioXmlStr+="<DG>";
							vioXmlStr+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
							vioXmlStr+="</DG>";
							
						}else{
							if(i>0){
								vioXmlStr+="<DG>";
								vioXmlStr+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
								vioXmlStr+="</DG>";
							}
							prevLunSize=lunSize;
							startLun=lunid;
							endLun=lunid;
							lunTypeCount=1;
							vioXmlStr+="<DG>";
							vioXmlStr+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
							vioXmlStr+="</DG>";
						}
					}
				}else if(temInterval==val&&prevLunSize==lunSize){
					
				}else {
					if(location>2){
						vioXmlStr+="<DG>";
						vioXmlStr+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
						vioXmlStr+="</DG>";
						startLun=lunid;
						location=0;
						lunTypeCount=0;
					}else {
						if(val!=1&&val!=2&&val!=4&&val!=6&&val!=8){
							if(lastlunNum!=lunNum){
								if(i>0){
								if(temInterval==1||temInterval==2||temInterval==4||temInterval==6||temInterval==8){
									if(startLun.equals(endLun)){
										temInterval=0;
									}
									vioXmlStr+="<DG>";
									vioXmlStr+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									vioXmlStr+="</DG>";
									
								}else{
									vioXmlStr+="<DG>";
									vioXmlStr+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									vioXmlStr+="</DG>";
								}
								startLun=lunid;
								location=0;
								lunTypeCount=0;
								}
							}
						}else{
							if(prevLunSize!=lunSize){
								if(temInterval==1||temInterval==2||temInterval==4||temInterval==6||temInterval==8){
									if(startLun.equals(endLun)){
										temInterval=0;
									}
									vioXmlStr+="<DG>";
									vioXmlStr+="<LUNID>"+startLun+":"+endLun+"("+temInterval+"/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									vioXmlStr+="</DG>";
									
								}else{
									vioXmlStr+="<DG>";
									vioXmlStr+="<LUNID>"+startLun+":"+endLun+"(0/"+lunTypeCount+"/"+prevLunSize+")"+"</LUNID>";
									vioXmlStr+="</DG>";
								}
								startLun=lunid;
								location=0;
								lunTypeCount=0;
							}
						}
					}
				}
				prevLunSize=lunSize;
				temInterval=val;
				lastlunNum=lunNum;
				endLun=lunid;
				location++;
				lunTypeCount++;
			}//for end
		}//if list.size end
    	out.print(vioXmlStr);
	}
    private String mBToTB(double d,int scale){
    	double tmp=d;
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.round(tmp, scale);
    	return String.valueOf(tmp);
    }    
    private String mBToTB(int d,int scale){
    	double tmp=d;
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.round(tmp, scale);
    	return String.valueOf(tmp);
    }    
    private String mBToGB(int d,int scale){
    	double tmp=d;
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.round(tmp, scale);
    	return String.valueOf(tmp);
    }    
	private String mBToGB(double d,int scale){
    	double tmp=d;
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.round(tmp, scale);
    	return String.valueOf(tmp);
	}
	//������� end
	   /**
     * ��ȡ�澯��ϸ��Ϣ
     * @param req
     * @param out
     * @param parameter
     * @param parameter2
     */
    private void getEventInfo(HttpServletRequest req, PrintWriter out,
			String id) throws BLException {
    	SOC0305BL storageEventBL=(SOC0305BL)getBean("soc0305BL");
    	String storageEventInfo="";
    	SOC0305SearchCondImpl cond=new SOC0305SearchCondImpl();
    	cond.setId(id);
		List<SOC0305Info> storageEventList = storageEventBL.searchSoc0305(cond);
		if(storageEventList!=null&&storageEventList.size()>0){
			SOC0305Info storageEvent = storageEventList.get(0);
			//�澯��Ϣ
			storageEventInfo=storageEvent.getEirootmark()+","+storageEvent.getEiImportProgrammeTB().getImpTypename()
			+","+storageEvent.getDetectiontime()+","+storageEvent.getSrc()
			+","+storageEvent.getErrornum()+","+storageEvent.getDir()
			+","+storageEvent.getCategory()+","+storageEvent.getSeverity()
			+","+storageEvent.getErrordesc()+","+storageEvent.getLparnam();
		}
		out.print(storageEventInfo);
	}
    /**
     * ��ȡ��ϸDMXRealTime����
     * @param req
     * @param out
     * @param requestMode
     * @author wangxudong@deliverik.com
     */
    @SuppressWarnings("deprecation")
	protected void getRequestModeForDMXRealTime(HttpServletRequest req,HttpServletResponse res,PrintWriter out,String requestMode)throws BLException{
    	SOC0304BL monitorTaskBL =(SOC0304BL)getBean("soc0304BL");
    	SOC0301BL dmxRealTimeBL =(SOC0301BL)getBean("soc0301BL");

    	//��ʼ����������
    	if("initCurveDate".equals(requestMode)){
    		StringBuilder sb=new StringBuilder();
    		log.debug("initCurveDate ��ʼ");
    		int mtId=Integer.parseInt(req.getParameter("mtId"));
    		//��ȡ�������ж�������
    		SOC0304Info info=monitorTaskBL.searchSoc0304ByPK(mtId);
    		String objNames=info.getMtObjNames();
    		//��ѯ��������
    		SOC0301SearchCondImpl cond=new SOC0301SearchCondImpl();
    		cond.setMtId_eq(mtId);
    		//��ѯ���ݽ��
    		List<SOC0301Info> rtList=dmxRealTimeBL.searchSoc0301OrderByTimeAndName(cond);
    		String[] objArr=null;
    		//�ж��Ƿ�Ϊnull
    		if(objNames!=null&&!"".equals(objNames)){
    			objArr=objNames.split(",");
    		}else{
    			objArr=new String[]{"SYS"};
    		}
    		if(rtList!=null && rtList.size()>0){
    			for (int i = 0; i < objArr.length; i++) {
					for (int j = 0; j < rtList.size(); j++) {
						SOC0301Info drtInfo=rtList.get(j);
						if(drtInfo!=null){
							String objName=drtInfo.getMtoName();
							if((objName.equalsIgnoreCase(objArr[i]))||objName==null||"".equals(objName)){
//								int index=j/objArr.length;
//								int lastList=rtList.size()/objArr.length-1;
//								if(index!=lastList){
									sb.append(drtInfo.getTimeStamp()).append(",").append(drtInfo.getKpiValue()).append("|");
//								}else{
//									sb.append(drtInfo.getTimeStamp()).append(",").append(drtInfo.getKpiValue());
//								}
							}
						}
					}
					if(sb.toString().length()>0){
						sb.deleteCharAt(sb.length()-1);
					}
					if(i!=objArr.length-1){
						sb.append("=");
					}
    			}
    		}
    		out.print(sb.toString());
    		log.debug("initCurveDate ����");
    		
    	}
    	if("clrData".equals(requestMode)){//ȡ��ʵʱ����
    		log.debug("clrData ��ʼ");
    		List<SOC0301Info> list=null;
    		int mtid=0;
    		if(req.getParameter("MtId")!=null){
    			mtid=Integer.parseInt(req.getParameter("MtId"));
    			SOC0301SearchCondImpl cond=new SOC0301SearchCondImpl();
    			cond.setMtId_eq(mtid);
    			list=dmxRealTimeBL.searchSoc0301(cond);
    			if(list!=null&&list.size()>0){
    				for (int i = 0; i < list.size(); i++) {						
    					dmxRealTimeBL.deleteSoc0301(list.get(i));
					}
    			}    			
    			log.debug("clrData ����");
    			out.print("");
    		}else{
    			out.print("");
    		}
    	}else if("Mtinterval".equals(requestMode)){//ȡ�ü��
    		log.debug("ȡ�ü����ʼ");
    		int mtid=0;
    		if(req.getParameter("MtId")!=null){
    			mtid=Integer.parseInt(req.getParameter("MtId"));
    			SOC0304Info info=monitorTaskBL.searchSoc0304ByPK(mtid);
    			out.print(info.getMtInterval());//���ؼ��
    			log.debug("ȡ�ü������");
    		}else{
    			out.print("");
    		}
    	}else if("Mtstoptime".equals(requestMode)){//���ùر�ʱ�䣨��ʱ��
    		log.debug("���ùر�ʱ�俪ʼ");
    		int mtid=0;
    		if(req.getParameter("MtId")!=null){
    			mtid=Integer.parseInt(req.getParameter("MtId"));
    			SOC0304Info info=monitorTaskBL.searchSoc0304ByPK(mtid);
    			SOC0304TB tb=(SOC0304TB) SerializationUtils.clone(info);
    			if(!StringUtils.isEmpty(info.getMtPStopTime()) && req.getParameter("IsExitFlag").equals("1")){    				
    				tb.setMtStopTime(new Date().toLocaleString().substring(0, 10).replace("-", "/")+req.getParameter("StopTime"));
    			}else{
    				tb.setMtStopTime("");    				
    			}
    			if(!StringUtils.isEmpty(info.getMtPStopTime())){
    				tb.setMtPStopTime(new Date().toLocaleString().substring(0, 10).replace("-", "/")+req.getParameter("StopTime"));
    			}
    			
    			monitorTaskBL.updateSoc0304(tb);
    			out.print(tb.getMtStopTime());//���ؽ���ʱ��
    			log.debug("���ùر�ʱ������");
    		}else{
    			out.print("");
    		}
    	}else if("MtStatus".equals(requestMode)){//����״̬���رգ�
    		log.debug("���ùر�״̬��ʼ");
    		int mtid=0;//����
    		String tmpstatus="1";//0Ϊ����״̬ 1Ϊ�ر�״̬
    		if(req.getParameter("MtId")!=null && req.getParameter("MtStatus")!=null){
    			mtid=Integer.parseInt(req.getParameter("MtId"));
    			tmpstatus=req.getParameter("MtStatus");
    			SOC0304Info info=monitorTaskBL.searchSoc0304ByPK(mtid);
    			SOC0304TB tb=(SOC0304TB) SerializationUtils.clone(info);
    			tb.setMtStatus("1");//���ùر�
    			monitorTaskBL.updateSoc0304(tb);
    			out.print(tmpstatus);//����״̬
    			log.debug("���ùر�״̬����");
    		}else{
    			out.print("");
    		}
    	}else if("getInfo".equals(requestMode)){//ȡ�����ssn,kpi��mtpstoptime
    		int mtid=0;
    		if(req.getParameter("MtId")!=null){
    			mtid=Integer.parseInt(req.getParameter("MtId"));
    			SOC0304Info info=monitorTaskBL.searchSoc0304ByPK(mtid);
    			if(info!=null){
    				String objNameStr=info.getMtObjNames();
    				if(objNameStr==null||"".equals(objNameStr)){
    					objNameStr="SYS";
    				}
    				String mt=info.getMtSsn()+","+info.getMtKpi()+","+info.getMtPStopTime()+"<"+objNameStr;
    				out.print(mt);//����ssn,kpi,mtpstoptime<���󼯺�
    			}
    		}else{
    			out.print("");
    		}
    	}else if("Export_Report".equals(requestMode)){//��������
    		log.debug("�������� Ԥ��");
    		
    		//Ԥ������������
    	}else{    		
    		out.print("");
    	}
    }
    /**
     * ���ü���ӳ�ʱ��*******
     * @param req
     * @param out
     * @param parameter
     * @param parameter2
     */
    private void getSetMtPstoptime(HttpServletRequest req, PrintWriter out,
			String mtid) throws BLException {
    	String pTime="";
    	if(mtid!=null&&!"".equals(mtid)){
    		try {
    			Properties s=this.getProperties();
				//��ѯ����
    			IGMNT01BL igmnt01bl=(IGMNT01BL) getBean("igmnt01BL");
    			SOC0304BL soc0304BL=(SOC0304BL) getBean("soc0304BL");
    			SOC0304Info monitorTaskInfo=soc0304BL.searchSoc0304ByPK(Integer.parseInt(mtid));
    			SOC0304TB monitorTaskTB=(SOC0304TB) SerializationUtils.clone(monitorTaskInfo);
				//��ȡֹͣʱ��
				//String dateStr=monitorTaskInfo.getMtPStopTime();
				Calendar curcal=Calendar.getInstance();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				//ʱ��ת��
				//Date date=sdf.parse(dateStr);
//				Calendar cal=Calendar.getInstance();
//				cal.setTime(date);
				//����ʱ��
				Integer interVal=Integer.parseInt(s.getProperty("MONITOR_TASK_INTERVAL"));
				curcal.add(Calendar.SECOND, interVal);
				String pStopTime=sdf.format(curcal.getTime());
				pTime=pStopTime;
				//�������
				monitorTaskTB.setMtPStopTime(pStopTime);
				monitorTaskTB.setMtRecordTime("");//fix ��ʱʧЧbug
				monitorTaskTB.setMtStatus("0");//fix ���񲻹ر�bug����flash����
				soc0304BL.updateSoc0304(monitorTaskTB);
				//����ģ�������
				igmnt01bl.createBat(monitorTaskTB.getMtSsn(), monitorTaskTB.getMtId()+"", 
						monitorTaskTB.getMtCname(), monitorTaskTB.getMtKpi(), 
						monitorTaskTB.getMtInterval(), monitorTaskTB.getMtNum());
				igmnt01bl.createParseBat(monitorTaskTB.getMtId()+"");
    		} catch (Exception e) {
				log.error("======���ü���ӳ�ʱ���ӳ�����========");
			}
    	}
		out.print(pTime);
	}
    /**
     * ƴkpi�ַ���
     * @param kpiList
     * @param info
     * @return
     */
	private StringBuffer getKPIString(List<CodeDetail> kpiList,StringBuffer info){
    	for (int i = 0; i < kpiList.size(); i++) {
			CodeDetail cd=kpiList.get(i);
			if(i!=kpiList.size()-1){
				info.append(cd.getCid()+","+cd.getCvalue()).append(";");
			}else{
				info.append(cd.getCid()+","+cd.getCvalue()+".");
			}
		}
    	return info;
    }
    /**
     * ƴʱ��������
     * @param valList
     * @param info
     * @return
     */
    private StringBuffer getVALString(List<CodeDetail> valList,StringBuffer info){
    	for (int i = 0; i < valList.size(); i++) {
			CodeDetail cd=valList.get(i);
			if(i!=valList.size()-1){
				info.append(cd.getCid()+","+cd.getCvalue()).append(";");
			}else{
				info.append(cd.getCid()+","+cd.getCvalue()+".");
			}
		}
    	return info;
    }
    /**
	 *DMXREALTIME����Ӧ����Դ�ļ�
	 */
	private Properties getProperties() throws BLException {
		//CI����Ӧ����Դ�ļ�
		Properties properties = null;
		//������
		FileInputStream inputFile = null;
		//���������ļ�
		try {
			properties = new Properties();
			inputFile = new FileInputStream(ResourceUtility.getString("DMX_REALTIME_FILE_PATH"));
			properties.load(inputFile);
		} catch (FileNotFoundException e) {
			log.error("DMXREALTIME����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGASM2001.E001");
		} catch (IOException e) {
			log.error("DMXREALTIME����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGASM2001.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("DMXREALTIME����Ӧ����Դ�ļ���ȡ����", e);
					throw new BLException("IGASM2001.E001");
				}
			}
		}
		return properties;
	}
    /**
     * �����˵���ȡ��Ϣ
     * @param req
     * @param out
     * @param parameter
     * @param parameter2
     */
    private void getMonitorMsg(HttpServletRequest req, PrintWriter out,
			String cid,String mtSSn) throws BLException {
    	//�����ַ���
    	StringBuffer info=new StringBuffer();
    	CodeDetailBL codeDetailBL=(CodeDetailBL) getBean("codeDetailBL");
    	Object_ListBL object_ListBL=(Object_ListBL) getBean("object_ListBL");
    	//��ȡ���������
    	CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
    	cond.setCid(cid);
    	cond.setCcid(IGMntConstantDefine.COMPONENT_TYPE_CODE);
    	List<CodeDetail> cList=codeDetailBL.searchCodeDetail(cond, 2);
    	if(cList!=null&&cList.size()>0){
    		String syscoding=cList.get(0).getSyscoding();
    		//��ȡ��������
    		String fieldKpiName=syscoding.toUpperCase()+"_KPI_CODE";
    		String fieldValName=syscoding.toUpperCase()+"_VAL_CODE";
    		//��ȡ���������ֵ
    		String kpiCcid=IGMntConstantDefine.getValue(fieldKpiName);
    		String valCcid=IGMntConstantDefine.getValue(fieldValName);
    		CodeDetailSearchCondImpl kpicond=new CodeDetailSearchCondImpl();
    		kpicond.setCcid(kpiCcid);
    		//�Ȳ�ѯKPI
    		List<CodeDetail> kpiList=codeDetailBL.searchCodeDetail(kpicond, 1);
    		CodeDetailSearchCondImpl valcond=new CodeDetailSearchCondImpl();
    		//����ʱ����
    		valcond.setCcid(valCcid);
    		//�ٲ�ʱ����
    		List<CodeDetail> valList=codeDetailBL.searchCodeDetail(valcond, 1);
    		//Ȼ��ƴ�ַ���,��ƴ����
    		getKPIString(kpiList,info);
    		//��ƴʱ����
    		getVALString(valList,info);
    		//���ƴĬ��
    		//����ʱ����Ĭ��
    		String intervalDefault=IGMntConstantDefine.INTERVAL_DEFAULT;
    		String[] defArr=intervalDefault.split(",");
    		boolean isHave=false;
    		if(defArr!=null){
    			for (int i = 0; i < defArr.length; i++) {
					if(syscoding.equalsIgnoreCase(defArr[i])){
						isHave=true;
						for (int j = 0; j < valList.size(); j++) {
							if(valList.get(j).getSyscoding().equalsIgnoreCase(IGMntConstantDefine.INTERVAL_DEFAULT_VAL)){
								info.append(valList.get(j).getCid());
							}
						}
					}
				}
    			if(!isHave){
	    			for (int j = 0; j < valList.size(); j++) {
						if(valList.get(j).getSyscoding().equalsIgnoreCase(IGMntConstantDefine.INTERVAL_DEFAULT_OTHER_VAL)){
							info.append(valList.get(j).getCid());
						}
					}
    			}
    		}
    		//��ѯ��ض���
    		//��ѯ���󼯺�����
    		Object_ListSearchCondImpl olcond=new Object_ListSearchCondImpl();
    		olcond.setDataId(mtSSn);
    		String mtcname=IGMntConstantDefine.getValue(syscoding.toUpperCase());
    		olcond.setObject_Type(mtcname);
    		//��ѯ���󼯺�
    		List<Object_ListInfo> olInfoList=object_ListBL.searchObject_List(olcond);
    		//����
    		if(olInfoList!=null){
    			info.append(":");
    			for (int i = 0; i < olInfoList.size(); i++) {
    				Object_ListInfo olInfo=olInfoList.get(i);
					if(i==(olInfoList.size()-1)){
						info.append(olInfo.getObject_Name());
					}else{
						info.append(olInfo.getObject_Name()).append(",");
					}
				}
    		}
    	}
		out.print(info.toString());
	}
	protected void getKPI(HttpServletRequest req, PrintWriter out,
			String parameter) {
		StringBuffer ret = new StringBuffer();
		if(StringUtils.isNotEmpty(parameter)){
			MonitorTypeDefBL mtdBL = (MonitorTypeDefBL) getBean("monitorTypeDefBL");
			MonitorTypeDefSearchCondImpl mtdCond=new MonitorTypeDefSearchCondImpl();
			mtdCond.setMtId(parameter);
			List<MonitorTypeDefInfo> monitorTypeDefList = mtdBL.searchMonitorTypeDef(mtdCond);
			for (MonitorTypeDefInfo monitorTypeDefInfo : monitorTypeDefList) {
				String mtdName = monitorTypeDefInfo.getMtdName();
				String mtdValue = monitorTypeDefInfo.getMtdValue();
				String compare = monitorTypeDefInfo.getCompare();
				String mtdDes = monitorTypeDefInfo.getMtdDes();
				String deleteFlag = monitorTypeDefInfo.getDeleteFlag();
				ret.append(mtdName+"|"+mtdValue+"|"+compare+"|"+mtdDes+"|"+deleteFlag+",");
			}
		}
		out.print(ret.toString());
	}
    /**
     * ���¸澯����״̬	0:δ����	1:�Ѵ���
     * @param req
     * @param out
     * @param parameter
     */
    private void updateStorageEventStatus(HttpServletRequest req,
			PrintWriter out, String id) throws BLException{
    	SOC0305BL soc0305BL=(SOC0305BL)getBean("soc0305BL");
    	SOC0305TB storageEvent = (SOC0305TB)soc0305BL.searchSoc0305ByPK(Integer.valueOf(id));
    	storageEvent.setStatus("1");
    	soc0305BL.updateSoc0305(storageEvent);
    }
	
    /**
     * �����Զ����ĵ�
     * @param req
     * @param out
     * @param parameter
     */
    private void generateCustomDoc(HttpServletRequest req,
			PrintWriter out) throws BLException{
    	User user = (User) req.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
    	String dataid=req.getParameter("dataid");
		String kpi=req.getParameter("kpi");
		String checkboxs=req.getParameter("checkboxs");
		String dateFrom=req.getParameter("dateFrom");
		String dateTo=req.getParameter("dateTo");
		String timeFrom=req.getParameter("timeFrom");
		String timeTo=req.getParameter("timeTo");
		String timetype=req.getParameter("timetype");
		String compareData=req.getParameter("compareData");
		String mode=req.getParameter("mode");
		String device=req.getParameter("device");
		String userName=user.getUsername();
		String raName=req.getParameter("raName");
		CustomBirtReportImport customBirtReportImport=new CustomBirtReportImport();
		int status=customBirtReportImport.runBirtReportImport(dataid, kpi, checkboxs, dateFrom, dateTo, timeFrom, timeTo, timetype, compareData, mode, device, userName, raName);
		out.print(status);
    }
    
    /**
     * ��ȡ�Զ������ģ��select,����rtDateType
     * @param req
     * @param out
     */
    protected void ajaxType_getTemDateType(HttpServletRequest req,
			PrintWriter out)throws BLException {
    	log.debug("��ѯģ��select��ʼ");
    	String rtId=req.getParameter("rtId");
    	//��ȡBL
    	SOC0207BL soc0207BL =(SOC0207BL)getBean("soc0207BL");
    	SOC0207Info soc0207Info = soc0207BL.searchSOC0207ByPK(Integer.parseInt(rtId));
    	if(soc0207Info!=null){
    		out.print(soc0207Info.getRtDateType());
    	}
    	log.debug("��ѯģ��select����");
    }
    
    /**
     * �Զ��屨��������� ����ɾ��
     */
	private void delMyChoiceRCL(HttpServletRequest req, PrintWriter out)throws BLException{
		int idtemp=0;
		if(req.getParameter("Id")!=null){
			idtemp=Integer.parseInt(req.getParameter("Id"));
			if(idtemp>0){
				SOC0204BL soc0204BL=(SOC0204BL)getBean("soc0204BL");
				soc0204BL.deleteSOC0204ByPK(idtemp);
				out.print(true);
			}
		}else{
			out.print(false);
		}
	}
	
	/**
     * �����Զ��屨������
     */
	private void addReportCustomLink(HttpServletRequest req,PrintWriter out)throws BLException{
		String returnStr="";
		String rclReportType=req.getParameter("rclReportType");//��������
		String rclObjName=req.getParameter("rclObjName");//��������
		String objType=req.getParameter("objType");//��������
		String rclCaType=req.getParameter("rclCaType");
		String rclTemName=req.getParameter("rclTemName");
		String rclTemDesc=req.getParameter("rclTemDesc");
		String rclTemTitle=req.getParameter("rclTemTitle");
		String mode=req.getParameter("mode");
		String eiid=req.getParameter("eiid");
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		SOC0204BL soc0204BL=(SOC0204BL) getBean("soc0204BL");
		//��ȥ��ѯ,������ھ��޸�
		SOC0204TB soc0204TB=null;
		SOC0204SearchCondImpl cond=new SOC0204SearchCondImpl();
		
		
		cond.setRclReportType_eq(rclReportType);
		cond.setRclObjName_eq(rclObjName);
		cond.setRclObjType_eq(objType);
		cond.setRclUserId_eq(user.getUserid());
		cond.setRclCaType_eq(rclCaType);
		if("01".equals(rclReportType)){
			cond.setRclTemName_eq(rclTemName);
			cond.setRclTemDesc_eq(rclTemDesc);
			cond.setRclRfdTitle_eq(rclTemTitle);
		}else if("03".equals(rclReportType)){
			cond.setRclMode_eq(mode);
			if(!"sum".equals(mode)){
				cond.setRclObjEiid_eq(Integer.parseInt(eiid));
			}
		}
		List<SOC0204Info> soc0204List=soc0204BL.searchSOC0204(cond);
		if(soc0204List!=null&&soc0204List.size()>0){
			returnStr="exists";
		}else{
			soc0204TB=new SOC0204TB();
			soc0204TB.setRclReportType(rclReportType);
			soc0204TB.setRclObjName(rclObjName);
			soc0204TB.setRclObjType(objType);
			soc0204TB.setRclUserId(user.getUserid());
			soc0204TB.setRclCaType(rclCaType);
			if("01".equals(rclReportType)){
				soc0204TB.setRclTemName(rclTemName);
				soc0204TB.setRclTemDesc(rclTemDesc);
				soc0204TB.setRclRfdTitle(rclTemTitle);
			}else if("03".equals(rclReportType)){
				soc0204TB.setRclMode(mode);
				if(!"sum".equals(mode)){
					soc0204TB.setRclObjEiid(Integer.parseInt(eiid));
				}
			}
			soc0204BL.registSOC0204(soc0204TB);
			returnStr="insert";
		}
		out.print(returnStr);
    }
	
	 /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void getShowDataIO(HttpServletRequest req, PrintWriter out,
			String eirootmark) throws BLException {
    	long strTime=System.currentTimeMillis();
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version='1.0' encoding='utf-8'?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	long strTimeA=System.currentTimeMillis();
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eirootmark));
    	long endTimeA=System.currentTimeMillis();
		log.debug("��ѯ�ʲ�������  "+((endTimeA-strTimeA)/1000)+" ��");
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(eirootmark));
    	if(entityItem.getEsyscoding().startsWith("999001009")){
    		String[] eids={"109","110","111","112","114"};
    		cond.setEids(eids);
    	}
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	long endTime=System.currentTimeMillis();
		log.debug("ȫIO��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	dataXml.append("</root>");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void getShowStorageIO(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	List<Integer> ioEiids=new ArrayList<Integer>();
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_224);
    	srCond.setSrcldeiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	//����PV��PP�Ĺ�ϵ��224������PV
    	List<SOC0121Info> snapshotRelationInfoPV=snapshotRelationBL.searchSnapshotRelation(srCond);
    	Integer[] pvEiids=new Integer[snapshotRelationInfoPV.size()];
    	int pvNum=0;
    	if(snapshotRelationInfoPV!=null&&snapshotRelationInfoPV.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoPV){
    			if(!eiids.contains(srInfo.getSrpareiid())){
    				eiids.add(srInfo.getSrpareiid());
    				pvEiids[pvNum]=srInfo.getSrpareiid();
    				pvNum++;
    			}
    		}
    	}
    	snapshotRelationInfoPV.clear();
    	if(pvEiids!=null&&pvEiids.length>0){
    		srCond=new SOC0121SearchCondImpl();
        	srCond.setSrcldeiids(pvEiids);
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_221);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����PV��VG�Ĺ�ϵ��221������VG
        	List<SOC0121Info> snapshotRelationInfoVG=snapshotRelationBL.searchSnapshotRelation(srCond);
        	if(snapshotRelationInfoVG!=null&&snapshotRelationInfoVG.size()>0){
        		for(SOC0121Info srInfo:snapshotRelationInfoVG){
        			if(!eiids.contains(srInfo.getSrpareiid())){
        				eiids.add(srInfo.getSrpareiid());
        			}
        		}
        	}
        	snapshotRelationInfoVG.clear();
        	
        	srCond=new SOC0121SearchCondImpl();
        	srCond.setSrcldeiids(pvEiids);
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_217);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����PV��LV�Ĺ�ϵ��217������LV
        	List<SOC0121Info> snapshotRelationInfoLV=snapshotRelationBL.searchSnapshotRelation(srCond);
        	Integer[] lvEiids=new Integer[snapshotRelationInfoLV.size()];
        	int lvNum=0;
        	if(snapshotRelationInfoLV!=null&&snapshotRelationInfoLV.size()>0){
        		for(SOC0121Info srInfo:snapshotRelationInfoLV){
        			if(!eiids.contains(srInfo.getSrpareiid())){
        				eiids.add(srInfo.getSrpareiid());
        				lvEiids[lvNum]=srInfo.getSrpareiid();
        				lvNum++;
        			}
        		}
        	}
        	snapshotRelationInfoLV.clear();
        	if(lvEiids!=null&&lvEiids.length>0){
            	srCond=new SOC0121SearchCondImpl();
            	srCond.setSrcldeiids(lvEiids);
            	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_216);
            	srCond.setSrarithmetictype_eq("2");
            	srCond.setSrdomainversion_eq(domainversion);
            	//����FS��LV�Ĺ�ϵ��216������FS
            	List<SOC0121Info> snapshotRelationInfoFS=snapshotRelationBL.searchSnapshotRelation(srCond);
            	if(snapshotRelationInfoFS!=null&&snapshotRelationInfoFS.size()>0){
            		for(SOC0121Info srInfo:snapshotRelationInfoFS){
            			if(!eiids.contains(srInfo.getSrpareiid())){
            				eiids.add(srInfo.getSrpareiid());
            			}
            		}
            	}
            	snapshotRelationInfoFS.clear();
        	}
    		
        	srCond=new SOC0121SearchCondImpl();
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_218);
        	srCond.setSrpareiids(pvEiids);
        	srCond.setSrarithmetictype_eq("4");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����PV��META�Ĺ�ϵ��218������META
        	List<SOC0121Info> srList=snapshotRelationBL.searchSnapshotRelation(srCond);
        	Integer[] metaEiids=new Integer[srList.size()];
        	int metaNum=0;
        	if(srList!=null&&srList.size()>0){
        		for(SOC0121Info metaInfo:srList){
        			ioEiids.add(metaInfo.getSrcldeiid());
        			metaEiids[metaNum]=metaInfo.getSrcldeiid();
        			metaNum++;
        		}
        	}
        	srList.clear();
        	if(metaEiids!=null&&metaEiids.length>0){
            	srCond=new SOC0121SearchCondImpl();
            	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_219);
            	srCond.setSrpareiids(metaEiids);
            	srCond.setSrarithmetictype_eq("2");
            	srCond.setSrdomainversion_eq(domainversion);
            	//����META��HYPER�Ĺ�ϵ��219������HYPER
            	List<SOC0121Info> srHyperList=snapshotRelationBL.searchSnapshotRelation(srCond);
            	Integer[] hyperEiids=new Integer[srHyperList.size()];
            	int hyperNum=0;
            	if(srHyperList!=null&&srHyperList.size()>0){
            		for(SOC0121Info hyperInfo:srHyperList){
            			ioEiids.add(hyperInfo.getSrcldeiid());
            			hyperEiids[hyperNum]=hyperInfo.getSrcldeiid();
            			hyperNum++;
            		}
            	}
            	srHyperList.clear();
            	if(hyperEiids!=null&&hyperEiids.length>0){
            		srCond=new SOC0121SearchCondImpl();
                	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_220);
                	srCond.setSrpareiids(hyperEiids);
                	srCond.setSrarithmetictype_eq("2");
                	srCond.setSrdomainversion_eq(domainversion);
                	//����HYPER��DISK�Ĺ�ϵ��220������DISK
                	List<SOC0121Info> srDiskList=snapshotRelationBL.searchSnapshotRelation(srCond);
                	if(srDiskList!=null&&srDiskList.size()>0){
                		for(SOC0121Info diskInfo:srDiskList){
                			ioEiids.add(diskInfo.getSrcldeiid());
                		}
                	}
                	srDiskList.clear();
            	}
        	}
    	}
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	entityItemList.clear();
    	
    	if(ioEiids!=null&&ioEiids.size()>0){
    		cond=new SOC0118SearchCondImpl();
        	cond.setEiids(ioEiids);
        	List<SOC0118Info> entityItemStorageList=entityItemBL.searchEntityItem(cond);
        	if(entityItemStorageList!=null&&entityItemStorageList.size()>0){
        		Iterator<SOC0118Info> entityItemIt=entityItemStorageList.iterator();
        		while(entityItemIt.hasNext()){
        			SOC0118Info ei=entityItemIt.next();
        			if(ei.getEiid()!=ei.getEirootmark()){
        				dataXml.append("<NODE");
            			dataXml.append(" einame=\"");
            			dataXml.append(ei.getEiname());
            			dataXml.append("\" eiid=\"");
            			dataXml.append(ei.getEiid());
            			dataXml.append("\" esyscoding=\"");
            			dataXml.append(ei.getEsyscoding());
            			dataXml.append("\"/>");
        			}
        		}
        	}
        	entityItemStorageList.clear();
    	}
    	
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���PP��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByFs(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_216);
    	srCond.setSrpareiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	//����FS��LV�Ĺ�ϵ��216������LV
    	List<SOC0121Info> snapshotRelationInfoLV=snapshotRelationBL.searchSnapshotRelation(srCond);
    	Integer[] lvEiids=new Integer[snapshotRelationInfoLV.size()];
    	int lvNum=0;
    	if(snapshotRelationInfoLV!=null&&snapshotRelationInfoLV.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoLV){
    			if(!eiids.contains(srInfo.getSrcldeiid())){
    				eiids.add(srInfo.getSrcldeiid());
    				lvEiids[lvNum]=srInfo.getSrcldeiid();
    				lvNum++;
    			}
    		}
    	}
    	snapshotRelationInfoLV.clear();
    	//������FS�й�ϵ��LVʱ
    	if(lvEiids!=null&&lvEiids.length>0){
    		srCond=new SOC0121SearchCondImpl();
        	srCond.setSrpareiids(lvEiids);
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_217);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����LV��PV�Ĺ�ϵ��217������PV
        	List<SOC0121Info> snapshotRelationInfoPV=snapshotRelationBL.searchSnapshotRelation(srCond);
        	Integer[] pvEiids=new Integer[snapshotRelationInfoPV.size()];
        	int pvNum=0;
        	if(snapshotRelationInfoPV!=null&&snapshotRelationInfoPV.size()>0){
        		for(SOC0121Info srInfo:snapshotRelationInfoPV){
        			if(!eiids.contains(srInfo.getSrcldeiid())){
        				eiids.add(srInfo.getSrcldeiid());
        				pvEiids[pvNum]=srInfo.getSrcldeiid();
        				pvNum++;
        			}
        		}
        	}
        	snapshotRelationInfoPV.clear();
        	//������LV�й�ϵ��PVʱ
        	if(pvEiids!=null&&pvEiids.length>0){
        		srCond=new SOC0121SearchCondImpl();
            	srCond.setSrcldeiids(pvEiids);
            	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_221);
            	srCond.setSrarithmetictype_eq("2");
            	srCond.setSrdomainversion_eq(domainversion);
            	//����PV��VG�Ĺ�ϵ��221������VG
            	List<SOC0121Info> snapshotRelationInfoVG=snapshotRelationBL.searchSnapshotRelation(srCond);
            	if(snapshotRelationInfoVG!=null&&snapshotRelationInfoVG.size()>0){
            		for(SOC0121Info srInfo:snapshotRelationInfoVG){
            			if(!eiids.contains(srInfo.getSrpareiid())){
            				eiids.add(srInfo.getSrpareiid());
            			}
            		}
            	}
            	snapshotRelationInfoVG.clear();
            	srCond=new SOC0121SearchCondImpl();
            	srCond.setSrpareiids(pvEiids);
            	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_224);
            	srCond.setSrarithmetictype_eq("2");
            	srCond.setSrdomainversion_eq(domainversion);
            	//����PV��PP�Ĺ�ϵ��224������PP
            	List<SOC0121Info> snapshotRelationInfoPP=snapshotRelationBL.searchSnapshotRelation(srCond);
            	if(snapshotRelationInfoPP!=null&&snapshotRelationInfoPP.size()>0){
            		for(SOC0121Info srInfo:snapshotRelationInfoPP){
            			if(!eiids.contains(srInfo.getSrcldeiid())){
            				eiids.add(srInfo.getSrcldeiid());
            			}
            		}
            	}
            	snapshotRelationInfoPP.clear();
        	}
    	}
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	entityItemList.clear();
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���FS��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByLv(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_216);
    	srCond.setSrcldeiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	//����FS��LV�Ĺ�ϵ��216������FS
    	List<SOC0121Info> snapshotRelationInfoFS=snapshotRelationBL.searchSnapshotRelation(srCond);
    	if(snapshotRelationInfoFS!=null&&snapshotRelationInfoFS.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoFS){
    			if(!eiids.contains(srInfo.getSrpareiid())){
    				eiids.add(srInfo.getSrpareiid());
    			}
    		}
    	}
    	snapshotRelationInfoFS.clear();
    	srCond=new SOC0121SearchCondImpl();
    	srCond.setSrpareiid_eq(eiid);
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_217);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	//����LV��PV�Ĺ�ϵ��217������PV
    	List<SOC0121Info> snapshotRelationInfoPV=snapshotRelationBL.searchSnapshotRelation(srCond);
    	Integer[] pvEiids=new Integer[snapshotRelationInfoPV.size()];
    	int pvNum=0;
    	if(snapshotRelationInfoPV!=null&&snapshotRelationInfoPV.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoPV){
    			if(!eiids.contains(srInfo.getSrcldeiid())){
    				eiids.add(srInfo.getSrcldeiid());
    				pvEiids[pvNum]=srInfo.getSrcldeiid();
    				pvNum++;
    			}
    		}
    	}
    	snapshotRelationInfoPV.clear();
    	//���й�ϵ��PV����ʱ
    	if(pvEiids!=null&&pvEiids.length>0){
    		srCond=new SOC0121SearchCondImpl();
        	srCond.setSrcldeiids(pvEiids);
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_221);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����VG��PV�Ĺ�ϵ��221������VG
        	List<SOC0121Info> snapshotRelationInfoVG=snapshotRelationBL.searchSnapshotRelation(srCond);
        	if(snapshotRelationInfoVG!=null&&snapshotRelationInfoVG.size()>0){
        		for(SOC0121Info srInfo:snapshotRelationInfoVG){
        			if(!eiids.contains(srInfo.getSrpareiid())){
        				eiids.add(srInfo.getSrpareiid());
        			}
        		}
        	}
        	snapshotRelationInfoVG.clear();
        	srCond=new SOC0121SearchCondImpl();
        	srCond.setSrpareiids(pvEiids);
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_224);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����PV��PP�Ĺ�ϵ��224������PP
        	List<SOC0121Info> snapshotRelationInfoPP=snapshotRelationBL.searchSnapshotRelation(srCond);
        	if(snapshotRelationInfoPP!=null&&snapshotRelationInfoPP.size()>0){
        		for(SOC0121Info srInfo:snapshotRelationInfoPP){
        			if(!eiids.contains(srInfo.getSrcldeiid())){
        				eiids.add(srInfo.getSrcldeiid());
        			}
        		}
        	}
        	snapshotRelationInfoPP.clear();
    	}
    	
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	entityItemList.clear();
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���LV��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByVg(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_221);
    	srCond.setSrpareiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	//����VG��PV�Ĺ�ϵ��221������PV
    	List<SOC0121Info> snapshotRelationInfoPV=snapshotRelationBL.searchSnapshotRelation(srCond);
    	Integer[] pvEiids=new Integer[snapshotRelationInfoPV.size()];
    	int pvNum=0;
    	if(snapshotRelationInfoPV!=null&&snapshotRelationInfoPV.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoPV){
    			if(!eiids.contains(srInfo.getSrcldeiid())){
    				eiids.add(srInfo.getSrcldeiid());
    				pvEiids[pvNum]=srInfo.getSrcldeiid();
    				pvNum++;
    			}
    		}
    	}
    	snapshotRelationInfoPV.clear();
    	//�й�ϵ��PV����ʱ
    	if(pvEiids!=null&&pvEiids.length>0){
    		srCond=new SOC0121SearchCondImpl();
        	srCond.setSrcldeiids(pvEiids);
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_217);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����PV��LV�Ĺ�ϵ��217������LV
        	List<SOC0121Info> snapshotRelationInfoLV=snapshotRelationBL.searchSnapshotRelation(srCond);
        	Integer[] lvEiids=new Integer[snapshotRelationInfoLV.size()];
        	int lvNum=0;
        	if(snapshotRelationInfoLV!=null&&snapshotRelationInfoLV.size()>0){
        		for(SOC0121Info srInfo:snapshotRelationInfoLV){
        			if(!eiids.contains(srInfo.getSrpareiid())){
        				eiids.add(srInfo.getSrpareiid());
        				lvEiids[lvNum]=srInfo.getSrpareiid();
        				lvNum++;
        			}
        		}
        	}
        	snapshotRelationInfoLV.clear();
        	
        	if(lvEiids!=null&&lvEiids.length>0){
        		srCond=new SOC0121SearchCondImpl();
            	srCond.setSrcldeiids(lvEiids);
            	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_216);
            	srCond.setSrarithmetictype_eq("2");
            	srCond.setSrdomainversion_eq(domainversion);
            	//����LV��FS�Ĺ�ϵ��216������FS
            	List<SOC0121Info> snapshotRelationInfoFS=snapshotRelationBL.searchSnapshotRelation(srCond);
            	if(snapshotRelationInfoFS!=null&&snapshotRelationInfoFS.size()>0){
            		for(SOC0121Info srInfo:snapshotRelationInfoFS){
            			if(!eiids.contains(srInfo.getSrpareiid())){
            				eiids.add(srInfo.getSrpareiid());
            			}
            		}
            	}
            	snapshotRelationInfoFS.clear();
        	}
        	
        	srCond=new SOC0121SearchCondImpl();
        	srCond.setSrpareiids(pvEiids);
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_224);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����PV��PP�Ĺ�ϵ��224������PP
        	List<SOC0121Info> snapshotRelationInfoPP=snapshotRelationBL.searchSnapshotRelation(srCond);
        	if(snapshotRelationInfoPP!=null&&snapshotRelationInfoPP.size()>0){
        		for(SOC0121Info srInfo:snapshotRelationInfoPP){
        			if(!eiids.contains(srInfo.getSrcldeiid())){
        				eiids.add(srInfo.getSrcldeiid());
        			}
        		}
        	}
        	snapshotRelationInfoPP.clear();
    	}
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	entityItemList.clear();
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���VG��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByPv(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_221);
    	srCond.setSrcldeiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	//����PV��VG�Ĺ�ϵ��221������VG
    	List<SOC0121Info> snapshotRelationInfoVG=snapshotRelationBL.searchSnapshotRelation(srCond);
    	if(snapshotRelationInfoVG!=null&&snapshotRelationInfoVG.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoVG){
    			if(!eiids.contains(srInfo.getSrpareiid())){
    				eiids.add(srInfo.getSrpareiid());
    			}
    		}
    	}
    	snapshotRelationInfoVG.clear();

    	srCond=new SOC0121SearchCondImpl();
    	srCond.setSrcldeiid_eq(eiid);
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_217);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	//����PV��LV�Ĺ�ϵ��217������LV
    	List<SOC0121Info> snapshotRelationInfoLV=snapshotRelationBL.searchSnapshotRelation(srCond);
    	Integer[] lvEiids=new Integer[snapshotRelationInfoLV.size()];
    	int lvNum=0;
    	if(snapshotRelationInfoLV!=null&&snapshotRelationInfoLV.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoLV){
    			if(!eiids.contains(srInfo.getSrpareiid())){
    				eiids.add(srInfo.getSrpareiid());
    				lvEiids[lvNum]=srInfo.getSrpareiid();
    				lvNum++;
    			}
    		}
    	}
    	snapshotRelationInfoLV.clear();
    	if(lvEiids!=null&&lvEiids.length>0){
    		srCond=new SOC0121SearchCondImpl();
        	srCond.setSrcldeiids(lvEiids);
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_216);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	//����FS��LV�Ĺ�ϵ��216������FS
        	List<SOC0121Info> snapshotRelationInfoFS=snapshotRelationBL.searchSnapshotRelation(srCond);
        	if(snapshotRelationInfoFS!=null&&snapshotRelationInfoFS.size()>0){
        		for(SOC0121Info srInfo:snapshotRelationInfoFS){
        			if(!eiids.contains(srInfo.getSrpareiid())){
        				eiids.add(srInfo.getSrpareiid());
        			}
        		}
        	}
        	snapshotRelationInfoFS.clear();
    	}
    	srCond=new SOC0121SearchCondImpl();
    	srCond.setSrpareiid_eq(eiid);
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_224);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	//����PV��PP�Ĺ�ϵ��224������PP
    	List<SOC0121Info> snapshotRelationInfoPP=snapshotRelationBL.searchSnapshotRelation(srCond);
    	if(snapshotRelationInfoPP!=null&&snapshotRelationInfoPP.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoPP){
    			if(!eiids.contains(srInfo.getSrcldeiid())){
    				eiids.add(srInfo.getSrcldeiid());
    			}
    		}
    		snapshotRelationInfoPP.clear();
    	}
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	entityItemList.clear();
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���PV��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByPort(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_227);
    	srCond.setSrcldeiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("3");
    	srCond.setSrdomainversion_eq(domainversion);
    	List<SOC0121Info> snapshotRelationInfoList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	if(snapshotRelationInfoList!=null&&snapshotRelationInfoList.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoList){
    			if(!eiids.contains(srInfo.getSrpareiid())){
    				eiids.add(srInfo.getSrpareiid());
    			}
    		}
    	}
    	String hbaName="";
    	String hostName="";
    	String faPortName="";
    	String storageName="";
    	srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_203);
    	srCond.setSrcldeiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("1");
    	srCond.setSrdomainversion_eq(domainversion);
    	List<SOC0121Info> hbaList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	if(hbaList!=null&&hbaList.size()>0){
    		SOC0118Info hbaInfo=entityItemBL.searchEntityItemByKey(hbaList.get(0).getSrpareiid());
    		hbaName=hbaInfo.getEiname();
    		SOC0118Info hostInfo=entityItemBL.searchEntityItemByKey(hbaInfo.getEirootmark());
    		hostName=hostInfo.getEiname();
    		dataXml.append("<TextArea>");
    		dataXml.append(hostName).append("\n");
    		dataXml.append(entityItem.getEilabel());
    		dataXml.append(hbaName);
    		dataXml.append("</TextArea>");
    	}else{
    		srCond=new SOC0121SearchCondImpl();
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_208);
        	srCond.setSrpareiid_eq(eiid);
        	srCond.setSrarithmetictype_eq("1");
        	srCond.setSrdomainversion_eq(domainversion);
        	List<SOC0121Info> faPortList=snapshotRelationBL.searchSnapshotRelation(srCond);
        	if(faPortList!=null&&faPortList.size()>0){
        		SOC0118Info faPortInfo=entityItemBL.searchEntityItemByKey(faPortList.get(0).getSrcldeiid());
        		faPortName=faPortInfo.getEiname();
        		SOC0118Info storageInfo=entityItemBL.searchEntityItemByKey(faPortInfo.getEirootmark());
        		storageName=storageInfo.getEiname();
        		dataXml.append("<TextArea>");
        		dataXml.append(storageName).append("\n");
        		dataXml.append(faPortName);
        		dataXml.append("</TextArea>");
        	}
    	}
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	cond.setEid("130");
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���PORT��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByZonging(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	List<Integer> portEiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_227);
    	srCond.setSrpareiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("3");
    	srCond.setSrdomainversion_eq(domainversion);
    	List<SOC0121Info> snapshotRelationInfoList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	if(snapshotRelationInfoList!=null&&snapshotRelationInfoList.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoList){
    			if(!eiids.contains(srInfo.getSrcldeiid())){
    				eiids.add(srInfo.getSrcldeiid());
    				portEiids.add(srInfo.getSrcldeiid());
    			}
    		}
    	}
    	if(portEiids!=null&&portEiids.size()>0){
    		dataXml.append("<TextArea>");
    		for(Integer portEiid:portEiids){
    			SOC0118Info entityItemP=entityItemBL.searchEntityItemByKey(portEiid);
    			String hbaName="";
    	    	String hostName="";
    	    	String faPortName="";
    	    	String storageName="";
    	    	srCond=new SOC0121SearchCondImpl();
    	    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_203);
    	    	srCond.setSrcldeiid_eq(portEiid.toString());
    	    	srCond.setSrarithmetictype_eq("1");
    	    	srCond.setSrdomainversion_eq(domainversion);
    	    	List<SOC0121Info> hbaList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	    	if(hbaList!=null&&hbaList.size()>0){
    	    		SOC0118Info hbaInfo=entityItemBL.searchEntityItemByKey(hbaList.get(0).getSrpareiid());
    	    		hbaName=hbaInfo.getEiname();
    	    		SOC0118Info hostInfo=entityItemBL.searchEntityItemByKey(hbaInfo.getEirootmark());
    	    		hostName=hostInfo.getEiname();
    	    		dataXml.append(hostName).append("\n");
    	    		dataXml.append(entityItemP.getEilabel());
    	    		dataXml.append(hbaName).append("\n");
    	    	}else{
    	    		srCond=new SOC0121SearchCondImpl();
    	        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_208);
    	        	srCond.setSrpareiid_eq(portEiid.toString());
    	        	srCond.setSrarithmetictype_eq("1");
    	        	srCond.setSrdomainversion_eq(domainversion);
    	        	List<SOC0121Info> faPortList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	        	if(faPortList!=null&&faPortList.size()>0){
    	        		SOC0118Info faPortInfo=entityItemBL.searchEntityItemByKey(faPortList.get(0).getSrcldeiid());
    	        		faPortName=faPortInfo.getEiname();
    	        		SOC0118Info storageInfo=entityItemBL.searchEntityItemByKey(faPortInfo.getEirootmark());
    	        		storageName=storageInfo.getEiname();
    	        		dataXml.append(storageName).append("\n");
    	        		dataXml.append(faPortName).append("\n");
    	        	}
    	    	}
    		}
    		dataXml.append("</TextArea>");
    	}
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	cond.setEid("107");
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���Zonging��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByFaPort(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_209);
    	srCond.setSrpareiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("1");
    	srCond.setSrdomainversion_eq(domainversion);
    	List<SOC0121Info> snapshotRelationInfoList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	if(snapshotRelationInfoList!=null&&snapshotRelationInfoList.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoList){
    			if(!eiids.contains(srInfo.getSrcldeiid())){
    				eiids.add(srInfo.getSrcldeiid());
    			}
    		}
    	}
    	snapshotRelationInfoList.clear();
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	cond.setEid("109");
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���FAPORT��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByFa(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_209);
    	srCond.setSrcldeiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("1");
    	srCond.setSrdomainversion_eq(domainversion);
    	List<SOC0121Info> snapshotRelationInfoList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	if(snapshotRelationInfoList!=null&&snapshotRelationInfoList.size()>0){
    		for(SOC0121Info srInfo:snapshotRelationInfoList){
    			if(!eiids.contains(srInfo.getSrpareiid())){
    				eiids.add(srInfo.getSrpareiid());
    			}
    		}
    	}
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	cond.setEid("110");
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���FA��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByMeta(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	//����meta����hyper
    	srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_219);
    	srCond.setSrpareiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	List<SOC0121Info> srHyperList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	Integer[] hyperEiids=new Integer[srHyperList.size()];
    	List<Integer> hyperList=new ArrayList<Integer>();
    	int hyperNum=0;
    	if(srHyperList!=null&&srHyperList.size()>0){
    		for(SOC0121Info hyperInfo:srHyperList){
    			if(!eiids.contains(hyperInfo.getSrcldeiid())){
    				eiids.add(hyperInfo.getSrcldeiid());
    				hyperList.add(hyperInfo.getSrcldeiid());
        			hyperEiids[hyperNum]=hyperInfo.getSrcldeiid();
        			hyperNum++;
    			}
    		}
    	}
    	srHyperList.clear();
    	if(hyperEiids!=null&&hyperEiids.length>0){
    		//����hyper����disk
        	srCond=new SOC0121SearchCondImpl();
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_220);
        	srCond.setSrpareiids(hyperEiids);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	List<SOC0121Info> srDiskList=snapshotRelationBL.searchSnapshotRelation(srCond);
        	Integer[] diskEiids=new Integer[srDiskList.size()];
        	int diskNum=0;
        	if(srDiskList!=null&&srDiskList.size()>0){
        		for(SOC0121Info diskInfo:srDiskList){
        			if(!eiids.contains(diskInfo.getSrcldeiid())){
        				eiids.add(diskInfo.getSrcldeiid());
            			diskEiids[diskNum]=diskInfo.getSrcldeiid();
            			diskNum++;
        			}
        		}
        	}
        	srDiskList.clear();
        	if(diskEiids!=null&&diskEiids.length>0){
        		//����disk����DA
            	srCond=new SOC0121SearchCondImpl();
            	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_212);
            	srCond.setSrcldeiids(diskEiids);
            	srCond.setSrarithmetictype_eq("1");
            	srCond.setSrdomainversion_eq(domainversion);
            	List<SOC0121Info> srDAList=snapshotRelationBL.searchSnapshotRelation(srCond);
            	if(srDAList!=null&&srDAList.size()>0){
            		for(SOC0121Info daInfo:srDAList){
            			if(!eiids.contains(daInfo.getSrpareiid())){
            				eiids.add(daInfo.getSrpareiid());
            			}
            		}
            	}
            	srDAList.clear();
        	}
    	}
    	
    	
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	String[] eids={"111","112","113"};
    	cond.setEids(eids);
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				if(ei.getEsyscoding().equals("999001014")){
    					if(!hyperList.contains(ei.getEiid())){
    						continue;
    					}
    				}
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	entityItemList.clear();
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���Meta��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByHyper(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	//����meta����hyper
    	srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_219);
    	srCond.setSrcldeiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	List<SOC0121Info> srHyperList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	Integer[] hyperEiids=new Integer[srHyperList.size()];
    	int hyperNum=0;
    	if(srHyperList!=null&&srHyperList.size()>0){
    		for(SOC0121Info hyperInfo:srHyperList){
    			if(!eiids.contains(hyperInfo.getSrcldeiid())){
    				eiids.add(hyperInfo.getSrcldeiid());
        			hyperEiids[hyperNum]=hyperInfo.getSrcldeiid();
        			hyperNum++;
    			}
    		}
    	}
    	srHyperList.clear();
    	if(hyperEiids!=null&&hyperEiids.length>0){
    		//����hyper����disk
        	srCond=new SOC0121SearchCondImpl();
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_220);
        	srCond.setSrpareiids(hyperEiids);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	List<SOC0121Info> srDiskList=snapshotRelationBL.searchSnapshotRelation(srCond);
        	Integer[] diskEiids=new Integer[srDiskList.size()];
        	int diskNum=0;
        	if(srDiskList!=null&&srDiskList.size()>0){
        		for(SOC0121Info diskInfo:srDiskList){
        			if(!eiids.contains(diskInfo.getSrcldeiid())){
        				eiids.add(diskInfo.getSrcldeiid());
            			diskEiids[diskNum]=diskInfo.getSrcldeiid();
            			diskNum++;
        			}
        		}
        	}
        	srDiskList.clear();
        	if(diskEiids!=null&&diskEiids.length>0){
        		//����disk����DA
            	srCond=new SOC0121SearchCondImpl();
            	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_212);
            	srCond.setSrcldeiids(diskEiids);
            	srCond.setSrarithmetictype_eq("1");
            	srCond.setSrdomainversion_eq(domainversion);
            	List<SOC0121Info> srDAList=snapshotRelationBL.searchSnapshotRelation(srCond);
            	if(srDAList!=null&&srDAList.size()>0){
            		for(SOC0121Info daInfo:srDAList){
            			if(!eiids.contains(daInfo.getSrpareiid())){
            				eiids.add(daInfo.getSrpareiid());
            			}
            		}
            	}
            	srDAList.clear();
        	}
    	}
    	
    	
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	String[] eids={"111","112","113"};
    	cond.setEids(eids);
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	entityItemList.clear();
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���Hyper��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByDa(HttpServletRequest req, PrintWriter out,
			String eiid) throws BLException {
    	long strTime=System.currentTimeMillis();
    	List<Integer> eiids=new ArrayList<Integer>();
    	eiids.add(Integer.valueOf(eiid));
    	StringBuffer dataXml=new StringBuffer();
    	dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    	dataXml.append("<root>");
    	String domainversion=req.getParameter("domainversion");
    	SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
    	SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
    	SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
    	SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
    	//����meta����hyper
    	srCond=new SOC0121SearchCondImpl();
    	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_219);
    	srCond.setSrpareiid_eq(eiid);
    	srCond.setSrarithmetictype_eq("2");
    	srCond.setSrdomainversion_eq(domainversion);
    	List<SOC0121Info> srHyperList=snapshotRelationBL.searchSnapshotRelation(srCond);
    	Integer[] hyperEiids=new Integer[srHyperList.size()];
    	int hyperNum=0;
    	if(srHyperList!=null&&srHyperList.size()>0){
    		for(SOC0121Info hyperInfo:srHyperList){
    			if(!eiids.contains(hyperInfo.getSrcldeiid())){
    				eiids.add(hyperInfo.getSrcldeiid());
        			hyperEiids[hyperNum]=hyperInfo.getSrcldeiid();
        			hyperNum++;
    			}
    		}
    	}
    	srHyperList.clear();
    	if(hyperEiids!=null&&hyperEiids.length>0){
    		//����hyper����disk
        	srCond=new SOC0121SearchCondImpl();
        	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_220);
        	srCond.setSrpareiids(hyperEiids);
        	srCond.setSrarithmetictype_eq("2");
        	srCond.setSrdomainversion_eq(domainversion);
        	List<SOC0121Info> srDiskList=snapshotRelationBL.searchSnapshotRelation(srCond);
        	Integer[] diskEiids=new Integer[srDiskList.size()];
        	int diskNum=0;
        	if(srDiskList!=null&&srDiskList.size()>0){
        		for(SOC0121Info diskInfo:srDiskList){
        			if(!eiids.contains(diskInfo.getSrcldeiid())){
        				eiids.add(diskInfo.getSrcldeiid());
            			diskEiids[diskNum]=diskInfo.getSrcldeiid();
            			diskNum++;
        			}
        		}
        	}
        	srDiskList.clear();
        	if(diskEiids!=null&&diskEiids.length>0){
        		//����disk����DA
            	srCond=new SOC0121SearchCondImpl();
            	srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_212);
            	srCond.setSrcldeiids(diskEiids);
            	srCond.setSrarithmetictype_eq("1");
            	srCond.setSrdomainversion_eq(domainversion);
            	List<SOC0121Info> srDAList=snapshotRelationBL.searchSnapshotRelation(srCond);
            	if(srDAList!=null&&srDAList.size()>0){
            		for(SOC0121Info daInfo:srDAList){
            			if(!eiids.contains(daInfo.getSrpareiid())){
            				eiids.add(daInfo.getSrpareiid());
            			}
            		}
            	}
            	srDAList.clear();
        	}
    	}
    	
    	SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
    	cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
    	String[] eids={"111","112","113"};
    	cond.setEids(eids);
    	List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
    	if(entityItemList!=null&&entityItemList.size()>0){
    		Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
    		while(entityItemIt.hasNext()){
    			SOC0118Info ei=entityItemIt.next();
    			if(ei.getEiid()!=ei.getEirootmark()){
    				dataXml.append("<NODE");
        			dataXml.append(" einame=\"");
        			dataXml.append(ei.getEiname());
        			dataXml.append("\" eiid=\"");
        			dataXml.append(ei.getEiid());
        			dataXml.append("\" esyscoding=\"");
        			dataXml.append(ei.getEsyscoding());
        			dataXml.append("\" domainversion=\"");
        			dataXml.append(domainversion);
        			if(eiids.contains(ei.getEiid())){
    				dataXml.append("\" color=\"red");
        			}
        			dataXml.append("\"/>");
    			}
    		}
    	}
    	entityItemList.clear();
    	dataXml.append("</root>");
    	long endTime=System.currentTimeMillis();
		log.debug("���DA��ʾ������  "+((endTime-strTime)/1000)+" ��");
    	log.debug(dataXml);
		out.print(dataXml);
	}
    
    /**
     * ��ѯ�ʲ���Ϣ*******
     * @param req
     * @param out
     * @param parameter
     */
    private void changeColorByDisk(HttpServletRequest req, PrintWriter out,
            String eiid) throws BLException {
        long strTime=System.currentTimeMillis();
        List<Integer> eiids=new ArrayList<Integer>();
        eiids.add(Integer.valueOf(eiid));
        StringBuffer dataXml=new StringBuffer();
        dataXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        dataXml.append("<root>");
        String domainversion=req.getParameter("domainversion");
        SOC0118BL entityItemBL=(SOC0118BL)getBean("soc0118BL");
        SOC0118Info entityItem=entityItemBL.searchEntityItemByKey(Integer.valueOf(eiid));
        SOC0121BL snapshotRelationBL=(SOC0121BL)getBean("soc0121BL");
        SOC0121SearchCondImpl srCond=new SOC0121SearchCondImpl();
        //����disk����da
        srCond=new SOC0121SearchCondImpl();
        srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_212);
        srCond.setSrcldeiid_eq(eiid);
        srCond.setSrarithmetictype_eq("1");
        srCond.setSrdomainversion_eq(domainversion);
        List<SOC0121Info> srDaList=snapshotRelationBL.searchSnapshotRelation(srCond);
        if(srDaList!=null&&srDaList.size()>0){
            for(SOC0121Info daInfo:srDaList){
                if(!eiids.contains(daInfo.getSrpareiid())){
                    eiids.add(daInfo.getSrpareiid());
                }
            }
        }
        srDaList.clear();
        //����disk����hyper
        srCond=new SOC0121SearchCondImpl();
        srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_220);
        srCond.setSrcldeiid_eq(eiid);
        srCond.setSrarithmetictype_eq("2");
        srCond.setSrdomainversion_eq(domainversion);
        List<SOC0121Info> srHperList=snapshotRelationBL.searchSnapshotRelation(srCond);
        Integer[] hyperEiids=new Integer[srHperList.size()];
        List<Integer> hyperList=new ArrayList<Integer>();
        int hyperNum=0;
        if(srHperList!=null&&srHperList.size()>0){
            for(SOC0121Info hyperInfo:srHperList){
                if(!eiids.contains(hyperInfo.getSrpareiid())){
                    eiids.add(hyperInfo.getSrpareiid());
                    hyperList.add(hyperInfo.getSrpareiid());
                    hyperEiids[hyperNum]=hyperInfo.getSrpareiid();
                    hyperNum++;
                }
            }
        }
        srHperList.clear();
        if(hyperEiids!=null&&hyperEiids.length>0){
            //����hyper����meta
            srCond=new SOC0121SearchCondImpl();
            srCond.setSrassetrelation_eq(EiRelationKeyWords.EIR_ID_219);
            srCond.setSrcldeiids(hyperEiids);
            srCond.setSrarithmetictype_eq("2");
            srCond.setSrdomainversion_eq(domainversion);
            List<SOC0121Info> srMetaList=snapshotRelationBL.searchSnapshotRelation(srCond);
            if(srMetaList!=null&&srMetaList.size()>0){
                for(SOC0121Info metaInfo:srMetaList){
                    if(!eiids.contains(metaInfo.getSrpareiid())&&hyperEiids.length>0){
                        eiids.add(metaInfo.getSrpareiid());
                    }
                }
            }
        }
        
        SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
        cond.setEirootmark(Integer.valueOf(entityItem.getEirootmark()));
        String[] eids={"111","114","113"};
        cond.setEids(eids);
        List<SOC0118Info> entityItemList=entityItemBL.searchEntityItem(cond);
        if(entityItemList!=null&&entityItemList.size()>0){
            Iterator<SOC0118Info> entityItemIt=entityItemList.iterator();
            while(entityItemIt.hasNext()){
                SOC0118Info ei=entityItemIt.next();
                if(ei.getEiid()!=ei.getEirootmark()){
                    if(ei.getEsyscoding().equals("999001014")){
                        if(!hyperList.contains(ei.getEiid())){
                            continue;
                        }
                    }
                    dataXml.append("<NODE");
                    dataXml.append(" einame=\"");
                    dataXml.append(ei.getEiname());
                    dataXml.append("\" eiid=\"");
                    dataXml.append(ei.getEiid());
                    dataXml.append("\" esyscoding=\"");
                    dataXml.append(ei.getEsyscoding());
                    dataXml.append("\" domainversion=\"");
                    dataXml.append(domainversion);
                    if(eiids.contains(ei.getEiid())){
                        dataXml.append("\" color=\"red");
                    }
                    dataXml.append("\"/>");
                }
            }
        }
        entityItemList.clear();
        dataXml.append("</root>");
        long endTime=System.currentTimeMillis();
        log.debug("���DISK��ʾ������  "+((endTime-strTime)/1000)+" ��");
        log.debug(dataXml);
        out.print(dataXml);
    }
    /**
     * ����������IP��ַ�Ƿ��Ѿ�����
     * @param req
     * @param out
     * @param parameter
     */
    private void isRepeatIP(HttpServletRequest req, PrintWriter out,
			String ip) throws BLException {
        Ip_FilterBL bl = (Ip_FilterBL) getBean("ip_filterBL");
        Ip_FilterSearchCondImpl ifCond = new Ip_FilterSearchCondImpl();
        ifCond.setIp(ip);
        List<Ip_FilterInfo> ipFliterInfolist = bl.searchIp_Filter(ifCond);
        if(!ipFliterInfolist.isEmpty()){
            out.print("0");
        }else{
            out.print("1");
        }
	}
    
	/**
	 * ͼ����ʾ����*******
	 * 
	 * @param req
	 * @param out
	 * @param parameter
	 */
	private void checkIo(HttpServletRequest req, PrintWriter out)
			throws BLException {
	}
	/**
	 * chg SMS status 
	 * @return 
	 */
	private void setSMSstatus(HttpServletRequest req, PrintWriter out) {
		String res="";
		String namez=req.getParameter("status");
		if(namez.equals("����")){
			SMSThread.setSmsOpen(true);
			res="�ر�";
		}else{
			SMSThread.setSmsOpen(false);
			res="����";
		}
		out.print(res);
	}
	/**
	 * chg MAIL status 
	 * @return 
	 */
	private void setMAILstatus(HttpServletRequest req, PrintWriter out) {
		String res="";
		String namez=req.getParameter("status");
		if(namez.equals("����")){
			MAILThread.setMailOpen(true);
			res="�ر�";
		}else{
			MAILThread.setMailOpen(false);
			res="����";
		}
		out.print(res);
	}
	
	/**
	 * ����Ӱ�����XML
	 * @param req
	 * @param out
	 */
	private void createImageXml(HttpServletRequest req, PrintWriter out) {
		
		CodeListUtils codeListUtils = (CodeListUtils) getBean("codeListUtils");
		
		String eiid=req.getParameter("eiid");
		String eilabel=req.getParameter("eilabel");
		String einame=req.getParameter("einame");
		String eidesc=req.getParameter("eidesc");
		String operType=req.getParameter("operType");
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("<pluginBean>");
		sbf.append("<signType>");
		sbf.append("1");
		sbf.append("</signType>");
		sbf.append("<serviceType>");
		sbf.append(operType);
		sbf.append("</serviceType>");
		sbf.append("<index>");
		sbf.append("<operId>");
		sbf.append(codeListUtils.getCodeValue("158", null, null, "5"));
		sbf.append("</operId>");
		sbf.append("<contractId>");
		sbf.append(eiid);
		sbf.append("</contractId>");
		sbf.append("<contractLabel>");
		sbf.append(StringUtils.isEmpty(eilabel) ? "" : eilabel.trim());
		sbf.append("</contractLabel>");
		sbf.append("<contractName>");
		sbf.append(StringUtils.isEmpty(einame) ? "" : einame.trim());
		sbf.append("</contractName>");
		sbf.append("<contractDesc>");
		sbf.append(StringUtils.isEmpty(eidesc) ? "" : eidesc.trim());
		sbf.append("</contractDesc>");
		sbf.append("</index>");
		sbf.append("<fileType>");	
		sbf.append(codeListUtils.getCodeValue("158", null, null, "2"));
		sbf.append("</fileType>");
		sbf.append("</pluginBean>");
		//���ɼ��ܺ��XML
		StringBuffer xml = new StringBuffer();
		xml.append(codeListUtils.getCodeValue("158", null, null, "1"));
		xml.append("%3C?xml%20version=%221.0%22%20encoding=%22utf-8%22%20?%3E");
		log.debug(sbf.toString());
		try {
			xml.append(URLEncoder.encode(sbf.toString(), "UTF-8"));
			xml.append("&nocache=");
			xml.append(new Date());
		} catch (UnsupportedEncodingException e) {
			log.error("�쳣��", e);
		}
		
		out.print(xml);
	}
	 /**
     * ҵ����Դ��ػ�ȡ�����ڵ�
     * @param req
     * @param out
     * @param parameter
     */
    private void getServerList(HttpServletRequest req, PrintWriter out) throws BLException {
	}
    /**
     * ����serviceTypename��ȡָ��ֵ
     * @param req
     * @param out
     * @param parameter
     */
    private void getDataByServicetypename(HttpServletRequest req, PrintWriter out) throws BLException {
	}
    /**
     * ����service��ȡָ��ֵ
     * @param req
     * @param out
     * @param parameter
     */
    private void getDataByService(HttpServletRequest req, PrintWriter out) throws BLException {
	}
    /**
     * ��ȡƽ̨��Ч����
     * @param req
     * @param out
     */
    private void getPlatformAvailData(HttpServletRequest req, PrintWriter out) throws BLException {
	}
    /**
     *��ȡƽ̨�µ�server��ȡsevice�Ƿ���Ч
     * @param req
     * @param out
     */
    private void getServerOrServiceAvail(HttpServletRequest req, PrintWriter out) throws BLException {
    	log.debug("======================��ȡ��ȡƽ̨�µ�server��ȡsevice�Ƿ���Ч���ݿ�ʼ=========================");
	}
    
    /**
     * �����������Ͳ�ѯ����״̬��Ϣ
     * @param req
     * @param out
     * @param parameter
     */
    private void searchPrStatusByPdid(HttpServletRequest req, PrintWriter out,
			String pdid) {
    	IG333BL ig333BL=(IG333BL)getBean("ig333BL");
    	IG333SearchCondImpl ig333Cond=new IG333SearchCondImpl();
    	ig333Cond.setPdid(pdid);
    	ig333Cond.setNotContainEndStatus("1");
    	ig333Cond.setNotContainStartStatus("1");
    	List<IG333Info> ig333InfoList=ig333BL.searchIG333Info(ig333Cond);
    	StringBuffer sbf = new StringBuffer();
    	int i=0;
    	if(ig333InfoList!=null&&ig333InfoList.size()>0){
    		for(IG333Info info:ig333InfoList){
    			sbf.append(info.getPsdname()).append("##").append(info.getPsdcode());
    			if((++i) != ig333InfoList.size()) {
					sbf.append("###");
				}
    		}
    	}
    	out.print(sbf.toString());
	}
    
    /**
     * �����������Ͳ�ѯ���̱���Ϣ ��������ѡ����ѡ
     * @param req
     * @param out
     * @param parameter
     */
    private void searchPrInfoByPdid(HttpServletRequest req, PrintWriter out,
			String pdid) {
    	IG007BL ig007BL=(IG007BL)getBean("ig007BL");
    	IG007SearchCondImpl ig007Cond=new IG007SearchCondImpl();
    	ig007Cond.setPdid(pdid);
    	//��������ѡ����ѡ
    	String[] pidtypes={"2","B","C"};
    	ig007Cond.setPidtypes(pidtypes);
    	List<IG007Info> ig007InfoList=ig007BL.searchIG007Info(ig007Cond);
    	StringBuffer sbf = new StringBuffer();
    	int i=0;
    	if(ig007InfoList!=null&&ig007InfoList.size()>0){
    		for(IG007Info info:ig007InfoList){
    			sbf.append(info.getPidname()).append("##").append(info.getPidid()+"_"+info.getPidtype());
    			if((++i) != ig007InfoList.size()) {
					sbf.append("###");
				}
    		}
    	}
    	out.print(sbf.toString());
	}
    /**
     * �����������Ͳ�ѯ���̱���Ϣ ����
     * @param req
     * @param out
     * @param parameter
     */
    private void searchPrInfoByPdid_T(HttpServletRequest req, PrintWriter out,
			String pdid) {
    	IG007BL ig007BL=(IG007BL)getBean("ig007BL");
    	IG007SearchCondImpl ig007Cond=new IG007SearchCondImpl();
    	ig007Cond.setPdid(pdid);
    	//����
    	String[] pidtypes={"T"};
    	ig007Cond.setPidtypes(pidtypes);
    	List<IG007Info> ig007InfoList=ig007BL.searchIG007Info(ig007Cond);
    	StringBuffer sbf = new StringBuffer();
    	int i=0;
    	if(ig007InfoList!=null&&ig007InfoList.size()>0){
    		for(IG007Info info:ig007InfoList){
    			sbf.append(info.getPidname()).append("##").append(info.getPidid()+"_"+info.getPidtype());
    			if((++i) != ig007InfoList.size()) {
					sbf.append("###");
				}
    		}
    	}
    	out.print(sbf.toString());
	}
    
    /**
     *ҵ��ϵͳ�������ͼ
     * @param req
     * @param out
     */
    private void getMeasurememtCurve(HttpServletRequest req, PrintWriter out) throws BLException {
    	log.debug("======================ҵ��ϵͳ�������ͼ���ݿ�ʼ=========================");
	}
	/**
     * Hyperչʾ ʣ��hyper��ѯ
     */
	private void remainHyperByAjax(HttpServletRequest req, PrintWriter out)throws BLException{
		
		log.debug("=======��ʼʣ��hyper��ѯ========");
		
		String eiid = req.getParameter("eiid");
		if("".equals(eiid))
			log.debug("ʣ��hyper��ѯEiid"+req.getParameter("eiid"));
		PortRelationBL portRelationBL=(PortRelationBL) getBean("portRelationBL");
		SOC0118BL bl = (SOC0118BL) getBean("soc0118BL");
				
		//��ѯEntityItem�е�Hyper
			
		SOC0118SearchCondImpl condEiname = new SOC0118SearchCondImpl();
		condEiname.setEiid(eiid.toString());
		List<SOC0118Info> eiNameList=bl.searchEntityItem(condEiname);
		
		PortRelationSearchCondImpl condPrsc = new PortRelationSearchCondImpl();
		condPrsc.setSymmetrixid(eiNameList.get(0).getEiname());
		condPrsc.setEiid(eiid.toString());
			
		//��ѯPortRelationInfo�е�Hyper
		List<String> strList = portRelationBL.searchPortRelationStr(condPrsc); 
		StringBuffer sb = new StringBuffer();
		int t = 0;
		int s = 0;
		for(String str : strList){
			t++;s++;
			if(t==1)
				sb.append("<DG>");
			if(s%7==0){
				sb.append("</DG>");
				t=0;
			}else{
				sb.append("<col"+t+">0:0:"+str+"</col"+t+">");	
			}
			if(s%7!=0 && s==strList.size())
				sb.append("</DG>");
		  }
	    out.print(sb.toString());

	    
		log.debug("=======����ʣ��hyper��ѯ========");
	}	
	/**
     * Hyperչʾ ҵ��ϵͳ��ѯ
     */
	private void bussSearchByAjax(HttpServletRequest req, PrintWriter out)throws BLException{
		
		log.debug("=======��ʼҵ��ϵͳ��ѯ========");
		//�洢EIID
		String eiid = req.getParameter("eiid");
		if("".equals(eiid))
			log.debug("ҵ��ϵͳ��ѯʱ��Eiid"+req.getParameter("eiid"));
		//��ѯ����
		String einame = req.getParameter("einame");	
		if(null == einame)
			einame = "";
		String bussid = req.getParameter("bussid");	
		if(null == bussid)
			bussid = "";		
		//��ɫ����
		String bs = req.getParameter("bs");	
		if(null == bs)
			bs = "";		
		PortRelationBL portRelationBL=(PortRelationBL) getBean("portRelationBL");
		PortRelationSearchCondImpl condPrsc = new PortRelationSearchCondImpl();
		condPrsc.setEiname(einame);
		condPrsc.setEiid(eiid);
		condPrsc.setTempid(bussid);
		//���Hyperʱ�õ�����
		if(!"".equals(bs) && (bs.equals("gk") || bs.equals("mate"))){
			condPrsc.setStyle("hyper");
			List<String> list = portRelationBL.searchPortRelationHost(condPrsc);
			StringBuffer buf = new StringBuffer();
			if(list.size()>0){
				for(Object str : list){
					buf.append(str.toString()).append(",");
				}
				bussid=buf.toString().substring(0, buf.toString().length()-1);
			}else
				bussid = "0";
		}
		//0����ɫ1��ɫ
		String state="0";
		StringBuffer sb = new StringBuffer();
		//2374823:1:ҵ��ϵͳ1 
		condPrsc.setTempid(bussid);
		List<String> strList = portRelationBL.searchPortRelationBuss(condPrsc); 
		int t =0;
		if(strList.size()>0){
		for(int i=0;i<strList.size();i++){
			if(bs.equals("buss")&&bussid.equals(strList.get(i).split("#")[1]))
				state="1";
			else if(!bs.equals("buss") && !"".equals(bussid))
				state="1";
			else
				state="0";
				t++;
				//ÿ6������
				if(t==6){
					sb.append(""+strList.get(i).split("#")[1]+":"+state+":"+strList.get(i).split("#")[0]).append("|");
					t=0;
				}else{
					sb.append(""+strList.get(i).split("#")[1]+":"+state+":"+strList.get(i).split("#")[0]).append("@");
				}
				state="0";
		}
		
	    out.print(sb.toString().substring(0, sb.toString().length()-1));
		}		
		if(sb.length()==0)
			out.print(" ");
		
		log.debug("=======����ҵ��ϵͳ��ѯ========");
	}
	/**
     * Hyperչʾ ����&HBA�ؼ��ֲ�ѯ
     */
	private void hostHbaSearchByAjax(HttpServletRequest req, PrintWriter out)throws BLException{
		
		log.debug("=======��ʼ����&HBA�ؼ��ֲ�ѯ========");
		
		 String eiid = req.getParameter("eiid");
		 if(eiid==null){
			 eiid="";
			 log.debug("����&HBA��WWN��ѯʱ��Eiid"+req.getParameter("eiid"));	
		 }
		 String hba = req.getParameter("hba");
		 if(hba==null){
			 hba="";
		    log.debug("����&HBA��WWN��ѯʱ����������"+hba);
		 }
		 String wwn = req.getParameter("wwn");
		 if(wwn==null){
			wwn="";
			log.debug("����&HBA��WWN��ѯʱ��HBA Port WWN"+hba);
		 }
		String bussid = req.getParameter("bussid");
		 if(bussid==null)
			bussid="";
		String bs = req.getParameter("bs");
		 if(bs==null)
			 bs="";
		PortRelationBL portRelationBL=(PortRelationBL) getBean("portRelationBL");
		
		PortRelationSearchCondImpl condPrsc = new PortRelationSearchCondImpl();
		condPrsc.setEiid(eiid);
		condPrsc.setHba(hba);
		condPrsc.setWwn(wwn);
		condPrsc.setTempid(bussid);
		
		if(!"".equals(bs) && (bs.equals("gk") || bs.equals("mate"))){
			condPrsc.setStyle("hyper");
			List<String> list = portRelationBL.searchPortRelationHost(condPrsc);
			StringBuffer buf = new StringBuffer();
			if(list.size()>0){
				for(Object str : list){
					buf.append(str.toString()).append(",");
				}
				bussid=buf.toString().substring(0, buf.toString().length()-1);
			}else
				bussid = "0";
		}
		
		//��ѯPorstRelation���Ƿ���None
		
		List<PortRelationInfo> prList = portRelationBL.searchPortRelation(condPrsc);
		
		//�����������
		
		boolean flag1 = false;
		boolean flag2 = false;
		//0����ɫ1��ɫ
		String state="0";
		for(PortRelationInfo pri : prList){
			if(pri.getDevicesName().equals("None")){
				flag1 = true;
			}else{
				flag2 = true;}
		}
		//�������
		StringBuffer sb = new StringBuffer();
		if("".equals(wwn)){
			condPrsc.setFlag(true);
			condPrsc.setStyle("getEiid");
			//bussid
			if(!bs.equals("host"))
			condPrsc.setTempid(bussid);
			List<String> eiidList = portRelationBL.searchPortRelationHost(condPrsc);
			sb.append("<root>");
			for(Object o :eiidList){
			condPrsc.setFlag(true);
			//���� List
			condPrsc.setStyle("Zj");
			condPrsc.setEiid(o.toString());
		    List<String> zjList = portRelationBL.searchPortRelationHost(condPrsc);	
		    //HBA List
			condPrsc.setStyle("Hba");
		    List<String> hbaList = portRelationBL.searchPortRelationHost(condPrsc);	
		    condPrsc.setStyle("HbaCol");
		    List<String> hbaColList = portRelationBL.searchPortRelationHost(condPrsc);	
		    //HBA prot List
		    List<String> hbaPortList =null;
		    sb.append("<host hname='"+zjList.get(0)+"' hstatus='"+state+"' heiid='"+o.toString()+"' ");
		    //���HBA��
		    int i=0;
		    for(String str : hbaList){
		    	i++;
		    	if(bs.equals("host") && bussid.equals(str.split("#")[1]))
		    		state="1";
				else if(!bs.equals("host") && !"".equals(bs)){
					for(Object hbacol : hbaColList){
						if(hbacol.toString().equals(str.split("#")[1])){
					state="1";
						}
					}
				}
		    	else
		    		state="0";
		    	sb.append("hba"+i+"eiid='"+str.split("#")[1]+"' hba"+i+"='"+str.split("#")[0]+"' hba"+i+"status='"+state+"' ");
		    	state="0";
			    condPrsc.setStyle("HbaPort");
			    condPrsc.setBrpareiid(str.split("#")[1]);
			    condPrsc.setStyle("HbaPort");
			    hbaPortList = portRelationBL.searchPortRelationHost(condPrsc);	    
			    condPrsc.setStyle("PortCol");
			    List<String> protColList = portRelationBL.searchPortRelationHost(condPrsc);	
			    //HBA��HBAport��ϵ
			    int j=0;
			    for(String str_h : hbaPortList){
			    	if(bs.equals("host") && bussid.equals(str_h.split("#")[1]))
			    		state="1";
					else if(!bs.equals("host")&& !"".equals(bs)){
						for(Object prot : protColList){
							if(prot.toString().equals(str_h.split("#")[1])){
						state="1";
							}
						}
					}
			    	else
			    		state="0";
			    	sb.append("hba"+i+"_"+j+"eiid='"+str_h.split("#")[1]+"' hba"+i+"_"+j+"='"+str_h.split("#")[0]+"' hba"+i+"_"+j+"status='"+state+"' hba"+i+"_"+j+"wwn='"+str_h.split("#")[2]+"' ");
			    	state="0";
			    	j++;
			    	if(hbaPortList.size()<2)
				    	sb.append("hba"+i+"_"+j+"eiid='' hba"+i+"_"+j+"='' hba"+i+"_"+j+"status='0' hba"+i+"_"+j+"wwn='' ");
			    }
		    }
			    for(int k=8;k>i;k--){
			    	sb.append("hba"+k+"eiid='' hba"+k+"='' hba"+k+"status='0' ");
			    	for(int m=0;m<2;m++){
			    	sb.append("hba"+k+"_"+m+"eiid='' hba"+k+"_"+m+"='' hba"+k+"_"+m+"status='0' hba"+k+"_"+m+"wwn='' ");
			    	}
			    }
		   sb.append(" />"); 
			}
			}else{
			sb.append("<root>");
			//����HBA
			if(flag2){
			condPrsc.setFlag(false);
			List<String> strList = portRelationBL.searchPortRelationHost(condPrsc);
			Object o = strList.get(0);
			//��WWNû���ҵ�����ʱ��UnKNOW HBA
			if("".equals(o.toString())){
			    condPrsc.setStyle("Nnknow");
			    List<String> wwnPortList = portRelationBL.searchPortRelationHost(condPrsc);	
				sb.append("<host hname='unknown' hstatus='0' heiid=''  WWN='"+wwnPortList.get(0)+"' WWNstatus='1' ");
				for(int i=1;i<9;i++){
					sb.append(" hba"+i+"eiid='' hba"+i+"='' hba"+i+"status='0' ");
					for(int m=0;m<2;m++){
						sb.append(" hba"+i+"_"+m+"eiid='' hba"+i+"_"+m+"='' hba"+i+"_"+m+"status='0' hba"+i+"_"+m+"wwn=''");					
					}
				}
				sb.append("/>");
			}else{
				condPrsc.setFlag(true);
				//���� List
				condPrsc.setStyle("Zj");
				condPrsc.setEiid(o.toString());
			    List<String> zjList = portRelationBL.searchPortRelationHost(condPrsc);	
			    //HBA List
				condPrsc.setStyle("Hba");
			    List<String> hbaList = portRelationBL.searchPortRelationHost(condPrsc);	
			    //HBA prot List
			    List<String> hbaPortList = null ;
			    sb.append("<host hname='"+zjList.get(0)+"' hstatus='0' heiid='"+o.toString()+"' ");
			    //���HBA��
			    int i=0;
			    for(String str : hbaList){
			    	i++;
			    	sb.append("hba"+i+"eiid='"+str.split("#")[1]+"' hba"+i+"='"+str.split("#")[0]+"' hba"+i+"status='0' ");
				    condPrsc.setStyle("HbaPort");
				    condPrsc.setBrpareiid(str.split("#")[1]);
				    hbaPortList = portRelationBL.searchPortRelationHost(condPrsc);	    
				    //HBA��HBAport��ϵ
				    int j=0;
				    for(String str_h : hbaPortList){
				    	sb.append("hba"+i+"_"+j+"eiid='"+str_h.split("#")[1]+"' hba"+i+"_"+j+"='"+str_h.split("#")[0]+"' hba"+i+"_"+j+"status='0' hba"+i+"_"+j+"wwn='"+str_h.split("#")[2]+"' ");
				    	j++;
				    	if(hbaPortList.size()<2)
					    	sb.append("hba"+i+"_"+j+"eiid='' hba"+i+"_"+j+"='' hba"+i+"_"+j+"status='0' hba"+i+"_"+j+"wwn='' ");
				    }
			    }
			    for(int k=8;k>i;k--){
			    	sb.append("hba"+k+"eiid='' hba"+k+"='' hba"+k+"status='0' ");
			    	for(int m=0;m<2;m++){
			    	sb.append("hba"+k+"_"+m+"eiid='' hba"+k+"_"+m+"='' hba"+k+"_"+m+"status='0' hba"+k+"_"+m+"wwn='' ");
			    	}
			    }
			   sb.append(" />"); 
			}
		}
		//OtherHBA
		if(flag1){
		    condPrsc.setStyle("Nnknow");
		    List<String> wwnPortList = portRelationBL.searchPortRelationHost(condPrsc);	
			sb.append("<host hname='otherWwn' hstatus='0' heiid=''  WWN='"+wwnPortList.get(0)+"' WWNstatus='1' ");
			for(int i=1;i<9;i++){
				sb.append(" hba"+i+"eiid='' hba"+i+"='' hba"+i+"status='0' ");
				for(int m=0;m<2;m++){
					sb.append(" hba"+i+"_"+m+"eiid='' hba"+i+"_"+m+"='' hba"+i+"_"+m+"status='0' hba"+i+"_"+m+"wwn=''");					
				}
			}
			sb.append("/>");
		}
		}
		sb.append("</root>");
		out.print(sb.toString());
		
		log.debug("=======��������&HBA�ؼ��ֲ�ѯ========");
		
		}
	/**
     * //�������ؼ��ֲ�ѯ
     */
	private void switchPortSearchByAjax(HttpServletRequest req, PrintWriter out)throws BLException{
		
		log.debug("=======��ʼ�������ؼ��ֲ�ѯ========");

		
		 String eiid = req.getParameter("eiid");
		 if("".equals(eiid))
			log.debug("��������ѯʱ��Eiid="+req.getParameter("eiid"));	
		 String st = req.getParameter("switch");
		 if(st==null){
			 st="";
		    log.debug("��������ѯʱ����������"+st);
		 }
		String bussid = req.getParameter("bussid");
		 if(bussid==null){
			    bussid="";
		}
		String bs = req.getParameter("bs");
		 if(bs==null)
			 bs="";
		PortRelationBL portRelationBL=(PortRelationBL) getBean("portRelationBL");
		
		
		PortRelationSearchCondImpl condPrsc = new PortRelationSearchCondImpl();
		//��ɫ0����ɫ1��ɫ
		String state="0";
		//�洢Eiid
		condPrsc.setEiid(eiid);
		condPrsc.setEiname(st);
		condPrsc.setTempid(bussid);
		
		if(!"".equals(bs) && (bs.equals("gk") || bs.equals("mate"))){
			condPrsc.setStyle("hyper");
			List<String> list = portRelationBL.searchPortRelationHost(condPrsc);
			StringBuffer buf = new StringBuffer();
			if(list.size()>0){
				for(Object str : list){
					buf.append(str.toString()).append(",");
				}
				bussid=buf.toString().substring(0, buf.toString().length()-1);
			}else
				bussid = "0";
		}
		
		//������List
		StringBuffer sb = new StringBuffer();
		StringBuffer faSb = null;
		sb.append("<root>");
		condPrsc.setStyle("Switch");
		condPrsc.setTempid(bussid);
		List<String> strList = portRelationBL.searchPortRelationSwitch(condPrsc); 
		for(String str : strList){
	    	if(bs.equals("switch") && bussid.equals(str.split("#")[1]))
	    		state="1";
			else if(!bs.equals("switch")&& !"".equals(bs))
				state="1";
	    	else
	    		state="0";
			condPrsc.setStyle("Fa");
			condPrsc.setEiid(str.split("#")[1]);
			condPrsc.setEiname(str.split("#")[0]);
			List<String> faList = portRelationBL.searchPortRelationSwitch(condPrsc); 
			faSb = new StringBuffer();
			for(String faStr : faList){
				faSb.append(""+faStr.split("#")[1]+":"+state+":"+faStr.split("#")[0]+"|");
			}
			String fStr = faSb.toString().substring(0, faSb.length()-1);
			sb.append("<sw sname='"+str.split("#")[0]+"' seiid='"+str.split("#")[1]+"' >"+fStr+"</sw>");
		}
		sb.append("</root>");
		out.print(sb.toString());
		
		log.debug("=======�����������ؼ��ֲ�ѯ========");

	}
	/**
     * //FA
     */
	private void faPortSearchByAjax(HttpServletRequest req, PrintWriter out)throws BLException{
		
		log.debug("=======��ʼ��ʼ��FA========");

		//�洢EIID
		 String eiid = req.getParameter("eiid");
		 if("".equals(eiid))
			log.debug("��ʼ��FAʱ��Eiid="+req.getParameter("eiid"));	
		 
		 //���������ѯ��ID
		 String bussid = req.getParameter("bussid");
		 if(bussid==null)
		    bussid="";
		//���ڱ�ɫ����
		 String bs = req.getParameter("bs");
		 if(bs==null)
			 bs="";
		PortRelationBL portRelationBL=(PortRelationBL) getBean("portRelationBL");
		
		//���Hyperʱ�õ�FA
//		if(!"".equals(bs) && (bs.equals("gk") || bs.equals("mate"))){
//			List<String> list = portRelationBL.getHypeEiid(eiid,bussid);
//			StringBuffer buf = new StringBuffer();
//			if(list.size()>0){
//				for(Object str : list){
//					buf.append(str.toString()).append(",");
//				}
//				bussid=buf.toString().substring(0, buf.toString().length()-1);
//			}else
//				bussid = "0";
//		}
			
		
		//0����ɫ1��ɫ
		String state="0";
		PortRelationSearchCondImpl condPrsc = new PortRelationSearchCondImpl();
		//�洢Eiid
		condPrsc.setEiid(eiid);
		
		//FAList
		StringBuffer sb = new StringBuffer();
		StringBuffer fapSb = null;
		sb.append("<root>");
		condPrsc.setStyle("Fa");
		condPrsc.setTempid(bussid);
		List<String> strList = portRelationBL.searchPortRelationFa(condPrsc); 
		for(String str : strList){
			condPrsc.setStyle("Fa_p");
			condPrsc.setEiid(str.split("#")[1]);
			List<String> fapList = portRelationBL.searchPortRelationFa(condPrsc);
			//��ѯ��Ӧ��·�µ�FA 
			condPrsc.setStyle("faColor");
			condPrsc.setEiid(eiid);
			List<String> facList = portRelationBL.searchPortRelationFa(condPrsc); 
			//��ѯ��Ӧ��·�µ�FaPort 
			condPrsc.setStyle("fapColor");
			List<String> fapcList = portRelationBL.searchPortRelationFa(condPrsc); 
			fapSb = new StringBuffer();
			int i=0;
			for(String fapStr : fapList){
				i++;		
				String value = fapStr.split("#")[0].substring(fapStr.split("#")[0].length()-4,fapStr.split("#")[0].length()-1);
		    	if(bs.equals("fa") && (fapStr.split("#")[1].indexOf(bussid)>0 || bussid.equals(fapStr.split("#")[1])))
		    		state="1";
				else if((!bs.equals("fa")&& !"".equals(bs))||bussid.equals(str.split("#")[1])){
					for(Object facp : fapcList){
						if(facp.toString().equals(fapStr.split("#")[1])){
							state="1";
						}
					}
				}
		    	else
		    		state="0";
				fapSb.append("fPort"+i+"='"+value+"' fPort"+i+"eiid='"+fapStr.split("#")[1]+"' fPort"+i+"status='"+state+"' ");
				state="0";
			}
			for(int k=8;k>i;k--){
				fapSb.append("fPort"+k+"='' fPort"+k+"eiid='' fPort"+k+"status='0' ");
			}
	    	if(bs.equals("fa") && bussid.equals(str.split("#")[1]))
	    		state="1";
			else if(!bs.equals("fa")&& !"".equals(bs)){
				for(Object fac : facList){
					if(fac.toString().equals(str.split("#")[1])){
						state="1";
					}
				}
			}else
				state="0";
			sb.append("<FA fname='"+str.split("#")[0]+"' fstatus='"+state+"' feiid='"+str.split("#")[1]+"' "+fapSb.toString()+"/>");
			state="0";
		}
		sb.append("</root>");
		out.print(sb.toString());
		
		log.debug("=======������ʼ��FA========");
		
	}	
	/**
     * //hyper��ѯ
     */
	private void hyperPortSearchByAjax(HttpServletRequest req, PrintWriter out)throws BLException{
		
		log.debug("=======��ʼHyper��ѯ========");
		
		 //�洢EIID
		 String eiid = req.getParameter("eiid");
		 if("".equals(eiid))
			log.debug("��ѯHyperʱ��Eiid="+req.getParameter("eiid"));	
		 //��ѯ��Hyper����
		 String einame = req.getParameter("einame");
		 if(einame==null)
			 einame="";
		 //����meta��getKeeper
		 String style = req.getParameter("style");
		 if(style==null)
			 style=""; 
		 //���������ѯ��ID
		 String bussid = req.getParameter("bussid");
		 if(bussid==null)
			 bussid=""; 
		 //�洢���
		 String symmetrixid = req.getParameter("symmetrixid");
		 if(symmetrixid==null)
			 symmetrixid=""; 
		 //���ڱ�ɫ����
		 String bs = req.getParameter("bs");
		 if(null==bs)
			 bs=""; 		 
		PortRelationBL portRelationBL=(PortRelationBL) getBean("portRelationBL");
		//�����ɫ
		String tempId= bussid;
		//���Hyperʱ�õ�FA
		if(!"".equals(bs) && (bs.equals("gk") || bs.equals("mate"))){
			List<String> list = portRelationBL.getHypeEiid(eiid,bussid);
			StringBuffer buf = new StringBuffer();
			if(list.size()>0){
				for(Object str : list){
					buf.append(str.toString()).append(",");
				}
				bussid=buf.toString().substring(0, buf.toString().length()-1);
			}else
				bussid = "0";
		}
		
		PortRelationSearchCondImpl condPrsc = new PortRelationSearchCondImpl();
		//�洢Eiid
		condPrsc.setEiid(eiid);
		condPrsc.setEiname(einame);
		condPrsc.setTempid(bussid);
		condPrsc.setSymmetrixid(symmetrixid);
		condPrsc.setStyle(style);
		if(bs.equals("host")){
		condPrsc.setWwn("SearchEid");
		List<String> eidList = portRelationBL.searchPortRelationHyper(condPrsc); 
		Object eid =eidList.get(0);
		if(eid.toString().equals("102"))
			condPrsc.setWwn("getPort");
		else
			condPrsc.setWwn("getHba");
		}
		//FAList
		StringBuffer sb = new StringBuffer();
		boolean flag=true;
		List<String> strList = portRelationBL.searchPortRelationHyper(condPrsc); 
		if(!"".equals(bs) && (bs.equals(style))){
			for(String str : strList){
				if(str.equals(tempId)){
					flag=false;
				}
			}
			if(flag){
				condPrsc.setTempid("0");
				strList = portRelationBL.searchPortRelationHyper(condPrsc); 
			}
		}
		//0����ɫ1��ɫ
		String state="0";
		int t = 0;
		int s = 0;
		for(String str : strList){
	    	if(tempId.equals(str))
	    		state="1";
	    	else if("".equals(bs))
	    		state="0";
	    	else
	    		state="0";
				t++;s++;
				if(t==1)
					sb.append("<DG>");
				if(t<8 && s==strList.size()){
					for(int k=8;k>t;k--){
						sb.append("<col"+k+">:0:</col"+k+">");
						}
				}
				if(t==9){
					sb.append("</DG>");
					t=0;
				}else{
				sb.append("<col"+t+">"+str+":"+state+":"+str+"</col"+t+">");	
				}
				if(s==strList.size() && t!=0)
					sb.append("</DG>");
		  }
			if("".equals(sb.toString()))
				sb.append("<DG></DG>");
				out.print(sb.toString());
		
		log.debug("=======����Hyper��ѯ========");

	}	
	
	/**
	 * ȡ�ù�ϵ��Ϣ
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void searchRelationByAjax(HttpServletRequest req, PrintWriter out)throws BLException{
		//����ʲ���eiid
		String eiid=req.getParameter("eiid");
		//�洢��eiid
		String storageEiid=req.getParameter("storageEiid");
		//����ʲ�����id
		String typeId=req.getParameter("typeId");
		StringBuffer sb=new StringBuffer();
		
		SOC0125BL eddBl=(SOC0125BL) getBean("soc0125BL");
		SOC0125Info eiDomainDefVWInfo=eddBl.searchEiDomainDefVW("1");
		SOC0114BL emBl=(SOC0114BL) getBean("soc0114BL");
		PortRelationBL prBl=(PortRelationBL)getBean("portRelationBL");
		List<String> eiidList=new ArrayList<String>();
		Map<Integer, List<SOC0114Info>> emMap=new HashMap<Integer, List<SOC0114Info>>();
		if("0".equals(typeId)){
			eiidList.add(eiid);
		}else{
			PortRelationSearchCondImpl prCond=new PortRelationSearchCondImpl();
			prCond.setEiid(storageEiid);
			prCond.setTempid(eiid);
			prCond.setStyle("fapColor");
			eiidList=prBl.searchPortRelationFa(prCond);
		}
		int num=1;
		List<Integer> linkidList=new ArrayList<Integer>();
		if(eiidList!=null&&eiidList.size()>0){
			for(int i=0;i<eiidList.size();i++){
				Object o=eiidList.get(i);
				Integer otherEiid=Integer.parseInt(o.toString());
				EiLinkMapSearchCondImpl emCond=new EiLinkMapSearchCondImpl();
				emCond.setDomainid_eq(eiDomainDefVWInfo.getEiddid());
				emCond.setDomainversion_eq(eiDomainDefVWInfo.getVersion());
				emCond.setEiid_eq(Integer.parseInt(storageEiid));
				emCond.setOtherEiid(otherEiid);
				List<SOC0114Info> emListOne=emBl.searchEiLinkMapByOtherEiid(emCond);
				if(emListOne!=null&&emListOne.size()>0){
					for(SOC0114Info emOne:emListOne){
						if(!linkidList.contains(emOne.getLinkid())){
							linkidList.add(emOne.getLinkid());
						}
						if(num>=2&&!linkidList.contains(emOne.getLinkid())){
						if(emMap.get(emOne.getLinkid())!=null){
							List<SOC0114Info> emlListTwo=emMap.get(emOne.getLinkid());
							emlListTwo.add(emOne);
							emMap.put(emOne.getLinkid(), emlListTwo);
						}else{
							List<SOC0114Info> emlListTwo=new LinkedList<SOC0114Info>();
							emlListTwo.add(emOne);
							emMap.put(emOne.getLinkid(), emlListTwo);
						}
					}
						if(num==1){
							if(emMap.get(emOne.getLinkid())!=null){
								List<SOC0114Info> emlListTwo=emMap.get(emOne.getLinkid());
								emlListTwo.add(emOne);
								emMap.put(emOne.getLinkid(), emlListTwo);
							}else{
								List<SOC0114Info> emlListTwo=new LinkedList<SOC0114Info>();
								emlListTwo.add(emOne);
								emMap.put(emOne.getLinkid(), emlListTwo);
							}
						}
					}
				}
				num++;
			}
		}
		if(emMap!=null&&emMap.size()>0){
			sb.append("<root>");
			Set<Map.Entry<Integer,List<SOC0114Info>>> set= emMap.entrySet();
			int i=0;
			boolean flag=true;
			for(Iterator<Map.Entry<Integer,List<SOC0114Info>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<SOC0114Info>> entry = iter.next();
				List<SOC0114Info> emListThree=entry.getValue();
				if(emListThree!=null&&emListThree.size()>0){
					if(emListThree.size()==9){
						for(SOC0114Info emThree:emListThree){
							if(emThree.getLinkorder()==3&&flag){
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==4&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=false;
							}
							i++;
							if(emThree.getLinkorder()==6){
								flag=true;
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==7&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=true;
							}
						}
					}else if(emListThree.size()==10){
						for(SOC0114Info emThree:emListThree){
							if(emThree.getLinkorder()==4&&flag){
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==5&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=false;
							}
							i++;
							if(emThree.getLinkorder()==7){
								flag=true;
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==8&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=true;
							}
						}
					}else if(emListThree.size()==12){
						for(SOC0114Info emThree:emListThree){
							if(emThree.getLinkorder()==3&&flag){
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==4&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=false;
							}
							i++;
							if(emThree.getLinkorder()==6){
								flag=true;
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==7&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=false;
							}
							i++;
							if(emThree.getLinkorder()==9){
								flag=true;
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==10&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=true;
							}
						}
					}else if(emListThree.size()==13){
						for(SOC0114Info emThree:emListThree){
							if(emThree.getLinkorder()==4&&flag){
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==5&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=false;
							}
							i++;
							if(emThree.getLinkorder()==7){
								flag=true;
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==8&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=false;
							}
							i++;
							if(emThree.getLinkorder()==10){
								flag=true;
								sb.append("<Relation ");
								sb.append(" FromEiid='"+emThree.getEiid()+"'");
							}
							if(emThree.getLinkorder()==11&&flag){
								sb.append(" ToEiid='"+emThree.getEiid()+"'");
								sb.append(" Status='"+i+"'/>");
								flag=true;
							}
						}
					}
				}
				i++;
			}
			sb.append("</root>");
		}
		out.print(sb.toString());
		
	}
	
	 /**
	 * ���ܣ���ά�洢����ƽ̨
	 * @param req
	 * @param out
	 * @param requestMode 
	 * @throws Exception 
	 */

    protected void getBusyForSOCPerformance_V2(HttpServletRequest req,
			PrintWriter out, String requestMode,String requestMode1,String requestMode2,String requestMode3) throws BLException {

    	IGDBS02BL ctlBL = (IGDBS02BL)getBean("IGDBS02BL");		
        Collect_BusySearchCondImpl  cond = new Collect_BusySearchCondImpl();
        String model = ctlBL.getSymm_model(requestMode);
        cond.setDataid(requestMode);
        cond.setDate_from(requestMode1);
        cond.setDate_to(requestMode2);
        cond.setFlag(requestMode3);
        cond.setSymm_model(model);
		String resxml = "";
		resxml = ctlBL.createXml(cond);
		out.print(resxml);	
	}
    
    /**
     * ��������ȡ���
     * @param req
     * @param out
     * @param parameter
     */
    private void getContainTreeNode(HttpServletRequest req, PrintWriter out) throws BLException {
    	String id=req.getParameter("nid");//��ȡ���ID
    	String name=req.getParameter("nname");//��ȡ�������
    	log.debug("======================��ȡ������"+name+"�µĽ�㿪ʼ=========================");
    	//Ϊ���ص��ַ���
    	String returnStr="";
    	//���ؼ���
    	Map<Integer,List<RelationTreeTB>> treeMap=new LinkedHashMap<Integer, List<RelationTreeTB>>();
    	if(id!=null&&id.length()>0){
    		String[] idArr=id.split("_");
    		if(idArr!=null&&idArr.length>6){
    			//�ж������ͻ��Ƕ���   0Ϊģ�� 1Ϊ����
    			String isTypeFlag=idArr[0];
    			Integer eirootmark=Integer.parseInt(idArr[2]);
    			Integer eiversion=Integer.parseInt(idArr[3]);
    			Integer eismallversion=Integer.parseInt(idArr[4]);
    			Integer levelNum=Integer.parseInt(idArr[5]);
    			Integer fathereiid=Integer.parseInt(idArr[6]);
    			if("0".equals(isTypeFlag)){
    				//String eid=idArr[1];
    				String rlnCode=idArr[7];
    				Integer sourceEiid=Integer.parseInt(idArr[8]);
    				treeMap=searchDownTreeNodeByEid(rlnCode,fathereiid,eiversion,eismallversion,eirootmark,
    						levelNum,treeMap,sourceEiid,name);
    			}else{
    				Integer eiid=Integer.parseInt(idArr[1]);
    				Integer sourceEiid=Integer.parseInt(idArr[7]);
    				treeMap=searchDownTreeNodeByEiid(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap,sourceEiid);
    			}
    			returnStr=initChangeJsonObject(treeMap,levelNum);
    		}
    	}
    	log.debug("======================��ȡ�������µĽ�����=========================");
		out.print(returnStr);
	}
    
    /**
	 * ��treeMapת��Ϊjson����Ȼ�󴫸��ַ���
	 * @param Integer levelNum  ��㼶���
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  ��Ž��map
	 */
	public String initChangeJsonObject(Map<Integer,List<RelationTreeTB>> treeMap, Integer levelNum){
		//��Ҫ���ص��ַ���
		String returnStr="";
		if(treeMap!=null&&treeMap.size()>0){
			//1.���Ƚ�map��key����
			Integer[] keyArr=new Integer[treeMap.size()];
			treeMap.keySet().toArray(keyArr);
			//����
			Arrays.sort(keyArr);
			//2.��valueֵתΪ����
			//��������
			JSONArray jsonArr=new JSONArray();
			String lastId="0";
			Map<String, String> itemImageMap = this.getItemImagesInfoByCodeDetail();

			for (Integer key : keyArr) {
				//��ȡ����ֵ
				List<RelationTreeTB> rtList=treeMap.get(key);
				//�ж��Ƿ��Ͻ��
				//id:1, pId:0, name:"����", open:true, iconSkin:"pIcon01"
				//ID����, ģ�� ��������   0_eidֵ_eirootmarkֵ_eiversionֵ_eismallversionֵ_LevelNum_����eiid_��ϵ��ֵ
				//        ������������    1_eiidֵ_eirootmarkֵ_eiversionֵ_eismallversionֵ_LevelNum_����eiid
				try{
					if(key<levelNum){
						for (RelationTreeTB tb : rtList) {
							JSONObject objType=new JSONObject();
							String imagekey = tb.getEid();
							String typeId="0_"+tb.getEid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_0_"+tb.getSourceEiid();
							objType.put(IGCIMConstants.TREE_PARAMETER_ID, typeId);
							objType.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
							objType.put(IGCIMConstants.TREE_PARAMETER_NAME, tb.getEname());
							objType.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_TRUE);
							//���Ǹ��ڵ����Ҷ�ӽڵ�
//							if(IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(tb.getIsLeaf())){
//								objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
//							}else{
//								objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
//							}
							objType = this.getItemImageByName(objType, itemImageMap, imagekey, tb.getIsLeaf(), true);
							jsonArr.put(objType);
							lastId=typeId;
							
							JSONObject obj=new JSONObject();
							String objId="1_"+tb.getEiid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getSourceEiid();
							obj.put(IGCIMConstants.TREE_PARAMETER_ID, objId);
							obj.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
							obj.put(IGCIMConstants.TREE_PARAMETER_NAME, tb.getEiname());
							obj.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_TRUE);
							//���Ǹ��ڵ����Ҷ�ӽڵ�
//							if(IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(tb.getIsLeaf())){
//								obj.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
//							}else{
//								obj.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
//							}
							this.getItemImageByName(obj, itemImageMap, imagekey,tb.getIsLeaf(),false);
							jsonArr.put(obj);
							lastId=objId;
						}
					}else{
						for (RelationTreeTB tb : rtList) {
							JSONObject objType=new JSONObject();
							String typeId="";
							String name="";
							String imagekey = tb.getEid();
							boolean isModel = false;
							if(tb.getRlnCode()!=null&&!"".equals(tb.getRlnCode())){
								typeId="0_"+tb.getEid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getRlnCode()+"_"+tb.getSourceEiid();
								name=tb.getEname();
								isModel = true;
							}else{
								typeId="1_"+tb.getEiid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getSourceEiid();
								name=tb.getEiname();
							}
							objType.put(IGCIMConstants.TREE_PARAMETER_ID, typeId);
							objType.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
							objType.put(IGCIMConstants.TREE_PARAMETER_NAME, name);
							if(IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_TRUE.equals(tb.getIsLeaf())){
								objType.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_FALSE);
							}else{
								
							}
							
							//���Ǹ��ڵ����Ҷ�ӽڵ�
							if(isModel){
								objType.put("isParent", true);
								objType = this.getItemImageByName(objType, itemImageMap, imagekey, "false", isModel);
							}else{
								if("true".equals(tb.getIsLeaf())){
									objType.put("isParent", true);
								}else{
//									objType.put("isParent", false);
								}
								objType = this.getItemImageByName(objType, itemImageMap, imagekey, tb.getIsLeaf(), isModel);
							}
//							if(IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(tb.getIsLeaf())){
//								objType.put("isParent", false);
//								objType = this.getItemImageByName(objType, itemImageMap, imagekey, "true", isModel);
//								objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
//							}else{
//								objType.put("isParent", true);
//								objType = this.getItemImageByName(objType, itemImageMap, imagekey, "false", isModel);
//								objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
//							}
							jsonArr.put(objType);
						}
					}
				}catch (JSONException e) {
					log.debug("=====JSON����====="+e);
				}
			}
			returnStr=jsonArr.toString();
		}
		return returnStr;
	}
    /**
	 * ���ݽ�����²�ѯ�����н��
	 * @param Integer eiid  ��Ҫ��ѯ�Ķ���eiid
	 * @param Integer eiversion  ����汾
	 * @param Integer eismallversion  ����С�汾
	 * @param Integer eirootmark  ���󶥼�eiid
	 * @param Integer levelNum  ��㼶���
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  ��Ž��map
	 */
	public Map<Integer,List<RelationTreeTB>> searchDownTreeNodeByEid(String rlnCode,Integer fathereiid,Integer eiversion,Integer eismallversion,Integer eirootmark,
			Integer levelNum,Map<Integer,List<RelationTreeTB>> treeMap,Integer sourceEiid,String treeName)throws BLException{
		SOC0110BL soc0110BL=(SOC0110BL)getBean("soc0110BL");
		SOC0152BL soc0152BL=(SOC0152BL)getBean("soc0152BL");
		//��ѯ�Ƿ��а����Ĺ�ϵ�Ӷ�������в�����й�ϵ��
		SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(fathereiid+"");
		cond0110.setBrparversion(eiversion+"");
		cond0110.setBrparsmallversion(eismallversion+"");
		cond0110.setBrassetrelation(rlnCode);
		cond0110.setEirootmark(eirootmark.toString());
		//�����ӽ��
		List<SOC0110Info> soc0110infoList=soc0110BL.searchMaxEiBelongRelation(cond0110);
		if(soc0110infoList!=null&&soc0110infoList.size()>0){
			//���Ȳ�ѯ�Ƿ����ӽڵ�
			SOC0110Info fristInfo=soc0110infoList.get(0);
			SOC0123VW fristSoc0123vw=fristInfo.getCldEntityItemVW();
			//��ѯ��ϵ��
			SOC0152SearchCondImpl frist0152Cond=new SOC0152SearchCondImpl();
			//������ϵ��
			frist0152Cond.setRlnType_eq(IGCIMConstants.TYPE_CODE_CONTAIN_RELATION);
			frist0152Cond.setFromModelEid_eq(fristSoc0123vw.getEid()+"");
			//��ѯ�����
			List<SOC0152Info> soc0152List=soc0152BL.searchSOC0152(frist0152Cond);
			//Map �ж��Ƿ����ӽڵ��map
			Map<Integer, List<SOC0110Info>> isLeafMap=new HashMap<Integer, List<SOC0110Info>>();
			//�����ѯ���������ô��ģ���»����ڶ���
			if(soc0152List!=null&&soc0152List.size()>0){
				StringBuilder sb=new StringBuilder();
				for (int i = 0; i < soc0152List.size(); i++) {
					String code=soc0152List.get(i).getRlnCode();
					if(i==(soc0152List.size()-1)){
						sb.append("'"+code+"'");
					}else{
						sb.append("'"+code+"'"+",");
					}
				}
				//��ѯ���������Ƿ��ж���
				SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
				soc0110Cond.setEirootmark(eirootmark+"");
				soc0110Cond.setBrparversion(fristSoc0123vw.getEiversion()+"");
				soc0110Cond.setBrparsmallversion(fristSoc0123vw.getEismallversion()+"");
				soc0110Cond.setBrassetrelation_in(sb.toString());
				List<SOC0110Info> listtmp=soc0110BL.searchInBrassetrelationByEirootmark(soc0110Cond);
				if(listtmp!=null&&listtmp.size()>0){
					for (SOC0110Info info : listtmp) {
						Integer brpareiid=info.getBrpareiid();
						List<SOC0110Info> tmpList=isLeafMap.get(brpareiid);
						if(tmpList==null){
							tmpList=new ArrayList<SOC0110Info>();
						}
						tmpList.add(info);
						isLeafMap.put(brpareiid,tmpList);
					}
				}
			}
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			for (SOC0110Info info : soc0110infoList) {
				SOC0123VW soc0123vw=info.getCldEntityItemVW();
				RelationTreeTB tb=new RelationTreeTB();
				tb.setEiid(soc0123vw.getEiid());
				tb.setEiname(soc0123vw.getEiname());
				tb.setEirootmark(eirootmark);
				tb.setEid(soc0123vw.getEid()+"");
				tb.setFatherEiid(fathereiid);
				tb.setEiversion(soc0123vw.getEiversion());
				tb.setEismallversion(soc0123vw.getEismallversion());
				if(isLeafMap.containsKey(tb.getEiid())){
					tb.setIsLeaf("true");
				}else{
					tb.setIsLeaf("false");
				}
				tb.setSourceEiid(sourceEiid);
				rtlist.add(tb);
			}
			//����map��
			treeMap.put(levelNum+1, rtlist);
		}
		return treeMap;
	}
	
	/**
	 * ���ݽ�����²�ѯ�����н��
	 * @param Integer eiid  ��Ҫ��ѯ�Ķ���eiid
	 * @param Integer eiversion  ����汾
	 * @param Integer eismallversion  ����С�汾
	 * @param Integer eirootmark  ���󶥼�eiid
	 * @param Integer levelNum  ��㼶���
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  ��Ž��map
	 */
	public Map<Integer,List<RelationTreeTB>> searchDownTreeNodeByEiid(Integer eiid,Integer eiversion,Integer eismallversion,Integer eirootmark,
			Integer levelNum,Map<Integer,List<RelationTreeTB>> treeMap,Integer sourceEiid)throws BLException{
		SOC0110BL soc0110BL=(SOC0110BL)getBean("soc0110BL");
		SOC0152BL soc0152BL=(SOC0152BL)getBean("soc0152BL");
		//��ѯ�Ƿ��а����Ĺ�ϵ�Ӷ�������в�����й�ϵ��
		SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(eiid+"");
		cond0110.setBrparversion(eiversion+"");
		cond0110.setBrparsmallversion(eismallversion+"");
//		SOC0118Info soc0118AppInfo=soc0118BL.searchEntityItemByKey(sourceEiid);
//		SOC0118Info soc0118HostInfo=soc0118BL.searchEntityItemByKey(eiid);
//		if("999003001".equals(soc0118AppInfo.getEsyscoding())&&soc0118HostInfo.getEsyscoding().startsWith("999001001")){
//			cond0110.setBrassetrelation_in("'CR010100010014'");
//		}
		//���й�ϵ��
		//���й�ϵ
		List<SOC0110Info> soc0110List=soc0110BL.searchMaxEiBelongRelation(cond0110);
		if(soc0110List!=null&&soc0110List.size()>0){
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			List<String>  formEiid_toEiid=new ArrayList<String>();
			for(SOC0110Info soc0110:soc0110List){
				//���ݹ�ϵ���ѯ��ϵ��ϸ��Ϣ
				SOC0152SearchCondImpl cond0152=new SOC0152SearchCondImpl();
				//������ϵ��
				cond0152.setRlnType_eq(IGCIMConstants.TYPE_CODE_CONTAIN_RELATION);
				if("CM01010020".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010022".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010031".equals(soc0110.getParEntityItemVW().getEid())){
					cond0152.setFromModelEid_eq("CM01010001");
				}else{
					cond0152.setFromModelEid_eq(soc0110.getParEntityItemVW().getEid());
				}
				cond0152.setToModelEid_eq(soc0110.getCldEntityItemVW().getEid());
				String eiids=cond0152.getFromModelEid_eq()+"_"+cond0152.getToModelEid_eq();
				if(!formEiid_toEiid.contains(eiids)){
					formEiid_toEiid.add(eiids);
				}else{
					continue;
				}
				List<SOC0152Info> soc0152InfoList=soc0152BL.searchSOC0152(cond0152);
				if(soc0152InfoList!=null&soc0152InfoList.size()>0){
					//����ϵģ�ͷ�������
					for (SOC0152Info info : soc0152InfoList) {
						RelationTreeTB tb=new RelationTreeTB();
						tb.setEid(info.getToModelEid());
						tb.setEname(info.getToModelName());
						tb.setRlnCode(info.getRlnCode());
						tb.setFatherEiid(eiid);
						tb.setEiversion(eiversion);
						tb.setEismallversion(eismallversion);
						tb.setEirootmark(eirootmark);
						tb.setIsLeaf("false");
						tb.setSourceEiid(eirootmark);
						rtlist.add(tb);
					}
				}
			}
			//����map��
			treeMap.put(levelNum+1, rtlist);
		}
		return treeMap;
	}
	/**
	 * �澯��Ϣ��ѯ�Զ�ˢ��ҳ��
	 * 
	 * @param req
	 * @param out
	 * @throws Exception
	 * @author 
	 */
	private void searchAlm0401List(HttpServletRequest req, PrintWriter out) throws Exception {
		
	    CRM04BL ctlBL = (CRM04BL) getBean("crm04BL");
	   
	    CRM04SearchCondImpl cond = new CRM04SearchCondImpl();
	    
		String count = ResourceUtility.getString("WARNING_MESSAGE_COUNT");

		List<CRM04Info> crm04infoList = ctlBL.searchCRM04(cond,0,Integer.parseInt(count));
        
		StringBuilder sb = new StringBuilder();
		
		for(CRM04Info info : crm04infoList){
			StringBuilder buff = new StringBuilder();
			buff.append(info.getRulelevel()).
			append("#_#").
			append(info.getAlarmtime()).
			append("#_#").
			append(info.getObjectname()).
			append("#_#").
			append(info.getServerip()).
			append("#_#").
			append(info.getCategory()).
			append("#_#").
			append(info.getAlarmmsg());
			sb.append(buff.toString()).append("@_@");
		}
		if(StringUtils.isNotEmpty(sb.toString())){
			out.print(sb.substring(0, sb.length()-3));
		}
	}
	/**
	 * ��ѯҵ��ϵͳxml���� 
	 */
	private void getBussTopoMapXml(HttpServletRequest req, PrintWriter out)throws BLException {
		String FLEXID = req.getParameter("FLEXID");
    	StringBuffer topoXmlStr= new StringBuffer("");
    	TOPOXMLBL tOPOXMLBL=(TOPOXMLBL)getBean("tOPOXMLBL");//read topoxml
    	TOPOXMLSearchCondImpl tcond=new TOPOXMLSearchCondImpl();
    	tcond.setIsellipsis("a");
    	List<TOPOXMLInfo> list_axis=tOPOXMLBL.searchTOPOXML(tcond);
    	HashMap<String, String> topoXYMap = null;
    	if(list_axis != null){
    		if(list_axis.size() >0){
	    		topoXYMap = new HashMap<String, String>();
				for (TOPOXMLInfo xmlinfo : list_axis) {
					topoXYMap.put(xmlinfo.getMyid(), xmlinfo.getAixs());
				}
    		}
    	}
    	String temp_x="";
    	String temp_y="";
    	SOC0118BL soc0118BL =(SOC0118BL)getBean("soc0118BL");//node
    	SOC0107BL soc0107BL =(SOC0107BL)getBean("soc0107BL");//props
    	SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
    	String[] eidArr = new String[4];
    	eidArr[0]="CM03010001";//ҵ��ϵͳ(ƽ̨)
    	eidArr[1]="CM03010002";//�����ṩ��(����)
    	eidArr[2]="CM03010003";//���������(����)
    	eidArr[3]="CM03010004";//����ϵͳ
    	cond.setEid_arr(eidArr);
		SOC0119BL soc0119BL = (SOC0119BL)getBean("soc0119BL");
		SOC0119SearchCondImpl cond0119 = new SOC0119SearchCondImpl();
		String[] arrBR = new String[5];
		arrBR[0]="CR030100010008";
		arrBR[1]="CR030100010009";
		arrBR[2]="CR030100010010";
		arrBR[3]="CR030100010017";
		arrBR[4]="CR030100010018";
    	List<SOC0118Info> list_node =soc0118BL.searchEntityItem(cond);
    	User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
    	UserRoleBL userRoleBL=(UserRoleBL)getBean("userRoleBL");
    	UserRoleSearchCondImpl userCond=new UserRoleSearchCondImpl();
    	userCond.setRoleid(1014);
    	userCond.setUserid(user.getUserid());
    	List<UserRole> userRole=userRoleBL.searchUserRole(userCond);
    	boolean isManage=false;
    	boolean isShow=false;
    	if(userRole!=null&&userRole.size()>0){
    		isManage=true;
    	}
    	if(list_node.size()>0){
    		topoXmlStr.append("<?xml version='1.0' encoding='utf-8'?>");
    		topoXmlStr.append("<root>");
	   		String[] cids={"CI030100010002","CI030100010003","CI030100010004",
	   				"CI030100010005","CI030100010007","CI030100010008","CI030100010009","CI030100010010","CI030100010011","CI030100010012","CI030100010013","CI030100010014","CI030100010023"};
    		SOC0107SearchCondImpl cond0107 = new SOC0107SearchCondImpl();
	   		cond0107.setCids(cids);
	   		List<SOC0107Info> info0107_list=soc0107BL.searchSOC0107(cond0107);
	   		List<SOC0107Info> temp_list= null;	   		
	   		//�������ConfigItem����Mapֵ
	   		Map<String,List<SOC0107Info>> configItemMap =new HashMap<String,List<SOC0107Info>>();
	   		for(SOC0107Info soc0107Info:info0107_list){
	   			String key = soc0107Info.getEiid().toString()+soc0107Info.getCiversion().toString()+soc0107Info.getCismallversion().toString();
	   			if(configItemMap.get(key)!=null){
	   				configItemMap.get(key).add(soc0107Info);
	   			}else{
	   				temp_list= new ArrayList<SOC0107Info>();
	   				temp_list.add(soc0107Info);
	   				configItemMap.put(key, temp_list);
	   			}
	   		}
	   		//�������119��ϵ����Ϣ
	   		Map<String,List<SOC0119Info>> soc0119Map =new HashMap<String,List<SOC0119Info>>();
    		cond0119.setEirrelation_in(arrBR);
    		cond0119.setDeleteflag("0");
    		List<SOC0119Info> list_temp = soc0119BL.searchEntityItemRelation(cond0119);
    		List<SOC0119Info> soc0119_list= null;
    		for(SOC0119Info soc0119Info:list_temp){
    			String key = soc0119Info.getPareiid().toString()+soc0119Info.getParversion().toString()+soc0119Info.getParsmallversion().toString();
	   			if(soc0119Map.get(key)!=null){
	   				soc0119Map.get(key).add(soc0119Info);
	   			}else{
	   				soc0119_list= new ArrayList<SOC0119Info>();
	   				soc0119_list.add(soc0119Info);
	   				soc0119Map.put(key, soc0119_list);
	   			}
    		}
    		
    		//ƴxml NODE
    		for (SOC0118Info soc0118Info : list_node) {
    			String datatips ="";
    			Boolean hasLink = false;//����·
    	   		if (topoXYMap != null) {
        			if(StringUtils.isNotEmpty(  topoXYMap.get(soc0118Info.getEiid().toString()) )){
        				temp_x=topoXYMap.get(soc0118Info.getEiid().toString()).split("\\,")[0];
        				temp_y=topoXYMap.get(soc0118Info.getEiid().toString()).split("\\,")[1];
        			}
        		}
    	   		String keys = soc0118Info.getEiid().toString()+soc0118Info.getEiversion().toString()+soc0118Info.getEismallversion().toString();
    	   		List<SOC0107Info> configList = configItemMap.get(keys);
/*    	   		cond0107.setEiid(soc0118Info.getEiid().toString());
    	   		cond0107.setCiversion(soc0118Info.getEiversion().toString());
    	   		cond0107.setCismallversion(soc0118Info.getEismallversion().toString());
    	   		String[] cids={"CI030100010002","CI030100010003","CI030100010004",
    	   				"CI030100010005","CI030100010007","CI030100010008","CI030100010009","CI030100010010","CI030100010011","CI030100010012","CI030100010013","CI030100010014","CI030100010023"};
    	   		cond0107.setCids(cids);
    	   		List<SOC0107Info> info0107_list=soc0107BL.searchSOC0107(cond0107);//datatips*/
    	   		if(configList!=null){
        	   		for (SOC0107Info soc0107Info : configList) {
        	   			if("CI030100010002".equals(soc0107Info.getCid())||"CI030100010003".equals(soc0107Info.getCid())){
        	   				if(StringUtils.isNotEmpty(soc0107Info.getCivalue())){
        	   					datatips+=soc0107Info.getConfiguration().getCname()+": "+soc0107Info.getCivalue().substring(0, soc0107Info.getCivalue().indexOf("("))+"\n";
        	   				}else{
        	   					datatips+=soc0107Info.getConfiguration().getCname()+": "+soc0107Info.getCivalue()+"\n";
        	   				}
        	   			}else{
        	   				datatips+=soc0107Info.getConfiguration().getCname()+": "+soc0107Info.getCivalue()+"\n";
        	   			}
        	   			//has link
        	   			if("CI030100010002".equals(soc0107Info.getCid())||"CI030100010003".equals(soc0107Info.getCid())){
    	   					if(StringUtils.isNotEmpty(soc0107Info.getCivalue())&&soc0107Info.getCivalue().startsWith(user.getUsername())){
    	   						isShow=true;
    	   					}
    	   				}
    	   				if("CI030100010023".equals(soc0107Info.getCid())){
        	   				if(StringUtils.isNotEmpty(soc0107Info.getCivalue())){
        	   					if(soc0107Info.getCivalue().equals("��")){
        	   						if(isManage){
        	   							hasLink =true;
        	   						}else if(isShow){
        	   							hasLink=true;
        	   						}
        	   						
        	   					}
        	   				}
        	   			}
    				}
    	   		}
    	   		isShow=false;
        		topoXmlStr.append("<NODE id='"+soc0118Info.getEiid()+"' datatips='"+datatips+"' name='"+soc0118Info.getEiname().replaceAll("[\r\n]", "")+"' x='"+temp_x+"' y='"+temp_y+"' imgUrl='"+getImageType(soc0118Info.getEid(),hasLink)+"'/>");//switch
        		//ƴxml LINE
/*        		cond0119.setPareiid(soc0118Info.getEiid());
        		cond0119.setParversion(soc0118Info.getEiversion());
        		cond0119.setParsmallversion(soc0118Info.getEismallversion());
        		cond0119.setEirrelation_in(arrBR);
        		cond0119.setDeleteflag("0");
        		List<SOC0119Info> list_line = soc0119BL.searchEntityItemRelation(cond0119);*/
        		List<SOC0119Info> list_line = soc0119Map.get(keys);
        		if(list_line!=null){
            		for (SOC0119Info soc0119Info : list_line) {
            			topoXmlStr.append("<LINE id='"+Math.random()+"' setColorStyle='"+getBRcolor(soc0119Info.getEirrelation())+"' fromNode='"+soc0119Info.getPareiid().toString()+"' toNode='"+soc0119Info.getCldeiid().toString()+"'/>");
            		}
        		}
    		}
    		//ƴxml <REGION>
			UserRegionBL userRegionBL = (UserRegionBL)getBean("userRegionBL");
			UserRegionSearchCondImpl cond_ur = new UserRegionSearchCondImpl();
			cond_ur.setFLEXID(FLEXID);
			cond_ur.setUSERID(user.getUserid());
			List<UserRegionInfo> list_ur = userRegionBL.searchUserRegion(cond_ur);
			for (UserRegionInfo urInfo : list_ur) {
				topoXmlStr.append("<REGION id='"+urInfo.getID()+"' x='"+urInfo.getX()+"' y='"+urInfo.getY()+"' width='"+urInfo.getWidth()+"' height='"+urInfo.getHeight()+"' title='"+urInfo.getTitle()+"' />");
			}
    		topoXmlStr.append("</root>");
    	}
    	out.print(topoXmlStr.toString());
	}
	
	/**
	 * Ӧ��ά�����˲�ѯ
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void getBusinessTopoXML(HttpServletRequest req, PrintWriter out)throws BLException {
		//1��˫��ҳ��ɵõ�eiid��ѯsoc0118���eiversiion��eismallversion;
		//2����ѯsoc0125��ͼ�õ���ID����汾��
		SOC0118BL soc0118BL = (SOC0118BL)getBean("soc0118BL");
		SOC0125BL soc0125BL = (SOC0125BL)getBean("soc0125BL");
		String eiid=req.getParameter("eiid");
		String FLEXID = req.getParameter("FLEXID");
		String xml="";
		if(StringUtils.isNotEmpty(eiid)&&!"null".equals(eiid)){
			SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			Integer eiversion=soc0118Info.getEiversion();
			Integer eismallversion=soc0118Info.getEismallversion();
			SOC0125Info soc0125Info = soc0125BL.searchEiDomainDefVW("1");
			Integer domainid=soc0125Info.getEiddid();
			Integer domainversion=soc0125Info.getVersion();
			//3������eiid��eiversiion��eismallversion����ID����汾��fingerprint����������ѯsoc0114���и�ҵ��ϵͳ������������·��
			SOC0114VW_FXBL soc0114VW_FXBL = (SOC0114VW_FXBL) getBean("soc0114VW_FXBL");
			SOC0114VW_FXSearchCondImpl cond = new SOC0114VW_FXSearchCondImpl();
			cond.setEiid(Integer.parseInt(eiid));
			cond.setEiversion(eiversion);
			cond.setEismallversion(eismallversion);
			cond.setDomainid(domainid);
			cond.setDomainversion(domainversion);
			log.debug("========��ѯҵ����·��ϵ��ʼ========");
			xml = soc0114VW_FXBL.searchSOC0114VW_FXAPPByCond(cond,FLEXID);
			//String[] xmlStr=xml.split("@");//��ѯ��·��ϵ��ʼ
			log.debug("========��ѯҵ����·��ϵ����========");
			log.debug("========Buss topo map Fuxin������ʾ��������========");
		}
		if(StringUtils.isNotEmpty(xml)){
			out.print(xml);
		}else{
			out.print("");
		}
	}
	
	private void getHostEiidByVW(HttpServletRequest req, PrintWriter out)throws BLException {
		log.debug("========���⻯���˳�����ʾ����ʼ========");
		String hostEiid="";
		SOC0118BL soc0118BL = (SOC0118BL)getBean("soc0118BL");
		SOC0107BL soc0107BL = (SOC0107BL)getBean("soc0107BL");
		String eiid=req.getParameter("eiid");
		if(StringUtils.isNotEmpty(eiid)){
			//1��˫��ҳ��ɵõ�eiid��ѯsoc0118���eiversiion��eismallversion;
			SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			SOC0107SearchCondImpl cond=new SOC0107SearchCondImpl();
			cond.setEiid(soc0118Info.getEiid().toString());
			cond.setCiversion(soc0118Info.getEiversion().toString());
			cond.setCismallversion(soc0118Info.getEismallversion().toString());
			hostEiid=soc0107BL.getHostEiid(cond);
			
		}
		if(StringUtils.isNotEmpty(hostEiid)){
			out.print(hostEiid);
		}else{
			out.print("");
		}

	}
	
	/**
	 * ���⻯���˲�ѯ
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void getVWTopoXML(HttpServletRequest req, PrintWriter out)throws BLException {
		log.debug("========���⻯���˳�����ʾ����ʼ========");
		String xmlData="";
		SOC0118BL soc0118BL = (SOC0118BL)getBean("soc0118BL");
		String eiid=req.getParameter("eiid");
		if(StringUtils.isNotEmpty(eiid)&&!"null".equals(eiid)){
			//1��˫��ҳ��ɵõ�eiid��ѯsoc0118���eiversiion��eismallversion;
			SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			if("CM01010052".equals(soc0118Info.getEid())){
				xmlData=getVirtualMachine(soc0118Info);
			}else if("CM01010053".equals(soc0118Info.getEid())||"CM01010054".equals(soc0118Info.getEid())){
				xmlData=getNetworkOrDataStore(soc0118Info);
			}else if("CM01010051".equals(soc0118Info.getEid())){
				xmlData=getVMWARE_ESX(soc0118Info);
			}
		}
		if(StringUtils.isNotEmpty(xmlData)){
			out.print(xmlData);
		}else{
			out.print("");
		}

	}
	
	private String getVMWARE_ESX(SOC0118Info soc0118Info){
		String temp_x="";
    	String temp_y="";
    	String isellipsis="V1";
		SOC0110BL soc0110BL = (SOC0110BL)getBean("soc0110BL");
		SOC0154BL soc0154BL = (SOC0154BL)getBean("soc0154BL");
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		StringBuffer brassetrelation_in=new StringBuffer();
		brassetrelation_in.append("'CR010100510001'");
		soc0110Cond.setBrassetrelation_in(brassetrelation_in.toString());
		soc0110Cond.setBrpareiid(soc0118Info.getEiid().toString());
		soc0110Cond.setBrparversion(soc0118Info.getEiversion().toString());
		soc0110Cond.setBrparsmallversion(soc0118Info.getEismallversion().toString());
		List<SOC0110Info> soc0110InfoList=soc0110BL.searchMaxEiBelongRelation(soc0110Cond);
		SOC0154SearchCondImpl soc0154Cond=new SOC0154SearchCondImpl();
		soc0154Cond.setFromid(soc0118Info.getEiid().toString());
		soc0154Cond.setIsellipsis(isellipsis);
		List<SOC0154Info>  soc0154InfoList=soc0154BL.searchSoc0154(soc0154Cond);
		String xmlData = "";
		xmlData="<?xml version='1.0' encoding='utf-8'?><root>";
		List<String> eiidList=new ArrayList<String>();
		Map<String, String> colorMap=new HashMap<String, String>();
		colorMap.put("CR010100520001", "0");
		colorMap.put("CR010100520002", "1");
		colorMap.put("CR010100510001", "2");
		String colorStyle="";
		String smalltype="";
		brassetrelation_in=new StringBuffer();
		brassetrelation_in.append("'CR010100520001'").append(",");
		brassetrelation_in.append("'CR010100520002'");
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info info:soc0110InfoList){
				if(soc0154InfoList!=null&&soc0154InfoList.size()>0){
					for (SOC0154Info xmlinfo : soc0154InfoList) {
		    			if(xmlinfo.getMyid().equals(info.getBrcldeiid().toString())){
		    				temp_x=xmlinfo.getAixs().split("\\,")[0];
		    				temp_y=xmlinfo.getAixs().split("\\,")[1];
		    				break;
		    			}
		    		}
				}
				if(!eiidList.contains(info.getBrcldeiid().toString())){
					xmlData=xmlData+"<NODE id='"+info.getBrcldeiid()+"' eirootmark='"+info.getCldEntityItemVW().getEirootmark()
					+"' name='"+info.getCldEntityItemVW().getEiname()+
					"' version='"+info.getBrcldversion()+"' smallversion='"+info.getBrcldsmallversion()+
					"' alert='false' parentnode='' datatips='"+info.getCldEntityItemVW().getEiname()+
					"' x='"+temp_x+"' y='"+temp_y+"' smalltype='4'/>";
					eiidList.add(info.getBrcldeiid().toString());
				}
				soc0110Cond.setBrassetrelation_in(brassetrelation_in.toString());
				soc0110Cond.setBrpareiid(info.getBrcldeiid().toString());
				soc0110Cond.setBrparversion(info.getBrcldversion().toString());
				soc0110Cond.setBrparsmallversion(info.getBrcldsmallversion().toString());
				List<SOC0110Info> soc0110List=soc0110BL.searchMaxEiBelongRelation(soc0110Cond);
				if(soc0110List!=null&&soc0110List.size()>0){
					for(SOC0110Info soc0110Info:soc0110List){
						if(soc0154InfoList!=null&&soc0154InfoList.size()>0){
							for (SOC0154Info xmlinfo : soc0154InfoList) {
				    			if(xmlinfo.getMyid().equals(soc0110Info.getBrcldeiid().toString())){
				    				temp_x=xmlinfo.getAixs().split("\\,")[0];
				    				temp_y=xmlinfo.getAixs().split("\\,")[1];
				    				break;
				    			}
				    		}
						}
						if("CM01010053".equals(soc0110Info.getCldEntityItemVW().getEid())){
							smalltype="3";
						}else if("CM01010054".equals(soc0110Info.getCldEntityItemVW().getEid())){
							smalltype="2";
						}
						colorStyle=colorMap.get(soc0110Info.getBrassetrelation());
						if(!eiidList.contains(soc0110Info.getBrcldeiid().toString())){
							xmlData=xmlData+"<NODE id='"+soc0110Info.getBrcldeiid()+"' eirootmark='"+soc0110Info.getCldEntityItemVW().getEirootmark()
							+"' name='"+soc0110Info.getCldEntityItemVW().getEiname()+
							"' version='"+soc0110Info.getBrcldversion()+"' smallversion='"+soc0110Info.getBrcldsmallversion()+
							"' alert='false' parentnode='' datatips='"+soc0110Info.getCldEntityItemVW().getEiname()+
							"' x='"+temp_x+"' y='"+temp_y+"' smalltype='"+smalltype+"'/>";
							eiidList.add(soc0110Info.getBrcldeiid().toString());
						}
						xmlData=xmlData+"<LINE id='"+Math.random()+"' fromNode='"+soc0110Info.getBrpareiid()+
						"' toNode='"+soc0110Info.getBrcldeiid()+"' setColorStyle='"+colorStyle+"'/>";
					}
				}
				
			}
		}
		xmlData=xmlData+"</root>";
		return xmlData;
	}
	
	
	private String getNetworkOrDataStore(SOC0118Info soc0118Info){
		String smalltype="";
		String isellipsis="";
		String temp_x="";
    	String temp_y="";
		SOC0110BL soc0110BL = (SOC0110BL)getBean("soc0110BL");
		SOC0154BL soc0154BL = (SOC0154BL)getBean("soc0154BL");
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		StringBuffer brassetrelation_in=new StringBuffer();
		if("CM01010053".equals(soc0118Info.getEid())){
			brassetrelation_in.append("'CR010100520001'");
			smalltype="3";
			isellipsis="V3";
		}else if("CM01010054".equals(soc0118Info.getEid())){
			brassetrelation_in.append("'CR010100520002'");
			smalltype="2";
			isellipsis="V4";
		}
		soc0110Cond.setBrassetrelation_in(brassetrelation_in.toString());
		soc0110Cond.setBrcldeiid(soc0118Info.getEiid().toString());
		soc0110Cond.setBrcldversion(soc0118Info.getEiversion().toString());
		soc0110Cond.setBrcldsmallversion(soc0118Info.getEismallversion().toString());
		List<SOC0110Info> soc0110InfoList=soc0110BL.searchMaxEiBelongRelation(soc0110Cond);
		SOC0154SearchCondImpl soc0154Cond=new SOC0154SearchCondImpl();
		soc0154Cond.setFromid(soc0118Info.getEiid().toString());
		soc0154Cond.setIsellipsis(isellipsis);
		List<SOC0154Info>  soc0154InfoList=soc0154BL.searchSoc0154(soc0154Cond);
		String xmlData = "";
		xmlData="<?xml version='1.0' encoding='utf-8'?><root>";
		List<String> eiidList=new ArrayList<String>();
		if(soc0154InfoList!=null&&soc0154InfoList.size()>0){
			for (SOC0154Info xmlinfo : soc0154InfoList) {
    			if(xmlinfo.getMyid().equals(soc0118Info.getEiid().toString())){
    				temp_x=xmlinfo.getAixs().split("\\,")[0];
    				temp_y=xmlinfo.getAixs().split("\\,")[1];
    				break;
    			}
    		}
		}
		xmlData=xmlData+"<NODE id='"+soc0118Info.getEiid()+"' eirootmark='"+soc0118Info.getEirootmark()+"' name='"+soc0118Info.getEiname()+
		"' version='"+soc0118Info.getEiversion()+"' smallversion='"+soc0118Info.getEismallversion()+
		"' alert='false' parentnode='' datatips='"+soc0118Info.getEiname()+
		"' x='"+temp_x+"' y='"+temp_y+"' smalltype='"+smalltype+"'/>";
		Map<String, String> colorMap=new HashMap<String, String>();
		colorMap.put("CR010100520001", "0");
		colorMap.put("CR010100520002", "1");
		colorMap.put("CR010100510001", "2");
		String colorStyle="";
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info info:soc0110InfoList){
				if(soc0154InfoList!=null&&soc0154InfoList.size()>0){
					for (SOC0154Info xmlinfo : soc0154InfoList) {
		    			if(xmlinfo.getMyid().equals(info.getBrpareiid().toString())){
		    				temp_x=xmlinfo.getAixs().split("\\,")[0];
		    				temp_y=xmlinfo.getAixs().split("\\,")[1];
		    				break;
		    			}
		    		}
				}
				colorStyle=colorMap.get(info.getBrassetrelation());
				if(!eiidList.contains(info.getBrpareiid().toString())){
					xmlData=xmlData+"<NODE id='"+info.getBrpareiid()+"' eirootmark='"+info.getParEntityItemVW().getEirootmark()
					+"' name='"+info.getParEntityItemVW().getEiname()+
					"' version='"+info.getBrparversion()+"' smallversion='"+info.getBrparsmallversion()+
					"' alert='false' parentnode='' datatips='"+info.getParEntityItemVW().getEiname()+
					"' x='"+temp_x+"' y='"+temp_y+"' smalltype='4'/>";
					xmlData=xmlData+"<LINE id='"+Math.random()+"' fromNode='"+info.getBrpareiid()+
					"' toNode='"+info.getBrcldeiid()+"' setColorStyle='"+colorStyle+"'/>";
					eiidList.add(info.getBrcldeiid().toString());
				}
			}
		}
		xmlData=xmlData+"</root>";
		return xmlData;
	}
	
	private String getVirtualMachine(SOC0118Info soc0118Info){
		String temp_x="";
    	String temp_y="";
    	String isellipsis="V2";
		SOC0110BL soc0110BL = (SOC0110BL)getBean("soc0110BL");
		SOC0154BL soc0154BL = (SOC0154BL)getBean("soc0154BL");
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		StringBuffer brassetrelation_in=new StringBuffer();
		brassetrelation_in.append("'CR010100520001'").append(",");
		brassetrelation_in.append("'CR010100520002'");
		soc0110Cond.setBrassetrelation_in(brassetrelation_in.toString());
		soc0110Cond.setBrpareiid(soc0118Info.getEiid().toString());
		soc0110Cond.setBrparversion(soc0118Info.getEiversion().toString());
		soc0110Cond.setBrparsmallversion(soc0118Info.getEismallversion().toString());
		List<SOC0110Info> soc0110InfoList=soc0110BL.searchMaxEiBelongRelation(soc0110Cond);
		SOC0154SearchCondImpl soc0154Cond=new SOC0154SearchCondImpl();
		soc0154Cond.setFromid(soc0118Info.getEiid().toString());
		soc0154Cond.setIsellipsis(isellipsis);
		List<SOC0154Info>  soc0154InfoList=soc0154BL.searchSoc0154(soc0154Cond);
		String xmlData = "";
		xmlData="<?xml version='1.0' encoding='utf-8'?><root>";
		if(soc0154InfoList!=null&&soc0154InfoList.size()>0){
			for (SOC0154Info xmlinfo : soc0154InfoList) {
    			if(xmlinfo.getMyid().equals(soc0118Info.getEiid().toString())){
    				temp_x=xmlinfo.getAixs().split("\\,")[0];
    				temp_y=xmlinfo.getAixs().split("\\,")[1];
    				break;
    			}
    		}
		}
		List<String> eiidList=new ArrayList<String>();
		String smalltype="4";
		xmlData=xmlData+"<NODE id='"+soc0118Info.getEiid()+"' eirootmark='"+soc0118Info.getEirootmark()+"' name='"+soc0118Info.getEiname()+
		"' version='"+soc0118Info.getEiversion()+"' smallversion='"+soc0118Info.getEismallversion()+
		"' alert='false' parentnode='' datatips='"+soc0118Info.getEiname()+
		"' x='"+temp_x+"' y='"+temp_y+"' smalltype='"+smalltype+"'/>";
		Map<String, String> colorMap=new HashMap<String, String>();
		colorMap.put("CR010100520001", "0");
		colorMap.put("CR010100520002", "1");
		colorMap.put("CR010100510001", "2");
		String colorStyle="";
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info info:soc0110InfoList){
				if(soc0154InfoList!=null&&soc0154InfoList.size()>0){
					for (SOC0154Info xmlinfo : soc0154InfoList) {
		    			if(xmlinfo.getMyid().equals(info.getBrcldeiid().toString())){
		    				temp_x=xmlinfo.getAixs().split("\\,")[0];
		    				temp_y=xmlinfo.getAixs().split("\\,")[1];
		    				break;
		    			}
		    		}
				}
				if("CM01010053".equals(info.getCldEntityItemVW().getEid())){
					smalltype="3";
				}else if("CM01010054".equals(info.getCldEntityItemVW().getEid())){
					smalltype="2";
				}
				colorStyle=colorMap.get(info.getBrassetrelation());
				if(!eiidList.contains(info.getBrcldeiid().toString())){
					xmlData=xmlData+"<NODE id='"+info.getBrcldeiid()+"' eirootmark='"+info.getCldEntityItemVW().getEirootmark()
					+"' name='"+info.getCldEntityItemVW().getEiname()+
					"' version='"+info.getBrcldversion()+"' smallversion='"+info.getBrcldsmallversion()+
					"' alert='false' parentnode='' datatips='"+info.getCldEntityItemVW().getEiname()+
					"' x='"+temp_x+"' y='"+temp_y+"' smalltype='"+smalltype+"'/>";
					xmlData=xmlData+"<LINE id='"+Math.random()+"' fromNode='"+info.getBrpareiid()+
					"' toNode='"+info.getBrcldeiid()+"' setColorStyle='"+colorStyle+"'/>";
					eiidList.add(info.getBrcldeiid().toString());
				}
			}
		}
		xmlData=xmlData+"</root>";
		log.debug("========���⻯���˳�����ʾ��������========");
		return xmlData;
	}
	
	/**
	 * Ӧ��ά�����˲�ѯ
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void getBusinessTopoXMLForBJ(HttpServletRequest req, PrintWriter out)throws BLException {
		//1��˫��ҳ��ɵõ�eiid��ѯsoc0118���eiversiion��eismallversion;
		//2����ѯsoc0125��ͼ�õ���ID����汾��
		SOC0118BL soc0118BL = (SOC0118BL)getBean("soc0118BL");
		SOC0125BL soc0125BL = (SOC0125BL)getBean("soc0125BL");
		Integer eiid=Integer.parseInt(req.getParameter("eiid"));
		SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(eiid);
		Integer eiversion=soc0118Info.getEiversion();
		Integer eismallversion=soc0118Info.getEismallversion();
		SOC0125Info soc0125Info = soc0125BL.searchEiDomainDefVW("1");
		Integer domainid=soc0125Info.getEiddid();
		Integer domainversion=soc0125Info.getVersion();
		//3������eiid��eiversiion��eismallversion����ID����汾��fingerprint����������ѯsoc0114���и�ҵ��ϵͳ������������·��
		SOC0114VW_FXBL soc0114VW_FXBL = (SOC0114VW_FXBL) getBean("soc0114VW_FXBL");
		SOC0114VW_FXSearchCondImpl cond = new SOC0114VW_FXSearchCondImpl();
		cond.setEiid(eiid);
		cond.setEiversion(eiversion);
		cond.setEismallversion(eismallversion);
		cond.setDomainid(domainid);
		cond.setDomainversion(domainversion);
		log.debug("========��ѯҵ����·��ϵ��ʼ========");
		String xml = soc0114VW_FXBL.searchSOC0114VW_BJByCond(cond);
		String[] xmlStr=xml.split("@");//��ѯ��·��ϵ��ʼ
		log.debug("========��ѯҵ����·��ϵ����========");
		log.debug("========Buss topo map Beijin������ʾ��������========");
		if(xmlStr!=null&&xmlStr.length>1){
			out.print(xml);
		}else{
			out.print("");
		}
	}
	
	
	//��ȡͼƬ����
	private String getImageType(String eid,Boolean hasLinK){
		//"CM03010001";//ҵ��ϵͳ(ƽ̨)
    	//"CM03010002";//�����ṩ��(����)
		//"CM03010003";//���������(����)
    	//"CM03010004";//����ϵͳ(ƽ̨)
		String PlatFormServerImg="resource/image/monitor/pt.png";
    	String PlatFormServerHasLinkImg="resource/image/monitor/pt_has.png";
    	String BussProviderImg="resource/image/monitor/Srv-Provider.png";
    	String BussCallerImg="resource/image/monitor/Srv-Caller.png";
    	String outsideSystemImg="resource/image/monitor/outside_system.png";
    	String outsideSystemHasLinkImg="resource/image/monitor/outside_system_has.png";
    	if("CM03010001".equalsIgnoreCase(eid)){
    		return (hasLinK?PlatFormServerHasLinkImg:PlatFormServerImg);
    	}else if("CM03010002".equalsIgnoreCase(eid)){
    		return BussProviderImg;
    	}else if("CM03010003".equalsIgnoreCase(eid)){
    		return BussCallerImg;
    	}else if("CM03010004".equalsIgnoreCase(eid)){
    		return (hasLinK?outsideSystemHasLinkImg:outsideSystemImg);
    	}else{
    		return PlatFormServerImg;
    	}
	}
	//��ȡҵ��ϵͳ��ϵline��ɫ
	private String getBRcolor(String brassets){
		if("CR030100010008".equalsIgnoreCase(brassets)){
			return "1";//��
		}else if("CR030100010009".equalsIgnoreCase(brassets)){
			return "2";//��
		}else{
			return "3";//��
		}
	}
	/**
	 * ����ҵ��ϵͳ����xml����
	 */
	private void saveBussTopoXML(HttpServletRequest req, PrintWriter out)throws BLException {
		String outputStr="����ʧ��";
		String xmlstr=req.getParameter("xmlstr");
		String isellipsis=req.getParameter("isellipsis");
		String addRegionStr=req.getParameter("addRegionStr");
		String modRegionStr=req.getParameter("modRegionStr");
		String delRegionStr = req.getParameter("delRegionStr");
		String FLEXID = req.getParameter("FLEXID");
		String eiid=req.getParameter("eiid");
		UserRegionBL userRegionBL = (UserRegionBL)getBean("userRegionBL");
		SOC0118BL soc0118BL = (SOC0118BL)getBean("soc0118BL");
		
		if(StringUtils.isNotEmpty(xmlstr)){
			String[] bigEL=xmlstr.split("\\|");
			TOPOXMLBL tOPOXMLBL=(TOPOXMLBL)getBean("tOPOXMLBL");
			for (int i = 0; i < bigEL.length; i++) {
				String[] smallEL=bigEL[i].split("@");//192.168.1.0@x,y
				String address=smallEL[0];//eiid
				String aixs=smallEL[1];
				TOPOXMLTB topoxml=new TOPOXMLTB();
				topoxml.setMyid(address);//primary key
				topoxml.setAixs(aixs);
				topoxml.setIsellipsis(isellipsis);
				tOPOXMLBL.registTOPOXML(topoxml);
			}
			outputStr="����ɹ�";
//			out.print(outputStr);
		}
		//�����������
		if(StringUtils.isNotEmpty(addRegionStr)){
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			String userid=null;
			if(StringUtils.isNotEmpty(eiid)){
				userid=eiid;
			}else{
				userid=user.getUserid();
			}
			String[] regionArr = addRegionStr.split("\\|");
			for (String ragOBJ : regionArr) {
				String[] regArr = ragOBJ.split("@");
	            String x =regArr[0]; 
	            String y =regArr[1]; 
	            String width =regArr[2]; 
	            String height =regArr[3];
	            String title =regArr[4];
	            UserRegionTB urTB = new UserRegionTB();
	            urTB.setFlexID(FLEXID);
	            urTB.setUserID(userid);
	            urTB.setX(x);
	            urTB.setY(y);
	            urTB.setWidth(width);
	            urTB.setHeight(height);
	            urTB.setTitle(title);
	            userRegionBL.registUserRegion(urTB);
	            SOC0118TB soc0118TB=new SOC0118TB();
	    		soc0118TB.setEid("CM01010042");
	    		soc0118TB.setEiupdtime(IGStringUtils.getCurrentDateTime());
	    		soc0118TB.setEiinsdate(IGStringUtils.getCurrentDate());
	    		soc0118TB.setEsyscoding("999001038");
	    		soc0118TB.setEiversion(1);
	    		soc0118TB.setEismallversion(0);
	    		soc0118TB.setEistatus("N");
	    		soc0118TB.setEiuserid(user.getUserid());
	    		soc0118TB.setEiusername(user.getUsername());
	    		try {
	    			SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
	    			cond.setEilabel("ZJQY" + IGStringUtils.getCurrentYear().substring(2));
	    			String eilabel = soc0118BL.searchNextEntityItemLable(cond);
	    			soc0118TB.setEiname(eilabel);
	    			soc0118TB.setEilabel(eilabel);
	    			SOC0118Info soc0118Info=soc0118BL.registEntityItem(soc0118TB);
	    			SOC0118TB soc0118TBClone=(SOC0118TB)SerializationUtils.clone(soc0118Info);
	    			soc0118TBClone.setEirootmark(soc0118TBClone.getEiid());
	    			soc0118BL.updateEntityItem(soc0118TBClone);
	    		} catch (BLException e) {
	    			e.printStackTrace();
	    		}
			}
			outputStr="����ɹ�";
		}
		//�����޸�����
		if(StringUtils.isNotEmpty(modRegionStr)){
			String[] regionArr = modRegionStr.split("\\|");
			for (String ragOBJ : regionArr) {
				String[] regArr = ragOBJ.split("@");
				Integer ID =Integer.parseInt(regArr[0]);
	            String x =regArr[1]; 
	            String y =regArr[2]; 
	            String width =regArr[3]; 
	            String height =regArr[4];
	            String title = regArr[5];
	            UserRegionInfo urInfo = userRegionBL.searchUserRegionByPK(ID);
	            UserRegionTB urTB = (UserRegionTB)SerializationUtils.clone(urInfo);
	            urTB.setX(x);
	            urTB.setY(y);
	            urTB.setWidth(width);
	            urTB.setHeight(height);
	            urTB.setTitle(title);
	            userRegionBL.updateUserRegion(urTB);
			}
			outputStr="����ɹ�";
		}
		// ɾ������
		if (StringUtils.isNotEmpty(delRegionStr)) {
		    String[] regionArr = delRegionStr.split("\\|");
		    for (String region : regionArr) {
		    	UserRegionInfo userR=userRegionBL.searchUserRegionByPK(Integer.parseInt(region));
		    	String[] title=userR.getTitle().split(":");
		    	String eilabel="";
		    	if(title!=null&&title.length>2){
		    		eilabel=title[2];
		    	}
		    	if(StringUtils.isNotEmpty(eilabel)){
		    		soc0118BL.deleteEntityItemByEilabel(eilabel);
		    	}
		        userRegionBL.deleteUserRegionByPK(Integer.parseInt(region));
            }
		    outputStr="����ɹ�";
		}
		
		out.print(outputStr);
	}
	
	/**
	 * ���⻯��·����
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void saveVWTopoXML(HttpServletRequest req, PrintWriter out)throws BLException {
		String isellipsis="";
		String xmlstr=req.getParameter("xmlstr");
		String eiid=req.getParameter("eiid");
		SOC0118BL soc0118BL=(SOC0118BL)getBean("soc0118BL");
		SOC0118Info soc0118Info=soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
		if(soc0118Info!=null){
			if("CM01010051".equals(soc0118Info.getEid())){
				isellipsis="V1";
			}else if("CM01010052".equals(soc0118Info.getEid())){
				isellipsis="V2";
			}else if("CM01010053".equals(soc0118Info.getEid())){
				isellipsis="V3";
			}else if("CM01010054".equals(soc0118Info.getEid())){
				isellipsis="V4";
			}
		}
		if(StringUtils.isNotEmpty(xmlstr)){
			String[] bigEL=xmlstr.split("\\|");
			SOC0154BL soc0154BL=(SOC0154BL)getBean("soc0154BL");
			for (int i = 0; i < bigEL.length; i++) {
				String[] smallEL=bigEL[i].split("@");//192.168.1.0@x,y
				String address=smallEL[0];//eiid
				String aixs=smallEL[1];
				SOC0154TB soc0154=new SOC0154TB();
				soc0154.setMyid(address);//primary key
				soc0154.setAixs(aixs);
				soc0154.setFromid(eiid);
				soc0154.setIsellipsis(isellipsis);
				soc0154BL.registSoc0154(soc0154);
			}
			out.print("����ɹ�");
			return;
		}
		out.print("����ʧ��");
	}
	
	/**
     * �������ˣ���ϵ����ȡ���
     * @param req
     * @param out
     */
    private void getBusinessTreeNode(HttpServletRequest req, PrintWriter out) throws BLException {
    	String id=req.getParameter("nid");//��ȡ���ID
    	String name=req.getParameter("nname");//��ȡ�������
    	log.debug("======================��ȡ������"+name+"�µĽ�㿪ʼ=========================");
    	//Ϊ���ص��ַ���
    	String returnStr="";
    	//���ؼ���
    	Map<Integer,List<RelationTreeTB>> treeMap=new LinkedHashMap<Integer, List<RelationTreeTB>>();
    	if(id!=null&&id.length()>0){
    		String[] idArr=id.split("_");
    		if(idArr!=null&&idArr.length>6){
    			Integer eiversion=Integer.parseInt(idArr[3]);
    			Integer eismallversion=Integer.parseInt(idArr[4]);
    			Integer levelNum=Integer.parseInt(idArr[5]);
				Integer eiid=Integer.parseInt(idArr[1]);
				treeMap=searchBusinessTreeNodeByEiid(eiid,eiversion,eismallversion,levelNum,treeMap);
    			returnStr=initChangeJsonObject(treeMap,levelNum);
    		}
    	}
    	log.debug("======================��ȡ�������µĽ�����=========================");
		out.print(returnStr);
	}
    
    /**
	 * ��������,ҵ��ϵͳ���²�
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param levelNum
	 * @param treeMap
	 * @return
	 * @throws BLException
	 */
	private Map<Integer, List<RelationTreeTB>> searchBusinessTreeNodeByEiid(
			Integer eiid, Integer eiversion, Integer eismallversion,
			int levelNum, Map<Integer, List<RelationTreeTB>> treeMap) throws BLException{
		SOC0117BL soc0117BL=(SOC0117BL)getBean("soc0117BL");
		SOC0118BL soc0118BL=(SOC0118BL)getBean("soc0118BL");
		SOC0119BL soc0119BL=(SOC0119BL)getBean("soc0119BL");
		//��ѯ�Ƿ��а����Ĺ�ϵ�Ӷ�������в�����й�ϵ��
		SOC0119SearchCondImpl cond0119=new SOC0119SearchCondImpl();
		cond0119.setPareiid(eiid);
		cond0119.setParversion(eiversion);
		cond0119.setParsmallversion(eismallversion);
		List<SOC0119Info> soc0119InfoList=soc0119BL.searchMaxEntityItemRelation(cond0119);
		//����ϵģ�ͷ�������
		List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
		if(soc0119InfoList!=null&&soc0119InfoList.size()>0){
			for(SOC0119Info soc0119Info:soc0119InfoList){
				//����Ӧ��-����Ĺ�ϵ
				if (EntityItemKeyWords.APP_SERVICE_RelationCODE.equals(soc0119Info.getEirrelationcode())) {
					SOC0118Info soc0118Info=soc0118BL.searchEntityItemByKey(soc0119Info.getCldeiid());
					SOC0117Info soc0117Info=soc0117BL.searchEntityByKey(soc0118Info.getEid());
					RelationTreeTB	tbTop=new RelationTreeTB(soc0119Info.getCldeiid(),soc0118Info.getEiname(),soc0119Info.getCldeiid(),soc0117Info.getEname(),soc0117Info.getEid()+"",
							soc0119Info.getCldversion(),soc0119Info.getCldsmallversion(),soc0119Info.getCldeiid(),IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE,eiid);
					rtlist.add(tbTop);
				}
				//����map��
				treeMap.put(levelNum+1, rtlist);
			}
		}
		return treeMap;
	}
	
	/**
	 * get Item Image By Name
	 * @param jsonObject
	 * @param itemImageMap
	 * @param key
	 * @return
	 * @throws JSONException
	 */
	private JSONObject getItemImageByName(JSONObject jsonObject, Map<String, 
			String> itemImageMap, String key,String isLeaf,boolean isModel) throws JSONException{
//			if(itemImageMap != null && itemImageMap.containsKey(key)  && isModel){
//				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, itemImageMap.get(key));
//			}else{
//				if(isModel){
//					jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, "modeliconCOMMON");
//				}else{
//					jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
//				}
//				
//			}
		//�ж��Ƿ���Ҷ�ӽڵ�
		if (!IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(isLeaf)&&!isModel) {
			if(itemImageMap.get(key)!=null){
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, itemImageMap.get(key)+"leaf");
			}else{
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
			}
		} else {
			if (itemImageMap != null && itemImageMap.containsKey(key)&& isModel) {
				//��ģ�ͽڵ㣬�����ܻ�ȡ��ͼƬ��Ϣ
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						itemImageMap.get(key));

			} else if (itemImageMap != null && !itemImageMap.containsKey(key)
					&& isModel) {
				//��ģ�ͽڵ㣬���Ҳ��ܻ�ȡ��ͼƬ��Ϣ
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						"modeliconCOMMON");
			} else {
				if (IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE
						.equals(isLeaf)) {
					if(itemImageMap.get(key)!=null){
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								itemImageMap.get(key));
					}else{
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
					}
				} else {
//					if ("CM02060001".equals(deviceCode)) {
//						jsonObject.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_FALSE);
//					}
					if(itemImageMap.get(key)!=null){
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, itemImageMap.get(key)+"leaf");
					}else{
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
					}
				}
			}
		}
		return jsonObject;
	}
	
	/**
	 * get Item Images Info By Code Detail table
	 * @return
	 */
	private Map<String, String> getItemImagesInfoByCodeDetail(){
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		cond.setCcid("002");
		CodeDetailBL codeDetailBL = (CodeDetailBL) getBean("codeDetailBL");
		Map<String, String> imageMap = null;
		List<CodeDetail> imageInfolist = codeDetailBL.searchCodeDetail(cond, 0);
		if(imageInfolist != null && imageInfolist.size() != 0){
			imageMap = new HashMap<String, String>();
			for(CodeDetail codeDetail : imageInfolist){
				String keys[] = codeDetail.getCdinfo().split("_");
				if(keys.length == 3){
					imageMap.put(keys[0], codeDetail.getCvalue());
					//imageMap.put(keys[1]+"_"+keys[2], codeDetail.getCvalue());
				}else{
					imageMap.put(codeDetail.getCdinfo(), codeDetail.getCvalue());
				}
			}
		}
		return imageMap;
	}
	/** ����flex CI��ѯ */
	private void getCIInfoVM(HttpServletRequest req, PrintWriter out) throws BLException {
		StringBuffer sb=new StringBuffer("");
		String eiid=req.getParameter("eiid");
		SOC0118BL soc0118BL =(SOC0118BL)getBean("soc0118BL");
		SOC0107BL soc0107BL =(SOC0107BL)getBean("soc0107BL");
		SOC0124Info soc0124Info = soc0118BL.searchEntityItemVWByKey(Integer.parseInt(eiid));
		sb.append("<DG>");
		sb.append("<COL1>"+soc0124Info.getEname()+"</COL1>");
		sb.append("<COL2>"+soc0124Info.getEilabel()+"</COL2>");
		sb.append("<COL3>"+soc0124Info.getEiname()+"</COL3>");
		sb.append("</DG>|");
		SOC0129SearchCondImpl cond_0129 = new SOC0129SearchCondImpl();
		cond_0129.setEiid(eiid);
		cond_0129.setEsyscoding_q(soc0124Info.getEsyscoding());
		List<SOC0129Info> list_soc0129=soc0107BL.searchConfigItemVW(cond_0129);
		for (int i = 0; i < list_soc0129.size(); i++) {
			sb.append("<DG>");
			sb.append("<COL1>"+list_soc0129.get(i).getCname()+"</COL1>");
			sb.append("<COL2>"+list_soc0129.get(i).getCivalue()+"</COL2>");
			sb.append("<COL3>"+list_soc0129.get(i).getCdesc()+"</COL3>");
			sb.append("</DG>");
		}
		out.print(sb.toString());
	}
	/**
	 * ��ȡָ������
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void getTrendByID(HttpServletRequest req, PrintWriter out) throws BLException {
	}
	/**
	 * ��ȡָ������
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void gatMaterChartData(HttpServletRequest req, PrintWriter out) throws BLException {
		
	}
	
	/**
	 * ��ȡ���Ƚϵ�����
	 * @param req
	 * @param out
	 * @throws BLException
	 */
	private void searchCompareSourchHostList(HttpServletRequest req, PrintWriter out) throws BLException {
		IGCIC01BL bl = (IGCIC01BL)getBean("igcic01BL");
		Gson gson = new Gson();
		
		Integer systemId = Integer.valueOf(req.getParameter("systemId"));
		String crtype = req.getParameter("crtype");
		Map<String,Object> map = bl.checkCompareRole(systemId, crtype);
		
		out.write(gson.toJson(map));
		
	}
	
	/**
	 * ��ȡ�������
	 * @param req 
	 * @param out PrintWriter
	 * @param rcrid
	 */
	private void getRiskCheckName(HttpServletRequest req, PrintWriter out, String rcrid) throws BLException {
		
		// ��ȡ�������Ϣ
		RiskCheckResultBL riskCheckResultBL = (RiskCheckResultBL) getBean("riskCheckResultBL");
		RiskCheckResult rcr = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
		String rcid = String.valueOf(rcr.getRcid());
		String rcname = rcr.getRcname();
		
		out.print(rcid + "#" + rcname);
	}
	/**
	 * ��ȡ��������
	 * @param req 
	 * @param out PrintWriter
	 * @param rcrid
	 */
	private void getCheckResultUsername(HttpServletRequest req, PrintWriter out, String rcrid) throws BLException {
		
		// ��ȡ�������Ϣ
		RiskCheckResultBL riskCheckResultBL = (RiskCheckResultBL) getBean("riskCheckResultBL");
		RiskCheckResult rcr = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
		String rcid = String.valueOf(rcr.getRcid());
		
		CheckworkInfoResultBL checkworkInfoResultBL = (CheckworkInfoResultBL) getBean("checkworkInfoResultBL");
		CheckworkInfoResultSearchCondImpl cond = new CheckworkInfoResultSearchCondImpl();
		cond.setRcrid(rcr.getRcrid());
		List<CheckworkInfoResultInfo> infoList = checkworkInfoResultBL.searchCheckworkInfoResult(cond);
		String cwrname = "";
		if(infoList!=null && infoList.size()>0){
			Integer cwrid = infoList.get(0).getCwrid();
			CheckWorkResultBL checkWorkResultBL = (CheckWorkResultBL)getBean("checkWorkResultBL");
			CheckWorkResultInfo info =  checkWorkResultBL.searchCheckWorkResultByPK(cwrid);
			cwrname = info.getCwrname();
		}
		
		//��ȡ��鹤������
		String rcname = rcr.getRcname();
		//��ȡ��鹤��˵��
		String rcdesc = rcr.getRcdesc();
		//��ȡ��鷽��
		String rccommon = rcr.getRccommon();
		
		String username = rcr.getRcrusername();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject1 = new JSONObject();
		try {
			jsonObject1.put("rcid", rcid);
			jsonObject1.put("rcname", rcname);
			jsonObject1.put("rcdesc", rcdesc);
			jsonObject1.put("rccommon", rccommon);
			jsonObject1.put("username", username);
			jsonObject1.put("cwrname", cwrname);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonArray.put(jsonObject1);
		out.print(jsonArray.toString());
	}
	
	private void getAreaOptionname(HttpServletRequest req, PrintWriter out) {
		// TODO Auto-generated method stub
		CompareTemplateBL compareTemplateBL = (CompareTemplateBL) getBean("compareTemplateBL");

		String room = req.getParameter("room");
		SOC0601BL soc0601BL = (SOC0601BL)getBean("soc0601BL");
		
		SOC0601SearchCondImpl soc0601cond = new SOC0601SearchCondImpl();
		List<SOC0601Info> soc0601List = soc0601BL.searchSOC0601Info(soc0601cond);
		Integer category = 0;
		for(SOC0601Info soc0601Info : soc0601List){
			if(room.equals(soc0601Info.getEiname())){
				category = soc0601Info.getEiid();
			}
		}
		CompareTemplateSearchCondImpl cond = new CompareTemplateSearchCondImpl();
		cond.setCategory(category.toString());
		cond.setCabtype("zone");
		List<CompareTemplateInfo> list = compareTemplateBL.searchCompareTemplate(cond);
		
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<list.size();i++){
			sb.append(list.get(i).getCtName());			
			if(i<list.size()-1){
				sb.append("#");
			}
		}
		out.print(sb.toString());
	}
	/**
	 * Ӧ���߼���ϵ����������������
	 * @param req
	 * @param out
	 */
	private void crateArea(HttpServletRequest req, PrintWriter out) {
		SOC0118BL soc0118BL=(SOC0118BL)getBean("soc0118BL");
		String eilabel="";
		try {
			SOC0118SearchCondImpl cond=new SOC0118SearchCondImpl();
			cond.setEilabel("ZJQY" + IGStringUtils.getCurrentYear().substring(2));
			eilabel = soc0118BL.searchNextEntityItemLable(cond);
		} catch (BLException e) {
			e.printStackTrace();
		}
		out.print(eilabel);
	}
	
	private void saveBack(HttpServletRequest req, PrintWriter out) {
		// TODO Auto-generated method stub
		String cwrid = req.getParameter("cwrid");
		req.getSession().setAttribute("cwrid", cwrid);
	}
	
	/**	
	 * ���ܣ���ȡ���̲�������״̬
	 * @param req
	 * @param out
	 * �޸ļ�¼��null 	
	 * @throws JSONException 
	 * @throws BLException 
	 */	
	private void getPpsubstatus(HttpServletRequest req, PrintWriter out) throws JSONException, BLException {
		String psdid = req.getParameter("psdid");//�ڵ�id
		String prid = req.getParameter("prid");//����id
		String userid = req.getParameter("userid");//�û�id
		String source = req.getParameter("source");//�¼���Դ
		
		IG337BL ig337BL = (IG337BL)getBean("ig337BL");
		UserRoleBL userRoleBL = (UserRoleBL)getBean("userRoleBL");
		Integer FWTROLEID = 1205;//����̨roleid
		Integer YWROLEID = 1210;//����ֵ���roleid
		String roleIdFlag = "0";//�Ƿ��Ƿ���̨��ɫ ��:1 ��:0
		String updateFlag = "0";//�Ƿ�������� ��:1 ��:0
		String alarmRoleIdFlag = "0";//�Ƿ�������ֵ��ڽ�ɫ ��:1 ��:0
		String ALARMSOURCE = "��ظ澯";//�¼���Դ
		//��ѯ�������б�
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setPrid(Integer.parseInt(prid));
		List<IG337Info> list = ig337BL.getIG337Infos(cond);
		JSONArray userjson = new JSONArray();
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size();i++) {
				JSONObject userObj = new JSONObject();
				userObj.put("ppuserid", list.get(i).getPpuserid());
				userObj.put("ppusername", list.get(i).getPpusername());
				userObj.put("ppstatus", StringUtils.isEmpty(list.get(i).getPpsubstatus())?"0":list.get(i).getPpsubstatus());
				userjson.put(userObj);//������Աjson����
			}
		}
		
		//��ѯ��ɫ�б�
		UserRoleSearchCondImpl userRoleCond = new UserRoleSearchCondImpl();
		userRoleCond.setUserid(userid);
		List<UserRole> userRoleList = userRoleBL.searchUserRole(userRoleCond);
		if(ALARMSOURCE.equals(source)){//����� "��ظ澯"
			for (UserRole userRole : userRoleList) {
				if(YWROLEID.equals(userRole.getRoleid())){
					alarmRoleIdFlag = "1";//��ɫ��ͬ��1
				}
			}
		}else{//����������¼�
			for (UserRole userRole : userRoleList) {
				if(FWTROLEID.equals(userRole.getRoleid())){
					roleIdFlag = "1";//��ɫ��ͬ��1
				}
			}
		}
		
		//��ѯ�����̵��¼������Ƿ�Ϊ��
		IG599BL ig599BL = (IG599BL)getBean("ig599BL");
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(Integer.parseInt(prid));
		ig599Cond.setPivarname("�¼�����");
		List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
		if(null != ig599List && ig599List.size() > 0){
			IG599Info IG599Bean = ig599List.get(0);
			if("��".equals(IG599Bean.getPivarvalue())){
				updateFlag = "1";
			}
		}
		
		out.println(roleIdFlag+"##"+userjson+"##"+updateFlag+"##"+alarmRoleIdFlag);
	}
	
	/**	
	 * ���ܣ��������̲�������״̬
	 * @param req
	 * @param out
	 * �޸ļ�¼��null 	
	 * @throws BLException 
	 */	
	private void confirmPpsubstatus(HttpServletRequest req, PrintWriter out) throws BLException {
		String psdid = req.getParameter("psdid");//�ڵ�id
		String prid = req.getParameter("prid");//����id
		String selectUserid = req.getParameter("selectUserid");//��ѡ�û�id
		String becauseVal = req.getParameter("becauseVal");//��ȡ����ԭ������
		String dealVal = req.getParameter("dealVal");//��ȡ����������
		String causeVal = req.getParameter("causeVal");//��ȡԭ���������
		IG337BL ig337BL = (IG337BL)getBean("ig337BL");
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setPrid(Integer.parseInt(prid));
		cond.setPpuserid(selectUserid);
		List<IG337Info> list = ig337BL.getIG337Infos(cond);
		if(null != list && list.size() > 0){
			IG337Info bean = list.get(0);
			IG337TB copyBean = (IG337TB)SerializationUtils.clone(bean);
			copyBean.setPpsubstatus(IGPRDCONSTANTS.PARTICIPANT_SUBSTATUS_CONFIRM);
			copyBean.setPpbacktime(IGStringUtils.getCurrentDateTime());
			ig337BL.updateIG337Info(copyBean);
		}
		//���¹���ԭ��
		IG599BL ig599BL = (IG599BL)getBean("ig599BL");
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(Integer.parseInt(prid));
		ig599Cond.setPivarname("����ԭ��");
		List<IG599Info> registIG599List = new ArrayList<IG599Info>();
		List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
		if(ig599List!=null && ig599List.size()>0){
			IG599Info ig599Info = ig599List.get(0);
			IG599TB ig599TB = (IG599TB) SerializationUtils.clone(ig599Info);
			ig599TB.setPivarvalue(becauseVal);
			registIG599List.add(ig599TB);
		}
		//���´���������
		ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(Integer.parseInt(prid));
		ig599Cond.setPivarname("������");
		ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
		if(ig599List!=null && ig599List.size()>0){
			IG599Info ig599Info = ig599List.get(0);
			IG599TB ig599TB = (IG599TB) SerializationUtils.clone(ig599Info);
			ig599TB.setPivarvalue(dealVal);
			registIG599List.add(ig599TB);
		}
		//����ԭ���������
		ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPrid(Integer.parseInt(prid));
		ig599Cond.setPivarname("ԭ�����");
		ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
		if(ig599List!=null && ig599List.size()>0){
			IG599Info ig599Info = ig599List.get(0);
			IG599TB ig599TB = (IG599TB) SerializationUtils.clone(ig599Info);
			ig599TB.setPivarvalue(causeVal);
			registIG599List.add(ig599TB);
		}
		ig599BL.registIG599Infos(registIG599List);
	}
	
	
	/**	
	 * ���ܣ�һ���¼����� �¼���������
	 * @param req
	 * @param out
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	private void upgrade(HttpServletRequest req, PrintWriter out) throws BLException {
		String prid = req.getParameter("prid");//����id
		IG599BL ig599BL = (IG599BL)getBean("ig599BL");
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(Integer.parseInt(prid));
		cond.setPivarname("�¼�����");
		List<IG599Info> list = ig599BL.searchIG599InfosByCond(cond);
		if(null != list && list.size() > 0){
			IG599Info bean = list.get(0);
			if("��".equals(bean.getPivarvalue())){
				IG599TB copyBean = (IG599TB)SerializationUtils.clone(bean);
				copyBean.setPivarvalue("��");
				ig599BL.updateIG599Info(copyBean);
			}
		}
		out.println(1);
	}
	
	/**
	 * chg SMS status 
	 * @return 
	 */
	private void setEveryDayWorkSMSstatus(HttpServletRequest req, PrintWriter out) {
		String res="";
		String namez=req.getParameter("status");
		if(namez.equals("����")){
			SMSThread.setWorkManagerSmsOpen(true);
			res="�ر�";
		}else{
			SMSThread.setWorkManagerSmsOpen(false);
			res="����";
		}
		out.print(res);
	}
	
	/**
	 * @Description ������������ѿ���״̬
	 * @param req �������
	 * @param out �����
	 * @author WangLiang
	 */
	private void setWorkItemSMSstatus(HttpServletRequest req, PrintWriter out) {
		String res="";
		String namez=req.getParameter("status");
		if(namez.equals("����")){
			SMSThread.setWorkItemSmsOpen(true);
			res="�ر�";
		}else{
			SMSThread.setWorkItemSmsOpen(false);
			res="����";
		}
		out.print(res);
	}
	
}
