import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlay implements LineListener{
    boolean playCompleted;

    /**
     * Play a given audio file.
     * @param audioFilePath Path of the audio file.
     */
    void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.addLineListener(this);

            audioClip.open(audioStream);

            audioClip.start();

            while (!playCompleted) {
                // wait for the playback completes
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            audioClip.close();

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
//        File initialFile = new File("C:\\Users\\shind\\Desktop\\github\\ds\\src\\main\\java\\BabyElephantWalk60.wav");
        AudioPlay player = new AudioPlay();
        player.play("C:\\Users\\shind\\Desktop\\github\\ds\\src\\main\\java\\BabyElephantWalk60.wav");
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        System.out.println(event.getLine().getLineInfo());
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");

        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
    }
}
