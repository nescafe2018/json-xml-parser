/**
 * Sanlark Inc.
 * @Author : Rajiv Kumar <sanlark@gmail.com>
 * @CreateDate : Mar 20, 2018
 * @Version    : 1.0.0
 */
package com.sanlark.rajiv.lib.json;

import java.io.File;

import org.apache.log4j.Logger;

import com.sanlark.rajiv.lib.json.hanlder.ConsoleOutputHandlerImpl;
import com.sanlark.rajiv.lib.json.hanlder.IOutputHandler;
import com.sanlark.rajiv.lib.json.hanlder.XmlFileOutputHandlerImpl;

public class MainClass {
	private static Logger logger = Logger.getLogger(MainClass.class);
	
	private static final int SUCCESS_EXIT_CODE = 0;
	private static final int ERROR_EXIT_CODE = 1;
	
	private static final String ATTR_JSON_FILE_PATH = "jsonFilePath";
	private static final String ATTR_XML_FILE_PATH = "xmlFilePath";
	private static final String ATTR_OUTPUT_TYPE = "outputType";
	
	public static void main(String[] args) {
		logger.info("Starting application");
		
		String srcFile = System.getProperty(ATTR_JSON_FILE_PATH);
		if(srcFile == null){
			exitApp("'"+ATTR_JSON_FILE_PATH+"' must be set");
		}
		
		File srcFilePath = new File(srcFile);
		if(srcFilePath.exists() == false){
			exitApp("Invalid source file path '" + srcFilePath + "'");
		}
		
		IOutputHandler outputHandler = null;
		
		if("file".equals(System.getProperty(ATTR_OUTPUT_TYPE))){
			String targetPath = System.getProperty(ATTR_XML_FILE_PATH);
			
			if(targetPath != null){
				File targetFile = new File(targetPath);
				if(targetFile.exists() == false){
					exitApp("Invalid xml file path '" + targetPath + "'");
				}
			}else{
				targetPath = new File(srcFilePath.getParent(), 
						srcFilePath.getName() + ".xml").getAbsolutePath();
			}
			
			outputHandler = new XmlFileOutputHandlerImpl(targetPath);
		}else{
			outputHandler = new ConsoleOutputHandlerImpl();
		}
		
		try{
			logger.info("Parsing started");
			
			JsonToXmlParser parser = new JsonToXmlParser();
			parser.parse(srcFilePath.getAbsolutePath(), outputHandler);
			
			logger.info("Parsing completed");
		}catch(Exception ex){
			logger.fatal(ex);
			exitApp("Exception in parsing");
		}
		
		logger.info("Execution completed");
		System.exit(SUCCESS_EXIT_CODE);
	}

	/**
	 * @param string
	 */
	private static void exitApp(String errMsg) {
		logger.error(errMsg);
		System.exit(ERROR_EXIT_CODE);
	}
}