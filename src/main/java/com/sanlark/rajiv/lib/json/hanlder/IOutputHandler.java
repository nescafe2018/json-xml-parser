/**
 * Sanlark Inc.
 * @Author : Rajiv Kumar <sanlark@gmail.com>
 * @CreateDate : Mar 20, 2018
 * @Version    : 1.0.0
 */
package com.sanlark.rajiv.lib.json.hanlder;

import java.io.IOException;

public interface IOutputHandler {
	String FORMAT_PREFIX = "\t";
	
	void init()throws IOException;
	void close()throws IOException;
	
	void writeStartField(String fieldName);
	void writeEndField(String fieldName);
	
	void writeFieldValue(String fieldName, String value);
}