package org.example.core;

import java.util.ArrayList;
import java.util.List;

public class MyStringBuilder {
    private StringBuilder stringBuilder;
    private final List<String> snapshots;

    public MyStringBuilder(String string) {
        stringBuilder = new StringBuilder(string);
        snapshots = new ArrayList<>();
        snapshots.add(stringBuilder.toString());
    }

    public MyStringBuilder append(String string) {
        stringBuilder.append(string);
        snapshots.add(stringBuilder.toString());
        return this;
    }

    public MyStringBuilder undo() {
        if (snapshots.size() > 1) {
            snapshots.remove(snapshots.size() - 1);
            stringBuilder = new StringBuilder(snapshots.get(snapshots.size() - 1));
        }
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}