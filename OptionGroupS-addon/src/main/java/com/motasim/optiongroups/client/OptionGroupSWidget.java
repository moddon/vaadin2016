package com.motasim.optiongroups.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.ArrayList;
import java.util.List;

// Extend any GWT Widget
public class OptionGroupSWidget extends VerticalPanel {

    public static interface Callback {

        public void buttonClicked(int index);
    }

    private static final class OptionItems extends CheckBox {

        private final int index;
        private final List<Integer> selectedOptions = new ArrayList<>();

        private OptionItems(String caption, int index) {
            this.index = index;
            this.setText(caption);
            if (!selectedOptions.contains(index)) {
                selectedOptions.add(index);
            }
            this.setText(caption);
        }
    }
    public  List<Integer> selectedOptions = new ArrayList<>();

    public void setOptions(final Callback callback, String[] options, int value, List<Integer> selectedOptions) {
        this.clear();
        this.selectedOptions = selectedOptions;
        HorizontalPanel panel = null;
        panel = new HorizontalPanel();
        this.add(panel);
       
        for (int i = 0; i < options.length; i++) {

             if (!this.selectedOptions.contains(value)) {
            this.selectedOptions.add(value);
        }
            panel = new HorizontalPanel();
            this.add(panel);

            OptionItems btn = new OptionItems(options[i], i);
            panel.add(btn);
            if ((i == value) || (this.selectedOptions.contains(i))) {
                btn.addStyleName("selected");
            } else {
                btn.removeStyleName("selected");
            }
            btn.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    callback.buttonClicked(((OptionItems) clickEvent.getSource()).index);
                }
            });
        }
    }

}
