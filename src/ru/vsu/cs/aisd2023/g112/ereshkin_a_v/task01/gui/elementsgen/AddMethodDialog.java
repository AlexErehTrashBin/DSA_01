package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.elementsgen;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.common.AccessComboBoxModel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Method;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.GUIUtils;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.MethodUtils;

import javax.swing.*;
import java.awt.*;

public class AddMethodDialog extends JDialog {
	private final ClassDescription description;
	private JPanel contentPane;
	private JButton createButton;
	private JButton cancelButton;
	private JTextArea codeArea;
	private JTextField nameTextField;
	private JCheckBox staticCheckBox;
	private JCheckBox finalCheckBox;
	private JComboBox<AccessLevel> accessComboBox;
	private JTextPane bodyPane;
	private JTextField typeTextField;
	private Method method;

	public AddMethodDialog(ClassDescription description) {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(createButton);
		setSize(new Dimension(900, 400));

		this.description = description;

		initMethod();
		addListeners();
		initFields();
		updateCode();

	}

	private void initMethod() {
		method = MethodUtils.getDefaultMethod();
	}

	private void initFields() {
		nameTextField.setText(method.getName());

		typeTextField.setText(method.getType());

		finalCheckBox.setSelected(method.isFinal());

		staticCheckBox.setSelected(method.isStatic());

		bodyPane.setText(method.getBody());

		AccessComboBoxModel model = new AccessComboBoxModel();
		accessComboBox.setModel(model);
		accessComboBox.setSelectedItem(method.getAccessLevel());
	}

	private void addListeners() {
		/// Кнопка "Создать" - добавляет метод в класс и закрывает окно
		GUIUtils.addActionListener(createButton, () -> {
			description.addMethods(method);
			method = MethodUtils.getDefaultMethod();
			setVisible(false);
		});
		/// Кнопка "Отмена" - закрывает окно
		GUIUtils.addActionListener(cancelButton, () -> this.setVisible(false));
		/// ComboBox "Уровень доступа"
		GUIUtils.addKeyListener(bodyPane, () -> {
			method.setBody(bodyPane.getText());
			updateCode();
		});
		GUIUtils.addItemListener(accessComboBox, () -> {
			method.setAccessLevel((AccessLevel) accessComboBox.getSelectedItem());
			updateCode();
		});
		GUIUtils.addKeyListener(nameTextField, () -> {
			method.setName(nameTextField.getText());
			updateCode();
		});
		GUIUtils.addKeyListener(typeTextField, () -> {
			method.setType(typeTextField.getText());
			updateCode();
		});
		/// Галка "Статический" - делает метод статическим и переписывает код на новый
		GUIUtils.addActionListener(staticCheckBox, () -> {
			method.setStatic(staticCheckBox.isSelected());
			updateCode();
		});
		/// Галка "Финальный" - делает метод финальным и переписывает код на новый
		GUIUtils.addActionListener(finalCheckBox, () -> {
			method.setFinal(finalCheckBox.isSelected());
			updateCode();
		});
	}

	private void updateCode() {
		codeArea.setText(method.toString());
	}
}