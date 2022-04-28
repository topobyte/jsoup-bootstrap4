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

import static de.topobyte.jsoup.HTML.h1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.FormUtil;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.components.Button;
import de.topobyte.jsoup.bootstrap4.components.Container;
import de.topobyte.jsoup.bootstrap4.components.ContextualType;
import de.topobyte.jsoup.bootstrap4.forms.Checkbox;
import de.topobyte.jsoup.bootstrap4.forms.Group;
import de.topobyte.jsoup.bootstrap4.forms.InlineCheckbox;
import de.topobyte.jsoup.bootstrap4.forms.InputGroup;
import de.topobyte.jsoup.bootstrap4.forms.RadioGroup;
import de.topobyte.jsoup.bootstrap4.forms.SelectGroup;
import de.topobyte.jsoup.components.Body;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Form;
import de.topobyte.jsoup.components.Input.Type;

public class FormsGenerator extends BaseGenerator
{

	private Path path = TestBootstrap4.DIR.resolve("forms.html");

	@Override
	public void generate() throws IOException
	{
		super.generate();

		Body body = builder.getBody();

		// Content

		Container c = body.ac(Bootstrap.container());

		c.ap(h1().inner("Regular forms"));

		form(c);

		c.ap(h1().inner("Horizontal forms"));

		horizontalForm(c);

		c.ap(h1().inner("Submit buttons"));

		submitButtons(c);

		Document doc = builder.getDocument();
		System.out.println(doc);

		builder.write(path);
	}

	private void form(Container content)
	{
		Form form = content.ac(HTML.form());
		form.attr("id", "form1");

		BootstrapForms forms = new BootstrapForms();
		formContent(form, forms, "nrml-");
	}

	private void horizontalForm(Container content)
	{
		Form form = content.ac(HTML.form());
		form.attr("id", "form2");
		form.addClass("form-horizontal");

		BootstrapFormsHorizontal forms = new BootstrapFormsHorizontal();
		formContent(form, forms, "hrz-");
	}

	private void formContent(Form form, BootstrapForms forms, String prefix)
	{
		InputGroup inputName = forms.addInput(form, "name", "Name");
		inputName.getInput().setPlaceholder("Your name");

		InputGroup inputPassword = forms.addInput(form, "password", "Password");
		inputPassword.getInput().setType(Type.PASSWORD);

		SelectGroup selectGroup = forms.addSelect(form, "pet", "Preferred Pet",
				Arrays.asList("Cat", "Dog", "Bird"),
				Arrays.asList("cat", "dog", "bird"));

		FormUtil.addPleaseSelectOption(selectGroup.getSelect());

		RadioGroup radios = forms.addRadio(form, prefix + "drink_a",
				"Preferred Drink", Arrays.asList("Coke", "Water", "Beer"),
				Arrays.asList("coke", "water", "beer"), true);

		Group group = radios.getGroup();
		Checkbox checkbox = forms.addCheckbox(group.getContent(), "sugar",
				"And everyhting with sugar", prefix + "box1");
		checkbox.getInput().setChecked(true);

		group = forms.addGroup(form);
		forms.addCheckbox(group.getContent(), "stay_signed_in",
				"A checkbox without a label to the left", prefix + "box2");

		radios = forms.addRadio(form, prefix + "drink_b", "Preferred Drink",
				Arrays.asList("Coke", "Water", "Beer"),
				Arrays.asList("coke", "water", "beer"), false);
		radios.getInputs().get(1).setChecked(true);

		group = forms.addGroup(form, "Options");
		forms.addCheckbox(group.getContent(), "stay_signed_in",
				"Keep me signed in", prefix + "box3");
		forms.addCheckbox(group.getContent(), "other", "Something else",
				prefix + "box4");

		group = forms.addGroup(form, "Multiple");
		Div div = group.getContent().ac(HTML.div());
		InlineCheckbox inlineCheckbox = forms.addInlineCheckbox(div,
				"stay_signed_in", "Keep me signed in", prefix + "box5");
		inlineCheckbox.getInput().setChecked(true);
		forms.addInlineCheckbox(div, "other", "Something else",
				prefix + "box6");

		forms.addSubmit(form, "Continue");
	}

	private void submitButtons(Container content)
	{
		Form form = content.ac(HTML.form());
		form.attr("id", "form2");
		form.addClass("form-horizontal");

		BootstrapFormsHorizontal forms = new BootstrapFormsHorizontal();

		InputGroup inputName = forms.addInput(form, "name", "Name");
		inputName.getInput().setPlaceholder("Your name");

		InputGroup inputPassword = forms.addInput(form, "password", "Password");
		inputPassword.getInput().setType(Type.PASSWORD);

		forms.addSubmit(form, "Continue");
		forms.addSubmit(form, ContextualType.DANGER, false, "Continue");
		forms.addSubmit(form, Button.Type.LINK, false, "Continue");
		forms.addSubmit(form, ContextualType.WARNING, true, "Continue");
		forms.addSubmit(form, Button.Type.SUCCESS, true, "Continue");
	}

}
