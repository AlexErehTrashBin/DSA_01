package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.StartForm;
import ru.vsu.cs.util.SwingUtils;

public class Main {
	public static void main(String[] args) {
		SwingUtils.setLookAndFeelByName("Windows");
		SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
		StartForm form = new StartForm();
		java.awt.EventQueue.invokeLater(() -> form.setVisible(true));
	}
}