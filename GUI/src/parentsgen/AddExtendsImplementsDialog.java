package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.parentsgen;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;

import javax.swing.*;

public class AddExtendsImplementsDialog extends JDialog {
	private JPanel contentPane;
	private JButton buttonOK;
	private JButton buttonCancel;

	public AddExtendsImplementsDialog(ClassDescription description) {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);
	}
}
