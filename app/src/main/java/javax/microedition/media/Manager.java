package javax.microedition.media;

import java.io.InputStream;
import java.io.IOException;

public class Manager {
    public static Player createPlayer(InputStream stream, String type) throws IOException {
        return new Player() {
            public void realize() {
            }

            public void prefetch() {
            }

            public void start() {
            }

            public void stop() {
            }

            public void deallocate() {
            }

            public void close() {
            }

            public long setMediaTime(long now) {
                return 0;
            }

            public long getMediaTime() {
                return 0;
            }

            public int getState() {
                return 0;
            }

            public long getDuration() {
                return 0;
            }

            public void setLoopCount(int count) {
            }

            public void addPlayerListener(PlayerListener playerListener) {
            }

            public void removePlayerListener(PlayerListener playerListener) {
            }

            public Control getControl(String controlType) {
                if ("VolumeControl".equals(controlType)) {
                    return new javax.microedition.media.control.VolumeControl() {
                        public void setLevel(int level) {
                        }

                        public int getLevel() {
                            return 0;
                        }

                        public boolean isMuted() {
                            return false;
                        }

                        public void setMute(boolean mute) {
                        }
                    };
                }
                return null;
            }

            public Control[] getControls() {
                return null;
            }
        };
    }
}
