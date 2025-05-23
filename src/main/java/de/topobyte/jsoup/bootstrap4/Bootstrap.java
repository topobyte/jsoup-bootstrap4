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

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.components.Alert;
import de.topobyte.jsoup.bootstrap4.components.Badge;
import de.topobyte.jsoup.bootstrap4.components.Breadcrumb;
import de.topobyte.jsoup.bootstrap4.components.Button;
import de.topobyte.jsoup.bootstrap4.components.Column;
import de.topobyte.jsoup.bootstrap4.components.Container;
import de.topobyte.jsoup.bootstrap4.components.ContainerFluid;
import de.topobyte.jsoup.bootstrap4.components.ContextualType;
import de.topobyte.jsoup.bootstrap4.components.ListGroup;
import de.topobyte.jsoup.bootstrap4.components.ListGroupDiv;
import de.topobyte.jsoup.components.Div;

public class Bootstrap
{

	public static Container container()
	{
		return new Container();
	}

	public static ContainerFluid containerFluid()
	{
		return new ContainerFluid();
	}

	public static Button button(ContextualType type)
	{
		return new Button(type, false);
	}

	public static Button button(ContextualType type, boolean outline)
	{
		return new Button(type, outline);
	}

	public static Button button(Button.Type type)
	{
		return new Button(type, false);
	}

	public static Button button(Button.Type type, boolean outline)
	{
		return new Button(type, outline);
	}

	public static Breadcrumb breadcrumb()
	{
		return new Breadcrumb();
	}

	public static Div row()
	{
		return new Div("row");
	}

	public static Div column(Column... columns)
	{
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < columns.length; i++) {
			strb.append(columns[i].getClassName());
			if (i < columns.length - 1) {
				strb.append(" ");
			}
		}
		return HTML.div(strb.toString());
	}

	public static Badge badge(ContextualType type)
	{
		return new Badge(type);
	}

	public static Alert alert(ContextualType type)
	{
		return new Alert(type);
	}

	public static ListGroup listGroup()
	{
		return new ListGroup();
	}

	public static ListGroupDiv listGroupDiv()
	{
		return new ListGroupDiv();
	}

}
