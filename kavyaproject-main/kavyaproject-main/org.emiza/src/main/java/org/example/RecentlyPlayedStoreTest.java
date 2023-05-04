package org.example;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import java.util.Arrays;
import java.util.List;



public class RecentlyPlayedStoreTest {
        private RecentlyPlayedStore store;

        @BeforeMethod
        public void setUp() {
            store = new RecentlyPlayedStore(3, 3);
        }

        @Test
        public void testGetRecentlyPlayedEmpty() {
            List<String> result = store.getRecentlyPlayed("user1");
            Assert.assertEquals(result, Arrays.asList());
        }

        @Test
        public void testPlayAndGetRecentlyPlayed() {
            store.playSong("user1", "S1");
            store.playSong("user1", "S2");
            store.playSong("user1", "S3");

            List<String> result = store.getRecentlyPlayed("user1");
            Assert.assertEquals(result, Arrays.asList("S1", "S2", "S3"));

            store.playSong("user1", "S4");

            result = store.getRecentlyPlayed("user1");
            Assert.assertEquals(result, Arrays.asList("S2", "S3", "S4"));

            store.playSong("user1", "S2");

            result = store.getRecentlyPlayed("user1");
            Assert.assertEquals(result, Arrays.asList("S3", "S4", "S2"));

            store.playSong("user1", "S1");

            result = store.getRecentlyPlayed("user1");
            Assert.assertEquals(result, Arrays.asList("S4", "S2", "S1"));
        }

        @Test
        public void testPlayAndGetRecentlyPlayedMultipleUsers() {
            store.playSong("user1", "S1");
            store.playSong("user2", "S2");
            store.playSong("user1", "S3");

            List<String> result1 = store.getRecentlyPlayed("user1");
            Assert.assertEquals(result1, Arrays.asList("S1", "S3"));

            List<String> result2 = store.getRecentlyPlayed("user2");
            Assert.assertEquals(result2, Arrays.asList("S2"));
        }

        @Test
        public void testPlayMoreSongsThanCapacity() {
            store.playSong("user1", "S1");
            store.playSong("user1", "S2");
            store.playSong("user1", "S3");
            store.playSong("user1", "S4");
            store.playSong("user1", "S5");
        }
}
