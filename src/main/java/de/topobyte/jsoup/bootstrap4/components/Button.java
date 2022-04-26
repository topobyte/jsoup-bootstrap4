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

package de.topobyte.jsoup.bootstrap4.components;

import java.util.EnumMap;
import java.util.Map;

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.nodes.Element;

public class Button extends Element<Button>
{

	public enum Type {

		PRIMARY,
		SECONDARY,
		SUCCESS,
		INFO,
		WARNING,
		DANGER,
		LIGHT,
		DARK,
		LINK;

		private static Map<Type, String> map = new EnumMap<>(Type.class);
		static {
			for (Type type : values()) {
				map.put(type, type.name().toLowerCase());
			}
		}

		public static String getName(Type type)
		{
			return map.get(type);
		}

	}

	public Button(ContextualType type, boolean outline)
	{
		super("a");
		if (type == null) {
			throw new IllegalArgumentException("null is not allowed");
		}
		String typename = ContextualType.getName(type);
		if (outline) {
			attr("class", "btn btn-outline-" + typename);
		} else {
			attr("class", "btn btn-" + typename);
		}
		attr("role", "button");
	}

	public Button(Type type, boolean outline)
	{
		super("a");
		if (type == null) {
			throw new IllegalArgumentException("null is not allowed");
		}
		String typename = Type.getName(type);
		if (outline) {
			attr("class", "btn btn-outline-" + typename);
		} else {
			attr("class", "btn btn-" + typename);
		}
		attr("role", "button");
	}

	public Button(ContextualType type, boolean outline, String text)
	{
		this(type, outline);
		at(text);
	}

	public Button(ContextualType type, boolean outline, Node child)
	{
		this(type, outline);
		appendChild(child);
	}

	public Button(ContextualType type, boolean outline, String text,
			String href)
	{
		this(type, outline, text);
		attr("href", href);
	}

	public Button(ContextualType type, boolean outline, Node child, String href)
	{
		this(type, outline, child);
		attr("href", href);
	}

	public Button(Type type, boolean outline, String text)
	{
		this(type, outline);
		at(text);
	}

	public Button(Type type, boolean outline, Node child)
	{
		this(type, outline);
		appendChild(child);
	}

	public Button(Type type, boolean outline, String text, String href)
	{
		this(type, outline, text);
		attr("href", href);
	}

	public Button(Type type, boolean outline, Node child, String href)
	{
		this(type, outline, child);
		attr("href", href);
	}

}
