package com.motasim.optiongroups.client;

import com.motasim.optiongroups.OptionGroupS;

import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

// Connector binds client-side widget class to server-side component class
// Connector lives in the client and the @Connect annotation specifies the
// corresponding server-side component
@Connect(OptionGroupS.class)
public class OptionGroupSConnector extends AbstractComponentConnector {

    // ServerRpc is used to send events to server. Communication implementation
    // is automatically created here
    OptionGroupSServerRpc rpc = RpcProxy.create(OptionGroupSServerRpc.class, this);

    private final OptionGroupSWidget.Callback callback = new OptionGroupSWidget.Callback() {
        @Override
        public void buttonClicked(int index) {
            rpc.selected(index);
        }
    };

    // We must implement getWidget() to cast to correct type
    // (this will automatically create the correct widget type)
      @Override
    public OptionGroupSWidget getWidget() {
        return (OptionGroupSWidget) super.getWidget();
    }

    // We must implement getState() to cast to correct type
    @Override
    public OptionGroupSState getState() {
        return (OptionGroupSState) super.getState();
    }

    // Whenever the state changes in the server-side, this method is called
    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setOptions(callback, getState().options, getState().chosenOptionsIds);

    }
}
