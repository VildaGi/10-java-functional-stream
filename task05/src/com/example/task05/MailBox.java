package com.example.task05;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MailBox <T> implements Map<String, List<T>> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public List<T> get(Object key) {
        return List.of();
    }

    @Override
    public List<T> put(String key, List<T> value) {
        return List.of();
    }

    @Override
    public List<T> remove(Object key) {
        return List.of();
    }

    @Override
    public void putAll(Map<? extends String, ? extends List<T>> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return Set.of();
    }

    @Override
    public Collection<List<T>> values() {
        return List.of();
    }

    @Override
    public Set<Entry<String, List<T>>> entrySet() {
        return Set.of();
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
