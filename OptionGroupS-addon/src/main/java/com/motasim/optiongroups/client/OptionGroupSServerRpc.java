package com.motasim.optiongroups.client;

import com.vaadin.shared.communication.ServerRpc;

// ServerRpc is used to pass events from client to server
public interface OptionGroupSServerRpc extends ServerRpc {

    // Example API: Widget click is clicked
    public void  selected(int itemIndex);

}
