package org.demo2.AOPXMLconfiguration;

//new -> Annotation -> Loggable
//defined in LoggingAspect
//where ever you want to apply this annotation
//use @Loggable above that method
//example:ShapeService.getCircle() method
public @interface Loggable2 {

}
