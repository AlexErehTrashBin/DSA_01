package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

public class ClassElement extends Parameter implements AbstractClassElement {
	private AccessLevel accessLevel;
	private boolean isFinal = false;
	private boolean isStatic = false;

	public ClassElement(String type, String name) {
		super(type, name);
	}

	@Override
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	@Override
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public boolean isStatic() {
		return isStatic;
	}

	@Override
	public void setStatic(boolean aStatic) {
		isStatic = aStatic;
	}

	@Override
	public boolean isFinal() {
		return isFinal;
	}

	@Override
	public void setFinal(boolean aFinal) {
		isFinal = aFinal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ClassElement element = (ClassElement) o;

		return getName().equals(element.getName());
	}
}