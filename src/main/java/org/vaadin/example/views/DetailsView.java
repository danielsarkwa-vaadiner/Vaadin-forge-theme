package org.vaadin.example.views;

import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Details")
@Route(value = "details", layout = MainView.class)
public class DetailsView extends VerticalLayout {

    public DetailsView() {
        basic();
        filledVariant();
        reverseVariant();
    }

    public Void basic() {
        H5 groupHeading = new H5("Basic");

        Details details = new Details("Contact information", content());
        details.setWidth("300px");
        details.setOpened(true);

        add(groupHeading, details);

        return null;
    }

    public Void filledVariant() {
        H5 groupHeading = new H5("Filled Variant");

        Details details = new Details("Members (8)", content());
        details.setWidth("300px");
        details.setOpened(true);
        details.addThemeVariants(DetailsVariant.FILLED);

        add(groupHeading, details);

        return null;
    }

    public Void reverseVariant() {
        H5 groupHeading = new H5("Reverse Variant");

        Details details = new Details("Members (8)", content());
        details.setWidth("300px");
        details.setOpened(true);
        details.addThemeVariants(DetailsVariant.REVERSE);

        add(groupHeading, details);

        return null;
    }

    private VerticalLayout content() {
        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");

        VerticalLayout informationLayout = new VerticalLayout(name, email, phone);
        informationLayout.setSpacing(false);
        informationLayout.setPadding(false);

        return informationLayout;
    }
}
