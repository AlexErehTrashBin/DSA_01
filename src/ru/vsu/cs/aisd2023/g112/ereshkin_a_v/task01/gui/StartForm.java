package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.GUIUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class StartForm extends JFrame {
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	private JButton newClassButton;
	private JButton fromFileButton;
	private JButton settingsButton;
	private JButton exitButton;
	private JPanel panelMain;

	public StartForm(){
		this.setTitle("StartForm");
		this.setContentPane(panelMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
		JFileChooser fileChooserOpen = new JFileChooser();
		fileChooserOpen.setCurrentDirectory(new File("."));
		fileChooserOpen.addChoosableFileFilter(filter);

		GUIUtils.addActionListenerToButton(newClassButton, () -> {
			this.setVisible(false);
			java.awt.EventQueue.invokeLater(() -> new ClassGenerationForm(null).setVisible(true));
		});

		GUIUtils.addActionListenerToButton(fromFileButton, () -> {
			if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
				String filePath = fileChooserOpen.getSelectedFile().getPath();
				java.awt.EventQueue.invokeLater(() -> {
					this.setVisible(false);
					new ClassGenerationForm(filePath).setVisible(true);
				});
			}
		});

		GUIUtils.addActionListenerToButton(settingsButton, () -> {});

		GUIUtils.addActionListenerToButton(exitButton, () -> System.exit(0));
	}
}
