package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.gui.common;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccessComboBoxModel implements ComboBoxModel<AccessLevel> {
	List<AccessLevel> accessLevelList;
	AccessLevel selectedItem;

	public AccessComboBoxModel() {
		this.accessLevelList = new ArrayList<>();
		accessLevelList.addAll(Arrays.asList(AccessLevel.values()));
		selectedItem = AccessLevel.PACKAGE_PRIVATE;
	}

	public AccessComboBoxModel(boolean isClass) {
		this.accessLevelList = new ArrayList<>();
		if (isClass) {
			accessLevelList.add(AccessLevel.PUBLIC);
			accessLevelList.add(AccessLevel.PACKAGE_PRIVATE);
		}
		selectedItem = AccessLevel.PACKAGE_PRIVATE;
	}

	@Override
	public AccessLevel getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		if (anItem == selectedItem) return;
		if (anItem == null || anItem.getClass() != selectedItem.getClass()) return;

		selectedItem = (AccessLevel) anItem;
	}

	@Override
	public int getSize() {
		return accessLevelList.size();
	}

	@Override
	public AccessLevel getElementAt(int index) {
		return accessLevelList.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
	}
}
