package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

public interface AbstractClassElement extends AbstractParameter {
	AccessLevel getAccessLevel();

	void setAccessLevel(AccessLevel accessLevel);

	boolean isStatic();

	void setStatic(boolean aStatic);

	boolean isFinal();

	void setFinal(boolean aFinal);
}
