package org.vaadin.example.views;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Combo Box")
@Route(value = "combo-box", layout = MainView.class)
public class ComboBoxView extends VerticalLayout {
    public ComboBoxView() {

        labeling();
        helperText();

    }

    public Void labeling() {
        H5 groupHeading = new H5("Label and placeholder");

        ComboBox<String> label = new ComboBox<>("Label");
        label.setAllowCustomValue(true);
        label.setItems("Option 1", "Option 2", "Option 3", "Option 4");
        add(label);

        ComboBox<String> lp = new ComboBox<>("Label");
        lp.setAllowCustomValue(true);
        lp.setPlaceholder("Select an option");
        lp.setItems("Option 1", "Option 2", "Option 3", "Option 4");
        add(lp);

        HorizontalLayout labeling = new HorizontalLayout(label, lp);
        add(groupHeading, labeling);

        return null;
    }

    public Void helperText() {
        H5 groupHeading = new H5("Helper Text");

        ComboBox<String> helperText = new ComboBox<>("Label");
        helperText.setAllowCustomValue(true);
        helperText.setItems("Option 1", "Option 2", "Option 3", "Option 4");
        helperText.setHelperText("Select or type an option");

        add(groupHeading, helperText);

        return null;
    }
}