/**
 * 
 */
package com.satya.ds.exceptions;

/**
 * @author 703162557
 *
 */
public class ListException extends Exception {

	/**
	 * 
	 */
	public ListException() {
		this("List failed to perform the given operation.");
	}

	/**
	 * @param arg0
	 */
	public ListException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ListException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ListException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ListException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
