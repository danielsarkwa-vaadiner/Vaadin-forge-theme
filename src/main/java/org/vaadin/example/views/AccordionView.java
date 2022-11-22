package org.vaadin.example.views;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Accordion")
@Route(value = "accordion", layout = MainView.class)
public class AccordionView extends VerticalLayout {
    public AccordionView() {

        basic();
        filledVariant();
        reverseVariant();
        disabled();
    }

    public Void basic() {
        H5 groupHeading = new H5("Basic");

        Accordion accordion = new Accordion();
        accordion.setWidth("300px");

        accordion.add("Panel one", content());
        accordion.add("Panel two", content());
        accordion.add("Panel three", content());

        add(groupHeading, accordion);

        return null;
    }

    public Void filledVariant() {
        H5 groupHeading = new H5("Filled Variant");

        Accordion accordion = new Accordion();
        accordion.setWidth("300px");

        AccordionPanel panel1 = accordion.add("Panel one", content());
        panel1.addThemeVariants(DetailsVariant.FILLED);
        AccordionPanel panel2 = accordion.add("Panel two", content());
        panel2.addThemeVariants(DetailsVariant.FILLED);
        AccordionPanel panel3 = accordion.add("Panel three", content());
        panel3.addThemeVariants(DetailsVariant.FILLED);

        add(groupHeading, accordion);

        return null;
    }

    public Void reverseVariant() {
        H5 groupHeading = new H5("Reverse Variant");

        Accordion accordion = new Accordion();
        accordion.setWidth("300px");

        AccordionPanel panel1 = accordion.add("Panel one", content());
        panel1.addThemeVariants(DetailsVariant.REVERSE);
        AccordionPanel panel2 = accordion.add("Panel two", content());
        panel2.addThemeVariants(DetailsVariant.REVERSE);
        AccordionPanel panel3 = accordion.add("Panel three", content());
        panel3.addThemeVariants(DetailsVariant.REVERSE);

        add(groupHeading, accordion);

        return null;
    }

    public Void disabled() {
        H5 groupHeading = new H5("Disabled");

        Accordion accordion = new Accordion();

        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");

        VerticalLayout personalInformationLayout = new VerticalLayout(name, email, phone);
        personalInformationLayout.setSpacing(false);
        personalInformationLayout.setPadding(false);

        accordion.add("Personal information", personalInformationLayout);

        Span street = new Span("4027 Amber Lake Canyon");
        Span zipCode = new Span("72333-5884 Cozy Nook");
        Span city = new Span("Arkansas");

        VerticalLayout billingAddressLayout = new VerticalLayout();
        billingAddressLayout.setSpacing(false);
        billingAddressLayout.setPadding(false);
        billingAddressLayout.add(street, zipCode, city);

        AccordionPanel billingAddressPanel = accordion.add("Billing address", billingAddressLayout);
        billingAddressPanel.setEnabled(false);

        Span cardBrand = new Span("Mastercard");
        Span cardNumber = new Span("1234 5678 9012 3456");
        Span expiryDate = new Span("Expires 06/21");

        VerticalLayout paymentLayout = new VerticalLayout();
        paymentLayout.setSpacing(false);
        paymentLayout.setPadding(false);
        paymentLayout.add(cardBrand, cardNumber, expiryDate);

        AccordionPanel paymentPanel = accordion.add("Payment", paymentLayout);
        paymentPanel.setEnabled(false);

        add(groupHeading, accordion);

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
