package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.parentsgen;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExtendsImplementsDialog extends JDialog {
	private JPanel contentPane;
	private JButton buttonOK;
	private JButton buttonCancel;
	private JTextField textField;

	public AddExtendsImplementsDialog(ClassDescription description, int addCode) {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);

		setSize(new Dimension(900, 180));
		buttonCancel.addActionListener(e -> {
			this.setVisible(false);
		});
		buttonOK.addActionListener(e -> {
			if (addCode == 0){
				description.addParentClassName(textField.getText());
				this.setVisible(false);
			} else if (addCode == 1){
				description.addParentInterfaceName(textField.getText());
				this.setVisible(false);
			}
		});
	}
}
