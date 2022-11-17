package org.vaadin.example.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

import java.time.LocalTime;

@PageTitle("Time Picker")
@Route(value = "time-picker", layout = MainView.class)
public class TimePickerView extends VerticalLayout {

    public TimePickerView() {
        TimePicker timePicker = new TimePicker();
        timePicker.setLabel("Time");
        timePicker.setValue(LocalTime.of(7, 0));
        add(timePicker);
    }
}