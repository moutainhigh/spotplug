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

import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;

import com.plugtree.spotplug.Engine;
import com.plugtree.spotplug.Event;
import com.plugtree.spotplug.RuleReader;

public class FusionEngine implements Engine {

	private RuleReader reader;
	private StatefulKnowledgeSession session;
	private WorkingMemoryEntryPoint entryPoint;
	
	public FusionEngine() {
	}
	
	public void configure(){
				
		entryPoint = getSession().getWorkingMemoryEntryPoint("GenericEventEntryPoint");

		
//		TODO:
//		new Thread(new Runnable() {
//			public void run() {
//				session.fireUntilHalt();
//			}
//		}).start();
	}
		
	public synchronized void processEvent(Event event) {	
		
		entryPoint.insert(event);
		getSession().fireAllRules();
	}
	
	public void stop(){
		getSession().halt();
		getSession().dispose();
	}
	
	public void setRuleReader(RuleReader ruleReader) {
		this.reader = ruleReader;
	}

	
	public void setSession(StatefulKnowledgeSession session) {
		this.session = session;
	}

	public StatefulKnowledgeSession getSession() {
		return session;
	}	
}