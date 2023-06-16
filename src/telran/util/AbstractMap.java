package telran.util;

import java.util.*;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    protected Set<Entry<K, V>> set;

    @Override
    public V get(K key) {
        Entry<K, V> entry = new Entry<>(key, null);
        return set.stream()
                .filter(e -> e.equals(entry))
                .findFirst()
                .map(Entry::getValue)
                .orElse(null);
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, null);
        Optional<Entry<K, V>> existingEntry = set.stream()
                .filter(e -> e.equals(entry))
                .findFirst();
        if (existingEntry.isPresent()) {
            V oldValue = existingEntry.get().getValue();
            existingEntry.get().setValue(value);
            return oldValue;
        } else {
            set.add(new Entry<>(key, value));
            return null;
        }
    }

    @Override
    public boolean containsKey(K key) {
        Entry<K, V> entry = new Entry<>(key, null);
        return set.contains(entry);
    }

    @Override
    public boolean containsValue(V value) {
        return set.stream()
                .anyMatch(e -> Objects.equals(e.getValue(), value));
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> entry : set) {
            keys.add(entry.getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : set) {
            values.add(entry.getValue());
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return set;
    }

    @Override
    public V remove(K key) {
        Iterator<Entry<K, V>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (Objects.equals(entry.getKey(), key)) {
                iterator.remove();
                return entry.getValue();
            }
        }
        return null;
    }
}

