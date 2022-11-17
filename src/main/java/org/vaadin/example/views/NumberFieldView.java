package org.vaadin.example.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Number Field")
@Route(value = "number-field", layout = MainView.class)
public class NumberFieldView extends VerticalLayout {
    public NumberFieldView() {

        basic();
        stepper();

    }

    public Void basic() {
        H5 groupHeading = new H5("Leading and trailing content");

        NumberField leadingChar = new NumberField();
        leadingChar.setLabel("Label");
        leadingChar.setValue(200.0);
        Div prefix = new Div();
        prefix.setText("$");
        leadingChar.setPrefixComponent(prefix);
        leadingChar.addThemeName("has-text-prefix"); // used when field has a prefix text component

        NumberField leadingIcon = new NumberField();
        leadingIcon.setLabel("Label");
        leadingIcon.setValue(200.0);
        leadingIcon.setPrefixComponent(VaadinIcon.SEARCH.create());
        leadingIcon.addThemeName("leading-icon"); // used when field has a prefix icon component

        NumberField trailing = new NumberField();
        trailing.setLabel("Label");
        trailing.setValue(200.0);
        Div suffix = new Div();
        suffix.setText("€");
        trailing.setSuffixComponent(suffix);

        HorizontalLayout layout = new HorizontalLayout(leadingChar, leadingIcon, trailing);
        add(groupHeading, layout);

        add(groupHeading, layout);

        return null;
    }

    public Void stepper() {
        H5 groupHeading = new H5("Stepper");

        IntegerField stepper = new IntegerField();
        stepper.setValue(2);
        stepper.setHasControls(true);
        stepper.setMin(0);
        stepper.setMax(9);
        add(stepper);

        add(groupHeading, stepper);

        return null;
    }
}