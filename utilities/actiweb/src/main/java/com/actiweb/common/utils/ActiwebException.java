package com.actiweb.common.utils;

public class ActiwebException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private String errorCode;

  /**
   * @param string
   */
  public ActiwebException(String errorCode, String errorMessage) {
    super(errorMessage);
    this.errorCode = errorCode;
  }

  public ActiwebException(String code, Exception e) {
    super(e);
    this.errorCode = code;
  }

  @Override
  public String toString() {
    return "ActiwebException [errorCode=" + errorCode + "]";
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
