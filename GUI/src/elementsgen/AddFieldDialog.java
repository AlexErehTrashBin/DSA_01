package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.elementsgen;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.common.AccessComboBoxModel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.utils.GUIUtils;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Field;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.utils.FieldUtils;

import javax.swing.*;
import java.awt.*;

public class AddFieldDialog extends JDialog {
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
	private Field field;

	public AddFieldDialog(ClassDescription description) {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(createButton);
		setSize(new Dimension(900, 400));

		this.description = description;

		initField();
		addListeners();
		initFields();
		updateCode();

	}

	private void initField() {
		field = FieldUtils.getDefault();
	}

	private void initFields() {
		nameTextField.setText(field.getName());

		typeTextField.setText(field.getType());

		finalCheckBox.setSelected(field.isFinal());

		staticCheckBox.setSelected(field.isStatic());

		bodyPane.setText(field.getInitialValue());
		GUIUtils.setTabs(bodyPane, 4);

		AccessComboBoxModel model = new AccessComboBoxModel();
		accessComboBox.setModel(model);
		accessComboBox.setSelectedItem(field.getAccessLevel());
	}

	private void addListeners() {
		/// Кнопка "Создать" - добавляет метод в класс и закрывает окно
		GUIUtils.addActionListener(createButton, () -> {
			description.addFields(field);
			field = FieldUtils.getDefault();
			setVisible(false);
		});
		/// Кнопка "Отмена" - закрывает окно
		GUIUtils.addActionListener(cancelButton, () -> this.setVisible(false));
		GUIUtils.addKeyListener(bodyPane, () -> {
			field.setInitialValue(bodyPane.getText());
			updateCode();
		});
		/// ComboBox "Уровень доступа"
		GUIUtils.addItemListener(accessComboBox, () -> {
			field.setAccessLevel((AccessLevel) accessComboBox.getSelectedItem());
			updateCode();
		});
		GUIUtils.addKeyListener(nameTextField, () -> {
			field.setName(nameTextField.getText());
			updateCode();
		});
		GUIUtils.addKeyListener(typeTextField, () -> {
			field.setType(typeTextField.getText());
			updateCode();
		});
		/// Галка "Статический" - делает поле статическим и переписывает код на новый
		GUIUtils.addActionListener(staticCheckBox, () -> {
			field.setStatic(staticCheckBox.isSelected());
			updateCode();
		});
		/// Галка "Финальный" - делает поле финальным и переписывает код на новый
		GUIUtils.addActionListener(finalCheckBox, () -> {
			field.setFinal(finalCheckBox.isSelected());
			updateCode();
		});
	}

	private void updateCode() {
		codeArea.setText(field.toString());
	}
}