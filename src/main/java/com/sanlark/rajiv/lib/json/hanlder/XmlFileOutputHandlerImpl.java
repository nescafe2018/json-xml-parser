/**
 * Sanlark Inc.
 * @Author : Rajiv Kumar <sanlark@gmail.com>
 * @CreateDate : Mar 20, 2018
 * @Version    : 1.0.0
 */
package com.sanlark.rajiv.lib.json.hanlder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XmlFileOutputHandlerImpl extends AbstractOutputHandler{
	
	private final String xmlFilePath;
	private BufferedWriter writer;

	public XmlFileOutputHandlerImpl(String xmlFilePath){
		this.xmlFilePath = xmlFilePath;
	}

	protected void initResourceHandler()throws IOException{
		this.writer = new BufferedWriter(new FileWriter(xmlFilePath));
	}
	
	protected void releaseResourceHandler()throws IOException{
		writer.flush();
		writer.close();
	}

	/**
	 * @param value
	 */
	protected void print(String value)throws IOException{
		writer.write(value + "\n");
	}
}