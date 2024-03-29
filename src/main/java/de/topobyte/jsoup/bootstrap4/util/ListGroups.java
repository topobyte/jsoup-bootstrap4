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

package de.topobyte.jsoup.bootstrap4.util;

import de.topobyte.jsoup.bootstrap4.Bootstrap;
import de.topobyte.jsoup.bootstrap4.components.ContextualType;
import de.topobyte.jsoup.components.ListItem;

public class ListGroups
{

	public static void setBadge(ListItem item, ContextualType type, String text)
	{
		item.addClass("d-flex justify-content-between align-items-center");
		item.ac(Bootstrap.badge(type).at(text));
	}

}
