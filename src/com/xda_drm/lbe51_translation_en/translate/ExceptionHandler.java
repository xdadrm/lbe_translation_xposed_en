package com.xda_drm.lbe51_translation_en.translate;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
	  public void uncaughtException(Thread t, Throwable e) {
	    System.out.println("Throwable: " + e.getMessage());
	    System.out.println(t.toString());
	  }
	}