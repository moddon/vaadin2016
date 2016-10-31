package com.motasim.optiongroups;

import com.motasim.optiongroups.client.OptionGroupSServerRpc;
import com.motasim.optiongroups.client.OptionGroupSState;
import com.vaadin.data.Container;
import com.vaadin.data.Property;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractSelect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

// This is the server-side UI component that provides public API 
// for OptionGroupS
public class OptionGroupS extends AbstractSelect {

    private OptionGroupSServerRpc rpc = new OptionGroupSServerRpc() {
        @Override
        public void selected(int itemIndex) {
            selectedItemAtIndex(itemIndex);
        }
    };

    public OptionGroupS() {
        super.setMultiSelect(true);
        registerRpc(rpc);
    }

    public OptionGroupS(String caption) {
        super(caption);
        super.setMultiSelect(true);
        registerRpc(rpc);
    }

    public OptionGroupS(String caption, Container source) {
        super(caption, source);
        super.setMultiSelect(true);
        registerRpc(rpc);
    }

    public OptionGroupS(String caption, Collection<?> options) {
        super(caption, options);
        super.setMultiSelect(true);
        registerRpc(rpc);
    }

    @Override
    public void setMultiSelect(boolean multiSelect) {
       
        super.setMultiSelect(multiSelect);
    }

    private void selectedItemAtIndex(int index) {

        super.select(index);
        if (getState().chosenOptions.contains(index)) {
            unselect(index);
           getState().chosenOptions.removeIf(x -> x.equals(index));
        } else {
            getState().chosenOptions.add(index);
        }
        setValue(getState().chosenOptions);
    }

    @Override
    public void unselect(Object itemId) {
        super.unselect(itemId);
    }

    private void updateOptions() {
        getState().options
                = this.getContainerDataSource() != null && this.getContainerDataSource().size() > 0
                        ? this.getContainerDataSource().getItemIds().stream().map(this::getItemCaption).collect(Collectors.toList()).toArray(new String[0])
                        : new String[0];
    }

    @Override
    public void setValue(Object newValue) throws Property.ReadOnlyException {
        if (newValue == getNullSelectionItemId()) {
            newValue = null;
        }

        setValue(newValue, false);
    }

    @Override
    public void setContainerDataSource(Container newDataSource) {
        super.setContainerDataSource(newDataSource);
        updateOptions();
    }

    @Override
    public void containerItemSetChange(Container.ItemSetChangeEvent event) {
        super.containerItemSetChange(event);
        updateOptions();
    }

    @Override
    protected OptionGroupSState getState(boolean markAsDirty) {
        return (OptionGroupSState) super.getState(markAsDirty);
    }

    // We must override getState() to cast the state to OptionGroupSState
    @Override
    protected OptionGroupSState getState() {
        return (OptionGroupSState) super.getState();
    }
}
