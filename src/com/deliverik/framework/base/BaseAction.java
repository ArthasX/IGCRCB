package com.deliverik.framework.base;

import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;
import org.springframework.web.struts.ActionSupport;

import com.deliverik.framework.dao.ExclusionException;
import com.deliverik.framework.exception.InvalidOperationException;
import com.deliverik.framework.exception.MaxDataCountException;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IniReader;
import com.deliverik.framework.utility.ResourceUtility;

/**
 * Base action class of web layer request process, providing common functionalities.
 * It integrates the Spring framework by extending the org.springframework.web.struts.ActionSupport class.<br>
 * All web layer struts action classes should extend this class.
 *
 */
public abstract class BaseAction extends ActionSupport {

	/** Static logger. */
	static Log log = LogFactory.getLog(BaseAction.class);

	/** Key of the session attribute that store information of the user logged in. */
	public static final String SESSION_KEY_LOGIN_USER = "LOGIN_USER";

	/** Key of the session attribute that store information of the last input forward. */
	public static final String SESSION_KEY_LAST_INPUT_FORWARD = "LAST_INPUT_FORWARD";

	/**  */
	public static final String REQUEST_PARAM_FROM_COUNT = "fromCount";

	/**  */
	public static final String REQUEST_PARAM_TENPO_TYPE = "auth_tenpo_type";

	/**  */
	public static final String REQUEST_PARAM_TENPO_STATUS = "auth_tenpo_status";


	/**  */
	protected static final int GUI_ID_KETA = 9;

	/**  */
	protected static MessageResources resources;

	/** Volatile boolean variable to remember the status of whether initialized or not. */
	protected static volatile boolean isInitialized;

	/**
	 * Main process method to perform the struts action task and return an ActionForward.
	 *
	 * @param mapping 
	 * @param form 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		try {
			if( !isInitialized ){
				synchronized (this){
					// 
					resources = getResources(req);

					// 
					CodeListUtils codeListUtils = (CodeListUtils) getBean("codeListUtils");
					// 
//					if(BooleanUtils.toBoolean(ResourceUtility.getString("CODELIST_DEFAULT")))
//						codeListUtils.init();

					getServletContext().setAttribute("codeListUtils", codeListUtils);

//2010.6.9  License文件读取					
					boolean bReadFlag = true;
					
					bReadFlag = IniReader.init(ResourceUtility.getString("CONF_INI_FILE_NAME"));
					
					if (!bReadFlag) {
						getMessages(req).clear();
						addMessage(req,new ActionMessage("IGCO00000.E008"));

						// 
						return mapping.findForward("/error2");
					}

					isInitialized = true;
				}
			}

			if( mapping.getInputForward().getPath() != null ){
				req.getSession().setAttribute(SESSION_KEY_LAST_INPUT_FORWARD, mapping.getInputForward());
			}

			// call the actual processing ...
			ActionForward forward = doProcess(mapping, form, req, res);

			//分页时,查询的页数据不存在检测
			if (req.getAttribute("PagingDTO") != null) {
				PagingDTO pDto = (PagingDTO) req.getAttribute("PagingDTO");
				
				//Case1:共0页、跳转到第2页以后
				//Case2:大于0页、跳转页大于最大页数
				if (((pDto.getTotalCount() == 0) && (pDto.getViewPage() > 1)) ||
						((pDto.getTotalCount() > 0) && (pDto.getViewPage() > pDto.getTotalPage()))) {
					addMessage(req,new ActionMessage("IGCO00000.E009",pDto.getViewPage(),pDto.getTotalPage()));
					pDto.setTotalCount(0);
				}
			}
			
			return forward;

		} catch (MaxDataCountException e) {
			// Exception due to exceeding of max data count
			getMessages(req).clear();
			addMessage(req,new ActionMessage("IGCO00000.E005", e.getMaxCount(), e.getResultCount()));

			return getInputForward(mapping, req);

		} catch (BLException e) {
			// Exception from business logic processing
			saveToken(req);
			
			getMessages(req).clear();

			for (BLError error : e.getErrors()) {
				ActionMessage m = new ActionMessage(error.getKey(), error.getMParam());
				addMessage(req, m);
				setErrorField(req, error.getType().getField());
			}

			return getInputForward(mapping, req);

		} catch (ExclusionException e) {
			// 
			getMessages(req).clear();
			log.warn("ExclusionException",e);

			addMessage(req,new ActionMessage("IGCO00000.E004"));

			return getInputForward(mapping, req);

		} catch (InvalidOperationException e) {
			// 
			getMessages(req).clear();
			addMessage(req,new ActionMessage("IGCO00000.E007"));

			// 
			return mapping.findForward("/mainmenu");

		} catch (Exception e) {
			e.printStackTrace();
			getMessages(req).clear();
			if( e.getCause() instanceof SocketException &&
				e.getMessage().indexOf("Connection reset by peer: socket write error") >=0 ){
				// 
				return null;
			}

			// 
			log.error("Unknown error", e);

			req.getSession().setAttribute(Globals.EXCEPTION_KEY, e);

			ActionMessage m = new ActionMessage("IGCO00000.E001");
			addMessage(req, m);

			return mapping.findForward("/error");

		}
	}

	/**
	 * Translate the request path to action mapping path by removing ".do"
	 *
	 * @param req 
	 * @return 
	 */
	protected String getFowardActionPath(HttpServletRequest req) {
		String ret = (String)req.getAttribute("javax.servlet.forward.servlet_path");
		if(ret != null){
			ret = ret.replace(".do", "");
		}

		return ret;
	}

	/**
	 * <br>
	 * <br>
	 *
	 * @param req 
	 * @param tenpo_type 
	 * @param tenpo_status 
	 * @return 
	 */
	protected void setAuthControlKeys(HttpServletRequest req, String tenpo_type, String tenpo_status) {
		req.setAttribute(REQUEST_PARAM_TENPO_TYPE, tenpo_type);
		req.setAttribute(REQUEST_PARAM_TENPO_STATUS, tenpo_status);
	}

	/**
	 * 
	 *
	 * @param mapping 
	 * @param req 
	 * @return 
	 */
	protected ActionForward getInputForward(ActionMapping mapping, HttpServletRequest req) {

		if( mapping.getInputForward().getPath() != null ){
			return mapping.getInputForward();
		}

		ActionForward lastInputForward = (ActionForward) req.getSession().getAttribute(SESSION_KEY_LAST_INPUT_FORWARD);
		if( lastInputForward != null ) {
			return lastInputForward;
		}
		return mapping.findForward("/error");

	}
	

	/**
	 * 
	 *
	 * @param req 
	 * @return 
	 */
	protected int getMessageCount(HttpServletRequest req) {
		return getMessages(req).size() + getErrors(req).size();
	}

	/**
	 * 
	 *
	 * @param req 
	 * @param m 
	 */
	protected void addMessage(HttpServletRequest req, List<ActionMessage> m) {

		if(m == null || m.isEmpty())
			return;

		ActionMessages ms = getMessages(req);
		if (ms == null) {
			ms = new ActionMessages();
		}

		for(ActionMessage i : m){
			ms.add(ActionMessages.GLOBAL_MESSAGE, i);
			saveMessages(req, ms);
		}
	}

	/**
	 * 
	 *
	 * @param req 
	 * @param m 
	 */
	protected void addMessage(HttpServletRequest req, ActionMessage m) {
		ActionMessages ms = getMessages(req);
		if (ms == null) {
			ms = new ActionMessages();
		}
		ms.add(ActionMessages.GLOBAL_MESSAGE, m);
		saveMessages(req, ms);
	}

	/**
	 * 
	 *
	 * @param req 
	 * @param fieldName 
	 */
	protected void setErrorField(HttpServletRequest req, String... fieldName) {
		ActionMessages ms = getErrors(req);
		if (ms == null) {
			ms = new ActionMessages();
		}
		for (String field : fieldName) {
			ms.add(field, new ActionMessage(null));
		}
		saveErrors(req, ms);

	}

	/**
	 * 
	 *
	 * @param req 
	 */
	protected void clearSessionFormData(HttpServletRequest req) {
		HttpSession ses = req.getSession();
		if(ses==null) return;
		Enumeration<?> enm = ses.getAttributeNames();
		while (enm.hasMoreElements()) {
			String key = (String) enm.nextElement();

			if(key.substring(0, 2).equals("AD")){

				ses.removeAttribute(key);
				log.debug("SessionClear KEY:" + key);
			}
			// ActionForm, PagingDTO, VO 
			else if (ses.getAttribute(key) instanceof ActionForm ||
					ses.getAttribute(key) instanceof PagingDTO ||
					ses.getAttribute(key) instanceof BaseVO	) {

				ses.removeAttribute(key);
				log.debug("SessionClear KEY:" + key);

			// VO
			}else if(ses.getAttribute(key) instanceof List){
				List<?> l = (List<?>)ses.getAttribute(key);
				if(l != null && !l.isEmpty())
					if(l.get(0) instanceof BaseVO){
						ses.removeAttribute(key);
						log.debug("SessionClear KEY:" + key);
					}

			}
		}
	}

	/**
	 * Actual request processing method. All action class should implement this method.
	 *
	 * @param mapping 
	 * @param form 
	 * @param req 
	 * @param res 
	 * @return 
	 */
	abstract public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	
	protected Object getSessionAttribute(HttpServletRequest req, String key) {
		return req.getSession().getAttribute(key);
	}
	
	protected void setSessionAttribute(HttpServletRequest req, String key, Object obj) {
		req.getSession().setAttribute(key, obj);
	}

	/**
	 * 
	 *
	 * @param req 
	 */
	protected void logout(HttpServletRequest req) {
		// 
//		req.getSession().invalidate();
		HttpSession ses = req.getSession();
		if(ses!=null) ses.invalidate();
	}

	/**
	 * Get object instance with Spring utility.
	 *
	 * @param name Name of the object
	 * @return Bean
	 */
	protected Object getBean(String name) {
		return getWebApplicationContext().getBean(name);
	}

	/**
	 * 
	 *
	 * @param scrID 
	 * @param cnt 
	 * @throws MaxDataCountException 
	 */
	protected void checkMaxDataCount(String scrID, int cnt) throws MaxDataCountException {
		int maxCount = getMaxDataCount(scrID);
		if (cnt > maxCount) {
			throw new MaxDataCountException(cnt, maxCount);
		}

	}

	/**
	 * 
	 * @throws InvalidOperationException
	 */
	protected void throwInvalidOperationException() throws InvalidOperationException {
		throw new InvalidOperationException();
	}


	/**
	 * 
	 *
	 * @param Action
	 * @return 
	 */
	protected<T extends BaseAction> int getMaxDataCount(T obj) {
		// ActionID
		String scrID = obj.getClass().getSimpleName();
		scrID = StringUtils.left(scrID, GUI_ID_KETA);
		return getMaxDataCount(scrID);
	}

	/**
	 * 
	 *
	 * @param scrID 
	 * @return 
	 */
	protected int getMaxDataCount(String scrID) {
		try {
			int ret;
			String maxCnt = resources.getMessage("MAX_COUNT." + scrID);
			if (maxCnt == null) {
				maxCnt = resources.getMessage("MAX_COUNT.DEFAULT");
			}
			ret = Integer.parseInt(maxCnt);
			return ret;
		} catch (Exception e) {
			log.warn("MAX scrID:"+ scrID, e);
			return 1000;
		}
	}

	/**
	 * 
	 *
	 * @param scrID 
	 * @return 
	 */
	protected int getPageDataCount(String scrID) {
		try {
			int ret;
			String maxCnt = resources.getMessage("PAGE_COUNT." + scrID);
			if (maxCnt == null) {
				maxCnt = resources.getMessage("PAGE_COUNT.DEFAULT");
			}
			ret = Integer.parseInt(maxCnt);
			return ret;
		} catch (Exception e) {
			log.warn("scrID:"+ scrID, e);
			return 50;
		}
	}

	/**
	 * 
	 *
	 * <br>
	 *
	 * @param req 
	 * @param Action
	 * @return PagingDTO
	 */
	protected<T extends BaseAction> PagingDTO getPagingDTO(HttpServletRequest req, T obj) {
		// ActionID
		String scrID = obj.getClass().getSimpleName();
		scrID = StringUtils.left(scrID, GUI_ID_KETA);

		return getPagingDTO(req, scrID);
	}

	/**
	 * 
	 *
	 * <br>
	 *
	 * @param req 
	 * @param scrID 
	 * @return PagingDTO
	 */
	protected PagingDTO getPagingDTO(HttpServletRequest req, String scrID) {

		// 
		int fCount = NumberUtils.toInt(req.getParameter(REQUEST_PARAM_FROM_COUNT));
		// 
		int rCnt = getPageDataCount(scrID);

		// PagingDTO
		PagingDTO pDto = new PagingDTO( req.getRequestURI(), fCount, rCnt, 0);
		// Session
		req.setAttribute("PagingDTO", pDto);
		return pDto;
	}

	/**
	 * 
	 *
	 * <br>
	 *
	 * @param req 
	 * @param scrID 
	 * @return PaginDTO
	 */
	protected PagingDTO getPaginDTO(HttpServletRequest req, String scrID) {

		// 
		int fCount = NumberUtils.toInt(req.getParameter(REQUEST_PARAM_FROM_COUNT));
		// 
		int rCnt = getPageDataCount(scrID);

		// 
		PagingDTO pDto = new PagingDTO(req.getRequestURI(), fCount, rCnt, 0);
		// 
		req.setAttribute("PagingDTO", pDto);
		return pDto;
	}

	/**
	 * 
	 *
	 * @param req 
	 * @param pageCount 
	 * @param totalCount 
	 */
	protected void setPaginDTO(HttpServletRequest req, int pageCount, int totalCount) {

		// 
		int fCount = NumberUtils.toInt(req.getParameter(REQUEST_PARAM_FROM_COUNT));
		// 
		PagingDTO pDto = new PagingDTO( req.getRequestURI(), fCount, pageCount, totalCount);
		// 
		req.setAttribute("PagingDTO", pDto);
	}

	/**
	 * 
	 *
	 * @param req 
	 * @param pDto 
	 */
	protected void setPaginDTO(HttpServletRequest req, PagingDTO pDto) {

		// 
		req.setAttribute("PagingDTO", pDto);
	}

	/**
	 * 
	 *
	 * @param req 
	 * @return 
	 */
	protected int getPagingFromCount(HttpServletRequest req) {

		return NumberUtils.toInt(req.getParameter(REQUEST_PARAM_FROM_COUNT));
	}

//	/**
//	 * VO(ViewObject)傪愝掕偟傑偡丅
//	 *
//	 * @param req 儕僋僄僗僩
//	 * @param vo ViewObject
//	 */
//	protected<T extends jp.co.eico.brmf.vo.BaseVO> void setVO(HttpServletRequest req, T vo) {
//		// 儕僋僄僗僩偵僙僢僩
//		req.setAttribute(vo.getClass().getSimpleName(), vo);
//	}


	/**
	 * 
	 *
	 * @param req 
	 * @param vo ViewObject
	 */
	protected<T extends BaseVO> void setVO(HttpServletRequest req, T vo) {
		// 
		req.setAttribute(vo.getClass().getSimpleName(), vo);
	}


	/**
	 * 
	 *
	 * @param session HttpSession
	 * @param vo ViewObject
	 */
	protected<T extends BaseVO> void setVO(HttpSession session, T vo) {
		// 
		session.setAttribute(vo.getClass().getSimpleName(), vo);
	}

	/**
	 * 
	 *
	 * @param session HttpSession
	 * @param vo ViewObject
	 */
	protected<T extends BaseVO> void removeVO(HttpSession session, T vo) {
		// 
		session.removeAttribute(vo.getClass().getSimpleName());
	}
//
//	/**
//	 * 僸僗僩儕DTO傪愝掕偟傑偡丅
//	 *
//	 * @param req  儕僋僄僗僩
//	 * @param hst  昞帵桳岠擔
//	 * @param list 桳岠擔儕僗僩
//	 * @param linkDisp 儕儞僋昞帵僼儔僌
//	 */
//	protected<T extends HistoryTerm> void setHistoryDTO(HttpServletRequest req, HistoryTerm hst, List<T> list, boolean linkDisp) {
//
//		// HistoryDTO嶌惉
//		HistoryDTO dto = new HistoryDTO(req.getRequestURI(), hst, new ArrayList<HistoryTerm>(list), linkDisp);
//		// 儕僋僄僗僩偵僙僢僩
//		req.setAttribute("HistoryDTO", dto);
//	}

	/**
	 * 
	 * @param res 
	 * @param filename 
	 */
	protected void setResponseOnDownload(HttpServletResponse res, String filename){
		try {
			res.setContentType("application/octet-stream");
			filename = new String(filename.getBytes(), "ISO8859_1");
			res.setHeader("Content-Disposition","attachment; filename=" + filename);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param res 
	 */
	protected void resetResponse(HttpServletResponse res){
		if( !res.isCommitted() )
			res.reset();
	}

	/**
	 * 
	 * @param req 
	 * @param linkID 
	 */
	protected void setLinkID(HttpServletRequest req, String linkID){
		req.getSession().setAttribute("MAIN_LINK_ID", linkID);
	}

	/**
	 * 
	 * @param req 
	 * @return 
	 */
	protected String getLinkID(HttpServletRequest req){
		return (String) req.getSession().getAttribute("MAIN_LINK_ID");
	}

	/**
	 * 
	 * @param dest 
	 * @param source 
	 */
	protected void copyProperties(Object dest, Object source){
		try {
			PropertyUtils.copyProperties(dest, source);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
