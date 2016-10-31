package com.motasim.optiongroups.client;

import com.vaadin.shared.ui.optiongroup.OptionGroupState;
import com.vaadin.shared.ui.select.AbstractSelectState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionGroupSState extends AbstractSelectState {

    public List<Integer> chosenOptions = new ArrayList<Integer>();
    public String[] options = new String[0];
  
}
