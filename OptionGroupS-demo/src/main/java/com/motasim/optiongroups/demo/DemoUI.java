package com.motasim.optiongroups.demo;

import com.motasim.optiongroups.OptionGroupS;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.Arrays;
import com.vaadin.ui.Notification;

@Theme("demo")
@Title("OptionGroupS Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        // Initialize our new UI component
        // Initialize our new UI component
        final OptionGroupS component = new OptionGroupS("Please choose the options you want to activate: ", Arrays.asList("GPS", "Google Maps", "RFID", "TRY THIS", "HELLO"));
       

        component.addValueChangeListener(e -> Notification.show("You choosed "+component.getItemCaption(e.getProperty().getValue())));
 
        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("demoContentLayout");
        layout.setSizeFull();
        layout.addComponent(component);
        layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
        setContent(layout);
    }
}
