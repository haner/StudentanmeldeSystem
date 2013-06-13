/**
 * 
 */
package spring.webapp.anmeldesystem.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

/**
 * Extends {@link CustomizableTraceInterceptor} to provide custom logging levels
 * 
 * @author Songhua Cui
 */
public class TraceInterceptor extends CustomizableTraceInterceptor {

	private static final long serialVersionUID = 5216202429049581251L;
	protected static Logger logger4J = Logger.getLogger("aop");

	/**
	 * @param logger
	 * @param message
	 * @param ex
	 */
	@Override
	protected void writeToLog(Log logger, String message, Throwable ex) {
		if (ex != null) {
			logger4J.debug(message, ex);
		} else {
			logger4J.debug(message);
		}
	}

	/**
	 * @param invocation
	 * @param logger
	 * @return 
	 */
	@Override
	protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
		return true;
	}
}