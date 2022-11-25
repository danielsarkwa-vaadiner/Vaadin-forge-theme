package org.vaadin.example.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("List Box")
@Route(value = "list-box", layout = MainView.class)
public class ListBoxView extends VerticalLayout {

    public ListBoxView() {
        basic();
        minimal();
        dividers();
        disabled();
    }

    public Void basic() {
        final String SHOW_ASSIGNEE = "List Item One";
        final String SHOW_DUE_DATE = "List Item Two";
        final String SHOW_STATUS = "List Item Three";

        H5 groupHeading = new H5("Basic");

        MultiSelectListBox<String> listBox = new MultiSelectListBox<>();
        listBox.setItems(SHOW_ASSIGNEE, SHOW_DUE_DATE, SHOW_STATUS);
        listBox.select(SHOW_ASSIGNEE, SHOW_STATUS);
        listBox.setWidth("400px");

        add(groupHeading, listBox);

        return null;
    }

    public Void minimal() {
        final String SHOW_ASSIGNEE = "List Item One";
        final String SHOW_DUE_DATE = "List Item Two";
        final String SHOW_STATUS = "List Item Three";

        H5 groupHeading = new H5("Minimal");

        MultiSelectListBox<String> listBox = new MultiSelectListBox<>();
        listBox.setItems(SHOW_ASSIGNEE, SHOW_DUE_DATE, SHOW_STATUS);
        listBox.select(SHOW_ASSIGNEE, SHOW_STATUS);
        listBox.setWidth("400px");
        listBox.getElement().getThemeList().add("minimal");

        add(groupHeading, listBox);

        return null;
    }

    public Void dividers() {
        final String SHOW_ASSIGNEE = "List Item One";
        final String SHOW_DUE_DATE = "List Item Two";
        final String SHOW_STATUS = "List Item Three";
        final String SHOW_THUMBNAIL = "List Item Four";
        final String SHOW_PREVIEW = "List Item Five";

        H5 groupHeading = new H5("Dividers");

        MultiSelectListBox<String> listBox = new MultiSelectListBox<>();
        listBox.setItems(
                SHOW_ASSIGNEE, SHOW_DUE_DATE, SHOW_STATUS, SHOW_THUMBNAIL, SHOW_PREVIEW
        );
        listBox.addComponents(SHOW_STATUS, new Hr());
        listBox.select(SHOW_ASSIGNEE, SHOW_STATUS, SHOW_THUMBNAIL);
        listBox.setWidth("400px");

        add(groupHeading, listBox);

        return null;
    }

    private class Status {

        private String name;
        private int count;

        Status(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getDisplayName() {
            return this.name + " (" + this.count + ")";
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public Void disabled() {
        Status inProgress = new Status("In progress", 2);
        Status done = new Status("Done", 4);
        Status cancelled = new Status("Cancelled", 0);

        H5 groupHeading = new H5("Disabled");

        ListBox<Status> listBox = new ListBox<>();
        listBox.setItems(inProgress, done, cancelled);
        listBox.setItemEnabledProvider(status -> status.getCount() > 0);
        listBox.setRenderer(new ComponentRenderer<>(status ->
                new Text(status.getDisplayName()))
        );
        listBox.setValue(inProgress);
        listBox.setWidth("400px");

        add(groupHeading, listBox);

        return null;
    }
}