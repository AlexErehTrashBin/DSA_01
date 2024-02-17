package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.classgen;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.AddDialog;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.common.AccessComboBoxModel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.utils.GUIUtils;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.utils.ClassUtils;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer.ClassDeserializer;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer.ClassSerializer;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ClassGenerationForm extends JFrame {
	private static final int DEFAULT_WIDTH = 1400;
	private static final int DEFAULT_HEIGHT = 600;
	private ClassDescription description;
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
	private JCheckBox staticCheckBox;
	private JComboBox<AccessLevel> accessComboBox;
	private JButton saveButton;

	public ClassGenerationForm(String filePath) {
		this.setTitle("Создание класса");
		this.setContentPane(panelMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		description = ClassUtils.getDefaultClass();
		if (filePath != null) {
			try {
				description = ClassDeserializer.getClassFromLines(ArrayUtils.readLinesFromFile(filePath));
			} catch (FileNotFoundException e) {
				SwingUtils.showInfoMessageBox(e.getMessage());
			}
		}

		classNameField.setText(description.getName());

		codePane.setEditable(false);
		codePane.setText(description.toString());
		GUIUtils.setTabs(codePane, 4);

		addListeners();

		AccessComboBoxModel model = new AccessComboBoxModel(true);
		accessComboBox.setModel(model);
		accessComboBox.setSelectedItem(description.getAccessLevel());

		GUIUtils.addItemListener(accessComboBox, () -> {
			description.setAccessLevel((AccessLevel) accessComboBox.getSelectedItem());
			updateCode();
		});

		/// Галка "Статический" - делает класс статическим и переписывает код на новый
		GUIUtils.addActionListener(staticCheckBox, () -> {
			description.setStatic(staticCheckBox.isSelected());
			updateCode();
		});

		JFileChooser fileChooserSave = new JFileChooser();
		fileChooserSave.setCurrentDirectory(new File("."));
		FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
		fileChooserSave.addChoosableFileFilter(filter);

		GUIUtils.addActionListener(saveButton, () -> {

			if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
				String pathToSave = fileChooserSave.getSelectedFile().getPath();
				String code = ClassSerializer.serialize(description);
				try {
					PrintWriter ps = new PrintWriter(pathToSave);
					ps.print(code);
					ps.close();
				} catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		});
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