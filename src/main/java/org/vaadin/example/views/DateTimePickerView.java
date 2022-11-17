package org.vaadin.example.views;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Date Time Picker")
@Route(value = "date-time-picker", layout = MainView.class)
public class DateTimePickerView extends VerticalLayout {

    public DateTimePickerView() {
        DateTimePicker dateTimePicker = new DateTimePicker();
        dateTimePicker.setLabel("Date and time");
        add(dateTimePicker);
    }
}
