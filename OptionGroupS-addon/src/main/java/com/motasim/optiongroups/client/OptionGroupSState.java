package com.motasim.optiongroups.client;

import com.vaadin.shared.ui.optiongroup.OptionGroupState;
import com.vaadin.shared.ui.select.AbstractSelectState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionGroupSState extends AbstractSelectState {

    // State can have both public variable and bean properties
   
    public int latestChosen = -1;
    public List<Integer> chosenOptions = new ArrayList<>();
    public String[] options = new String[0];
  
}
