// Copyright 2016 Sebastian Kuerten
//
// This file is part of jsoup-bootstrap4.
//
// jsoup-bootstrap4 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jsoup-bootstrap4 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with jsoup-bootstrap4. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.jsoup.bootstrap4;

import static de.topobyte.jsoup.HTML.b;
import static de.topobyte.jsoup.HTML.br;
import static de.topobyte.jsoup.HTML.div;
import static de.topobyte.jsoup.HTML.h1;
import static de.topobyte.jsoup.HTML.i;
import static de.topobyte.jsoup.HTML.p;
import static de.topobyte.jsoup.bootstrap4.Bootstrap.alert;
import static de.topobyte.jsoup.bootstrap4.Bootstrap.badge;
import static de.topobyte.jsoup.bootstrap4.Bootstrap.button;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.bootstrap4.components.Alert;
import de.topobyte.jsoup.bootstrap4.components.Badge;
import de.topobyte.jsoup.bootstrap4.components.Breadcrumb;
import de.topobyte.jsoup.bootstrap4.components.Button;
import de.topobyte.jsoup.bootstrap4.components.Card;
import de.topobyte.jsoup.bootstrap4.components.CollapsibleCard;
import de.topobyte.jsoup.bootstrap4.components.Container;
import de.topobyte.jsoup.bootstrap4.components.ContextualType;
import de.topobyte.jsoup.bootstrap4.components.NavTabs;
import de.topobyte.jsoup.bootstrap4.components.ResponsiveImage;
import de.topobyte.jsoup.components.Body;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.P;

public class OverviewGenerator extends BaseGenerator
{

	private Path path = TestBootstrap4.DIR.resolve("index.html");

	@Override
	public void generate() throws IOException
	{
		super.generate();

		Body body = builder.getBody();

		// Content

		Container c = body.ac(Bootstrap.container());

		breadcrumbs(c);

		c.ap(h1().inner("The headline"));

		Div div = c.ac(div("foo"));

		P p = div.ac(p().inner("this is a paragraph in a div. "));

		System.out.println(p);
		p.ap(b().inner("bold"));
		p.at(" and ");
		p.ap(i().inner("italic"));
		p.at(" text is possible as well");
		System.out.println(p);

		buttons1(div);
		buttons2(div);

		labels(div);

		navTabs(div);

		panels(div);

		alerts(div);

		div.ac(new ResponsiveImage("image.svg"));

		Document doc = builder.getDocument();
		System.out.println(doc);

		builder.write(path);
	}

	private static void breadcrumbs(Container c)
	{
		Breadcrumb breadcrumb = Bootstrap.breadcrumb();
		c.ap(breadcrumb);

		breadcrumb.addTextItem("foo");
		breadcrumb.addTextItem("bar");
		breadcrumb.addTextItem("and");
		breadcrumb.addTextItem("so on");
	}

	private static void buttons1(Div div)
	{
		P p = div.ac(p().inner("A paragraph with some buttons:"));
		p.ap(br());

		List<ContextualType> types = Arrays.asList(ContextualType.values());
		Iterator<ContextualType> iterator = types.iterator();
		while (iterator.hasNext()) {
			ContextualType type = iterator.next();

			p.ac(button(type).inner("I'm a button")).attr("href", "#");
			if (iterator.hasNext()) {
				p.at(" ");
			}
		}

		p = div.ac(p());
		iterator = types.iterator();
		while (iterator.hasNext()) {
			ContextualType type = iterator.next();

			p.ac(button(type, true).inner("I'm a button")).attr("href", "#");
			if (iterator.hasNext()) {
				p.at(" ");
			}
		}
	}

	private static void buttons2(Div div)
	{
		P p = div.ac(p().inner("More buttons:"));
		p = div.ac(p());

		List<Button.Type> types = Arrays.asList(Button.Type.values());
		Iterator<Button.Type> iterator = types.iterator();
		while (iterator.hasNext()) {
			Button.Type type = iterator.next();

			p.ac(button(type).inner("I'm a button")).attr("href", "#");
			if (iterator.hasNext()) {
				p.at(" ");
			}
		}

		p = div.ac(p());
		iterator = types.iterator();
		while (iterator.hasNext()) {
			Button.Type type = iterator.next();

			p.ac(button(type, true).inner("I'm a button")).attr("href", "#");
			if (iterator.hasNext()) {
				p.at(" ");
			}
		}
	}

	private static void labels(Div div)
	{
		P p = div.ac(p().inner("Another paragraph with some labels:"));
		p.ap(br());

		List<ContextualType> types = Arrays.asList(ContextualType.values());
		Iterator<ContextualType> iterator = types.iterator();
		while (iterator.hasNext()) {
			ContextualType type = iterator.next();
			Badge label = badge(type);
			p.ap(label.inner(
					"I'm a label of type " + type.toString().toLowerCase()));
			if (iterator.hasNext()) {
				p.at(" ");
			}
		}
	}

	private static void navTabs(Div div)
	{
		div.ac(p().inner("Nav tabs:"));
		NavTabs navTabs = new NavTabs();
		div.ac(navTabs.getElement());

		for (int i = 1; i <= 5; i++) {
			navTabs.addItem("#", "item " + i, i == 2);
		}
	}

	private static void panels(Div div)
	{
		div.ac(p().inner("Panels:"));

		Card panel = div.ac(new Card(false));
		panel.getCardHead().at("A simple panel");
		panel.getCardBody().at("Some content");
		panel.addClass("mb-2");

		panel = div.ac(new Card(true));
		panel.getCardHead().at("A simple panel");
		panel.getCardBody().at("Some content");
		panel.getCardFooter().at("A footer");
		panel.addClass("mb-2");

		CollapsibleCard cpanel = div.ac(new CollapsibleCard(false, true, true));
		cpanel.getPanelHead().at("A collapsible panel");
		cpanel.getPanelBody().at("Some content");
		cpanel.addClass("mb-2");

		cpanel = div.ac(new CollapsibleCard(true, true, false));
		cpanel.getPanelHead().at("A collapsible panel");
		cpanel.getPanelBody().at("Some content");
		cpanel.getPanelFooter().at("A footer");
		cpanel.addClass("mb-2");
	}

	private static void alerts(Div div)
	{
		div.ac(p().inner("Alerts:"));

		List<ContextualType> types = Arrays.asList(ContextualType.values());
		Iterator<ContextualType> iterator = types.iterator();
		while (iterator.hasNext()) {
			ContextualType type = iterator.next();
			Alert alert = div.ac(alert(type));
			alert.at("I'm an alert of type " + type.toString().toLowerCase());
		}
	}

}
