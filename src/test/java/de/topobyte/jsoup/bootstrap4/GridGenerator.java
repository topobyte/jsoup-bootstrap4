// Copyright 2025 Sebastian Kuerten
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

import static de.topobyte.jsoup.bootstrap4.components.Column.MD_6;
import static de.topobyte.jsoup.bootstrap4.components.Column.XS_12;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.components.Container;
import de.topobyte.jsoup.bootstrap4.components.ListGroup;
import de.topobyte.jsoup.components.Body;
import de.topobyte.jsoup.components.Div;

public class GridGenerator extends BaseGenerator
{

	private Path path = TestBootstrap4.DIR.resolve("grid.html");

	@Override
	public void generate() throws IOException
	{
		super.generate();

		Body body = builder.getBody();

		// Content

		Container c = body.ac(Bootstrap.container());

		columns(c);

		Document doc = builder.getDocument();
		System.out.println(doc);

		builder.write(path);
	}

	private void columns(Container c)
	{
		Div row = c.ac(Bootstrap.row());
		column(row, Bootstrap.column(XS_12, MD_6));
		column(row, Bootstrap.column(XS_12, MD_6));
		column(row, Bootstrap.column(XS_12));
	}

	private void column(Div row, Div col)
	{
		row.ac(col);
		col.ac(HTML.p()).at("This is a " + col.attr("class") + " column")
				.addClass("mt-4");

		basic(col);
	}

	private void basic(Div content)
	{
		ListGroup list = content.ac(Bootstrap.listGroup());
		for (int i = 0; i < 5; i++) {
			list.addTextItem(getText(i));
		}
	}

	private String getText(int i)
	{
		return texts.get(i % texts.size());
	}

	private List<String> texts = new ArrayList<>();
	{
		texts.add("Cras justo odio");
		texts.add("Dapibus ac facilisis in");
		texts.add("Morbi leo risus");
		texts.add("Porta ac consectetur ac");
		texts.add("Vestibulum at eros");
	}

}
