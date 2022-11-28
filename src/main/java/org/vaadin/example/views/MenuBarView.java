package org.vaadin.example.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.contextmenu.HasMenuItems;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Menu Bar")
@Route(value = "menu-bar", layout = MainView.class)
public class MenuBarView extends VerticalLayout {

    public MenuBarView() {

        basic();
        overflow();
        icons();
        disabled();
    }

    public Void basic() {
        H5 groupHeading = new H5("Basic");

        MenuBar menuBar = new MenuBar();
        Text selected = new Text("");
        ComponentEventListener<ClickEvent<MenuItem>> listener = e -> selected.setText(e.getSource().getText());
        Div message = new Div(new Text("Clicked item: "), selected);

        menuBar.addItem("View", listener);
        menuBar.addItem("Edit", listener);

        MenuItem share = menuBar.addItem("Share");
        SubMenu shareSubMenu = share.getSubMenu();
        MenuItem onSocialMedia = shareSubMenu.addItem("On social media");
        SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
        socialMediaSubMenu.addItem("Facebook", listener);
        socialMediaSubMenu.addItem("Twitter", listener);
        socialMediaSubMenu.addItem("Instagram", listener);
        shareSubMenu.addItem("By email", listener);
        shareSubMenu.addItem("Get Link", listener);

        MenuItem move = menuBar.addItem("Move");
        SubMenu moveSubMenu = move.getSubMenu();
        moveSubMenu.addItem("To folder", listener);
        moveSubMenu.addItem("To trash", listener);

        menuBar.addItem("Duplicate", listener);

        HorizontalLayout layout = new HorizontalLayout(menuBar, message);
        add(groupHeading, layout);

        return null;
    }

    public Void overflow() {
        H5 groupHeading = new H5("Overflow");

        MenuBar menuBar = new MenuBar();
        addItems(menuBar);
        Div div = new Div();
        div.setText("Move the splitter to see overflow feature");

        SplitLayout splitLayout = new SplitLayout(menuBar, div);

        add(groupHeading, splitLayout);

        return null;
    }

    public Void icons() {
        H5 groupHeading = new H5("Icons");

        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_ICON);
        MenuItem share = createIconItem(menuBar, VaadinIcon.COPY, "Copy", null);
        createIconItem(menuBar, VaadinIcon.ALARM, null, "duplicate");

        add(groupHeading, menuBar);

        return null;
    }

    public Void disabled() {
        H5 groupHeading = new H5("Disabled");

        MenuBar menuBar = new MenuBar();

        menuBar.addItem("View")
                .setEnabled(false);
        menuBar.addItem("Edit");
        MenuItem send = menuBar.addItem("Send");
        send.setEnabled(false);
        menuBar.addItem("Move");

        menuBar.addItem("Share")
                .setEnabled(false);

        add(groupHeading, menuBar);

        return null;
    }

    private void addItems(MenuBar menuBar) {
        menuBar.addItem("View");
        menuBar.addItem("Edit");

        MenuItem share = menuBar.addItem("Share");
        SubMenu shareSubMenu = share.getSubMenu();
        MenuItem onSocialMedia = shareSubMenu.addItem("On social media");
        SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
        socialMediaSubMenu.addItem("Facebook");
        socialMediaSubMenu.addItem("Twitter");
        socialMediaSubMenu.addItem("Instagram");
        shareSubMenu.addItem("By email");
        shareSubMenu.addItem("Get Link");

        MenuItem move = menuBar.addItem("Move");
        SubMenu moveSubMenu = move.getSubMenu();
        moveSubMenu.addItem("To folder");
        moveSubMenu.addItem("To trash");

        menuBar.addItem("Duplicate");
    }

    private MenuItem createIconItem(HasMenuItems menu, VaadinIcon iconName, String label, String ariaLabel) {
        return createIconItem(menu, iconName, label, ariaLabel, false);
    }
    private MenuItem createIconItem(HasMenuItems menu, VaadinIcon iconName, String label, String ariaLabel, boolean isChild) {
        Icon icon = new Icon(iconName);

        if (isChild) {
            icon.getStyle().set("width", "var(--lumo-icon-size-s)");
            icon.getStyle().set("height", "var(--lumo-icon-size-s)");
            icon.getStyle().set("marginRight", "var(--lumo-space-s)");
        }

        MenuItem item = menu.addItem(icon, e -> {
        });

        if (ariaLabel != null) {
            item.getElement().setAttribute("aria-label", ariaLabel);
        }

        if (label != null) {
            item.add(new Text(label));
        }

        return item;
    }

}
