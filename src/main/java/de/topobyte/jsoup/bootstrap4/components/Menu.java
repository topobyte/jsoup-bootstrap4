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

package de.topobyte.jsoup.bootstrap4.components;

import static de.topobyte.jsoup.HTML.a;
import static de.topobyte.jsoup.HTML.div;
import static de.topobyte.jsoup.HTML.li;
import static de.topobyte.jsoup.HTML.span;
import static de.topobyte.jsoup.HTML.ul;

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.ElementBuilder;
import de.topobyte.jsoup.bootstrap4.Bootstrap;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.jsoup.nodes.Element;

public class Menu extends Element<Menu>
{

	private String idNavbar;
	protected Element<?> content = this;

	public Menu(boolean fixed, boolean fullWidth, Expand expand, boolean light,
			String color)
	{
		this("bs-navbar-collapse", fixed, fullWidth, expand, light, color);
	}

	public Menu(String idNavbar, boolean fixed, boolean fullWidth,
			Expand expand, boolean light, String color)
	{
		super("nav");
		this.idNavbar = idNavbar;
		addClass("navbar");
		if (fixed) {
			addClass("fixed-top");
		}
		if (expand != Expand.NEVER) {
			addClass("navbar-expand-" + expand.id);
		}
		if (color == null) {
			if (light) {
				addClass("navbar-light bg-light");
			} else {
				addClass("navbar-dark bg-dark");
			}
		} else {
			if (light) {
				addClass("navbar-light");
			} else {
				addClass("navbar-dark");
			}
			attr("style", "background-color: " + color);
		}
		if (!fullWidth) {
			container();
		}
	}

	private void container()
	{
		content = ac(Bootstrap.container());
	}

	public void addToggleButton()
	{
		Element<?> button = content.ac(ElementBuilder.create("button", "type",
				"button", "class", "navbar-toggler", "data-toggle", "collapse",
				"data-target", "#" + idNavbar, "aria-controls", idNavbar,
				"aria-expanded", "false", "aria-label", "Toggle navigation"));

		button.appendChild(span().addClass("navbar-toggler-icon"));
	}

	public void addBrand(org.jsoup.nodes.Element brand)
	{
		content.ac(brand.addClass("navbar-brand"));
	}

	public Div addCollapsible()
	{
		return content.ac(div().addClass("collapse navbar-collapse").attr("id",
				idNavbar));
	}

	public UnorderedList addSection(Element<?> collapse)
	{
		UnorderedList list = collapse.ac(ul());
		list.addClass("navbar-nav");
		return list;
	}

	public UnorderedList addSectionRight(Element<?> collapse)
	{
		UnorderedList list = collapse.ac(ul());
		list.addClass("navbar-nav ml-auto");
		return list;
	}

	public void add(Element<?> section, Node content, boolean active)
	{
		Element<?> li = section.ac(li().addClass("nav-item"));
		if (active) {
			li.addClass("active");
		}
		li.appendChild(content);
	}

	public void addLink(Element<?> section, String link, String text,
			boolean active)
	{
		A a = a(link).inner(text).addClass("nav-link");

		Element<?> li = section.ac(li().addClass("nav-item"));
		if (active) {
			li.addClass("active");
		}
		li.appendChild(a);
	}

}
