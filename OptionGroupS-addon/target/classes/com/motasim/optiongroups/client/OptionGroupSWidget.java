package com.motasim.optiongroups.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.ArrayList;
import java.util.List;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.FocusPanel;

// Extend any GWT Widget
public class OptionGroupSWidget extends VerticalPanel {

    public static interface Callback {

        public void buttonClicked(int index);
    }

    private static final class Switch extends HTML {

        public final int index;
        public boolean activated = false;

        private Switch(int index) {

            this.index = index;
            this.setHTML("<head>\n"
                    + "<style>\n"
                    + ".switch {\n"
                    + "  position: relative;\n"
                    + "  display: inline-block;\n"
                    + "  width: 60px;\n"
                    + "  height: 34px;\n"
                    + "}\n"
                    + "\n"
                    + ".switch input {display:none;}\n"
                    + "\n"
                    + ".slider {\n"
                    + "  position: absolute;\n"
                    + "  cursor: pointer;\n"
                    + "  top: 0;\n"
                    + "  left: 0;\n"
                    + "  right: 0;\n"
                    + "  bottom: 0;\n"
                    + "  background-color: #ccc;\n"
                    + "  -webkit-transition: .4s;\n"
                    + "  transition: .4s;\n"
                    + "}\n"
                    + "\n"
                    + ".slider:before {\n"
                    + "  position: absolute;\n"
                    + "  content: \"\";\n"
                    + "  height: 26px;\n"
                    + "  width: 26px;\n"
                    + "  left: 4px;\n"
                    + "  bottom: 4px;\n"
                    + "  background-color: white;\n"
                    + "  -webkit-transition: .4s;\n"
                    + "  transition: .4s;\n"
                    + "}\n"
                    + "\n"
                    + "input:checked + .slider {\n"
                    + "  background-color: #2196F3;\n"
                    + "}\n"
                    + "\n"
                    + "input:focus + .slider {\n"
                    + "  box-shadow: 0 0 1px #2196F3;\n"
                    + "}\n"
                    + "\n"
                    + "input:checked + .slider:before {\n"
                    + "  -webkit-transform: translateX(26px);\n"
                    + "  -ms-transform: translateX(26px);\n"
                    + "  transform: translateX(26px);\n"
                    + "}\n"
                    + "\n"
                    + "/* Rounded sliders */\n"
                    + ".slider.round {\n"
                    + "  border-radius: 34px;\n"
                    + "}\n"
                    + "\n"
                    + ".slider.round:before {\n"
                    + "  border-radius: 50%;\n"
                    + "}\n"
                    + "</style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<label class=\"switch\">\n"
                    + "  <input type=\"checkbox\" checked>\n"
                    + "  <div class=\"slider round\"></div>"
                    + "</label>\n"
                    + "\n"
                    + "</body>\n"
                    + "</html>\n"
                    + "");

            this.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent clickEvent) {

                    activated = (!activated);

                }
            });
        }
    }

    private static final class ShowOptionItems extends HorizontalPanel {

        private ShowOptionItems(int index) {

        }
    }

    private static final class OptionItem extends HorizontalPanel {

        private final int index;
        private Switch sw;

        private OptionItem(String caption, int index) {
            this.index = index;
            sw = new Switch(index);
            this.add(sw);

            Label optionLabel = new Label();

            optionLabel.setText(caption);
            optionLabel.addStyleName("font");

            this.add(optionLabel);

            this.setSpacing(5);

        }

    }
    public List<Integer> selectedOptions = new ArrayList<>();

    public void setOptions(final Callback callback, String[] options, int value, List<Integer> selectedOptions) {
        this.clear();

        this.selectedOptions = selectedOptions;
        FocusPanel panel = null;
        panel = new FocusPanel();

        this.add(panel);

        for (int i = 0; i < options.length; i++) {

            if (!this.selectedOptions.contains(value)) {
                this.selectedOptions.add(value);
            }
            panel = new FocusPanel();
            this.add(panel);

            OptionItem item = new OptionItem(options[i], i);
            panel.add(item);

            panel.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    callback.buttonClicked(((OptionItem)clickEvent.getSource()).index);
                }
            });
        }

    }

}
