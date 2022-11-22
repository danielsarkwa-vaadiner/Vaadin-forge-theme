package org.vaadin.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Tabs")
@Route(value = "tabs", layout = MainView.class)
public class TabsView extends VerticalLayout {
    public TabsView() {
        basic();
        states();
        horizontalOrientation();
        verticalOrientation();
        iconsVertical();
        iconsHorizontal();
    }

    public Void basic() {
        H5 groupHeading = new H5("Basic");

        Tab details = new Tab("Tab one");
        Tab payment = new Tab("Tab two");
        Tab shipping = new Tab("Tab three");

        Tabs tabs = new Tabs(details, payment, shipping);

        add(groupHeading, tabs);

        return null;
    }

    public Void states() {
        H5 groupHeading = new H5("States");

        Tab selected = new Tab("Selected");

        Tab unselected = new Tab("Unselected");

        Tab disabled = new Tab("Disabled");
        disabled.setEnabled(false);

        Tabs tabs = new Tabs(selected, unselected, disabled);
        tabs.setSelectedTab(selected);

        add(groupHeading, tabs);

        return null;
    }

    public Void horizontalOrientation() {
        H5 groupHeading = new H5("Horizontal Orientation");

        Tab analytics = new Tab("Analytics");
        Tab customers = new Tab("Customers");
        Tab dashboards = new Tab("Dashboards");
        Tab documents = new Tab("Documents");
        Tab orders = new Tab("Orders");

        Tabs tabs = new Tabs(analytics, customers, dashboards, documents, orders);
        tabs.setMaxWidth("100%");
        tabs.setWidth("400px");

        add(groupHeading, tabs);

        return null;
    }

    public Void verticalOrientation() {
        H5 groupHeading = new H5("Vertical Orientation");

        Tab analytics = new Tab("Analytics");
        Tab customers = new Tab("Customers");
        Tab dashboards = new Tab("Dashboards");
        Tab documents = new Tab("Documents");
        Tab orders = new Tab("Orders");

        Tabs tabs = new Tabs(analytics, customers, dashboards, documents, orders);
        tabs.setMaxWidth("100%");
        tabs.setWidth("400px");

        add(groupHeading, tabs);

        return null;
    }

    public Void iconsVertical() {
        H5 groupHeading = new H5("Icons - Vertical");

        Tab profile = new Tab(
                VaadinIcon.HEART.create(),
                new Span("Tab one")
        );
        Tab settings = new Tab(
                VaadinIcon.HEART.create(),
                new Span("Tab two")
        );
        Tab notifications = new Tab(
                VaadinIcon.HEART.create(),
                new Span("Tab three")
        );

        // Set the icon on top
        for (Tab tab : new Tab[] { profile, settings, notifications }) {
            tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        }

        Tabs tabs = new Tabs(profile, settings, notifications);

        add(groupHeading, tabs);

        return null;
    }

    public Void iconsHorizontal() {
        H5 groupHeading = new H5("Icons - Horizontal");

        Tab profile = new Tab(
                VaadinIcon.HEART.create(),
                new Span("Tab one")
        );
        Tab settings = new Tab(
                VaadinIcon.HEART.create(),
                new Span("Tab two")
        );
        Tab notifications = new Tab(
                VaadinIcon.HEART.create(),
                new Span("Tab three")
        );

        Tabs tabs = new Tabs(profile, settings, notifications);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);

        add(groupHeading, tabs);

        return null;
    }
}
