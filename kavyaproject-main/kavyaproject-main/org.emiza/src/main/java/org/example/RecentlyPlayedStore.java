package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RecentlyPlayedStore {

        private final int capacity;
        private final int numSongs;
        private final Map<String, List<String>> store;

        public RecentlyPlayedStore(int capacity, int numSongs) {
            this.capacity = capacity;
            this.numSongs = numSongs;
            this.store = new HashMap<>();
        }


       public void playSong(String user, String song) {
            List<String> playlist = store.computeIfAbsent(user, k -> new ArrayList<>());
            if (playlist.size() >= capacity) {
                playlist.remove(0);
            }
            playlist.add(song);
        }

        public List<String> getRecentlyPlayed(String user) {
            List<String> playlist = store.get(user);
            if (playlist == null) {
                return new ArrayList<>();
            }
            int startIndex = Math.max(0, playlist.size() - numSongs);
            return playlist.subList(startIndex, playlist.size());
        }
    }