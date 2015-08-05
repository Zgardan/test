package com;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape,ApplicationEventPublisherAware{
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationEventPublisher publisher;
	@Autowired
	private MessageSource messageSource;

	public void draw(){
		System.out.println(this.messageSource.getMessage("drawing.triangle", null, "Default Drawing Message", null));
		System.out.println("PointA : (" + pointA.getX()+ ", " + pointA.getY() + ")");
		System.out.println("PointB : (" + pointB.getX()+ ", " + pointB.getY() + ")");
		System.out.println("PointC : (" + pointC.getX()+ ", " + pointC.getY() + ")");
		System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getPointA() {
		return pointA;
	}
	@Resource
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	
	public Point getPointB() {
		return pointB;
	}
	@Resource
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}
	@Resource
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	@PostConstruct
	public void inititializeTriangle(){
		System.out.println("Init of Triangle");
	}
	@PreDestroy
	public void destroyTriangle(){
		System.out.println("Destroy of Triangle");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
}
