package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.util.JTableUtils;

import javax.swing.*;

public class ClassGenerationForm extends JFrame {
	private static final int DEFAULT_WIDTH = 1000;
	private static final int DEFAULT_HEIGHT = 600;
	private static final String DEFAULT_CLASS_NAME = "SampleClass";
	private JPanel panelMain;
	private JTable classElementsTable;
	private JTextPane codePane;
	private JTextField classNameField;
	private JButton addMethodButton;
	private JButton addFieldButton;
	private JButton removeButton;

	public ClassGenerationForm(String filePath) {
		this.setTitle("ClassGenerationForm");
		this.setContentPane(panelMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		ClassDescription description = new ClassDescription(DEFAULT_CLASS_NAME);
		classNameField.setText(DEFAULT_CLASS_NAME);

		JTableUtils.initJTableForArray(
				classElementsTable, 100,
				false, false,
				false, false,
				false);
		JTableUtils.writeArrayToJTable(classElementsTable, new String[][]{
				{"Метод", "Test"}
		});


	}
}
