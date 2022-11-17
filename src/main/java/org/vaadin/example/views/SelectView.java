package org.vaadin.example.views;

import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Select")
@Route(value = "select", layout = MainView.class)
public class SelectView extends VerticalLayout {

    public SelectView() {
        Select<String> select = new Select<>();
        select.setLabel("Label");
        select.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        select.setPlaceholder("Select an item");
        select.setHelperText("Supportive text");
        select.setItemEnabledProvider(item -> !"Item 1".equals(item));
        add(select);

        Select<String> placeholder = new Select<>();
        placeholder.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        placeholder.setPlaceholder("Select an item");
        placeholder.setItemEnabledProvider(item -> !"Item 1".equals(item));
        add(placeholder);

        Select<String> selectDivider = new Select<>();
        selectDivider.setLabel("Label");
        selectDivider.setItems("Item 1", "Item 2", "Item 3", "Item 4", "Item 5");
        selectDivider.addComponents("Item 1", new Hr());
        selectDivider.addComponents("Item 2", new Hr());
        selectDivider.setValue("Item 1");
        add(selectDivider);
    }
}
