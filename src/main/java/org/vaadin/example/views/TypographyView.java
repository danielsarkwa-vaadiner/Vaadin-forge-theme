package org.vaadin.example.views;

import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.example.MainView;

@PageTitle("Typography")
@Route(value = "typography", layout = MainView.class)
public class TypographyView extends VerticalLayout {

    public TypographyView() {
        headlines();
        add(new Hr());
        body();
        add(new Hr());
        title();
        add(new Hr());
        otherText();
    }

    public Void headlines() {
        Paragraph headline1 = new Paragraph("Headline 1");
        headline1.addClassName("forge-typography--headline1");
        add(headline1);

        Paragraph headline2 = new Paragraph("Headline 2");
        headline2.addClassName("forge-typography--headline2");
        add(headline2);

        Paragraph headline3 = new Paragraph("Headline 3");
        headline3.addClassName("forge-typography--headline3");
        add(headline3);

        Paragraph headline4 = new Paragraph("Headline 4");
        headline4.addClassName("forge-typography--headline4");
        add(headline4);

        Paragraph headline5 = new Paragraph("Headline 5");
        headline5.addClassName("forge-typography--headline5");
        add(headline5);

        Paragraph headline6 = new Paragraph("Headline 6");
        headline6.addClassName("forge-typography--headline6");
        add(headline6);

        return null;
    }

    public Void body() {
        Paragraph body1 = new Paragraph("Body 1");
        body1.addClassName("forge-typography--body1");
        add(body1);

        Paragraph body2 = new Paragraph("Body 2");
        body2.addClassName("forge-typography--body2");
        add(body2);

        return null;
    }

    public Void title() {
        Paragraph title = new Paragraph("Title");
        title.addClassName("forge-typography--title");
        add(title);

        Paragraph subtitle1 = new Paragraph("Subtitle 1");
        subtitle1.addClassName("forge-typography--subtitle1");
        add(subtitle1);

        Paragraph subtitle1Secondary = new Paragraph("Subtitle 1 Secondary");
        subtitle1Secondary.addClassName("forge-typography--subtitle1-secondary");
        add(subtitle1Secondary);

        Paragraph subtitle2 = new Paragraph("Subtitle 2");
        subtitle2.addClassName("forge-typography--subtitle2");
        add(subtitle2);

        Paragraph subtitle2Secondary = new Paragraph("Subtitle 2 Secondary");
        subtitle2Secondary.addClassName("forge-typography--subtitle2-secondary");
        add(subtitle2Secondary);

        return null;
    }

    public Void otherText() {
        Paragraph overline = new Paragraph("Overline");
        overline.addClassName("forge-typography--overline");
        add(overline);

        Paragraph caption = new Paragraph("Caption");
        caption.addClassName("forge-typography--caption");
        add(caption);

        return null;
    }
}