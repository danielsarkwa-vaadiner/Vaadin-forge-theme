package org.vaadin.example.views;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Checkbox")
@Route(value = "checkbox", layout = MainView.class)
public class CheckboxView extends VerticalLayout {

    public CheckboxView() {

        states();
        orientation();

    }

    public Void states() {
        H5 groupHeading = new H5("Check state");

        Checkbox uncheckedBox = new Checkbox("Unchecked");

        Checkbox checkedBox = new Checkbox("Checked");
        checkedBox.setValue(true);

        Checkbox indeterminateBox = new Checkbox("Indeterminate");
        indeterminateBox.setIndeterminate(true);

        HorizontalLayout layout = new HorizontalLayout(uncheckedBox, checkedBox, indeterminateBox);
        add(groupHeading, layout);

        return null;
    }

    public Void orientation() {
        H5 groupHeading = new H5("Check state");

        CheckboxGroup<String> checkboxGroupHorizontal = new CheckboxGroup<>();
        checkboxGroupHorizontal.setItems("Label 1", "Label 2", "Label 3");

        CheckboxGroup<String> checkboxGroupVertical = new CheckboxGroup<>();
        checkboxGroupVertical.setItems("Label 1", "Label 2", "Label 3", "Label 4", "Label 5", "Label 6", "Label 7");
        checkboxGroupVertical.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        VerticalLayout layout = new VerticalLayout(checkboxGroupHorizontal, checkboxGroupVertical);
        layout.setPadding(false);
        add(groupHeading, layout);

        return null;
    }
}
