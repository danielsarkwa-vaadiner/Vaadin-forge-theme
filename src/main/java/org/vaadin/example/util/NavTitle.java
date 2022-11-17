package org.vaadin.example.util;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;

public class NavTitle extends H1 implements AfterNavigationObserver {

    public void afterNavigation(AfterNavigationEvent event) {
        this.setText(UI.getCurrent().getInternals().getTitle());
    }
}