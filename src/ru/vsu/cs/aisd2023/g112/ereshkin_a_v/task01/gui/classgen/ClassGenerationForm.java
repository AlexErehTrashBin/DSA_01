package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.classgen;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.AddDialog;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.ClassUtils;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.GUIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClassGenerationForm extends JFrame {
	private static final int DEFAULT_WIDTH = 1400;
	private static final int DEFAULT_HEIGHT = 600;
	private final ClassDescription description;
	private JPanel panelMain;
	private JTextPane codePane;
	private JTextField classNameField;
	private JButton addButton;
	private JButton removeMethodsButton;
	private JButton removeFieldsButton;
	private JButton removeAllExtendsButton;
	private JButton removeAllImplementsButton;
	private JButton writeCodeButton;
	private JButton removeAllButton;
	private JButton removeButton;
	private JButton replaceOrAddButton;
	private String path;

	public ClassGenerationForm(String filePath) {
		this.setTitle("Создание класса");
		this.setContentPane(panelMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		setPath(filePath);

		description = ClassUtils.getDefaultClass();
		classNameField.setText(description.getName());

		codePane.setEditable(false);
		codePane.setText(description.toString());
		GUIUtils.setTabs(codePane, 4);

		addListeners();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private void addFirstRowButtonsListeners() {
		addButton.addActionListener(e -> EventQueue.invokeLater(() -> {
			new AddDialog(description).setVisible(true);
			updateCode();
		}));
	}

	private void addSecondRowButtonsListeners() {
		GUIUtils.addActionListener(removeMethodsButton, () -> {
			description.clearMethods();
			updateCode();
		});
		GUIUtils.addActionListener(removeFieldsButton, () -> {
			description.clearFields();
			updateCode();
		});
		GUIUtils.addActionListener(removeAllExtendsButton, () -> {
			description.clearParentClasses();
			updateCode();
		});
		GUIUtils.addActionListener(removeAllImplementsButton, () -> {
			description.clearParentInterfaces();
			updateCode();
		});
	}

	private void addThirdRowButtonsListeners() {
		GUIUtils.addActionListener(writeCodeButton, () -> {
			codePane.setText(description.toString());
		});
		GUIUtils.addActionListener(removeAllButton, () -> {
			description.clearAll();
			codePane.setText(description.toString());
		});
	}

	private void updateCode() {
		codePane.setText(description.toString());
	}

	private void addListeners() {
		addFirstRowButtonsListeners();
		addSecondRowButtonsListeners();
		addThirdRowButtonsListeners();

		classNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyPressed(e);
				description.setName(classNameField.getText());
				updateCode();
			}
		});
	}

}