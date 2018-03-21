/**
 * Sanlark Inc.
 * @Author : Rajiv Kumar <sanlark@gmail.com>
 * @CreateDate : Mar 21, 2018
 * @Version    : 1.0.0
 */
package com.sanlark.rajiv.lib.json.hanlder;

import java.io.IOException;

public class ConsoleOutputHandlerImpl extends AbstractOutputHandler{

	@Override
	protected void initResourceHandler() throws IOException {}

	@Override
	protected void releaseResourceHandler() throws IOException {}

	@Override
	protected void print(String value) throws IOException {
		System.out.println(value);
	}

}