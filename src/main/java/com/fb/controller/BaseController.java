package com.fb.controller;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
/**
 * BaseController
 * @author Lain
 *
 */
public class BaseController {
	@Autowired
	private MessageSource msgSource ;
	/**
	 * Get parameter start width a prefix 
	 * @param request
	 * @param prefix
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Map<String , Object> getParametersStartWidth( HttpServletRequest request , String prefix ){
		Map< String , String[] > omp = request.getParameterMap();
		Map< String , Object > nmp = new HashMap<String , Object>() ;
		Set<String> keys = omp.keySet();
		for(String key : keys ){
			if( key.startsWith(prefix) ){
				String nkey = key.substring( prefix.length() ) ;
				if( ! StringUtils.isEmpty( nkey ) ){
					nmp.put(nkey, omp.get(key) ) ;
				}
			}
		}
		return nmp ;
	}
	
	/**
	 * Pase parameter for datatable from request
	 * @param request
	 * @return
	 */
	protected DataTableVo parseData4DT( HttpServletRequest request ){
		DataTableVo dt = new DataTableVo() ;
		try{
			String sEcho = request.getParameter("sEcho") ;
			String start = request.getParameter("iDisplayStart") ;
			int iDisplayStart = StringUtils.isEmpty(start) ? 0 : Integer.parseInt( start ) ;
			String length = request.getParameter("iDisplayLength") ;
			int iDisplayLength = StringUtils.isEmpty(length) ? 10 : Integer.parseInt( length ) ;
			
			dt.setsEcho(sEcho);
			dt.setiDisplayLength(iDisplayLength);
			dt.setiDisplayStart(iDisplayStart);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dt ;
	}
	
	/**
	 * Format data to json of datatable 
	 * @param dt
	 * @return
	 */
	protected String formateData2DT( DataTableVo dt ){
		if( dt == null ){
			return null ;
		}
		StringWriter writer = new StringWriter() ;
		ObjectMapper mapper = new ObjectMapper() ;
		try{
			mapper.writeValue( writer , dt ) ;
			writer.flush();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return writer.toString();
	}
	
	/**
	 * Build a success message 
	 * @param code
	 * @param msgType
	 * @return
	 */
	protected String buildSuccessMessage( String code , int msgType ){
		return buildMessage( ResultModal.SUCCESS , code , null , msgType) ;
	}
	
	/**
	 * Build a success message with data
	 * @param code
	 * @param data
	 * @param msgType
	 * @return
	 */
	protected String buildSuccessMessage( String code , Object data , int msgType){
		return buildMessage( ResultModal.SUCCESS , code , data , msgType ) ;
	}
	
	/**
	 * Build a fail message 
	 * @param code
	 * @param msgType
	 * @return
	 */
	protected String buildFailMessage( String code , int msgType){
		return buildMessage( ResultModal.FAIL , code , null , msgType ) ;
	}
	
	/**
	 * Build fail message with data
	 * @param code
	 * @param data
	 * @param msgType
	 * @return
	 */
	protected String buildFailMessage( String code , Object data , int msgType ){
		return buildMessage( ResultModal.FAIL , code , data , msgType ) ;
	}
	
	/**
	 * Build message
	 * @param status
	 * @param code
	 * @param data
	 * @param msgType
	 * @return
	 */
	private String buildMessage( String status , String code ,  Object data , int msgType ){
		StringWriter writer = new StringWriter() ;
		try{
			String msg = msgSource.getMessage(code, null , code , Locale.CHINA) ; 
			ResultModal resultModal = new ResultModal( status , code , msg , data , msgType );
			ObjectMapper mapper = new ObjectMapper() ;
			mapper.writeValue(writer, resultModal);
			writer.flush();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return writer.toString() ;
	}
	
	/**
	 * ResultModal templete
	 * @author Lain
	 *
	 */
	public class ResultModal{
		public static final String SUCCESS = "success" ; 
		public static final String FAIL = "fail" ;
		public static final int DIALOG = 0 ;
		public static final int MESSAGE = 1 ;
		private int msgType ;		
		private String state ;		
		private String code ;		
		private String msg ;		
		private Object data ;		
		public ResultModal( String state , String code , String msg , Object data , int msgType){
			this.state = state ;
			this.code = code ;
			this.msg = msg ;
			this.data = data ;
			this.msgType = msgType ;
		}
		public ResultModal(){
			
		}
		
		public int getMsgType() {
			return msgType;
		}
		public void setMsgType(int msgType) {
			this.msgType = msgType;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
	}
	
	/**
	 * DataTableVo templete
	 * @author Lain
	 *
	 */
	public class DataTableVo {
		private String sEcho ;
		private int iDisplayStart ;
		private int iDisplayLength ;
		private int iTotalRecords ;
		private int iTotalDisplayRecords ;
		private List<Object> aaData ;
		public String getsEcho() {
			return sEcho;
		}
		public void setsEcho(String sEcho) {
			this.sEcho = sEcho;
		}
		public int getiDisplayStart() {
			return iDisplayStart;
		}
		public void setiDisplayStart(int iDisplayStart) {
			this.iDisplayStart = iDisplayStart;
		}
		public int getiDisplayLength() {
			return iDisplayLength;
		}
		public void setiDisplayLength(int iDisplayLength) {
			this.iDisplayLength = iDisplayLength;
		}
		
		public int getiTotalRecords() {
			return iTotalRecords;
		}
		public void setiTotalRecords(int iTotalRecords) {
			this.iTotalRecords = iTotalRecords;
			setiTotalDisplayRecords(iTotalRecords) ;
		}
		
		public int getiTotalDisplayRecords() {
			return iTotalDisplayRecords;
		}
		public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
			this.iTotalDisplayRecords = iTotalDisplayRecords;
		}
		@SuppressWarnings("unchecked")
		public void setData(Object aaData) {
			if( aaData instanceof List ){
				this.aaData = (List<Object>)aaData;
			}else{
				this.aaData = new ArrayList<Object>() ;
				this.aaData.add( aaData ) ;
			}
		}
		
		public List<Object> getAaData(){
			return aaData ;
		}
	}
}
