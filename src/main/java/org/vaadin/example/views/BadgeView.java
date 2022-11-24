package org.vaadin.example.views;

import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Badge")
@Route(value = "badge", layout = MainView.class)
public class BadgeView extends VerticalLayout {

    public BadgeView() {
        basic();
        icon();
    }

    public Void basic() {
        H5 groupHeading = new H5("Basic");

        // Default variant
        Span pending = new Span("Pending");
        pending.getElement().getThemeList().add("badge");

        Span confirmed = new Span("Confirmed");
        confirmed.getElement().getThemeList().add("badge success");

        Span denied = new Span("Denied");
        denied.getElement().getThemeList().add("badge error");

        Span onHold = new Span("On hold");
        onHold.getElement().getThemeList().add("badge contrast");

        // Primary variant
        Span pendingPrimary = new Span("Pending");
        pendingPrimary.getElement().getThemeList().add("badge primary");

        Span confirmedPrimary = new Span("Confirmed");
        confirmedPrimary.getElement().getThemeList().add("badge success primary");

        Span deniedPrimary = new Span("Denied");
        deniedPrimary.getElement().getThemeList().add("badge error primary");

        Span onHoldPrimary = new Span("On hold");
        onHoldPrimary.getElement().getThemeList().add("badge contrast primary");

        HorizontalLayout normal = new HorizontalLayout(pending, confirmed, denied, onHold);
        HorizontalLayout primary = new HorizontalLayout(pendingPrimary, confirmedPrimary, deniedPrimary, onHoldPrimary);

        add(groupHeading, new VerticalLayout(normal, primary));

        return null;
    }

    public Void icon() {
        H5 groupHeading = new H5("Icon");

        // Icon before text
        Span pending1 = new Span(createIcon(VaadinIcon.CLOCK), new Span("Pending"));
        pending1.getElement().getThemeList().add("badge");

        Span confirmed1 = new Span(createIcon(VaadinIcon.CHECK), new Span("Confirmed"));
        confirmed1.getElement().getThemeList().add("badge success");

        Span denied1 = new Span(createIcon(VaadinIcon.EXCLAMATION_CIRCLE_O), new Span("Denied"));
        denied1.getElement().getThemeList().add("badge error");

        Span onHold1 = new Span(createIcon(VaadinIcon.HAND), new Span("On hold"));
        onHold1.getElement().getThemeList().add("badge contrast");

        // Icon after text
        Span pending2 = new Span(new Span("Pending"), createIcon(VaadinIcon.CLOCK));
        pending2.getElement().getThemeList().add("badge primary");

        Span confirmed2 = new Span(new Span("Confirmed"), createIcon(VaadinIcon.CHECK));
        confirmed2.getElement().getThemeList().add("badge success primary");

        Span denied2 = new Span(new Span("Denied"), createIcon(VaadinIcon.EXCLAMATION_CIRCLE_O));
        denied2.getElement().getThemeList().add("badge error primary");

        Span onHold2 = new Span(new Span("On hold"), createIcon(VaadinIcon.HAND));
        onHold2.getElement().getThemeList().add("badge contrast primary");

        HorizontalLayout normal = new HorizontalLayout(pending1, confirmed1, denied1, onHold1);
        HorizontalLayout primary = new HorizontalLayout(pending2, confirmed2, denied2, onHold2);

        add(groupHeading, new VerticalLayout(normal, primary));

        return null;
    }

    private Icon createIcon(VaadinIcon vaadinIcon) {
        Icon icon = vaadinIcon.create();
        icon.getStyle().set("padding", "var(--lumo-space-xs");
        return icon;
    }
}