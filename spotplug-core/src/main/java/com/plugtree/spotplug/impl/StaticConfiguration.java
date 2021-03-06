/**
 * Copyright 2010 Plugtree LLC 
Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License. 
 */
 
package com.plugtree.spotplug.impl;

import com.plugtree.spotplug.Configuration;
import com.plugtree.spotplug.Engine;
import com.plugtree.spotplug.EventInput;
import com.plugtree.spotplug.bus.Bus;

public class StaticConfiguration implements Configuration {

	private Engine engine;
	private EventInputManager eventInputManager;
	private EventInput fileEventInput;
	private Bus bus;
	private ActivatedRuleListener ruleListener;
	//private EventInput jmsEventInput;
	
	public StaticConfiguration(){
	}

	public void setEngine(Engine engine){
		this.engine = engine;
	}
	
	public Engine getEngine(){
		return engine;
	}
	
	@Override
    public EventInputManager getEventInputManager() {
		return eventInputManager;
	}
	
	public void setEventInputManager(EventInputManager eventInputManager) {
		this.eventInputManager = eventInputManager;
	}

	@Override
	public void configure() {
		//eventInputManager.addEventInput(jmsEventInput);
		ruleListener.setBus(bus);
		eventInputManager.addEventInput(fileEventInput);
		engine.configure();
	}

	public void setFileEventInput(EventInput eventInput) {
		this.fileEventInput = eventInput;
	}

	public EventInput getFileEventInput() {
		return fileEventInput;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public void setRuleListener(ActivatedRuleListener ruleListener) {
		this.ruleListener = ruleListener;
	}

//	public void setJmsEventInput(EventInput jmsEventInput) {
//		this.jmsEventInput = jmsEventInput;
//	}
//
//	public EventInput getJmsEventInput() {
//		return jmsEventInput;
//	}
}

	
