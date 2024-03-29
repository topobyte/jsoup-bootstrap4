// Copyright 2019 Sebastian Kuerten
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

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.components.Div;

public class Alert extends Div
{

	public Alert(ContextualType type)
	{
		if (type == null) {
			throw new IllegalArgumentException("null is not allowed");
		}
		String typename = ContextualType.getName(type);
		attr("class", "alert alert-" + typename);
		attr("role", "alert");
	}

	public Alert(ContextualType type, String text)
	{
		this(type);
		at(text);
	}

	public Alert(ContextualType type, Node child)
	{
		this(type);
		appendChild(child);
	}

}
