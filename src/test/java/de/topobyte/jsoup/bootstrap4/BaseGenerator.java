// Copyright 2020 Sebastian Kuerten
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

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import de.topobyte.jsoup.ElementUtil;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.HtmlBuilder;
import de.topobyte.jsoup.bootstrap4.components.Menu;
import de.topobyte.jsoup.bootstrap4.components.MenuBuilder;
import de.topobyte.jsoup.components.Body;
import de.topobyte.jsoup.components.Head;
import de.topobyte.jsoup.components.Meta;
import de.topobyte.jsoup.nodes.Element;

public class BaseGenerator
{

	protected HtmlBuilder builder = new HtmlBuilder();

	public void generate() throws IOException
	{
		Head head = builder.getHead();

		Meta meta = head.ac(HTML.meta());
		meta.attr("http-equiv", "content-type");
		meta.attr("content", "text/html; charset=utf-8");

		meta = head.ac(HTML.meta());
		meta.attr("name", "viewport");
		meta.attr("content",
				"width=device-width, initial-scale=1, shrink-to-fit=no");

		String header = IOUtils
				.toString(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("bootstrap4.headers.html"));
		System.out.println(header);
		ElementUtil.appendFragment(head, header);

		Body body = builder.getBody();

		// Menu

		menu(body);
	}

	protected static void menu(Body body)
	{
		MenuBuilder menuBuilder = new MenuBuilder();
		Menu menu = menuBuilder.create();
		body.ap(menu);

		menu.addBrand(HTML.span().at("Awesome"));
		menu.addToggleButton();

		Element<?> collapse = menu.addCollapsible();
		Element<?> main = menu.addSection(collapse);
		Element<?> right = menu.addSectionRight(collapse);

		menu.addLink(main, "index.html", "Overview", false);
		menu.addLink(main, "forms.html", "Forms", false);
		menu.addLink(main, "list-groups.html", "List-Groups", false);

		menu.addLink(right, "#", "About", false);
	}

}
