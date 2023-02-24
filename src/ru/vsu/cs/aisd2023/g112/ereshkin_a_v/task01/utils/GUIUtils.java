package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils;

import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;

public class GUIUtils {
	public static void runWithCatching(Runnable r){
		try {
			r.run();
		} catch (Exception e){
			SwingUtils.showErrorMessageBox(e);
		}
	}
	public static void addActionListenerToButton(JButton button, Runnable r){
		button.addActionListener(e -> GUIUtils.runWithCatching(r));
	}
}
