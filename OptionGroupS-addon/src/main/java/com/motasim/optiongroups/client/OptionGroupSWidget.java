package com.motasim.optiongroups.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.List;

// Extend any GWT Widget
public class OptionGroupSWidget extends VerticalPanel {

    public static interface Callback {

        public void buttonClicked(int index);
    }

    private static final class OptionItem extends FocusWidget implements HasValue<Boolean> {

        private Element slider;
        private final int index;
        private boolean value = false;

//        @Override
//        public HandlerRegistration addClickHandler(ClickHandler handler) {
//            this.setValue(!this.getValue(),true);
//            return super.addClickHandler(handler); //To change body of generated methods, choose Tools | Templates.
//        }

        private OptionItem(String caption, int index) {

            this.index = index;

            setElement(Document.get().createDivElement());
            setStyleName("OptionGroupS");

            slider = Document.get().createLabelElement();
            slider.setClassName("OptionGroupS-slider");

            getElement().appendChild(slider);
            updateStyleName(false);

        }

        private void updateStyleName(boolean isChecked) {
            if (isChecked) {
                slider.addClassName("on");
                slider.removeClassName("off");
            } else {
                slider.addClassName("off");
                slider.removeClassName("on");
            }
        }

        @Override
        public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
            return addHandler(handler, ValueChangeEvent.getType());
        }

        @Override
        public Boolean getValue() {
            return value;
        }

        @Override
        public void setValue(Boolean value) {
            setValue(value, false);
        }

        @Override
        public void setValue(Boolean value, boolean fireEvents) {
            if (value == null) {
                value = Boolean.FALSE;
            }
            if (this.value != value) {
                this.value = value;
                updateStyleName(value);
                if (fireEvents) {
                    ValueChangeEvent.fire(this, value);
                }
            }
        }
    }

    public void setOptions(final Callback callback, String[] options, List<Integer> value) {
        this.clear();
        HorizontalPanel panel = null;

        for (int i = 0; i < options.length; i++) {

            {
                panel = new HorizontalPanel();
                this.add(panel);
            }

            OptionItem item = new OptionItem(options[i], i);

            panel.add(item);
            if (value.contains(i)) {
                item.setValue(true,true);
                item.updateStyleName(true);
            } else {
                item.setValue(false,true);
                item.updateStyleName(false);
            }
            item.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    callback.buttonClicked(((OptionItem) clickEvent.getSource()).index);

                }
            });
        }
    }

}
