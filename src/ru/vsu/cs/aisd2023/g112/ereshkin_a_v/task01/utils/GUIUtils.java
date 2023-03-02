package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils;

import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIUtils {
	public static void runWithCatching(Runnable r){
		try {
			r.run();
		} catch (Exception e){
			SwingUtils.showErrorMessageBox(e);
		}
	}
	/**
	 * Костыль для табуляции в 4 знака внутри JTextPane
	 * */
	public static void setTabs(JTextPane textPane, int charactersPerTab) {
		FontMetrics fm = textPane.getFontMetrics(textPane.getFont());
		int charWidth = fm.charWidth('w');
		int tabWidth = charWidth * charactersPerTab;

		TabStop[] tabs = new TabStop[10];

		for (int j = 0; j < tabs.length; j++) {
			int tab = j + 1;
			tabs[j] = new TabStop(tab * tabWidth);
		}

		TabSet tabSet = new TabSet(tabs);
		SimpleAttributeSet attributes = new SimpleAttributeSet();
		StyleConstants.setTabSet(attributes, tabSet);
		int length = textPane.getDocument().getLength();
		textPane.getStyledDocument()
				.setParagraphAttributes(0, length, attributes, false);
	}
	public static <T extends AbstractButton> void addActionListener(T element, Runnable r){
		element.addActionListener(e -> GUIUtils.runWithCatching(r));
	}
	public static <T extends JComponent> void addKeyListener(T component, Runnable runnable){
		component.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				GUIUtils.runWithCatching(runnable);
			}
		});
	}
	public static <T extends ItemSelectable> void addItemListener(T component, Runnable runnable){
		component.addItemListener(e -> GUIUtils.runWithCatching(runnable));
	}
}
