package com.plugtree.spotplug.client.mainviews;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.plugtree.spotplug.client.visualizationWidgets.ChartPanel;
import com.plugtree.spotplug.client.visualizationWidgets.EventChartPanel;
import com.plugtree.spotplug.client.visualizationWidgets.RuleChartPanel;

public class EventView extends VerticalPanel {

    private ChartPanel chartPanel1 = new RuleChartPanel();
    private ChartPanel chartPanel2 = new RuleChartPanel();
    private ChartPanel chartPanel3 = new EventChartPanel();
    private ChartPanel chartPanel4 = new EventChartPanel();
    
    private Label ruleLabel = new Label("Rules viewer:");
    private Label eventLabel = new Label("Events viewer:");
	    
	private HorizontalPanel horizontalPanel1 = new HorizontalPanel();
	private HorizontalPanel horizontalPanel2 = new HorizontalPanel();
	
	public EventView() {
	    setUp();
	}
	
	private void setUp() {
		
		horizontalPanel1.add(chartPanel1);
		horizontalPanel1.add(chartPanel2);

		horizontalPanel2.add(chartPanel3);
		horizontalPanel2.add(chartPanel4);

		add(ruleLabel);
		add(horizontalPanel1);
		add(eventLabel);
		add(horizontalPanel2);
	}
}
