// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee interface
interface AdvancedMediaPlayer {
    void playMP4(String fileName);
    void playMP3(String fileName);
}

// Concrete Adaptee
class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }

    @Override
    public void playMP3(String fileName) {
        // Do nothing
    }
}

// Concrete Adaptee
class MP3Player implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        // Do nothing
    }

    @Override
    public void playMP3(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("MP4")) {
            advancedMediaPlayer = new MP4Player();
        } else if (audioType.equalsIgnoreCase("MP3")) {
            advancedMediaPlayer = new MP3Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("MP4")) {
            advancedMediaPlayer.playMP4(fileName);
        } else if (audioType.equalsIgnoreCase("MP3")) {
            advancedMediaPlayer.playMP3(fileName);
        }
    }
}

// Concrete Target
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("MP3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("MP4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// Main class
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("MP3", "song.mp3");
        audioPlayer.play("MP4", "video.mp4");
        audioPlayer.play("AVI", "movie.avi");
    }
}
