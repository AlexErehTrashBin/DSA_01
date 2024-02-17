package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.elementsgen.AddFieldDialog;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.elementsgen.AddMethodDialog;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.parentsgen.AddExtendsImplementsDialog;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.utils.GUIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog extends JDialog {
	private JPanel contentPane;
	private JButton methodButton;
	private JButton buttonCancel;
	private JButton fieldButton;
	private JButton addImplementButton;
	private JButton addExtendsButton;

	public AddDialog(ClassDescription description) {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonCancel);

		setSize(new Dimension(900, 180));

		addListeners(description);
	}

	private void addListeners(ClassDescription description) {
		GUIUtils.addActionListener(methodButton, () -> EventQueue.invokeLater(() -> {
			setVisible(false);
			new AddMethodDialog(description).setVisible(true);
		}));
		GUIUtils.addActionListener(fieldButton, () -> EventQueue.invokeLater(() -> {
			setVisible(false);
			new AddFieldDialog(description).setVisible(true);
		}));
		GUIUtils.addActionListener(addExtendsButton, () -> EventQueue.invokeLater(() -> {
			setVisible(false);
			new AddExtendsImplementsDialog(description, 0).setVisible(true);
		}));
		GUIUtils.addActionListener(addImplementButton, () -> EventQueue.invokeLater(() -> {
			setVisible(false);
			new AddExtendsImplementsDialog(description, 1).setVisible(true);
		}));
		GUIUtils.addActionListener(buttonCancel, () -> setVisible(false));
	}
}
